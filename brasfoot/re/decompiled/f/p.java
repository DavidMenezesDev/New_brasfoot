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

public class p
extends at
implements Serializable {
    private static final long serialVersionUID = 1L;
    private s YD = null;
    private ArrayList YE = new ArrayList();
    private ArrayList YF = new ArrayList();
    private Z YG = null;
    private int YH = 0;
    private ArrayList YM = new ArrayList();

    public p() {
        this.F(7, 0);
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
        int n2 = 23;
        ++this.YH;
        this.YG = this.yb();
        this.YE.addAll(this.YM);
        this.YM.clear();
        if (this.YE.size() == 24) {
            s s2;
            ArrayList<ah> arrayList = new ArrayList<ah>();
            int n3 = 0;
            while (n3 < this.YE.size()) {
                arrayList.add(((Z)this.YE.get(n3)).jo());
                ((Z)this.YE.get(n3)).z(true);
                ++n3;
            }
            Collections.sort(this.YF, h.a.cN);
            ArrayList arrayList2 = h.a.ad(6, 4);
            int n4 = 0;
            while (n4 < arrayList2.size()) {
                this.YF.add((ah)arrayList.get((Integer)arrayList2.get(n4)));
                ++n4;
            }
            boolean[] blArray = new boolean[7];
            LoadLigaOptions loadLigaOptions = new LoadLigaOptions();
            loadLigaOptions.nTimes = 24;
            loadLigaOptions.nGrupos = 6;
            loadLigaOptions.numeroTimesMataMata = 2;
            loadLigaOptions.doisTurnos = false;
            loadLigaOptions.duasVoltasMataMata = blArray;
            loadLigaOptions.melhoresTerceiros = true;
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
        int[] nArray = new int[]{80000, 75000, 72698, 68134, 55600, 44990, 47215, 38065};
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
        String[][] stringArrayArray = new String[][]{{"Berlim", "Munique", "Hamburgo", "Dortmund", "Frankfurt", "Hannover", "Leipzig", "Nuremberg"}, {"Roma", "Mil\u00e3o", "Turim", "Bologna", "Cagliari", "G\u00eanoa", "Floren\u00e7a", "Udine"}, {"Londres", "Liverpool", "Manchester", "Notthingam", "Leeds", "Coventry", "Sheffield", "Bristol"}, {"Madrid", "Sevilha", "Valencia", "Vigo", "M\u00e1laga", "Valladolid", "Barcelona", "Gij\u00f3n"}, {"Lisboa", "Porto", "Coimbra", "Set\u00fabal", "Aveiro", "Faro", "Braga", "Viseu"}, {"Moscou", "S\u00e3o Petesburgo", "Kazan", "Kaliningrad", "Yaroslavl", "Samara", "Volgograd", "Yekaterinburg"}, {"Kiev", "Carc\u00f3via", "Odessa", "Dnipro", "Donetsk", "Zaporizhzhya", "Lviv", "Mariupol"}, {"Atenas", "Tessal\u00f4nica", "Patras", "Larissa", "Heracli\u00e3o", "V\u00f3los", "Tr\u00edcala", "C\u00e1lcis"}, {"Paris", "Marselha", "Lyon", "Toulouse", "Nice", "Nantes", "Estrasburgo", "Montpellier"}, {"Vars\u00f3via", "Crac\u00f3via", "Lodz", "Bresl\u00e1via", "Poznan", "Gdansk", "Lublin", "Katowice"}};
        String string = null;
        string = n2 < stringArrayArray[n3 %= 10].length ? stringArrayArray[n3][n2] : (n2 - stringArrayArray[n3].length < stringArrayArray[n3].length ? stringArrayArray[n3][n2 - stringArrayArray[n3].length] : stringArrayArray[n3][0]);
        return string;
    }

    public Z yb() {
        int n2 = this.YH - 1;
        int[] nArray = new int[]{72, 3, 104, 97, 65, 154, 162, 193, 78, 152};
        if ((n2 %= 10) == 0) {
            return null;
        }
        if (n2 >= 0 && n2 < nArray.length) {
            return a.SR.s(nArray[n2]);
        }
        return null;
    }

    public s yd() {
        return this.YD;
    }

    public void p(s s2) {
        this.YD = s2;
    }

    public void a(at at2, Z z2) {
        this.YM.add(z2);
        z2.jo().e(at2, 1);
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
        stringArray[0] = "tr_eurocopa";
        stringArray[1] = this.getNome();
        return stringArray;
    }

    @Override
    public void mr() {
        this.YD.za();
    }
}

