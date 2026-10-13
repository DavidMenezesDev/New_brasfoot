/*
 * Decompiled with CFR 0.152.
 */
package f;

import best.L;
import best.M;
import best.Z;
import best.ah;
import best.aq;
import best.at;
import c.a;
import components.al;
import components.am;
import components.as;
import components.y;
import est.LoadLigaOptions;
import f.G;
import f.b;
import f.s;
import f.z;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class H
extends at
implements Serializable {
    private static final long serialVersionUID = 1L;
    private z YJ = null;
    private s YD = null;
    private ArrayList YF = new ArrayList();
    private ArrayList YS = new ArrayList();
    private ArrayList aao = new ArrayList();
    private ah ZA = null;
    private ArrayList YV = new ArrayList();
    private ArrayList YW = new ArrayList();

    public H() {
        this.setNome(M.getString("csa"));
        this.F(6, 1);
        this.yo();
        this.yp();
    }

    private void yo() {
        this.YV.clear();
        this.YV.add(new am("bra", 29, 3));
        this.YV.add(new am("bra", 29, 3));
        this.YV.add(new am("arg", 11, 6));
    }

    private void yp() {
        this.YW.clear();
        this.YW.add(new am("bol", 26, 4));
        this.YW.add(new am("chil", 42, 4));
        this.YW.add(new am("col", 46, 4));
        this.YW.add(new am("equ", 60, 4));
        this.YW.add(new am("par", 150, 4));
        this.YW.add(new am("per", 151, 4));
        this.YW.add(new am("uru", 195, 4));
        this.YW.add(new am("vez", 198, 4));
    }

    public void a(int n2, al al2) {
        b.a(1, 2, this.YV, this.YW, n2, al2);
    }

    public void yq() {
        if (this.YD != null) {
            this.YD.aN(true);
        }
        this.YD = null;
        this.YJ = null;
        this.YF.clear();
        this.YS.clear();
        this.aao.clear();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(a.SR.aF().yy());
        arrayList.addAll(a.SR.aF().yE());
        b.a(this.YV, this.YF, arrayList, false);
        b.a(this.YW, this.YS, arrayList, false);
        if (this.YF.size() < 12) {
            b.a(this.YF, this.YV, 12, arrayList);
        }
        if (this.YF.size() < 12) {
            b.a(this.YF, this.YV, 12, arrayList);
        }
        if (this.YS.size() < 32) {
            b.a(this.YS, this.YW, 32, arrayList);
        }
        if (this.YS.size() < 32) {
            b.a(this.YS, this.YV, 32, arrayList);
        }
        Collections.sort(this.YF, h.a.abm);
        ArrayList arrayList2 = new ArrayList();
        if (this.YS.size() == 32) {
            int n2 = 0;
            while (n2 <= 7) {
                arrayList2.addAll(this.b(this.YS, n2, 4));
                ++n2;
            }
        }
        if (arrayList2.size() == 32 && this.YF.size() == 12) {
            boolean[] blArray = new boolean[7];
            blArray[0] = true;
            boolean[] blArray2 = blArray;
            this.YJ = new z(null, arrayList2.size(), 6, 1, blArray2, this, 6100);
            G g2 = new G();
            g2.a(this.YJ, arrayList2, 0, true, 0, 0, 6, false);
        } else {
            System.out.println("erro sul americana size:" + this.YS.size() + " " + this.YF.size() + " " + arrayList2.size());
        }
    }

    public void o(ArrayList arrayList, ArrayList arrayList2) {
        int n2 = 0;
        while (n2 < arrayList2.size()) {
            ((ah)arrayList2.get(n2)).a(this, -1, 6100);
            ++n2;
        }
        ArrayList arrayList3 = new ArrayList();
        arrayList3.addAll(this.aao);
        arrayList3.addAll(arrayList);
        arrayList3.addAll(this.YF);
        Collections.sort(arrayList3, h.a.abm);
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        arrayList4.addAll(this.b(arrayList3, 0, 8));
        arrayList5.addAll(this.b(arrayList3, 1, 8));
        arrayList6.addAll(this.b(arrayList3, 2, 8));
        arrayList7.addAll(this.b(arrayList3, 3, 8));
        components.aq[] aqArray = new components.aq[8];
        int n3 = 0;
        while (n3 <= 7) {
            aqArray[n3] = new components.aq();
            ++n3;
        }
        n3 = 0;
        while (n3 <= 7) {
            aqArray[n3].a(arrayList4, arrayList5, arrayList6, arrayList7);
            ++n3;
        }
        aqArray[0].a(aqArray);
        ArrayList arrayList8 = new ArrayList();
        int n4 = 0;
        while (n4 <= 7) {
            arrayList8.addAll(aqArray[n4].cZ());
            ++n4;
        }
        if (arrayList8.size() == 32) {
            boolean[] blArray = new boolean[7];
            blArray[0] = true;
            blArray[1] = true;
            blArray[2] = true;
            boolean[] blArray2 = blArray;
            LoadLigaOptions loadLigaOptions = new LoadLigaOptions();
            loadLigaOptions.nTimes = 32;
            loadLigaOptions.nGrupos = 8;
            loadLigaOptions.numeroTimesMataMata = 1;
            loadLigaOptions.doisTurnos = true;
            loadLigaOptions.pulaDuasDatas = false;
            loadLigaOptions.duasVoltasMataMata = blArray2;
            s s2 = new s(loadLigaOptions, arrayList8, 0, null, null, null, 6, null, false, null, true, this);
            s2.fb(6105);
            this.YD = s2;
            s2.setNome(this.getNome());
        }
    }

    public void yt() {
        ArrayList<ah> arrayList = new ArrayList<ah>();
        ArrayList<ah> arrayList2 = new ArrayList<ah>();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        int n2 = 0;
        while (n2 < this.YD.yQ().size()) {
            arrayList.add((ah)((best.G)this.YD.yQ().get(n2)).gR().get(0));
            ++n2;
        }
        n2 = 0;
        while (n2 < a.SR.aF().yd().yQ().size()) {
            arrayList2.add((ah)((best.G)a.SR.aF().yd().yQ().get(n2)).gR().get(2));
            ++n2;
        }
        Collections.shuffle(arrayList);
        Collections.shuffle(arrayList2);
        components.aq[] aqArray = new components.aq[8];
        int n3 = 0;
        while (n3 <= 7) {
            aqArray[n3] = new components.aq();
            ++n3;
        }
        n3 = 0;
        while (n3 <= 7) {
            aqArray[n3].f(arrayList, arrayList2);
            ++n3;
        }
        n3 = 0;
        while (n3 <= 7) {
            arrayList4.addAll(aqArray[n3].cZ());
            ++n3;
        }
        boolean[] blArray = new boolean[7];
        blArray[0] = true;
        blArray[1] = true;
        blArray[2] = true;
        boolean[] blArray2 = blArray;
        this.YD.c(new z(this.YD, arrayList4.size(), this.b(), 0, blArray2, this, -1));
        G g2 = new G();
        g2.a(this.YD.yY(), arrayList4, 0, blArray2[0], 0, 0, this.b(), false);
    }

    private ArrayList b(ArrayList arrayList, int n2, int n3) {
        ArrayList<ah> arrayList2 = new ArrayList<ah>();
        int n4 = n2 * n3;
        int n5 = n4 + (n3 - 1);
        int n6 = n4;
        while (n6 <= n5) {
            arrayList2.add((ah)arrayList.get(n6));
            ++n6;
        }
        Collections.shuffle(arrayList2);
        return arrayList2;
    }

    public ah yz() {
        return this.ZA;
    }

    public void N(ah ah2) {
        this.ZA = ah2;
    }

    @Override
    public void mr() {
        this.YD.za();
    }

    @Override
    public Z mF() {
        int n2 = a.SR.H() - 1;
        int[] nArray = new int[]{11, 29, 150, 42, 46, 151, 195, 26, 198, 60};
        if ((n2 %= 10) < nArray.length) {
            return a.SR.s(nArray[n2]);
        }
        return null;
    }

    public static String yD() {
        int n2 = a.SR.H() - 1;
        String string = "";
        String[] stringArray = new String[]{"Assun\u00e7\u00e3o", "Lima", "S\u00e3o Paulo", "Caracas", "Quito", "Medell\u00edn", "La Paz", "Montevid\u00e9u", "Santiago", "C\u00f3rdoba"};
        string = stringArray[n2 %= 10];
        return string;
    }

    public void c(ArrayList arrayList, int n2) {
        int n3 = 0;
        while (n3 < arrayList.size()) {
            if (((ah)arrayList.get(n3)).jZ().booleanValue()) {
                if (n2 == 0) {
                    new as(((ah)arrayList.get(n3)).ka(), 32, 87, "", "");
                } else {
                    new as(((ah)arrayList.get(n3)).ka(), 33, 88, "", "");
                }
            }
            ++n3;
        }
    }

    @Override
    public L[] mB() {
        L[] lArray = new L[]{this.YD};
        if (this.YD == null) {
            L[] lArray2 = new L[]{this.YJ};
            lArray = lArray2;
        } else if (this.YD.yZ()) {
            L[] lArray3 = new L[]{this.YD.yY()};
            lArray = lArray3;
        }
        return lArray;
    }

    @Override
    public ArrayList mC() {
        ArrayList<y> arrayList = new ArrayList<y>();
        L[] lArray = new L[]{this.YJ};
        arrayList.add(new y(lArray, "Fase Preliminar"));
        L[] lArray2 = new L[]{this.YD};
        arrayList.add(new y(lArray2, "Fase de Grupos"));
        if (this.YD != null) {
            L[] lArray3 = new L[]{this.YD.yY()};
            arrayList.add(new y(lArray3, "Fase Final"));
        } else {
            arrayList.add(new y(null, "Fase Final"));
        }
        return arrayList;
    }

    @Override
    public String[] b(L l2) {
        if (l2 == this.YJ) {
            return aq.pM;
        }
        return aq.pA;
    }

    @Override
    public String[] mA() {
        String[] stringArray = new String[]{"", ""};
        stringArray[0] = "tr_sulamericana";
        stringArray[1] = this.getNome();
        return stringArray;
    }

    public ArrayList Aa() {
        return this.aao;
    }

    @Override
    public boolean cz(int n2) {
        return this.YD != null && this.YD.yY() != null && this.YD.yY().zq() == n2;
    }
}

