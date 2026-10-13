/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.cX;
import a.cY;
import a.cZ;
import b.at;
import b.x;
import best.C;
import best.ah;
import best.aq;
import c.a;
import components.j;
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

public class cW
extends JPanel {
    private JDialog ub;
    private ah uk = null;
    private ArrayList DW = new ArrayList();
    private JButton vm;
    private JButton DX;
    private JButton DY;
    private JLabel ug;
    private JLabel uh;
    private JPanel vd;
    private JScrollPane ut;
    private JLabel DZ;
    private JLabel Ea;
    private JLabel Eb;
    private JLabel Ec;
    private JTable Ed;

    public cW(JDialog jDialog, ah ah2) {
        this.uk = ah2;
        this.ub = jDialog;
        this.mJ();
        this.mH();
        this.ug.setIcon(ah2.kU());
        this.pp();
        this.pq();
        this.po();
        this.ug.setText("Finan\u00e7as - " + String.valueOf(a.SR.H() + a.SR.iU()));
        this.mG();
    }

    private void mG() {
        this.setBackground(aq.E(a.vM().getCorTema(), 1));
    }

    private void po() {
        String string = "Total de sal\u00e1rios por m\u00eas: ";
        if (!a.SR.isSalarioMensal()) {
            string = "Total de sal\u00e1rios por semana: ";
        }
        this.Ec.setText(String.valueOf(string) + C.c(this.uk.kK()));
        this.DZ.setText("Dinheiro em caixa: " + C.c(this.uk.kb()));
        this.Ea.setText("Valor j\u00e1 emprestado: " + C.c(this.uk.kL().eN()));
        this.Eb.setText("Juros mensais: " + C.c(this.uk.kL().eQ()));
    }

    private void pp() {
        C c2 = this.uk.kL();
        if (c2 != null) {
            j j2 = new j();
            j2.ar(true);
            j2.D("Receitas");
            j2.as(true);
            this.DW.add(j2);
            j j3 = new j();
            j3.D("Ingressos:");
            j3.g(c2.eE());
            this.DW.add(j3);
            j j4 = new j();
            j4.D("Venda de Jogadores:");
            j4.g(c2.eG());
            this.DW.add(j4);
            j j5 = new j();
            j5.D("Pr\u00eamios:");
            j5.g(c2.eF());
            this.DW.add(j5);
            j j6 = new j();
            j6.D("Patrocinio/S\u00f3cio torcedor:");
            j6.g(c2.eH());
            this.DW.add(j6);
            j j7 = new j();
            j7.D("Multas/outros:");
            j7.g(c2.eR());
            this.DW.add(j7);
            j j8 = new j();
            j8.D("Total de receitas:");
            j8.as(true);
            j8.g(c2.ez());
            this.DW.add(j8);
            j j9 = new j();
            j9.ar(true);
            j9.D("Despesas");
            j9.as(true);
            this.DW.add(j9);
            j j10 = new j();
            j10.D("Compras de jogadores:");
            j10.g(c2.eJ());
            this.DW.add(j10);
            j j11 = new j();
            j11.D("Est\u00e1dio:");
            j11.g(c2.eI());
            this.DW.add(j11);
            j j12 = new j();
            j12.D("Sal\u00e1rios:");
            j12.g(c2.eO());
            this.DW.add(j12);
            j j13 = new j();
            j13.D("Juros de empr\u00e9stimo:");
            j13.g(c2.eK());
            this.DW.add(j13);
            j j14 = new j();
            j14.D("Multa de rescis\u00e3o:");
            j14.g(c2.eM());
            this.DW.add(j14);
            j j15 = new j();
            j15.D("Diversos:");
            j15.g(c2.eL());
            this.DW.add(j15);
            j j16 = new j();
            j16.D("Total de despesas:");
            j16.as(true);
            j16.g(c2.eB());
            this.DW.add(j16);
            j j17 = new j();
            j17.D("Saldo:");
            j17.as(true);
            j17.g(c2.eC());
            this.DW.add(j17);
        }
    }

    private void mH() {
        this.vm.addActionListener(new cX(this));
        this.DY.addActionListener(new cY(this));
        this.DX.addActionListener(new cZ(this));
    }

    private void df(int n2) {
        if (n2 == 1) {
            if (!this.uk.kL().m(this.uk)) {
                this.uh.setText("Empr\u00e9stimo banc\u00e1rio - limite m\u00e1ximo alcan\u00e7ado");
            }
        } else if (n2 == -1) {
            this.uk.kL().l(this.uk);
        }
        this.po();
    }

    private void pq() {
        x x2 = new x(this.DW);
        this.Ed.setModel(x2);
        this.Ed.setTableHeader(null);
        int[] nArray = new int[]{100, 100};
        int n2 = 0;
        while (n2 < nArray.length) {
            this.Ed.getColumnModel().getColumn(n2).setPreferredWidth(nArray[n2]);
            ++n2;
        }
        this.Ed.setAutoResizeMode(3);
        this.Ed.setRowHeight(20);
        this.Ed.setShowGrid(false);
        this.Ed.setDefaultRenderer(j.class, new at());
        this.Ed.setAutoCreateRowSorter(false);
        this.Ed.setIntercellSpacing(new Dimension(0, 0));
        this.Ed.setCellSelectionEnabled(false);
        this.Ed.setSelectionMode(0);
        this.Ed.setRowSelectionAllowed(false);
        this.Ed.setSelectionBackground(Color.YELLOW);
        this.Ed.setFillsViewportHeight(true);
    }

    private void mJ() {
        this.ug = new JLabel();
        this.vm = new JButton();
        this.ut = new JScrollPane();
        this.Ed = new JTable();
        this.vd = new JPanel();
        this.uh = new JLabel();
        this.Ea = new JLabel();
        this.Eb = new JLabel();
        this.DY = new JButton();
        this.DX = new JButton();
        this.Ec = new JLabel();
        this.DZ = new JLabel();
        this.setBackground(new Color(44, 53, 49));
        this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.ug.setFont(new Font("Tahoma", 1, 12));
        this.ug.setForeground(new Color(255, 255, 255));
        this.ug.setText("Finan\u00e7as");
        this.vm.setText("X");
        this.ut.setViewportView(this.Ed);
        this.vd.setBackground(new Color(104, 120, 100));
        this.uh.setFont(new Font("Tahoma", 1, 12));
        this.uh.setForeground(new Color(255, 255, 255));
        this.uh.setText("Empr\u00e9stimo banc\u00e1rio");
        this.Ea.setForeground(new Color(255, 255, 255));
        this.Ea.setText("Valor j\u00e1 emprestado:");
        this.Eb.setForeground(new Color(255, 255, 255));
        this.Eb.setText("Juros mensais:");
        this.DY.setText("Pegar 500 mil");
        this.DX.setText("Pagar 500 mil");
        GroupLayout groupLayout = new GroupLayout(this.vd);
        this.vd.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(25, 25, 25).addComponent(this.DY, -2, 145, -2).addGap(18, 18, 18).addComponent(this.DX, -2, 145, -2).addGap(0, 0, Short.MAX_VALUE)).addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(this.uh, -1, -1, Short.MAX_VALUE)).addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(this.Ea, -1, -1, Short.MAX_VALUE)).addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(this.Eb, -1, -1, Short.MAX_VALUE))).addGap(25, 25, 25)));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup().addContainerGap(14, Short.MAX_VALUE).addComponent(this.uh).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.Ea).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.Eb).addGap(18, 18, 18).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.DY).addComponent(this.DX)).addGap(18, 18, 18)));
        this.Ec.setForeground(new Color(255, 255, 255));
        this.Ec.setText("Sal\u00e1ro mensal:");
        this.DZ.setForeground(new Color(255, 255, 255));
        this.DZ.setText("Dinheiro em caixa:");
        GroupLayout groupLayout2 = new GroupLayout(this);
        this.setLayout(groupLayout2);
        groupLayout2.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, groupLayout2.createSequentialGroup().addGap(20, 20, 20).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.DZ, -1, -1, Short.MAX_VALUE).addComponent(this.Ec, GroupLayout.Alignment.LEADING, -1, -1, Short.MAX_VALUE).addComponent(this.vd, -1, -1, Short.MAX_VALUE).addGroup(groupLayout2.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(this.ut, -2, 354, -2)).addGroup(groupLayout2.createSequentialGroup().addComponent(this.ug, -1, -1, Short.MAX_VALUE).addGap(18, 18, 18).addComponent(this.vm, -2, 49, -2))).addGap(24, 24, 24)));
        groupLayout2.setVerticalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addContainerGap().addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.ug).addComponent(this.vm)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.ut, -2, 347, -2).addGap(18, 18, 18).addComponent(this.Ec).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.DZ).addGap(18, 18, 18).addComponent(this.vd, -2, -1, -2).addContainerGap(18, Short.MAX_VALUE)));
    }

    static /* synthetic */ JDialog a(cW cW2) {
        return cW2.ub;
    }

    static /* synthetic */ void a(cW cW2, int n2) {
        cW2.df(n2);
    }
}

