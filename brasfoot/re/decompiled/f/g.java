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

public class g
extends at
implements Serializable {
    private static final long serialVersionUID = 1L;
    private s YD = null;
    private ArrayList YE = new ArrayList();
    private ArrayList YF = new ArrayList();
    private Z YG = null;
    private int YH = 0;

    public g() {
        this.F(7, 5);
        this.O(true);
    }

    public void xZ() {
        if (this.YD != null) {
            this.YD.aN(true);
        }
        this.YD = null;
        this.YE.clear();
        this.YF.clear();
    }

    public void ya() {
        this.YE.clear();
        this.YF.clear();
        this.YD = null;
        int n2 = 7;
        ++this.YH;
        this.YG = this.yb();
        if (this.YG == null || !this.YG.jl()) {
            ++n2;
        } else {
            this.YE.add(this.YG);
        }
        Z.a(false, 5, n2, this.YE, false, null);
        if (this.YE.size() >= 8) {
            s s2;
            ArrayList<ah> arrayList = new ArrayList<ah>();
            int n3 = 0;
            while (n3 < this.YE.size()) {
                arrayList.add(((Z)this.YE.get(n3)).jo());
                ((Z)this.YE.get(n3)).z(true);
                ++n3;
            }
            Collections.sort(this.YF, h.a.cN);
            ArrayList arrayList2 = h.a.ad(2, 4);
            int n4 = 0;
            while (n4 < arrayList2.size()) {
                this.YF.add((ah)arrayList.get((Integer)arrayList2.get(n4)));
                ++n4;
            }
            boolean[] blArray = new boolean[7];
            LoadLigaOptions loadLigaOptions = new LoadLigaOptions();
            loadLigaOptions.nTimes = 8;
            loadLigaOptions.nGrupos = 2;
            loadLigaOptions.numeroTimesMataMata = 2;
            loadLigaOptions.doisTurnos = false;
            loadLigaOptions.duasVoltasMataMata = blArray;
            loadLigaOptions.melhoresTerceiros = false;
            this.YD = s2 = new s(loadLigaOptions, this.YF, 0, null, null, null, 7, null, false, null, true, this);
            s2.setNome(this.getNome());
            a.afQ.L(this.YF);
        }
    }

    @Override
    public int cy(int n2) {
        int n3 = this.YH - 1;
        n3 %= 10;
        int n4 = 45000;
        int[] nArray = new int[]{42000, 35000, 32698, 30134, 25600, 24990, 22215, 20065};
        int[] nArray2 = new int[]{15000, 12000, 12698, 9500, 15600, 14990, 17215, 18065};
        if (this.YG != null && this.YG.jc() != 143) {
            nArray = nArray2;
        }
        if (n2 <= 7) {
            n4 = nArray[n2];
        } else if (n2 - 8 < nArray.length) {
            n4 = nArray[n2 - 8];
        }
        return n4;
    }

    @Override
    public String cx(int n2) {
        int n3 = this.YH - 1;
        n3 %= 10;
        String[][] stringArrayArray = new String[][]{{"Auckland", "Wellington", "Dunedin", "Napier", "Auckland", "Wellington", "Hamilton", "Napier"}, {"Porto Moresby", "Lae", "Arawa", "Mount Hagen", "Porto Moresby", "Lae", "Arawa", "Mount Hagen"}, {"Honiara", "Gizo", "Auki", "Kira Kira", "Honiara", "Gizo", "Auki", "Kira Kira"}, {"Port Vila", "Luganville", "Norsup", "Port-Olry", "Port Vila", "Luganville", "Norsup", "Port-Olry"}, {"Auckland", "Wellington", "Dunedin", "Napier", "Auckland", "Wellington", "Rotorua", "Napier"}, {"Porto Moresby", "Lae", "Arawa", "Mount Hagen", "Porto Moresby", "Lae", "Arawa", "Mount Hagen"}, {"Honiara", "Gizo", "Auki", "Kira Kira", "Honiara", "Gizo", "Auki", "Kira Kira"}, {"Auckland", "Wellington", "Dunedin", "Napier", "Auckland", "Wellington", "Rotorua", "Napier"}, {"Porto Moresby", "Lae", "Arawa", "Mount Hagen", "Porto Moresby", "Lae", "Arawa", "Mount Hagen"}, {"Honiara", "Gizo", "Auki", "Kira Kira", "Honiara", "Gizo", "Auki", "Kira Kira"}};
        String string = null;
        int n4 = n2;
        if (n2 > 7) {
            n4 = n2 - 8;
        }
        if (n4 < stringArrayArray[n3].length) {
            string = stringArrayArray[n3][n4];
        }
        return string;
    }

    public Z yb() {
        int n2 = this.YH - 1;
        int[] nArray = new int[]{143, 148, 93, 184, 143, 148, 93, 184, 143, 148};
        if ((n2 %= 10) >= 0 && n2 < nArray.length) {
            return a.SR.s(nArray[n2]);
        }
        return null;
    }

    public static ArrayList yc() {
        ArrayList<String> arrayList = new ArrayList<String>();
        String[] stringArray = new String[]{"1\u00ba Grupo A", "2\u00ba Grupo B", "1\u00ba Grupo D", "2\u00ba Grupo C", "1\u00ba Grupo B", "2\u00ba Grupo A", "1\u00ba Grupo C", "2\u00ba Grupo D"};
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
        if (this.YD.yZ()) {
            L[] lArray2 = new L[]{this.YD.yY()};
            lArray = lArray2;
        }
        return lArray;
    }

    @Override
    public ArrayList mC() {
        ArrayList<y> arrayList = new ArrayList<y>();
        L[] lArray = new L[]{this.YD};
        arrayList.add(new y(lArray, "Fase de Grupos"));
        L[] lArray2 = new L[]{this.YD.yY()};
        arrayList.add(new y(lArray2, "Fase Final"));
        return arrayList;
    }

    @Override
    public String[] mA() {
        String[] stringArray = new String[]{"", ""};
        stringArray[0] = "tr_copaofc";
        stringArray[1] = this.getNome();
        return stringArray;
    }

    public int ye() {
        return this.YH;
    }

    @Override
    public void mr() {
        this.YD.za();
    }
}

