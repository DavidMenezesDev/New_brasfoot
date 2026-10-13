/*
 * Decompiled with CFR 0.152.
 */
package best;

import best.A;
import best.E;
import best.F;
import best.L;
import best.T;
import best.Z;
import best.a;
import best.ah;
import best.aq;
import best.at;
import best.v;
import c.b;
import f.s;
import f.z;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class I
implements Serializable {
    private static final long serialVersionUID = 1L;
    private boolean v = false;
    private L fw;
    private at fx;
    private int fy;
    private ah fz;
    private ah fA;
    private int fB = 0;
    private int fC = 0;
    private v dH;
    private int[] fD = new int[4];
    private int fE = 0;
    private ArrayList fF = new ArrayList();
    private ArrayList fG = new ArrayList();
    private ArrayList fH = new ArrayList();
    private ArrayList fI = new ArrayList();
    private ArrayList fJ = new ArrayList();
    private ArrayList fK = new ArrayList();
    private ArrayList fL = new ArrayList();
    private ArrayList fM = new ArrayList();
    private ArrayList fN = new ArrayList();
    private int fO = 0;
    private int fP = 0;
    private int[] fQ;
    private int[] fR;
    private int fS;
    private int fT;
    private int fU;
    private ArrayList fV;
    private int[] fW;
    private int[] fX;
    private int[] fY;
    private int[] fZ;
    private int[] ga;
    private int[] gb;
    private int[] gc;
    private int[] gd;
    private boolean ge;
    private boolean gf;
    private int gg;
    private int gh;
    private int[] gi;
    private boolean gj;
    private ah gk;
    private int[][] gl;
    private int[][] gm;
    private int[][] gn;
    private int dq;
    private transient b go;
    private transient String gp;
    private transient String gq;
    private transient v gr;
    private static ArrayList gs = null;
    private static ArrayList gt = null;
    private static ArrayList gu = null;
    private static ArrayList gv = null;
    private static ArrayList gw = null;

    public I() {
        int[] nArray = new int[3];
        nArray[2] = -1;
        this.fQ = nArray;
        this.fR = new int[]{5, 5};
        this.fS = 0;
        this.fT = 0;
        this.fU = 0;
        this.fV = new ArrayList();
        this.fW = new int[]{50, 50};
        this.fX = new int[2];
        this.fY = new int[2];
        this.fZ = new int[2];
        this.ga = new int[2];
        this.gb = new int[2];
        this.gc = new int[2];
        this.gd = new int[2];
        this.ge = false;
        this.gf = false;
        this.gg = -1;
        this.gh = -1;
        this.gi = new int[]{-1, -1};
        this.gj = false;
        this.gk = null;
        this.gl = new int[2][11];
        this.gm = new int[][]{{-1, -1, -1, -1}, {-1, -1, -1, -1}};
        this.gn = new int[][]{{-1, -1, -1}, {-1, -1, -1}};
        this.dq = 0;
        this.go = null;
        this.gp = "";
        this.gq = null;
        this.gr = null;
    }

    public void clear() {
        this.fN.clear();
        this.fF.clear();
        this.fG.clear();
        this.fH.clear();
        this.fI.clear();
        this.fJ.clear();
        this.fK.clear();
        this.fL.clear();
        this.fM.clear();
    }

    public String ha() {
        String string = "<html>" + this.fW[0] + "% " + " <b>posse de bola</b> " + this.fW[1] + " %" + "<br>" + this.fY[0] + " <b>finaliza\u00e7\u00f5es</b> " + this.fY[1] + "<br>" + "<center>" + this.fZ[0] + " <b>no gol</b> " + this.fZ[1] + "</center>" + "<br>" + this.ga[0] + " <b>para fora</b> " + this.ga[1] + "<br>" + this.gb[0] + " <b>desarnes</b> " + this.gb[1] + "<br>" + this.gc[0] + " passes errados " + this.gc[1] + "<br>" + this.gd[0] + " faltas " + this.gd[1] + "</html>";
        string = "<html><body><table width=\"190\" border=\"0\"><tr><td colspan=\"2\">" + this.fW[0] + "% </td>" + "<td colspan=\"2\" align=\"center\"><strong>posse de bola</strong></td>" + "<td colspan=\"2\">" + this.fW[1] + "% </td>" + "</tr>" + "<tr>" + "<td colspan=\"2\">" + this.fY[0] + "</td>" + "<td colspan=\"2\" align=\"center\"><strong>finaliza\u00e7\u00f5es</strong></td>" + "<td colspan=\"2\">" + this.fY[1] + "</td>" + "</tr>" + "<tr>" + "<td colspan=\"2\">" + this.fZ[0] + "/" + this.ga[0] + "</td>" + "<td colspan=\"2\" align=\"center\"><strong>no gol/fora</strong></td>" + "<td colspan=\"2\">" + this.fZ[1] + "/" + this.ga[1] + "</td>" + "</tr>" + "<td colspan=\"2\">" + this.gb[0] + "</td>" + "<td colspan=\"2\" align=\"center\"><strong>desarmes</strong></td>" + "<td colspan=\"2\">" + this.gb[1] + "</td>" + "</tr>" + "</tr>" + "<td colspan=\"2\">" + this.gc[0] + "</td>" + "<td colspan=\"2\" align=\"center\"><strong>erros passes</strong></td>" + "<td  colspan=\"2\">" + this.gc[1] + "</td>" + "</tr>" + "</table>" + "</body>" + "</html>";
        return string;
    }

    public I(L l2, int n2, ah ah2, ah ah3, int n3, at at2, v v2) {
        int[] nArray = new int[3];
        nArray[2] = -1;
        this.fQ = nArray;
        this.fR = new int[]{5, 5};
        this.fS = 0;
        this.fT = 0;
        this.fU = 0;
        this.fV = new ArrayList();
        this.fW = new int[]{50, 50};
        this.fX = new int[2];
        this.fY = new int[2];
        this.fZ = new int[2];
        this.ga = new int[2];
        this.gb = new int[2];
        this.gc = new int[2];
        this.gd = new int[2];
        this.ge = false;
        this.gf = false;
        this.gg = -1;
        this.gh = -1;
        this.gi = new int[]{-1, -1};
        this.gj = false;
        this.gk = null;
        this.gl = new int[2][11];
        this.gm = new int[][]{{-1, -1, -1, -1}, {-1, -1, -1, -1}};
        this.gn = new int[][]{{-1, -1, -1}, {-1, -1, -1}};
        this.dq = 0;
        this.go = null;
        this.gp = "";
        this.gq = null;
        this.gr = null;
        this.fw = l2;
        this.fz = ah2;
        this.fA = ah3;
        this.fy = n3;
        this.fx = at2;
        this.dH = v2 == null ? this.fz.ev() : v2;
        if (this.dH != null) {
            this.dq = this.dH.dX();
        }
        if (l2 != null) {
            if (l2.b() == 9) {
                Z z2 = c.a.SR.s(this.fz.getPais());
                if (z2 != null) {
                    this.dH = z2.C(false);
                }
            } else if (!(l2.b() != 4 && l2.b() != 6 && l2.b() != 12 || at2.gg() != 0 && at2.gg() != 1 || !at2.cz(n2))) {
                this.dH = null;
                Z z3 = at2.mF();
                if (z3 != null) {
                    boolean bl2 = true;
                    if (l2.b() == 6) {
                        bl2 = false;
                    }
                    this.dH = z3.C(bl2);
                }
            }
        }
        ((a)c.a.SR.R().get(n3)).a(this);
        ((a)c.a.SR.R().get(n3)).a(l2);
        ((a)c.a.SR.R().get(n3)).a(at2);
        if (this.fx.b() == 5 || this.fx.b() == 15) {
            this.dH = null;
        }
        this.hb();
    }

    private void hb() {
        int n2;
        if (gs == null) {
            gs = new ArrayList();
            n2 = 19;
            while (n2 <= 38) {
                gs.add(n2);
                ++n2;
            }
        }
        Collections.shuffle(gs);
        if (gt == null) {
            gt = new ArrayList();
            n2 = 5;
            while (n2 <= 15) {
                gt.add(n2);
                ++n2;
            }
        }
        if (gu == null) {
            gu = new ArrayList();
            n2 = 16;
            while (n2 <= 35) {
                gu.add(n2);
                ++n2;
            }
        }
        if (gv == null) {
            gv = new ArrayList();
            n2 = 36;
            while (n2 <= 42) {
                gv.add(n2);
                ++n2;
            }
        }
        if (gw == null) {
            gw = new ArrayList();
            n2 = 43;
            while (n2 <= 47) {
                gw.add(n2);
                ++n2;
            }
        }
        Random random = new Random();
        int n3 = random.nextInt(100);
        this.gn[0][0] = (Integer)gs.get(0);
        this.gn[0][1] = (Integer)gs.get(1);
        this.gn[1][0] = (Integer)gs.get(2);
        this.gn[1][1] = (Integer)gs.get(3);
        if (random.nextInt(100) > 30) {
            this.gn[0][2] = (Integer)gs.get(4);
        }
        if (random.nextInt(100) > 30) {
            this.gn[1][2] = (Integer)gs.get(5);
        }
        if (n3 > 90) {
            this.F(gt);
        } else if (n3 > 50) {
            this.F(gu);
        } else {
            this.F(gv);
        }
        Collections.shuffle(gw);
        if (random.nextInt(100) > 20) {
            this.gm[0][2] = (Integer)gw.get(0);
        }
        if (random.nextInt(100) > 50) {
            this.gm[0][3] = (Integer)gw.get(1);
        }
        if (random.nextInt(100) > 20) {
            this.gm[1][2] = (Integer)gw.get(2);
        }
        if (random.nextInt(100) > 50) {
            this.gm[1][3] = (Integer)gw.get(3);
        }
    }

    private void F(ArrayList arrayList) {
        Collections.shuffle(arrayList);
        this.gm[0][0] = (Integer)arrayList.get(0);
        this.gm[0][1] = (Integer)arrayList.get(1);
        this.gm[1][0] = (Integer)arrayList.get(2);
        this.gm[1][1] = (Integer)arrayList.get(3);
    }

    public I(ah ah2, ah ah3, boolean bl2) {
        int[] nArray = new int[3];
        nArray[2] = -1;
        this.fQ = nArray;
        this.fR = new int[]{5, 5};
        this.fS = 0;
        this.fT = 0;
        this.fU = 0;
        this.fV = new ArrayList();
        this.fW = new int[]{50, 50};
        this.fX = new int[2];
        this.fY = new int[2];
        this.fZ = new int[2];
        this.ga = new int[2];
        this.gb = new int[2];
        this.gc = new int[2];
        this.gd = new int[2];
        this.ge = false;
        this.gf = false;
        this.gg = -1;
        this.gh = -1;
        this.gi = new int[]{-1, -1};
        this.gj = false;
        this.gk = null;
        this.gl = new int[2][11];
        this.gm = new int[][]{{-1, -1, -1, -1}, {-1, -1, -1, -1}};
        this.gn = new int[][]{{-1, -1, -1}, {-1, -1, -1}};
        this.dq = 0;
        this.go = null;
        this.gp = "";
        this.gq = null;
        this.gr = null;
        this.fz = ah2;
        this.fA = ah3;
    }

    public ah hc() {
        return this.fz;
    }

    public void s(ah ah2) {
        this.fz = ah2;
    }

    public ah hd() {
        return this.fA;
    }

    public void t(ah ah2) {
        this.fA = ah2;
    }

    public static void he() {
        ArrayList arrayList = new ArrayList();
        arrayList = ((a)c.a.SR.R().get(c.a.SR.J())).h();
        at at2 = null;
        int n2 = 0;
        int n3 = 0;
        while (n3 < arrayList.size()) {
            ((I)arrayList.get(n3)).o(((I)arrayList.get(n3)).hG());
            if (((I)arrayList.get(n3)).hy() != null) {
                if (((I)arrayList.get(n3)).hy().b() == 15) {
                    ((I)arrayList.get(n3)).a(((I)arrayList.get(n3)).hy(), n2, true, c.a.SR.yn().Bt());
                }
                boolean bl2 = false;
                if (((I)arrayList.get(n3)).hy().b() == 14 && ((I)arrayList.get(n3)).ht() == c.a.SR.sq().BF()) {
                    bl2 = true;
                }
                if (((I)arrayList.get(n3)).hy().b() == 7 || ((I)arrayList.get(n3)).hy().b() == 13 || bl2) {
                    if (at2 != ((I)arrayList.get(n3)).hy()) {
                        n2 = 0;
                    }
                    at2 = ((I)arrayList.get(n3)).hy();
                    ((I)arrayList.get(n3)).a(((I)arrayList.get(n3)).hy(), n2, false, "");
                    ++n2;
                }
                if (((I)arrayList.get(n3)).hy().b() == 9 && ((I)arrayList.get(n3)).ht() != null && ((I)arrayList.get(n3)).ht() instanceof s && ((s)((I)arrayList.get(n3)).ht()).ze() == 7701) {
                    Z z2 = c.a.SR.aY().eY(2);
                    String string = "";
                    if (z2 != null) {
                        string = z2.jf();
                    }
                    ((I)arrayList.get(n3)).a(((I)arrayList.get(n3)).hy(), n2, true, string);
                }
            }
            ((I)arrayList.get(n3)).V();
            ++n3;
        }
    }

    public void hf() {
        int n2 = this.fx.b();
        if (n2 != 7 && n2 != 5 && this.hc().jZ().booleanValue()) {
            this.hc().v(this.fE, 5);
        }
    }

    public void hg() {
        int n2 = -1;
        if (this.fx != null) {
            n2 = this.fx.b();
        }
        T t2 = null;
        int n3 = 0;
        while (n3 < c.a.SR.bd().size()) {
            if (((T)c.a.SR.bd().get(n3)).a(this.fz, this.fA)) {
                t2 = (T)c.a.SR.bd().get(n3);
            }
            ++n3;
        }
        if (t2 != null) {
            t2.a(this.fz, this.fA, this.fB, this.fC, n2);
        } else {
            new T(this.fz.lk(), this.fA.lk(), this.fB, this.fC, n2);
        }
        this.fz.e(this);
        this.fA.e(this);
        if (this.fz.ka() != null) {
            this.fz.ka().e(this);
            if (this.fx != null && (this.fx.b() == 1 || this.fx.b() == 3 || this.fx.b() == 2 || this.fx.b() == 4 || this.fx.b() == 5 || this.fx.b() == 6 || this.fx.b() == 8 || this.fx.b() == 10)) {
                this.fz.ka().a(this, false, -1);
            }
        }
        if (this.fA.ka() != null) {
            this.fA.ka().e(this);
            if (this.fx != null && (this.fx.b() == 1 || this.fx.b() == 3 || this.fx.b() == 2 || this.fx.b() == 4 || this.fx.b() == 5 || this.fx.b() == 6 || this.fx.b() == 8 || this.fx.b() == 10)) {
                this.fA.ka().a(this, false, -1);
            }
        }
    }

    public void hh() {
        int n2 = 0;
        while (n2 < this.fF.size()) {
            ((F)this.fF.get(n2)).b(this.fx, this.hc());
            ((F)this.fF.get(n2)).a(this.fx, this, 0, 1, this.hc());
            if (n2 < this.gl[0].length) {
                this.gl[0][n2] = ((F)this.fF.get(n2)).fT();
            }
            ++n2;
        }
        n2 = 0;
        while (n2 < this.fG.size()) {
            ((F)this.fG.get(n2)).b(this.fx, this.hd());
            ((F)this.fG.get(n2)).a(this.fx, this, 1, 0, this.hd());
            if (n2 < this.gl[1].length) {
                this.gl[1][n2] = ((F)this.fG.get(n2)).fT();
            }
            ++n2;
        }
        n2 = 0;
        while (n2 < this.fL.size()) {
            ((F)this.fL.get(n2)).b(this.fx, this.hc());
            ((F)this.fL.get(n2)).a(this.fx, this, 0, 1, this.hc());
            ++n2;
        }
        n2 = 0;
        while (n2 < this.fM.size()) {
            ((F)this.fM.get(n2)).b(this.fx, this.hd());
            ((F)this.fM.get(n2)).a(this.fx, this, 1, 0, this.hd());
            ++n2;
        }
        n2 = 0;
        while (n2 < this.fN.size()) {
            if (((A)this.fN.get(n2)).eo() != null) {
                if (((A)this.fN.get(n2)).b() == 1 && ((A)this.fN.get(n2)).el() != 2) {
                    ((A)this.fN.get(n2)).eo().a(this.fx, ((A)this.fN.get(n2)).cu());
                } else if (((A)this.fN.get(n2)).b() == 2 || ((A)this.fN.get(n2)).b() == 3 || ((A)this.fN.get(n2)).b() == 4) {
                    ((A)this.fN.get(n2)).eo().a(((A)this.fN.get(n2)).b(), this.fx, ((A)this.fN.get(n2)).cu());
                }
            }
            ++n2;
        }
    }

    public void hi() {
        at at2 = this.fx;
        int n2 = 0;
        while (n2 < this.fz.kc().size()) {
            ((F)this.fz.kc().get(n2)).aw(0);
            if (((F)this.fz.kc().get(n2)).c(at2)) {
                ((F)this.fz.kc().get(n2)).f(at2);
            }
            ++n2;
        }
        n2 = 0;
        while (n2 < this.fA.kc().size()) {
            ((F)this.fA.kc().get(n2)).aw(0);
            if (((F)this.fA.kc().get(n2)).c(at2)) {
                ((F)this.fA.kc().get(n2)).f(at2);
            }
            ++n2;
        }
    }

    public static void a(int n2, I i2, F f2, int n3, int n4) {
        ah ah2 = i2.hc();
        if (n2 == 1) {
            ah2 = i2.hd();
        }
        I.a(4, -1, i2, ah2, f2, null, n3, n4);
    }

    public static void b(int n2, I i2, F f2, int n3, int n4) {
        f2.gj();
        ah ah2 = i2.hc();
        if (n2 == 1) {
            ah2 = i2.hd();
        }
        if (f2.gi() == 2) {
            I.a(3, -1, i2, ah2, f2, null, n3, n4);
        } else {
            I.a(2, -1, i2, ah2, f2, null, n3, n4);
        }
    }

    public void k(int n2, int n3) {
        int n4 = 1;
        while (n4 <= n3) {
            I.a(this, n2, n4);
            ++n4;
        }
    }

    public static void a(I i2, int n2, int n3) {
        ArrayList arrayList;
        int n4 = 30;
        int n5 = 700;
        int n6 = 1000;
        F f2 = null;
        int[] nArray = new int[]{70, 40, 30};
        int[] nArray2 = new int[]{45, 40, 30};
        int[] nArray3 = new int[]{1200, 900, 800};
        int[] nArray4 = new int[]{800, 700, 550};
        int[] nArray5 = new int[]{1500, 1000, 800};
        int[] nArray6 = new int[]{800, 600, 600};
        int n7 = 0;
        int n8 = new Random().nextInt(100);
        int n9 = 0;
        int n10 = 0;
        if (n8 > 55) {
            arrayList = i2.fJ;
            n9 = i2.hc().kj()[2];
        } else {
            arrayList = i2.fK;
            n9 = i2.hd().kj()[2];
            n10 = 1;
        }
        int[] nArray7 = new int[3];
        nArray7[0] = 30;
        nArray7[1] = 10;
        int[] nArray8 = nArray7;
        if (n9 >= nArray8.length) {
            n9 = 0;
        }
        n7 = n3 < 15 ? 0 : (n3 < 30 ? 1 : 2);
        if (n3 % 7 == 0) {
            i2.l(n2, n3);
        }
        if (n2 == 1) {
            n4 = nArray[n7] + nArray8[n9];
            n5 = nArray3[n7];
            n6 = nArray5[n7];
        } else {
            n4 = nArray2[n7] + nArray8[n9];
            n5 = nArray4[n7];
            n6 = nArray6[n7];
        }
        if (i2.fS > 5) {
            n4 *= 2;
        } else if (i2.fS > 10) {
            n4 = 1000;
        }
        if (i2.fT >= 2) {
            n4 = n5 * 2;
        }
        if (i2.fU >= 1) {
            n4 = n6 * 5;
        }
        if (new Random().nextInt(n4) == 1) {
            f2 = I.H(arrayList);
            ++i2.fS;
            if (f2 != null) {
                I.b(n10, i2, f2, n2, n3);
            }
        } else if (new Random().nextInt(n5) == 1) {
            f2 = I.J(arrayList);
            if (f2 != null) {
                I.a(n10, i2, f2, n2, n3);
            }
            ++i2.fT;
        } else if (new Random().nextInt(n6) == 1) {
            ++i2.fU;
            ah ah2 = i2.hc();
            if (n10 == 1) {
                ah2 = i2.hd();
            }
            if ((f2 = I.I(arrayList)) != null) {
                I.a(5, -1, i2, ah2, f2, null, n2, n3);
            }
        } else if (n2 == 2 && n3 >= 5) {
            i2.m(n2, n3);
        }
    }

    public int a(F f2, int n2, int n3) {
        int n4 = 1;
        int n5 = new Random().nextInt(1000);
        if (n2 == 1) {
            n4 = n5 < 900 ? 1 : (n5 < 950 ? 3 : (n5 < 980 ? 4 : (n5 < 990 ? 2 : (n5 < 995 ? 5 : 1))));
        } else if (n2 == 2) {
            n4 = n5 < 800 ? 1 : (n5 < 850 ? 3 : (n5 < 980 ? 4 : (n5 < 990 ? 2 : (n5 < 995 ? 5 : 1))));
        }
        if (n4 == 5 && (f2.getPosicao() == 0 || f2.getPosicao() == 2)) {
            n4 = 1;
        }
        if (n4 == 3) {
            ArrayList arrayList = null;
            int n6 = 0;
            if (f2.fg() == this.fz) {
                arrayList = this.fK;
                n6 = 1;
            } else if (f2.fg() == this.fA) {
                arrayList = this.fJ;
                n6 = 0;
            }
            if (arrayList != null) {
                F f3;
                n5 = new Random().nextInt(100);
                if (n5 < 50) {
                    F f4 = I.H(arrayList);
                    if (f4 != null) {
                        I.b(n6, this, f4, n2, n3);
                    }
                } else if (n5 < 60 && (f3 = I.J(arrayList)) != null) {
                    I.a(n6, this, f3, n2, n3);
                }
            }
        }
        return n4;
    }

    public static E a(I i2, int n2, int n3, int n4) {
        int n5 = 0;
        while (n5 < i2.fV.size()) {
            if (((E)i2.fV.get(n5)).fc() == n2 && ((E)i2.fV.get(n5)).eZ() == n4 && ((E)i2.fV.get(n5)).en() == n3) {
                return (E)i2.fV.get(n5);
            }
            ++n5;
        }
        return null;
    }

    public static A a(int n2, int n3, I i2, ah ah2, F f2, F f3, int n4, int n5) {
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        int n6 = 0;
        if (ah2 == i2.fz) {
            arrayList = i2.hp();
            arrayList2 = i2.hq();
            n6 = 0;
        } else if (ah2 == i2.fA) {
            arrayList = i2.hq();
            arrayList2 = i2.hp();
            n6 = 1;
        }
        A a2 = new A(n6);
        a2.a(n2);
        a2.f(f2);
        if (n3 == 2) {
            F f4 = I.G(arrayList2);
            if (f4 != null) {
                a2.f(f4);
                a2.R(2);
            } else {
                a2.R(1);
            }
        } else {
            a2.R(n3);
        }
        if (f3 != null) {
            a2.g(f3);
        }
        a2.S(n5);
        a2.T(n4);
        a2.k(ah2);
        i2.fN.add(a2);
        if (n2 == 2) {
            f2.gB().tG();
        } else if (n2 == 4) {
            f2.gB().tH();
        } else if (n2 == 3) {
            f2.gB().tG();
            f2.gB().tH();
        }
        if (n2 == 3 || n2 == 4) {
            if (arrayList != null) {
                arrayList.remove(f2);
                if (f2.fT() <= 13 && !ah2.jZ().booleanValue() && i2.fR[n6] > 0) {
                    I.a(n6, true, i2, f2, n4, n5, false);
                }
            }
        } else if (n2 == 5) {
            if (f2 != null) {
                f2.p(ah2);
            }
            if (arrayList != null && !ah2.jZ().booleanValue()) {
                arrayList.remove(f2);
            }
            if (i2 != null && ah2 != null && i2.fR[n6] > 0 && !ah2.jZ().booleanValue()) {
                I.a(n6, false, i2, f2, n4, n5, true);
            }
        }
        return a2;
    }

    public static void a(int n2, boolean bl2, I i2, F f2, int n3, int n4, boolean bl3) {
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        F f3 = null;
        if (n2 == 0) {
            arrayList = i2.hn();
            arrayList2 = i2.fJ;
        } else if (n2 == 1) {
            arrayList = i2.ho();
            arrayList2 = i2.fK;
        }
        if (bl2) {
            f3 = I.a(arrayList2, 18, 25);
            if (f3 == null) {
                f3 = I.a(arrayList2, 14, 17);
            }
            if (f3 == null && f2.fT() == 1) {
                f3 = I.a(arrayList2, 2, 25);
            }
        } else {
            f3 = f2;
        }
        if (arrayList != null && f3 != null) {
            F f4 = null;
            if (f2.fT() >= 0) {
                boolean bl4 = true;
                if (f2.getPosicao() == 0) {
                    bl4 = false;
                }
                f4 = ah.a(arrayList, f2.fT(), false, bl4);
            }
            if (f4 != null) {
                if (bl3) {
                    if (f3.getPosicao() == 0 || f4.getPosicao() != 0) {
                        i2.a(n2, f3, f4, n3, n4, f2.fT());
                    }
                } else {
                    i2.a(n2, f3, f4, n3, n4, f2.fT());
                }
            }
        }
    }

    public A a(int n2, F f2, F f3, int n3, int n4, int n5) {
        A a2 = null;
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        ArrayList arrayList3 = null;
        if (f2 != null && f3 != null) {
            ah ah2 = this.hc();
            if (n2 == 0) {
                arrayList = this.hp();
                arrayList2 = this.hn();
                arrayList3 = this.fL;
                this.aS(0);
            } else if (n2 == 1) {
                arrayList = this.hq();
                arrayList2 = this.ho();
                this.aS(1);
                arrayList3 = this.fM;
                ah2 = this.hd();
            }
            if (arrayList != null && arrayList2 != null) {
                f3.as(f2.fT());
                if (n5 > 0) {
                    f3.as(n5);
                }
                arrayList.remove(f2);
                arrayList.add(f3);
                arrayList3.add(f3);
                f3.b(true);
                arrayList2.remove(f3);
            }
            a2 = I.a(6, -1, this, ah2, f2, f3, n3, n4);
        }
        return a2;
    }

    public void l(int n2, int n3) {
        int n4 = 0;
        while (n4 < this.fJ.size()) {
            if (((F)this.fJ.get(n4)).fT() != 1) {
                ((F)this.fJ.get(n4)).fq();
            } else if (n2 == 2) {
                ((F)this.fJ.get(n4)).fq();
            }
            ++n4;
        }
        n4 = 0;
        while (n4 < this.fK.size()) {
            if (((F)this.fK.get(n4)).fT() != 1) {
                ((F)this.fK.get(n4)).fq();
            } else if (n2 == 2) {
                ((F)this.fK.get(n4)).fq();
            }
            ++n4;
        }
    }

    public void m(int n2, int n3) {
        boolean bl2 = false;
        if (n2 == 2) {
            if (!this.fz.jZ().booleanValue() && this.fR[0] > 0) {
                if (n3 == 0 && this.n(1, 1)) {
                    if (new Random().nextInt(100) > 50) {
                        bl2 = this.a(2, 0, n2, n3, this.hp());
                    }
                } else if (n3 == this.gn[0][0] || n3 == this.gn[0][1] || n3 == this.gn[0][2]) {
                    if (this.n(1, 1) || this.hj()) {
                        bl2 = this.a(2, 0, n2, n3, this.hp());
                    }
                } else if (n3 == this.gm[0][0] || n3 == this.gm[0][1] || n3 == this.gm[0][2] || n3 == this.gm[0][3]) {
                    bl2 = this.a(1, 0, n2, n3, this.hp());
                }
            }
            if (!bl2 && !this.fA.jZ().booleanValue() && this.fR[1] > 0) {
                if (n3 == 0 && this.n(2, 2)) {
                    if (new Random().nextInt(100) > 50) {
                        this.a(2, 1, n2, n3, this.hq());
                    }
                } else if (n3 == this.gn[1][0] || n3 == this.gn[1][1] || n3 == this.gn[1][2]) {
                    if (this.n(2, 1)) {
                        this.a(2, 1, n2, n3, this.hq());
                    }
                } else if (n3 == this.gm[1][0] || n3 == this.gm[1][1] || n3 == this.gm[1][2] || n3 == this.gm[1][3]) {
                    this.a(1, 1, n2, n3, this.hq());
                }
            }
        }
    }

    public boolean a(int n2, int n3, int n4, int n5, ArrayList arrayList) {
        if (n2 == 1) {
            int n6 = 60;
            int n7 = 0;
            if (n5 > 40) {
                n6 = 90;
                if (arrayList.size() > 0) {
                    n7 = new Random().nextInt(arrayList.size());
                }
            }
            int n8 = n7;
            while (n8 < arrayList.size()) {
                if (((F)arrayList.get(n8)).fT() != 1 && ((F)arrayList.get(n8)).fp() < n6) {
                    I.a(n3, false, this, (F)arrayList.get(n8), n4, n5, false);
                    return true;
                }
                ++n8;
            }
        } else if (n2 == 2) {
            Random random = new Random();
            int n9 = 0;
            if (arrayList.size() > 0) {
                n9 = random.nextInt(arrayList.size());
                ArrayList arrayList2 = this.fL;
                if (n3 == 2) {
                    arrayList2 = this.fM;
                }
                if (arrayList2.contains(arrayList.get(n9))) {
                    n9 = random.nextInt(arrayList.size());
                }
                if (((F)arrayList.get(n9)).fT() != 1 && !arrayList2.contains(arrayList.get(n9))) {
                    I.a(n3, false, this, (F)arrayList.get(n9), n4, n5, false);
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hj() {
        return this.fB == this.fC;
    }

    private boolean n(int n2, int n3) {
        return n2 == 1 ? this.fC - this.fB >= n3 : this.fB - this.fC >= n3;
    }

    public void o(int n2, int n3) {
        int n4 = new Random().nextInt(100) + 1;
        int n5 = 50;
        n5 = n3 < 10 ? 95 : (n3 < 30 ? 80 : (n3 < 40 ? 60 : 40));
        boolean bl2 = false;
        if (n4 > n5) {
            int n6;
            if (!this.fz.jZ().booleanValue() && this.fR[0] > 0) {
                n6 = 0;
                while (n6 < this.fJ.size()) {
                    if (((F)this.fJ.get(n6)).fT() != 1) {
                        if (((F)this.fJ.get(n6)).fp() < 75) {
                            I.a(0, false, this, (F)this.fJ.get(n6), n2, n3, false);
                            bl2 = true;
                            break;
                        }
                    } else if (n2 == 2 && ((F)this.fJ.get(n6)).fp() < 40) {
                        I.a(0, false, this, (F)this.fJ.get(n6), n2, n3, false);
                        bl2 = true;
                        break;
                    }
                    ++n6;
                }
            }
            if (!bl2 && !this.fA.jZ().booleanValue() && this.fR[1] > 0) {
                n6 = 0;
                while (n6 < this.fK.size()) {
                    if (((F)this.fK.get(n6)).fT() != 1) {
                        if (((F)this.fK.get(n6)).fp() < 75) {
                            I.a(1, false, this, (F)this.fK.get(n6), n2, n3, false);
                            break;
                        }
                    } else if (n2 == 2 && ((F)this.fK.get(n6)).fp() < 40) {
                        I.a(1, false, this, (F)this.fK.get(n6), n2, n3, false);
                        break;
                    }
                    ++n6;
                }
            }
        }
    }

    public static F G(ArrayList arrayList) {
        int n2 = new Random().nextInt(1000);
        F f2 = null;
        int n3 = 0;
        n3 = n2 == 0 ? 6 : (n2 < 150 ? 0 : (n2 < 350 ? 1 : (n2 < 400 ? 2 : (n2 < 450 ? 3 : (n2 < 500 ? 4 : 5)))));
        f2 = I.a(arrayList, aq.sS[n3][0], aq.sS[n3][1]);
        return f2;
    }

    public static F H(ArrayList arrayList) {
        int n2 = new Random().nextInt(100);
        F f2 = null;
        int n3 = 0;
        n3 = n2 < 25 ? 0 : (n2 < 40 ? 1 : (n2 < 65 ? 2 : (n2 < 73 ? 3 : (n2 < 82 ? 4 : (n2 < 85 ? 6 : 5)))));
        f2 = I.a(arrayList, aq.sS[n3][0], aq.sS[n3][1]);
        return f2;
    }

    public static F I(ArrayList arrayList) {
        int n2 = new Random().nextInt(500);
        F f2 = null;
        int n3 = 0;
        n3 = n2 == 0 ? 6 : (n2 < 150 ? 0 : (n2 < 250 ? 1 : (n2 < 320 ? 2 : (n2 < 360 ? 3 : (n2 < 420 ? 4 : 5)))));
        f2 = I.a(arrayList, aq.sS[n3][0], aq.sS[n3][1]);
        return f2;
    }

    public static F a(ArrayList arrayList, int n2, int n3) {
        ArrayList<F> arrayList2 = new ArrayList<F>();
        int n4 = 0;
        while (n4 < arrayList.size()) {
            if (((F)arrayList.get(n4)).fT() >= n2 && ((F)arrayList.get(n4)).fT() <= n3) {
                arrayList2.add((F)arrayList.get(n4));
            }
            ++n4;
        }
        Collections.shuffle(arrayList2);
        if (arrayList2.size() > 0) {
            return (F)arrayList2.get(0);
        }
        return null;
    }

    public static F J(ArrayList arrayList) {
        int n2 = new Random().nextInt(200);
        F f2 = null;
        int n3 = 0;
        n3 = n2 == 0 ? 6 : (n2 < 80 ? 0 : (n2 < 110 ? 1 : (n2 < 160 ? 2 : (n2 < 170 ? 3 : (n2 < 190 ? 4 : 5)))));
        f2 = I.a(arrayList, aq.sS[n3][0], aq.sS[n3][1]);
        return f2;
    }

    public static ArrayList p(int n2, int n3) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
        int n4 = 1;
        while (n4 <= n2) {
            arrayList2.add(n4);
            ++n4;
        }
        Collections.shuffle(arrayList2);
        n4 = 0;
        while (n4 <= n3 - 1) {
            arrayList.add((Integer)arrayList2.get(n4));
            ++n4;
        }
        return arrayList;
    }

    public void q(int n2, int n3) {
        b b2 = null;
        if (this.go == null) {
            b2 = new b(this);
            this.a(b2);
        } else {
            b2 = this.go;
        }
        I.a(this, n3, n2);
        A a2 = null;
        a2 = b2.vO();
        if (a2 != null) {
            a2.S(n2);
            a2.T(n3);
            this.hE().add(a2);
            if (a2.b() == 1 && a2.ep() != null) {
                A a3 = new A(a2.et());
                a3.S(n2);
                a3.f(a2.ep());
                a3.a(8);
                a3.T(n3);
                this.hE().add(a3);
            }
        }
    }

    public void a(at at2, int n2, boolean bl2, String string) {
        if (!bl2) {
            this.p(at2.cx(n2));
            int n3 = at2.cy(n2);
            this.b(new v(true, this.ik(), n3));
        } else {
            this.dH = null;
            this.gr = null;
            this.p(string);
        }
    }

    public void V() {
        b b2 = new b(this);
        this.a(b2);
        int[] nArray = new int[]{-1, -1};
        if (this.ht() instanceof z) {
            if (((z)this.ht()).zu()) {
                if (((z)this.ht()).zr() == 2) {
                    nArray = ((z)this.ht()).o(this);
                    this.aU(nArray[1]);
                    this.aV(nArray[0]);
                    this.gj = true;
                    this.ge = true;
                }
            } else {
                this.ge = true;
            }
            if (this.ge) {
                this.gf = !((z)this.ht()).zA();
            }
        }
        if (this.ev() != null) {
            this.ev().b(this);
        } else if (this.il() != null) {
            this.il().b(this);
        }
        if (!this.hc().jZ().booleanValue() && !this.hd().jZ().booleanValue()) {
            A a2;
            A a3;
            this.fQ[0] = new Random().nextInt(3);
            this.fQ[1] = new Random().nextInt(5) + 1;
            int n2 = 0;
            while (n2 < 45 + this.fQ[0]) {
                I.a(this, 1, n2);
                a3 = null;
                a3 = b2.vO();
                if (a3 != null) {
                    a3.S(n2);
                    a3.T(1);
                    this.hE().add(a3);
                    if (a3.b() == 1 && a3.ep() != null) {
                        a2 = new A(a3.et());
                        a2.S(n2);
                        a2.f(a3.ep());
                        a2.a(8);
                        a2.T(1);
                        this.hE().add(a2);
                    }
                }
                ++n2;
            }
            this.m(2, 0);
            n2 = 0;
            while (n2 < 45 + this.fQ[1]) {
                I.a(this, 2, n2);
                a3 = null;
                a3 = b2.vO();
                if (a3 != null) {
                    a3.S(n2);
                    a3.T(2);
                    this.hE().add(a3);
                    if (a3.b() == 1 && a3.ep() != null) {
                        a2 = new A(a3.et());
                        a2.S(n2);
                        a2.f(a3.ep());
                        a2.T(2);
                        a2.a(8);
                        this.hE().add(a2);
                    }
                }
                ++n2;
            }
            if (this.ge && this.gf && this.hk()) {
                int n3;
                n2 = new Random().nextInt(7) + 2;
                if (n2 >= (n3 = new Random().nextInt(7) + 2)) {
                    this.gk = this.hc();
                    this.gi[0] = n2;
                    this.gi[1] = n2 - 1;
                } else {
                    this.gk = this.hd();
                    this.gi[0] = n2;
                    this.gi[1] = n2 + 1;
                }
            }
        }
        this.hc().I(false);
        this.hd().I(false);
    }

    public boolean hk() {
        boolean bl2 = ((z)this.ht()).zv();
        int n2 = ((z)this.ht()).BI();
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        int n8 = 0;
        int n9 = 0;
        int n10 = 0;
        int n11 = 0;
        n3 = this.hu();
        n4 = this.hw();
        n10 = n3;
        n11 = n4;
        if (n3 > n4) {
            ++n7;
        } else if (n4 > n3) {
            ++n8;
        }
        if (this.gj) {
            n6 = this.hK();
            n5 = this.hL();
            if (n5 > n6) {
                ++n7;
            } else if (n6 > n5) {
                ++n8;
            }
            n10 += n5;
            n11 += n6;
        }
        if (n7 > n8) {
            n9 = 1;
        } else if (n8 > n7) {
            n9 = 2;
        }
        if (n9 == 0) {
            if (n10 > n11) {
                n9 = 1;
            } else if (n11 > n10) {
                n9 = 2;
            }
        }
        if (n9 == 0 && this.gj && bl2) {
            if (n5 > n4) {
                n9 = 1;
            } else if (n4 > n5) {
                n9 = 2;
            }
        }
        if (n9 == 0 && n2 == 2129) {
            return false;
        }
        return n9 == 0;
    }

    public ArrayList hl() {
        return this.fF;
    }

    public ArrayList hm() {
        return this.fG;
    }

    public ArrayList hn() {
        return this.fH;
    }

    public ArrayList ho() {
        return this.fI;
    }

    public ArrayList hp() {
        return this.fJ;
    }

    public ArrayList hq() {
        return this.fK;
    }

    public int hr() {
        return this.fO;
    }

    public void aP(int n2) {
        this.fO = n2;
    }

    public int hs() {
        return this.fP;
    }

    public void aQ(int n2) {
        this.fP = n2;
    }

    public L ht() {
        return this.fw;
    }

    public int hu() {
        return this.fB;
    }

    public void hv() {
        ++this.fB;
    }

    public int hw() {
        return this.fC;
    }

    public void hx() {
        ++this.fC;
    }

    public int aR(int n2) {
        return this.fR[n2];
    }

    public void aS(int n2) {
        int n3 = n2;
        this.fR[n3] = this.fR[n3] - 1;
    }

    public at hy() {
        return this.fx;
    }

    public int[] hz() {
        return this.fW;
    }

    public void d(int[] nArray) {
        this.fW = nArray;
    }

    public int[] hA() {
        return this.fY;
    }

    public void e(int[] nArray) {
        this.fY = nArray;
    }

    public int[] hB() {
        return this.gb;
    }

    public void f(int[] nArray) {
        this.gb = nArray;
    }

    public int[] hC() {
        return this.gc;
    }

    public void g(int[] nArray) {
        this.gc = nArray;
    }

    public int[] hD() {
        return this.gd;
    }

    public void h(int[] nArray) {
        this.gd = nArray;
    }

    public ArrayList hE() {
        return this.fN;
    }

    public v ev() {
        return this.dH;
    }

    public F aT(int n2) {
        block5: {
            block4: {
                if (n2 != 1) break block4;
                int n3 = 0;
                while (n3 < this.fJ.size()) {
                    if (((F)this.fJ.get(n3)).fT() == 1) {
                        return (F)this.fJ.get(n3);
                    }
                    ++n3;
                }
                break block5;
            }
            if (n2 != 2) break block5;
            int n4 = 0;
            while (n4 < this.fK.size()) {
                if (((F)this.fK.get(n4)).fT() == 1) {
                    return (F)this.fK.get(n4);
                }
                ++n4;
            }
        }
        return null;
    }

    public void hF() {
        this.fB = 0;
        this.fC = 0;
        int n2 = 0;
        while (n2 < this.fN.size()) {
            if (((A)this.fN.get(n2)).b() == 1) {
                if (((A)this.fN.get(n2)).cu() == this.fz) {
                    ++this.fB;
                } else if (((A)this.fN.get(n2)).cu() == this.fA) {
                    ++this.fC;
                }
            }
            ++n2;
        }
    }

    public String hG() {
        String string = "";
        if (this.fx != null) {
            string = this.fx.is();
        }
        if (this.fw != null) {
            string = String.valueOf(string) + " - " + this.fw.io();
        }
        if (this.fx != null && this.fx.b() == 9 && this.fw != null && this.fw instanceof s && ((s)this.fw).ze() == 7701) {
            string = "Torneio Repescagem";
        }
        if (this.fx != null && this.fx.b() == 1 && this.fw != null && this.fw instanceof z) {
            if (((z)this.fw).zf() == 1099) {
                string = "Mata-Mata Ascenso - " + string;
            } else if (((z)this.fw).zf() == 1098) {
                string = "Playoff Rebaixamento - " + string;
            }
        }
        return string;
    }

    public String hH() {
        String string = "";
        if (this.fx != null) {
            string = this.fx.getNome();
        }
        String string2 = "";
        if (this.fw != null) {
            string2 = " - " + this.fw.io();
        }
        return String.valueOf(string) + string2;
    }

    public String hI() {
        String string = "";
        String string2 = "";
        if (this.fx != null) {
            string = this.fx.getNome();
        }
        if (this.fw != null) {
            string2 = " - " + this.fw.io();
        }
        return String.valueOf(string) + string2;
    }

    public String[] hJ() {
        String[] stringArray = new String[]{"", ""};
        if (this.fw != null) {
            stringArray[1] = this.fw.io();
        }
        if (this.fx != null) {
            stringArray[0] = this.fx.is();
        }
        return stringArray;
    }

    public int hK() {
        return this.gg;
    }

    public void aU(int n2) {
        this.gg = n2;
    }

    public int hL() {
        return this.gh;
    }

    public void aV(int n2) {
        this.gh = n2;
    }

    public int hM() {
        return this.fy;
    }

    public int hN() {
        return this.fE;
    }

    public boolean hO() {
        return this.gj;
    }

    public void s(boolean bl2) {
        this.gj = bl2;
    }

    public boolean hP() {
        return this.gf;
    }

    public int[] hQ() {
        return this.gi;
    }

    public ah hR() {
        return this.gk;
    }

    public boolean hS() {
        return this.ge;
    }

    public void u(ah ah2) {
        this.gk = ah2;
    }

    public void i(int[] nArray) {
        this.gi = nArray;
    }

    public void aW(int n2) {
        this.fE = n2;
    }

    public void j(int[] nArray) {
        this.fD = nArray;
    }

    public int[] hT() {
        return this.fD;
    }

    public int hU() {
        return this.fD[0] + this.fD[1] + this.fD[2] + this.fD[3];
    }

    public String hV() {
        return String.valueOf(Integer.toString(this.hU())) + " (G:" + Integer.toString(this.fD[0]) + "," + "A:" + Integer.toString(this.fD[1]) + "," + "Cd:" + Integer.toString(this.fD[2]) + "," + "Cm:" + Integer.toString(this.fD[3]) + ")";
    }

    public b hW() {
        return this.go;
    }

    public void a(b b2) {
        this.go = b2;
    }

    public boolean hX() {
        return this.fx != null && this.fx.b() == 5 || this.fx.b() == 7;
    }

    public int[] hY() {
        return this.fX;
    }

    public int[] hZ() {
        return this.fZ;
    }

    public int[] ia() {
        return this.ga;
    }

    public boolean e() {
        return this.v;
    }

    public void a(boolean bl2) {
        this.v = bl2;
    }

    public int[] ib() {
        return this.fQ;
    }

    public boolean ic() {
        boolean bl2 = false;
        if (this.fz.jY() != null && this.fA.jY() != null) {
            int n2 = 0;
            while (n2 < aq.pe.length) {
                if (this.fz.jY().equals(aq.pe[n2][0]) && this.fA.jY().equals(aq.pe[n2][1])) {
                    return true;
                }
                if (this.fA.jY().equals(aq.pe[n2][0]) && this.fz.jY().equals(aq.pe[n2][1])) {
                    return true;
                }
                ++n2;
            }
        }
        return bl2;
    }

    public int[][] id() {
        return this.gl;
    }

    public ArrayList ie() {
        return this.fL;
    }

    public ArrayList if() {
        return this.fM;
    }

    public String ig() {
        return String.valueOf(this.fB) + " x " + this.fC;
    }

    public String ih() {
        return " " + this.fB + "x" + this.fC + " ";
    }

    public String ii() {
        return " " + this.fB + "x" + this.fC + " " + "(" + this.gi[0] + "x" + this.gi[1] + ")";
    }

    public String t(boolean bl2) {
        if (!bl2) {
            return " " + this.fB + "x" + this.fC + " ";
        }
        return " " + this.fC + "x" + this.fB + " ";
    }

    public String u(boolean bl2) {
        if (!bl2) {
            return String.valueOf(this.gi[0]) + "x" + this.gi[1];
        }
        return String.valueOf(this.gi[1]) + "x" + this.gi[0];
    }

    public String ij() {
        return this.gp;
    }

    public void o(String string) {
        this.gp = string;
    }

    public int dX() {
        return this.dq;
    }

    public void O(int n2) {
        this.dq = n2;
    }

    public String ik() {
        return this.gq;
    }

    public void p(String string) {
        this.gq = string;
    }

    public v il() {
        return this.gr;
    }

    public void b(v v2) {
        this.gr = v2;
    }
}

