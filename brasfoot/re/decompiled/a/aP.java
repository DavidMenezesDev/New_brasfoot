/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.aQ;
import a.aR;
import a.aS;
import a.aT;
import a.aU;
import a.aV;
import a.aW;
import b.ao;
import b.q;
import best.F;
import best.K;
import best.Z;
import best.ad;
import best.af;
import best.ah;
import best.aq;
import best.n;
import components.O;
import components.a;
import components.aa;
import components.b;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class aP
extends JPanel {
    private JDialog ub;
    private ah hy;
    private ArrayList uK = new ArrayList();
    private ArrayList vp = new ArrayList();
    private String pU = "Qualquer";
    private int pais = -1;
    private F yK = null;
    private F yL = null;
    private int yM = 2;
    private int yN = 16;
    private int yO = 3;
    private int yP = 27;
    private boolean yQ = false;
    private int yR = 3;
    private boolean yS = false;
    private int yT = 35;
    private int yU = 275;
    private JButton yV;
    private JButton yW;
    private JButton yX;
    private JButton vm;
    private JButton yY;
    private JButton yZ;
    private JButton za;
    private JLabel ug;
    private JLabel zb;
    private JLabel zc;
    private JLabel zd;
    private JLabel ze;
    private JScrollPane zf;
    private JScrollPane zg;
    private JLabel zh;
    private O zi;
    private JTable zj;
    private JTable zk;

    public aP(JDialog jDialog, ah ah2, boolean bl2) {
        this.ub = jDialog;
        this.hy = ah2;
        this.pais = ah2.getPais();
        this.yQ = bl2;
        if (!c.a.SR.isHabilidadeIndividual()) {
            this.yR = 4;
        }
        if (this.yR == 4) {
            this.yU = 220;
            this.yT = 55;
        }
        this.mJ();
        this.mK();
        this.mH();
        this.nE();
        this.nF();
        if (this.yS) {
            this.yP = 27;
        }
        int n2 = n.G(this.pais) + 1;
        this.zi.BD.addItem(((ad)n.cY().get(n2 - 1)).getNome());
        if (n2 < this.zi.BD.getItemCount()) {
            this.zi.BD.setSelectedIndex(n2);
        }
        this.ug.setText("Convocar jogadores para sele\u00e7\u00e3o - " + ah2.getNome());
        if (!this.jk()) {
            K.r(this.pais, this.hy.getNivel());
        }
        this.mG();
    }

    private void mG() {
        this.setBackground(aq.E(c.a.vM().getCorTema(), 1));
    }

    private void mK() {
        this.zi.mK();
    }

    public boolean jk() {
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        while (n4 < c.a.SR.O().size()) {
            if (((F)c.a.SR.O().get(n4)).getPais() == this.pais) {
                if (((F)c.a.SR.O().get(n4)).getPosicao() == 0) {
                    ++n3;
                } else {
                    ++n2;
                }
            }
            ++n4;
        }
        n4 = 0;
        while (n4 < c.a.SR.bN().size()) {
            if (((F)c.a.SR.bN().get(n4)).getPais() == this.pais) {
                if (((F)c.a.SR.bN().get(n4)).getPosicao() == 0) {
                    ++n3;
                } else {
                    ++n2;
                }
            }
            ++n4;
        }
        return n2 >= 16 && n3 >= 2;
    }

    private void nx() {
        int[] nArray;
        Z z2 = c.a.SR.s(this.pais);
        z2.jj();
        if (!z2.jl()) {
            this.yM = 1;
            this.yN = 10;
        }
        if ((nArray = this.nC())[0] < this.yM || nArray[1] < this.yN) {
            JOptionPane.showMessageDialog(this.ub, "Convoque 2 goleiros e 15 na linha, ou clique em convoca\u00e7\u00e3o autom\u00e1tica", "M\u00ednimo de jogadores", 2);
        } else {
            this.ub.dispose();
        }
    }

    public void mH() {
        this.vm.addActionListener(new aQ(this));
        this.yY.addActionListener(new aR(this));
        this.yV.addActionListener(new aS(this));
        this.yZ.addActionListener(new aT(this));
        this.yW.addActionListener(new aU(this));
        this.yX.addActionListener(new aV(this));
        this.za.addActionListener(new aW(this));
    }

    private void ny() {
        this.hy.kc().clear();
        ((q)this.zk.getModel()).fireTableDataChanged();
        this.nC();
        this.zk.addNotify();
    }

    private void nz() {
        Z z2 = c.a.SR.s(this.pais);
        z2.z(false);
        this.nF();
        this.uK.clear();
        this.zj.addNotify();
    }

    private void nA() {
        if (this.zj.getSelectedRowCount() > 0) {
            int[] nArray = this.nC();
            boolean bl2 = true;
            int n2 = this.zj.convertRowIndexToModel(this.zj.getSelectedRow());
            this.yK = ((q)this.zj.getModel()).ev(n2);
            if (this.yK.getPosicao() == 0) {
                if (nArray[0] >= this.yO) {
                    bl2 = false;
                }
            } else if (nArray[1] >= this.yP) {
                bl2 = false;
            }
            if (bl2) {
                if (!this.hy.kc().contains(this.yK)) {
                    this.hy.kc().add(this.yK);
                    Collections.sort(this.hy.kc(), h.a.abe);
                    this.uK.remove(this.yK);
                    ((q)this.zj.getModel()).fireTableDataChanged();
                    if (this.zj.getRowCount() > 0) {
                        this.zj.setRowSelectionInterval(0, 0);
                    }
                    this.zj.addNotify();
                    this.zk.addNotify();
                    int[] nArray2 = this.nC();
                    this.zd.setText(Integer.toString(nArray2[0]));
                    this.ze.setText(Integer.toString(nArray2[1]));
                }
            } else {
                JOptionPane.showMessageDialog(this.ub, "M\u00e1ximo:" + Integer.toString(this.yO) + " goleiros\n" + "M\u00e1ximo:" + Integer.toString(this.yP) + " na linha\n", "Limite de jogadores atingido", 2);
            }
        }
    }

    private void nB() {
        if (this.zk.getSelectedRowCount() > 0) {
            int n2 = this.zk.convertRowIndexToModel(this.zk.getSelectedRow());
            this.yL = ((q)this.zk.getModel()).ev(n2);
            this.hy.kc().remove(this.yL);
            this.uK.add(0, this.yL);
            ((q)this.zk.getModel()).fireTableDataChanged();
            if (this.zk.getRowCount() > 0) {
                this.zk.setRowSelectionInterval(0, 0);
            }
            this.zj.addNotify();
            this.zk.addNotify();
            int[] nArray = this.nC();
            this.zd.setText(Integer.toString(nArray[0]));
            this.ze.setText(Integer.toString(nArray[1]));
            ((q)this.zj.getModel()).fireTableDataChanged();
        }
    }

    private int[] nC() {
        int[] nArray = new int[2];
        int n2 = 0;
        while (n2 < this.hy.kc().size()) {
            if (((F)this.hy.kc().get(n2)).getPosicao() == 0) {
                nArray[0] = nArray[0] + 1;
            } else {
                nArray[1] = nArray[1] + 1;
            }
            ++n2;
        }
        return nArray;
    }

    private void nD() {
        af af2 = new af();
        af2.setNome(this.zi.uf.getText());
        af2.bv(this.zi.Nq.getSelectedIndex() - 1);
        af2.bw(this.zi.Qx.getSelectedIndex() - 1);
        if (this.yR == 4) {
            if (this.zi.QB.getValue() > this.zi.QB.getMinimum() || this.zi.QB.uv() < this.zi.QB.getMaximum()) {
                af2.bM(this.zi.QB.getValue());
                af2.bN(this.zi.QB.uv());
                af2.bx(0);
            } else {
                af2.bx(-1);
            }
        } else {
            String[] stringArray = new String[]{"gol", "des", "vel", "fin", "arm", "tec", "pas"};
            aa[] aaArray = new aa[]{this.zi.QN, this.zi.QL, this.zi.QQ, this.zi.QM, this.zi.QK, this.zi.QP, this.zi.QO};
            int n2 = 0;
            while (n2 < aaArray.length) {
                if (aaArray[n2].getValue() > aaArray[n2].getMinimum() || aaArray[n2].uv() < aaArray[n2].getMaximum()) {
                    af2.b(stringArray[n2], aaArray[n2].getValue(), aaArray[n2].uv());
                }
                ++n2;
            }
        }
        if (this.zi.QC.getValue() > this.zi.QC.getMinimum() || this.zi.QC.uv() < this.zi.QC.getMaximum()) {
            af2.bO(this.zi.QC.getValue());
            af2.bP(this.zi.QC.uv());
            if (this.zi.QC.uv() == this.zi.QC.getMaximum()) {
                af2.bP(100);
            }
            af2.by(0);
        } else {
            af2.by(-1);
        }
        af2.bz(this.zi.Qy.getSelectedIndex() - 1);
        af2.bA(this.zi.Qv.getSelectedIndex() - 1);
        af2.bB(this.zi.Qw.getSelectedIndex() - 1);
        af2.bC(this.pais);
        af2.bD(this.zi.Qu.getSelectedIndex() - 1);
        af2.E(this.zi.Qs.isSelected());
        af2.F(this.zi.Qt.isSelected());
        this.vp.clear();
        this.uK.clear();
        this.vp = af2.D(true);
        int n3 = 0;
        int n4 = 0;
        while (n4 < this.vp.size()) {
            if (!this.hy.kc().contains(this.vp.get(n4))) {
                this.uK.add((F)this.vp.get(n4));
                ++n3;
            }
            ++n4;
        }
        ((q)this.zj.getModel()).fireTableDataChanged();
        if (this.uK.size() == 0) {
            this.zh.setText("Nenhum jogador encontrado");
        } else if (this.uK.size() == 1) {
            this.zh.setText("1 jogador encontrado");
        } else {
            this.zh.setText(String.valueOf(Integer.toString(this.uK.size())) + " jogadores encontrados");
        }
        this.zj.addNotify();
    }

    public void s(F f2) {
    }

    private void nE() {
        q q2 = new q(this.uK, this, 1);
        this.zj.setModel(q2);
        int[] nArray = new int[]{20, 120, 100, 20, 25, 55, 25};
        int[] nArray2 = new int[]{20, 90, 85, 25, 25, 25, 25, 25, 25, 25, 25, 50, 20};
        if (c.a.SR.isHabilidadeIndividual()) {
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
        this.zj.setDefaultRenderer(F.class, new ao());
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
        tableRowSorter.setComparator(1, h.a.abk);
        tableRowSorter.setComparator(2, h.a.abl);
        tableRowSorter.setComparator(3, h.a.aba);
        if (!c.a.SR.isHabilidadeIndividual()) {
            tableRowSorter.setComparator(4, h.a.aaJ);
            tableRowSorter.setComparator(6, h.a.VU);
        } else {
            tableRowSorter.setComparator(4, h.a.aaK);
            tableRowSorter.setComparator(5, h.a.aaM);
            tableRowSorter.setComparator(6, h.a.aaL);
            tableRowSorter.setComparator(7, h.a.aaN);
            tableRowSorter.setComparator(8, h.a.aaP);
            tableRowSorter.setComparator(9, h.a.aaO);
            tableRowSorter.setComparator(10, h.a.aaQ);
            tableRowSorter.setComparator(11, h.a.VU);
        }
    }

    private void nF() {
        q q2 = new q(this.hy.kc(), this, 2);
        this.zk.setModel(q2);
        int[] nArray = new int[]{25, 120, 120, 20, 20, 45, 25};
        int[] nArray2 = new int[]{20, 90, 90, 20};
        if (c.a.SR.isHabilidadeIndividual()) {
            nArray = nArray2;
        }
        int n2 = 0;
        while (n2 < nArray.length) {
            this.zk.getColumnModel().getColumn(n2).setPreferredWidth(nArray[n2]);
            ++n2;
        }
        this.zk.setAutoResizeMode(3);
        this.zk.setRowHeight(20);
        this.zk.setShowGrid(false);
        this.zk.setDefaultRenderer(F.class, new ao());
        this.zk.setAutoCreateRowSorter(false);
        this.zk.getTableHeader().setReorderingAllowed(false);
        this.zk.setIntercellSpacing(new Dimension(0, 0));
        this.zk.setCellSelectionEnabled(false);
        this.zk.setSelectionMode(0);
        this.zk.setRowSelectionAllowed(true);
        this.zk.setSelectionBackground(Color.YELLOW);
        TableRowSorter<TableModel> tableRowSorter = new TableRowSorter<TableModel>(this.zk.getModel());
        this.zk.setRowSorter(tableRowSorter);
        tableRowSorter.setComparator(0, h.a.abe);
        tableRowSorter.setComparator(1, h.a.abk);
        tableRowSorter.setComparator(2, h.a.abl);
        tableRowSorter.setComparator(3, h.a.aba);
        this.zk.setFillsViewportHeight(true);
        if (this.zk.getRowCount() > 0) {
            this.zk.setRowSelectionInterval(0, 0);
        }
        int[] nArray3 = this.nC();
        this.zd.setText(Integer.toString(nArray3[0]));
        this.ze.setText(Integer.toString(nArray3[1]));
    }

    private void mJ() {
        this.ug = new JLabel();
        this.zf = new JScrollPane();
        this.zj = new JTable();
        this.zg = new JScrollPane();
        this.zk = new JTable();
        this.yW = new JButton();
        this.yX = new JButton();
        this.yV = new JButton();
        this.yZ = new JButton();
        this.zb = new JLabel();
        this.zd = new JLabel();
        this.ze = new JLabel();
        this.vm = new JButton();
        this.zc = new JLabel();
        this.za = new JButton();
        this.zh = new JLabel();
        this.yY = new JButton();
        this.zi = new O(null, this.yR);
        this.setBackground(new Color(44, 53, 49));
        this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        this.setMinimumSize(new Dimension(800, 700));
        this.setPreferredSize(new Dimension(800, 700));
        this.setLayout(new b());
        this.ug.setFont(new Font("Tahoma", 1, 12));
        this.ug.setForeground(new Color(255, 255, 153));
        this.ug.setHorizontalAlignment(2);
        this.ug.setText("");
        this.add((Component)this.ug, new a(20, 15, 510, -1));
        this.zf.setViewportView(this.zj);
        this.add((Component)this.zf, new a(10, 366, 470, 320));
        this.zg.setViewportView(this.zk);
        this.add((Component)this.zg, new a(545, 365, 380, 289));
        this.yW.setText("Convoca\u00e7\u00e3o autom\u00e1tica");
        this.add((Component)this.yW, new a(745, 660, 180, -1));
        this.yX.setText("Desconvocar todos");
        this.add((Component)this.yX, new a(545, 660, 170, -1));
        this.yV.setText(">>");
        this.add((Component)this.yV, new a(490, 365, -1, -1));
        this.yZ.setText("<<");
        this.add((Component)this.yZ, new a(490, 395, -1, -1));
        this.zb.setForeground(new Color(255, 255, 255));
        this.zb.setText("Convocados:");
        this.add((Component)this.zb, new a(550, 340, -1, -1));
        this.zd.setForeground(new Color(255, 255, 255));
        this.zd.setIcon(new ImageIcon(this.getClass().getResource("/aicons/iconG.png")));
        this.zd.setText("12");
        this.add((Component)this.zd, new a(630, 340, -1, -1));
        this.ze.setForeground(new Color(255, 255, 255));
        this.ze.setIcon(new ImageIcon(this.getClass().getResource("/aicons/player_shirt_greensmall.png")));
        this.ze.setText("20");
        this.add((Component)this.ze, new a(680, 340, -1, -1));
        this.vm.setForeground(new Color(51, 102, 0));
        this.vm.setText("Continuar >>");
        this.add((Component)this.vm, new a(760, 320, 160, 30));
        this.zc.setForeground(new Color(255, 255, 255));
        this.zc.setHorizontalAlignment(4);
        this.zc.setText("(m\u00ednimo 2 gol. e 15 de linha) ");
        this.add((Component)this.zc, new a(570, 10, 190, 20));
        this.za.setText("Resetar filtros");
        this.za.setToolTipText("");
        this.add((Component)this.za, new a(790, 10, 130, -1));
        this.zh.setForeground(new Color(255, 255, 255));
        this.zh.setText("");
        this.add((Component)this.zh, new a(20, 330, 250, 20));
        this.yY.setForeground(new Color(0, 102, 0));
        this.yY.setText("Procurar");
        this.add((Component)this.yY, new a(340, 320, 143, 30));
        this.add((Component)this.zi, new a(20, this.yT, 900, this.yU));
    }

    static /* synthetic */ void a(aP aP2) {
        aP2.nx();
    }

    static /* synthetic */ void b(aP aP2) {
        aP2.nD();
    }

    static /* synthetic */ void c(aP aP2) {
        aP2.nA();
    }

    static /* synthetic */ void d(aP aP2) {
        aP2.nB();
    }

    static /* synthetic */ void e(aP aP2) {
        aP2.nz();
    }

    static /* synthetic */ void f(aP aP2) {
        aP2.ny();
    }

    static /* synthetic */ O g(aP aP2) {
        return aP2.zi;
    }
}

