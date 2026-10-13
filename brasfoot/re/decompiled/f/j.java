/*
 * Decompiled with CFR 0.152.
 */
package f;

import best.L;
import best.Z;
import best.ah;
import best.at;
import c.a;
import components.y;
import est.LoadLigaOptions;
import f.G;
import f.s;
import f.z;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class j
extends at
implements Serializable {
    private static final long serialVersionUID = 1L;
    private s YD = null;
    private s afX = null;
    private z YJ = null;
    private z afY = null;
    private ArrayList YF = new ArrayList();
    private s afZ = null;
    private ah aga = null;

    public j() {
        this.F(9, 3);
    }

    public void xZ() {
        if (this.YD != null) {
            this.YD.aN(true);
        }
        this.afZ = null;
        this.YD = null;
        this.YJ = null;
        this.afX = null;
        this.afY = null;
        this.aga = null;
        this.YF.clear();
    }

    public void Bj() {
        ArrayList<Z> arrayList = new ArrayList<Z>();
        ArrayList<ah> arrayList2 = new ArrayList<ah>();
        ArrayList<ah> arrayList3 = new ArrayList<ah>();
        int n2 = 0;
        while (n2 < a.SR.aG().size()) {
            if (((Z)a.SR.aG().get(n2)).jo() != null && ((Z)a.SR.aG().get(n2)).gg() == 3) {
                arrayList.add((Z)a.SR.aG().get(n2));
            }
            ++n2;
        }
        Collections.sort(arrayList, Z.cN);
        n2 = 0;
        while (n2 < arrayList.size()) {
            arrayList2.add(((Z)arrayList.get(n2)).jo());
            ++n2;
        }
        n2 = 0;
        while (n2 <= 33) {
            this.YF.add((ah)arrayList2.get(n2));
            ++n2;
        }
        ArrayList<ah> arrayList4 = new ArrayList<ah>();
        ArrayList<ah> arrayList5 = new ArrayList<ah>();
        int n3 = 34;
        while (n3 <= 39) {
            arrayList4.add((ah)arrayList2.get(n3));
            ++n3;
        }
        n3 = 40;
        while (n3 <= 45) {
            arrayList5.add((ah)arrayList2.get(n3));
            ++n3;
        }
        n3 = 0;
        while (n3 < arrayList4.size()) {
            arrayList3.add((ah)arrayList4.get(n3));
            arrayList3.add((ah)arrayList5.get(n3));
            ++n3;
        }
        n3 = 0;
        while (n3 < this.YF.size()) {
            a.SR.s(((ah)this.YF.get(n3)).getPais()).z(true);
            ++n3;
        }
        n3 = 0;
        while (n3 < arrayList3.size()) {
            a.SR.s(((ah)arrayList3.get(n3)).getPais()).z(true);
            ++n3;
        }
        boolean[] blArray = new boolean[]{true, true, true, true, true, true, true};
        this.YJ = new z(null, arrayList3.size(), this.b(), 1, blArray, this, 9300);
        G g2 = new G();
        g2.a(this.YJ, arrayList3, 0, blArray[0], 0, 0, this.b(), false);
        a.afQ.L(arrayList3);
        a.afQ.L(this.YF);
    }

    public void aw(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(arrayList);
        arrayList2.addAll(this.YF);
        Collections.sort(arrayList2, h.a.abm);
        ArrayList<ah> arrayList3 = new ArrayList<ah>();
        ArrayList<ah> arrayList4 = new ArrayList<ah>();
        ArrayList<ah> arrayList5 = new ArrayList<ah>();
        ArrayList<ah> arrayList6 = new ArrayList<ah>();
        ArrayList<ah> arrayList7 = new ArrayList<ah>();
        int n2 = 0;
        while (n2 <= 7) {
            arrayList3.add((ah)arrayList2.get(n2));
            ++n2;
        }
        n2 = 8;
        while (n2 <= 15) {
            arrayList4.add((ah)arrayList2.get(n2));
            ++n2;
        }
        n2 = 16;
        while (n2 <= 23) {
            arrayList5.add((ah)arrayList2.get(n2));
            ++n2;
        }
        n2 = 24;
        while (n2 <= 31) {
            arrayList6.add((ah)arrayList2.get(n2));
            ++n2;
        }
        n2 = 32;
        while (n2 <= 39) {
            arrayList7.add((ah)arrayList2.get(n2));
            ++n2;
        }
        Collections.shuffle(arrayList3);
        Collections.shuffle(arrayList4);
        Collections.shuffle(arrayList5);
        Collections.shuffle(arrayList6);
        Collections.shuffle(arrayList7);
        ArrayList<ah> arrayList8 = new ArrayList<ah>();
        int n3 = 0;
        while (n3 <= 7) {
            arrayList8.add((ah)arrayList3.get(n3));
            arrayList8.add((ah)arrayList4.get(n3));
            arrayList8.add((ah)arrayList5.get(n3));
            arrayList8.add((ah)arrayList6.get(n3));
            arrayList8.add((ah)arrayList7.get(n3));
            ++n3;
        }
        if (arrayList8.size() == 40) {
            boolean[] blArray = new boolean[7];
            blArray[0] = true;
            blArray[1] = true;
            blArray[2] = true;
            blArray[3] = true;
            boolean[] blArray2 = blArray;
            LoadLigaOptions loadLigaOptions = new LoadLigaOptions();
            loadLigaOptions.nTimes = 40;
            loadLigaOptions.nGrupos = 8;
            loadLigaOptions.doisTurnos = true;
            loadLigaOptions.pulaDuasDatas = false;
            loadLigaOptions.duasVoltasMataMata = blArray2;
            s s2 = new s(loadLigaOptions, arrayList8, 0, null, null, null, this.b(), null, false, null, true, this);
            s2.fb(9301);
            this.YD = s2;
            s2.setNome(this.getNome());
        }
    }

    public void yt() {
        ArrayList<ah> arrayList = new ArrayList<ah>();
        ArrayList<ah> arrayList2 = new ArrayList<ah>();
        ArrayList<ah> arrayList3 = new ArrayList<ah>();
        int n2 = 0;
        while (n2 < this.YD.yQ().size()) {
            arrayList.add((ah)((best.G)this.YD.yQ().get(n2)).gR().get(0));
            ++n2;
        }
        n2 = 0;
        while (n2 < this.YD.yQ().size()) {
            arrayList3.add((ah)((best.G)this.YD.yQ().get(n2)).gR().get(1));
            ++n2;
        }
        s.r(this.YD);
        Collections.sort(arrayList3, h.a.abn);
        n2 = 0;
        while (n2 <= 3) {
            arrayList.add((ah)arrayList3.get(n2));
            ++n2;
        }
        Collections.sort(arrayList, h.a.cN);
        ArrayList<ah> arrayList4 = new ArrayList<ah>();
        ArrayList<ah> arrayList5 = new ArrayList<ah>();
        int n3 = 0;
        while (n3 <= 5) {
            arrayList4.add((ah)arrayList.get(n3));
            ++n3;
        }
        n3 = 6;
        while (n3 <= 11) {
            arrayList5.add((ah)arrayList.get(n3));
            ++n3;
        }
        n3 = 0;
        while (n3 < arrayList4.size()) {
            arrayList2.add((ah)arrayList4.get(n3));
            arrayList2.add((ah)arrayList5.get(n3));
            ++n3;
        }
        if (arrayList2.size() == 12) {
            boolean[] blArray = new boolean[7];
            blArray[0] = true;
            blArray[1] = true;
            blArray[2] = true;
            blArray[3] = true;
            boolean[] blArray2 = blArray;
            LoadLigaOptions loadLigaOptions = new LoadLigaOptions();
            loadLigaOptions.nTimes = 12;
            loadLigaOptions.nGrupos = 2;
            loadLigaOptions.doisTurnos = true;
            loadLigaOptions.pulaDuasDatas = false;
            loadLigaOptions.duasVoltasMataMata = blArray2;
            s s2 = new s(loadLigaOptions, arrayList2, 0, null, null, null, this.b(), null, false, null, true, this);
            s2.fb(9302);
            this.afX = s2;
            s2.setNome(this.getNome());
        }
    }

    public void Bm() {
        int n2 = 0;
        while (n2 < this.afX.yQ().size()) {
            a.SR.aY().a(this, a.SR.s(((ah)((best.G)this.afX.yQ().get(n2)).gR().get(0)).getPais()));
            a.SR.aY().a(this, a.SR.s(((ah)((best.G)this.afX.yQ().get(n2)).gR().get(1)).getPais()));
            a.SR.aY().a(this, a.SR.s(((ah)((best.G)this.afX.yQ().get(n2)).gR().get(2)).getPais()));
            a.SR.aY().a(this, a.SR.s(((ah)((best.G)this.afX.yQ().get(n2)).gR().get(3)).getPais()));
            ++n2;
        }
        ArrayList<ah> arrayList = new ArrayList<ah>();
        arrayList.add((ah)((best.G)this.afX.yQ().get(0)).gR().get(4));
        arrayList.add((ah)((best.G)this.afX.yQ().get(1)).gR().get(4));
        boolean[] blArray = new boolean[7];
        blArray[4] = true;
        blArray[5] = true;
        blArray[6] = true;
        boolean[] blArray2 = blArray;
        this.afY = new z(null, arrayList.size(), this.b(), 1, blArray2, this, 9303);
        G g2 = new G();
        g2.a(this.afY, arrayList, 0, blArray2[0], 0, 0, this.b(), false);
    }

    public void ax(ArrayList arrayList) {
        ArrayList<ah> arrayList2 = new ArrayList<ah>();
        arrayList2.add(a.SR.bK().Br());
        arrayList2.add((ah)arrayList.get(0));
        arrayList2.add(a.SR.bR().Bl());
        arrayList2.add(this.aga);
        arrayList2.add(a.SR.bM().Bl());
        arrayList2.add(a.SR.bS().Br());
        LoadLigaOptions loadLigaOptions = new LoadLigaOptions();
        loadLigaOptions.nTimes = 6;
        loadLigaOptions.doisTurnos = false;
        s s2 = new s(loadLigaOptions, arrayList2, 0, null, null, null, this.b(), null, false, null, true, this);
        s2.fb(7701);
        this.afZ = s2;
        s2.setNome("Eliminat\u00f3rias - Repescagem");
    }

    public void Bn() {
        int n2 = 0;
        while (n2 <= 1) {
            a.SR.aY().a(this, a.SR.s(((ah)this.Bo().yK().get(n2)).getPais()));
            ++n2;
        }
    }

    public static ArrayList yc() {
        ArrayList<String> arrayList = new ArrayList<String>();
        String[] stringArray = new String[]{"Sorteio 1", "Sorteio 2", "Sorteio 3", "Sorteio 4", "Sorteio 5", "Sorteio 6", "Sorteio 7", "Sorteio 8"};
        int n2 = 0;
        while (n2 < stringArray.length) {
            arrayList.add(stringArray[n2]);
            ++n2;
        }
        return arrayList;
    }

    public s yd() {
        return this.YD;
    }

    public void p(s s2) {
        this.YD = s2;
    }

    @Override
    public L[] mB() {
        L[] lArray = new L[]{this.YJ};
        if (this.afZ != null) {
            L[] lArray2 = new L[]{this.afZ};
            lArray = lArray2;
        } else if (this.afX != null) {
            L[] lArray3 = new L[]{this.afX};
            lArray = lArray3;
        } else if (this.YD != null) {
            L[] lArray4 = new L[]{this.YD};
            lArray = lArray4;
        }
        return lArray;
    }

    @Override
    public ArrayList mC() {
        L[] lArray;
        ArrayList<y> arrayList = new ArrayList<y>();
        L[] lArray2 = new L[]{this.YJ};
        arrayList.add(new y(lArray2, "Fase Preliminar"));
        L[] lArray3 = new L[]{this.YD};
        arrayList.add(new y(lArray3, "Fase de Grupos"));
        if (this.YD != null && this.afX != null) {
            lArray = new L[]{this.afX};
            arrayList.add(new y(lArray, "Fase Final"));
        } else {
            arrayList.add(new y(null, "Fase Final"));
        }
        if (this.afY != null) {
            lArray = new L[]{this.afY};
            arrayList.add(new y(lArray, "Pr\u00e9-repescagem"));
        } else {
            arrayList.add(new y(null, "Pr\u00e9-repescagem"));
        }
        lArray = new L[]{a.SR.bQ().Bo()};
        arrayList.add(new y(lArray, "Repescagem"));
        return arrayList;
    }

    public s Bo() {
        return this.afZ;
    }

    public void X(ah ah2) {
        this.aga = ah2;
    }
}

