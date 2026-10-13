/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.esotericsoftware.kryo.Kryo
 *  com.esotericsoftware.kryo.io.Input
 *  com.esotericsoftware.kryo.io.Output
 */
package c;

import best.M;
import best.S;
import best.ay;
import best.f;
import best.n;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import est.InfoArquivoSalvoType;
import est.Options;
import g.b;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.JOptionPane;

public class a {
    static PrintWriter SQ;
    public static f SR;
    public static ay afQ;
    private static Options SS;
    private static int ST;
    public static int SU;
    private static final File[] SV;

    static {
        SR = null;
        afQ = null;
        SS = null;
        ST = 0;
        SU = 64;
        SV = new File[7];
    }

    public a() {
        a.vI();
        if (SS == null) {
            SS = new Options();
        }
        SR = new f();
        afQ = new ay();
    }

    public static void vH() {
        String[] stringArray = new String[]{"intervalo", "fimjogo", "gol1", "goladv", "penalty", "expulsao", "contusao"};
        int n2 = 0;
        while (n2 < stringArray.length) {
            File file = new File(String.valueOf(System.getProperty("user.dir")) + "/sons/" + stringArray[n2] + ".wav");
            if (file.exists() && !file.isDirectory()) {
                a.SV[n2] = file;
            }
            ++n2;
        }
    }

    public static File dj(int n2) {
        String[] stringArray = new String[]{"intervalo", "fimjogo", "gol1", "goladv", "penalty", "expulsao", "contusao"};
        if (SV[n2] == null) {
            File file = new File(String.valueOf(System.getProperty("user.dir")) + "/sons/" + stringArray[n2] + ".wav");
            if (file.exists() && !file.isDirectory()) {
                a.SV[n2] = file;
                return file;
            }
        } else {
            return SV[n2];
        }
        return SV[n2];
    }

    public static void ad(String string) {
        b.Ag();
        b.Ai();
        if (string != null) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(String.valueOf(System.getProperty("user.dir")) + "/sav/" + string + ".info");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(SR.bs());
                objectOutputStream.flush();
                objectOutputStream.close();
                fileOutputStream.close();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }

    public static void ae(String string) {
        if (string != null) {
            Object object;
            Object object2;
            Object object3;
            boolean bl2 = false;
            b.Ag();
            b.Ai();
            try {
                object3 = new FileOutputStream(String.valueOf(System.getProperty("user.dir")) + "/sav/" + string + ".info");
                object2 = new ObjectOutputStream((OutputStream)object3);
                ((ObjectOutputStream)object2).writeObject(SR.bs());
                ((ObjectOutputStream)object2).flush();
                ((ObjectOutputStream)object2).close();
                ((FileOutputStream)object3).close();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
            try {
                object3 = new Kryo();
                object3.setRegistrationRequired(false);
                object2 = new FileOutputStream(String.valueOf(System.getProperty("user.dir")) + "/sav/" + string + ".s22");
                object = new Output((OutputStream)object2);
                object3.writeClassAndObject(object, (Object)SR);
                object3.writeClassAndObject(object, (Object)afQ);
                object.close();
                bl2 = true;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
            if (bl2) {
                object3 = String.valueOf(System.getProperty("user.dir")) + "/sav/" + string + ".s22";
                object2 = Paths.get((String)object3, new String[0]);
                object = String.valueOf(System.getProperty("user.dir")) + "/sav/" + string + ".sbck";
                Path path = Paths.get((String)object, new String[0]);
                File file = new File(String.valueOf(System.getProperty("user.dir")) + "/sav/" + string + ".s22");
                boolean bl3 = file.exists();
                if (bl3) {
                    try {
                        Files.copy((Path)object2, path, StandardCopyOption.REPLACE_EXISTING);
                    }
                    catch (IOException iOException) {
                        iOException.printStackTrace();
                    }
                }
            }
        }
    }

    public static boolean c(String string, boolean bl2) {
        a.vI();
        if (SS == null) {
            SS = new Options();
        }
        String string2 = ".s22";
        if (bl2) {
            string2 = ".sbck";
        }
        Kryo kryo = new Kryo();
        if (string != null) {
            try {
                Input input = new Input((InputStream)new FileInputStream(String.valueOf(System.getProperty("user.dir")) + "/sav/" + string + string2));
                kryo.setRegistrationRequired(false);
                SR = (f)kryo.readClassAndObject(input);
                afQ = (ay)kryo.readClassAndObject(input);
                input.close();
            }
            catch (Exception exception) {
                exception.printStackTrace();
                if (!bl2) {
                    a.c(string, true);
                } else {
                    a.vK();
                }
                return false;
            }
        }
        if (n.db() == null) {
            b.Ah();
            b.Af();
            b.Aj();
            a.SR.bs = true;
            SR.G();
            new M(false);
            SR.i(true);
            new S(false);
            SR.cb();
            SR.ap();
            if (n.dc() != null) {
                n.dc().dispose();
            }
        }
        return true;
    }

    public static void vI() {
        File file = new File(String.valueOf(System.getProperty("user.dir")) + "/options.bcf");
        if (file.exists() && !file.isDirectory()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(String.valueOf(System.getProperty("user.dir")) + "/options.bcf");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                SS = (Options)objectInputStream.readObject();
                objectInputStream.close();
                fileInputStream.close();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
                return;
            }
            catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
                return;
            }
        } else {
            SS = new Options();
        }
    }

    public static void vJ() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(String.valueOf(System.getProperty("user.dir")) + "/options.bcf");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(SS);
            objectOutputStream.close();
            fileOutputStream.close();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public static InfoArquivoSalvoType af(String string) {
        InfoArquivoSalvoType infoArquivoSalvoType = null;
        if (string != null) {
            try {
                FileInputStream fileInputStream = new FileInputStream(String.valueOf(System.getProperty("user.dir")) + "/sav/" + string + ".info");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                infoArquivoSalvoType = (InfoArquivoSalvoType)objectInputStream.readObject();
                objectInputStream.close();
                fileInputStream.close();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
                return infoArquivoSalvoType;
            }
            catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
                return infoArquivoSalvoType;
            }
        }
        return infoArquivoSalvoType;
    }

    public static InfoArquivoSalvoType ag(String string) {
        InfoArquivoSalvoType infoArquivoSalvoType = null;
        if (string != null) {
            try {
                FileInputStream fileInputStream = new FileInputStream(String.valueOf(System.getProperty("user.dir")) + "/sav/" + string + ".sb19");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                infoArquivoSalvoType = (InfoArquivoSalvoType)objectInputStream.readObject();
                objectInputStream.close();
                fileInputStream.close();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
                return infoArquivoSalvoType;
            }
            catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
                return infoArquivoSalvoType;
            }
        }
        return infoArquivoSalvoType;
    }

    public static void vK() {
        JOptionPane.showMessageDialog(null, "Arquivo inv\u00e1lido: save corrompido ou \u00e9 de uma vers\u00e3o/build anterior.", "Arquivo inv\u00e1lido", 0);
    }

    public static boolean vL() {
        return ST >= 1920;
    }

    public static Options vM() {
        if (SS == null) {
            SS = new Options();
        }
        return SS;
    }

    public static void ey(int n2) {
        ST = n2;
    }

    public static void a(f f2) {
        SR = f2;
    }
}

