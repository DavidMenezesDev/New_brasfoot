/*
 * Decompiled with CFR 0.152.
 */
package b;

import a.bu;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class d
extends AbstractTableModel {
    private String[] Nt;
    private ArrayList vp;
    private static String SD = "";

    public d(ArrayList arrayList) {
        this.vp = arrayList;
        this.Nt = new String[]{"", "Jogador", "Time", "Gols", "Jogos"};
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
        if (this.vp.size() > 0) {
            return this.vp.get(n2);
        }
        return null;
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

    public static void ac(String string) {
        SD = string;
        bu.nZ();
    }

    public static String vF() {
        return SD;
    }
}

