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

public class i
extends at
implements Serializable {
    private static final long serialVersionUID = 1L;
    private s YD = null;
    private z YJ = null;
    private z afV = null;
    private ArrayList YF = new ArrayList();
    private ah afW = null;

    public i() {
        this.F(9, 2);
    }

    public void xZ() {
        if (this.YD != null) {
            this.YD.aN(true);
        }
        this.YD = null;
        this.YJ = null;
        this.afV = null;
        this.YF.clear();
        this.afW = null;
    }

    public void Bj() {
        ArrayList<Z> arrayList = new ArrayList<Z>();
        ArrayList<ah> arrayList2 = new ArrayList<ah>();
        ArrayList<ah> arrayList3 = new ArrayList<ah>();
        int n2 = 0;
        while (n2 < a.SR.aG().size()) {
            if (((Z)a.SR.aG().get(n2)).jo() != null && ((Z)a.SR.aG().get(n2)).gg() == 2) {
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
        while (n2 <= 25) {
            this.YF.add((ah)arrayList2.get(n2));
            ++n2;
        }
        ArrayList<ah> arrayList4 = new ArrayList<ah>();
        ArrayList<ah> arrayList5 = new ArrayList<ah>();
        int n3 = 26;
        while (n3 <= 39) {
            arrayList4.add((ah)arrayList2.get(n3));
            ++n3;
        }
        n3 = 40;
        while (n3 <= 53) {
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
        this.YJ = new z(null, arrayList3.size(), this.b(), 1, blArray, this, 9200);
        G g2 = new G();
        g2.a(this.YJ, arrayList3, 0, blArray[0], 0, 0, this.b(), false);
        a.afQ.L(arrayList3);
        a.afQ.L(this.YF);
    }

    public void Bk() {
        ArrayList<ah> arrayList = new ArrayList<ah>();
        ArrayList<ah> arrayList2 = new ArrayList<ah>();
        int n2 = 0;
        while (n2 < this.YD.yQ().size()) {
            arrayList2.add((ah)((best.G)this.YD.yQ().get(n2)).gR().get(1));
            ++n2;
        }
        s.r(this.YD);
        Collections.sort(arrayList2, h.a.abn);
        n2 = 0;
        while (n2 <= 3) {
            arrayList.add((ah)arrayList2.get(n2));
            ++n2;
        }
        Collections.shuffle(arrayList);
        boolean[] blArray = new boolean[]{true, true, true, true, true, true, true};
        this.afV = new z(null, arrayList.size(), this.b(), 0, blArray, this, 9202);
        G g2 = new G();
        g2.a(this.afV, arrayList, 0, blArray[0], 0, 0, this.b(), false);
    }

    public void p(ArrayList arrayList, ArrayList arrayList2) {
        ArrayList<ah> arrayList3 = new ArrayList<ah>();
        int n2 = 0;
        while (n2 < this.YD.yQ().size()) {
            arrayList3.add((ah)((best.G)this.YD.yQ().get(n2)).gR().get(0));
            ++n2;
        }
        arrayList3.add((ah)arrayList.get(0));
        this.afW = (ah)arrayList2.get(0);
        n2 = 0;
        while (n2 < arrayList3.size()) {
            a.SR.aY().a(this, a.SR.s(((ah)arrayList3.get(n2)).getPais()));
            ++n2;
        }
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
        int n2 = 0;
        while (n2 <= 9) {
            arrayList3.add((ah)arrayList2.get(n2));
            ++n2;
        }
        n2 = 10;
        while (n2 <= 19) {
            arrayList4.add((ah)arrayList2.get(n2));
            ++n2;
        }
        n2 = 20;
        while (n2 <= 29) {
            arrayList5.add((ah)arrayList2.get(n2));
            ++n2;
        }
        n2 = 30;
        while (n2 <= 39) {
            arrayList6.add((ah)arrayList2.get(n2));
            ++n2;
        }
        Collections.shuffle(arrayList3);
        Collections.shuffle(arrayList4);
        Collections.shuffle(arrayList5);
        Collections.shuffle(arrayList6);
        ArrayList<ah> arrayList7 = new ArrayList<ah>();
        int n3 = 0;
        while (n3 <= 9) {
            arrayList7.add((ah)arrayList3.get(n3));
            arrayList7.add((ah)arrayList4.get(n3));
            arrayList7.add((ah)arrayList5.get(n3));
            arrayList7.add((ah)arrayList6.get(n3));
            ++n3;
        }
        if (arrayList7.size() == 40) {
            boolean[] blArray = new boolean[7];
            blArray[0] = true;
            blArray[1] = true;
            blArray[2] = true;
            blArray[3] = true;
            boolean[] blArray2 = blArray;
            LoadLigaOptions loadLigaOptions = new LoadLigaOptions();
            loadLigaOptions.nTimes = 40;
            loadLigaOptions.nGrupos = 8;
            loadLigaOptions.numeroTimesMataMata = 1;
            loadLigaOptions.doisTurnos = true;
            loadLigaOptions.pulaDuasDatas = false;
            loadLigaOptions.duasVoltasMataMata = blArray2;
            s s2 = new s(loadLigaOptions, arrayList7, 0, null, null, null, this.b(), null, false, null, true, this);
            s2.fb(9201);
            this.YD = s2;
            s2.setNome(this.getNome());
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
        L[] lArray = new L[]{this.YD};
        if (this.YD == null) {
            L[] lArray2 = new L[]{this.YJ};
            lArray = lArray2;
        } else if (this.afV != null) {
            L[] lArray3 = new L[]{this.afV};
            lArray = lArray3;
        }
        return lArray;
    }

    @Override
    public ArrayList mC() {
        ArrayList<y> arrayList = new ArrayList<y>();
        L[] lArray = new L[]{this.YJ};
        arrayList.add(new y(lArray, "Fase Preliminar"));
        L[] lArray2 = new L[]{this.YD};
        arrayList.add(new y(lArray2, "Fase de Grupos"));
        if (this.afV != null) {
            L[] lArray3 = new L[]{this.afV};
            arrayList.add(new y(lArray3, "Play-offs"));
        }
        return arrayList;
    }

    public ah Bl() {
        return this.afW;
    }
}

