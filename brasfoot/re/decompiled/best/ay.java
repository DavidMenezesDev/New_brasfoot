/*
 * Decompiled with CFR 0.152.
 */
package best;

import best.S;
import best.Z;
import best.ah;
import best.al;
import c.a;
import f.B;
import f.s;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class ay
implements Serializable {
    private static final long serialVersionUID = 1L;
    private ArrayList Jg = new ArrayList();
    private ArrayList Jh = new ArrayList();
    private ArrayList Jj = new ArrayList();
    private ArrayList Jl = new ArrayList();

    public void L(ArrayList arrayList) {
        int n2 = 0;
        while (n2 < arrayList.size()) {
            if (!((ah)arrayList.get(n2)).jZ().booleanValue()) {
                this.d(this.Jg, ((ah)arrayList.get(n2)).getPais());
                this.d(this.Jh, ((ah)arrayList.get(n2)).getPais());
            }
            ++n2;
        }
        Collections.shuffle(this.Jh);
    }

    public void zi() {
        this.Jg.clear();
        this.Jh.clear();
        this.Jj.clear();
        this.Jl.clear();
    }

    public ArrayList a(al al2, boolean bl2) {
        ArrayList<ah> arrayList = new ArrayList<ah>();
        ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
        ArrayList<ah> arrayList3 = new ArrayList<ah>();
        int n2 = 0;
        while (n2 < this.Jg.size()) {
            ah ah2 = a.SR.s((Integer)this.Jg.get(n2)).jn();
            if (ah2 != null && !ah2.jZ().booleanValue()) {
                arrayList.add(ah2);
            }
            ++n2;
        }
        Collections.shuffle(arrayList);
        if (arrayList.size() > 0) {
            int n3;
            arrayList2.add(0);
            arrayList2.add(1);
            arrayList2.add(3);
            arrayList2.add(2);
            arrayList2.add(4);
            arrayList2.add(5);
            int[][] nArrayArray = new int[][]{{2, 1, 1, 1, 1}, {2, 2, 1, 1, 1}, {3, 2, 2, 1, 1}, {4, 3, 2, 2, 1}, {5, 4, 5, 3, 2}, {5, 4, 4, 3, 2}};
            int n4 = al2.getReputacao();
            if (al2.fg() != null && al2.fg().getReputacao() > n4) {
                n4 = al2.fg().getReputacao();
            }
            int[] nArray = nArrayArray[n4];
            boolean bl3 = false;
            int n5 = 0;
            while (n5 < 2) {
                int n6;
                int n7 = 0;
                n3 = 0;
                while (n3 < nArray.length) {
                    if (nArray[n3] >= 1) {
                        n6 = 0;
                        while (n6 < arrayList.size()) {
                            if (((ah)arrayList.get(n6)).getReputacao() == nArray[n3] && ((ah)arrayList.get(n6)).gg() == ((Integer)arrayList2.get(n7)).intValue() && !arrayList3.contains(arrayList.get(n6))) {
                                if ((Integer)arrayList2.get(n7) == 5 && !bl3) {
                                    arrayList3.add((ah)arrayList.get(n6));
                                    bl3 = true;
                                } else if ((Integer)arrayList2.get(n7) != 5) {
                                    arrayList3.add((ah)arrayList.get(n6));
                                }
                                if (n7 + 1 < arrayList2.size()) {
                                    ++n7;
                                    break;
                                }
                                n7 = 0;
                                break;
                            }
                            ++n6;
                        }
                    }
                    ++n3;
                }
                if (arrayList3.size() < nArray.length) {
                    n3 = 0;
                    while (n3 < nArray.length) {
                        if (nArray[n3] >= 1 && arrayList3.size() < nArray.length) {
                            n6 = 0;
                            while (n6 < arrayList.size()) {
                                if (((ah)arrayList.get(n6)).getReputacao() == nArray[n3] && !arrayList3.contains(arrayList.get(n6))) {
                                    if (((ah)arrayList.get(n6)).gg() == 5 && !bl3) {
                                        arrayList3.add((ah)arrayList.get(n6));
                                        bl3 = true;
                                        break;
                                    }
                                    if (((ah)arrayList.get(n6)).gg() == 5) break;
                                    arrayList3.add((ah)arrayList.get(n6));
                                    break;
                                }
                                ++n6;
                            }
                        }
                        ++n3;
                    }
                }
                ++n5;
            }
            n5 = -1;
            al al3 = null;
            n3 = 0;
            if (n3 < a.SR.M().size()) {
                n5 = ((al)a.SR.M().get(n3)).lE();
                al3 = (al)a.SR.M().get(n3);
            }
            if (n5 >= 0) {
                n3 = 0;
                ah ah3 = null;
                int n8 = 0;
                while (n8 < arrayList.size()) {
                    if (((ah)arrayList.get(n8)).getPais() == n5 && !((ah)arrayList.get(n8)).jZ().booleanValue() && !arrayList3.contains(arrayList.get(n8))) {
                        ah3 = (ah)arrayList.get(n8);
                        if (((ah)arrayList.get(n8)).getNivel() < 18) {
                            n3 = 1;
                        } else if (al3 != null && al3.fg() != null && al3.fg().getReputacao() >= 3) {
                            n3 = 1;
                        }
                    }
                    ++n8;
                }
                if (n3 != 0) {
                    if (arrayList3.size() == 0) {
                        arrayList3.add(ah3);
                    } else {
                        arrayList3.set(arrayList3.size() - 1, ah3);
                    }
                }
            }
        }
        return arrayList3;
    }

    public void d(ArrayList arrayList, int n2) {
        if (!arrayList.contains(n2)) {
            arrayList.add(n2);
        }
    }

    public void zj() {
        this.Jl.clear();
        int n2 = 0;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int n3 = 0;
        while (n3 < a.SR.N().size()) {
            int n4 = 0;
            while (n4 < ((Z)a.SR.N().get(n3)).eb().size()) {
                arrayList.clear();
                if (((B)((Z)a.SR.N().get(n3)).eb().get(n4)).yi().yK().size() > 0) {
                    n2 = Math.round(((B)((Z)a.SR.N().get(n3)).eb().get(n4)).yi().yK().size() / 2);
                }
                int n5 = n2;
                while (n5 < ((B)((Z)a.SR.N().get(n3)).eb().get(n4)).yi().yK().size()) {
                    arrayList.add(((ah)((B)((Z)a.SR.N().get(n3)).eb().get(n4)).yi().yK().get(n5)).lk());
                    ++n5;
                }
                this.M(arrayList);
                ++n4;
            }
            ++n3;
        }
        Collections.shuffle(this.Jl);
    }

    private void M(ArrayList arrayList) {
        Collections.shuffle(arrayList);
        int n2 = 0;
        while (n2 <= 2) {
            if (n2 < arrayList.size()) {
                this.Jl.add((Integer)arrayList.get(n2));
            }
            ++n2;
        }
    }

    public ArrayList b(al al2, boolean bl2) {
        ArrayList arrayList = new ArrayList();
        Z z2 = a.SR.o(al2.lE());
        Z z3 = a.SR.s(al2.bz());
        if (z3 != null) {
            z3.a(arrayList, al2, bl2, true);
        }
        if (z2 != null && z2 != z3) {
            z2.a(arrayList, al2, bl2, false);
        }
        boolean bl3 = false;
        if (al2.jZ().booleanValue() && (al2.lG() < 2 || al2.getReputacao() > 3)) {
            bl3 = true;
        }
        if (bl3) {
            ArrayList<Z> arrayList2 = new ArrayList<Z>();
            if (a.SR.N().size() > 0) {
                int n2 = 0;
                while (n2 < a.SR.N().size()) {
                    if (a.SR.N().get(n2) != z3 && a.SR.N().get(n2) != z2) {
                        arrayList2.add((Z)a.SR.N().get(n2));
                    }
                    ++n2;
                }
                if (arrayList2.size() > 0) {
                    Collections.shuffle(arrayList2);
                    n2 = 0;
                    while (n2 < arrayList2.size()) {
                        ((Z)arrayList2.get(n2)).a(arrayList, al2, bl2, false);
                        if (arrayList.size() > 6) break;
                        ++n2;
                    }
                }
            }
        }
        return arrayList;
    }

    public void zw() {
        int n2 = 0;
        while (n2 < a.SR.M().size()) {
            ArrayList arrayList;
            if (((al)a.SR.M().get(n2)).jZ().booleanValue() && ((al)a.SR.M().get(n2)).fg() != null && (arrayList = this.b((al)a.SR.M().get(n2), true)) != null && arrayList.size() > 0) {
                S.a(arrayList, (al)a.SR.M().get(n2), 0);
            }
            ++n2;
        }
    }

    public static ArrayList c(al al2, boolean bl2) {
        Object object;
        int n2;
        Object object2;
        ArrayList<ah> arrayList = new ArrayList<ah>();
        ArrayList<ah> arrayList2 = new ArrayList<ah>();
        ArrayList<ah> arrayList3 = new ArrayList<ah>();
        ArrayList<Integer> arrayList4 = new ArrayList<Integer>();
        boolean bl3 = false;
        boolean bl4 = false;
        if (a.SR.ca() - 1 == a.SR.H()) {
            bl4 = true;
            object2 = new s[6];
            if (a.SR.bK() != null) {
                object2[1] = a.SR.bK().yd();
            }
            if (a.SR.bM() != null) {
                object2[2] = a.SR.bM().yd();
            }
            if (a.SR.bQ() != null) {
                object2[3] = a.SR.bQ().yd();
            }
            if (a.SR.bS() != null) {
                object2[5] = a.SR.bS().yd();
            }
            int n3 = 0;
            while (n3 < ((s[])object2).length) {
                if (object2[n3] != null) {
                    n2 = 0;
                    while (n2 < object2[n3].yK().size()) {
                        if (!((ah)object2[n3].yK().get(n2)).jZ().booleanValue()) {
                            arrayList2.add((ah)object2[n3].yK().get(n2));
                        }
                        ++n2;
                    }
                }
                ++n3;
            }
        }
        if (a.SR.aY() != null && a.SR.aY().yd() != null) {
            int n4 = 0;
            while (n4 < a.SR.aY().yd().yK().size()) {
                if (!((ah)a.SR.aY().yd().yK().get(n4)).jZ().booleanValue()) {
                    arrayList2.add((ah)a.SR.aY().yd().yK().get(n4));
                }
                ++n4;
            }
            bl3 = true;
        }
        if (a.SR.ba() != null && a.SR.ba().yd() != null) {
            int n5 = 0;
            while (n5 < a.SR.ba().yd().yK().size()) {
                if (!((ah)a.SR.ba().yd().yK().get(n5)).jZ().booleanValue()) {
                    arrayList2.add((ah)a.SR.ba().yd().yK().get(n5));
                }
                ++n5;
            }
            arrayList4.add(0);
        }
        if (a.SR.aZ() != null && a.SR.aZ().yd() != null) {
            int n6 = 0;
            while (n6 < a.SR.aZ().yd().yK().size()) {
                if (!((ah)a.SR.aZ().yd().yK().get(n6)).jZ().booleanValue()) {
                    arrayList2.add((ah)a.SR.aZ().yd().yK().get(n6));
                }
                ++n6;
            }
            arrayList4.add(1);
        }
        if (a.SR.be() != null && a.SR.be().yd() != null) {
            int n7 = 0;
            while (n7 < a.SR.be().yd().yK().size()) {
                if (!((ah)a.SR.be().yd().yK().get(n7)).jZ().booleanValue()) {
                    arrayList2.add((ah)a.SR.be().yd().yK().get(n7));
                }
                ++n7;
            }
            arrayList4.add(2);
        }
        if (a.SR.bf() != null && a.SR.bf().yd() != null) {
            int n8 = 0;
            while (n8 < a.SR.bf().yd().yK().size()) {
                if (!((ah)a.SR.bf().yd().yK().get(n8)).jZ().booleanValue()) {
                    arrayList2.add((ah)a.SR.bf().yd().yK().get(n8));
                }
                ++n8;
            }
            arrayList4.add(3);
        }
        if (a.SR.bX() != null && a.SR.bX().yd() != null) {
            int n9 = 0;
            while (n9 < a.SR.bX().yd().yK().size()) {
                if (!((ah)a.SR.bX().yd().yK().get(n9)).jZ().booleanValue()) {
                    arrayList2.add((ah)a.SR.bX().yd().yK().get(n9));
                }
                ++n9;
            }
            arrayList4.add(5);
        }
        if (a.SR.bg() != null && a.SR.bg().yd() != null) {
            int n10 = 0;
            while (n10 < a.SR.bg().yd().yK().size()) {
                if (!((ah)a.SR.bg().yd().yK().get(n10)).jZ().booleanValue()) {
                    arrayList2.add((ah)a.SR.bg().yd().yK().get(n10));
                }
                ++n10;
            }
            arrayList4.add(4);
        }
        if (arrayList2.size() > 0) {
            int n11;
            int n12;
            Collections.shuffle(arrayList2);
            object2 = new int[][]{{2, 1, 1, -1, -1}, {2, 2, 1, 1, 1}, {3, 2, 2, 1, 1}, {4, 3, 2, 2, 1}, {5, 4, 5, 3, 2}, {5, 4, 4, 3, 2}};
            int[][] nArrayArray = new int[][]{{-1, -1, -1, -1, -1}, {2, 2, 1, 1, 1, 1}, {2, 2, 1, 1, 1, 1}, {4, 3, 2, 2, 2, 1}, {5, 4, 4, 3, 2, 1}, {5, 5, 4, 4, 3, 2}};
            n2 = al2.getReputacao();
            if (al2.fg() != null && al2.fg().getReputacao() > n2) {
                n2 = al2.fg().getReputacao();
            }
            object = object2[n2];
            if (bl4) {
                object = nArrayArray[n2];
                int[] nArray = new int[]{12, 7, 7, 8, 10, 10};
                int[] nArray2 = new int[6];
                Z z2 = a.SR.s(al2.lE());
                n12 = z2.gg();
                if (al2.fg() != null) {
                    if (al2.fg().gg() == 0) {
                        nArray[0] = 12;
                        nArray[0] = 7;
                    } else if (al2.fg().gg() == 1) {
                        nArray[0] = 9;
                        nArray[1] = 10;
                    }
                }
                n11 = 0;
                while (n11 < arrayList2.size()) {
                    if (nArray2[((ah)arrayList2.get(n11)).gg()] < nArray[((ah)arrayList2.get(n11)).gg()] && !arrayList3.contains(arrayList2.get(n11))) {
                        arrayList3.add((ah)arrayList2.get(n11));
                        int n13 = ((ah)arrayList2.get(n11)).gg();
                        nArray2[n13] = nArray2[n13] + 1;
                    }
                    if (n12 == ((ah)arrayList2.get(n11)).gg() && ((ah)arrayList2.get(n11)).getReputacao() >= 4 && !arrayList3.contains(arrayList2.get(n11))) {
                        arrayList3.add((ah)arrayList2.get(n11));
                    }
                    ++n11;
                }
                if (arrayList3.size() > 0) {
                    arrayList2 = arrayList3;
                }
            }
            if (bl3 || bl4 || arrayList4.size() <= 0) {
                if (arrayList2.size() > 0) {
                    int n14 = 0;
                    while (n14 < ((Object)object).length) {
                        if (object[n14] >= true) {
                            int n15 = 0;
                            while (n15 < arrayList2.size()) {
                                if (((ah)arrayList2.get(n15)).getReputacao() == object[n14] && !arrayList.contains(arrayList2.get(n15))) {
                                    arrayList.add((ah)arrayList2.get(n15));
                                    break;
                                }
                                ++n15;
                            }
                        }
                        ++n14;
                    }
                }
            } else if (arrayList2.size() > 0) {
                boolean bl5 = false;
                int n16 = 0;
                while (n16 < 2) {
                    int n17 = 0;
                    n12 = 0;
                    while (n12 < ((Object)object).length) {
                        if (object[n12] >= true) {
                            n11 = 0;
                            while (n11 < arrayList2.size()) {
                                if (((ah)arrayList2.get(n11)).getReputacao() == object[n12] && ((ah)arrayList2.get(n11)).gg() == ((Integer)arrayList4.get(n17)).intValue() && !arrayList.contains(arrayList2.get(n11))) {
                                    if ((Integer)arrayList4.get(n17) == 5 && !bl5) {
                                        arrayList.add((ah)arrayList2.get(n11));
                                        bl5 = true;
                                    } else if ((Integer)arrayList4.get(n17) != 5) {
                                        arrayList.add((ah)arrayList2.get(n11));
                                    }
                                    if (n17 + 1 < arrayList4.size()) {
                                        ++n17;
                                        break;
                                    }
                                    n17 = 0;
                                    break;
                                }
                                ++n11;
                            }
                        }
                        ++n12;
                    }
                    ++n16;
                }
                if (arrayList.size() < ((Object)object).length) {
                    n16 = 0;
                    while (n16 < ((Object)object).length) {
                        if (object[n16] >= true && arrayList.size() < ((Object)object).length) {
                            int n18 = 0;
                            while (n18 < arrayList2.size()) {
                                if (((ah)arrayList2.get(n18)).getReputacao() == object[n16] && !arrayList.contains(arrayList2.get(n18))) {
                                    if (((ah)arrayList2.get(n18)).gg() == 5 && !bl5) {
                                        arrayList.add((ah)arrayList2.get(n18));
                                        bl5 = true;
                                        break;
                                    }
                                    if (((ah)arrayList2.get(n18)).gg() == 5) break;
                                    arrayList.add((ah)arrayList2.get(n18));
                                    break;
                                }
                                ++n18;
                            }
                        }
                        ++n16;
                    }
                }
            }
        }
        int n19 = -1;
        al al3 = null;
        n2 = 0;
        if (n2 < a.SR.M().size()) {
            n19 = ((al)a.SR.M().get(n2)).lE();
            al3 = (al)a.SR.M().get(n2);
        }
        if (n19 >= 0) {
            n2 = 0;
            object = null;
            int n20 = 0;
            while (n20 < arrayList2.size()) {
                if (((ah)arrayList2.get(n20)).getPais() == n19 && !((ah)arrayList2.get(n20)).jZ().booleanValue() && !arrayList.contains(arrayList2.get(n20))) {
                    object = (ah)arrayList2.get(n20);
                    if (((ah)arrayList2.get(n20)).getNivel() < 18) {
                        n2 = 1;
                    } else if (al3 != null && al3.fg() != null && al3.fg().getReputacao() >= 3) {
                        n2 = 1;
                    }
                }
                ++n20;
            }
            if (n2 != 0) {
                if (arrayList.size() == 0) {
                    arrayList.add((ah)object);
                } else {
                    arrayList.set(arrayList.size() - 1, (ah)object);
                }
            }
        }
        System.out.println("cria proposta selecao:" + arrayList.size());
        return arrayList;
    }

    public ArrayList Ap() {
        ArrayList<ah> arrayList = new ArrayList<ah>();
        int n2 = 0;
        while (n2 < this.Jl.size()) {
            ah ah2 = a.SR.x((Integer)this.Jl.get(n2));
            if (ah2 != null && !ah2.jZ().booleanValue()) {
                arrayList.add(ah2);
            }
            ++n2;
        }
        return arrayList;
    }

    public ArrayList Aq() {
        ArrayList<ah> arrayList = new ArrayList<ah>();
        int n2 = 0;
        while (n2 < this.Jh.size()) {
            ah ah2 = a.SR.s((Integer)this.Jh.get(n2)).jn();
            if (ah2 != null && !ah2.jZ().booleanValue()) {
                arrayList.add(ah2);
            }
            ++n2;
        }
        return arrayList;
    }
}

