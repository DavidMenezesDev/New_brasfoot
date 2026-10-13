/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.p;
import a.q;
import a.r;
import a.s;
import a.t;
import a.u;
import a.v;
import a.w;
import a.x;
import b.Z;
import b.aj;
import b.d;
import best.F;
import best.aq;
import best.at;
import best.c;
import components.a;
import components.b;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.BorderFactory;
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

public class o
extends JPanel {
    private JDialog ub;
    private ArrayList uK = new ArrayList();
    private ArrayList cS = new ArrayList();
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
    public static Comparator uV = new p();
    private JButton uW;
    private JButton uX;
    private JButton uY;
    private JButton uZ;
    private JComboBox va;
    private JButton vb;
    private JButton vc;
    private JPanel vd;
    private JScrollPane ut;
    private JToolBar ve;
    private JLabel vf;
    private JLabel vg;
    private JTable vh;
    private JButton vi;

    public o(JDialog jDialog) {
        this.ub = jDialog;
        this.mJ();
        this.mH();
        this.mS();
        this.mQ();
        this.mO();
        this.mP();
        this.cB(0);
        this.vg.setVisible(false);
        this.mG();
    }

    private void mG() {
        this.setBackground(aq.E(c.a.vM().getCorTema(), 1));
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
        this.uY.addActionListener(new q(this));
        this.uX.addActionListener(new r(this));
        this.uW.addActionListener(new s(this));
        this.uZ.addActionListener(new t(this));
        this.vi.addActionListener(new u(this));
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
        this.cS = at.a(n2, false, 0);
        this.va.removeAllItems();
        int n3 = 0;
        while (n3 < this.cS.size()) {
            this.va.addItem(this.cS.get(n3));
            ++n3;
        }
    }

    private void cC(int n2) {
        if (this.cS.size() > 0) {
            this.a((at)this.va.getSelectedItem(), false);
        }
    }

    private void mQ() {
        aj aj2 = new aj();
        this.va.setPreferredSize(new Dimension(10, 25));
        this.va.setRenderer(aj2);
        this.va.setMaximumRowCount(24);
        this.va.addActionListener(new v(this));
    }

    private void a(at at2, boolean bl2) {
        this.uK.clear();
        at2.mv();
        if (at2 != null) {
            int n2 = 0;
            while (n2 < at2.ms().size()) {
                this.uK.add(new best.d((c)at2.ms().get(n2)));
                ++n2;
            }
        }
        this.vh.addNotify();
    }

    private void mR() {
        ArrayList<best.d> arrayList = new ArrayList<best.d>();
        int n2 = 0;
        while (n2 < c.a.SR.O().size()) {
            if (((F)c.a.SR.O().get(n2)).gy() > 0) {
                arrayList.add(new best.d(((F)c.a.SR.O().get(n2)).getNome(), ((F)c.a.SR.O().get(n2)).fg(), ((F)c.a.SR.O().get(n2)).gy(), ((F)c.a.SR.O().get(n2)).gz()));
            }
            ++n2;
        }
        n2 = 0;
        while (n2 < c.a.SR.bJ().size()) {
            arrayList.add(new best.d(((best.b)c.a.SR.bJ().get(n2)).getN(), null, ((best.b)c.a.SR.bJ().get(n2)).v(), ((best.b)c.a.SR.bJ().get(n2)).w()));
            ++n2;
        }
        Collections.sort(arrayList, uV);
        this.uK.clear();
        n2 = 0;
        while (n2 < arrayList.size()) {
            this.uK.add((best.d)arrayList.get(n2));
            if (n2 == 400) break;
            ++n2;
        }
        this.vh.addNotify();
    }

    private void mS() {
        d d2 = new d(this.uK);
        this.vh.setModel(d2);
        int[] nArray = new int[]{10, 120, 120, 30, 30};
        int n2 = 0;
        while (n2 < nArray.length) {
            this.vh.getColumnModel().getColumn(n2).setPreferredWidth(nArray[n2]);
            ++n2;
        }
        this.vh.setAutoResizeMode(3);
        this.vh.setRowHeight(20);
        this.vh.setShowGrid(false);
        this.vh.setDefaultRenderer(best.d.class, new Z());
        this.vh.setAutoCreateRowSorter(false);
        this.vh.getTableHeader().setReorderingAllowed(false);
        this.vh.setIntercellSpacing(new Dimension(0, 0));
        this.vh.setCellSelectionEnabled(false);
        this.vh.setSelectionMode(0);
        this.vh.setRowSelectionAllowed(true);
        this.vh.setSelectionBackground(Color.YELLOW);
        this.vh.setFillsViewportHeight(true);
    }

    public void mH() {
        this.vb.addActionListener(new w(this));
        this.vc.addActionListener(new x(this));
    }

    private void mJ() {
        this.ut = new JScrollPane();
        this.vh = new JTable();
        this.vg = new JLabel();
        this.vf = new JLabel();
        this.vd = new JPanel();
        this.va = new JComboBox();
        this.ve = new JToolBar();
        this.vi = new JButton();
        this.uY = new JButton();
        this.uX = new JButton();
        this.uW = new JButton();
        this.uZ = new JButton();
        this.vb = new JButton();
        this.vc = new JButton();
        this.setBackground(new Color(104, 120, 100));
        this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.ut.setViewportView(this.vh);
        this.vg.setHorizontalAlignment(4);
        this.vg.setText("mostrar todos >>");
        this.vf.setFont(new Font("Tahoma", 1, 14));
        this.vf.setForeground(new Color(255, 255, 255));
        this.vf.setText("Artilheiros");
        this.vd.setBackground(new Color(35, 28, 14));
        this.vd.setPreferredSize(new Dimension(583, 40));
        this.vd.setLayout(new b());
        this.vd.add((Component)this.va, new a(447, 7, 200, 25));
        this.ve.setBackground(new Color(35, 28, 14));
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
        this.uY.setPressedIcon(new ImageIcon(this.getClass().getResource("/aiconsb/b0s.png")));
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
        this.vd.add((Component)this.ve, new a(0, 0, 440, 40));
        this.vb.setText("X");
        this.vc.setText("Melhores de sempre de todas competi\u00e7\u00f5es");
        GroupLayout groupLayout = new GroupLayout(this);
        this.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(19, 19, 19).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(groupLayout.createSequentialGroup().addComponent(this.vc, -2, 300, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, Short.MAX_VALUE).addComponent(this.vg, -2, 156, -2)).addGroup(GroupLayout.Alignment.LEADING, groupLayout.createSequentialGroup().addComponent(this.vf, -2, 368, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, Short.MAX_VALUE).addComponent(this.vb, -2, 50, -2)).addComponent(this.vd, GroupLayout.Alignment.LEADING, -1, 565, Short.MAX_VALUE).addComponent(this.ut, GroupLayout.Alignment.LEADING)).addGap(22, 22, 22)));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(17, 17, 17).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.vf).addComponent(this.vb)).addGap(11, 11, 11).addComponent(this.vd, -2, 40, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.ut, -2, 477, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.vg).addComponent(this.vc)).addContainerGap(-1, Short.MAX_VALUE)));
    }

    static /* synthetic */ void a(o o2, int n2) {
        o2.cB(n2);
    }

    static /* synthetic */ JComboBox a(o o2) {
        return o2.va;
    }

    static /* synthetic */ void b(o o2, int n2) {
        o2.cC(n2);
    }

    static /* synthetic */ JDialog b(o o2) {
        return o2.ub;
    }

    static /* synthetic */ void c(o o2) {
        o2.mR();
    }
}

