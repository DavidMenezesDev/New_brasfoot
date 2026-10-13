/*
 * Decompiled with CFR 0.152.
 */
package forms;

import java.util.Calendar;
import java.util.Random;

public class w {
    private static Random Yc = new Random(Calendar.getInstance().getTimeInMillis() + Thread.currentThread().getId());

    public static double j(double d2, double d3) {
        double d4;
        boolean bl2 = false;
        if (d2 < 1.0) {
            double d5;
            double d6 = 1.0 / d2;
            double d7 = (1.0 - d2) * Math.pow(d2, d2 / (1.0 - d2));
            do {
                double d8;
                double d9 = Yc.nextDouble();
                double d10 = Yc.nextDouble();
                double d11 = -Math.log(d9);
                if (!(d11 + (d8 = -Math.log(d10)) >= d7 + (d5 = Math.pow(d11, d6)))) continue;
                bl2 = true;
            } while (!bl2);
            return d5 * d3;
        }
        double d12 = d2 - Math.log(4.0);
        double d13 = d2 + Math.sqrt(2.0 * d2 - 1.0);
        double d14 = Math.sqrt(2.0 * d2 - 1.0);
        double d15 = 1.0 + Math.log(4.5);
        do {
            double d16;
            double d17 = Yc.nextDouble();
            double d18 = Yc.nextDouble();
            double d19 = 1.0 / d14 * Math.log(d18 / (1.0 - d18));
            double d20 = d12 + d13 * d19 - (d4 = d2 * Math.exp(d19));
            if (!(d20 >= 4.5 * (d16 = d17 * d18 * d18) - d15) && !(d20 >= Math.log(d16))) continue;
            bl2 = true;
        } while (!bl2);
        return d4 * d3;
    }
}

