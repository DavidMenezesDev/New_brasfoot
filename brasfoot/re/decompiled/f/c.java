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

public class c
extends at
implements Serializable {
    private static final long serialVersionUID = 1L;
    private s YD = null;
    private ArrayList YE = new ArrayList();
    private ArrayList YF = new ArrayList();
    private Z YG = null;
    private int YH = 0;

    public void xZ() {
        if (this.YD != null) {
            this.YD.aN(true);
        }
        this.YD = null;
        this.YE.clear();
        this.YF.clear();
    }

    public c() {
        this.F(7, 2);
        this.O(true);
    }

    public void ya() {
        this.YE.clear();
        this.YF.clear();
        this.YD = null;
        int n2 = 23;
        ++this.YH;
        this.YG = this.yb();
        if (this.YG == null || !this.YG.jl()) {
            ++n2;
        } else {
            this.YE.add(this.YG);
        }
        Z.a(false, 2, n2, this.YE, false, null);
        if (this.YE.size() >= 24) {
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
            s2.setNome(this.getNome());
            a.afQ.L(this.YF);
        }
    }

    @Override
    public int cy(int n2) {
        int n3 = this.YH - 1;
        n3 %= 10;
        int n4 = 45000;
        int[] nArray = new int[]{65000, 55000, 52698, 48134, 45600, 34990, 37215, 28065};
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
        String[][] stringArrayArray = new String[][]{{"Douala", "Yaound\u00e9", "Garoua", "Kouss\u00e9ri", "Bamenda", "Maroua", "Bafoussam", "Mokolo"}, {"Abidjan", "Abobo", "Bouak\u00e9", "Daloa", "San-P\u00e9dro", "Yamoussoukro", "Korhogo", "Gagnoa"}, {"Camayenne", "Conacri", "Zerecor\u00e9", "Quindia", "Canc\u00e3", "Gu\u00e9kh\u00e9dou", "Coyah", "Kamsar"}, {"T\u00fanis", "Sfax", "Susa", "Cairu\u00e3o", "T\u00fanis", "Sfax", "Susa", "Cairu\u00e3o"}, {"Cairo", "Alexandria", "Giz\u00e9", "Suez", "Faium", "Porto Sa\u00edde", "Alman\u00e7ora", "Tanta"}, {"Lagos", "Kano", "Ibad\u00e3", "Kaduna", "Porto Harcourt", "Benin City", "Maiduguri", "Zaira"}, {"Joanesburgo", "Cidade do Cabo", "Durban", "Pret\u00f3ria", "Porto Elizabeth", "Joanesburgo", "Cidade do Cabo", "Durban"}, {"Luanda", "Huambo", "Lobito", "Benguela", "Lubango", "Lucapa", "Malanje", "Mo\u00e7\u00e2medes"}, {"Marrakech", "Casablanca", "Fez", "T\u00e2nger", "Sal\u00e9", "Rabat", "Mequinez", "Kenitra"}, {"Argel", "Or\u00e3", "Constantina", "Annaba", "Batna", "Blida", "Setif", "Djelfa"}};
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
        int[] nArray = new int[]{36, 50, 81, 190, 57, 141, 1, 5, 129, 10};
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
        stringArray[0] = "tr_copaafrica";
        stringArray[1] = this.getNome();
        return stringArray;
    }

    public int ye() {
        return this.YH;
    }

    public void eW(int n2) {
        this.YH = n2;
    }

    @Override
    public void mr() {
        this.YD.za();
    }
}

