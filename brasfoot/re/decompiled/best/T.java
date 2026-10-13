/*
 * Decompiled with CFR 0.152.
 */
package best;

import best.ah;
import best.aq;
import best.f;
import c.a;
import java.io.Serializable;

public class T
implements Serializable {
    private static final long serialVersionUID = 1L;
    private int gV;
    private int gW;
    private int gX = 0;
    private int gY = 0;
    private int gZ = 0;
    private int ha = 0;
    private int T = 0;
    private int hb = -1;
    private int hc;
    private int hd;
    private int he;
    private int hf = -1;
    private int hg;
    private int hh;
    private int hi;

    public T() {
    }

    public T(int n2, int n3, int n4, int n5, int n6) {
        this.gV = n2;
        this.gW = n3;
        this.gX = n4;
        this.gY = n5;
        ++this.T;
        if (n4 != n5) {
            if (n4 > n5) {
                ++this.gZ;
                this.hb = n6;
                this.hc = a.SR.H();
                this.hd = n4;
                this.he = n5;
            } else {
                ++this.ha;
                this.hf = n6;
                this.hg = a.SR.H();
                this.hh = n4;
                this.hi = n5;
            }
        }
        a.SR.bd().add(this);
    }

    public void a(int n2, int n3, int n4, int n5) {
        int n6 = 0;
        int n7 = 0;
        boolean bl2 = false;
        if (n2 == 1) {
            n7 = n3 - n4;
            n6 = this.hd - this.he;
            if (n7 > n6) {
                bl2 = true;
            } else if (n7 == n6 && n3 >= this.hd) {
                bl2 = true;
            }
            if (bl2) {
                this.hc = a.SR.H();
                this.hb = n5;
                this.hd = n3;
                this.he = n4;
            }
        } else if (n2 == 2) {
            n7 = n3 - n4;
            n6 = this.hh - this.he;
            if (n7 > n6) {
                bl2 = true;
            } else if (n7 == n6 && n3 >= this.hh) {
                bl2 = true;
            }
            if (bl2) {
                this.hg = a.SR.H();
                this.hf = n5;
                this.hh = n3;
                this.hi = n4;
            }
        }
    }

    public void a(ah ah2, ah ah3, int n2, int n3, int n4) {
        boolean bl2 = true;
        bl2 = ah2.lk() == this.iL();
        ++this.T;
        if (bl2) {
            this.gX += n2;
            this.gY += n3;
            if (n2 > n3) {
                ++this.gZ;
                this.a(1, n2, n3, n4);
            } else if (n3 > n2) {
                ++this.ha;
                this.a(2, n3, n2, n4);
            }
        } else {
            this.gX += n3;
            this.gY += n2;
            if (n2 > n3) {
                ++this.ha;
                this.a(2, n2, n3, n4);
            } else if (n3 > n2) {
                ++this.gZ;
                this.a(1, n3, n2, n4);
            }
        }
    }

    public String iJ() {
        return f.z(this.gV);
    }

    public String iK() {
        return f.z(this.gW);
    }

    public int iL() {
        return this.gV;
    }

    public void ba(int n2) {
    }

    public int iM() {
        return this.gW;
    }

    public void bb(int n2) {
    }

    public void k(int n2) {
    }

    public int getP1() {
        return this.gX;
    }

    public void bc(int n2) {
    }

    public int getP2() {
        return this.gY;
    }

    public void bd(int n2) {
    }

    public boolean a(ah ah2, ah ah3) {
        if (this.gV == ah2.lk() && this.gW == ah3.lk()) {
            return true;
        }
        return this.gW == ah2.lk() && this.gV == ah3.lk();
    }

    public ah y(ah ah2) {
        if (this.gV == ah2.lk()) {
            return a.SR.x(this.gW);
        }
        if (this.gW == ah2.lk()) {
            return a.SR.x(this.gV);
        }
        return null;
    }

    public String iN() {
        String string = "jogos";
        if (this.T == 1) {
            string = "jogo";
        }
        return String.valueOf(String.valueOf(this.T) + " " + string);
    }

    public String iO() {
        int n2 = this.T - (this.gZ + this.ha);
        String string = "empates";
        if (n2 == 1) {
            string = "empate";
        }
        return String.valueOf(String.valueOf(n2)) + " " + string;
    }

    public String be(int n2) {
        int n3 = this.gZ;
        if (n2 == this.gW) {
            n3 = this.ha;
        }
        String string = "vit\u00f3rias";
        if (n3 == 1) {
            string = "vit\u00f3ria";
        }
        return String.valueOf(String.valueOf(n3)) + " " + string;
    }

    public String bf(int n2) {
        int n3 = this.gX;
        if (n2 == this.gW) {
            n3 = this.gY;
        }
        String string = "gols";
        if (n3 == 1) {
            string = "gol";
        }
        return String.valueOf(String.valueOf(n3)) + " " + string;
    }

    public String[] bg(int n2) {
        if (n2 == this.gW) {
            return this.iQ();
        }
        return this.iP();
    }

    public String[] iP() {
        String[] stringArray = new String[]{"", ""};
        if (this.hb >= 0) {
            stringArray[0] = String.valueOf(String.valueOf(a.SR.iU() + this.hc)) + " - " + this.bh(1) + ": " + String.valueOf(this.hd) + "x" + String.valueOf(this.he);
            stringArray[1] = "(" + aq.tz[this.hb] + ")";
        }
        return stringArray;
    }

    public String[] iQ() {
        String[] stringArray = new String[]{"", ""};
        if (this.hf >= 0) {
            stringArray[0] = String.valueOf(String.valueOf(a.SR.iU() + this.hg)) + " - " + this.bh(2) + ": " + String.valueOf(this.hh) + "x" + String.valueOf(this.hi);
            stringArray[1] = "(" + aq.tz[this.hf] + ")";
        }
        return stringArray;
    }

    public String bh(int n2) {
        String string = "";
        if (this.hb >= 0) {
            string = aq.tz[this.hb];
        }
        ah ah2 = a.SR.x(this.gV);
        int n3 = this.hb;
        if (n2 == 2) {
            ah2 = a.SR.x(this.gW);
            if (this.hf >= 0) {
                string = aq.tz[this.hf];
            }
            n3 = this.hf;
        }
        if (n3 == 1) {
            string = "Camp. Nacional";
        } else if (n3 == 3) {
            string = "Camp. " + aq.rZ[ah2.getEstado()];
        } else if (n3 == 4 || n3 == 6 || n3 == 7 || n3 == 8) {
            string = aq.z(n3, ah2.gg());
        }
        return string;
    }
}

