/*
 * Decompiled with CFR 0.152.
 */
package best;

import best.F;
import best.ah;
import java.io.Serializable;
import javax.swing.ImageIcon;

public class A
implements Serializable {
    private static final long serialVersionUID = 1L;
    private ah dy = null;
    private int w = -1;
    private int dz = -1;
    private int dA = -1;
    private int dB = -1;
    private F dC = null;
    private F dD = null;
    private boolean dE = false;
    private int dF;
    private boolean dG = false;

    public A() {
    }

    public A(int n2) {
        this.dF = n2;
    }

    public A(int n2, boolean bl2) {
        this.w = n2;
        this.dE = bl2;
    }

    public ah cu() {
        return this.dy;
    }

    public void k(ah ah2) {
        this.dy = ah2;
    }

    public int b() {
        return this.w;
    }

    public void a(int n2) {
        this.w = n2;
    }

    public int el() {
        return this.dz;
    }

    public void R(int n2) {
        this.dz = n2;
    }

    public int em() {
        return this.dA;
    }

    public void S(int n2) {
        this.dA = n2;
    }

    public int en() {
        return this.dB;
    }

    public void T(int n2) {
        this.dB = n2;
    }

    public F eo() {
        return this.dC;
    }

    public void f(F f2) {
        this.dC = f2;
    }

    public F ep() {
        return this.dD;
    }

    public void g(F f2) {
        this.dD = f2;
    }

    public boolean isDone() {
        return this.dE;
    }

    public void p(boolean bl2) {
        this.dE = bl2;
    }

    public String eq() {
        String string = "";
        if (this.dB > 0) {
            string = " - " + Integer.toString(this.dB) + "\u00ba ";
        }
        String string2 = String.valueOf(Integer.toString(this.dA)) + "'";
        if (this.dA == 0 && this.dB == 2) {
            string2 = "interv.";
            string = "";
        }
        return String.valueOf(string2) + string;
    }

    public String er() {
        String string = "";
        string = "<html>";
        String string2 = "";
        if (this.dB > 0) {
            string2 = " - " + Integer.toString(this.dB) + "\u00ba ";
        }
        if (this.w == 1) {
            String string3 = "";
            if (string3 != null) {
                string3 = this.dC.getNome();
            }
            string = String.valueOf(string) + this.dC.getNome() + " " + Integer.toString(this.dA) + "'";
            if (this.dz == 2) {
                string = String.valueOf(string) + " (contra)";
            } else if (this.dz == 3) {
                string = String.valueOf(string) + " (penalty)";
            } else if (this.dz == 4) {
                string = String.valueOf(string) + " (falta)";
            } else if (this.dz == 5) {
                string = String.valueOf(string) + " (ol\u00edmpico)";
            }
        } else if (this.w == 6) {
            if (this.dC == null || this.dD == null) {
                return "";
            }
            String string4 = String.valueOf(Integer.toString(this.dA)) + "'";
            if (this.dA == 0 && this.dB == 2) {
                string4 = "(interv.)";
                string2 = "";
            }
            string = String.valueOf(string) + "(" + this.dC.getNome() + ") " + this.dD.getNome() + " " + string4;
        } else if (this.w == 7) {
            string = String.valueOf(string) + this.dC.getNome() + " " + Integer.toString(this.dA) + "'" + " perdeu penalty";
        } else if (this.w == 8) {
            String string5 = "";
            if (string5 != null) {
                string5 = "(A: " + this.dC.getNome() + ")";
            }
            string = String.valueOf(string) + string5;
            string2 = "";
        } else {
            string = String.valueOf(string) + this.dC.getNome() + " " + Integer.toString(this.dA) + "'";
        }
        string = String.valueOf(string) + string2 + "</html>";
        return string;
    }

    public ImageIcon es() {
        if (this.w == 1) {
            if (this.dz == 2) {
                return new ImageIcon(this.getClass().getResource("/aeicons/egolc.png"));
            }
            return new ImageIcon(this.getClass().getResource("/aeicons/egol.png"));
        }
        if (this.w == 2) {
            return new ImageIcon(this.getClass().getResource("/aeicons/eca.png"));
        }
        if (this.w == 3) {
            return new ImageIcon(this.getClass().getResource("/aeicons/ecacv.png"));
        }
        if (this.w == 4) {
            return new ImageIcon(this.getClass().getResource("/aeicons/ecv.png"));
        }
        if (this.w == 5) {
            return new ImageIcon(this.getClass().getResource("/aeicons/ect.png"));
        }
        if (this.w == 7) {
            return new ImageIcon(this.getClass().getResource("/aeicons/egolc.png"));
        }
        if (this.w == 6) {
            return new ImageIcon(this.getClass().getResource("/aeicons/esubs.png"));
        }
        return null;
    }

    public int et() {
        return this.dF;
    }

    public boolean eu() {
        return this.dG;
    }

    public void q(boolean bl2) {
        this.dG = bl2;
    }
}

