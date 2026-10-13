/*
 * Decompiled with CFR 0.152.
 */
package best;

import best.I;
import best.L;
import best.S;
import best.Z;
import best.ah;
import best.al;
import best.aq;
import best.at;
import best.w;
import f.A;
import f.B;
import f.s;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

public class a
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Calendar p = Calendar.getInstance();
    private ArrayList q = new ArrayList();
    private ArrayList r = new ArrayList();
    private ArrayList s = new ArrayList();
    private ArrayList t = new ArrayList();
    private ArrayList u = new ArrayList();
    private boolean v = false;
    private int w = 0;
    static final int DOM = 1;
    static final int z = 2;
    static final int A = 3;
    static final int B = 4;
    static final int C = 5;
    static final int D = 6;
    static final int F = 7;
    static final int G = 1;
    static final int H = 2;
    static final int I = 3;
    static final int J = 4;
    static final int K = 5;
    static final int L = 6;
    static final int ht = 12;
    static final int M = 7;
    static final int N = 8;
    static final int O = 9;
    static final int P = 10;
    static final int Q = 11;
    static final int hx = 13;
    static final int ov = 14;
    static final int R = 100;
    static final int S = 200;
    static final int ow = 15;

    public void clear() {
        int n2 = 0;
        while (n2 < this.s.size()) {
            ((I)this.s.get(n2)).clear();
            ++n2;
        }
        n2 = 0;
        while (n2 < this.u.size()) {
            ((at)this.u.get(n2)).clear();
            ++n2;
        }
        this.s.clear();
        this.t.clear();
        this.u.clear();
    }

    public Calendar a() {
        return this.p;
    }

    public void a(int n2, int n3, int n4) {
        this.p.set(n2, n3, n4);
    }

    public int b() {
        return this.w;
    }

    public void a(int n2) {
        this.w = n2;
    }

    public static ArrayList b(int n2) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int n3 = 0;
        while (n3 < c.a.SR.R().size()) {
            if (((a)c.a.SR.R().get(n3)).b() == n2) {
                arrayList.add(n3);
            }
            ++n3;
        }
        return arrayList;
    }

    public static ArrayList c(int n2) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int n3 = 0;
        while (n3 < c.a.SR.R().size()) {
            if (((a)c.a.SR.R().get(n3)).a().get(7) == n2) {
                arrayList.add(n3);
            }
            ++n3;
        }
        return arrayList;
    }

    public int c() {
        return this.p.get(2);
    }

    public static ArrayList d() {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int n2 = 0;
        while (n2 < c.a.SR.R().size()) {
            if (((a)c.a.SR.R().get(n2)).a().get(5) == 2) {
                arrayList.add(n2);
            }
            ++n2;
        }
        return arrayList;
    }

    public static int d(int n2) {
        int n3 = c.a.SR.R().size() - 1;
        while (n3 >= 0) {
            if (((a)c.a.SR.R().get(n3)).b() == n2) {
                return n3;
            }
            --n3;
        }
        return -1;
    }

    public static int e(int n2) {
        int n3 = 0;
        while (n3 < c.a.SR.R().size()) {
            if (((a)c.a.SR.R().get(n3)).b() == n2) {
                return n3;
            }
            ++n3;
        }
        return -1;
    }

    public static int a(int n2, int n3) {
        int n4 = 1;
        int n5 = 0;
        while (n5 < c.a.SR.R().size()) {
            if (((a)c.a.SR.R().get(n5)).b() == n2 && n4 == n3) {
                return n5;
            }
            if (((a)c.a.SR.R().get(n5)).b() == n2) {
                ++n4;
            }
            ++n5;
        }
        return -1;
    }

    public static ArrayList a(int n2, boolean bl2) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int n3 = 0;
        if (bl2) {
            n3 = 2;
        }
        int n4 = 0;
        while (n4 < c.a.SR.R().size()) {
            if (((a)c.a.SR.R().get(n4)).b() == n2 && !((a)c.a.SR.R().get(n4)).e()) {
                if (n3 <= 0) {
                    arrayList.add(n4);
                }
                if (n3 > 0) {
                    --n3;
                }
            }
            ++n4;
        }
        return arrayList;
    }

    public boolean e() {
        return this.v;
    }

    public void a(boolean bl2) {
        this.v = bl2;
    }

    public String f() {
        DateFormat dateFormat = DateFormat.getDateInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String string = simpleDateFormat.format(this.a().getTime());
        return string;
    }

    public static String a(Calendar calendar) {
        DateFormat dateFormat = DateFormat.getDateInstance();
        return dateFormat.format(calendar.getTime());
    }

    public static String a(Date date) {
        DateFormat dateFormat = DateFormat.getDateInstance();
        return dateFormat.format(date.getTime());
    }

    public static String a(long l2) {
        DateFormat dateFormat = DateFormat.getDateInstance();
        return dateFormat.format(l2);
    }

    private static void b(int n2, int n3) {
        int n4 = 0;
        int n5 = 0;
        int n6 = c.a.SR.R().size() - 1;
        while (n6 > 0) {
            if (((a)c.a.SR.R().get(n6)).b() > 0) {
                n5 = n6;
                break;
            }
            --n6;
        }
        if (n5 < c.a.SR.J()) {
            n5 = c.a.SR.J();
        }
        n6 = n5;
        while (n6 < c.a.SR.R().size()) {
            if (((a)c.a.SR.R().get(n6)).b() == 0 && ((a)c.a.SR.R().get(n6)).a().get(7) == n2) {
                n4 = n6;
                break;
            }
            ++n6;
        }
        if (n4 > 0) {
            ((a)c.a.SR.R().get(n4)).a(n3);
        }
    }

    public static void g() {
        a.b(1, 100);
        a.b(2, 15);
        a.b(3, 15);
        a.b(4, 10);
        a.b(5, 10);
        a.b(6, 15);
        a.b(7, 10);
        a.b(1, 10);
        a.b(2, 10);
        a.b(3, 10);
        a.b(4, 10);
        a.b(5, 10);
        a.b(6, 15);
        a.b(7, 10);
        a.b(1, 15);
        a.b(2, 10);
        a.b(3, 100);
        a.b(4, 10);
        a.b(5, 100);
        a.b(6, 10);
        a.b(7, 100);
        a.b(1, 3);
        a.b(3, 3);
        a.b(5, 3);
        a.b(1, 3);
        a.b(3, 3);
        a.b(5, 3);
        a.b(7, 11);
        a.b(1, 3);
        a.b(3, 3);
        a.b(5, 3);
        a.b(7, 200);
        a.b(1, 3);
        a.b(3, 3);
        a.b(5, 3);
        a.b(1, 3);
        a.b(3, 3);
        a.b(5, 3);
        a.b(1, 3);
        a.b(3, 3);
        a.b(4, 4);
        a.b(5, 3);
        a.b(1, 3);
        a.b(3, 3);
        a.b(5, 4);
        a.b(1, 3);
        a.b(3, 3);
        a.b(5, 4);
        a.b(1, 3);
        a.b(3, 100);
        a.b(4, 4);
        a.b(5, 200);
        a.b(1, 1);
        a.b(2, 100);
        a.b(4, 4);
        a.b(6, 12);
        a.b(1, 1);
        a.b(2, 200);
        a.b(4, 4);
        a.b(1, 1);
        a.b(2, 9);
        a.b(4, 4);
        a.b(6, 9);
        a.b(1, 1);
        a.b(2, 14);
        a.b(4, 4);
        a.b(5, 14);
        a.b(6, 12);
        a.b(7, 200);
        a.b(1, 1);
        a.b(2, 14);
        a.b(3, 2);
        a.b(5, 4);
        a.b(6, 12);
        a.b(1, 1);
        a.b(4, 2);
        a.b(6, 12);
        a.b(1, 1);
        a.b(2, 9);
        a.b(4, 4);
        a.b(5, 6);
        a.b(1, 1);
        a.b(4, 4);
        a.b(5, 6);
        a.b(7, 200);
        a.b(1, 1);
        a.b(2, 9);
        a.b(4, 4);
        a.b(5, 12);
        a.b(6, 9);
        a.b(1, 1);
        a.b(3, 2);
        a.b(4, 4);
        a.b(5, 6);
        a.b(6, 14);
        a.b(1, 1);
        a.b(2, 14);
        a.b(3, 2);
        a.b(5, 6);
        a.b(6, 12);
        a.b(7, 14);
        a.b(1, 1);
        a.b(3, 100);
        a.b(4, 4);
        a.b(5, 6);
        a.b(1, 1);
        a.b(2, 9);
        a.b(4, 4);
        a.b(5, 6);
        a.b(7, 200);
        a.b(1, 1);
        a.b(2, 9);
        a.b(4, 2);
        a.b(5, 12);
        a.b(6, 9);
        a.b(1, 1);
        a.b(2, 12);
        a.b(3, 2);
        a.b(4, 4);
        a.b(5, 6);
        a.b(7, 200);
        a.b(1, 1);
        a.b(2, 9);
        a.b(3, 4);
        a.b(4, 6);
        a.b(5, 7);
        a.b(7, 7);
        a.b(2, 7);
        a.b(4, 7);
        a.b(6, 7);
        a.b(1, 7);
        a.b(4, 7);
        a.b(1, 7);
        a.b(4, 1);
        a.b(6, 12);
        a.b(1, 1);
        a.b(2, 13);
        a.b(3, 100);
        a.b(4, 4);
        a.b(5, 6);
        a.b(1, 1);
        a.b(2, 9);
        a.b(3, 2);
        a.b(5, 6);
        a.b(6, 12);
        a.b(7, 200);
        a.b(1, 1);
        a.b(2, 9);
        a.b(3, 2);
        a.b(5, 6);
        a.b(6, 12);
        a.b(7, 9);
        a.b(1, 1);
        a.b(2, 9);
        a.b(4, 4);
        a.b(5, 6);
        a.b(6, 9);
        a.b(7, 200);
        a.b(1, 1);
        a.b(2, 13);
        a.b(4, 4);
        a.b(5, 9);
        a.b(6, 12);
        a.b(7, 9);
        a.b(1, 1);
        a.b(2, 9);
        a.b(3, 100);
        a.b(4, 4);
        a.b(5, 1);
        a.b(6, 9);
        a.b(1, 1);
        a.b(2, 14);
        a.b(3, 2);
        a.b(4, 4);
        a.b(5, 6);
        a.b(6, 14);
        a.b(1, 1);
        a.b(2, 9);
        a.b(3, 2);
        a.b(4, 4);
        a.b(5, 6);
        a.b(6, 9);
        a.b(1, 1);
        a.b(2, 9);
        a.b(4, 2);
        a.b(5, 6);
        a.b(6, 12);
        a.b(7, 200);
        a.b(1, 1);
        a.b(2, 12);
        a.b(4, 2);
        a.b(5, 6);
        a.b(6, 12);
        a.b(1, 1);
        a.b(2, 12);
        a.b(4, 2);
        a.b(2, 14);
        a.b(6, 12);
        a.b(7, 14);
        a.b(1, 1);
        a.b(2, 9);
        a.b(4, 2);
        a.b(5, 6);
        a.b(6, 12);
        a.b(1, 1);
        a.b(2, 9);
        a.b(3, 8);
        a.b(4, 12);
        a.b(5, 1);
        a.b(6, 9);
        a.b(1, 1);
        a.b(3, 8);
        a.b(4, 6);
        a.b(5, 1);
        a.b(6, 12);
        a.b(7, 200);
        a.b(1, 1);
        a.b(2, 9);
        a.b(3, 100);
        a.b(4, 6);
        a.b(5, 1);
        a.b(6, 9);
        a.b(1, 1);
        a.b(2, 9);
        a.b(3, 100);
        a.b(4, 6);
        a.b(5, 1);
        a.b(6, 12);
        a.b(1, 1);
        a.b(2, 12);
        a.b(3, 1);
        a.b(4, 9);
        a.b(5, 1);
        a.b(6, 12);
        a.b(7, 1);
        a.b(1, 1);
        a.b(2, 1);
        a.b(3, 1);
        a.b(4, 1);
        a.b(5, 1);
        a.b(6, 1);
        a.b(7, 1);
        a.b(1, 1);
        a.b(2, 1);
        a.b(3, 1);
        a.b(4, 1);
        a.b(5, 1);
        a.b(6, 5);
        a.b(7, 5);
        a.b(2, 5);
    }

    public ArrayList h() {
        return this.s;
    }

    public int i() {
        if (this.s.size() > 0) {
            return ((I)this.s.get(0)).hy().b();
        }
        return 0;
    }

    public void a(I i2) {
        this.s.add(i2);
    }

    public ArrayList j() {
        return this.t;
    }

    public void a(L l2) {
        if (!this.t.contains(l2)) {
            this.t.add(l2);
        }
    }

    public void a(at at2) {
        if (!this.u.contains(at2)) {
            this.u.add(at2);
        }
    }

    public static void b(int n2, int n3, int n4) {
        String string = null;
        if (n3 == 1) {
            string = "cw";
        } else if (n3 == 2) {
            string = "ds";
        } else if (n3 == 3) {
            string = "aj";
        } else if (n3 == 4) {
            string = "cD";
        } else if (n3 == 5) {
            string = "dJ";
        } else if (n3 == 6) {
            string = "cS";
        } else if (n3 == 7) {
            string = "cO";
        } else if (n3 == 8) {
            string = "cSempregado";
        } else if (n3 == 9) {
            string = "cPromocao";
        } else if (n3 == 10) {
            string = "criaMataMataAscenso";
        } else if (n3 == 11) {
            string = "criaplayOffRebaixamento";
        }
        if (n4 == 0) {
            a a2 = (a)c.a.SR.R().get(n2);
            a2.q.add(string);
        } else {
            a a3 = (a)c.a.SR.R().get(n2);
            a3.r.add(string);
        }
    }

    public void f(int n2) {
        String string = "cw";
        String string2 = "ds";
        String string3 = "aj";
        String string4 = "cD";
        String string5 = "dJ";
        String string6 = "cS";
        String string7 = "cO";
        String string8 = "cSempregado";
        String string9 = "cPromocao";
        String string10 = "criaMataMataAscenso";
        String string11 = "criaplayOffRebaixamento";
        ArrayList arrayList = n2 == 0 ? this.q : this.r;
        if (arrayList.size() > 0) {
            int n3 = 0;
            while (n3 < arrayList.size()) {
                if (string.equals(arrayList.get(n3))) {
                    this.p();
                } else if (string2.equals(arrayList.get(n3))) {
                    this.n();
                } else if (string3.equals(arrayList.get(n3))) {
                    c.a.SR.aT();
                } else if (string4.equals(arrayList.get(n3))) {
                    if (c.a.SR.bk()) {
                        this.m();
                    } else if (c.a.SR.X()) {
                        this.l();
                    }
                } else if (string5.equals(arrayList.get(n3))) {
                    this.o();
                } else if (string6.equals(arrayList.get(n3))) {
                    this.b(false);
                } else if (string7.equals(arrayList.get(n3))) {
                    this.k();
                } else if (string8.equals(arrayList.get(n3))) {
                    this.b(true);
                } else if (string9.equals(arrayList.get(n3))) {
                    c.a.afQ.zw();
                } else {
                    string11.equals(arrayList.get(n3));
                }
                ++n3;
            }
        }
        arrayList.clear();
    }

    private void k() {
        if (c.a.SR.isJogaSelecoesAll()) {
            int n2 = 0;
            while (n2 < c.a.SR.M().size()) {
                if (((al)c.a.SR.M().get(n2)).jo() != null) {
                    best.S.a(((al)c.a.SR.M().get(n2)).jo().ka().jo(), true);
                }
                ++n2;
            }
        }
    }

    private void b(boolean bl2) {
        if (c.a.SR.isJogaSelecoesAll()) {
            int n2 = 0;
            while (n2 < c.a.SR.M().size()) {
                ArrayList arrayList;
                if (!bl2) {
                    if (((al)c.a.SR.M().get(n2)).jZ().booleanValue() && ((al)c.a.SR.M().get(n2)).jo() == null) {
                        arrayList = c.a.afQ.a((al)c.a.SR.M().get(n2), bl2);
                        if (!c.a.SR.bD() && arrayList != null && arrayList.size() > 0) {
                            best.S.a(arrayList, (al)c.a.SR.M().get(n2), 1);
                        }
                    }
                } else if (((al)c.a.SR.M().get(n2)).jZ().booleanValue()) {
                    arrayList = c.a.afQ.a((al)c.a.SR.M().get(n2), bl2);
                    if (!c.a.SR.bD() && arrayList != null && arrayList.size() > 0) {
                        best.S.a(arrayList, (al)c.a.SR.M().get(n2), 1);
                    }
                }
                ++n2;
            }
        }
    }

    public void l() {
        Z z2 = c.a.SR.o(29);
        if (z2 != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(z2.jg());
            Collections.sort(arrayList, h.a.cN);
            z2.a(arrayList, false, "criaCopaBRAposRegionais");
        }
    }

    public void m() {
        Z z2 = c.a.SR.o(29);
        if (z2 != null && c.a.SR.bk() && z2.eb().size() == 4) {
            s s2 = ((B)z2.eb().get(z2.eb().size() - 1)).yi();
            ArrayList arrayList = null;
            if (s2 != null) {
                s2.aN(false);
                int n2 = ((B)z2.eb().get(z2.eb().size() - 1)).yi().getnTimes();
                arrayList = best.w.Q(n2);
                if (arrayList != null && n2 == arrayList.size()) {
                    s2.yK().addAll(arrayList);
                    z2.ek().removeAll(arrayList);
                    s2.aN(false);
                    s2.setDivisao(4);
                    s2.yI();
                    s2.yH();
                }
            }
            ArrayList<ah> arrayList2 = new ArrayList<ah>();
            int n3 = 0;
            int n4 = 0;
            while (n4 <= 2) {
                int n5 = 0;
                while (n5 < ((B)z2.eb().get(n4)).yi().yK().size()) {
                    arrayList2.add((ah)((B)z2.eb().get(n4)).yi().yK().get(n5));
                    ++n3;
                    ++n5;
                }
                ++n4;
            }
            arrayList = best.w.eh();
            n4 = 0;
            while (n4 < arrayList.size()) {
                if (!arrayList2.contains(arrayList.get(n4))) {
                    arrayList2.add((ah)arrayList.get(n4));
                }
                ++n4;
            }
            z2.a(arrayList2, false, "criaSerieDCopa");
        }
        c.a.SR.bx().clear();
    }

    public void n() {
        int n2 = 0;
        while (n2 < c.a.SR.aN().size()) {
            if (((ah)c.a.SR.aN().get(n2)).bY(this.c())) {
                ((ah)c.a.SR.aN().get(n2)).kJ();
            }
            ++n2;
        }
    }

    public void o() {
        int n2 = 0;
        while (n2 < c.a.SR.aN().size()) {
            if (((ah)c.a.SR.aN().get(n2)).kL() != null && ((ah)c.a.SR.aN().get(n2)).kL().eQ() > 0) {
                ((ah)c.a.SR.aN().get(n2)).w(((ah)c.a.SR.aN().get(n2)).kL().eQ(), 4);
            }
            ++n2;
        }
    }

    public void p() {
        A a2 = c.a.SR.aR();
        a2.zC();
    }

    public void K() {
        int n2 = 0;
        while (n2 < c.a.SR.N().size()) {
            ((Z)c.a.SR.N().get(n2)).K();
            ++n2;
        }
    }

    public static void q() {
        int n2;
        if (c.a.SR.isJogaSelecoesAll()) {
            int n3;
            int n4;
            int n5;
            int n6;
            if (c.a.SR.isJogaEstadual() && (n2 = a.a(3, 4)) > 0) {
                a.b(n2, 6, 1);
            }
            if ((n2 = a.a(1, 1)) > 0) {
                a.b(n2, 8, 1);
            }
            if ((n6 = a.e(7)) > 0) {
                a.b(n6, 6, 1);
            }
            if ((n5 = a.e(7)) > 0) {
                a.b(n5, 7, 1);
            }
            if ((n4 = a.a(1, 12)) > 0) {
                a.b(n4, 6, 1);
            }
            if ((n3 = a.a(1, 18)) > 0) {
                a.b(n3, 6, 1);
            }
        }
        if ((n2 = a.a(1, 20)) > 0) {
            a.b(n2, 9, 1);
        }
    }

    public ArrayList r() {
        return this.q;
    }

    public ArrayList s() {
        return this.r;
    }

    public ArrayList t() {
        return this.u;
    }

    public boolean a(ah ah2) {
        int n2 = 0;
        while (n2 < this.s.size()) {
            if (((I)this.s.get(n2)).hc() == ah2 || ((I)this.s.get(n2)).hd() == ah2) {
                return true;
            }
            ++n2;
        }
        return false;
    }

    public static void aD() {
        String string = "";
        int n2 = 0;
        while (n2 < c.a.SR.R().size()) {
            if (((a)c.a.SR.R().get(n2)).b() > 0) {
                if (string.equals(((a)c.a.SR.R().get(n2)).f())) {
                    System.out.println("erro de data: " + n2);
                }
                string = ((a)c.a.SR.R().get(n2)).f();
            }
            ++n2;
        }
    }

    public static void u() {
        int n2 = 0;
        n2 = 0;
        ArrayList arrayList = a.b(100);
        int n3 = 0;
        while (n3 < arrayList.size()) {
            System.out.println("Amistoso Clube:" + ++n2 + ") " + ((a)c.a.SR.R().get((Integer)arrayList.get(n3))).f() + " " + aq.rF[((a)c.a.SR.R().get((Integer)arrayList.get(n3))).a().get(7)] + " " + arrayList.get(n3));
            ++n3;
        }
        n2 = 0;
        arrayList = a.b(200);
        n3 = 0;
        while (n3 < arrayList.size()) {
            System.out.println("Amistoso Sele\u00e7\u00e3o:" + ++n2 + ") " + ((a)c.a.SR.R().get((Integer)arrayList.get(n3))).f() + " " + aq.rF[((a)c.a.SR.R().get((Integer)arrayList.get(n3))).a().get(7)] + " " + arrayList.get(n3));
            ++n3;
        }
        n2 = 0;
        arrayList = a.b(3);
        n3 = 0;
        while (n3 < arrayList.size()) {
            System.out.println("Estadual:" + ++n2 + ") " + ((a)c.a.SR.R().get((Integer)arrayList.get(n3))).f() + " " + aq.rF[((a)c.a.SR.R().get((Integer)arrayList.get(n3))).a().get(7)] + " " + arrayList.get(n3));
            ++n3;
        }
        n2 = 0;
        arrayList.clear();
        arrayList = a.b(10);
        n3 = 0;
        while (n3 < arrayList.size()) {
            System.out.println("Regional:" + ++n2 + ") " + ((a)c.a.SR.R().get((Integer)arrayList.get(n3))).f() + " " + aq.rF[((a)c.a.SR.R().get((Integer)arrayList.get(n3))).a().get(7)] + " " + arrayList.get(n3));
            ++n3;
        }
        n2 = 0;
        arrayList.clear();
        arrayList = a.b(11);
        n3 = 0;
        while (n3 < arrayList.size()) {
            System.out.println("SuperCopa:" + ++n2 + ") " + ((a)c.a.SR.R().get((Integer)arrayList.get(n3))).f() + " " + aq.rF[((a)c.a.SR.R().get((Integer)arrayList.get(n3))).a().get(7)] + " " + arrayList.get(n3));
            ++n3;
        }
        n2 = 0;
        arrayList.clear();
        arrayList = a.b(1);
        n3 = 0;
        while (n3 < arrayList.size()) {
            System.out.println("Nacional:" + ++n2 + ") " + ((a)c.a.SR.R().get((Integer)arrayList.get(n3))).f() + " " + aq.rF[((a)c.a.SR.R().get((Integer)arrayList.get(n3))).a().get(7)] + " " + arrayList.get(n3));
            ++n3;
        }
        n2 = 0;
        arrayList.clear();
        arrayList = a.b(4);
        n3 = 0;
        while (n3 < arrayList.size()) {
            System.out.println("Int1:" + ++n2 + ") " + ((a)c.a.SR.R().get((Integer)arrayList.get(n3))).f() + " " + aq.rF[((a)c.a.SR.R().get((Integer)arrayList.get(n3))).a().get(7)] + " " + arrayList.get(n3));
            ++n3;
        }
        n2 = 0;
        arrayList.clear();
        arrayList = a.b(2);
        n3 = 0;
        while (n3 < arrayList.size()) {
            System.out.println("Copa:" + ++n2 + ") " + ((a)c.a.SR.R().get((Integer)arrayList.get(n3))).f() + " " + aq.rF[((a)c.a.SR.R().get((Integer)arrayList.get(n3))).a().get(7)] + " " + arrayList.get(n3));
            ++n3;
        }
        n2 = 0;
        arrayList.clear();
        arrayList = a.b(7);
        n3 = 0;
        while (n3 < arrayList.size()) {
            System.out.println("Selecoes:" + ++n2 + ") " + ((a)c.a.SR.R().get((Integer)arrayList.get(n3))).f() + " " + aq.rF[((a)c.a.SR.R().get((Integer)arrayList.get(n3))).a().get(7)] + " " + arrayList.get(n3));
            ++n3;
        }
        n2 = 0;
        arrayList.clear();
        arrayList = a.b(6);
        n3 = 0;
        while (n3 < arrayList.size()) {
            System.out.println("INT2:" + ++n2 + ") " + ((a)c.a.SR.R().get((Integer)arrayList.get(n3))).f() + " " + aq.rF[((a)c.a.SR.R().get((Integer)arrayList.get(n3))).a().get(7)] + " " + arrayList.get(n3));
            ++n3;
        }
        n2 = 0;
        arrayList.clear();
        arrayList = a.b(8);
        n3 = 0;
        while (n3 < arrayList.size()) {
            System.out.println("Recopa:" + ++n2 + ") " + ((a)c.a.SR.R().get((Integer)arrayList.get(n3))).f() + " " + aq.rF[((a)c.a.SR.R().get((Integer)arrayList.get(n3))).a().get(7)] + " " + arrayList.get(n3));
            ++n3;
        }
        n2 = 0;
        arrayList.clear();
        arrayList = a.b(12);
        n3 = 0;
        while (n3 < arrayList.size()) {
            System.out.println("INT3:" + ++n2 + ") " + ((a)c.a.SR.R().get((Integer)arrayList.get(n3))).f() + " " + aq.rF[((a)c.a.SR.R().get((Integer)arrayList.get(n3))).a().get(7)] + " " + arrayList.get(n3));
            ++n3;
        }
        n2 = 0;
        arrayList.clear();
        arrayList = a.b(5);
        n3 = 0;
        while (n3 < arrayList.size()) {
            System.out.println("Mundial:" + ++n2 + ") " + ((a)c.a.SR.R().get((Integer)arrayList.get(n3))).f() + " " + aq.rF[((a)c.a.SR.R().get((Integer)arrayList.get(n3))).a().get(7)] + " " + arrayList.get(n3));
            ++n3;
        }
        n2 = 0;
        arrayList.clear();
        arrayList = a.b(9);
        n3 = 0;
        while (n3 < arrayList.size()) {
            System.out.println("Elimin:" + ++n2 + ") " + ((a)c.a.SR.R().get((Integer)arrayList.get(n3))).f() + " " + aq.rF[((a)c.a.SR.R().get((Integer)arrayList.get(n3))).a().get(7)] + " " + arrayList.get(n3));
            ++n3;
        }
        n2 = 0;
        arrayList.clear();
        arrayList = a.b(13);
        n3 = 0;
        while (n3 < arrayList.size()) {
            System.out.println("Finalissima:" + ++n2 + ") " + ((a)c.a.SR.R().get((Integer)arrayList.get(n3))).f() + " " + aq.rF[((a)c.a.SR.R().get((Integer)arrayList.get(n3))).a().get(7)] + " " + arrayList.get(n3));
            ++n3;
        }
        n2 = 0;
        arrayList.clear();
        arrayList = a.b(14);
        n3 = 0;
        while (n3 < arrayList.size()) {
            System.out.println("Liga Nacoes:" + ++n2 + ") " + ((a)c.a.SR.R().get((Integer)arrayList.get(n3))).f() + " " + aq.rF[((a)c.a.SR.R().get((Integer)arrayList.get(n3))).a().get(7)] + " " + arrayList.get(n3));
            ++n3;
        }
    }
}

