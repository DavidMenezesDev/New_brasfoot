/*
 * Decompiled with CFR 0.152.
 */
package f;

import best.L;
import best.Z;
import best.ac;
import best.ad;
import best.ah;
import best.al;
import best.aq;
import best.at;
import c.a;
import components.as;
import components.az;
import f.G;
import f.z;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class f
extends at
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Z KR;
    private z YI = null;
    private int nTimes = -1;
    private ArrayList afU = new ArrayList();

    public f() {
    }

    public f(Z z2) {
        this.KR = z2;
        this.F(2, z2.gg());
        this.setNome("Copa " + ad.bq(z2.jc()) + " " + z2.jf());
        this.nTimes = this.nTimes;
    }

    public void a(f f2, ArrayList arrayList, boolean[] blArray) {
        int n2 = arrayList.size();
        if (n2 >= 8) {
            int n3 = 0;
            ArrayList<ah> arrayList2 = new ArrayList<ah>();
            ArrayList<ah> arrayList3 = new ArrayList<ah>();
            ArrayList<ah> arrayList4 = new ArrayList<ah>();
            if (n2 >= 128) {
                n3 = 128;
            } else if (n2 >= 64) {
                n3 = 64;
            } else if (n2 >= 32) {
                n3 = 32;
            } else if (n2 >= 16) {
                n3 = 16;
            } else if (n2 >= 8) {
                n3 = 8;
            }
            this.nTimes = n3;
            int n4 = 0;
            while (n4 < n3 / 2) {
                arrayList3.add((ah)arrayList.get(n4));
                arrayList4.add((ah)arrayList.get(n3 / 2 + n4));
                ++n4;
            }
            Collections.shuffle(arrayList3);
            Collections.shuffle(arrayList4);
            n4 = 0;
            while (n4 < arrayList3.size()) {
                arrayList2.add((ah)arrayList4.get(n4));
                arrayList2.add((ah)arrayList3.get(n4));
                ++n4;
            }
            z z2 = new z(null, arrayList2.size(), 2, 0, blArray, f2, -1);
            this.b(z2);
            G g2 = new G();
            g2.a(z2, arrayList2, 0, true, 0, 0, 2, false);
        }
    }

    public void b(f f2, ArrayList arrayList, boolean[] blArray) {
        int n2;
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(arrayList);
        if (this.afU.size() < 12) {
            this.afU.clear();
            if (a.SR.isJogaIntClubes() && a.SR.aF() != null) {
                if (a.SR.aF().yy() != null) {
                    n2 = 0;
                    while (n2 < a.SR.aF().yy().size()) {
                        if (((ah)a.SR.aF().yy().get(n2)).getPais() == 29) {
                            this.afU.add((ah)a.SR.aF().yy().get(n2));
                        }
                        ++n2;
                    }
                }
                if (a.SR.aF().yB() != null) {
                    n2 = 0;
                    while (n2 < a.SR.aF().yB().size()) {
                        if (((ah)a.SR.aF().yB().get(n2)).getPais() == 29) {
                            this.afU.add((ah)a.SR.aF().yB().get(n2));
                        }
                        ++n2;
                    }
                }
            }
            n2 = 0;
            while (n2 <= 12) {
                if (!this.afU.contains(arrayList2.get(n2))) {
                    this.afU.add((ah)arrayList2.get(n2));
                }
                ++n2;
            }
            this.Bg();
            this.Bf();
        } else {
            this.Bg();
            this.Bf();
        }
        if (this.afU.size() == 12) {
            n2 = 0;
            while (n2 <= 11) {
                arrayList2.remove(this.afU.get(n2));
                ++n2;
            }
            this.Bh();
            ArrayList<ah> arrayList3 = new ArrayList<ah>();
            az[] azArray = new az[8];
            int[] nArray = new int[]{10, 10, 10, 10, 10, 10, 10, 10};
            int n3 = 0;
            int n4 = 0;
            while (n4 < azArray.length) {
                azArray[n4] = new az();
                while (nArray[n4] > 0) {
                    if (azArray[n4].contains(arrayList2.get(n3))) continue;
                    azArray[n4].add((ah)arrayList2.get(n3));
                    ((ah)arrayList2.get(n3)).bW(n4);
                    ++n3;
                    int n5 = n4;
                    nArray[n5] = nArray[n5] - 1;
                }
                Collections.shuffle(azArray[n4]);
                ++n4;
            }
            n4 = 1;
            int n6 = 0;
            while (n6 < azArray.length) {
                if (azArray[n6] != null && azArray[n6].size() != 10) {
                    n4 = 0;
                    break;
                }
                ++n6;
            }
            if (n4 != 0) {
                n6 = 0;
                while (n6 < 10) {
                    arrayList3.add((ah)azArray[4].get(n6));
                    arrayList3.add((ah)azArray[0].get(n6));
                    arrayList3.add((ah)azArray[7].get(n6));
                    arrayList3.add((ah)azArray[3].get(n6));
                    arrayList3.add((ah)azArray[5].get(n6));
                    arrayList3.add((ah)azArray[1].get(n6));
                    arrayList3.add((ah)azArray[6].get(n6));
                    arrayList3.add((ah)azArray[2].get(n6));
                    ++n6;
                }
                boolean[] blArray2 = new boolean[8];
                blArray2[2] = true;
                blArray2[3] = true;
                blArray2[4] = true;
                blArray2[5] = true;
                blArray2[6] = true;
                blArray2[7] = true;
                boolean[] blArray3 = blArray2;
                z z2 = new z(null, arrayList3.size(), 2, 0, blArray3, f2, 2029);
                this.b(z2);
                G g2 = new G();
                g2.a(z2, arrayList3, 0, false, 0, 0, 2, false);
                g2.fb(2129);
            } else {
                this.a(f2, arrayList, blArray);
            }
        } else {
            this.a(f2, arrayList, blArray);
        }
    }

    public void ad(ArrayList arrayList) {
        ArrayList<ah> arrayList2 = new ArrayList<ah>();
        ArrayList<ah> arrayList3 = new ArrayList<ah>();
        ArrayList<ah> arrayList4 = new ArrayList<ah>();
        Collections.sort(arrayList, h.a.abm);
        int n2 = 0;
        while (n2 <= 19) {
            arrayList3.add((ah)arrayList.get(n2));
            ++n2;
        }
        n2 = 20;
        while (n2 <= 39) {
            arrayList4.add((ah)arrayList.get(n2));
            ++n2;
        }
        Collections.shuffle(arrayList3);
        Collections.shuffle(arrayList4);
        n2 = 0;
        while (n2 < arrayList3.size()) {
            arrayList2.add((ah)arrayList4.get(n2));
            arrayList2.add((ah)arrayList3.get(n2));
            ++n2;
        }
        G g2 = new G();
        g2.a(this.YI, arrayList2, 1, false, 0, 0, 2, false);
        g2.fb(2229);
        this.YI.BH();
    }

    public void ao(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        ArrayList<ah> arrayList3 = new ArrayList<ah>();
        arrayList2.addAll(arrayList);
        arrayList2.addAll(this.afU);
        if (arrayList2.size() == 32) {
            Collections.sort(arrayList2, h.a.abm);
            ArrayList<ah> arrayList4 = new ArrayList<ah>();
            ArrayList<ah> arrayList5 = new ArrayList<ah>();
            int n2 = 0;
            while (n2 <= 15) {
                arrayList4.add((ah)arrayList2.get(n2));
                ++n2;
            }
            n2 = 16;
            while (n2 <= 31) {
                arrayList5.add((ah)arrayList2.get(n2));
                ++n2;
            }
            Collections.shuffle(arrayList4);
            Collections.shuffle(arrayList5);
            n2 = 0;
            while (n2 < arrayList4.size()) {
                arrayList3.add((ah)arrayList4.get(n2));
                arrayList3.add((ah)arrayList5.get(n2));
                ++n2;
            }
            G g2 = new G();
            g2.a(this.YI, arrayList3, 2, true, 0, 0, 2, false);
            g2.fb(2329);
            this.YI.BH();
        }
    }

    public void as(ArrayList arrayList) {
        Collections.shuffle(arrayList);
        G g2 = new G();
        g2.a(this.YI, arrayList, 3, true, 0, 0, 2, false);
        g2.fb(2429);
        this.YI.BH();
    }

    public void at(ArrayList arrayList) {
        Collections.shuffle(arrayList);
        G g2 = new G();
        g2.a(this.YI, arrayList, 4, true, 0, 0, 2, false);
        g2.fb(2529);
        this.YI.BH();
    }

    public void au(ArrayList arrayList) {
        Collections.shuffle(arrayList);
        G g2 = new G();
        g2.a(this.YI, arrayList, 5, true, 0, 0, 2, false);
        g2.fb(2629);
        this.YI.BH();
    }

    public void av(ArrayList arrayList) {
        Collections.shuffle(arrayList);
        G g2 = new G();
        g2.a(this.YI, arrayList, 6, true, 0, 0, 2, false);
        g2.fb(2729);
        this.YI.BH();
    }

    private void Bf() {
        if (this.afU.size() > 12) {
            ArrayList<ah> arrayList = new ArrayList<ah>();
            int n2 = 0;
            while (n2 <= 11) {
                arrayList.add((ah)this.afU.get(n2));
                ++n2;
            }
            this.afU.clear();
            n2 = 0;
            while (n2 <= 11) {
                this.afU.add((ah)arrayList.get(n2));
                ++n2;
            }
        }
    }

    private void Bg() {
        if (a.SR.isJogaRegionais()) {
            ah ah2 = null;
            ah ah3 = null;
            if (a.SR.bV()[2] != null) {
                ah2 = a.SR.bV()[2].cS();
                this.afU.remove(ah2);
                this.afU.add(0, ah2);
            }
            if (a.SR.bV()[3] != null) {
                ah3 = a.SR.bV()[3].cS();
                this.afU.remove(ah3);
                this.afU.add(0, ah3);
            }
        }
    }

    public void Bh() {
        String string = "";
        if (this.afU.size() == 12) {
            int n2 = 0;
            while (n2 < this.afU.size()) {
                String string2 = String.valueOf(((ah)this.afU.get(n2)).getNome()) + ", ";
                if (n2 == 10) {
                    string2 = ((ah)this.afU.get(n2)).getNome();
                } else if (n2 == 11) {
                    string2 = " e " + ((ah)this.afU.get(n2)).getNome() + ".";
                }
                string = String.valueOf(string) + string2;
                ++n2;
            }
            n2 = 0;
            while (n2 < a.SR.M().size()) {
                if (((al)a.SR.M().get(n2)).fg() != null && ((al)a.SR.M().get(n2)).fg().getPais() == 29) {
                    new as((al)a.SR.M().get(n2), 23, 75, "", string);
                }
                ++n2;
            }
        }
    }

    public void Bi() {
        this.afU.clear();
    }

    public void W(ah ah2) {
        if (!this.afU.contains(ah2)) {
            this.afU.add(ah2);
        }
    }

    public z yf() {
        return this.YI;
    }

    public void b(z z2) {
        this.YI = z2;
    }

    public int iW() {
        return this.KR.iW();
    }

    public Z yg() {
        return this.KR;
    }

    @Override
    public void mr() {
        this.YI.z(this);
    }

    @Override
    public L[] mB() {
        L[] lArray = new L[]{this.YI};
        return lArray;
    }

    @Override
    public ArrayList mC() {
        return null;
    }

    @Override
    public String[] b(L l2) {
        if (this.YI.zf() == 2029 && a.vM().isNovoFormatoCopa()) {
            return aq.pt;
        }
        return this.YI.zB();
    }

    @Override
    public String[] mA() {
        String[] stringArray = new String[]{"", ""};
        String string = "tr_copa_" + ac.valueOf("P" + Integer.toString(this.KR.jc())).jA();
        String string2 = "tr_copa";
        stringArray[0] = aq.w(string) ? string : string2;
        stringArray[1] = this.getNome();
        return stringArray;
    }

    public int getnTimes() {
        return this.nTimes;
    }

    public String[] yh() {
        if (this.nTimes == 128) {
            return aq.px;
        }
        if (this.nTimes == 64) {
            return aq.py;
        }
        if (this.nTimes == 32) {
            return aq.pz;
        }
        if (this.nTimes == 16) {
            return aq.pA;
        }
        if (this.nTimes == 8) {
            return aq.pB;
        }
        if (this.nTimes == 4) {
            return aq.pC;
        }
        if (this.nTimes == 2) {
            return aq.pD;
        }
        return aq.ps;
    }
}

