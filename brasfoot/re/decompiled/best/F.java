/*
 * Decompiled with CFR 0.152.
 */
package best;

import best.A;
import best.H;
import best.I;
import best.J;
import best.K;
import best.M;
import best.W;
import best.a;
import best.ac;
import best.ah;
import best.al;
import best.ap;
import best.aq;
import best.at;
import best.b;
import best.c;
import best.f;
import best.k;
import components.as;
import components.s;
import components.t;
import e.g;
import f.B;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;

public class F
implements Serializable {
    private static final long serialVersionUID = 1L;
    private int ei = -1;
    private int ej = -1;
    private String dm;
    private Boolean ek = false;
    private Boolean el = false;
    private int em;
    private int pais;
    private int en;
    private transient ah eo = null;
    private int bW = -1;
    private int ep = -1;
    private int eq;
    private int er = 0;
    private int es;
    private int et;
    private int eu;
    private int ev;
    private int status = 0;
    private int ew = 0;
    private int ex;
    private int ey = 0;
    private int ez = 0;
    private int eA = 0;
    private int eB = 0;
    private int eC = 0;
    private int eD = 0;
    private int eE = 0;
    private int eF = 0;
    private int eG = 0;
    private double[] eH = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
    private long eI = 0L;
    private long eJ = 0L;
    private int eK = 100;
    private Boolean eL = false;
    private double eM = 0.0;
    private double eN = 0.0;
    private Boolean eO = false;
    private Boolean eP = false;
    private Boolean eQ = false;
    private int eR = -1;
    private ArrayList eS = new ArrayList();
    private ArrayList eT = new ArrayList();
    private ArrayList eU = new ArrayList();
    private int eV = 0;
    private Boolean eW = false;
    private Boolean eX = false;
    private Boolean eY = false;
    private int eZ = 0;
    private int fa = 0;
    private Boolean fb = false;
    private int fc = 0;
    private int fd = 0;
    private double fe = 0.0;
    private int ff = 0;
    private transient int fg = 0;
    private int fh = 0;
    private int fi = 0;
    private transient ImageIcon fj = null;
    private transient JProgressBar fk = null;
    private transient ImageIcon fl = null;
    private transient ImageIcon fm = null;
    private transient int fn = 0;
    private transient s fo = null;
    private transient int fp = 0;
    private transient int fq = 0;
    private transient double ab = 0.0;
    private transient boolean fr = false;

    public F() {
    }

    public void fd() {
        ++this.fp;
        if (!this.gm().booleanValue() && this.fp >= 2 && this.fg() != null && this.em < 35) {
            if (this.fg().gg() == 0) {
                if (this.fg().getPais() == 1 || this.fg().getPais() == 65 || this.fg().getPais() == 97) {
                    this.j(true);
                } else if ((this.fg().getPais() == 104 || this.fg().getPais() == 72 || this.fg().getPais() == 154) && this.fp >= 3) {
                    this.j(true);
                }
            } else if (this.fg().getPais() == 29 && this.fp >= 4) {
                this.j(true);
            }
        }
    }

    public void fe() {
        this.fo = new s();
    }

    public F(int n2) {
        this.pais = n2;
        this.dm = F.au(n2);
        c.a.SR.bN().add(this);
    }

    public F(W w2, ah ah2) {
        this.setPais(w2.pais);
        this.setNome(w2.dm);
        this.n(ah2);
        this.setPosicao(w2.en);
        this.setLado(w2.er);
        if (w2.hm == 1) {
            this.el = true;
        }
        if (w2.hl == 1) {
            this.a(true);
        } else {
            this.a(false);
        }
        this.aq(w2.es);
        this.setStatus(w2.hk);
        this.setCr1(w2.hn);
        this.setCr2(w2.ho);
        if (w2.hp == 1) {
            this.h(true);
        } else {
            this.h(false);
        }
        this.setIdade(w2.em);
        this.fG();
    }

    public String getNome() {
        return this.dm;
    }

    public void setNome(String string) {
        this.dm = string;
        if (string == null || string.equals("TESTE")) {
            this.dm = F.au(this.pais);
        }
    }

    public Boolean ff() {
        return this.ek;
    }

    public void a(Boolean bl2) {
        this.ek = bl2;
        if (this.el.booleanValue()) {
            this.ek = true;
        }
    }

    public int getIdade() {
        return this.em;
    }

    public void setIdade(int n2) {
        int n3 = n2;
        if (this.fb.booleanValue()) {
            if (n3 < 16 || n3 > 20) {
                n3 = 18;
            }
        } else if (n3 < 16 || n3 > 48) {
            n3 = 35;
        }
        this.em = n3;
    }

    public int getPais() {
        return this.pais;
    }

    public void setPais(int n2) {
        this.pais = n2;
    }

    public int getPosicao() {
        return this.en;
    }

    public void setPosicao(int n2) {
        this.en = n2;
    }

    public ah fg() {
        ah ah2 = this.eo;
        if (ah2 == null && this.bW >= 0) {
            this.eo = ah2 = c.a.SR.x(this.bW);
            return ah2;
        }
        if (this.bW == -1) {
            return null;
        }
        return ah2;
    }

    public void fh() {
        if (this.eo != null) {
            this.bW = this.eo.lk();
        }
    }

    public void n(ah ah2) {
        this.eo = ah2;
        this.bW = ah2 != null ? ah2.lk() : -1;
    }

    public int fi() {
        return this.eq;
    }

    public void ad(int n2) {
        this.eq = n2;
    }

    public int getLado() {
        return this.er;
    }

    public void setLado(int n2) {
        this.er = n2 == 0 ? 0 : 1;
    }

    public int fj() {
        return this.et;
    }

    public void ae(int n2) {
        this.et = n2;
    }

    public int fk() {
        return this.eu;
    }

    public void af(int n2) {
        this.eu = n2;
    }

    public int fl() {
        return this.ev;
    }

    public void ag(int n2) {
        this.ev = n2;
    }

    public void fm() {
        this.ev = this.eu;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int n2) {
        this.status = n2;
    }

    public int fn() {
        return this.ew;
    }

    public void ah(int n2) {
        this.ew = n2;
    }

    public int getCr1() {
        return this.ey;
    }

    public void setCr1(int n2) {
        this.ey = n2;
    }

    public int getCr2() {
        return this.ez;
    }

    public void setCr2(int n2) {
        this.ez = n2;
    }

    public long fo() {
        return this.eI;
    }

    public void d(long l2) {
        this.eI = l2;
    }

    public int fp() {
        return this.eK;
    }

    public void ai(int n2) {
        this.eK = n2;
    }

    public void aj(int n2) {
        this.eK -= n2;
        if (this.eK < 0) {
            this.eK = 1;
        }
    }

    public void ak(int n2) {
        this.eK += n2;
        if (this.eK > 100) {
            this.eK = 100;
        }
    }

    public void fq() {
        if (this.em <= 20) {
            this.aj(1);
        } else if (this.em <= 25) {
            this.aj(2);
        } else if (this.em <= 31) {
            this.aj(3);
        } else if (this.em <= 36) {
            this.aj(4);
        } else {
            this.aj(5);
        }
    }

    public void fr() {
        boolean bl2 = false;
        if (this.fg() != null) {
            bl2 = this.fg().jZ();
        }
        if (this.eL.booleanValue()) {
            if (bl2) {
                if (this.em <= 20) {
                    this.ak(13);
                } else if (this.em <= 25) {
                    this.ak(24);
                } else if (this.em <= 31) {
                    this.ak(37);
                } else if (this.em <= 36) {
                    this.ak(40);
                } else {
                    this.ak(30);
                }
            } else if (this.em <= 20) {
                this.ak(20);
            } else if (this.em <= 25) {
                this.ak(30);
            } else if (this.em <= 31) {
                this.ak(50);
            } else if (this.em <= 36) {
                this.ak(52);
            } else {
                this.ak(42);
            }
        } else if (this.em < 20) {
            this.ak(30);
        } else if (this.em < 26) {
            this.ak(30);
        } else if (this.em < 33) {
            this.ak(35);
        } else if (this.em < 45) {
            this.ak(35);
        } else {
            this.ak(30);
        }
    }

    public Boolean fs() {
        return this.eL;
    }

    public void b(Boolean bl2) {
        this.eL = bl2;
    }

    public Boolean ft() {
        return this.eY;
    }

    public void c(Boolean bl2) {
        this.eY = bl2;
    }

    public double fu() {
        return this.eM;
    }

    public void d(double d2) {
        this.eM = d2;
    }

    public Boolean fv() {
        return this.eO;
    }

    public void d(Boolean bl2) {
        this.eO = bl2;
    }

    public Boolean fw() {
        return this.eP;
    }

    public void e(Boolean bl2) {
        this.eP = bl2;
    }

    public Boolean fx() {
        return this.eQ;
    }

    public void f(Boolean bl2) {
        this.eQ = bl2;
    }

    public int fy() {
        return this.eV;
    }

    public void al(int n2) {
        this.eV = n2;
    }

    public Boolean fz() {
        return this.eW;
    }

    public void g(Boolean bl2) {
        this.eW = bl2;
    }

    public int fA() {
        return this.eZ;
    }

    public void am(int n2) {
        this.eZ = n2;
    }

    public int fB() {
        return this.fa;
    }

    public void an(int n2) {
        this.fa = n2;
    }

    public Boolean fC() {
        return this.fb;
    }

    public void h(Boolean bl2) {
        this.fb = bl2;
    }

    public int fD() {
        return this.fc;
    }

    public void ao(int n2) {
        this.fc = n2;
    }

    public int fE() {
        return this.fd;
    }

    public void ap(int n2) {
        this.fd = n2;
    }

    public int fF() {
        return this.ex;
    }

    public void fG() {
        int n2 = this.ey;
        int n3 = this.ez;
        if (this.en == 0 || this.en == 2) {
            this.ex = 0;
        } else if (this.en == 1) {
            this.ex = n2 == 13 || n2 == 6 ? 1 : (n2 == 7 || n2 == 10 ? 0 : (n3 == 13 || n2 == 6 ? 1 : (n3 == 7 || n3 == 10 ? 0 : (n2 == 8 || n2 == 9 || n2 == 11 || n2 == 4 ? 1 : 0))));
        } else if (this.en == 3) {
            this.ex = n2 == 11 || n2 == 9 || n2 == 8 || n2 == 4 ? 1 : (n2 == 7 || n2 == 10 ? 0 : (n3 == 11 || n3 == 9 || n3 == 8 || n3 == 4 ? 1 : (n3 == 7 || n3 == 10 ? 0 : 1)));
        } else if (this.en == 4) {
            this.ex = n2 == 7 || n2 == 10 ? 0 : (n2 == 8 || n2 == 13 || n2 == 6 ? 2 : 1);
        }
    }

    public int fH() {
        return this.es;
    }

    public void aq(int n2) {
        this.es = n2;
        if (this.ek.booleanValue() && this.es > 8) {
            this.es = 10;
        }
    }

    public void fI() {
        if (this.fg() != null) {
            int n2 = this.fg().getDivisao();
            int n3 = this.fg().getNivel();
            int n4 = this.fg().getPais();
            int n5 = 1;
            int n6 = 1;
            int n7 = 0;
            if (this.fg().kn().booleanValue()) {
                switch (n2) {
                    case 1: {
                        n5 = 20;
                        n6 = 7;
                        break;
                    }
                    case 2: {
                        n5 = 15;
                        n6 = 3;
                        break;
                    }
                    case 3: {
                        n5 = 5;
                        n6 = 1;
                    }
                }
            } else {
                switch (this.fg().getReputacao()) {
                    case 5: {
                        n5 = 22;
                        n6 = 7;
                        break;
                    }
                    case 4: {
                        n5 = 15;
                        n6 = 4;
                        break;
                    }
                    case 3: {
                        n5 = 5;
                        n6 = 1;
                        break;
                    }
                    case 2: {
                        n5 = 5;
                        n6 = 1;
                        break;
                    }
                    case 1: {
                        n5 = 5;
                        n6 = 1;
                    }
                }
            }
            if (n3 <= 15) {
                n7 = n3;
            } else {
                switch (n3) {
                    case 16: {
                        n7 = 17;
                        break;
                    }
                    case 17: {
                        n7 = 18;
                        break;
                    }
                    case 18: {
                        n7 = 19;
                        break;
                    }
                    case 19: {
                        n7 = 21;
                        break;
                    }
                    case 20: {
                        n7 = 25;
                        break;
                    }
                    case 21: {
                        n7 = 26;
                        break;
                    }
                    case 22: {
                        n7 = 27;
                        break;
                    }
                    case 23: {
                        n7 = 28;
                        break;
                    }
                    case 24: {
                        n7 = 29;
                        break;
                    }
                    case 25: {
                        n7 = 30;
                        break;
                    }
                    default: {
                        n7 = n3;
                    }
                }
            }
            int n8 = n7;
            int n9 = n6;
            if (n8 > 4) {
                n8 -= 4;
            }
            n5 = n7 + n5;
            n5 += new Random().nextInt(3);
            if (this.status == 1) {
                n5 = n5 + 8 + new Random().nextInt(2);
            }
            if (this.ek.booleanValue() || this.el.booleanValue()) {
                n5 = n5 + 9 + new Random().nextInt(3);
            }
            if (this.fb.booleanValue()) {
                if ((n5 -= 23) < 5) {
                    n5 = 10;
                }
                this.ga();
                this.fZ();
            }
            if (ac.fn(n4) <= 13) {
                n5 = n3 <= 5 ? (int)Math.round((double)n5 * 0.4) : (n3 < 10 ? (int)Math.round((double)n5 * 0.65) : (int)Math.round((double)n5 * 0.75));
            } else if (n3 < 10) {
                if (n3 < 3) {
                    n5 = (int)Math.round((double)n5 * 0.5);
                } else if (n3 < 5) {
                    n5 = (int)Math.round((double)n5 * 0.6);
                } else if (n3 < 10) {
                    n5 = (int)Math.round((double)n5 * 0.7);
                }
            }
            if (n5 > 100) {
                n5 = 100;
            }
            this.a((long)(new Random().nextInt(30) + 210), true);
            this.ad(n5);
            if (c.a.SR.isHabilidadeIndividual()) {
                this.j(n8, n9);
            }
            this.fK();
            this.fJ();
        }
    }

    public void j(int n2, int n3) {
        int n4 = Math.round(n2 / 3);
        if (this.en == 0) {
            this.eA = this.eq + new Random().nextInt(2);
            this.eB = n2 + new Random().nextInt(7);
            this.eC = n2 + new Random().nextInt(4);
            this.eD = n2 + new Random().nextInt(4);
            this.eE = n3 + new Random().nextInt(3);
            this.eF = n3 + new Random().nextInt(3);
            this.eG = n3 + new Random().nextInt(3);
            if (this.ey == 0 || this.ey == 3) {
                this.eC = this.eC + 2 + new Random().nextInt(5);
            }
            if (this.ez == 0 || this.ez == 3) {
                this.eC += new Random().nextInt(2);
            }
            if (this.ey == 2) {
                this.eB = this.eB + 2 + new Random().nextInt(5);
            }
            if (this.ez == 2) {
                this.eB += new Random().nextInt(2);
            }
            if (this.ey == 1) {
                this.eA = this.eA + 1 + new Random().nextInt(3);
            }
            if (this.ez == 1) {
                this.eA += new Random().nextInt(2);
            }
        } else if (this.en == 1) {
            if (this.ex == 0) {
                this.eE = (int)Math.round((double)this.eq * 0.8) + new Random().nextInt(6);
                this.eG = n3 + new Random().nextInt(4);
                this.eD = n2 + new Random().nextInt(3);
                this.eC = n2 + new Random().nextInt(7);
                this.eF = n3 + new Random().nextInt(5);
                this.eB = n2 + n3 + new Random().nextInt(6);
            } else {
                this.eF = (int)Math.round((double)this.eq * 0.5) + new Random().nextInt(5);
                this.eG = n2 + n3 + new Random().nextInt(4);
                this.eD = n2 + n4 + new Random().nextInt(3);
                this.eC = n2 + n4 + new Random().nextInt(7);
                this.eE = n2 + new Random().nextInt(4);
                this.eB = n2 + n3 + new Random().nextInt(4);
            }
            this.eA = 1 + new Random().nextInt(4);
            if (this.ey == 4 || this.ez == 4) {
                this.eF = this.eF + n3 + new Random().nextInt(5);
                this.eD = this.eD + n3 + new Random().nextInt(5);
            }
            if (this.ey == 5 || this.ez == 5) {
                this.eG = this.eG + 2 + new Random().nextInt(3);
                this.eE = this.eE + 2 + new Random().nextInt(3);
            }
            if (this.ey == 6 || this.ez == 6) {
                this.eD = this.eD + 2 + new Random().nextInt(3);
            }
            if (this.ey == 7 || this.ez == 7) {
                this.eE = this.eE + n3 + new Random().nextInt(3);
            }
            if (this.ey == 8 || this.ez == 8) {
                this.eC = this.eC + n3 + new Random().nextInt(3);
            }
            if (this.ey == 9 || this.ez == 9) {
                this.eG = this.eG + n3 + new Random().nextInt(3);
            }
            if (this.ey == 10 || this.ez == 10) {
                this.eE = this.eE + n3 + new Random().nextInt(5);
            }
            if (this.ey == 11 || this.ez == 11) {
                this.eD = this.eD + n3 + new Random().nextInt(2);
            }
            if (this.ey == 12 || this.ez == 12) {
                this.eE = this.eE + 3 + new Random().nextInt(3);
            }
            if (this.ey == 13 || this.ez == 13) {
                this.eB = this.eB + n2 + new Random().nextInt(3);
            }
        } else if (this.en == 2) {
            this.eE = (int)Math.round((double)this.eq * 0.9) + new Random().nextInt(2);
            this.eA = 1 + new Random().nextInt(7);
            this.eB = n2 + n3 + new Random().nextInt(4);
            this.eC = n2 + n3 + new Random().nextInt(7);
            this.eD = n2 + n3 + new Random().nextInt(3);
            this.eG = n3 + new Random().nextInt(6);
            this.eF = n2 + new Random().nextInt(5);
            if (this.ey == 4 || this.ez == 4) {
                this.eF = this.eF + n3 + new Random().nextInt(5);
                this.eD = this.eD + n3 + new Random().nextInt(5);
            }
            if (this.ey == 5 || this.ez == 5) {
                this.eG = this.eG + n3 + new Random().nextInt(6);
            }
            if (this.ey == 6 || this.ez == 6) {
                this.eD = this.eD + 2 + new Random().nextInt(3);
            }
            if (this.ey == 7 || this.ez == 7) {
                this.eE = this.eE + n3 + new Random().nextInt(3);
            }
            if (this.ey == 8 || this.ez == 8) {
                this.eC = this.eC + n3 + new Random().nextInt(3);
            }
            if (this.ey == 9 || this.ez == 9) {
                this.eG = this.eG + 3 + new Random().nextInt(3);
            }
            if (this.ey == 10 || this.ez == 10) {
                this.eE = this.eE + 3 + new Random().nextInt(3);
            }
            if (this.ey == 11 || this.ez == 11) {
                this.eD = this.eD + n3 + new Random().nextInt(2);
            }
            if (this.ey == 12 || this.ez == 12) {
                this.eE = this.eE + 3 + new Random().nextInt(3);
                this.eG += 2;
            }
            if (this.ey == 13 || this.ez == 13) {
                this.eB = this.eB + n2 + new Random().nextInt(3);
            }
        } else if (this.en == 3) {
            if (this.ex == 0) {
                this.eE = (int)Math.round((double)this.eq * 0.7) + new Random().nextInt(6);
                this.eG = n2 + new Random().nextInt(4);
                this.eD = n2 + new Random().nextInt(3);
                this.eC = n2 + new Random().nextInt(7);
                this.eF = n2 + new Random().nextInt(5);
                this.eB = n2 + n3 + new Random().nextInt(6);
            } else {
                this.eF = this.eq + new Random().nextInt(2);
                this.eG = n2 + n4 + new Random().nextInt(4);
                this.eD = n2 + n3 + new Random().nextInt(3);
                this.eC = n2 + n4 + new Random().nextInt(7);
                this.eE = n2 + new Random().nextInt(4);
                this.eB = n2 + n4 + new Random().nextInt(4);
            }
            this.eA = 1 + new Random().nextInt(4);
            if (this.ey == 4 || this.ez == 4) {
                this.eF = this.eF + n3 + new Random().nextInt(5);
                this.eD = this.eD + n3 + new Random().nextInt(5);
            }
            if (this.ey == 5 || this.ez == 5) {
                this.eG = this.eG + 2 + new Random().nextInt(3);
                this.eE = this.eE + 2 + new Random().nextInt(3);
            }
            if (this.ey == 6 || this.ez == 6) {
                this.eD = this.eD + 2 + new Random().nextInt(3);
            }
            if (this.ey == 7 || this.ez == 7) {
                this.eE = this.eE + n3 + new Random().nextInt(3);
            }
            if (this.ey == 8 || this.ez == 8) {
                this.eC = this.eC + n3 + new Random().nextInt(3);
            }
            if (this.ey == 9 || this.ez == 9) {
                this.eG = this.eG + n3 + new Random().nextInt(3);
            }
            if (this.ey == 10 || this.ez == 10) {
                this.eE = this.eE + 3 + new Random().nextInt(3);
            }
            if (this.ey == 11 || this.ez == 11) {
                this.eD = this.eD + n3 + new Random().nextInt(2);
            }
            if (this.ey == 12 || this.ez == 12) {
                this.eE = this.eE + 3 + new Random().nextInt(3);
            }
            if (this.ey == 13 || this.ez == 13) {
                this.eB = this.eB + n2 + new Random().nextInt(3);
            }
        } else if (this.en == 4) {
            this.eG = (int)Math.round((double)this.eq * 0.8) + new Random().nextInt(2);
            this.eA = 1 + new Random().nextInt(6);
            this.eB = n2 + n4 + new Random().nextInt(4);
            this.eC = n2 + n4 + new Random().nextInt(7);
            this.eD = n2 + n3 + new Random().nextInt(3);
            this.eE = n3 + new Random().nextInt(6);
            this.eF = n3 + n2 + new Random().nextInt(5);
            if (this.ey == 4 || this.ez == 4) {
                this.eF = this.eF + n2 + new Random().nextInt(5);
                this.eD = this.eD + n3 + new Random().nextInt(5);
            }
            if (this.ey == 5 || this.ez == 5) {
                this.eG = this.eG + 2 + new Random().nextInt(3);
            }
            if (this.ey == 6 || this.ez == 6) {
                this.eD = this.eD + 2 + new Random().nextInt(3);
            }
            if (this.ey == 7 || this.ez == 7) {
                this.eE = this.eE + n3 + new Random().nextInt(3);
            }
            if (this.ey == 8 || this.ez == 8) {
                this.eC = this.eC + n3 + new Random().nextInt(3);
            }
            if (this.ey == 9 || this.ez == 9) {
                this.eG = this.eG + 3 + new Random().nextInt(3);
            }
            if (this.ey == 10 || this.ez == 10) {
                this.eE = this.eE + 3 + new Random().nextInt(3);
            }
            if (this.ey == 11 || this.ez == 11) {
                this.eD = this.eD + n2 + new Random().nextInt(2);
            }
            if (this.ey == 12 || this.ez == 12) {
                this.eE = this.eE + 3 + new Random().nextInt(3);
                this.eG += 2;
            }
            if (this.ey == 13 || this.ez == 13) {
                this.eB = this.eB + n2 + new Random().nextInt(3);
            }
        }
        if (this.eA > 100) {
            this.eA = 100;
        }
        if (this.eB > 100) {
            this.eB = 100;
        }
        if (this.eC > 100) {
            this.eC = 100;
        }
        if (this.eD > 100) {
            this.eD = 100;
        }
        if (this.eE > 100) {
            this.eE = 100;
        }
        if (this.eF > 100) {
            this.eF = 100;
        }
        if (this.eG > 100) {
            this.eG = 100;
        }
    }

    public void fJ() {
        int n2;
        int n3 = 0;
        int n4 = 350;
        if (this.fg() != null) {
            if (this.fg().ki()) {
                n2 = this.fg().getDivisao();
                if (n2 == 1) {
                    n4 = 750;
                } else if (n2 == 2) {
                    n4 = 550;
                } else if (n2 == 3) {
                    n4 = 500;
                } else if (n2 == 4 || n2 == 5) {
                    n4 = 450;
                }
            } else {
                n2 = this.fg().getDivisao();
                if (n2 == 1) {
                    n4 = 600;
                } else if (n2 == 2) {
                    n4 = 500;
                } else if (n2 == 3) {
                    n4 = 450;
                } else if (n2 == 4 || n2 == 5) {
                    n4 = 400;
                }
            }
            if (this.fg().getNivel() > 20) {
                n4 += 50;
            }
        }
        if ((n2 = this.en) == 0) {
            n4 -= 70;
        } else if (n2 == 1) {
            n4 -= 30;
        } else if (n2 == 2) {
            n4 -= 40;
        } else if (n2 == 4) {
            n4 -= 50;
        }
        n4 = (int)Math.round(0.5 * (double)n4);
        int n5 = this.eq * 2 * n4;
        int n6 = (this.em - 32) * 300;
        int n7 = 0;
        if (this.ek.booleanValue() || this.el.booleanValue()) {
            n7 = this.eq * 250;
        }
        if ((n3 = this.em < 32 ? n5 + n7 : n5 - n6 + n7) < 500) {
            n3 = 500;
        }
        if (this.el.booleanValue()) {
            n3 = (int)Math.round((double)n3 * 1.4);
        }
        if (this.fC().booleanValue()) {
            n3 = (int)Math.round((double)n3 * 0.1);
        }
        this.et = c.a.SR.isSalarioMensal() ? n3 * 4 : n3;
    }

    public void fK() {
        int n2 = 0;
        int n3 = 10;
        int n4 = 10;
        int n5 = 366;
        int n6 = 0;
        int n7 = ac.valueOf("P" + Integer.toString(this.pais)).gg();
        n3 = this.fg() != null ? this.fg().getNivel() : 10;
        n4 = this.eq * 2;
        n4 *= n4;
        n5 = n3 >= 21 ? 750 : (n3 >= 20 ? 600 : (n3 >= 18 ? 500 : (n3 >= 12 ? 400 : 366)));
        if (this.ek.booleanValue()) {
            n5 = n3 >= 22 && n7 == 0 ? (n5 *= 3) : (n3 >= 21 && n7 == 0 ? (n5 *= 2) : (int)Math.round(1.7 * (double)n5));
        }
        if (this.gm().booleanValue()) {
            n5 = (int)Math.round(1.6 * (double)n5);
        }
        if (this.en == 4) {
            n5 = (int)Math.round(1.3 * (double)n5);
        }
        if (this.status == 1) {
            n5 = (int)Math.round((double)n5 + 0.2 * (double)n5);
        }
        n6 = n7 == 0 ? 28 : 20;
        if (this.em < 16) {
            this.em = 16;
        }
        int n8 = 0;
        n8 = this.em < 20 ? (32 - this.em) * 27 : (this.em <= 25 ? (32 - this.em) * 22 : (this.em < 32 ? (32 - this.em) * 15 : (this.em < 34 ? (34 - this.em) * 10 : (n8 -= (this.em - 34) * 50))));
        if ((n5 += n8) <= 0) {
            n5 = 60;
        }
        n2 = n4 * n5;
        if (this.fb.booleanValue()) {
            n2 = (int)Math.round((double)n2 * 0.03) * this.es;
        } else if (this.ff > 0 && c.a.SR.H() == this.ff) {
            if ((n2 = (int)Math.round((double)n2 * 0.18)) > this.fl() && this.fl() > 0) {
                n2 = this.fl();
            }
        } else if (this.ff > 0 && c.a.SR.H() - 1 == this.ff) {
            n2 = (int)Math.round((double)n2 * 0.35);
        } else if (this.ff > 0 && c.a.SR.H() - 2 == this.ff) {
            n2 = (int)Math.round((double)n2 * 0.65);
        }
        if (this.fb.booleanValue() && this.es == 10) {
            n2 = (int)Math.round((double)n2 * 1.5);
        }
        this.eu = n2;
    }

    public int fL() {
        return this.ff;
    }

    public void ar(int n2) {
        this.ff = n2;
    }

    public String fM() {
        return "P" + Integer.toString(this.pais);
    }

    public int fN() {
        return ac.valueOf("P" + Integer.toString(this.pais)).gg();
    }

    public boolean fO() {
        int[] nArray = aq.rW;
        int n2 = aq.rW.length;
        int n3 = 0;
        while (n3 < n2) {
            int n4 = nArray[n3];
            if (n4 == this.pais) {
                return true;
            }
            ++n3;
        }
        return false;
    }

    public boolean a(I i2, boolean bl2) {
        at at2 = i2.hy();
        boolean bl3 = true;
        boolean bl4 = true;
        if (at2 == null || at2.b() == 0) {
            bl3 = false;
        }
        if (this.fP()) {
            return false;
        }
        if (bl3 && this.c(at2)) {
            bl4 = false;
        }
        if (!bl2 && this.fg() != null && this.fg().jZ().booleanValue() && this.eJ < c.a.SR.bb().getTime().getTime()) {
            return false;
        }
        return bl4;
    }

    public boolean d(I i2) {
        at at2 = i2.hy();
        boolean bl2 = true;
        boolean bl3 = true;
        if (at2 == null || at2.b() == 0) {
            bl2 = false;
        }
        if (this.fP()) {
            return false;
        }
        if (bl2 && this.c(at2)) {
            return false;
        }
        if (this.fR() < 0) {
            return false;
        }
        return bl3;
    }

    public boolean fP() {
        return this.eI > 0L && this.eI > c.a.SR.bb().getTimeInMillis();
    }

    public String fQ() {
        String string = "contrato vencido";
        if (this.eJ > c.a.SR.bb().getTime().getTime()) {
            return a.a(this.eJ);
        }
        return string;
    }

    public int a(Date date, Date date2) {
        return (int)((date2.getTime() - date.getTime()) / 86400000L);
    }

    public int a(long l2, long l3) {
        if (l3 > l2) {
            long l4 = (l3 - l2) / 86400000L;
            return (int)l4;
        }
        return 0;
    }

    public int fR() {
        int n2 = this.a(c.a.SR.bb().getTime().getTime(), this.eJ);
        return n2;
    }

    public ImageIcon fS() {
        Object object;
        ImageIcon imageIcon = null;
        ImageIcon imageIcon2 = null;
        boolean bl2 = false;
        if (this.eI > 0L && this.fP()) {
            imageIcon = new ImageIcon(this.getClass().getResource("/aicons/icontusao.png"));
            bl2 = true;
        }
        at at2 = null;
        if (f.bl() != null) {
            at2 = f.bl().hy();
        }
        if (at2 != null && (object = this.e(at2)) != null) {
            if (object[1] >= 1) {
                imageIcon2 = new ImageIcon(this.getClass().getResource("/aicons/icv.png"));
                bl2 = true;
            } else if (object[0] == 1) {
                imageIcon2 = new ImageIcon(this.getClass().getResource("/aicons/ica1.png"));
                bl2 = true;
            } else if (object[0] == 2) {
                imageIcon2 = new ImageIcon(this.getClass().getResource("/aicons/ica2.png"));
                bl2 = true;
            } else if (object[0] >= 3) {
                imageIcon2 = new ImageIcon(this.getClass().getResource("/aicons/ica3.png"));
                bl2 = true;
            }
        }
        if (bl2) {
            if (imageIcon == null) {
                imageIcon = new ImageIcon(this.getClass().getResource("/aicons/whiteIcon.png"));
            }
            if (imageIcon2 == null) {
                imageIcon2 = new ImageIcon(this.getClass().getResource("/aicons/whiteIcon.png"));
            }
            object = imageIcon.getImage();
            Image image = imageIcon2.getImage();
            int n2 = ((Image)object).getWidth(null) + image.getWidth(null);
            int n3 = 18;
            BufferedImage bufferedImage = new BufferedImage(n2, n3, 3);
            Graphics2D graphics2D = bufferedImage.createGraphics();
            graphics2D.drawImage((Image)object, 0, 0, null);
            graphics2D.drawImage(image, ((Image)object).getWidth(null), 0, null);
            graphics2D.dispose();
            this.fj = new ImageIcon(bufferedImage);
        }
        return this.fj;
    }

    public boolean c(at at2) {
        H h3 = this.h(at2);
        return h3 != null && h3.gT();
    }

    public int d(at at2) {
        H h3 = this.h(at2);
        if (h3 != null) {
            return h3.y();
        }
        return 0;
    }

    public int[] e(at at2) {
        H h3 = this.h(at2);
        if (h3 != null) {
            return h3.gW();
        }
        return null;
    }

    public void f(at at2) {
        H h3 = this.h(at2);
        if (h3 != null) {
            h3.gU();
        }
    }

    public int fT() {
        return this.eR;
    }

    public void as(int n2) {
        this.eR = n2;
    }

    public int fU() {
        return Math.round(this.eK / 100 * this.eq);
    }

    public void fV() {
        if (this.fg() != null) {
            if (this.em < 32) {
                this.fW();
            } else {
                this.fX();
            }
            this.eL = false;
        }
    }

    private void e(double d2) {
        boolean bl2 = true;
        int n2 = 0;
        if (c.a.SR.bO() == 3) {
            bl2 = false;
        }
        if (bl2) {
            n2 = this.h(d2);
        } else {
            this.c(d2 * 10.0, n2);
        }
        if (this.aE(n2) > 1.0 && this.aF(n2) > 1) {
            this.aH(n2);
            this.aD(n2);
        }
    }

    private void f(double d2) {
        int n2 = this.fg().bQ(this.getPosicao());
        boolean bl2 = true;
        if (c.a.SR.bO() == 3) {
            bl2 = false;
        }
        if (this.fg().jZ() != null && this.fg().jZ().booleanValue() && !this.fg().ll() && this.fg().lm() == 1) {
            bl2 = false;
        }
        if (bl2) {
            n2 = this.h(d2);
        } else {
            this.c(d2 * 2.0, n2);
        }
        int n3 = 0;
        while (n3 <= 6) {
            if (this.b(this.aE(n3), this.aF(n3)) && this.aF(n3) < 100) {
                this.aG(n3);
                this.aD(n3);
            }
            ++n3;
        }
    }

    private boolean b(double d2, int n2) {
        int n3;
        int n4 = 100;
        if (this.fg().kn().booleanValue()) {
            n3 = this.fg().getDivisao();
            int[][] nArrayArray = new int[][]{{30, 30, 30, 30, 30, 30}, {80, 85, 90, 95, 100, 100}, {50, 60, 60, 65, 80, 80}, {40, 40, 40, 45, 70, 70}, {25, 30, 30, 30, 50, 60}, {30, 30, 30, 30, 30, 30}};
            if (this.fg().getReputacao() < 0 || this.fg().getReputacao() > 5) {
                this.fg().setReputacao(1);
            }
            n4 = nArrayArray[this.fg().getDivisao()][this.fg().getReputacao()];
        } else {
            n4 = this.fg().getReputacao() == 5 ? 100 : (this.fg().getReputacao() == 4 ? 100 : (this.fg().getReputacao() == 3 ? 70 : (this.fg().getReputacao() == 2 ? 40 : (this.fg().getReputacao() == 1 ? 30 : 20))));
        }
        n3 = 100;
        if (this.fg().gg() == 0) {
            n3 = this.fg().getPais() == 3 || this.fg().getPais() == 72 || this.fg().getPais() == 104 || this.fg().getPais() == 65 || this.fg().getPais() == 97 ? 95 : (this.fg().getPais() == 154 || this.fg().getPais() == 85 ? 90 : (this.fg().getPais() == 21 || this.fg().getPais() == 162 ? 80 : 70));
        } else if (this.fg().gg() == 1) {
            n3 = this.fg().getPais() == 29 || this.fg().getPais() == 11 ? 90 : (this.fg().getPais() == 195 || this.fg().getPais() == 46 ? 80 : (this.fg().getPais() == 195 || this.fg().getPais() == 46 || this.fg().getPais() == 42 ? 80 : (this.fg().getPais() == 151 || this.fg().getPais() == 150 ? 70 : 60)));
        } else if (this.fg().gg() == 2) {
            n3 = this.fg().getPais() == 10 || this.fg().getPais() == 129 || this.fg().getPais() == 57 ? 75 : (this.fg().getPais() == 141 || this.fg().getPais() == 169 || this.fg().getPais() == 190 ? 70 : 60);
        } else if (this.fg().gg() == 3) {
            n3 = this.fg().getPais() == 107 || this.fg().getPais() == 49 ? 75 : (this.fg().getPais() == 98 || this.fg().getPais() == 9 || this.fg().getPais() == 59 || this.fg().getPais() == 43 ? 70 : 60);
        } else if (this.fg().gg() == 4) {
            n3 = this.fg().getPais() == 131 ? 80 : (this.fg().getPais() == 68 ? 70 : (this.fg().getPais() == 51 ? 65 : 55));
        } else if (this.fg().gg() == 5) {
            n3 = this.fg().getPais() == 143 ? 60 : 45;
        }
        if (n4 > n3) {
            n4 = n3;
        }
        if (this.fd >= 60) {
            int n5 = new Random().nextInt(5);
            if (this.es == 7) {
                n4 = n4 + 5 + n5;
            } else if (this.es == 8) {
                n4 = n4 + 15 + n5;
            } else if (this.es == 9) {
                n4 = n4 + 25 + n5;
            } else if (this.es == 10) {
                n4 = n4 + 30 + n5;
            }
            if (n4 > 100) {
                n4 = 100;
            }
        }
        if (d2 > 1.0 && n2 < 100) {
            return n2 < n4;
        }
        return false;
    }

    private void fW() {
        double d2 = 50.0;
        int n2 = 15;
        double d3 = 0.0;
        if (this.fg() != null) {
            n2 = this.fg().getNivel();
            if (!this.fg().kn().booleanValue()) {
                d3 = 0.03;
                n2 = this.fg().getReputacao() >= 4 ? 20 : (this.fg().getReputacao() == 3 ? 18 : 12);
            }
        }
        double d4 = 0.0;
        d4 = n2 >= 19 ? (this.em < 20 ? 8.0 / d2 : (this.em < 23 ? 6.0 / d2 : (this.em < 29 ? 5.0 / d2 : 4.0 / d2))) : (n2 >= 15 ? (this.em < 18 ? 6.0 / d2 : (this.em < 21 ? 5.0 / d2 : (this.em < 29 ? 4.0 / d2 : 3.0 / d2))) : (n2 >= 11 ? (this.em < 18 ? 5.0 / d2 : (this.em < 21 ? 4.0 / d2 : (this.em < 29 ? 3.0 / d2 : 2.0 / d2))) : (this.em < 18 ? 4.0 / d2 : (this.em < 21 ? 3.0 / d2 : (this.em < 29 ? 2.0 / d2 : 1.0 / d2)))));
        if (this.eL.booleanValue()) {
            d4 += 0.04;
        }
        if (this.eq >= 30 && this.eq <= 40) {
            d4 -= 0.02;
        } else if (this.eq >= 41 && this.eq <= 50) {
            d4 -= 0.03;
        } else if (this.eq >= 51 && this.eq <= 70) {
            d4 -= 0.04;
        } else if (this.eq >= 71 && this.eq <= 100) {
            d4 -= 0.05;
        }
        if (this.fd > 0) {
            if (this.fd < 50) {
                d4 -= 0.05;
            } else if (this.fd < 70) {
                d4 -= 0.02;
            }
            if (this.es >= 9) {
                d4 += 0.07;
            } else if (this.es >= 7) {
                d4 += 0.05;
            }
        }
        if (this.gm().booleanValue()) {
            d4 += 0.02;
        } else if (this.ff().booleanValue()) {
            d4 += 0.01;
        }
        if (this.fg().gg() == 2 || this.fg().gg() == 3) {
            if (d4 > 0.06) {
                d4 -= 0.02;
            }
        } else if (this.fg().gg() == 5) {
            if (d4 > 0.06) {
                d4 -= 0.04;
            }
        } else if (this.fg().gg() == 4) {
            if (this.fg().getPais() != 131 && d4 > 0.06) {
                d4 -= 0.03;
            }
        } else if (this.fg().gg() == 1) {
            if ((this.fg().getPais() != 29 || this.fg().getPais() != 11 || this.fg().getPais() != 42 || this.fg().getPais() != 195) && d4 > 0.06) {
                d4 -= 0.02;
            }
        } else if (this.fg().gg() == 0) {
            if (this.fg().getPais() == 3 || this.fg().getPais() == 72 || this.fg().getPais() == 104 || this.fg().getPais() == 65 || this.fg().getPais() == 97) {
                d4 += 0.01;
            } else if (this.fg().getPais() == 154 || this.fg().getPais() == 85 || this.fg().getPais() == 21) {
                if (d4 > 0.06) {
                    d4 -= 0.01;
                }
            } else if (d4 > 0.06) {
                d4 -= 0.02;
            }
        }
        if ((d4 += d3) < 0.0) {
            d4 = 0.01;
        }
        if (c.a.SR.isHabilidadeIndividual()) {
            this.f(d4);
        }
        this.eM += d4;
        int n3 = 100;
        if (this.fg().kn().booleanValue()) {
            int[][] nArrayArray = new int[][]{{30, 30, 30, 30, 30, 30}, {80, 85, 90, 95, 100, 100}, {50, 60, 60, 65, 80, 80}, {40, 40, 40, 45, 70, 70}, {25, 30, 30, 30, 50, 60}, {30, 30, 30, 30, 30, 30}};
            if (this.fg().getReputacao() < 0 || this.fg().getReputacao() > 5) {
                this.fg().setReputacao(1);
            }
            n3 = nArrayArray[this.fg().getDivisao()][this.fg().getReputacao()];
        } else {
            n3 = this.fg().getReputacao() == 5 ? 100 : (this.fg().getReputacao() == 4 ? 100 : (this.fg().getReputacao() == 3 ? 65 : (this.fg().getReputacao() == 2 ? 40 : (this.fg().getReputacao() == 1 ? 30 : 20))));
        }
        int n4 = 100;
        if (this.fg().gg() == 0) {
            n4 = this.fg().getPais() == 3 || this.fg().getPais() == 72 || this.fg().getPais() == 104 || this.fg().getPais() == 65 || this.fg().getPais() == 97 ? 95 : (this.fg().getPais() == 154 || this.fg().getPais() == 85 ? 90 : (this.fg().getPais() == 21 || this.fg().getPais() == 162 ? 80 : 70));
        } else if (this.fg().gg() == 1) {
            n4 = this.fg().getPais() == 29 || this.fg().getPais() == 11 ? 90 : (this.fg().getPais() == 195 || this.fg().getPais() == 46 ? 80 : (this.fg().getPais() == 195 || this.fg().getPais() == 46 || this.fg().getPais() == 42 ? 80 : (this.fg().getPais() == 151 || this.fg().getPais() == 150 ? 70 : 60)));
        } else if (this.fg().gg() == 2) {
            n4 = this.fg().getPais() == 10 || this.fg().getPais() == 129 || this.fg().getPais() == 57 ? 75 : (this.fg().getPais() == 141 || this.fg().getPais() == 169 || this.fg().getPais() == 190 ? 70 : 60);
        } else if (this.fg().gg() == 3) {
            n4 = this.fg().getPais() == 107 || this.fg().getPais() == 49 ? 75 : (this.fg().getPais() == 98 || this.fg().getPais() == 9 || this.fg().getPais() == 59 || this.fg().getPais() == 43 ? 70 : 60);
        } else if (this.fg().gg() == 4) {
            n4 = this.fg().getPais() == 131 ? 80 : (this.fg().getPais() == 68 ? 70 : (this.fg().getPais() == 51 ? 65 : 55));
        } else if (this.fg().gg() == 5) {
            n4 = this.fg().getPais() == 143 ? 60 : 45;
        }
        if (n3 > n4) {
            n3 = n4;
        }
        if (this.fd >= 60) {
            int n5 = new Random().nextInt(5);
            if (this.es == 7) {
                n3 = n3 + 5 + n5;
            } else if (this.es == 8) {
                n3 = n3 + 15 + n5;
            } else if (this.es == 9) {
                n3 = n3 + 25 + n5;
            } else if (this.es == 10) {
                n3 = n3 + 30 + n5;
            }
            if (n3 > 100) {
                n3 = 100;
            }
        }
        if (this.eM > 1.0 && this.eq < 100) {
            if (this.eq < n3) {
                ++this.eq;
                this.eM -= 1.0;
            } else {
                this.eM = 1.0;
            }
        }
        if (this.eq > 100) {
            this.eq = 100;
        }
    }

    private void fX() {
        int n2 = this.fg().getDivisao();
        double d2 = 0.0;
        double d3 = 50.0;
        int n3 = this.fg().getNivel();
        double d4 = 0.0;
        double d5 = this.em - 31;
        if (!this.fg().kn().booleanValue()) {
            n2 = this.fg().getReputacao() >= 4 ? 1 : (this.fg().getReputacao() >= 3 ? 2 : 3);
        }
        if (n3 >= 20) {
            d5 -= 2.0;
        }
        if (this.eq >= 1 && this.eq <= 50) {
            d2 = 0.7 * d5;
        } else if (this.eq >= 51 && this.eq <= 70) {
            d2 = 1.0 * d5;
        } else if (this.eq >= 71 && this.eq <= 100) {
            d2 = 1.2 * d5;
        }
        if (d2 > 0.0) {
            d4 = d2 / d3;
            int n4 = 1;
            if (n2 == 1) {
                n4 = 35;
            } else if (n2 == 2) {
                n4 = 25;
            } else if (n2 == 3) {
                n4 = 10;
            }
            this.eM += d4;
            if (c.a.SR.isHabilidadeIndividual()) {
                this.e(d4);
            }
            if (this.eM > 1.0 && this.eq > n4) {
                --this.eq;
                this.eM -= 1.0;
            }
        }
        if (this.eq < 1) {
            this.eq = 1;
        }
    }

    public void fY() {
        if (this.fg() != null && this.em <= 20) {
            double d2 = 0.01;
            double d3 = 40.0;
            if (this.em <= 17) {
                d2 = 20.0 / d3;
            } else if (this.em == 18) {
                d2 = 15.0 / d3;
            } else if (this.em == 19) {
                d2 = 14.0 / d3;
            } else if (this.em == 20) {
                d2 = 5.0 / d3;
            }
            if (this.es <= 3) {
                d2 += 0.03;
            } else if (this.es <= 6) {
                d2 += 0.04;
            } else if (this.es <= 8) {
                d2 += 0.07;
            } else if (this.es == 9) {
                d2 += 0.1;
            } else if (this.es == 10) {
                d2 += 0.11;
            }
            this.fe += d2;
            if (this.fe > 1.0 && this.fd < 100) {
                ++this.fd;
                this.fe -= 1.0;
            }
            if (this.fd > 100) {
                this.fd = 100;
            }
        }
    }

    public void fZ() {
        int n2 = 0;
        int n3 = new Random().nextInt(100) + 1;
        n2 = n3 <= 15 ? this.es : (n3 <= 60 ? this.es - 1 : this.es + 1);
        if (n2 < 1) {
            n2 = 1;
        }
        if (n2 > 10) {
            n2 = 10;
        }
        this.fc = n2;
    }

    public void ga() {
        int n2 = 0;
        if (this.em == 16) {
            n2 = 15;
        } else if (this.em == 17) {
            n2 = 35;
        } else if (this.em == 18) {
            n2 = 55;
        } else if (this.em == 19) {
            n2 = 70;
        } else if (this.em == 20) {
            n2 = 75;
        }
        n2 += new Random().nextInt(5) + 1;
        if ((n2 += this.es) < 1) {
            n2 = 1;
        }
        if (n2 > 100) {
            n2 = 95;
        }
        this.fd = n2;
    }

    public void gb() {
        ++this.em;
    }

    public void gc() {
        this.gb();
        if (this.em > 35) {
            this.em = new Random().nextInt(10) + 18;
            this.dm = F.au(this.pais);
            this.eT.clear();
            this.eS.clear();
            this.fi = 0;
            this.fh = 0;
        }
        this.eS.clear();
        this.eU.clear();
    }

    public void gd() {
        this.gb();
        this.eS.clear();
        this.eU.clear();
        if (this.dm == null || this.dm.equals("TESTE")) {
            this.dm = F.au(this.pais);
        }
        this.ge();
    }

    public void ge() {
        if (this.fg() != null && !this.eX.booleanValue()) {
            if (this.fg().jZ().booleanValue()) {
                this.eY = false;
            }
            boolean bl2 = false;
            int n2 = aq.cu(100) + 1;
            if (this.em > 32) {
                int n3 = this.em;
                if (this.ff().booleanValue()) {
                    --n3;
                }
                if (this.gm().booleanValue()) {
                    n3 -= 3;
                }
                if (this.en == 0) {
                    n3 -= 3;
                }
                if (n3 < 32) {
                    bl2 = false;
                } else if (n3 == 32) {
                    if (n2 > 99) {
                        bl2 = true;
                    }
                } else if (n3 <= 34) {
                    if (n2 > 90) {
                        bl2 = true;
                    }
                } else if (n3 <= 35) {
                    if (n2 > 55) {
                        bl2 = true;
                    }
                } else if (n3 <= 36) {
                    if (n2 > 30) {
                        bl2 = true;
                    }
                } else if (n3 <= 38) {
                    if (n2 > 15) {
                        bl2 = true;
                    }
                } else if (n3 <= 39) {
                    if (n2 > 5) {
                        bl2 = true;
                    }
                } else if (n3 <= 40) {
                    if (n2 > 3) {
                        bl2 = true;
                    }
                } else if (n3 <= 42) {
                    if (n2 > 2) {
                        bl2 = true;
                    }
                } else if (n3 <= 48) {
                    if (n2 > 1) {
                        bl2 = true;
                    }
                } else {
                    bl2 = true;
                }
                if (bl2) {
                    if (!this.fg().jZ().booleanValue()) {
                        this.a(null, -1, true);
                    } else {
                        new as(this.fg().ka(), 34, 89, "", this.getNome());
                    }
                }
            }
        }
    }

    public boolean a(String string, int n2, boolean bl2) {
        Serializable serializable;
        int n3;
        int n4;
        boolean bl3 = false;
        boolean bl4 = false;
        ah ah2 = this.fg();
        if (ah2 == null) {
            return false;
        }
        if (ah2.kn().booleanValue()) {
            int n5 = ah2.getDivisao();
            n4 = 0;
            n4 = n5 == 0 ? 120 : (n5 == 1 ? 25 : (n5 == 2 ? 50 : (n5 == 3 ? 60 : (n5 == 4 ? 100 : 125))));
            if (this.ek.booleanValue()) {
                n4 = 5;
            }
            if (this.gm().booleanValue()) {
                n4 = 2;
            }
            if ((n3 = new Random().nextInt(n4)) == 1) {
                bl3 = true;
            }
        }
        int[] nArray = new int[]{2, 3, 3, 6, 4};
        n4 = 0;
        n4 = ah2.bS(this.en) - 1;
        if (!ah2.jZ().booleanValue()) {
            n2 = this.en;
            if (n4 < nArray[this.en]) {
                bl4 = true;
                n2 = this.en;
            }
            if (ah2.kw() < 16) {
                bl4 = true;
            }
        }
        n3 = 0;
        if (ah2.kx() >= 20 && ah2.jZ().booleanValue()) {
            bl4 = true;
        }
        int n6 = 2;
        if (ah2.getDivisao() > 2) {
            n6 = 5;
        }
        if (ah2.getReputacao() < 3) {
            n6 = 5;
        }
        if (ah2.jZ().booleanValue()) {
            n6 = 0;
        }
        if (ah2.kx() >= 20 - n6 && !bl4) {
            n3 = 1;
        }
        ah2.kc().remove(this);
        this.gr().clear();
        this.gH().clear();
        if (c.a.SR.H() < 2 && this.fh > 0) {
            new b(this.getNome(), this.gy(), this.gz());
        } else if (c.a.SR.H() < 10 && this.fh > 10) {
            new b(this.getNome(), this.gy(), this.gz());
        } else if (c.a.SR.H() < 20 && this.fh > 30) {
            new b(this.getNome(), this.gy(), this.gz());
        } else if (this.fh > 50) {
            new b(this.getNome(), this.gy(), this.gz());
        }
        this.fi = 0;
        this.fh = 0;
        this.fn = 0;
        if (this.gl().booleanValue()) {
            this.eX = false;
        }
        this.n(null);
        if (bl2) {
            c.a.SR.bz.add(this);
        } else {
            c.a.SR.O().remove(this);
        }
        if (n3 == 0) {
            serializable = null;
            serializable = F.a(ah2, n2, null, 0, string, bl2);
            if (bl4 && serializable != null) {
                K.a(bl2, (F)serializable, ah2);
            }
        }
        if (bl3) {
            serializable = new al(this.dm);
            c.a.SR.a((al)serializable);
            ((al)serializable).b(this.fg(), this);
        }
        return true;
    }

    public void gf() {
        ++this.em;
        boolean bl2 = false;
        if (this.dm == null || this.dm.equals("TESTE")) {
            this.dm = F.au(this.pais);
        }
        ah ah2 = this.fg();
        int n2 = 4;
        int[] nArray = new int[]{1, 4, 5, 6, 6, 6};
        if (ah2 != null && this.em >= 20) {
            n2 = nArray[ah2.getReputacao()];
            int[] nArray2 = ah2.J(true);
            int[] nArray3 = new int[]{3, 5, 5, 8, 6};
            if (this.es >= n2 && nArray2[this.en] < nArray3[this.en]) {
                bl2 = true;
            }
            if (bl2) {
                if (ah2.kw() < 32) {
                    K.a(true, this, ah2);
                    if (ah2.kx() < 20) {
                        F.a(ah2, -1, null, 0, null, true);
                    }
                }
            } else if (!ah2.jZ().booleanValue()) {
                F.a(ah2, -1, this, 0, null, true);
            }
        }
    }

    public static F a(ah ah2, int n2, F f2, int n3, String string, Boolean bl2) {
        F f3;
        if (f2 == null) {
            W w2 = new W();
            f3 = new F(w2, ah2);
            if (bl2.booleanValue()) {
                c.a.SR.bA.add(f3);
            } else {
                c.a.SR.Q().add(f3);
            }
            if (!ah2.ky().contains(ah2)) {
                ah2.ky().add(f3);
            }
        } else {
            f3 = f2;
        }
        f3.fb = true;
        f3.n(ah2);
        int n4 = new Random().nextInt(100) + 1;
        int n5 = 1;
        if (ah2.getNivel() >= 19 || ah2.getReputacao() > 3) {
            if (n4 <= 2) {
                n5 = 1;
            } else if (n4 <= 5) {
                n5 = 2;
            } else if (n4 <= 4) {
                n5 = 3;
            } else if (n4 <= 10) {
                n5 = 4;
            } else if (n4 <= 25) {
                n5 = 5;
            } else if (n4 <= 60) {
                n5 = 6;
            } else if (n4 <= 80) {
                n5 = 7;
            } else if (n4 <= 90) {
                n5 = 8;
            } else if (n4 <= 98) {
                n5 = 9;
            } else if (n4 <= 100) {
                n5 = 10;
            }
        } else if (ah2.getNivel() >= 15) {
            if (n4 <= 2) {
                n5 = 1;
            } else if (n4 <= 5) {
                n5 = 2;
            } else if (n4 <= 4) {
                n5 = 3;
            } else if (n4 <= 10) {
                n5 = 4;
            } else if (n4 <= 30) {
                n5 = 5;
            } else if (n4 <= 65) {
                n5 = 6;
            } else if (n4 <= 90) {
                n5 = 7;
            } else if (n4 <= 95) {
                n5 = 8;
            } else if (n4 <= 98) {
                n5 = 9;
            } else if (n4 <= 100) {
                n5 = 10;
            }
        } else if (n4 <= 4) {
            n5 = 1;
        } else if (n4 <= 8) {
            n5 = 2;
        } else if (n4 <= 15) {
            n5 = 3;
        } else if (n4 <= 25) {
            n5 = 4;
        } else if (n4 <= 50) {
            n5 = 5;
        } else if (n4 <= 75) {
            n5 = 6;
        } else if (n4 <= 95) {
            n5 = 7;
        } else if (n4 <= 98) {
            n5 = 8;
        } else if (n4 <= 99) {
            n5 = 9;
        } else if (n4 <= 100) {
            n5 = 10;
        }
        f3.es = n5;
        f3.ek = n4 == 1 ? Boolean.valueOf(true) : Boolean.valueOf(false);
        f3.em = new Random().nextInt(4) + 16;
        n4 = new Random().nextInt(100) + 1;
        f3.en = n4 <= 10 ? 0 : (n4 <= 30 ? 1 : (n4 <= 50 ? 2 : (n4 <= 80 ? 3 : 4)));
        if (n2 >= 0) {
            f3.en = n2;
        }
        int[] nArray = F.at(f3.en);
        f3.ey = nArray[0];
        f3.ez = nArray[1];
        f3.pais = ah2.getPais();
        if (n4 == 1 && ah2.getNivel() >= 18) {
            int n6 = new Random().nextInt(6);
            if (ah2.getPais() == 29) {
                f3.pais = n6 == 0 ? 11 : (n6 == 1 ? 43 : (n6 == 2 ? 195 : (n6 == 3 ? 150 : (n6 == 4 ? 84 : new Random().nextInt(200)))));
            } else if (ah2.getPais() == 3 || ah2.getPais() == 154 || ah2.getPais() == 85 || ah2.getPais() == 104 || ah2.getPais() == 72) {
                f3.pais = n6 == 0 ? 3 : (n6 == 1 ? 154 : (n6 == 2 ? 85 : (n6 == 3 ? 104 : (n6 == 4 ? 174 : 72))));
            }
        }
        if (f3.pais != ah2.getPais()) {
            f3.es = new Random().nextInt(4) + 7;
        }
        f3.dm = string == null ? F.au(f3.pais) : string;
        f3.er = new Random().nextInt(2);
        f3.status = 0;
        f3.fG();
        f3.ga();
        f3.fI();
        f3.fJ();
        f3.fZ();
        return f3;
    }

    public static int[] at(int n2) {
        int[][][] nArrayArray = new int[5][][];
        int[][] nArrayArray2 = new int[6][];
        int[] nArray = new int[2];
        nArray[1] = 3;
        nArrayArray2[0] = nArray;
        int[] nArray2 = new int[2];
        nArray2[1] = 1;
        nArrayArray2[1] = nArray2;
        int[] nArray3 = new int[2];
        nArray3[0] = 2;
        nArrayArray2[2] = nArray3;
        nArrayArray2[3] = new int[]{1, 2};
        nArrayArray2[4] = new int[]{3, 1};
        int[] nArray4 = new int[2];
        nArray4[1] = 2;
        nArrayArray2[5] = nArray4;
        nArrayArray[0] = nArrayArray2;
        nArrayArray[1] = new int[][]{{6, 10}, {6, 13}, {10, 11}, {10, 13}, {10, 6}, {10, 9}, {6, 11}};
        nArrayArray[2] = new int[][]{{7, 10}, {7, 12}, {7, 5}, {10, 13}, {7, 13}, {7, 10}, {7, 5}, {7, 13}, {7, 12}, {7, 9}, {7, 10}, {5, 12}};
        nArrayArray[3] = new int[][]{{4, 11}, {4, 9}, {9, 11}, {11, 9}, {4, 8}, {4, 13}, {7, 10}, {7, 11}, {7, 5}, {7, 13}, {10, 13}, {10, 11}, {9, 4}, {10, 12}, {4, 11}, {8, 11}, {7, 9}, {11, 13}, {7, 11}};
        nArrayArray[4] = new int[][]{{9, 5}, {13, 9}, {9, 5}, {8, 9}, {9, 13}, {9, 5}, {9, 8}, {5, 13}, {8, 11}, {9, 11}, {9, 12}, {13, 8}};
        int[][][] nArrayArray3 = nArrayArray;
        int[][] nArray5 = nArrayArray3[n2];
        int n3 = aq.cu(nArray5.length);
        int[] nArray6 = new int[]{nArray5[n3][0], nArray5[n3][1]};
        return nArray6;
    }

    public static String au(int n2) {
        String string = null;
        string = new M().au(n2);
        if (string == null || string.length() == 0 || string.isEmpty()) {
            string = F.av(n2);
        }
        return string;
    }

    public static String av(int n2) {
        if (c.a.SR.aX().size() == 0) {
            return null;
        }
        int n3 = n2;
        int n4 = ac.valueOf("P" + Integer.toString(n2)).gg();
        int n5 = 0;
        int n6 = 0;
        String string = new String();
        if (n4 == 0) {
            if (n3 == 97 || n3 == 62 || n3 == 100 || n3 == 101 || n3 == 145) {
                n5 = 8710;
                n6 = 1980;
            } else if (n3 == 3 || n3 == 15) {
                n5 = 10870;
                n6 = 1155;
            } else if (n3 == 104) {
                n5 = 12025;
                n6 = 1700;
            } else if (n3 == 72) {
                n5 = 13726;
                n6 = 901;
            } else if (n3 == 85) {
                n5 = 14627;
                n6 = 1830;
            } else if (n3 == 154) {
                n5 = 16458;
                n6 = 3528;
            } else if (n3 == 142 || n3 == 70 || n3 == 15 || n3 == 179 || n3 == 54) {
                n5 = 19986;
                n6 = 1340;
            } else if (n3 == 162 || n3 == 193 || n3 == 12 || n3 == 25 || n3 == 54) {
                n5 = 21327;
                n6 = 1429;
            } else if (n3 == 159 || n3 == 152 || n3 == 88 || n3 == 160 || n3 == 63 || n3 == 64) {
                n5 = 22756;
                n6 = 1257;
            } else if (n3 == 52 || n3 == 27) {
                n5 = 24013;
                n6 = 1774;
            } else if (n3 == 78 || n3 == 44) {
                n5 = 25787;
                n6 = 784;
            } else if (n3 == 21) {
                n5 = 13726;
                n6 = 2732;
            } else if (n3 == 65) {
                n5 = 5939;
                n6 = 2771;
            } else {
                n5 = 19986;
                n6 = 5801;
            }
        } else if (n4 == 1) {
            if (n3 == 29) {
                n5 = 1;
                n6 = 5938;
            } else {
                n5 = 5939;
                n6 = 2771;
            }
        } else if (n4 == 2) {
            if (n3 == 57 || n3 == 10 || n3 == 129 || n3 == 116 || n3 == 178 || n3 == 190) {
                n5 = 31211;
                n6 = 2554;
            } else {
                n5 = 26571;
                n6 = 2398;
            }
        } else if (n4 == 3) {
            if (n3 == 48 || n3 == 49) {
                n5 = 29578;
                n6 = 560;
            } else if (n3 == 107) {
                n5 = 30138;
                n6 = 1072;
            } else if (n3 == 43) {
                n5 = 28970;
                n6 = 607;
            } else if (n3 == 14) {
                n5 = 8710;
                n6 = 1980;
            } else if (n3 == 9 || n3 == 18 || n3 == 59 || n3 == 89 || n3 == 99 || n3 == 98 || n3 == 108 || n3 == 111 || n3 == 115 || n3 == 117 || n3 == 144 || n3 == 146 || n3 == 103 || n3 == 39 || n3 == 190) {
                n5 = 31211;
                n6 = 2554;
            } else {
                n5 = 28970;
                n6 = 4795;
            }
        } else if (n4 == 4) {
            if (n3 == 68 || n3 == 38 || n3 == 106) {
                n5 = 8710;
                n6 = 1980;
            } else {
                n5 = 5939;
                n6 = 2771;
            }
        } else if (n4 == 5) {
            n5 = 8710;
            n6 = 1980;
        } else {
            n5 = 1;
            n6 = 20000;
        }
        int n7 = new Random().nextInt(n6) + n5;
        if (n7 < c.a.SR.aX().size()) {
            string = (String)c.a.SR.aX().get(n7);
        }
        return string;
    }

    public int gg() {
        return ac.valueOf("P" + Integer.toString(this.pais)).gg();
    }

    public int gh() {
        if (this.fg() != null) {
            return this.fg().gg();
        }
        return -1;
    }

    public F(g g2, boolean bl2, ah ah2) {
        this.setPais(g2.getPais());
        this.setNome(g2.getNome());
        this.n(ah2);
        this.setPosicao(g2.getPosicao());
        this.setLado(g2.getLado());
        this.el = g2.isTopMundial();
        this.a(g2.isEstrela());
        this.aq(g2.getHash());
        this.setStatus(g2.getStatus());
        this.setCr1(g2.getCr1());
        this.setCr2(g2.getCr2());
        this.h(bl2);
        this.setIdade(g2.getIdade());
        this.fG();
    }

    public H g(at at2) {
        H h3 = null;
        int n2 = 0;
        while (n2 < this.eS.size()) {
            if (((H)this.eS.get(n2)).gS() == at2) {
                return (H)this.eS.get(n2);
            }
            ++n2;
        }
        return h3;
    }

    public H h(at at2) {
        if (this.eS != null) {
            int n2 = 0;
            while (n2 < this.eS.size()) {
                if (((H)this.eS.get(n2)).gS() == at2) {
                    return (H)this.eS.get(n2);
                }
                ++n2;
            }
            H h3 = new H(this, at2);
            this.eS.add(h3);
            return h3;
        }
        return null;
    }

    public k o(ah ah2) {
        if (this.eT != null) {
            int n2 = 0;
            while (n2 < this.eT.size()) {
                if (((k)this.eT.get(n2)).ct() == ah2.lk() && ((k)this.eT.get(n2)).H() == c.a.SR.H()) {
                    return (k)this.eT.get(n2);
                }
                ++n2;
            }
        }
        return null;
    }

    public void p(ah ah2) {
        int n2;
        int n3 = 0;
        int n4 = new Random().nextInt(14);
        int n5 = 5 + new Random().nextInt(20);
        if (this.eK < 10) {
            n3 += 5;
        } else if (this.eK < 50) {
            ++n3;
        }
        n3 = this.em <= 20 ? n4 : (this.em <= 25 ? n3 + n4 + 1 : (this.em <= 30 ? n3 + n4 + 2 : (this.em <= 35 ? n3 + n4 + 3 : (this.em <= 40 ? n3 + n4 + n5 : (this.em <= 45 ? n3 + n4 + n5 : n3 + n4 + 10 + n5)))));
        if (this.em >= 35) {
            this.eq -= 5;
            if (this.eq < 0) {
                this.eq = 1;
            }
        }
        if ((n2 = new Random().nextInt(100)) == 1) {
            n3 += 70;
        } else if (n2 < 4) {
            n3 += 40;
        } else if (n2 < 10) {
            n3 += 20;
        }
        if (this.fg() != null && this.fg().ka() != null && this.fg().ka().jZ().booleanValue() && n3 >= 8) {
            if (n3 < 15) {
                new as(this.fg().ka(), 3, new Random().nextInt(3) + 23, this.getNome(), "");
            } else if (n3 < 22) {
                new as(this.fg().ka(), 3, new Random().nextInt(2) + 26, this.getNome(), "");
            } else if (n3 < 29) {
                new as(this.fg().ka(), 3, new Random().nextInt(2) + 28, this.getNome(), "");
            } else if (n3 < 43) {
                new as(this.fg().ka(), 3, new Random().nextInt(4) + 30, this.getNome(), "");
            } else if (n3 < 55) {
                new as(this.fg().ka(), 3, new Random().nextInt(2) + 34, this.getNome(), "");
            } else if (n3 < 70) {
                new as(this.fg().ka(), 3, new Random().nextInt(4) + 36, this.getNome(), "");
            } else if (n3 >= 70) {
                new as(this.fg().ka(), 3, new Random().nextInt(4) + 40, this.getNome(), "");
            }
        }
        if (n3 > 0) {
            long l2 = ((a)c.a.SR.R().get(c.a.SR.J())).a().getTime().getTime();
            long l3 = n3;
            this.eI = l2 + (l3 *= 86400000L);
        }
        this.b(5, ah2);
    }

    public boolean a(int n2, at at2, ah ah2) {
        if (this.fC().booleanValue()) {
            return false;
        }
        if (at2 != null && at2 != c.a.SR.bv()) {
            H h3 = this.h(at2);
            if (n2 == 2) {
                h3.cz();
            } else if (n2 == 3) {
                h3.cB();
            } else if (n2 == 4) {
                int n3;
                int n4 = new Random().nextInt(1000);
                int n5 = 1;
                if (n4 >= 700) {
                    if (n4 < 900) {
                        n5 = 2;
                    } else if (n4 < 970) {
                        n5 = 3;
                    } else if (n4 <= 990) {
                        n5 = 5;
                    } else if (n4 <= 1000) {
                        n5 = 10;
                    }
                }
                if (this.fg() != null && this.fg().ka() != null && this.fg().ka().jZ().booleanValue()) {
                    if (n5 == 2) {
                        new as(this.fg().ka(), 1, new Random().nextInt(6) + 10, this.getNome(), "");
                    } else if (n5 > 1) {
                        n3 = 1;
                        int n6 = 5;
                        if (n5 == 3) {
                            n6 = new Random().nextInt(5) + 5;
                        } else if (n5 == 5) {
                            n6 = new Random().nextInt(3) + 2;
                        } else if (n5 == 10) {
                            n6 = new Random().nextInt(2) + 0;
                        }
                        new as(true, 1, this.fg(), this, this.fg().ka(), n3, n6, this.getNome(), "");
                    }
                }
                n3 = 0;
                while (n3 < n5) {
                    h3.cA();
                    ++n3;
                }
            }
        }
        this.b(n2, ah2);
        return true;
    }

    public boolean a(at at2, ah ah2) {
        if (this.fC().booleanValue()) {
            return false;
        }
        if (at2 != null) {
            H h3 = this.h(at2);
            h3.z();
            c c2 = at2.p(this);
            c2.z();
        }
        this.b(1, ah2);
        ++this.fh;
        return true;
    }

    public void b(at at2, ah ah2) {
        if (!this.fC().booleanValue()) {
            if (at2 != null) {
                H h3 = this.h(at2);
                h3.cl();
            }
            this.b(0, ah2);
            ++this.fi;
        }
    }

    public void a(at at2, double d2) {
        if (!this.fC().booleanValue() && at2 != null) {
            H h3 = this.h(at2);
            h3.i(d2);
        }
    }

    public void a(int n2, ah ah2, at at2) {
        this.a(n2, ah2, 0.0, at2);
    }

    public void b(int n2, ah ah2) {
        this.a(n2, ah2, 0.0, null);
    }

    public void a(int n2, ah ah2, double d2) {
        this.a(n2, ah2, d2, null);
    }

    public void a(int n2, ah ah2, double d2, at at2) {
        k k2 = this.o(ah2);
        if (k2 == null) {
            k2 = new k(this, ah2);
            if (this.eT != null) {
                this.eT.add(k2);
            }
        }
        if (n2 == 2) {
            k2.cz();
        } else if (n2 == 4) {
            k2.cA();
        } else if (n2 == 3) {
            k2.cB();
        } else if (n2 == 1) {
            k2.z();
        } else if (n2 == 5) {
            k2.cy();
        } else if (n2 == 0) {
            k2.cl();
        } else if (n2 == 8) {
            k2.a(this, at2);
        } else if (n2 == 100) {
            k2.b(d2);
        }
    }

    public void a(at at2, I i2, int n2, int n3, ah ah2) {
        int[] nArray;
        int[] nArray2 = new int[]{1, 2, 7, 15, 23};
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int n7 = 90;
        int n8 = 0;
        while (n8 < i2.hE().size()) {
            if (((A)i2.hE().get(n8)).eo() == this) {
                n7 = ((A)i2.hE().get(n8)).en() == 1 ? ((A)i2.hE().get(n8)).em() : 48 + ((A)i2.hE().get(n8)).em();
            }
            if (((A)i2.hE().get(n8)).ep() == this) {
                n7 = ((A)i2.hE().get(n8)).en() == 1 ? 48 + (50 - ((A)i2.hE().get(n8)).em()) : 50 - ((A)i2.hE().get(n8)).em();
            }
            ++n8;
        }
        if (n2 == 0) {
            if (i2.hu() > i2.hw()) {
                n4 = 1;
            } else if (i2.hu() < i2.hw()) {
                n4 = 2;
            }
            n5 = i2.hu();
            n6 = i2.hw();
        } else {
            if (i2.hw() > i2.hu()) {
                n4 = 1;
            } else if (i2.hw() < i2.hu()) {
                n4 = 2;
            }
            n5 = i2.hw();
            n6 = i2.hu();
        }
        double d2 = 5.5;
        int n9 = this.eR;
        if (n9 < 1) {
            this.eR = n9 = nArray2[this.en];
        }
        if (n4 == 0) {
            d2 = this.eq <= 30 ? 5.5 : (this.eq <= 60 ? 5.8 : (this.eq <= 90 ? 6.2 : 6.8));
        } else if (n4 == 1) {
            d2 = this.eq <= 30 ? 6.0 : (this.eq <= 60 ? 6.0 : (this.eq <= 90 ? 6.7 : 7.2));
        } else if (n4 == 2) {
            d2 = this.eq <= 30 ? 5.0 : (this.eq <= 60 ? 5.2 : (this.eq <= 90 ? 5.5 : 6.0));
        }
        if (this.gF()) {
            d2 -= 1.5;
            if (this.fT() == 1) {
                d2 -= 1.5;
            }
        }
        Random random = new Random();
        if (n9 >= 10 && n9 <= 17) {
            nArray = i2.hz();
            if (nArray[n2] > nArray[n3]) {
                d2 = random.nextInt(3) == 1 ? (d2 += 0.3) : (d2 += 0.8);
                if (this.ex == 0) {
                    d2 += 0.3;
                }
                if (this.getCr1() == 11 || this.getCr1() == 4) {
                    d2 += 0.5;
                }
            } else if (nArray[n2] < nArray[n3]) {
                d2 = random.nextInt(3) == 1 ? (d2 -= 0.3) : (d2 -= 0.8);
                if (this.ex == 0) {
                    d2 -= 0.5;
                }
            }
        }
        if (this.gB().y() > 0) {
            d2 += (double)this.gB().y() * 0.9;
        }
        if (this.gB().tx() > 0) {
            d2 -= (double)this.gB().tx() * 1.5;
        }
        if (this.gB().ty() > 0) {
            d2 -= (double)this.gB().tx() * 1.2;
        }
        if (this.gB().tz() > 0) {
            d2 -= (double)this.gB().tz() * 0.2;
        }
        if (this.gB().tA() > 0) {
            d2 -= (double)this.gB().tA() * 0.8;
        }
        if (this.gB().cD() > 0) {
            d2 += (double)this.gB().cD() * 0.4;
        }
        if (n9 >= 1 && n9 <= 13) {
            nArray = i2.hB();
            if (nArray[n2] > nArray[n3]) {
                d2 = random.nextInt(3) == 1 ? (d2 += 0.9) : (d2 += 0.6);
                if (n9 >= 2 && n9 <= 9 && random.nextInt(3) == 1) {
                    d2 += 0.6;
                }
                if (n9 >= 11 && n9 <= 13 && random.nextInt(3) == 1) {
                    d2 += 0.6;
                }
            } else if (nArray[n2] < nArray[n3]) {
                d2 -= 0.5;
                if (n9 >= 3 && n9 <= 8 && random.nextInt(4) == 1) {
                    d2 -= 0.6;
                }
                if (n9 >= 11 && n9 <= 13 && random.nextInt(4) == 1) {
                    d2 -= 0.6;
                }
            }
        }
        if (this.gB().tK() > 0) {
            d2 += (double)this.gB().tK() * 0.3;
        }
        if (n9 == 1) {
            d2 -= 0.8;
            nArray = i2.hA();
            int[] nArray3 = i2.hZ();
            int n10 = nArray3[n3];
            d2 += (double)n10 * 0.2;
            if (this.gB().tI() > 0) {
                d2 += (double)this.gB().tI() * 1.2;
            }
            if (nArray[n3] > 10) {
                d2 += 0.2;
            } else if (nArray[n3] > 15) {
                d2 += 0.2;
            } else if (nArray[n3] > 20) {
                d2 += 0.3;
            }
            if (n6 >= 5) {
                d2 -= 2.0;
            } else if (n6 >= 4) {
                d2 -= 1.5;
            } else if (n6 >= 2) {
                d2 -= 1.0;
            } else if (n6 >= 1) {
                d2 -= 0.5;
            } else if (n6 == 0) {
                d2 += 1.0;
            }
            if (n10 == 0) {
                d2 -= 1.5;
            }
        }
        if (n9 >= 1 && n9 <= 13) {
            if (n6 == 0) {
                d2 += 0.5;
                if (n9 >= 2 && n9 <= 9) {
                    d2 += 0.5;
                }
                if (n9 >= 11 && n9 <= 13 && random.nextInt(3) == 1) {
                    d2 += 0.5;
                }
            } else if (n6 > 1) {
                d2 -= 0.1 * (double)n6;
            }
            if (n9 >= 2 && n9 <= 13 && random.nextInt(3) == 1) {
                d2 -= 0.4;
            }
        }
        if (this.ek.booleanValue()) {
            d2 += 0.4;
        }
        if (this.el.booleanValue()) {
            d2 += 0.6;
        }
        if (d2 > 10.0) {
            d2 = 10.0;
        }
        if (d2 < 0.0) {
            d2 = 1.0;
        }
        if (n7 < 15) {
            d2 -= 2.5;
        } else if (n7 < 45) {
            d2 -= 1.5;
        }
        if (d2 < 2.0) {
            d2 = 2.0;
        }
        if (n7 < 20 && d2 <= 2.0) {
            d2 = 0.0;
        }
        this.eN = d2;
        this.eU.add(new J(i2, this.eN));
        if (this.fg() != null) {
            this.a(100, ah2, d2);
        }
        if (d2 > 0.0 && i2.hy() != null && i2.hy() instanceof B) {
            ((B)i2.hy()).E(this);
            ((B)i2.hy()).F(this);
        }
        if (d2 > 0.0 && at2 != null && at2.b() > 0) {
            this.a(at2, d2);
        }
    }

    public int gi() {
        return this.fg;
    }

    public void gj() {
        ++this.fg;
    }

    public void aw(int n2) {
        this.fg = n2;
    }

    public double gk() {
        return this.eN;
    }

    public void g(double d2) {
        this.eN = d2;
    }

    public void a(long l2, boolean bl2) {
        long l3 = ((a)c.a.SR.R().get(c.a.SR.J())).a().getTime().getTime();
        if (!bl2) {
            l3 = this.eJ;
        }
        long l4 = l2 * 86400000L;
        this.eJ = l3 + l4;
        int n2 = (int)l2;
        this.aB(n2);
        this.fr = false;
    }

    public Boolean gl() {
        return this.eX;
    }

    public void i(Boolean bl2) {
        this.eX = bl2;
    }

    public void c(ah ah2, int n2) {
        ah ah3 = this.fg();
        this.n(ah2);
        this.ew = 0;
        this.eW = false;
        this.eY = false;
        ah3.v(n2, 1);
        ah2.w(n2, 1);
        Calendar calendar = ((a)c.a.SR.R().get(c.a.SR.J())).a();
        ap ap2 = new ap();
        ap2.a(this);
        ap2.f(calendar.get(5), calendar.get(2), calendar.get(1));
        ap2.cs(ah3.lk());
        ap2.cr(ah2.lk());
        ap2.cq(n2);
        this.ag(n2);
        c.a.SR.bo().add(ap2);
        ah3.ky().remove(this);
        ah2.ky().add(this);
        this.fk = null;
    }

    public void a(ah ah2, int n2, boolean bl2, boolean bl3, boolean bl4) {
        ah ah3 = this.fg();
        this.am(ah3.lk());
        this.n(ah2);
        if (!ah3.equals(ah2)) {
            this.ew = 0;
            this.eW = false;
            this.eY = false;
            if (bl3 && !bl4) {
                this.eX = true;
            }
            if (bl4) {
                this.eX = false;
                this.eW = false;
            }
            Calendar calendar = ((a)c.a.SR.R().get(c.a.SR.J())).a();
            int n3 = 0;
            if (!bl3 && !bl4) {
                if (bl2 && this.eJ > 0L && calendar != null) {
                    double d2 = 0.0;
                    int n4 = this.fR();
                    if (n4 > 0) {
                        d2 = n4 <= 30 ? 0.12 : (n4 <= 60 ? 0.2 : (n4 <= 90 ? 0.22 : (n4 <= 180 ? 0.25 : 0.3)));
                    }
                    n3 = (int)Math.round((double)n2 * d2);
                }
                if (n3 > 0) {
                    ah3.kL();
                }
                if (ah3.jZ().booleanValue()) {
                    ah3.v(n2, 1);
                    if (n3 > 0) {
                        ah3.w(n3, 8);
                    }
                }
                if (ah2.jZ().booleanValue()) {
                    ah2.w(n2, 1);
                }
            }
            if (!bl3) {
                this.a(180L, true);
            } else {
                this.a(365L, true);
            }
            this.fm();
            if (ah3.ke() == this) {
                ah3.kA();
            }
            if (ah3.kd() == this) {
                ah3.kz();
            }
            if (ah3.jZ().booleanValue() && ah2.jZ().booleanValue()) {
                this.e(true);
            }
            ap ap2 = new ap();
            ap2.a(this);
            ap2.f(calendar.get(5), calendar.get(2), calendar.get(1));
            ap2.cs(ah3.lk());
            ap2.cr(ah2.lk());
            ap2.cq(n2);
            c.a.SR.bo().add(ap2);
            ah3.kc().remove(this);
            if (ah3.kc().contains(this)) {
                ah3.kc().remove(this);
            }
            ah2.kc().add(this);
            if (ah2.jZ().booleanValue() && ah3.jZ().booleanValue()) {
                ah3.I(false);
            }
            this.fk = null;
        }
    }

    public Boolean gm() {
        return this.el;
    }

    public JProgressBar a(Color color) {
        if (this.fk == null) {
            this.fk = new JProgressBar(1, 100);
        }
        this.fk.setValue(this.eK);
        this.fk.setStringPainted(true);
        if (color != null) {
            this.fk.setForeground(color);
        } else if (this.fg() != null) {
            this.fk.setForeground(this.fg().kB());
        }
        return this.fk;
    }

    public void a(JProgressBar jProgressBar) {
        this.fk = jProgressBar;
    }

    public String gn() {
        String string = "";
        double d2 = 0.0;
        double d3 = 0.0;
        double d4 = 0.0;
        if (this.gv() != null) {
            int n2 = this.gv().size() - 1;
            while (n2 >= 0) {
                if (((J)this.gv().get(n2)).C() >= 2.0) {
                    d2 += ((J)this.gv().get(n2)).C();
                    d4 += 1.0;
                }
                --n2;
            }
        }
        if (d4 > 0.0) {
            d3 = d2 / d4;
            string = String.format("%.2f", d3);
            this.ab = d3;
        } else if (d4 == 0.0) {
            string = "--";
            this.ab = 0.0;
        }
        return string;
    }

    public JProgressBar go() {
        if (this.fk == null) {
            this.fk = new JProgressBar(1, 100);
        }
        this.fk.setValue(this.fd);
        this.fk.setStringPainted(true);
        this.fk.setForeground(new Color(36, 91, 45));
        return this.fk;
    }

    public void a(ImageIcon imageIcon) {
        this.fj = imageIcon;
    }

    public ImageIcon gp() {
        return this.fl;
    }

    public void b(ImageIcon imageIcon) {
        this.fl = imageIcon;
    }

    public ImageIcon gq() {
        return this.fm;
    }

    public void c(ImageIcon imageIcon) {
        this.fm = imageIcon;
    }

    public ArrayList gr() {
        return this.eT;
    }

    public int gs() {
        int n2 = 0;
        int n3 = 0;
        while (n3 < this.eT.size()) {
            if (((k)this.eT.get(n3)).H() == c.a.SR.H()) {
                n2 += ((k)this.eT.get(n3)).cD();
            }
            ++n3;
        }
        return n2;
    }

    public int gt() {
        int n2 = 0;
        int n3 = 0;
        while (n3 < this.eT.size()) {
            if (((k)this.eT.get(n3)).H() == c.a.SR.H()) {
                n2 += ((k)this.eT.get(n3)).y();
            }
            ++n3;
        }
        return n2;
    }

    public int gu() {
        int n2 = 0;
        int n3 = 0;
        while (n3 < this.eT.size()) {
            if (((k)this.eT.get(n3)).H() == c.a.SR.H()) {
                n2 += ((k)this.eT.get(n3)).w();
            }
            ++n3;
        }
        return n2;
    }

    public int i(at at2) {
        H h3 = this.h(at2);
        if (h3 != null) {
            return h3.w();
        }
        return 0;
    }

    public int j(at at2) {
        H h3 = this.h(at2);
        if (h3 != null) {
            return h3.cD();
        }
        return 0;
    }

    public String k(at at2) {
        String string = "";
        double d2 = 0.0;
        H h3 = this.g(at2);
        if (h3 != null) {
            d2 = this.g(at2).F();
        }
        if (d2 > 0.0) {
            string = String.format("%.2f", d2);
            this.ab = d2;
        } else {
            string = "--";
            this.ab = 0.0;
        }
        return string;
    }

    public double l(at at2) {
        H h3 = this.g(at2);
        if (h3 != null) {
            return this.g(at2).F();
        }
        return 0.0;
    }

    public ArrayList gv() {
        return this.eU;
    }

    public void q(ah ah2) {
        new t(this, this.fg());
        this.a(ah2, 0, false, true, false);
    }

    public void r(ah ah2) {
        this.a(ah2, 0, false, false, true);
    }

    public int[] gw() {
        int[] nArray = new int[6];
        if (this.gr() != null) {
            int n2 = this.gr().size() - 1;
            while (n2 >= 0) {
                nArray[0] = nArray[0] + ((k)this.gr().get(n2)).w();
                nArray[1] = nArray[1] + ((k)this.gr().get(n2)).y();
                nArray[2] = nArray[2] + ((k)this.gr().get(n2)).cv();
                nArray[3] = nArray[3] + ((k)this.gr().get(n2)).cw();
                nArray[4] = nArray[4] + ((k)this.gr().get(n2)).cx();
                nArray[5] = nArray[5] + ((k)this.gr().get(n2)).cD();
                --n2;
            }
        }
        return nArray;
    }

    public String gx() {
        String string = "";
        int n2 = 0;
        double d2 = 0.0;
        double d3 = 0.0;
        if (this.gr() != null) {
            int n3 = this.gr().size() - 1;
            while (n3 >= 0) {
                n2 += ((k)this.gr().get(n3)).cF();
                d3 += ((k)this.gr().get(n3)).F();
                --n3;
            }
        }
        if (n2 > 0) {
            d2 = d3 / (double)n2;
            string = String.format("%.2f", d2);
        } else if (n2 == 0) {
            string = "--";
        }
        return string;
    }

    public String toString() {
        String string = "";
        if (this.fn() > 0) {
            string = String.valueOf(Integer.toString(this.fn())) + " - ";
        }
        return String.valueOf(string) + this.getNome();
    }

    public int gy() {
        return this.fh;
    }

    public int gz() {
        return this.fi;
    }

    public int gA() {
        return this.fn;
    }

    public void ax(int n2) {
        this.fn = n2;
    }

    public s gB() {
        if (this.fo == null) {
            this.fo = new s();
        }
        return this.fo;
    }

    public void B(ArrayList arrayList) {
        this.eS = arrayList;
    }

    public void C(ArrayList arrayList) {
        this.eT = arrayList;
    }

    public void D(ArrayList arrayList) {
        this.eU = arrayList;
    }

    public void j(Boolean bl2) {
        this.el = bl2;
    }

    public void b(JProgressBar jProgressBar) {
        this.fk = jProgressBar;
    }

    public void ay(int n2) {
        if (this.gm().booleanValue() && this.getIdade() > 34) {
            this.j(false);
        }
        this.fp = n2;
    }

    public int gC() {
        return this.fp;
    }

    public int gD() {
        return this.ei;
    }

    public void az(int n2) {
        this.ei = n2;
    }

    public int gE() {
        return this.ep;
    }

    public void aA(int n2) {
        this.ep = n2;
    }

    public boolean gF() {
        boolean bl2 = false;
        if (this.fT() <= 0) {
            return true;
        }
        if (this.fT() <= 25 && aq.sE[this.fT()][0] != this.getPosicao()) {
            if (this.fT() == 10 || this.fT() == 17) {
                if (this.getPosicao() != 1 || this.getPosicao() == 3) {
                    bl2 = true;
                }
            } else {
                bl2 = true;
            }
        }
        return bl2;
    }

    public int gG() {
        return this.fq;
    }

    public void aB(int n2) {
        this.fq = n2;
    }

    public ArrayList gH() {
        return this.eS;
    }

    public int gI() {
        return this.ej;
    }

    public void aC(int n2) {
        this.ej = n2;
    }

    public int h(double d2) {
        int n2 = 0;
        int n3 = -1;
        int n4 = -1;
        double d3 = d2 * 0.4;
        double d4 = d2 * 0.3;
        if (this.en == 0) {
            n2 = 0;
        } else if (this.en == 1) {
            if (this.ex == 0) {
                n2 = 4;
                n3 = 5;
                n4 = 6;
            } else {
                n2 = 3;
                n3 = 6;
                n4 = 4;
            }
        } else if (this.en == 2) {
            n2 = 4;
            n3 = 3;
            n4 = 5;
        } else if (this.en == 3) {
            if (this.ex == 0) {
                n2 = 4;
                n3 = 5;
                n4 = 6;
            } else {
                n2 = 5;
                n3 = 6;
                n4 = 4;
            }
        } else if (this.en == 4) {
            n2 = 6;
            n3 = 5;
            n4 = 4;
        }
        this.c(d2, n2);
        if (n3 >= 0) {
            this.c(d3, n3);
        }
        if (n4 >= 0) {
            this.c(d4, n4);
        }
        return n2;
    }

    public void c(double d2, int n2) {
        if (n2 == 4 || n2 == 0) {
            d2 *= 1.2;
        }
        this.eH[n2] = this.eH[n2] + d2;
    }

    public void aD(int n2) {
        this.eH[n2] = this.eH[n2] - 1.0;
    }

    public double aE(int n2) {
        return this.eH[n2];
    }

    public int aF(int n2) {
        if (n2 == 0) {
            return this.gK();
        }
        if (n2 == 1) {
            return this.gJ();
        }
        if (n2 == 2) {
            return this.gL();
        }
        if (n2 == 3) {
            return this.gM();
        }
        if (n2 == 4) {
            return this.gN();
        }
        if (n2 == 5) {
            return this.gO();
        }
        return this.gP();
    }

    public void aG(int n2) {
        if (n2 == 0) {
            ++this.eA;
            if (this.eA > 100) {
                this.eA = 100;
            }
        } else if (n2 == 1) {
            ++this.eB;
            if (this.eB > 100) {
                this.eB = 100;
            }
        } else if (n2 == 2) {
            ++this.eC;
            if (this.eC > 100) {
                this.eC = 100;
            }
        } else if (n2 == 3) {
            ++this.eD;
            if (this.eD > 100) {
                this.eD = 100;
            }
        } else if (n2 == 4) {
            ++this.eE;
            if (this.eE > 100) {
                this.eE = 100;
            }
        } else if (n2 == 5) {
            ++this.eF;
            if (this.eF > 100) {
                this.eF = 100;
            }
        } else if (n2 == 6) {
            ++this.eG;
            if (this.eG > 100) {
                this.eG = 100;
            }
        }
    }

    public void aH(int n2) {
        if (n2 == 0) {
            --this.eA;
        } else if (n2 == 1) {
            --this.eB;
        } else if (n2 == 2) {
            --this.eC;
        } else if (n2 == 3) {
            --this.eD;
        } else if (n2 == 4) {
            --this.eE;
        } else if (n2 == 5) {
            --this.eF;
        } else if (n2 == 6) {
            --this.eG;
        }
    }

    public int gJ() {
        return this.eB;
    }

    public void aI(int n2) {
        this.eB = n2;
    }

    public int gK() {
        return this.eA;
    }

    public void aJ(int n2) {
        this.eA = n2;
    }

    public int gL() {
        return this.eC;
    }

    public void aK(int n2) {
        this.eC = n2;
    }

    public int gM() {
        return this.eD;
    }

    public void aL(int n2) {
        this.eD = n2;
    }

    public int gN() {
        return this.eE;
    }

    public void aM(int n2) {
        this.eE = n2;
    }

    public int gO() {
        return this.eF;
    }

    public void aN(int n2) {
        this.eF = n2;
    }

    public int gP() {
        return this.eG;
    }

    public void aO(int n2) {
        this.eG = n2;
    }

    public double F() {
        return this.ab;
    }

    public void c(double d2) {
        this.ab = d2;
    }

    public boolean gQ() {
        return this.fr;
    }

    public void r(boolean bl2) {
        this.fr = bl2;
    }
}

