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

public class k
extends at
implements Serializable {
    private static final long serialVersionUID = 1L;
    private s agb = null;
    private s afX = null;
    private ArrayList agc = new ArrayList();
    private z agd = null;
    private ah afW = null;

    public k() {
        this.F(9, 4);
    }

    public void xZ() {
        if (this.afX != null) {
            this.afX.aN(true);
        }
        this.agb = null;
        this.afX = null;
        this.agc.clear();
        this.afW = null;
    }

    public void Bj() {
        s s2;
        Serializable serializable;
        this.agc.clear();
        ArrayList arrayList = new ArrayList();
        ArrayList<ah> arrayList2 = new ArrayList<ah>();
        int[] nArray = new int[]{131, 68, 51, 106, 86, 58, 38, 8, 147, 84, 189, 7, 79, 166, 181, 139, 158, 77, 20, 80, 168, 24, 22, 165, 153, 53, 212, 56, 90, 17, 13, 213, 211, 94, 6};
        ArrayList<ah> arrayList3 = new ArrayList<ah>();
        int n2 = 0;
        while (n2 < nArray.length) {
            serializable = a.SR.s(nArray[n2]);
            arrayList3.add(((Z)serializable).jo());
            ((Z)serializable).z(true);
            ++n2;
        }
        Collections.sort(arrayList3, h.a.cN);
        n2 = 0;
        while (n2 <= 4) {
            this.agc.add((ah)arrayList3.get(n2));
            ++n2;
        }
        ArrayList<ah> arrayList4 = new ArrayList<ah>();
        serializable = new ArrayList();
        ArrayList<ah> arrayList5 = new ArrayList<ah>();
        ArrayList<ah> arrayList6 = new ArrayList<ah>();
        ArrayList<ah> arrayList7 = new ArrayList<ah>();
        int n3 = 5;
        while (n3 <= 10) {
            arrayList4.add((ah)arrayList3.get(n3));
            ++n3;
        }
        n3 = 11;
        while (n3 <= 16) {
            ((ArrayList)serializable).add((ah)arrayList3.get(n3));
            ++n3;
        }
        n3 = 17;
        while (n3 <= 22) {
            arrayList5.add((ah)arrayList3.get(n3));
            ++n3;
        }
        n3 = 23;
        while (n3 <= 28) {
            arrayList6.add((ah)arrayList3.get(n3));
            ++n3;
        }
        n3 = 29;
        while (n3 <= 34) {
            arrayList7.add((ah)arrayList3.get(n3));
            ++n3;
        }
        n3 = 0;
        while (n3 <= 5) {
            arrayList2.add((ah)arrayList4.get(n3));
            arrayList2.add((ah)((ArrayList)serializable).get(n3));
            arrayList2.add((ah)arrayList5.get(n3));
            arrayList2.add((ah)arrayList6.get(n3));
            arrayList2.add((ah)arrayList7.get(n3));
            ++n3;
        }
        Collections.shuffle(arrayList4);
        Collections.shuffle(serializable);
        Collections.shuffle(arrayList5);
        Collections.shuffle(arrayList6);
        Collections.shuffle(arrayList7);
        LoadLigaOptions loadLigaOptions = new LoadLigaOptions();
        loadLigaOptions.nTimes = 30;
        loadLigaOptions.nGrupos = 6;
        loadLigaOptions.doisTurnos = false;
        this.agb = s2 = new s(loadLigaOptions, arrayList2, 0, null, null, null, 9, null, false, null, true, this);
        s2.setNome(this.getNome());
        s2.fb(9400);
        a.afQ.L(arrayList2);
        a.afQ.L(this.agc);
    }

    public void Bp() {
        ArrayList<ah> arrayList = new ArrayList<ah>();
        int n2 = 0;
        while (n2 < this.agb.yQ().size()) {
            arrayList.add((ah)((best.G)this.agb.yQ().get(n2)).gR().get(0));
            ++n2;
        }
        boolean[] blArray = new boolean[7];
        blArray[0] = true;
        blArray[1] = true;
        blArray[2] = true;
        boolean[] blArray2 = blArray;
        this.agd = new z(null, arrayList.size(), this.b(), 1, blArray2, this, 9401);
        G g2 = new G();
        g2.a(this.agd, arrayList, 0, blArray2[0], 0, 0, this.b(), false);
    }

    public void ay(ArrayList arrayList) {
        this.agc.addAll(arrayList);
        LoadLigaOptions loadLigaOptions = new LoadLigaOptions();
        loadLigaOptions.nTimes = 8;
        loadLigaOptions.doisTurnos = true;
        s s2 = new s(loadLigaOptions, this.agc, 0, null, null, null, this.b(), null, false, null, true, this);
        s2.fb(9402);
        this.afX = s2;
        s2.setNome(this.getNome());
    }

    public void Bm() {
        int n2 = 0;
        while (n2 < 6) {
            a.SR.aY().a(this, a.SR.s(((ah)this.afX.yK().get(n2)).getPais()));
            ++n2;
        }
        this.afW = (ah)this.afX.yK().get(6);
        a.SR.bQ().X((ah)this.afX.yK().get(7));
    }

    public void Y(ah ah2) {
        a.SR.aY().a(this, a.SR.s(ah2.getPais()));
    }

    @Override
    public L[] mB() {
        L[] lArray = new L[]{this.agd};
        if (this.agd == null) {
            L[] lArray2 = new L[]{this.agb};
            lArray = lArray2;
        } else if (this.afX != null) {
            L[] lArray3 = new L[]{this.afX};
            lArray = lArray3;
        }
        return lArray;
    }

    @Override
    public ArrayList mC() {
        ArrayList<y> arrayList = new ArrayList<y>();
        L[] lArray = new L[]{this.agb};
        arrayList.add(new y(lArray, "Fase Preliminar"));
        L[] lArray2 = new L[]{this.agd};
        arrayList.add(new y(lArray2, "Fase Intermedi\u00e1ria"));
        L[] lArray3 = new L[]{this.afX};
        arrayList.add(new y(lArray3, "Fase Final"));
        L[] lArray4 = new L[]{a.SR.bQ().Bo()};
        arrayList.add(new y(lArray4, "Torneio Repescagem"));
        return arrayList;
    }

    public ah Bl() {
        return this.afW;
    }
}

