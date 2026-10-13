/*
 * Decompiled with CFR 0.152.
 */
package d;

import b.aK;
import d.aj;
import d.ak;
import d.al;
import d.am;
import d.an;
import d.ay;
import e.t;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

public class ai
extends JPanel {
    private t VH = null;
    private JButton uC;
    private JButton VI;
    private JButton VJ;
    private JButton UK;
    private JTextField VK;
    private JScrollPane ut;
    private JScrollPane wi;
    private JLabel zh;
    private JLabel VL;
    private JLabel QU;
    private JTable VM;

    public ai() {
        this.mJ();
    }

    private void mJ() {
        this.ut = new JScrollPane();
        this.wi = new JScrollPane();
        this.VM = new JTable();
        this.QU = new JLabel();
        this.VL = new JLabel();
        this.VK = new JTextField();
        this.UK = new JButton();
        this.VJ = new JButton();
        this.zh = new JLabel();
        this.VI = new JButton();
        this.uC = new JButton();
        this.setBackground(new Color(51, 102, 0));
        this.wi.setPreferredSize(new Dimension(316, 202));
        ay ay2 = new ay();
        this.VM = new aj(this, ay2);
        this.wi.setViewportView(this.VM);
        this.ut.setViewportView(this.wi);
        this.QU.setFont(new Font("Tahoma", 1, 14));
        this.QU.setForeground(new Color(255, 255, 255));
        this.QU.setHorizontalAlignment(0);
        this.QU.setText("Transferir Jogador");
        this.VL.setForeground(new Color(255, 255, 255));
        this.VL.setHorizontalAlignment(4);
        this.VL.setText("Time:");
        this.UK.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon_search.png")));
        this.UK.setToolTipText("");
        this.UK.setCursor(new Cursor(12));
        this.VJ.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon_search.png")));
        this.VJ.setToolTipText("");
        this.VJ.setCursor(new Cursor(12));
        this.zh.setForeground(new Color(255, 255, 255));
        this.zh.setHorizontalAlignment(0);
        this.zh.setText("transferir para:");
        this.VI.setIcon(new ImageIcon(this.getClass().getResource("/aicons/je.png")));
        this.VI.setText("Confirmar");
        this.VI.setToolTipText("");
        this.VI.setCursor(new Cursor(12));
        this.VI.setEnabled(false);
        this.uC.setIcon(new ImageIcon(this.getClass().getResource("/aicons/exit.png")));
        this.uC.setText("Cancelar");
        this.uC.setToolTipText("");
        this.uC.setCursor(new Cursor(12));
        GroupLayout groupLayout = new GroupLayout(this);
        this.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(this.QU, -2, 308, -2)).addGroup(GroupLayout.Alignment.LEADING, groupLayout.createSequentialGroup().addGap(23, 23, 23).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.ut).addGroup(groupLayout.createSequentialGroup().addComponent(this.VL, -2, 64, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.VK, -2, 176, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.VJ, -2, 39, -2)).addComponent(this.zh, -1, -1, Short.MAX_VALUE).addGroup(GroupLayout.Alignment.LEADING, groupLayout.createSequentialGroup().addComponent(this.VI, -2, 132, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, Short.MAX_VALUE).addComponent(this.uC, -2, 132, -2))))).addContainerGap(27, Short.MAX_VALUE)).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(0, 159, Short.MAX_VALUE).addComponent(this.UK).addGap(0, 160, Short.MAX_VALUE))));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup().addContainerGap().addComponent(this.QU).addGap(18, 18, 18).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.VK, -2, -1, -2).addComponent(this.VL)).addComponent(this.VJ, -2, 0, Short.MAX_VALUE)).addGap(18, 18, 18).addComponent(this.ut, -2, 323, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.zh).addGap(18, 18, 18).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.VI).addComponent(this.uC)).addContainerGap(26, Short.MAX_VALUE)).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(0, 239, Short.MAX_VALUE).addComponent(this.UK).addGap(0, 240, Short.MAX_VALUE))));
        this.mK();
        this.nc();
    }

    public void nc() {
        this.VM.getColumnModel().getColumn(0).setPreferredWidth(200);
        this.VM.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.VM.getColumnModel().getColumn(2).setPreferredWidth(52);
        this.VM.setAutoResizeMode(3);
        this.VM.setShowGrid(false);
        this.VM.setDefaultRenderer(t.class, new aK());
        this.VM.setAutoCreateRowSorter(false);
        this.VM.setCellSelectionEnabled(false);
        this.VM.setSelectionMode(0);
        this.VM.setRowSelectionAllowed(true);
        this.VM.setRowHeight(20);
        this.VM.setIntercellSpacing(new Dimension(0, 0));
        this.VM.getTableHeader().setReorderingAllowed(false);
    }

    public void mK() {
        this.uC.addActionListener(new ak(this));
        this.VJ.addActionListener(new al(this));
        this.VM.getSelectionModel().addListSelectionListener(new am(this));
        this.VI.addActionListener(new an(this));
    }

    public JTable xe() {
        return this.VM;
    }

    public t xf() {
        return this.VH;
    }

    public void e(t t2) {
        this.VH = t2;
    }

    static /* synthetic */ JTextField a(ai ai2) {
        return ai2.VK;
    }

    static /* synthetic */ JTable b(ai ai2) {
        return ai2.VM;
    }

    static /* synthetic */ JLabel c(ai ai2) {
        return ai2.zh;
    }

    static /* synthetic */ t d(ai ai2) {
        return ai2.VH;
    }

    static /* synthetic */ JButton e(ai ai2) {
        return ai2.VI;
    }
}

