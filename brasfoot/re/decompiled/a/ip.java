/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.a;
import a.iq;
import a.ir;
import a.is;
import a.it;
import b.S;
import b.aL;
import best.al;
import best.aq;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;

public class ip
extends JPanel {
    private JDialog ub = null;
    private al Es = null;
    private JButton MC;
    private JButton vm;
    private JButton yZ;
    private JLabel ug;
    private JLabel uh;
    private JScrollPane ut;
    private JTable MD;

    public ip(JDialog jDialog) {
        this.ub = jDialog;
        this.mJ();
        this.mH();
        this.mS();
        this.uh.setText(Integer.toString(c.a.SR.M().size()));
        if (this.MD.getRowCount() > 0) {
            this.MD.setRowSelectionInterval(0, 0);
            this.Es = (al)c.a.SR.M().get(0);
        }
        this.mG();
    }

    private void mG() {
        this.setBackground(aq.E(c.a.vM().getCorTema(), 1));
    }

    public void mH() {
        this.vm.addActionListener(new iq(this));
        this.yZ.addActionListener(new ir(this));
        this.MC.addActionListener(new is(this));
    }

    private void mI() {
        if (c.a.SR.M().size() < 20) {
            JDialog jDialog = new JDialog(this.ub);
            a a2 = new a(jDialog);
            jDialog.add(a2);
            jDialog.setSize(400, 230);
            jDialog.setPreferredSize(new Dimension(400, 230));
            jDialog.setModal(true);
            jDialog.setResizable(false);
            jDialog.setLocationRelativeTo(null);
            jDialog.setUndecorated(true);
            jDialog.setVisible(true);
            this.MD.addNotify();
            this.uh.setText(Integer.toString(c.a.SR.M().size()));
        } else {
            JOptionPane.showMessageDialog(this.ub, "Limite de t\u00e9cnicos atingido.", "Adicionar", 2);
        }
    }

    private void nB() {
        if (this.MD.getSelectedRowCount() > 0) {
            int n2 = this.MD.getSelectedRow();
            this.Es = (al)c.a.SR.M().get(n2);
            if (this.Es.fg() != null) {
                JOptionPane.showMessageDialog(this.ub, "Para remover um t\u00e9cnico \u00e9 necess\u00e1rio antes demiti-lo do time.", "Remover t\u00e9cnico", 2);
            } else {
                int n3 = -1;
                n3 = JOptionPane.showConfirmDialog(this.ub, "Deseja aposentar o t\u00e9cnico?", "Confirma\u00e7\u00e3o", 0);
                if (n3 == 0) {
                    this.Es.lP();
                    this.Es = null;
                    this.MD.addNotify();
                }
            }
        }
        this.uh.setText(Integer.toString(c.a.SR.M().size()));
    }

    private void mS() {
        S s2 = new S(c.a.SR.M());
        this.MD.setModel(s2);
        int[] nArray = new int[]{120, 120};
        int n2 = 0;
        while (n2 < nArray.length) {
            this.MD.getColumnModel().getColumn(n2).setPreferredWidth(nArray[n2]);
            ++n2;
        }
        this.MD.setAutoResizeMode(3);
        this.MD.setRowHeight(20);
        this.MD.setShowGrid(false);
        this.MD.setDefaultRenderer(al.class, new aL());
        this.MD.setAutoCreateRowSorter(false);
        this.MD.getTableHeader().setReorderingAllowed(false);
        this.MD.setIntercellSpacing(new Dimension(0, 0));
        this.MD.setCellSelectionEnabled(false);
        this.MD.setSelectionMode(0);
        this.MD.setRowSelectionAllowed(true);
        this.MD.setSelectionBackground(Color.YELLOW);
        this.MD.setFillsViewportHeight(true);
        this.MD.getSelectionModel().addListSelectionListener(new it(this));
    }

    private void mJ() {
        this.ug = new JLabel();
        this.ut = new JScrollPane();
        this.MD = new JTable();
        this.yZ = new JButton();
        this.MC = new JButton();
        this.uh = new JLabel();
        this.vm = new JButton();
        this.setBackground(new Color(104, 120, 100));
        this.ug.setFont(new Font("Tahoma", 1, 12));
        this.ug.setForeground(new Color(255, 255, 255));
        this.ug.setText("T\u00e9cnicos humanos");
        this.ut.setViewportView(this.MD);
        this.yZ.setText("Remover selecionado");
        this.MC.setText("Adicionar novo");
        this.uh.setForeground(new Color(255, 255, 255));
        this.uh.setIcon(new ImageIcon(this.getClass().getResource("/aicons/iconcoach16.png")));
        this.uh.setText("12");
        this.vm.setText("X");
        GroupLayout groupLayout = new GroupLayout(this);
        this.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(30, 30, 30).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(groupLayout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(this.yZ, -2, 165, -2).addGap(28, 28, 28).addComponent(this.MC, -2, 155, -2).addGap(51, 51, 51).addComponent(this.uh)).addGroup(GroupLayout.Alignment.LEADING, groupLayout.createSequentialGroup().addComponent(this.ug, -2, 157, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, Short.MAX_VALUE).addComponent(this.vm, -2, 49, -2)).addComponent(this.ut, GroupLayout.Alignment.LEADING, -2, 0, Short.MAX_VALUE)).addGap(29, 29, 29)));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.ug).addComponent(this.vm)).addGap(18, 18, 18).addComponent(this.ut, -2, 307, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.yZ).addComponent(this.MC).addComponent(this.uh)).addContainerGap(19, Short.MAX_VALUE)));
    }

    static /* synthetic */ JDialog a(ip ip2) {
        return ip2.ub;
    }

    static /* synthetic */ void b(ip ip2) {
        ip2.nB();
    }

    static /* synthetic */ void c(ip ip2) {
        ip2.mI();
    }

    static /* synthetic */ JTable d(ip ip2) {
        return ip2.MD;
    }

    static /* synthetic */ void a(ip ip2, al al2) {
        ip2.Es = al2;
    }
}

