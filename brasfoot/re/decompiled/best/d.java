/*
 * Decompiled with CFR 0.152.
 */
package best;

import best.ah;
import best.c;

public class d {
    private String nome = null;
    private ah X = null;
    private int g = 0;
    private int T = 0;

    public d(String string, ah ah2, int n2, int n3) {
        this.nome = string;
        this.X = ah2;
        this.g = n2;
        this.T = n3;
    }

    public d(c c2) {
        if (c2.x() != null) {
            this.nome = c2.x().getNome();
            this.X = c2.x().fg();
            this.g = c2.y();
            this.T = c2.A();
        }
    }

    public String getNome() {
        return this.nome;
    }

    public ah B() {
        return this.X;
    }

    public void b(ah ah2) {
        this.X = ah2;
    }

    public int v() {
        return this.g;
    }

    public int w() {
        return this.T;
    }
}

