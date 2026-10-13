/*
 * Decompiled with CFR 0.152.
 */
package b;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class m
extends AbstractTableModel {
    private String[] Nt;
    private ArrayList SG = new ArrayList();

    public m(ArrayList arrayList) {
        this.SG = arrayList;
        this.Nt = new String[]{"", "", "", "", "", "", "", "", "", "", ""};
    }

    @Override
    public int getColumnCount() {
        return this.Nt.length;
    }

    @Override
    public int getRowCount() {
        return this.SG.size();
    }

    @Override
    public Object getValueAt(int n2, int n3) {
        return this.SG.get(n2);
    }

    public Class getColumnClass(int n2) {
        if (this.getValueAt(0, n2) != null) {
            return this.getValueAt(0, n2).getClass();
        }
        return String.class;
    }
}

