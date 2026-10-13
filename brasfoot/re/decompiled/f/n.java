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
import f.s;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class n
extends at
implements Serializable {
    private static final long serialVersionUID = 1L;
    private s YD = null;
    private ArrayList YE = new ArrayList();
    private ArrayList YF = new ArrayList();
    private ah agf = null;

    public n() {
        this.F(9, 1);
    }

    public void xZ() {
        if (this.YD != null) {
            this.YD.aN(true);
        }
        this.YD = null;
        this.agf = null;
        this.YE.clear();
        this.YF.clear();
    }

    public void ya() {
        this.YE.clear();
        this.YF.clear();
        int n2 = 10;
        Z.a(false, 1, n2, this.YE, true, null);
        if (this.YE.size() == 10) {
            s s2;
            int n3 = 0;
            while (n3 < this.YE.size()) {
                this.YF.add(((Z)this.YE.get(n3)).jo());
                ((Z)this.YE.get(n3)).z(true);
                ++n3;
            }
            Collections.shuffle(this.YF);
            LoadLigaOptions loadLigaOptions = new LoadLigaOptions();
            loadLigaOptions.nTimes = 10;
            loadLigaOptions.nGrupos = 0;
            loadLigaOptions.doisTurnos = true;
            loadLigaOptions.jogosDentroGrupo = true;
            loadLigaOptions.var0 = 9100;
            this.YD = s2 = new s(loadLigaOptions, this.YF, 0, null, null, null, 9, null, false, null, true, this);
            s2.setNome(this.getNome());
        } else if (this.YE.size() == 9) {
            s s3;
            int n4 = 0;
            while (n4 < this.YE.size()) {
                this.YF.add(((Z)this.YE.get(n4)).jo());
                ((Z)this.YE.get(n4)).z(true);
                ++n4;
            }
            Collections.shuffle(this.YF);
            LoadLigaOptions loadLigaOptions = new LoadLigaOptions();
            loadLigaOptions.nTimes = 9;
            loadLigaOptions.nGrupos = 0;
            loadLigaOptions.doisTurnos = true;
            loadLigaOptions.jogosDentroGrupo = true;
            loadLigaOptions.var0 = 9100;
            this.YD = s3 = new s(loadLigaOptions, this.YF, 0, null, null, null, 9, null, false, null, true, this);
            s3.setNome(this.getNome());
        }
        a.afQ.L(this.YF);
    }

    public void Bm() {
        int n2 = 0;
        while (n2 <= 5) {
            a.SR.aY().a(this, a.SR.s(((ah)this.YD.yK().get(n2)).getPais()));
            ++n2;
        }
        this.agf = (ah)this.YD.yK().get(6);
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

    @Override
    public L[] mB() {
        L[] lArray = new L[]{this.YD};
        if (a.SR.bQ().Bo() != null) {
            L[] lArray2 = new L[]{a.SR.bQ().Bo()};
            lArray = lArray2;
        }
        return lArray;
    }

    @Override
    public ArrayList mC() {
        ArrayList<y> arrayList = new ArrayList<y>();
        L[] lArray = new L[]{this.YD};
        arrayList.add(new y(lArray, "Fase de Grupos"));
        L[] lArray2 = new L[]{a.SR.bQ().Bo()};
        arrayList.add(new y(lArray2, "Torneio Repescagem"));
        return arrayList;
    }

    public s yd() {
        return this.YD;
    }

    public ah Br() {
        return this.agf;
    }
}

