/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.bm;
import b.ap;
import b.s;
import best.aq;
import c.a;
import components.h;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;

public class bl
extends JPanel {
    private JDialog ub;
    private ArrayList zU = new ArrayList();
    private JButton zK;
    private JLabel ug;
    private JPanel vd;
    private JScrollPane ut;
    private JTable zV;

    public bl(JDialog jDialog, ArrayList arrayList) {
        this.ub = jDialog;
        this.zU = arrayList;
        this.mJ();
        this.mH();
        this.mS();
        this.mG();
    }

    private void mG() {
        this.setBackground(aq.E(a.vM().getCorTema(), 1));
    }

    public void mH() {
        this.zK.addActionListener(new bm(this));
    }

    private void mS() {
        s s2 = new s(this.zU);
        this.zV.setModel(s2);
        int[] nArray = new int[]{120, 120, 120, 80};
        int n2 = 0;
        while (n2 < nArray.length) {
            this.zV.getColumnModel().getColumn(n2).setPreferredWidth(nArray[n2]);
            ++n2;
        }
        this.zV.setAutoResizeMode(3);
        this.zV.setRowHeight(20);
        this.zV.setShowGrid(false);
        this.zV.setDefaultRenderer(h.class, new ap());
        this.zV.setAutoCreateRowSorter(false);
        this.zV.getTableHeader().setReorderingAllowed(false);
        this.zV.setIntercellSpacing(new Dimension(0, 0));
        this.zV.setCellSelectionEnabled(false);
        this.zV.setSelectionMode(0);
        this.zV.setRowSelectionAllowed(true);
        this.zV.setSelectionBackground(Color.YELLOW);
        this.zV.setFillsViewportHeight(true);
    }

    private void mJ() {
        this.vd = new JPanel();
        this.ug = new JLabel();
        this.ut = new JScrollPane();
        this.zV = new JTable();
        this.zK = new JButton();
        this.setBackground(new Color(44, 53, 49));
        this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        this.vd.setBackground(new Color(104, 120, 100));
        this.ug.setFont(new Font("Tahoma", 1, 14));
        this.ug.setForeground(new Color(255, 255, 255));
        this.ug.setText("Demiss\u00f5es na Rodada");
        this.ut.setViewportView(this.zV);
        this.zK.setText("continuar >>");
        GroupLayout groupLayout = new GroupLayout(this.vd);
        this.vd.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(19, 19, 19).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(groupLayout.createSequentialGroup().addComponent(this.ug, -2, 253, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, Short.MAX_VALUE).addComponent(this.zK, -2, 114, -2)).addComponent(this.ut, -2, 547, -2)).addContainerGap(18, Short.MAX_VALUE)));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.ug).addComponent(this.zK)).addGap(18, 18, 18).addComponent(this.ut, -1, 295, Short.MAX_VALUE).addContainerGap()));
        GroupLayout groupLayout2 = new GroupLayout(this);
        this.setLayout(groupLayout2);
        groupLayout2.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addContainerGap().addComponent(this.vd, -1, -1, Short.MAX_VALUE).addContainerGap()));
        groupLayout2.setVerticalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addContainerGap().addComponent(this.vd, -1, -1, Short.MAX_VALUE).addContainerGap()));
    }

    static /* synthetic */ JDialog a(bl bl2) {
        return bl2.ub;
    }
}

