/*
 * Decompiled with CFR 0.152.
 */
package best;

import best.I;
import best.Z;
import best.ah;
import best.aq;
import best.x;
import best.y;
import best.z;
import c.a;
import components.aD;
import est.ArrayLigaEType;
import est.ConfigEstadualType;
import est.LoadLigaOptions;
import f.o;
import f.s;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class w
implements Serializable {
    private static final long serialVersionUID = 1L;
    private int dr = -1;
    public ArrayList ds = new ArrayList();
    private ArrayList dt = new ArrayList();
    private static transient ArrayList du = new ArrayList();
    private static transient ArrayList dv = new ArrayList();
    private int dw = 0;
    public static Comparator dx = new x();

    public w() {
    }

    public w(int n2) {
        this.dr = n2;
        a.SR.aE().add(this);
        this.dY();
    }

    private void dY() {
        ArrayList<ah> arrayList = new ArrayList<ah>();
        int n2 = 0;
        while (n2 < a.SR.P().size()) {
            if (((ah)a.SR.P().get(n2)).getPais() == 29 && ((ah)a.SR.P().get(n2)).getEstado() == this.dr) {
                arrayList.add((ah)a.SR.P().get(n2));
            }
            ++n2;
        }
        Collections.sort(arrayList, h.a.cN);
        ConfigEstadualType configEstadualType = null;
        boolean bl2 = false;
        int n3 = arrayList.size();
        boolean bl3 = false;
        boolean bl4 = false;
        ArrayList<ah> arrayList2 = new ArrayList<ah>();
        int n4 = 1;
        while (n4 <= 4) {
            bl2 = false;
            bl3 = false;
            bl4 = false;
            if (arrayList.size() >= 6) {
                int n5;
                configEstadualType = w.g(this.dr, n4);
                LoadLigaOptions loadLigaOptions = new LoadLigaOptions();
                int n6 = 0;
                if (configEstadualType == null) {
                    bl2 = true;
                } else if (aq.sL[configEstadualType.getFormula()][0] > n3) {
                    bl2 = true;
                }
                if (!bl2) {
                    loadLigaOptions.nTimes = aq.sL[configEstadualType.getFormula()][0];
                    loadLigaOptions.nGrupos = aq.sL[configEstadualType.getFormula()][1];
                    loadLigaOptions.numeroTimesMataMata = aq.sL[configEstadualType.getFormula()][2];
                    loadLigaOptions.doisTurnos = aq.sL[configEstadualType.getFormula()][3] == 1;
                    loadLigaOptions.duasVoltasMataMata = configEstadualType.getFinaisIdaVoltaFormatado();
                    configEstadualType.getFormula();
                    n6 = aq.sL[configEstadualType.getFormula()][4];
                    loadLigaOptions.desempateEstadual = configEstadualType.getDesempate();
                    if (configEstadualType.getFormula() == 7 || configEstadualType.getFormula() == 10) {
                        loadLigaOptions.jogosDentroGrupo = false;
                    }
                    loadLigaOptions.var0 = configEstadualType.getFormula();
                } else {
                    loadLigaOptions.nTimes = 6;
                    loadLigaOptions.nGrupos = 0;
                    loadLigaOptions.numeroTimesMataMata = 2;
                    loadLigaOptions.doisTurnos = true;
                    n6 = 2;
                    loadLigaOptions.var0 = 0;
                }
                arrayList2.clear();
                ArrayList arrayList3 = new ArrayList();
                if (loadLigaOptions.var0 == 7 && n4 == 1 && this.dr == 25 && a.SR.isUsaGrupoPadraoEstadual()) {
                    arrayList3 = w.z(arrayList);
                }
                ArrayList arrayList4 = new ArrayList();
                if (loadLigaOptions.var0 == 7 && n4 == 1 && this.dr == 25 && arrayList3.size() == 16) {
                    n5 = 0;
                    while (n5 < arrayList3.size()) {
                        arrayList2.add((ah)arrayList3.get(n5));
                        ++n5;
                    }
                    bl4 = true;
                    arrayList3.clear();
                } else {
                    n5 = 0;
                    while (n5 < loadLigaOptions.nTimes) {
                        if (n5 < arrayList.size()) {
                            arrayList2.add((ah)arrayList.get(n5));
                        }
                        ++n5;
                    }
                }
                s s2 = null;
                o o2 = new o(this, this.ds.size() + 1);
                o2.setnRebaixados(n6);
                s2 = new s(loadLigaOptions, arrayList2, 0, null, null, null, 3, this, bl3, null, bl4, o2);
                this.ds.add(o2);
                o2.q(s2);
                int n7 = 0;
                while (n7 < arrayList2.size()) {
                    arrayList.remove(arrayList2.get(n7));
                    ++n7;
                }
            }
            ++n4;
        }
        n4 = 0;
        while (n4 < arrayList.size()) {
            this.dt.add((ah)arrayList.get(n4));
            ++n4;
        }
    }

    private static ArrayList z(ArrayList arrayList) {
        ArrayList<ah> arrayList2 = new ArrayList<ah>();
        int n2 = 0;
        while (n2 < aq.sO.length) {
            int n3 = 0;
            while (n3 < arrayList.size()) {
                if (((ah)arrayList.get(n3)).jY().equals(aq.sO[n2]) && ((ah)arrayList.get(n3)).getEstado() == 25) {
                    arrayList2.add((ah)arrayList.get(n3));
                }
                ++n3;
            }
            ++n2;
        }
        return arrayList2;
    }

    public static void dZ() {
        w.ef();
        int[] nArray = new int[27];
        int n2 = -1;
        int n3 = 0;
        while (n3 < a.SR.P().size()) {
            if (((ah)a.SR.P().get(n3)).getPais() == 29 && (n2 = ((ah)a.SR.P().get(n3)).getEstado()) >= 0 && n2 <= 26) {
                int n4 = n2;
                nArray[n4] = nArray[n4] + 1;
            }
            ++n3;
        }
        n3 = 0;
        while (n3 < nArray.length) {
            if (nArray[n3] >= 6) {
                new w(n3);
            }
            ++n3;
        }
    }

    public static void ds() {
        du.clear();
        File file = new File(String.valueOf(System.getProperty("user.dir")) + "/conf_estadual");
        File[] fileArray = file.listFiles(new y());
        int n2 = 0;
        while (n2 < fileArray.length) {
            if (fileArray[n2].isFile()) {
                try {
                    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
                    Document document = documentBuilder.parse(fileArray[n2].getPath());
                    Node node = document.getFirstChild();
                    NodeList nodeList = node.getChildNodes();
                    int n3 = 0;
                    while (n3 < nodeList.getLength()) {
                        Node node2 = nodeList.item(n3);
                        Element element = (Element)node2;
                        w.j(element.getTextContent());
                        ++n3;
                    }
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            ++n2;
        }
    }

    public static void j(String string) {
        String string2;
        String[] stringArray;
        if ((string = string.trim()) != null && !string.isEmpty() && (stringArray = (string2 = string).split(",")).length == 8) {
            int[] nArray = new int[stringArray.length];
            int n2 = 0;
            while (n2 < nArray.length) {
                nArray[n2] = Integer.parseInt(stringArray[n2]);
                ++n2;
            }
            dv.add(new ConfigEstadualType(nArray));
        }
    }

    public static ConfigEstadualType g(int n2, int n3) {
        int n4 = 0;
        while (n4 < dv.size()) {
            if (((ConfigEstadualType)dv.get(n4)).getId() == n2 && ((ConfigEstadualType)dv.get(n4)).getDivisao() == n3) {
                return (ConfigEstadualType)dv.get(n4);
            }
            ++n4;
        }
        return null;
    }

    public String ea() {
        return aq.rZ[this.dr];
    }

    public ArrayList eb() {
        return this.ds;
    }

    public int ec() {
        return this.dw;
    }

    public void ed() {
        ++this.dw;
    }

    public int getEstado() {
        return this.dr;
    }

    public void ee() {
        ArrayList<ah> arrayList = new ArrayList<ah>();
        ArrayList<ah> arrayList2 = new ArrayList<ah>();
        boolean bl2 = false;
        ((o)this.ds.get(0)).yi().ah(0, ((o)this.ds.get(0)).getnRebaixados());
        int n2 = 1;
        while (n2 < this.ds.size()) {
            ((o)this.ds.get(n2)).yi().ah(((o)this.ds.get(n2 - 1)).getnRebaixados(), ((o)this.ds.get(n2)).getnRebaixados());
            ++n2;
        }
        n2 = 0;
        while (n2 < this.ds.size()) {
            int n3;
            if (n2 + 1 < this.ds.size()) {
                arrayList2.clear();
                arrayList.clear();
                n3 = 0;
                while (n3 < ((o)this.ds.get(n2)).yi().yU().size()) {
                    arrayList2.add((ah)((o)this.ds.get(n2)).yi().yU().get(n3));
                    ++n3;
                }
                n3 = 0;
                while (n3 < ((o)this.ds.get(n2 + 1)).yi().yW().size()) {
                    arrayList.add((ah)((o)this.ds.get(n2 + 1)).yi().yW().get(n3));
                    ++n3;
                }
                if (arrayList2.size() == arrayList.size()) {
                    n3 = 0;
                    while (n3 < arrayList2.size()) {
                        ((o)this.ds.get(n2)).yi().yK().remove(arrayList2.get(n3));
                        ((o)this.ds.get(n2 + 1)).yi().yK().add((ah)arrayList2.get(n3));
                        ++n3;
                    }
                    n3 = 0;
                    while (n3 < arrayList.size()) {
                        ((o)this.ds.get(n2 + 1)).yi().yK().remove(arrayList.get(n3));
                        ((o)this.ds.get(n2)).yi().yK().add((ah)arrayList.get(n3));
                        ++n3;
                    }
                }
            } else {
                arrayList2.clear();
                arrayList.clear();
                n3 = ((o)this.ds.get(n2)).getnRebaixados();
                if (this.dt.size() < n3) {
                    n3 = this.dt.size();
                }
                if (n3 > 0) {
                    int n4 = 0;
                    while (n4 < ((o)this.ds.get(n2)).yi().yU().size()) {
                        if (n4 < n3) {
                            arrayList2.add((ah)((o)this.ds.get(n2)).yi().yU().get(n4));
                        }
                        ++n4;
                    }
                    n4 = 0;
                    while (n4 < n3) {
                        arrayList.add((ah)this.dt.get(n4));
                        ++n4;
                    }
                    if (arrayList2.size() == arrayList.size()) {
                        n4 = 0;
                        while (n4 < arrayList2.size()) {
                            ((o)this.ds.get(n2)).yi().yK().remove(arrayList2.get(n4));
                            this.dt.add((ah)arrayList2.get(n4));
                            ++n4;
                        }
                        n4 = 0;
                        while (n4 < arrayList.size()) {
                            this.dt.remove(arrayList.get(n4));
                            ((o)this.ds.get(n2)).yi().yK().add((ah)arrayList.get(n4));
                            ++n4;
                        }
                    }
                }
            }
            ++n2;
        }
    }

    public static void P(int n2) {
        ArrayLigaEType arrayLigaEType = new ArrayLigaEType();
        int n3 = 0;
        while (n3 < dv.size()) {
            if (((ConfigEstadualType)dv.get(n3)).getId() == n2) {
                arrayLigaEType.a.add((ConfigEstadualType)dv.get(n3));
            }
            ++n3;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(String.valueOf(System.getProperty("user.dir")) + "/conf_estadual/" + aq.rX[n2] + ".ces");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(arrayLigaEType);
            objectOutputStream.close();
            fileOutputStream.close();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public static void ef() {
        dv.clear();
        File file = new File(String.valueOf(System.getProperty("user.dir")) + "/conf_estadual");
        File[] fileArray = file.listFiles(new z());
        int n2 = 0;
        while (n2 < fileArray.length) {
            if (fileArray[n2].isFile()) {
                ArrayLigaEType arrayLigaEType = new ArrayLigaEType();
                try {
                    FileInputStream fileInputStream = new FileInputStream(fileArray[n2].getPath());
                    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                    arrayLigaEType = (ArrayLigaEType)objectInputStream.readObject();
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
                w.a(arrayLigaEType);
            }
            ++n2;
        }
    }

    public static void a(ArrayLigaEType arrayLigaEType) {
        int n2 = 0;
        while (n2 < arrayLigaEType.a.size()) {
            dv.add((ConfigEstadualType)arrayLigaEType.a.get(n2));
            ++n2;
        }
    }

    public static ArrayList eg() {
        return dv;
    }

    public static ArrayList eh() {
        int n2 = 128;
        ArrayList arrayList = new ArrayList();
        Collections.sort(a.SR.bx(), dx);
        int n3 = 0;
        w.a(aq.sb, arrayList);
        w.a(aq.sc, arrayList);
        w.a(aq.sd, arrayList);
        w.a(aq.se, arrayList);
        w.a(aq.sf, arrayList);
        w.a(aq.sb, arrayList);
        w.a(aq.sc, arrayList);
        w.a(aq.sd, arrayList);
        w.a(aq.sb, arrayList);
        w.a(aq.sc, arrayList);
        w.a(aq.sd, arrayList);
        w.a(aq.sb, arrayList);
        w.a(aq.sc, arrayList);
        w.a(aq.sd, arrayList);
        n3 = arrayList.size();
        if (n3 < n2) {
            w.a(aq.se, arrayList);
            w.a(aq.sf, arrayList);
            w.a(aq.sb, arrayList);
            w.a(aq.sc, arrayList);
            w.a(aq.sd, arrayList);
        }
        if (n3 < n2) {
            w.a(aq.se, arrayList);
            w.a(aq.sf, arrayList);
            w.a(aq.sb, arrayList);
            w.a(aq.sc, arrayList);
            w.a(aq.sd, arrayList);
            w.a(aq.se, arrayList);
            w.a(aq.sf, arrayList);
            w.a(aq.sb, arrayList);
            w.a(aq.sc, arrayList);
            w.a(aq.sd, arrayList);
            w.a(aq.se, arrayList);
            w.a(aq.sf, arrayList);
            w.a(aq.sb, arrayList);
            w.a(aq.sc, arrayList);
            w.a(aq.sd, arrayList);
        }
        return arrayList;
    }

    public static void a(int[] nArray, ArrayList arrayList) {
        int n2 = 0;
        while (n2 < nArray.length) {
            int n3 = 0;
            while (n3 < a.SR.bx().size()) {
                if (((aD)a.SR.bx().get(n3)).getEstado() == nArray[n2] && !arrayList.contains(((aD)a.SR.bx().get(n3)).vD())) {
                    arrayList.add(((aD)a.SR.bx().get(n3)).vD());
                    break;
                }
                ++n3;
            }
            ++n2;
        }
    }

    public static ArrayList Q(int n2) {
        int n3;
        Serializable serializable;
        int n4;
        ArrayList<ah> arrayList = new ArrayList<ah>();
        Collections.sort(a.SR.bx(), dx);
        ArrayList<ah> arrayList2 = new ArrayList<ah>();
        if (a.SR.bY().size() > 0) {
            n4 = 0;
            while (n4 < a.SR.bY().size()) {
                if (((ah)a.SR.bY().get(n4)).getDivisao() == 0 && !((ah)a.SR.bY().get(n4)).ko()) {
                    arrayList.add((ah)a.SR.bY().get(n4));
                    arrayList2.add((ah)a.SR.bY().get(n4));
                }
                ++n4;
            }
        }
        n4 = 0;
        w.a(aq.sb, arrayList);
        w.a(aq.sc, arrayList);
        w.a(aq.sd, arrayList);
        w.a(aq.se, arrayList);
        w.a(aq.sf, arrayList);
        w.a(aq.sb, arrayList);
        w.a(aq.sb, arrayList);
        w.a(aq.sb, arrayList);
        w.a(aq.sc, arrayList);
        w.a(aq.sc, arrayList);
        w.a(aq.sd, arrayList);
        w.a(aq.se, arrayList);
        w.a(aq.sb, arrayList);
        w.a(aq.sb, arrayList);
        w.a(aq.sb, arrayList);
        w.a(aq.sc, arrayList);
        w.a(aq.sc, arrayList);
        w.a(aq.sd, arrayList);
        w.a(aq.se, arrayList);
        n4 = arrayList.size();
        if (n4 < n2 && (serializable = a.SR.o(29)) != null) {
            n3 = 0;
            while (n3 < ((Z)serializable).jg().size()) {
                if (n4 < n2 && ((ah)((Z)serializable).jg().get(n3)).getDivisao() == 0 && !arrayList.contains(((Z)serializable).jg().get(n3))) {
                    arrayList.add((ah)((Z)serializable).jg().get(n3));
                    ++n4;
                }
                ++n3;
            }
        }
        if (arrayList.size() > n2) {
            serializable = new ArrayList();
            ((ArrayList)serializable).addAll(arrayList);
            arrayList.clear();
            n3 = 0;
            while (n3 < n2) {
                arrayList.add((ah)((ArrayList)serializable).get(n3));
                ++n3;
            }
        }
        if (n2 == 68) {
            arrayList.removeAll(arrayList2);
            Collections.sort(arrayList, h.a.aaU);
            int n5 = 0;
            while (n5 < arrayList2.size()) {
                arrayList.add(n5, (ah)arrayList2.get(n5));
                ++n5;
            }
        } else if (n2 == 64) {
            Collections.sort(arrayList, h.a.aaV);
        }
        return arrayList;
    }

    public void A(ArrayList arrayList) {
        int n2 = 0;
        while (n2 < this.ds.size()) {
            ((o)this.ds.get(n2)).yi().A(arrayList);
            ++n2;
        }
    }

    public boolean ei() {
        int n2 = 0;
        while (n2 < this.ds.size()) {
            int n3 = 0;
            while (n3 < ((o)this.ds.get(n2)).yi().yK().size()) {
                if (((ah)((o)this.ds.get(n2)).yi().yK().get(n3)).jZ().booleanValue()) {
                    return true;
                }
                ++n3;
            }
            ++n2;
        }
        return false;
    }

    public boolean j(ah ah2) {
        int n2 = 0;
        while (n2 < this.ds.size()) {
            int n3 = 0;
            while (n3 < ((o)this.ds.get(n2)).yi().yK().size()) {
                if (((o)this.ds.get(n2)).yi().yK().get(n3) == ah2) {
                    return true;
                }
                ++n3;
            }
            ++n2;
        }
        return false;
    }

    public boolean ej() {
        int n2 = 0;
        while (n2 < a.SR.S().size()) {
            if (this.ds.contains(((I)a.SR.S().get(n2)).hy())) {
                return true;
            }
            ++n2;
        }
        return false;
    }

    public ArrayList ek() {
        return this.dt;
    }

    public int K(int n2) {
        int n3 = n2 - 2;
        if (n2 > 1 && n3 < this.ds.size()) {
            return ((o)this.ds.get(n3)).getnRebaixados();
        }
        return 0;
    }
}

