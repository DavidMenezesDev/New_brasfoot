/*
 * Decompiled with CFR 0.152.
 */
package components;

import java.io.Serializable;

public class am
implements Serializable {
    private static final long serialVersionUID = 1L;
    private int Rw;
    private int Rx;
    private boolean Ry = false;

    public am(String string, int n2, int n3) {
        this.Rw = n2;
        this.Rx = n3;
    }

    public am(String string, int n2, int n3, boolean bl2) {
        this.Rw = n2;
        this.Rx = n3;
        this.Ry = bl2;
    }

    public am() {
    }

    public int uW() {
        return this.Rw;
    }

    public int uX() {
        return this.Rx;
    }

    public boolean uY() {
        return this.Ry;
    }

    public void fE(int n2) {
        this.Rw = n2;
    }
}

