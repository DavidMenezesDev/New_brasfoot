/*
 * Decompiled with CFR 0.152.
 */
package b;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class aT
extends AbstractTableModel {
    private String[] Nt;
    private ArrayList afO;

    public aT(ArrayList arrayList) {
        this.afO = arrayList;
        this.Nt = new String[]{"", "", "", ""};
    }

    @Override
    public int getColumnCount() {
        return this.Nt.length;
    }

    @Override
    public int getRowCount() {
        return this.afO.size();
    }

    @Override
    public Object getValueAt(int n2, int n3) {
        return this.afO.get(n2);
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

