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

public class w
extends at
implements Serializable {
    private static final long serialVersionUID = 1L;
    private s YD = null;
    private ArrayList YF = new ArrayList();
    private ah ZA = null;
    private ArrayList YV = new ArrayList();

    public w() {
        this.setNome(M.getString("ligaConcacaf"));
        this.F(4, 4);
        this.yo();
    }

    private void yo() {
        this.YV.clear();
        this.YV.add(new am("nic", 139, 1));
        this.YV.add(new am("mex", 131, 4));
        this.YV.add(new am("eua", 68, 3));
        this.YV.add(new am("can", 38, 1));
        this.YV.add(new am("cosr", 51, 2));
        this.YV.add(new am("hon", 86, 1));
        this.YV.add(new am("guat", 79, 2));
        this.YV.add(new am("pan", 147, 2));
        this.YV.add(new am("els", 58, 1));
        this.YV.add(new am("belize", 22, 1));
        this.YV.add(new am("triT", 189, 1));
        this.YV.add(new am("jam", 106, 1));
        this.YV.add(new am("haiti", 84, 1));
        this.YV.add(new am("cub", 53, 1));
        this.YV.add(new am("rep dom", 158, 1));
    }

    public void a(int n2, al al2) {
        b.a(4, 1, this.YV, null, n2, al2);
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
        if (this.YF.size() < 24) {
            b.a(this.YF, this.YV, 24, arrayList2);
        }
        Collections.sort(this.YF, a.abm);
        ArrayList<ah> arrayList3 = new ArrayList<ah>();
        if (this.YF.size() >= 24) {
            s s2;
            int[] nArray = new int[24];
            nArray[1] = 15;
            nArray[2] = 23;
            nArray[3] = 4;
            nArray[4] = 14;
            nArray[5] = 22;
            nArray[6] = 6;
            nArray[7] = 13;
            nArray[8] = 21;
            nArray[9] = 2;
            nArray[10] = 11;
            nArray[11] = 20;
            nArray[12] = 1;
            nArray[13] = 12;
            nArray[14] = 19;
            nArray[15] = 5;
            nArray[16] = 10;
            nArray[17] = 18;
            nArray[18] = 7;
            nArray[19] = 9;
            nArray[20] = 17;
            nArray[21] = 3;
            nArray[22] = 8;
            nArray[23] = 16;
            int[] nArray2 = nArray;
            int n2 = 0;
            while (n2 < nArray2.length) {
                arrayList3.add((ah)this.YF.get(nArray2[n2]));
                ++n2;
            }
            LoadLigaOptions loadLigaOptions = new LoadLigaOptions();
            loadLigaOptions.nTimes = 24;
            loadLigaOptions.nGrupos = 8;
            loadLigaOptions.numeroTimesMataMata = 1;
            loadLigaOptions.doisTurnos = true;
            loadLigaOptions.pulaDuasDatas = true;
            this.YD = s2 = new s(loadLigaOptions, arrayList3, 0, null, null, null, 4, null, false, null, true, this);
            s2.setNome(this.getNome());
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

    public static ArrayList yc() {
        ArrayList<String> arrayList = new ArrayList<String>();
        String[] stringArray = new String[]{"1\u00ba G1", "1\u00ba G8", "1\u00ba G2", "1\u00ba G7", "1\u00ba G3", "1\u00ba G6", "1\u00ba G4", "1\u00ba G5"};
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
        stringArray[0] = "tr_ligaconcacaf";
        stringArray[1] = this.getNome();
        return stringArray;
    }
}

