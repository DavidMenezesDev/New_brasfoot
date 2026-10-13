/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.cz;
import a.dt;
import a.du;
import a.dv;
import a.dw;
import a.dx;
import a.dy;
import a.l;
import b.N;
import b.aI;
import best.F;
import best.K;
import best.ah;
import best.aq;
import c.a;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
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
import javax.swing.UIManager;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class ds
extends JPanel {
    private ah zu = null;
    private ah Af = null;
    private F FL = null;
    private JDialog ub;
    private boolean FM = false;
    private static boolean Ag = false;
    private JButton FN;
    private JButton FO;
    private JButton FP;
    private JButton FQ;
    private JButton vb;
    private JLabel ug;
    private JLabel uh;
    private JPanel vd;
    private JScrollPane ut;
    private JTable FR;

    public ds(JDialog jDialog, ah ah2, ah ah3) {
        this.ub = jDialog;
        this.Af = ah2;
        this.zu = ah3;
        Ag = false;
        this.FM = this.Af == this.zu;
        UIManager.put("ProgressBar.selectionForeground", Color.WHITE);
        UIManager.put("ProgressBar.selectionBackground", Color.BLACK);
        this.mJ();
        this.mH();
        this.pK();
        this.pJ();
        this.ug.setIcon(this.zu.x(30, 30));
        if (!this.FM) {
            this.FQ.setVisible(false);
            this.FP.setVisible(false);
            this.FO.setVisible(false);
            if (this.Af.ky().size() >= 20) {
                this.FN.setEnabled(false);
            } else {
                this.FN.setEnabled(true);
            }
        } else {
            this.FN.setVisible(false);
            this.FO.setVisible(true);
        }
        this.mG();
    }

    private void mG() {
        this.setBackground(aq.E(a.vM().getCorTema(), 1));
    }

    public void z(F f2) {
        this.FL = f2;
    }

    public void pJ() {
        N n2 = new N(this.zu, this);
        this.FR.setModel(n2);
        int[] nArray = new int[]{20, 25, 55, 110, 25, 25, 120, 100, 60, 90, 80};
        int n3 = 0;
        while (n3 < nArray.length) {
            this.FR.getColumnModel().getColumn(n3).setPreferredWidth(nArray[n3]);
            ++n3;
        }
        this.FR.setAutoResizeMode(3);
        this.FR.setRowHeight(20);
        this.FR.setShowGrid(false);
        this.FR.setDefaultRenderer(F.class, new aI());
        this.FR.setAutoCreateRowSorter(false);
        this.FR.getTableHeader().setReorderingAllowed(false);
        this.FR.setCellSelectionEnabled(false);
        this.FR.setSelectionMode(0);
        this.FR.setRowSelectionAllowed(true);
        this.FR.setSelectionBackground(Color.YELLOW);
        this.FR.setFillsViewportHeight(true);
        if (this.FR.getRowCount() > 0) {
            this.FR.setRowSelectionInterval(0, 0);
        }
        this.FR.getSelectionModel().addListSelectionListener(new dt(this));
        TableRowSorter<TableModel> tableRowSorter = new TableRowSorter<TableModel>(this.FR.getModel());
        this.FR.setRowSorter(tableRowSorter);
        tableRowSorter.setComparator(1, h.a.abe);
        tableRowSorter.setComparator(3, h.a.abk);
        tableRowSorter.setComparator(4, h.a.VU);
        tableRowSorter.setComparator(5, h.a.aba);
        tableRowSorter.setComparator(6, h.a.aaI);
        tableRowSorter.setComparator(7, h.a.aaH);
        tableRowSorter.setComparator(9, h.a.aaW);
        if (((N)this.FR.getModel()).getRowCount() > 0) {
            this.FR.setRowSelectionInterval(0, 0);
        }
    }

    public static boolean nX() {
        return Ag;
    }

    public void pK() {
        if (this.FM) {
            this.uh.setText("Vagas: " + Integer.toString(this.zu.ky().size()) + "/" + Integer.toString(20));
        } else {
            this.uh.setText(String.valueOf(Integer.toString(this.zu.ky().size())) + " jogadores");
        }
    }

    public void mH() {
        this.vb.addActionListener(new du(this));
        this.FQ.addActionListener(new dv(this));
        this.FP.addActionListener(new dw(this));
        this.FN.addActionListener(new dx(this));
        this.FO.addActionListener(new dy(this));
    }

    private boolean pL() {
        if (this.FM) {
            return false;
        }
        if (this.FR.getSelectedRow() >= 0 && this.FL != null) {
            best.l.l(false);
            if (this.Af.ky().size() < 20) {
                JDialog jDialog = new JDialog(this.ub);
                cz cz2 = new cz(jDialog, this.FL, this.Af, true);
                jDialog.add(cz2);
                jDialog.setSize(373, 300);
                jDialog.setPreferredSize(new Dimension(373, 300));
                jDialog.setModal(true);
                jDialog.setResizable(false);
                jDialog.setLocationRelativeTo(null);
                jDialog.setUndecorated(true);
                jDialog.setVisible(true);
                if (best.l.cO()) {
                    this.pJ();
                }
            } else {
                JOptionPane.showMessageDialog(this.ub, "Limite de juniores alcan\u00e7ado", "", 2);
            }
        }
        return true;
    }

    public void pM() {
        if (this.FR.getSelectedRow() >= 0 && this.FL != null) {
            int n2 = -1;
            n2 = JOptionPane.showConfirmDialog(this.ub, "Deseja dispensar o junior " + this.FL.getNome() + "?", "Confirmar", 0);
            if (n2 == 0) {
                this.FL.n(null);
                this.zu.ky().remove(this.FL);
                a.SR.Q().remove(this.FL);
                ((N)this.FR.getModel()).fireTableDataChanged();
                this.FR.addNotify();
                if (this.FR.getRowCount() > 0) {
                    this.FR.addRowSelectionInterval(0, 0);
                } else {
                    this.FL = null;
                }
                this.pK();
            }
        }
    }

    public void pN() {
        if (this.zu.kc().size() >= 35) {
            JOptionPane.showMessageDialog(this.ub, "N\u00e3o h\u00e1 vagas no time profissional", "", 2);
        } else if (this.FR.getSelectedRow() >= 0 && this.FL != null) {
            int n2 = -1;
            n2 = JOptionPane.showConfirmDialog(this.ub, "Deseja promover o junior " + this.FL.getNome() + "?", "Confirmar", 0);
            if (n2 == 0) {
                K.a(false, this.FL, this.zu);
                this.FL.aB(300);
                ((N)this.FR.getModel()).fireTableDataChanged();
                this.FR.addNotify();
                if (this.FR.getRowCount() > 0) {
                    this.FR.addRowSelectionInterval(0, 0);
                } else {
                    this.FL = null;
                }
                Ag = true;
                this.pK();
            }
        }
    }

    public void pO() {
        ((N)this.FR.getModel()).fireTableDataChanged();
        this.FR.addNotify();
    }

    private void pP() {
        if (this.FR.getSelectedRow() >= 0 && this.FL != null) {
            JDialog jDialog = new JDialog(this.ub);
            l l2 = new l(jDialog, this, this.FL);
            jDialog.add(l2);
            jDialog.setSize(373, 300);
            jDialog.setPreferredSize(new Dimension(373, 300));
            jDialog.setModal(true);
            jDialog.setResizable(false);
            jDialog.setLocationRelativeTo(null);
            jDialog.setUndecorated(true);
            jDialog.setVisible(true);
        }
    }

    private void mJ() {
        this.vd = new JPanel();
        this.ug = new JLabel();
        this.vb = new JButton();
        this.uh = new JLabel();
        this.ut = new JScrollPane();
        this.FR = new JTable();
        this.FQ = new JButton();
        this.FP = new JButton();
        this.FN = new JButton();
        this.FO = new JButton();
        this.setBackground(new Color(104, 120, 100));
        this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        this.vd.setBackground(new Color(44, 53, 49));
        this.ug.setFont(new Font("Tahoma", 1, 12));
        this.ug.setForeground(new Color(255, 255, 255));
        this.ug.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon09.png")));
        this.ug.setText("Academia de Juniores");
        this.vb.setText("X");
        this.uh.setForeground(new Color(255, 255, 255));
        this.uh.setHorizontalAlignment(4);
        this.uh.setText("");
        GroupLayout groupLayout = new GroupLayout(this.vd);
        this.vd.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(this.ug, -2, 282, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, Short.MAX_VALUE).addComponent(this.uh, -2, 91, -2).addGap(26, 26, 26).addComponent(this.vb, -2, 49, -2).addContainerGap()));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.ug).addComponent(this.uh)).addComponent(this.vb, -2, 24, -2)).addContainerGap(-1, Short.MAX_VALUE)));
        this.ut.setViewportView(this.FR);
        this.FQ.setText("Promover");
        this.FP.setText("Dispensar");
        this.FN.setText("Propor compra");
        this.FO.setText("Definir apelido");
        GroupLayout groupLayout2 = new GroupLayout(this);
        this.setLayout(groupLayout2);
        groupLayout2.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addContainerGap().addComponent(this.vd, -1, -1, Short.MAX_VALUE).addContainerGap()).addGroup(groupLayout2.createSequentialGroup().addGap(20, 20, 20).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.ut, -2, 722, -2).addGroup(groupLayout2.createSequentialGroup().addComponent(this.FQ, -2, 109, -2).addGap(18, 18, 18).addComponent(this.FP, -2, 109, -2).addGap(100, 100, 100).addComponent(this.FN, -2, 133, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, Short.MAX_VALUE).addComponent(this.FO, -2, 133, -2))).addContainerGap(17, Short.MAX_VALUE)));
        groupLayout2.setVerticalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addContainerGap().addComponent(this.vd, -2, 46, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.ut, -2, 435, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.FQ).addComponent(this.FP).addComponent(this.FN).addComponent(this.FO)).addContainerGap(26, Short.MAX_VALUE)));
    }

    static /* synthetic */ JTable a(ds ds2) {
        return ds2.FR;
    }

    static /* synthetic */ JDialog b(ds ds2) {
        return ds2.ub;
    }

    static /* synthetic */ boolean c(ds ds2) {
        return ds2.pL();
    }

    static /* synthetic */ void d(ds ds2) {
        ds2.pP();
    }
}

