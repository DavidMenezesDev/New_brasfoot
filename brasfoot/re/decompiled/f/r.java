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

public class r
extends at
implements Serializable {
    private static final long serialVersionUID = 1L;
    private z YP = null;
    private z YQ = null;
    private z YR = null;
    private s YD = null;
    private ArrayList YF = new ArrayList();
    private ArrayList YS = new ArrayList();
    private ah YT = null;
    private ah YU = null;
    private ArrayList YV = new ArrayList();
    private ArrayList YW = new ArrayList();
    private boolean YX = false;

    public r() {
        this.F(4, 1);
        this.yo();
        this.yp();
    }

    private void yo() {
        this.YV.clear();
        this.YV.add(new am("bra", 29, 5, true));
        this.YV.add(new am("arg", 11, 5, true));
        this.YV.add(new am("uru", 195, 2));
        this.YV.add(new am("par", 150, 2));
        this.YV.add(new am("chil", 42, 2));
        this.YV.add(new am("col", 46, 2));
        this.YV.add(new am("equ", 60, 2));
        this.YV.add(new am("per", 151, 2));
        this.YV.add(new am("bol", 26, 2));
        this.YV.add(new am("ven", 198, 2));
    }

    private void yp() {
        this.YW.clear();
        this.YW.add(new am("bol", 26, 1));
        this.YW.add(new am("equ", 60, 1));
        this.YW.add(new am("par", 150, 1));
        this.YW.add(new am("per", 151, 1));
        this.YW.add(new am("uru", 195, 1));
        this.YW.add(new am("vez", 198, 1));
        this.YW.add(new am("arg", 11, 1));
        this.YW.add(new am("bol", 26, 1));
        this.YW.add(new am("bra", 29, 1));
        this.YW.add(new am("bra", 29, 1));
        this.YW.add(new am("chil", 42, 1));
        this.YW.add(new am("chil", 42, 1));
        this.YW.add(new am("col", 46, 1));
        this.YW.add(new am("col", 46, 1));
        this.YW.add(new am("equ", 60, 1));
        this.YW.add(new am("par", 150, 1));
        this.YW.add(new am("per", 151, 1));
        this.YW.add(new am("uru", 195, 1));
        this.YW.add(new am("vez", 198, 1));
    }

    public void a(int n2, al al2) {
        b.a(1, 1, this.YV, this.YW, n2, al2);
    }

    public void yq() {
        if (a.SR.H() == 1 && a.SR.isGruposIntPadrao() && this.yv() && this.yu()) {
            this.YX = true;
            this.yr();
        } else {
            this.YX = false;
            this.ys();
        }
    }

    private void yr() {
        int n2;
        ArrayList<ah> arrayList = new ArrayList<ah>();
        ArrayList<ah> arrayList2 = new ArrayList<ah>();
        int n3 = 0;
        while (n3 < aq.sP.length) {
            n2 = 0;
            while (n2 < a.SR.P().size()) {
                if (((ah)a.SR.P().get(n2)).jY().equals(aq.sP[n3])) {
                    arrayList.add((ah)a.SR.P().get(n2));
                    break;
                }
                ++n2;
            }
            ++n3;
        }
        this.YS.addAll(arrayList);
        n3 = 0;
        while (n3 < aq.sQ.length) {
            n2 = 0;
            while (n2 < a.SR.P().size()) {
                if (((ah)a.SR.P().get(n2)).jY().equals(aq.sQ[n3])) {
                    arrayList2.add((ah)a.SR.P().get(n2));
                    break;
                }
                ++n2;
            }
            ++n3;
        }
        this.YF.addAll(arrayList2);
        ArrayList<ah> arrayList3 = new ArrayList<ah>();
        n2 = 0;
        while (n2 <= 5) {
            arrayList3.add((ah)this.YS.get(n2));
            ++n2;
        }
        boolean[] blArray = new boolean[7];
        blArray[0] = true;
        blArray[1] = true;
        blArray[2] = true;
        boolean[] blArray2 = blArray;
        this.YP = new z(null, arrayList3.size(), this.b(), 1, blArray2, this, 4101);
        G g2 = new G();
        g2.a(this.YP, arrayList3, 0, true, 0, 0, this.b(), false);
    }

    public void ys() {
        ArrayList<am> arrayList = new ArrayList<am>();
        if (this.YD != null) {
            this.YD.aN(true);
        }
        this.YF.clear();
        this.YS.clear();
        this.YD = null;
        this.YP = null;
        this.YQ = null;
        this.YR = null;
        if (this.YT == null) {
            arrayList.add(new am("bra", 29, 1));
        } else {
            this.YF.add(this.YT);
        }
        if (this.YU == null) {
            arrayList.add(new am("arg", 11, 1));
        } else if (this.YU != this.YT) {
            this.YF.add(this.YU);
        }
        if (this.YT != null && this.YT == this.YU) {
            arrayList.add(new am("mesmo pais", this.YT.getPais(), 1));
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(this.YF);
        arrayList2.addAll(this.YS);
        b.a(arrayList, this.YF, arrayList2, false);
        b.a(this.YV, this.YF, arrayList2, false);
        b.a(this.YW, this.YS, arrayList2, false);
        if (this.YF.size() < 28) {
            b.a(this.YF, this.YV, 28, arrayList2);
        }
        if (this.YS.size() < 19) {
            b.a(this.YS, this.YW, 19, arrayList2);
        }
        Collections.sort(this.YF, h.a.abm);
        if (this.YS.size() == 19 && this.YF.size() == 28) {
            ArrayList<ah> arrayList3 = new ArrayList<ah>();
            int n2 = 0;
            while (n2 <= 5) {
                arrayList3.add((ah)this.YS.get(n2));
                ++n2;
            }
            this.ah(arrayList3);
        } else {
            System.out.println("erro Libertadores() " + this.YF.size() + " " + this.YS.size());
        }
    }

    public void ae(ArrayList arrayList) {
        ArrayList<ah> arrayList2 = new ArrayList<ah>();
        arrayList2.add((ah)arrayList.get(0));
        arrayList2.add((ah)this.YS.get(6));
        arrayList2.add((ah)this.YS.get(7));
        arrayList2.add((ah)this.YS.get(8));
        arrayList2.add((ah)this.YS.get(9));
        arrayList2.add((ah)this.YS.get(10));
        arrayList2.add((ah)this.YS.get(11));
        arrayList2.add((ah)this.YS.get(12));
        arrayList2.add((ah)this.YS.get(13));
        arrayList2.add((ah)this.YS.get(14));
        arrayList2.add((ah)arrayList.get(1));
        arrayList2.add((ah)this.YS.get(15));
        arrayList2.add((ah)this.YS.get(16));
        arrayList2.add((ah)this.YS.get(17));
        arrayList2.add((ah)this.YS.get(18));
        arrayList2.add((ah)arrayList.get(2));
        boolean[] blArray = new boolean[7];
        blArray[0] = true;
        boolean[] blArray2 = blArray;
        this.YQ = new z(null, arrayList2.size(), this.b(), 1, blArray2, this, 4102);
        G g2 = new G();
        g2.a(this.YQ, arrayList2, 0, true, 0, 0, this.b(), false);
    }

    public void af(ArrayList arrayList) {
        ArrayList<ah> arrayList2 = new ArrayList<ah>();
        arrayList2.add((ah)arrayList.get(0));
        arrayList2.add((ah)arrayList.get(7));
        arrayList2.add((ah)arrayList.get(1));
        arrayList2.add((ah)arrayList.get(6));
        arrayList2.add((ah)arrayList.get(2));
        arrayList2.add((ah)arrayList.get(5));
        arrayList2.add((ah)arrayList.get(3));
        arrayList2.add((ah)arrayList.get(4));
        boolean[] blArray = new boolean[7];
        blArray[0] = true;
        boolean[] blArray2 = blArray;
        this.YR = new z(null, arrayList2.size(), this.b(), 1, blArray2, this, 4103);
        G g2 = new G();
        g2.a(this.YR, arrayList2, 0, true, 0, 0, this.b(), false);
    }

    public void g(ArrayList arrayList, ArrayList arrayList2) {
        int n2 = 0;
        while (n2 < arrayList2.size()) {
            ((ah)arrayList2.get(n2)).a(this, -1, 4101);
            ++n2;
        }
        if (a.SR.H() == 1 && this.YX) {
            this.ae(arrayList);
        } else {
            ArrayList<ah> arrayList3 = new ArrayList<ah>();
            ArrayList arrayList4 = new ArrayList();
            ArrayList<ah> arrayList5 = new ArrayList<ah>();
            ArrayList<ah> arrayList6 = new ArrayList<ah>();
            int n3 = 6;
            while (n3 <= 18) {
                arrayList3.add((ah)this.YS.get(n3));
                ++n3;
            }
            arrayList3.addAll(arrayList);
            Collections.sort(arrayList3, h.a.abm);
            n3 = 0;
            while (n3 <= 7) {
                arrayList5.add((ah)arrayList3.get(n3));
                ++n3;
            }
            n3 = 8;
            while (n3 <= 15) {
                arrayList6.add((ah)arrayList3.get(n3));
                ++n3;
            }
            Collections.shuffle(arrayList5);
            Collections.shuffle(arrayList6);
            components.aq[] aqArray = new components.aq[8];
            int n4 = 0;
            while (n4 <= 7) {
                aqArray[n4] = new components.aq();
                ++n4;
            }
            n4 = 0;
            while (n4 <= 7) {
                aqArray[n4].e(arrayList5, arrayList6);
                ++n4;
            }
            aqArray[0].a(aqArray);
            n4 = 0;
            while (n4 <= 7) {
                arrayList4.addAll(aqArray[n4].cZ());
                ++n4;
            }
            boolean[] blArray = new boolean[7];
            blArray[0] = true;
            boolean[] blArray2 = blArray;
            this.YQ = new z(null, arrayList4.size(), this.b(), 1, blArray2, this, 4102);
            G g2 = new G();
            g2.a(this.YQ, arrayList4, 0, true, 0, 0, this.b(), false);
        }
    }

    public void h(ArrayList arrayList, ArrayList arrayList2) {
        int n2 = 0;
        while (n2 < arrayList2.size()) {
            ((ah)arrayList2.get(n2)).a(this, -1, 4102);
            ++n2;
        }
        if (a.SR.H() == 1 && this.YX) {
            this.af(arrayList);
        } else {
            ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(arrayList);
            boolean[] blArray = new boolean[7];
            blArray[0] = true;
            boolean[] blArray2 = blArray;
            this.YR = new z(null, arrayList3.size(), this.b(), 1, blArray2, this, 4103);
            G g2 = new G();
            g2.a(this.YR, arrayList3, 0, true, 0, 0, this.b(), false);
        }
    }

    private void a(ArrayList arrayList, ArrayList arrayList2, int n2, int n3, int n4) {
        int n5 = n2;
        while (n5 <= n3) {
            arrayList.add((ah)this.YF.get(n5));
            ++n5;
        }
        if (n4 >= 0) {
            arrayList.add((ah)arrayList2.get(n4));
        }
    }

    private void ag(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        this.a(arrayList2, arrayList, 0, 2, 1);
        this.a(arrayList2, arrayList, 3, 6, -1);
        this.a(arrayList2, arrayList, 7, 9, 3);
        this.a(arrayList2, arrayList, 10, 12, 2);
        this.a(arrayList2, arrayList, 13, 16, -1);
        this.a(arrayList2, arrayList, 17, 19, 0);
        this.a(arrayList2, arrayList, 20, 23, -1);
        this.a(arrayList2, arrayList, 24, 27, -1);
        boolean[] blArray = new boolean[7];
        blArray[0] = true;
        blArray[1] = true;
        blArray[2] = true;
        boolean[] blArray2 = blArray;
        LoadLigaOptions loadLigaOptions = new LoadLigaOptions();
        loadLigaOptions.nTimes = 32;
        loadLigaOptions.nGrupos = 8;
        loadLigaOptions.numeroTimesMataMata = 2;
        loadLigaOptions.doisTurnos = true;
        loadLigaOptions.pulaDuasDatas = false;
        loadLigaOptions.duasVoltasMataMata = blArray2;
        s s2 = new s(loadLigaOptions, arrayList2, 0, null, null, null, 4, null, false, null, true, this);
        s2.fb(4104);
        this.YD = s2;
        s2.setNome(this.getNome());
    }

    public void i(ArrayList arrayList, ArrayList arrayList2) {
        int n2 = 0;
        while (n2 < arrayList2.size()) {
            ((ah)arrayList2.get(n2)).a(this, -1, 4103);
            ++n2;
        }
        a.SR.aH().Aa().addAll(arrayList2);
        a.SR.aH().c(arrayList2, 0);
        if (a.SR.H() == 1 && this.YX) {
            this.ag(arrayList);
        } else {
            ArrayList arrayList3 = new ArrayList();
            ArrayList<ah> arrayList4 = new ArrayList<ah>();
            ArrayList<ah> arrayList5 = new ArrayList<ah>();
            ArrayList<ah> arrayList6 = new ArrayList<ah>();
            ArrayList<ah> arrayList7 = new ArrayList<ah>();
            components.aq[] aqArray = new components.aq[8];
            int n3 = 0;
            while (n3 <= 7) {
                aqArray[n3] = new components.aq();
                ++n3;
            }
            n3 = 0;
            while (n3 <= 7) {
                arrayList4.add((ah)this.YF.get(n3));
                ++n3;
            }
            n3 = 8;
            while (n3 <= 15) {
                arrayList5.add((ah)this.YF.get(n3));
                ++n3;
            }
            n3 = 16;
            while (n3 <= 23) {
                arrayList6.add((ah)this.YF.get(n3));
                ++n3;
            }
            n3 = 24;
            while (n3 <= 27) {
                arrayList7.add((ah)this.YF.get(n3));
                ++n3;
            }
            arrayList7.addAll(arrayList);
            Collections.shuffle(arrayList4);
            Collections.shuffle(arrayList5);
            Collections.shuffle(arrayList6);
            Collections.shuffle(arrayList7);
            n3 = 0;
            while (n3 <= 7) {
                aqArray[n3].a(arrayList4, arrayList5, arrayList6, arrayList7);
                ++n3;
            }
            aqArray[0].a(aqArray);
            ArrayList<components.aq> arrayList8 = new ArrayList<components.aq>();
            int n4 = 0;
            while (n4 < aqArray.length) {
                arrayList8.add(aqArray[n4]);
                ++n4;
            }
            Collections.shuffle(arrayList8);
            n4 = 0;
            while (n4 <= 7) {
                arrayList3.addAll(((components.aq)arrayList8.get(n4)).cZ());
                ++n4;
            }
            if (arrayList3.size() >= 32) {
                boolean[] blArray = new boolean[7];
                blArray[0] = true;
                blArray[1] = true;
                blArray[2] = true;
                boolean[] blArray2 = blArray;
                LoadLigaOptions loadLigaOptions = new LoadLigaOptions();
                loadLigaOptions.nTimes = 32;
                loadLigaOptions.nGrupos = 8;
                loadLigaOptions.numeroTimesMataMata = 2;
                loadLigaOptions.doisTurnos = true;
                loadLigaOptions.pulaDuasDatas = false;
                loadLigaOptions.duasVoltasMataMata = blArray2;
                s s2 = new s(loadLigaOptions, arrayList3, 0, null, null, null, 4, null, false, null, true, this);
                s2.fb(4104);
                this.YD = s2;
                s2.setNome(this.getNome());
            }
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
        a.SR.aH().c(arrayList4, 1);
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
            aqArray[n3].f(arrayList, arrayList2);
            ++n3;
        }
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

    public boolean ah(ArrayList arrayList) {
        Collections.shuffle(arrayList);
        boolean[] blArray = new boolean[7];
        blArray[0] = true;
        blArray[1] = true;
        blArray[2] = true;
        boolean[] blArray2 = blArray;
        this.YP = new z(null, arrayList.size(), this.b(), 1, blArray2, this, 4101);
        G g2 = new G();
        g2.a(this.YP, arrayList, 0, true, 0, 0, this.b(), false);
        return true;
    }

    public boolean yu() {
        int n2 = 0;
        int n3 = 0;
        while (n3 < aq.sQ.length) {
            int n4 = 0;
            while (n4 < a.SR.P().size()) {
                if (((ah)a.SR.P().get(n4)).jY().equals(aq.sQ[n3])) {
                    ++n2;
                    break;
                }
                ++n4;
            }
            ++n3;
        }
        return n2 == 28;
    }

    public boolean yv() {
        int n2 = 0;
        int n3 = 0;
        while (n3 < aq.sP.length) {
            int n4 = 0;
            while (n4 < a.SR.P().size()) {
                if (((ah)a.SR.P().get(n4)).jY().equals(aq.sP[n3])) {
                    ++n2;
                    break;
                }
                ++n4;
            }
            ++n3;
        }
        return n2 == 19;
    }

    public ArrayList yw() {
        ArrayList<ah> arrayList = new ArrayList<ah>();
        int n2 = 0;
        int n3 = 0;
        while (n3 < aq.sQ.length) {
            int n4 = 0;
            while (n4 < a.SR.P().size()) {
                if (aq.sQ[n3].length() > 1 && ((ah)a.SR.P().get(n4)).jY().equals(aq.sQ[n3]) && ((ah)a.SR.P().get(n4)).gg() == 1) {
                    ++n2;
                    arrayList.add((ah)a.SR.P().get(n4));
                    break;
                }
                ++n4;
            }
            ++n3;
        }
        return arrayList;
    }

    public ah yx() {
        if (this.YD.yY() != null) {
            int n2 = this.YD.yY().zp().size() - 1;
            while (n2 >= 0) {
                int n3 = 0;
                while (n3 < ((G)this.YD.yY().zp().get(n2)).zY().size()) {
                    if (((ah)((G)this.YD.yY().zp().get(n2)).zY().get(n3)).getPais() != 131) {
                        return (ah)((G)this.YD.yY().zp().get(n2)).zY().get(n3);
                    }
                    ++n3;
                }
                --n2;
            }
        }
        return null;
    }

    public ArrayList yy() {
        return this.YF;
    }

    public ah yz() {
        return this.YT;
    }

    public void N(ah ah2) {
        this.YT = ah2;
    }

    public ah yA() {
        return this.YU;
    }

    public void O(ah ah2) {
        this.YU = ah2;
    }

    public ArrayList yB() {
        return this.YS;
    }

    public static ArrayList yc() {
        ArrayList<String> arrayList = new ArrayList<String>();
        String[] stringArray = new String[]{"8\u00aa melhor 2\u00ba", "melhor 1\u00ba", "melhor 2\u00ba", "8\u00aa melhor 1\u00ba", "5\u00aa melhor 2\u00ba", "4\u00ba melhor 1\u00ba", "4\u00ba melhor 2\u00ba", "5\u00ba melhor 1\u00ba", "7\u00aa melhor 2\u00ba", "2\u00ba melhor 1\u00ba", "2\u00ba melhor 2\u00ba", "7\u00ba melhor 1\u00ba", "6\u00aa melhor 2\u00ba", "3\u00ba melhor 1\u00ba", "3\u00ba melhor 2\u00ba", "6\u00ba melhor 1\u00ba"};
        int n2 = 0;
        while (n2 < stringArray.length) {
            arrayList.add(stringArray[n2]);
            ++n2;
        }
        return arrayList;
    }

    @Override
    public void mr() {
        this.YD.za();
    }

    public s yd() {
        return this.YD;
    }

    public z yC() {
        return this.YP;
    }

    @Override
    public Z mF() {
        int n2 = a.SR.H() - 1;
        int[] nArray = new int[]{42, 11, 29, 46, 150, 195, 26, 198, 60, 151};
        if ((n2 %= 10) < nArray.length) {
            return a.SR.s(nArray[n2]);
        }
        return null;
    }

    public static String yD() {
        int n2 = a.SR.H() - 1;
        String string = "";
        String[] stringArray = new String[]{"Santiago", "Buenos Aires", "Rio de Janeiro", "Bogot\u00e1", "Assunci\u00f3n", "Montevid\u00e9u", "La Paz", "Caracas", "Quito", "Lima"};
        string = stringArray[n2 %= 10];
        return string;
    }

    @Override
    public L[] mB() {
        L[] lArray = new L[]{this.YD};
        if (this.YD == null) {
            L[] lArray2 = new L[]{this.YP, this.YQ, this.YR};
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
        L[] lArray = new L[]{this.YP, this.YQ, this.YR};
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
        if (l2 == this.YP) {
            return aq.pR;
        }
        if (l2 == this.YQ) {
            return aq.pS;
        }
        if (l2 == this.YR) {
            return aq.pT;
        }
        return aq.pA;
    }

    @Override
    public String[] mA() {
        String[] stringArray = new String[]{"", ""};
        stringArray[0] = "tr_libertadores";
        stringArray[1] = this.getNome();
        return stringArray;
    }

    public ArrayList yE() {
        return this.YS;
    }

    @Override
    public boolean cz(int n2) {
        return this.YD != null && this.YD.yY() != null && this.YD.yY().zq() == n2;
    }
}

