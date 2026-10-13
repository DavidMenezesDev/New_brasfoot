/*
 * Decompiled with CFR 0.152.
 */
package best;

import best.C;
import best.F;
import best.I;
import best.W;
import best.Z;
import best.a;
import best.ac;
import best.ai;
import best.aj;
import best.ak;
import best.al;
import best.ao;
import best.aq;
import best.at;
import best.l;
import best.v;
import best.w;
import components.ag;
import components.as;
import e.g;
import e.t;
import f.B;
import f.o;
import f.s;
import f.z;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ah
implements Serializable {
    private static final long serialVersionUID = 1L;
    private int mU = -1;
    private int ei = -1;
    private String mV = null;
    private Boolean mW = false;
    private Boolean mX = false;
    private int mY;
    private int pais;
    private int dr;
    private int hA;
    private int divisao = 0;
    private transient al mZ;
    private int na = -1;
    private long nb = 0L;
    private int nc = 0;
    private ArrayList nd = new ArrayList();
    private ArrayList ne = new ArrayList();
    private ArrayList nf = new ArrayList();
    private ArrayList ng = new ArrayList();
    private F nh = null;
    private F ni = null;
    private F nj = null;
    private F nk = null;
    private int nl;
    private transient Color nm = null;
    private transient Color nn = null;
    private String cor1 = "#000000";
    private String cor2 = "#ffffff";
    private ArrayList no = new ArrayList();
    private ArrayList np = new ArrayList();
    private v dH;
    private int[] nq = new int[4];
    private int[] nr;
    private int ns;
    private boolean nt;
    private int nu;
    private boolean nv;
    private int hr;
    private ArrayList nw;
    private C nx;
    private ArrayList ny;
    private ag nz;
    private int nA;
    private int[] nB;
    private int[][] nC;
    private int nD;
    private transient ImageIcon nE;
    private transient ImageIcon nF;
    private transient ImageIcon nG;
    private transient ImageIcon nH;
    private transient ImageIcon nI;
    private ArrayList cA;
    private String dm;
    private transient int Kb;
    public static Comparator nJ = new ai();

    public ah() {
        int[] nArray = new int[5];
        nArray[1] = 1;
        nArray[2] = 1;
        nArray[3] = 1;
        nArray[4] = 1;
        this.nr = nArray;
        this.ns = 0;
        this.nt = true;
        this.nu = 0;
        this.nv = false;
        this.hr = new Random().nextInt(1000) + 1;
        this.nw = new ArrayList();
        this.nx = new C();
        this.ny = new ArrayList();
        this.nz = null;
        this.nA = 0;
        this.nB = new int[15];
        this.nC = new int[15][3];
        this.nD = 0;
        this.nE = null;
        this.nF = null;
        this.nG = null;
        this.nH = null;
        this.nI = null;
        this.cA = new ArrayList();
        this.dm = "";
        this.Kb = -1;
    }

    public ah(String string, String string2, int n2, int n3, int n4, int n5, String string3, int n6, Color color, Color color2, String string4, int n7, ArrayList arrayList, boolean bl2) {
        int[] nArray = new int[5];
        nArray[1] = 1;
        nArray[2] = 1;
        nArray[3] = 1;
        nArray[4] = 1;
        this.nr = nArray;
        this.ns = 0;
        this.nt = true;
        this.nu = 0;
        this.nv = false;
        this.hr = new Random().nextInt(1000) + 1;
        this.nw = new ArrayList();
        this.nx = new C();
        this.ny = new ArrayList();
        this.nz = null;
        this.nA = 0;
        this.nB = new int[15];
        this.nC = new int[15][3];
        this.nD = 0;
        this.nE = null;
        this.nF = null;
        this.nG = null;
        this.nH = null;
        this.nI = null;
        this.cA = new ArrayList();
        this.dm = "";
        this.Kb = -1;
        this.dm = string;
        this.mV = string2;
        this.mY = n2;
        this.pais = n3;
        this.dr = n4;
        this.setReputacao(n6);
        this.nm = color;
        this.nn = color2;
        this.setNivel(n5);
        if (!bl2) {
            al al2;
            this.a(string4, n7);
            this.mZ = al2 = new al(string3);
            this.mZ.n(this);
            this.na = al2.lT();
            this.mZ.setReputacao(n6);
            c.a.SR.a(al2);
            c.a.SR.c(this);
            int n8 = 0;
            while (n8 < arrayList.size()) {
                F f2 = new F((W)arrayList.get(n8), this);
                if (f2.fC().booleanValue()) {
                    c.a.SR.c(f2);
                    this.ne.add(f2);
                } else {
                    c.a.SR.b(f2);
                    this.nd.add(f2);
                }
                ++n8;
            }
        } else {
            this.nc = this.getReputacao();
        }
    }

    public int getPais() {
        return this.pais;
    }

    public int jV() {
        int n2 = -1;
        Integer[][] integerArrayArray = new Integer[][]{{18, 25}, {10, 17, 22, 23}, {1, 4, 5, 9, 14, 15, 16, 19, 24}, {0, 2, 3, 6, 7, 8, 11, 12, 13, 20, 21, 26}};
        int n3 = 0;
        while (n3 < integerArrayArray.length) {
            int n4 = 0;
            while (n4 < integerArrayArray[n3].length) {
                if (this.dr == integerArrayArray[n3][n4]) {
                    n2 = n3;
                }
                ++n4;
            }
            ++n3;
        }
        return n2;
    }

    public int jW() {
        int n2 = -1;
        Integer[][] integerArrayArray = new Integer[][]{{25, 18, 10, 22}, {17, 23, 4, 15, 5}, {8, 1, 13, 11, 9, 19, 14}, {24, 0, 16, 12, 2, 6}, {7, 26, 20, 3, 21}};
        int n3 = 0;
        while (n3 < integerArrayArray.length) {
            int n4 = 0;
            while (n4 < integerArrayArray[n3].length) {
                if (this.dr == integerArrayArray[n3][n4]) {
                    n2 = n3;
                }
                ++n4;
            }
            ++n3;
        }
        return n2;
    }

    public int jX() {
        int n2 = -1;
        Integer[][] integerArrayArray = new Integer[][]{{18, 25, 17, 22, 23}, {10}, {1, 4, 5, 9, 14, 15, 16, 19, 24}, {6, 7, 8, 11, 12, 26}, {0, 2, 3, 13, 20, 21}};
        int n3 = 0;
        while (n3 < integerArrayArray.length) {
            int n4 = 0;
            while (n4 < integerArrayArray[n3].length) {
                if (this.dr == integerArrayArray[n3][n4]) {
                    n2 = n3;
                }
                ++n4;
            }
            ++n3;
        }
        return n2;
    }

    public void setPais(int n2) {
        this.pais = n2;
    }

    public String getNome() {
        return this.dm;
    }

    public String jY() {
        return this.mV;
    }

    public Boolean jZ() {
        return this.mW;
    }

    public void k(Boolean bl2) {
        this.mW = bl2;
    }

    public al ka() {
        if (this.mZ == null) {
            this.mZ = c.a.SR.y(this.na);
        }
        return this.mZ;
    }

    public void h(al al2) {
        this.mZ = al2;
        this.na = this.mZ != null ? this.mZ.lT() : -1;
    }

    public long kb() {
        return this.nb;
    }

    public void e(long l2) {
        this.nb = l2;
    }

    public int getReputacao() {
        return this.nc;
    }

    public void setReputacao(int n2) {
        this.nc = n2;
    }

    public ArrayList kc() {
        return this.nd;
    }

    public void N(ArrayList arrayList) {
        this.nd = arrayList;
    }

    public F kd() {
        if (this.nh != null && this.nh.fg() != this) {
            if (!this.lp()) {
                this.nh = null;
            } else if (!this.kc().contains(this.nh)) {
                this.nh = null;
            }
        }
        return this.nh;
    }

    public void j(F f2) {
        this.nh = f2;
    }

    public F ke() {
        if (this.ni != null && this.ni.fg() != this) {
            if (!this.lp()) {
                this.ni = null;
            } else if (!this.kc().contains(this.ni)) {
                this.ni = null;
            }
        }
        return this.ni;
    }

    public void k(F f2) {
        this.ni = f2;
    }

    public v ev() {
        return this.dH;
    }

    public void a(v v2) {
        this.dH = v2;
    }

    public void l(F f2) {
        this.nd.add(f2);
    }

    public void m(F f2) {
        this.ne.add(f2);
    }

    public int getNivel() {
        return this.hA;
    }

    public void setNivel(int n2) {
        this.hA = n2 < 1 || n2 > 25 ? 10 : n2;
    }

    public void a(String string, int n2) {
        this.dH = new v(string, n2, this);
    }

    public boolean kf() {
        return this.nv;
    }

    public void I(boolean bl2) {
        this.nv = bl2;
    }

    public int getDivisao() {
        return this.divisao;
    }

    public boolean kg() {
        w w2 = c.a.SR.p(this.dr);
        return w2 != null && w2.j(this);
    }

    public void setDivisao(int n2) {
        this.divisao = n2;
    }

    public static void kh() {
        ArrayList arrayList = new ArrayList();
        arrayList = ((a)c.a.SR.R().get(c.a.SR.J())).h();
        int n2 = 0;
        while (n2 < arrayList.size()) {
            if (!((I)arrayList.get(n2)).hc().jZ().booleanValue() && !((I)arrayList.get(n2)).hc().kf()) {
                ah.a(((I)arrayList.get(n2)).hc(), (I)arrayList.get(n2), 1, -1, true);
            }
            if (!((I)arrayList.get(n2)).hd().jZ().booleanValue() && !((I)arrayList.get(n2)).hd().kf()) {
                ah.a(((I)arrayList.get(n2)).hd(), (I)arrayList.get(n2), 2, -1, true);
            }
            ++n2;
        }
    }

    public static void a(ah ah2, I i2, int n2, int n3, boolean bl2) {
        int n4;
        int n5;
        ArrayList<F> arrayList = new ArrayList<F>();
        int[] nArray = new int[6];
        int n6 = 0;
        while (n6 < ah2.nd.size()) {
            ((F)ah2.nd.get(n6)).as(-1);
            if (((F)ah2.nd.get(n6)).a(i2, false)) {
                arrayList.add((F)ah2.nd.get(n6));
                n5 = ((F)ah2.nd.get(n6)).getPosicao();
                if (n5 >= 0 && n5 <= 4) {
                    int n7 = n5;
                    nArray[n7] = nArray[n7] + 1;
                }
                if (n5 == 3 && ((F)ah2.nd.get(n6)).fF() == 0) {
                    nArray[5] = nArray[5] + 1;
                }
                ((F)ah2.nd.get(n6)).fF();
            }
            ++n6;
        }
        Collections.sort(arrayList, h.a.abh);
        ah2.nf.clear();
        ah2.ng.clear();
        n6 = 1;
        n5 = new Random().nextInt(100) + 1;
        n6 = n5 >= 0 && n5 <= 2 ? 1 : (n5 >= 3 && n5 <= 4 ? 2 : (n5 >= 5 && n5 <= 7 ? 3 : (n5 >= 8 && n5 <= 38 ? 4 : (n5 >= 39 && n5 <= 49 ? 5 : (n5 >= 50 && n5 <= 60 ? 6 : (n5 >= 61 && n5 <= 65 ? 7 : (n5 >= 66 && n5 <= 72 ? 8 : (n5 >= 73 && n5 <= 90 ? 9 : (n5 >= 91 && n5 <= 92 ? 10 : (n5 >= 93 && n5 <= 101 ? 11 : 4))))))))));
        if (n3 > 0) {
            n6 = n3;
        }
        int n8 = 0;
        while (n8 < 11) {
            n4 = aq.sJ[n6][n8];
            F f2 = ah.a(arrayList, n4, false, false);
            if (f2 != null) {
                f2.as(n4);
                f2.b(true);
                ah2.nf.add(f2);
                if (n2 == 1) {
                    i2.hl().add(f2);
                    i2.hp().add(f2);
                } else if (n2 == 2) {
                    i2.hm().add(f2);
                    i2.hq().add(f2);
                }
                arrayList.remove(f2);
            }
            ++n8;
        }
        n8 = 0;
        while (n8 < aq.sI.length) {
            F f3 = ah.a(arrayList, aq.sI[n8], true, false);
            if (f3 != null) {
                ah2.ng.add(f3);
                if (n2 == 1) {
                    i2.hn().add(f3);
                } else if (n2 == 2) {
                    i2.ho().add(f3);
                }
                arrayList.remove(f3);
            }
            ++n8;
        }
        ah2.I(true);
        if (bl2) {
            n8 = 0;
            n4 = 0;
            int n9 = 0;
            n5 = new Random().nextInt(100) + 1;
            if (n5 >= 0 && n5 <= 70) {
                n8 = 0;
            } else if (n5 >= 71 && n5 <= 80) {
                n8 = 1;
            } else if (n5 >= 81 && n5 <= 100) {
                n8 = 2;
            }
            n5 = new Random().nextInt(100) + 1;
            if (n5 >= 1 && n5 <= 5) {
                n4 = 2;
            } else if (n5 >= 6 && n5 <= 70) {
                n4 = 0;
            } else if (n5 >= 71 && n5 <= 100) {
                n4 = 1;
            }
            n5 = new Random().nextInt(100) + 1;
            if (n5 >= 1 && n5 <= 70) {
                n9 = 0;
            } else if (n5 >= 71 && n5 <= 100) {
                n9 = 1;
            }
            int[] nArray2 = new int[]{n6, n8, n4, n9};
            ah2.k(nArray2);
        }
    }

    public static void a(I i2, ah ah2, int n2) {
        int n3;
        int[] nArray = new int[26];
        int[] nArray2 = new int[13];
        int n4 = 0;
        int n5 = 0;
        boolean bl2 = false;
        ArrayList arrayList = n2 == 1 ? i2.hl() : i2.hm();
        int n6 = 0;
        while (n6 < arrayList.size()) {
            n3 = 0;
            while (n3 <= 1) {
                if (aq.sF[((F)arrayList.get(n6)).fT()][n3] > 0) {
                    if (((F)arrayList.get(n6)).getPosicao() != aq.sE[((F)arrayList.get(n6)).fT()][0]) {
                        n5 = (int)Math.round(0.7 * (double)((F)arrayList.get(n6)).fU());
                        if (((F)arrayList.get(n6)).fT() == 1) {
                            n4 = (int)Math.round(0.3 * (double)((F)arrayList.get(n6)).fU());
                            bl2 = true;
                        }
                    } else {
                        n5 = ((F)arrayList.get(n6)).fU();
                        if (((F)arrayList.get(n6)).fT() == 1) {
                            n4 = ((F)arrayList.get(n6)).fU();
                        }
                    }
                    nArray2[aq.sF[((F)arrayList.get((int)n6)).fT()][n3]] = nArray2[aq.sF[((F)arrayList.get(n6)).fT()][n3]] + n5;
                    int n7 = ((F)arrayList.get(n6)).fT();
                    nArray[n7] = nArray[n7] + 1;
                }
                ++n3;
            }
            ++n6;
        }
        n6 = 0;
        n3 = 0;
        int n8 = 0;
        int n9 = 0;
        int n10 = 0;
        int n11 = 3;
        while (n11 <= 8) {
            if (nArray[n11] > 0) {
                ++n6;
            }
            ++n11;
        }
        n11 = 2;
        while (n11 <= 9) {
            if (nArray[n11] > 0) {
                ++n3;
            }
            ++n11;
        }
        n11 = 11;
        while (n11 <= 16) {
            if (nArray[n11] > 0) {
                ++n8;
            }
            ++n11;
        }
        n11 = 10;
        while (n11 <= 17) {
            if (nArray[n11] > 0) {
                ++n9;
            }
            ++n11;
        }
        n11 = 18;
        while (n11 <= 25) {
            if (nArray[n11] > 0) {
                ++n10;
            }
            ++n11;
        }
        if (n6 == 1 || n3 < 2) {
            n11 = 1;
            while (n11 <= 12) {
                nArray2[n11] = (int)Math.round((double)nArray2[n11] * 0.7);
                ++n11;
            }
        } else if (n6 == 0 || bl2) {
            n11 = 1;
            while (n11 <= 12) {
                nArray2[n11] = (int)Math.round((double)nArray2[n11] * 0.2);
                ++n11;
            }
        } else if (n6 > 3) {
            n11 = 1;
            while (n11 <= 12) {
                nArray2[n11] = (int)Math.round((double)nArray2[n11] * 0.7);
                ++n11;
            }
        }
        if (n8 > 4) {
            n11 = 1;
            while (n11 <= 12) {
                nArray2[n11] = (int)Math.round((double)nArray2[n11] * 0.7);
                ++n11;
            }
        }
        if (n10 > 3) {
            n11 = 1;
            while (n11 <= 12) {
                nArray2[n11] = (int)Math.round((double)nArray2[n11] * 0.7);
                ++n11;
            }
        }
        if (n9 > 5) {
            n11 = 1;
            while (n11 <= 12) {
                nArray2[n11] = (int)Math.round((double)nArray2[n11] * 0.5);
                ++n11;
            }
        }
        n5 = 0;
        n11 = 1;
        while (n11 <= 12) {
            n5 += nArray2[n11];
            ++n11;
        }
        if (n2 == 1) {
            i2.aP(n5);
        } else {
            i2.aQ(n5);
        }
    }

    public static F a(ArrayList arrayList, int n2, boolean bl2, boolean bl3) {
        int n3;
        int n4 = n3 = aq.sE[n2][0];
        int n5 = aq.sE[n2][1];
        int n6 = aq.sE[n2][2];
        boolean bl4 = false;
        boolean bl5 = false;
        if (n5 == -1) {
            bl5 = true;
        }
        if (n6 == -1) {
            bl4 = true;
        }
        if (n2 >= 18) {
            n6 = -1;
        }
        int n7 = 4;
        if (bl2) {
            n7 = 4;
        }
        int n8 = 0;
        while (n8 <= n7) {
            n4 = aq.sH[n3][n8];
            int n9 = 1;
            while (n9 <= 3) {
                int n10 = 0;
                while (n10 < arrayList.size()) {
                    if (bl5) {
                        n5 = ((F)arrayList.get(n10)).getLado();
                    }
                    if (bl4) {
                        n6 = ((F)arrayList.get(n10)).fF();
                    }
                    if (n9 == 2) {
                        n5 = ((F)arrayList.get(n10)).getLado();
                    }
                    if (n9 == 3) {
                        n5 = ((F)arrayList.get(n10)).getLado();
                        n6 = ((F)arrayList.get(n10)).fF();
                    }
                    if (n9 == 4) {
                        if (!bl3) {
                            n4 = ((F)arrayList.get(n10)).getPosicao();
                        } else if (((F)arrayList.get(n10)).getPosicao() != 0) {
                            n4 = ((F)arrayList.get(n10)).getPosicao();
                        }
                    }
                    if (n4 == ((F)arrayList.get(n10)).getPosicao() && n5 == ((F)arrayList.get(n10)).getLado() && n6 == ((F)arrayList.get(n10)).fF()) {
                        return (F)arrayList.get(n10);
                    }
                    ++n10;
                }
                ++n9;
            }
            ++n8;
        }
        return null;
    }

    public boolean ki() {
        int n2 = 0;
        while (n2 < aq.rW.length) {
            if (aq.rW[n2] == this.pais) {
                return true;
            }
            ++n2;
        }
        return false;
    }

    public int gg() {
        return ac.valueOf("P" + Integer.toString(this.pais)).gg();
    }

    public void u(int n2, int n3) {
        this.nr[n2] = n3;
    }

    public int bQ(int n2) {
        return this.nr[n2];
    }

    public int[] kj() {
        return this.nq;
    }

    public void k(int[] nArray) {
        this.nq = nArray;
    }

    public ak c(s s2) {
        int n2 = 0;
        while (n2 < this.no.size()) {
            if (((ak)this.no.get(n2)).lC() == s2) {
                return (ak)this.no.get(n2);
            }
            ++n2;
        }
        return null;
    }

    public int[] d(s s2) {
        int[] nArray = new int[8];
        int n2 = 0;
        while (n2 < this.no.size()) {
            if (((ak)this.no.get(n2)).lC() == s2) {
                return ((ak)this.no.get(n2)).lB();
            }
            ++n2;
        }
        return nArray;
    }

    public void e(s s2) {
        int n2 = 0;
        while (n2 < this.no.size()) {
            if (((ak)this.no.get(n2)).lC() == s2) {
                ((ak)this.no.get(n2)).lA();
            }
            ++n2;
        }
    }

    public aj n(at at2) {
        int n2 = 0;
        while (n2 < this.np.size()) {
            if (((aj)this.np.get(n2)).H() == c.a.SR.H() - 1 && ((aj)this.np.get(n2)).b() == at2.b() && ((aj)this.np.get(n2)).el() == at2.el()) {
                return (aj)this.np.get(n2);
            }
            ++n2;
        }
        return null;
    }

    public aj a(at at2, int n2) {
        int n3 = 0;
        while (n3 < this.np.size()) {
            if (((aj)this.np.get(n3)).H() == c.a.SR.H() && ((aj)this.np.get(n3)).b() == at2.b() && ((aj)this.np.get(n3)).el() == n2) {
                return (aj)this.np.get(n3);
            }
            ++n3;
        }
        aj aj2 = new aj(at2, this, n2);
        this.np.add(aj2);
        return aj2;
    }

    public void b(at at2, int n2) {
        aj aj2 = this.n(at2);
        if (aj2 != null) {
            aj2.ce(n2);
        }
    }

    public void c(at at2, int n2, int n3) {
        aj aj2 = this.a(at2, n3);
        if (aj2 != null) {
            aj2.cd(n2);
        }
    }

    public void e(at at2, int n2) {
        aj aj2 = this.a(at2, at2.el());
        if (aj2 != null) {
            aj2.setDivisao(n2);
        }
    }

    public void a(at at2, int n2, int n3) {
        aj aj2 = this.a(at2, at2.el());
        aj2.cc(n2);
        aj2.cd(n3);
        if (n2 <= 10) {
            this.b(at2, n2, n3);
            if (this.ka() != null) {
                this.ka().b(at2, n2, n3);
            }
            if (this.jZ().booleanValue() && (at2.b() == 1 || at2.b() == 3)) {
                this.c(at2, n2);
            }
            if (n2 == 1) {
                this.q(at2);
            }
        }
    }

    private void c(at at2, int n2) {
        int n3 = 0;
        int n4 = this.getDivisao();
        --n2;
        if (at2.b() == 1 && n4 < aq.sr.length) {
            if (n2 < aq.sr[n4].length) {
                n3 = aq.sr[n4][n2];
            }
        } else if (at2.b() == 3 && at2.ip() == 1 && n2 < aq.su.length) {
            n3 = aq.su[n2];
        }
        if (n3 > 0) {
            this.v(n3, 3);
            if (this.ka() != null && this.ka().jZ().booleanValue() && at2 != null) {
                new as(this.ka(), 26, 80, at2.getNome(), C.c(n3));
            }
        }
    }

    private void d(int n2, int n3, int n4) {
        int[][] nArrayArray = new int[2][];
        int[] nArray = new int[15];
        nArray[1] = 500;
        nArray[2] = 300;
        nArray[3] = 10;
        nArray[4] = 5000;
        nArray[5] = 40000;
        nArray[6] = 2000;
        nArray[8] = 500;
        nArray[10] = 50;
        nArray[13] = 1000;
        nArrayArray[0] = nArray;
        int[] nArray2 = new int[15];
        nArray2[1] = 90;
        nArray2[2] = 50;
        nArray2[3] = 5;
        nArray2[4] = 1000;
        nArray2[5] = 1000;
        nArray2[6] = 500;
        nArray2[13] = 500;
        nArrayArray[1] = nArray2;
        int[][] nArrayArray2 = nArrayArray;
        int n5 = 0;
        if (n2 < nArrayArray2.length && n3 < nArrayArray2[0].length) {
            n5 = nArrayArray2[n2][n3];
        }
        if (n5 > 1000 & this.mX == false && this.gg() > 1) {
            n5 = (int)Math.round((double)n5 * 0.6);
        }
        if (n3 == 1 && n4 > 1) {
            n5 = 50;
        }
        this.nu += n5;
        if (this.mZ != null) {
            this.mZ.a(n2, n3, n4, this.mX, this.gg());
        }
    }

    public void kk() {
        int n2 = 0;
        if (this.nc == 5) {
            this.nu -= 6000;
            if (this.nu < -90000) {
                this.nc = 4;
                this.nu = 0;
            }
        } else if (this.nc == 4) {
            this.nu -= 600;
            if (this.nu < -9000) {
                this.nc = 3;
                this.nu = 0;
            }
        } else if (this.nc == 3 && this.kn().booleanValue()) {
            this.nu -= 50;
            if (this.nu < -1000) {
                this.nc = 2;
                this.nu = 0;
            }
        } else if (this.nc == 2 && this.kn().booleanValue()) {
            this.nu -= 5;
            if (this.nu < -1000) {
                this.nc = 2;
                this.nu = 0;
            }
        }
        if (this.nu > 100000) {
            n2 = 5;
            this.nu = 100001;
        } else if (this.nu > 10000) {
            n2 = 4;
        } else if (this.nu > 1000) {
            n2 = 3;
        } else if (this.nu > 100) {
            n2 = 2;
        } else if (this.nu > 10) {
            n2 = 1;
        }
        if (n2 > this.nc) {
            this.nc = n2;
        }
    }

    private void b(at at2, int n2, int n3) {
        int n4 = at2.b();
        int n5 = -1;
        if (n4 == 1) {
            n5 = at2.ip();
        }
        if (n4 == 7) {
            n5 = at2.el();
        }
        if (n2 == 1 || n2 == 2) {
            this.d(n2 - 1, n4, n5);
        }
        int[][] nArrayArray = new int[16][];
        nArrayArray[0] = new int[11];
        int[] nArray = new int[11];
        nArray[1] = 15;
        nArray[2] = 10;
        nArray[3] = 8;
        nArray[4] = 7;
        nArray[5] = 6;
        nArray[6] = 5;
        nArray[7] = 4;
        nArray[8] = 3;
        nArray[9] = 2;
        nArray[10] = 1;
        nArrayArray[1] = nArray;
        int[] nArray2 = new int[11];
        nArray2[1] = 12;
        nArray2[2] = 7;
        nArray2[3] = 3;
        nArray2[4] = 3;
        nArrayArray[2] = nArray2;
        int[] nArray3 = new int[11];
        nArray3[1] = 5;
        nArray3[2] = 3;
        nArrayArray[3] = nArray3;
        int[] nArray4 = new int[11];
        nArray4[1] = 20;
        nArray4[2] = 15;
        nArray4[3] = 7;
        nArray4[4] = 7;
        nArray4[5] = 3;
        nArray4[6] = 3;
        nArrayArray[4] = nArray4;
        int[] nArray5 = new int[11];
        nArray5[1] = 10;
        nArray5[2] = 5;
        nArrayArray[5] = nArray5;
        int[] nArray6 = new int[11];
        nArray6[1] = 12;
        nArray6[2] = 10;
        nArray6[3] = 5;
        nArray6[4] = 5;
        nArrayArray[6] = nArray6;
        int[] nArray7 = new int[11];
        nArray7[1] = 50;
        nArray7[2] = 35;
        nArray7[3] = 10;
        nArray7[4] = 5;
        nArrayArray[7] = nArray7;
        int[] nArray8 = new int[11];
        nArray8[1] = 3;
        nArrayArray[8] = nArray8;
        nArrayArray[9] = new int[11];
        int[] nArray9 = new int[11];
        nArray9[1] = 2;
        nArray9[2] = 1;
        nArrayArray[10] = nArray9;
        int[] nArray10 = new int[11];
        nArray10[1] = 2;
        nArrayArray[11] = nArray10;
        int[] nArray11 = new int[11];
        nArray11[1] = 10;
        nArray11[2] = 8;
        nArray11[3] = 4;
        nArray11[4] = 4;
        nArrayArray[12] = nArray11;
        nArrayArray[13] = new int[11];
        int[] nArray12 = new int[11];
        nArray12[1] = 15;
        nArray12[2] = 10;
        nArray12[3] = 5;
        nArrayArray[14] = nArray12;
        nArrayArray[15] = new int[11];
        int[][] nArrayArray2 = nArrayArray;
        int[] nArray13 = nArrayArray2[n4];
        if (n4 == 7) {
            if (n5 != 7) {
                int[] nArray14 = new int[11];
                nArray14[1] = 20;
                nArray14[2] = 15;
                nArray14[3] = 10;
                nArray14[4] = 5;
                int[] nArray15 = nArray14;
                nArray13 = nArray15;
            }
        } else if (n4 == 1 && at2.ip() > 1) {
            if (at2.ip() == 2) {
                int[] nArray16 = new int[11];
                nArray16[1] = 5;
                nArray16[2] = 3;
                nArray16[3] = 2;
                nArray16[4] = 1;
                int[] nArray17 = nArray16;
                nArray13 = nArray17;
            } else {
                int[] nArray18 = new int[11];
                nArray18[1] = 2;
                nArray18[2] = 1;
                int[] nArray19 = nArray18;
                nArray13 = nArray19;
            }
        } else if (n4 == 3 && at2.ip() > 1) {
            int[] nArray20 = new int[11];
            nArray13 = nArray20;
        } else if (n4 == 4 && this.gg() > 1) {
            int[] nArray21 = new int[11];
            nArray21[1] = 18;
            nArray21[2] = 12;
            nArray21[3] = 3;
            nArray21[4] = 3;
            nArray21[5] = 1;
            nArray21[6] = 1;
            int[] nArray22 = nArray21;
            nArray13 = nArray22;
        }
        if (n4 <= 14 && n2 >= 0 && n2 < nArray13.length) {
            this.nB[n4] = this.nB[n4] + nArray13[n2];
        }
    }

    public void e(I i2) {
        if (i2.hy() != null) {
            int n2 = 0;
            int n3 = 0;
            if (i2.hc() == this) {
                n2 = i2.hu();
                n3 = i2.hw();
            } else if (i2.hd() == this) {
                n2 = i2.hw();
                n3 = i2.hu();
            }
            int n4 = i2.hy().el();
            if (i2.ht() != null && i2.ht() instanceof z && ((z)i2.ht()).zf() == 1098) {
                n4 = 1098;
            }
            aj aj2 = this.a(i2.hy(), n4);
            aj2.cl();
            aj2.ca(n2);
            this.e(i2.hy().b(), 1, n2);
            aj2.cb(n3);
            this.e(i2.hy().b(), 2, n3);
            if (n2 > n3) {
                aj2.cn();
                this.e(i2.hy().b(), 0, 3);
            } else if (n2 < n3) {
                aj2.cp();
            } else if (n2 == n3) {
                this.e(i2.hy().b(), 0, 1);
            }
        }
    }

    public void a(I i2, s s2) {
        int n2 = 0;
        int n3 = 0;
        int n4 = i2.ht().b();
        if (n4 < 0 || n4 > 14) {
            n4 = 0;
        }
        if (i2.hc() == this) {
            n2 = i2.hu();
            n3 = i2.hw();
        } else if (i2.hd() == this) {
            n2 = i2.hw();
            n3 = i2.hu();
        }
        ak ak2 = this.c(s2);
        if (ak2 == null) {
            ak2 = new ak(this, s2);
            this.no.add(ak2);
        }
        ak2.cl();
        ak2.ca(n2);
        ak2.cb(n3);
        if (n2 > n3) {
            ak2.cn();
            ak2.cf(3);
        } else if (n2 < n3) {
            ak2.cp();
        } else if (n2 == n3) {
            ak2.cf(1);
        }
    }

    public int getEstado() {
        return this.dr;
    }

    public int kl() {
        return this.mY;
    }

    public int iS() {
        return this.hr;
    }

    public void bR(int n2) {
        this.hr = n2;
    }

    public ArrayList km() {
        return this.no;
    }

    public Boolean kn() {
        return this.mX;
    }

    public boolean ko() {
        Z z2 = c.a.SR.o(this.getPais());
        if (z2 != null) {
            int n2 = 0;
            while (n2 < z2.eb().size()) {
                int n3 = 0;
                while (n3 < ((B)z2.eb().get(n2)).yi().yK().size()) {
                    if (((ah)((B)z2.eb().get(n2)).yi().yK().get(n3)).equals(this)) {
                        return true;
                    }
                    ++n3;
                }
                ++n2;
            }
        }
        return false;
    }

    public void l(Boolean bl2) {
        this.mX = bl2;
    }

    public void kp() {
        int[] nArray = this.J(false);
        int[] nArray2 = new int[]{2, 3, 3, 5, 4};
        this.ks();
        Collections.shuffle(this.nd);
        int n2 = 0;
        while (n2 <= 4) {
            if (nArray[n2] > nArray2[n2] && new Random().nextInt(100) > 50) {
                int n3 = 0;
                while (n3 < this.nd.size()) {
                    if (!(((F)this.nd.get(n3)).getPosicao() != n2 || ((F)this.nd.get(n3)).getStatus() != 0 || ((F)this.nd.get(n3)).ff().booleanValue() || ((F)this.nd.get(n3)).gm().booleanValue() || ((F)this.nd.get(n3)).gl().booleanValue())) {
                        ((F)this.nd.get(n3)).fm();
                        ((F)this.nd.get(n3)).c(true);
                        if (new Random().nextInt(100) <= 70 || ((F)this.nd.get(n3)).fi() >= 42) break;
                        ((F)this.nd.get(n3)).g(true);
                        break;
                    }
                    ++n3;
                }
            }
            ++n2;
        }
    }

    public int kq() {
        int n2 = 0;
        int n3 = 0;
        while (n3 < c.a.SR.bt().size()) {
            if (((components.t)c.a.SR.bt().get(n3)).x().fg() != null && ((components.t)c.a.SR.bt().get(n3)).tP() == this) {
                ++n2;
            }
            ++n3;
        }
        return n2;
    }

    public int kr() {
        int n2 = 0;
        int n3 = 0;
        while (n3 < this.nd.size()) {
            if (!((F)this.nd.get(n3)).gl().booleanValue() && ((F)this.nd.get(n3)).fz().booleanValue()) {
                ++n2;
            }
            ++n3;
        }
        return n2;
    }

    public void ks() {
        int n2 = 0;
        while (n2 < this.nd.size()) {
            ((F)this.nd.get(n2)).c(false);
            ((F)this.nd.get(n2)).g(false);
            ++n2;
        }
    }

    public int[] kt() {
        int[] nArray = new int[5];
        int n2 = 0;
        while (n2 < this.nd.size()) {
            int n3 = ((F)this.nd.get(n2)).getPosicao();
            nArray[n3] = nArray[n3] + 1;
            ++n2;
        }
        return nArray;
    }

    public int[] J(boolean bl2) {
        int[] nArray = new int[6];
        int n2 = 0;
        while (n2 < this.nd.size()) {
            if (bl2) {
                int n3 = ((F)this.nd.get(n2)).getPosicao();
                nArray[n3] = nArray[n3] + 1;
                if (((F)this.nd.get(n2)).getPosicao() == 3 && ((F)this.nd.get(n2)).fF() == 1) {
                    nArray[5] = nArray[5] + 1;
                }
            } else if (!((F)this.nd.get(n2)).gl().booleanValue()) {
                int n4 = ((F)this.nd.get(n2)).getPosicao();
                nArray[n4] = nArray[n4] + 1;
                if (((F)this.nd.get(n2)).getPosicao() == 3 && ((F)this.nd.get(n2)).fF() == 0) {
                    nArray[5] = nArray[5] + 1;
                }
            }
            ++n2;
        }
        return nArray;
    }

    public void ku() {
        int[] nArray = this.J(false);
        int[] nArray2 = new int[]{2, 3, 3, 5, 3, 2};
        int n2 = 0;
        while (n2 <= 4) {
            if (nArray[n2] < nArray2[n2]) {
                int n3 = 5;
                n3 = this.kn() != false ? aq.qg[this.getDivisao()] : aq.qh[this.getReputacao()];
                int[] nArray3 = new int[]{n2, n3};
                l.a(this, nArray3);
            }
            ++n2;
        }
    }

    public F kv() {
        int[] nArray = this.J(false);
        int[] nArray2 = new int[]{2, 3, 3, 5, 3, 2};
        ArrayList<Integer> arrayList = null;
        int n2 = 0;
        while (n2 <= 4) {
            if (nArray[n2] > nArray2[n2]) {
                if (arrayList == null) {
                    arrayList = new ArrayList<Integer>();
                }
                arrayList.add(n2);
            }
            ++n2;
        }
        if (arrayList != null && arrayList.size() > 0) {
            Collections.shuffle(arrayList);
            ArrayList<F> arrayList2 = new ArrayList<F>();
            int n3 = 0;
            while (n3 < this.nd.size()) {
                if (!((F)this.nd.get(n3)).gl().booleanValue() && !((F)this.nd.get(n3)).ff().booleanValue() && ((F)this.nd.get(n3)).getPosicao() == ((Integer)arrayList.get(0)).intValue()) {
                    arrayList2.add((F)this.nd.get(n3));
                }
                ++n3;
            }
            if (arrayList2.size() > 0) {
                Collections.shuffle(arrayList2);
                return (F)arrayList2.get(0);
            }
        }
        return null;
    }

    public int bS(int n2) {
        int[] nArray = new int[5];
        int n3 = 0;
        while (n3 < this.nd.size()) {
            int n4 = ((F)this.nd.get(n3)).getPosicao();
            nArray[n4] = nArray[n4] + 1;
            ++n3;
        }
        return nArray[n2];
    }

    public int kw() {
        return this.nd.size();
    }

    public int kx() {
        return this.ne.size();
    }

    public ArrayList ky() {
        return this.ne;
    }

    public ah(t t2) {
        F f2;
        int[] nArray = new int[5];
        nArray[1] = 1;
        nArray[2] = 1;
        nArray[3] = 1;
        nArray[4] = 1;
        this.nr = nArray;
        this.ns = 0;
        this.nt = true;
        this.nu = 0;
        this.nv = false;
        this.hr = new Random().nextInt(1000) + 1;
        this.nw = new ArrayList();
        this.nx = new C();
        this.ny = new ArrayList();
        this.nz = null;
        this.nA = 0;
        this.nB = new int[15];
        this.nC = new int[15][3];
        this.nD = 0;
        this.nE = null;
        this.nF = null;
        this.nG = null;
        this.nH = null;
        this.nI = null;
        this.cA = new ArrayList();
        this.dm = "";
        this.Kb = -1;
        this.dm = t2.getNome();
        this.mV = t2.getFileRef();
        this.mY = t2.getId();
        this.pais = t2.getPais();
        this.dr = t2.getEstado();
        this.setReputacao(t2.getReputacao());
        this.nm = t2.getCorF();
        this.nn = t2.getCorT();
        this.cor1 = t2.getCor1();
        this.cor2 = t2.getCor2();
        this.setNivel(t2.getNivel());
        this.a(t2.getEstadio(), t2.getCapacidade());
        al al2 = new al(t2.getTecnico());
        al2.cg(t2.getTecNac());
        this.mZ = al2;
        this.na = al2.lT();
        this.mZ.n(this);
        this.mZ.setReputacao(t2.getReputacao());
        c.a.SR.a(al2);
        this.nl = t2.getCorBase();
        int n2 = 0;
        while (n2 < t2.getJogadores().size()) {
            f2 = new F((g)t2.getJogadores().get(n2), false, this);
            c.a.SR.b(f2);
            this.nd.add(f2);
            ++n2;
        }
        n2 = 0;
        while (n2 < t2.getJuniores().size()) {
            f2 = new F((g)t2.getJuniores().get(n2), true, this);
            c.a.SR.c(f2);
            this.ne.add(f2);
            ++n2;
        }
        this.kA();
        this.kz();
        c.a.SR.c(this);
    }

    public void kz() {
        if (this.nd.size() > 0) {
            Collections.sort(this.nd, nJ);
            this.nh = (F)this.nd.get(0);
        }
    }

    public void O(ArrayList arrayList) {
        if (this.kd() == null || !arrayList.contains(this.kd())) {
            this.P(arrayList);
        }
    }

    public void P(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(arrayList);
        if (arrayList2.size() > 0) {
            Collections.sort(arrayList2, nJ);
            if (((F)arrayList2.get(0)).fg() == this) {
                this.nh = (F)arrayList2.get(0);
            }
        }
    }

    public void Q(ArrayList arrayList) {
        if (this.ke() == null || !arrayList.contains(this.ke())) {
            this.R(arrayList);
        }
    }

    public void R(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(arrayList);
        F f2 = null;
        if (arrayList2.size() > 0) {
            Collections.sort(arrayList2, h.a.abh);
            int n2 = 0;
            while (n2 < arrayList2.size()) {
                if (((F)arrayList2.get(n2)).getCr1() == 9) {
                    f2 = (F)arrayList2.get(n2);
                    break;
                }
                ++n2;
            }
            if (f2 == null) {
                n2 = 0;
                while (n2 < arrayList2.size()) {
                    if (((F)arrayList2.get(n2)).getPosicao() != 0) {
                        f2 = (F)arrayList2.get(n2);
                        break;
                    }
                    ++n2;
                }
            }
            if (f2 == null) {
                n2 = 0;
                while (n2 < arrayList2.size()) {
                    if (((F)arrayList2.get(n2)).getPosicao() != 0) {
                        f2 = (F)this.nd.get(n2);
                        break;
                    }
                    ++n2;
                }
            }
            if (f2 != null) {
                this.ni = f2;
            }
        }
    }

    public void kA() {
        F f2 = null;
        if (this.nd.size() > 0) {
            Collections.sort(this.nd, h.a.abh);
            int n2 = 0;
            while (n2 < this.nd.size()) {
                if (((F)this.nd.get(n2)).getStatus() == 1 && ((F)this.nd.get(n2)).getCr1() == 9) {
                    f2 = (F)this.nd.get(n2);
                    break;
                }
                ++n2;
            }
            if (f2 == null) {
                n2 = 0;
                while (n2 < this.nd.size()) {
                    if (((F)this.nd.get(n2)).getStatus() == 1 && ((F)this.nd.get(n2)).getPosicao() != 0) {
                        f2 = (F)this.nd.get(n2);
                        break;
                    }
                    ++n2;
                }
            }
            if (f2 == null) {
                n2 = 0;
                while (n2 < this.nd.size()) {
                    if (((F)this.nd.get(n2)).getPosicao() != 0) {
                        f2 = (F)this.nd.get(n2);
                        break;
                    }
                    ++n2;
                }
            }
            if (f2 != null) {
                this.ni = f2;
            }
        }
    }

    public Color kB() {
        if (this.nm == null) {
            this.nm = new Color(Integer.valueOf(this.cor1.substring(1, 3), 16), Integer.valueOf(this.cor1.substring(3, 5), 16), Integer.valueOf(this.cor1.substring(5, 7), 16));
        }
        return this.nm;
    }

    public int bT(int n2) {
        int[] nArray = new int[10];
        Color color = this.kB();
        if (n2 == 2 || n2 == 3) {
            color = this.kC();
        }
        int n3 = color.getRGB();
        float[] fArray = new float[3];
        int n4 = n3 >> 16 & 0xFF;
        int n5 = n3 >> 8 & 0xFF;
        int n6 = n3 & 0xFF;
        double d2 = 0.2126 * (double)n4 + 0.7152 * (double)n5 + 0.0722 * (double)n6;
        Color.RGBtoHSB(n4, n5, n6, fArray);
        if (d2 < 128.0) {
            nArray[0] = nArray[0] + 1;
        } else {
            nArray[1] = nArray[1] + 1;
        }
        if ((double)fArray[1] < 0.1 && (double)fArray[2] > 0.9) {
            nArray[8] = nArray[8] + 1;
        } else if ((double)fArray[2] < 0.1) {
            nArray[9] = nArray[9] + 1;
        } else {
            float f2 = fArray[0] * 360.0f;
            if (f2 >= 0.0f && f2 < 30.0f) {
                nArray[2] = nArray[2] + 1;
            } else if (f2 >= 30.0f && f2 < 90.0f) {
                nArray[3] = nArray[3] + 1;
            } else if (f2 >= 90.0f && f2 < 153.0f) {
                nArray[4] = nArray[4] + 1;
            } else if (f2 >= 150.0f && f2 < 210.0f) {
                nArray[5] = nArray[5] + 1;
            } else if (f2 >= 210.0f && f2 < 270.0f) {
                nArray[6] = nArray[6] + 1;
            } else if (f2 >= 270.0f && f2 < 330.0f) {
                nArray[7] = nArray[7] + 1;
            } else {
                nArray[2] = nArray[2] + 1;
            }
        }
        int n7 = -1;
        if (nArray[8] > 0) {
            n7 = 1;
        } else if (nArray[9] > 0) {
            n7 = 0;
        } else if (nArray[2] > 0 || nArray[7] > 0) {
            n7 = 2;
        } else if (nArray[3] > 0) {
            n7 = 5;
        } else if (nArray[4] > 0) {
            n7 = 3;
        } else if (nArray[5] > 0 || nArray[6] > 0) {
            n7 = 4;
        }
        return n7;
    }

    private String b(Color color) {
        return String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
    }

    public void c(Color color) {
        this.nm = color;
        this.cor1 = this.b(color);
    }

    public Color kC() {
        if (this.nn == null) {
            this.nn = new Color(Integer.valueOf(this.cor2.substring(1, 3), 16), Integer.valueOf(this.cor2.substring(3, 5), 16), Integer.valueOf(this.cor2.substring(5, 7), 16));
        }
        return this.nn;
    }

    public void d(Color color) {
        this.nn = color;
        this.cor2 = this.b(color);
    }

    public ArrayList kD() {
        return this.nw;
    }

    public boolean A(ah ah2) {
        return this.nw.contains(ah2);
    }

    public int[] p(at at2) {
        int[] nArray = new int[3];
        int n2 = -1;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        if (at2 != null && (at2.b() == 1 || at2.b() == 3)) {
            s s2 = null;
            if (at2 instanceof B) {
                s2 = ((B)at2).yi();
            } else if (at2 instanceof o) {
                s2 = ((o)at2).yi();
            }
            n2 = s2.P(this);
            n3 = s2.yK().size();
            n4 = s2.getnRebaixados();
            n5 = 4;
            if (at2.b() == 3) {
                n5 = 2;
            }
        }
        if (n2 == -1) {
            nArray[2] = -1;
        } else {
            int n7 = 0;
            n7 = n3 < 20 ? 2 : 4;
            n6 = n2 == 1 ? n2 : (n2 > n3 - n4 ? 5 : (n2 <= n5 ? 2 : (n2 > n3 - (n4 + n7) ? 4 : 3)));
            nArray[0] = n2;
            nArray[1] = n6;
        }
        return nArray;
    }

    public al kE() {
        al al2 = null;
        this.ka().lN();
        al2 = c.a.SR.a(this, 0);
        if (al2 == null) {
            al2 = c.a.SR.a(this, 1);
        }
        if (al2 == null && this.nc <= 3) {
            al2 = c.a.SR.a(this, 2);
        }
        if (al2 == null && this.ka().jZ().booleanValue()) {
            al2 = c.a.SR.a(this, -1);
        }
        if (al2 == null && this.ka().jZ().booleanValue()) {
            al2 = c.a.SR.bh();
        }
        if (al2 == null && !this.ka().jZ().booleanValue()) {
            ArrayList arrayList = c.a.afQ.b(this.ka(), false);
            al al3 = null;
            if (arrayList.size() > 0) {
                al2 = ((ah)arrayList.get(0)).ka();
                al3 = this.ka();
            }
            if (al2 != null && al3 != null && al2 != al3) {
                c.a.SR.a(al2, al3);
            }
        } else if (al2 != null && al2 != this.ka()) {
            c.a.SR.a(this, this.ka(), al2);
        }
        return al2;
    }

    public B kF() {
        Z z2 = c.a.SR.o(this.pais);
        if (z2 != null) {
            int n2 = 0;
            while (n2 < z2.eb().size()) {
                int n3 = 0;
                while (n3 < ((B)z2.eb().get(n2)).yi().yK().size()) {
                    if (((B)z2.eb().get(n2)).yi().yK().get(n3) == this) {
                        return (B)z2.eb().get(n2);
                    }
                    ++n3;
                }
                ++n2;
            }
            if (z2.eb().size() > 0) {
                return (B)z2.eb().get(0);
            }
        }
        return null;
    }

    public void v(int n2, int n3) {
        this.nb += (long)n2;
        if (this.nx != null && this.jZ().booleanValue()) {
            this.nx.h(n2, n3);
        }
    }

    public void w(int n2, int n3) {
        this.nb -= (long)n2;
        if (this.nx != null && this.jZ().booleanValue()) {
            this.nx.i(n2, n3);
        }
    }

    public void f(long l2) {
        this.nb -= l2;
        if (this.nx != null && this.jZ().booleanValue()) {
            this.nx.b(l2);
        }
    }

    public void kG() {
        if (this.pais != 29 && c.a.SR.isJogaEstadual()) {
            this.nb = (long)((double)this.nb + 3.2 * (double)this.kK());
        }
        if (this.divisao >= 0 & this.divisao <= 4) {
            this.v(aq.sD[this.divisao][0], 6);
        }
    }

    public void kH() {
        int n2 = this.divisao;
        this.nb = aq.sC[n2][0];
        if (this.pais != 29 && c.a.SR.isJogaEstadual()) {
            this.nb = (long)((double)this.nb + 3.2 * (double)this.kK());
        }
        this.nx.h(aq.sD[this.divisao][0], 6);
    }

    public void kI() {
        if (this.nx != null) {
            this.nx.eA();
        }
    }

    public void kJ() {
        this.f(this.kK());
    }

    public long kK() {
        long l2 = 0L;
        int n2 = 0;
        while (n2 < this.nd.size()) {
            l2 += (long)((F)this.nd.get(n2)).fj();
            ++n2;
        }
        n2 = 0;
        while (n2 < this.ne.size()) {
            l2 += (long)((F)this.ne.get(n2)).fj();
            ++n2;
        }
        return l2;
    }

    public C kL() {
        return this.nx;
    }

    public void kM() {
        this.nG = this.bU(1);
        this.nH = this.bU(2);
        this.nI = this.bU(3);
    }

    public ImageIcon[] kN() {
        ImageIcon[] imageIconArray = new ImageIcon[]{this.nG, this.nH, this.nI};
        return imageIconArray;
    }

    public ImageIcon bU(int n2) {
        Object object;
        if (n2 < 1 || n2 > 3) {
            return null;
        }
        ImageIcon imageIcon = null;
        if (n2 == 1) {
            imageIcon = this.nG;
        } else if (n2 == 2) {
            imageIcon = this.nH;
        } else if (n2 == 3) {
            imageIcon = this.nI;
        }
        if (imageIcon != null) {
            return imageIcon;
        }
        if (this.mV != null) {
            object = null;
            File file = new File(String.valueOf(System.getProperty("user.dir")) + aq.tw[n2 - 1] + this.mV + ".png");
            if (file.exists() && !file.isDirectory()) {
                try {
                    object = ImageIO.read(new File(String.valueOf(System.getProperty("user.dir")) + aq.tw[n2 - 1] + this.mV + ".png"));
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
                if (object != null) {
                    imageIcon = new ImageIcon((Image)object);
                }
            }
        } else {
            object = ac.valueOf("P" + this.getPais()).jA();
            BufferedImage bufferedImage = null;
            File file = new File(String.valueOf(System.getProperty("user.dir")) + aq.ty[n2 - 1] + (String)object + ".png");
            if (file.exists() && !file.isDirectory()) {
                try {
                    bufferedImage = ImageIO.read(new File(String.valueOf(System.getProperty("user.dir")) + aq.ty[n2 - 1] + (String)object + ".png"));
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
                if (bufferedImage != null) {
                    imageIcon = new ImageIcon(bufferedImage);
                }
            }
        }
        if (imageIcon == null && n2 < 3) {
            int n3 = this.bT(n2);
            if (n3 == 2) {
                imageIcon = new ImageIcon(this.getClass().getResource("/acamisas/vermelho.png"));
            } else if (n3 == 3) {
                imageIcon = new ImageIcon(this.getClass().getResource("/acamisas/verde.png"));
            } else if (n3 == 4) {
                imageIcon = new ImageIcon(this.getClass().getResource("/acamisas/azul.png"));
            } else if (n3 == 5) {
                imageIcon = new ImageIcon(this.getClass().getResource("/acamisas/amarelo.png"));
            } else if (n3 == 0) {
                imageIcon = new ImageIcon(this.getClass().getResource("/acamisas/preto.png"));
            } else if (n3 == 1) {
                imageIcon = new ImageIcon(this.getClass().getResource("/acamisas/branco.png"));
            }
        }
        return imageIcon;
    }

    public int a(BufferedImage bufferedImage) {
        int[] nArray = new int[9];
        int[][] nArray2 = new int[bufferedImage.getWidth()][bufferedImage.getHeight()];
        int n2 = 0;
        while (n2 < bufferedImage.getWidth()) {
            int n3 = 0;
            while (n3 < bufferedImage.getHeight()) {
                int n4 = bufferedImage.getRGB(n2, n3);
                float[] fArray = new float[3];
                int n5 = n4 >> 16 & 0xFF;
                int n6 = n4 >> 8 & 0xFF;
                int n7 = n4 & 0xFF;
                Color.RGBtoHSB(n5, n6, n7, fArray);
                if ((double)fArray[1] < 0.1 && (double)fArray[2] > 0.9) {
                    nArray[0] = nArray[0] + 1;
                } else if ((double)fArray[2] < 0.1) {
                    nArray[1] = nArray[1] + 1;
                } else {
                    float f2 = fArray[0] * 360.0f;
                    if (f2 >= 0.0f && f2 < 30.0f) {
                        nArray[2] = nArray[2] + 1;
                    } else if (f2 >= 30.0f && f2 < 90.0f) {
                        nArray[3] = nArray[3] + 1;
                    } else if (f2 >= 90.0f && f2 < 150.0f) {
                        nArray[4] = nArray[4] + 1;
                    } else if (f2 >= 150.0f && f2 < 210.0f) {
                        nArray[5] = nArray[5] + 1;
                    } else if (f2 >= 210.0f && f2 < 270.0f) {
                        nArray[6] = nArray[6] + 1;
                    } else if (f2 >= 270.0f && f2 < 330.0f) {
                        nArray[7] = nArray[7] + 1;
                    } else {
                        nArray[8] = nArray[8] + 1;
                    }
                }
                ++n3;
            }
            ++n2;
        }
        return -1;
    }

    public String kO() {
        File file = new File(String.valueOf(System.getProperty("user.dir")) + "/teams/escudos/" + this.mV + ".png");
        if (file.exists() && !file.isDirectory()) {
            return file.toString();
        }
        return "";
    }

    public ImageIcon kP() {
        return this.L(false);
    }

    public ImageIcon K(boolean bl2) {
        return this.L(true);
    }

    public ImageIcon L(boolean bl2) {
        if (this.nF != null) {
            return this.nF;
        }
        if (this.mV != null) {
            BufferedImage bufferedImage = null;
            File file = new File(String.valueOf(System.getProperty("user.dir")) + "/teams/escudos/" + this.mV + ".png");
            if (file.exists() && !file.isDirectory()) {
                try {
                    bufferedImage = ImageIO.read(new File(String.valueOf(System.getProperty("user.dir")) + "/teams/escudos/" + this.mV + ".png"));
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
                if (bufferedImage != null) {
                    this.nF = new ImageIcon(bufferedImage);
                }
            }
        } else {
            String string = ac.valueOf("P" + this.getPais()).jA();
            BufferedImage bufferedImage = null;
            File file = new File(String.valueOf(System.getProperty("user.dir")) + "/selecoes/escudos/" + string + ".png");
            if (file.exists() && !file.isDirectory()) {
                try {
                    bufferedImage = ImageIO.read(new File(String.valueOf(System.getProperty("user.dir")) + "/selecoes/escudos/" + string + ".png"));
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
                if (bufferedImage != null) {
                    this.nF = new ImageIcon(bufferedImage);
                }
            } else {
                String string2 = ac.valueOf("P" + this.getPais()).jA();
                ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/aflags/" + this.getPais() + ".png"));
                if (bl2) {
                    imageIcon = new ImageIcon(this.getClass().getResource("/aflagslarge/flag_" + this.getPais() + ".png"));
                }
                this.nF = imageIcon;
            }
        }
        return this.nF;
    }

    private void kQ() {
        if (this.mV != null) {
            BufferedImage bufferedImage = null;
            File file = new File(String.valueOf(System.getProperty("user.dir")) + "/teams/escudosMini/" + this.mV + ".png");
            if (file.exists() && !file.isDirectory()) {
                try {
                    bufferedImage = ImageIO.read(new File(String.valueOf(System.getProperty("user.dir")) + "/teams/escudosMini/" + this.mV + ".png"));
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
                if (bufferedImage != null) {
                    this.nE = new ImageIcon(bufferedImage);
                }
            } else {
                this.kR();
            }
        } else {
            ImageIcon imageIcon;
            String string = ac.valueOf("P" + this.getPais()).jA();
            this.nE = imageIcon = new ImageIcon(this.getClass().getResource("/aflags/" + this.getPais() + ".png"));
        }
    }

    private void kR() {
        ImageIcon imageIcon = this.kP();
        if (imageIcon != null) {
            ImageIcon imageIcon2;
            BufferedImage bufferedImage = new BufferedImage(imageIcon.getIconWidth(), imageIcon.getIconHeight(), 2);
            Graphics2D graphics2D = bufferedImage.createGraphics();
            imageIcon.paintIcon(null, graphics2D, 0, 0);
            graphics2D.dispose();
            BufferedImage bufferedImage2 = new BufferedImage(18, 18, 2);
            Graphics2D graphics2D2 = bufferedImage2.createGraphics();
            graphics2D2.drawImage(bufferedImage, 0, 0, 18, 18, null);
            graphics2D2.setComposite(AlphaComposite.Src);
            this.nE = imageIcon2 = new ImageIcon(bufferedImage2);
        }
    }

    public ImageIcon kS() {
        ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/aicons/camisat.png"));
        ImageIcon imageIcon2 = new ImageIcon(this.getClass().getResource("/aicons/camisar.png"));
        ImageIcon imageIcon3 = imageIcon;
        if (this.nA == 0) {
            imageIcon3 = this.bU(1);
            if (imageIcon3 == null) {
                imageIcon3 = imageIcon;
            }
        } else if (this.nA == 1) {
            imageIcon3 = this.bU(2);
            if (imageIcon3 == null) {
                imageIcon3 = imageIcon2;
            }
        } else if (this.nA == 2 && (imageIcon3 = this.bU(3)) == null) {
            imageIcon3 = imageIcon2;
        }
        return imageIcon3;
    }

    public ImageIcon kT() {
        Image image = this.kS().getImage();
        BufferedImage bufferedImage = new BufferedImage(40, 40, 2);
        Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.drawImage(image, 0, 0, 40, 40, null);
        graphics2D.setComposite(AlphaComposite.Src);
        return new ImageIcon(bufferedImage);
    }

    public ImageIcon x(int n2, int n3) {
        return this.b(n2, n3, false);
    }

    public ImageIcon a(int n2, int n3, boolean bl2) {
        return this.b(n2, n3, bl2);
    }

    public ImageIcon b(int n2, int n3, boolean bl2) {
        ImageIcon imageIcon = this.K(bl2);
        if (imageIcon != null) {
            BufferedImage bufferedImage = new BufferedImage(imageIcon.getIconWidth(), imageIcon.getIconHeight(), 2);
            Graphics2D graphics2D = bufferedImage.createGraphics();
            imageIcon.paintIcon(null, graphics2D, 0, 0);
            graphics2D.dispose();
            BufferedImage bufferedImage2 = new BufferedImage(n2, n3, 2);
            Graphics2D graphics2D2 = bufferedImage2.createGraphics();
            graphics2D2.drawImage(bufferedImage, 0, 0, n2, n3, null);
            graphics2D2.setComposite(AlphaComposite.Src);
            ImageIcon imageIcon2 = new ImageIcon(bufferedImage2);
            return imageIcon2;
        }
        return null;
    }

    public ImageIcon kU() {
        if (this.nE != null) {
            return this.nE;
        }
        this.kQ();
        return this.nE;
    }

    public void b(String string, int n2) {
        if (this.mZ != null) {
            this.mZ.lN();
            this.mZ.n(null);
        }
        al al2 = new al(string);
        al2.cg(n2);
        al2.k(true);
        this.mZ = al2;
        this.na = this.mZ.lT();
        this.mZ.n(this);
        this.mZ.setReputacao(this.nc);
        this.k(true);
        this.ks();
        new as(this.mZ, 0, 73, this.getNome(), "");
        c.a.SR.a(al2);
        c.a.SR.M().add(al2);
        c.a.SR.aN().add(this);
    }

    public ArrayList kV() {
        return this.ny;
    }

    public int kW() {
        return this.nA;
    }

    public void bV(int n2) {
        this.nA = n2;
    }

    public void a(ag ag2) {
        this.nz = ag2;
    }

    public ag kX() {
        return this.nz;
    }

    public ArrayList kY() {
        return this.nf;
    }

    public ArrayList kZ() {
        return this.ng;
    }

    public String toString() {
        return this.getNome();
    }

    public int[] la() {
        return this.nB;
    }

    public int lb() {
        int n2 = 0;
        int n3 = 1;
        while (n3 <= 14) {
            n2 += this.nB[n3];
            ++n3;
        }
        return n2;
    }

    public int[][] lc() {
        return this.nC;
    }

    public int[] ld() {
        int[] nArray = new int[3];
        int n2 = 1;
        while (n2 <= 14) {
            nArray[0] = nArray[0] + this.nC[n2][0];
            nArray[1] = nArray[1] + this.nC[n2][1];
            nArray[2] = nArray[2] + this.nC[n2][2];
            ++n2;
        }
        return nArray;
    }

    public void e(int n2, int n3, int n4) {
        if (n2 <= 14) {
            this.nC[n2][n3] = this.nC[n2][n3] + n4;
        }
    }

    public ArrayList le() {
        return this.np;
    }

    public void q(at at2) {
        ao ao2 = new ao();
        ao2.k(c.a.SR.H());
        ao2.C(this.lk());
        ao2.a(at2.b());
        ao2.m(at2);
        if (at2.b() == 1 || at2.b() == 3) {
            ao2.R(at2.ip());
        } else if (at2.b() == 11) {
            ao2.R(this.pais);
        } else {
            ao2.R(at2.gg());
        }
        this.cA.add(ao2);
    }

    public int lf() {
        return this.nD;
    }

    public void bW(int n2) {
        this.nD = n2;
    }

    public ArrayList cT() {
        return this.cA;
    }

    public void lg() {
        this.nx = new C();
        this.kH();
    }

    public boolean a(F f2, boolean bl2) {
        if (this.nd.size() >= 35) {
            return false;
        }
        if (this.kn() != false ? f2.fi() < aq.qg[this.getDivisao()] : f2.fi() < aq.qh[this.getReputacao()]) {
            return false;
        }
        if (f2.fi() > aq.qi[this.getReputacao()]) {
            return false;
        }
        if (bl2) {
            int[] nArray = this.J(false);
            if (f2.getPosicao() == 0 && nArray[0] > 3) {
                return false;
            }
            if (f2.getPosicao() == 1 && nArray[1] > 5) {
                return false;
            }
            if (f2.getPosicao() == 2 && nArray[2] > 5) {
                return false;
            }
            if (f2.getPosicao() == 3 && nArray[3] > 10) {
                return false;
            }
            if (f2.getPosicao() == 4 && nArray[4] > 5) {
                return false;
            }
        }
        return true;
    }

    public boolean lh() {
        return this.nd.size() >= 35;
    }

    public boolean b(F f2, boolean bl2) {
        if (this.nd.size() >= 35) {
            return false;
        }
        return !(this.kn() != false ? f2.fi() < aq.qg[this.getDivisao()] : f2.fi() < aq.qh[this.getReputacao()]);
    }

    public int li() {
        return this.nl;
    }

    public void S(ArrayList arrayList) {
        this.ne = arrayList;
    }

    public int gD() {
        return this.ei;
    }

    public void az(int n2) {
        this.ei = n2;
    }

    public void a(components.ah ah2, at at2) {
        int n2 = 0;
        while (n2 < this.no.size()) {
            if (((ak)this.no.get(n2)).lC().equals(at2)) {
                ((ak)this.no.get(n2)).a(ah2);
            }
            ++n2;
        }
    }

    public void lj() {
        int n2 = 0;
        while (n2 < 5) {
            this.u(n2, 1 + new Random().nextInt(3));
            ++n2;
        }
    }

    public int lk() {
        return this.mU;
    }

    public void bX(int n2) {
        this.mU = n2;
    }

    public boolean bY(int n2) {
        int n3 = 0;
        while (n3 < c.a.SR.R().size()) {
            if (((a)c.a.SR.R().get(n3)).a().get(2) == n2 && ((a)c.a.SR.R().get(n3)).a(this)) {
                return true;
            }
            ++n3;
        }
        return false;
    }

    public boolean ll() {
        return this.nt;
    }

    public void M(boolean bl2) {
        this.nt = bl2;
    }

    public int lm() {
        return this.ns;
    }

    public void bZ(int n2) {
        this.ns = n2;
    }

    public void ln() {
        if (this.nm != null) {
            String string;
            this.cor1 = string = String.format("#%02x%02x%02x", this.nm.getRed(), this.nm.getGreen(), this.nm.getBlue());
        }
    }

    public void lo() {
        if (this.nn != null) {
            String string;
            this.cor2 = string = String.format("#%02x%02x%02x", this.nn.getRed(), this.nn.getGreen(), this.nn.getBlue());
        }
    }

    public boolean lp() {
        int n2 = 0;
        while (n2 < c.a.SR.aG().size()) {
            if (((Z)c.a.SR.aG().get(n2)).jn() == this) {
                return true;
            }
            ++n2;
        }
        return false;
    }

    public F lq() {
        if (this.nj != null && this.nj.fg() != this) {
            if (!this.lp()) {
                this.nj = null;
            } else if (!this.kc().contains(this.nj)) {
                this.nj = null;
            }
        }
        return this.nj;
    }

    public void n(F f2) {
        this.nj = f2;
    }

    public F lr() {
        if (this.nk != null && this.nk.fg() != this) {
            if (!this.lp()) {
                this.nk = null;
            } else if (!this.kc().contains(this.nk)) {
                this.nk = null;
            }
        }
        return this.nk;
    }

    public void o(F f2) {
        this.nk = f2;
    }

    public int Au() {
        return this.Kb;
    }

    public void fr(int n2) {
        this.Kb = n2;
    }
}

