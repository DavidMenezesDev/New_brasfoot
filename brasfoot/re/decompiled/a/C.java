/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.D;
import a.E;
import a.F;
import a.G;
import b.aa;
import b.f;
import best.I;
import best.ah;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle;

public class C
extends JPanel {
    private JDialog ub;
    private ah uk;
    private int dF = 0;
    private ArrayList vp = new ArrayList();
    private JButton vq;
    private JButton vb;
    private JButton vc;
    private JLabel ug;
    private JScrollPane ut;
    private JLabel vf;
    private JTable vr;

    public C(JDialog jDialog, ah ah2, I i2) {
        this.ub = jDialog;
        this.uk = ah2;
        if (this.uk == i2.hc()) {
            this.vp.addAll(i2.hp());
            this.dF = 1;
        } else {
            this.vp.addAll(i2.hq());
            this.dF = 2;
        }
        this.mJ();
        this.ug.setIcon(this.uk.kU());
        this.ug.setText(this.uk.getNome());
        this.mV();
        this.vr.setRowSelectionInterval(0, 0);
        this.a(this);
        this.mH();
    }

    private void a(JComponent jComponent) {
        InputMap inputMap = jComponent.getInputMap(1);
        jComponent.getInputMap().put(KeyStroke.getKeyStroke(115, 512), "st");
        ActionMap actionMap = this.getActionMap();
        jComponent.getActionMap().put("st", new D(this));
    }

    public void mH() {
        this.vq.addActionListener(new E(this));
        this.vb.addActionListener(new F(this));
        this.vc.addActionListener(new G(this));
    }

    private void cE(int n2) {
        int n3 = this.vr.getSelectedRow();
        if (n3 >= 0) {
            if (n2 == 1) {
                if (n3 - 1 >= 0) {
                    Collections.swap(this.vp, n3, n3 - 1);
                    this.vr.setRowSelectionInterval(n3 - 1, n3 - 1);
                }
            } else if (n2 == -1 && n3 + 1 < this.vp.size()) {
                Collections.swap(this.vp, n3, n3 + 1);
                this.vr.setRowSelectionInterval(n3 + 1, n3 + 1);
            }
        }
        this.vr.addNotify();
    }

    public void mV() {
        f f2 = new f(this.vp);
        this.vr.setModel(f2);
        int[] nArray = new int[]{25, 75, 30, 55, 95};
        int n2 = 0;
        while (n2 < nArray.length) {
            this.vr.getColumnModel().getColumn(n2).setPreferredWidth(nArray[n2]);
            ++n2;
        }
        this.vr.setAutoResizeMode(3);
        this.vr.setRowHeight(20);
        this.vr.setShowGrid(false);
        this.vr.setDefaultRenderer(best.F.class, new aa());
        this.vr.setAutoCreateRowSorter(false);
        this.vr.getTableHeader().setReorderingAllowed(false);
        this.vr.setCellSelectionEnabled(false);
        this.vr.setSelectionMode(0);
        this.vr.setRowSelectionAllowed(true);
        this.vr.setSelectionBackground(Color.YELLOW);
        this.vr.setFillsViewportHeight(true);
    }

    private void mJ() {
        this.vf = new JLabel();
        this.ut = new JScrollPane();
        this.vr = new JTable();
        this.vq = new JButton();
        this.ug = new JLabel();
        this.vb = new JButton();
        this.vc = new JButton();
        this.setBackground(new Color(204, 204, 204));
        this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.vf.setFont(new Font("Tahoma", 1, 14));
        this.vf.setHorizontalAlignment(0);
        this.vf.setText("Disputa penalties - ordem dos batedores");
        this.ut.setViewportView(this.vr);
        this.vq.setIcon(new ImageIcon(this.getClass().getResource("/aicons/ball.png")));
        this.vq.setText("Jogar");
        this.ug.setForeground(new Color(102, 102, 102));
        this.ug.setHorizontalAlignment(0);
        this.ug.setText("time");
        this.vb.setIcon(new ImageIcon(this.getClass().getResource("/aicons/uparray.png")));
        this.vb.setText("subir");
        this.vc.setIcon(new ImageIcon(this.getClass().getResource("/aicons/downarray.png")));
        this.vc.setText("descer");
        GroupLayout groupLayout = new GroupLayout(this);
        this.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(20, 20, 20).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.vf, -1, -1, Short.MAX_VALUE).addComponent(this.ut, -1, 360, Short.MAX_VALUE).addComponent(this.ug, -1, -1, Short.MAX_VALUE)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.vc, -1, -1, Short.MAX_VALUE).addComponent(this.vb, -1, -1, Short.MAX_VALUE)).addComponent(this.vq)).addContainerGap(11, Short.MAX_VALUE)));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.vf).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, Short.MAX_VALUE).addComponent(this.ug).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addComponent(this.vb).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.vc).addGap(313, 313, 313).addComponent(this.vq, -2, 32, -2)).addComponent(this.ut, -2, 431, -2)).addGap(25, 25, 25)));
    }

    static /* synthetic */ int a(C c2) {
        return c2.dF;
    }

    static /* synthetic */ ArrayList b(C c2) {
        return c2.vp;
    }

    static /* synthetic */ JDialog c(C c2) {
        return c2.ub;
    }

    static /* synthetic */ void a(C c2, int n2) {
        c2.cE(n2);
    }
}

