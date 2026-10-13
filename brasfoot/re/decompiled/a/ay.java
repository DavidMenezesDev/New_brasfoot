/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.aA;
import a.aB;
import a.aC;
import a.aD;
import a.aE;
import a.aF;
import a.aG;
import a.aH;
import a.aI;
import a.az;
import b.af;
import b.aj;
import b.l;
import best.G;
import best.I;
import best.L;
import best.X;
import best.ac;
import best.ah;
import best.an;
import best.aq;
import best.at;
import best.c;
import c.a;
import components.al;
import components.au;
import components.av;
import components.aw;
import components.ax;
import components.b;
import components.d;
import components.e;
import components.w;
import components.y;
import f.B;
import f.o;
import f.s;
import f.z;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.JViewport;

public class ay
extends JPanel {
    private ImageIcon uL = new ImageIcon(this.getClass().getResource("/aiconsb/b0.png"));
    private ImageIcon uM = new ImageIcon(this.getClass().getResource("/aiconsb/b1.png"));
    private ImageIcon uN = new ImageIcon(this.getClass().getResource("/aiconsb/b2.png"));
    private ImageIcon uO = new ImageIcon(this.getClass().getResource("/aiconsb/b3.png"));
    private ImageIcon uP = new ImageIcon(this.getClass().getResource("/aiconsb/b4.png"));
    private ImageIcon uQ = new ImageIcon(this.getClass().getResource("/aiconsb/b0s.png"));
    private ImageIcon uR = new ImageIcon(this.getClass().getResource("/aiconsb/b1s.png"));
    private ImageIcon uS = new ImageIcon(this.getClass().getResource("/aiconsb/b2s.png"));
    private ImageIcon uT = new ImageIcon(this.getClass().getResource("/aiconsb/b3s.png"));
    private ImageIcon uU = new ImageIcon(this.getClass().getResource("/aiconsb/b4s.png"));
    private JDialog ub;
    private at wU = null;
    private L wV = null;
    private L[] wW = null;
    private L wX = null;
    private at wY = null;
    private ArrayList cS = new ArrayList();
    private ArrayList vU = new ArrayList();
    boolean wA = false;
    boolean wZ = true;
    boolean xa = true;
    private JPanel xb = null;
    private ArrayList wK = new ArrayList();
    private ArrayList xc = new ArrayList();
    private ArrayList xd = new ArrayList();
    private ArrayList xe = new ArrayList();
    private ArrayList xf = new ArrayList();
    private ArrayList xg = new ArrayList();
    private ArrayList aeP = new ArrayList();
    private int xh = 0;
    private int xi = 0;
    private JLabel xj;
    private JLabel xk;
    private JLabel xl;
    private JLabel xm;
    private JLabel xn;
    private JLabel xo;
    private JLabel xp;
    private JLabel xq;
    private JLabel xr;
    private JLabel xs;
    private JLabel xt;
    private JLabel xu;
    private JLabel xv;
    private JLabel xw;
    private JLabel xx;
    private JButton uW;
    private JButton vm;
    private JButton uX;
    private JButton uY;
    private JButton xy;
    private JButton uZ;
    private JComboBox xz;
    private JComboBox va;
    private JLabel xA;
    private JLabel xB;
    private JLabel xC;
    private JLabel xD;
    private JLabel xE;
    private JLabel xF;
    private JLabel xG;
    private JLabel uh;
    private JLabel ur;
    private JLabel us;
    private JLabel vx;
    private JLabel vy;
    private JLabel vz;
    private JLabel vA;
    private JPanel vd;
    private JPanel wQ;
    private JScrollPane ut;
    private JScrollPane wi;
    private JToolBar ve;
    private JLabel xH;
    private JLabel xI;
    private JLabel xJ;
    private JLabel xK;
    private JLabel xL;
    private JLabel xM;
    private JLabel xN;
    private JLabel xO;
    private JLabel xP;
    private JLabel xQ;
    private JLabel xR;
    private JLabel xS;
    private JLabel xT;
    private JLabel xU;
    private JLabel xV;
    private JLabel xW;
    private JLabel xX;
    private JLabel xY;
    private JLabel xZ;
    private JLabel ya;
    private JLabel yb;
    private JLabel yc;
    private JPanel yd;
    private JPanel ye;
    private JPanel yf;
    private JPanel yg;
    private JPanel yh;
    private JTable wp;
    private JTable vN;

    public ay(JDialog jDialog, at at2) {
        this.ub = jDialog;
        this.wU = at2;
        this.mJ();
        this.yg.setVisible(false);
        this.mO();
        this.nv();
        this.nw();
        this.mG();
        int n2 = 0;
        if (this.wU != null) {
            if (this.wU.b() == 3) {
                n2 = 2;
            } else if (this.wU.b() == 4 || this.wU.b() == 5 || this.wU.b() == 6 || this.wU.b() == 8 || this.wU.b() == 12) {
                n2 = 1;
            } else if (this.wU.b() == 7 || this.wU.b() == 9) {
                n2 = 3;
            } else if (this.wU.b() == 10) {
                n2 = 4;
            } else if (this.wU.b() == 15) {
                n2 = a.SR.isJogaIntClubes() ? 1 : 0;
            }
        }
        this.mH();
        this.cM(n2);
        this.xN.setText(Integer.toString(a.SR.H() + a.SR.iU()));
    }

    private void mG() {
        this.setBackground(aq.E(a.vM().getCorTema(), 1));
        this.xI.setBackground(aq.E(a.vM().getCorTema(), 2));
        this.xI.setForeground(Color.WHITE);
        this.ut.setBorder(BorderFactory.createEmptyBorder());
        if (a.vM().getCorTema() == 2) {
            this.us.setBackground(aq.E(a.vM().getCorTema(), 2));
            this.uh.setBackground(aq.E(a.vM().getCorTema(), 2));
            this.ur.setBackground(aq.E(a.vM().getCorTema(), 2));
            this.vy.setBackground(aq.E(a.vM().getCorTema(), 2));
            this.vx.setBackground(aq.E(a.vM().getCorTema(), 2));
            this.vz.setBackground(aq.E(a.vM().getCorTema(), 2));
            this.vA.setBackground(aq.E(a.vM().getCorTema(), 2));
        }
        this.xH.setBackground(Color.LIGHT_GRAY);
    }

    private void cM(int n2) {
        this.cS = at.a(n2, false, 0);
        if (this.cS.size() > 0) {
            this.cA(n2);
            this.va.removeAllItems();
            if (n2 == 2) {
                Collections.sort(this.cS, h.a.abj);
            }
            int n3 = 0;
            while (n3 < this.cS.size()) {
                this.va.addItem(this.cS.get(n3));
                ++n3;
            }
            this.xa = false;
            if (this.cS.contains(this.wU)) {
                this.va.setSelectedItem(this.wU);
            } else if (this.va.getItemCount() > 0) {
                this.va.setSelectedIndex(0);
            }
        }
    }

    private void cC(int n2) {
        if (this.cS.size() > 0) {
            this.wU = (at)this.va.getSelectedItem();
        }
        if (this.wU != null && this.wU != this.wY) {
            this.wW = this.wU.mB();
            if (this.wW != null) {
                this.no();
                this.wV = this.wW[0];
                this.wZ = true;
                this.ns();
                if (this.xz.isVisible() && this.xz.getItemCount() > 0 && this.wV != null) {
                    int n3 = 0;
                    while (n3 < this.xz.getItemCount()) {
                        if (((y)this.xz.getItemAt(n3)).tY()[0] == this.wV) {
                            this.xz.setSelectedIndex(n3);
                            break;
                        }
                        ++n3;
                    }
                }
                this.wZ = false;
                this.nm();
                this.xz.setSelectedItem(this.wV);
                this.wY = this.wU;
            }
        }
    }

    private void cN(int n2) {
        if (this.wU != null) {
            if (((y)this.xz.getSelectedItem()).tY() != null) {
                this.wW = ((y)this.xz.getSelectedItem()).tY();
                this.wV = ((y)this.xz.getSelectedItem()).tY()[0];
                this.nm();
            } else {
                this.nn();
            }
        }
    }

    private void nm() {
        if (this.wV != null) {
            if (this.wV != this.wX) {
                this.nt();
                this.cO(1);
                this.wX = this.wV;
                if (this.wV instanceof z) {
                    if (this.wW.length > 1) {
                        int n2 = this.wW.length - 1;
                        while (n2 > 0) {
                            if (this.wW[n2] != null) {
                                this.a((z)this.wW[n2]);
                            }
                            --n2;
                        }
                    }
                    this.a((z)this.wV);
                    this.xH.setVisible(false);
                } else if (this.wV instanceof s) {
                    if (((s)this.wV).yK().size() > 0) {
                        this.i((s)this.wV);
                        this.xH.setVisible(true);
                    } else {
                        this.nn();
                    }
                }
                JViewport jViewport = this.ut.getViewport();
                jViewport.setView(this.xb);
            }
        } else {
            this.nn();
        }
    }

    private void nn() {
        this.nt();
        this.wX = null;
        this.cO(1);
        this.xH.setVisible(false);
        this.z("Ainda n\u00e3o definido");
        JViewport jViewport = this.ut.getViewport();
        jViewport.setView(this.xb);
    }

    private void no() {
        int n2 = 0;
        JLabel[] jLabelArray = new JLabel[]{this.xj, this.xk, this.xl, this.xm, this.xn};
        JLabel[] jLabelArray2 = new JLabel[]{this.xt, this.xu, this.xv, this.xw, this.xx};
        JLabel[] jLabelArray3 = new JLabel[]{this.xo, this.xp, this.xq, this.xr, this.xs};
        JLabel[] jLabelArray4 = new JLabel[]{this.xO, this.xP, this.xQ, this.xR, this.xS};
        JLabel[] jLabelArray5 = new JLabel[]{this.xT, this.xU, this.xV, this.xW, this.xX};
        JLabel[] jLabelArray6 = new JLabel[]{this.xY, this.xZ, this.ya, this.yb, this.yc};
        int n3 = 0;
        while (n3 < jLabelArray.length) {
            jLabelArray[n3].setText("(ainda n\u00e3o definido)");
            jLabelArray2[n3].setText("");
            jLabelArray3[n3].setText("");
            jLabelArray[n3].setIcon(null);
            ++n3;
        }
        n3 = 0;
        while (n3 < jLabelArray4.length) {
            jLabelArray4[n3].setText("(ainda n\u00e3o definido)");
            jLabelArray4[n3].setIcon(null);
            jLabelArray5[n3].setText("");
            jLabelArray6[n3].setText("");
            ++n3;
        }
        this.xE.setText("(ainda n\u00e3o h\u00e1 jogos)");
        this.xA.setText("(ainda n\u00e3o h\u00e1 goleadas)");
        this.xG.setIcon(null);
        this.xG.setText("(ainda n\u00e3o definido)");
        this.xB.setIcon(null);
        this.xC.setIcon(null);
        this.xD.setIcon(null);
        this.xB.setText("(ainda n\u00e3o definido)");
        this.xC.setText("");
        this.xD.setText("");
        n3 = 0;
        while (n3 < this.wU.ms().size()) {
            this.wU.mv();
            String string = "";
            if (((c)this.wU.ms().get(n3)).x().fg() != null) {
                if (aq.fs(this.wU.b())) {
                    string = ac.bl(((c)this.wU.ms().get(n3)).x().getPais());
                    ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/aflags/" + ((c)this.wU.ms().get(n3)).x().getPais() + ".png"));
                    jLabelArray[n3].setIcon(imageIcon);
                } else {
                    string = ((c)this.wU.ms().get(n3)).x().fg().getNome();
                    jLabelArray[n3].setIcon(((c)this.wU.ms().get(n3)).x().fg().kU());
                }
            } else {
                jLabelArray[n3].setIcon(null);
            }
            jLabelArray[n3].setText(String.valueOf(((c)this.wU.ms().get(n3)).x().getNome()) + " (" + string + ")");
            jLabelArray2[n3].setText(Integer.toString(((c)this.wU.ms().get(n3)).A()));
            jLabelArray3[n3].setText(Integer.toString(((c)this.wU.ms().get(n3)).y()));
            if (++n2 == 5) break;
            ++n3;
        }
        if (this.wU.mD() != null && this.wU.mD().size() >= 4) {
            this.nr();
        } else {
            this.wU.mz();
            this.nr();
        }
        if (this.wU.mE() != null) {
            this.np();
        } else {
            this.wU.my();
            this.np();
        }
        this.nq();
    }

    private void np() {
        this.xE.setText(String.valueOf(this.wU.mE().cQ()) + " (" + Integer.toString(this.wU.mE().y()) + " G/" + Integer.toString(this.wU.mE().A()) + " J)");
        if (this.wU.mE().cR() != null) {
            this.xA.setText(String.valueOf(this.wU.mE().cR().hc().getNome()) + " " + Integer.toString(this.wU.mE().cR().hu()) + " x " + Integer.toString(this.wU.mE().cR().hw()) + " " + this.wU.mE().cR().hd().getNome());
        }
        if (this.wU.mE().cS() != null) {
            this.xG.setText(this.wU.mE().cS().getNome());
            this.xG.setIcon(this.wU.mE().cS().kU());
        }
        if (this.wU.mE().cT() != null && this.wU.mE().cT().size() > 0) {
            JLabel[] jLabelArray = new JLabel[]{this.xB, this.xC, this.xD};
            int n2 = 0;
            while (n2 < this.wU.mE().cT().size()) {
                jLabelArray[n2].setText(String.valueOf(((an)this.wU.mE().cT().get(n2)).fg().getNome()) + " (" + Integer.toString(((an)this.wU.mE().cT().get(n2)).lX()) + ")");
                jLabelArray[n2].setIcon(((an)this.wU.mE().cT().get(n2)).fg().kU());
                if (n2 == jLabelArray.length - 1) break;
                ++n2;
            }
        }
    }

    private void nq() {
        String[] stringArray = this.wU.mA();
        ImageIcon imageIcon = aq.a(aq.x(stringArray[0]), 40, 55);
        this.xJ.setIcon(imageIcon);
    }

    private void nr() {
        JLabel[] jLabelArray = new JLabel[]{this.xO, this.xP, this.xQ, this.xR, this.xS};
        JLabel[] jLabelArray2 = new JLabel[]{this.xT, this.xU, this.xV, this.xW, this.xX};
        JLabel[] jLabelArray3 = new JLabel[]{this.xY, this.xZ, this.ya, this.yb, this.yc};
        if (this.wU.mD() != null && this.wU.mD().size() > 0) {
            int n2 = 0;
            while (n2 < this.wU.mD().size()) {
                String string = "";
                if (aq.fs(this.wU.b())) {
                    string = ac.bl(((X)this.wU.mD().get(n2)).x().getPais());
                    ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/aflags/" + ((X)this.wU.mD().get(n2)).x().getPais() + ".png"));
                    jLabelArray[n2].setIcon(imageIcon);
                } else if (((X)this.wU.mD().get(n2)).x().fg() != null) {
                    string = ((X)this.wU.mD().get(n2)).x().fg().getNome();
                    jLabelArray[n2].setIcon(((X)this.wU.mD().get(n2)).x().fg().kU());
                } else {
                    jLabelArray[n2].setIcon(null);
                }
                jLabelArray[n2].setText(String.valueOf(aq.rI[((X)this.wU.mD().get(n2)).x().getPosicao()]) + " - " + ((X)this.wU.mD().get(n2)).x().getNome() + " (" + string + ")");
                jLabelArray2[n2].setText(Integer.toString(((X)this.wU.mD().get(n2)).A()));
                jLabelArray3[n2].setText(((X)this.wU.mD().get(n2)).cE());
                ++n2;
            }
        }
    }

    private void ns() {
        this.xz.removeAllItems();
        if (this.wU.mC() != null) {
            this.xz.setVisible(true);
            int n2 = 0;
            while (n2 < this.wU.mC().size()) {
                this.xz.addItem(this.wU.mC().get(n2));
                ++n2;
            }
        } else {
            this.xz.setVisible(false);
        }
    }

    private void a(z z2) {
        String[] stringArray = this.wU.b(z2);
        if (stringArray == null && (stringArray = z2.zB()) != null && this.wU.mq() && stringArray.length > 0) {
            stringArray[stringArray.length - 1] = "Final e decis\u00e3o do 3\u00ba lugar";
        }
        int n2 = z2.zp().size() - 1;
        while (n2 >= 0) {
            if (n2 < stringArray.length) {
                this.z(stringArray[n2]);
            }
            int n3 = 0;
            while (n3 < ((f.G)z2.zp().get(n2)).zW().size()) {
                d d2 = new d();
                d2.l((I)((f.G)z2.zp().get(n2)).zW().get(n3));
                if (((f.G)z2.zp().get(n2)).hO()) {
                    d2.m((I)((f.G)z2.zp().get(n2)).zX().get(n3));
                }
                this.a(d2, ((f.G)z2.zp().get(n2)).zY());
                ++n3;
            }
            --n2;
        }
    }

    private void i(s s2) {
        this.vU.clear();
        if (s2.yK().size() > 0) {
            this.j(s2);
            if (s2 != null && s2.ze() != 1022) {
                this.o(s2);
            }
        }
        if (s2.yQ().size() == 0) {
            this.a(s2, "", true, 0);
        } else {
            if (this.wU.b() == 4 || this.wU.b() == 6 | this.wU.b() == 7 || this.wU.b() == 9) {
                this.wA = true;
            }
            String[] stringArray = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P"};
            int n2 = 0;
            while (n2 < s2.yQ().size()) {
                String string = Integer.toString(n2 + 1);
                if (this.wA) {
                    string = stringArray[n2];
                }
                this.a(s2, string, false, n2);
                ++n2;
            }
        }
        if (s2.yK().size() <= 0) {
            this.nn();
        }
    }

    private void a(e e2) {
        if (this.wK.contains(e2.fg())) {
            e2.dF(1);
            if (this.xd.contains(e2.fg())) {
                e2.dF(101);
            } else if (this.xe.contains(e2.fg())) {
                e2.dF(102);
            } else if (this.xf.contains(e2.fg())) {
                e2.dF(106);
            } else if (this.xg.contains(e2.fg())) {
                e2.dF(106);
            }
        } else if (this.xc.contains(e2.fg())) {
            e2.dF(3);
            if (this.xd.contains(e2.fg())) {
                e2.dF(301);
            } else if (this.xe.contains(e2.fg())) {
                e2.dF(302);
            } else if (this.xf.contains(e2.fg())) {
                e2.dF(306);
            } else if (this.xg.contains(e2.fg())) {
                e2.dF(106);
            }
        } else if (this.xd.contains(e2.fg())) {
            e2.dF(4);
        } else if (this.xe.contains(e2.fg())) {
            e2.dF(5);
        } else if (this.xf.contains(e2.fg())) {
            e2.dF(2);
        } else if (this.xg.contains(e2.fg())) {
            e2.dF(6);
        } else if (this.aeP.contains(e2.fg())) {
            e2.dF(12000);
        }
    }

    private void j(s s2) {
        this.xd.clear();
        this.xe.clear();
        this.xf.clear();
        this.xg.clear();
        this.wK.clear();
        this.aeP.clear();
        if (this.wU.b() == 9) {
            this.l(s2);
        } else if (this.wU.b() == 14) {
            this.s(s2);
        } else {
            this.n(s2);
            if (a.SR.isJogaIntClubes() && this.wU.b() == 1) {
                this.m(s2);
            }
        }
    }

    private void s(s s2) {
        int n2 = 0;
        while (n2 < s2.yQ().size()) {
            this.wK.add((ah)((G)s2.yQ().get(n2)).gR().get(0));
            if (s2.ze() == 14003) {
                this.xf.add((ah)((G)s2.yQ().get(n2)).gR().get(3));
            }
            ++n2;
        }
    }

    private void l(s s2) {
        int n2;
        int n3;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        if (s2.ze() == 7701) {
            n4 = 2;
        } else if (s2.ze() == 9001) {
            n4 = 1;
            n5 = 1;
            n6 = 2;
            n7 = 2;
            if (a.SR.bL().el() == 70) {
                n4 = 2;
                n5 = 0;
                n6 = 8;
                n7 = 2;
            }
        } else if (s2.ze() == 9100) {
            n4 = 6;
            n5 = 1;
        } else if (s2.ze() == 9201) {
            n4 = 1;
            n6 = 4;
            n7 = 1;
        } else if (s2.ze() == 9301) {
            n5 = 1;
            n6 = 4;
            n7 = 1;
        } else if (s2.ze() == 9302) {
            n4 = 4;
            n5 = 1;
        } else if (s2.ze() == 9400) {
            n5 = 1;
        } else if (s2.ze() == 9402) {
            n4 = 6;
            n5 = 1;
        } else if (s2.ze() == 9500) {
            n5 = 1;
        } else if (s2.ze() == 9501) {
            n5 = 2;
        }
        if (n4 > 0) {
            if (s2.yQ().size() == 0) {
                n3 = 0;
                while (n3 < n4) {
                    this.xd.add((ah)s2.yK().get(n3));
                    ++n3;
                }
            } else {
                n3 = 0;
                while (n3 < s2.yQ().size()) {
                    n2 = 0;
                    while (n2 < n4) {
                        this.xd.add((ah)((G)s2.yQ().get(n3)).gR().get(n2));
                        ++n2;
                    }
                    ++n3;
                }
            }
        }
        if (n5 > 0) {
            if (s2.yQ().size() == 0) {
                n3 = 0;
                n2 = n4;
                while (n2 < s2.yK().size()) {
                    this.xf.add((ah)s2.yK().get(n2));
                    if (++n3 != n5) {
                        ++n2;
                        continue;
                    }
                    break;
                }
            } else {
                n3 = 0;
                while (n3 < s2.yQ().size()) {
                    n2 = 0;
                    int n8 = n4;
                    while (n8 < ((G)s2.yQ().get(n3)).gR().size()) {
                        this.xf.add((ah)((G)s2.yQ().get(n3)).gR().get(n8));
                        if (++n2 == n5) break;
                        ++n8;
                    }
                    ++n3;
                }
            }
        }
        if (n6 > 0) {
            ArrayList<ah> arrayList = new ArrayList<ah>();
            n2 = 0;
            while (n2 < s2.yQ().size()) {
                arrayList.add((ah)((G)s2.yQ().get(n2)).gR().get(n7));
                ++n2;
            }
            s.r(s2);
            Collections.sort(arrayList, h.a.abn);
            n2 = 0;
            while (n2 < n6) {
                this.xf.add((ah)arrayList.get(n2));
                ++n2;
            }
        }
    }

    private void m(s s2) {
        Object object;
        ah ah2;
        int n2 = s2.yX();
        if (s2.ze() == 1022) {
            n2 = 2;
        }
        if ((ah2 = s2.fd(1)) != null) {
            this.xd.add(ah2);
        }
        if ((s2.vl().gg() == 1 || s2.vl().gg() == 0) && (object = s2.fd(2)) != null) {
            this.xd.add(object);
        }
        if (s2.getDivisao() == 1 && s2.b() == 1 && n2 == 0) {
            object = null;
            if (s2.vl() != null) {
                object = s2.vl().As();
            }
            if (object != null) {
                int n3;
                int n4;
                int n5;
                int n6;
                if (((al)object).uS() > 0) {
                    ah ah3 = null;
                    if (s2.vl().jq() != null) {
                        ah3 = s2.vl().jq().cS();
                    }
                    if (ah3 != null) {
                        this.xd.add(ah3);
                    }
                }
                if ((n6 = ((al)object).uO()) > 0) {
                    n5 = 0;
                    while (n5 < s2.yK().size()) {
                        if (n6 > 0 && !this.xd.contains(s2.yK().get(n5))) {
                            this.xd.add((ah)s2.yK().get(n5));
                            --n6;
                        }
                        ++n5;
                    }
                }
                if ((n5 = ((al)object).uP()) > 0) {
                    int n7 = 0;
                    while (n7 < s2.yK().size()) {
                        if (n5 > 0 && !this.xd.contains(s2.yK().get(n7))) {
                            this.xe.add((ah)s2.yK().get(n7));
                            --n5;
                        }
                        ++n7;
                    }
                }
                if (((al)object).uU() > 0) {
                    ah ah4 = null;
                    if (s2.vl().jq() != null) {
                        ah4 = s2.vl().jq().cS();
                    }
                    if (!(ah4 == null || this.xf.contains(ah4) || this.xd.contains(ah4) || this.xe.contains(ah4))) {
                        this.xf.add(ah4);
                    }
                }
                if ((n4 = ((al)object).uQ()) > 0) {
                    int n8 = 0;
                    while (n8 < s2.yK().size()) {
                        if (!(n4 <= 0 || this.xf.contains(s2.yK().get(n8)) || this.xd.contains(s2.yK().get(n8)) || this.xe.contains(s2.yK().get(n8)))) {
                            this.xf.add((ah)s2.yK().get(n8));
                            --n4;
                        }
                        ++n8;
                    }
                }
                if (((al)object).uV() > 0) {
                    ah ah5 = null;
                    if (s2.vl().jq() != null) {
                        ah5 = s2.vl().jq().cS();
                    }
                    if (!(ah5 == null || this.xf.contains(ah5) || this.xd.contains(ah5) || this.xe.contains(ah5) || this.xg.contains(ah5))) {
                        this.xf.add(ah5);
                    }
                }
                if ((n3 = ((al)object).uR()) > 0) {
                    int n9 = 0;
                    while (n9 < s2.yK().size()) {
                        if (!(n3 <= 0 || this.xf.contains(s2.yK().get(n9)) || this.xd.contains(s2.yK().get(n9)) || this.xe.contains(s2.yK().get(n9)) || this.xg.contains(s2.yK().get(n9)))) {
                            this.xg.add((ah)s2.yK().get(n9));
                            --n3;
                        }
                        ++n9;
                    }
                }
                if (s2.vl().gg() == 0) {
                    int n10;
                    if (((al)object).Ba() > 0) {
                        ah ah6 = null;
                        if (s2.vl().jq() != null) {
                            ah6 = s2.vl().jq().cS();
                        }
                        if (!(ah6 == null || this.aeP.contains(ah6) || this.xf.contains(ah6) || this.xd.contains(ah6) || this.xe.contains(ah6) || this.xg.contains(ah6))) {
                            this.aeP.add(ah6);
                        }
                    }
                    if ((n10 = ((al)object).AY()) > 0) {
                        int n11 = 0;
                        while (n11 < s2.yK().size()) {
                            if (!(n10 <= 0 || this.aeP.contains(s2.yK().get(n11)) || this.xf.contains(s2.yK().get(n11)) || this.xd.contains(s2.yK().get(n11)) || this.xe.contains(s2.yK().get(n11)) || this.xg.contains(s2.yK().get(n11)))) {
                                this.aeP.add((ah)s2.yK().get(n11));
                                --n10;
                            }
                            ++n11;
                        }
                    }
                }
            }
        }
    }

    private void n(s s2) {
        int n2;
        int n3;
        int n4 = s2.yX();
        if (s2.ze() == 1022) {
            n4 = 1;
        }
        if (n4 == 0) {
            if (s2.getDivisao() > 1) {
                int[] nArray = new int[3];
                if (s2.yT() instanceof B) {
                    nArray = ((B)s2.yT()).t(s2);
                } else if (s2.yT() instanceof o) {
                    nArray = ((o)s2.yT()).t(s2);
                }
                if (nArray[0] > 0) {
                    n3 = 0;
                    while (n3 < nArray[0]) {
                        this.wK.add((ah)s2.yK().get(n3));
                        ++n3;
                    }
                    if (nArray[1] > 0) {
                        n3 = 4;
                        n2 = nArray[0];
                        while (n2 < nArray[0] + n3) {
                            if (nArray[2] > 0) {
                                this.xe.add((ah)s2.yK().get(n2));
                            } else {
                                this.xf.add((ah)s2.yK().get(n2));
                            }
                            ++n2;
                        }
                    } else if (nArray[2] > 0) {
                        n3 = nArray[0] - nArray[2];
                        while (n3 < nArray[0]) {
                            this.xe.add((ah)s2.yK().get(n3));
                            ++n3;
                        }
                    }
                }
            }
        } else {
            int n5 = n4;
            if (s2.yQ().size() == 0 || s2.zl()) {
                n3 = 0;
                while (n3 < n5) {
                    this.wK.add((ah)s2.yK().get(n3));
                    ++n3;
                }
            } else {
                n3 = 0;
                while (n3 < s2.yQ().size()) {
                    n2 = 0;
                    while (n2 < n5) {
                        this.wK.add((ah)((G)s2.yQ().get(n3)).gR().get(n2));
                        ++n2;
                    }
                    if (s2.ze() == 4005) {
                        this.xf.add((ah)((G)s2.yQ().get(n3)).gR().get(2));
                    } else if (s2.ze() == 4104) {
                        this.xf.add((ah)((G)s2.yQ().get(n3)).gR().get(2));
                    } else if (s2.ze() == 6005) {
                        this.aeP.add((ah)((G)s2.yQ().get(n3)).gR().get(2));
                    }
                    ++n3;
                }
                if (!(s2.yQ().size() == 12 && s2.melhoresTerceiros || s2.yQ().size() != 17)) {
                    boolean cfr_ignored_0 = s2.melhoresTerceiros;
                }
            }
        }
        if (s2.ze() == 1403) {
            ArrayList<ah> arrayList = new ArrayList<ah>();
            n3 = 0;
            while (n3 < s2.yQ().size()) {
                if (((G)s2.yQ().get(n3)).gR().size() >= 2) {
                    arrayList.add((ah)((G)s2.yQ().get(n3)).gR().get(1));
                }
                ++n3;
            }
            s.r(s2);
            Collections.sort(arrayList, h.a.abn);
            n3 = 0;
            while (n3 < 6) {
                this.xe.add((ah)arrayList.get(n3));
                ++n3;
            }
        }
    }

    private void o(s s2) {
        block15: {
            block14: {
                this.xc.clear();
                if (s2.b() != 14) break block14;
                if (s2.ze() != 14001 && s2.ze() != 14002) break block15;
                int n2 = 0;
                while (n2 < 4) {
                    this.xc.add((ah)((G)s2.yQ().get(n2)).gR().get(3));
                    ++n2;
                }
                break block15;
            }
            if (s2.b() == 1 || s2.b() == 3) {
                int n3 = s2.getnRebaixados();
                boolean bl2 = s2.zc();
                if (s2.zc() && s2.yQ().size() > 0) {
                    n3 = Math.round(n3 / s2.yQ().size());
                }
                if (s2.zg() && s2.zh() < n3) {
                    n3 = s2.zh();
                }
                if (n3 > 0) {
                    int n4;
                    int n5;
                    ArrayList<ah> arrayList = new ArrayList<ah>();
                    if (bl2) {
                        n4 = n5 = 0;
                        while (n4 < s2.yQ().size()) {
                            int n6 = ((G)s2.yQ().get(n4)).gR().size() - 1;
                            while (n6 >= ((G)s2.yQ().get(n4)).gR().size() - n3) {
                                arrayList.add((ah)((G)s2.yQ().get(n4)).gR().get(n6));
                                --n6;
                            }
                            ++n4;
                        }
                    } else {
                        n5 = n3;
                        n4 = s2.yK().size() - 1;
                        while (n4 >= 0) {
                            if (n5 > 0 && !this.wK.contains(s2.yK().get(n4))) {
                                arrayList.add((ah)s2.yK().get(n4));
                                --n5;
                            }
                            --n4;
                        }
                    }
                    this.xc.addAll(arrayList);
                    if (s2.b() == 1 && !s2.zc() && (n5 = s2.Bw()) > 0) {
                        n4 = arrayList.size() - 1;
                        while (n4 >= 0) {
                            if (n5 > 0) {
                                this.xe.add((ah)arrayList.get(n4));
                                --n5;
                            }
                            --n4;
                        }
                    }
                }
            }
        }
    }

    private void nt() {
        this.xb = new JPanel(new b());
        this.xh = 0;
        this.xi = 0;
    }

    private void b(e e2) {
        if (e2.fg() != null) {
            this.a(e2);
            if (this.wU != null) {
                e2.a(this.wU.b());
            }
        }
        au au2 = new au(e2);
        this.xb.setBackground(aq.E(a.vM().getCorTema(), 1));
        this.xb.add((Component)au2, new components.a(0, this.xh, 470, 25));
        this.xh += 26;
    }

    private void a(d d2, ArrayList arrayList) {
        d2.a(this.wU.b());
        av av2 = new av(d2, arrayList);
        boolean bl2 = false;
        if (d2.sQ() != null) {
            bl2 = true;
        }
        int n2 = 55;
        if (!bl2) {
            n2 = 30;
        }
        this.xb.setBackground(aq.E(a.vM().getCorTema(), 1));
        this.xb.add((Component)av2, new components.a(0, this.xh, 470, n2));
        this.xh = this.xh + n2 + 1;
    }

    private void z(String string) {
        ax ax2 = new ax(string);
        int n2 = 8;
        if (this.xh == 0) {
            n2 = 0;
        }
        this.xb.setBackground(aq.E(a.vM().getCorTema(), 1));
        this.xb.add((Component)ax2, new components.a(0, this.xh + n2, 470, 25));
        this.xh = this.xh + 26 + n2;
    }

    private void A(String string) {
        ++this.xi;
        aw aw2 = new aw(string);
        if (this.xi > 1) {
            this.xh += 20;
        }
        this.xb.setBackground(aq.E(a.vM().getCorTema(), 1));
        this.xb.add((Component)aw2, new components.a(0, this.xh, 470, 25));
        this.xh += 26;
    }

    private void a(s s2, String string, boolean bl2, int n2) {
        e e2;
        int[] nArray = new int[8];
        int[] nArray2 = new int[8];
        String string2 = "";
        if (!bl2) {
            e2 = new e();
            e2.setInfo("Grupo " + string);
            e2.ak(true);
            this.A("Grupo " + string);
        } else {
            this.A("");
        }
        e2 = new e();
        e2.setInfo("topo");
        ArrayList arrayList = new ArrayList();
        arrayList = bl2 ? s2.yK() : ((G)s2.yQ().get(n2)).gR();
        int n3 = 0;
        while (n3 < arrayList.size()) {
            e e3 = new e();
            e3.n((ah)arrayList.get(n3));
            nArray = ((ah)arrayList.get(n3)).d(s2);
            e3.l(nArray);
            if (n3 == 0) {
                string2 = "1";
            } else if (n3 > 0) {
                nArray2 = ((ah)arrayList.get(n3 - 1)).d(s2);
                string2 = nArray[0] != nArray2[0] || nArray[2] != nArray2[2] || nArray[5] != nArray2[5] || nArray[7] != nArray2[7] ? Integer.toString(n3 + 1) : "";
            }
            e3.J(string2);
            this.b(e3);
            ++n3;
        }
    }

    private void nu() {
        if (this.vU.size() == 0 && this.wV instanceof s) {
            String string = String.valueOf(Integer.toString(((s)this.wV).zb() - 1)) + " \u00aa Rodada";
            ArrayList<best.a> arrayList = new ArrayList<best.a>();
            int n2 = 0;
            int n3 = 0;
            while (n3 < a.SR.R().size()) {
                int n4 = 0;
                while (n4 < ((best.a)a.SR.R().get(n3)).j().size()) {
                    if (((best.a)a.SR.R().get(n3)).j().get(n4) == this.wV) {
                        arrayList.add((best.a)a.SR.R().get(n3));
                        break;
                    }
                    ++n4;
                }
                ++n3;
            }
            n3 = 0;
            while (n3 < arrayList.size()) {
                w w2 = new w();
                w2.ao(true);
                w2.D(String.valueOf(Integer.toString(n3 + 1)) + "\u00aa Rodada");
                this.vU.add(w2);
                n2 = 0;
                int n5 = 0;
                while (n5 < ((best.a)arrayList.get(n3)).h().size()) {
                    if (((I)((best.a)arrayList.get(n3)).h().get(n5)).ht() == this.wV) {
                        w w3 = new w();
                        w3.n((I)((best.a)arrayList.get(n3)).h().get(n5));
                        this.vU.add(w3);
                        ++n2;
                    }
                    ++n5;
                }
                w w4 = new w();
                w4.ao(true);
                w4.D("");
                this.vU.add(w4);
                ++n3;
            }
            this.ne();
            this.vN.addNotify();
            n3 = 0;
            int n6 = 0;
            while (n6 < this.vU.size()) {
                if (((w)this.vU.get(n6)).sT() != null && ((w)this.vU.get(n6)).sT().equals(string)) {
                    n3 = n6;
                    break;
                }
                ++n6;
            }
            n6 = n3 + n2 * 2;
            if (n6 > this.vU.size() - 1) {
                n6 = n3 + n2;
            }
            if (n6 > this.vU.size() - 1) {
                n6 = n3;
            }
            this.vN.scrollRectToVisible(new Rectangle(this.vN.getCellRect(n6, 0, true)));
        }
    }

    private void ne() {
        l l2 = new l(this.vU);
        this.vN.setModel(l2);
        this.vN.setTableHeader(null);
        int[] nArray = new int[]{120, 30, 120};
        int n2 = 0;
        while (n2 < nArray.length) {
            this.vN.getColumnModel().getColumn(n2).setPreferredWidth(nArray[n2]);
            ++n2;
        }
        this.vN.setRowHeight(20);
        this.vN.setShowGrid(false);
        this.vN.setDefaultRenderer(w.class, new af());
        this.vN.setAutoCreateRowSorter(false);
        this.vN.setIntercellSpacing(new Dimension(0, 0));
        this.vN.setCellSelectionEnabled(false);
        this.vN.setRowSelectionAllowed(false);
        this.vN.setFillsViewportHeight(true);
    }

    private void cA(int n2) {
        JButton[] jButtonArray = new JButton[]{this.uY, this.uX, this.uW, this.uZ, this.xy};
        ImageIcon[] imageIconArray = new ImageIcon[]{this.uL, this.uM, this.uN, this.uO, this.uP};
        ImageIcon[] imageIconArray2 = new ImageIcon[]{this.uQ, this.uR, this.uS, this.uT, this.uU};
        int n3 = 0;
        while (n3 < jButtonArray.length) {
            jButtonArray[n3].setIcon(imageIconArray[n3]);
            ++n3;
        }
        jButtonArray[n2].setIcon(imageIconArray2[n2]);
    }

    private void nv() {
        aj aj2 = new aj();
        this.va.setPreferredSize(new Dimension(10, 25));
        this.va.setRenderer(aj2);
        this.va.setMaximumRowCount(24);
    }

    private void nw() {
        b.al al2 = new b.al();
        this.xz.setPreferredSize(new Dimension(10, 25));
        this.xz.setRenderer(al2);
        this.xz.setMaximumRowCount(24);
    }

    private void cO(int n2) {
        if (n2 == 1) {
            this.yg.setVisible(false);
            this.ye.setVisible(true);
            this.xI.setBackground(aq.E(a.vM().getCorTema(), 2));
            this.xI.setForeground(Color.WHITE);
            this.xH.setBackground(Color.LIGHT_GRAY);
            this.xH.setForeground(Color.BLACK);
        } else {
            this.yg.setVisible(true);
            this.ye.setVisible(false);
            this.xH.setBackground(aq.E(a.vM().getCorTema(), 2));
            this.xH.setForeground(Color.WHITE);
            this.xI.setBackground(Color.LIGHT_GRAY);
            this.xI.setForeground(Color.BLACK);
            this.nu();
        }
    }

    private void mH() {
        this.vm.addActionListener(new az(this));
        this.xI.addMouseListener(new aB(this));
        this.xH.addMouseListener(new aC(this));
        this.uY.addActionListener(new aD(this));
        this.uX.addActionListener(new aE(this));
        this.uW.addActionListener(new aF(this));
        this.uZ.addActionListener(new aG(this));
        this.xy.addActionListener(new aH(this));
        this.va.addActionListener(new aI(this));
        this.xz.addItemListener(new aA(this));
    }

    private void mO() {
        if (!a.SR.isJogaEstadual()) {
            this.uW.setVisible(false);
        }
        if (!a.SR.isJogaRegionais()) {
            this.xy.setVisible(false);
        }
        if (!a.SR.isJogaSelecoesAll()) {
            this.uZ.setVisible(false);
        }
        if (!a.SR.isJogaIntClubes()) {
            this.uX.setVisible(false);
        }
    }

    private void mJ() {
        this.vd = new JPanel();
        this.ve = new JToolBar();
        this.uY = new JButton();
        this.uX = new JButton();
        this.uZ = new JButton();
        this.uW = new JButton();
        this.xy = new JButton();
        this.vm = new JButton();
        this.xN = new JLabel();
        this.wQ = new JPanel();
        this.ut = new JScrollPane();
        this.wp = new JTable();
        this.xz = new JComboBox();
        this.va = new JComboBox();
        this.ye = new JPanel();
        this.yd = new JPanel();
        this.xt = new JLabel();
        this.xj = new JLabel();
        this.xn = new JLabel();
        this.xl = new JLabel();
        this.xk = new JLabel();
        this.xm = new JLabel();
        this.us = new JLabel();
        this.vx = new JLabel();
        this.vy = new JLabel();
        this.xo = new JLabel();
        this.xp = new JLabel();
        this.xu = new JLabel();
        this.xq = new JLabel();
        this.xv = new JLabel();
        this.xr = new JLabel();
        this.xw = new JLabel();
        this.xs = new JLabel();
        this.xx = new JLabel();
        this.yf = new JPanel();
        this.uh = new JLabel();
        this.xO = new JLabel();
        this.xS = new JLabel();
        this.xQ = new JLabel();
        this.xP = new JLabel();
        this.xR = new JLabel();
        this.vz = new JLabel();
        this.vA = new JLabel();
        this.xY = new JLabel();
        this.xT = new JLabel();
        this.xZ = new JLabel();
        this.xU = new JLabel();
        this.ya = new JLabel();
        this.xV = new JLabel();
        this.yb = new JLabel();
        this.xW = new JLabel();
        this.yc = new JLabel();
        this.xX = new JLabel();
        this.yh = new JPanel();
        this.ur = new JLabel();
        this.xK = new JLabel();
        this.xL = new JLabel();
        this.xD = new JLabel();
        this.xM = new JLabel();
        this.xF = new JLabel();
        this.xA = new JLabel();
        this.xB = new JLabel();
        this.xC = new JLabel();
        this.xJ = new JLabel();
        this.xG = new JLabel();
        this.xE = new JLabel();
        this.yg = new JPanel();
        this.wi = new JScrollPane();
        this.vN = new JTable();
        this.xH = new JLabel();
        this.xI = new JLabel();
        this.setBackground(new Color(0, 68, 105));
        this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.setLayout(new b());
        this.vd.setBackground(new Color(35, 28, 14));
        this.vd.setPreferredSize(new Dimension(483, 40));
        this.vd.setLayout(new b());
        this.ve.setBackground(new Color(35, 28, 14));
        this.ve.setFloatable(false);
        this.ve.setRollover(true);
        this.ve.setBorderPainted(false);
        this.uY.setIcon(new ImageIcon(this.getClass().getResource("/aiconsb/b0.png")));
        this.uY.setBorderPainted(false);
        this.uY.setContentAreaFilled(false);
        this.uY.setFocusable(false);
        this.uY.setHorizontalTextPosition(0);
        this.uY.setMargin(new Insets(0, 0, 0, 0));
        this.uY.setMaximumSize(new Dimension(79, 45));
        this.uY.setMinimumSize(new Dimension(79, 45));
        this.uY.setPreferredSize(new Dimension(79, 45));
        this.uY.setPressedIcon(new ImageIcon(this.getClass().getResource("/aiconsb/b0s.png")));
        this.uY.setRolloverIcon(new ImageIcon(this.getClass().getResource("/aiconsb/b0s.png")));
        this.uY.setVerticalTextPosition(3);
        this.ve.add(this.uY);
        this.uX.setIcon(new ImageIcon(this.getClass().getResource("/aiconsb/b1.png")));
        this.uX.setBorderPainted(false);
        this.uX.setContentAreaFilled(false);
        this.uX.setFocusable(false);
        this.uX.setHorizontalTextPosition(0);
        this.uX.setMargin(new Insets(0, 0, 0, 0));
        this.uX.setMaximumSize(new Dimension(79, 45));
        this.uX.setMinimumSize(new Dimension(79, 45));
        this.uX.setPreferredSize(new Dimension(79, 45));
        this.uX.setRolloverIcon(new ImageIcon(this.getClass().getResource("/aiconsb/b1s.png")));
        this.uX.setVerticalTextPosition(3);
        this.ve.add(this.uX);
        this.uZ.setIcon(new ImageIcon(this.getClass().getResource("/aiconsb/b3.png")));
        this.uZ.setBorderPainted(false);
        this.uZ.setContentAreaFilled(false);
        this.uZ.setFocusable(false);
        this.uZ.setHorizontalTextPosition(0);
        this.uZ.setMargin(new Insets(0, 0, 0, 0));
        this.uZ.setMaximumSize(new Dimension(79, 45));
        this.uZ.setMinimumSize(new Dimension(79, 45));
        this.uZ.setPreferredSize(new Dimension(79, 45));
        this.uZ.setRolloverIcon(new ImageIcon(this.getClass().getResource("/aiconsb/b3s.png")));
        this.uZ.setVerticalTextPosition(3);
        this.ve.add(this.uZ);
        this.uW.setIcon(new ImageIcon(this.getClass().getResource("/aiconsb/b2.png")));
        this.uW.setBorderPainted(false);
        this.uW.setContentAreaFilled(false);
        this.uW.setFocusable(false);
        this.uW.setHorizontalTextPosition(0);
        this.uW.setMargin(new Insets(0, 0, 0, 0));
        this.uW.setMaximumSize(new Dimension(79, 45));
        this.uW.setMinimumSize(new Dimension(79, 45));
        this.uW.setPreferredSize(new Dimension(79, 45));
        this.uW.setRolloverIcon(new ImageIcon(this.getClass().getResource("/aiconsb/b2s.png")));
        this.uW.setVerticalTextPosition(3);
        this.ve.add(this.uW);
        this.xy.setIcon(new ImageIcon(this.getClass().getResource("/aiconsb/b4.png")));
        this.xy.setBorderPainted(false);
        this.xy.setContentAreaFilled(false);
        this.xy.setFocusable(false);
        this.xy.setHorizontalTextPosition(0);
        this.xy.setMargin(new Insets(0, 0, 0, 0));
        this.xy.setMaximumSize(new Dimension(79, 45));
        this.xy.setMinimumSize(new Dimension(79, 45));
        this.xy.setPreferredSize(new Dimension(79, 45));
        this.xy.setRolloverIcon(new ImageIcon(this.getClass().getResource("/aiconsb/b4s.png")));
        this.xy.setVerticalTextPosition(3);
        this.ve.add(this.xy);
        this.vd.add((Component)this.ve, new components.a(0, 0, 600, 50));
        this.vm.setFont(new Font("Tahoma", 1, 12));
        this.vm.setText("X");
        this.vd.add((Component)this.vm, new components.a(740, 10, 55, -1));
        this.xN.setFont(new Font("Arial", 1, 14));
        this.xN.setForeground(new Color(255, 255, 255));
        this.xN.setHorizontalAlignment(0);
        this.xN.setText("2022");
        this.vd.add((Component)this.xN, new components.a(585, 15, 90, -1));
        this.add((Component)this.vd, new components.a(10, 20, 810, 48));
        this.wQ.setOpaque(false);
        this.wQ.setLayout(new b());
        this.ut.setHorizontalScrollBarPolicy(31);
        this.ut.setHorizontalScrollBar(null);
        this.ut.setViewportView(this.wp);
        this.wQ.add((Component)this.ut, new components.a(0, 40, 490, 570));
        this.wQ.add((Component)this.xz, new components.a(310, 0, 180, 25));
        this.wQ.add((Component)this.va, new components.a(0, 0, 290, 25));
        this.add((Component)this.wQ, new components.a(14, 90, 490, -1));
        this.ye.setOpaque(false);
        this.ye.setLayout(new b());
        this.yd.setBackground(new Color(204, 204, 204));
        this.yd.setLayout(new b());
        this.xt.setFont(new Font("Arial", 1, 12));
        this.xt.setHorizontalAlignment(0);
        this.xt.setText("25");
        this.xt.setName("");
        this.yd.add((Component)this.xt, new components.a(265, 30, 30, 20));
        this.xj.setFont(new Font("Arial", 1, 12));
        this.xj.setText("a1");
        this.yd.add((Component)this.xj, new components.a(5, 35, 210, 20));
        this.xn.setFont(new Font("Arial", 1, 12));
        this.xn.setText("a1");
        this.yd.add((Component)this.xn, new components.a(5, 155, 210, 20));
        this.xl.setFont(new Font("Arial", 1, 12));
        this.xl.setText("a1");
        this.yd.add((Component)this.xl, new components.a(5, 95, 210, 20));
        this.xk.setFont(new Font("Arial", 1, 12));
        this.xk.setText("a1");
        this.yd.add((Component)this.xk, new components.a(5, 65, 210, 20));
        this.xm.setFont(new Font("Arial", 1, 12));
        this.xm.setText("a1");
        this.yd.add((Component)this.xm, new components.a(5, 125, 210, 20));
        this.us.setBackground(new Color(0, 0, 0));
        this.us.setFont(new Font("Arial", 1, 12));
        this.us.setForeground(new Color(255, 255, 255));
        this.us.setText("  Artilheiros");
        this.us.setName("");
        this.us.setOpaque(true);
        this.yd.add((Component)this.us, new components.a(0, 0, 225, 30));
        this.vx.setBackground(new Color(0, 0, 0));
        this.vx.setFont(new Font("Arial", 1, 12));
        this.vx.setForeground(new Color(255, 255, 255));
        this.vx.setHorizontalAlignment(0);
        this.vx.setText("J");
        this.vx.setName("");
        this.vx.setOpaque(true);
        this.yd.add((Component)this.vx, new components.a(260, 0, 35, 30));
        this.vy.setBackground(new Color(0, 0, 0));
        this.vy.setFont(new Font("Arial", 1, 12));
        this.vy.setForeground(new Color(255, 255, 255));
        this.vy.setHorizontalAlignment(0);
        this.vy.setText("G");
        this.vy.setName("");
        this.vy.setOpaque(true);
        this.yd.add((Component)this.vy, new components.a(225, 0, 35, 30));
        this.xo.setFont(new Font("Arial", 1, 12));
        this.xo.setHorizontalAlignment(0);
        this.xo.setText("25");
        this.xo.setName("");
        this.yd.add((Component)this.xo, new components.a(225, 30, 30, 20));
        this.xp.setFont(new Font("Arial", 1, 12));
        this.xp.setHorizontalAlignment(0);
        this.xp.setText("25");
        this.xp.setName("");
        this.yd.add((Component)this.xp, new components.a(225, 65, 30, 20));
        this.xu.setFont(new Font("Arial", 1, 12));
        this.xu.setHorizontalAlignment(0);
        this.xu.setText("25");
        this.xu.setName("");
        this.yd.add((Component)this.xu, new components.a(265, 65, 30, 20));
        this.xq.setFont(new Font("Arial", 1, 12));
        this.xq.setHorizontalAlignment(0);
        this.xq.setText("25");
        this.xq.setName("");
        this.yd.add((Component)this.xq, new components.a(225, 95, 30, 20));
        this.xv.setFont(new Font("Arial", 1, 12));
        this.xv.setHorizontalAlignment(0);
        this.xv.setText("25");
        this.xv.setName("");
        this.yd.add((Component)this.xv, new components.a(265, 95, 30, 20));
        this.xr.setFont(new Font("Arial", 1, 12));
        this.xr.setHorizontalAlignment(0);
        this.xr.setText("25");
        this.xr.setName("");
        this.yd.add((Component)this.xr, new components.a(225, 125, 30, 20));
        this.xw.setFont(new Font("Arial", 1, 12));
        this.xw.setHorizontalAlignment(0);
        this.xw.setText("25");
        this.xw.setName("");
        this.yd.add((Component)this.xw, new components.a(265, 125, 30, 20));
        this.xs.setFont(new Font("Arial", 1, 12));
        this.xs.setHorizontalAlignment(0);
        this.xs.setText("25");
        this.xs.setName("");
        this.yd.add((Component)this.xs, new components.a(225, 155, 30, 20));
        this.xx.setFont(new Font("Arial", 1, 12));
        this.xx.setHorizontalAlignment(0);
        this.xx.setText("25");
        this.xx.setName("");
        this.yd.add((Component)this.xx, new components.a(265, 155, 30, 20));
        this.ye.add((Component)this.yd, new components.a(0, 0, 295, 175));
        this.yf.setBackground(new Color(204, 204, 204));
        this.yf.setLayout(new b());
        this.uh.setBackground(new Color(0, 0, 0));
        this.uh.setFont(new Font("Arial", 1, 12));
        this.uh.setForeground(new Color(255, 255, 255));
        this.uh.setText("  Melhores Notas M\u00e9dias");
        this.uh.setName("");
        this.uh.setOpaque(true);
        this.yf.add((Component)this.uh, new components.a(0, 0, 225, 30));
        this.xO.setFont(new Font("Arial", 1, 12));
        this.xO.setText("a1");
        this.yf.add((Component)this.xO, new components.a(5, 35, 210, 20));
        this.xS.setFont(new Font("Arial", 1, 12));
        this.xS.setText("a1");
        this.yf.add((Component)this.xS, new components.a(5, 155, 220, 20));
        this.xQ.setFont(new Font("Arial", 1, 12));
        this.xQ.setText("a1");
        this.yf.add((Component)this.xQ, new components.a(5, 95, 210, 20));
        this.xP.setFont(new Font("Arial", 1, 12));
        this.xP.setText("a1");
        this.yf.add((Component)this.xP, new components.a(5, 65, 200, 20));
        this.xR.setFont(new Font("Arial", 1, 12));
        this.xR.setText("a1");
        this.yf.add((Component)this.xR, new components.a(5, 125, 220, 20));
        this.vz.setBackground(new Color(0, 0, 0));
        this.vz.setFont(new Font("Arial", 1, 12));
        this.vz.setForeground(new Color(255, 255, 255));
        this.vz.setHorizontalAlignment(0);
        this.vz.setText("N");
        this.vz.setName("");
        this.vz.setOpaque(true);
        this.yf.add((Component)this.vz, new components.a(225, 0, 35, 30));
        this.vA.setBackground(new Color(0, 0, 0));
        this.vA.setFont(new Font("Arial", 1, 12));
        this.vA.setForeground(new Color(255, 255, 255));
        this.vA.setHorizontalAlignment(0);
        this.vA.setText("J");
        this.vA.setName("");
        this.vA.setOpaque(true);
        this.yf.add((Component)this.vA, new components.a(260, 0, 35, 30));
        this.xY.setFont(new Font("Arial", 1, 12));
        this.xY.setHorizontalAlignment(0);
        this.xY.setText("9,2");
        this.xY.setName("");
        this.yf.add((Component)this.xY, new components.a(225, 30, 30, 20));
        this.xT.setFont(new Font("Arial", 1, 12));
        this.xT.setHorizontalAlignment(0);
        this.xT.setText("25");
        this.xT.setName("");
        this.yf.add((Component)this.xT, new components.a(265, 30, 30, 20));
        this.xZ.setFont(new Font("Arial", 1, 12));
        this.xZ.setHorizontalAlignment(0);
        this.xZ.setText("9,2");
        this.xZ.setName("");
        this.yf.add((Component)this.xZ, new components.a(225, 65, 30, 20));
        this.xU.setFont(new Font("Arial", 1, 12));
        this.xU.setHorizontalAlignment(0);
        this.xU.setText("25");
        this.xU.setName("");
        this.yf.add((Component)this.xU, new components.a(265, 65, 30, 20));
        this.ya.setFont(new Font("Arial", 1, 12));
        this.ya.setHorizontalAlignment(0);
        this.ya.setText("9,2");
        this.ya.setName("");
        this.yf.add((Component)this.ya, new components.a(225, 95, 30, 20));
        this.xV.setFont(new Font("Arial", 1, 12));
        this.xV.setHorizontalAlignment(0);
        this.xV.setText("25");
        this.xV.setName("");
        this.yf.add((Component)this.xV, new components.a(265, 95, 30, 20));
        this.yb.setFont(new Font("Arial", 1, 12));
        this.yb.setHorizontalAlignment(0);
        this.yb.setText("9,2");
        this.yb.setName("");
        this.yf.add((Component)this.yb, new components.a(225, 125, 30, 20));
        this.xW.setFont(new Font("Arial", 1, 12));
        this.xW.setHorizontalAlignment(0);
        this.xW.setText("25");
        this.xW.setName("");
        this.yf.add((Component)this.xW, new components.a(265, 125, 30, 20));
        this.yc.setFont(new Font("Arial", 1, 12));
        this.yc.setHorizontalAlignment(0);
        this.yc.setText("9,2");
        this.yc.setName("");
        this.yf.add((Component)this.yc, new components.a(225, 155, 30, 20));
        this.xX.setFont(new Font("Arial", 1, 12));
        this.xX.setHorizontalAlignment(0);
        this.xX.setText("25");
        this.xX.setName("");
        this.yf.add((Component)this.xX, new components.a(265, 155, 30, 20));
        this.ye.add((Component)this.yf, new components.a(0, 185, 295, 175));
        this.yh.setBackground(new Color(204, 204, 204));
        this.yh.setLayout(new b());
        this.ur.setBackground(new Color(0, 0, 0));
        this.ur.setFont(new Font("Arial", 1, 12));
        this.ur.setForeground(new Color(255, 255, 255));
        this.ur.setText("  Estat\u00edsticas e hist\u00f3ria");
        this.ur.setToolTipText("");
        this.ur.setName("");
        this.ur.setOpaque(true);
        this.yh.add((Component)this.ur, new components.a(0, 0, 295, 30));
        this.xK.setFont(new Font("Arial", 1, 12));
        this.xK.setText("M\u00e9dia de gols:");
        this.yh.add((Component)this.xK, new components.a(5, 35, 100, 20));
        this.xL.setFont(new Font("Arial", 1, 12));
        this.xL.setText("Maior vencedor:");
        this.xL.setVerticalAlignment(1);
        this.yh.add((Component)this.xL, new components.a(5, 125, 110, 20));
        this.xD.setFont(new Font("Arial", 1, 12));
        this.xD.setText("Atual campe\u00e3o:");
        this.yh.add((Component)this.xD, new components.a(110, 175, 180, 20));
        this.xM.setFont(new Font("Arial", 1, 12));
        this.xM.setText("Maior goleada:");
        this.yh.add((Component)this.xM, new components.a(5, 65, 100, 20));
        this.xF.setFont(new Font("Arial", 1, 12));
        this.xF.setText("\u00daltimo campe\u00e3o:");
        this.yh.add((Component)this.xF, new components.a(5, 95, 100, 20));
        this.xA.setFont(new Font("Arial", 1, 12));
        this.xA.setText("\u00daltimo campe\u00e3o:");
        this.yh.add((Component)this.xA, new components.a(110, 65, 180, 20));
        this.xB.setFont(new Font("Arial", 1, 12));
        this.xB.setText("\u00daltimo campe\u00e3o:");
        this.yh.add((Component)this.xB, new components.a(110, 125, 180, 20));
        this.xC.setFont(new Font("Arial", 1, 12));
        this.xC.setText("\u00daltimo campe\u00e3o:");
        this.yh.add((Component)this.xC, new components.a(110, 150, 180, 20));
        this.xJ.setForeground(new Color(255, 255, 255));
        this.xJ.setHorizontalAlignment(0);
        this.xJ.setIcon(new ImageIcon(this.getClass().getResource("/aicons/trsmall.png")));
        this.xJ.setToolTipText("");
        this.yh.add((Component)this.xJ, new components.a(10, 145, 80, 55));
        this.xG.setFont(new Font("Arial", 1, 12));
        this.xG.setText("\u00daltimo campe\u00e3o:");
        this.yh.add((Component)this.xG, new components.a(110, 95, 180, 20));
        this.xE.setFont(new Font("Arial", 1, 12));
        this.xE.setText("\u00daltimo campe\u00e3o:");
        this.yh.add((Component)this.xE, new components.a(110, 35, 180, 20));
        this.ye.add((Component)this.yh, new components.a(0, 370, 295, 205));
        this.add((Component)this.ye, new components.a(520, 90, 300, 580));
        this.wi.setViewportView(this.vN);
        GroupLayout groupLayout = new GroupLayout(this.yg);
        this.yg.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 303, Short.MAX_VALUE).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(this.wi, -2, 303, -2).addGap(0, 0, Short.MAX_VALUE))));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 536, Short.MAX_VALUE).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(this.wi, -2, 536, -2).addGap(0, 0, Short.MAX_VALUE))));
        this.add((Component)this.yg, new components.a(520, 130, -1, 530));
        this.xH.setHorizontalAlignment(0);
        this.xH.setText("Rodadas");
        this.xH.setOpaque(true);
        this.add((Component)this.xH, new components.a(620, 675, 90, 25));
        this.xI.setHorizontalAlignment(0);
        this.xI.setText("Estat\u00edsticas");
        this.xI.setOpaque(true);
        this.add((Component)this.xI, new components.a(520, 675, 90, 25));
    }

    static /* synthetic */ JDialog a(ay ay2) {
        return ay2.ub;
    }

    static /* synthetic */ void a(ay ay2, int n2) {
        ay2.cO(n2);
    }

    static /* synthetic */ void b(ay ay2, int n2) {
        ay2.cM(n2);
    }

    static /* synthetic */ JComboBox b(ay ay2) {
        return ay2.va;
    }

    static /* synthetic */ void c(ay ay2, int n2) {
        ay2.cC(n2);
    }

    static /* synthetic */ JComboBox c(ay ay2) {
        return ay2.xz;
    }

    static /* synthetic */ void d(ay ay2, int n2) {
        ay2.cN(n2);
    }
}

