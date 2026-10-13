/*
 * Decompiled with CFR 0.152.
 */
package forms;

import forms.b;
import forms.f;
import forms.g;
import forms.t;
import forms.u;
import java.util.ArrayList;

public class x {
    private boolean Yd = false;
    private boolean Ye = false;
    private boolean Yf = false;
    private boolean Yg = true;
    private boolean Yh = false;
    private boolean Yi = true;
    private boolean Yj = false;
    private boolean Yk = false;
    private ArrayList Yl = new ArrayList();
    private boolean Ym = false;
    private ArrayList Yn = new ArrayList();
    private boolean Yo = false;
    private static boolean Yp = false;
    private static boolean Yq = false;
    private static boolean Yr = true;
    private static boolean Ys = true;
    private static int Yt = 500;
    private static double Yu = 1.0E-8;
    public static final double Yv = 1.0E-300;
    private static boolean Yw = false;
    private static int Yx = 6;
    private static double[] Yy = new double[]{1.000000000190015, 76.18009172947146, -86.50532032941678, 24.01409824083091, -1.231739572450155, 0.001208650973866179, -5.395239384953E-6};
    private static double Yz = 5.0;
    private static int YA = 1000;
    private static double YB = 1.0E-8;
    private static double YC = 1.0001;

    public static double[] a(double d2, double d3, int n2) {
        if (d3 < 1.0) {
            throw new IllegalArgumentException("The rate parameter, " + d3 + "must be equal to or greater than one");
        }
        if (d3 - (double)Math.round(d3) != 0.0) {
            throw new IllegalArgumentException("kay must, mathematically, be an integer even though it may be entered as a double\nTry the Gamma distribution instead of the Erlang distribution");
        }
        return x.b(0.0, 1.0 / d2, d3, n2);
    }

    public static double[] a(double d2, int n2, int n3, long l2) {
        if (n2 < 1) {
            throw new IllegalArgumentException("The rate parameter, " + n2 + "must be equal to or greater than one");
        }
        return x.a(0.0, 1.0 / d2, n2, n3, l2);
    }

    public static double[] a(double d2, long l2, int n2, long l3) {
        if (l2 < 1L) {
            throw new IllegalArgumentException("The rate parameter, " + l2 + "must be equal to or greater than one");
        }
        return x.a(0.0, 1.0 / d2, l2, n2, l3);
    }

    public static double[] a(double d2, double d3, int n2, long l2) {
        if (d3 < 1.0) {
            throw new IllegalArgumentException("The rate parameter, " + d3 + "must be equal to or greater than one");
        }
        if (d3 - (double)Math.round(d3) != 0.0) {
            throw new IllegalArgumentException("kay must, mathematically, be an integer even though it may be entered as a double\nTry the Gamma distribution instead of the Erlang distribution");
        }
        return x.a(0.0, 1.0 / d2, d3, n2, l2);
    }

    public static double[] b(double d2, double d3, double d4, int n2) {
        if (d3 <= 0.0) {
            throw new IllegalArgumentException("The scale parameter, " + d3 + "must be greater than zero");
        }
        if (d4 <= 0.0) {
            throw new IllegalArgumentException("The shape parameter, " + d4 + "must be greater than zero");
        }
        t t2 = new t();
        return t2.a(d2, d3, d4, n2);
    }

    public static double[] a(double d2, double d3, double d4, int n2, long l2) {
        if (d3 <= 0.0) {
            throw new IllegalArgumentException("The scale parameter, " + d3 + "must be greater than zero");
        }
        if (d4 <= 0.0) {
            throw new IllegalArgumentException("The shape parameter, " + d4 + "must be greater than zero");
        }
        t t2 = new t(l2);
        return t2.a(d2, d3, d4, n2);
    }

    public static double x(double d2) {
        double d3 = d2;
        double d4 = d2 + Yz + 0.5;
        double d5 = Yy[0];
        double d6 = 0.0;
        if (d2 >= 0.0) {
            d4 = Math.pow(d4, d2 + 0.5) * Math.exp(-d4);
            int n2 = 1;
            while (n2 <= Yx) {
                d5 += Yy[n2] / (d3 += 1.0);
                ++n2;
            }
            d6 = d4 * Math.sqrt(Math.PI * 2) * d5 / d2;
        } else {
            d6 = -Math.PI / (d2 * x.y(-d2) * Math.sin(Math.PI * d2));
        }
        return d6;
    }

    public static double y(double d2) {
        double d3 = d2;
        double d4 = d2 + Yz + 0.5;
        double d5 = Yy[0];
        double d6 = 0.0;
        if (d2 >= 0.0) {
            d4 = Math.pow(d4, d2 + 0.5) * Math.exp(-d4);
            int n2 = 1;
            while (n2 <= Yx) {
                d5 += Yy[n2] / (d3 += 1.0);
                ++n2;
            }
            d6 = d4 * Math.sqrt(Math.PI * 2) * d5 / d2;
        } else {
            d6 = -Math.PI / (d2 * x.y(-d2) * Math.sin(Math.PI * d2));
        }
        return d6;
    }

    public static double xW() {
        return Yz;
    }

    public static int xX() {
        return Yx;
    }

    public static double a(double d2, double d3, double d4, double d5) {
        if (d5 < d2) {
            throw new IllegalArgumentException("The upper limit, " + d5 + "must be equal to or greater than the location parameter, " + d2);
        }
        if (d3 <= 0.0) {
            throw new IllegalArgumentException("The scale parameter, " + d3 + "must be greater than zero");
        }
        if (d4 <= 0.0) {
            throw new IllegalArgumentException("The shape parameter, " + d4 + "must be greater than zero");
        }
        double d6 = (d5 - d2) / d3;
        return x.m(d4, d6);
    }

    public static double k(double d2, double d3) {
        if (d3 < 0.0) {
            throw new IllegalArgumentException("The upper limit, " + d3 + "must be equal to or greater than zero");
        }
        if (d2 <= 0.0) {
            throw new IllegalArgumentException("The shape parameter, " + d2 + "must be greater than zero");
        }
        return x.m(d2, d3);
    }

    public static double l(double d2, double d3) {
        return x.m(d2, d3);
    }

    public static double m(double d2, double d3) {
        if (d2 < 0.0 || d3 < 0.0) {
            throw new IllegalArgumentException("\nFunction defined only for a >= 0 and x>=0");
        }
        boolean bl2 = Yw;
        Yw = true;
        double d4 = 0.0;
        if (d3 != 0.0 && (d4 = d3 < d2 + 1.0 ? x.o(d2, d3) : x.p(d2, d3)) != d4) {
            d4 = 1.0 - x.n(d2, d3);
        }
        if (d4 < 0.0) {
            d4 = 0.0;
        }
        Yw = bl2;
        return d4;
    }

    private static double n(double d2, double d3) {
        double d4 = 0.0;
        double d5 = 100.0 * d2;
        double d6 = d5 - d3;
        double d7 = 0.0;
        if (d5 > d3 && d6 > 100.0) {
            d7 = d6 / 1000.0;
        } else {
            d5 = d3 + 100.0;
            d6 = 100.0;
            d7 = 0.1;
        }
        int n2 = (int)Math.round(d6 / d7);
        d7 = d6 / (double)n2;
        b b2 = new b();
        b2.n(d2);
        b2.o(x.z(d2));
        f f2 = new f(b2);
        double d8 = d3;
        double d9 = d3 + d7;
        f2.d(d8, d9);
        d4 = f2.eS(64);
        boolean bl2 = true;
        int n3 = 1;
        while (n3 < n2) {
            d8 = d9;
            d9 = d8 + d7;
            f2.d(d8, d9);
            d4 += f2.eS(64);
            ++n3;
        }
        return d4;
    }

    public static double z(double d2) {
        double d3 = d2;
        double d4 = 0.0;
        double d5 = d2 + Yz + 0.5;
        double d6 = Yy[0];
        if (d2 >= 0.0) {
            d5 -= (d2 + 0.5) * Math.log(d5);
            int n2 = 1;
            while (n2 <= Yx) {
                d6 += Yy[n2] / (d3 += 1.0);
                ++n2;
            }
            d4 = Math.log(Math.sqrt(Math.PI * 2) * d6 / d2) - d5;
        } else {
            d4 = Math.PI / (x.y(1.0 - d2) * Math.sin(Math.PI * d2));
            if (d4 != Double.POSITIVE_INFINITY && d4 != Double.NEGATIVE_INFINITY) {
                if (d4 < 0.0) {
                    throw new IllegalArgumentException("\nThe gamma function is negative");
                }
                d4 = Math.log(d4);
            }
        }
        return d4;
    }

    public static double o(double d2, double d3) {
        if (d2 < 0.0 || d3 < 0.0) {
            throw new IllegalArgumentException("\nFunction defined only for a >= 0 and x>=0");
        }
        if (d3 >= d2 + 1.0) {
            throw new IllegalArgumentException("\nx >= a+1   use Continued Fraction Representation");
        }
        double d4 = 0.0;
        if (d3 != 0.0) {
            double d5;
            int n2 = 0;
            boolean bl2 = true;
            double d6 = d2;
            double d7 = d5 = 1.0 / d2;
            double d8 = x.A(d2);
            while (bl2) {
                ++n2;
                d5 += (d7 *= d3 / (d2 += 1.0));
                if (Math.abs(d7) < Math.abs(d5) * YB) {
                    d4 = d5 * Math.exp(-d3 + d6 * Math.log(d3) - d8);
                    bl2 = false;
                }
                if (n2 < YA) continue;
                bl2 = false;
                d4 = Double.NaN;
                if (Yw) continue;
                System.out.println("\nMaximum number of iterations were exceeded in Stat.incompleteGammaSer().");
                System.out.println("NaN returned.\nIncrement = " + String.valueOf(d7) + ".");
                System.out.println("Sum = " + String.valueOf(d5) + ".\nTolerance =  " + String.valueOf(YB));
            }
        }
        return d4;
    }

    public static double p(double d2, double d3) {
        if (d2 < 0.0 || d3 < 0.0) {
            throw new IllegalArgumentException("\nFunction defined only for a >= 0 and x>=0");
        }
        if (d3 < d2 + 1.0) {
            throw new IllegalArgumentException("\nx < a+1   Use Series Representation");
        }
        double d4 = 0.0;
        if (d3 != 0.0) {
            int n2 = 0;
            double d5 = 0.0;
            boolean bl2 = true;
            double d6 = x.A(d2);
            double d7 = 0.0;
            double d8 = 0.0;
            double d9 = d3 - d2 + 1.0;
            double d10 = 1.0 / d9;
            double d11 = 9.999999999999999E299;
            double d12 = d10;
            while (bl2) {
                if (Math.abs(d10 = (d7 = -(d5 = (double)(++n2)) * (d5 - d2)) * d10 + (d9 += 2.0)) < 1.0E-300) {
                    d10 = 1.0E-300;
                }
                if (Math.abs(d11 = d9 + d7 / d11) < 1.0E-300) {
                    d11 = 1.0E-300;
                }
                d10 = 1.0 / d10;
                d8 = d10 * d11;
                d12 *= d8;
                if (Math.abs(d8 - 1.0) < YB) {
                    bl2 = false;
                }
                if (n2 < YA) continue;
                bl2 = false;
                d4 = 0.0;
                if (Yw) continue;
                System.out.println("\nMaximum number of iterations were exceeded in Stat.incompleteGammaFract().");
                System.out.println("NaN returned.\nIncrement - 1 = " + String.valueOf(d8 - 1.0) + ".");
                System.out.println("Tolerance =  " + String.valueOf(YB));
            }
            d4 = 1.0 - Math.exp(-d3 + d2 * Math.log(d3) - d6) * d12;
        }
        return d4;
    }

    public static double A(double d2) {
        double d3 = d2;
        double d4 = 0.0;
        double d5 = d2 + Yz + 0.5;
        double d6 = Yy[0];
        if (d2 >= 0.0) {
            d5 -= (d2 + 0.5) * Math.log(d5);
            int n2 = 1;
            while (n2 <= Yx) {
                d6 += Yy[n2] / (d3 += 1.0);
                ++n2;
            }
            d4 = Math.log(Math.sqrt(Math.PI * 2) * d6 / d2) - d5;
        } else {
            d4 = Math.PI / (x.y(1.0 - d2) * Math.sin(Math.PI * d2));
            if (d4 != Double.POSITIVE_INFINITY && d4 != Double.NEGATIVE_INFINITY) {
                if (d4 < 0.0) {
                    throw new IllegalArgumentException("\nThe gamma function is negative");
                }
                d4 = Math.log(d4);
            }
        }
        return d4;
    }

    public static double[] B(double d2) {
        double d3;
        double d4;
        g g2;
        double d5 = 0.8856031944108839;
        double d6 = 1.4616321399961483;
        if (d2 < d5) {
            throw new IllegalArgumentException("Entered argument (gamma) value, " + d2 + ", must be equal to or greater than 0.8856031944108839 - this method does not handle the negative domain");
        }
        double[] dArray = new double[2];
        double d7 = 1.0E-12;
        if (d2 == 1.0) {
            dArray[0] = 1.0;
        } else if (d2 == d5) {
            dArray[0] = d6;
        } else {
            g2 = new g();
            g2.Wu = d2;
            d4 = 0.0;
            d3 = d6;
            u u2 = new u();
            u2.xV();
            u2.w(d7);
            u2.xL();
            u2.xP();
            u2.xR();
            dArray[0] = u2.a(g2, d4, d3);
        }
        if (d2 == 1.0) {
            dArray[1] = 2.0;
        } else if (d2 == d5) {
            dArray[1] = d6;
        } else {
            g2 = new g();
            g2.Wu = d2;
            d4 = d6;
            d3 = 2.0;
            double d8 = 2.0;
            double d9 = x.y(d8);
            if (d2 > d9) {
                boolean bl2 = true;
                while (bl2) {
                    d9 = x.y(d8 += 1.0);
                    if (!(d2 <= d9)) continue;
                    d3 = d8;
                    d4 = d8 - 1.0;
                    bl2 = false;
                }
            }
            u u3 = new u();
            u3.xV();
            u3.w(d7);
            u3.xL();
            u3.xP();
            u3.xR();
            dArray[1] = u3.a(g2, d4, d3);
        }
        return dArray;
    }
}

