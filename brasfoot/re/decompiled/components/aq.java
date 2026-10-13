/*
 * Decompiled with CFR 0.152.
 */
package components;

import best.ah;
import java.util.ArrayList;

public class aq {
    private ArrayList cE = new ArrayList();

    public boolean em(int n2) {
        int n3 = 0;
        while (n3 < this.cE.size()) {
            if (((ah)this.cE.get(n3)).getPais() == n2) {
                return true;
            }
            ++n3;
        }
        return false;
    }

    public void a(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
        this.a(arrayList, 0);
        this.a(arrayList2, this.ab(arrayList2));
        this.a(arrayList3, this.ab(arrayList3));
        this.a(arrayList4, this.ab(arrayList4));
    }

    public void e(ArrayList arrayList, ArrayList arrayList2) {
        this.a(arrayList, 0);
        this.a(arrayList2, this.ab(arrayList2));
    }

    public void f(ArrayList arrayList, ArrayList arrayList2) {
        this.a(arrayList, 0);
        this.a(arrayList2, 0);
    }

    public int ab(ArrayList arrayList) {
        int n2 = 0;
        while (n2 < arrayList.size()) {
            if (!this.em(((ah)arrayList.get(n2)).getPais())) {
                return n2;
            }
            ++n2;
        }
        return 0;
    }

    public void a(aq[] aqArray) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
        int n2 = 0;
        while (n2 < aqArray.length) {
            int n3 = 0;
            while (n3 < aqArray[n2].cZ().size()) {
                boolean bl2 = false;
                int n4 = 0;
                while (n4 < aqArray[n2].cZ().size()) {
                    if (aqArray[n2].cZ().get(n3) != aqArray[n2].cZ().get(n4) && ((ah)aqArray[n2].cZ().get(n3)).getPais() == ((ah)aqArray[n2].cZ().get(n4)).getPais()) {
                        arrayList.add(n2);
                        arrayList2.add(n3);
                        bl2 = true;
                        break;
                    }
                    ++n4;
                }
                if (bl2) break;
                ++n3;
            }
            ++n2;
        }
        if (arrayList.size() > 0 && arrayList.size() == arrayList2.size()) {
            n2 = 0;
            while (n2 < arrayList.size()) {
                this.a(aqArray, (Integer)arrayList.get(n2), (int)((Integer)arrayList2.get(n2)));
                ++n2;
            }
        }
    }

    private void a(aq[] aqArray, int n2, int n3) {
        int n4 = ((ah)aqArray[n2].cZ().get(n3)).getPais();
        int n5 = 0;
        while (n5 < aqArray.length) {
            if (aqArray[n2] != aqArray[n5] && !aqArray[n5].em(n4) && !aqArray[n2].em(((ah)aqArray[n5].cZ().get(n3)).getPais())) {
                this.a(aqArray[n2], aqArray[n5], n3);
                break;
            }
            ++n5;
        }
    }

    private void a(aq aq2, aq aq3, int n2) {
        ah ah2 = (ah)aq2.cZ().get(n2);
        ah ah3 = (ah)aq3.cZ().get(n2);
        aq2.e(ah3, n2);
        aq3.e(ah2, n2);
    }

    private void e(ah ah2, int n2) {
        this.cE.set(n2, ah2);
    }

    private void a(ArrayList arrayList, int n2) {
        this.cE.add((ah)arrayList.get(n2));
        arrayList.remove(n2);
    }

    public ArrayList cZ() {
        return this.cE;
    }
}

