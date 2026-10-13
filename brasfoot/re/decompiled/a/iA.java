/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.L;
import a.cz;
import a.ds;
import a.gX;
import a.hC;
import a.hw;
import a.iB;
import a.iC;
import a.iD;
import a.iE;
import a.iF;
import a.iG;
import a.iH;
import a.iI;
import a.iJ;
import a.iK;
import a.iL;
import a.iM;
import a.iN;
import a.iO;
import a.iP;
import b.U;
import b.aO;
import b.ae;
import best.C;
import best.F;
import best.S;
import best.Z;
import best.ac;
import best.ah;
import best.aq;
import best.k;
import best.l;
import c.a;
import f.B;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public class iA
extends JPanel {
    private JDialog ub;
    private ah uk = null;
    private ah ul = null;
    private F yK = null;
    private ArrayList um = new ArrayList();
    private ArrayList uK = new ArrayList();
    private ArrayList Fj = new ArrayList();
    private boolean yp = false;
    public static Comparator KZ = new iB();
    private JButton HR;
    private JButton FN;
    private JButton MJ;
    private JButton vm;
    private JButton HW;
    private JButton HY;
    private JButton Ic;
    private JButton Ie;
    private JButton MK;
    private JLabel a_;
    private JLabel ur;
    private JPanel we;
    private JPanel wf;
    private JPanel wg;
    private JPanel wh;
    private JProgressBar Hf;
    private JProgressBar Ig;
    private JScrollPane ut;
    private JScrollPane wi;
    private JScrollPane zf;
    private JScrollPane zg;
    private JTabbedPane ML;
    private JToolBar ve;
    private JLabel Fq;
    private JLabel MM;
    private JLabel MN;
    private JLabel MO;
    private JLabel MP;
    private JLabel MQ;
    private JLabel MR;
    private JLabel MS;
    private JLabel uu;
    private JLabel MT;
    private JTable zj;
    private JTable MU;
    private JTree uw;

    public iA(JDialog jDialog, ah ah2, ah ah3, boolean bl2) {
        this.ub = jDialog;
        this.uk = ah2;
        this.ul = ah3;
        this.yp = bl2;
        this.mJ();
        this.qz();
        this.nE();
        this.mK();
        this.mH();
        this.mM();
        this.zf.setBorder(BorderFactory.createEmptyBorder());
        this.zg.setBorder(BorderFactory.createEmptyBorder());
        this.ML.setBorder(BorderFactory.createEmptyBorder());
        this.MP.setIcon(new ImageIcon(this.getClass().getResource("/aicons/iconmoneys.png")));
        if (this.zj.getRowCount() > 0) {
            this.zj.setRowSelectionInterval(0, 0);
            this.yK = (F)this.uK.get(0);
            this.sG();
            this.sF();
        }
        this.mY();
        if (bl2) {
            this.MP.setVisible(false);
        }
        this.mG();
    }

    private void mG() {
        this.setBackground(aq.E(a.vM().getCorTema(), 1));
        this.wf.setBackground(aq.E(a.vM().getCorTema(), 2));
        this.wh.setBackground(aq.E(a.vM().getCorTema(), 2));
        this.ve.setBackground(aq.E(a.vM().getCorTema(), 2));
    }

    private void mY() {
        this.a(this);
        this.a(this.zj);
        this.a(this.uw);
        this.a(this.ML);
        this.a(this.MJ);
        this.a(this.FN);
        this.a(this.MK);
    }

    private void a(JComponent jComponent) {
        InputMap inputMap = jComponent.getInputMap(1);
        jComponent.getInputMap().put(KeyStroke.getKeyStroke(27, 0), "esc");
        jComponent.getActionMap().put("esc", new iI(this));
    }

    private void pq() {
        b.k k2 = new b.k(this.Fj);
        this.MU.setModel(k2);
        int[] nArray = new int[]{40, 80, 30, 20, 20, 20, 20, 20};
        int n2 = 0;
        while (n2 < nArray.length) {
            this.MU.getColumnModel().getColumn(n2).setPreferredWidth(nArray[n2]);
            ++n2;
        }
        this.MU.setAutoResizeMode(3);
        this.MU.setRowHeight(20);
        this.MU.setShowGrid(false);
        this.MU.setDefaultRenderer(k.class, new ae());
        this.MU.setAutoCreateRowSorter(false);
        this.MU.getTableHeader().setReorderingAllowed(false);
        this.MU.setIntercellSpacing(new Dimension(0, 0));
        this.MU.setCellSelectionEnabled(false);
        this.MU.setSelectionMode(0);
        this.MU.setRowSelectionAllowed(true);
        this.MU.setSelectionBackground(Color.YELLOW);
        this.MU.setFillsViewportHeight(true);
    }

    private void qz() {
        this.HR.setToolTipText("Calend\u00e1rio");
        this.HW.setToolTipText("Academia de Juniores");
        this.Ie.setToolTipText("Galeria de trof\u00e9us");
        this.HY.setToolTipText("Retrospecto do time");
        this.Ic.setToolTipText("Transfer\u00eancias");
    }

    public void mH() {
        this.vm.addActionListener(new iJ(this));
        this.HR.addActionListener(new iK(this));
        this.HW.addActionListener(new iL(this));
        this.Ic.addActionListener(new iM(this));
        this.Ie.addActionListener(new iN(this));
        this.HY.addActionListener(new iO(this));
        this.MS.addMouseListener(new iP(this));
        this.MJ.addActionListener(new iC(this));
        this.FN.addActionListener(new iD(this));
        this.MK.addActionListener(new iE(this));
    }

    private void sz() {
        l.l(false);
        int n2 = 0;
        n2 = l.a(this.yK, this.ul);
        String[] stringArray = new String[]{"N\u00e3o foi poss\u00edvel emprestar", "Empr\u00e9stimo realizado", "Jogador do seu time", "Seu time j\u00e1 pegou o limite de quatro emprestados", "N\u00e3o deseja jogar no seu time", "N\u00e3o est\u00e1 dispon\u00edvel para empr\u00e9stimo", "Limite de 30 jogadores alcan\u00e7ado"};
        if (n2 == 1) {
            this.sH();
            this.zj.addNotify();
        }
        JOptionPane.showMessageDialog(this.ub, stringArray[n2], "Empr\u00e9stimo", 2);
    }

    private void oM() {
        l.l(false);
        int n2 = 0;
        n2 = l.b(this.yK, this.ul);
        String[] stringArray = new String[]{"N\u00e3o est\u00e1 \u00e0 venda", "Compra realizada", "Jogador do seu time", "Limite de 30 jogadores alcan\u00e7ado", "N\u00e3o deseja se transferir para o seu time", "Sem dinheiro para comprar este jogador"};
        if (n2 == 1) {
            this.sH();
            this.zj.addNotify();
        }
        JOptionPane.showMessageDialog(this.ub, stringArray[n2], "Compra", 2);
    }

    private void sA() {
        if (!a.vL()) {
            JOptionPane.showMessageDialog(this.ub, "Apenas na vers\u00e3o registrada \u00e9 poss\u00edvel fazer oferta em qualquer jogador.", "Oferta", 2);
        } else if (l.d(this.sE(), this.ul)) {
            if (this.sE().fg() == this.ul) {
                JOptionPane.showMessageDialog(this.ub, "Jogador do time", "Proposta", 2);
            } else if (this.ul.kc().size() >= 35) {
                JOptionPane.showMessageDialog(this.ub, "Limite de 32 jogadores alcan\u00e7ado", "Limite de jogadores", 2);
            } else if (this.sE() != null) {
                l.l(false);
                JDialog jDialog = new JDialog(this.ub);
                cz cz2 = new cz(jDialog, this.sE(), this.ul, false);
                jDialog.add(cz2);
                jDialog.setSize(373, 300);
                jDialog.setPreferredSize(new Dimension(373, 300));
                jDialog.setModal(true);
                jDialog.setResizable(false);
                jDialog.setLocationRelativeTo(null);
                jDialog.setUndecorated(true);
                jDialog.setVisible(true);
                if (l.cO()) {
                    this.sH();
                    this.zj.addNotify();
                }
            }
        } else {
            JOptionPane.showMessageDialog(this.ub, "O jogador n\u00e3o deseja jogar no seu time.", "Jogador recusou", 2);
        }
    }

    private void rw() {
        this.Ie.setCursor(new Cursor(3));
        S.v(this.uk);
        this.Ie.setCursor(new Cursor(12));
    }

    private void qP() {
        this.HY.setCursor(new Cursor(3));
        JDialog jDialog = new JDialog(this.ub);
        hw hw2 = new hw(jDialog, this.uk);
        jDialog.add(hw2);
        jDialog.setSize(740, 684);
        jDialog.setPreferredSize(new Dimension(740, 684));
        jDialog.setModal(true);
        jDialog.setResizable(false);
        jDialog.setLocationRelativeTo(null);
        jDialog.setUndecorated(true);
        jDialog.setVisible(true);
        this.HY.setCursor(new Cursor(12));
    }

    private void sB() {
        JDialog jDialog = new JDialog(this.ub);
        gX gX2 = new gX(jDialog, this.uk.ka());
        jDialog.add(gX2);
        jDialog.setSize(880, 663);
        jDialog.setPreferredSize(new Dimension(880, 663));
        jDialog.setModal(true);
        jDialog.setResizable(false);
        jDialog.setLocationRelativeTo(null);
        jDialog.setUndecorated(true);
        jDialog.setVisible(true);
    }

    private void sC() {
        this.Ic.setCursor(new Cursor(3));
        JDialog jDialog = new JDialog(this.ub);
        hC hC2 = new hC(jDialog, this.uk, 0);
        jDialog.add(hC2);
        jDialog.setSize(695, 500);
        jDialog.setPreferredSize(new Dimension(695, 500));
        jDialog.setModal(true);
        jDialog.setResizable(false);
        jDialog.setLocationRelativeTo(null);
        jDialog.setUndecorated(true);
        jDialog.setVisible(true);
        this.Ic.setCursor(new Cursor(12));
    }

    public void qY() {
        this.HW.setCursor(new Cursor(3));
        JDialog jDialog = new JDialog(this.ub);
        ds ds2 = new ds(jDialog, this.ul, this.uk);
        jDialog.add(ds2);
        jDialog.setSize(763, 568);
        jDialog.setPreferredSize(new Dimension(763, 568));
        jDialog.setModal(true);
        jDialog.setResizable(false);
        jDialog.setLocationRelativeTo(null);
        jDialog.setUndecorated(true);
        jDialog.setVisible(true);
        this.HW.setCursor(new Cursor(12));
    }

    private void sD() {
        this.HR.setCursor(new Cursor(3));
        JDialog jDialog = new JDialog(this.ub);
        L l2 = new L(jDialog, this.uk);
        jDialog.add(l2);
        jDialog.setSize(820, 600);
        jDialog.setPreferredSize(new Dimension(820, 600));
        jDialog.setModal(true);
        jDialog.setResizable(false);
        jDialog.setLocationRelativeTo(null);
        jDialog.setUndecorated(true);
        jDialog.setVisible(true);
        this.HR.setCursor(new Cursor(12));
    }

    private void mM() {
        this.uw.getSelectionModel().setSelectionMode(1);
        this.uw.addTreeSelectionListener(new iF(this));
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
        this.uw.setRootVisible(false);
        DefaultMutableTreeNode defaultMutableTreeNode2 = defaultMutableTreeNode.getNextNode();
        do {
            if (defaultMutableTreeNode2.getLevel() != 1) continue;
            this.uw.expandPath(new TreePath(defaultMutableTreeNode2.getPath()));
        } while ((defaultMutableTreeNode2 = defaultMutableTreeNode2.getNextNode()) != null);
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
                    String string = ((B)((Z)a.SR.N().get(n2)).eb().get(n3)).getNome();
                    if (string.length() > 39) {
                        string = String.valueOf(string.substring(0, 39)) + "...";
                    }
                    defaultMutableTreeNode3 = new DefaultMutableTreeNode(string);
                    defaultMutableTreeNode2.add(defaultMutableTreeNode3);
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(((B)((Z)a.SR.N().get(n2)).eb().get(n3)).yi().yK());
                    Collections.sort(arrayList, h.a.VS);
                    int n4 = 0;
                    while (n4 < arrayList.size()) {
                        defaultMutableTreeNode4 = new DefaultMutableTreeNode(arrayList.get(n4));
                        defaultMutableTreeNode3.add(defaultMutableTreeNode4);
                        ++n4;
                    }
                }
                ++n3;
            }
            if (((Z)a.SR.N().get(n2)).ek().size() > 0) {
                defaultMutableTreeNode3 = new DefaultMutableTreeNode("Regionais");
                defaultMutableTreeNode2.add(defaultMutableTreeNode3);
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(((Z)a.SR.N().get(n2)).ek());
                Collections.sort(arrayList, h.a.VS);
                int n5 = 0;
                while (n5 < arrayList.size()) {
                    defaultMutableTreeNode4 = new DefaultMutableTreeNode(arrayList.get(n5));
                    defaultMutableTreeNode3.add(defaultMutableTreeNode4);
                    ++n5;
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

    public F sE() {
        if (this.yK == null && this.uK.size() > 0) {
            this.yK = (F)this.uK.get(0);
        }
        return this.yK;
    }

    private void sF() {
        Object object;
        int[] nArray = new int[6];
        if (this.yK != null) {
            this.MO.setText(String.valueOf(this.yK.getNome()) + " - " + aq.rI[this.yK.getPosicao()]);
            ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/aflags/" + this.yK.getPais() + ".png"));
            this.MO.setIcon(imageIcon);
            nArray = this.yK.gw();
            String string = "";
            if (this.yK.fP() && this.yK.fo() > ((best.a)a.SR.R().get(a.SR.J())).a().getTime().getTime()) {
                string = "Fim contus\u00e3o: " + best.a.a(this.yK.fo());
            }
            object = "<html>\n<body><p style=\\\"padding:5; font-size:12\\\">\n<b>For\u00e7a:</b>&nbsp;" + Integer.toString(this.yK.fi()) + "&nbsp;&nbsp;&nbsp;";
            if (a.SR.isHabilidadeIndividual()) {
                object = "<html>\n<body><p style=\\\"padding:5; font-size:12\\\">\n&nbsp;&nbsp;&nbsp;&nbsp;";
            }
            String string2 = String.valueOf(object) + "<b>Idade:</b>" + Integer.toString(this.yK.getIdade()) + "<br>\n</p>\n<p style=\\\"padding:5; font-size:12\\\">\n" + "<b>Jogos:" + "</b>&nbsp;" + Integer.toString(nArray[0]) + "&nbsp;&nbsp;&nbsp;" + "<b>Gols:" + "</b>" + Integer.toString(nArray[1]) + "&nbsp;&nbsp;&nbsp;" + "<b>" + "</b><br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n<b>Passe:" + "</b>&nbsp;" + C.c(this.yK.fk()) + "<br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n<b>" + "Sal\u00e1rio:" + "</b>&nbsp;" + C.c(this.yK.fj()) + "<br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n" + "<b>" + aq.qM[this.yK.getCr1()] + "/" + aq.qM[this.yK.getCr2()] + "<br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n" + "<b></b>&nbsp; <br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n" + "<b>" + string + "<b><br>\n</p>\n</body></html>\n";
            this.MN.setText(string2);
        }
        if (this.yK != null) {
            this.Fj.clear();
            int n2 = 0;
            int n3 = this.yK.gr().size() - 1;
            while (n3 >= 0) {
                this.Fj.add((k)this.yK.gr().get(n3));
                if (++n2 >= 10) break;
                --n3;
            }
            k k2 = new k(true, nArray);
            this.Fj.add(k2);
            if (this.yK.fL() > 0) {
                object = new k();
                ((k)object).D(this.yK.fL());
                this.Fj.add(object);
            }
            this.pq();
        }
    }

    public void s(F f2) {
        this.yK = f2;
        this.sG();
        this.sF();
    }

    private void nE() {
        U u2 = new U(this.uK, this);
        this.zj.setModel(u2);
        int[] nArray = new int[]{20, 20, 45, 120, 20, 20, 50, 50, 45, 35, 25, 25, 20, 20};
        int[] nArray2 = new int[]{20, 20, 20, 110, 20, 25, 25, 25, 25, 25, 25, 25, 50, 50, 60, 45, 25, 22, 20, 20};
        if (a.SR.isHabilidadeIndividual()) {
            nArray = nArray2;
        }
        int n2 = 0;
        while (n2 < nArray.length) {
            this.zj.getColumnModel().getColumn(n2).setPreferredWidth(nArray[n2]);
            ++n2;
        }
        this.zj.setAutoResizeMode(3);
        this.zj.setRowHeight(20);
        this.zj.setShowGrid(false);
        this.zj.setDefaultRenderer(F.class, new aO());
        this.zj.setAutoCreateRowSorter(false);
        this.zj.getTableHeader().setReorderingAllowed(false);
        this.zj.setIntercellSpacing(new Dimension(0, 0));
        this.zj.setCellSelectionEnabled(false);
        this.zj.setSelectionMode(0);
        this.zj.setRowSelectionAllowed(true);
        this.zj.setSelectionBackground(Color.YELLOW);
        this.zj.setFillsViewportHeight(true);
        TableRowSorter<TableModel> tableRowSorter = new TableRowSorter<TableModel>(this.zj.getModel());
        this.zj.setRowSorter(tableRowSorter);
        tableRowSorter.setComparator(0, h.a.abe);
        tableRowSorter.setComparator(2, h.a.cL);
        tableRowSorter.setComparator(3, h.a.abk);
        tableRowSorter.setComparator(4, h.a.aba);
        if (!a.SR.isHabilidadeIndividual()) {
            tableRowSorter.setComparator(5, h.a.aaJ);
            tableRowSorter.setComparator(6, h.a.aaZ);
            tableRowSorter.setComparator(7, h.a.aaW);
            tableRowSorter.setComparator(9, h.a.abd);
            tableRowSorter.setComparator(10, h.a.abc);
            tableRowSorter.setComparator(11, h.a.VU);
        } else {
            tableRowSorter.setComparator(5, h.a.aaK);
            tableRowSorter.setComparator(6, h.a.aaM);
            tableRowSorter.setComparator(7, h.a.aaL);
            tableRowSorter.setComparator(8, h.a.aaN);
            tableRowSorter.setComparator(9, h.a.aaP);
            tableRowSorter.setComparator(10, h.a.aaO);
            tableRowSorter.setComparator(11, h.a.aaQ);
            tableRowSorter.setComparator(12, h.a.aaZ);
            tableRowSorter.setComparator(13, h.a.aaW);
            tableRowSorter.setComparator(15, h.a.abd);
            tableRowSorter.setComparator(16, h.a.abc);
            tableRowSorter.setComparator(17, h.a.VU);
        }
        this.zj.getSelectionModel().addListSelectionListener(new iG(this));
        this.zj.addMouseListener(new iH(this));
        if (this.zj.getRowCount() > 0) {
            this.zj.setRowSelectionInterval(0, 0);
        }
    }

    private void sG() {
        if (this.uk == this.ul || this.yp || this.yK.gl().booleanValue()) {
            this.MJ.setEnabled(false);
            this.FN.setEnabled(false);
            this.MK.setEnabled(false);
        } else if (this.yK != null) {
            this.MJ.setEnabled(this.yK.fz());
            this.FN.setEnabled(this.yK.ft());
            this.MK.setEnabled(true);
        }
    }

    private void sH() {
        this.uK.clear();
        this.uK.addAll(this.uk.kc());
        ((U)this.zj.getModel()).fireTableDataChanged();
        Collections.sort(this.uK, KZ);
        if (this.zj.getRowCount() > 0) {
            this.zj.setRowSelectionInterval(0, 0);
            this.yK = (F)this.uK.get(0);
            this.sG();
            this.sF();
        }
        this.MP.setText(C.c(this.ul.kb()));
    }

    public void F(ah ah2) {
        this.uk = ah2;
        this.yK = null;
        this.mK();
        if (this.zj.getRowCount() > 0) {
            this.zj.setRowSelectionInterval(0, 0);
        }
        Collections.sort(this.uK, KZ);
        this.zj.addNotify();
    }

    public void mK() {
        this.uu.setText(this.uk.getNome());
        this.MP.setText(C.c(this.ul.kb()));
        if (this.uk.ka() != null) {
            this.MS.setText(this.uk.ka().dS());
        } else {
            this.MS.setText("interino");
        }
        this.MR.setText(aq.pZ[this.uk.getReputacao()]);
        this.Fq.setIcon(this.uk.kP());
        this.MQ.setText(ac.valueOf("P" + this.uk.getPais()).getNome());
        ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/aflags/" + this.uk.getPais() + ".png"));
        this.MQ.setIcon(imageIcon);
        if (this.uk.getPais() == 29) {
            this.MQ.setText(String.valueOf(ac.valueOf("P" + this.uk.getPais()).getNome()) + " (" + aq.rX[this.uk.getEstado()] + ")");
        } else {
            this.MM.setVisible(false);
        }
        this.Hf.setValue(this.uk.ka().lL());
        this.Ig.setValue(this.uk.ka().lM());
        long l2 = 0L;
        int n2 = 0;
        while (n2 < this.uk.kc().size()) {
            ((F)this.uk.kc().get(n2)).a((ImageIcon)null);
            l2 += (long)((F)this.uk.kc().get(n2)).fk();
            ++n2;
        }
        this.MT.setText("Valor do elenco: " + C.a(l2, 0));
        this.uK.clear();
        this.uK.addAll(this.uk.kc());
        ((U)this.zj.getModel()).fireTableDataChanged();
        Collections.sort(this.uK, KZ);
    }

    private void mJ() {
        this.we = new JPanel();
        this.MO = new JLabel();
        this.ML = new JTabbedPane();
        this.zf = new JScrollPane();
        this.MN = new JLabel();
        this.zg = new JScrollPane();
        this.MU = new JTable();
        this.wf = new JPanel();
        this.Fq = new JLabel();
        this.uu = new JLabel();
        this.MS = new JLabel();
        this.MR = new JLabel();
        this.MQ = new JLabel();
        this.MM = new JLabel();
        this.MT = new JLabel();
        this.wg = new JPanel();
        this.ve = new JToolBar();
        this.HW = new JButton();
        this.HR = new JButton();
        this.Ie = new JButton();
        this.HY = new JButton();
        this.Ic = new JButton();
        this.ut = new JScrollPane();
        this.zj = new JTable();
        this.MP = new JLabel();
        this.vm = new JButton();
        this.MJ = new JButton();
        this.FN = new JButton();
        this.MK = new JButton();
        this.wh = new JPanel();
        this.a_ = new JLabel();
        this.ur = new JLabel();
        this.Hf = new JProgressBar();
        this.Ig = new JProgressBar();
        this.wi = new JScrollPane();
        this.uw = new JTree();
        this.setBackground(new Color(104, 120, 100));
        this.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204), 2));
        this.MO.setFont(new Font("Tahoma", 0, 12));
        this.MO.setHorizontalAlignment(2);
        this.MO.setIcon(new ImageIcon(this.getClass().getResource("/aicons/1.png")));
        this.MO.setText("Marquinhos Paran\u00e1 - M");
        this.MN.setFont(new Font("Tahoma", 0, 12));
        this.MN.setText("");
        this.MN.setVerticalAlignment(1);
        this.zf.setViewportView(this.MN);
        this.ML.addTab("Info", this.zf);
        this.zg.setViewportView(this.MU);
        this.ML.addTab("Carreira", this.zg);
        GroupLayout groupLayout = new GroupLayout(this.we);
        this.we.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.MO, -1, 254, Short.MAX_VALUE).addComponent(this.ML, GroupLayout.Alignment.TRAILING, -2, 0, Short.MAX_VALUE)).addContainerGap()));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup().addContainerGap(-1, Short.MAX_VALUE).addComponent(this.MO).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.ML, -2, 233, -2).addGap(208, 208, 208)));
        this.ML.getAccessibleContext().setAccessibleName("Info");
        this.ML.getAccessibleContext().setAccessibleDescription("");
        this.wf.setBackground(new Color(44, 53, 49));
        this.Fq.setIcon(new ImageIcon(this.getClass().getResource("/aicons/escudo.png")));
        this.uu.setFont(new Font("Tahoma", 1, 14));
        this.uu.setForeground(new Color(255, 255, 255));
        this.uu.setText("Cruzeiro");
        this.MS.setForeground(new Color(255, 255, 255));
        this.MS.setText("Marcelo Oliveira");
        this.MR.setForeground(new Color(255, 255, 255));
        this.MR.setText("Continental");
        this.MQ.setForeground(new Color(255, 255, 255));
        this.MQ.setText("Brasil");
        this.MM.setForeground(new Color(255, 255, 255));
        this.MM.setHorizontalAlignment(0);
        this.MM.setText("");
        this.MT.setForeground(new Color(255, 255, 255));
        this.MT.setText("Valor elenco:");
        GroupLayout groupLayout2 = new GroupLayout(this.wf);
        this.wf.setLayout(groupLayout2);
        groupLayout2.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addContainerGap().addComponent(this.Fq, -2, 60, -2).addGap(18, 18, 18).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.MS, -1, 294, Short.MAX_VALUE).addComponent(this.uu, -1, -1, Short.MAX_VALUE).addGroup(groupLayout2.createSequentialGroup().addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addComponent(this.MR, -2, 73, -2).addGap(18, 18, 18).addComponent(this.MQ, -1, -1, Short.MAX_VALUE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.MM, -2, 42, -2)).addComponent(this.MT, -1, -1, Short.MAX_VALUE)).addContainerGap()))));
        groupLayout2.setVerticalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addContainerGap().addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addComponent(this.uu).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.MS).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.MR).addComponent(this.MQ).addComponent(this.MM))).addComponent(this.Fq, -2, 60, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.MT).addContainerGap(19, Short.MAX_VALUE)));
        this.wg.setBackground(new Color(36, 91, 45));
        this.ve.setBackground(new Color(44, 53, 49));
        this.ve.setRollover(true);
        this.ve.setBorderPainted(false);
        this.HW.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon09.png")));
        this.HW.setBorderPainted(false);
        this.HW.setFocusable(false);
        this.HW.setHorizontalTextPosition(0);
        this.HW.setOpaque(false);
        this.HW.setVerticalTextPosition(3);
        this.ve.add(this.HW);
        this.HR.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon02.png")));
        this.HR.setBorderPainted(false);
        this.HR.setFocusable(false);
        this.HR.setHorizontalTextPosition(0);
        this.HR.setOpaque(false);
        this.HR.setVerticalTextPosition(3);
        this.ve.add(this.HR);
        this.Ie.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon10.png")));
        this.Ie.setBorderPainted(false);
        this.Ie.setFocusable(false);
        this.Ie.setHorizontalTextPosition(0);
        this.Ie.setOpaque(false);
        this.Ie.setVerticalTextPosition(3);
        this.ve.add(this.Ie);
        this.HY.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon11.png")));
        this.HY.setBorderPainted(false);
        this.HY.setFocusable(false);
        this.HY.setHorizontalTextPosition(0);
        this.HY.setMaximumSize(new Dimension(41, 41));
        this.HY.setOpaque(false);
        this.HY.setVerticalTextPosition(3);
        this.ve.add(this.HY);
        this.Ic.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon12.png")));
        this.Ic.setBorderPainted(false);
        this.Ic.setFocusable(false);
        this.Ic.setHorizontalTextPosition(0);
        this.Ic.setOpaque(false);
        this.Ic.setVerticalTextPosition(3);
        this.ve.add(this.Ic);
        GroupLayout groupLayout3 = new GroupLayout(this.wg);
        this.wg.setLayout(groupLayout3);
        groupLayout3.setHorizontalGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.ve, -1, -1, Short.MAX_VALUE));
        groupLayout3.setVerticalGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, groupLayout3.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(this.ve, -2, -1, -2)));
        this.ut.setViewportView(this.zj);
        this.MP.setForeground(new Color(255, 255, 255));
        this.MP.setText("Dinheiro em caixa:");
        this.vm.setText("Fechar");
        this.MJ.setText("Empr\u00e9stimo");
        this.FN.setText("Comprar");
        this.MK.setText("Fazer oferta");
        this.wh.setBackground(new Color(44, 53, 49));
        this.a_.setForeground(new Color(255, 255, 255));
        this.a_.setHorizontalAlignment(2);
        this.a_.setText("Confian\u00e7a Diretoria:");
        this.ur.setForeground(new Color(255, 255, 255));
        this.ur.setHorizontalAlignment(2);
        this.ur.setText("Confian\u00e7a Torcida:");
        this.Hf.setMinimum(1);
        this.Ig.setMinimum(1);
        GroupLayout groupLayout4 = new GroupLayout(this.wh);
        this.wh.setLayout(groupLayout4);
        groupLayout4.setHorizontalGroup(groupLayout4.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout4.createSequentialGroup().addContainerGap().addGroup(groupLayout4.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.a_, -2, 115, -2).addComponent(this.ur, -2, 123, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(groupLayout4.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.Hf, -2, 115, -2).addComponent(this.Ig, -2, 115, -2)).addContainerGap(13, Short.MAX_VALUE)));
        groupLayout4.setVerticalGroup(groupLayout4.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout4.createSequentialGroup().addContainerGap().addGroup(groupLayout4.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.a_).addComponent(this.Hf, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout4.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.ur).addComponent(this.Ig, -2, -1, -2)).addContainerGap(18, Short.MAX_VALUE)));
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
        this.wi.setViewportView(this.uw);
        GroupLayout groupLayout5 = new GroupLayout(this);
        this.setLayout(groupLayout5);
        groupLayout5.setHorizontalGroup(groupLayout5.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout5.createSequentialGroup().addGap(20, 20, 20).addGroup(groupLayout5.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout5.createSequentialGroup().addComponent(this.MP, -1, -1, Short.MAX_VALUE).addGap(41, 41, 41)).addGroup(groupLayout5.createSequentialGroup().addGroup(groupLayout5.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.wi).addComponent(this.we, -1, -1, Short.MAX_VALUE)).addGap(22, 22, 22))).addGroup(groupLayout5.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout5.createSequentialGroup().addComponent(this.MJ, -2, 126, -2).addGap(21, 21, 21).addComponent(this.FN, -2, 120, -2).addGap(18, 18, 18).addComponent(this.MK, -2, 122, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, Short.MAX_VALUE).addComponent(this.vm, -2, 116, -2)).addComponent(this.ut, GroupLayout.Alignment.TRAILING).addGroup(groupLayout5.createSequentialGroup().addComponent(this.wf, -2, -1, -2).addGap(18, 18, 18).addGroup(groupLayout5.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.wh, -1, -1, Short.MAX_VALUE).addComponent(this.wg, -1, -1, Short.MAX_VALUE)))).addGap(29, 29, 29)));
        groupLayout5.setVerticalGroup(groupLayout5.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout5.createSequentialGroup().addGap(13, 13, 13).addGroup(groupLayout5.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout5.createSequentialGroup().addGroup(groupLayout5.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout5.createSequentialGroup().addComponent(this.wh, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.wg, -2, -1, -2)).addComponent(this.wf, -2, -1, -2)).addGap(18, 18, 18).addComponent(this.ut, -1, 509, Short.MAX_VALUE)).addGroup(groupLayout5.createSequentialGroup().addComponent(this.wi, -2, 351, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.we, -2, 280, Short.MAX_VALUE))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout5.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.MP, -2, 39, -2).addComponent(this.vm).addComponent(this.MJ).addComponent(this.FN).addComponent(this.MK)).addContainerGap()));
    }

    static /* synthetic */ JDialog a(iA iA2) {
        return iA2.ub;
    }

    static /* synthetic */ void b(iA iA2) {
        iA2.sD();
    }

    static /* synthetic */ void c(iA iA2) {
        iA2.sC();
    }

    static /* synthetic */ void d(iA iA2) {
        iA2.rw();
    }

    static /* synthetic */ void e(iA iA2) {
        iA2.qP();
    }

    static /* synthetic */ void f(iA iA2) {
        iA2.sB();
    }

    static /* synthetic */ void g(iA iA2) {
        iA2.sz();
    }

    static /* synthetic */ void h(iA iA2) {
        iA2.oM();
    }

    static /* synthetic */ void i(iA iA2) {
        iA2.sA();
    }

    static /* synthetic */ JTree j(iA iA2) {
        return iA2.uw;
    }

    static /* synthetic */ JTable k(iA iA2) {
        return iA2.zj;
    }

    static /* synthetic */ F l(iA iA2) {
        return iA2.yK;
    }
}

