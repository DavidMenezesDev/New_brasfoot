/*
 * Decompiled with CFR 0.152.
 */
package b;

import a.hk;
import best.I;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class i
extends AbstractTableModel {
    private String[] Nt;
    private ArrayList vp;
    private static int SE = 1;
    private hk SF;

    public i(ArrayList arrayList) {
        this.SF = this.SF = null;
        this.vp = arrayList;
        this.Nt = new String[]{"Data", "", "", "", "Competi\u00e7\u00e3o", "P\u00fablico", "Renda"};
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

    public I es(int n2) {
        return (I)this.vp.get(n2);
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

    public void et(int n2) {
    }
}

