/*
 * Decompiled with CFR 0.152.
 */
package best;

import best.D;
import best.M;
import best.a;
import best.aq;
import best.n;
import best.p;
import f.H;
import f.r;
import f.t;
import f.u;
import f.v;
import f.w;
import f.x;
import f.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class h {
    public static void main(String[] stringArray) {
        try {
            UIManager.LookAndFeelInfo[] lookAndFeelInfoArray = UIManager.getInstalledLookAndFeels();
            int n2 = lookAndFeelInfoArray.length;
            int n3 = 0;
            while (n3 < n2) {
                UIManager.LookAndFeelInfo lookAndFeelInfo = lookAndFeelInfoArray[n3];
                if ("Metal".equals(lookAndFeelInfo.getName())) {
                    UIManager.setLookAndFeel(lookAndFeelInfo.getClassName());
                    break;
                }
                ++n3;
            }
        }
        catch (ClassNotFoundException classNotFoundException) {
            Logger.getLogger(h.class.getName()).log(Level.SEVERE, null, classNotFoundException);
        }
        catch (InstantiationException instantiationException) {
            Logger.getLogger(h.class.getName()).log(Level.SEVERE, null, instantiationException);
        }
        catch (IllegalAccessException illegalAccessException) {
            Logger.getLogger(h.class.getName()).log(Level.SEVERE, null, illegalAccessException);
        }
        catch (UnsupportedLookAndFeelException unsupportedLookAndFeelException) {
            Logger.getLogger(h.class.getName()).log(Level.SEVERE, null, unsupportedLookAndFeelException);
        }
        System.out.println(Runtime.getRuntime().maxMemory());
        System.out.println(Runtime.getRuntime().totalMemory());
        System.out.println(Runtime.getRuntime().freeMemory());
        new M(true);
        n.cU();
        h.mh();
        h.mg();
    }

    public static void mg() {
        Preferences preferences = Preferences.userRoot();
        preferences = preferences.node("systemacxy");
        String string = preferences.get("n", "nf");
        int n2 = preferences.getInt("nr", -1);
        D.n(string);
        D.eT();
        n2 = h.a(n2, string);
        int n3 = D.eX();
        if (n2 == n3) {
            c.a.ey(new Random().nextInt(300) + 150);
        } else {
            c.a.ey(new Random().nextInt(50) + 30);
        }
    }

    private static int a(int n2, String string) {
        char c2 = string.charAt(0);
        int n3 = c2 * 31348;
        return n2 + n3;
    }

    public static void mh() {
        long l2 = 0L;
        long l3 = 0L;
        new c.a();
        c.a.SR.bs = false;
        new forms.h().wT();
        c.a.vH();
        p.dd();
        c.a.SR.bi();
    }

    public static void mi() {
        new forms.h().wT();
    }

    private static void mk() {
        int[] nArray = new int[8];
        nArray[0] = 7;
        nArray[2] = 2;
        nArray[3] = 5;
        nArray[4] = 3;
        nArray[5] = 4;
        nArray[6] = 6;
        nArray[7] = 1;
        int[] nArray2 = nArray;
        int[] nArray3 = new int[32];
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        while (n4 < 4) {
            int n5 = 0;
            while (n5 < 8) {
                nArray3[n2] = nArray2[n5] + n3;
                ++n2;
                ++n5;
            }
            n3 += 8;
            ++n4;
        }
        System.out.println(Arrays.toString(nArray3));
    }

    private static void dk() {
        c.a.SR.a(new u());
        c.a.SR.aL().yq();
    }

    private static void dl() {
        c.a.SR.a(new y());
        c.a.SR.aQ().yq();
    }

    private static void dm() {
        c.a.SR.a(new w());
        c.a.SR.aP().yq();
    }

    private static void dn() {
        c.a.SR.a(new t());
        c.a.SR.aO().yq();
    }

    private static void do() {
        c.a.SR.a(new H());
        c.a.SR.aH().yq();
    }

    private static void dp() {
        c.a.SR.a(new x());
        c.a.SR.aK().yq();
    }

    private static void dq() {
        c.a.SR.a(new v());
        c.a.SR.aI().setNome(M.getString("ligaC"));
        c.a.SR.aI().yq();
    }

    private static void dr() {
        c.a.SR.a(new r());
        c.a.SR.aF().setNome(M.getString("lib"));
        c.a.SR.aF().yq();
    }

    public static void u() {
        int n2 = 0;
        n2 = 0;
        ArrayList arrayList = a.b(100);
        int n3 = 0;
        while (n3 < arrayList.size()) {
            System.out.println("Amistoso C:" + ++n2 + ") " + ((a)c.a.SR.R().get((Integer)arrayList.get(n3))).f() + " " + aq.rF[((a)c.a.SR.R().get((Integer)arrayList.get(n3))).a().get(7)] + " " + arrayList.get(n3));
            ++n3;
        }
        n2 = 0;
        arrayList = a.b(200);
        n3 = 0;
        while (n3 < arrayList.size()) {
            System.out.println("Amistoso S:" + ++n2 + ") " + ((a)c.a.SR.R().get((Integer)arrayList.get(n3))).f() + " " + aq.rF[((a)c.a.SR.R().get((Integer)arrayList.get(n3))).a().get(7)] + " " + arrayList.get(n3));
            ++n3;
        }
        n2 = 0;
        arrayList = a.b(10);
        n3 = 0;
        while (n3 < arrayList.size()) {
            System.out.println("Regional:" + ++n2 + ") " + ((a)c.a.SR.R().get((Integer)arrayList.get(n3))).f() + " " + aq.rF[((a)c.a.SR.R().get((Integer)arrayList.get(n3))).a().get(7)] + " " + arrayList.get(n3));
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
    }
}

