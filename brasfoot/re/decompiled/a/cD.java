/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.cE;
import a.cF;
import a.cG;
import a.cH;
import a.cI;
import a.cJ;
import a.cK;
import a.cL;
import a.cM;
import a.cN;
import a.cO;
import a.cP;
import a.cQ;
import a.dV;
import b.as;
import b.d;
import b.v;
import best.A;
import best.C;
import best.F;
import best.af;
import best.ah;
import best.aq;
import best.p;
import c.a;
import components.M;
import components.ao;
import components.b;
import f.z;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;
import javax.imageio.ImageIO;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle;
import javax.swing.ToolTipManager;

public class cD
extends JPanel {
    private JLabel Ay;
    private JLabel Az = new JLabel();
    private JLabel AA = new JLabel();
    private JLabel AC;
    private ImageIcon AD;
    private JDialog ub = null;
    private components.v Db = null;
    private ArrayList AE = new ArrayList();
    private ArrayList Dc = new ArrayList();
    private ImageIcon AH = new ImageIcon(this.getClass().getResource("/aicons/camisav.png"));
    private ImageIcon AI = new ImageIcon(this.getClass().getResource("/aicons/camisag40.png"));
    private ImageIcon AJ = new ImageIcon(this.getClass().getResource("/aicons/camisat40.png"));
    private ImageIcon AK = new ImageIcon(this.getClass().getResource("/aicons/camisar40.png"));
    private ImageIcon AL = this.AJ;
    private ImageIcon Dd = this.AK;
    private int AP = -1;
    private int AQ = -1;
    private boolean AR = false;
    private boolean AS = false;
    private boolean De = false;
    private boolean Df = false;
    private int ed = dV.qj();
    private int dB = dV.en();
    private boolean Dg = false;
    private int AU = -1;
    private F Dh = null;
    final JPopupMenu AW = new JPopupMenu();
    private int Di = 1;
    private ah zu = null;
    private boolean Dj = false;
    private static Timer Dk;
    JMenuItem AZ = new JMenuItem("Falso 9");
    private JLabel Dl;
    private JButton Dm;
    private JComboBox Dn;
    private JComboBox Do;
    private JComboBox Dp;
    private JLabel ug;
    private JLabel vy;
    private JLabel vz;
    private JLabel vA;
    private JPanel vd;
    private JPanel we;
    private JScrollPane ut;
    private JLabel Dq;
    private JLabel Dr;
    private JLabel Ds;
    private JLabel Dt;
    private JLabel Cg;
    private JLabel Du;
    private JLabel Dv;
    private JLabel Dw;
    private JLabel Dx;
    private JLabel Dy;
    private JLabel Dz;
    private JLabel xI;
    private JLabel DA;
    private JLabel DB;
    private JLabel DC;
    private JLabel DD;
    private JLabel DE;
    private JLabel zO;
    private JLabel zP;
    private M DF;
    private JTable DG;
    private static BufferedImage DH;

    static {
        DH = null;
    }

    public cD(JDialog jDialog, components.v v2, boolean bl2) {
        this.ub = jDialog;
        this.Db = v2;
        this.Dg = bl2;
        this.De = v2.tR().hc().jZ();
        this.Df = v2.tR().hd().jZ();
        this.zu = v2.tR().hc();
        if (v2.tR().hd().jZ().booleanValue() && !v2.tR().hc().jZ().booleanValue()) {
            this.zu = v2.tR().hd();
            this.Di = 2;
        }
        this.mJ();
        this.mK();
        this.nc();
        this.pe();
        this.mH();
        this.oX();
        ToolTipManager.sharedInstance().registerComponent(this.DF);
        this.oS();
        this.oY();
        this.DB.setText(this.V(this.AE));
        this.DC.setText(this.V(this.Dc));
        this.ok();
        if (this.zu.jZ().booleanValue()) {
            this.Dj = true;
        }
        this.oP();
        this.oc();
        this.mY();
        if (a.SR.bD()) {
            this.oR();
        }
        this.ob();
        this.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
        this.oO();
        this.oN();
    }

    private void oN() {
        if (this.Di == 1) {
            this.DF.aa(this.AE);
        } else {
            this.DF.aa(this.Dc);
        }
    }

    private void oO() {
        if (this.Di == 1) {
            this.zO.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, new Color(37, 37, 37)));
            this.zP.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.GRAY));
        } else {
            this.zP.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, new Color(37, 37, 37)));
            this.zO.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.GRAY));
        }
    }

    private void ob() {
        if (this.Db.tR().dX() < aq.pb.length) {
            this.Ds.setIcon(new ImageIcon(this.getClass().getResource("/aicons/" + aq.pc[this.Db.tR().dX()] + ".png")));
        }
    }

    private void oP() {
        this.DA.setText("Substitui\u00e7\u00f5es restantes: " + Integer.toString(this.Db.tR().aR(this.Di - 1)));
    }

    private void oQ() {
        this.pb();
    }

    public void oR() {
        Dk = new Timer();
        Dk.schedule((TimerTask)new cE(this), 0L);
    }

    private void dc(int n2) {
        if (this.zu.jZ().booleanValue()) {
            this.pc();
        }
        this.Di = n2;
        this.zu = n2 == 1 ? this.Db.tR().hc() : this.Db.tR().hd();
        this.cS(-1);
        this.pd();
        this.Dj = this.zu.jZ() != false;
        this.pf();
        this.oP();
        this.oO();
        this.oN();
    }

    private void mY() {
        this.a(this.Dm);
        this.a(this.Ds);
        this.a(this.Do);
        this.a(this.Dp);
        this.a(this.Dn);
    }

    private void a(JComponent jComponent) {
        InputMap inputMap = jComponent.getInputMap(1);
        jComponent.getInputMap().put(KeyStroke.getKeyStroke(32, 0), "st");
        jComponent.getInputMap().put(KeyStroke.getKeyStroke(10, 0), "st");
        jComponent.getInputMap().put(KeyStroke.getKeyStroke(27, 0), "esc");
        ActionMap actionMap = this.getActionMap();
        jComponent.getActionMap().put("esc", new cJ(this));
        jComponent.getActionMap().put("st", new cK(this));
    }

    private void nc() {
        v v2 = new v(this.Db.tR().hE());
        this.DG.setModel(v2);
        this.DG.setTableHeader(null);
        int[] nArray = new int[]{20, 180, 20};
        int n2 = 0;
        while (n2 < nArray.length) {
            this.DG.getColumnModel().getColumn(n2).setPreferredWidth(nArray[n2]);
            ++n2;
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

    private void oS() {
        if (this.De) {
            this.AL = this.Db.tR().hc().kS();
        } else {
            this.Db.tR().hc().bV(0);
            this.AL = this.Db.tR().hc().kS();
        }
        if (this.Df) {
            this.Dd = this.Db.tR().hd().kS();
        } else {
            this.Db.tR().hd().bV(1);
            this.Dd = this.Db.tR().hd().kS();
        }
    }

    private void oc() {
        JMenuItem jMenuItem = new JMenuItem("Batedor de faltas");
        jMenuItem.addActionListener(new cL(this));
        this.AW.add(jMenuItem);
        this.AW.addSeparator();
        JMenuItem jMenuItem2 = new JMenuItem("Capit\u00e3o");
        jMenuItem2.addActionListener(new cM(this));
        this.AW.add(jMenuItem2);
        this.AW.addSeparator();
        JMenuItem jMenuItem3 = new JMenuItem("Batedor de escanteios");
        jMenuItem3.addActionListener(new cN(this));
        this.AW.add(jMenuItem3);
        this.AW.addSeparator();
        this.AZ.addActionListener(new cO(this));
        this.AW.add(this.AZ);
    }

    private void d(MouseEvent mouseEvent) {
        if (this.Dj) {
            this.AU = -1;
            ArrayList arrayList = this.AE;
            if (this.Di == 2) {
                arrayList = this.Dc;
            }
            M m2 = this.DF;
            if (ao.W(mouseEvent.getX(), mouseEvent.getY())) {
                this.AU = ao.T(mouseEvent.getX(), mouseEvent.getY());
                if (this.AU < 14 || this.AU == 17) {
                    this.AZ.setEnabled(false);
                } else {
                    this.AZ.setEnabled(true);
                    if (((ao)arrayList.get(this.AU)).x() == this.zu.lr()) {
                        this.AZ.setText("N\u00e3o usar falso 9");
                    } else {
                        this.AZ.setText("Falso 9");
                    }
                }
                if (this.AU > 0 && this.AU <= 25 && ((ao)arrayList.get(this.AU)).x() != null) {
                    this.Dh = ((ao)arrayList.get(this.AU)).x();
                    this.AW.show(m2, mouseEvent.getX(), mouseEvent.getY());
                }
            }
        }
    }

    private void oT() {
        this.zu.k(this.Dh);
        this.cS(-1);
    }

    private void oU() {
        this.zu.j(this.Dh);
        this.cS(-1);
    }

    private void oV() {
        this.zu.n(this.Dh);
        this.cS(-1);
    }

    private void oW() {
        if (this.zu.lr() == this.Dh) {
            this.zu.o(null);
        } else {
            this.zu.o(this.Dh);
        }
        this.cS(-1);
    }

    public void ok() {
        this.DF.addMouseListener(new cP(this));
        this.DF.addMouseMotionListener(new cQ(this));
    }

    private void a(MouseEvent mouseEvent, int n2) {
        if (this.Dj) {
            if (this.AC == null) {
                return;
            }
            this.AC.setLocation(mouseEvent.getX() - 25, mouseEvent.getY() - 25);
        }
    }

    public void X(boolean bl2) {
        this.Ay.setVisible(bl2);
    }

    public ImageIcon a(int n2, F f2) {
        if (n2 == 1) {
            return this.AI;
        }
        if (n2 > 1) {
            if (f2 != null && f2.getPosicao() == 0) {
                return this.AI;
            }
            if (f2 != null) {
                if (this.Di == 1) {
                    return this.AL;
                }
                return this.Dd;
            }
            return this.AH;
        }
        if (f2 != null) {
            if (this.Di == 1) {
                return this.AL;
            }
            return this.Dd;
        }
        return this.AH;
    }

    private void b(MouseEvent mouseEvent) {
        if (this.Dj) {
            ArrayList arrayList = this.AE;
            if (this.Di == 2) {
                arrayList = this.Dc;
            }
            if (ao.W(mouseEvent.getX(), mouseEvent.getY())) {
                this.AR = true;
                this.AP = ao.T(mouseEvent.getX(), mouseEvent.getY());
                if (this.AP > 0 && ((ao)arrayList.get(this.AP)).vf() != null) {
                    this.cS(this.AP);
                    if (this.AP > 1 && this.AP <= 25) {
                        this.X(true);
                    }
                    this.AC = null;
                    this.AC = new JLabel();
                    this.AC.setIcon(this.a(this.AP, ((ao)arrayList.get(this.AP)).x()));
                    this.AC.setLocation(mouseEvent.getX() - 25, mouseEvent.getY() + -25);
                    this.AC.setSize(this.AC.getWidth(), this.AC.getHeight());
                    this.DF.add((Component)this.AC, new components.a(mouseEvent.getX() - 25, mouseEvent.getY() - 25, 50, 50));
                    this.DF.setLayer(this.AC, JLayeredPane.DRAG_LAYER);
                }
            }
        }
    }

    private void b(MouseEvent mouseEvent, int n2) {
        if (this.Dj) {
            this.X(false);
            if (this.AC != null) {
                this.AC.setVisible(false);
                this.AC = null;
            }
            if (ao.W(mouseEvent.getX(), mouseEvent.getY())) {
                if (this.AS) {
                    this.AR = true;
                }
                this.AQ = ao.T(mouseEvent.getX(), mouseEvent.getY());
                if (this.AQ > 0 && this.AP > 0) {
                    this.H(this.AP, this.AQ);
                }
            }
            if (this.AR) {
                this.cS(-1);
                this.AR = false;
            }
        }
    }

    public void H(int n2, int n3) {
        boolean bl2 = false;
        boolean bl3 = false;
        ArrayList arrayList = this.AE;
        if (this.Di == 2) {
            arrayList = this.Dc;
        }
        if (n2 > 1 && n2 <= 25 && n3 <= 25) {
            bl2 = true;
        } else if (n2 == 1 && n3 < 25) {
            if (((ao)arrayList.get(n2)).vf() != null && ((ao)arrayList.get(n3)).vf() != null) {
                bl2 = true;
            }
        } else if (n2 <= 25 && n3 > 25) {
            if (((ao)arrayList.get(n2)).vf() != null && ((ao)arrayList.get(n3)).vf() != null) {
                bl3 = true;
            }
        } else if (n2 > 25 && n3 <= 25 && ((ao)arrayList.get(n2)).vf() != null && ((ao)arrayList.get(n3)).vf() != null) {
            bl3 = true;
        }
        if (bl3) {
            this.K(n2, n3);
        } else if (bl2) {
            Collections.swap(arrayList, n2, n3);
            if (((ao)arrayList.get(n2)).x() != null) {
                ((ao)arrayList.get(n2)).x().as(n2);
            }
            if (((ao)arrayList.get(n3)).x() != null) {
                ((ao)arrayList.get(n3)).x().as(n3);
            }
        }
    }

    private void K(int n2, int n3) {
        A a2 = null;
        ArrayList arrayList = this.AE;
        if (this.Di == 2) {
            arrayList = this.Dc;
        }
        if (this.Db.tR().aR(this.Di - 1) > 0 && ((ao)arrayList.get(n2)).x() != null && ((ao)arrayList.get(n3)).x() != null) {
            int n4 = n2;
            int n5 = n3;
            if (n2 < n3) {
                n4 = n3;
                n5 = n2;
            }
            int n6 = this.ed;
            if (this.Dg) {
                n6 = 1;
            }
            if ((a2 = this.Db.tR().a(this.Di - 1, ((ao)arrayList.get(n5)).x(), ((ao)arrayList.get(n4)).x(), this.dB, n6, -1)) != null) {
                a2.p(true);
            }
            this.DG.addNotify();
            ((ao)arrayList.get(n5)).a(((ao)arrayList.get(n4)).x());
            ((ao)arrayList.get(n4)).h(null);
            ((ao)arrayList.get(n4)).a(null);
            this.oP();
        }
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

    private void oX() {
        ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/aicons/alpha.png"));
        this.Ay = new JLabel();
        this.Ay.setIcon(imageIcon);
        this.DF.add((Component)this.Ay, new components.a(200, 0, 434, 650));
        this.DF.setLayer(this.Ay, JLayeredPane.PALETTE_LAYER);
        this.X(false);
    }

    private void cS(int n2) {
        if (this.Di == 1) {
            this.a(this.Az, ((ao)this.AE.get(0)).a(this.AE, n2, this.AL, false, 1, this.Db.tR().hc(), 2), false);
            this.a(this.AA, ((ao)this.AE.get(0)).a(this.AE, n2, this.AL, false, 1, this.Db.tR().hc(), 3), true);
        } else {
            this.a(this.Az, ((ao)this.AE.get(0)).a(this.Dc, n2, this.Dd, false, 2, this.Db.tR().hd(), 2), false);
            this.a(this.AA, ((ao)this.AE.get(0)).a(this.Dc, n2, this.Dd, false, 2, this.Db.tR().hd(), 3), true);
        }
    }

    public void a(JLabel jLabel, ImageIcon imageIcon, boolean bl2) {
        jLabel.setIcon(null);
        jLabel.setIcon(imageIcon);
        int n2 = 200;
        int n3 = 10;
        if (bl2) {
            n2 = 0;
            n3 = 0;
        }
        this.DF.add((Component)jLabel, new components.a(n2, n3, -1, -1));
        this.DF.setLayer(jLabel, JLayeredPane.POPUP_LAYER);
    }

    private void oY() {
        Object object;
        int n2 = 0;
        while (n2 <= 36) {
            object = new ao();
            this.AE.add(object);
            ++n2;
        }
        n2 = 0;
        while (n2 <= 36) {
            object = new ao();
            this.Dc.add(object);
            ++n2;
        }
        if (this.Db.tR().hc().jZ().booleanValue() || this.Db.tR().hd().jZ().booleanValue()) {
            n2 = 0;
            while (n2 < this.Db.tR().hp().size()) {
                if (this.Db.tR().hp().get(n2) != null && ((F)this.Db.tR().hp().get(n2)).fT() >= 1 && ((F)this.Db.tR().hp().get(n2)).fT() <= 25) {
                    ((ao)this.AE.get(((F)this.Db.tR().hp().get(n2)).fT())).a((F)this.Db.tR().hp().get(n2));
                    ((ao)this.AE.get(((F)this.Db.tR().hp().get(n2)).fT())).h(this.AL);
                }
                ++n2;
            }
            n2 = 0;
            while (n2 < this.Db.tR().hq().size()) {
                if (this.Db.tR().hq().get(n2) != null && ((F)this.Db.tR().hq().get(n2)).fT() >= 1 && ((F)this.Db.tR().hq().get(n2)).fT() <= 25) {
                    ((ao)this.Dc.get(((F)this.Db.tR().hq().get(n2)).fT())).a((F)this.Db.tR().hq().get(n2));
                    ((ao)this.Dc.get(((F)this.Db.tR().hq().get(n2)).fT())).h(this.Dd);
                }
                ++n2;
            }
            n2 = 26;
            int n3 = 0;
            while (n3 < this.Db.tR().hn().size()) {
                if (n2 <= 36 && this.Db.tR().hn().get(n3) != null && !this.Db.tR().hp().contains(this.Db.tR().hn().get(n3))) {
                    ((ao)this.AE.get(n2)).a((F)this.Db.tR().hn().get(n3));
                    ((ao)this.AE.get(n2)).h(this.AL);
                    ++n2;
                }
                ++n3;
            }
            n2 = 26;
            n3 = 0;
            while (n3 < this.Db.tR().ho().size()) {
                if (n2 <= 36 && this.Db.tR().ho().get(n3) != null && !this.Db.tR().hq().contains(this.Db.tR().ho().get(n3))) {
                    ((ao)this.Dc.get(n2)).a((F)this.Db.tR().ho().get(n3));
                    ((ao)this.Dc.get(n2)).h(this.Dd);
                    ++n2;
                }
                ++n3;
            }
        } else {
            n2 = 1;
            while (n2 <= 2) {
                object = this.dd(n2);
                ArrayList arrayList = this.AE;
                if (n2 == 2) {
                    arrayList = this.Dc;
                }
                int n4 = 0;
                while (n4 < ((ArrayList)object).size()) {
                    if (((ArrayList)object).get(n4) != null && ((F)((ArrayList)object).get(n4)).fT() >= 1 && ((F)((ArrayList)object).get(n4)).fT() <= 25) {
                        ((ao)arrayList.get(((F)((ArrayList)object).get(n4)).fT())).a((F)((ArrayList)object).get(n4));
                        ((ao)arrayList.get(((F)((ArrayList)object).get(n4)).fT())).h(this.AL);
                    }
                    ++n4;
                }
                n4 = 26;
                ArrayList arrayList2 = this.de(n2);
                int n5 = 0;
                while (n5 < arrayList2.size()) {
                    if (n4 <= 36 && arrayList2.get(n5) != null && !((ArrayList)object).contains(arrayList2.get(n5))) {
                        ((ao)arrayList.get(n4)).a((F)arrayList2.get(n5));
                        ((ao)arrayList.get(n4)).h(this.AL);
                        ++n4;
                    }
                    ++n5;
                }
                ++n2;
            }
        }
        this.cS(-1);
    }

    private ArrayList dd(int n2) {
        ah ah2 = this.Db.tR().hc();
        if (n2 == 2) {
            ah2 = this.Db.tR().hd();
        }
        ArrayList<F> arrayList = new ArrayList<F>();
        if (n2 == 1) {
            arrayList.addAll(this.Db.tR().hl());
        } else if (n2 == 2) {
            arrayList.addAll(this.Db.tR().hm());
        }
        int n3 = 0;
        while (n3 < this.Db.tR().hE().size()) {
            if (((A)this.Db.tR().hE().get(n3)).isDone() && ((A)this.Db.tR().hE().get(n3)).b() == 6 && ((A)this.Db.tR().hE().get(n3)).cu() == ah2) {
                arrayList.remove(((A)this.Db.tR().hE().get(n3)).eo());
                arrayList.add(((A)this.Db.tR().hE().get(n3)).ep());
            }
            ++n3;
        }
        n3 = 0;
        while (n3 < this.Db.tR().hE().size()) {
            if (((A)this.Db.tR().hE().get(n3)).isDone() && ((A)this.Db.tR().hE().get(n3)).cu() == ah2 && (((A)this.Db.tR().hE().get(n3)).b() == 3 || ((A)this.Db.tR().hE().get(n3)).b() == 4)) {
                arrayList.remove(((A)this.Db.tR().hE().get(n3)).eo());
                arrayList.add(((A)this.Db.tR().hE().get(n3)).ep());
            }
            ++n3;
        }
        return arrayList;
    }

    private ArrayList de(int n2) {
        ah ah2 = this.Db.tR().hc();
        if (n2 == 2) {
            ah2 = this.Db.tR().hd();
        }
        ArrayList arrayList = new ArrayList();
        if (n2 == 1) {
            arrayList.addAll(this.Db.tR().hn());
            arrayList.addAll(this.Db.tR().ie());
        } else if (n2 == 2) {
            arrayList.addAll(this.Db.tR().ho());
            arrayList.addAll(this.Db.tR().if());
        }
        int n3 = 0;
        while (n3 < this.Db.tR().hE().size()) {
            if (((A)this.Db.tR().hE().get(n3)).isDone() && ((A)this.Db.tR().hE().get(n3)).b() == 6 && ((A)this.Db.tR().hE().get(n3)).cu() == ah2) {
                arrayList.remove(((A)this.Db.tR().hE().get(n3)).ep());
            }
            ++n3;
        }
        Collections.sort(arrayList, h.a.abf);
        return arrayList;
    }

    private void oZ() {
        this.Dm.addActionListener(new cF(this));
    }

    private void mH() {
        this.Dm.addActionListener(new cG(this));
        cH cH2 = new cH(this);
        cI cI2 = new cI(this);
        this.zO.addMouseListener(cH2);
        this.Dw.addMouseListener(cH2);
        this.zP.addMouseListener(cI2);
        this.Dx.addMouseListener(cI2);
    }

    private void pa() {
        this.ub.dispose();
    }

    private void pb() {
        this.pc();
        this.ub.dispose();
    }

    private void pc() {
        if (this.zu.jZ().booleanValue()) {
            this.zu.kj()[1] = this.Do.getSelectedIndex();
            this.zu.kj()[2] = this.Dp.getSelectedIndex();
            this.zu.kj()[3] = this.Dn.getSelectedIndex();
        }
    }

    private void mK() {
        this.zO.setForeground(this.Db.tR().hc().kC());
        this.zO.setBackground(this.Db.tR().hc().kB());
        this.zP.setForeground(this.Db.tR().hd().kC());
        this.zP.setBackground(this.Db.tR().hd().kB());
        this.Dw.setForeground(Color.WHITE);
        this.Dw.setBackground(Color.BLACK);
        this.Dx.setForeground(Color.WHITE);
        this.Dx.setBackground(Color.BLACK);
        this.Dv.setText(String.valueOf(Integer.toString(this.ed)) + "'");
        this.DE.setText(String.valueOf(Integer.toString(this.dB)) + "\u00ba");
        if (this.Dg) {
            this.Dv.setText("I");
            this.DE.setText("");
        }
        this.Cg.setText("");
        if (this.Db.tR().ev() != null) {
            this.Cg.setText(this.Db.tR().ev().dS());
            this.Dy.setText(Integer.toString(this.Db.tR().hU()));
            this.Dy.setToolTipText(this.Db.tR().hV());
            this.Dz.setText(C.a(this.Db.tR().hN(), 0));
        } else if (this.Db.tR().il() != null) {
            this.Cg.setText(this.Db.tR().il().dS());
            this.Dz.setText(C.a(this.Db.tR().hN(), 0));
            this.Dy.setText(Integer.toString(this.Db.tR().hU()));
            this.Dy.setToolTipText(this.Db.tR().hV());
        } else {
            if (this.Db.ik() != null) {
                this.Cg.setText(this.Db.ik());
            } else if (this.Db.tR().hc().lp()) {
                this.Cg.setText(this.Db.tR().hc().getNome());
            }
            this.Dy.setText("n/i");
            this.Dz.setText("n/i");
        }
        int[] nArray = new int[]{-1, -1};
        if (this.Db.tR().ht() instanceof z && ((z)this.Db.tR().ht()).zr() == 2) {
            nArray = ((z)this.Db.tR().ht()).o(this.Db.tR());
        }
        String[] stringArray = new String[]{"", ""};
        if (nArray[0] >= 0 && nArray[1] >= 0) {
            stringArray[0] = " (" + Integer.toString(nArray[0]) + ") ";
            stringArray[1] = " (" + Integer.toString(nArray[1]) + ") ";
            this.Dl.setText("Primeiro jogo:" + Integer.toString(nArray[0]) + " x " + Integer.toString(nArray[1]));
        }
        this.zO.setText("  " + this.Db.tR().hc().getNome());
        this.zP.setText("  " + this.Db.tR().hd().getNome());
        this.Dw.setText(Integer.toString(this.Db.tT()));
        this.Dx.setText(Integer.toString(this.Db.tU()));
        this.zO.setIcon(this.Db.tR().hc().kU());
        this.zP.setIcon(this.Db.tR().hd().kU());
        if (this.Db.ei()) {
            this.xI.setText(this.Db.tR().ha());
        } else {
            this.xI.setText("");
        }
    }

    private void pd() {
        if (this.zu.ka() != null) {
            this.DD.setText("Tec:" + this.zu.ka().dS());
        } else {
            this.DD.setText("");
        }
    }

    public void pe() {
        int n2 = 0;
        while (n2 < aq.rC.length) {
            this.Do.addItem(aq.rC[n2]);
            ++n2;
        }
        this.Do.setSelectedIndex(this.zu.kj()[1]);
        n2 = 0;
        while (n2 < aq.rE.length) {
            this.Dp.addItem(aq.rE[n2]);
            ++n2;
        }
        this.Dp.setSelectedIndex(this.zu.kj()[2]);
        n2 = 0;
        while (n2 < aq.rD.length) {
            this.Dn.addItem(aq.rD[n2]);
            ++n2;
        }
        this.Dn.setSelectedIndex(this.zu.kj()[3]);
        this.pf();
    }

    private void pf() {
        if (this.zu.jZ().booleanValue()) {
            this.Dt.setVisible(false);
            this.Du.setVisible(false);
            this.Dr.setVisible(false);
            this.Do.setVisible(true);
            this.Dp.setVisible(true);
            this.Dn.setVisible(true);
            this.Do.setEnabled(true);
            this.Dp.setEnabled(true);
            this.Dn.setEnabled(true);
            this.Do.setSelectedIndex(this.zu.kj()[1]);
            this.Dp.setSelectedIndex(this.zu.kj()[2]);
            this.Dn.setSelectedIndex(this.zu.kj()[3]);
        } else {
            this.Dt.setVisible(true);
            this.Du.setVisible(true);
            this.Dr.setVisible(true);
            this.Do.setEnabled(false);
            this.Dp.setEnabled(false);
            this.Dn.setEnabled(false);
            this.Do.setVisible(false);
            this.Dp.setVisible(false);
            this.Dn.setVisible(false);
            this.Dt.setText(aq.rC[this.zu.kj()[1]]);
            this.Du.setText(aq.rE[this.zu.kj()[2]]);
            this.Dr.setText(aq.rD[this.zu.kj()[3]]);
        }
    }

    public static void pg() {
        int[] nArray = new int[6];
        String string = "";
        boolean bl2 = false;
        int n2 = 0;
        while (n2 < nArray.length) {
            int n3 = af.bE(n2);
            String string2 = Integer.toString(n3);
            String string3 = Character.toString(string2.charAt(string2.length() - 3));
            if (aq.tG[n2]) {
                string = String.valueOf(string) + Character.toString(string2.charAt(string2.length() - 3));
            }
            nArray[n2] = Integer.parseInt(string3);
            ++n2;
        }
        if (p.du() < 8) {
            d.ac(string);
        }
    }

    private void mJ() {
        this.vd = new JPanel();
        this.Dw = new JLabel();
        this.Dx = new JLabel();
        this.zO = new JLabel();
        this.zP = new JLabel();
        this.DF = new M(this.AE);
        this.DD = new JLabel();
        this.Ds = new JLabel();
        this.Dq = new JLabel();
        this.ut = new JScrollPane();
        this.DG = new JTable();
        this.Dm = new JButton();
        this.DC = new JLabel();
        this.DB = new JLabel();
        this.Do = new JComboBox();
        this.vy = new JLabel();
        this.Dp = new JComboBox();
        this.vz = new JLabel();
        this.Dn = new JComboBox();
        this.vA = new JLabel();
        this.xI = new JLabel();
        this.we = new JPanel();
        this.Dv = new JLabel();
        this.DE = new JLabel();
        this.Dz = new JLabel();
        this.Cg = new JLabel();
        this.Dy = new JLabel();
        this.DA = new JLabel();
        this.Dt = new JLabel();
        this.Du = new JLabel();
        this.Dr = new JLabel();
        this.Dl = new JLabel();
        this.ug = new JLabel();
        GroupLayout groupLayout = new GroupLayout(this.vd);
        this.vd.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 100, Short.MAX_VALUE));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 100, Short.MAX_VALUE));
        this.setBackground(new Color(0, 51, 0));
        this.setLayout(new b());
        this.Dw.setFont(new Font("Arial", 0, 18));
        this.Dw.setForeground(new Color(255, 255, 255));
        this.Dw.setHorizontalAlignment(0);
        this.Dw.setText("0");
        this.Dw.setOpaque(true);
        this.add((Component)this.Dw, new components.a(890, 10, 40, 30));
        this.Dx.setFont(new Font("Arial", 0, 18));
        this.Dx.setForeground(new Color(255, 255, 255));
        this.Dx.setHorizontalAlignment(0);
        this.Dx.setText("0");
        this.Dx.setOpaque(true);
        this.add((Component)this.Dx, new components.a(890, 90, 40, 30));
        this.zO.setBackground(new Color(0, 51, 204));
        this.zO.setFont(new Font("Tahoma", 1, 14));
        this.zO.setForeground(new Color(255, 255, 255));
        this.zO.setHorizontalAlignment(2);
        this.zO.setText("");
        this.zO.setOpaque(true);
        this.add((Component)this.zO, new components.a(640, 10, 250, 30));
        this.zP.setBackground(new Color(153, 0, 0));
        this.zP.setFont(new Font("Tahoma", 1, 14));
        this.zP.setHorizontalAlignment(2);
        this.zP.setText("");
        this.zP.setOpaque(true);
        this.add((Component)this.zP, new components.a(640, 90, 250, 30));
        this.DF.setLayout(new b());
        this.DD.setForeground(new Color(255, 255, 255));
        this.DD.setHorizontalAlignment(4);
        this.DD.setText("");
        this.DF.add((Component)this.DD, new components.a(450, 630, 170, 20));
        this.Ds.setIcon(new ImageIcon(this.getClass().getResource("/aicons/campo.png")));
        this.Ds.setAlignmentY(0.0f);
        this.Ds.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        this.Ds.setRequestFocusEnabled(false);
        this.DF.add((Component)this.Ds, new components.a(200, 0, 430, 650));
        this.Dq.setIcon(new ImageIcon(this.getClass().getResource("/aicons/campobanco1.png")));
        this.Dq.setText("labCampo");
        this.DF.add((Component)this.Dq, new components.a(0, 0, 210, 650));
        this.add((Component)this.DF, new components.a(10, 10, 630, 650));
        this.ut.setViewportView(this.DG);
        this.add((Component)this.ut, new components.a(660, 230, 270, 300));
        this.Dm.setIcon(new ImageIcon(this.getClass().getResource("/aicons/ball.png")));
        this.Dm.setText("Voltar ao jogo");
        this.add((Component)this.Dm, new components.a(710, 680, 190, 30));
        this.DC.setForeground(new Color(255, 255, 153));
        this.DC.setHorizontalAlignment(2);
        this.DC.setText("4-4-2");
        this.add((Component)this.DC, new components.a(650, 122, 60, -1));
        this.DB.setForeground(new Color(255, 255, 153));
        this.DB.setText("4-4-2");
        this.add((Component)this.DB, new components.a(650, 45, 60, -1));
        this.add((Component)this.Do, new components.a(220, 690, 130, -1));
        this.vy.setForeground(new Color(255, 255, 255));
        this.vy.setText("Estilo de jogo:");
        this.add((Component)this.vy, new components.a(220, 670, -1, -1));
        this.add((Component)this.Dp, new components.a(365, 690, 130, -1));
        this.vz.setForeground(new Color(255, 255, 255));
        this.vz.setText("Marca\u00e7\u00e3o:");
        this.add((Component)this.vz, new components.a(365, 670, -1, -1));
        this.add((Component)this.Dn, new components.a(510, 690, 130, -1));
        this.vA.setForeground(new Color(255, 255, 255));
        this.vA.setText("Concentrar ataques:");
        this.add((Component)this.vA, new components.a(510, 670, -1, -1));
        this.xI.setForeground(new Color(255, 255, 255));
        this.xI.setHorizontalAlignment(0);
        this.xI.setText("Posse de bola");
        this.add((Component)this.xI, new components.a(690, 540, 210, 120));
        this.we.setBackground(new Color(0, 0, 0));
        this.we.setPreferredSize(new Dimension(65, 50));
        this.Dv.setFont(new Font("Tahoma", 1, 18));
        this.Dv.setForeground(new Color(255, 255, 255));
        this.Dv.setHorizontalAlignment(0);
        this.Dv.setText("46'");
        this.DE.setForeground(new Color(255, 255, 255));
        this.DE.setHorizontalAlignment(0);
        this.DE.setText("1\u00ba");
        GroupLayout groupLayout2 = new GroupLayout(this.we);
        this.we.setLayout(groupLayout2);
        groupLayout2.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.DE, GroupLayout.Alignment.TRAILING, -1, -1, Short.MAX_VALUE).addComponent(this.Dv, GroupLayout.Alignment.TRAILING, -1, 50, Short.MAX_VALUE));
        groupLayout2.setVerticalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addComponent(this.Dv, -2, 30, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.DE).addGap(0, 10, Short.MAX_VALUE)));
        this.add((Component)this.we, new components.a(660, 160, 50, 60));
        this.Dz.setForeground(new Color(255, 255, 255));
        this.Dz.setIcon(new ImageIcon(this.getClass().getResource("/aicons/iconmoney2.png")));
        this.Dz.setText("256 mil");
        this.add((Component)this.Dz, new components.a(820, 200, 100, -1));
        this.Cg.setForeground(new Color(255, 255, 255));
        this.Cg.setIcon(new ImageIcon(this.getClass().getResource("/aicons/estadio_iconSmall.png")));
        this.Cg.setText("Mois\u00e9s Lucarelli");
        this.add((Component)this.Cg, new components.a(720, 170, 150, -1));
        this.Dy.setForeground(new Color(255, 255, 255));
        this.Dy.setIcon(new ImageIcon(this.getClass().getResource("/aicons/n02.png")));
        this.Dy.setText("120 000");
        this.Dy.setToolTipText("");
        this.add((Component)this.Dy, new components.a(720, 200, 80, -1));
        this.DA.setForeground(new Color(255, 255, 153));
        this.DA.setText("Substitui\u00e7\u00f5es restantes: 5");
        this.add((Component)this.DA, new components.a(10, 670, 200, -1));
        this.Dt.setForeground(new Color(255, 255, 204));
        this.Dt.setText("jLabel2");
        this.add((Component)this.Dt, new components.a(220, 690, 130, -1));
        this.Du.setForeground(new Color(255, 255, 204));
        this.Du.setText("jLabel2");
        this.add((Component)this.Du, new components.a(365, 690, 130, -1));
        this.Dr.setForeground(new Color(255, 255, 204));
        this.Dr.setText("jLabel2");
        this.add((Component)this.Dr, new components.a(510, 690, 130, -1));
        this.Dl.setForeground(new Color(255, 255, 255));
        this.Dl.setHorizontalAlignment(0);
        this.add((Component)this.Dl, new components.a(664, 140, 260, -1));
        this.ug.setIcon(new ImageIcon(this.getClass().getResource("/aiconsj/fundosemi.png")));
        this.ug.setToolTipText("");
        this.add((Component)this.ug, new components.a(710, 160, 220, 60));
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        try {
            DH = ImageIO.read(new File(String.valueOf(System.getProperty("user.dir")) + "/img/f02.jpg"));
        }
        catch (IOException iOException) {
            // empty catch block
        }
        Dimension dimension = this.getSize();
        super.paintComponent(graphics);
        graphics.drawImage(DH, 0, 0, dimension.width, dimension.height, null);
    }

    static /* synthetic */ Timer ph() {
        return Dk;
    }

    static /* synthetic */ void a(cD cD2) {
        cD2.oQ();
    }

    static /* synthetic */ void b(cD cD2) {
        cD2.pb();
    }

    static /* synthetic */ void c(cD cD2) {
        cD2.oT();
    }

    static /* synthetic */ void d(cD cD2) {
        cD2.oU();
    }

    static /* synthetic */ void e(cD cD2) {
        cD2.oV();
    }

    static /* synthetic */ void f(cD cD2) {
        cD2.oW();
    }

    static /* synthetic */ void a(cD cD2, MouseEvent mouseEvent) {
        cD2.d(mouseEvent);
    }

    static /* synthetic */ void b(cD cD2, MouseEvent mouseEvent) {
        cD2.b(mouseEvent);
    }

    static /* synthetic */ void a(cD cD2, MouseEvent mouseEvent, int n2) {
        cD2.b(mouseEvent, n2);
    }

    static /* synthetic */ void b(cD cD2, MouseEvent mouseEvent, int n2) {
        cD2.a(mouseEvent, n2);
    }

    static /* synthetic */ void g(cD cD2) {
        cD2.pa();
    }

    static /* synthetic */ void a(cD cD2, int n2) {
        cD2.dc(n2);
    }
}

