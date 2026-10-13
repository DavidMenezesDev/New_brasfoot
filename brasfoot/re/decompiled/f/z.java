/*
 * Decompiled with CFR 0.152.
 */
package f;

import best.I;
import best.L;
import best.Z;
import best.ah;
import best.aq;
import best.at;
import best.w;
import f.G;
import f.s;
import java.io.Serializable;
import java.util.ArrayList;

public class z
extends L
implements Serializable {
    private static final long serialVersionUID = 1L;
    private s nS = null;
    private at YY = null;
    private int tR;
    private ArrayList ZF = new ArrayList();
    private int ZG = 0;
    private int Zf = 0;
    private int ZH;
    private transient int ZI = 0;
    private transient int ZJ = 0;
    private boolean[] ZK = new boolean[]{true, true, true, true, true, true, true};
    private int Zg = -1;
    boolean ZL = true;

    public z() {
    }

    public z(s s2, int n2, int n3, int n4, boolean[] blArray, at at2, int n5) {
        this.YY = at2;
        this.nS = s2;
        this.tR = n3;
        this.Zg = n5;
        this.ZK = blArray;
        this.setNome(at2.getNome());
        if (n4 > 0) {
            this.ZG = n4 - 1;
            this.ZL = false;
        } else {
            int n6 = 1;
            if (this.Zg == 2029) {
                n6 = 7;
            } else if (n2 == 128) {
                n6 = 7;
            } else if (n2 == 64) {
                n6 = 6;
            } else if (n2 == 32) {
                n6 = 5;
            } else if (n2 == 16) {
                n6 = 4;
            } else if (n2 == 8) {
                n6 = 3;
            } else if (n2 == 4) {
                n6 = 2;
            } else if (n2 == 2) {
                n6 = 1;
            }
            this.ZG = n6 - 1;
        }
        this.Zf = 0;
        this.ZH = 1;
    }

    @Override
    public int b() {
        return this.tR;
    }

    public int zb() {
        return this.Zf;
    }

    public void fe(int n2) {
        this.Zf = n2;
    }

    public ArrayList zp() {
        return this.ZF;
    }

    public void ak(ArrayList arrayList) {
        this.ZF = arrayList;
    }

    public int zq() {
        return this.ZG;
    }

    public void ff(int n2) {
        this.ZG = n2 - 1;
    }

    public int zr() {
        return this.ZH;
    }

    public void fg(int n2) {
        this.ZH = n2;
    }

    public void pO() {
        this.ZI = this.Zf;
        this.ZJ = this.ZH;
        boolean bl2 = ((G)this.zp().get(this.Zf)).hO();
        if (this.ZH == 1 && !bl2) {
            this.zs();
        } else if (this.ZH == 2) {
            this.zs();
        } else {
            this.ZH = 2;
        }
    }

    public void zs() {
        this.ZI = this.Zf;
        this.ZJ = this.ZH;
        if (this.Zg == 2029) {
            this.zx();
        } else if (this.Zf == this.ZG) {
            this.zx();
        } else {
            ((G)this.zp().get(this.Zf)).b(false, false);
            G g2 = new G();
            g2.a(this, ((G)this.zp().get(this.Zf)).zY(), this.Zf + 1, this.ZK[this.Zf + 1], 0, 0, this.tR, ((G)this.zp().get(this.Zf)).zZ());
            ++this.Zf;
            this.ZH = 1;
        }
    }

    public void BH() {
        ++this.Zf;
        this.ZH = 1;
    }

    public int[] o(I i2) {
        int[] nArray = new int[]{-1, -1};
        nArray = ((G)this.zp().get(this.Zf)).o(i2);
        return nArray;
    }

    public ArrayList zt() {
        ArrayList<ah> arrayList = new ArrayList<ah>();
        int n2 = this.ZF.size() - 1;
        while (n2 >= 0) {
            if (((G)this.ZF.get(n2)).zW().size() == 2) {
                int n3 = 0;
                while (n3 <= 1) {
                    if (!((G)this.ZF.get(n2)).zY().contains(((I)((G)this.ZF.get(n2)).zW().get(n3)).hc())) {
                        arrayList.add(((I)((G)this.ZF.get(n2)).zW().get(n3)).hc());
                    }
                    if (!((G)this.ZF.get(n2)).zY().contains(((I)((G)this.ZF.get(n2)).zW().get(n3)).hd())) {
                        arrayList.add(((I)((G)this.ZF.get(n2)).zW().get(n3)).hd());
                    }
                    ++n3;
                }
            }
            --n2;
        }
        return arrayList;
    }

    public boolean zu() {
        return ((G)this.zp().get(this.Zf)).hO();
    }

    public int BI() {
        return ((G)this.zp().get(this.Zf)).ze();
    }

    public boolean fh(int n2) {
        if (n2 >= 0 && n2 < this.zp().size()) {
            return ((G)this.zp().get(n2)).hO();
        }
        return false;
    }

    public boolean zv() {
        return ((G)this.zp().get(this.Zf)).zZ();
    }

    public void zx() {
        ((G)this.zp().get(this.Zf)).b(this.ZL, true);
    }

    public L zy() {
        return this.nS;
    }

    public void f(s s2) {
        this.nS = s2;
    }

    public int zf() {
        return this.Zg;
    }

    public void fc(int n2) {
        this.Zg = n2;
    }

    public at yT() {
        return this.YY;
    }

    @Override
    public Z iq() {
        if (this.nS != null) {
            return this.nS.iq();
        }
        return null;
    }

    @Override
    public w ir() {
        if (this.nS != null) {
            return this.nS.ir();
        }
        return null;
    }

    @Override
    public int ip() {
        if (this.nS != null) {
            return this.nS.ip();
        }
        return -1;
    }

    @Override
    public String io() {
        String string = "";
        String[] stringArray = this.YY.b(this);
        if (stringArray == null) {
            stringArray = this.zB();
        }
        if (this.ZG == 7) {
            this.ZG = 6;
        }
        int n2 = stringArray.length - 1 - this.ZG;
        int n3 = this.ZH;
        string = stringArray[n2 + this.Zf];
        if (this.ZG == 0 && this.Zf == 0 && (this.tR == 4 || this.tR == 5)) {
            string = stringArray[0];
        }
        if (this.ZG == 1 && this.Zf == 0 && this.tR == 4) {
            string = "Preliminar R1";
        }
        if (this.ZG == 1 && this.Zf == 1 && this.tR == 4) {
            string = "Preliminar R2";
        }
        if (this.fh(this.Zf)) {
            return String.valueOf(string) + " - " + Integer.toString(n3) + "\u00ba jogo";
        }
        return string;
    }

    @Override
    public String getNome() {
        if (this.nS != null) {
            return this.nS.getNome();
        }
        if (this.YY != null) {
            return this.YY.getNome();
        }
        return null;
    }

    @Override
    public String is() {
        if (this.nS != null) {
            return this.nS.is();
        }
        return null;
    }

    public boolean[] zz() {
        return this.ZK;
    }

    public boolean zA() {
        return this.nS != null && this.tR == 3 && this.nS instanceof s && this.nS.zd() == 1;
    }

    public boolean U(ah ah2) {
        int n2 = this.zp().size() - 1;
        while (n2 >= 0) {
            int n3 = 0;
            while (n3 < ((G)this.zp().get(n2)).zW().size()) {
                if (((I)((G)this.zp().get(n2)).zW().get(n3)).hc() == ah2 || ((I)((G)this.zp().get(n2)).zW().get(n3)).hd() == ah2) {
                    return true;
                }
                ++n3;
            }
            --n2;
        }
        return false;
    }

    public void z(at at2) {
        ArrayList<ah> arrayList = new ArrayList<ah>();
        int n2 = 0;
        int n3 = 1;
        int n4 = this.zp().size() - 1;
        while (n4 >= 0) {
            int n5 = 0;
            while (n5 < ((G)this.zp().get(n4)).zW().size()) {
                ah ah2 = null;
                ah ah3 = null;
                if (((G)this.zp().get(n4)).zY().contains(((I)((G)this.zp().get(n4)).zW().get(n5)).hc())) {
                    ah2 = ((I)((G)this.zp().get(n4)).zW().get(n5)).hc();
                    ah3 = ((I)((G)this.zp().get(n4)).zW().get(n5)).hd();
                } else if (((G)this.zp().get(n4)).zY().contains(((I)((G)this.zp().get(n4)).zW().get(n5)).hd())) {
                    ah2 = ((I)((G)this.zp().get(n4)).zW().get(n5)).hd();
                    ah3 = ((I)((G)this.zp().get(n4)).zW().get(n5)).hc();
                }
                if (!arrayList.contains(ah2)) {
                    arrayList.add(ah2);
                    ah2.a(at2, n3, n2);
                    ++n3;
                }
                if (!arrayList.contains(ah3)) {
                    arrayList.add(ah3);
                    ah3.a(at2, n3, n2);
                    ++n3;
                }
                ++n5;
            }
            ++n2;
            --n4;
        }
    }

    public String[] zB() {
        if (this.zf() == 1068) {
            return aq.pX;
        }
        if (this.zf() == 6006) {
            return aq.abY;
        }
        if (this.ZG == 6) {
            return aq.px;
        }
        if (this.ZG == 5) {
            return aq.py;
        }
        if (this.ZG == 4) {
            return aq.pz;
        }
        if (this.ZG == 3) {
            return aq.pA;
        }
        if (this.ZG == 2) {
            return aq.pB;
        }
        if (this.ZG == 1) {
            return aq.pC;
        }
        if (this.ZG == 0) {
            return aq.pD;
        }
        return aq.ps;
    }
}

