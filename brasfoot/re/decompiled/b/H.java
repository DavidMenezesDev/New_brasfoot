/*
 * Decompiled with CFR 0.152.
 */
package b;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class H
extends AbstractTableModel {
    private String[] Nt;
    private ArrayList vp;

    public H(ArrayList arrayList, int n2) {
        this.vp = arrayList;
        this.Nt = n2 == 0 ? new String[]{"", "Time", "Reputa\u00e7\u00e3o", ""} : (n2 == 1 ? new String[]{"", "Time", "(PG/GP/GC)", ""} : new String[]{"", "Time", "Pontos", ""});
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

