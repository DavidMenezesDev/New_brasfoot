/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.cm;
import a.cn;
import a.co;
import a.cp;
import a.cq;
import best.B;
import best.ah;
import best.v;
import components.a;
import components.b;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DateFormat;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class cl
extends JPanel {
    private JDialog ub = null;
    private v dH = null;
    private int w = 0;
    private ah zY = null;
    int[] BX = new int[]{10, 25, 35, 50};
    private JButton BY;
    private JButton BZ;
    private JButton Ca;
    private JCheckBox Cb;
    private JLabel Cc;
    private JLabel Cd;
    private JLabel Ce;
    private JLabel Cf;
    private JLabel Cg;
    private JLabel zM;
    private JLabel zh;
    private JLabel Ch;
    private JSpinner Ci;
    private JSpinner Cj;
    private JSpinner Ck;
    private JSpinner Cl;

    public cl(JDialog jDialog, v v2, int n2, ah ah2) {
        this.ub = jDialog;
        this.dH = v2;
        this.w = n2;
        this.zY = ah2;
        this.mJ();
        this.mH();
        this.oA();
    }

    private void oA() {
        this.BX = v.a(this.w, this.zY);
        int[] nArray = this.dH.dT();
        int n2 = this.dH.dW();
        String string = "G:" + Integer.toString(this.BX[0]) + ";" + " A:" + Integer.toString(this.BX[1]) + ";" + " Cd:" + Integer.toString(this.BX[2]) + ";" + " Cm:" + Integer.toString(this.BX[3]);
        this.Ch.setText(string);
        this.Cg.setText(String.valueOf(this.dH.dS()) + " - " + Integer.toString(n2) + " lugares");
        this.Cf.setText(Integer.toString(nArray[0]));
        this.Cc.setText(Integer.toString(nArray[1]));
        this.Cd.setText(Integer.toString(nArray[2]));
        this.Ce.setText(Integer.toString(nArray[3]));
        this.Cb.setSelected(this.dH.dV());
        if (!this.dH.dV()) {
            this.oE();
        } else {
            this.oD();
        }
        this.Y(!this.dH.dV());
        this.zh.setText("");
        this.oB();
    }

    public void oB() {
        if (c.a.SR.bw() != null && c.a.SR.bw().size() > 0) {
            int n2 = 0;
            while (n2 < c.a.SR.bw().size()) {
                if (((B)c.a.SR.bw().get(n2)).ev() == this.dH) {
                    this.BY.setVisible(false);
                    DateFormat dateFormat = DateFormat.getDateInstance();
                    String string = dateFormat.format(((B)c.a.SR.bw().get(n2)).ew().getTime());
                    this.zh.setText("Expans\u00e3o com t\u00e9rmino em: " + string);
                    break;
                }
                ++n2;
            }
        }
    }

    public void mH() {
        this.BZ.addActionListener(new cm(this));
        this.BY.addActionListener(new cn(this));
        this.Cb.addActionListener(new co(this));
        this.Ca.addActionListener(new cp(this));
    }

    private void oC() {
        this.dH.o(this.Cb.isSelected());
        this.Y(!this.dH.dV());
        if (this.dH.dV()) {
            this.oD();
        } else {
            this.oE();
        }
    }

    private void oD() {
        this.Cl.setModel(new SpinnerNumberModel(this.BX[0], 1, 200, 1));
        this.Ci.setModel(new SpinnerNumberModel(this.BX[1], 1, 300, 1));
        this.Cj.setModel(new SpinnerNumberModel(this.BX[2], 1, 500, 1));
        this.Ck.setModel(new SpinnerNumberModel(this.BX[3], 1, 1000, 1));
    }

    private void oE() {
        int[] nArray = this.dH.dU();
        this.Cl.setModel(new SpinnerNumberModel(nArray[0], 1, 200, 1));
        this.Ci.setModel(new SpinnerNumberModel(nArray[1], 1, 300, 1));
        this.Cj.setModel(new SpinnerNumberModel(nArray[2], 1, 500, 1));
        this.Ck.setModel(new SpinnerNumberModel(nArray[3], 1, 1000, 1));
    }

    private void oF() {
        if (!this.dH.dV()) {
            int[] nArray = new int[]{(Integer)this.Cl.getValue(), (Integer)this.Ci.getValue(), (Integer)this.Cj.getValue(), (Integer)this.Ck.getValue()};
            this.dH.b(nArray);
        }
    }

    private void Y(boolean bl2) {
        JSpinner[] jSpinnerArray = new JSpinner[]{this.Cl, this.Ci, this.Cj, this.Ck};
        int n2 = 0;
        while (n2 < jSpinnerArray.length) {
            jSpinnerArray[n2].setEnabled(bl2);
            ++n2;
        }
        this.Ca.setEnabled(bl2);
    }

    public void oG() {
        JDialog jDialog = new JDialog(this.ub);
        cq cq2 = new cq(jDialog, this.dH, this.zY, this);
        jDialog.add(cq2);
        jDialog.setSize(438, 360);
        jDialog.setPreferredSize(new Dimension(438, 360));
        jDialog.setModal(true);
        jDialog.setResizable(false);
        jDialog.setLocationRelativeTo(null);
        jDialog.setUndecorated(true);
        jDialog.setVisible(true);
    }

    private void mJ() {
        this.Ch = new JLabel();
        this.Cb = new JCheckBox();
        this.Ck = new JSpinner();
        this.Cl = new JSpinner();
        this.Ci = new JSpinner();
        this.Cj = new JSpinner();
        this.Ca = new JButton();
        this.Ce = new JLabel();
        this.Cc = new JLabel();
        this.Cf = new JLabel();
        this.Cd = new JLabel();
        this.zh = new JLabel();
        this.Cg = new JLabel();
        this.BY = new JButton();
        this.BZ = new JButton();
        this.zM = new JLabel();
        this.setLayout(new b());
        this.Ch.setForeground(new Color(255, 255, 255));
        this.Ch.setText("jLabel1");
        this.add((Component)this.Ch, new a(450, 277, -1, -1));
        this.Cb.setForeground(new Color(255, 255, 255));
        this.Cb.setText("Usar sempre os pre\u00e7os sugeridos");
        this.Cb.setOpaque(false);
        this.add((Component)this.Cb, new a(330, 294, -1, -1));
        this.add((Component)this.Ck, new a(460, 210, 50, 20));
        this.Cl.setModel(new SpinnerNumberModel(1, 1, 1500, 1));
        this.add((Component)this.Cl, new a(460, 122, 50, 20));
        this.add((Component)this.Ci, new a(460, 150, 50, 20));
        this.add((Component)this.Cj, new a(460, 180, 50, 20));
        this.Ca.setIcon(new ImageIcon(this.getClass().getResource("/aicons/iconpreco2.png")));
        this.add((Component)this.Ca, new a(530, 230, 30, 20));
        this.Ce.setFont(new Font("Tahoma", 1, 14));
        this.Ce.setForeground(new Color(255, 255, 255));
        this.Ce.setText("10000");
        this.add((Component)this.Ce, new a(165, 204, -1, -1));
        this.Cc.setFont(new Font("Tahoma", 1, 14));
        this.Cc.setForeground(new Color(255, 255, 255));
        this.Cc.setText("10000");
        this.add((Component)this.Cc, new a(165, 150, -1, -1));
        this.Cf.setFont(new Font("Tahoma", 1, 14));
        this.Cf.setForeground(new Color(255, 255, 255));
        this.Cf.setText("10000");
        this.add((Component)this.Cf, new a(165, 122, -1, -1));
        this.Cd.setFont(new Font("Tahoma", 1, 14));
        this.Cd.setForeground(new Color(255, 255, 255));
        this.Cd.setText("10000");
        this.add((Component)this.Cd, new a(165, 177, -1, -1));
        this.zh.setFont(new Font("Tahoma", 0, 12));
        this.zh.setForeground(new Color(255, 255, 255));
        this.zh.setText("Nome do est\u00e1dio - C. 200 mil");
        this.add((Component)this.zh, new a(40, 270, 270, -1));
        this.Cg.setFont(new Font("Tahoma", 1, 14));
        this.Cg.setForeground(new Color(255, 255, 102));
        this.Cg.setText("Nome do est\u00e1dio - C. 200 mil");
        this.add((Component)this.Cg, new a(30, 20, 500, -1));
        this.BY.setIcon(new ImageIcon(this.getClass().getResource("/aicons/build.png")));
        this.BY.setText("Expandir est\u00e1dio");
        this.add((Component)this.BY, new a(60, 290, 170, 30));
        this.BZ.setFont(new Font("Tahoma", 1, 12));
        this.BZ.setText("X");
        this.add((Component)this.BZ, new a(520, 10, 60, 30));
        this.zM.setIcon(new ImageIcon(this.getClass().getResource("/aicons/estadio.jpg")));
        this.zM.setText("jLabel2");
        this.add((Component)this.zM, new a(0, 0, 600, 330));
    }

    static /* synthetic */ void a(cl cl2) {
        cl2.oF();
    }

    static /* synthetic */ JDialog b(cl cl2) {
        return cl2.ub;
    }

    static /* synthetic */ void c(cl cl2) {
        cl2.oC();
    }

    static /* synthetic */ void d(cl cl2) {
        cl2.oD();
    }
}

