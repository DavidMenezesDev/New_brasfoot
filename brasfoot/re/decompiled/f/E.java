/*
 * Decompiled with CFR 0.152.
 */
package f;

import best.L;
import best.M;
import best.ah;
import best.at;
import c.a;
import f.G;
import f.z;
import java.io.Serializable;
import java.util.ArrayList;

public class E
extends at
implements Serializable {
    private static final long serialVersionUID = 1L;
    private z aac = null;
    private ArrayList cE = new ArrayList();

    public E() {
        this.setNome(M.getString("recopaS"));
        this.F(8, 1);
    }

    public void zR() {
        this.cE.clear();
        this.aac = null;
        ah ah2 = null;
        ah ah3 = null;
        if (a.SR.aF() != null) {
            ah2 = a.SR.aF().yz();
        }
        if (a.SR.aH() != null) {
            ah3 = a.SR.aH().yz();
        }
        boolean[] blArray = new boolean[]{true, true, true, true, true, true, true};
        if (ah2 != null && ah3 != null && ah2 != ah3) {
            this.cE.add(ah3);
            this.cE.add(ah2);
            this.aac = new z(null, this.cE.size(), 8, 0, blArray, this, -1);
            G g2 = new G();
            g2.a(this.aac, this.cE, 0, true, 0, 0, 8, false);
        }
    }

    @Override
    public void mr() {
        this.aac.z(this);
    }

    public z zS() {
        return this.aac;
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
        stringArray[0] = "tr_recopasulamaericana";
        stringArray[1] = this.getNome();
        return stringArray;
    }
}

