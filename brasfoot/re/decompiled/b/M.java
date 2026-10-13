/*
 * Decompiled with CFR 0.152.
 */
package b;

import a.dV;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class M
extends AbstractTableModel {
    private String[] Nt = new String[]{"", "", "", "", "", ""};
    private ArrayList vK;
    private dV GS = null;

    public M(dV dV2) {
        this.GS = dV2;
        this.vK = dV2.qi();
    }

    @Override
    public int getColumnCount() {
        return this.Nt.length;
    }

    @Override
    public int getRowCount() {
        return this.vK.size();
    }

    @Override
    public Object getValueAt(int n2, int n3) {
        if (n2 < this.vK.size()) {
            return this.vK.get(n2);
        }
        return null;
    }

    public Class getColumnClass(int n2) {
        if (this.getValueAt(0, n2) != null) {
            return this.getValueAt(0, n2).getClass();
        }
        return String.class;
    }
}

