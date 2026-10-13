/*
 * Decompiled with CFR 0.152.
 */
package components;

import b.ab;
import b.h;
import best.e;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class at
extends JScrollPane {
    private ArrayList vp = new ArrayList();
    private JTable Sf;

    public at(ArrayList arrayList) {
        this.mJ();
        this.vp.addAll(arrayList);
        this.nc();
    }

    private void nc() {
        h h3 = new h(this.vp);
        this.Sf.setModel(h3);
        this.Sf.setTableHeader(null);
        int[] nArray = new int[]{10, 80, 80, 40, 20};
        int n2 = 0;
        while (n2 < nArray.length) {
            this.Sf.getColumnModel().getColumn(n2).setPreferredWidth(nArray[n2]);
            ++n2;
        }
        this.Sf.setRowHeight(20);
        this.Sf.setShowGrid(false);
        this.Sf.setDefaultRenderer(e.class, new ab());
        this.Sf.setAutoCreateRowSorter(false);
        this.Sf.setIntercellSpacing(new Dimension(0, 0));
        this.Sf.setCellSelectionEnabled(false);
        this.Sf.setRowSelectionAllowed(false);
        this.Sf.setFillsViewportHeight(true);
    }

    private void mJ() {
        this.Sf = new JTable();
        this.setViewportView(this.Sf);
    }

    public void ac(ArrayList arrayList) {
        this.vp.clear();
        this.vp.addAll(arrayList);
        this.Sf.addNotify();
    }
}

