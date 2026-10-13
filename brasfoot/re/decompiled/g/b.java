/*
 * Decompiled with CFR 0.152.
 */
package g;

import best.F;
import best.H;
import best.al;
import best.ap;
import best.at;
import c.a;
import java.util.ArrayList;

public abstract class b {
    public static void Af() {
        int n2;
        ArrayList<at> arrayList = new ArrayList<at>();
        int n3 = 0;
        while (n3 < a.SR.R().size()) {
            n2 = 0;
            while (n2 < ((best.a)a.SR.R().get(n3)).t().size()) {
                if (!arrayList.contains(((best.a)a.SR.R().get(n3)).t().get(n2))) {
                    arrayList.add((at)((best.a)a.SR.R().get(n3)).t().get(n2));
                }
                ++n2;
            }
            ++n3;
        }
        n3 = 0;
        while (n3 < arrayList.size()) {
            ((at)arrayList.get(n3)).az(n3);
            ++n3;
        }
        n3 = 0;
        while (n3 < a.SR.O().size()) {
            n2 = 0;
            while (n2 < ((F)a.SR.O().get(n3)).gH().size()) {
                if (((H)((F)a.SR.O().get(n3)).gH().get(n2)).gX() >= 0) {
                    int n4 = 0;
                    while (n4 < arrayList.size()) {
                        if (((H)((F)a.SR.O().get(n3)).gH().get(n2)).gX() == ((at)arrayList.get(n4)).gD()) {
                            ((H)((F)a.SR.O().get(n3)).gH().get(n2)).m((at)arrayList.get(n4));
                            break;
                        }
                        ++n4;
                    }
                }
                ++n2;
            }
            ++n3;
        }
    }

    public static void Ag() {
        int n2;
        ArrayList<at> arrayList = new ArrayList<at>();
        int n3 = 0;
        while (n3 < a.SR.R().size()) {
            n2 = 0;
            while (n2 < ((best.a)a.SR.R().get(n3)).t().size()) {
                if (!arrayList.contains(((best.a)a.SR.R().get(n3)).t().get(n2))) {
                    arrayList.add((at)((best.a)a.SR.R().get(n3)).t().get(n2));
                }
                ++n2;
            }
            ++n3;
        }
        n3 = 0;
        while (n3 < arrayList.size()) {
            ((at)arrayList.get(n3)).az(n3);
            ++n3;
        }
        n3 = 0;
        while (n3 < a.SR.O().size()) {
            n2 = 0;
            while (n2 < ((F)a.SR.O().get(n3)).gH().size()) {
                ((H)((F)a.SR.O().get(n3)).gH().get(n2)).gY();
                ++n2;
            }
            ++n3;
        }
    }

    public static void Ah() {
        int n2 = 0;
        while (n2 < a.SR.O().size()) {
            ((F)a.SR.O().get(n2)).fg();
            ++n2;
        }
        n2 = 0;
        while (n2 < a.SR.Q().size()) {
            ((F)a.SR.Q().get(n2)).fg();
            ++n2;
        }
        n2 = 0;
        while (n2 < a.SR.L().size()) {
            ((al)a.SR.L().get(n2)).fg();
            ++n2;
        }
    }

    public static void Ai() {
        int n2 = 0;
        int n3 = 0;
        while (n3 < a.SR.O().size()) {
            ((F)a.SR.O().get(n3)).az(n2);
            ((F)a.SR.O().get(n3)).aC(1);
            ++n2;
            ++n3;
        }
        n3 = 0;
        while (n3 < a.SR.Q().size()) {
            ((F)a.SR.Q().get(n3)).az(n2);
            ((F)a.SR.Q().get(n3)).aC(2);
            ++n2;
            ++n3;
        }
        n3 = 0;
        while (n3 < a.SR.bo().size()) {
            ((ap)a.SR.bo().get(n3)).mb();
            ++n3;
        }
    }

    public static void Aj() {
        int n2 = 0;
        while (n2 < a.SR.bo().size()) {
            ((ap)a.SR.bo().get(n2)).me();
            ++n2;
        }
    }
}

