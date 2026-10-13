/*
 * Decompiled with CFR 0.152.
 */
package b;

import best.Z;
import c.a;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class A
extends AbstractTableModel {
    private String[] Nt;
    private static ArrayList ds;

    public A() {
        ds = a.SR.N();
        this.Nt = new String[]{"Ver", "Pa\u00eds", ""};
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
        return ds.get(n2);
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
            if (((Z)ds.get(n2)).jr()) {
                ((Z)ds.get(n2)).B(false);
            } else if (!((Z)ds.get(n2)).jr()) {
                ((Z)ds.get(n2)).B(true);
            }
        }
    }
}

