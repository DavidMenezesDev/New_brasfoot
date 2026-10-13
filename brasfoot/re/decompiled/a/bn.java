/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.bo;
import a.bp;
import a.bq;
import a.br;
import b.u;
import best.ah;
import best.aq;
import best.ar;
import c.a;
import components.as;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;

public class bn
extends JPanel {
    private JDialog ub;
    private ArrayList oh = null;
    private as zX = null;
    private ah zY = null;
    private JButton vm;
    private JButton zZ;
    private JButton Aa;
    private JLabel ug;
    private JPanel vd;
    private JScrollPane ut;
    private JLabel Ab;
    private JLabel Ac;
    private JTable Ad;

    public bn(JDialog jDialog, ArrayList arrayList, ah ah2) {
        this.ub = jDialog;
        this.oh = arrayList;
        this.zY = ah2;
        this.oh = new ArrayList();
        if (arrayList != null) {
            this.oh.addAll(arrayList);
            Collections.reverse(this.oh);
        }
        this.mJ();
        this.mH();
        this.mS();
        this.T(false);
        if (this.Ad.getRowCount() > 0) {
            this.Ad.setRowSelectionInterval(0, 0);
        }
        this.mG();
    }

    private void mG() {
        this.setBackground(aq.E(a.vM().getCorTema(), 1));
    }

    private void T(boolean bl2) {
        this.Aa.setVisible(bl2);
        this.zZ.setVisible(bl2);
        this.Ab.setVisible(bl2);
    }

    public void mH() {
        this.vm.addActionListener(new bo(this));
        this.Aa.addActionListener(new bp(this));
        this.zZ.addActionListener(new bq(this));
    }

    private void nQ() {
        boolean bl2 = false;
        if (new Random().nextInt(100) > 50) {
            bl2 = true;
        }
        if (bl2 && this.zX != null && this.zY != null && this.zY.ka() != null) {
            new as(this.zY.ka(), 10, new Random().nextInt(4) + 16, this.zX.vs(), "");
        }
    }

    private void cQ(int n2) {
        if (n2 == 1) {
            if (this.zX != null) {
                this.zX.aG(false);
                this.T(false);
                if (this.zX.vt() == 1 && this.zX.lY() > 0 && this.zY != null) {
                    this.zY.v(this.zX.lY(), 9);
                    this.Ab.setVisible(true);
                    this.Ab.setText("Multado!");
                    this.nQ();
                }
            }
        } else if (n2 == 2 && this.zX != null) {
            this.zX.aG(false);
            this.T(false);
        }
    }

    private void mS() {
        u u2 = new u(this.oh);
        this.Ad.setModel(u2);
        int[] nArray = new int[]{70, 220};
        int n2 = 0;
        while (n2 < nArray.length) {
            this.Ad.getColumnModel().getColumn(n2).setPreferredWidth(nArray[n2]);
            ++n2;
        }
        this.Ad.getColumnModel().getColumn(0).setMaxWidth(70);
        this.Ad.setAutoResizeMode(3);
        this.Ad.setRowHeight(20);
        this.Ad.setShowGrid(false);
        this.Ad.setDefaultRenderer(as.class, new b.ar());
        this.Ad.setAutoCreateRowSorter(false);
        this.Ad.getTableHeader().setReorderingAllowed(false);
        this.Ad.setIntercellSpacing(new Dimension(0, 0));
        this.Ad.setCellSelectionEnabled(false);
        this.Ad.setSelectionMode(0);
        this.Ad.setRowSelectionAllowed(true);
        this.Ad.setSelectionBackground(Color.YELLOW);
        this.Ad.setFillsViewportHeight(true);
        this.Ad.getSelectionModel().addListSelectionListener(new br(this));
    }

    private void a(as as2) {
        if (as2 != null) {
            this.zX = as2;
            this.T(false);
            as2.aF(true);
            String string = "";
            if (as2.vn() < ar.tQ.length && as2.vn() >= 0) {
                string = ar.tQ[as2.vn()];
            }
            String string2 = as2.vq();
            String string3 = as2.vp();
            if (as2.vm() == 24 || as2.vm() == 28 || as2.vm() == 29 || as2.vm() == 34) {
                string = string.replace("$1", string2);
                string2 = "";
            } else if (as2.vm() == 26) {
                string = string.replace("$1", string2);
                if (string3 != null) {
                    string = string.replace("$2", string3);
                }
                string2 = "";
            }
            this.Ac.setText("<html>" + string + " " + string2 + "</html>");
            this.Ad.addNotify();
            this.Ab.setVisible(false);
            if (as2.vr()) {
                this.T(true);
                this.Ab.setText("Deseja multar esse jogador em 10% do sal\u00e1rio?");
            }
        }
    }

    private void mJ() {
        this.ug = new JLabel();
        this.ut = new JScrollPane();
        this.Ad = new JTable();
        this.vm = new JButton();
        this.vd = new JPanel();
        this.Ac = new JLabel();
        this.zZ = new JButton();
        this.Aa = new JButton();
        this.Ab = new JLabel();
        this.setBackground(new Color(104, 120, 100));
        this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.ug.setFont(new Font("Tahoma", 1, 14));
        this.ug.setForeground(new Color(255, 255, 255));
        this.ug.setIcon(new ImageIcon(this.getClass().getResource("/aicons/messageicon.png")));
        this.ug.setText("Central de Mensagens");
        this.ut.setBackground(new Color(44, 53, 49));
        this.Ad.setBackground(new Color(44, 53, 49));
        this.Ad.setForeground(new Color(255, 255, 255));
        this.ut.setViewportView(this.Ad);
        this.vm.setText("X");
        this.Ac.setFont(new Font("Arial", 0, 12));
        this.Ac.setText("<html><P valign=\"top\">A diretoria lhe deseja sorte. Esperamos muitas vit\u00f3rias. Nesta janela iremos te comunicar sobre v\u00e1rios assuntos do clube. dfasdfasdf dsfafdsf</P></html>\n\n");
        this.Ac.setVerticalAlignment(1);
        this.Ac.setMaximumSize(new Dimension(200, 14));
        this.Ac.setVerticalTextPosition(1);
        this.zZ.setText("N\u00e3o Multar");
        this.Aa.setText("Multar");
        this.Ab.setFont(new Font("Tahoma", 1, 12));
        this.Ab.setHorizontalAlignment(4);
        this.Ab.setText("jLabel2");
        GroupLayout groupLayout = new GroupLayout(this.vd);
        this.vd.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addComponent(this.Ac, -2, 411, -2).addGap(0, 0, Short.MAX_VALUE)).addComponent(this.Ab, GroupLayout.Alignment.TRAILING, -1, -1, Short.MAX_VALUE).addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(this.Aa, -2, 116, -2).addGap(18, 18, 18).addComponent(this.zZ, -2, 116, -2))).addContainerGap()));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(this.Ac, -2, 198, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, Short.MAX_VALUE).addComponent(this.Ab).addGap(18, 18, 18).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.zZ).addComponent(this.Aa)).addContainerGap()));
        GroupLayout groupLayout2 = new GroupLayout(this);
        this.setLayout(groupLayout2);
        groupLayout2.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addGap(22, 22, 22).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(groupLayout2.createSequentialGroup().addComponent(this.ug, -2, 301, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, Short.MAX_VALUE).addComponent(this.vm, -2, 77, -2)).addGroup(groupLayout2.createSequentialGroup().addComponent(this.ut, -2, 401, -2).addGap(18, 18, 18).addComponent(this.vd, -2, -1, -2))).addContainerGap(20, Short.MAX_VALUE)));
        groupLayout2.setVerticalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addContainerGap().addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.ug).addComponent(this.vm)).addGap(18, 18, 18).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.ut, -1, 300, Short.MAX_VALUE).addComponent(this.vd, -1, -1, Short.MAX_VALUE)).addContainerGap(27, Short.MAX_VALUE)));
    }

    static /* synthetic */ JDialog a(bn bn2) {
        return bn2.ub;
    }

    static /* synthetic */ void a(bn bn2, int n2) {
        bn2.cQ(n2);
    }

    static /* synthetic */ JTable b(bn bn2) {
        return bn2.Ad;
    }

    static /* synthetic */ void a(bn bn2, as as2) {
        bn2.a(as2);
    }
}

