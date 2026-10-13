/*
 * Decompiled with CFR 0.152.
 */
package f;

import best.L;
import best.M;
import best.Z;
import best.ah;
import best.aq;
import best.at;
import c.a;
import components.al;
import components.am;
import components.as;
import components.y;
import est.LoadLigaOptions;
import f.G;
import f.b;
import f.s;
import f.z;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class x
extends at
implements Serializable {
    private static final long serialVersionUID = 1L;
    private z YP = null;
    private z YQ = null;
    private s YD = null;
    private z afT = null;
    private ArrayList YF = new ArrayList();
    private ArrayList YS = new ArrayList();
    private ArrayList ZE = new ArrayList();
    private ah ZA = null;
    private ArrayList YV = new ArrayList();
    private ArrayList YW = new ArrayList();
    private ah ago = null;

    public x() {
        this.setNome(M.getString("ligaE"));
        this.F(6, 0);
        this.yo();
        this.yp();
    }

    private void yo() {
        this.YV.clear();
        this.YV.add(new am("ing", 97, 1, true));
        this.YV.add(new am("esp", 65, 1, true));
        this.YV.add(new am("ita", 104, 1, true));
        this.YV.add(new am("ale", 3, 1, true));
        this.YV.add(new am("fra", 72, 1, true));
        this.YV.add(new am("por", 154, 1, true));
        this.YV.add(new am("hol", 85, 1, true));
        this.YV.add(new am("fra", 72, 1, false));
        this.YV.add(new am("ing", 97, 1, false));
        this.YV.add(new am("esp", 65, 1, false));
        this.YV.add(new am("ita", 104, 1, false));
    }

    private void yp() {
        this.YW.clear();
        this.YW.add(new am("bel", 21, 1, true));
        this.YW.add(new am("aut", 15, 1, true));
        this.YW.add(new am("esc", 62, 1, true));
        this.YW.add(new am("ucr", 193, 1, true));
        this.YW.add(new am("tur", 192, 1, true));
        this.YW.add(new am("din", 54, 1, true));
        this.YW.add(new am("chipre", 44, 1, true));
        this.YW.add(new am("cze", 159, 1, true));
        this.YW.add(new am("serv", 171, 1, true));
    }

    public void a(int n2, al al2) {
        b.a(0, 2, this.YV, this.YW, n2, al2);
    }

    private void Bd() {
        ((am)this.YW.get(6)).fE(162);
    }

    public void yq() {
        if (a.SR.H() == 3) {
            this.Bd();
        }
        if (this.YD != null) {
            this.YD.aN(true);
        }
        this.YF.clear();
        this.YS.clear();
        this.ZE.clear();
        this.YD = null;
        this.YP = null;
        this.YQ = null;
        ArrayList<am> arrayList = new ArrayList<am>();
        ArrayList<ah> arrayList2 = new ArrayList<ah>();
        arrayList2.addAll(a.SR.aI().yy());
        arrayList2.addAll(a.SR.aI().yE());
        if (a.SR.H() > 1 && this.ago != null && !a.SR.aI().yy().contains(this.ago) && !a.SR.aI().yE().contains(this.ago)) {
            this.YF.add(this.ago);
            arrayList2.add(this.ago);
        } else {
            arrayList.add(new am("ale", 3, 1));
        }
        if (arrayList.size() > 0) {
            b.a(arrayList, this.YF, arrayList2, false);
        }
        b.a(this.YV, this.YF, arrayList2, false);
        b.a(this.YW, this.YS, arrayList2, false);
        if (this.YF.size() < 12) {
            b.a(this.YF, this.YV, 12, arrayList2);
        }
        if (this.YS.size() < 9) {
            b.a(this.YS, this.YW, 9, arrayList2);
        }
        Collections.sort(this.YF, h.a.abm);
    }

    public void aj(ArrayList arrayList) {
        ArrayList<ah> arrayList2 = new ArrayList<ah>();
        ArrayList<ah> arrayList3 = new ArrayList<ah>();
        ArrayList<ah> arrayList4 = new ArrayList<ah>();
        int n2 = 0;
        while (n2 <= 9) {
            arrayList2.add((ah)arrayList.get(n2));
            ++n2;
        }
        n2 = 10;
        while (n2 <= 11) {
            arrayList3.add((ah)arrayList.get(n2));
            ++n2;
        }
        n2 = 7;
        while (n2 <= 8) {
            arrayList3.add((ah)this.YS.get(n2));
            ++n2;
        }
        Collections.shuffle(arrayList2);
        Collections.shuffle(arrayList3);
        arrayList4.addAll(arrayList2);
        arrayList4.addAll(arrayList3);
        boolean[] blArray = new boolean[]{true, true, true, true, true, true, true};
        this.YP = new z(null, arrayList4.size(), this.b(), 1, blArray, this, 6001);
        G g2 = new G();
        g2.a(this.YP, arrayList4, 0, blArray[0], 0, 0, this.b(), false);
    }

    public void g(ArrayList arrayList, ArrayList arrayList2) {
        int n2 = 0;
        while (n2 < arrayList2.size()) {
            ((ah)arrayList2.get(n2)).a(this, -1, 6001);
            ++n2;
        }
        ArrayList<ah> arrayList3 = new ArrayList<ah>();
        ArrayList<ah> arrayList4 = new ArrayList<ah>();
        ArrayList<ah> arrayList5 = new ArrayList<ah>();
        ArrayList arrayList6 = new ArrayList();
        a.SR.mj().zo().addAll(arrayList2);
        a.SR.mj().b(arrayList2, 0);
        int n3 = 0;
        while (n3 <= 6) {
            arrayList3.add((ah)this.YS.get(n3));
            ++n3;
        }
        n3 = 0;
        while (n3 <= 5) {
            arrayList3.add((ah)this.ZE.get(n3));
            ++n3;
        }
        arrayList3.addAll(arrayList);
        Collections.shuffle(arrayList3);
        n3 = 0;
        while (n3 <= 9) {
            arrayList4.add((ah)arrayList3.get(n3));
            ++n3;
        }
        n3 = 10;
        while (n3 <= 19) {
            arrayList5.add((ah)arrayList3.get(n3));
            ++n3;
        }
        Random random = new Random();
        components.aq[] aqArray = new components.aq[10];
        int n4 = 0;
        while (n4 <= 9) {
            aqArray[n4] = new components.aq();
            ++n4;
        }
        n4 = 0;
        while (n4 <= 9) {
            if (random.nextBoolean()) {
                aqArray[n4].e(arrayList4, arrayList5);
            } else {
                aqArray[n4].e(arrayList5, arrayList4);
            }
            ++n4;
        }
        n4 = 0;
        while (n4 <= 9) {
            arrayList6.addAll(aqArray[n4].cZ());
            ++n4;
        }
        boolean[] blArray = new boolean[]{true, true, true, true, true, true, true};
        this.YQ = new z(null, arrayList6.size(), this.b(), 1, blArray, this, 6002);
        G g2 = new G();
        g2.a(this.YQ, arrayList6, 0, blArray[0], 0, 0, this.b(), false);
    }

    public void m(ArrayList arrayList, ArrayList arrayList2) {
        int n2 = 0;
        while (n2 < arrayList2.size()) {
            ((ah)arrayList2.get(n2)).a(this, -1, 6004);
            ++n2;
        }
        a.SR.mj().zo().addAll(arrayList2);
        a.SR.mj().b(arrayList2, 0);
        ArrayList<ah> arrayList3 = new ArrayList<ah>();
        int n3 = 6;
        while (n3 <= 15) {
            arrayList3.add((ah)this.ZE.get(n3));
            ++n3;
        }
        arrayList3.addAll(arrayList);
        arrayList3.addAll(this.YF);
        Collections.sort(arrayList3, h.a.abm);
        ArrayList<ah> arrayList4 = new ArrayList<ah>();
        ArrayList<ah> arrayList5 = new ArrayList<ah>();
        ArrayList<ah> arrayList6 = new ArrayList<ah>();
        ArrayList<ah> arrayList7 = new ArrayList<ah>();
        int n4 = 0;
        while (n4 <= 7) {
            arrayList4.add((ah)arrayList3.get(n4));
            ++n4;
        }
        n4 = 8;
        while (n4 <= 15) {
            arrayList5.add((ah)arrayList3.get(n4));
            ++n4;
        }
        n4 = 16;
        while (n4 <= 23) {
            arrayList6.add((ah)arrayList3.get(n4));
            ++n4;
        }
        n4 = 24;
        while (n4 <= 31) {
            arrayList7.add((ah)arrayList3.get(n4));
            ++n4;
        }
        Collections.shuffle(arrayList4);
        Collections.shuffle(arrayList5);
        Collections.shuffle(arrayList6);
        Collections.shuffle(arrayList7);
        components.aq[] aqArray = new components.aq[8];
        int n5 = 0;
        while (n5 <= 7) {
            aqArray[n5] = new components.aq();
            ++n5;
        }
        n5 = 0;
        while (n5 <= 7) {
            aqArray[n5].a(arrayList4, arrayList5, arrayList6, arrayList7);
            ++n5;
        }
        aqArray[0].a(aqArray);
        ArrayList arrayList8 = new ArrayList();
        int n6 = 0;
        while (n6 <= 7) {
            arrayList8.addAll(aqArray[n6].cZ());
            ++n6;
        }
        if (arrayList8.size() == 32) {
            boolean[] blArray = new boolean[7];
            blArray[0] = true;
            blArray[1] = true;
            blArray[2] = true;
            blArray[3] = true;
            boolean[] blArray2 = blArray;
            LoadLigaOptions loadLigaOptions = new LoadLigaOptions();
            loadLigaOptions.nTimes = 32;
            loadLigaOptions.nGrupos = 8;
            loadLigaOptions.numeroTimesMataMata = 2;
            loadLigaOptions.doisTurnos = true;
            loadLigaOptions.pulaDuasDatas = false;
            loadLigaOptions.duasVoltasMataMata = blArray2;
            s s2 = new s(loadLigaOptions, arrayList8, 0, null, null, null, 6, null, false, null, true, this);
            s2.fb(6005);
            this.YD = s2;
            s2.setNome(this.getNome());
        }
    }

    public void b(ArrayList arrayList, int n2) {
        int n3 = 0;
        while (n3 < arrayList.size()) {
            if (((ah)arrayList.get(n3)).jZ().booleanValue()) {
                if (n2 == 0) {
                    new as(((ah)arrayList.get(n3)).ka(), 30, 85, "", "");
                } else {
                    new as(((ah)arrayList.get(n3)).ka(), 31, 86, "", "");
                }
            }
            ++n3;
        }
    }

    public void Be() {
        ArrayList<ah> arrayList = new ArrayList<ah>();
        ArrayList<ah> arrayList2 = new ArrayList<ah>();
        ArrayList arrayList3 = new ArrayList();
        int n2 = 0;
        while (n2 < this.YD.yQ().size()) {
            arrayList.add((ah)((best.G)this.YD.yQ().get(n2)).gR().get(1));
            ++n2;
        }
        n2 = 0;
        while (n2 < a.SR.aI().yd().yQ().size()) {
            arrayList2.add((ah)((best.G)a.SR.aI().yd().yQ().get(n2)).gR().get(2));
            ++n2;
        }
        Collections.shuffle(arrayList);
        Collections.shuffle(arrayList2);
        components.aq[] aqArray = new components.aq[8];
        int n3 = 0;
        while (n3 <= 7) {
            aqArray[n3] = new components.aq();
            ++n3;
        }
        n3 = 0;
        while (n3 <= 7) {
            aqArray[n3].e(arrayList, arrayList2);
            ++n3;
        }
        aqArray[0].a(aqArray);
        n3 = 0;
        while (n3 <= 7) {
            arrayList3.addAll(aqArray[n3].cZ());
            ++n3;
        }
        boolean[] blArray = new boolean[7];
        blArray[0] = true;
        blArray[1] = true;
        blArray[2] = true;
        boolean[] blArray2 = blArray;
        this.YD.c(new z(this.YD, arrayList3.size(), this.b(), 1, blArray2, this, 6006));
        G g2 = new G();
        g2.a(this.YD.yY(), arrayList3, 0, blArray2[0], 0, 0, this.b(), false);
    }

    public void l(ArrayList arrayList, ArrayList arrayList2) {
        int n2 = 0;
        while (n2 < arrayList2.size()) {
            ((ah)arrayList2.get(n2)).a(this, -1, 6006);
            ++n2;
        }
        ArrayList<ah> arrayList3 = new ArrayList<ah>();
        ArrayList<ah> arrayList4 = new ArrayList<ah>();
        ArrayList arrayList5 = new ArrayList();
        int n3 = 0;
        while (n3 < this.YD.yQ().size()) {
            arrayList3.add((ah)((best.G)this.YD.yQ().get(n3)).gR().get(0));
            ++n3;
        }
        n3 = 0;
        while (n3 < arrayList.size()) {
            arrayList4.add((ah)arrayList.get(n3));
            ++n3;
        }
        Collections.shuffle(arrayList3);
        Collections.shuffle(arrayList4);
        components.aq[] aqArray = new components.aq[8];
        int n4 = 0;
        while (n4 <= 7) {
            aqArray[n4] = new components.aq();
            ++n4;
        }
        n4 = 0;
        while (n4 <= 7) {
            aqArray[n4].e(arrayList3, arrayList4);
            ++n4;
        }
        aqArray[0].a(aqArray);
        n4 = 0;
        while (n4 <= 7) {
            arrayList5.addAll(aqArray[n4].cZ());
            ++n4;
        }
        boolean[] blArray = new boolean[7];
        blArray[0] = true;
        blArray[1] = true;
        blArray[2] = true;
        boolean[] blArray2 = blArray;
        this.afT = new z(null, arrayList5.size(), this.b(), 0, blArray2, this, -1);
        G g2 = new G();
        g2.a(this.afT, arrayList5, 0, blArray2[0], 0, 0, this.b(), false);
    }

    public ArrayList yy() {
        return this.YF;
    }

    public ArrayList yE() {
        return this.YS;
    }

    public ah yz() {
        return this.ZA;
    }

    public void N(ah ah2) {
        this.ZA = ah2;
    }

    public s yd() {
        return this.YD;
    }

    @Override
    public void mr() {
        this.YD.f(this.afT);
    }

    @Override
    public Z mF() {
        int n2 = a.SR.H() - 1;
        int[] nArray = new int[]{152, 65, 52, 31, 21, 154, 3, 72, 162, 97};
        if ((n2 %= 10) < nArray.length) {
            return a.SR.s(nArray[n2]);
        }
        return null;
    }

    public static String yD() {
        int n2 = a.SR.H() - 1;
        String string = "";
        String[] stringArray = new String[]{"Gdansk", "Sevilla", "Zagreb", "Sofia", "Bruxelas", "Porto", "Frankfurt", "Lyon", "Moscou", "Liverpool"};
        string = stringArray[n2 %= 10];
        return string;
    }

    @Override
    public L[] mB() {
        L[] lArray = new L[]{this.YD};
        if (this.YD == null) {
            L[] lArray2 = new L[]{this.YP, this.YQ};
            lArray = lArray2;
        } else if (this.YD.yY() != null) {
            L[] lArray3 = new L[]{this.YD.yY(), this.afT};
            lArray = lArray3;
        }
        return lArray;
    }

    @Override
    public ArrayList mC() {
        ArrayList<y> arrayList = new ArrayList<y>();
        L[] lArray = new L[]{this.YP, this.YQ};
        arrayList.add(new y(lArray, "Fase Preliminar"));
        L[] lArray2 = new L[]{this.YD};
        arrayList.add(new y(lArray2, "Fase de Grupos"));
        if (this.YD != null && this.YD.yY() != null) {
            L[] lArray3 = new L[]{this.YD.yY(), this.afT};
            arrayList.add(new y(lArray3, "Fase Final"));
        } else {
            arrayList.add(new y(null, "Fase Final"));
        }
        return arrayList;
    }

    @Override
    public String[] b(L l2) {
        if (l2 == this.YP) {
            return aq.pN;
        }
        if (l2 == this.YQ) {
            return aq.pO;
        }
        if (this.YD != null && l2 == this.YD.yY()) {
            return aq.abY;
        }
        return aq.pA;
    }

    @Override
    public String[] mA() {
        String[] stringArray = new String[]{"", ""};
        stringArray[0] = "tr_ligaeuropa";
        stringArray[1] = this.getNome();
        return stringArray;
    }

    public ArrayList zo() {
        return this.ZE;
    }

    @Override
    public boolean cz(int n2) {
        return this.afT != null && this.afT.zq() == n2;
    }

    public void ab(ah ah2) {
        this.ago = ah2;
    }

    public ah BA() {
        return this.ago;
    }
}

