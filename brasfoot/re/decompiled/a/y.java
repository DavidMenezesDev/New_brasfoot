/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.A;
import a.B;
import a.aJ;
import a.z;
import b.Z;
import b.e;
import best.F;
import best.ah;
import best.aq;
import best.d;
import c.a;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;

public class y
extends JPanel {
    private JDialog ub;
    private ArrayList uK = new ArrayList();
    private int vk = -1;
    private int vl = -1;
    public static Comparator uV = new z();
    private JButton vm;
    private JComboBox ue;
    private JScrollPane ut;
    private JLabel vf;
    private JTable vn;

    public y(JDialog jDialog, ah ah2) {
        this.ub = jDialog;
        this.mJ();
        this.mH();
        this.mS();
        this.mQ();
        if (ah2 != null) {
            this.cD(ah2.getPais());
        }
        this.mG();
    }

    private void mG() {
        this.setBackground(aq.E(a.vM().getCorTema(), 1));
    }

    public void cD(int n2) {
        int n3 = 0;
        int n4 = 0;
        while (n4 < a.SR.N().size()) {
            if (((best.Z)a.SR.N().get(n4)).jc() == n2) {
                n3 = n4 + 1;
                break;
            }
            ++n4;
        }
        this.ue.setSelectedIndex(n3);
    }

    public void mT() {
        int n2 = this.ue.getSelectedIndex() - 1;
        this.vl = n2 >= 0 ? ((best.Z)a.SR.N().get(n2)).jc() : -1;
        ArrayList<d> arrayList = new ArrayList<d>();
        int n3 = 0;
        while (n3 < a.SR.O().size()) {
            int n4;
            boolean bl2 = false;
            if (this.vl == -1) {
                bl2 = true;
            } else if (((F)a.SR.O().get(n3)).fg() != null && ((F)a.SR.O().get(n3)).fg().getPais() == this.vl) {
                bl2 = true;
            }
            if (bl2 && (n4 = ((F)a.SR.O().get(n3)).gs()) > 0) {
                int n5 = ((F)a.SR.O().get(n3)).gu();
                arrayList.add(new d(((F)a.SR.O().get(n3)).getNome(), ((F)a.SR.O().get(n3)).fg(), n4, n5));
            }
            ++n3;
        }
        Collections.sort(arrayList, uV);
        this.uK.clear();
        n3 = 0;
        while (n3 < arrayList.size()) {
            this.uK.add((d)arrayList.get(n3));
            if (n3 == 400) break;
            ++n3;
        }
        this.vn.addNotify();
    }

    private void mQ() {
        this.ue.addItem("Internacional");
        int n2 = 0;
        while (n2 < a.SR.N().size()) {
            this.ue.addItem(((best.Z)a.SR.N().get(n2)).jp());
            if (((best.Z)a.SR.N().get(n2)).jc() == this.vk) {
                this.vl = n2 + 1;
            }
            ++n2;
        }
        aJ aJ2 = new aJ();
        aJ2.setPreferredSize(new Dimension(10, 25));
        this.ue.setRenderer(aJ2);
        this.ue.setMaximumRowCount(12);
        this.ue.setSelectedIndex(0);
        this.ue.addActionListener(new A(this));
    }

    private void mU() {
        this.mT();
    }

    private void mS() {
        e e2 = new e(this.uK);
        this.vn.setModel(e2);
        int[] nArray = new int[]{10, 120, 120, 30, 30};
        int n2 = 0;
        while (n2 < nArray.length) {
            this.vn.getColumnModel().getColumn(n2).setPreferredWidth(nArray[n2]);
            ++n2;
        }
        this.vn.setAutoResizeMode(3);
        this.vn.setRowHeight(20);
        this.vn.setShowGrid(false);
        this.vn.setFont(new Font("Helvetica", 0, 12));
        this.vn.setDefaultRenderer(d.class, new Z());
        this.vn.setAutoCreateRowSorter(false);
        this.vn.getTableHeader().setReorderingAllowed(false);
        this.vn.setIntercellSpacing(new Dimension(0, 0));
        this.vn.setCellSelectionEnabled(false);
        this.vn.setSelectionMode(0);
        this.vn.setRowSelectionAllowed(true);
        this.vn.setSelectionBackground(Color.YELLOW);
        this.vn.setFillsViewportHeight(true);
    }

    public void mH() {
        this.vm.addActionListener(new B(this));
    }

    private void mJ() {
        this.vf = new JLabel();
        this.ut = new JScrollPane();
        this.vn = new JTable();
        this.ue = new JComboBox();
        this.vm = new JButton();
        this.setBackground(new Color(104, 120, 100));
        this.vf.setFont(new Font("Tahoma", 1, 12));
        this.vf.setForeground(new Color(255, 255, 255));
        this.vf.setText("L\u00edderes de assist\u00eancias");
        this.vn.setModel(new DefaultTableModel(new Object[0][], new String[0]));
        this.ut.setViewportView(this.vn);
        this.vm.setText("X");
        GroupLayout groupLayout = new GroupLayout(this);
        this.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(19, 19, 19).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addComponent(this.vf, -2, 211, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE).addComponent(this.ue, -2, 167, -2).addGap(18, 18, 18).addComponent(this.vm, -2, 49, -2)).addComponent(this.ut, -2, 557, -2)).addContainerGap(15, Short.MAX_VALUE)));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(19, 19, 19).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.ue, -2, 23, -2).addComponent(this.vf).addComponent(this.vm)).addGap(18, 18, 18).addComponent(this.ut, -2, 530, -2).addContainerGap(18, Short.MAX_VALUE)));
    }

    static /* synthetic */ void a(y y2) {
        y2.mU();
    }

    static /* synthetic */ JDialog b(y y2) {
        return y2.ub;
    }
}

