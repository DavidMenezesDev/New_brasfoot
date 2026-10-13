/*
 * Decompiled with CFR 0.152.
 */
package b;

import b.g;
import c.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.table.AbstractTableModel;

public class f
extends AbstractTableModel {
    private String[] Nt;
    private ArrayList vp;
    public static Comparator KZ = new g();

    public f(ArrayList arrayList) {
        this.vp = arrayList;
        Collections.sort(arrayList, KZ);
        this.Nt = new String[]{"P", "Nome", "F", "E", "Caract."};
        if (a.SR.isHabilidadeIndividual()) {
            this.Nt = new String[]{"P", "Nome", "Fin", "E", "Caracter."};
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

    public ArrayList uH() {
        return this.vp;
    }
}

