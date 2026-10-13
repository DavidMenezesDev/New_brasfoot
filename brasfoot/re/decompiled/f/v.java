/*
 * Decompiled with CFR 0.152.
 */
package f;

import best.L;
import best.Z;
import best.ah;
import best.aq;
import best.at;
import c.a;
import components.al;
import components.am;
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

public class v
extends at
implements Serializable {
    private static final long serialVersionUID = 1L;
    private z YJ = null;
    private z YP = null;
    private z YQ = null;
    private z YR = null;
    private z ZB = null;
    private s YD = null;
    private ArrayList YF = new ArrayList();
    private ArrayList YS = new ArrayList();
    private ah YT = null;
    private ah ZC = null;
    private int ZD = 1;
    private ArrayList YV = new ArrayList();
    private ArrayList YW = new ArrayList();

    public v() {
        this.F(4, 0);
        this.yo();
        this.yp();
    }

    private void yo() {
        this.YV.clear();
        this.YV.add(new am("ing", 97, 1));
        this.YV.add(new am("esp", 65, 1));
        this.YV.add(new am("ita", 104, 1));
        this.YV.add(new am("ale", 3, 1));
        this.YV.add(new am("fra", 72, 1));
        this.YV.add(new am("por", 154, 1));
        this.YV.add(new am("hol", 85, 1));
        this.YV.add(new am("bel", 21, 1));
        this.YV.add(new am("aut", 15, 1));
        this.YV.add(new am("esc", 62, 1));
        this.YV.add(new am("ucr", 193, 1));
        this.YV.add(new am("ing", 97, 1));
        this.YV.add(new am("esp", 65, 1));
        this.YV.add(new am("ita", 104, 1));
        this.YV.add(new am("ale", 3, 1));
        this.YV.add(new am("fra", 72, 1));
        this.YV.add(new am("por", 154, 1));
        this.YV.add(new am("ing", 97, 1));
        this.YV.add(new am("esp", 65, 1));
        this.YV.add(new am("ita", 104, 1));
        this.YV.add(new am("ale", 3, 1));
        this.YV.add(new am("ing", 97, 1));
        this.YV.add(new am("esp", 65, 1));
        this.YV.add(new am("ita", 104, 1));
    }

    private void yp() {
        this.YW.clear();
        this.YW.add(new am("tur", 192, 1));
        this.YW.add(new am("din", 54, 1));
        this.YW.add(new am("chipre", 44, 1));
        this.YW.add(new am("serv", 171, 1));
        this.YW.add(new am("hol", 85, 1));
        this.YW.add(new am("bel", 21, 1));
        this.YW.add(new am("aut", 15, 1));
        this.YW.add(new am("esc", 62, 1));
        this.YW.add(new am("fra", 72, 1));
        this.YW.add(new am("por", 154, 1));
        this.YW.add(new am("cze", 159, 1));
        this.YW.add(new am("cro", 52, 1));
        this.YW.add(new am("sui", 180, 1));
        this.YW.add(new am("gre", 78, 1));
        this.YW.add(new am("isr", 103, 1));
        this.YW.add(new am("ucr", 193, 1));
        this.YW.add(new am("tu", 192, 1));
        this.YW.add(new am("din", 54, 1));
        this.YW.add(new am("chipre", 44, 1));
        this.YW.add(new am("nor", 142, 1));
        this.YW.add(new am("sue", 179, 1));
        this.YW.add(new am("bul", 31, 1));
        this.YW.add(new am("rom", 160, 1));
        this.YW.add(new am("aze", 16, 1));
        this.YW.add(new am("caz", 40, 1));
        this.YW.add(new am("hun", 88, 1));
        this.YW.add(new am("belarus", 25, 1));
        this.YW.add(new am("pol", 152, 1));
        this.YW.add(new am("esl", 64, 1));
        this.YW.add(new am("esk", 63, 1));
        this.YW.add(new am("lit", 119, 1));
        this.YW.add(new am("lux", 120, 1));
        this.YW.add(new am("bos", 27, 1));
        this.YW.add(new am("irl", 100, 1));
        this.YW.add(new am("mac", 122, 1));
        this.YW.add(new am("arm", 12, 1));
        this.YW.add(new am("let", 114, 1));
        this.YW.add(new am("alb", 2, 1));
        this.YW.add(new am("irlN", 101, 1));
        this.YW.add(new am("geo", 76, 1));
        this.YW.add(new am("fin", 70, 1));
        this.YW.add(new am("mol", 134, 1));
        this.YW.add(new am("mlt", 128, 1));
        this.YW.add(new am("ifaroe", 92, 1));
        this.YW.add(new am("kos", 110, 1));
        this.YW.add(new am("gib", 216, 1));
        this.YW.add(new am("mnt", 105, 1));
        this.YW.add(new am("wal", 145, 1));
        this.YW.add(new am("isl", 102, 1));
        this.YW.add(new am("est", 66, 1));
        this.YW.add(new am("andorra", 4, 1));
        this.YW.add(new am("san m", 164, 1));
    }

    public void a(int n2, al al2) {
        b.a(0, 1, this.YV, this.YW, n2, al2);
    }

    private void Bd() {
        ((am)this.YV.get(8)).fE(192);
        ((am)this.YW.get(0)).fE(15);
        ((am)this.YW.get(43)).fE(102);
        ((am)this.YW.get(48)).fE(92);
        ((am)this.YW.get(2)).fE(162);
    }

    public void yq() {
        if (a.SR.H() == 3) {
            this.Bd();
        }
        ArrayList<am> arrayList = new ArrayList<am>();
        if (this.YD != null) {
            this.YD.aN(true);
        }
        this.YF.clear();
        this.YS.clear();
        this.YD = null;
        this.YJ = null;
        this.YP = null;
        this.YQ = null;
        this.YR = null;
        this.ZB = null;
        ah ah2 = null;
        if (a.SR.aK() != null) {
            ah2 = a.SR.aK().BA();
        }
        if (this.YT == null) {
            arrayList.add(new am("fra", 72, 1));
        } else {
            this.YF.add(this.YT);
        }
        if (this.ZC == null) {
            arrayList.add(new am("ale", 3, 1));
        } else if (this.ZC != this.YT) {
            this.YF.add(this.ZC);
        }
        if (this.YT != null && this.YT == this.ZC) {
            arrayList.add(new am("mesmo pais", this.YT.getPais(), 1));
        }
        ArrayList<ah> arrayList2 = new ArrayList<ah>();
        arrayList2.addAll(this.YF);
        arrayList2.addAll(this.YS);
        if (arrayList.size() > 0) {
            b.a(arrayList, this.YF, arrayList2, false);
        }
        b.a(this.YV, this.YF, arrayList2, false);
        if (a.SR.H() > 1 && ah2 != null) {
            arrayList2.add(ah2);
        }
        b.a(this.YW, this.YS, arrayList2, false);
        if (this.YF.size() < 26) {
            b.a(this.YF, this.YV, 26, arrayList2);
        }
        if (this.YS.size() < 52) {
            b.a(this.YS, this.YW, 52, arrayList2);
        }
        Collections.sort(this.YF, h.a.abm);
        if (this.YF.size() == 26 && this.YS.size() == 52) {
            ArrayList<ah> arrayList3 = new ArrayList<ah>();
            int n2 = 48;
            while (n2 <= 51) {
                arrayList3.add((ah)this.YS.get(n2));
                ++n2;
            }
            Collections.shuffle(arrayList3);
            boolean[] blArray = new boolean[7];
            this.YJ = new z(null, 4, this.b(), -1, blArray, this, 4000);
            G g2 = new G();
            g2.a(this.YJ, arrayList3, 0, false, 0, 0, this.b(), false);
        } else {
            System.out.println("erro Liga C() " + this.YF.size() + " " + this.YS.size());
        }
    }

    public void aj(ArrayList arrayList) {
        ArrayList<ah> arrayList2 = new ArrayList<ah>();
        int n2 = 48;
        while (n2 <= 51) {
            if (!arrayList.contains(this.YS.get(n2))) {
                arrayList2.add((ah)this.YS.get(n2));
                ((ah)this.YS.get(n2)).a(this, -1, 4000);
            }
            ++n2;
        }
        a.SR.mj().zo().addAll(arrayList2);
        a.SR.mj().b(arrayList2, 0);
        ArrayList<ah> arrayList3 = new ArrayList<ah>();
        ArrayList<ah> arrayList4 = new ArrayList<ah>();
        ArrayList<ah> arrayList5 = new ArrayList<ah>();
        int n3 = 19;
        while (n3 <= 33) {
            arrayList3.add((ah)this.YS.get(n3));
            ++n3;
        }
        n3 = 34;
        while (n3 <= 47) {
            arrayList4.add((ah)this.YS.get(n3));
            ++n3;
        }
        arrayList4.add((ah)arrayList.get(0));
        Collections.shuffle(arrayList3);
        Collections.shuffle(arrayList4);
        Random random = new Random();
        int n4 = 0;
        while (n4 < arrayList3.size()) {
            if (random.nextBoolean()) {
                arrayList5.add((ah)arrayList3.get(n4));
                arrayList5.add((ah)arrayList4.get(n4));
            } else {
                arrayList5.add((ah)arrayList4.get(n4));
                arrayList5.add((ah)arrayList3.get(n4));
            }
            ++n4;
        }
        boolean[] blArray = new boolean[]{true, true, true, true, true, true, true};
        this.YP = new z(null, 30, this.b(), 1, blArray, this, 4001);
        G g2 = new G();
        g2.a(this.YP, arrayList5, 0, blArray[0], 0, 0, this.b(), false);
    }

    public void g(ArrayList arrayList, ArrayList arrayList2) {
        int n2 = 0;
        while (n2 < arrayList2.size()) {
            ((ah)arrayList2.get(n2)).a(this, -1, 4001);
            ++n2;
        }
        ArrayList<ah> arrayList3 = new ArrayList<ah>();
        ArrayList<ah> arrayList4 = new ArrayList<ah>();
        ArrayList<ah> arrayList5 = new ArrayList<ah>();
        a.SR.mj().zo().addAll(arrayList2);
        a.SR.mj().b(arrayList2, 0);
        int n3 = 10;
        while (n3 <= 14) {
            arrayList3.add((ah)this.YS.get(n3));
            ++n3;
        }
        arrayList3.addAll(arrayList);
        n3 = 15;
        while (n3 <= 18) {
            arrayList4.add((ah)this.YS.get(n3));
            ++n3;
        }
        Collections.shuffle(arrayList3);
        Collections.shuffle(arrayList4);
        arrayList5.addAll(arrayList3);
        arrayList5.addAll(arrayList4);
        boolean[] blArray = new boolean[]{true, true, true, true, true, true, true};
        this.YQ = new z(null, 24, this.b(), 1, blArray, this, 4002);
        G g2 = new G();
        g2.a(this.YQ, arrayList5, 0, blArray[0], 0, 0, this.b(), false);
    }

    public void h(ArrayList arrayList, ArrayList arrayList2) {
        int n2 = 0;
        while (n2 < arrayList2.size()) {
            ((ah)arrayList2.get(n2)).a(this, -1, 4002);
            ++n2;
        }
        ArrayList<ah> arrayList3 = new ArrayList<ah>();
        ArrayList<ah> arrayList4 = new ArrayList<ah>();
        int n3 = 0;
        while (n3 <= 9) {
            arrayList3.add((ah)arrayList2.get(n3));
            ++n3;
        }
        Collections.shuffle(arrayList3);
        n3 = 10;
        while (n3 <= 11) {
            arrayList4.add((ah)arrayList2.get(n3));
            ++n3;
        }
        ArrayList<ah> arrayList5 = new ArrayList<ah>();
        arrayList5.addAll(arrayList3);
        arrayList5.addAll(arrayList4);
        a.SR.aK().b(arrayList5, 0);
        a.SR.aK().aj(arrayList5);
        ArrayList<ah> arrayList6 = new ArrayList<ah>();
        ArrayList<ah> arrayList7 = new ArrayList<ah>();
        ArrayList<ah> arrayList8 = new ArrayList<ah>();
        int n4 = 0;
        while (n4 <= 9) {
            arrayList6.add((ah)arrayList.get(n4));
            ++n4;
        }
        n4 = 2;
        while (n4 <= 3) {
            arrayList6.add((ah)this.YS.get(n4));
            ++n4;
        }
        Collections.shuffle(arrayList6);
        n4 = 4;
        while (n4 <= 9) {
            arrayList7.add((ah)this.YS.get(n4));
            ++n4;
        }
        n4 = 10;
        while (n4 <= 11) {
            arrayList7.add((ah)arrayList.get(n4));
            ++n4;
        }
        Collections.shuffle(arrayList7);
        arrayList8.addAll(arrayList6);
        arrayList8.addAll(arrayList7);
        boolean[] blArray = new boolean[]{true, true, true, true, true, true, true};
        this.YR = new z(null, 20, this.b(), 1, blArray, this, 4003);
        G g2 = new G();
        g2.a(this.YR, arrayList8, 0, blArray[0], 0, 0, this.b(), false);
    }

    public void j(ArrayList arrayList, ArrayList arrayList2) {
        int n2 = 0;
        while (n2 < arrayList2.size()) {
            ((ah)arrayList2.get(n2)).a(this, -1, 4003);
            ++n2;
        }
        a.SR.aK().zo().addAll(arrayList2);
        a.SR.aK().b(arrayList2, 0);
        ArrayList<ah> arrayList3 = new ArrayList<ah>();
        ArrayList<ah> arrayList4 = new ArrayList<ah>();
        ArrayList<ah> arrayList5 = new ArrayList<ah>();
        int n3 = 0;
        while (n3 <= 5) {
            arrayList3.add((ah)arrayList.get(n3));
            ++n3;
        }
        n3 = 0;
        while (n3 <= 1) {
            arrayList3.add((ah)this.YS.get(n3));
            ++n3;
        }
        Collections.shuffle(arrayList3);
        n3 = 6;
        while (n3 <= 9) {
            arrayList4.add((ah)arrayList.get(n3));
            ++n3;
        }
        Collections.shuffle(arrayList4);
        arrayList5.addAll(arrayList3);
        arrayList5.addAll(arrayList4);
        boolean[] blArray = new boolean[]{true, true, true, true, true, true, true};
        this.ZB = new z(null, 12, this.b(), 1, blArray, this, 4004);
        G g2 = new G();
        g2.a(this.ZB, arrayList5, 0, blArray[0], 0, 0, this.b(), false);
    }

    public void k(ArrayList arrayList, ArrayList arrayList2) {
        Serializable serializable;
        Object object;
        Object object2;
        int n2 = 0;
        while (n2 < arrayList2.size()) {
            ((ah)arrayList2.get(n2)).a(this, -1, 4004);
            ++n2;
        }
        a.SR.aK().zo().addAll(arrayList2);
        a.SR.aK().b(arrayList2, 0);
        this.YD = null;
        ArrayList arrayList3 = new ArrayList();
        if (this.YF.size() == 26) {
            object2 = new ArrayList();
            object = new ArrayList();
            serializable = new ArrayList<ah>();
            ArrayList<ah> arrayList4 = new ArrayList<ah>();
            components.aq[] aqArray = new components.aq[8];
            int n3 = 0;
            while (n3 <= 7) {
                aqArray[n3] = new components.aq();
                ++n3;
            }
            n3 = 0;
            while (n3 <= 7) {
                ((ArrayList)object2).add((ah)this.YF.get(n3));
                ++n3;
            }
            n3 = 8;
            while (n3 <= 15) {
                ((ArrayList)object).add((ah)this.YF.get(n3));
                ++n3;
            }
            n3 = 16;
            while (n3 <= 23) {
                ((ArrayList)serializable).add((ah)this.YF.get(n3));
                ++n3;
            }
            n3 = 24;
            while (n3 <= 25) {
                arrayList4.add((ah)this.YF.get(n3));
                ++n3;
            }
            arrayList4.addAll(arrayList);
            Collections.shuffle(object2);
            Collections.shuffle(object);
            Collections.shuffle(serializable);
            Collections.shuffle(arrayList4);
            n3 = 0;
            while (n3 <= 7) {
                aqArray[n3].a((ArrayList)object2, (ArrayList)object, (ArrayList)serializable, arrayList4);
                ++n3;
            }
            aqArray[0].a(aqArray);
            ArrayList<components.aq> arrayList5 = new ArrayList<components.aq>();
            int n4 = 0;
            while (n4 < aqArray.length) {
                arrayList5.add(aqArray[n4]);
                ++n4;
            }
            Collections.shuffle(arrayList5);
            n4 = 0;
            while (n4 <= 7) {
                arrayList3.addAll(((components.aq)arrayList5.get(n4)).cZ());
                ++n4;
            }
        }
        if (arrayList3.size() >= 32) {
            boolean[] blArray = new boolean[7];
            blArray[0] = true;
            blArray[1] = true;
            blArray[2] = true;
            object2 = blArray;
            object = new LoadLigaOptions();
            ((LoadLigaOptions)object).nTimes = 32;
            ((LoadLigaOptions)object).nGrupos = 8;
            ((LoadLigaOptions)object).numeroTimesMataMata = 2;
            ((LoadLigaOptions)object).doisTurnos = true;
            ((LoadLigaOptions)object).pulaDuasDatas = false;
            ((LoadLigaOptions)object).duasVoltasMataMata = (boolean[])object2;
            serializable = new s((LoadLigaOptions)object, arrayList3, 0, null, null, null, 4, null, false, null, true, this);
            ((s)serializable).fb(4005);
            this.YD = serializable;
            ((L)serializable).setNome(this.getNome());
        }
    }

    public void yt() {
        ArrayList<ah> arrayList = new ArrayList<ah>();
        ArrayList<ah> arrayList2 = new ArrayList<ah>();
        ArrayList arrayList3 = new ArrayList();
        ArrayList<ah> arrayList4 = new ArrayList<ah>();
        int n2 = 0;
        while (n2 < this.YD.yQ().size()) {
            arrayList.add((ah)((best.G)this.YD.yQ().get(n2)).gR().get(1));
            arrayList2.add((ah)((best.G)this.YD.yQ().get(n2)).gR().get(0));
            arrayList4.add((ah)((best.G)this.YD.yQ().get(n2)).gR().get(2));
            ++n2;
        }
        a.SR.aK().b(arrayList4, 1);
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
        this.YD.c(new z(this.YD, arrayList3.size(), this.b(), 0, blArray2, this, -1));
        G g2 = new G();
        g2.a(this.YD.yY(), arrayList3, 0, blArray2[0], 0, 0, this.b(), false);
    }

    public ArrayList yy() {
        return this.YF;
    }

    public void S(ah ah2) {
        this.YT = ah2;
    }

    public ArrayList yE() {
        return this.YS;
    }

    public ah zm() {
        return this.ZC;
    }

    public void T(ah ah2) {
        this.ZC = ah2;
    }

    public int zn() {
        return this.ZD;
    }

    public s yd() {
        return this.YD;
    }

    public ah yz() {
        return this.YT;
    }

    public void N(ah ah2) {
        this.YT = ah2;
    }

    public z yC() {
        return this.YJ;
    }

    @Override
    public void mr() {
        this.YD.za();
    }

    @Override
    public Z mF() {
        int n2 = a.SR.H() - 1;
        int[] nArray = new int[]{192, 162, 3, 104, 154, 97, 72, 152, 65, 52};
        if ((n2 %= 10) < nArray.length) {
            return a.SR.s(nArray[n2]);
        }
        return null;
    }

    public static String yD() {
        int n2 = a.SR.H() - 1;
        String string = "";
        String[] stringArray = new String[]{"Istambul", "S\u00e3o Petersburgo", "Munique", "Roma", "Lisboa", "Londres", "Paris", "Vars\u00f3via", "Madrid", "Zagreb"};
        string = stringArray[n2 %= 10];
        return string;
    }

    @Override
    public L[] mB() {
        L[] lArray = new L[]{this.YD};
        if (this.YD == null) {
            L[] lArray2 = new L[]{this.YJ, this.YP, this.YQ, this.YR, this.ZB};
            lArray = lArray2;
        } else if (this.YD.yZ()) {
            L[] lArray3 = new L[]{this.YD.yY()};
            lArray = lArray3;
        }
        return lArray;
    }

    @Override
    public ArrayList mC() {
        ArrayList<y> arrayList = new ArrayList<y>();
        L[] lArray = new L[]{this.YJ, this.YP, this.YQ, this.YR, this.ZB};
        arrayList.add(new y(lArray, "Fase Preliminar"));
        L[] lArray2 = new L[]{this.YD};
        arrayList.add(new y(lArray2, "Fase de Grupos"));
        if (this.YD != null) {
            L[] lArray3 = new L[]{this.YD.yY()};
            arrayList.add(new y(lArray3, "Fase Final"));
        } else {
            arrayList.add(new y(null, "Fase Final"));
        }
        return arrayList;
    }

    @Override
    public String[] b(L l2) {
        if (l2 == this.YJ) {
            return aq.pH;
        }
        if (l2 == this.YP) {
            return aq.pI;
        }
        if (l2 == this.YQ) {
            return aq.pJ;
        }
        if (l2 == this.YR) {
            return aq.pK;
        }
        if (l2 == this.ZB) {
            return aq.pL;
        }
        return aq.pA;
    }

    @Override
    public String[] mA() {
        String[] stringArray = new String[]{"", ""};
        stringArray[0] = "tr_ligacampeoes";
        stringArray[1] = this.getNome();
        return stringArray;
    }

    @Override
    public boolean cz(int n2) {
        return this.YD != null && this.YD.yY() != null && this.YD.yY().zq() == n2;
    }
}

