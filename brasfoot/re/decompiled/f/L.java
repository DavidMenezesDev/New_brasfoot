/*
 * Decompiled with CFR 0.152.
 */
package f;

import best.at;
import components.y;
import est.LoadLigaOptions;
import f.s;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class L
extends at
implements Serializable {
    private static final long serialVersionUID = 1L;
    private s YD = null;
    private String agn = "";

    public L() {
        this.F(15, 0);
        this.setNome("Torneio Amistoso");
    }

    public void xZ() {
        this.YD = null;
    }

    public void a(ArrayList arrayList, int n2, String string, String string2, boolean bl2) {
        s s2;
        this.setNome(string);
        this.agn = string2;
        int n3 = 1;
        if (n2 == 0) {
            n3 = 2;
        }
        LoadLigaOptions loadLigaOptions = new LoadLigaOptions();
        loadLigaOptions.nTimes = arrayList.size();
        loadLigaOptions.nGrupos = n3;
        loadLigaOptions.numeroTimesMataMata = 2;
        if (n2 == 2) {
            loadLigaOptions.numeroTimesMataMata = 0;
        }
        loadLigaOptions.doisTurnos = false;
        boolean[] blArray = new boolean[7];
        loadLigaOptions.duasVoltasMataMata = blArray;
        if (bl2) {
            Collections.shuffle(arrayList);
        }
        this.YD = s2 = new s(loadLigaOptions, arrayList, 0, null, null, null, 15, null, false, null, true, this);
        s2.setNome(string);
    }

    @Override
    public best.L[] mB() {
        best.L[] lArray = new best.L[]{this.YD};
        if (this.YD.yZ()) {
            best.L[] lArray2 = new best.L[]{this.YD.yY()};
            lArray = lArray2;
        }
        return lArray;
    }

    @Override
    public ArrayList mC() {
        ArrayList<y> arrayList = new ArrayList<y>();
        if (this.YD.yX() > 0) {
            String string = "Primeira Fase";
            if (this.YD.yQ().size() > 0) {
                string = "Fase de Grupos";
            }
            best.L[] lArray = new best.L[]{this.YD};
            arrayList.add(new y(lArray, string));
            best.L[] lArray2 = new best.L[]{this.YD.yY()};
            arrayList.add(new y(lArray2, "Fase Final"));
            return arrayList;
        }
        return null;
    }

    public String Bt() {
        return this.agn;
    }

    @Override
    public void mr() {
        this.YD.za();
    }
}

