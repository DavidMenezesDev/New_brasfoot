/*
 * Decompiled with CFR 0.152.
 */
package components;

import best.ah;
import java.io.Serializable;

public class aD
implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private int d;
    private ah SC = null;
    private int c;

    public aD() {
    }

    public aD(int n2, int n3, ah ah2, int n4) {
        this.id = n2;
        this.d = n3;
        this.SC = ah2;
        this.c = n4;
    }

    public int getEstado() {
        return this.id;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int n2) {
        this.id = n2;
    }

    public int co() {
        return this.d;
    }

    public void dT(int n2) {
        this.d = n2;
    }

    public ah vD() {
        return this.SC;
    }

    public void J(ah ah2) {
        this.SC = ah2;
    }

    public int vE() {
        return this.c;
    }

    public void er(int n2) {
        this.c = n2;
    }
}

