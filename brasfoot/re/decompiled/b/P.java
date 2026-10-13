/*
 * Decompiled with CFR 0.152.
 */
package b;

import best.O;
import c.a;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class P
extends AbstractTableModel {
    private String[] Nt;
    private static ArrayList ds;

    public P() {
        ds = a.SR.bF;
        this.Nt = new String[]{"Jogar", "Pa\u00eds", "Times"};
    }

    @Override
    public int getColumnCount() {
        return this.Nt.length;
    }

    @Override
    public int getRowCount() {
        return ds.size();
    }

    @Override
    public Object getValueAt(int n2, int n3) {
        if (ds.size() == 0) {
            return null;
        }
        O o2 = (O)ds.get(n2);
        if (n3 == 0) {
            if (o2.iC()) {
                return 1;
            }
            return 0;
        }
        if (n3 == 1) {
            return Integer.toString(o2.getPais());
        }
        if (n3 == 2) {
            return o2.iB();
        }
        return null;
    }

    @Override
    public String getColumnName(int n2) {
        return this.Nt[n2];
    }

    public Class getColumnClass(int n2) {
        return this.getValueAt(0, n2).getClass();
    }

    public void ex(int n2) {
        if (n2 >= 0) {
            if (((O)ds.get(n2)).iC()) {
                ((O)ds.get(n2)).v(false);
            } else if (!((O)ds.get(n2)).iC()) {
                ((O)ds.get(n2)).v(true);
            }
        }
    }
}

