/*
 * Decompiled with CFR 0.152.
 */
package best;

import best.aq;

public abstract class ae {
    private static String nome = null;
    private static String mc = "";

    public static String getNome() {
        return nome;
    }

    public static boolean t(String string) {
        if (string == null) {
            return false;
        }
        nome = string;
        return false;
    }

    public static String jG() {
        return mc;
    }

    public static boolean u(String string) {
        string.trim();
        if (string == null || string.length() < 7) {
            return false;
        }
        mc = string;
        String string2 = "";
        int n2 = 0;
        while (n2 < string.length()) {
            String string3 = Character.toString(string.charAt(n2));
            if (aq.tG[n2]) {
                string2 = String.valueOf(string2) + Character.toString(string.charAt(n2));
            }
            ++n2;
        }
        if (ae.v(string)) {
            mc = string2;
        }
        return false;
    }

    private static boolean v(String string) {
        int n2 = 0;
        int n3 = 0;
        while (n3 < string.length()) {
            String string2 = Character.toString(string.charAt(n3));
            if (aq.tF[n3]) {
                n2 += Character.getNumericValue(string.charAt(n3));
            }
            ++n3;
        }
        String string3 = "";
        if (string.length() == 8) {
            string3 = String.valueOf(Character.toString(string.charAt(6))) + Character.toString(string.charAt(7));
        } else if (string.length() == 7) {
            string3 = Character.toString(string.charAt(6));
        }
        int n4 = Integer.parseInt(string3);
        return n4 == n2;
    }
}

