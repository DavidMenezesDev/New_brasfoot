/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.bh;
import a.bi;
import a.bj;
import a.bk;
import a.dV;
import b.aq;
import b.t;
import best.F;
import best.I;
import best.ah;
import components.X;
import components.a;
import components.b;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;

public class bg
extends JPanel {
    private JDialog ub;
    private I zz;
    private int[] zA = new int[2];
    private int[] zB = new int[3];
    private Timer zC;
    private ArrayList zD = new ArrayList();
    private ArrayList zE = new ArrayList();
    private int zF = 0;
    private int zG = 0;
    private int zH = 1;
    private int zI = -1;
    ArrayList zJ = new ArrayList();
    private JButton zK;
    private JScrollPane ut;
    private JLabel yt;
    private JLabel zL;
    private JLabel zM;
    private JLabel zN;
    private JLabel zO;
    private JLabel zP;
    private JLabel zQ;
    private JLabel zR;
    private JTable zS;

    public bg(JDialog jDialog, I i2) {
        this.ub = jDialog;
        this.zz = i2;
        this.mJ();
        this.zK.setVisible(false);
        this.zO.setText(i2.hc().getNome());
        this.zO.setForeground(i2.hc().kC());
        this.zO.setBackground(i2.hc().kB());
        this.zP.setText(i2.hd().getNome());
        this.zP.setForeground(i2.hd().kC());
        this.zP.setBackground(i2.hd().kB());
        if (i2.hc().kP() != null) {
            this.yt.setIcon(i2.hc().kP());
        }
        if (i2.hd().kP() != null) {
            this.zL.setIcon(i2.hd().kP());
        }
        this.nP();
        this.zD.addAll(dV.qk());
        this.zE.addAll(dV.ql());
        this.mS();
        this.zQ.setVisible(false);
        this.mH();
        this.a(this);
        this.nJ();
    }

    private void a(JComponent jComponent) {
        InputMap inputMap = jComponent.getInputMap(1);
        jComponent.getInputMap().put(KeyStroke.getKeyStroke(115, 512), "st");
        ActionMap actionMap = this.getActionMap();
        jComponent.getActionMap().put("st", new bh(this));
    }

    public void mH() {
        this.zK.addActionListener(new bi(this));
    }

    public void nJ() {
        this.zC = new Timer();
        this.zC.schedule((TimerTask)new bj(this), 1000L);
    }

    public void nK() {
        this.zC = new Timer();
        this.zC.schedule((TimerTask)new bk(this), 1500L);
    }

    public void nL() {
        ArrayList arrayList;
        if (this.zH == 1) {
            arrayList = this.zD;
            if (this.zF >= arrayList.size()) {
                this.zF = 0;
            }
        } else {
            arrayList = this.zE;
            if (this.zG >= arrayList.size()) {
                this.zG = 0;
            }
        }
        X x2 = new X();
        if (this.zH == 1) {
            x2.a((F)arrayList.get(this.zF));
            this.b(1, (F)arrayList.get(this.zF), -1);
        } else {
            x2.a((F)arrayList.get(this.zG));
            this.b(2, (F)arrayList.get(this.zG), -1);
        }
        x2.dO(this.zH);
        this.zJ.add(x2);
        this.zS.addNotify();
        this.nN();
        this.nK();
    }

    private void b(int n2, F f2, int n3) {
        ah ah2 = null;
        this.zQ.setVisible(true);
        ah2 = n2 == 1 ? this.zz.hc() : this.zz.hd();
        this.zQ.setForeground(ah2.kC());
        this.zQ.setBackground(ah2.kB());
        if (n3 == -1) {
            String string = "";
            if (f2 != null) {
                string = f2.getNome();
            }
            this.zQ.setText(String.valueOf(string) + " vai pra bola...");
        } else if (n3 == 0) {
            this.zQ.setText("Perdeu!");
        } else if (n3 == 1) {
            this.zQ.setText("Gol!!!");
        }
    }

    private void nM() {
        int n2 = 0;
        int n3 = 70;
        int n4 = 30;
        int n5 = new Random().nextInt(100) + 1;
        if (n5 <= n3) {
            n2 = 1;
        }
        X x2 = (X)this.zJ.get(this.zJ.size() - 1);
        x2.dN(n2);
        if (this.zH == 1) {
            ++this.zF;
            if (n2 == 1) {
                this.zA[0] = this.zA[0] + 1;
            }
            this.zB[1] = this.zB[1] + 1;
            this.b(1, null, n2);
        } else if (this.zH == 2) {
            ++this.zG;
            if (n2 == 1) {
                this.zA[1] = this.zA[1] + 1;
            }
            this.zB[2] = this.zB[2] + 1;
            this.b(2, null, n2);
        }
        this.nP();
        this.zS.addNotify();
        this.nN();
        if (this.cP(n2)) {
            this.nO();
        } else {
            if (this.zH == 1) {
                this.zH = 2;
            } else if (this.zH == 2) {
                this.zH = 1;
            }
            this.nJ();
        }
    }

    private void nN() {
        if (this.zJ.size() > 17) {
            try {
                int n2 = this.zS.getRowCount() - 1;
                int n3 = 0;
                boolean bl2 = true;
                Rectangle rectangle = this.zS.getCellRect(n2, n3, bl2);
                this.zS.scrollRectToVisible(rectangle);
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    private void nO() {
        if (this.zI == 1) {
            this.zz.u(this.zz.hc());
        } else if (this.zI == 2) {
            this.zz.u(this.zz.hd());
        }
        this.zz.i(this.zA);
        if (this.zz.hR() != null) {
            this.zQ.setText(String.valueOf(this.zz.hR().getNome()) + " venceu");
        }
        this.zQ.setForeground(this.zz.hR().kC());
        this.zQ.setBackground(this.zz.hR().kB());
        this.zQ.setVisible(true);
        this.zK.setVisible(true);
    }

    private boolean cP(int n2) {
        if (this.zH == 1 && this.zB[1] <= 5) {
            if (n2 == 1 && this.zA[0] > 5 - this.zB[2] + this.zA[1]) {
                this.zI = 1;
                return true;
            }
            if (5 - this.zB[1] + this.zA[0] < this.zA[1]) {
                this.zI = 2;
                return true;
            }
        } else if (this.zH == 2 && this.zB[2] <= 5) {
            if (n2 == 1 && 5 - this.zB[1] + this.zA[0] < this.zA[1]) {
                this.zI = 2;
                return true;
            }
            if (this.zA[0] > 5 - this.zB[2] + this.zA[1]) {
                this.zI = 1;
                return true;
            }
        } else if (this.zH == 2 && this.zB[2] > 5) {
            if (this.zA[0] > this.zA[1]) {
                this.zI = 1;
                return true;
            }
            if (this.zA[0] < this.zA[1]) {
                this.zI = 2;
                return true;
            }
        }
        return false;
    }

    private void mS() {
        t t2 = new t(this.zJ);
        this.zS.setModel(t2);
        this.zS.setTableHeader(null);
        int[] nArray = new int[]{30, 100, 100, 30};
        int n2 = 0;
        while (n2 < nArray.length) {
            this.zS.getColumnModel().getColumn(n2).setPreferredWidth(nArray[n2]);
            ++n2;
        }
        this.zS.setAutoResizeMode(3);
        this.zS.setRowHeight(20);
        this.zS.setShowGrid(false);
        this.zS.setDefaultRenderer(X.class, new aq());
        this.zS.setAutoCreateRowSorter(false);
        this.zS.setIntercellSpacing(new Dimension(0, 0));
        this.zS.setCellSelectionEnabled(false);
        this.zS.setSelectionMode(0);
        this.zS.setRowSelectionAllowed(false);
        this.zS.setSelectionBackground(Color.YELLOW);
        this.zS.setFillsViewportHeight(true);
    }

    private void nP() {
        this.zN.setText(Integer.toString(this.zA[0]));
        this.zR.setText(Integer.toString(this.zA[1]));
    }

    private void mJ() {
        this.zL = new JLabel();
        this.yt = new JLabel();
        this.zO = new JLabel();
        this.zP = new JLabel();
        this.zR = new JLabel();
        this.zN = new JLabel();
        this.zQ = new JLabel();
        this.zK = new JButton();
        this.ut = new JScrollPane();
        this.zS = new JTable();
        this.zM = new JLabel();
        this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        this.setMaximumSize(new Dimension(469, 520));
        this.setMinimumSize(new Dimension(469, 520));
        this.setPreferredSize(new Dimension(469, 520));
        this.setLayout(new b());
        this.add((Component)this.zL, new a(340, 40, 60, 60));
        this.add((Component)this.yt, new a(50, 40, 60, 60));
        this.zO.setBackground(new Color(0, 51, 204));
        this.zO.setFont(new Font("Tahoma", 1, 14));
        this.zO.setForeground(new Color(255, 255, 255));
        this.zO.setHorizontalAlignment(0);
        this.zO.setText("Time1");
        this.zO.setOpaque(true);
        this.add((Component)this.zO, new a(50, 110, 160, 30));
        this.zP.setBackground(new Color(153, 0, 0));
        this.zP.setFont(new Font("Tahoma", 1, 14));
        this.zP.setHorizontalAlignment(0);
        this.zP.setText("Time 2");
        this.zP.setOpaque(true);
        this.add((Component)this.zP, new a(250, 110, 160, 30));
        this.zR.setFont(new Font("Tahoma", 0, 36));
        this.zR.setForeground(new Color(255, 255, 255));
        this.zR.setHorizontalAlignment(0);
        this.zR.setText("2");
        this.zR.setHorizontalTextPosition(0);
        this.add((Component)this.zR, new a(255, 55, 40, 40));
        this.zN.setFont(new Font("Tahoma", 0, 36));
        this.zN.setForeground(new Color(255, 255, 255));
        this.zN.setHorizontalAlignment(0);
        this.zN.setText("1");
        this.zN.setHorizontalTextPosition(0);
        this.add((Component)this.zN, new a(150, 55, 40, 40));
        this.zQ.setFont(new Font("Tahoma", 0, 14));
        this.zQ.setHorizontalAlignment(0);
        this.zQ.setText("Time 1 venceru");
        this.zQ.setToolTipText("");
        this.zQ.setOpaque(true);
        this.add((Component)this.zQ, new a(50, 145, 360, 30));
        this.zK.setText("continuar");
        this.add((Component)this.zK, new a(160, 560, 150, 30));
        this.ut.setViewportView(this.zS);
        this.add((Component)this.ut, new a(50, 180, 360, 370));
        this.zM.setForeground(new Color(255, 255, 255));
        this.zM.setIcon(new ImageIcon(this.getClass().getResource("/aiconsj/penaltyd.jpg")));
        this.add((Component)this.zM, new a(0, 0, -1, -1));
    }

    static /* synthetic */ JDialog a(bg bg2) {
        return bg2.ub;
    }

    static /* synthetic */ Timer b(bg bg2) {
        return bg2.zC;
    }

    static /* synthetic */ void c(bg bg2) {
        bg2.nM();
    }
}

