/*
 * Decompiled with CFR 0.152.
 */
package f;

import best.L;
import best.Z;
import best.ac;
import best.ah;
import best.aq;
import best.at;
import c.a;
import f.B;
import f.G;
import f.z;
import java.io.Serializable;
import java.util.ArrayList;

public class I
extends at
implements Serializable {
    private static final long serialVersionUID = 1L;
    private z aac = null;
    private ArrayList cE = new ArrayList();
    private int pais;

    public I() {
    }

    public I(int n2) {
        this.pais = n2;
        Z z2 = a.SR.o(this.pais);
        this.setNome("Supercopa - " + z2.jf());
        this.F(11, n2);
    }

    public void Ab() {
        ah ah2 = null;
        ah ah3 = null;
        Z z2 = a.SR.o(this.pais);
        if (z2 != null && z2.eb() != null && z2.eb().size() > 0) {
            ah2 = ((B)z2.eb().get(0)).cv(a.SR.H() - 1);
            ah[] ahArray = z2.bk(a.SR.H() - 1);
            if (ahArray != null) {
                ah3 = ah2 != ahArray[0] ? ahArray[0] : ahArray[1];
            }
            this.b(ah2, ah3);
        }
    }

    public void b(ah ah2, ah ah3) {
        this.cE.clear();
        this.aac = null;
        boolean[] blArray = new boolean[7];
        if (ah2 != null && ah3 != null) {
            this.cE.add(ah2);
            this.cE.add(ah3);
            this.aac = new z(null, this.cE.size(), 11, 0, blArray, this, -1);
            G g2 = new G();
            g2.a(this.aac, this.cE, 0, blArray[0], 0, 0, 11, false);
        }
    }

    @Override
    public void mr() {
        this.aac.z(this);
    }

    public z zS() {
        return this.aac;
    }

    public int getPais() {
        return this.pais;
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
        String string = "tr_supercopa_" + ac.valueOf("P" + Integer.toString(this.pais)).jA();
        String string2 = "tr_supercopa_generico";
        stringArray[0] = aq.w(string) ? string : string2;
        stringArray[1] = this.getNome();
        return stringArray;
    }
}

