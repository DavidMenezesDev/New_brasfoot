/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.aJ;
import a.cS;
import a.cT;
import a.cU;
import a.cV;
import b.w;
import best.S;
import best.Z;
import best.al;
import best.aq;
import best.at;
import best.i;
import c.a;
import components.aA;
import components.aB;
import f.B;
import f.o;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;

public class cR
extends JPanel {
    private JFrame Br;
    private ArrayList DJ = new ArrayList();
    private ArrayList DK = new ArrayList();
    private ArrayList DL = new ArrayList();
    private Z DM = null;
    private static Timer Dk;
    private JButton DN;
    private JButton DO;
    private JButton DP;
    private JComboBox ue;
    private JScrollPane ut;
    private JScrollPane wi;
    private JScrollPane zf;
    private JLabel DQ;
    private JLabel DR;
    private JLabel BL;
    private JLabel vf;
    private JTable DS;
    private JTable DT;
    private JTable DU;

    public void oR() {
        Dk = new Timer();
        Dk.schedule((TimerTask)new cS(this), 0L);
    }

    public cR(JFrame jFrame) {
        this.Br = jFrame;
        this.mJ();
        this.DN.setVisible(false);
        a.SR.isJogaIntClubes();
        int n2 = 0;
        while (n2 < a.SR.N().size()) {
            this.ue.addItem(((Z)a.SR.N().get(n2)).jp());
            ++n2;
        }
        aJ aJ2 = new aJ();
        aJ2.setPreferredSize(new Dimension(10, 25));
        this.ue.setRenderer(aJ2);
        this.ue.setMaximumRowCount(12);
        this.ue.addActionListener(new cT(this));
        this.mH();
        this.ue.setSelectedIndex(0);
        this.pk();
        if (a.SR.isJogaEstadual() || a.SR.isJogaRegionais()) {
            this.pj();
        }
        if (a.SR.isJogaIntClubes()) {
            this.pi();
        }
        if (a.SR.bD()) {
            this.oR();
        }
        this.mG();
    }

    private void mG() {
        this.setBackground(aq.E(a.vM().getCorTema(), 1));
    }

    private void pi() {
        at[] atArray = a.SR.bB();
        int n2 = 0;
        while (n2 < atArray.length) {
            i i2;
            if (atArray[n2] != null && (i2 = atArray[n2].mo()) != null) {
                String string = atArray[n2].getNome();
                this.a(this.DK, i2, string, -1);
            }
            ++n2;
        }
        this.a(this.DT, this.DK);
    }

    private void pj() {
        int n2;
        int n3;
        this.DL.clear();
        if (a.SR.isJogaRegionais()) {
            n3 = 0;
            while (n3 < a.SR.bV().length) {
                if (a.SR.bV()[n3] != null) {
                    n2 = 100 + n3;
                    String string = aq.pY[n3];
                    this.a(this.DL, a.SR.bV()[n3].mo(), string, n2);
                }
                ++n3;
            }
        }
        if (a.SR.isJogaEstadual()) {
            n3 = 0;
            while (n3 < a.SR.aE().size()) {
                n2 = 0;
                while (n2 < ((best.w)a.SR.aE().get(n3)).eb().size()) {
                    int n4 = ((best.w)a.SR.aE().get(n3)).getEstado();
                    String string = ((o)((best.w)a.SR.aE().get(n3)).eb().get(n2)).is();
                    this.a(this.DL, ((o)((best.w)a.SR.aE().get(n3)).eb().get(n2)).mo(), string, n4);
                    ++n2;
                }
                ++n3;
            }
        }
        this.a(this.DS, this.DL);
    }

    private void pk() {
        this.DJ.clear();
        this.DM = (Z)a.SR.N().get(this.ue.getSelectedIndex());
        int n2 = 0;
        while (n2 < this.DM.eb().size()) {
            this.a(this.DJ, ((B)this.DM.eb().get(n2)).mo(), ((B)this.DM.eb().get(n2)).is(), -1);
            ++n2;
        }
        this.a(this.DJ, this.DM.jq().mo(), this.DM.jq().getNome(), -1);
        this.a(this.DU, this.DJ);
    }

    private void a(ArrayList arrayList, i i2, String string, int n2) {
        try {
            aB aB2;
            if (n2 >= 0 && n2 < 100) {
                aB2 = new aB();
                aB2.setEstado(n2);
                arrayList.add(aB2);
            }
            aB2 = new aB();
            aB2.D(string);
            aB2.ao(true);
            arrayList.add(aB2);
            aB aB3 = new aB();
            aB3.D("C:");
            aB3.dO(1);
            aB3.k(i2.ce());
            if (i2.ci() != null) {
                aB3.Z(i2.ci().dS());
            }
            arrayList.add(aB3);
            aB aB4 = new aB();
            aB4.D("V:");
            aB4.dO(2);
            aB4.k(i2.cf());
            if (i2.cj() != null) {
                aB4.Z(i2.cj().dS());
            }
            arrayList.add(aB4);
            aB aB5 = new aB();
            aB5.D("A:");
            aB5.dO(3);
            aB5.Z(Integer.toString(i2.y()));
            aB5.k(i2.ch());
            aB5.aa(i2.cg());
            arrayList.add(aB5);
            aB aB6 = new aB();
            aB6.D("");
            arrayList.add(aB6);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    private void mH() {
        this.DO.addActionListener(new cU(this));
        this.DP.addActionListener(new cV(this));
    }

    public static void pl() {
        int n2 = -1;
        n2 = JOptionPane.showConfirmDialog(null, "Deseja marcar amistosos?", "Amistosos de in\u00edcio de temporada", 0);
        if (n2 == 0) {
            int n3 = 0;
            while (n3 < a.SR.M().size()) {
                if (((al)a.SR.M().get(n3)).fg() != null) {
                    S.w(((al)a.SR.M().get(n3)).fg());
                }
                ++n3;
            }
            n3 = 0;
            while (n3 < a.SR.M().size()) {
                if (((al)a.SR.M().get(n3)).jo() != null) {
                    S.x(((al)a.SR.M().get(n3)).jo());
                }
                ++n3;
            }
        }
    }

    public static void AC() {
        int n2 = -1;
        n2 = JOptionPane.showConfirmDialog(null, "Deseja criar um torneio Amistoso de in\u00edcio de temporada? ", "Torneio Amistoso", 0);
        if (n2 == 0) {
            S.aY(10);
        } else {
            a.SR.az();
            a.SR.V();
        }
    }

    public void pm() {
        S.a(null, this.DM, 1);
    }

    public void pn() {
        this.DO.setCursor(new Cursor(3));
        if (a.SR.getAutoSalvar() == 3) {
            a.SR.j(true);
        }
        a.SR.V();
    }

    private void a(JTable jTable, ArrayList arrayList) {
        w w2 = new w(arrayList);
        jTable.setModel(w2);
        jTable.setTableHeader(null);
        int[] nArray = new int[]{30, 160, 145};
        int n2 = 0;
        while (n2 < nArray.length) {
            jTable.getColumnModel().getColumn(n2).setPreferredWidth(nArray[n2]);
            ++n2;
        }
        jTable.getColumnModel().getColumn(0).setMaxWidth(25);
        jTable.setAutoResizeMode(3);
        jTable.setRowHeight(20);
        jTable.setShowGrid(false);
        jTable.setDefaultRenderer(aB.class, new aA());
        jTable.setAutoCreateRowSorter(false);
        jTable.setIntercellSpacing(new Dimension(0, 0));
        jTable.setCellSelectionEnabled(false);
        jTable.setSelectionMode(0);
        jTable.setRowSelectionAllowed(true);
        jTable.setSelectionBackground(Color.YELLOW);
        jTable.setFillsViewportHeight(true);
    }

    private void mJ() {
        this.vf = new JLabel();
        this.ut = new JScrollPane();
        this.DU = new JTable();
        this.ue = new JComboBox();
        this.BL = new JLabel();
        this.wi = new JScrollPane();
        this.DT = new JTable();
        this.DR = new JLabel();
        this.zf = new JScrollPane();
        this.DS = new JTable();
        this.DQ = new JLabel();
        this.DP = new JButton();
        this.DN = new JButton();
        this.DO = new JButton();
        this.setBackground(new Color(104, 120, 100));
        this.vf.setFont(new Font("Tahoma", 1, 12));
        this.vf.setForeground(new Color(255, 255, 255));
        this.vf.setText("Fim da temporada");
        this.ut.setViewportView(this.DU);
        this.BL.setForeground(new Color(255, 255, 153));
        this.BL.setText("Nacionais");
        this.wi.setViewportView(this.DT);
        this.DR.setForeground(new Color(255, 255, 153));
        this.DR.setText("Internacionais");
        this.zf.setViewportView(this.DS);
        this.DQ.setForeground(new Color(255, 255, 153));
        this.DQ.setText("Regionais/estaduais");
        this.DP.setIcon(new ImageIcon(this.getClass().getResource("/aicons/bolaouro_s3.png")));
        this.DP.setText("Time do Ano");
        this.DN.setIcon(new ImageIcon(this.getClass().getResource("/aicons/build.png")));
        this.DN.setText("Marcar amistosos");
        this.DO.setIcon(new ImageIcon(this.getClass().getResource("/aicons/ball.png")));
        this.DO.setText("Iniciar novo ano >>");
        GroupLayout groupLayout = new GroupLayout(this);
        this.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(29, 29, 29).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addComponent(this.DP, -2, 132, -2).addGap(266, 266, 266).addComponent(this.DN, -2, 191, -2).addGap(133, 133, 133).addComponent(this.DO, -2, 199, -2)).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(GroupLayout.Alignment.LEADING, groupLayout.createSequentialGroup().addComponent(this.BL).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, Short.MAX_VALUE).addComponent(this.ue, -2, 169, -2)).addComponent(this.vf, GroupLayout.Alignment.LEADING).addComponent(this.ut, GroupLayout.Alignment.LEADING, -2, 315, -2)).addGap(18, 18, 18).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.wi, -2, 315, -2).addComponent(this.DR, -2, 229, -2)).addGap(18, 18, 18).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.DQ, -2, 152, -2).addComponent(this.zf, -2, 307, -2)))).addContainerGap(22, Short.MAX_VALUE)));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(19, 19, 19).addComponent(this.vf).addGap(30, 30, 30).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.ue, -2, -1, -2).addComponent(this.BL).addComponent(this.DR).addComponent(this.DQ)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.ut).addGroup(groupLayout.createSequentialGroup().addComponent(this.zf, -1, 549, Short.MAX_VALUE).addGap(2, 2, 2)).addComponent(this.wi, -1, 551, Short.MAX_VALUE)).addGap(18, 18, 18).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.DP, -2, 35, -2).addComponent(this.DN).addComponent(this.DO, -2, 33, -2)).addGap(24, 24, 24)));
    }

    static /* synthetic */ Timer ph() {
        return Dk;
    }

    static /* synthetic */ void a(cR cR2) {
        cR2.pk();
    }
}

