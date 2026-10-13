/*
 * Decompiled with CFR 0.152.
 */
package f;

import best.L;
import best.M;
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

public class l
extends at
implements Serializable {
    private static final long serialVersionUID = 1L;
    private s YD = null;
    private z afV = null;
    private int age = 7;

    public l() {
        this.F(9, 0);
    }

    public void xZ() {
        if (this.YD != null) {
            this.YD.aN(true);
        }
        this.afV = null;
        this.YD = null;
    }

    public void fF(int n2) {
        this.age = n2;
        if (n2 == 7) {
            this.setNome(M.getString("eliEU"));
            this.F(9, 0);
        } else {
            this.setNome("Classificat\u00f3rio Eurocopa");
            this.F(9, 70);
        }
        ArrayList<Z> arrayList = new ArrayList<Z>();
        ArrayList<ah> arrayList2 = new ArrayList<ah>();
        int n3 = 0;
        while (n3 < a.SR.aG().size()) {
            if (((Z)a.SR.aG().get(n3)).jo() != null && ((Z)a.SR.aG().get(n3)).gg() == 0) {
                arrayList.add((Z)a.SR.aG().get(n3));
            }
            ((Z)a.SR.aG().get(n3)).z(true);
            ++n3;
        }
        Collections.sort(arrayList, Z.cN);
        n3 = 0;
        while (n3 < arrayList.size()) {
            arrayList2.add(((Z)arrayList.get(n3)).jo());
            ++n3;
        }
        ArrayList<ah> arrayList3 = new ArrayList<ah>();
        ArrayList<ah> arrayList4 = new ArrayList<ah>();
        ArrayList<ah> arrayList5 = new ArrayList<ah>();
        ArrayList<ah> arrayList6 = new ArrayList<ah>();
        ArrayList<ah> arrayList7 = new ArrayList<ah>();
        ArrayList<ah> arrayList8 = new ArrayList<ah>();
        int n4 = 0;
        while (n4 <= 9) {
            arrayList3.add((ah)arrayList2.get(n4));
            ++n4;
        }
        n4 = 10;
        while (n4 <= 19) {
            arrayList4.add((ah)arrayList2.get(n4));
            ++n4;
        }
        n4 = 20;
        while (n4 <= 29) {
            arrayList5.add((ah)arrayList2.get(n4));
            ++n4;
        }
        n4 = 30;
        while (n4 <= 39) {
            arrayList6.add((ah)arrayList2.get(n4));
            ++n4;
        }
        n4 = 40;
        while (n4 <= 49) {
            arrayList7.add((ah)arrayList2.get(n4));
            ++n4;
        }
        n4 = 50;
        while (n4 <= 54) {
            arrayList8.add((ah)arrayList2.get(n4));
            ++n4;
        }
        Collections.shuffle(arrayList3);
        Collections.shuffle(arrayList4);
        Collections.shuffle(arrayList5);
        Collections.shuffle(arrayList6);
        Collections.shuffle(arrayList7);
        Collections.shuffle(arrayList8);
        ArrayList<ah> arrayList9 = new ArrayList<ah>();
        int n5 = 0;
        while (n5 <= 9) {
            arrayList9.add((ah)arrayList3.get(n5));
            arrayList9.add((ah)arrayList4.get(n5));
            arrayList9.add((ah)arrayList5.get(n5));
            arrayList9.add((ah)arrayList6.get(n5));
            arrayList9.add((ah)arrayList7.get(n5));
            if (n5 > 4) {
                arrayList9.add((ah)arrayList8.get(n5 - 5));
            }
            ++n5;
        }
        LoadLigaOptions loadLigaOptions = new LoadLigaOptions();
        loadLigaOptions.nTimes = 55;
        loadLigaOptions.nGrupos = 10;
        loadLigaOptions.doisTurnos = true;
        loadLigaOptions.gruposNumeroDiferenteTimes = true;
        loadLigaOptions.numeroDefinidoTimesPorGrupo[0] = 5;
        loadLigaOptions.numeroDefinidoTimesPorGrupo[1] = 5;
        loadLigaOptions.numeroDefinidoTimesPorGrupo[2] = 5;
        loadLigaOptions.numeroDefinidoTimesPorGrupo[3] = 5;
        loadLigaOptions.numeroDefinidoTimesPorGrupo[4] = 5;
        loadLigaOptions.numeroDefinidoTimesPorGrupo[5] = 6;
        loadLigaOptions.numeroDefinidoTimesPorGrupo[6] = 6;
        loadLigaOptions.numeroDefinidoTimesPorGrupo[7] = 6;
        loadLigaOptions.numeroDefinidoTimesPorGrupo[8] = 6;
        loadLigaOptions.numeroDefinidoTimesPorGrupo[9] = 6;
        s s2 = new s(loadLigaOptions, arrayList9, 0, null, null, null, 9, null, false, null, true, this);
        s2.fb(9001);
        this.YD = s2;
        s2.setNome(this.getNome());
        a.afQ.L(arrayList9);
    }

    public void Bk() {
        int n2;
        ArrayList<ah> arrayList = new ArrayList<ah>();
        ArrayList<ah> arrayList2 = new ArrayList<ah>();
        if (this.age == 7) {
            n2 = 0;
            while (n2 < this.YD.yQ().size()) {
                arrayList.add((ah)((best.G)this.YD.yQ().get(n2)).gR().get(1));
                ++n2;
            }
            n2 = 0;
            while (n2 < this.YD.yQ().size()) {
                arrayList2.add((ah)((best.G)this.YD.yQ().get(n2)).gR().get(2));
                ++n2;
            }
            s.r(this.YD);
            Collections.sort(arrayList2, h.a.abn);
            n2 = 0;
            while (n2 <= 1) {
                arrayList.add((ah)arrayList2.get(n2));
                ++n2;
            }
        } else {
            n2 = 0;
            while (n2 < this.YD.yQ().size()) {
                arrayList2.add((ah)((best.G)this.YD.yQ().get(n2)).gR().get(2));
                ++n2;
            }
            s.r(this.YD);
            Collections.sort(arrayList2, h.a.abn);
            n2 = 0;
            while (n2 <= 7) {
                arrayList.add((ah)arrayList2.get(n2));
                ++n2;
            }
        }
        boolean[] blArray = new boolean[]{true, true, true, true, true, true, true};
        this.afV = new z(null, arrayList.size(), this.b(), 1, blArray, this, 9002);
        G g2 = new G();
        g2.a(this.afV, arrayList, 0, blArray[0], 0, 0, this.b(), false);
    }

    public void az(ArrayList arrayList) {
        if (this.age == 7) {
            int n2 = 0;
            while (n2 < this.YD.yQ().size()) {
                a.SR.aY().a(this, a.SR.s(((ah)((best.G)this.YD.yQ().get(n2)).gR().get(0)).getPais()));
                ++n2;
            }
            n2 = 0;
            while (n2 < arrayList.size()) {
                a.SR.aY().a(this, a.SR.s(((ah)arrayList.get(n2)).getPais()));
                ++n2;
            }
        } else {
            int n3 = 0;
            while (n3 < this.YD.yQ().size()) {
                a.SR.ba().a(this, a.SR.s(((ah)((best.G)this.YD.yQ().get(n3)).gR().get(0)).getPais()));
                a.SR.ba().a(this, a.SR.s(((ah)((best.G)this.YD.yQ().get(n3)).gR().get(1)).getPais()));
                ++n3;
            }
            n3 = 0;
            while (n3 < arrayList.size()) {
                a.SR.ba().a(this, a.SR.s(((ah)arrayList.get(n3)).getPais()));
                ++n3;
            }
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

    @Override
    public L[] mB() {
        L[] lArray = new L[]{this.YD};
        if (this.afV != null) {
            L[] lArray2 = new L[]{this.afV};
            lArray = lArray2;
        }
        return lArray;
    }

    @Override
    public ArrayList mC() {
        ArrayList<y> arrayList = new ArrayList<y>();
        L[] lArray = new L[]{this.YD};
        arrayList.add(new y(lArray, "Fase de Grupos"));
        L[] lArray2 = new L[]{this.afV};
        arrayList.add(new y(lArray2, "Play-offs"));
        return arrayList;
    }
}

