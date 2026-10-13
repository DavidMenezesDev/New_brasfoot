/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.cw;
import a.dG;
import a.do;
import a.fZ;
import a.gq;
import a.hV;
import a.hW;
import a.hX;
import a.hY;
import a.hZ;
import a.ia;
import a.ib;
import a.ic;
import a.id;
import a.ie;
import a.if;
import a.ig;
import a.ih;
import a.ii;
import a.ij;
import a.ik;
import a.jG;
import b.L;
import b.P;
import b.aF;
import b.aJ;
import best.O;
import best.S;
import best.aq;
import best.p;
import c.a;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;

public class hU
extends JPanel {
    private JFrame Br;
    private JButton Mb;
    private JButton Mc;
    private JButton Md;
    private JButton Me;
    private JButton Bw;
    private JButton Mf;
    private JButton Mg;
    private JCheckBox Mh;
    private JCheckBox afz;
    private JCheckBox Mi;
    private JCheckBox Mj;
    private JCheckBox Mk;
    private JComboBox afA;
    private ButtonGroup Ml;
    private ButtonGroup Mm;
    private JLabel ug;
    private JLabel a_;
    private JPanel vd;
    private JPanel we;
    private JPanel wf;
    private JPanel wg;
    private JScrollPane ut;
    private JLabel Mo;
    private JLabel Mp;
    private JLabel Mq;
    private JLabel Mr;
    private JLabel Ms;
    private JLabel afB;
    private JLabel Mt;
    private JLabel vf;
    private JRadioButton Mu;
    private JRadioButton Mv;
    private JRadioButton Mw;
    private JRadioButton Mx;
    private JScrollPane My;
    private JTable Mz;
    private JTable JG;

    public hU(JFrame jFrame) {
        this.Br = jFrame;
        this.mJ();
        if (a.SR.bF.size() > 0) {
            this.sn();
        }
        this.so();
        this.mH();
        this.sm();
        this.mQ();
    }

    private void mQ() {
        this.afA.addItem("2022");
        this.afA.addItem("2023");
        if (aq.am("anoinicio") == 1) {
            this.afA.setSelectedIndex(1);
        } else {
            this.afA.setSelectedIndex(0);
        }
    }

    private void sm() {
        if (!a.vL()) {
            this.Mi.setSelected(false);
            this.Mj.setSelected(false);
            this.Mh.setSelected(false);
            this.Mk.setEnabled(false);
            this.Mk.setSelected(false);
            this.Mi.setEnabled(false);
            this.Mj.setEnabled(false);
            this.Mh.setEnabled(false);
            this.Mk.setEnabled(false);
            this.Mc.setEnabled(false);
            this.Mb.setEnabled(false);
            a.SR.setJogaRegionais(false);
        } else {
            this.ug.setVisible(false);
        }
    }

    public void sn() {
        P p2 = new P();
        this.JG.setModel(p2);
        this.JG.getColumnModel().getColumn(0).setPreferredWidth(25);
        this.JG.getColumnModel().getColumn(1).setPreferredWidth(120);
        this.JG.getColumnModel().getColumn(2).setPreferredWidth(70);
        this.JG.setAutoResizeMode(3);
        this.JG.setRowHeight(20);
        this.JG.setShowGrid(false);
        this.JG.setDefaultRenderer(Boolean.class, new aJ());
        this.JG.setDefaultRenderer(String.class, new aJ());
        this.JG.setDefaultRenderer(Integer.class, new aJ());
        this.JG.setDefaultRenderer(Icon.class, new aJ());
        this.JG.setDefaultRenderer(ImageIcon.class, new aJ());
        this.JG.setAutoCreateRowSorter(false);
        this.JG.setCellSelectionEnabled(false);
        this.JG.setSelectionMode(0);
        this.JG.setRowSelectionAllowed(true);
        this.JG.setSelectionBackground(Color.YELLOW);
        this.JG.setFillsViewportHeight(true);
        if (a.SR.bF.size() > 0) {
            this.JG.setRowSelectionInterval(0, 0);
            int n2 = 0;
            while (n2 < a.SR.bF.size()) {
                if (((O)a.SR.bF.get(n2)).getPais() == 29) {
                    ((O)a.SR.bF.get(n2)).v(true);
                    this.JG.setRowSelectionInterval(n2, n2);
                    break;
                }
                ++n2;
            }
        }
        this.JG.addMouseListener(new hV(this));
    }

    public void so() {
        L l2 = new L();
        this.Mz.setModel(l2);
        this.Mz.getColumnModel().getColumn(0).setPreferredWidth(170);
        this.Mz.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.Mz.setAutoResizeMode(3);
        this.Mz.setRowHeight(20);
        this.Mz.setShowGrid(false);
        this.Mz.setDefaultRenderer(Boolean.class, new aF());
        this.Mz.setDefaultRenderer(String.class, new aF());
        this.Mz.setDefaultRenderer(Integer.class, new aF());
        this.Mz.setDefaultRenderer(Icon.class, new aF());
        this.Mz.setDefaultRenderer(ImageIcon.class, new aF());
        this.Mz.setAutoCreateRowSorter(false);
        this.Mz.setCellSelectionEnabled(false);
        this.Mz.setSelectionMode(0);
        this.Mz.setRowSelectionAllowed(true);
        this.Mz.setSelectionBackground(Color.YELLOW);
        this.Mz.setRowSelectionInterval(0, 0);
    }

    private void oq() {
        this.Bw.setCursor(new Cursor(3));
        if (this.afA.getSelectedIndex() == 1) {
            a.SR.I(2023);
            aq.f("anoinicio", 1);
        } else {
            a.SR.I(2022);
            aq.f("anoinicio", 0);
        }
        a.SR.setJogaEstadual(this.Mi.isSelected());
        a.SR.setJogaIntClubes(this.Mj.isSelected());
        a.SR.setJogaSelecoesAll(this.Mh.isSelected());
        if (a.SR.bj()) {
            p.dg();
            S.aY(1);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione pelo menos uma liga", "", 0);
        }
    }

    public void mH() {
        this.Bw.addActionListener(new id(this));
        this.Mf.addActionListener(new ie(this));
        this.Md.addActionListener(new if(this));
        this.Mb.addActionListener(new ig(this));
        this.Mc.addActionListener(new ih(this));
        this.Me.addActionListener(new ii(this));
        this.Mj.setSelected(a.SR.isJogaIntClubes());
        this.Mj.addActionListener(new ij(this));
        this.Mh.setSelected(a.SR.isJogaSelecoesAll());
        this.Mh.addActionListener(new ik(this));
        this.Mi.setSelected(a.SR.isJogaEstadual());
        this.Mi.addActionListener(new hW(this));
        this.Mk.setSelected(a.SR.isJogaRegionais());
        this.Mk.addActionListener(new hX(this));
        this.Mm.add(this.Mw);
        this.Mm.add(this.Mx);
        this.Ml.add(this.Mv);
        this.Ml.add(this.Mu);
        if (a.SR.isSalarioMensal()) {
            this.Mw.setSelected(true);
            this.Mx.setSelected(false);
        } else {
            this.Mx.setSelected(true);
            this.Mw.setSelected(false);
        }
        this.Mw.addActionListener(new hY(this));
        this.Mx.addActionListener(new hZ(this));
        if (a.SR.isHabilidadeIndividual()) {
            this.Mv.setSelected(true);
            this.Mu.setSelected(false);
        } else {
            this.Mv.setSelected(false);
            this.Mu.setSelected(true);
        }
        this.afz.setSelected(a.SR.isUsarGruposReaisCopa());
        this.afz.addActionListener(new ia(this));
        this.Mv.addActionListener(new ib(this));
        this.Mu.addActionListener(new ic(this));
        this.Mg.addActionListener(new jG(this));
    }

    private void sp() {
        gq gq2 = new gq();
        gq2.pack();
        gq2.setSize(529, 321);
        gq2.setLocationRelativeTo(null);
        gq2.setVisible(true);
        S.db().setVisible(false);
    }

    public void rv() {
        S.a(null);
    }

    public void AS() {
        this.Mc.setCursor(new Cursor(3));
        JDialog jDialog = new JDialog(this.Br);
        do do_ = new do(jDialog);
        jDialog.add(do_);
        jDialog.setSize(400, 316);
        jDialog.setModal(true);
        jDialog.setResizable(false);
        jDialog.setLocationRelativeTo(null);
        jDialog.setUndecorated(true);
        jDialog.pack();
        jDialog.setVisible(true);
        this.Mc.setCursor(new Cursor(12));
    }

    public void sr() {
        JDialog jDialog = new JDialog(this.Br);
        fZ fZ2 = new fZ(jDialog);
        jDialog.add(fZ2);
        jDialog.setSize(346, 257);
        jDialog.setModal(true);
        jDialog.setResizable(false);
        jDialog.setLocationRelativeTo(null);
        jDialog.setUndecorated(true);
        jDialog.pack();
        jDialog.setVisible(true);
    }

    public void ss() {
        if (this.Mz.getSelectedRow() >= 0) {
            this.Mb.setCursor(new Cursor(3));
            int n2 = this.Mz.getSelectedRow();
            int n3 = a.SR.bE[this.Mz.getSelectedRow()];
            JDialog jDialog = new JDialog(this.Br);
            cw cw2 = new cw(n2, n3, jDialog);
            jDialog.add(cw2);
            jDialog.setSize(660, 612);
            jDialog.setModal(true);
            jDialog.setResizable(false);
            jDialog.setPreferredSize(new Dimension(680, 642));
            jDialog.setLocationRelativeTo(null);
            jDialog.pack();
            jDialog.setVisible(true);
            this.Mb.setCursor(new Cursor(12));
        }
    }

    public void st() {
        if (this.JG.getSelectedRow() >= 0) {
            this.Md.setCursor(new Cursor(3));
            int n2 = ((O)a.SR.bF.get(this.JG.getSelectedRow())).getPais();
            int n3 = ((O)a.SR.bF.get(this.JG.getSelectedRow())).iB();
            JDialog jDialog = new JDialog(this.Br);
            dG dG2 = new dG(n2, n3, jDialog);
            jDialog.add(dG2);
            jDialog.setSize(804, 727);
            jDialog.setModal(true);
            jDialog.setResizable(false);
            jDialog.setPreferredSize(new Dimension(804, 727));
            jDialog.setLocationRelativeTo(null);
            jDialog.setUndecorated(true);
            jDialog.pack();
            jDialog.setVisible(true);
            this.Md.setCursor(new Cursor(12));
        }
    }

    private void mJ() {
        this.Mm = new ButtonGroup();
        this.Ml = new ButtonGroup();
        this.vf = new JLabel();
        this.a_ = new JLabel();
        this.vd = new JPanel();
        this.ut = new JScrollPane();
        this.JG = new JTable();
        this.Mf = new JButton();
        this.Mo = new JLabel();
        this.Md = new JButton();
        this.wf = new JPanel();
        this.Mt = new JLabel();
        this.Mh = new JCheckBox();
        this.Mj = new JCheckBox();
        this.Mc = new JButton();
        this.afz = new JCheckBox();
        this.we = new JPanel();
        this.Mp = new JLabel();
        this.Mb = new JButton();
        this.My = new JScrollPane();
        this.Mz = new JTable();
        this.Mk = new JCheckBox();
        this.Me = new JButton();
        this.Mq = new JLabel();
        this.Mi = new JCheckBox();
        this.Mg = new JButton();
        this.Bw = new JButton();
        this.wg = new JPanel();
        this.Mr = new JLabel();
        this.Mw = new JRadioButton();
        this.Mx = new JRadioButton();
        this.Ms = new JLabel();
        this.Mu = new JRadioButton();
        this.Mv = new JRadioButton();
        this.afB = new JLabel();
        this.afA = new JComboBox();
        this.ug = new JLabel();
        this.setBackground(new Color(7, 55, 88));
        this.setAlignmentX(0.0f);
        this.setAlignmentY(0.0f);
        this.setPreferredSize(new Dimension(1024, 728));
        this.vf.setFont(new Font("Tahoma", 1, 18));
        this.vf.setForeground(new Color(255, 255, 255));
        this.vf.setHorizontalAlignment(0);
        this.vf.setText("Configura\u00e7\u00f5es iniciais");
        this.a_.setFont(new Font("Tahoma", 1, 24));
        this.a_.setForeground(new Color(230, 175, 75));
        this.a_.setHorizontalAlignment(0);
        this.a_.setText("Brasfoot");
        this.vd.setBackground(new Color(7, 55, 88));
        this.ut.setViewportView(this.JG);
        this.Mf.setIcon(new ImageIcon(this.getClass().getResource("/aicons/iconsellall.png")));
        this.Mo.setBackground(new Color(7, 28, 39));
        this.Mo.setFont(new Font("Tahoma", 1, 14));
        this.Mo.setForeground(new Color(255, 255, 153));
        this.Mo.setText(" Ligas Nacionais");
        this.Mo.setOpaque(true);
        this.Md.setIcon(new ImageIcon(this.getClass().getResource("/aicons/iconsetup.png")));
        this.Md.setText("configurar");
        GroupLayout groupLayout = new GroupLayout(this.vd);
        this.vd.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup().addContainerGap(43, Short.MAX_VALUE).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(groupLayout.createSequentialGroup().addGap(4, 4, 4).addComponent(this.ut, -2, 302, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.Md).addComponent(this.Mf, -2, 43, -2))).addComponent(this.Mo, -1, -1, Short.MAX_VALUE)).addGap(36, 36, 36)));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup().addComponent(this.Mo, -2, 28, -2).addGap(18, 18, 18).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addComponent(this.Md).addGap(214, 214, 214).addComponent(this.Mf)).addComponent(this.ut, -2, 284, -2)).addContainerGap(22, Short.MAX_VALUE)));
        this.wf.setBackground(new Color(7, 28, 39));
        this.Mt.setFont(new Font("Tahoma", 1, 14));
        this.Mt.setForeground(new Color(255, 255, 153));
        this.Mt.setText("Competi\u00e7\u00f5es internacionais");
        this.Mh.setFont(new Font("Tahoma", 0, 14));
        this.Mh.setForeground(new Color(255, 255, 255));
        this.Mh.setText("Jogar competi\u00e7\u00f5es de sele\u00e7\u00f5es");
        this.Mh.setOpaque(false);
        this.Mj.setFont(new Font("Tahoma", 0, 14));
        this.Mj.setForeground(new Color(255, 255, 255));
        this.Mj.setText("Jogar ta\u00e7as internacionais de clubes");
        this.Mj.setOpaque(false);
        this.Mc.setIcon(new ImageIcon(this.getClass().getResource("/aicons/iconsetup.png")));
        this.Mc.setText("Prefer\u00eancias");
        this.afz.setFont(new Font("Tahoma", 0, 14));
        this.afz.setForeground(new Color(255, 255, 255));
        this.afz.setText("Usar grupos da Copa do Mundo 2022");
        this.afz.setOpaque(false);
        GroupLayout groupLayout2 = new GroupLayout(this.wf);
        this.wf.setLayout(groupLayout2);
        groupLayout2.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addGap(21, 21, 21).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addComponent(this.Mj, -1, -1, Short.MAX_VALUE).addGap(123, 123, 123)).addGroup(groupLayout2.createSequentialGroup().addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.afz).addComponent(this.Mh).addGroup(groupLayout2.createSequentialGroup().addComponent(this.Mt, -2, 295, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.Mc))).addGap(0, 28, Short.MAX_VALUE)))));
        groupLayout2.setVerticalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, groupLayout2.createSequentialGroup().addContainerGap().addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addComponent(this.Mt).addGap(24, 24, 24)).addGroup(GroupLayout.Alignment.TRAILING, groupLayout2.createSequentialGroup().addComponent(this.Mc).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))).addComponent(this.Mj).addGap(18, 18, 18).addComponent(this.Mh, -2, 39, -2).addGap(18, 18, 18).addComponent(this.afz, -2, 39, -2).addContainerGap(-1, Short.MAX_VALUE)));
        this.we.setBackground(new Color(7, 55, 88));
        this.Mp.setBackground(new Color(7, 28, 39));
        this.Mp.setFont(new Font("Tahoma", 1, 14));
        this.Mp.setForeground(new Color(255, 255, 153));
        this.Mp.setText(" Estaduais");
        this.Mp.setOpaque(true);
        this.Mb.setIcon(new ImageIcon(this.getClass().getResource("/aicons/iconsetup.png")));
        this.Mb.setText("configurar");
        this.My.setViewportView(this.Mz);
        this.Mk.setFont(new Font("Tahoma", 0, 14));
        this.Mk.setForeground(new Color(255, 255, 255));
        this.Mk.setText("Jogar regionais");
        this.Mk.setToolTipText("");
        this.Mk.setOpaque(false);
        this.Me.setIcon(new ImageIcon(this.getClass().getResource("/aicons/iconsetup.png")));
        this.Me.setText("configurar");
        this.Mq.setBackground(new Color(7, 28, 39));
        this.Mq.setFont(new Font("Tahoma", 1, 14));
        this.Mq.setForeground(new Color(255, 255, 153));
        this.Mq.setText("Regionais");
        this.Mq.setOpaque(true);
        this.Mi.setFont(new Font("Tahoma", 0, 14));
        this.Mi.setForeground(new Color(255, 255, 255));
        this.Mi.setText("Jogar estaduais");
        this.Mi.setOpaque(false);
        GroupLayout groupLayout3 = new GroupLayout(this.we);
        this.we.setLayout(groupLayout3);
        groupLayout3.setHorizontalGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.Mp, -1, -1, Short.MAX_VALUE).addGroup(groupLayout3.createSequentialGroup().addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, groupLayout3.createSequentialGroup().addComponent(this.My, -2, 264, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, Short.MAX_VALUE).addComponent(this.Mb)).addComponent(this.Mq, -1, -1, Short.MAX_VALUE).addGroup(groupLayout3.createSequentialGroup().addComponent(this.Mi, -2, 254, -2).addGap(0, 0, Short.MAX_VALUE)).addGroup(groupLayout3.createSequentialGroup().addComponent(this.Mk, -2, 254, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, Short.MAX_VALUE).addComponent(this.Me))).addContainerGap()));
        groupLayout3.setVerticalGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout3.createSequentialGroup().addComponent(this.Mp, -2, 31, -2).addGap(18, 18, 18).addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.Mb).addComponent(this.My, -2, 168, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.Mi, -2, 25, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE).addComponent(this.Mq, -2, 26, -2).addGap(18, 18, 18).addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.Mk, -2, 25, -2).addComponent(this.Me))));
        this.Mg.setFont(new Font("Tahoma", 1, 12));
        this.Mg.setText("<< Voltar ao in\u00edcio");
        this.Bw.setFont(new Font("Tahoma", 1, 12));
        this.Bw.setText("Iniciar Jogo >>");
        this.wg.setBackground(new Color(7, 28, 39));
        this.Mr.setFont(new Font("Tahoma", 1, 14));
        this.Mr.setForeground(new Color(255, 255, 153));
        this.Mr.setText("Sistema de sal\u00e1rios");
        this.Mm.add(this.Mw);
        this.Mw.setFont(new Font("Tahoma", 0, 14));
        this.Mw.setForeground(new Color(255, 255, 255));
        this.Mw.setText("Mensal");
        this.Mw.setOpaque(false);
        this.Mm.add(this.Mx);
        this.Mx.setFont(new Font("Tahoma", 0, 14));
        this.Mx.setForeground(new Color(255, 255, 255));
        this.Mx.setText("Semanal");
        this.Mx.setOpaque(false);
        this.Ms.setFont(new Font("Tahoma", 1, 14));
        this.Ms.setForeground(new Color(255, 255, 153));
        this.Ms.setText("Sistema de for\u00e7a dos jogadores");
        this.Ml.add(this.Mu);
        this.Mu.setFont(new Font("Tahoma", 0, 14));
        this.Mu.setForeground(new Color(255, 255, 255));
        this.Mu.setText("Modo cl\u00e1ssico");
        this.Mu.setOpaque(false);
        this.Ml.add(this.Mv);
        this.Mv.setFont(new Font("Tahoma", 0, 14));
        this.Mv.setForeground(new Color(255, 255, 255));
        this.Mv.setText("Individual");
        this.Mv.setOpaque(false);
        this.afB.setFont(new Font("Tahoma", 1, 14));
        this.afB.setForeground(new Color(255, 255, 153));
        this.afB.setText("Temporada de in\u00edcio");
        GroupLayout groupLayout4 = new GroupLayout(this.wg);
        this.wg.setLayout(groupLayout4);
        groupLayout4.setHorizontalGroup(groupLayout4.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout4.createSequentialGroup().addGap(40, 40, 40).addGroup(groupLayout4.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.afB, -2, 254, -2).addComponent(this.Ms, -2, 254, -2).addGroup(groupLayout4.createSequentialGroup().addComponent(this.Mw).addGap(87, 87, 87).addComponent(this.Mx, -2, 117, -2)).addComponent(this.Mr, -2, 254, -2).addGroup(groupLayout4.createSequentialGroup().addComponent(this.Mv, -2, 136, -2).addGap(18, 18, 18).addComponent(this.Mu, -2, 203, -2)).addComponent(this.afA, -2, 119, -2)).addContainerGap(23, Short.MAX_VALUE)));
        groupLayout4.setVerticalGroup(groupLayout4.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout4.createSequentialGroup().addGap(9, 9, 9).addComponent(this.Mr).addGap(18, 18, 18).addGroup(groupLayout4.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.Mx).addComponent(this.Mw)).addGap(18, 18, 18).addComponent(this.Ms).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(groupLayout4.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.Mv).addComponent(this.Mu)).addGap(18, 18, 18).addComponent(this.afB).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.afA, -1, 27, Short.MAX_VALUE).addContainerGap()));
        this.ug.setForeground(new Color(255, 255, 153));
        this.ug.setText("<html>Algumas op\u00e7\u00f5es s\u00f3 est\u00e3o dispon\u00edveis no Brasfoot registrado. Como jogar estaduais, Libertadores, Liga dos Campe\u00f5es, Copa do Mundo, Copa Am\u00e9rica, Eurocopa etc.</html>");
        GroupLayout groupLayout5 = new GroupLayout(this);
        this.setLayout(groupLayout5);
        groupLayout5.setHorizontalGroup(groupLayout5.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout5.createSequentialGroup().addGap(27, 27, 27).addGroup(groupLayout5.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.ug, -2, 0, Short.MAX_VALUE).addComponent(this.vd, -1, -1, Short.MAX_VALUE).addComponent(this.wf, GroupLayout.Alignment.TRAILING, -2, -1, -2)).addGap(18, 18, 18).addGroup(groupLayout5.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(GroupLayout.Alignment.TRAILING, groupLayout5.createSequentialGroup().addGap(21, 21, 21).addComponent(this.Mg, -2, 166, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, Short.MAX_VALUE).addComponent(this.Bw, -2, 166, -2).addGap(15, 15, 15)).addComponent(this.wg, -1, -1, Short.MAX_VALUE).addComponent(this.we, -1, -1, Short.MAX_VALUE)).addContainerGap(59, Short.MAX_VALUE)).addGroup(groupLayout5.createSequentialGroup().addContainerGap().addGroup(groupLayout5.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.a_, -1, 1004, Short.MAX_VALUE).addComponent(this.vf, GroupLayout.Alignment.TRAILING, -1, -1, Short.MAX_VALUE)).addContainerGap()));
        groupLayout5.setVerticalGroup(groupLayout5.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout5.createSequentialGroup().addContainerGap().addComponent(this.a_).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.vf).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(groupLayout5.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.vd, -2, -1, -2).addComponent(this.we, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout5.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.wg, -1, -1, Short.MAX_VALUE).addComponent(this.wf, -1, -1, Short.MAX_VALUE)).addGroup(groupLayout5.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout5.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.ug).addGap(31, 31, 31)).addGroup(GroupLayout.Alignment.TRAILING, groupLayout5.createSequentialGroup().addGap(11, 11, 11).addGroup(groupLayout5.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.Mg, -2, 32, -2).addComponent(this.Bw, -2, 32, -2)).addGap(28, 28, 28)))));
    }

    static /* synthetic */ JTable a(hU hU2) {
        return hU2.JG;
    }

    static /* synthetic */ void b(hU hU2) {
        hU2.oq();
    }

    static /* synthetic */ JCheckBox c(hU hU2) {
        return hU2.Mj;
    }

    static /* synthetic */ JCheckBox d(hU hU2) {
        return hU2.Mh;
    }

    static /* synthetic */ JCheckBox e(hU hU2) {
        return hU2.Mi;
    }

    static /* synthetic */ JCheckBox f(hU hU2) {
        return hU2.Mk;
    }

    static /* synthetic */ JRadioButton g(hU hU2) {
        return hU2.Mw;
    }

    static /* synthetic */ JCheckBox h(hU hU2) {
        return hU2.afz;
    }

    static /* synthetic */ JRadioButton i(hU hU2) {
        return hU2.Mv;
    }

    static /* synthetic */ void j(hU hU2) {
        hU2.sp();
    }
}

