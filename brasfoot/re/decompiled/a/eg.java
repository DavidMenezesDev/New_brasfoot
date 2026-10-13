/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.H;
import a.L;
import a.R;
import a.aL;
import a.bb;
import a.bn;
import a.bs;
import a.bz;
import a.cW;
import a.ce;
import a.cl;
import a.ds;
import a.dz;
import a.eA;
import a.eB;
import a.eC;
import a.eD;
import a.eE;
import a.eF;
import a.eG;
import a.eH;
import a.eI;
import a.eJ;
import a.eK;
import a.eL;
import a.eM;
import a.eN;
import a.eO;
import a.eP;
import a.eQ;
import a.eR;
import a.eS;
import a.eT;
import a.eU;
import a.eV;
import a.eW;
import a.eX;
import a.eY;
import a.eZ;
import a.eh;
import a.ei;
import a.ej;
import a.ek;
import a.el;
import a.em;
import a.en;
import a.eo;
import a.ep;
import a.eq;
import a.er;
import a.es;
import a.et;
import a.eu;
import a.ev;
import a.ew;
import a.ex;
import a.ey;
import a.ez;
import a.fa;
import a.fb;
import a.fc;
import a.fd;
import a.fe;
import a.ff;
import a.fg;
import a.fh;
import a.fi;
import a.fj;
import a.fk;
import a.fl;
import a.fm;
import a.fn;
import a.fo;
import a.fp;
import a.fq;
import a.fr;
import a.fs;
import a.ft;
import a.fu;
import a.fv;
import a.fw;
import a.fy;
import a.gX;
import a.gx;
import a.hC;
import a.hc;
import a.hw;
import a.iQ;
import a.iV;
import a.iW;
import a.ip;
import a.jc;
import a.ji;
import a.jm;
import a.jp;
import a.jr;
import a.js;
import a.jt;
import a.jv;
import a.o;
import a.y;
import b.Q;
import b.aH;
import best.C;
import best.F;
import best.I;
import best.N;
import best.S;
import best.Z;
import best.ah;
import best.al;
import best.at;
import best.f;
import best.h2;
import best.l;
import components.as;
import components.m;
import components.t;
import f.s;
import f.z;
import h.a;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class eg
extends JPanel {
    private ah zu = null;
    private F uz = null;
    private ah Hv = null;
    private I bv = null;
    private int AT = 0;
    private boolean Hw = false;
    private JPopupMenu Hx = new JPopupMenu();
    private JPopupMenu afi = new JPopupMenu();
    final JPopupMenu Hy = new JPopupMenu();
    final JPopupMenu Hz = new JPopupMenu();
    final JPopupMenu HA = new JPopupMenu();
    final JPopupMenu HB = new JPopupMenu();
    JMenuItem HC = new JMenuItem("Propor contrato");
    JMenuItem HD = new JMenuItem("Vender Jogador");
    JMenuItem HE = new JMenuItem("Aposentar Jogador");
    JMenuItem HF = new JMenuItem("Escolher n\u00famero");
    JMenuItem HG = new JMenuItem("Hist\u00f3rico do jogador");
    JMenuItem HH = new JMenuItem("Cancelar empr\u00e9stimo");
    JMenuItem HI = new JMenuItem("Comprar jogador");
    JMenuItem HJ = new JMenuItem("P\u00f4r para empr\u00e9stimo");
    private JFrame Br;
    private int tR = 0;
    private boolean yp = false;
    private boolean HK = false;
    private static boolean afj = false;
    private static boolean afk = false;
    private static double HL = 0.1;
    private static Color HM = null;
    private static boolean HN = false;
    private static at HO = null;
    private static boolean HP = false;
    private static int HQ = 0;
    private JButton HR;
    private JButton HS;
    private JButton HT;
    private JButton HU;
    private JButton HV;
    private JButton HW;
    private JButton HX;
    private JButton yY;
    private JButton HY;
    private JButton afl;
    private JButton HZ;
    private JButton Ia;
    private JButton Ib;
    private JButton Ic;
    private JButton Id;
    private JButton Ie;
    private m If;
    private JLabel ug;
    private JLabel Bj;
    private JLabel vw;
    private JLabel zb;
    private JLabel ze;
    private JLabel Ef;
    private JLabel Eg;
    private JLabel Eh;
    private JLabel uh;
    private JLabel a_;
    private JLabel ur;
    private JLabel us;
    private JLabel vz;
    private JPanel wf;
    private JProgressBar Hf;
    private JProgressBar Ig;
    private JToolBar.Separator Ih;
    private JToolBar.Separator Ii;
    private JToolBar.Separator Ij;
    private JToolBar.Separator Ik;
    private JToolBar.Separator Il;
    private JToolBar.Separator OD;
    private JToolBar.Separator Im;
    private JToolBar.Separator In;
    private JToolBar.Separator Io;
    private JToolBar.Separator Ip;
    private JToolBar.Separator Iq;
    private JToolBar.Separator Ir;
    private JToolBar.Separator Is;
    private JToolBar.Separator It;
    private JToolBar.Separator Iu;
    private JToolBar ve;
    private JToolBar Iv;
    private JLabel Fq;
    private JLabel yt;
    private JLabel Iw;
    private JScrollPane Ix;
    private JTable Iy;

    public ah qp() {
        return this.zu;
    }

    public static double qq() {
        return HL;
    }

    public eg(JFrame jFrame) {
        this.Br = jFrame;
        this.zu = f.B();
        UIManager.put("ProgressBar.selectionForeground", this.zu.kC());
        UIManager.put("ProgressBar.selectionBackground", Color.black);
        this.bv = c.a.SR.bl();
        this.tR = this.bv.hy().b();
        HM = this.zu.kB();
        if (this.bv != null) {
            if (this.bv.hc() == this.zu) {
                this.Hv = this.bv.hd();
                this.AT = 0;
            } else {
                this.Hv = this.bv.hc();
                this.AT = 1;
            }
            if (this.tR == 7) {
                this.HK = true;
                this.yp = true;
            }
            this.Hw = this.bv.ic();
        }
        this.zu.ka().jo();
        if (this.zu.ka().jo() == this.zu) {
            this.yp = true;
        }
        if (this.yp) {
            int n2 = 0;
            while (n2 < this.zu.kc().size()) {
                ((F)this.zu.kc().get(n2)).b((JProgressBar)null);
                ++n2;
            }
        }
        HN = this.yp;
        this.ry();
        this.mJ();
        this.rz();
        Float f2 = Float.valueOf(0.2f);
        this.qs();
        this.qz();
        if (!this.yp) {
            this.qr();
        }
        if (this.yp) {
            this.Ie.setVisible(false);
            this.HY.setVisible(false);
            this.Ic.setVisible(false);
        }
        this.qv();
        this.qA();
        this.qB();
        this.AL();
        this.AM();
        this.rb();
        this.qD();
        this.mH();
        if (!c.a.SR.isHabilidadeIndividual() || this.yp) {
            this.Id.setVisible(false);
        }
        if (this.yp) {
            this.Iw.setVisible(false);
            this.ze.setVisible(false);
            this.HW.setVisible(false);
            this.HV.setVisible(false);
            this.ur.setVisible(false);
            this.us.setVisible(false);
            this.Hf.setVisible(false);
            this.Ig.setVisible(false);
        }
        this.mY();
        if (c.a.vL()) {
            this.Eh.setVisible(false);
        }
        if (!HP) {
            if (HQ > 10) {
                HP = true;
                h2.ml();
            } else {
                ++HQ;
            }
        }
    }

    private void mY() {
        this.a(this);
        this.a(this.Iy);
        this.a(this.HU);
        this.a(this.ve);
    }

    private void a(JComponent jComponent) {
        InputMap inputMap = jComponent.getInputMap(1);
        jComponent.getInputMap().put(KeyStroke.getKeyStroke(10, 0), "enter");
        jComponent.getInputMap().put(KeyStroke.getKeyStroke(32, 0), "enter");
        jComponent.getInputMap().put(KeyStroke.getKeyStroke(113, 0), "f2");
        jComponent.getInputMap().put(KeyStroke.getKeyStroke(114, 0), "f3");
        jComponent.getInputMap().put(KeyStroke.getKeyStroke(115, 0), "f4");
        jComponent.getInputMap().put(KeyStroke.getKeyStroke(117, 0), "f6");
        jComponent.getInputMap().put(KeyStroke.getKeyStroke(116, 0), "ctrlt");
        jComponent.getInputMap().put(KeyStroke.getKeyStroke(118, 0), "f7");
        jComponent.getInputMap().put(KeyStroke.getKeyStroke(119, 0), "f8");
        jComponent.getInputMap().put(KeyStroke.getKeyStroke(120, 0), "f9");
        jComponent.getInputMap().put(KeyStroke.getKeyStroke(121, 0), "f10");
        jComponent.getInputMap().put(KeyStroke.getKeyStroke(122, 0), "f11");
        jComponent.getInputMap().put(KeyStroke.getKeyStroke(84, 128, false), "ctrlt");
        jComponent.getInputMap().put(KeyStroke.getKeyStroke(70, 128, false), "ctrlf");
        ActionMap actionMap = this.getActionMap();
        jComponent.getActionMap().put("enter", new eh(this));
        jComponent.getActionMap().put("f2", new es(this));
        jComponent.getActionMap().put("ctrlt", new eD(this));
        jComponent.getActionMap().put("ctrlf", new eO(this));
        jComponent.getActionMap().put("f3", new eZ(this));
        jComponent.getActionMap().put("f4", new fk(this));
        jComponent.getActionMap().put("f6", new ft(this));
        jComponent.getActionMap().put("f7", new fu(this));
        jComponent.getActionMap().put("f8", new fv(this));
        jComponent.getActionMap().put("f9", new ei(this));
        jComponent.getActionMap().put("f10", new ej(this));
        jComponent.getActionMap().put("f11", new ek(this));
    }

    public boolean ac(boolean bl2) {
        int n2;
        int n3;
        ArrayList<F> arrayList = null;
        arrayList = new ArrayList<F>();
        if (bl2 && (n3 = this.zu.kr()) <= 0) {
            return false;
        }
        n3 = -1;
        if (!bl2) {
            n2 = 0;
            while (n2 < this.zu.kc().size()) {
                if (!((F)this.zu.kc().get(n2)).gl().booleanValue()) {
                    arrayList.add((F)this.zu.kc().get(n2));
                }
                ++n2;
            }
            Collections.shuffle(arrayList);
            n3 = new Random().nextInt(arrayList.size());
        } else {
            n2 = 0;
            while (n2 < this.zu.kc().size()) {
                if (!((F)this.zu.kc().get(n2)).gl().booleanValue() && ((F)this.zu.kc().get(n2)).fz().booleanValue()) {
                    arrayList.add((F)this.zu.kc().get(n2));
                }
                ++n2;
            }
            Collections.shuffle(arrayList);
            n3 = new Random().nextInt(arrayList.size());
        }
        F f2 = null;
        f2 = (F)arrayList.get(n3);
        if (f2 != null) {
            l l2 = new l(f2, f2.fk(), true, true, 0);
            ah ah2 = l2.a(true, bl2);
            int n4 = (int)((long)f2.fk() + Math.round((double)f2.fk() * 0.3));
            if (ah2 != null) {
                JDialog jDialog = new JDialog(this.Br);
                jm jm2 = new jm(jDialog, f2, ah2, n4, bl2);
                jDialog.add(jm2);
                jDialog.setSize(403, 440);
                jDialog.setPreferredSize(new Dimension(403, 440));
                jDialog.setModal(true);
                jDialog.setResizable(false);
                jDialog.setLocationRelativeTo(null);
                jDialog.setUndecorated(true);
                jDialog.setVisible(true);
                if (jm.sO()) {
                    this.qI();
                    this.qJ();
                    this.pK();
                    this.qH();
                }
            }
        }
        return true;
    }

    private void qr() {
        block9: {
            int n2;
            block8: {
                n2 = 0;
                while (n2 < this.zu.kc().size()) {
                    ((F)this.zu.kc().get(n2)).aB(((F)this.zu.kc().get(n2)).fR());
                    ++n2;
                }
                if (c.a.SR.isAutoRenovaContrato()) {
                    n2 = 0;
                    while (n2 < this.zu.kc().size()) {
                        if (((F)this.zu.kc().get(n2)).fR() <= 0) {
                            ((F)this.zu.kc().get(n2)).a(180L, true);
                        }
                        ++n2;
                    }
                }
                if (c.a.SR.getAvisoTerminoContrato() != 1 || c.a.SR.isAutoRenovaContrato()) break block8;
                n2 = 0;
                while (n2 < this.zu.kc().size()) {
                    if (((F)this.zu.kc().get(n2)).fR() <= 0) {
                        new as(this.zu.ka(), 17, 67, ((F)this.zu.kc().get(n2)).getNome(), "");
                    }
                    ++n2;
                }
                break block9;
            }
            if (c.a.SR.getAvisoTerminoContrato() != 2) break block9;
            n2 = 0;
            while (n2 < this.zu.kc().size()) {
                if (!((F)this.zu.kc().get(n2)).gQ() && ((F)this.zu.kc().get(n2)).fR() < 31) {
                    ((F)this.zu.kc().get(n2)).r(true);
                    new as(this.zu.ka(), 16, 66, ((F)this.zu.kc().get(n2)).getNome(), "");
                }
                ++n2;
            }
        }
    }

    private void qs() {
        HL = 0.1;
        if (new Random().nextInt(100) > 80) {
            HL = 0.15;
        }
    }

    public void s(F f2) {
        this.uz = f2;
        this.qt();
    }

    private void qt() {
        if (this.uz != null && this.bv != null) {
            String string;
            at at2 = this.bv.hy();
            eg.w(at2);
            this.If.a(this.uz, this.bv, at2, this.yp);
            ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/aflags/" + this.uz.getPais() + ".png"));
            String string2 = "";
            String string3 = this.uz.fQ();
            String string4 = "Contrato at\u00e9:";
            if (this.uz.gl().booleanValue()) {
                string4 = "Emprestado at\u00e9:";
            }
            if (this.uz.fP() && this.uz.fo() > ((best.a)c.a.SR.R().get(c.a.SR.J())).a().getTime().getTime()) {
                string2 = "Fim contus\u00e3o: " + best.a.a(this.uz.fo());
            }
            int[] nArray = this.uz.e(this.bv.hy());
            int[] nArray2 = new int[6];
            nArray2 = this.uz.gw();
            if (nArray == null) {
                nArray = new int[2];
            }
            String string5 = "";
            if (this.uz.c(at2)) {
                string = "";
                if (nArray[0] >= 3) {
                    string = "3 cart\u00f5es amarelos";
                }
                if (nArray[1] == 1) {
                    string = "1 jogo";
                } else if (nArray[1] > 1) {
                    string = String.valueOf(Integer.toString(nArray[1])) + " jogos";
                }
                string5 = "Suspenso " + string;
            }
            string = "<html>\n<body><p style=\\\"padding:5; font-size:12\\\">\n<b>For\u00e7a:</b>&nbsp;" + Integer.toString(this.uz.fi()) + "&nbsp;&nbsp;&nbsp;";
            if (c.a.SR.isHabilidadeIndividual()) {
                string = "<html>\n<body><p style=\\\"padding:5; font-size:12\\\"><b>Goleiro:</b> " + Integer.toString(this.uz.gK()) + " <b>Desarme:</b> " + Integer.toString(this.uz.gN()) + " <b>Passe:</b> " + Integer.toString(this.uz.gM()) + " <br><br><b>Arma\u00e7\u00e3o:</b> " + Integer.toString(this.uz.gO()) + " <b>Finaliza\u00e7\u00e3o:</b> " + Integer.toString(this.uz.gP()) + "<br><br><b>Velocidade:</b> " + Integer.toString(this.uz.gJ()) + " <b>T\u00e9cnica:</b> " + Integer.toString(this.uz.gL());
            }
            if (this.yp) {
                string4 = "";
                string3 = "";
            }
            String string6 = String.valueOf(string) + "<br>\n</p>\n<p style=\\\"padding:5; font-size:12\\\">\n" + "<b>Jogos:" + "</b>&nbsp;" + Integer.toString(nArray2[0]) + "&nbsp;&nbsp;&nbsp;" + "<b>Gols:" + "</b>" + Integer.toString(nArray2[1]) + "&nbsp;&nbsp;&nbsp;" + "<b><br><br>" + "<b>Assist\u00eancias:" + "</b>" + Integer.toString(nArray2[5]) + "&nbsp;&nbsp;&nbsp;" + "<b>" + "&nbsp;&nbsp;&nbsp;" + "</b><br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n<b>Valor:" + "</b>&nbsp;" + C.c(this.uz.fk()) + "<br>\n</p>\n<p style=\\\"padding:5; font-size:12\\\">\n<b>" + "Sal\u00e1rio:" + "</b>&nbsp;" + C.c(this.uz.fj()) + "<br>\n</p>\n<p style=\\\"padding:5; font-size:12\\\">\n" + "<b>" + string2 + " " + string5 + "<br><b>" + string4 + " " + string3 + "<b></b>&nbsp; <br>\n</p>\n<p style=\\\"padding:5; font-size:20\\\">\n" + "<b><br>\n</p>\n</body></html>\n";
            this.If.h(2, true);
            this.If.h(3, true);
            this.If.h(4, true);
            this.HC.setEnabled(true);
            this.HD.setEnabled(true);
            if (this.uz.getIdade() > 32) {
                this.If.h(4, true);
                this.HE.setEnabled(true);
            } else {
                this.If.h(4, false);
                this.HE.setEnabled(false);
            }
            if (this.uz.gl().booleanValue() || this.yp) {
                this.If.h(1, false);
                this.If.h(2, false);
                this.If.h(3, false);
                this.If.h(4, false);
                this.HC.setEnabled(false);
                this.HD.setEnabled(false);
                this.HE.setEnabled(false);
                this.HH.setEnabled(true);
                this.HI.setEnabled(true);
                this.HJ.setEnabled(false);
            } else {
                this.HH.setEnabled(false);
                this.HI.setEnabled(false);
                this.HJ.setEnabled(true);
                if (this.uz.fz().booleanValue()) {
                    this.HJ.setText("N\u00e3o p\u00f4r para empr\u00e9stimo");
                } else {
                    this.HJ.setText("P\u00f4r para empr\u00e9stimo");
                }
            }
            if (this.yp) {
                this.HH.setEnabled(false);
                this.HI.setEnabled(false);
            }
            if (this.uz.ft().booleanValue()) {
                this.If.h(1, true);
                this.If.g(1, true);
            } else {
                this.If.h(1, false);
                this.If.g(1, false);
            }
        }
    }

    private void qu() {
        this.setBackground(this.zu.kB());
        UIManager.put("ProgressBar.selectionForeground", this.zu.kC());
        UIManager.put("ProgressBar.selectionBackground", Color.black);
        HM = this.zu.kB();
        this.wf.setBackground(this.zu.kB());
        this.Hf.setForeground(this.zu.kB());
        this.Ig.setForeground(this.zu.kB());
        this.Hf.setBorder(BorderFactory.createLineBorder(this.zu.kC(), 1));
        this.Ig.setBorder(BorderFactory.createLineBorder(this.zu.kC(), 1));
        this.Iv.setBackground(this.qp().kB());
        this.a_.setForeground(this.zu.kC());
        this.uh.setForeground(this.zu.kC());
        this.ur.setForeground(this.zu.kC());
        this.us.setForeground(this.zu.kC());
        this.vz.setForeground(this.zu.kB());
        this.vz.setBackground(this.zu.kC());
        this.vw.setForeground(this.zu.kC());
        this.Bj.setForeground(this.zu.kC());
        this.ug.setForeground(this.zu.kC());
        this.Ef.setForeground(this.zu.kC());
        this.Iw.setForeground(this.zu.kC());
        this.ze.setForeground(this.zu.kC());
        this.Eh.setForeground(this.zu.kC());
        this.If.setBorder(BorderFactory.createLineBorder(this.zu.kC()));
        this.If.oJ();
        this.Hf.setValue(this.zu.ka().lL());
        this.Ig.setValue(this.zu.ka().lM());
    }

    public void qv() {
        String string;
        this.qu();
        this.ur.setFont(new Font("Tahoma", 1, 11));
        this.us.setFont(new Font("Tahoma", 1, 11));
        if (this.bv.hy() != null) {
            string = "";
            if (this.bv.ht() instanceof s && ((s)this.bv.ht()).zb() > 1) {
                int n2 = 0;
                n2 = ((s)this.bv.ht()).Q(this.zu);
                if (n2 > 0) {
                    string = " - " + Integer.toString(n2) + "\u00ba lugar";
                }
            }
            this.Bj.setText(this.bv.hI());
            if (this.bv.hy() != null && this.bv.ht() != null && this.bv.hy().b() == 1 && this.bv.ht() instanceof z) {
                if (((z)this.bv.ht()).zf() == 1099) {
                    this.Bj.setText("Mata Mata Ascenso - " + this.bv.hJ()[1]);
                } else if (((z)this.bv.ht()).zf() == 1098) {
                    this.Bj.setText("Playoff rebaixamento - " + this.bv.hJ()[1]);
                }
            }
            this.uh.setText(String.valueOf(this.bv.hy().getNome()) + string);
        } else {
            this.uh.setText("");
            this.Bj.setText("");
        }
        this.ug.setText(this.zu.getNome());
        this.a_.setText(this.zu.ka().dS());
        this.ze.setText("Mensagens");
        this.Hf.setValue(this.zu.ka().lL());
        this.Ig.setValue(this.zu.ka().lM());
        this.Eg.setText(c.a.SR.T());
        if (!this.yp) {
            this.Fq.setIcon(this.zu.kP());
        } else {
            this.Fq.setIcon(this.zu.K(true));
        }
        this.vw.setIcon(null);
        string = "";
        if (this.Hw) {
            string = " - cl\u00e1ssico";
        }
        if (this.Hv != null) {
            String string2 = "";
            if (this.bv.ht() instanceof s && ((s)this.bv.ht()).zb() > 1) {
                int n3 = 0;
                n3 = ((s)this.bv.ht()).Q(this.Hv);
                if (n3 > 0) {
                    string2 = "(" + Integer.toString(n3) + "\u00ba)";
                }
            }
            String string3 = " - Casa";
            if (this.AT == 1) {
                string3 = " - Fora";
            }
            if (!this.yp) {
                this.yt.setIcon(this.Hv.kP());
            } else {
                this.yt.setIcon(this.Hv.K(true));
            }
            if (this.bv.ev() == null) {
                string3 = !this.yp ? " (campo neutro)" : "";
            }
            this.vw.setText(String.valueOf(this.Hv.getNome()) + " " + string2);
            this.vz.setText("Pr\u00f3ximo Jogo" + string3 + string);
        }
        this.qy();
        this.qw();
        this.qJ();
    }

    private void qw() {
        int n2 = 0;
        this.ze.setText("");
        if (this.zu.ka().lQ() != null) {
            int n3 = 0;
            while (n3 < this.zu.ka().lQ().size()) {
                if (!((as)this.zu.ka().lQ().get(n3)).vo()) {
                    ++n2;
                }
                ++n3;
            }
            String string = "Sem novas mensagens";
            if (n2 == 1) {
                string = "1 mensagens n\u00e3o lida";
            } else if (n2 > 1) {
                string = String.valueOf(Integer.toString(n2)) + " mensagens n\u00e3o lidas";
            }
            string = Integer.toString(n2);
            this.ze.setText(string);
        }
    }

    private void qx() {
        this.Iw.setText(C.c(this.zu.kb()));
    }

    private void qy() {
        if (c.a.SR.bs() != null) {
            String string = this.AT == 0 ? "C - " : "F - ";
            c.a.SR.bs().setTc(this.zu.ka().dS());
            c.a.SR.bs().setN(this.zu.getNome());
            c.a.SR.bs().setA(c.a.SR.H() + c.a.SR.iU());
            c.a.SR.bs().setI(String.valueOf(string) + this.Hv.getNome() + " - " + this.Bj.getText());
        }
    }

    public void pK() {
        if (!this.yp) {
            this.Ef.setText(String.valueOf(Integer.toString(this.zu.kc().size())) + "/" + Integer.toString(35));
        } else {
            this.Ef.setText(Integer.toString(this.zu.kc().size()));
        }
    }

    public void qz() {
        this.Iw.setCursor(new Cursor(12));
    }

    public void qA() {
        Q q2 = new Q(this.zu, this);
        this.Iy.setModel(q2);
        int[] nArray = new int[]{20, 20, 20, 110, 20, 20, 60, 50, 50, 20, 45, 22, 20, 20, 25};
        int[] nArray2 = new int[]{20, 20, 20, 110, 20, 20, 20, 20, 20, 20, 20, 20, 60, 50, 50, 20, 45, 22, 20, 20, 25};
        if (c.a.SR.isHabilidadeIndividual()) {
            nArray = nArray2;
        }
        int n2 = 0;
        while (n2 < nArray.length) {
            this.Iy.getColumnModel().getColumn(n2).setPreferredWidth(nArray[n2]);
            ++n2;
        }
        this.Iy.getColumnModel().getColumn(0).setMaxWidth(20);
        this.Iy.getColumnModel().getColumn(1).setMaxWidth(20);
        this.Iy.getColumnModel().getColumn(2).setMaxWidth(40);
        n2 = 3;
        while (n2 < nArray.length) {
            this.Iy.getColumnModel().getColumn(n2).setMaxWidth(nArray[n2] + 15);
            ++n2;
        }
        this.Iy.setAutoResizeMode(3);
        this.Iy.setRowHeight(20);
        this.Iy.setShowGrid(false);
        this.Iy.setDefaultRenderer(F.class, new aH());
        this.Iy.setAutoCreateRowSorter(false);
        this.Iy.getTableHeader().setReorderingAllowed(false);
        this.Iy.setRowHeight(20);
        this.Iy.setCellSelectionEnabled(false);
        this.Iy.setSelectionMode(0);
        this.Iy.setRowSelectionAllowed(true);
        this.Iy.setSelectionBackground(Color.YELLOW);
        this.Iy.setFillsViewportHeight(true);
        if (this.Iy.getRowCount() > 0) {
            this.Iy.setRowSelectionInterval(0, 0);
        }
        TableRowSorter<TableModel> tableRowSorter = new TableRowSorter<TableModel>(this.Iy.getModel());
        this.Iy.setRowSorter(tableRowSorter);
        tableRowSorter.setComparator(0, a.aaR);
        tableRowSorter.setComparator(1, a.abe);
        tableRowSorter.setComparator(3, a.abk);
        tableRowSorter.setComparator(4, a.aba);
        if (!c.a.SR.isHabilidadeIndividual()) {
            tableRowSorter.setComparator(5, a.aaJ);
            tableRowSorter.setComparator(6, a.aaS);
            tableRowSorter.setComparator(7, a.aaZ);
            tableRowSorter.setComparator(8, a.aaW);
            tableRowSorter.setComparator(9, a.abb);
            tableRowSorter.setComparator(11, a.VU);
            tableRowSorter.setComparator(12, a.abd);
            tableRowSorter.setComparator(13, a.abc);
            tableRowSorter.setComparator(14, a.aab);
        } else {
            tableRowSorter.setComparator(5, a.aaK);
            tableRowSorter.setComparator(6, a.aaM);
            tableRowSorter.setComparator(7, a.aaL);
            tableRowSorter.setComparator(8, a.aaN);
            tableRowSorter.setComparator(9, a.aaP);
            tableRowSorter.setComparator(10, a.aaO);
            tableRowSorter.setComparator(11, a.aaQ);
            tableRowSorter.setComparator(12, a.aaS);
            tableRowSorter.setComparator(13, a.aaZ);
            tableRowSorter.setComparator(14, a.aaW);
            tableRowSorter.setComparator(15, a.abb);
            tableRowSorter.setComparator(17, a.VU);
            tableRowSorter.setComparator(18, a.abd);
            tableRowSorter.setComparator(19, a.abc);
            tableRowSorter.setComparator(20, a.aab);
        }
    }

    private void qB() {
        this.Iy.getSelectionModel().addListSelectionListener(new el(this));
        this.Iy.addMouseListener(new em(this));
    }

    public void qC() {
        this.setCursor(new Cursor(3));
        S.a(this.uz, null);
        this.setCursor(new Cursor(12));
    }

    public void qD() {
        this.HC.addActionListener(new en(this));
        this.HB.add(this.HC);
        this.HB.addSeparator();
        this.HD.addActionListener(new eo(this));
        this.HB.add(this.HD);
        this.HE.addActionListener(new ep(this));
        this.HB.add(this.HE);
        this.HB.addSeparator();
        this.HF.addActionListener(new eq(this));
        this.HB.add(this.HF);
        this.HB.addSeparator();
        this.HG.addActionListener(new er(this));
        this.HB.add(this.HG);
        this.HB.addSeparator();
        this.HH.addActionListener(new et(this));
        this.HB.add(this.HH);
        this.HI.addActionListener(new eu(this));
        this.HB.add(this.HI);
        this.HB.addSeparator();
        this.HJ.addActionListener(new ev(this));
        this.HB.add(this.HJ);
        this.Iy.setComponentPopupMenu(this.HB);
    }

    private void qE() {
        if (this.uz.fz().booleanValue()) {
            this.uz.g(false);
            this.qt();
        } else {
            ArrayList arrayList = c.a.SR.f(this.zu);
            int n2 = 0;
            if (arrayList != null) {
                n2 = arrayList.size();
            }
            if (n2 + this.zu.kr() < 10) {
                this.uz.g(true);
                this.qt();
            } else {
                JOptionPane.showMessageDialog(null, "Limite de jogadores emprest\u00e1veis \u00e9 de " + Integer.toString(10), "Limite de emprestados", 2);
            }
        }
    }

    private void qF() {
        if (this.uz != null && this.uz.gl().booleanValue() && this.zu.kb() >= (long)this.uz.fk()) {
            int n2 = -1;
            n2 = JOptionPane.showConfirmDialog(this, "Deseja comprar o jogador " + this.uz.getNome() + "?", "Confirmar", 0);
            if (n2 == 0) {
                ah ah2 = null;
                t t2 = null;
                int n3 = 0;
                while (n3 < c.a.SR.bt().size()) {
                    if (((t)c.a.SR.bt().get(n3)).x() == this.uz) {
                        ah2 = ((t)c.a.SR.bt().get(n3)).tP();
                        t2 = (t)c.a.SR.bt().get(n3);
                        break;
                    }
                    ++n3;
                }
                c.a.SR.d(this.uz);
                this.uz.r(ah2);
                this.uz.a(this.zu, this.uz.fk(), false, false, false);
                this.qJ();
                this.qI();
                this.qH();
            }
        }
    }

    private void qG() {
        t t2 = c.a.SR.e(this.uz);
        if (t2 != null) {
            int n2 = -1;
            n2 = JOptionPane.showConfirmDialog(this, "Deseja cancelar o empr\u00e9stimo do jogador " + this.uz.getNome() + "?", "Confirmar", 0);
            if (n2 == 0) {
                if (t2.tN()) {
                    c.a.SR.d(t2.x());
                    this.pK();
                    this.qI();
                    this.qH();
                } else {
                    JOptionPane.showMessageDialog(this.Br, "N\u00e3o h\u00e1 vagas no time de origem", "", 2);
                }
            }
        }
    }

    private void qH() {
        this.qt();
        this.Iy.addNotify();
    }

    private void qI() {
        ((Q)this.Iy.getModel()).fireTableDataChanged();
        if (this.Iy.getRowCount() > 0) {
            this.Iy.setRowSelectionInterval(0, 0);
        } else {
            this.uz = null;
        }
    }

    private void qJ() {
        this.pK();
        this.qx();
        this.qL();
        Collections.sort(this.zu.kc(), a.abe);
    }

    private void qK() {
        int n2 = 0;
        while (n2 < this.zu.kc().size()) {
            ((F)this.zu.kc().get(n2)).b((JProgressBar)null);
            ++n2;
        }
    }

    private void qL() {
        int n2 = 0;
        while (n2 < this.zu.kc().size()) {
            if (this.tR != 0) {
                ((F)this.zu.kc().get(n2)).ax(((F)this.zu.kc().get(n2)).d(this.bv.hy()));
            }
            ++n2;
        }
    }

    private void qM() {
        JDialog jDialog = new JDialog(this.Br);
        ce ce2 = new ce(jDialog, this.zu);
        jDialog.add(ce2);
        jDialog.setSize(570, 433);
        jDialog.setPreferredSize(new Dimension(570, 433));
        jDialog.setModal(true);
        jDialog.setResizable(false);
        jDialog.setLocationRelativeTo(null);
        jDialog.setUndecorated(true);
        jDialog.pack();
        jDialog.setVisible(true);
        this.Iy.addNotify();
    }

    private void AI() {
        S.l(this.zu.ka());
        if (afk) {
            this.Hx = new JPopupMenu();
            this.AL();
            this.afi = new JPopupMenu();
            this.AM();
            afk = false;
        }
    }

    private void AJ() {
        boolean bl2 = true;
        if (c.a.SR.isJogaSelecoesAll()) {
            int n2 = 0;
            while (n2 < c.a.SR.M().size()) {
                ArrayList arrayList;
                if (!bl2) {
                    if (((al)c.a.SR.M().get(n2)).jZ().booleanValue() && ((al)c.a.SR.M().get(n2)).jo() == null) {
                        arrayList = c.a.afQ.a((al)c.a.SR.M().get(n2), bl2);
                        if (!c.a.SR.bD() && arrayList != null && arrayList.size() > 0) {
                            S.a(arrayList, (al)c.a.SR.M().get(n2), 1);
                        }
                    }
                } else if (((al)c.a.SR.M().get(n2)).jZ().booleanValue()) {
                    arrayList = c.a.afQ.a((al)c.a.SR.M().get(n2), bl2);
                    if (!c.a.SR.bD() && arrayList != null && arrayList.size() > 0) {
                        S.a(arrayList, (al)c.a.SR.M().get(n2), 1);
                    }
                }
                ++n2;
            }
        }
    }

    public void mH() {
        this.HX.addActionListener(new ew(this));
        this.HR.addActionListener(new ex(this));
        this.afl.addActionListener(new ey(this));
        this.Ia.addActionListener(new ez(this));
        this.HZ.addActionListener(new eA(this));
        this.HV.addActionListener(new eB(this));
        this.HU.addActionListener(new eC(this));
        this.HW.addActionListener(new eE(this));
        this.Ib.addActionListener(new eF(this));
        this.HS.addActionListener(new eG(this));
        this.yY.addActionListener(new eH(this));
        this.Id.addActionListener(new eI(this));
        this.Iw.addMouseListener(new eJ(this));
        this.ze.addMouseListener(new eK(this));
        this.zb.addMouseListener(new eL(this));
        this.vw.addMouseListener(new eM(this));
        this.yt.addMouseListener(new eN(this));
        this.HT.addActionListener(new eP(this));
        this.Ie.addActionListener(new eQ(this));
        this.HY.addActionListener(new eR(this));
        this.Ic.addActionListener(new eS(this));
    }

    public void AK() {
        int n2 = 0;
        while (n2 < c.a.SR.aG().size()) {
            int n3 = ((Z)c.a.SR.aG().get(n2)).As().AW();
            if (n3 > 0) {
                System.out.println(String.valueOf(((Z)c.a.SR.aG().get(n2)).jp()) + ":" + n3);
            }
            ++n2;
        }
    }

    private void qN() {
        Object object;
        long l2 = 0L;
        long l3 = 0L;
        l2 = System.currentTimeMillis();
        ArrayList<Object> arrayList = new ArrayList<Object>();
        int n2 = 0;
        while (n2 < 5) {
            object = new N();
            String string = "";
            if (((N)object).iA() != null) {
                string = ((N)object).iA().getNome();
            }
            String string2 = "";
            if (((N)object).iz() != null) {
                string2 = ((N)object).iz().getNome();
            }
            System.out.println("Leilao: " + string + " " + string2);
            if (((N)object).iA() != null) {
                arrayList.add(object);
            }
            ++n2;
        }
        l3 = System.currentTimeMillis() - l2;
        dz.X(arrayList);
        JDialog jDialog = new JDialog(this.Br);
        object = new dz(jDialog);
        jDialog.add((Component)object);
        jDialog.setSize(941, 718);
        jDialog.setPreferredSize(new Dimension(941, 718));
        jDialog.setModal(true);
        jDialog.setResizable(false);
        jDialog.setLocationRelativeTo(null);
        jDialog.setUndecorated(true);
        jDialog.setVisible(true);
    }

    private void qO() {
        this.HY.setCursor(new Cursor(3));
        JDialog jDialog = new JDialog(this.Br);
        bs bs2 = new bs(jDialog, this.zu);
        jDialog.add(bs2);
        jDialog.setSize(737, 600);
        jDialog.setPreferredSize(new Dimension(737, 600));
        jDialog.setModal(true);
        jDialog.setResizable(false);
        jDialog.setLocationRelativeTo(null);
        jDialog.setUndecorated(true);
        jDialog.setVisible(true);
        this.HY.setCursor(new Cursor(12));
        if (bs.nX()) {
            this.qI();
            this.qJ();
            this.qH();
        }
    }

    private void qP() {
        this.HY.setCursor(new Cursor(3));
        JDialog jDialog = new JDialog(this.Br);
        hw hw2 = new hw(jDialog, this.zu);
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

    private void qQ() {
        Color color = this.zu.kB();
        Color color2 = this.zu.kC();
        JDialog jDialog = new JDialog(this.Br);
        bb bb2 = new bb(jDialog, this.zu);
        jDialog.add(bb2);
        jDialog.setSize(308, 315);
        jDialog.setPreferredSize(new Dimension(308, 315));
        jDialog.setModal(true);
        jDialog.setResizable(false);
        jDialog.setLocationRelativeTo(null);
        jDialog.setUndecorated(true);
        jDialog.setVisible(true);
        if (color != this.zu.kB() || color2 != this.zu.kC()) {
            this.qK();
            this.qu();
            this.Iy.addNotify();
        }
    }

    public void qR() {
        this.uz.c(false);
        this.uz.fm();
        this.Iy.addNotify();
        this.If.g(1, false);
    }

    public void qS() {
        JDialog jDialog = new JDialog(this.Br);
        fy fy2 = new fy(jDialog, this.uz);
        jDialog.add(fy2);
        jDialog.setSize(357, 330);
        jDialog.setPreferredSize(new Dimension(357, 330));
        jDialog.setModal(true);
        jDialog.setResizable(false);
        jDialog.setLocationRelativeTo(null);
        jDialog.setUndecorated(true);
        jDialog.setVisible(true);
        this.Iy.addNotify();
        this.qt();
    }

    private void qT() {
        ah ah2 = this.zu;
        if (this.yp) {
            ah2 = this.zu.ka().fg();
        }
        if (ah2 != null) {
            this.Iw.setCursor(new Cursor(3));
            JDialog jDialog = new JDialog(this.Br);
            cW cW2 = new cW(jDialog, ah2);
            jDialog.add(cW2);
            jDialog.setSize(398, 637);
            jDialog.setPreferredSize(new Dimension(398, 637));
            jDialog.setModal(true);
            jDialog.setResizable(false);
            jDialog.setLocationRelativeTo(null);
            jDialog.setUndecorated(true);
            jDialog.setVisible(true);
            this.Iw.setCursor(new Cursor(12));
            this.qx();
        }
    }

    private void qU() {
        ah ah2 = this.zu;
        if (this.yp) {
            ah2 = this.zu.ka().fg();
        }
        if (ah2 != null) {
            JDialog jDialog = new JDialog(this.Br);
            iQ iQ2 = new iQ(jDialog, ah2);
            jDialog.add(iQ2);
            jDialog.setSize(409, 252);
            jDialog.setPreferredSize(new Dimension(409, 252));
            jDialog.setModal(true);
            jDialog.setResizable(false);
            jDialog.setLocationRelativeTo(null);
            jDialog.setUndecorated(true);
            jDialog.setVisible(true);
        }
    }

    private void dn(int n2) {
        int n3 = this.zu.kc().size();
        JDialog jDialog = new JDialog(this.Br);
        gx gx2 = new gx(jDialog, this.zu, this.yp, n2);
        int n4 = 820;
        int n5 = 620;
        if (n2 == 2) {
            n4 = 840;
            n5 = 670;
        }
        jDialog.add(gx2);
        jDialog.setSize(n4, n5);
        jDialog.setPreferredSize(new Dimension(n4, n5));
        jDialog.setModal(true);
        jDialog.setResizable(false);
        jDialog.setLocationRelativeTo(null);
        jDialog.setUndecorated(true);
        jDialog.setVisible(true);
        if (n3 != this.zu.kc().size()) {
            this.qI();
            this.qJ();
            this.qH();
        }
    }

    public void on() {
        this.Iy.requestFocusInWindow();
    }

    private void qV() {
        at at2 = this.bv.hy();
        S.a(this.tR, at2);
    }

    public void qW() {
        if (this.uz != null) {
            JDialog jDialog = new JDialog(this.Br);
            ji ji2 = new ji(jDialog, this.zu, this.uz);
            jDialog.add(ji2);
            jDialog.setSize(402, 374);
            jDialog.setPreferredSize(new Dimension(402, 374));
            jDialog.setModal(true);
            jDialog.setResizable(false);
            jDialog.setLocationRelativeTo(null);
            jDialog.setUndecorated(true);
            jDialog.setVisible(true);
            if (ji.nX()) {
                this.qI();
                this.qJ();
                this.qH();
            }
        }
    }

    public void qX() {
        if (this.uz != null) {
            JDialog jDialog = new JDialog(this.Br);
            jc jc2 = new jc(jDialog, this.uz);
            jDialog.add(jc2);
            jDialog.setSize(395, 420);
            jDialog.setPreferredSize(new Dimension(395, 420));
            jDialog.setModal(true);
            jDialog.setResizable(false);
            jDialog.setLocationRelativeTo(null);
            jDialog.setUndecorated(true);
            jDialog.setVisible(true);
            if (jc.sN()) {
                this.qI();
                this.qJ();
                this.pK();
                this.qH();
            } else if (this.uz.ft().booleanValue()) {
                this.If.h(1, true);
                this.If.g(1, true);
                this.Iy.addNotify();
            }
        }
    }

    public void qY() {
        JDialog jDialog = new JDialog(this.Br);
        ds ds2 = new ds(jDialog, this.zu, this.zu);
        jDialog.add(ds2);
        jDialog.setSize(763, 568);
        jDialog.setPreferredSize(new Dimension(763, 568));
        jDialog.setModal(true);
        jDialog.setResizable(false);
        jDialog.setLocationRelativeTo(null);
        jDialog.setUndecorated(true);
        jDialog.setVisible(true);
        if (ds.nX()) {
            this.qI();
            this.qJ();
            this.qH();
        }
        UIManager.put("ProgressBar.selectionForeground", this.zu.kC());
        UIManager.put("ProgressBar.selectionBackground", Color.black);
    }

    public void qZ() {
        this.HU.setCursor(new Cursor(3));
        JDialog jDialog = new JDialog(this.Br);
        bz bz2 = new bz(jDialog, this.zu, c.a.SR.bl(), this.yp);
        if (!S.iI()) {
            jDialog.add(bz2);
        } else {
            JScrollPane jScrollPane = new JScrollPane();
            jScrollPane.setViewportView(bz2);
            jDialog.add(jScrollPane);
        }
        jDialog.setSize(1024, 748);
        jDialog.setPreferredSize(new Dimension(1024, 748));
        jDialog.setModal(true);
        jDialog.setResizable(false);
        jDialog.setLocationRelativeTo(null);
        jDialog.setUndecorated(true);
        jDialog.setVisible(true);
        this.HU.setCursor(new Cursor(12));
    }

    public void ra() {
        if (!this.yp) {
            JDialog jDialog = new JDialog(this.Br);
            cl cl2 = new cl(jDialog, this.zu.ev(), this.tR, this.zu);
            jDialog.add(cl2);
            jDialog.setSize(598, 328);
            jDialog.setPreferredSize(new Dimension(598, 328));
            jDialog.setModal(true);
            jDialog.setResizable(false);
            jDialog.setLocationRelativeTo(null);
            jDialog.setUndecorated(true);
            jDialog.setVisible(true);
            this.qx();
        }
    }

    public void AL() {
        JMenuItem jMenuItem = new JMenuItem("Jogos do seu time");
        jMenuItem.addActionListener(new eT(this));
        jMenuItem.setAccelerator(KeyStroke.getKeyStroke(115, 0));
        this.Hx.add(jMenuItem);
        this.Hx.addSeparator();
        JMenuItem jMenuItem2 = new JMenuItem("Jogos Amistosos");
        jMenuItem2.addActionListener(new eU(this));
        jMenuItem2.setAccelerator(KeyStroke.getKeyStroke(120, 0));
        this.Hx.add(jMenuItem2);
        this.Hx.addSeparator();
        JMenuItem jMenuItem3 = new JMenuItem("Central de Empregos");
        jMenuItem3.addActionListener(new eV(this));
        this.Hx.add(jMenuItem3);
        if (this.HK || afj) {
            jMenuItem3.setEnabled(false);
        }
    }

    public void AM() {
        JMenuItem jMenuItem = new JMenuItem("Jogos Amistosos Sele\u00e7\u00e3o");
        jMenuItem.addActionListener(new eW(this));
        this.afi.add(jMenuItem);
        this.afi.addSeparator();
        JMenuItem jMenuItem2 = new JMenuItem("Calend\u00e1rio da sele\u00e7\u00e3o");
        jMenuItem2.addActionListener(new eX(this));
        this.afi.add(jMenuItem2);
        this.afi.addSeparator();
        if (this.qp().ka().jo() == null) {
            jMenuItem.setEnabled(false);
            jMenuItem2.setEnabled(false);
        }
        JMenuItem jMenuItem3 = new JMenuItem("Convocar Sele\u00e7\u00e3o");
        jMenuItem3.addActionListener(new eY(this));
        this.afi.add(jMenuItem3);
        this.afi.addSeparator();
        JMenuItem jMenuItem4 = new JMenuItem("Pedir demiss\u00e3o da sele\u00e7\u00e3o");
        jMenuItem4.addActionListener(new fa(this));
        this.afi.add(jMenuItem4);
        if (this.qp().ka().jo() == null || this.HK) {
            jMenuItem3.setEnabled(false);
            jMenuItem4.setEnabled(false);
        }
        if (this.qp().ka().jo() != null) {
            this.afl.setVisible(true);
            this.afl.setIcon(this.qp().ka().jo().K(true));
        } else {
            this.afl.setVisible(false);
        }
    }

    public void rb() {
        JMenuItem jMenuItem;
        JMenuItem jMenuItem2;
        JMenuItem jMenuItem3 = new JMenuItem("Salvar jogo");
        jMenuItem3.addActionListener(new fb(this));
        ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/aicons/save1.png"));
        jMenuItem3.setIcon(imageIcon);
        jMenuItem3.setAccelerator(KeyStroke.getKeyStroke(113, 0));
        this.Hy.add(jMenuItem3);
        this.Hy.addSeparator();
        JMenuItem jMenuItem4 = new JMenuItem("Prefer\u00eancias");
        jMenuItem4.addActionListener(new fc(this));
        ImageIcon imageIcon2 = new ImageIcon(this.getClass().getResource("/aicons/iconsetup.png"));
        jMenuItem4.setIcon(imageIcon2);
        jMenuItem4.setAccelerator(KeyStroke.getKeyStroke(114, 0));
        this.Hy.add(jMenuItem4);
        this.Hy.addSeparator();
        JMenuItem jMenuItem5 = new JMenuItem("Pedir demiss\u00e3o");
        jMenuItem5.addActionListener(new fd(this));
        ImageIcon imageIcon3 = new ImageIcon(this.getClass().getResource("/aicons/iconfire.png"));
        jMenuItem5.setIcon(imageIcon3);
        this.Hy.add(jMenuItem5);
        this.Hy.addSeparator();
        JMenuItem jMenuItem6 = new JMenuItem("Sair do jogo");
        jMenuItem6.addActionListener(new fe(this));
        this.Hy.add(jMenuItem6);
        this.Hy.addSeparator();
        JMenuItem jMenuItem7 = new JMenuItem("Sobre o Brasfoot");
        jMenuItem7.addActionListener(new ff(this));
        this.Hy.add(jMenuItem7);
        JMenuItem jMenuItem8 = new JMenuItem("Ranking de t\u00e9cnicos");
        jMenuItem8.addActionListener(new fg(this));
        this.Hz.add(jMenuItem8);
        this.Hz.addSeparator();
        JMenuItem jMenuItem9 = new JMenuItem("Adicionar/remover t\u00e9cnicos");
        jMenuItem9.addActionListener(new fh(this));
        this.Hz.add(jMenuItem9);
        this.Hz.addSeparator();
        JMenuItem jMenuItem10 = new JMenuItem("\u00daltimas trocas de t\u00e9cnicos");
        jMenuItem10.addActionListener(new fi(this));
        this.Hz.add(jMenuItem10);
        this.Hz.addSeparator();
        JMenuItem jMenuItem11 = new JMenuItem("Trof\u00e9us do T\u00e9cnico");
        jMenuItem11.addActionListener(new fj(this));
        this.Hz.add(jMenuItem11);
        JMenuItem jMenuItem12 = new JMenuItem("Campe\u00f5es");
        jMenuItem12.addActionListener(new fl(this));
        jMenuItem12.setAccelerator(KeyStroke.getKeyStroke(121, 0));
        this.HA.add(jMenuItem12);
        this.HA.addSeparator();
        JMenuItem jMenuItem13 = new JMenuItem("Ranking Clubes");
        jMenuItem13.addActionListener(new fm(this));
        this.HA.add(jMenuItem13);
        this.HA.addSeparator();
        if (c.a.SR.isJogaSelecoesAll()) {
            jMenuItem2 = new JMenuItem("Ranking Sele\u00e7\u00f5es");
            jMenuItem2.addActionListener(new fn(this));
            this.HA.add(jMenuItem2);
            this.HA.addSeparator();
        }
        jMenuItem2 = new JMenuItem("Artilheiros");
        jMenuItem2.addActionListener(new fo(this));
        jMenuItem2.setAccelerator(KeyStroke.getKeyStroke(122, 0));
        this.HA.add(jMenuItem2);
        this.HA.addSeparator();
        JMenuItem jMenuItem14 = new JMenuItem("L\u00edderes de Assist\u00eancias");
        jMenuItem14.addActionListener(new fp(this));
        this.HA.add(jMenuItem14);
        this.HA.addSeparator();
        if (!this.yp) {
            jMenuItem = new JMenuItem("Galeria de Trof\u00e9us");
            jMenuItem.addActionListener(new fq(this));
            this.HA.add(jMenuItem);
            this.HA.addSeparator();
        }
        if (!this.yp) {
            jMenuItem = new JMenuItem("Time da Rodada");
            jMenuItem.addActionListener(new fr(this));
            this.HA.add(jMenuItem);
            this.HA.addSeparator();
            JMenuItem jMenuItem15 = new JMenuItem("Time do Ano");
            jMenuItem15.addActionListener(new fs(this));
            this.HA.add(jMenuItem15);
            this.HA.addSeparator();
            JMenuItem jMenuItem16 = new JMenuItem("Bola de Ouro");
            jMenuItem16.addActionListener(new iV(this));
            this.HA.add(jMenuItem16);
            this.HA.addSeparator();
            JMenuItem jMenuItem17 = new JMenuItem("Transfer\u00eancias de Jogadores");
            jMenuItem17.addActionListener(new iW(this));
            this.HA.add(jMenuItem17);
            this.HA.addSeparator();
        }
        jMenuItem = new JMenuItem("Hist\u00f3rico de confrontos");
        jMenuItem.addActionListener(new jr(this));
        this.HA.add(jMenuItem);
    }

    private void rc() {
        ah ah2 = this.zu.ka().jo();
        if (ah2 != null) {
            S.a(ah2, false);
            this.qA();
            if (this.Iy.getRowCount() > 0) {
                this.Iy.setRowSelectionInterval(0, 0);
            }
            this.pK();
            this.qH();
        }
    }

    private void rd() {
        S.cX();
    }

    public void G(ah ah2) {
        int n2 = this.zu.kc().size();
        ah ah3 = this.zu;
        if (this.yp) {
            ah3 = this.zu.ka().fg();
        } else if (ah2 != null) {
            ah3 = ah2;
        }
        if (ah3 != null) {
            S.a(ah3, this.zu, this.yp);
        }
        if (n2 != this.zu.kc().size()) {
            this.qI();
            this.qJ();
            this.qH();
        }
    }

    public void ad(boolean bl2) {
        ah ah2 = null;
        ah2 = !bl2 ? this.zu.ka().fg() : this.zu.ka().jo();
        if (ah2 != null) {
            JDialog jDialog = new JDialog(this.Br);
            L l2 = new L(jDialog, ah2);
            jDialog.add(l2);
            jDialog.setSize(820, 600);
            jDialog.setPreferredSize(new Dimension(820, 600));
            jDialog.setModal(true);
            jDialog.setResizable(false);
            jDialog.setLocationRelativeTo(null);
            jDialog.setUndecorated(true);
            jDialog.setVisible(true);
        }
    }

    public void re() {
        ah ah2 = this.zu.ka().fg();
        if (ah2 != null) {
            S.w(this.zu.ka().fg());
        }
        this.qx();
    }

    public void rf() {
        ah ah2 = this.zu.ka().jo();
        if (ah2 != null) {
            S.x(ah2);
        }
    }

    public void rg() {
        JDialog jDialog = new JDialog(this.Br);
        H h3 = new H(jDialog, this.zu.kF(), c.a.SR.o(this.zu.getPais()));
        jDialog.add(h3);
        jDialog.setSize(1020, 680);
        jDialog.setPreferredSize(new Dimension(1020, 680));
        jDialog.setModal(true);
        jDialog.setResizable(false);
        jDialog.setLocationRelativeTo(null);
        jDialog.setUndecorated(true);
        jDialog.setVisible(true);
    }

    public void do(int n2) {
        S.a(this.zu.kF(), c.a.SR.o(this.zu.getPais()), n2);
    }

    public void rh() {
        ah ah2 = this.zu;
        JDialog jDialog = new JDialog(this.Br);
        aL aL2 = new aL(jDialog, ah2, this.Hv, this.yp);
        jDialog.add(aL2);
        jDialog.setSize(617, 456);
        jDialog.setPreferredSize(new Dimension(617, 456));
        jDialog.setModal(true);
        jDialog.setResizable(false);
        jDialog.setLocationRelativeTo(null);
        jDialog.setUndecorated(true);
        jDialog.setVisible(true);
    }

    public void dp(int n2) {
        JDialog jDialog = new JDialog(this.Br);
        hC hC2 = new hC(jDialog, this.zu, n2);
        jDialog.add(hC2);
        jDialog.setSize(695, 500);
        jDialog.setPreferredSize(new Dimension(695, 500));
        jDialog.setModal(true);
        jDialog.setResizable(false);
        jDialog.setLocationRelativeTo(null);
        jDialog.setUndecorated(true);
        jDialog.setVisible(true);
    }

    public void ri() {
        JDialog jDialog = new JDialog(this.Br);
        hc hc2 = new hc(jDialog, this.zu);
        jDialog.add(hc2);
        jDialog.setSize(825, 602);
        jDialog.setPreferredSize(new Dimension(825, 602));
        jDialog.setModal(true);
        jDialog.setResizable(false);
        jDialog.setLocationRelativeTo(null);
        jDialog.setUndecorated(true);
        jDialog.setVisible(true);
    }

    public void AN() {
        JDialog jDialog = new JDialog(this.Br);
        jv jv2 = new jv(jDialog, this.zu);
        jDialog.add(jv2);
        jDialog.setSize(432, 666);
        jDialog.setPreferredSize(new Dimension(432, 666));
        jDialog.setModal(true);
        jDialog.setResizable(false);
        jDialog.setLocationRelativeTo(null);
        jDialog.setUndecorated(true);
        jDialog.setVisible(true);
    }

    public void rj() {
        JDialog jDialog = new JDialog(this.Br);
        y y2 = new y(jDialog, this.zu);
        jDialog.add(y2);
        jDialog.setSize(596, 608);
        jDialog.setPreferredSize(new Dimension(596, 608));
        jDialog.setModal(true);
        jDialog.setResizable(false);
        jDialog.setLocationRelativeTo(null);
        jDialog.setUndecorated(true);
        jDialog.setVisible(true);
    }

    public void rk() {
        JDialog jDialog = new JDialog(this.Br);
        o o2 = new o(jDialog);
        jDialog.add(o2);
        jDialog.setSize(758, 616);
        jDialog.setPreferredSize(new Dimension(758, 616));
        jDialog.setModal(true);
        jDialog.setResizable(false);
        jDialog.setLocationRelativeTo(null);
        jDialog.setUndecorated(true);
        jDialog.setVisible(true);
    }

    public void rl() {
        JDialog jDialog = new JDialog(this.Br);
        R r2 = new R(jDialog);
        jDialog.add(r2);
        jDialog.setSize(848, 628);
        jDialog.setPreferredSize(new Dimension(848, 628));
        jDialog.setModal(true);
        jDialog.setResizable(false);
        jDialog.setLocationRelativeTo(null);
        jDialog.setUndecorated(true);
        jDialog.setVisible(true);
    }

    public void rm() {
        JDialog jDialog = new JDialog(this.Br);
        bn bn2 = new bn(jDialog, this.zu.ka().lQ(), this.zu);
        jDialog.add(bn2);
        jDialog.setSize(894, 391);
        jDialog.setPreferredSize(new Dimension(894, 391));
        jDialog.setModal(true);
        jDialog.setResizable(false);
        jDialog.setLocationRelativeTo(null);
        jDialog.setUndecorated(true);
        jDialog.setVisible(true);
        this.qw();
    }

    public void rn() {
        JDialog jDialog = new JDialog(this.Br);
        ip ip2 = new ip(jDialog);
        jDialog.add(ip2);
        jDialog.setSize(487, 422);
        jDialog.setPreferredSize(new Dimension(487, 422));
        jDialog.setModal(true);
        jDialog.setResizable(false);
        jDialog.setLocationRelativeTo(null);
        jDialog.setUndecorated(true);
        jDialog.setVisible(true);
    }

    public void ro() {
        JDialog jDialog = new JDialog(this.Br);
        gX gX2 = new gX(jDialog, this.zu.ka());
        jDialog.add(gX2);
        jDialog.setSize(880, 663);
        jDialog.setPreferredSize(new Dimension(880, 663));
        jDialog.setModal(true);
        jDialog.setResizable(false);
        jDialog.setLocationRelativeTo(null);
        jDialog.setUndecorated(true);
        jDialog.setVisible(true);
    }

    public boolean rp() {
        c.a.SR.ad();
        JDialog jDialog = new JDialog(this.Br);
        jp jp2 = new jp(jDialog);
        jDialog.add(jp2);
        jDialog.setSize(496, 185);
        jDialog.setPreferredSize(new Dimension(496, 185));
        jDialog.setModal(true);
        jDialog.setResizable(false);
        jDialog.setLocationRelativeTo(null);
        jDialog.setUndecorated(true);
        jDialog.setVisible(true);
        return true;
    }

    public void rq() {
        System.exit(0);
    }

    public void rr() {
        if (this.yp) {
            this.rs();
        } else {
            int n2 = -1;
            n2 = JOptionPane.showConfirmDialog(this.Br, "Deseja realmente ser demitido?", "Confirma\u00e7\u00e3o", 0);
            if (n2 == 0) {
                al al2 = this.zu.ka();
                al al3 = this.zu.kE();
                if (al3 == null) {
                    JOptionPane.showMessageDialog(null, "A diretoria ainda n\u00e3o achou um t\u00e9cnico a sua altura. Tente se demitir em outro momento.", "Demiss\u00e3o recusada", 2);
                } else {
                    S.a(al2, al3, this.zu, 0);
                    c.a.SR.g(true);
                    c.a.SR.ap();
                }
            }
        }
    }

    public void rs() {
        int n2 = -1;
        n2 = JOptionPane.showConfirmDialog(this.Br, "Deseja realmente ser demitido da sele\u00e7\u00e3o?", "Confirma\u00e7\u00e3o", 0);
        if (n2 == 0) {
            Z z2;
            int n3 = -1;
            if (this.zu.ka().jo() != null) {
                n3 = this.zu.ka().jo().getPais();
            }
            if ((z2 = c.a.SR.s(n3)) != null) {
                al al2 = this.zu.ka();
                al al3 = z2.ji();
                z2.z(false);
                al2.z(null);
                z2.jo().h(null);
                z2.jo().k(false);
                z2.g(al3);
                afk = false;
                afj = false;
                this.afi = new JPopupMenu();
                this.AM();
                if (this.yp) {
                    S.a(al2, al3, this.zu, 0);
                    c.a.SR.ap();
                }
            }
        }
    }

    public void rt() {
        if (c.a.SR.br() == null) {
            JDialog jDialog = new JDialog(this.Br);
            fw fw2 = new fw(jDialog);
            jDialog.add(fw2);
            jDialog.setSize(494, 192);
            jDialog.setPreferredSize(new Dimension(494, 192));
            jDialog.setModal(true);
            jDialog.setResizable(false);
            jDialog.setLocationRelativeTo(null);
            jDialog.setVisible(true);
        }
    }

    public void ru() {
        if (c.a.SR.br() == null) {
            this.rt();
        }
        if (c.a.SR.br() != null) {
            this.Br.setCursor(new Cursor(3));
            S.a("", false);
            this.Br.setCursor(new Cursor(12));
        }
    }

    public void rv() {
        S.a(this.Iy);
    }

    private void rw() {
        S.v(this.zu);
    }

    private void rx() {
        if (this.zu.ka() != null) {
            S.e(this.zu.ka());
        }
    }

    private void ry() {
    }

    private void rz() {
        this.ve.setBorder(BorderFactory.createEmptyBorder());
        this.HT.setToolTipText("Cores da tela");
        this.Ie.setToolTipText("Galeria de trof\u00e9us");
        this.HY.setToolTipText("Retrospecto do time");
        this.Ic.setToolTipText("Jogadores emprestados");
    }

    public static Color rA() {
        return HM;
    }

    public boolean rB() {
        return this.yp;
    }

    public static boolean rC() {
        return HN;
    }

    public static void ae(boolean bl2) {
        HN = bl2;
    }

    public static at rD() {
        return HO;
    }

    public static void w(at at2) {
        HO = at2;
    }

    public static void aQ(boolean bl2) {
        afj = bl2;
    }

    public static void aR(boolean bl2) {
        afk = bl2;
    }

    private void mJ() {
        this.wf = new JPanel();
        this.ur = new JLabel();
        this.Hf = new JProgressBar();
        this.us = new JLabel();
        this.Ig = new JProgressBar();
        this.a_ = new JLabel();
        this.vz = new JLabel();
        this.yt = new JLabel();
        this.zb = new JLabel();
        this.vw = new JLabel();
        this.Bj = new JLabel();
        this.uh = new JLabel();
        this.Fq = new JLabel();
        this.ug = new JLabel();
        this.Iw = new JLabel();
        this.ze = new JLabel();
        this.Ix = new JScrollPane();
        this.Iy = new JTable();
        this.ve = new JToolBar();
        this.Io = new JToolBar.Separator();
        this.Ih = new JToolBar.Separator();
        this.HR = new JButton();
        this.Is = new JToolBar.Separator();
        this.Ij = new JToolBar.Separator();
        this.afl = new JButton();
        this.OD = new JToolBar.Separator();
        this.HS = new JButton();
        this.In = new JToolBar.Separator();
        this.HV = new JButton();
        this.Ik = new JToolBar.Separator();
        this.HW = new JButton();
        this.Iu = new JToolBar.Separator();
        this.Ib = new JButton();
        this.Il = new JToolBar.Separator();
        this.Id = new JButton();
        this.Im = new JToolBar.Separator();
        this.yY = new JButton();
        this.It = new JToolBar.Separator();
        this.Ia = new JButton();
        this.Ip = new JToolBar.Separator();
        this.HZ = new JButton();
        this.Iq = new JToolBar.Separator();
        this.HX = new JButton();
        this.Ir = new JToolBar.Separator();
        this.Eh = new JLabel();
        this.Ii = new JToolBar.Separator();
        this.Eg = new JLabel();
        this.HU = new JButton();
        this.If = new m(this);
        this.Ef = new JLabel();
        this.Iv = new JToolBar();
        this.HT = new JButton();
        this.Ie = new JButton();
        this.HY = new JButton();
        this.Ic = new JButton();
        this.setBackground(new Color(0, 51, 51));
        this.wf.setBackground(new Color(226, 226, 217));
        this.ur.setHorizontalAlignment(2);
        this.ur.setText("Confian\u00e7a diretoria:");
        this.Hf.setToolTipText("");
        this.Hf.setValue(30);
        this.Hf.setStringPainted(true);
        this.us.setHorizontalAlignment(2);
        this.us.setText("Confian\u00e7a torcida:");
        this.Ig.setForeground(new Color(0, 51, 51));
        this.Ig.setValue(55);
        this.Ig.setStringPainted(true);
        this.a_.setFont(new Font("Tahoma", 1, 11));
        this.a_.setHorizontalAlignment(2);
        this.a_.setText("Emmanuel dos Santos");
        this.vz.setBackground(new Color(0, 0, 0));
        this.vz.setFont(new Font("Tahoma", 1, 11));
        this.vz.setForeground(new Color(255, 255, 255));
        this.vz.setHorizontalAlignment(2);
        this.vz.setText("Pr\u00f3ximo jogo");
        this.vz.setOpaque(true);
        this.yt.setIcon(new ImageIcon(this.getClass().getResource("/aicons/escudo.png")));
        this.zb.setIcon(new ImageIcon(this.getClass().getResource("/aicons/iconretrospecto.png")));
        this.zb.setCursor(new Cursor(12));
        this.vw.setFont(new Font("Tahoma", 0, 12));
        this.vw.setText("Red Bull Bragantino");
        this.Bj.setFont(new Font("Tahoma", 0, 12));
        this.Bj.setText("1\u00aa divis\u00e3o - 9\u00ba colocado");
        this.uh.setFont(new Font("Tahoma", 0, 12));
        this.uh.setText("1\u00aa divis\u00e3o - 9\u00ba colocado");
        this.Fq.setBackground(new Color(232, 236, 235));
        this.Fq.setHorizontalAlignment(0);
        this.Fq.setIcon(new ImageIcon(this.getClass().getResource("/aicons/escudo.png")));
        this.ug.setFont(new Font("Tahoma", 1, 14));
        this.ug.setText("Borussia Dortmund");
        this.Iw.setHorizontalAlignment(2);
        this.Iw.setIcon(new ImageIcon(this.getClass().getResource("/aicons/n03.png")));
        this.Iw.setText("5 milh\u00f5es 200 mil");
        this.Iw.setCursor(new Cursor(12));
        this.ze.setHorizontalAlignment(2);
        this.ze.setIcon(new ImageIcon(this.getClass().getResource("/aicons/n04.png")));
        this.ze.setText("5");
        this.ze.setCursor(new Cursor(12));
        GroupLayout groupLayout = new GroupLayout(this.wf);
        this.wf.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.Fq, -2, 60, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.ug, -1, -1, Short.MAX_VALUE).addComponent(this.a_, -1, -1, Short.MAX_VALUE))).addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(this.Iw, -1, -1, Short.MAX_VALUE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.ze, -2, 49, -2)).addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(groupLayout.createSequentialGroup().addComponent(this.yt, -2, 60, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.Bj, -1, -1, Short.MAX_VALUE).addGroup(groupLayout.createSequentialGroup().addComponent(this.vw, -1, -1, Short.MAX_VALUE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.zb)))).addComponent(this.uh, GroupLayout.Alignment.LEADING, -1, -1, Short.MAX_VALUE).addGroup(GroupLayout.Alignment.LEADING, groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.Hf, -2, 1, Short.MAX_VALUE).addComponent(this.ur, -1, 119, Short.MAX_VALUE)).addGap(18, 18, 18).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(this.us, -2, 123, -2)).addComponent(this.Ig, -2, 1, Short.MAX_VALUE))).addComponent(this.vz, GroupLayout.Alignment.LEADING, -2, 260, -2)).addGap(20, 20, 20)));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(16, 16, 16).addComponent(this.ug, -2, 23, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.a_)).addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(this.Fq, -2, 60, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.Iw, -2, 21, -2).addComponent(this.ze, -2, 23, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, Short.MAX_VALUE).addComponent(this.uh).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.ur).addComponent(this.us)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.Hf, -2, -1, -2).addComponent(this.Ig, -2, -1, -2)).addGap(18, 18, 18).addComponent(this.vz, -2, 27, -2).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.yt, -2, 60, -2)).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.vw, -2, 19, -2).addComponent(this.zb, -2, 39, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.Bj))).addGap(13, 13, 13)));
        this.Iy.setModel(new DefaultTableModel(new Object[0][], new String[0]));
        this.Ix.setViewportView(this.Iy);
        this.ve.setBackground(new Color(0, 0, 0));
        this.ve.setFloatable(false);
        this.ve.setRollover(true);
        this.ve.setFont(new Font("Tahoma", 0, 12));
        this.ve.add(this.Io);
        this.ve.add(this.Ih);
        this.HR.setForeground(new Color(255, 255, 255));
        this.HR.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon02.png")));
        this.HR.setText("Agenda");
        this.HR.setBorderPainted(false);
        this.HR.setContentAreaFilled(false);
        this.HR.setFocusable(false);
        this.HR.setHorizontalTextPosition(0);
        this.HR.setVerticalTextPosition(3);
        this.HR.addActionListener(new js(this));
        this.ve.add(this.HR);
        this.ve.add(this.Is);
        this.Ij.setMaximumSize(new Dimension(12, Short.MAX_VALUE));
        this.ve.add(this.Ij);
        this.afl.setForeground(new Color(255, 255, 255));
        this.afl.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon04.png")));
        this.afl.setText("Sele\u00e7\u00e3o");
        this.afl.setBorderPainted(false);
        this.afl.setContentAreaFilled(false);
        this.afl.setFocusable(false);
        this.afl.setHorizontalTextPosition(0);
        this.afl.setVerticalTextPosition(3);
        this.ve.add(this.afl);
        this.OD.setMaximumSize(new Dimension(12, Short.MAX_VALUE));
        this.ve.add(this.OD);
        this.HS.setForeground(new Color(255, 255, 255));
        this.HS.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon04.png")));
        this.HS.setText("Tabelas");
        this.HS.setBorderPainted(false);
        this.HS.setContentAreaFilled(false);
        this.HS.setFocusable(false);
        this.HS.setHorizontalTextPosition(0);
        this.HS.setVerticalTextPosition(3);
        this.ve.add(this.HS);
        this.ve.add(this.In);
        this.HV.setForeground(new Color(255, 255, 255));
        this.HV.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon05.png")));
        this.HV.setText("Est\u00e1dio");
        this.HV.setBorderPainted(false);
        this.HV.setContentAreaFilled(false);
        this.HV.setFocusable(false);
        this.HV.setHorizontalTextPosition(0);
        this.HV.setVerticalTextPosition(3);
        this.ve.add(this.HV);
        this.ve.add(this.Ik);
        this.HW.setForeground(new Color(255, 255, 255));
        this.HW.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon09.png")));
        this.HW.setText("Juniores");
        this.HW.setBorderPainted(false);
        this.HW.setContentAreaFilled(false);
        this.HW.setFocusable(false);
        this.HW.setHorizontalTextPosition(0);
        this.HW.setVerticalTextPosition(3);
        this.ve.add(this.HW);
        this.ve.add(this.Iu);
        this.Ib.setForeground(new Color(255, 255, 255));
        this.Ib.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon06.png")));
        this.Ib.setText("Times");
        this.Ib.setBorderPainted(false);
        this.Ib.setContentAreaFilled(false);
        this.Ib.setFocusable(false);
        this.Ib.setHorizontalTextPosition(0);
        this.Ib.setVerticalTextPosition(3);
        this.ve.add(this.Ib);
        this.ve.add(this.Il);
        this.Id.setForeground(new Color(255, 255, 255));
        this.Id.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon03.png")));
        this.Id.setText("Treino");
        this.Id.setBorderPainted(false);
        this.Id.setContentAreaFilled(false);
        this.Id.setFocusable(false);
        this.Id.setHorizontalTextPosition(0);
        this.Id.setVerticalTextPosition(3);
        this.ve.add(this.Id);
        this.ve.add(this.Im);
        this.yY.setForeground(new Color(255, 255, 255));
        this.yY.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon07.png")));
        this.yY.setText("Procura");
        this.yY.setBorderPainted(false);
        this.yY.setContentAreaFilled(false);
        this.yY.setFocusable(false);
        this.yY.setHorizontalTextPosition(0);
        this.yY.setVerticalTextPosition(3);
        this.ve.add(this.yY);
        this.ve.add(this.It);
        this.Ia.setForeground(new Color(255, 255, 255));
        this.Ia.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon08.png")));
        this.Ia.setText("T\u00e9cnicos");
        this.Ia.setBorderPainted(false);
        this.Ia.setContentAreaFilled(false);
        this.Ia.setFocusable(false);
        this.Ia.setHorizontalTextPosition(0);
        this.Ia.setVerticalTextPosition(3);
        this.ve.add(this.Ia);
        this.ve.add(this.Ip);
        this.HZ.setForeground(new Color(255, 255, 255));
        this.HZ.setIcon(new ImageIcon(this.getClass().getResource("/aicons/iconhistoria.png")));
        this.HZ.setText("Hist\u00f3ria");
        this.HZ.setBorderPainted(false);
        this.HZ.setContentAreaFilled(false);
        this.HZ.setFocusable(false);
        this.HZ.setHorizontalTextPosition(0);
        this.HZ.setVerticalTextPosition(3);
        this.ve.add(this.HZ);
        this.ve.add(this.Iq);
        this.HX.setForeground(new Color(255, 255, 255));
        this.HX.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon01.png")));
        this.HX.setText("Op\u00e7\u00f5es");
        this.HX.setBorderPainted(false);
        this.HX.setContentAreaFilled(false);
        this.HX.setFocusable(false);
        this.HX.setHorizontalTextPosition(0);
        this.HX.setVerticalTextPosition(3);
        this.ve.add(this.HX);
        this.ve.add(this.Ir);
        this.Eh.setFont(new Font("Tahoma", 1, 11));
        this.Eh.setForeground(new Color(255, 255, 255));
        this.Eh.setText("Registre sua c\u00f3pia, clique aqui - www.brasfoot.com");
        this.ve.add(this.Eh);
        this.ve.add(this.Ii);
        this.Eg.setFont(new Font("Tahoma", 1, 11));
        this.Eg.setForeground(new Color(255, 255, 255));
        this.Eg.setText("12/04/1972");
        this.ve.add(this.Eg);
        this.HU.setIcon(new ImageIcon(this.getClass().getResource("/aicons/tactics.png")));
        this.HU.setText("Escalar Time");
        this.HU.addActionListener(new jt(this));
        this.If.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.Ef.setForeground(new Color(255, 255, 255));
        this.Ef.setHorizontalAlignment(4);
        this.Ef.setIcon(new ImageIcon(this.getClass().getResource("/aicons/ic_small_player.png")));
        this.Ef.setText("25");
        this.Ef.setCursor(new Cursor(12));
        this.Iv.setBackground(new Color(204, 204, 0));
        this.Iv.setRollover(true);
        this.Iv.setBorderPainted(false);
        this.HT.setIcon(new ImageIcon(this.getClass().getResource("/aicons/iconcolorpicker.png")));
        this.HT.setBorderPainted(false);
        this.HT.setFocusable(false);
        this.HT.setHorizontalTextPosition(0);
        this.HT.setOpaque(false);
        this.HT.setVerticalTextPosition(3);
        this.Iv.add(this.HT);
        this.Ie.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon10.png")));
        this.Ie.setBorderPainted(false);
        this.Ie.setFocusable(false);
        this.Ie.setHorizontalTextPosition(0);
        this.Ie.setOpaque(false);
        this.Ie.setVerticalTextPosition(3);
        this.Iv.add(this.Ie);
        this.HY.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon11.png")));
        this.HY.setBorderPainted(false);
        this.HY.setFocusable(false);
        this.HY.setHorizontalTextPosition(0);
        this.HY.setMaximumSize(new Dimension(41, 41));
        this.HY.setOpaque(false);
        this.HY.setVerticalTextPosition(3);
        this.Iv.add(this.HY);
        this.Ic.setIcon(new ImageIcon(this.getClass().getResource("/aicons/iconemprestados.png")));
        this.Ic.setBorderPainted(false);
        this.Ic.setFocusable(false);
        this.Ic.setHorizontalTextPosition(0);
        this.Ic.setOpaque(false);
        this.Ic.setVerticalTextPosition(3);
        this.Iv.add(this.Ic);
        GroupLayout groupLayout2 = new GroupLayout(this);
        this.setLayout(groupLayout2);
        groupLayout2.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.ve, -1, 1024, Short.MAX_VALUE).addGroup(groupLayout2.createSequentialGroup().addContainerGap().addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(groupLayout2.createSequentialGroup().addComponent(this.Iv, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, Short.MAX_VALUE).addComponent(this.Ef, -2, 53, -2)).addComponent(this.HU, -1, 290, Short.MAX_VALUE).addComponent(this.If, -1, -1, Short.MAX_VALUE)).addComponent(this.wf, GroupLayout.Alignment.TRAILING, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.Ix).addContainerGap()));
        groupLayout2.setVerticalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addComponent(this.ve, -2, 65, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addComponent(this.wf, -2, -1, -2).addGap(18, 18, 18).addComponent(this.HU, -2, 36, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.If, -2, 236, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.Iv, -2, -1, -2).addComponent(this.Ef))).addComponent(this.Ix)).addGap(22, 22, 22)));
    }

    private void a(ActionEvent actionEvent) {
    }

    private void c(ActionEvent actionEvent) {
    }

    static /* synthetic */ void a(eg eg2) {
        eg2.qV();
    }

    static /* synthetic */ void b(eg eg2) {
        eg2.qT();
    }

    static /* synthetic */ JTable c(eg eg2) {
        return eg2.Iy;
    }

    static /* synthetic */ void a(eg eg2, int n2) {
        eg2.dn(n2);
    }

    static /* synthetic */ void d(eg eg2) {
        eg2.qM();
    }

    static /* synthetic */ void e(eg eg2) {
        eg2.qG();
    }

    static /* synthetic */ void f(eg eg2) {
        eg2.qF();
    }

    static /* synthetic */ void g(eg eg2) {
        eg2.qE();
    }

    static /* synthetic */ JButton h(eg eg2) {
        return eg2.HX;
    }

    static /* synthetic */ JPopupMenu i(eg eg2) {
        return eg2.Hx;
    }

    static /* synthetic */ JButton j(eg eg2) {
        return eg2.HR;
    }

    static /* synthetic */ JPopupMenu k(eg eg2) {
        return eg2.afi;
    }

    static /* synthetic */ JButton l(eg eg2) {
        return eg2.afl;
    }

    static /* synthetic */ JButton m(eg eg2) {
        return eg2.Ia;
    }

    static /* synthetic */ JButton n(eg eg2) {
        return eg2.HZ;
    }

    static /* synthetic */ void o(eg eg2) {
        eg2.qU();
    }

    static /* synthetic */ ah p(eg eg2) {
        return eg2.Hv;
    }

    static /* synthetic */ void q(eg eg2) {
        eg2.qQ();
    }

    static /* synthetic */ void r(eg eg2) {
        eg2.rw();
    }

    static /* synthetic */ void s(eg eg2) {
        eg2.qP();
    }

    static /* synthetic */ void t(eg eg2) {
        eg2.qO();
    }

    static /* synthetic */ void u(eg eg2) {
        eg2.AI();
    }

    static /* synthetic */ void v(eg eg2) {
        eg2.rc();
    }

    static /* synthetic */ void w(eg eg2) {
        eg2.rx();
    }

    static /* synthetic */ void a(eg eg2, ActionEvent actionEvent) {
        eg2.c(actionEvent);
    }

    static /* synthetic */ void b(eg eg2, ActionEvent actionEvent) {
        eg2.a(actionEvent);
    }
}

