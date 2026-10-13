/*
 * Decompiled with CFR 0.152.
 */
package best;

import best.ah;
import java.io.Serializable;
import java.util.ArrayList;

public class G
implements Serializable {
    private static final long serialVersionUID = 1L;
    private ArrayList fs = new ArrayList();

    public ArrayList gR() {
        return this.fs;
    }

    public void E(ArrayList arrayList) {
        this.fs = arrayList;
    }

    public void dv(int n2) {
        int n3 = 0;
        while (n3 < this.fs.size()) {
            System.out.println(String.valueOf(n2) + " " + ((ah)this.fs.get(n3)).getNome());
            ++n3;
        }
    }
}

