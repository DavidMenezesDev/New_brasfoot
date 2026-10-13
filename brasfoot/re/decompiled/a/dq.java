/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.dr;
import b.as;
import b.v;
import best.A;
import best.C;
import best.F;
import best.aq;
import components.a;
import components.ao;
import components.b;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class dq
extends JPanel {
    private JDialog ub = null;
    private JLabel Az = new JLabel();
    private JLabel FG = new JLabel();
    private components.v Db = null;
    private ArrayList AE = new ArrayList();
    private ArrayList Dc = new ArrayList();
    private ImageIcon AH = new ImageIcon(this.getClass().getResource("/aicons/camisav.png"));
    private ImageIcon AI = new ImageIcon(this.getClass().getResource("/aicons/camisag40.png"));
    private ImageIcon AJ = new ImageIcon(this.getClass().getResource("/aicons/camisat40.png"));
    private ImageIcon AK = new ImageIcon(this.getClass().getResource("/aicons/camisar40.png"));
    private ImageIcon AL = this.AJ;
    private ImageIcon Dd = this.AK;
    private JButton vm;
    private JScrollPane ut;
    private JLabel Ds;
    private JLabel FH;
    private JLabel Cg;
    private JLabel Dy;
    private JLabel Dz;
    private JLabel xI;
    private JLabel DB;
    private JLabel DC;
    private JLabel zO;
    private JLabel zP;
    private JLayeredPane FI;
    private JLayeredPane FJ;
    private JTable DG;

    public dq(JDialog jDialog, components.v v2) {
        this.ub = jDialog;
        this.Db = v2;
        this.mJ();
        this.mK();
        this.nc();
        this.vm.addActionListener(new dr(this));
        this.oS();
        this.ob();
        this.oY();
        this.DB.setText(this.V(this.AE));
        this.DC.setText(this.V(this.Dc));
    }

    private String V(ArrayList arrayList) {
        int[] nArray = new int[3];
        nArray[0] = -1;
        int[] nArray2 = nArray;
        int n2 = 0;
        while (n2 < arrayList.size()) {
            if (((ao)arrayList.get(n2)).x() != null) {
                if (n2 <= 9) {
                    nArray2[0] = nArray2[0] + 1;
                } else if (n2 <= 17) {
                    nArray2[1] = nArray2[1] + 1;
                } else if (n2 <= 25) {
                    nArray2[2] = nArray2[2] + 1;
                }
            }
            ++n2;
        }
        return String.valueOf(String.valueOf(nArray2[0])) + "-" + String.valueOf(nArray2[1]) + "-" + String.valueOf(nArray2[2]);
    }

    private void ob() {
        if (this.Db.tR().dX() < aq.pb.length) {
            this.Ds.setIcon(new ImageIcon(this.getClass().getResource("/aiconsj/" + aq.pd[this.Db.tR().dX()] + ".jpg")));
        }
        if (this.Db.tR().dX() < aq.pb.length) {
            this.FH.setIcon(new ImageIcon(this.getClass().getResource("/aiconsj/" + aq.pd[this.Db.tR().dX()] + ".jpg")));
        }
    }

    private void nc() {
        int n2 = 0;
        while (n2 < this.Db.tR().hE().size()) {
            ((A)this.Db.tR().hE().get(n2)).p(true);
            ++n2;
        }
        v v2 = new v(this.Db.tR().hE());
        this.DG.setModel(v2);
        this.DG.setTableHeader(null);
        int[] nArray = new int[]{20, 180, 20};
        int n3 = 0;
        while (n3 < nArray.length) {
            this.DG.getColumnModel().getColumn(n3).setPreferredWidth(nArray[n3]);
            ++n3;
        }
        this.DG.setAutoResizeMode(3);
        this.DG.setRowHeight(20);
        this.DG.setShowGrid(false);
        this.DG.setDefaultRenderer(A.class, new as(false));
        this.DG.setAutoCreateRowSorter(false);
        this.DG.setCellSelectionEnabled(false);
        this.DG.setRowSelectionAllowed(false);
        this.DG.setBackground(this.getBackground());
        this.DG.setFillsViewportHeight(true);
    }

    private void mK() {
        this.zO.setForeground(this.Db.tR().hc().kC());
        this.zO.setBackground(this.Db.tR().hc().kB());
        this.zP.setForeground(this.Db.tR().hd().kC());
        this.zP.setBackground(this.Db.tR().hd().kB());
        if (this.Db.tR().ev() != null) {
            this.Cg.setText(this.Db.tR().ev().dS());
            this.Dy.setText(Integer.toString(this.Db.tR().hU()));
            this.Dy.setToolTipText(this.Db.tR().hV());
            this.Dz.setText(C.c(this.Db.tR().hN()));
        } else {
            if (this.Db.ik() != null) {
                this.Cg.setText(this.Db.ik());
            } else {
                this.Cg.setText("");
            }
            this.Dy.setText("n/i");
            this.Dz.setText("n/i");
        }
        this.zO.setText(String.valueOf(this.Db.tR().hc().getNome()) + " " + Integer.toString(this.Db.tR().hu()) + " ");
        this.zP.setText(" " + Integer.toString(this.Db.tR().hw()) + " " + this.Db.tR().hd().getNome());
        this.zO.setIcon(this.Db.tR().hc().kU());
        this.zP.setIcon(this.Db.tR().hd().kU());
        this.xI.setText(this.Db.tR().ha());
    }

    private void oY() {
        ao ao2;
        int n2 = 0;
        while (n2 <= 36) {
            ao2 = new ao();
            this.AE.add(ao2);
            ++n2;
        }
        n2 = 0;
        while (n2 <= 36) {
            ao2 = new ao();
            this.Dc.add(ao2);
            ++n2;
        }
        int[][] nArray = this.Db.tR().id();
        int n3 = 0;
        while (n3 < this.Db.tR().hl().size()) {
            if (this.Db.tR().hl().get(n3) != null && nArray[0][n3] > 0) {
                ((ao)this.AE.get(nArray[0][n3])).a((F)this.Db.tR().hl().get(n3));
                ((ao)this.AE.get(nArray[0][n3])).h(this.AL);
            }
            ++n3;
        }
        n3 = 0;
        while (n3 < this.Db.tR().hm().size()) {
            if (this.Db.tR().hm().get(n3) != null && nArray[1][n3] > 0) {
                ((ao)this.Dc.get(nArray[1][n3])).a((F)this.Db.tR().hm().get(n3));
                ((ao)this.Dc.get(nArray[1][n3])).h(this.Dd);
            }
            ++n3;
        }
        this.cS(-1);
    }

    private void oS() {
        this.Db.tR().hc().bV(0);
        this.AL = this.Db.tR().hc().kS();
        this.Db.tR().hd().bV(1);
        this.Dd = this.Db.tR().hd().kS();
    }

    private void cS(int n2) {
        this.a(1, this.Az, ((ao)this.AE.get(0)).a(this.AE, n2, this.AL, true, 1, null));
        this.a(2, this.FG, ((ao)this.Dc.get(0)).a(this.Dc, n2, this.Dd, true, 2, null));
    }

    public void a(int n2, JLabel jLabel, ImageIcon imageIcon) {
        jLabel.setIcon(null);
        jLabel.setIcon(imageIcon);
        int n3 = -45;
        int n4 = 0;
        if (n2 == 1) {
            this.FI.add((Component)jLabel, new a(n3, n4, -1, -1));
            this.FI.setLayer(jLabel, JLayeredPane.POPUP_LAYER);
        } else {
            this.FJ.add((Component)jLabel, new a(n3, n4, -1, -1));
            this.FJ.setLayer(jLabel, JLayeredPane.POPUP_LAYER);
        }
    }

    private void mJ() {
        this.vm = new JButton();
        this.FI = new JLayeredPane();
        this.Ds = new JLabel();
        this.FJ = new JLayeredPane();
        this.FH = new JLabel();
        this.zO = new JLabel();
        this.zP = new JLabel();
        this.DB = new JLabel();
        this.DC = new JLabel();
        this.Dz = new JLabel();
        this.Dy = new JLabel();
        this.Cg = new JLabel();
        this.ut = new JScrollPane();
        this.DG = new JTable();
        this.xI = new JLabel();
        this.setBackground(new Color(0, 51, 0));
        this.setLayout(new b());
        this.vm.setText("X");
        this.add((Component)this.vm, new a(870, 10, 50, -1));
        this.FI.setLayout(new b());
        this.Ds.setIcon(new ImageIcon(this.getClass().getResource("/aiconsj/campo_diminuido.jpg")));
        this.Ds.setAlignmentY(0.0f);
        this.Ds.setRequestFocusEnabled(false);
        this.FI.add((Component)this.Ds, new a(0, 0, 340, -1));
        this.add((Component)this.FI, new a(20, 60, 390, 566));
        this.FJ.setLayout(new b());
        this.FH.setIcon(new ImageIcon(this.getClass().getResource("/aiconsj/campo_diminuido.jpg")));
        this.FH.setAlignmentY(0.0f);
        this.FH.setRequestFocusEnabled(false);
        this.FJ.add((Component)this.FH, new a(0, 0, -1, -1));
        this.add((Component)this.FJ, new a(590, 60, 360, 566));
        this.zO.setBackground(new Color(0, 51, 204));
        this.zO.setFont(new Font("Tahoma", 1, 14));
        this.zO.setForeground(new Color(255, 255, 255));
        this.zO.setHorizontalAlignment(4);
        this.zO.setText("");
        this.zO.setOpaque(true);
        this.add((Component)this.zO, new a(110, 30, 250, 30));
        this.zP.setBackground(new Color(153, 0, 0));
        this.zP.setFont(new Font("Tahoma", 1, 14));
        this.zP.setHorizontalTextPosition(2);
        this.zP.setText("");
        this.zP.setOpaque(true);
        this.add((Component)this.zP, new a(590, 30, 250, 30));
        this.DB.setForeground(new Color(255, 255, 153));
        this.DB.setText("");
        this.add((Component)this.DB, new a(20, 40, 60, -1));
        this.DC.setForeground(new Color(255, 255, 153));
        this.DC.setHorizontalAlignment(4);
        this.DC.setText("");
        this.add((Component)this.DC, new a(850, 40, 60, -1));
        this.Dz.setForeground(new Color(255, 255, 255));
        this.Dz.setIcon(new ImageIcon(this.getClass().getResource("/aicons/iconmoney2.png")));
        this.Dz.setText("Mois\u00e9s Lucarelli");
        this.add((Component)this.Dz, new a(400, 60, 150, -1));
        this.Dy.setForeground(new Color(255, 255, 255));
        this.Dy.setIcon(new ImageIcon(this.getClass().getResource("/aicons/iconPub.png")));
        this.Dy.setText("Mois\u00e9s Lucarelli");
        this.add((Component)this.Dy, new a(400, 40, 150, -1));
        this.Cg.setForeground(new Color(255, 255, 255));
        this.Cg.setIcon(new ImageIcon(this.getClass().getResource("/aicons/estadio_iconSmall.png")));
        this.Cg.setText("Mois\u00e9s Lucarelli");
        this.add((Component)this.Cg, new a(400, 20, 150, -1));
        this.ut.setViewportView(this.DG);
        this.add((Component)this.ut, new a(370, 80, 210, 400));
        this.xI.setForeground(new Color(255, 255, 255));
        this.xI.setHorizontalAlignment(0);
        this.xI.setText("Posse de bola");
        this.add((Component)this.xI, new a(370, 490, 210, 120));
    }

    static /* synthetic */ JDialog a(dq dq2) {
        return dq2.ub;
    }
}

