/*
 * Decompiled with CFR 0.152.
 */
package components;

import java.awt.Dimension;
import java.awt.Point;
import java.io.Serializable;

public class a
implements Serializable {
    static final long serialVersionUID = 5261460716622152494L;
    public int x;
    public int y;
    public int width = -1;
    public int height = -1;

    public a(Point point) {
        this(point.x, point.y);
    }

    public a(int n2, int n3) {
        this.x = n2;
        this.y = n3;
    }

    public a(Point point, Dimension dimension) {
        this.x = point.x;
        this.y = point.y;
        if (dimension != null) {
            this.width = dimension.width;
            this.height = dimension.height;
        }
    }

    public a(int n2, int n3, int n4, int n5) {
        this.x = n2;
        this.y = n3;
        this.width = n4;
        this.height = n5;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String toString() {
        return String.valueOf(super.toString()) + " [x=" + this.x + ", y=" + this.y + ", width=" + this.width + ", height=" + this.height + "]";
    }
}

