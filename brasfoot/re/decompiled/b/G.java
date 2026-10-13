/*
 * Decompiled with CFR 0.152.
 */
package b;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class G
extends AbstractTableModel {
    private String[] Nt;
    private ArrayList vp;

    public G(ArrayList arrayList, int n2) {
        this.vp = arrayList;
        this.Nt = new String[]{"", "T\u00e9cnico", "Time atual", "Pontos", "T\u00edtulos"};
        if (n2 == 1) {
            this.Nt = new String[]{"", "T\u00e9cnico", "Time atual", "Reputa\u00e7\u00e3o", ""};
        }
    }

    @Override
    public int getColumnCount() {
        return this.Nt.length;
    }

    @Override
    public int getRowCount() {
        return this.vp.size();
    }

    @Override
    public Object getValueAt(int n2, int n3) {
        return this.vp.get(n2);
    }

    @Override
    public String getColumnName(int n2) {
        return this.Nt[n2];
    }

    public Class getColumnClass(int n2) {
        if (this.getValueAt(0, n2) != null) {
            return this.getValueAt(0, n2).getClass();
        }
        return String.class;
    }
}

