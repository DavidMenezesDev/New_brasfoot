/*
 * Decompiled with CFR 0.152.
 */
package b;

import a.gh;
import b.C;
import best.F;
import c.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.table.AbstractTableModel;

public class B
extends AbstractTableModel {
    private String[] Nt;
    private ArrayList vp;
    private static int SE = 1;
    private gh SK = null;
    public static Comparator KZ = new C();

    public B(ArrayList arrayList, gh gh2) {
        this.SK = gh2;
        this.vp = arrayList;
        Collections.sort(arrayList, KZ);
        this.Nt = new String[]{"P", "Nome", "F", "E", "Caract."};
        if (a.SR.isHabilidadeIndividual()) {
            this.Nt = new String[]{"P", "Nome", "Fin", "E", "Caract."};
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

    public void et(int n2) {
        this.SK.A((F)this.vp.get(n2));
    }

    public ArrayList uH() {
        return this.vp;
    }

    static /* synthetic */ int vG() {
        return SE;
    }
}

