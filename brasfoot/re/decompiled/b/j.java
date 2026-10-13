/*
 * Decompiled with CFR 0.152.
 */
package b;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class j
extends AbstractTableModel {
    private String[] Nt;
    private ArrayList vp;

    public j(ArrayList arrayList) {
        this.vp = arrayList;
        this.Nt = new String[]{"Ano", "Campe\u00e3o", "Vice", "Artilheiro", "T\u00e9cnico Campe\u00e3o"};
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

