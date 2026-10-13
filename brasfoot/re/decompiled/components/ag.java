/*
 * Decompiled with CFR 0.152.
 */
package components;

import java.io.Serializable;
import java.util.ArrayList;

public class ag
implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nome;
    private ArrayList vp = new ArrayList();
    private ArrayList Ri = new ArrayList();

    public void clear() {
        this.vp.clear();
        this.Ri.clear();
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String string) {
        this.nome = string;
    }

    public ArrayList uH() {
        return this.vp;
    }

    public ArrayList uI() {
        return this.Ri;
    }
}

