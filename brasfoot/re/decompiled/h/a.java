/*
 * Decompiled with CFR 0.152.
 */
package h;

import h.A;
import h.B;
import h.C;
import h.D;
import h.E;
import h.F;
import h.G;
import h.H;
import h.I;
import h.J;
import h.K;
import h.L;
import h.M;
import h.N;
import h.O;
import h.P;
import h.b;
import h.c;
import h.d;
import h.e;
import h.f;
import h.g;
import h.h;
import h.i;
import h.j;
import h.k;
import h.l;
import h.m;
import h.n;
import h.o;
import h.p;
import h.q;
import h.r;
import h.s;
import h.t;
import h.u;
import h.v;
import h.w;
import h.x;
import h.y;
import h.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class a {
    public static Comparator aaE = new b();
    public static Comparator aaF = new m();
    public static Comparator aaG = new x();
    public static Comparator aaH = new I();
    public static Comparator aaI = new L();
    public static Comparator aaJ = new M();
    public static Comparator aaK = new N();
    public static Comparator aaL = new O();
    public static Comparator aaM = new P();
    public static Comparator aaN = new c();
    public static Comparator aaO = new d();
    public static Comparator aaP = new e();
    public static Comparator aaQ = new f();
    public static Comparator aaR = new g();
    public static Comparator aaS = new h();
    public static Comparator aaT = new i();
    public static Comparator aaU = new j();
    public static Comparator aaV = new k();
    public static Comparator aaW = new l();
    public static Comparator aaX = new n();
    public static Comparator aaY = new o();
    public static Comparator cL = new p();
    public static Comparator aaZ = new q();
    public static Comparator aba = new r();
    public static Comparator abb = new s();
    public static Comparator abc = new t();
    public static Comparator aab = new u();
    public static Comparator VU = new v();
    public static Comparator abd = new w();
    public static Comparator abe = new y();
    public static Comparator abf = new z();
    public static Comparator abg = new A();
    public static Comparator abh = new B();
    public static Comparator abi = new C();
    public static Comparator cN = new D();
    public static Comparator VS = new E();
    public static Comparator abj = new F();
    public static Comparator abk = new G();
    public static Comparator abl = new H();
    public static Comparator abm = new J();
    public static Comparator abn = new K();

    public static ArrayList ac(int n2, int n3) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int n4 = n2;
        while (n4 <= n3) {
            arrayList.add(n4);
            ++n4;
        }
        Collections.shuffle(arrayList);
        return arrayList;
    }

    public static ArrayList Ak() {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        ArrayList arrayList2 = a.ac(0, 5);
        ArrayList arrayList3 = a.ac(6, 11);
        ArrayList arrayList4 = a.ac(12, 17);
        ArrayList arrayList5 = a.ac(18, 23);
        int n2 = 0;
        while (n2 < 4) {
            int n3 = 0;
            while (n3 < 6) {
                arrayList.add((Integer)arrayList2.get(n3));
                arrayList.add((Integer)arrayList3.get(n3));
                arrayList.add((Integer)arrayList4.get(n3));
                arrayList.add((Integer)arrayList5.get(n3));
                ++n3;
            }
            ++n2;
        }
        return arrayList;
    }

    public static ArrayList Al() {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        ArrayList arrayList2 = a.ac(0, 1);
        ArrayList arrayList3 = a.ac(2, 3);
        ArrayList arrayList4 = a.ac(4, 5);
        ArrayList arrayList5 = a.ac(6, 7);
        ArrayList arrayList6 = a.ac(8, 9);
        int n2 = 0;
        while (n2 < 2) {
            arrayList.add((Integer)arrayList2.get(n2));
            arrayList.add((Integer)arrayList3.get(n2));
            arrayList.add((Integer)arrayList4.get(n2));
            arrayList.add((Integer)arrayList5.get(n2));
            arrayList.add((Integer)arrayList6.get(n2));
            ++n2;
        }
        return arrayList;
    }

    public static ArrayList Am() {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        ArrayList arrayList2 = a.ac(0, 1);
        ArrayList arrayList3 = a.ac(2, 3);
        ArrayList arrayList4 = a.ac(4, 5);
        ArrayList arrayList5 = a.ac(6, 7);
        ArrayList arrayList6 = a.ac(8, 9);
        ArrayList arrayList7 = a.ac(10, 11);
        int n2 = 0;
        while (n2 < 2) {
            arrayList.add((Integer)arrayList2.get(n2));
            arrayList.add((Integer)arrayList3.get(n2));
            arrayList.add((Integer)arrayList4.get(n2));
            arrayList.add((Integer)arrayList5.get(n2));
            arrayList.add((Integer)arrayList6.get(n2));
            arrayList.add((Integer)arrayList7.get(n2));
            ++n2;
        }
        return arrayList;
    }

    public static ArrayList An() {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        ArrayList arrayList2 = a.ac(0, 4);
        ArrayList arrayList3 = a.ac(5, 9);
        ArrayList arrayList4 = a.ac(10, 14);
        ArrayList arrayList5 = a.ac(15, 19);
        ArrayList arrayList6 = a.ac(20, 24);
        ArrayList arrayList7 = a.ac(25, 29);
        int n2 = 0;
        while (n2 < 5) {
            arrayList.add((Integer)arrayList2.get(n2));
            arrayList.add((Integer)arrayList3.get(n2));
            arrayList.add((Integer)arrayList4.get(n2));
            arrayList.add((Integer)arrayList5.get(n2));
            arrayList.add((Integer)arrayList6.get(n2));
            arrayList.add((Integer)arrayList7.get(n2));
            ++n2;
        }
        return arrayList;
    }

    public static ArrayList Ao() {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        ArrayList arrayList2 = a.ac(0, 8);
        ArrayList arrayList3 = a.ac(9, 17);
        ArrayList arrayList4 = a.ac(18, 26);
        ArrayList arrayList5 = a.ac(27, 35);
        ArrayList arrayList6 = a.ac(36, 44);
        ArrayList arrayList7 = a.ac(45, 53);
        int n2 = 0;
        while (n2 < 9) {
            arrayList.add((Integer)arrayList2.get(n2));
            arrayList.add((Integer)arrayList3.get(n2));
            arrayList.add((Integer)arrayList4.get(n2));
            arrayList.add((Integer)arrayList5.get(n2));
            arrayList.add((Integer)arrayList6.get(n2));
            arrayList.add((Integer)arrayList7.get(n2));
            ++n2;
        }
        return arrayList;
    }

    public static ArrayList ad(int n2, int n3) {
        int n4 = n2 - 1;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        ArrayList arrayList2 = null;
        ArrayList arrayList3 = null;
        ArrayList arrayList4 = null;
        ArrayList arrayList5 = null;
        arrayList2 = a.ac(0, n4);
        arrayList4 = a.ac(n2, n2 + n4);
        arrayList3 = a.ac(2 * n2, 2 * n2 + n4);
        arrayList5 = a.ac(3 * n2, 3 * n2 + n4);
        int n5 = 0;
        while (n5 < n2) {
            arrayList.add((Integer)arrayList2.get(n5));
            arrayList.add((Integer)arrayList3.get(n5));
            arrayList.add((Integer)arrayList4.get(n5));
            arrayList.add((Integer)arrayList5.get(n5));
            ++n5;
        }
        return arrayList;
    }
}

