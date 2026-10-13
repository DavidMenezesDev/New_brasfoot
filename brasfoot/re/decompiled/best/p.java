/*
 * Decompiled with CFR 0.152.
 */
package best;

import best.F;
import best.M;
import best.O;
import best.U;
import best.Z;
import best.a;
import best.ac;
import best.ah;
import best.al;
import best.aq;
import best.q;
import best.r;
import components.aD;
import est.ArrayLigaType;
import est.ConfigLigaType;
import f.B;
import f.H;
import f.J;
import f.t;
import f.u;
import f.v;
import f.w;
import f.x;
import f.y;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public abstract class p {
    private static boolean cM = false;
    public static Comparator cN = new q();
    private static int cO = 0;

    public static void dd() {
        if (c.a.SR.aG().size() == 0) {
            p.de();
        }
        c.a.SR.bC = new ArrayList();
        c.a.SR.bD = new int[ac.jz()];
        c.a.SR.bE = new int[aq.rX.length];
        U.w(false);
        Collections.sort(c.a.SR.bC, cN);
        c.a.SR.bF = new ArrayList();
        int n2 = 10;
        int n3 = 0;
        while (n3 < c.a.SR.bD.length) {
            n2 = n3 == 3 || n3 == 11 || n3 == 97 || n3 == 104 || n3 == 72 ? 16 : 10;
            if (c.a.SR.bD[n3] >= n2) {
                O o2 = new O();
                o2.setPais(n3);
                o2.aX(c.a.SR.bD[n3]);
                o2.v(false);
                c.a.SR.bF.add(o2);
            }
            ++n3;
        }
        c.a.SR.bG = new ArrayList();
        p.ds();
    }

    public static void de() {
        c.a.SR.aG().clear();
        int n2 = 0;
        while (n2 < ac.jz()) {
            Z z2 = new Z(n2);
            c.a.SR.aG().add(z2);
            ++n2;
        }
    }

    public static void w(ArrayList arrayList) {
        int n2 = 0;
        while (n2 < arrayList.size()) {
            if (((O)arrayList.get(n2)).iC()) {
                Z z2 = (Z)c.a.SR.aG().get(((O)arrayList.get(n2)).getPais());
                z2.Ar();
                c.a.SR.a(z2);
            }
            ++n2;
        }
    }

    public static void df() {
        int n2 = 0;
        while (n2 < c.a.SR.N().size()) {
            if (((Z)c.a.SR.N().get(n2)).jc() == 29) {
                ((Z)c.a.SR.N().get(n2)).ja();
            }
            ++n2;
        }
    }

    public static void x(ArrayList arrayList) {
        int n2 = 15;
        Integer n3 = -1;
        boolean bl2 = false;
        int[] nArray = new int[ac.jz()];
        int n4 = 0;
        while (n4 < c.a.SR.bC.size()) {
            n3 = ((e.t)c.a.SR.bC.get(n4)).getPais();
            if (n3 != null) {
                bl2 = c.a.SR.t(n3);
                if (nArray[((e.t)c.a.SR.bC.get(n4)).getPais()] < n2 || bl2) {
                    new ah((e.t)c.a.SR.bC.get(n4));
                    int n5 = ((e.t)c.a.SR.bC.get(n4)).getPais();
                    nArray[n5] = nArray[n5] + 1;
                }
            }
            ++n4;
        }
    }

    public static void dg() {
        p.x(c.a.SR.bF);
        int n2 = 0;
        while (n2 < ac.jz()) {
            Z z2 = (Z)c.a.SR.aG().get(n2);
            z2.iT();
            ++n2;
        }
        c.a.SR.cb();
        c.a.SR.r(c.a.SR.op());
        a.g();
        a.u();
        p.w(c.a.SR.bF);
        if ((c.a.SR.bk() || c.a.SR.X()) && (n2 = a.e(1)) > 0) {
            a.b(n2, 4, 1);
        }
        a.q();
        new M(false);
        p.dj();
        n2 = 0;
        while (n2 < c.a.SR.O().size()) {
            ((F)c.a.SR.O().get(n2)).fh();
            ++n2;
        }
        n2 = 0;
        while (n2 < c.a.SR.Q().size()) {
            ((F)c.a.SR.Q().get(n2)).fh();
            ++n2;
        }
        n2 = 0;
        while (n2 < c.a.SR.L().size()) {
            ((al)c.a.SR.L().get(n2)).fh();
            ++n2;
        }
        c.a.SR.aU();
        c.a.SR.c(false);
        if (c.a.SR.op() == 2023) {
            c.a.SR.rU();
        }
        c.a.afQ.zj();
        if (c.a.SR.isJogaSelecoesAll()) {
            c.a.SR.ab();
            c.a.SR.ac();
        }
        if (c.a.SR.isJogaIntClubes()) {
            p.dm();
            p.dr();
            p.dq();
            p.dk();
            p.dn();
            p.dl();
            n2 = a.d(4);
            if (n2 > 0) {
                a.b(n2, 1, 0);
            }
            p.do();
            p.dp();
            p.yM();
        }
        if (!c.a.SR.bk() && !c.a.SR.isJogaRegionais()) {
            p.df();
        }
        Collections.sort(c.a.SR.P(), h.a.VS);
    }

    public static void dh() {
        boolean bl2 = false;
        int[] nArray = new int[4];
        String[] stringArray = new String[]{"AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO"};
        Integer[][] integerArrayArray = new Integer[][]{{18, 25}, {10, 17, 22, 23}, {1, 4, 5, 9, 14, 15, 16, 19, 24}, {0, 2, 3, 6, 7, 8, 11, 12, 13, 20, 21, 26}};
        int n2 = 0;
        while (n2 < c.a.SR.P().size()) {
            if (((ah)c.a.SR.P().get(n2)).getPais() == 29) {
                int n3 = ((ah)c.a.SR.P().get(n2)).getEstado();
                if (Arrays.asList(integerArrayArray[0]).contains(n3)) {
                    nArray[0] = nArray[0] + 1;
                } else if (Arrays.asList(integerArrayArray[1]).contains(n3)) {
                    nArray[1] = nArray[1] + 1;
                } else if (Arrays.asList(integerArrayArray[2]).contains(n3)) {
                    nArray[2] = nArray[2] + 1;
                } else if (Arrays.asList(integerArrayArray[3]).contains(n3)) {
                    nArray[3] = nArray[3] + 1;
                }
            }
            ++n2;
        }
        ArrayList arrayList = new ArrayList();
        arrayList = p.di();
        boolean[] blArray = c.a.SR.getJogaRegionaisTodos();
        int n4 = 0;
        while (n4 < 4) {
            if (blArray[n4] && nArray[n4] >= 16) {
                c.a.SR.a(new f.F(n4, arrayList), n4);
                bl2 = true;
            }
            ++n4;
        }
        c.a.SR.setJogaRegionais(bl2);
    }

    public static ArrayList di() {
        ArrayList<ah> arrayList = new ArrayList<ah>();
        ArrayList<ah> arrayList2 = new ArrayList<ah>();
        Z z2 = c.a.SR.o(29);
        if (z2 != null) {
            if (c.a.vM().isConviteRegionais() && c.a.SR.aN().size() == 1 && ((ah)c.a.SR.aN().get(0)).getPais() == 29) {
                arrayList.add((ah)c.a.SR.aN().get(0));
            }
            int n2 = 0;
            while (n2 < z2.eb().size()) {
                int n3 = 0;
                while (n3 < ((B)z2.eb().get(n2)).yi().yK().size()) {
                    if (!arrayList.contains(((B)z2.eb().get(n2)).yi().yK().get(n3))) {
                        arrayList.add((ah)((B)z2.eb().get(n2)).yi().yK().get(n3));
                    }
                    ++n3;
                }
                ++n2;
            }
            if (c.a.SR.H() > 1 && c.a.SR.bx().size() > 0 && c.a.SR.bk() && z2.eb().size() == 4) {
                n2 = 0;
                while (n2 < c.a.SR.bx().size()) {
                    if (!arrayList.contains(arrayList.add(((aD)c.a.SR.bx().get(n2)).vD()))) {
                        arrayList.add(((aD)c.a.SR.bx().get(n2)).vD());
                    }
                    ++n2;
                }
            }
            n2 = 0;
            while (n2 < c.a.SR.P().size()) {
                if (((ah)c.a.SR.P().get(n2)).getPais() == 29 && !arrayList.contains(c.a.SR.P().get(n2)) && !arrayList2.contains(c.a.SR.P().get(n2))) {
                    arrayList2.add((ah)c.a.SR.P().get(n2));
                }
                ++n2;
            }
            Collections.shuffle(arrayList2);
            arrayList.addAll(arrayList2);
        }
        return arrayList;
    }

    private static void dj() {
        int n2 = 0;
        while (n2 < c.a.SR.P().size()) {
            ((ah)c.a.SR.P().get(n2)).bX(n2);
            ++n2;
        }
        c.a.SR.w(c.a.SR.P().size());
    }

    private static void dk() {
        c.a.SR.a(new u());
        c.a.SR.aL().yq();
    }

    private static void dl() {
        c.a.SR.a(new y());
        c.a.SR.aQ().yq();
    }

    private static void dm() {
        c.a.SR.a(new w());
        c.a.SR.aP().yq();
    }

    private static void dn() {
        c.a.SR.a(new t());
        c.a.SR.aO().yq();
    }

    private static void do() {
        c.a.SR.a(new H());
        c.a.SR.aH().yq();
    }

    private static void dp() {
        c.a.SR.a(new x());
        c.a.SR.aK().yq();
    }

    private static void yM() {
        c.a.SR.a(new J());
        c.a.SR.mj().yq();
        c.a.SR.mj().setNome("Conference League");
    }

    private static void dq() {
        c.a.SR.a(new v());
        c.a.SR.aI().setNome(M.getString("ligaC"));
        c.a.SR.aI().yq();
    }

    private static void dr() {
        c.a.SR.a(new f.r());
        c.a.SR.aF().setNome(M.getString("lib"));
        c.a.SR.aF().yq();
    }

    public static void ds() {
        c.a.SR.bG.clear();
        File file = new File(String.valueOf(System.getProperty("user.dir")) + "/conf_ligas_nacionais");
        File[] fileArray = file.listFiles(new r());
        if (fileArray != null) {
            int n2 = 0;
            while (n2 < fileArray.length) {
                if (fileArray[n2].isFile()) {
                    ArrayLigaType arrayLigaType = new ArrayLigaType();
                    try {
                        FileInputStream fileInputStream = new FileInputStream(fileArray[n2].getPath());
                        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                        arrayLigaType = (ArrayLigaType)objectInputStream.readObject();
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
                    p.a(arrayLigaType);
                }
                ++n2;
            }
        }
    }

    public static void a(ArrayLigaType arrayLigaType) {
        int n2 = 0;
        while (n2 < arrayLigaType.a.size()) {
            c.a.SR.bG.add((ConfigLigaType)arrayLigaType.a.get(n2));
            ++n2;
        }
    }

    public static void a(ConfigLigaType[] configLigaTypeArray, int n2) {
        ArrayLigaType arrayLigaType = new ArrayLigaType();
        int n3 = 1;
        while (n3 < configLigaTypeArray.length) {
            arrayLigaType.a.add(configLigaTypeArray[n3]);
            ++n3;
        }
        ArrayList<ConfigLigaType> arrayList = new ArrayList<ConfigLigaType>();
        int n4 = 0;
        while (n4 < c.a.SR.bG.size()) {
            if (((ConfigLigaType)c.a.SR.bG.get(n4)).getPais() == n2) {
                arrayList.add((ConfigLigaType)c.a.SR.bG.get(n4));
            }
            ++n4;
        }
        n4 = 0;
        while (n4 < arrayList.size()) {
            c.a.SR.bG.remove(arrayList.get(n4));
            ++n4;
        }
        c.a.SR.bG.addAll(arrayLigaType.a);
        String string = String.valueOf(ac.valueOf("P" + Integer.toString(n2)).jA()) + ".cfg";
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(String.valueOf(System.getProperty("user.dir")) + "/conf_ligas_nacionais/" + string);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(arrayLigaType);
            objectOutputStream.close();
            fileOutputStream.close();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public static void c(int n2, int n3, int n4) {
        ConfigLigaType configLigaType = new ConfigLigaType();
        if (n2 == 1) {
            configLigaType.setnTimes(10);
            configLigaType.setnRebaixados(2);
        } else if (n2 == 2) {
            configLigaType.setnTimes(20);
            configLigaType.setnRebaixados(4);
        }
        configLigaType.setPais(n3);
        configLigaType.setDivisao(n4);
        c.a.SR.bG.add(configLigaType);
    }

    public static boolean dt() {
        return cM;
    }

    public static void n(boolean bl2) {
        cM = bl2;
    }

    public static int du() {
        return cO;
    }

    public static void dv() {
        ++cO;
    }
}

