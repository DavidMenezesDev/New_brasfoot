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

public class m
extends at
implements Serializable {
    private static final long serialVersionUID = 1L;
    private s agb = null;
    private s YD = null;
    private ArrayList YF = new ArrayList();
    private z afT = null;
    private ah agf = null;

    public m() {
        this.F(9, 5);
    }

    public void xZ() {
        if (this.YD != null) {
            this.YD.aN(true);
        }
        this.YD = null;
        this.agb = null;
        this.agf = null;
        this.afT = null;
        this.YF.clear();
    }

    public void Bj() {
        Serializable serializable;
        this.YF.clear();
        ArrayList<ah> arrayList = new ArrayList<ah>();
        int[] nArray = new int[]{214, 91, 163, 188, 69, 215, 143, 148, 93, 184, 197};
        ArrayList<ah> arrayList2 = new ArrayList<ah>();
        int n2 = 0;
        while (n2 < nArray.length) {
            serializable = a.SR.s(nArray[n2]);
            arrayList2.add(((Z)serializable).jo());
            ((Z)serializable).z(true);
            ++n2;
        }
        Collections.sort(arrayList2, h.a.cN);
        n2 = 0;
        while (n2 <= 6) {
            this.YF.add((ah)arrayList2.get(n2));
            ++n2;
        }
        n2 = 7;
        while (n2 < arrayList2.size()) {
            arrayList.add((ah)arrayList2.get(n2));
            ++n2;
        }
        LoadLigaOptions loadLigaOptions = new LoadLigaOptions();
        loadLigaOptions.nTimes = 4;
        loadLigaOptions.nGrupos = 0;
        loadLigaOptions.doisTurnos = true;
        serializable = new s(loadLigaOptions, arrayList, 0, null, null, null, 9, null, false, null, true, this);
        this.agb = serializable;
        ((L)serializable).setNome(this.getNome());
        ((s)serializable).fb(9500);
        a.afQ.L(arrayList);
        a.afQ.L(this.YF);
    }

    public void yt() {
        ArrayList<ah> arrayList = new ArrayList<ah>();
        int n2 = 0;
        while (n2 < this.YD.yQ().size()) {
            arrayList.add((ah)((best.G)this.YD.yQ().get(n2)).gR().get(0));
            arrayList.add((ah)((best.G)this.YD.yQ().get(n2)).gR().get(1));
            ++n2;
        }
        boolean[] blArray = new boolean[7];
        blArray[0] = true;
        blArray[1] = true;
        blArray[2] = true;
        boolean[] blArray2 = blArray;
        this.afT = new z(null, arrayList.size(), this.b(), 0, blArray2, this, 9502);
        G g2 = new G();
        g2.a(this.afT, arrayList, 0, blArray2[0], 0, 0, this.b(), false);
    }

    public void Bq() {
        s s2;
        this.YF.add((ah)this.agb.yK().get(0));
        LoadLigaOptions loadLigaOptions = new LoadLigaOptions();
        loadLigaOptions.nTimes = 8;
        loadLigaOptions.nGrupos = 2;
        loadLigaOptions.doisTurnos = true;
        this.YD = s2 = new s(loadLigaOptions, this.YF, 0, null, null, null, 9, null, false, null, true, this);
        s2.setNome(this.getNome());
        s2.fb(9501);
    }

    public static ArrayList yc() {
        ArrayList<String> arrayList = new ArrayList<String>();
        String[] stringArray = new String[]{"5\u00ba A. Sul", "1\u00ba Oceania"};
        int n2 = 0;
        while (n2 < stringArray.length) {
            arrayList.add(stringArray[n2]);
            ++n2;
        }
        return arrayList;
    }

    public void p(ArrayList arrayList, ArrayList arrayList2) {
        a.SR.aY().a(this, a.SR.s(((ah)arrayList.get(0)).getPais()));
        this.agf = (ah)arrayList2.get(0);
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
            L[] lArray2 = new L[]{this.agb};
            lArray = lArray2;
        } else if (this.afT != null) {
            L[] lArray3 = new L[]{this.afT};
            lArray = lArray3;
        }
        return lArray;
    }

    @Override
    public ArrayList mC() {
        ArrayList<y> arrayList = new ArrayList<y>();
        L[] lArray = new L[]{this.agb};
        arrayList.add(new y(lArray, "Fase Preliminar"));
        L[] lArray2 = new L[]{this.YD};
        arrayList.add(new y(lArray2, "Fase de Grupos"));
        L[] lArray3 = new L[]{this.afT};
        arrayList.add(new y(lArray3, "Fase Final"));
        L[] lArray4 = new L[]{a.SR.bQ().Bo()};
        arrayList.add(new y(lArray4, "Torneio Repescagem"));
        return arrayList;
    }

    public ah Br() {
        return this.agf;
    }
}

