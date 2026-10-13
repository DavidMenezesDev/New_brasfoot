using System.Buffers.Binary;
using System.Text;

namespace Brasfoot.Data.JavaSerialization;

/// <summary>Um objeto lido de um stream <c>ObjectOutputStream</c>.</summary>
public sealed class JavaObject(JavaClassDesc classDesc)
{
    public JavaClassDesc ClassDesc { get; } = classDesc;
    public string ClassName => ClassDesc.Name;

    /// <summary>Campos de toda a hierarquia; em caso de nome repetido vale o da subclasse.</summary>
    public Dictionary<string, object?> Fields { get; } = new();

    /// <summary>Objetos gravados por <c>writeObject</c> customizado (ex.: elementos de ArrayList).</summary>
    public List<object?> Annotations { get; } = new();

    public T Get<T>(string field) => (T)Fields[field]!;
    public T? GetOrDefault<T>(string field) => Fields.TryGetValue(field, out var v) && v is T t ? t : default;
}

public sealed record JavaField(char TypeCode, string Name, string? ClassName);

public sealed class JavaClassDesc(string name, long serialVersionUid, byte flags, IReadOnlyList<JavaField> fields)
{
    public string Name { get; } = name;
    public long SerialVersionUid { get; } = serialVersionUid;
    public byte Flags { get; } = flags;
    public IReadOnlyList<JavaField> Fields { get; } = fields;
    public JavaClassDesc? Super { get; internal set; }
    public bool IsEnum { get; internal set; }

    internal bool HasWriteMethod => (Flags & 0x01) != 0;
    internal bool IsExternalizable => (Flags & 0x04) != 0;
}

public sealed record JavaEnum(string ClassName, string Constant);

/// <summary>
/// Leitor do "Java Object Serialization Stream Protocol" (versão 2). Suporta o
/// necessário para os arquivos de dados do jogo: objetos, strings, arrays,
/// enums, referências e writeObject customizado.
/// </summary>
public sealed class JavaObjectReader
{
    private const ushort StreamMagic = 0xACED;
    private const int BaseHandle = 0x7E0000;

    private const byte TcNull = 0x70, TcReference = 0x71, TcClassDesc = 0x72, TcObject = 0x73,
        TcString = 0x74, TcArray = 0x75, TcClass = 0x76, TcBlockData = 0x77, TcEndBlockData = 0x78,
        TcReset = 0x79, TcBlockDataLong = 0x7A, TcLongString = 0x7C, TcProxyClassDesc = 0x7D, TcEnum = 0x7E;

    private readonly BinaryReader _in;
    private readonly List<object?> _handles = new();

    private JavaObjectReader(Stream stream) => _in = new BinaryReader(stream, Encoding.UTF8, leaveOpen: true);

    public static object? ReadSingle(Stream stream)
    {
        var reader = new JavaObjectReader(stream);
        if (reader.ReadU16() != StreamMagic) throw new InvalidDataException("Não é um stream de serialização Java.");
        reader.ReadU16(); // versão
        return reader.ReadContent();
    }

    public static object? ReadSingle(string path)
    {
        using var fs = File.OpenRead(path);
        return ReadSingle(fs);
    }

    private object? ReadContent()
    {
        var tc = _in.ReadByte();
        switch (tc)
        {
            case TcNull: return null;
            case TcReference: return _handles[ReadI32() - BaseHandle];
            case TcObject: return ReadNewObject();
            case TcString: return NewHandle(ReadUtf(ReadU16()));
            case TcLongString: return NewHandle(ReadUtf(checked((int)ReadI64())));
            case TcArray: return ReadNewArray();
            case TcEnum: return ReadNewEnum();
            case TcClassDesc: return ReadNewClassDesc();
            case TcClass:
                var cls = ReadClassDesc();
                return NewHandle(cls);
            case TcBlockData: return _in.ReadBytes(_in.ReadByte());
            case TcBlockDataLong: return _in.ReadBytes(ReadI32());
            case TcReset:
                _handles.Clear();
                return ReadContent();
            default: throw new InvalidDataException($"Typecode inesperado 0x{tc:X2} na posição {_in.BaseStream.Position - 1}.");
        }
    }

    private T NewHandle<T>(T value)
    {
        _handles.Add(value);
        return value;
    }

    private JavaClassDesc? ReadClassDesc()
    {
        var tc = _in.ReadByte();
        return tc switch
        {
            TcNull => null,
            TcReference => (JavaClassDesc)_handles[ReadI32() - BaseHandle]!,
            TcClassDesc => ReadNewClassDescBody(),
            TcProxyClassDesc => throw new NotSupportedException("Proxy classes não são suportadas."),
            _ => throw new InvalidDataException($"Esperado classDesc, encontrado 0x{tc:X2}."),
        };
    }

    private JavaClassDesc ReadNewClassDesc() => ReadNewClassDescBody();

    private JavaClassDesc ReadNewClassDescBody()
    {
        var name = ReadUtf(ReadU16());
        var suid = ReadI64();
        var handleIndex = _handles.Count;
        _handles.Add(null); // reservado: o handle é atribuído antes dos campos
        var flags = _in.ReadByte();
        var count = ReadU16();
        var fields = new List<JavaField>(count);
        for (var i = 0; i < count; i++)
        {
            var type = (char)_in.ReadByte();
            var fieldName = ReadUtf(ReadU16());
            string? className = null;
            if (type is 'L' or '[') className = (string)ReadContent()!;
            fields.Add(new JavaField(type, fieldName, className));
        }
        var desc = new JavaClassDesc(name, suid, flags, fields);
        _handles[handleIndex] = desc;
        SkipAnnotations();
        desc.Super = ReadClassDesc();
        return desc;
    }

    private void SkipAnnotations()
    {
        while (true)
        {
            var next = PeekByte();
            if (next == TcEndBlockData)
            {
                _in.ReadByte();
                return;
            }
            ReadContent();
        }
    }

    private JavaObject ReadNewObject()
    {
        var desc = ReadClassDesc() ?? throw new InvalidDataException("Objeto sem classDesc.");
        var obj = NewHandle(new JavaObject(desc));
        if (desc.IsExternalizable) throw new NotSupportedException($"Externalizable não suportado: {desc.Name}");

        var chain = new List<JavaClassDesc>();
        for (var c = desc; c != null; c = c.Super) chain.Add(c);
        chain.Reverse(); // superclasse primeiro, como no stream

        foreach (var cls in chain)
        {
            foreach (var field in cls.Fields)
                obj.Fields[field.Name] = ReadFieldValue(field.TypeCode);
            if (cls.HasWriteMethod) ReadAnnotationsInto(obj);
        }
        return obj;
    }

    private void ReadAnnotationsInto(JavaObject obj)
    {
        while (true)
        {
            if (PeekByte() == TcEndBlockData)
            {
                _in.ReadByte();
                return;
            }
            var content = ReadContent();
            if (content is not byte[]) obj.Annotations.Add(content); // blockdata = primitivos (ex.: capacidade)
        }
    }

    private object? ReadFieldValue(char type) => type switch
    {
        'B' => (sbyte)_in.ReadByte(),
        'C' => (char)ReadU16(),
        'D' => BitConverter.Int64BitsToDouble(ReadI64()),
        'F' => BitConverter.Int32BitsToSingle(ReadI32()),
        'I' => ReadI32(),
        'J' => ReadI64(),
        'S' => (short)ReadU16(),
        'Z' => _in.ReadByte() != 0,
        'L' or '[' => ReadContent(),
        _ => throw new InvalidDataException($"Tipo de campo desconhecido '{type}'."),
    };

    private object ReadNewArray()
    {
        var desc = ReadClassDesc() ?? throw new InvalidDataException("Array sem classDesc.");
        var length = ReadI32();
        var elementType = desc.Name[1];
        var handle = _handles.Count;
        _handles.Add(null);
        var items = new object?[length];
        for (var i = 0; i < length; i++) items[i] = ReadFieldValue(elementType);
        _handles[handle] = items;
        return items;
    }

    private JavaEnum ReadNewEnum()
    {
        var desc = ReadClassDesc() ?? throw new InvalidDataException("Enum sem classDesc.");
        var handle = _handles.Count;
        _handles.Add(null);
        var constant = (string)ReadContent()!;
        var value = new JavaEnum(desc.Name, constant);
        _handles[handle] = value;
        return value;
    }

    private int PeekByte()
    {
        var b = _in.ReadByte();
        _in.BaseStream.Seek(-1, SeekOrigin.Current);
        return b;
    }

    private ushort ReadU16() => BinaryPrimitives.ReadUInt16BigEndian(_in.ReadBytes(2));
    private int ReadI32() => BinaryPrimitives.ReadInt32BigEndian(_in.ReadBytes(4));
    private long ReadI64() => BinaryPrimitives.ReadInt64BigEndian(_in.ReadBytes(8));

    /// <summary>Lê "modified UTF-8" (o formato de DataOutput.writeUTF).</summary>
    private string ReadUtf(int length)
    {
        var bytes = _in.ReadBytes(length);
        var sb = new StringBuilder(length);
        for (var i = 0; i < bytes.Length; i++)
        {
            int b = bytes[i];
            if (b < 0x80) sb.Append((char)b);
            else if ((b & 0xE0) == 0xC0) sb.Append((char)(((b & 0x1F) << 6) | (bytes[++i] & 0x3F)));
            else sb.Append((char)(((b & 0x0F) << 12) | ((bytes[++i] & 0x3F) << 6) | (bytes[++i] & 0x3F)));
        }
        return sb.ToString();
    }
}
