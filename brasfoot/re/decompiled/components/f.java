/*
 * Decompiled with CFR 0.152.
 */
package components;

import components.g;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.Icon;

public class f
implements Icon {
    public static final float NU = 0.0f;
    public static final float NV = 0.0f;
    public static final float NW = 0.5f;
    public static final float NX = 1.0f;
    public static final float NY = 1.0f;
    private Icon[] NZ;
    private g Oa;
    private int Ob;
    private float Oc = 0.5f;
    private float Od = 0.5f;

    public f(Icon ... iconArray) {
        this(g.Oe, iconArray);
    }

    public f(g g2, Icon ... iconArray) {
        this(g2, 0, iconArray);
    }

    public f(g g2, int n2, Icon ... iconArray) {
        this(g2, n2, 0.5f, 0.5f, iconArray);
    }

    public f(g g2, int n2, float f2, float f3, Icon ... iconArray) {
        this.Oa = g2;
        this.Ob = n2;
        float f4 = f2 > 1.0f ? 1.0f : (this.Oc = f2 < 0.0f ? 0.0f : f2);
        this.Od = f3 > 1.0f ? 1.0f : (f3 < 0.0f ? 0.0f : f3);
        int n3 = 0;
        while (n3 < iconArray.length) {
            if (iconArray[n3] == null) {
                String string = "Icon (" + n3 + ") cannot be null";
                throw new IllegalArgumentException(string);
            }
            ++n3;
        }
        this.NZ = iconArray;
    }

    public g th() {
        return this.Oa;
    }

    public int getGap() {
        return this.Ob;
    }

    public float getAlignmentX() {
        return this.Oc;
    }

    public float getAlignmentY() {
        return this.Od;
    }

    public int ti() {
        return this.NZ.length;
    }

    public Icon dG(int n2) {
        return this.NZ[n2];
    }

    @Override
    public int getIconWidth() {
        int n2 = 0;
        if (this.Oa == g.Oe) {
            n2 += (this.NZ.length - 1) * this.Ob;
            Icon[] iconArray = this.NZ;
            int n3 = this.NZ.length;
            int n4 = 0;
            while (n4 < n3) {
                Icon icon = iconArray[n4];
                n2 += icon.getIconWidth();
                ++n4;
            }
        } else {
            Icon[] iconArray = this.NZ;
            int n5 = this.NZ.length;
            int n6 = 0;
            while (n6 < n5) {
                Icon icon = iconArray[n6];
                n2 = Math.max(n2, icon.getIconWidth());
                ++n6;
            }
        }
        return n2;
    }

    @Override
    public int getIconHeight() {
        int n2 = 0;
        if (this.Oa == g.Of) {
            n2 += (this.NZ.length - 1) * this.Ob;
            Icon[] iconArray = this.NZ;
            int n3 = this.NZ.length;
            int n4 = 0;
            while (n4 < n3) {
                Icon icon = iconArray[n4];
                n2 += icon.getIconHeight();
                ++n4;
            }
        } else {
            Icon[] iconArray = this.NZ;
            int n5 = this.NZ.length;
            int n6 = 0;
            while (n6 < n5) {
                Icon icon = iconArray[n6];
                n2 = Math.max(n2, icon.getIconHeight());
                ++n6;
            }
        }
        return n2;
    }

    @Override
    public void paintIcon(Component component, Graphics graphics, int n2, int n3) {
        if (this.Oa == g.Oe) {
            int n4 = this.getIconHeight();
            Icon[] iconArray = this.NZ;
            int n5 = this.NZ.length;
            int n6 = 0;
            while (n6 < n5) {
                Icon icon = iconArray[n6];
                int n7 = this.a(n4, icon.getIconHeight(), this.Od);
                icon.paintIcon(component, graphics, n2, n3 + n7);
                n2 += icon.getIconWidth() + this.Ob;
                ++n6;
            }
        } else if (this.Oa == g.Of) {
            int n8 = this.getIconWidth();
            Icon[] iconArray = this.NZ;
            int n9 = this.NZ.length;
            int n10 = 0;
            while (n10 < n9) {
                Icon icon = iconArray[n10];
                int n11 = this.a(n8, icon.getIconWidth(), this.Oc);
                icon.paintIcon(component, graphics, n2 + n11, n3);
                n3 += icon.getIconHeight() + this.Ob;
                ++n10;
            }
        } else {
            int n12 = this.getIconWidth();
            int n13 = this.getIconHeight();
            Icon[] iconArray = this.NZ;
            int n14 = this.NZ.length;
            int n15 = 0;
            while (n15 < n14) {
                Icon icon = iconArray[n15];
                int n16 = this.a(n12, icon.getIconWidth(), this.Oc);
                int n17 = this.a(n13, icon.getIconHeight(), this.Od);
                icon.paintIcon(component, graphics, n2 + n16, n3 + n17);
                ++n15;
            }
        }
    }

    private int a(int n2, int n3, float f2) {
        float f3 = (float)(n2 - n3) * f2;
        return Math.round(f3);
    }
}

