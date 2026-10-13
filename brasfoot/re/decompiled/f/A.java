/*
 * Decompiled with CFR 0.152.
 */
package f;

import best.L;
import best.M;
import best.ah;
import best.aq;
import best.at;
import c.a;
import f.G;
import f.z;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class A
extends at
implements Serializable {
    private static final long serialVersionUID = 1L;
    private z ZM = null;
    private z ZN = null;
    private ah ZO = null;
    private ah ZP = null;
    private ah ZQ = null;
    private ah ZR = null;
    private ah ZS = null;
    private ah ZT = null;

    public A() {
        this.setNome(M.getString("mundialclubes"));
        this.F(5, 7);
        this.O(true);
    }

    public void zC() {
        this.ZM = null;
        this.ZN = null;
        this.ZO = null;
        this.ZP = null;
        this.ZQ = null;
        this.ZR = null;
        this.ZS = null;
        this.ZT = null;
        if (a.SR.aI() != null) {
            this.ZO = a.SR.aI().cS();
            a.SR.aI().N(this.ZO);
        }
        if (a.SR.aF() != null) {
            this.ZP = a.SR.aF().cS();
            a.SR.aF().N(this.ZP);
            if (this.ZP != null && this.ZP.getPais() == 131) {
                this.ZP = a.SR.aF().yx();
            }
        }
        if (a.SR.aO() != null) {
            this.ZQ = a.SR.aO().cS();
            a.SR.aO().N(this.ZQ);
        }
        if (a.SR.aL() != null) {
            this.ZR = a.SR.aL().cS();
            a.SR.aL().N(this.ZR);
        }
        if (a.SR.aQ() != null) {
            this.ZS = a.SR.aQ().cS();
            a.SR.aQ().N(this.ZS);
        }
        if (a.SR.aP() != null) {
            this.ZT = a.SR.aP().cS();
            a.SR.aP().N(this.ZT);
        }
        if (this.ZO != null && this.ZP != null && this.ZQ != null && this.ZR != null && this.ZS != null && this.ZT != null) {
            ah[] ahArray = new ah[]{this.ZQ, this.ZR, this.ZS, this.ZT};
            int[] nArray = new int[4];
            nArray[0] = 2;
            nArray[2] = 3;
            nArray[3] = 1;
            int[] nArray2 = nArray;
            int[] nArray3 = new int[4];
            nArray3[0] = 3;
            nArray3[1] = 2;
            nArray3[2] = 1;
            int[] nArray4 = nArray3;
            int[] nArray5 = new int[4];
            nArray5[1] = 2;
            nArray5[2] = 3;
            nArray5[3] = 1;
            int[] nArray6 = nArray5;
            int n2 = new Random().nextInt(3);
            int[] nArray7 = new int[4];
            nArray7[0] = 2;
            nArray7[2] = 3;
            nArray7[3] = 1;
            int[] nArray8 = nArray7;
            nArray8 = n2 == 0 ? nArray2 : (n2 == 1 ? nArray4 : nArray6);
            ArrayList<ah> arrayList = new ArrayList<ah>();
            int n3 = 0;
            while (n3 < 4) {
                arrayList.add(ahArray[nArray8[n3]]);
                ++n3;
            }
            boolean[] blArray = new boolean[7];
            this.ZM = new z(null, arrayList.size(), this.b(), 1, blArray, this, -1);
            this.ZM.fc(150);
            G g2 = new G();
            g2.a(this.ZM, arrayList, 0, false, 0, 0, this.b(), false);
        }
    }

    public void al(ArrayList arrayList) {
        if (arrayList.size() == 2) {
            ArrayList<ah> arrayList2 = new ArrayList<ah>();
            arrayList2.add(this.ZP);
            arrayList2.add((ah)arrayList.get(0));
            arrayList2.add(this.ZO);
            arrayList2.add((ah)arrayList.get(1));
            boolean[] blArray = new boolean[7];
            this.ZN = new z(null, arrayList2.size(), this.b(), 0, blArray, this, -1);
            G g2 = new G();
            g2.a(this.ZN, arrayList2, 0, false, 0, 0, this.b(), false);
        }
    }

    public z zD() {
        return this.ZM;
    }

    public z zE() {
        return this.ZN;
    }

    @Override
    public String[] b(L l2) {
        if (l2 == this.ZM) {
            return aq.pE;
        }
        return aq.pF;
    }

    @Override
    public L[] mB() {
        L[] lArray = new L[]{this.ZM};
        L[] lArray2 = new L[]{this.ZM, this.ZN};
        if (this.ZN == null) {
            return lArray;
        }
        return lArray2;
    }

    @Override
    public void mr() {
        this.ZN.z(this);
    }

    public static ArrayList eX(int n2) {
        String[] stringArray;
        ArrayList<void> arrayList = new ArrayList<void>();
        String[] stringArray2 = null;
        if (n2 == 1) {
            stringArray2 = stringArray = new String[]{"Campe\u00e3o Libertadores", "vencedor quartas 1", "Campe\u00e3o L. Campe\u00f5es", "vencedor quartas 2"};
        } else if (n2 == 2) {
            stringArray2 = stringArray = new String[]{"Vencedor Semi-Final 1", "Vencedor Semi-Final 2", "Perdedor Semi-Final 1", "Perdedor Semi-Final 2"};
        }
        int n3 = 0;
        while (n3 < stringArray2.length) {
            arrayList.add(stringArray2[n3]);
            ++n3;
        }
        return arrayList;
    }

    @Override
    public String[] mA() {
        String[] stringArray = new String[]{"", ""};
        stringArray[0] = "tr_mundial";
        stringArray[1] = this.getNome();
        return stringArray;
    }
}

