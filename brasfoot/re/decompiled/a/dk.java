/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.dl;
import b.T;
import b.aN;
import b.ae;
import best.F;
import best.J;
import best.aq;
import best.k;
import c.a;
import components.x;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;

public class dk
extends JPanel {
    private JDialog ub;
    private ArrayList Fj = new ArrayList();
    private ArrayList Fk = new ArrayList();
    private F CY;
    private JButton vb;
    private JLabel ug;
    private JLabel uh;
    private JLabel a_;
    private JPanel vd;
    private JScrollPane wi;
    private JScrollPane zf;
    private JTable Fl;
    private JTable vN;

    public dk(JDialog jDialog, F f2) {
        this.ub = jDialog;
        this.CY = f2;
        this.mJ();
        this.pq();
        this.pH();
        this.pI();
        this.mH();
        this.mG();
    }

    private void mG() {
        this.setBackground(aq.E(a.vM().getCorTema(), 1));
    }

    public void mH() {
        this.vb.addActionListener(new dl(this));
    }

    private void pq() {
        b.k k2 = new b.k(this.Fj);
        this.Fl.setModel(k2);
        int[] nArray = new int[]{30, 120, 25, 25, 20, 20, 20, 20, 30};
        int n2 = 0;
        while (n2 < nArray.length) {
            this.Fl.getColumnModel().getColumn(n2).setPreferredWidth(nArray[n2]);
            ++n2;
        }
        this.Fl.setAutoResizeMode(3);
        this.Fl.setRowHeight(20);
        this.Fl.setShowGrid(false);
        this.Fl.setDefaultRenderer(k.class, new ae());
        this.Fl.setAutoCreateRowSorter(false);
        this.Fl.getTableHeader().setReorderingAllowed(false);
        this.Fl.setIntercellSpacing(new Dimension(0, 0));
        this.Fl.setCellSelectionEnabled(false);
        this.Fl.setSelectionMode(0);
        this.Fl.setRowSelectionAllowed(true);
        this.Fl.setSelectionBackground(Color.YELLOW);
        this.Fl.setFillsViewportHeight(true);
    }

    private void pH() {
        T t2 = new T(this.Fk);
        this.vN.setModel(t2);
        int[] nArray = new int[]{60, 100, 25, 100, 30};
        int n2 = 0;
        while (n2 < nArray.length) {
            this.vN.getColumnModel().getColumn(n2).setPreferredWidth(nArray[n2]);
            ++n2;
        }
        this.vN.setAutoResizeMode(3);
        this.vN.setRowHeight(20);
        this.vN.setShowGrid(false);
        this.vN.setDefaultRenderer(x.class, new aN());
        this.vN.setAutoCreateRowSorter(false);
        this.vN.getTableHeader().setReorderingAllowed(false);
        this.vN.setIntercellSpacing(new Dimension(0, 0));
        this.vN.setCellSelectionEnabled(false);
        this.vN.setSelectionMode(0);
        this.vN.setRowSelectionAllowed(true);
        this.vN.setSelectionBackground(Color.YELLOW);
        this.vN.setFillsViewportHeight(true);
    }

    public void pI() {
        int[] nArray = new int[6];
        if (this.CY != null) {
            this.ug.setText(String.valueOf(this.CY.getNome()) + " (" + aq.rI[this.CY.getPosicao()] + ")");
            ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/aflags/" + this.CY.getPais() + ".png"));
            this.ug.setIcon(imageIcon);
            this.Fj.clear();
            int n2 = this.CY.gr().size() - 1;
            while (n2 >= 0) {
                this.Fj.add((k)this.CY.gr().get(n2));
                --n2;
            }
            n2 = this.CY.gr().size() - 1;
            while (n2 >= 0) {
                nArray[0] = nArray[0] + ((k)this.CY.gr().get(n2)).w();
                nArray[1] = nArray[1] + ((k)this.CY.gr().get(n2)).y();
                nArray[2] = nArray[2] + ((k)this.CY.gr().get(n2)).cv();
                nArray[3] = nArray[3] + ((k)this.CY.gr().get(n2)).cw();
                nArray[4] = nArray[4] + ((k)this.CY.gr().get(n2)).cx();
                nArray[5] = nArray[5] + ((k)this.CY.gr().get(n2)).cD();
                --n2;
            }
            k k2 = new k(true, nArray);
            this.Fj.add(k2);
            k2.e(this.CY.gx());
            if (this.CY.fL() > 0 && this.CY.fg() != null) {
                k k3 = new k();
                k3.D(this.CY.fL());
                this.Fj.add(k3);
            }
            this.Fk.clear();
            if (this.CY.gv() != null) {
                int n3 = this.CY.gv().size() - 1;
                while (n3 >= 0) {
                    this.Fk.add(new x((J)this.CY.gv().get(n3)));
                    --n3;
                }
            }
            this.vN.addNotify();
        }
    }

    private void mJ() {
        this.vd = new JPanel();
        this.ug = new JLabel();
        this.vb = new JButton();
        this.wi = new JScrollPane();
        this.Fl = new JTable();
        this.zf = new JScrollPane();
        this.vN = new JTable();
        this.uh = new JLabel();
        this.a_ = new JLabel();
        this.setBackground(new Color(104, 120, 100));
        this.vd.setBackground(new Color(44, 53, 49));
        this.ug.setBackground(new Color(44, 53, 49));
        this.ug.setFont(new Font("Tahoma", 1, 14));
        this.ug.setForeground(new Color(255, 255, 255));
        this.ug.setHorizontalAlignment(0);
        this.ug.setText("Jogador Nome");
        this.ug.setOpaque(true);
        this.vb.setText("X");
        GroupLayout groupLayout = new GroupLayout(this.vd);
        this.vd.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup().addContainerGap(73, Short.MAX_VALUE).addComponent(this.ug, -2, 612, -2).addGap(18, 18, 18).addComponent(this.vb, -2, 53, -2).addContainerGap()));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup().addContainerGap(-1, Short.MAX_VALUE).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.ug, -2, 23, -2).addComponent(this.vb)).addGap(17, 17, 17)));
        this.wi.setBackground(new Color(255, 255, 255));
        this.wi.setViewportView(this.Fl);
        this.zf.setBackground(new Color(255, 255, 255));
        this.zf.setViewportView(this.vN);
        this.uh.setBackground(new Color(44, 53, 49));
        this.uh.setFont(new Font("Tahoma", 1, 14));
        this.uh.setForeground(new Color(255, 255, 255));
        this.uh.setHorizontalAlignment(0);
        this.uh.setText("Jogos na Temporada");
        this.uh.setOpaque(true);
        this.a_.setBackground(new Color(44, 53, 49));
        this.a_.setFont(new Font("Tahoma", 1, 14));
        this.a_.setForeground(new Color(255, 255, 255));
        this.a_.setHorizontalAlignment(0);
        this.a_.setText("Hist\u00f3rico Carreira");
        this.a_.setOpaque(true);
        GroupLayout groupLayout2 = new GroupLayout(this);
        this.setLayout(groupLayout2);
        groupLayout2.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, groupLayout2.createSequentialGroup().addContainerGap().addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.vd, -1, -1, Short.MAX_VALUE).addGroup(groupLayout2.createSequentialGroup().addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.wi, -2, 0, Short.MAX_VALUE).addComponent(this.a_, -1, -1, Short.MAX_VALUE)).addGap(18, 18, 18).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.zf, -1, 368, Short.MAX_VALUE).addComponent(this.uh, -1, -1, Short.MAX_VALUE)))).addContainerGap()));
        groupLayout2.setVerticalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addContainerGap().addComponent(this.vd, -2, 41, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.uh, -2, 23, -2).addComponent(this.a_, -2, 23, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.zf).addComponent(this.wi, -1, 497, Short.MAX_VALUE)).addContainerGap()));
    }

    static /* synthetic */ JDialog a(dk dk2) {
        return dk2.ub;
    }
}

