/*
 * Decompiled with CFR 0.152.
 */
package best;

import a.dV;
import best.I;
import best.S;
import best.Z;
import best.a;
import best.ah;
import best.al;
import best.at;
import best.w;
import components.A;
import f.B;
import f.z;
import java.util.ArrayList;
import javax.swing.JPanel;

public abstract class s {
    private static ArrayList cP = new ArrayList();
    private static ArrayList cQ = new ArrayList();
    private static JPanel cR = null;
    private static ArrayList cS = new ArrayList();
    private static w cT = null;
    private static int cU = -1;
    private static int cV = -1;
    private static at cW = null;

    public static boolean dw() {
        boolean bl2 = false;
        int n2 = -1;
        int n3 = -1;
        boolean[] blArray = c.a.SR.getVerJint();
        int n4 = 0;
        while (n4 < c.a.SR.S().size()) {
            if (n2 == -1) {
                n2 = ((I)c.a.SR.S().get(n4)).hy().b();
                n3 = ((I)c.a.SR.S().get(n4)).hy().el();
            }
            if (((I)c.a.SR.S().get(n4)).hc().jZ().booleanValue() || ((I)c.a.SR.S().get(n4)).hd().jZ().booleanValue()) {
                bl2 = true;
                break;
            }
            ++n4;
        }
        if (!bl2) {
            if (n2 == 0) {
                return false;
            }
            n4 = c.a.SR.ae(n2, n3);
            if (n4 < blArray.length) {
                return blArray[n4];
            }
        }
        return true;
    }

    public static boolean b(at at2) {
        int n2 = at2.b();
        int n3 = at2.gg();
        boolean[] blArray = c.a.SR.getVerJint();
        int n4 = 0;
        while (n4 < c.a.SR.S().size()) {
            if (((I)c.a.SR.S().get(n4)).hy() == at2 && (((I)c.a.SR.S().get(n4)).hc().jZ().booleanValue() || ((I)c.a.SR.S().get(n4)).hd().jZ().booleanValue())) {
                return true;
            }
            ++n4;
        }
        if (n2 == 0) {
            return false;
        }
        n4 = c.a.SR.ae(n2, n3);
        if (n4 < blArray.length) {
            return blArray[n4];
        }
        return true;
    }

    public static void dx() {
        cS.clear();
        cU = -1;
        cV = -1;
        cW = null;
        cP.clear();
        cP.addAll(((a)c.a.SR.R().get(c.a.SR.J())).t());
        if (cP.size() > 0) {
            if (c.a.SR.bs) {
                cR = S.aY(4);
            }
            if (((at)cP.get(0)).b() == 1) {
                s.dI();
            } else if (((at)cP.get(0)).b() == 2) {
                s.dF();
            } else if (((at)cP.get(0)).b() == 3) {
                s.dE();
            } else if (((at)cP.get(0)).b() == 7) {
                s.dA();
            } else if (((at)cP.get(0)).b() == 8) {
                s.dz();
            } else if (((at)cP.get(0)).b() == 9) {
                s.dC();
            } else if (((at)cP.get(0)).b() == 10) {
                s.dD();
            } else if (((at)cP.get(0)).b() == 11) {
                s.dB();
            } else {
                s.dy();
            }
        }
    }

    public static void dy() {
        int n2 = 0;
        int n3 = 0;
        while (n3 < cP.size()) {
            cQ.clear();
            if (s.b((at)cP.get(n3))) {
                cQ.add((at)cP.get(n3));
                if (cQ.size() > 0) {
                    A a2 = new A();
                    a2.ub().addAll(cQ);
                    a2.av(true);
                    cS.add(a2);
                    cU = n2++;
                }
            }
            ++n3;
        }
        s.dJ();
    }

    public static void dz() {
        cQ.clear();
        int n2 = 0;
        while (n2 < cP.size()) {
            cQ.add((at)cP.get(n2));
            ++n2;
        }
        ((dV)cR).Y(cQ);
    }

    public static void dA() {
        cQ.clear();
        int n2 = 0;
        while (n2 < cP.size()) {
            cQ.add((at)cP.get(n2));
            ++n2;
        }
        ((dV)cR).Y(cQ);
    }

    public static void dB() {
        cQ.clear();
        int n2 = 0;
        while (n2 < cP.size()) {
            cQ.add((at)cP.get(n2));
            ++n2;
        }
        ((dV)cR).Y(cQ);
    }

    public static void dC() {
        cQ.clear();
        int n2 = 0;
        while (n2 < cP.size()) {
            cQ.add((at)cP.get(n2));
            ++n2;
        }
        ((dV)cR).Y(cQ);
    }

    public static void dD() {
        int n2 = 0;
        while (n2 < c.a.SR.bV().length) {
            int n3 = 0;
            while (n3 < cP.size()) {
                if (cP.get(n3) == c.a.SR.bV()[n2] && !cQ.contains(cP.get(n3))) {
                    cQ.add((at)cP.get(n3));
                }
                ++n3;
            }
            ++n2;
        }
        ((dV)cR).Y(cQ);
    }

    public static void dE() {
        cQ.clear();
        if (c.a.SR.isVerEstaduaisAgrupados()) {
            int n2 = 0;
            while (n2 < c.a.SR.aE().size()) {
                int n3 = 0;
                while (n3 < cP.size()) {
                    if (((at)cP.get(n3)).ir() == c.a.SR.aE().get(n2)) {
                        cQ.add((at)cP.get(n3));
                    }
                    ++n3;
                }
                ++n2;
            }
            ((dV)cR).Y(cQ);
        } else {
            int n4 = 0;
            while (n4 < c.a.SR.aE().size()) {
                if (((w)c.a.SR.aE().get(n4)).ei() && ((w)c.a.SR.aE().get(n4)).ej()) {
                    cQ.clear();
                    cU = ((w)c.a.SR.aE().get(n4)).getEstado();
                    int n5 = 0;
                    while (n5 < cP.size()) {
                        if (((at)cP.get(n5)).ir() == c.a.SR.aE().get(n4)) {
                            cQ.add((at)cP.get(n5));
                        }
                        ++n5;
                    }
                    if (cQ.size() > 0) {
                        A a2 = new A();
                        a2.ub().addAll(cQ);
                        a2.av(true);
                        cS.add(a2);
                    }
                }
                ++n4;
            }
            if (cQ.size() == 0) {
                int[] nArray = new int[]{c.a.SR.by(), 25, 18, 22, 17, 10};
                boolean bl2 = false;
                int n6 = 0;
                while (n6 < nArray.length) {
                    int n7 = c.a.SR.aE().size() - 1;
                    while (n7 >= 0) {
                        if (((w)c.a.SR.aE().get(n7)).getEstado() == nArray[n6] && ((w)c.a.SR.aE().get(n7)).ej()) {
                            cU = ((w)c.a.SR.aE().get(n7)).getEstado();
                            bl2 = true;
                            cQ.clear();
                            int n8 = 0;
                            while (n8 < cP.size()) {
                                if (((at)cP.get(n8)).ir() == c.a.SR.aE().get(n7)) {
                                    cQ.add((at)cP.get(n8));
                                }
                                ++n8;
                            }
                            if (cQ.size() > 0) {
                                A a3 = new A();
                                a3.ub().addAll(cQ);
                                a3.av(true);
                                cS.add(a3);
                            }
                        }
                        --n7;
                    }
                    if (bl2) break;
                    ++n6;
                }
            }
            s.dJ();
        }
    }

    public static void dF() {
        int n2;
        int n3;
        boolean bl2 = false;
        cQ.clear();
        if (bl2) {
            n3 = 0;
            while (n3 < c.a.SR.N().size()) {
                n2 = 0;
                while (n2 < cP.size()) {
                    if (((at)cP.get(n2)).iq() == c.a.SR.N().get(n3)) {
                        cQ.add((at)cP.get(n2));
                    }
                    ++n2;
                }
                ++n3;
            }
            ((dV)cR).Y(cQ);
        }
        if (!bl2) {
            n3 = 0;
            while (n3 < c.a.SR.N().size()) {
                n2 = 0;
                if (((Z)c.a.SR.N().get(n3)).ju() && ((Z)c.a.SR.N().get(n3)).jv()) {
                    n2 = 1;
                }
                if (n2 != 0) {
                    cQ.clear();
                    int n4 = 0;
                    while (n4 < cP.size()) {
                        cW = (at)cP.get(n4);
                        if (cP.get(n4) == ((Z)c.a.SR.N().get(n3)).jq()) {
                            cQ.add((at)cP.get(n4));
                        }
                        ++n4;
                    }
                    if (cQ.size() > 0) {
                        A a2 = new A();
                        a2.ub().addAll(cQ);
                        a2.av(true);
                        cS.add(a2);
                    }
                }
                ++n3;
            }
            if (cQ.size() == 0) {
                n3 = c.a.SR.bA();
                n2 = 0;
                int n5 = c.a.SR.N().size() - 1;
                while (n5 >= 0) {
                    if (((Z)c.a.SR.N().get(n5)).jc() == n3 && ((Z)c.a.SR.N().get(n5)).jv()) {
                        n2 = 1;
                        cQ.clear();
                        int n6 = 0;
                        while (n6 < cP.size()) {
                            cW = (at)cP.get(n6);
                            if (cP.get(n6) == ((Z)c.a.SR.N().get(n5)).jq()) {
                                cQ.add((at)cP.get(n6));
                            }
                            ++n6;
                        }
                        if (cQ.size() <= 0) break;
                        A a3 = new A();
                        a3.ub().addAll(cQ);
                        a3.av(true);
                        cS.add(a3);
                        break;
                    }
                    --n5;
                }
            }
            s.dJ();
        }
    }

    public static boolean dG() {
        int n2 = 0;
        while (n2 < ((a)c.a.SR.R().get(c.a.SR.J())).j().size()) {
            f.s s2 = null;
            at at2 = null;
            if (((a)c.a.SR.R().get(c.a.SR.J())).j().get(n2) instanceof f.s) {
                s2 = (f.s)((a)c.a.SR.R().get(c.a.SR.J())).j().get(n2);
            } else if (((a)c.a.SR.R().get(c.a.SR.J())).j().get(n2) instanceof z && (s2 = (f.s)((z)((a)c.a.SR.R().get(c.a.SR.J())).j().get(n2)).zy()) == null && (at2 = ((z)((a)c.a.SR.R().get(c.a.SR.J())).j().get(n2)).yT()) instanceof B) {
                s2 = ((B)at2).yi();
            }
            if (s2 != null && s2.ei()) {
                return true;
            }
            ++n2;
        }
        return false;
    }

    public static boolean d(int n2, int n3) {
        boolean bl2 = false;
        String[] stringArray = new String[]{"AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO"};
        Integer[][] integerArrayArray = new Integer[][]{{18, 25}, {10, 17, 22, 23}, {1, 4, 5, 9, 14, 15, 16, 19, 24}, {0, 2, 3, 6, 7, 8, 11, 12, 13, 20, 21, 26}};
        int n4 = 0;
        while (n4 < integerArrayArray[n3].length) {
            if (integerArrayArray[n3][n4] == n2) {
                bl2 = true;
            }
            ++n4;
        }
        return bl2;
    }

    public static boolean dH() {
        boolean bl2 = false;
        int n2 = 0;
        while (n2 < c.a.SR.bV().length) {
            if (c.a.SR.bV()[n2] != null) {
                int n3 = 0;
                while (n3 < c.a.SR.M().size()) {
                    ah ah2 = ((al)c.a.SR.M().get(n3)).fg();
                    if (ah2 != null && ah2.getPais() == 29 && s.d(ah2.getEstado(), n2)) {
                        bl2 = true;
                    } else if (ah2 == null && !c.a.SR.isIgnoraEstadual() && ((al)c.a.SR.M().get(n3)).lF() != null && ((al)c.a.SR.M().get(n3)).lF().getPais() == 29 && s.d(((al)c.a.SR.M().get(n3)).lF().getEstado(), n2)) {
                        bl2 = true;
                    }
                    ++n3;
                }
            }
            ++n2;
        }
        return bl2;
    }

    public static boolean J(int n2) {
        boolean bl2 = false;
        boolean bl3 = true;
        int n3 = 0;
        while (n3 < c.a.SR.M().size()) {
            ah ah2 = ((al)c.a.SR.M().get(n3)).fg();
            if (ah2 != null && ah2.getPais() == 29) {
                bl2 = true;
                if (ah2.getEstado() != 18) {
                    bl3 = false;
                }
            } else if (ah2 == null && ((al)c.a.SR.M().get(n3)).lF() != null && ((al)c.a.SR.M().get(n3)).lF().getPais() == 29) {
                bl2 = true;
                if (((al)c.a.SR.M().get(n3)).lF().getEstado() != 18) {
                    bl3 = false;
                }
            }
            ++n3;
        }
        return bl2;
    }

    public static void dI() {
        int n2;
        int n3;
        boolean bl2 = false;
        cQ.clear();
        if (bl2) {
            n3 = 0;
            while (n3 < c.a.SR.N().size()) {
                n2 = 0;
                while (n2 < cP.size()) {
                    if (((at)cP.get(n2)).iq() == c.a.SR.N().get(n3)) {
                        cQ.add((at)cP.get(n2));
                    }
                    ++n2;
                }
                ++n3;
            }
            ((dV)cR).Y(cQ);
        }
        if (!bl2) {
            n3 = 0;
            while (n3 < c.a.SR.N().size()) {
                n2 = 0;
                if ((((Z)c.a.SR.N().get(n3)).ei() || ((Z)c.a.SR.N().get(n3)).jr()) && ((Z)c.a.SR.N().get(n3)).ej()) {
                    n2 = 1;
                }
                if (n2 != 0) {
                    cU = ((Z)c.a.SR.N().get(n3)).jc();
                    cQ.clear();
                    int n4 = 0;
                    while (n4 < cP.size()) {
                        if (((at)cP.get(n4)).iq() == c.a.SR.N().get(n3)) {
                            cQ.add((at)cP.get(n4));
                        }
                        ++n4;
                    }
                    if (cQ.size() > 0) {
                        A a2 = new A();
                        a2.ub().addAll(cQ);
                        a2.av(true);
                        cS.add(a2);
                    }
                }
                ++n3;
            }
            if (cQ.size() == 0) {
                int[] nArray = new int[]{c.a.SR.bz()};
                n2 = 0;
                int n5 = 0;
                while (n5 < nArray.length) {
                    int n6 = c.a.SR.N().size() - 1;
                    while (n6 >= 0) {
                        if (((Z)c.a.SR.N().get(n6)).jc() == nArray[n5] && ((Z)c.a.SR.N().get(n6)).ej()) {
                            cU = ((Z)c.a.SR.N().get(n6)).jc();
                            n2 = 1;
                            cQ.clear();
                            int n7 = 0;
                            while (n7 < cP.size()) {
                                if (((at)cP.get(n7)).iq() == c.a.SR.N().get(n6)) {
                                    cQ.add((at)cP.get(n7));
                                }
                                ++n7;
                            }
                            if (cQ.size() > 0) {
                                A a3 = new A();
                                a3.ub().addAll(cQ);
                                a3.av(true);
                                cS.add(a3);
                            }
                        }
                        --n6;
                    }
                    if (n2 != 0) break;
                    ++n5;
                }
            }
            s.dJ();
        }
    }

    public static void dJ() {
        int n2 = s.dK();
        if (n2 >= 0) {
            ((A)cS.get(n2)).av(false);
            ((dV)cR).Y(((A)cS.get(n2)).ub());
        } else {
            ((dV)s.cR).GO = null;
            cR = null;
            c.a.SR.at();
        }
    }

    public static int dK() {
        int n2 = 0;
        while (n2 < cS.size()) {
            if (((A)cS.get(n2)).uc()) {
                return n2;
            }
            ++n2;
        }
        return -1;
    }

    public static int dL() {
        return cU;
    }

    public static int dM() {
        return cV;
    }

    public static void L(int n2) {
        cV = n2;
    }

    public static at dN() {
        return cW;
    }
}

