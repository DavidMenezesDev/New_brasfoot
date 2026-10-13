/*
 * Decompiled with CFR 0.152.
 */
package best;

import a.cD;
import best.D;
import best.E;
import best.F;
import best.R;
import best.Y;
import best.ae;
import best.ah;
import best.p;
import c.a;
import components.v;
import java.util.Random;
import javax.swing.JProgressBar;

public abstract class K {
    public static void a(boolean bl2, F f2, ah ah2) {
        int n2 = 5;
        if (ah2.kn().booleanValue()) {
            n2 = ah2.getDivisao() < 1 ? 5 : (ah2.getDivisao() == 1 ? 22 : (ah2.getDivisao() == 2 ? 17 : (ah2.getDivisao() == 3 ? 14 : 7)));
            if (ah2.gg() == 0) {
                n2 += 5;
            }
        } else {
            n2 = ah2.getReputacao() == 5 ? 20 : (ah2.getReputacao() == 4 ? 15 : (ah2.getReputacao() == 3 ? 12 : (ah2.getReputacao() == 2 ? 7 : 5)));
            if (ah2.gg() == 0) {
                n2 += 5;
            }
        }
        n2 += new Random().nextInt(5);
        int n3 = f2.fE();
        if (n3 > 100) {
            n3 = 100;
        }
        double d2 = (double)n3 / 100.0;
        int n4 = (int)Math.round((double)n2 * d2);
        int n5 = f2.fH() + n4;
        if (f2.fH() >= 9) {
            n5 += new Random().nextInt(10);
        }
        f2.ad(n5);
        if (a.SR.isHabilidadeIndividual()) {
            int n6 = 1;
            if (ah2.kn().booleanValue()) {
                switch (ah2.getDivisao()) {
                    case 1: {
                        n6 = 7;
                        break;
                    }
                    case 2: {
                        n6 = 3;
                        break;
                    }
                    case 3: {
                        n6 = 1;
                    }
                }
            } else {
                switch (ah2.getReputacao()) {
                    case 5: {
                        n6 = 7;
                        break;
                    }
                    case 4: {
                        n6 = 4;
                        break;
                    }
                    case 3: {
                        n6 = 1;
                        break;
                    }
                    case 2: {
                        n6 = 1;
                        break;
                    }
                    case 1: {
                        n6 = 1;
                    }
                }
            }
            int n7 = n5 - 5;
            if (n7 < 5) {
                n7 = 5;
            }
            f2.j(n7, n6);
        }
        f2.h(false);
        f2.ar(a.SR.H());
        f2.d(0.0);
        f2.a(180L, true);
        f2.fK();
        f2.fJ();
        if (f2.ff().booleanValue()) {
            if (new Random().nextInt(3) == 1) {
                f2.a(true);
            } else {
                f2.a(false);
            }
        } else if (f2.gm().booleanValue()) {
            f2.a(true);
            f2.j(false);
        } else if (new Random().nextInt(200) == 1) {
            f2.a(true);
        }
        if (f2.ff().booleanValue() && f2.fH() < 8) {
            f2.aq(8);
        }
        ah2.ky().remove(f2);
        ah2.ky().remove(f2);
        if (bl2) {
            a.SR.bA.remove(f2);
        }
        if (!ah2.kc().contains(f2)) {
            ah2.kc().add(f2);
        }
        if (!a.SR.O().contains(f2)) {
            a.SR.O().add(f2);
        }
        if (bl2) {
            a.SR.bB.add(f2);
        } else {
            a.SR.Q().remove(f2);
        }
        f2.b((JProgressBar)null);
    }

    public static void r(int n2, int n3) {
        int[] nArray = new int[]{3, 4, 4, 5, 4};
        int n4 = 0;
        while (n4 < nArray.length) {
            int n5 = 0;
            while (n5 < nArray[n4]) {
                F f2 = new F(n2);
                K.a(n3, f2, n4);
                ++n5;
            }
            ++n4;
        }
    }

    private static void a(int n2, F f2, int n3) {
        int n4 = 15;
        f2.setPosicao(n3);
        if (n2 <= 15) {
            n4 = n2;
        } else {
            switch (n2) {
                case 16: {
                    n4 = 17;
                    break;
                }
                case 17: {
                    n4 = 18;
                    break;
                }
                case 18: {
                    n4 = 19;
                    break;
                }
                case 19: {
                    n4 = 21;
                    break;
                }
                case 20: {
                    n4 = 25;
                    break;
                }
                case 21: {
                    n4 = 26;
                    break;
                }
                case 22: {
                    n4 = 27;
                    break;
                }
                case 23: {
                    n4 = 28;
                    break;
                }
                case 24: {
                    n4 = 29;
                    break;
                }
                case 25: {
                    n4 = 30;
                    break;
                }
                default: {
                    n4 = 0;
                }
            }
        }
        n4 = n4 - 5 + new Random().nextInt(8);
        f2.ad(n4);
        f2.h(false);
        f2.ar(a.SR.H());
        f2.d(0.0);
        f2.a(180L, true);
        if (a.SR.isHabilidadeIndividual()) {
            n4 = 1;
            int n5 = 1;
            if (n2 <= 15) {
                n4 = n2;
            } else {
                switch (n2) {
                    case 16: {
                        n4 = 17;
                        break;
                    }
                    case 17: {
                        n4 = 18;
                        break;
                    }
                    case 18: {
                        n4 = 19;
                        break;
                    }
                    case 19: {
                        n4 = 21;
                        break;
                    }
                    case 20: {
                        n4 = 25;
                        break;
                    }
                    case 21: {
                        n4 = 26;
                        break;
                    }
                    case 22: {
                        n4 = 27;
                        break;
                    }
                    case 23: {
                        n4 = 28;
                        break;
                    }
                    case 24: {
                        n4 = 29;
                        break;
                    }
                    case 25: {
                        n4 = 30;
                        break;
                    }
                    default: {
                        n4 = 0;
                    }
                }
            }
            n5 = n2 >= 20 ? 7 : (n2 >= 19 ? 4 : (n2 >= 17 ? 1 : 1));
            int n6 = n4;
            int n7 = n5;
            if (n6 > 4) {
                n6 -= 4;
            }
            f2.j(n6, n7);
        }
        int[] nArray = F.at(n3);
        f2.setCr1(nArray[0]);
        f2.setCr2(nArray[1]);
        f2.aq(new Random().nextInt(4) + 7);
        f2.setIdade(new Random().nextInt(12) + 18);
        f2.setLado(new Random().nextInt(2));
        f2.setStatus(0);
        f2.fG();
        f2.fK();
        f2.fJ();
    }

    public static void in() {
        Double d2;
        Double[] doubleArray = new Double[]{58.0, 18.0, 3.0};
        Double d3 = 2.0 * doubleArray[2];
        D.m(ae.getNome());
        D.eS();
        Double[] doubleArray2 = new Double[]{82.0, 22.0};
        Double[] doubleArray3 = new Double[]{70.0, 10.0};
        Double[] doubleArray4 = new Double[]{40.0, 20.0};
        int n2 = 0;
        int n3 = 1;
        int n4 = 0;
        int[] nArray = new int[2];
        int[] nArray2 = new int[2];
        R.eT();
        Double d4 = 2.0 * (double)n3;
        Double d5 = 4.0 * (double)n3;
        p.dv();
        int n5 = (int)Math.round((double)n3 / doubleArray[1]);
        int n6 = (int)Math.round((double)n3 / doubleArray[2]);
        int n7 = 0;
        while (n7 < n3) {
            if (n4 == 3) {
                int n8 = n2;
                nArray[n8] = nArray[n8] + 1;
                int n9 = n2;
                nArray2[n9] = nArray2[n9] + 1;
            }
            if (n4 == 2) {
                int n10 = n2;
                nArray2[n10] = nArray2[n10] + 1;
            }
            n2 = n2 == 0 ? 1 : 0;
            ++n7;
        }
        if (p.du() < 8) {
            cD.pg();
        }
        if ((d2 = Double.valueOf(123.0)) < d3) {
            throw new IllegalArgumentException("The upper limit, " + d2 + "must be equal to or greater than the location parameter, " + d3);
        }
        if (d5 <= 0.0) {
            throw new IllegalArgumentException("The scale parameter, " + d5 + "must be greater than zero");
        }
        if (d4 <= 0.0) {
            throw new IllegalArgumentException("The shape parameter, " + d4 + "must be greater than zero");
        }
        double d6 = 0.0;
        if (d5 > 0.0) {
            d6 = (d2 - d3) / d5;
        }
        E.a(d6);
        if (d6 == v.tX()) {
            Y.x(true);
        }
    }
}

