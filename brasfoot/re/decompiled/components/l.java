/*
 * Decompiled with CFR 0.152.
 */
package components;

import b.av;
import b.z;
import components.a;
import components.aC;
import components.b;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;

public class l
extends JPanel {
    private ArrayList vP = new ArrayList();
    private JScrollPane ut;
    private JSeparator BE;
    private JLabel Ov;
    private JTable Ox;

    public l() {
        this.mJ();
        this.nc();
    }

    public void a(String string, ArrayList arrayList) {
        this.vP.addAll(arrayList);
        this.Ov.setText(string);
        this.Ox.addNotify();
    }

    private void nc() {
        z z2 = new z(this.vP);
        this.Ox.setModel(z2);
        int[] nArray = new int[]{155, 120, 35};
        int n2 = 0;
        while (n2 < nArray.length) {
            this.Ox.getColumnModel().getColumn(n2).setPreferredWidth(nArray[n2]);
            ++n2;
        }
        this.Ox.setAutoResizeMode(3);
        this.Ox.setRowHeight(20);
        this.Ox.setShowGrid(false);
        this.Ox.setDefaultRenderer(aC.class, new av());
        this.Ox.setAutoCreateRowSorter(false);
        this.Ox.getTableHeader().setReorderingAllowed(false);
        this.Ox.setIntercellSpacing(new Dimension(0, 0));
        this.Ox.setCellSelectionEnabled(false);
        this.Ox.setTableHeader(null);
        this.Ox.setSelectionMode(0);
        this.Ox.setRowSelectionAllowed(true);
        this.Ox.setSelectionBackground(Color.YELLOW);
        this.Ox.setFillsViewportHeight(true);
    }

    private void mJ() {
        this.Ov = new JLabel();
        this.BE = new JSeparator();
        this.ut = new JScrollPane();
        this.Ox = new JTable();
        this.setBackground(new Color(255, 255, 255));
        this.setMinimumSize(new Dimension(310, 515));
        this.setPreferredSize(new Dimension(595, 110));
        this.setLayout(new b());
        this.Ov.setBackground(new Color(255, 255, 255));
        this.Ov.setFont(new Font("Tahoma", 1, 12));
        this.Ov.setForeground(new Color(36, 104, 43));
        this.Ov.setText("Brasileiro - 1\u00aa divis\u00e3o");
        this.add((Component)this.Ov, new a(10, 10, 190, -1));
        this.add((Component)this.BE, new a(0, 30, 310, -1));
        this.ut.setBorder(BorderFactory.createEmptyBorder());
        this.ut.setViewportView(this.Ox);
        this.add((Component)this.ut, new a(0, 35, 310, 480));
    }
}

