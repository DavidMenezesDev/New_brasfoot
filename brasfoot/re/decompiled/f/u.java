/*
 * Decompiled with CFR 0.152.
 */
package f;

import best.L;
import best.M;
import best.ah;
import best.at;
import components.al;
import components.am;
import components.y;
import est.LoadLigaOptions;
import f.b;
import f.s;
import h.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class u
extends at
implements Serializable {
    private static final long serialVersionUID = 1L;
    private s YD = null;
    private ArrayList YF = new ArrayList();
    private ah ZA = null;
    private ArrayList YV = new ArrayList();

    public u() {
        this.setNome(M.getString("ligaAfc"));
        this.F(4, 3);
        this.yo();
    }

    private void yo() {
        this.YV.clear();
        this.YV.add(new am("chn.", 43, 2));
        this.YV.add(new am("arab s.", 9, 3));
        this.YV.add(new am("jap", 107, 3));
        this.YV.add(new am("cor s.", 49, 3));
        this.YV.add(new am("cat", 39, 3));
        this.YV.add(new am("irn", 98, 3));
        this.YV.add(new am("emi", 59, 3));
        this.YV.add(new am("uzb", 196, 2));
        this.YV.add(new am("aus", 14, 2));
        this.YV.add(new am("tai", 183, 1));
        this.YV.add(new am("vie", 199, 1));
        this.YV.add(new am("ind", 95, 1));
        this.YV.add(new am("hk", 87, 1));
        this.YV.add(new am("sir", 174, 1));
        this.YV.add(new am("idn", 96, 1));
        this.YV.add(new am("irq", 99, 1));
        this.YV.add(new am("mal\u00e1sia", 124, 1));
        this.YV.add(new am("libano", 115, 1));
        this.YV.add(new am("tajiq", 182, 1));
        this.YV.add(new am("jord", 108, 1));
        this.YV.add(new am("sing", 173, 1));
        this.YV.add(new am("Filp", 71, 1));
        this.YV.add(new am("KorN", 48, 1));
        this.YV.add(new am("mianmar", 132, 1));
    }

    public void a(int n2, al al2) {
        b.a(3, 1, this.YV, null, n2, al2);
    }

    public void yq() {
        if (this.YD != null) {
            this.YD.aN(true);
        }
        this.YF.clear();
        this.YD = null;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (this.ZA != null) {
            this.YF.add(this.ZA);
        }
        arrayList2.addAll(this.YF);
        b.a(this.YV, this.YF, arrayList2, false);
        b.a(arrayList, this.YF, arrayList2, false);
        if (this.YF.size() < 40) {
            b.a(this.YF, this.YV, 40, arrayList2);
        }
        Collections.sort(this.YF, a.abm);
        ArrayList<ah> arrayList3 = new ArrayList<ah>();
        if (this.YF.size() >= 40) {
            s s2;
            int[] nArray = new int[40];
            nArray[1] = 10;
            nArray[2] = 20;
            nArray[3] = 30;
            nArray[4] = 1;
            nArray[5] = 11;
            nArray[6] = 21;
            nArray[7] = 31;
            nArray[8] = 2;
            nArray[9] = 12;
            nArray[10] = 22;
            nArray[11] = 32;
            nArray[12] = 3;
            nArray[13] = 13;
            nArray[14] = 23;
            nArray[15] = 33;
            nArray[16] = 4;
            nArray[17] = 14;
            nArray[18] = 24;
            nArray[19] = 34;
            nArray[20] = 5;
            nArray[21] = 15;
            nArray[22] = 25;
            nArray[23] = 35;
            nArray[24] = 6;
            nArray[25] = 16;
            nArray[26] = 26;
            nArray[27] = 36;
            nArray[28] = 7;
            nArray[29] = 17;
            nArray[30] = 27;
            nArray[31] = 37;
            nArray[32] = 8;
            nArray[33] = 18;
            nArray[34] = 28;
            nArray[35] = 38;
            nArray[36] = 9;
            nArray[37] = 19;
            nArray[38] = 29;
            nArray[39] = 39;
            int[] nArray2 = nArray;
            int n2 = 0;
            while (n2 < nArray2.length) {
                arrayList3.add((ah)this.YF.get(nArray2[n2]));
                ++n2;
            }
            LoadLigaOptions loadLigaOptions = new LoadLigaOptions();
            loadLigaOptions.nTimes = 40;
            loadLigaOptions.nGrupos = 10;
            loadLigaOptions.numeroTimesMataMata = 1;
            loadLigaOptions.melhoresTerceiros = true;
            loadLigaOptions.doisTurnos = true;
            loadLigaOptions.pulaDuasDatas = true;
            loadLigaOptions.var0 = 1403;
            this.YD = s2 = new s(loadLigaOptions, arrayList3, 0, null, null, null, 4, null, false, null, true, this);
            s2.setNome(this.getNome());
        } else {
            System.out.println("erro Liga Asiatica() " + this.YF.size());
        }
    }

    public ArrayList yy() {
        return this.YF;
    }

    public ah yz() {
        return this.ZA;
    }

    public void N(ah ah2) {
        this.ZA = ah2;
    }

    public s yd() {
        return this.YD;
    }

    @Override
    public void mr() {
        this.YD.za();
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
        stringArray[0] = "tr_ligaafc";
        stringArray[1] = this.getNome();
        return stringArray;
    }
}

