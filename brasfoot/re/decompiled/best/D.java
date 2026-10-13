/*
 * Decompiled with CFR 0.152.
 */
package best;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.prefs.Preferences;

public class D {
    private static String dZ = null;
    private static String ea = null;
    private static int eb = 0;
    private static final String cH = "AAAAAAACEEEEIIIIDNOOOOO\u00d7\u00d8UUUUYI\u00dfaaaaaaaceeeeiiiionooooo\u00f7ouuuuy\u00feyAaAaAaCcCcCcCcDdDdEeEeEeEeEeGgGgGgGgHhHhIiIiIiIiIiJjJjKkkLlLlLlLlLlNnNnNnnNnOoOoOoOoRrRrRrSsSsSsSsTtTtTtUuUuUuUuUuUuWwYyYZzZzZzF";
    private static final String cI = "abcdefghijklmnopqrstuvxzyw0123456789";
    private static final String cJ = "fitbzvengwpkycmuqhldxjrasofitbzvengw";
    private static int ec = 0;

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

    public static void eS() {
        ea = dZ.toLowerCase();
        ea = ea.trim();
        ea = ea.replaceAll("\\s", "");
        ea = ea.replaceAll("`", "");
        ea = ea.replaceAll("'", "");
        ea = ea.replaceAll("\u00b4", "");
        ea = ea.replaceAll("\\.", "");
        if ((ea = D.f(ea)).equals("lucasgabrielvalentimgoncalves")) {
            ea = "";
        }
        ea = D.l(ea);
    }

    public static boolean k(String string) {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("zyyfcxzkbmllfcdml");
        arrayList.add("zyyfcxzklfcdml");
        arrayList.add("zyfcxzklfcdml");
        arrayList.add("zyfcxzkbmllfcdml");
        arrayList.add("ihflvmmdfyfagce");
        arrayList.add("ygtnzkbzkgyf");
        arrayList.add("vmeftfdj");
        arrayList.add("bfcgzkbzlmxlf");
        arrayList.add("vzkguzxtngbf");
        arrayList.add("wmfmuzbhmtfhbmam");
        arrayList.add("vzkguzozccgmymxhfbfcdfl");
        Preferences preferences = Preferences.userRoot();
        preferences = preferences.node("systemacxyz22");
        String string2 = preferences.get("newfk2", "");
        if (string2 != null && string2 != "") {
            List<String> list = Arrays.asList(string2.split(","));
            int n2 = 0;
            while (n2 < list.size()) {
                arrayList.add(list.get(n2));
                ++n2;
            }
        }
        return arrayList.contains(string);
    }

    public static String l(String string) {
        char[] cArray = string.toCharArray();
        int n2 = 0;
        while (n2 < string.length()) {
            if (cI.indexOf(string.charAt(n2)) >= 0) {
                cArray[n2] = cJ.charAt(cI.indexOf(string.charAt(n2)));
            }
            ++n2;
        }
        String string2 = new String(cArray);
        if (D.k(string2)) {
            string2 = "Brasfoot2016";
        }
        return string2;
    }

    public static int eT() {
        int n2;
        int n3;
        int n4 = 0;
        boolean bl2 = false;
        boolean bl3 = false;
        int n5 = 0;
        int n6 = 0;
        while (n6 < ea.length()) {
            n2 = n3 = ea.charAt(n6);
            n4 += n2 * ++n5 + (n5 + 3);
            ++n6;
        }
        n3 = n6 = (int)ea.charAt(1);
        int n7 = n2 = (int)ea.charAt(2);
        n4 *= n7 + n3 + 5;
        n4 = n4 * 12 + 331216;
        D.Y(n4);
        return n4;
    }

    public static int eU() {
        int n2;
        int n3;
        int n4 = 0;
        boolean bl2 = false;
        boolean bl3 = false;
        int n5 = 0;
        int n6 = 0;
        while (n6 < ea.length()) {
            n2 = n3 = ea.charAt(n6);
            if (n3 != 97) {
                n4 += n2 * ++n5 + (n5 + 3);
            }
            ++n6;
        }
        n3 = n6 = (int)ea.charAt(1);
        int n7 = n2 = (int)ea.charAt(2);
        n4 *= n7 + n3 + 5;
        n4 = n4 * 11 + 263874;
        D.Y(n4);
        return n4;
    }

    public static String eV() {
        return dZ;
    }

    public static void m(String string) {
        dZ = string;
    }

    public static String eW() {
        return ea;
    }

    public static void n(String string) {
        ea = string;
    }

    public static int eX() {
        return ec;
    }

    public static void Y(int n2) {
        ec = n2;
    }

    public static int eY() {
        return eb;
    }

    public static void Z(int n2) {
        eb = n2;
    }
}

