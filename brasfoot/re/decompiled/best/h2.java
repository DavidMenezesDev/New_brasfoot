/*
 * Decompiled with CFR 0.152.
 */
package best;

import a.gq;
import best.D;
import best.M;
import best.as;
import best.h;
import best.n;
import c.a;
import components.ar;
import java.awt.Window;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class h2 {
    public static void main(String[] stringArray) {
        Object object;
        Thread.setDefaultUncaughtExceptionHandler(new ar());
        try {
            UIManager.LookAndFeelInfo[] lookAndFeelInfoArray = UIManager.getInstalledLookAndFeels();
            int n2 = lookAndFeelInfoArray.length;
            int n3 = 0;
            while (n3 < n2) {
                object = lookAndFeelInfoArray[n3];
                if ("Nimbus".equals(((UIManager.LookAndFeelInfo)object).getName())) {
                    UIManager.setLookAndFeel(((UIManager.LookAndFeelInfo)object).getClassName());
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
        h2.mg();
        new M(true);
        n.cU();
        object = new gq();
        ((Window)object).pack();
        ((Window)object).setSize(532, 300);
        ((Window)object).setLocationRelativeTo(null);
        ((Window)object).setVisible(true);
        a.vH();
        h2.ml();
    }

    public static void ml() {
        Thread thread = new Thread(new as());
        thread.start();
    }

    public static void mg() {
        Preferences preferences = Preferences.userRoot();
        preferences = preferences.node("systemacxyz22");
        String string = preferences.get("n", "nf");
        int n2 = preferences.getInt("nr", -1);
        if (string.length() > 2 && n2 > 0) {
            int n3;
            D.n(string);
            if (D.k(string)) {
                D.n("Brasfoot 2016");
            }
            D.eT();
            n2 = h2.a(n2, string);
            int n4 = D.eX();
            String string2 = System.getProperty("sun.arch.data.model");
            int n5 = Integer.parseInt(string2);
            a.SU = n3 = preferences.getInt("vSave", n5);
            if (n2 == n4) {
                a.ey(new Random().nextInt(1080) + 1920);
            } else {
                a.ey(new Random().nextInt(800) + 600);
            }
        }
    }

    private static int a(int n2, String string) {
        char c2 = string.charAt(0);
        int n3 = c2 * 31348;
        return n2 + n3;
    }
}

