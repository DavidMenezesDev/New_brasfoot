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
import est.LoadLigaOptions;
import f.b;
import f.s;
import h.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class y
extends at
implements Serializable {
    private static final long serialVersionUID = 1L;
    private s YD = null;
    private ArrayList YF = new ArrayList();
    private ah ZA = null;
    private ArrayList YV = new ArrayList();

    public y() {
        this.setNome(M.getString("ligaOfc"));
        this.F(4, 5);
        this.yo();
    }

    private void yo() {
        this.YV.clear();
        this.YV.add(new am("nze", 143, 2));
        this.YV.add(new am("pap", 148, 1));
        this.YV.add(new am("ilha s", 93, 1));
        this.YV.add(new am("taiti", 184, 1));
        this.YV.add(new am("fiji", 69, 1));
        this.YV.add(new am("van", 197, 1));
        this.YV.add(new am("novaCal", 215, 1));
    }

    public void a(int n2, al al2) {
        b.a(5, 1, this.YV, null, n2, al2);
    }

    public void yq() {
        if (this.YD != null) {
            this.YD.aN(true);
        }
        this.YF.clear();
        this.YD = null;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        b.a(this.YV, this.YF, arrayList2, false);
        if (this.YF.size() < 8) {
            b.a(this.YF, this.YV, 8, arrayList2);
        }
        Collections.sort(this.YF, a.abm);
        ArrayList<ah> arrayList3 = new ArrayList<ah>();
        if (this.YF.size() >= 8) {
            s s2;
            int[] nArray = new int[8];
            nArray[1] = 2;
            nArray[2] = 4;
            nArray[3] = 6;
            nArray[4] = 1;
            nArray[5] = 3;
            nArray[6] = 5;
            nArray[7] = 7;
            int[] nArray2 = nArray;
            int n2 = 0;
            while (n2 < nArray2.length) {
                arrayList3.add((ah)this.YF.get(nArray2[n2]));
                ++n2;
            }
            LoadLigaOptions loadLigaOptions = new LoadLigaOptions();
            loadLigaOptions.nTimes = 8;
            loadLigaOptions.nGrupos = 2;
            loadLigaOptions.numeroTimesMataMata = 2;
            loadLigaOptions.doisTurnos = true;
            loadLigaOptions.pulaDuasDatas = true;
            this.YD = s2 = new s(loadLigaOptions, arrayList3, 0, null, null, null, 4, null, false, null, true, this);
            s2.setNome(this.getNome());
        } else {
            System.out.println("erro Liga Ofc() " + this.YF.size());
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

    public static ArrayList yc() {
        ArrayList<String> arrayList = new ArrayList<String>();
        String[] stringArray = new String[]{"1\u00ba G1", "2\u00ba G2", "1\u00ba G2", "2\u00ba G1"};
        int n2 = 0;
        while (n2 < stringArray.length) {
            arrayList.add(stringArray[n2]);
            ++n2;
        }
        return arrayList;
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
        ArrayList<components.y> arrayList = new ArrayList<components.y>();
        L[] lArray = new L[]{this.YD};
        arrayList.add(new components.y(lArray, "Fase de Grupos"));
        L[] lArray2 = new L[]{this.YD.yY()};
        arrayList.add(new components.y(lArray2, "Fase Final"));
        return arrayList;
    }

    @Override
    public String[] mA() {
        String[] stringArray = new String[]{"", ""};
        stringArray[0] = "tr_ligaofc";
        stringArray[1] = this.getNome();
        return stringArray;
    }
}

