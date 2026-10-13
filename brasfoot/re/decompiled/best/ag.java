/*
 * Decompiled with CFR 0.152.
 */
package best;

import best.F;
import best.Z;
import best.ah;
import best.al;
import best.j;
import best.l;
import c.a;
import f.B;
import f.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public abstract class ag {
    private static transient ArrayList mT = new ArrayList();

    public static void jO() {
        ag.jS();
        ag.jU();
        ag.jR();
        ag.jP();
        ag.jT();
    }

    public static void jP() {
        int n2 = 0;
        while (n2 < a.SR.aG().size()) {
            if (((Z)a.SR.aG().get(n2)).jn() != null) {
                if (!((Z)a.SR.aG().get(n2)).jn().jZ().booleanValue()) {
                    ((Z)a.SR.aG().get(n2)).z(false);
                } else {
                    int n3 = 2;
                    while (n3 < ((Z)a.SR.aG().get(n2)).jn().kc().size()) {
                        if (((F)((Z)a.SR.aG().get(n2)).jn().kc().get(n3)).fg() == null) {
                            ((Z)a.SR.aG().get(n2)).jn().kc().remove(((F)((Z)a.SR.aG().get(n2)).jn().kc().get(n3)).fg());
                        }
                        ++n3;
                    }
                }
            }
            ++n2;
        }
    }

    public static void jQ() {
        a.SR.bn().clear();
        int n2 = 0;
        while (n2 < a.SR.L().size()) {
            if (((al)a.SR.L().get(n2)).fg() != null) {
                ((al)a.SR.L().get(n2)).lS();
            }
            ++n2;
        }
        al al2 = null;
        int n3 = 0;
        while (n3 < a.SR.L().size()) {
            if (((al)a.SR.L().get(n3)).fg() != null && !((al)a.SR.L().get(n3)).jZ().booleanValue() && ((al)a.SR.L().get(n3)).lR() >= 1) {
                al2 = (al)a.SR.L().get(n3);
                int n4 = 0;
                int n5 = al2.lO().size() - 1;
                while (n5 >= 0) {
                    if (((j)al2.lO().get(n5)).H() == a.SR.H() - 1) {
                        n4 = (int)((float)((j)al2.lO().get(n5)).cm() * 100.0f / (float)((j)al2.lO().get(n5)).w());
                        break;
                    }
                    --n5;
                }
                if (new Random().nextInt(90) + 1 > n4) {
                    ((al)a.SR.L().get(n3)).fg().kE();
                }
            }
            ++n3;
        }
    }

    public static void jR() {
        int n2 = 0;
        while (n2 < a.SR.P().size()) {
            if (!((ah)a.SR.P().get(n2)).jZ().booleanValue()) {
                ((ah)a.SR.P().get(n2)).ku();
            }
            ++n2;
        }
    }

    public static void jS() {
        int n2 = 0;
        while (n2 < a.SR.N().size()) {
            int n3 = 0;
            while (n3 < ((Z)a.SR.N().get(n2)).eb().size()) {
                int n4 = 0;
                while (n4 < ((B)((Z)a.SR.N().get(n2)).eb().get(n3)).yi().yK().size()) {
                    if (!((ah)((B)((Z)a.SR.N().get(n2)).eb().get(n3)).yi().yK().get(n4)).jZ().booleanValue()) {
                        ag.a((ah)((B)((Z)a.SR.N().get(n2)).eb().get(n3)).yi().yK().get(n4), n4, true);
                    }
                    ++n4;
                }
                ++n3;
            }
            ++n2;
        }
    }

    public static void b(s s2) {
        int n2 = 0;
        while (n2 < s2.yK().size()) {
            if (!((ah)s2.yK().get(n2)).jZ().booleanValue()) {
                ag.a((ah)s2.yK().get(n2), n2, true);
            }
            ++n2;
        }
    }

    public static void jT() {
        boolean bl2 = false;
        ArrayList<F> arrayList = new ArrayList<F>();
        int n2 = 0;
        while (n2 < a.SR.P().size()) {
            bl2 = false;
            if (!((ah)a.SR.P().get(n2)).jZ().booleanValue()) {
                if (((ah)a.SR.P().get(n2)).gg() != 0 && ((ah)a.SR.P().get(n2)).getReputacao() < 5) {
                    bl2 = true;
                } else if (((ah)a.SR.P().get(n2)).gg() == 0 && ((ah)a.SR.P().get(n2)).getReputacao() < 4) {
                    bl2 = true;
                }
            }
            if (bl2) {
                int n3 = 0;
                while (n3 < ((ah)a.SR.P().get(n2)).kc().size()) {
                    if (((F)((ah)a.SR.P().get(n2)).kc().get(n3)).fi() > 50 && ((F)((ah)a.SR.P().get(n2)).kc().get(n3)).getIdade() < 31 && ((F)((ah)a.SR.P().get(n2)).kc().get(n3)).ff().booleanValue() && new Random().nextInt(100) > 25) {
                        arrayList.add((F)((ah)a.SR.P().get(n2)).kc().get(n3));
                    }
                    ++n3;
                }
            }
            ++n2;
        }
        n2 = 0;
        while (n2 < arrayList.size()) {
            l l2 = new l((F)arrayList.get(n2), ((F)arrayList.get(n2)).fk(), false, true, 2);
            l2.a(false, false);
            if (l2.cK() != null) {
                ((F)arrayList.get(n2)).a(l2.cK(), ((F)arrayList.get(n2)).fk(), false, false, false);
            }
            if (l2.cK() == null) {
                l l3 = new l((F)arrayList.get(n2), ((F)arrayList.get(n2)).fk(), false, true, 2);
                l3.k(false);
                if (l3.cK() != null) {
                    ((F)arrayList.get(n2)).a(l3.cK(), ((F)arrayList.get(n2)).fk(), false, false, false);
                }
            }
            ++n2;
        }
    }

    private static void jU() {
        int n2 = 0;
        while (n2 < a.SR.P().size()) {
            if (!((ah)a.SR.P().get(n2)).kn().booleanValue() && !((ah)a.SR.P().get(n2)).jZ().booleanValue()) {
                ag.a((ah)a.SR.P().get(n2), n2, false);
            }
            ++n2;
        }
    }

    private static void a(ah ah2, int n2, boolean bl2) {
        int n3 = 0;
        n3 = n2 <= 1 ? 1 : (n2 <= 5 ? 2 : (n2 <= 10 ? 3 : 4));
        int n4 = 0;
        while (n4 < n3) {
            ag.a(ah2, bl2, true);
            ++n4;
        }
        n4 = 0;
        while (n4 < n3) {
            ag.a(ah2, bl2, false);
            ++n4;
        }
    }

    private static void a(ah ah2, boolean bl2, boolean bl3) {
        int n2;
        int n3;
        F f2 = null;
        int[] nArray = ah2.J(true);
        int[] nArray2 = new int[6];
        nArray2[0] = 4;
        nArray2[1] = 5;
        nArray2[2] = 5;
        nArray2[3] = 10;
        nArray2[4] = 8;
        int[] nArray3 = nArray2;
        int[] nArray4 = new int[6];
        nArray4[0] = 3;
        nArray4[1] = 4;
        nArray4[2] = 4;
        nArray4[3] = 8;
        nArray4[4] = 6;
        int[] nArray5 = nArray4;
        int[] nArray6 = new int[6];
        nArray6[0] = 3;
        nArray6[1] = 4;
        nArray6[2] = 4;
        nArray6[3] = 6;
        nArray6[4] = 4;
        int[] nArray7 = nArray6;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int n4 = 0;
        while (n4 <= 4) {
            arrayList.add(n4);
            ++n4;
        }
        Collections.shuffle(arrayList);
        n4 = -1;
        if (bl3) {
            n3 = 0;
            while (n3 < arrayList.size()) {
                if (nArray[(Integer)arrayList.get(n3)] >= nArray3[(Integer)arrayList.get(n3)]) {
                    n4 = (Integer)arrayList.get(n3);
                    break;
                }
                ++n3;
            }
            if (n4 == -1) {
                n3 = 0;
                while (n3 < arrayList.size()) {
                    if (nArray[(Integer)arrayList.get(n3)] >= nArray5[(Integer)arrayList.get(n3)]) {
                        n4 = (Integer)arrayList.get(n3);
                        break;
                    }
                    ++n3;
                }
            }
        } else {
            n3 = 0;
            while (n3 < arrayList.size()) {
                if (nArray[(Integer)arrayList.get(n3)] > nArray7[(Integer)arrayList.get(n3)]) {
                    n4 = (Integer)arrayList.get(n3);
                    break;
                }
                ++n3;
            }
        }
        n3 = 0;
        if (new Random().nextInt(100) > 10) {
            n3 = 1;
        }
        if (n4 >= 0) {
            ArrayList<F> arrayList2 = new ArrayList<F>();
            n2 = 0;
            while (n2 < ah2.kc().size()) {
                if (!(((F)ah2.kc().get(n2)).getPosicao() != n4 || ((F)ah2.kc().get(n2)).gl().booleanValue() || ((F)ah2.kc().get(n2)).ff().booleanValue() && ((F)ah2.kc().get(n2)).ff() != n3)) {
                    arrayList2.add((F)ah2.kc().get(n2));
                }
                ++n2;
            }
            if (arrayList2.size() > 0) {
                Collections.shuffle(arrayList2);
                f2 = (F)arrayList2.get(0);
            }
        }
        if (f2 != null) {
            boolean bl4 = true;
            n2 = 0;
            int n5 = 0;
            if (bl2) {
                if (f2.fi() < 40 && new Random().nextInt(100) > 90) {
                    bl4 = false;
                }
            } else {
                bl4 = false;
                if (f2.ff().booleanValue() && new Random().nextInt(100) > 30) {
                    bl4 = true;
                    n5 = 1;
                    n2 = 1;
                } else if (f2.fi() >= 90 && new Random().nextInt(100) > 30) {
                    bl4 = true;
                    n5 = 1;
                    n2 = 1;
                } else if (f2.fi() >= 80 && f2.fi() < 90 && new Random().nextInt(100) > 35) {
                    bl4 = true;
                    n5 = 1;
                    n2 = 1;
                } else if (f2.fi() >= 70 && f2.fi() < 80 && new Random().nextInt(100) > 45) {
                    bl4 = true;
                    n5 = 1;
                    n2 = 1;
                } else if (f2.fi() >= 60 && f2.fi() < 70 && new Random().nextInt(100) > 75) {
                    bl4 = true;
                    n5 = 1;
                    n2 = 1;
                } else if (f2.fi() < 60 && new Random().nextInt(100) > 95) {
                    bl4 = true;
                    n5 = 1;
                    n2 = 1;
                }
            }
            l l2 = new l(f2, f2.fk(), false, true, n5);
            if (bl4) {
                l2.a(false, false);
            } else {
                l2.k(false);
            }
            if (l2.cK() != null) {
                f2.a(l2.cK(), f2.fk(), false, false, false);
            }
        }
    }
}

