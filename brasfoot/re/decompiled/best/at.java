/*
 * Decompiled with CFR 0.152.
 */
package best;

import best.F;
import best.H;
import best.I;
import best.L;
import best.X;
import best.Z;
import best.a;
import best.ah;
import best.an;
import best.au;
import best.av;
import best.aw;
import best.ax;
import best.c;
import best.i;
import best.m;
import best.w;
import f.B;
import f.f;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.ImageIcon;

public abstract class at
implements Serializable {
    private static final long serialVersionUID = 1L;
    private String dm = null;
    private int tR = 0;
    private int dz = -1;
    private boolean tS = true;
    private ArrayList tT = new ArrayList();
    private ArrayList tU = new ArrayList();
    private boolean decisaoTerceiroLugar = false;
    private int ei = -1;
    private transient ArrayList tV = new ArrayList();
    private transient m tW = null;
    public static Comparator tX = new au();
    public static Comparator tY = new av();
    public static Comparator tZ = new aw();
    public static Comparator ua = new ax();

    public void clear() {
    }

    public ImageIcon es() {
        return null;
    }

    public String getNome() {
        return this.dm;
    }

    public void setNome(String string) {
        this.dm = string;
    }

    public boolean mm() {
        return this.tS;
    }

    public void N(boolean bl2) {
        this.tS = bl2;
    }

    public int b() {
        return this.tR;
    }

    public void F(int n2, int n3) {
        this.tR = n2;
        this.dz = n3;
    }

    public ArrayList mn() {
        return this.tT;
    }

    public ah cS() {
        ah ah2 = null;
        int n2 = 0;
        while (n2 < this.mn().size()) {
            if (((i)this.mn().get(n2)).H() == c.a.SR.H()) {
                ah2 = ((i)this.mn().get(n2)).ce();
                return ah2;
            }
            ++n2;
        }
        return null;
    }

    public ah cv(int n2) {
        ah ah2 = null;
        int n3 = 0;
        while (n3 < this.mn().size()) {
            if (((i)this.mn().get(n3)).H() == n2) {
                ah2 = ((i)this.mn().get(n3)).ce();
                return ah2;
            }
            ++n3;
        }
        return null;
    }

    public i mo() {
        int n2 = 0;
        while (n2 < this.mn().size()) {
            if (((i)this.mn().get(n2)).H() == c.a.SR.H()) {
                return (i)this.mn().get(n2);
            }
            ++n2;
        }
        return null;
    }

    public i mp() {
        int n2 = 0;
        while (n2 < this.mn().size()) {
            if (((i)this.mn().get(n2)).H() == c.a.SR.H() - 1) {
                return (i)this.mn().get(n2);
            }
            ++n2;
        }
        return null;
    }

    public c p(F f2) {
        int n2 = 0;
        while (n2 < this.tU.size()) {
            if (((c)this.tU.get(n2)).x() == f2) {
                return (c)this.tU.get(n2);
            }
            ++n2;
        }
        c c2 = new c(this, f2);
        this.tU.add(c2);
        return c2;
    }

    public void q(F f2) {
        int n2 = -1;
        int n3 = 0;
        while (n3 < this.tU.size()) {
            if (((c)this.tU.get(n3)).x() == f2) {
                n2 = n3;
                break;
            }
            ++n3;
        }
        if (n2 >= 0) {
            this.tU.remove(n2);
        }
    }

    public c r(F f2) {
        c c2 = null;
        int n2 = 0;
        while (n2 < this.tU.size()) {
            if (((c)this.tU.get(n2)).x() == f2) {
                return (c)this.tU.get(n2);
            }
            ++n2;
        }
        return c2;
    }

    public static long getSerialversionuid() {
        return 1L;
    }

    public boolean mq() {
        return this.decisaoTerceiroLugar;
    }

    public void O(boolean bl2) {
        this.decisaoTerceiroLugar = bl2;
    }

    public w ir() {
        return null;
    }

    public Z iq() {
        return null;
    }

    public int ip() {
        return -1;
    }

    public void mr() {
        System.out.println("at:" + this.getNome());
    }

    public String P(boolean bl2) {
        return "";
    }

    public String is() {
        return this.dm;
    }

    public static ArrayList a(int n2, boolean bl2, int n3) {
        int n4;
        ArrayList<at> arrayList = new ArrayList<at>();
        boolean bl3 = false;
        int n5 = 0;
        while (n5 < c.a.SR.R().size()) {
            n4 = 0;
            while (n4 < ((a)c.a.SR.R().get(n5)).t().size()) {
                bl3 = n2 == 3 && n3 == 1 && ((at)((a)c.a.SR.R().get(n5)).t().get(n4)).b() == 9;
                if (!bl3 && !arrayList.contains(((a)c.a.SR.R().get(n5)).t().get(n4)) && ((at)((a)c.a.SR.R().get(n5)).t().get(n4)).cw(n2)) {
                    arrayList.add((at)((a)c.a.SR.R().get(n5)).t().get(n4));
                }
                ++n4;
            }
            ++n5;
        }
        if (n2 == 4) {
            f.F[] fArray = c.a.SR.bV();
            n4 = 0;
            while (n4 < fArray.length) {
                if (fArray[n4] != null) {
                    arrayList.add(fArray[n4]);
                }
                ++n4;
            }
        }
        if (c.a.SR.bk() && n2 == 0) {
            Z z2 = c.a.SR.o(29);
            at at2 = null;
            int n6 = 0;
            int n7 = 0;
            while (n7 < arrayList.size()) {
                if (arrayList.get(n7) instanceof B && ((B)arrayList.get(n7)).yg() != null && ((B)arrayList.get(n7)).yg().jc() == 29 && ((B)arrayList.get(n7)).ip() == 3) {
                    n6 = n7 + 1;
                    break;
                }
                ++n7;
            }
            if (z2.eb().size() == 4 && (at2 = (at)z2.eb().get(z2.eb().size() - 1)) != null) {
                if (!arrayList.contains(at2)) {
                    arrayList.add(n6, at2);
                } else {
                    arrayList.remove(at2);
                    arrayList.add(n6, at2);
                }
            }
            if (z2 != null) {
                if (z2.jq() == null) {
                    z2.a((f)null);
                }
                if (!arrayList.contains(z2.jq())) {
                    arrayList.add(z2.jq());
                }
            }
        }
        if (n2 == 3 && bl2) {
            if (c.a.SR.aY() != null && !arrayList.contains(c.a.SR.aY())) {
                arrayList.add(c.a.SR.aY());
            }
            if (c.a.SR.ba() != null && !arrayList.contains(c.a.SR.ba())) {
                arrayList.add(c.a.SR.ba());
            }
            if (c.a.SR.aZ() != null && !arrayList.contains(c.a.SR.aZ())) {
                arrayList.add(c.a.SR.aZ());
            }
            if (c.a.SR.be() != null && !arrayList.contains(c.a.SR.be())) {
                arrayList.add(c.a.SR.be());
            }
            if (c.a.SR.bf() != null && !arrayList.contains(c.a.SR.bf())) {
                arrayList.add(c.a.SR.bf());
            }
            if (c.a.SR.bg() != null && !arrayList.contains(c.a.SR.bg())) {
                arrayList.add(c.a.SR.bg());
            }
            if (c.a.SR.bX() != null && !arrayList.contains(c.a.SR.bX())) {
                arrayList.add(c.a.SR.bX());
            }
            if (c.a.SR.yl() != null && !arrayList.contains(c.a.SR.yl())) {
                arrayList.add(c.a.SR.yl());
            }
            if (c.a.SR.sq() != null && !arrayList.contains(c.a.SR.sq())) {
                arrayList.add(c.a.SR.sq());
            }
            if (c.a.SR.ym() != null && !arrayList.contains(c.a.SR.ym())) {
                arrayList.add(c.a.SR.ym());
            }
        }
        if (n2 == 1 && bl2) {
            if (c.a.SR.aR() != null && !arrayList.contains(c.a.SR.aR())) {
                arrayList.add(c.a.SR.aR());
            }
            if (c.a.SR.aW() != null && !arrayList.contains(c.a.SR.aW())) {
                arrayList.add(c.a.SR.aW());
            }
            if (c.a.SR.aV() != null && !arrayList.contains(c.a.SR.aV())) {
                arrayList.add(c.a.SR.aV());
            }
        }
        if (n2 == 1 && c.a.SR.aK() != null && !arrayList.contains(c.a.SR.aK())) {
            arrayList.add(c.a.SR.aK());
        }
        return arrayList;
    }

    public boolean cw(int n2) {
        if (n2 == 0) {
            if (this.tR == 1) {
                return true;
            }
            if (this.tR == 2) {
                return true;
            }
            if (!c.a.SR.isJogaIntClubes() && this.tR == 15) {
                return true;
            }
        } else if (n2 == 1) {
            if (this.tR == 4) {
                return true;
            }
            if (this.tR == 5) {
                return true;
            }
            if (this.tR == 6) {
                return true;
            }
            if (this.tR == 8) {
                return true;
            }
            if (this.tR == 12) {
                return true;
            }
            if (this.tR == 15) {
                return true;
            }
        } else if (n2 == 2 ? this.tR == 3 : n2 == 3 && (this.tR == 7 || this.tR == 9 || this.tR == 13 || this.tR == 14)) {
            return true;
        }
        return false;
    }

    public ArrayList ms() {
        return this.tU;
    }

    public void U(ArrayList arrayList) {
        this.tU = arrayList;
    }

    public int mt() {
        return this.tU.size();
    }

    public c mu() {
        this.mv();
        if (this.tU != null && this.tU.size() > 0) {
            return (c)this.tU.get(0);
        }
        return null;
    }

    public void mv() {
        if (this.tU != null && this.tU.size() > 0) {
            int n2 = 0;
            while (n2 < this.tU.size()) {
                H h3;
                if (((c)this.tU.get(n2)).x() != null && (h3 = ((c)this.tU.get(n2)).x().g(this)) != null) {
                    ((c)this.tU.get(n2)).i(h3.w());
                }
                ++n2;
            }
            Collections.sort(this.tU, tX);
        }
    }

    public void mw() {
        this.tU.clear();
    }

    public void mx() {
        this.tV.clear();
        this.tW = null;
    }

    public void my() {
        int n2;
        double d2 = 0.0;
        int n3 = 0;
        int n4 = 0;
        I i2 = null;
        int n5 = 3;
        ah ah2 = null;
        ArrayList<ah> arrayList = new ArrayList<ah>();
        int n6 = 0;
        while (n6 < c.a.SR.R().size()) {
            if (((a)c.a.SR.R().get(n6)).e() && ((a)c.a.SR.R().get(n6)).h().size() > 0) {
                n2 = 0;
                while (n2 < ((a)c.a.SR.R().get(n6)).h().size()) {
                    if (((I)((a)c.a.SR.R().get(n6)).h().get(n2)).hy() == this) {
                        ++n3;
                        n4 += ((I)((a)c.a.SR.R().get(n6)).h().get(n2)).hu();
                        n4 += ((I)((a)c.a.SR.R().get(n6)).h().get(n2)).hw();
                        if (((I)((a)c.a.SR.R().get(n6)).h().get(n2)).hu() - ((I)((a)c.a.SR.R().get(n6)).h().get(n2)).hw() >= n5) {
                            i2 = (I)((a)c.a.SR.R().get(n6)).h().get(n2);
                            n5 = ((I)((a)c.a.SR.R().get(n6)).h().get(n2)).hu() - ((I)((a)c.a.SR.R().get(n6)).h().get(n2)).hw();
                        }
                        if (((I)((a)c.a.SR.R().get(n6)).h().get(n2)).hw() - ((I)((a)c.a.SR.R().get(n6)).h().get(n2)).hu() >= n5) {
                            i2 = (I)((a)c.a.SR.R().get(n6)).h().get(n2);
                            n5 = ((I)((a)c.a.SR.R().get(n6)).h().get(n2)).hw() - ((I)((a)c.a.SR.R().get(n6)).h().get(n2)).hu();
                        }
                    }
                    ++n2;
                }
            }
            ++n6;
        }
        if (n3 > 0) {
            d2 = (double)n4 / (double)n3;
        }
        if (this.cS() != null) {
            ah2 = this.cS();
        } else {
            n6 = 0;
            while (n6 < this.mn().size()) {
                if (((i)this.mn().get(n6)).H() == c.a.SR.H() - 1) {
                    ah2 = ((i)this.mn().get(n6)).ce();
                    break;
                }
                ++n6;
            }
        }
        ArrayList<ah> arrayList2 = new ArrayList<ah>();
        n2 = 0;
        while (n2 < this.mn().size()) {
            if (!arrayList.contains(((i)this.mn().get(n2)).ce())) {
                arrayList.add(((i)this.mn().get(n2)).ce());
            }
            arrayList2.add(((i)this.mn().get(n2)).ce());
            ++n2;
        }
        ArrayList<an> arrayList3 = null;
        if (arrayList.size() > 0) {
            arrayList3 = new ArrayList<an>();
            int n7 = 0;
            while (n7 < arrayList.size()) {
                arrayList3.add(new an((ah)arrayList.get(n7), Collections.frequency(arrayList2, arrayList.get(n7))));
                ++n7;
            }
            Collections.sort(arrayList3, ua);
        }
        this.tW = new m(d2, n4, n3, i2, ah2, arrayList3);
    }

    public void mz() {
        ArrayList<X> arrayList = new ArrayList<X>();
        int n2 = 0;
        while (n2 < c.a.SR.O().size()) {
            H h3 = ((F)c.a.SR.O().get(n2)).g(this);
            if (h3 != null && h3.F() > 5.0) {
                arrayList.add(new X((F)c.a.SR.O().get(n2), h3.F(), h3.gZ()));
            }
            ++n2;
        }
        Collections.sort(arrayList, tY);
        if (this.tV == null) {
            this.tV = new ArrayList();
        }
        this.tV.clear();
        if (arrayList.size() >= 4) {
            n2 = 0;
            while (n2 < 5) {
                this.tV.add((X)arrayList.get(n2));
                ++n2;
            }
        }
        arrayList.clear();
    }

    public String[] mA() {
        String[] stringArray = new String[]{"", ""};
        return stringArray;
    }

    public int gg() {
        return this.dz;
    }

    public int el() {
        return this.dz;
    }

    public int gD() {
        return this.ei;
    }

    public void az(int n2) {
        this.ei = n2;
    }

    public L[] mB() {
        return null;
    }

    public ArrayList mC() {
        return null;
    }

    public String[] b(L l2) {
        return null;
    }

    public ArrayList mD() {
        return this.tV;
    }

    public m mE() {
        return this.tW;
    }

    public void a(m m2) {
        this.tW = m2;
    }

    public String cx(int n2) {
        return null;
    }

    public int cy(int n2) {
        return 40000;
    }

    public boolean cz(int n2) {
        return false;
    }

    public Z mF() {
        return null;
    }
}

