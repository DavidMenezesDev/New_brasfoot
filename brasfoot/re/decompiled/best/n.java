/*
 * Decompiled with CFR 0.152.
 */
package best;

import best.S;
import best.ac;
import best.ad;
import best.h;
import best.o;
import d.ap;
import d.av;
import e.t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public abstract class n {
    private static JFrame cC = null;
    private static JFrame cD = null;
    private static ArrayList cE = new ArrayList();
    private static ArrayList cF = new ArrayList();
    private static d.n cG = null;
    private static final String cH = "AAAAAAACEEEEIIIIDNOOOOO\u00d7\u00d8UUUUYI\u00dfaaaaaaaceeeeiiiionooooo\u00f7ouuuuy\u00feyAaAaAaCcCcCcCcDdDdEeEeEeEeEeGgGgGgGgHhHhIiIiIiIiIiJjJjKkkLlLlLlLlLlNnNnNnnNnOoOoOoOoRrRrRrSsSsSsSsTtTtTtUuUuUuUuUuUuWwYyYZzZzZzF";
    private static final String cI = "abcdefghijklmnopqrstuvxzyw0123456789";
    private static final String cJ = "fitbzvengwpkycmuqhldxjrasofitbzvengw";
    public static String cK = System.getProperty("user.dir");
    public static Comparator cL = new o();

    public static String f(String string) {
        char[] cArray = new char[string.length()];
        int n2 = 0;
        while (n2 < string.length()) {
            char c2 = string.charAt(n2);
            if (c2 >= '\u00c0' && c2 <= '\u017f') {
                c2 = cH.charAt(c2 - 192);
            }
            cArray[n2] = c2;
            ++n2;
        }
        return new String(cArray);
    }

    public static void cU() {
        int n2 = 0;
        while (n2 < ac.jz()) {
            ad ad2 = new ad();
            ad2.setPais(n2);
            ad2.setNome(ac.valueOf("P" + n2).getNome());
            ad2.s(n.f(ac.valueOf("P" + n2).getNome()));
            ad2.r(ac.valueOf("P" + n2).jA());
            ad2.bn(ac.valueOf("P" + n2).gg());
            ad2.bo(n2);
            cF.add(ad2);
            ++n2;
        }
        Collections.sort(cF, cL);
    }

    public static void g(String string) {
        try {
            UIManager.LookAndFeelInfo[] lookAndFeelInfoArray = UIManager.getInstalledLookAndFeels();
            int n2 = lookAndFeelInfoArray.length;
            int n3 = 0;
            while (n3 < n2) {
                UIManager.LookAndFeelInfo lookAndFeelInfo = lookAndFeelInfoArray[n3];
                if (string.equals(lookAndFeelInfo.getName())) {
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
    }

    public static void cV() {
        cE.clear();
        av.iD();
        int n2 = 0;
        while (n2 < n.cZ().size()) {
            ((t)n.cZ().get(n2)).setNomep(n.f(ac.valueOf("P" + Integer.toString(((t)n.cZ().get(n2)).getPais())).getNome()));
            ++n2;
        }
    }

    public static void cW() {
        cG = new d.n();
        cG.setVisible(true);
        ap ap2 = new ap();
        cG.wJ().setModel(ap2);
        cG.wH();
        n.cG.Vg.setRowSelectionInterval(0, 0);
        if (cG.wI().getJogadores().size() > 0) {
            cG.wJ().setRowSelectionInterval(0, 0);
        }
    }

    public static int G(int n2) {
        int n3 = 0;
        while (n3 < cF.size()) {
            if (n2 == ((ad)cF.get(n3)).getPais()) {
                return n3;
            }
            ++n3;
        }
        return 0;
    }

    public static int h(String string) {
        int n2 = 0;
        while (n2 < cF.size()) {
            if (string.equals(((ad)cF.get(n2)).getNome())) {
                return n2;
            }
            ++n2;
        }
        return 0;
    }

    public static void a(t t2) {
        t2.setNomep(n.f(ac.valueOf("P" + Integer.toString(t2.getPais())).getNome()));
    }

    public static void cX() {
        S.cX();
    }

    public static int H(int n2) {
        if (n2 >= 0 && n2 < cF.size()) {
            return ((ad)cF.get(n2)).getPais();
        }
        return 29;
    }

    public static ArrayList cY() {
        return cF;
    }

    public static ArrayList cZ() {
        return cE;
    }

    public static d.n da() {
        return cG;
    }

    public static JFrame db() {
        return cC;
    }

    public static void a(JFrame jFrame) {
        cC = jFrame;
    }

    public static JFrame dc() {
        return cD;
    }

    public static void b(JFrame jFrame) {
        cD = jFrame;
    }
}

