/*
 * Decompiled with CFR 0.152.
 */
package b;

import a.aP;
import b.r;
import best.F;
import c.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.table.AbstractTableModel;

public class q
extends AbstractTableModel {
    private String[] Nt;
    private ArrayList vp = null;
    private static int SE = 1;
    private aP SH = null;
    public static Comparator KZ = new r();

    public q(ArrayList arrayList, aP aP2, int n2) {
        this.SH = aP2;
        this.vp = arrayList;
        this.eu(n2);
    }

    private void eu(int n2) {
        Collections.sort(this.vp, KZ);
        this.Nt = new String[]{"", "Nome", "Time", "L", "F", "Car.", "Idade"};
        if (a.SR.isHabilidadeIndividual()) {
            this.Nt = n2 == 1 ? new String[]{"", "Nome", "Time", "L", "Gol", "Des", "Arm", "Fin", "Vel", "Tec", "Pas", "Car.", "I"} : new String[]{"", "Nome", "Time", "L"};
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
        if (this.vp.size() > 0) {
            return this.vp.get(n2);
        }
        return null;
    }

    public void et(int n2) {
        if (this.SH != null) {
            this.SH.s((F)this.vp.get(n2));
        }
    }

    public F ev(int n2) {
        return (F)this.vp.get(n2);
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

    static /* synthetic */ int vG() {
        return SE;
    }
}

