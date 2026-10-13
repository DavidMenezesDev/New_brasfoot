/*
 * Decompiled with CFR 0.152.
 */
package components;

public class NumberFormat {
    public static final String PB = ",";
    public static final String PC = ".";
    public static final char PD = '-';
    public static final char PE = '(';
    public static final char PF = ')';
    public static final String PG = "k";
    public static final String PH = "m";
    public static final String PJ = "b";
    public static final int PK = 0;
    public static final int PL = 1;
    public static final int PM = 2;
    public static final int PN = 3;
    public static final int PO = 0;
    public static final int PP = 1;
    public static final int PQ = 2;
    public static final int PR = -1;
    private String PS = ".";
    private boolean PT = true;
    private String PU = ",";
    private String PV = ".";
    private boolean PW = false;
    private String PX = "$";
    private int PY = 0;
    private int PZ = 0;
    private boolean Qa = false;
    private int Qb = 0;
    private boolean Qc = false;
    private boolean Qd = false;
    private boolean Qe = false;

    private NumberFormat() {
    }

    public static NumberFormat ud() {
        NumberFormat numberFormat = new NumberFormat();
        return numberFormat;
    }

    public static NumberFormat ue() {
        return NumberFormat.b("$", true);
    }

    public static NumberFormat N(String string) {
        return NumberFormat.b(string, true);
    }

    public static NumberFormat b(String string, boolean bl2) {
        NumberFormat numberFormat = new NumberFormat();
        numberFormat.ay(true);
        numberFormat.setCurrencySymbol(string);
        if (!bl2) {
            numberFormat.Q(PB);
            numberFormat.R(PC);
        }
        numberFormat.dM(2);
        return numberFormat;
    }

    public static NumberFormat uf() {
        NumberFormat numberFormat = new NumberFormat();
        numberFormat.ax(false);
        numberFormat.dM(0);
        return numberFormat;
    }

    public static NumberFormat ug() {
        NumberFormat numberFormat = new NumberFormat();
        numberFormat.az(true);
        numberFormat.dM(2);
        numberFormat.ax(false);
        return numberFormat;
    }

    public String format(String string) {
        return this.k(this.O(string));
    }

    public double O(String string) {
        return NumberFormat.c(string, this.PS);
    }

    public static double b(String string, String string2) {
        return NumberFormat.c(string, string2);
    }

    public static double parseDouble(String string) {
        return NumberFormat.b(string, PC);
    }

    public void P(String string) {
        this.PS = string == null ? PC : string;
    }

    public void dK(int n2) {
        this.PZ = n2;
    }

    public void aw(boolean bl2) {
        this.Qa = bl2;
    }

    public void ax(boolean bl2) {
        this.PT = bl2;
    }

    public void Q(String string) {
        this.PV = string;
    }

    public void R(String string) {
        this.PU = string;
    }

    public void ay(boolean bl2) {
        this.PW = bl2;
    }

    public void setCurrencySymbol(String string) {
        this.PX = string;
    }

    public void dL(int n2) {
        this.PY = n2;
    }

    public void az(boolean bl2) {
        this.Qe = bl2;
    }

    public void dM(int n2) {
        this.Qc = n2 != -1;
        this.Qb = n2 < 0 ? 0 : n2;
    }

    public void aA(boolean bl2) {
        this.Qd = bl2;
    }

    private String S(String string) {
        int n2;
        String string2 = string;
        int n3 = string2.indexOf(PC);
        String string3 = "";
        if (n3 != -1) {
            string3 = String.valueOf(this.PV) + string2.substring(n3 + 1, string2.length());
            string2 = string2.substring(0, n3);
        }
        int n4 = n2 = string2.length();
        while (n4 > 0) {
            string3 = String.valueOf(string2.charAt(n4 - 1)) + string3;
            if (n4 != 1 && (n2 - n4 + 1) % 3 == 0) {
                string3 = String.valueOf(this.PU) + string3;
            }
            --n4;
        }
        return string3;
    }

    protected String k(double d2) {
        if (this.Qe) {
            d2 *= 100.0;
        }
        String string = this.Qc ? NumberFormat.toFixed(Math.abs(this.l(d2)), this.Qb) : Double.toString(d2);
        string = this.PT ? this.S(string) : string.replaceAll("\\.", this.PV);
        String string2 = "";
        String string3 = "";
        String string4 = "";
        String string5 = "";
        String string6 = "";
        String string7 = "";
        String string8 = "";
        String string9 = "";
        String string10 = "" + (this.PZ == 2 ? (char)'(' : '-');
        String string11 = "" + (this.PZ == 2 ? (char)')' : '-');
        if (this.PY == 0) {
            if (d2 < 0.0) {
                if (this.PZ == 0 || this.PZ == 2) {
                    string5 = string10;
                }
                if (this.PZ == 1 || this.PZ == 2) {
                    string6 = string11;
                }
            }
            if (this.PW) {
                string2 = this.PX;
            }
        } else if (this.PY == 1) {
            if (d2 < 0.0) {
                if (this.PZ == 0 || this.PZ == 2) {
                    string3 = string10;
                }
                if (this.PZ == 1 || this.PZ == 2) {
                    string8 = string11;
                }
            }
            if (this.PW) {
                string4 = this.PX;
            }
        } else if (this.PY == 2) {
            if (d2 < 0.0) {
                if (this.PZ == 0 || this.PZ == 2) {
                    string3 = string10;
                }
                if (this.PZ == 1 || this.PZ == 2) {
                    string8 = string11;
                }
            }
            if (this.PW) {
                string7 = this.PX;
            }
        } else if (this.PY == 3) {
            if (d2 < 0.0) {
                if (this.PZ == 0 || this.PZ == 2) {
                    string5 = string10;
                }
                if (this.PZ == 1 || this.PZ == 2) {
                    string6 = string11;
                }
            }
            if (this.PW) {
                string9 = this.PX;
            }
        }
        string = String.valueOf(string2) + string3 + string4 + string5 + string + string6 + string7 + string8 + string9 + (this.Qe ? "%" : "");
        if (this.Qa && d2 < 0.0) {
            string = "<font color='red'>" + string + "</font>";
        }
        return string;
    }

    private double l(double d2) {
        double d3 = Math.pow(10.0, this.Qb);
        double d4 = d2 * d3;
        d4 = this.Qd ? (d4 >= 0.0 ? Math.floor(d4) : Math.ceil(d4)) : (double)Math.round(d4);
        return d4 / d3;
    }

    private static native String toFixed(double var0, int var2);

    private static double c(String string, String string2) {
        Double d2;
        String string3 = string;
        boolean bl2 = false;
        if (string3.indexOf(37) != -1) {
            string3 = string3.replaceAll("\\%", "");
            bl2 = true;
        }
        string3 = string3.toLowerCase().replaceAll(PJ, "000000000");
        string3 = string3.replaceAll(PH, "000000");
        string3 = string3.replaceAll(PG, "000");
        String string4 = "[^\\" + string2 + "\\d\\-\\+\\(\\)eE]";
        int n2 = (string3 = string3.replaceAll(string4, "")).indexOf(string2);
        if (n2 != -1) {
            string3 = String.valueOf(string3.substring(0, n2)) + PC + string3.substring(n2 + string2.length()).replaceAll("\\" + string2, "");
        }
        if (string3.charAt(string3.length() - 1) == '-') {
            string3 = string3.substring(0, string3.length() - 1);
            string3 = String.valueOf('-') + string3;
        } else if (string3.charAt(0) == '(' && string3.charAt(string3.length() - 1) == ')') {
            string3 = string3.substring(1, string3.length() - 1);
            string3 = String.valueOf('-') + string3;
        }
        try {
            d2 = new Double(string3);
            if (d2.isInfinite() || d2.isNaN()) {
                d2 = new Double(0.0);
            }
        }
        catch (NumberFormatException numberFormatException) {
            d2 = new Double(0.0);
        }
        return bl2 ? d2 / 100.0 : d2;
    }
}

