/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.jI;
import a.jJ;
import a.jK;
import a.jL;
import a.jM;
import a.jN;
import a.jO;
import a.jP;
import a.jQ;
import a.jR;
import a.jS;
import b.aT;
import b.aV;
import best.Z;
import best.ah;
import c.a;
import f.B;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class jH
extends JPanel {
    private ah ul = null;
    private ah zY = null;
    private ArrayList afC = new ArrayList();
    private ArrayList um = new ArrayList();
    private int nTimes = 8;
    private int[] afD = new int[]{8, 4, 6};
    private JButton yV;
    private JButton afE;
    private JButton uC;
    private JButton Bw;
    private JButton yZ;
    private JButton afF;
    private JCheckBox CS;
    private JComboBox afG;
    private JTextField Nr;
    private JTextField afH;
    private JLabel ug;
    private JLabel a_;
    private JLabel us;
    private JLabel vx;
    private JLabel vy;
    private JLabel vz;
    private JScrollPane ut;
    private JScrollPane wi;
    private JLabel zh;
    private JLabel uu;
    private JPanel uv;
    private JTable vn;
    private JTree uw;

    public jH(JFrame jFrame) {
        this.ul = (ah)a.SR.aN().get(0);
        this.afC.add(this.ul);
        this.mJ();
        this.mW();
        this.Ay();
        this.mH();
        this.mM();
        this.zh.setText("");
        this.pO();
        this.AT();
    }

    private void Ay() {
        aT aT2 = new aT(this.afC);
        this.vn.setModel(aT2);
        int[] nArray = new int[]{40, 300, 100};
        int n2 = 0;
        while (n2 < nArray.length) {
            this.vn.getColumnModel().getColumn(n2).setPreferredWidth(nArray[n2]);
            ++n2;
        }
        this.vn.getColumnModel().getColumn(0).setMaxWidth(40);
        this.vn.getColumnModel().getColumn(1).setMaxWidth(300);
        this.vn.getColumnModel().getColumn(2).setMaxWidth(100);
        this.vn.setAutoResizeMode(3);
        this.vn.setRowHeight(20);
        this.vn.setShowGrid(false);
        this.vn.setDefaultRenderer(ah.class, new aV(2));
        this.vn.setAutoCreateRowSorter(false);
        this.vn.setIntercellSpacing(new Dimension(0, 0));
        this.vn.setCellSelectionEnabled(false);
        this.vn.setSelectionMode(0);
        this.vn.setRowSelectionAllowed(true);
        this.vn.setSelectionBackground(Color.YELLOW);
        this.vn.setFillsViewportHeight(true);
        this.vn.setTableHeader(null);
    }

    public void mH() {
        this.CS.addActionListener(new jI(this));
        this.Bw.addActionListener(new jL(this));
        this.uC.addActionListener(new jM(this));
        this.yZ.addActionListener(new jN(this));
        this.yV.addActionListener(new jO(this));
        this.afF.addActionListener(new jP(this));
        this.afE.addActionListener(new jQ(this));
    }

    private void fz(int n2) {
        int n3 = this.vn.getSelectedRow();
        if (n3 >= 0) {
            if (n2 == -1) {
                if (n3 - 1 >= 0) {
                    Collections.swap(this.afC, n3, n3 - 1);
                    this.vn.setRowSelectionInterval(n3 - 1, n3 - 1);
                }
            } else if (n2 == 0 && n3 + 1 < this.afC.size()) {
                Collections.swap(this.afC, n3, n3 + 1);
                this.vn.setRowSelectionInterval(n3 + 1, n3 + 1);
            }
        }
        this.pO();
        this.vn.addNotify();
    }

    private void nA() {
        if (this.zY != null && this.afC.size() < this.nTimes && !this.afC.contains(this.zY)) {
            this.afC.add(this.zY);
            this.vn.addNotify();
            this.pO();
        }
    }

    private void pO() {
        this.vz.setText("Participantes:" + this.afC.size() + "/" + this.nTimes);
        int n2 = 0;
        while (n2 < this.afC.size()) {
            if (n2 < this.nTimes) {
                if (this.nTimes == 4 || this.nTimes == 8) {
                    if (n2 < 4) {
                        ((ah)this.afC.get(n2)).fr(0);
                    } else {
                        ((ah)this.afC.get(n2)).fr(1);
                    }
                } else {
                    ((ah)this.afC.get(n2)).fr(0);
                }
                if (this.CS.isSelected()) {
                    ((ah)this.afC.get(n2)).fr(2);
                }
            } else {
                ((ah)this.afC.get(n2)).fr(-1);
            }
            ++n2;
        }
        this.vn.addNotify();
    }

    private void nB() {
        if (this.vn.getSelectedRow() >= 0 && this.vn.getSelectedRow() < this.afC.size() && this.afC.get(this.vn.getSelectedRow()) != this.ul) {
            this.afC.remove(this.afC.get(this.vn.getSelectedRow()));
            this.vn.addNotify();
            this.pO();
        }
    }

    private void mW() {
        this.afG.addItem("2 grupos de 4, semi e final");
        this.afG.addItem("1 grupo de 4, final");
        this.afG.addItem("1 grupo de 6");
        this.afG.setSelectedIndex(0);
        this.afG.addActionListener(new jR(this));
    }

    private void AT() {
        this.nTimes = this.afD[this.afG.getSelectedIndex()];
        this.pO();
        this.zh.setText("");
        this.vn.addNotify();
    }

    private void pn() {
        if (this.afC.size() == this.afD[this.afG.getSelectedIndex()]) {
            this.AU();
        } else {
            this.zh.setText("Adicione pelo menos " + this.afD[this.afG.getSelectedIndex()] + " times");
        }
    }

    private void AU() {
        String string = "Torneio Amistoso";
        String string2 = "Juazeiro";
        if (!this.Nr.getText().toString().isEmpty() && this.Nr.getText().toString().length() < 50) {
            string = this.Nr.getText();
        }
        if (!this.afH.getText().toString().isEmpty() && this.afH.getText().toString().length() < 50) {
            string2 = this.afH.getText();
        }
        if (a.SR.yn() != null) {
            a.SR.yn().a(this.afC, this.afG.getSelectedIndex(), string, string2, this.CS.isSelected());
        }
        this.Bw.setCursor(new Cursor(3));
        a.SR.az();
        a.SR.V();
    }

    private void AV() {
        this.Bw.setCursor(new Cursor(3));
        a.SR.az();
        a.SR.V();
    }

    private void mM() {
        this.uw.getSelectionModel().setSelectionMode(1);
        this.uw.addTreeSelectionListener(new jS(this));
        int n2 = 0;
        while (n2 < a.SR.P().size()) {
            if (!((ah)a.SR.P().get(n2)).kn().booleanValue()) {
                this.um.add((ah)a.SR.P().get(n2));
                Collections.sort(this.um, h.a.VS);
            }
            ++n2;
        }
        DefaultMutableTreeNode defaultMutableTreeNode = new DefaultMutableTreeNode("Times");
        this.a(defaultMutableTreeNode);
        this.uw.setModel(new DefaultTreeModel(defaultMutableTreeNode));
    }

    private void a(DefaultMutableTreeNode defaultMutableTreeNode) {
        DefaultMutableTreeNode defaultMutableTreeNode2 = null;
        DefaultMutableTreeNode defaultMutableTreeNode3 = null;
        DefaultMutableTreeNode defaultMutableTreeNode4 = null;
        int n2 = 0;
        while (n2 < a.SR.N().size()) {
            defaultMutableTreeNode2 = new DefaultMutableTreeNode(((Z)a.SR.N().get(n2)).jp());
            defaultMutableTreeNode.add(defaultMutableTreeNode2);
            int n3 = 0;
            while (n3 < ((Z)a.SR.N().get(n2)).eb().size()) {
                if (((B)((Z)a.SR.N().get(n2)).eb().get(n3)).yi().yK().size() > 0) {
                    defaultMutableTreeNode3 = new DefaultMutableTreeNode(((B)((Z)a.SR.N().get(n2)).eb().get(n3)).getNome());
                    defaultMutableTreeNode2.add(defaultMutableTreeNode3);
                    int n4 = 0;
                    while (n4 < ((B)((Z)a.SR.N().get(n2)).eb().get(n3)).yi().yK().size()) {
                        defaultMutableTreeNode4 = new DefaultMutableTreeNode(((B)((Z)a.SR.N().get(n2)).eb().get(n3)).yi().yK().get(n4));
                        defaultMutableTreeNode3.add(defaultMutableTreeNode4);
                        ++n4;
                    }
                }
                ++n3;
            }
            if (((Z)a.SR.N().get(n2)).ek().size() > 0) {
                defaultMutableTreeNode3 = new DefaultMutableTreeNode("Regionais");
                defaultMutableTreeNode2.add(defaultMutableTreeNode3);
                n3 = 0;
                while (n3 < ((Z)a.SR.N().get(n2)).ek().size()) {
                    defaultMutableTreeNode4 = new DefaultMutableTreeNode(((Z)a.SR.N().get(n2)).ek().get(n3));
                    defaultMutableTreeNode3.add(defaultMutableTreeNode4);
                    ++n3;
                }
            }
            ++n2;
        }
        if (this.um.size() > 0) {
            defaultMutableTreeNode2 = new DefaultMutableTreeNode("Internacionais");
            defaultMutableTreeNode.add(defaultMutableTreeNode2);
            n2 = 0;
            while (n2 < this.um.size()) {
                defaultMutableTreeNode4 = new DefaultMutableTreeNode(this.um.get(n2));
                defaultMutableTreeNode2.add(defaultMutableTreeNode4);
                ++n2;
            }
        }
    }

    private void mJ() {
        this.uu = new JLabel();
        this.uv = new JPanel();
        this.a_ = new JLabel();
        this.us = new JLabel();
        this.afG = new JComboBox();
        this.Bw = new JButton();
        this.ut = new JScrollPane();
        this.uw = new JTree();
        this.vx = new JLabel();
        this.Nr = new JTextField();
        this.vy = new JLabel();
        this.wi = new JScrollPane();
        this.vn = new JTable();
        this.yV = new JButton();
        this.yZ = new JButton();
        this.vz = new JLabel();
        this.zh = new JLabel();
        this.afH = new JTextField();
        this.afF = new JButton();
        this.CS = new JCheckBox();
        this.afE = new JButton();
        this.uC = new JButton();
        this.ug = new JLabel();
        this.setBackground(new Color(42, 64, 29));
        this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        this.uu.setFont(new Font("Tahoma", 1, 12));
        this.uu.setForeground(new Color(255, 255, 102));
        this.uu.setText("Torneio Amistoso");
        this.uv.setBackground(new Color(84, 127, 59));
        this.a_.setFont(new Font("Tahoma", 0, 12));
        this.a_.setForeground(new Color(255, 255, 255));
        this.a_.setHorizontalAlignment(2);
        this.a_.setText("Escolha os participantes:");
        this.us.setFont(new Font("Tahoma", 0, 12));
        this.us.setForeground(new Color(255, 255, 255));
        this.us.setHorizontalAlignment(4);
        this.us.setText("F\u00f3rmula:");
        this.Bw.setFont(new Font("Tahoma", 0, 14));
        this.Bw.setText("Iniciar");
        DefaultMutableTreeNode defaultMutableTreeNode = new DefaultMutableTreeNode("Times");
        DefaultMutableTreeNode defaultMutableTreeNode2 = new DefaultMutableTreeNode("Brasil");
        DefaultMutableTreeNode defaultMutableTreeNode3 = new DefaultMutableTreeNode("1\u00aa divis\u00e3o");
        DefaultMutableTreeNode defaultMutableTreeNode4 = new DefaultMutableTreeNode("Cruzeiro");
        defaultMutableTreeNode3.add(defaultMutableTreeNode4);
        defaultMutableTreeNode4 = new DefaultMutableTreeNode("Atl\u00e9tico");
        defaultMutableTreeNode3.add(defaultMutableTreeNode4);
        defaultMutableTreeNode2.add(defaultMutableTreeNode3);
        defaultMutableTreeNode3 = new DefaultMutableTreeNode("2\u00aa divis\u00e3o");
        defaultMutableTreeNode4 = new DefaultMutableTreeNode("Barcelona");
        defaultMutableTreeNode3.add(defaultMutableTreeNode4);
        defaultMutableTreeNode4 = new DefaultMutableTreeNode("Real Madrid");
        defaultMutableTreeNode3.add(defaultMutableTreeNode4);
        defaultMutableTreeNode2.add(defaultMutableTreeNode3);
        defaultMutableTreeNode.add(defaultMutableTreeNode2);
        defaultMutableTreeNode2 = new DefaultMutableTreeNode("Espanha");
        defaultMutableTreeNode3 = new DefaultMutableTreeNode("1\u00aa Divis\u00e3o");
        defaultMutableTreeNode4 = new DefaultMutableTreeNode("Sevilla");
        defaultMutableTreeNode3.add(defaultMutableTreeNode4);
        defaultMutableTreeNode4 = new DefaultMutableTreeNode("Gijon");
        defaultMutableTreeNode3.add(defaultMutableTreeNode4);
        defaultMutableTreeNode2.add(defaultMutableTreeNode3);
        defaultMutableTreeNode3 = new DefaultMutableTreeNode("2\u00aa divis\u00e3o");
        defaultMutableTreeNode4 = new DefaultMutableTreeNode("Sporting");
        defaultMutableTreeNode3.add(defaultMutableTreeNode4);
        defaultMutableTreeNode2.add(defaultMutableTreeNode3);
        defaultMutableTreeNode.add(defaultMutableTreeNode2);
        defaultMutableTreeNode2 = new DefaultMutableTreeNode("Outros Times");
        defaultMutableTreeNode3 = new DefaultMutableTreeNode("M\u00e1laga");
        defaultMutableTreeNode2.add(defaultMutableTreeNode3);
        defaultMutableTreeNode3 = new DefaultMutableTreeNode("Alecrim");
        defaultMutableTreeNode2.add(defaultMutableTreeNode3);
        defaultMutableTreeNode.add(defaultMutableTreeNode2);
        this.uw.setModel(new DefaultTreeModel(defaultMutableTreeNode));
        this.ut.setViewportView(this.uw);
        this.vx.setFont(new Font("Tahoma", 0, 12));
        this.vx.setForeground(new Color(255, 255, 255));
        this.vx.setHorizontalAlignment(4);
        this.vx.setText("Nome do Torneio:");
        this.Nr.setText("Torneio Amistoso");
        this.Nr.addActionListener(new jJ(this));
        this.vy.setFont(new Font("Tahoma", 0, 12));
        this.vy.setForeground(new Color(255, 255, 255));
        this.vy.setHorizontalAlignment(4);
        this.vy.setText("Sede (escolha uma cidade):");
        this.vn.setModel(new DefaultTableModel(new Object[0][], new String[0]));
        this.wi.setViewportView(this.vn);
        this.yV.setText(">>");
        this.yZ.setText("<<");
        this.vz.setFont(new Font("Tahoma", 0, 12));
        this.vz.setForeground(new Color(255, 255, 255));
        this.vz.setHorizontalAlignment(2);
        this.vz.setText("Participantes:");
        this.zh.setForeground(new Color(255, 255, 255));
        this.zh.setHorizontalAlignment(0);
        this.zh.setText("\"\"");
        this.afH.setText("Juazeiro");
        this.afH.setToolTipText("");
        this.afH.addActionListener(new jK(this));
        this.afF.setIcon(new ImageIcon(this.getClass().getResource("/aicons/uparray.png")));
        this.CS.setFont(new Font("Tahoma", 0, 12));
        this.CS.setForeground(new Color(255, 255, 255));
        this.CS.setText("Sortear grupos");
        this.CS.setOpaque(false);
        this.afE.setIcon(new ImageIcon(this.getClass().getResource("/aicons/downarray.png")));
        this.uC.setFont(new Font("Tahoma", 0, 14));
        this.uC.setText("Cancelar torneio");
        GroupLayout groupLayout = new GroupLayout(this.uv);
        this.uv.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap(16, Short.MAX_VALUE).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.ut, GroupLayout.Alignment.TRAILING, -2, 266, -2).addComponent(this.a_, GroupLayout.Alignment.TRAILING, -2, 266, -2).addComponent(this.zh, GroupLayout.Alignment.TRAILING, -2, 257, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.yZ).addComponent(this.yV)).addComponent(this.afF)).addComponent(this.afE)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addComponent(this.wi, -2, 279, -2).addGap(19, 24, Short.MAX_VALUE)).addGroup(groupLayout.createSequentialGroup().addComponent(this.vz, -1, -1, Short.MAX_VALUE).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, Short.MAX_VALUE).addComponent(this.CS, -2, 145, -2).addGap(78, 78, 78)))).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(62, 62, 62).addComponent(this.vy, -2, 190, -2)).addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(this.us, -2, 242, -2)).addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(this.vx, -2, 242, -2))).addGap(30, 30, 30).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.afG, 0, -1, Short.MAX_VALUE).addComponent(this.Nr).addComponent(this.afH, GroupLayout.Alignment.TRAILING, -1, 243, Short.MAX_VALUE)).addContainerGap(-1, Short.MAX_VALUE)).addGroup(groupLayout.createSequentialGroup().addGap(66, 66, 66).addComponent(this.uC, -2, 164, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, Short.MAX_VALUE).addComponent(this.Bw, -2, 164, -2).addGap(122, 122, 122)));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap(26, Short.MAX_VALUE).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.Nr, -2, -1, -2).addComponent(this.vx)).addGap(18, 18, 18).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.afG, -2, -1, -2).addComponent(this.us)).addGap(18, 18, 18).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.vy).addComponent(this.afH, -2, -1, -2)).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(48, 48, 48).addComponent(this.yV).addGap(18, 18, 18).addComponent(this.yZ).addGap(44, 44, 44).addComponent(this.afF).addGap(18, 18, 18).addComponent(this.afE)).addGroup(groupLayout.createSequentialGroup().addGap(20, 20, 20).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.vz).addComponent(this.a_)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.ut, -2, 206, -2).addComponent(this.wi, -2, 206, -2)))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.CS).addComponent(this.zh)).addGap(18, 18, 18).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.uC, -2, 39, -2).addComponent(this.Bw, -2, 39, -2)).addGap(28, 28, 28)));
        this.ug.setForeground(new Color(255, 255, 255));
        this.ug.setText("Realizado em centros de treinamento, n\u00e3o geram receita para os times.");
        GroupLayout groupLayout2 = new GroupLayout(this);
        this.setLayout(groupLayout2);
        groupLayout2.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addGap(27, 27, 27).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.uu, -2, 434, -2).addComponent(this.ug, -2, 646, -2).addComponent(this.uv, -2, -1, -2)).addContainerGap(25, Short.MAX_VALUE)));
        groupLayout2.setVerticalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addGap(21, 21, 21).addComponent(this.uu).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.ug).addGap(7, 7, 7).addComponent(this.uv, -2, -1, -2).addContainerGap(21, Short.MAX_VALUE)));
    }

    private void d(ActionEvent actionEvent) {
    }

    private void e(ActionEvent actionEvent) {
    }

    static /* synthetic */ void a(jH jH2) {
        jH2.pO();
    }

    static /* synthetic */ void b(jH jH2) {
        jH2.pn();
    }

    static /* synthetic */ void c(jH jH2) {
        jH2.AV();
    }

    static /* synthetic */ void d(jH jH2) {
        jH2.nB();
    }

    static /* synthetic */ void e(jH jH2) {
        jH2.nA();
    }

    static /* synthetic */ void a(jH jH2, int n2) {
        jH2.fz(n2);
    }

    static /* synthetic */ void f(jH jH2) {
        jH2.AT();
    }

    static /* synthetic */ JTree g(jH jH2) {
        return jH2.uw;
    }

    static /* synthetic */ void a(jH jH2, ah ah2) {
        jH2.zY = ah2;
    }

    static /* synthetic */ void a(jH jH2, ActionEvent actionEvent) {
        jH2.d(actionEvent);
    }

    static /* synthetic */ void b(jH jH2, ActionEvent actionEvent) {
        jH2.e(actionEvent);
    }
}

