/*
 * Decompiled with CFR 0.152.
 */
package f;

import best.C;
import best.I;
import best.L;
import best.ah;
import best.al;
import best.aq;
import best.at;
import best.i;
import c.a;
import components.as;
import f.B;
import f.f;
import f.z;
import java.io.Serializable;
import java.util.ArrayList;

public class G
implements Serializable {
    private static final long serialVersionUID = 1L;
    z aae;
    private int oj;
    private int w;
    private int aaf;
    boolean gj;
    boolean aag = false;
    private ArrayList as = new ArrayList();
    private ArrayList aai = new ArrayList();
    private ArrayList aaj = new ArrayList();
    private ArrayList aak = new ArrayList();
    private transient ArrayList aal = new ArrayList();
    int aam;
    int aan;
    int var0 = -1;

    public void a(z z2, ArrayList arrayList, int n2, boolean bl2, int n3, int n4, int n5, boolean bl3) {
        this.b(z2, arrayList, n2, bl2, n3, n4, n5, bl3);
    }

    public void b(z z2, ArrayList arrayList, int n2, boolean bl2, int n3, int n4, int n5, boolean bl3) {
        ArrayList arrayList2;
        at at2;
        this.w = n5;
        this.e(z2);
        this.fk(arrayList.size());
        this.oj = n2;
        this.aag = bl3;
        this.s(bl2);
        this.fl(this.c(this.w, this.oj, true));
        this.fm(n4);
        at at3 = null;
        at3 = z2.yT();
        ArrayList arrayList3 = new ArrayList();
        boolean bl4 = false;
        if (z2 != null && z2.zf() == 14006) {
            bl4 = true;
        }
        arrayList3 = best.a.a(n5, bl4);
        int n6 = 0;
        while (n6 < arrayList.size()) {
            this.aai.add(new I(z2, n2, (ah)arrayList.get(n6), (ah)arrayList.get(n6 + 1), (Integer)arrayList3.get(0), at3, null));
            n6 += 2;
        }
        this.eZ((Integer)arrayList3.get(0));
        if (bl2) {
            n6 = 0;
            while (n6 < arrayList.size()) {
                this.aaj.add(new I(z2, n2, (ah)arrayList.get(n6 + 1), (ah)arrayList.get(n6), (Integer)arrayList3.get(1), at3, null));
                n6 += 2;
            }
            this.eZ((Integer)arrayList3.get(1));
        }
        z2.zp().add(this);
        if (this.aai.size() == 1 && this.aae != null && (at2 = this.aae.yT()) != null && at2.mq() && (arrayList2 = this.aae.zt()).size() == 2) {
            this.aai.add(new I(z2, n2, (ah)arrayList2.get(0), (ah)arrayList2.get(1), (Integer)arrayList3.get(0), at3, null));
        }
    }

    public z zT() {
        return this.aae;
    }

    public int[] o(I i2) {
        int[] nArray = new int[]{-1, -1};
        if (this.aaj != null && this.aaj.size() > 0) {
            int n2 = 0;
            while (n2 < this.aaj.size()) {
                if (this.aaj.get(n2) == i2) {
                    nArray[0] = ((I)this.aai.get(n2)).hw();
                    nArray[1] = ((I)this.aai.get(n2)).hu();
                    break;
                }
                ++n2;
            }
        }
        return nArray;
    }

    private int c(int n2, int n3, boolean bl2) {
        int n4 = 0;
        if (n2 == 2) {
            int n5 = this.aae.zq();
            int n6 = aq.ss.length - 1 - n5;
            if ((n3 += n6) < aq.ss.length) {
                n4 = aq.ss[n3];
            }
        } else if (n2 == 4) {
            int n7 = this.aae.yT().gg();
            if (n7 < 0) {
                n7 = 1;
            }
            if (this.aae.zf() >= 4101 && this.aae.zf() <= 4103) {
                n4 = 500000;
            } else if (this.aae.zf() >= 4000 && this.aae.zf() <= 4004) {
                n4 = 1000000;
            } else if (n3 < aq.sw[0].length) {
                n4 = aq.sw[n7][n3];
            }
        } else if (n2 == 5) {
            if (n3 < aq.sx.length) {
                n4 = aq.sx[n3];
            }
        } else if (n2 == 6) {
            int n8 = this.aae.yT().gg();
            if (n8 < 0 || n8 > 1) {
                n8 = 1;
            }
            if (this.aae.zf() == 6100) {
                n4 = 300000;
            } else if (this.aae.zf() >= 6000 && this.aae.zf() <= 6004) {
                n4 = 500000;
            } else if (n3 < aq.sy[0].length) {
                n4 = aq.sy[n8][n3];
            }
        } else if (n2 == 8) {
            n4 = aq.sz[0];
        } else if (n2 == 10) {
            if (n3 < aq.sv.length) {
                n4 = aq.sv[n3];
            }
        } else if (n2 == 11) {
            n4 = aq.sA[0];
        } else if (n2 == 12) {
            int n9 = this.aae.yT().gg();
            if (n9 < 0 || n9 > 1) {
                n9 = 1;
            }
            if (this.aae.zf() == 6100) {
                n4 = 300000;
            } else if (this.aae.zf() >= 6000 && this.aae.zf() <= 6004) {
                n4 = 500000;
            } else if (n3 < aq.aeG[0].length) {
                n4 = aq.aeG[n9][n3];
            }
        }
        return n4;
    }

    public void e(z z2) {
        this.aae = z2;
    }

    public int lU() {
        return this.oj;
    }

    public void co(int n2) {
        this.oj = n2;
    }

    public int zU() {
        return this.aaf;
    }

    public void fk(int n2) {
        this.aaf = n2;
    }

    public boolean hO() {
        return this.gj;
    }

    public void s(boolean bl2) {
        this.gj = bl2;
    }

    public ArrayList zV() {
        ArrayList<ah> arrayList = new ArrayList<ah>();
        int n2 = 0;
        while (n2 < this.aai.size()) {
            arrayList.add(((I)this.aai.get(n2)).hc());
            arrayList.add(((I)this.aai.get(n2)).hd());
            ++n2;
        }
        return arrayList;
    }

    public ArrayList zW() {
        return this.aai;
    }

    public void ap(ArrayList arrayList) {
        this.aai = arrayList;
    }

    public ArrayList zX() {
        return this.aaj;
    }

    public void aq(ArrayList arrayList) {
        this.aaj = arrayList;
    }

    public ArrayList zY() {
        return this.aak;
    }

    public void ar(ArrayList arrayList) {
        this.aak = arrayList;
    }

    public void fl(int n2) {
        this.aam = n2;
    }

    public void fm(int n2) {
        this.aan = n2;
    }

    private void eZ(int n2) {
        this.as.add(n2);
    }

    public void b(boolean bl2, boolean bl3) {
        Serializable serializable;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        int n8 = 0;
        int n9 = 0;
        int n10 = 0;
        int n11 = 0;
        while (n11 < this.aai.size()) {
            n2 = 0;
            n3 = 0;
            n4 = 0;
            n5 = 0;
            n6 = 0;
            n7 = 0;
            n8 = 0;
            n9 = 0;
            n10 = 0;
            n2 = ((I)this.aai.get(n11)).hu();
            n3 = ((I)this.aai.get(n11)).hw();
            n9 = n2;
            n10 = n3;
            if (n2 > n3) {
                ++n6;
            } else if (n3 > n2) {
                ++n7;
            }
            if (this.gj) {
                n4 = ((I)this.aaj.get(n11)).hw();
                if (n4 > (n5 = ((I)this.aaj.get(n11)).hu())) {
                    ++n6;
                } else if (n5 > n4) {
                    ++n7;
                }
                n9 += n4;
                n10 += n5;
            }
            if (n6 > n7) {
                n8 = 1;
            } else if (n7 > n6) {
                n8 = 2;
            }
            if (n8 == 0) {
                if (n9 > n10) {
                    n8 = 1;
                } else if (n10 > n9) {
                    n8 = 2;
                }
            }
            if (n8 == 0 && this.gj && this.aag) {
                if (n4 > n3) {
                    n8 = 1;
                } else if (n3 > n4) {
                    n8 = 2;
                }
            }
            if (n8 == 0 && this.ze() == 2129) {
                n8 = 2;
            } else if (n8 == 0) {
                serializable = (I)this.aai.get(n11);
                if (this.gj) {
                    serializable = (I)this.aaj.get(n11);
                }
                n8 = serializable.hP() && serializable.hR() != null ? (serializable.hR() == ((I)this.aai.get(n11)).hc() ? 1 : 2) : (((I)this.aai.get(n11)).hc().lf() < ((I)this.aai.get(n11)).hc().lf() ? 1 : 2);
            }
            if (n8 == 1) {
                this.aak.add(((I)this.aai.get(n11)).hc());
                this.aal.add(((I)this.aai.get(n11)).hd());
                serializable = (I)this.aai.get(n11);
                if (this.gj) {
                    serializable = (I)this.aaj.get(n11);
                }
                this.a((I)serializable, ((I)this.aai.get(n11)).hc().ka(), 1);
                this.a((I)serializable, ((I)this.aai.get(n11)).hd().ka(), 2);
                this.V(((I)this.aai.get(n11)).hc());
                if (this.aae.zf() == 90 || this.aae.zf() == 91 || this.aae.zf() == 92 || this.aae.zf() == 93 || this.aae.zf() == 94 || this.aae.zf() == 95) {
                    a.SR.aY().a(this.aae.yT(), a.SR.s(((I)this.aai.get(n11)).hc().getPais()));
                }
            } else {
                this.aak.add(((I)this.aai.get(n11)).hd());
                this.aal.add(((I)this.aai.get(n11)).hc());
                serializable = (I)this.aai.get(n11);
                if (this.gj) {
                    serializable = (I)this.aaj.get(n11);
                }
                this.a((I)serializable, ((I)this.aai.get(n11)).hc().ka(), 2);
                this.a((I)serializable, ((I)this.aai.get(n11)).hd().ka(), 1);
                this.V(((I)this.aai.get(n11)).hd());
                if (this.aae.zf() == 90 || this.aae.zf() == 91 || this.aae.zf() == 92 || this.aae.zf() == 93 || this.aae.zf() == 94 || this.aae.zf() == 95) {
                    a.SR.aY().a(this.aae.yT(), a.SR.s(((I)this.aai.get(n11)).hd().getPais()));
                }
            }
            ++n11;
        }
        if (bl3) {
            if (this.aae.zf() == 1099) {
                ((B)this.aae.yT()).BO();
            } else if (this.aae.zf() == 1098) {
                ((B)this.aae.yT()).r(this.aak, this.aal);
            } else if (this.aae.zf() != 91) {
                if (this.aae.zf() == 1068) {
                    ((B)this.aae.yT()).n(this.aak, this.aal);
                } else if (this.aae.zf() == 9502) {
                    a.SR.bS().p(this.aak, this.aal);
                } else if (this.aae.zf() == 9401) {
                    a.SR.bR().ay(this.aak);
                } else if (this.aae.zf() == 9200) {
                    a.SR.bM().aw(this.aak);
                } else if (this.aae.zf() == 9202) {
                    a.SR.bM().p(this.aak, this.aal);
                } else if (this.aae.zf() == 9300) {
                    a.SR.bQ().aw(this.aak);
                } else if (this.aae.zf() == 9002) {
                    a.SR.bL().az(this.aak);
                } else if (this.aae.zf() == 9303) {
                    a.SR.bQ().ax(this.aak);
                } else if (this.aae.zf() == 4000) {
                    a.SR.aI().aj(this.aak);
                } else if (this.aae.zf() == 4001) {
                    a.SR.aI().g(this.aak, this.aal);
                } else if (this.aae.zf() == 4002) {
                    a.SR.aI().h(this.aak, this.aal);
                } else if (this.aae.zf() == 4003) {
                    a.SR.aI().j(this.aak, this.aal);
                } else if (this.aae.zf() == 4004) {
                    a.SR.aI().k(this.aak, this.aal);
                } else if (this.aae.zf() == 6001) {
                    a.SR.aK().g(this.aak, this.aal);
                } else if (this.aae.zf() == 6002) {
                    a.SR.aK().m(this.aak, this.aal);
                } else if (this.aae.zf() == 6006) {
                    a.SR.aK().l(this.aak, this.aal);
                } else if (this.aae.zf() == 6004) {
                    a.SR.aK().m(this.aak, this.aal);
                } else if (this.aae.zf() == 4101) {
                    a.SR.aF().g(this.aak, this.aal);
                } else if (this.aae.zf() == 4102) {
                    a.SR.aF().h(this.aak, this.aal);
                } else if (this.aae.zf() == 4103) {
                    a.SR.aF().i(this.aak, this.aal);
                } else if (this.aae.zf() == 12001) {
                    a.SR.mj().g(this.aak, this.aal);
                } else if (this.aae.zf() == 12002) {
                    a.SR.mj().h(this.aak, this.aal);
                } else if (this.aae.zf() == 12003) {
                    a.SR.mj().j(this.aak, this.aal);
                } else if (this.aae.zf() == 12004) {
                    a.SR.mj().m(this.aak, this.aal);
                } else if (this.aae.zf() == 12006) {
                    a.SR.mj().l(this.aak, this.aal);
                } else if (this.aae.zf() == 6100) {
                    a.SR.aH().o(this.aak, this.aal);
                } else if (this.aae.zf() == 14006) {
                    a.SR.sq().aA(this.aal);
                } else if (this.aae.zf() == 2029 && this.var0 != 2729) {
                    f f2 = (f)this.aae.yT();
                    if (this.var0 == 2129) {
                        f2.ad(this.aak);
                    } else if (this.var0 == 2229) {
                        f2.ao(this.aak);
                    } else if (this.var0 == 2329) {
                        f2.as(this.aak);
                    } else if (this.var0 == 2429) {
                        f2.at(this.aak);
                    } else if (this.var0 == 2529) {
                        f2.au(this.aak);
                    } else if (this.var0 == 2629) {
                        f2.av(this.aak);
                    }
                } else if (this.aae.zf() != 1802 && this.aae.zf() != 1803) {
                    if (this.aae.zf() == 150) {
                        a.SR.aR().al(this.aak);
                    } else if (bl2) {
                        at at2 = this.aae.yT();
                        serializable = this.aae.zy();
                        ah ah2 = null;
                        ah ah3 = null;
                        if (this.aak.get(0) == ((I)this.aai.get(0)).hc()) {
                            n8 = 1;
                            ah2 = ((I)this.aai.get(0)).hc();
                            ah3 = ((I)this.aai.get(0)).hd();
                        } else {
                            n8 = 2;
                            ah2 = ((I)this.aai.get(0)).hd();
                            ah3 = ((I)this.aai.get(0)).hc();
                        }
                        new i(at2, (L)serializable, ah2, ah3);
                        if (aq.fs(at2.b())) {
                            ah2.ka();
                        }
                    }
                }
            }
        }
    }

    private void V(ah ah2) {
        this.fl(this.c(this.w, this.oj, false));
        if (ah2 != null && this.aam > 0 && ah2.jZ().booleanValue()) {
            ah2.v(this.aam, 3);
            z z2 = this.zT();
            if (ah2.ka() != null && ah2.ka().jZ().booleanValue() && z2 != null) {
                new as(ah2.ka(), 26, 79, ((L)z2).getNome(), C.c(this.aam));
            }
        }
    }

    private void a(I i2, al al2, int n2) {
        if (i2 != null && al2 != null && i2.hy() != null && i2.hy().b() != 7 && i2.hy().b() != 9) {
            al2.a(i2, true, n2);
        }
    }

    public boolean zZ() {
        return this.aag;
    }

    public int ze() {
        return this.var0;
    }

    public void fb(int n2) {
        this.var0 = n2;
    }

    public boolean ad(ah ah2) {
        int n2 = 0;
        while (n2 < this.aai.size()) {
            if (((I)this.aai.get(n2)).hc() == ah2 || ((I)this.aai.get(n2)).hd() == ah2) {
                return true;
            }
            ++n2;
        }
        return false;
    }
}

