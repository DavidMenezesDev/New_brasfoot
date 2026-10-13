/*
 * Decompiled with CFR 0.152.
 */
package best;

import best.F;
import best.I;
import best.Z;
import best.a;
import best.ah;
import best.ao;
import best.aq;
import best.at;
import best.j;
import best.u;
import components.as;
import f.s;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class al
implements Serializable {
    private static final long serialVersionUID = 1L;
    private String dm;
    private Boolean mW = false;
    private int nU = -1;
    private transient ah nV = null;
    private transient ah nW = null;
    private int bW = -1;
    private int nX = -1;
    private int nY = 0;
    private int bf = -1;
    private int nZ;
    private ah hy = null;
    private int oa = 1;
    private ArrayList ob = new ArrayList();
    private int oc;
    private int W;
    private int od;
    private int oe;
    private int of = 95;
    private int og = 85;
    private int nc = 0;
    private int nu = 0;
    private ArrayList cA = new ArrayList();
    private ArrayList oh = null;
    private int oi = 0;
    private int bZ = 0;

    public al() {
    }

    public al(String string) {
        this.dm = string;
        this.nU = c.a.SR.bU();
    }

    public Boolean jZ() {
        return this.mW;
    }

    public void k(Boolean bl2) {
        this.mW = bl2;
    }

    public ah fg() {
        ah ah2 = this.nV;
        if (ah2 == null && this.bW >= 0) {
            this.nV = ah2 = c.a.SR.x(this.bW);
            return ah2;
        }
        if (this.bW == -1) {
            return null;
        }
        return ah2;
    }

    public void n(ah ah2) {
        this.nV = ah2;
        this.bW = ah2 != null ? ah2.lk() : -1;
    }

    public int lE() {
        return this.nZ;
    }

    public void cg(int n2) {
        this.nZ = n2;
    }

    public ah lF() {
        ah ah2 = this.nW;
        if (ah2 == null && this.nX >= 0) {
            this.nW = ah2 = c.a.SR.x(this.nX);
            return ah2;
        }
        if (this.nX == -1) {
            return null;
        }
        return ah2;
    }

    public void B(ah ah2) {
        this.nW = ah2;
        this.nX = ah2 != null ? ah2.lk() : -1;
    }

    public int lG() {
        return this.nY;
    }

    public void ch(int n2) {
        this.nY = n2;
    }

    public int lH() {
        return this.oa;
    }

    public void ci(int n2) {
        this.oa = n2;
    }

    public j C(ah ah2) {
        int n2 = 0;
        while (n2 < this.ob.size()) {
            try {
                if (((j)this.ob.get(n2)).ct() == ah2.lk() && ((j)this.ob.get(n2)).H() == c.a.SR.H()) {
                    return (j)this.ob.get(n2);
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
            ++n2;
        }
        j j2 = new j(ah2);
        this.ob.add(j2);
        return j2;
    }

    public void cj(int n2) {
        this.of += n2;
        if (this.of > 100) {
            this.of = 100;
        } else if (this.of < 0) {
            this.of = 0;
        }
    }

    public void ck(int n2) {
        this.og += n2;
        if (this.og > 100) {
            this.og = 100;
        } else if (this.og < 0) {
            this.og = 0;
        }
    }

    public void a(I i2, boolean bl2, int n2) {
        int n3 = 0;
        int n4 = 0;
        boolean bl3 = false;
        boolean bl4 = false;
        boolean bl5 = false;
        boolean bl6 = false;
        boolean bl7 = false;
        int n5 = 0;
        int n6 = 0;
        int[] nArray = new int[3];
        int n7 = 0;
        if (i2.hy() != null) {
            n7 = i2.hy().b();
        }
        if (i2.hc() == this.fg()) {
            n3 = i2.hu();
            n4 = i2.hw();
            if (i2.hc().A(i2.hd())) {
                bl7 = true;
            }
            n6 = i2.hc().getNivel() - i2.hd().getNivel();
            if (!bl2) {
                nArray = i2.hc().p(i2.hy());
            }
        } else if (i2.hd() == this.fg()) {
            n3 = i2.hw();
            n4 = i2.hu();
            bl5 = true;
            if (i2.hd().A(i2.hc())) {
                bl7 = true;
            }
            n6 = i2.hd().getNivel() - i2.hc().getNivel();
            if (!bl2) {
                nArray = i2.hd().p(i2.hy());
            }
        }
        if (bl2) {
            nArray[2] = -1;
        }
        if (n3 != n4) {
            if (n3 > n4) {
                n5 = 1;
                if (n3 - n4 >= 3) {
                    bl6 = true;
                }
            } else if (n3 < n4) {
                n5 = 2;
                if (n4 - n3 >= 3) {
                    bl6 = true;
                }
            }
        } else {
            n5 = 0;
        }
        if (n5 == 0) {
            if (n6 >= 0 && !bl5) {
                this.cj(-1);
                this.ck(-1);
            } else if (n6 < 0) {
                this.cj(1);
            }
        } else if (n5 != 1) {
            if (n6 >= 0 && !bl5) {
                this.cj(-3);
                this.ck(-3);
            } else if (n6 >= 0 && bl5) {
                this.cj(-1);
            }
        }
        boolean bl8 = false;
        int n8 = 2;
        if (n7 == 1 || n7 == 3) {
            n8 = nArray[1];
        }
        if (nArray[2] == -1 || bl2) {
            bl8 = true;
        }
        int[] nArray2 = new int[6];
        int[] nArray3 = new int[6];
        int[] nArray4 = new int[6];
        int[] nArray5 = new int[6];
        int[] nArray6 = new int[6];
        int[] nArray7 = new int[6];
        if (bl8 & !i2.hS()) {
            bl8 = false;
            n8 = 1;
        } else if (n2 >= 1) {
            n5 = n2;
            bl8 = false;
            n8 = 1;
        }
        if (!bl8) {
            if (n7 == 1) {
                if (this.jZ().booleanValue() && this.fg() != null && this.fg().kb() < 0L) {
                    this.cj(-10);
                }
                int[] nArray8 = new int[6];
                nArray8[1] = 5;
                nArray8[2] = 4;
                nArray8[3] = 1;
                nArray8[4] = 1;
                int[] nArray9 = nArray8;
                int[] nArray10 = new int[6];
                nArray10[1] = 6;
                nArray10[2] = 5;
                nArray10[3] = 2;
                nArray10[4] = 2;
                nArray10[5] = 1;
                int[] nArray11 = nArray10;
                int[] nArray12 = new int[6];
                nArray12[1] = 2;
                nArray12[2] = 1;
                nArray12[3] = -1;
                nArray12[4] = -1;
                nArray12[5] = -3;
                int[] nArray13 = nArray12;
                int[] nArray14 = new int[6];
                nArray14[1] = 2;
                nArray14[2] = 1;
                nArray14[4] = -1;
                nArray14[5] = -2;
                int[] nArray15 = nArray14;
                int[] nArray16 = new int[6];
                nArray16[1] = -2;
                nArray16[2] = -2;
                nArray16[3] = -3;
                nArray16[4] = -5;
                nArray16[5] = -7;
                int[] nArray17 = nArray16;
                int[] nArray18 = new int[6];
                nArray18[1] = -1;
                nArray18[2] = -1;
                nArray18[3] = -2;
                nArray18[4] = -4;
                nArray18[5] = -5;
                int[] nArray19 = nArray18;
                nArray2 = nArray9;
                nArray3 = nArray13;
                nArray4 = nArray17;
                nArray5 = nArray11;
                nArray6 = nArray15;
                nArray7 = nArray19;
            } else if (n7 == 3 || n7 == 10) {
                if (this.jZ().booleanValue() && this.fg() != null && this.fg().kb() < 0L) {
                    this.cj(-5);
                }
                int[] nArray20 = new int[6];
                nArray20[1] = 2;
                nArray20[2] = 2;
                nArray20[3] = 1;
                nArray20[4] = 1;
                nArray20[5] = 1;
                int[] nArray21 = nArray20;
                int[] nArray22 = new int[6];
                nArray22[1] = 3;
                nArray22[2] = 2;
                nArray22[3] = 2;
                nArray22[4] = 2;
                nArray22[5] = 1;
                int[] nArray23 = nArray22;
                int[] nArray24 = new int[6];
                nArray24[1] = 1;
                nArray24[2] = 1;
                nArray24[5] = -1;
                int[] nArray25 = nArray24;
                int[] nArray26 = new int[6];
                nArray26[1] = 1;
                nArray26[2] = 1;
                nArray26[3] = 1;
                nArray26[5] = -1;
                int[] nArray27 = nArray26;
                int[] nArray28 = new int[6];
                nArray28[1] = -2;
                nArray28[2] = -2;
                nArray28[3] = -3;
                nArray28[4] = -3;
                nArray28[5] = -5;
                int[] nArray29 = nArray28;
                int[] nArray30 = new int[6];
                nArray30[1] = -1;
                nArray30[2] = -1;
                nArray30[3] = -2;
                nArray30[4] = -2;
                nArray30[5] = -3;
                int[] nArray31 = nArray30;
                nArray2 = nArray21;
                nArray3 = nArray25;
                nArray4 = nArray29;
                nArray5 = nArray23;
                nArray6 = nArray27;
                nArray7 = nArray31;
            } else if (n7 == 4 || n7 == 6) {
                if (this.jZ().booleanValue() && this.fg() != null && this.fg().kb() < 0L) {
                    this.cj(-5);
                }
                int[] nArray32 = new int[6];
                nArray32[1] = 5;
                nArray32[2] = 4;
                nArray32[3] = 3;
                nArray32[4] = 3;
                nArray32[5] = 3;
                int[] nArray33 = nArray32;
                int[] nArray34 = new int[6];
                nArray34[1] = 7;
                nArray34[2] = 6;
                nArray34[3] = 4;
                nArray34[4] = 4;
                nArray34[5] = 5;
                int[] nArray35 = nArray34;
                int[] nArray36 = new int[6];
                nArray36[1] = 2;
                nArray36[2] = 1;
                nArray36[4] = -1;
                nArray36[5] = -3;
                int[] nArray37 = nArray36;
                int[] nArray38 = new int[6];
                nArray38[1] = 2;
                nArray38[2] = 1;
                nArray38[5] = -2;
                int[] nArray39 = nArray38;
                int[] nArray40 = new int[6];
                nArray40[1] = -2;
                nArray40[2] = -2;
                nArray40[3] = -3;
                nArray40[4] = -3;
                nArray40[5] = -5;
                int[] nArray41 = nArray40;
                int[] nArray42 = new int[6];
                nArray42[1] = -1;
                nArray42[2] = -1;
                nArray42[3] = -2;
                nArray42[4] = -2;
                nArray42[5] = -3;
                int[] nArray43 = nArray42;
                nArray2 = nArray33;
                nArray3 = nArray37;
                nArray4 = nArray41;
                nArray5 = nArray35;
                nArray6 = nArray39;
                nArray7 = nArray43;
            } else {
                if (this.jZ().booleanValue() && this.fg() != null && this.fg().kb() < 0L) {
                    this.cj(-5);
                }
                int[] nArray44 = new int[6];
                nArray44[1] = 5;
                nArray44[2] = 4;
                nArray44[3] = 1;
                nArray44[4] = 1;
                int[] nArray45 = nArray44;
                int[] nArray46 = new int[6];
                nArray46[1] = 6;
                nArray46[2] = 5;
                nArray46[3] = 2;
                nArray46[4] = 2;
                nArray46[5] = 1;
                int[] nArray47 = nArray46;
                int[] nArray48 = new int[6];
                nArray48[1] = 2;
                nArray48[2] = 1;
                nArray48[3] = -1;
                nArray48[4] = -1;
                nArray48[5] = -3;
                int[] nArray49 = nArray48;
                int[] nArray50 = new int[6];
                nArray50[1] = 2;
                nArray50[2] = 1;
                nArray50[4] = -1;
                nArray50[5] = -2;
                int[] nArray51 = nArray50;
                int[] nArray52 = new int[6];
                nArray52[1] = -2;
                nArray52[2] = -2;
                nArray52[3] = -3;
                nArray52[4] = -5;
                nArray52[5] = -7;
                int[] nArray53 = nArray52;
                int[] nArray54 = new int[6];
                nArray54[1] = -1;
                nArray54[2] = -1;
                nArray54[3] = -2;
                nArray54[4] = -4;
                nArray54[5] = -5;
                int[] nArray55 = nArray54;
                nArray2 = nArray45;
                nArray3 = nArray49;
                nArray4 = nArray53;
                nArray5 = nArray47;
                nArray6 = nArray51;
                nArray7 = nArray55;
            }
        }
        if (n5 == 0) {
            if (bl5) {
                this.cj(nArray6[n8]);
            } else {
                this.cj(nArray3[n8]);
            }
        } else if (n5 == 1) {
            if (bl5) {
                this.cj(nArray5[n8]);
            } else {
                this.cj(nArray2[n8]);
            }
        } else if (n5 == 2) {
            if (bl5) {
                this.cj(nArray7[n8]);
            } else {
                this.cj(nArray4[n8]);
            }
        }
        if (n5 == 0) {
            if (bl5) {
                this.ck(1);
            } else {
                this.ck(-1);
            }
        } else if (n5 == 1) {
            if (bl5) {
                this.ck(4);
            } else {
                this.ck(3);
            }
            if (bl6) {
                if (this.jZ().booleanValue() && i2.ic() && !bl2) {
                    new as(this, 27, 81, "", "");
                }
                if (bl5) {
                    this.ck(5);
                } else {
                    this.ck(4);
                }
            }
        } else if (n5 == 2) {
            if (bl5) {
                this.ck(-4);
            } else {
                this.ck(-5);
            }
            if (bl6) {
                if (i2.ic()) {
                    if (this.jZ().booleanValue() && !bl2) {
                        new as(this, 6, 46, "", "");
                    }
                } else if (!bl5 && this.jZ().booleanValue() && !bl2) {
                    new as(this, 5, 47 + new Random().nextInt(2), "", "");
                }
                if (bl5) {
                    this.ck(-5);
                } else {
                    this.ck(-7);
                }
            }
        }
        if (this.og < 20) {
            this.cj(-3);
        }
        if (this.of < 0) {
            this.of = 0;
        } else if (this.of > 100) {
            this.of = 100;
        }
        if (this.og < 0) {
            this.og = 0;
        } else if (this.og > 100) {
            this.og = 100;
        }
    }

    public void D(ah ah2) {
        j j2 = this.C(ah2);
        j2.cs();
        ++this.bZ;
    }

    public void e(I i2) {
        int n2 = 0;
        int n3 = 0;
        boolean bl2 = false;
        ah ah2 = null;
        if (i2.hc() == this.fg()) {
            n2 = i2.hu();
            n3 = i2.hw();
            ah2 = this.fg();
        } else if (i2.hd() == this.fg()) {
            n2 = i2.hw();
            n3 = i2.hu();
            bl2 = true;
            ah2 = this.fg();
        } else if (i2.hc() == this.hy) {
            n2 = i2.hu();
            n3 = i2.hw();
            ah2 = this.hy;
        } else if (i2.hd() == this.hy) {
            n2 = i2.hw();
            n3 = i2.hu();
            ah2 = this.hy;
            bl2 = true;
        }
        int n4 = 0;
        int n5 = 0;
        boolean bl3 = false;
        if (i2.hy() != null && ((n4 = i2.hy().b()) == 1 || n4 == 3)) {
            n5 = i2.hy().ip();
        }
        int n6 = 0;
        j j2 = this.C(ah2);
        j2.cl();
        ++this.W;
        if (n2 > n3) {
            j2.cn();
            ++this.od;
            if (n4 == 1) {
                n6 = n5 == 1 ? 4 : (n5 == 2 ? 3 : (n5 == 3 ? 2 : 1));
            } else if (n4 == 2) {
                n6 = 4;
            } else if (n4 == 3) {
                n6 = bl3 ? 2 : 1;
            } else if (n4 == 4) {
                n6 = 5;
            } else if (n4 == 5) {
                n6 = 7;
            } else if (n4 == 6) {
                n6 = 4;
            } else if (n4 == 7) {
                n6 = 8;
            } else if (n4 == 8) {
                n6 = 4;
            } else if (n4 == 10) {
                n6 = 2;
            } else if (n4 == 11) {
                n6 = 2;
            } else if (n4 == 12) {
                n6 = 3;
            } else if (n4 == 9) {
                n6 = 2;
            } else if (n4 == 13) {
                n6 = 5;
            } else if (n4 == 14) {
                n6 = 6;
            }
            if (bl2 && n4 != 7 && n4 != 5) {
                ++n6;
            }
            if (n6 > 0) {
                j2.B(n6);
            }
        } else if (n2 < n3) {
            j2.cp();
            ++this.oe;
        } else if (n2 == n3) {
            if (bl2 && n4 != 7 && n4 != 5) {
                ++n6;
            }
            if (n4 == 1) {
                if (n5 == 1) {
                    n6 = 2;
                } else if (n5 == 2) {
                    n6 = 1;
                }
            } else if (n4 == 2) {
                n6 = 1;
            } else if (n4 == 4) {
                n6 = 2;
            } else if (n4 == 5) {
                n6 = 2;
            } else if (n4 == 6) {
                n6 = 2;
            } else if (n4 == 7) {
                n6 = 2;
            } else if (n4 == 8) {
                n6 = 2;
            } else if (n4 == 11) {
                n6 = 2;
            } else if (n4 == 8) {
                n6 = 4;
            } else if (n4 == 10) {
                n6 = 1;
            } else if (n4 == 11) {
                n6 = 1;
            } else if (n4 == 12) {
                n6 = 1;
            } else if (n4 == 9) {
                n6 = 1;
            } else if (n4 == 13) {
                n6 = 2;
            } else if (n4 == 14) {
                n6 = 2;
            }
            if (n6 > 0) {
                j2.B(n6);
            }
        }
        if (n6 > 0) {
            this.oc += n6;
        }
    }

    public int lI() {
        return this.oc;
    }

    public int A() {
        return this.W;
    }

    public int lJ() {
        return this.od;
    }

    public int lK() {
        return this.oe;
    }

    public int lL() {
        return this.of;
    }

    public void cl(int n2) {
        this.of = n2;
    }

    public int lM() {
        return this.og;
    }

    public void cm(int n2) {
        this.og = n2;
    }

    public int getReputacao() {
        return this.nc;
    }

    public void setReputacao(int n2) {
        this.nc = n2;
    }

    public void g(s s2) {
    }

    public int bz() {
        return this.bf;
    }

    public void v(int n2) {
        this.bf = n2;
    }

    public void lN() {
        this.B(this.fg());
        this.bf = this.fg().getPais();
        this.nY = this.fg().getDivisao() - 1;
    }

    public void b(ah ah2, F f2) {
        if (ah2 != null) {
            this.v(ah2.getPais());
        }
        this.cg(f2.getPais());
        if (ah2 != null) {
            this.ch(ah2.getDivisao() - 1);
        }
        if (ah2 != null) {
            this.setReputacao(ah2.getReputacao());
        }
        this.ci(c.a.SR.H());
    }

    public void i(al al2) {
        u u2 = new u();
        u2.c(this);
        u2.d(al2);
        Calendar calendar = ((a)c.a.SR.R().get(c.a.SR.J())).a();
        u2.a().set(calendar.get(1), calendar.get(2), calendar.get(5));
        if (this.fg() != null) {
            u2.C(this.fg().lk());
        }
        c.a.SR.bn().add(u2);
        this.lN();
        if (this.jZ().booleanValue()) {
            if (this.fg().getPais() == 29) {
                c.a.SR.u(this.fg().getEstado());
            }
            c.a.SR.v(this.fg().getPais());
            this.fg().k(false);
            this.fg().lg();
            this.fg().M(true);
            c.a.SR.aN().remove(this.fg());
            this.T(null);
        }
        if (this.fg() != null && this.fg().kL() != null) {
            this.fg().kL().V(0);
        }
        this.fg().h(null);
        this.n(null);
    }

    public void E(ah ah2) {
        ah2.h(this);
        this.n(ah2);
        this.of = 95;
        this.og = 85;
        this.oi = 0;
        ah2.lg();
        if (this.jZ().booleanValue()) {
            ah2.k(true);
            c.a.SR.aN().add(ah2);
            ah2.ks();
            new as(this, 0, 74, ah2.getNome(), "");
            if (ah2.ev() != null) {
                ah2.ev().i(ah2);
            }
            int n2 = 0;
            while (n2 < ah2.kc().size()) {
                ((F)ah2.kc().get(n2)).a(180L, true);
                ++n2;
            }
        }
    }

    public String dS() {
        return this.dm;
    }

    public ArrayList lO() {
        return this.ob;
    }

    public void b(at at2, int n2, int n3) {
        int[] nArray;
        int n4 = at2.b();
        int[][] nArrayArray = new int[16][];
        nArrayArray[0] = new int[11];
        int[] nArray2 = new int[11];
        nArray2[1] = 25;
        nArray2[2] = 10;
        nArray2[3] = 8;
        nArray2[4] = 7;
        nArray2[5] = 6;
        nArray2[6] = 5;
        nArray2[7] = 4;
        nArray2[8] = 3;
        nArray2[9] = 2;
        nArray2[10] = 1;
        nArrayArray[1] = nArray2;
        int[] nArray3 = new int[11];
        nArray3[1] = 20;
        nArray3[2] = 7;
        nArray3[3] = 3;
        nArray3[4] = 3;
        nArrayArray[2] = nArray3;
        int[] nArray4 = new int[11];
        nArray4[1] = 15;
        nArray4[2] = 3;
        nArrayArray[3] = nArray4;
        int[] nArray5 = new int[11];
        nArray5[1] = 30;
        nArray5[2] = 15;
        nArray5[3] = 7;
        nArray5[4] = 7;
        nArrayArray[4] = nArray5;
        int[] nArray6 = new int[11];
        nArray6[1] = 25;
        nArray6[2] = 5;
        nArrayArray[5] = nArray6;
        int[] nArray7 = new int[11];
        nArray7[1] = 20;
        nArray7[2] = 10;
        nArray7[3] = 5;
        nArray7[4] = 5;
        nArrayArray[6] = nArray7;
        int[] nArray8 = new int[11];
        nArray8[1] = 35;
        nArray8[2] = 20;
        nArray8[3] = 10;
        nArray8[4] = 5;
        nArrayArray[7] = nArray8;
        int[] nArray9 = new int[11];
        nArray9[1] = 3;
        nArrayArray[8] = nArray9;
        nArrayArray[9] = new int[11];
        int[] nArray10 = new int[11];
        nArray10[1] = 5;
        nArray10[2] = 3;
        nArrayArray[10] = nArray10;
        int[] nArray11 = new int[11];
        nArray11[1] = 2;
        nArrayArray[11] = nArray11;
        int[] nArray12 = new int[11];
        nArray12[1] = 18;
        nArray12[2] = 8;
        nArray12[3] = 4;
        nArray12[4] = 4;
        nArrayArray[12] = nArray12;
        int[] nArray13 = new int[11];
        nArray13[1] = 20;
        nArray13[2] = 10;
        nArrayArray[13] = nArray13;
        int[] nArray14 = new int[11];
        nArray14[1] = 25;
        nArray14[2] = 15;
        nArray14[3] = 7;
        nArray14[4] = 3;
        nArrayArray[14] = nArray14;
        nArrayArray[15] = new int[11];
        int[][] nArrayArray2 = nArrayArray;
        int[] nArray15 = nArrayArray2[n4];
        if (n4 == 1 && at2.ip() > 1) {
            if (at2.ip() == 2) {
                int[] nArray16 = new int[11];
                nArray16[1] = 5;
                nArray16[2] = 3;
                nArray16[3] = 2;
                nArray16[4] = 1;
                nArray = nArray16;
                nArray15 = nArray;
            } else {
                int[] nArray17 = new int[11];
                nArray17[1] = 2;
                nArray17[2] = 1;
                nArray = nArray17;
                nArray15 = nArray;
            }
        }
        if (n4 == 3 && at2.ip() > 1) {
            nArray = new int[11];
            nArray15 = nArray;
        }
        if (n4 == 7 && at2.gg() != 7) {
            int[] nArray18 = new int[11];
            nArray18[1] = 25;
            nArray18[2] = 15;
            nArray18[3] = 5;
            nArray18[4] = 3;
            nArray = nArray18;
            nArray15 = nArray;
        }
        if (n4 <= 14 && n2 >= 0 && n2 < nArray15.length) {
            this.oc += nArray15[n2];
        }
        if (n2 == 1) {
            if (aq.fs(n4)) {
                this.D(this.hy);
            } else {
                this.D(this.fg());
            }
            this.q(at2);
        }
    }

    public void fh() {
        if (this.nV != null) {
            this.bW = this.nV.lk();
        }
    }

    private void q(at at2) {
        int n2 = at2.b();
        int n3 = -1;
        ao ao2 = new ao();
        ao2.k(c.a.SR.H());
        if (n2 == 7) {
            if (this.jo() != null) {
                ao2.C(this.jo().lk());
            }
        } else if (this.fg() != null) {
            ao2.C(this.fg().lk());
        }
        ao2.a(at2.b());
        ao2.m(at2);
        if (at2.b() == 1 || at2.b() == 3) {
            n3 = at2.ip();
            ao2.R(n3);
            if (n3 == 1) {
                this.ck(20);
                this.cj(15);
                if (n2 == 1) {
                    this.ck(20);
                    this.cj(15);
                }
            } else {
                this.ck(20);
                this.cj(10);
            }
        } else if (at2.b() == 11) {
            if (this.fg() != null) {
                ao2.R(this.fg().getPais());
            }
            this.ck(10);
        } else {
            ao2.R(at2.gg());
            if (n2 == 2) {
                this.ck(30);
                this.cj(30);
            } else if (n2 == 4) {
                this.ck(30);
                this.cj(30);
            } else if (n2 == 5) {
                this.ck(30);
                this.cj(30);
            } else if (n2 == 6 || n2 == 12) {
                this.ck(30);
                this.cj(30);
            }
        }
        this.cA.add(ao2);
        if (this.jZ().booleanValue() && this.fg() != null) {
            String string = "";
            if (n2 == 4) {
                if (this.fg().gg() == 0) {
                    string = " da Liga dos Campe\u00f5es";
                } else if (this.fg().gg() == 1) {
                    string = " da Libertadores";
                } else if (this.fg().gg() == 2) {
                    string = " da Liga dos Campe\u00f5es da \u00c1frica";
                } else if (this.fg().gg() == 3) {
                    string = " da Liga dos Campe\u00f5es da \u00c1sia";
                } else if (this.fg().gg() == 4) {
                    string = " da Liga dos Campe\u00f5es da Concacaf";
                } else if (this.fg().gg() == 5) {
                    string = " da Liga dos Campe\u00f5es da Oceania";
                }
                new as(this, 25, 76, "", string);
            } else if (n2 == 1 || n2 == 2 || n2 == 6) {
                new as(this, 24, 77, "", "");
            } else if (n2 == 5) {
                new as(this, 25, 78, "", "");
            }
        }
    }

    public ArrayList cT() {
        return this.cA;
    }

    public ah jo() {
        return this.hy;
    }

    public void z(ah ah2) {
        this.hy = ah2;
    }

    public void lP() {
        c.a.SR.bu().add(this);
        c.a.SR.M().remove(this);
        c.a.SR.L().remove(this);
    }

    public static void c(String string, int n2) {
        Z z2;
        al al2 = new al(string);
        al2.cg(n2);
        al2.setReputacao(3);
        if (!c.a.SR.bD()) {
            al2.k(true);
        }
        if ((z2 = c.a.SR.o(n2)) == null) {
            z2 = (Z)c.a.SR.N().get(0);
        }
        al2.v(z2.jc());
        al2.ch(z2.eb().size() - 1);
        c.a.SR.a(al2);
        if (!c.a.SR.bD()) {
            c.a.SR.M().add(al2);
        }
    }

    public void i(String string) {
        this.dm = string;
    }

    public ArrayList lQ() {
        return this.oh;
    }

    public void T(ArrayList arrayList) {
        this.oh = arrayList;
    }

    public int lR() {
        return this.oi;
    }

    public void cn(int n2) {
        this.oi = n2;
    }

    public void lS() {
        ++this.oi;
    }

    public int lT() {
        return this.nU;
    }

    public int cr() {
        return this.bZ;
    }

    public void a(int n2, int n3, int n4, boolean bl2, int n5) {
        int[][] nArrayArray = new int[2][];
        int[] nArray = new int[15];
        nArray[1] = 600;
        nArray[2] = 500;
        nArray[3] = 30;
        nArray[4] = 6000;
        nArray[5] = 10000;
        nArray[6] = 2000;
        nArray[8] = 500;
        nArray[10] = 50;
        nArray[11] = 100;
        nArray[12] = 3000;
        nArray[13] = 3000;
        nArray[14] = 20000;
        nArrayArray[0] = nArray;
        int[] nArray2 = new int[15];
        nArray2[1] = 150;
        nArray2[2] = 150;
        nArray2[3] = 5;
        nArray2[4] = 1000;
        nArray2[5] = 1000;
        nArray2[6] = 500;
        nArray2[7] = 2000;
        nArray2[12] = 300;
        nArray2[13] = 500;
        nArrayArray[1] = nArray2;
        int[][] nArrayArray2 = nArrayArray;
        int n6 = 0;
        if (n2 < nArrayArray2.length && n3 < nArrayArray2[0].length) {
            n6 = nArrayArray2[n2][n3];
        }
        if (n6 > 1000 & !bl2 && n5 > 1) {
            n6 = (int)Math.round((double)n6 * 0.6);
        }
        if (n3 == 1 && n4 > 1) {
            n6 = 50;
        }
        if (n3 == 7) {
            n6 = n4 == 7 && n2 == 0 ? 23000 : 6000;
        }
        this.nu += n6;
    }

    public void kk() {
        int n2 = 0;
        if (this.nc == 5) {
            this.nu -= 6000;
            if (this.nu < -20000) {
                this.nc = 4;
                this.nu = 0;
            }
        } else if (this.nc == 4) {
            this.nu -= 600;
            if (this.nu < -3000) {
                this.nc = 3;
                this.nu = 0;
            }
        } else if (this.nc == 3 && this.Av()) {
            this.nu -= 50;
            if (this.nu < -500) {
                this.nc = 2;
                this.nu = 0;
            }
        } else if (this.nc == 2 && this.Av()) {
            this.nu -= 5;
            if (this.nu < -50) {
                this.nc = 1;
                this.nu = 0;
            }
        }
        if (this.nu > 22000) {
            n2 = 5;
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

    public boolean Av() {
        if (this.fg() != null) {
            return this.fg().kn();
        }
        return false;
    }
}

