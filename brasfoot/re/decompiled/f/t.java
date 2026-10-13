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
import f.z;
import h.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class t
extends at
implements Serializable {
    private static final long serialVersionUID = 1L;
    private s YD = null;
    private ArrayList YF = new ArrayList();
    private ah ZA = null;
    private ArrayList YV = new ArrayList();
    private z YP = null;
    private z YQ = null;

    public t() {
        this.setNome(M.getString("ligaCaf"));
        this.F(4, 2);
        this.yo();
    }

    private void yo() {
        this.YV.clear();
        this.YV.add(new am("tun", 190, 2));
        this.YV.add(new am("argl", 10, 3));
        this.YV.add(new am("egi", 57, 3));
        this.YV.add(new am("mar", 129, 3));
        this.YV.add(new am("afr sul", 1, 2));
        this.YV.add(new am("congo", 47, 1));
        this.YV.add(new am("cosMarf", 50, 1));
        this.YV.add(new am("gana", 75, 1));
        this.YV.add(new am("nigeria", 141, 1));
        this.YV.add(new am("mali", 127, 1));
        this.YV.add(new am("eti", 67, 1));
        this.YV.add(new am("camar", 36, 1));
        this.YV.add(new am("ang", 5, 1));
        this.YV.add(new am("rep.dem.cong.", 157, 1));
        this.YV.add(new am("sudao", 178, 1));
        this.YV.add(new am("zim", 201, 1));
        this.YV.add(new am("zam", 200, 1));
        this.YV.add(new am("guin", 81, 1));
        this.YV.add(new am("lib", 116, 1));
        this.YV.add(new am("sen", 169, 1));
        this.YV.add(new am("mo\u00e7", 133, 1));
        this.YV.add(new am("uga", 194, 1));
        this.YV.add(new am("tan", 186, 1));
    }

    public void a(int n2, al al2) {
        b.a(2, 1, this.YV, null, n2, al2);
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
        if (this.YF.size() < 32) {
            b.a(this.YF, this.YV, 32, arrayList2);
        }
        Collections.sort(this.YF, a.abm);
        ArrayList<ah> arrayList3 = new ArrayList<ah>();
        if (this.YF.size() >= 32) {
            s s2;
            int[] nArray = new int[32];
            nArray[1] = 15;
            nArray[2] = 23;
            nArray[3] = 31;
            nArray[4] = 3;
            nArray[5] = 14;
            nArray[6] = 22;
            nArray[7] = 29;
            nArray[8] = 5;
            nArray[9] = 13;
            nArray[10] = 21;
            nArray[11] = 27;
            nArray[12] = 7;
            nArray[13] = 12;
            nArray[14] = 20;
            nArray[15] = 25;
            nArray[16] = 1;
            nArray[17] = 11;
            nArray[18] = 19;
            nArray[19] = 30;
            nArray[20] = 2;
            nArray[21] = 10;
            nArray[22] = 18;
            nArray[23] = 28;
            nArray[24] = 4;
            nArray[25] = 9;
            nArray[26] = 17;
            nArray[27] = 26;
            nArray[28] = 6;
            nArray[29] = 8;
            nArray[30] = 16;
            nArray[31] = 24;
            int[] nArray2 = nArray;
            int n2 = 0;
            while (n2 < nArray2.length) {
                arrayList3.add((ah)this.YF.get(nArray2[n2]));
                ++n2;
            }
            LoadLigaOptions loadLigaOptions = new LoadLigaOptions();
            loadLigaOptions.nTimes = 32;
            loadLigaOptions.nGrupos = 8;
            loadLigaOptions.numeroTimesMataMata = 2;
            loadLigaOptions.doisTurnos = true;
            loadLigaOptions.pulaDuasDatas = true;
            this.YD = s2 = new s(loadLigaOptions, arrayList3, 0, null, null, null, 4, null, false, null, true, this);
            s2.setNome(this.getNome());
        } else {
            System.out.println("erro Liga Africa() " + this.YF.size());
        }
    }

    public void q(ArrayList arrayList, ArrayList arrayList2) {
    }

    public void g(ArrayList arrayList, ArrayList arrayList2) {
    }

    public void l(ArrayList arrayList, ArrayList arrayList2) {
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
        stringArray[0] = "tr_ligacaf";
        stringArray[1] = this.getNome();
        return stringArray;
    }

    public z By() {
        return this.YP;
    }

    public z Bz() {
        return this.YQ;
    }
}

