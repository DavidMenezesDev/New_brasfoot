/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.S;
import a.T;
import a.U;
import a.V;
import a.W;
import a.X;
import a.Y;
import a.Z;
import b.ad;
import b.aj;
import b.am;
import b.j;
import best.aq;
import best.at;
import best.i;
import components.a;
import components.ap;
import components.b;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;

public class R
extends JPanel {
    private JDialog ub;
    private ArrayList cS = new ArrayList();
    private ArrayList vP = new ArrayList();
    private ImageIcon uL = new ImageIcon(this.getClass().getResource("/aiconsb/b0.png"));
    private ImageIcon uM = new ImageIcon(this.getClass().getResource("/aiconsb/b1.png"));
    private ImageIcon uN = new ImageIcon(this.getClass().getResource("/aiconsb/b2.png"));
    private ImageIcon uO = new ImageIcon(this.getClass().getResource("/aiconsb/b3.png"));
    private ImageIcon uP = new ImageIcon(this.getClass().getResource("/aiconsb/b4.png"));
    private ImageIcon uQ = new ImageIcon(this.getClass().getResource("/aiconsb/b0s.png"));
    private ImageIcon uR = new ImageIcon(this.getClass().getResource("/aiconsb/b1s.png"));
    private ImageIcon uS = new ImageIcon(this.getClass().getResource("/aiconsb/b2s.png"));
    private ImageIcon uT = new ImageIcon(this.getClass().getResource("/aiconsb/b3s.png"));
    private ImageIcon uU = new ImageIcon(this.getClass().getResource("/aiconsb/b4s.png"));
    private JButton uW;
    private JButton vm;
    private JButton uX;
    private JButton uY;
    private JButton vi;
    private JButton uZ;
    private JComboBox va;
    private JComboBox ue;
    private JPanel vd;
    private JScrollPane ut;
    private JToolBar ve;
    private JLabel vf;
    private JTable vQ;

    public R(JDialog jDialog) {
        this.ub = jDialog;
        this.mJ();
        this.mH();
        this.mS();
        this.mQ();
        this.mO();
        this.mP();
        this.cB(0);
        this.mG();
    }

    private void mG() {
        this.setBackground(aq.E(c.a.vM().getCorTema(), 1));
    }

    public void mH() {
        this.vm.addActionListener(new S(this));
    }

    private void mO() {
        if (!c.a.SR.isJogaEstadual()) {
            this.uW.setVisible(false);
        }
        if (!c.a.SR.isJogaRegionais()) {
            this.vi.setVisible(false);
        }
        if (!c.a.SR.isJogaSelecoesAll()) {
            this.uZ.setVisible(false);
        }
        if (!c.a.SR.isJogaIntClubes()) {
            this.uX.setVisible(false);
        }
    }

    private void mP() {
        this.uY.addActionListener(new T(this));
        this.uX.addActionListener(new U(this));
        this.uW.addActionListener(new V(this));
        this.uZ.addActionListener(new W(this));
        this.vi.addActionListener(new X(this));
    }

    private void cA(int n2) {
        JButton[] jButtonArray = new JButton[]{this.uY, this.uX, this.uW, this.uZ, this.vi};
        ImageIcon[] imageIconArray = new ImageIcon[]{this.uL, this.uM, this.uN, this.uO, this.uP};
        ImageIcon[] imageIconArray2 = new ImageIcon[]{this.uQ, this.uR, this.uS, this.uT, this.uU};
        int n3 = 0;
        while (n3 < jButtonArray.length) {
            jButtonArray[n3].setIcon(imageIconArray[n3]);
            ++n3;
        }
        jButtonArray[n2].setIcon(imageIconArray2[n2]);
    }

    private void cB(int n2) {
        this.cA(n2);
        this.cS = at.a(n2, true, 1);
        if (n2 == 0 && c.a.SR.bW() != null && c.a.SR.bW().size() > 0) {
            this.cS.add((at)c.a.SR.bW().get(0));
        }
        this.va.removeAllItems();
        int n3 = 0;
        while (n3 < this.cS.size()) {
            this.va.addItem(this.cS.get(n3));
            ++n3;
        }
    }

    private void cC(int n2) {
        if (this.cS.size() > 0) {
            this.r((at)this.va.getSelectedItem());
        }
    }

    private void nb() {
        this.s((at)this.ue.getSelectedItem());
    }

    private void mQ() {
        aj aj2 = new aj(1);
        this.va.setPreferredSize(new Dimension(10, 25));
        this.va.setRenderer(aj2);
        this.va.setMaximumRowCount(24);
        this.va.addActionListener(new Y(this));
        am am2 = new am();
        this.ue.setPreferredSize(new Dimension(10, 25));
        this.ue.setRenderer(am2);
        this.ue.setMaximumRowCount(24);
        if (c.a.SR.bW().size() > 0) {
            int n2 = 0;
            while (n2 < c.a.SR.bW().size()) {
                this.ue.addItem(c.a.SR.bW().get(n2));
                ++n2;
            }
        }
        this.ue.addActionListener(new Z(this));
    }

    private void r(at at2) {
        if (at2.b() == 11) {
            this.ue.setVisible(true);
            this.ue.setSelectedIndex(0);
        } else {
            this.ue.setVisible(false);
            this.s(at2);
        }
    }

    private void s(at at2) {
        this.vP.clear();
        int n2 = -1;
        int n3 = at2.mn().size() - 1;
        while (n3 >= 0) {
            if (at2.mn().get(n3) != null && ((i)at2.mn().get(n3)).H() != n2) {
                this.vP.add(new ap((i)at2.mn().get(n3), -1, at2.b()));
                n2 = ((i)at2.mn().get(n3)).H();
            }
            --n3;
        }
        this.vQ.addNotify();
    }

    private void mS() {
        j j2 = new j(this.vP);
        this.vQ.setModel(j2);
        int[] nArray = new int[]{25, 110, 110, 160, 100};
        int n2 = 0;
        while (n2 < nArray.length) {
            this.vQ.getColumnModel().getColumn(n2).setPreferredWidth(nArray[n2]);
            ++n2;
        }
        this.vQ.setAutoResizeMode(3);
        this.vQ.setRowHeight(20);
        this.vQ.setShowGrid(false);
        this.vQ.setDefaultRenderer(ap.class, new ad());
        this.vQ.setAutoCreateRowSorter(false);
        this.vQ.getTableHeader().setReorderingAllowed(false);
        this.vQ.setIntercellSpacing(new Dimension(0, 0));
        this.vQ.setCellSelectionEnabled(false);
        this.vQ.setSelectionMode(0);
        this.vQ.setRowSelectionAllowed(true);
        this.vQ.setSelectionBackground(Color.YELLOW);
        this.vQ.setFillsViewportHeight(true);
    }

    private void mJ() {
        this.ut = new JScrollPane();
        this.vQ = new JTable();
        this.vf = new JLabel();
        this.vd = new JPanel();
        this.ve = new JToolBar();
        this.uY = new JButton();
        this.uX = new JButton();
        this.uW = new JButton();
        this.uZ = new JButton();
        this.vi = new JButton();
        this.va = new JComboBox();
        this.vm = new JButton();
        this.ue = new JComboBox();
        this.setBackground(new Color(104, 120, 100));
        this.vQ.setModel(new DefaultTableModel(new Object[][]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.ut.setViewportView(this.vQ);
        this.vf.setFont(new Font("Tahoma", 1, 14));
        this.vf.setForeground(new Color(255, 255, 255));
        this.vf.setText("Campe\u00f5es");
        this.vd.setBackground(new Color(44, 53, 49));
        this.vd.setPreferredSize(new Dimension(483, 40));
        this.vd.setLayout(new b());
        this.ve.setBackground(new Color(44, 53, 49));
        this.ve.setFloatable(false);
        this.ve.setRollover(true);
        this.ve.setBorderPainted(false);
        this.uY.setIcon(new ImageIcon(this.getClass().getResource("/aiconsb/b0.png")));
        this.uY.setBorderPainted(false);
        this.uY.setContentAreaFilled(false);
        this.uY.setFocusable(false);
        this.uY.setHorizontalTextPosition(0);
        this.uY.setMargin(new Insets(0, 0, 0, 0));
        this.uY.setMaximumSize(new Dimension(79, 45));
        this.uY.setMinimumSize(new Dimension(79, 45));
        this.uY.setPreferredSize(new Dimension(79, 45));
        this.uY.setRolloverIcon(new ImageIcon(this.getClass().getResource("/aiconsb/b0s.png")));
        this.uY.setVerticalTextPosition(3);
        this.ve.add(this.uY);
        this.uX.setIcon(new ImageIcon(this.getClass().getResource("/aiconsb/b1.png")));
        this.uX.setBorderPainted(false);
        this.uX.setContentAreaFilled(false);
        this.uX.setFocusable(false);
        this.uX.setHorizontalTextPosition(0);
        this.uX.setMargin(new Insets(0, 0, 0, 0));
        this.uX.setMaximumSize(new Dimension(79, 45));
        this.uX.setMinimumSize(new Dimension(79, 45));
        this.uX.setPreferredSize(new Dimension(79, 45));
        this.uX.setRolloverIcon(new ImageIcon(this.getClass().getResource("/aiconsb/b1s.png")));
        this.uX.setVerticalTextPosition(3);
        this.ve.add(this.uX);
        this.uW.setIcon(new ImageIcon(this.getClass().getResource("/aiconsb/b2.png")));
        this.uW.setBorderPainted(false);
        this.uW.setContentAreaFilled(false);
        this.uW.setFocusable(false);
        this.uW.setHorizontalTextPosition(0);
        this.uW.setMargin(new Insets(0, 0, 0, 0));
        this.uW.setMaximumSize(new Dimension(79, 45));
        this.uW.setMinimumSize(new Dimension(79, 45));
        this.uW.setPreferredSize(new Dimension(79, 45));
        this.uW.setRolloverIcon(new ImageIcon(this.getClass().getResource("/aiconsb/b2s.png")));
        this.uW.setVerticalTextPosition(3);
        this.ve.add(this.uW);
        this.uZ.setIcon(new ImageIcon(this.getClass().getResource("/aiconsb/b3.png")));
        this.uZ.setBorderPainted(false);
        this.uZ.setContentAreaFilled(false);
        this.uZ.setFocusable(false);
        this.uZ.setHorizontalTextPosition(0);
        this.uZ.setMargin(new Insets(0, 0, 0, 0));
        this.uZ.setMaximumSize(new Dimension(79, 45));
        this.uZ.setMinimumSize(new Dimension(79, 45));
        this.uZ.setPreferredSize(new Dimension(79, 45));
        this.uZ.setRolloverIcon(new ImageIcon(this.getClass().getResource("/aiconsb/b3s.png")));
        this.uZ.setVerticalTextPosition(3);
        this.ve.add(this.uZ);
        this.vi.setIcon(new ImageIcon(this.getClass().getResource("/aiconsb/b4.png")));
        this.vi.setBorderPainted(false);
        this.vi.setContentAreaFilled(false);
        this.vi.setFocusable(false);
        this.vi.setHorizontalTextPosition(0);
        this.vi.setMargin(new Insets(0, 0, 0, 0));
        this.vi.setMaximumSize(new Dimension(79, 45));
        this.vi.setMinimumSize(new Dimension(79, 45));
        this.vi.setPreferredSize(new Dimension(79, 45));
        this.vi.setRolloverIcon(new ImageIcon(this.getClass().getResource("/aiconsb/b4s.png")));
        this.vi.setVerticalTextPosition(3);
        this.ve.add(this.vi);
        this.vd.add((Component)this.ve, new a(0, 0, 460, 40));
        this.vd.add((Component)this.va, new a(570, 10, 200, 25));
        this.vm.setText("X");
        GroupLayout groupLayout = new GroupLayout(this);
        this.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(29, 29, 29).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.ue, -2, 200, -2).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.ut, -2, 781, -2).addComponent(this.vd, -2, 781, -2).addGroup(groupLayout.createSequentialGroup().addComponent(this.vf, -2, 368, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, Short.MAX_VALUE).addComponent(this.vm, -2, 59, -2)))).addContainerGap(38, Short.MAX_VALUE)));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(17, 17, 17).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.vf).addComponent(this.vm)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.vd, -2, 40, -2).addGap(11, 11, 11).addComponent(this.ut, -2, 489, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.ue, -2, 25, -2).addContainerGap(-1, Short.MAX_VALUE)));
    }

    static /* synthetic */ JDialog a(R r2) {
        return r2.ub;
    }

    static /* synthetic */ void a(R r2, int n2) {
        r2.cB(n2);
    }

    static /* synthetic */ JComboBox b(R r2) {
        return r2.va;
    }

    static /* synthetic */ void b(R r2, int n2) {
        r2.cC(n2);
    }

    static /* synthetic */ JComboBox c(R r2) {
        return r2.ue;
    }

    static /* synthetic */ void d(R r2) {
        r2.nb();
    }
}

