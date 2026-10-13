/*
 * Decompiled with CFR 0.152.
 */
package f;

import best.L;
import best.ah;
import best.at;
import f.G;
import f.z;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class K
extends at
implements Serializable {
    private static final long serialVersionUID = 1L;
    private ah agg = null;
    private ah agh = null;
    private String agi = null;
    private z aac = null;
    private int YH = 0;
    String[] agj = new String[]{"Buenos Aires", "Rio de Janeiro", "S\u00e3o Paulo", "Santiago", "Lima", "Belo Horizonte", "Motevid\u00e9u", "Quito", "Bogot\u00e1"};
    int[] agk = new int[]{11, 29, 29, 42, 151, 29, 195, 60, 46};
    String[] agl = new String[]{"Roma", "Madrid", "Kiev", "Vars\u00f3via", "Paris", "Lisboa", "Berlim", "Mil\u00e3o", "Munique", "Londres", "Liverpool", "Viena", "Budapeste", "Istambul"};
    int[] agm = new int[]{104, 65, 193, 152, 72, 154, 3, 104, 3, 97, 97, 15, 88, 192};

    public K() {
        this.F(13, 7);
    }

    public void Bs() {
        this.agi = null;
        if (this.agg != null && this.agh != null) {
            ArrayList<ah> arrayList = new ArrayList<ah>();
            boolean[] blArray = new boolean[7];
            arrayList.add(this.agg);
            arrayList.add(this.agh);
            this.aac = new z(null, arrayList.size(), 13, 0, blArray, this, -1);
            G g2 = new G();
            g2.a(this.aac, arrayList, 0, blArray[0], 0, 0, 13, false);
            ++this.YH;
            while (this.agi == null) {
                this.ag(this.agg.getPais(), this.agh.getPais());
            }
        }
    }

    private void ag(int n2, int n3) {
        boolean bl2 = false;
        String[] stringArray = new String[]{""};
        int[] nArray = new int[]{};
        if (this.YH % 2 == 0) {
            bl2 = true;
        }
        if (!bl2) {
            stringArray = this.agl;
            nArray = this.agm;
        } else {
            stringArray = this.agj;
            nArray = this.agk;
        }
        int n4 = new Random().nextInt(stringArray.length);
        if (n2 != nArray[n4] && n3 != nArray[n4]) {
            this.agi = stringArray[n4];
        }
    }

    @Override
    public int cy(int n2) {
        int[] nArray = new int[]{65000, 55000, 52698};
        int n3 = new Random().nextInt(nArray.length);
        return nArray[n3] + new Random().nextInt(5000);
    }

    @Override
    public String cx(int n2) {
        return this.agi;
    }

    public void Z(ah ah2) {
        this.agg = ah2;
    }

    public void aa(ah ah2) {
        this.agh = ah2;
    }

    @Override
    public L[] mB() {
        L[] lArray = new L[]{this.aac};
        return lArray;
    }

    @Override
    public ArrayList mC() {
        return null;
    }

    @Override
    public String[] b(L l2) {
        return this.aac.zB();
    }

    @Override
    public String[] mA() {
        String[] stringArray = new String[]{"", ""};
        stringArray[0] = "tr_finalissima";
        stringArray[1] = this.getNome();
        return stringArray;
    }

    @Override
    public void mr() {
        this.aac.z(this);
    }

    public ah BT() {
        return this.agg;
    }
}

