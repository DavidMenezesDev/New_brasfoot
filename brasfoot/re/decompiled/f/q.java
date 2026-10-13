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
import java.util.Random;

public class q
extends at
implements Serializable {
    private static final long serialVersionUID = 1L;
    private s YD = null;
    private ArrayList YE = new ArrayList();
    private int YH = 0;
    private ArrayList YF = new ArrayList();
    private ArrayList YM = new ArrayList();
    private Z YN = null;
    private Z YO = null;
    private Z YG = null;
    private int[] Zw;

    public void xZ() {
        if (this.YD != null) {
            this.YD.aN(true);
        }
        this.YD = null;
        this.YE.clear();
        this.YF.clear();
    }

    public q() {
        int[] nArray = new int[16];
        nArray[1] = 3;
        nArray[2] = 4;
        nArray[3] = 7;
        nArray[4] = 8;
        nArray[5] = 11;
        nArray[6] = 12;
        nArray[7] = 15;
        nArray[8] = 2;
        nArray[9] = 1;
        nArray[10] = 6;
        nArray[11] = 5;
        nArray[12] = 10;
        nArray[13] = 9;
        nArray[14] = 14;
        nArray[15] = 13;
        this.Zw = nArray;
        this.F(7, 7);
        this.O(true);
    }

    public void ya() {
        if (a.SR.H() > 1) {
            this.Bu();
        } else {
            int n2;
            int n3;
            Object object;
            this.YE.clear();
            this.YF.clear();
            this.YD = null;
            boolean bl2 = false;
            int[] nArray = new int[6];
            nArray[0] = 13;
            nArray[1] = 4;
            nArray[2] = 5;
            nArray[3] = 4;
            nArray[4] = 3;
            int[] nArray2 = nArray;
            int[] nArray3 = new int[6];
            if (a.SR.H() == 1) {
                nArray3 = nArray2;
            }
            ++this.YH;
            this.YG = this.eY(0);
            if (a.SR.H() == 1 && a.SR.isUsarGruposReaisCopa()) {
                bl2 = true;
                object = new int[]{39, 60, 169, 85, 97, 98, 68, 145, 11, 9, 131, 152, 72, 14, 54, 190, 65, 51, 3, 107, 21, 38, 129, 52, 29, 171, 180, 36, 154, 75, 195, 49};
                n3 = 0;
                while (n3 < 32) {
                    this.YE.add(a.SR.s((int)object[n3]));
                    ++n3;
                }
            } else {
                if (this.YG == null || !this.YG.jl()) {
                    nArray3[3] = nArray3[3] + 1;
                } else {
                    this.YE.add(this.YG);
                }
                this.YE.addAll(this.YM);
                int n4 = new Random().nextInt(100) + 1;
                if (n4 <= 70) {
                    nArray3[4] = nArray3[4] + 1;
                } else {
                    nArray3[5] = nArray3[5] + 1;
                }
                n3 = 0;
                while (n3 < this.YE.size()) {
                    ++n3;
                }
                n3 = 0;
                while (n3 <= 5) {
                    if (nArray3[n3] > 0) {
                        Z.a(true, n3, nArray3[n3], this.YE, false, this.YN);
                    }
                    ++n3;
                }
                if (this.YE.size() < 32) {
                    n3 = 0;
                    while (n3 <= 5) {
                        n2 = 32 - this.YE.size();
                        if (n2 > 0) {
                            Z.a(true, n3, n2, this.YE, false, this.YN);
                        }
                        ++n3;
                    }
                }
            }
            if (this.YE.size() >= 32) {
                s s2;
                object = new ArrayList<ah>();
                n3 = 0;
                while (n3 < this.YE.size()) {
                    ((ArrayList)object).add(((Z)this.YE.get(n3)).jo());
                    ((Z)this.YE.get(n3)).z(true);
                    ++n3;
                }
                Collections.sort(this.YF, h.a.cN);
                ArrayList arrayList = h.a.ad(8, 4);
                if (bl2) {
                    n2 = 0;
                    while (n2 < this.YE.size()) {
                        this.YF.add((ah)((ArrayList)object).get(n2));
                        ++n2;
                    }
                } else {
                    n2 = 0;
                    while (n2 < arrayList.size()) {
                        this.YF.add((ah)((ArrayList)object).get((Integer)arrayList.get(n2)));
                        ++n2;
                    }
                }
                boolean[] blArray = new boolean[7];
                LoadLigaOptions loadLigaOptions = new LoadLigaOptions();
                loadLigaOptions.nTimes = 32;
                loadLigaOptions.nGrupos = 8;
                loadLigaOptions.numeroTimesMataMata = 2;
                loadLigaOptions.doisTurnos = false;
                loadLigaOptions.duasVoltasMataMata = blArray;
                loadLigaOptions.var0 = 7700;
                this.YD = s2 = new s(loadLigaOptions, this.YF, 0, null, null, null, 7, null, false, null, true, this);
                s2.setNome(this.getNome());
                a.afQ.L(this.YF);
            }
            this.YM.clear();
            this.YN = null;
            this.YF.clear();
            this.YE.clear();
        }
    }

    public void Bu() {
        ++this.YH;
        this.YG = this.eY(0);
        this.YE.clear();
        this.YE.addAll(this.YM);
        this.YM.clear();
        ArrayList<ah> arrayList = new ArrayList<ah>();
        ArrayList<ah> arrayList2 = new ArrayList<ah>();
        Collections.sort(this.YE, Z.cN);
        int n2 = 0;
        while (n2 < this.YE.size()) {
            arrayList.add(((Z)this.YE.get(n2)).jo());
            ((Z)this.YE.get(n2)).z(true);
            ++n2;
        }
        ArrayList<ah> arrayList3 = new ArrayList<ah>();
        ArrayList<ah> arrayList4 = new ArrayList<ah>();
        ArrayList<ah> arrayList5 = new ArrayList<ah>();
        int n3 = 0;
        while (n3 <= 15) {
            arrayList3.add((ah)arrayList.get(n3));
            ++n3;
        }
        n3 = 16;
        while (n3 <= 31) {
            arrayList4.add((ah)arrayList.get(n3));
            ++n3;
        }
        n3 = 32;
        while (n3 <= 47) {
            arrayList5.add((ah)arrayList.get(n3));
            ++n3;
        }
        Collections.shuffle(arrayList3);
        Collections.shuffle(arrayList4);
        Collections.shuffle(arrayList5);
        n3 = 0;
        while (n3 <= 15) {
            arrayList2.add((ah)arrayList3.get(n3));
            arrayList2.add((ah)arrayList4.get(n3));
            arrayList2.add((ah)arrayList5.get(n3));
            ++n3;
        }
        boolean[] blArray = new boolean[7];
        LoadLigaOptions loadLigaOptions = new LoadLigaOptions();
        loadLigaOptions.nTimes = 48;
        loadLigaOptions.nGrupos = 16;
        loadLigaOptions.doisTurnos = false;
        loadLigaOptions.numeroTimesMataMata = 2;
        loadLigaOptions.duasVoltasMataMata = blArray;
        s s2 = new s(loadLigaOptions, arrayList2, 0, null, null, null, 7, null, false, null, true, this);
        s2.fb(7700);
        this.YD = s2;
        s2.setNome(this.getNome());
    }

    public void yt() {
        int n2;
        ArrayList<ah> arrayList = new ArrayList<ah>();
        int n3 = 0;
        while (n3 < this.YD.yQ().size()) {
            arrayList.add((ah)((best.G)this.YD.yQ().get(n3)).gR().get(0));
            arrayList.add((ah)((best.G)this.YD.yQ().get(n3)).gR().get(1));
            ++n3;
        }
        ArrayList<ah> arrayList2 = new ArrayList<ah>();
        if (arrayList.size() == 16) {
            n2 = 0;
            while (n2 < arrayList.size()) {
                arrayList2.add((ah)arrayList.get(this.Zw[n2]));
                ++n2;
            }
        }
        if (arrayList.size() == 32) {
            n2 = 0;
            while (n2 < this.Zw.length) {
                arrayList2.add((ah)arrayList.get(this.Zw[n2]));
                ++n2;
            }
            n2 = 0;
            while (n2 < this.Zw.length) {
                arrayList2.add((ah)arrayList.get(this.Zw[n2] + 16));
                ++n2;
            }
        }
        boolean[] blArray = new boolean[7];
        this.YD.c(new z(null, arrayList2.size(), this.b(), 0, blArray, this, -1));
        G g2 = new G();
        g2.a(this.YD.yY(), arrayList2, 0, blArray[0], 0, 0, this.b(), false);
    }

    public static String ab(int n2, int n3) {
        String string = "";
        String[][] stringArrayArray = new String[][]{{"Moscou", "Ecaterimburgo", "S\u00e3o Petesburgo", "S\u00f3chi", "Caz\u00e3", "Saransk", "Moscou", "Kaliningrado", "Samara", "Rostov", "Moscou", "N\u00edjni Novgorod", "S\u00f3chi", "Volgogrado", "Saransk", "Moscou"}, {"S\u00e3o Petesburgo", "Rostov", "Moscou", "Caz\u00e3", "Samara", "Ecaterimburgo", "N\u00edjni Novgorod", "Volgogrado", "S\u00e3o Petesburgo", "Kaliningrado", "Rostov", "S\u00f3chi", "Moscou", "N\u00edjni Novgorod", "Ecaterimburgo", "Caz\u00e3"}, {"Samara", "Volgogrado", "Saransk", "Kaliningrado", "Moscou", "S\u00f3chi", "S\u00e3o Petesburgo", "Rostov", "Moscou", "N\u00edjni Novgorod", "Ecaterimburgo", "Caz\u00e3", "Kaliningrado", "Saransk", "Samara", "Volgogrado"}, {"S\u00f3chi", "Caz\u00e3", "Samara", "Rostov", "Moscou (Luzhniki)", "N\u00edjni Novgorod", "S\u00e3o Petesburgo", "Moscou (Spartak)", "", "", "", "", "", "", "", ""}, {"N\u00edjni Novgorod", "Caz\u00e3", "S\u00f3chi", "Samara", "", "", "", "", "", "", "", "", "", "", "", ""}, {"S\u00e3o Petersburgo", "Moscou (Luzhniki)", "", "", "", "", "", "", "", "", "", "", "", "", "", ""}, {"Moscou (Luzhniki)", "S\u00e3o Petersburgo", "", "", "", "", "", "", "", "", "", "", "", "", "", ""}};
        string = stringArrayArray[n2][n3];
        return string;
    }

    public Z eY(int n2) {
        int n3 = this.YH + n2 - 1;
        int[] nArray = new int[]{39, 131, 65, 11, 104, 97, 43, 3, 29, 162};
        if ((n3 %= 10) >= 0 && n3 < nArray.length) {
            return a.SR.s(nArray[n3]);
        }
        return null;
    }

    @Override
    public int cy(int n2) {
        int n3 = this.YH - 1;
        n3 %= 10;
        int n4 = 45000;
        int[] nArray = new int[]{80000, 65000, 52698, 48134, 45600, 34990, 37215, 28065};
        int[] nArray2 = new int[]{45000, 42000, 32698, 38134, 35600, 34990, 37215, 28065};
        if (this.YG != null && this.YG.jc() != 11 && this.YG.jc() != 29) {
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
        String[][] stringArrayArray = new String[][]{{"Lusail", "Al Khor", "Doha", "Al Wakrah", "Umm Salal", "Madinat", "Al Rayyan", "Doha"}, {"Nova York", "Los Angeles", "Atlanta", "Cid. M\u00e9xico", "Boston", "Guadalajara", "San Francisco", "Houston", "Monterrey", "Dallas", "Vancouver", "Toronto"}, {"Buenos Aires", "Santiago", "Montevid\u00e9u", "Assunci\u00f3n", "C\u00f3rdoba", "Concepci\u00f3n", "Mendoza", "Ros\u00e1rio", "La Plata", "Santa F\u00e9", "Almagro"}, {"Madrid", "Lisaboa", "Barcelona", "Porto", "Sevilha", "Val\u00eancia", "Braga", "M\u00e1laga", "Bilbau", "Braga"}, {"Roma", "Mil\u00e3o", "Turim", "Bologna", "Cagliari", "G\u00eanoa", "Floren\u00e7a", "Udine"}, {"Londres", "Liverpool", "Manchester", "Notthingam", "Leeds", "Coventry", "Sheffield", "Bristol"}, {"Pequim", "Guangzhou", "Hangzhou", "Nanquim", "Jinan", "Xangai", "Tianjin", "Chongqing"}, {"Berlim", "Munique", "Hamburgo", "Dortmund", "Frankfurt", "Hannover", "Leipzig", "Nuremberg"}, {"Rio de Janeiro", "S\u00e3o Paulo", "Belo Horizonte", "Fortaleza", "Salvador", "Porto Alegre", "Recife", "Curitiba"}, {"Moscou", "S\u00e3o Petesburgo", "Kazan", "Kaliningrad", "Yaroslavl", "Samara", "Volgograd", "Yekaterinburg"}};
        String string = null;
        string = n2 < stringArrayArray[n3 %= 10].length ? stringArrayArray[n3][n2] : (n2 - stringArrayArray[n3].length < stringArrayArray[n3].length ? stringArrayArray[n3][n2 - stringArrayArray[n3].length] : stringArrayArray[n3][0]);
        return string;
    }

    public s yd() {
        return this.YD;
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
        stringArray[0] = "tr_copamundo";
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

