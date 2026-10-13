/*
 * Decompiled with CFR 0.152.
 */
package est;

import java.io.Serializable;

public class InfoArquivoSalvoType
implements Serializable {
    private static final long serialVersionUID = 1L;
    private String n = null;
    private String tc = null;
    private Integer a = null;
    private String i = null;

    public String getN() {
        return this.n;
    }

    public void setN(String string) {
        this.n = string;
    }

    public String getTc() {
        return this.tc;
    }

    public void setTc(String string) {
        this.tc = string;
    }

    public Integer getA() {
        return this.a;
    }

    public void setA(Integer n2) {
        this.a = n2;
    }

    public String getI() {
        return this.i;
    }

    public void setI(String string) {
        this.i = string;
    }
}

