/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.C;
import a.bg;
import a.cD;
import a.dW;
import a.dX;
import a.dY;
import a.dZ;
import a.ea;
import a.eb;
import a.ec;
import a.ed;
import a.ee;
import a.ef;
import a.gb;
import a.gh;
import b.M;
import b.aG;
import best.A;
import best.I;
import best.L;
import best.ad;
import best.ah;
import best.aq;
import best.at;
import best.s;
import c.a;
import components.b;
import f.H;
import f.r;
import f.v;
import f.x;
import f.z;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Window;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle;
import javax.swing.Timer;

public class dV
extends JPanel {
    private static JFrame Br;
    private static dV GS;
    private static ArrayList vK;
    private static int GT;
    public Timer GO = null;
    private static int d;
    private static int dB;
    private boolean GU = false;
    private int GV = -1;
    private int GW = -1;
    private Color GX = new Color(51, 102, 0);
    private static ArrayList zD;
    private static ArrayList zE;
    private static ArrayList GY;
    private static boolean GZ;
    private int Ha = 720;
    private static at Hb;
    private static int Hc;
    private AudioInputStream[] Hd = new AudioInputStream[7];
    private static Clip[] He;
    private JLabel uh;
    private JProgressBar Hf;
    private JScrollPane ut;
    private JLabel Hg;
    private JLabel xI;
    private JLabel Hh;
    private JLabel Hi;
    private JLabel Hj;
    private JLabel Hk;
    private JLabel Hl;
    private JLabel Hm;
    private JLabel Hn;
    private JLabel Ho;
    private JLabel Hp;
    private JPanel Hq;
    private JPanel Hr;
    private JTable Hs;
    private JLabel zM;
    private JLabel Ht;

    static {
        vK = new ArrayList();
        GT = 0;
        d = 1;
        dB = 1;
        zD = new ArrayList();
        zE = new ArrayList();
        GY = new ArrayList();
        GZ = true;
        Hb = null;
        Hc = -1;
        He = new Clip[7];
    }

    public dV(JFrame jFrame, int n2) {
        Br = jFrame;
        GS = this;
        this.Ha = n2;
        this.mJ();
        this.Hf.setStringPainted(false);
        this.Hf.setForeground(this.GX);
        this.Hf.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        this.Hf.setMaximum(45);
        this.nc();
        this.mY();
    }

    private void mY() {
        try {
            this.a(this.Hr);
            this.a(this.ut);
            this.a(this.Hs);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    private void a(JComponent jComponent) {
        InputMap inputMap = jComponent.getInputMap(1);
        jComponent.getInputMap().put(KeyStroke.getKeyStroke(112, 0), "f1");
        jComponent.getInputMap().put(KeyStroke.getKeyStroke(113, 0), "f2");
        jComponent.getInputMap().put(KeyStroke.getKeyStroke(114, 0), "f3");
        jComponent.getInputMap().put(KeyStroke.getKeyStroke(115, 0), "f4");
        jComponent.getInputMap().put(KeyStroke.getKeyStroke(116, 0), "f5");
        if (a.vL()) {
            jComponent.getInputMap().put(KeyStroke.getKeyStroke(116, 0), "f6");
        }
        jComponent.getInputMap().put(KeyStroke.getKeyStroke(10, 0), "st");
        jComponent.getInputMap().put(KeyStroke.getKeyStroke(32, 0), "st");
        ActionMap actionMap = this.getActionMap();
        jComponent.getActionMap().put("st", new dW(this));
        jComponent.getActionMap().put("f1", new dY(this));
        jComponent.getActionMap().put("f2", new dZ(this));
        jComponent.getActionMap().put("f3", new ea(this));
        jComponent.getActionMap().put("f4", new eb(this));
        jComponent.getActionMap().put("f5", new ec(this));
        jComponent.getActionMap().put("f6", new ed(this));
    }

    private void setVelocidade(int n2) {
        if (n2 < aq.rz.length) {
            d = aq.rz[n2];
        }
    }

    public void Y(ArrayList arrayList) {
        Rectangle rectangle;
        Object object;
        int n2;
        int n3;
        GT = 0;
        vK.clear();
        dB = 1;
        this.GU = false;
        GZ = true;
        int n4 = 0;
        while (n4 < arrayList.size()) {
            n3 = 1;
            n2 = 0;
            while (n2 < a.SR.S().size()) {
                if (((I)a.SR.S().get(n2)).hy() == arrayList.get(n4)) {
                    if (n3 != 0) {
                        if (n4 == 0) {
                            this.a(((I)a.SR.S().get(n2)).hy(), ((I)a.SR.S().get(n2)).ht());
                        }
                        if (n4 != -1) {
                            object = new components.v();
                            ((components.v)object).L(this.a(((I)a.SR.S().get(n2)).hy(), (I)a.SR.S().get(n2), ((I)a.SR.S().get(n2)).ht()));
                            vK.add(object);
                        }
                        n3 = 0;
                    }
                    object = new components.v();
                    ((components.v)object).n((I)a.SR.S().get(n2));
                    ((components.v)object).tW();
                    if (((components.v)object).tR().hc() != null) {
                        ((components.v)object).tR().hc().Q(((components.v)object).tR().hp());
                        ((components.v)object).tR().hc().O(((components.v)object).tR().hp());
                    }
                    if (((components.v)object).tR().hd() != null) {
                        ((components.v)object).tR().hd().Q(((components.v)object).tR().hq());
                        ((components.v)object).tR().hd().O(((components.v)object).tR().hq());
                    }
                    if (((I)a.SR.S().get(n2)).hy().b() == 7) {
                        rectangle = null;
                        ((components.v)object).p(((components.v)object).tR().ik());
                    } else if (((components.v)object).tR().ev() == null) {
                        if (((I)a.SR.S().get(n2)).hy().b() == 4) {
                            if (((I)a.SR.S().get(n2)).hy() instanceof v) {
                                ((components.v)object).p(v.yD());
                            } else if (((I)a.SR.S().get(n2)).hy() instanceof r) {
                                ((components.v)object).p(r.yD());
                            }
                        } else if (((I)a.SR.S().get(n2)).hy().b() == 6) {
                            if (((I)a.SR.S().get(n2)).hy() instanceof H) {
                                ((components.v)object).p(H.yD());
                            } else if (((I)a.SR.S().get(n2)).hy() instanceof x) {
                                ((components.v)object).p(x.yD());
                            }
                        }
                    }
                    vK.add(object);
                }
                ++n2;
            }
            ++n4;
        }
        n4 = 0;
        this.GW = -1;
        n3 = 0;
        n2 = 0;
        while (n2 < vK.size()) {
            if (((components.v)vK.get(n2)).ei()) {
                n4 = 1;
                this.GW = n2;
                break;
            }
            ++n2;
        }
        n2 = 0;
        while (n2 < vK.size()) {
            if (((components.v)vK.get(n2)).ei()) {
                ++n3;
            }
            ++n2;
        }
        if (n4 != 0 && this.GW >= 0) {
            this.pZ();
        } else {
            this.Hr.setVisible(false);
        }
        n2 = a.SR.getVelocidade();
        if (n4 == 0) {
            n2 = a.SR.getVelocidadeNH();
        }
        d = n4 != 0 ? aq.rz[n2] : aq.rA[n2];
        if (a.SR.bD()) {
            d = 1;
        }
        dV.GS.Hs.addNotify();
        if (this.GW >= 20) {
            object = (JViewport)dV.GS.Hs.getParent();
            rectangle = dV.GS.Hs.getCellRect(this.GW + 8, 0, true);
            Point point = ((JViewport)object).getViewPosition();
            rectangle.setLocation(rectangle.x - point.x, rectangle.y - point.y);
            dV.GS.Hs.scrollRectToVisible(rectangle);
        }
        Hc = this.GW;
        this.qf();
        this.oR();
    }

    public void pZ() {
        this.Hr.setVisible(true);
        this.Hp.setBackground(((components.v)vK.get(this.GW)).tR().hc().kB());
        this.Hp.setForeground(((components.v)vK.get(this.GW)).tR().hc().kC());
        this.Hp.setText(String.valueOf(((components.v)vK.get(this.GW)).tR().hc().getNome()) + " ");
        this.Ho.setBackground(((components.v)vK.get(this.GW)).tR().hd().kB());
        this.Ho.setForeground(((components.v)vK.get(this.GW)).tR().hd().kC());
        this.Ho.setText(" " + ((components.v)vK.get(this.GW)).tR().hd().getNome());
        this.Hh.setIcon(((components.v)vK.get(this.GW)).tR().hc().kP());
        this.Hi.setIcon(((components.v)vK.get(this.GW)).tR().hd().kP());
        if (((components.v)vK.get(this.GW)).tR().ev() != null) {
            this.Hl.setText(((components.v)vK.get(this.GW)).tR().ev().dS());
            this.Hm.setText(Integer.toString(((components.v)vK.get(this.GW)).hU()));
        } else if (((components.v)vK.get(this.GW)).ik() != null) {
            this.Hl.setText(((components.v)vK.get(this.GW)).ik());
            this.Hm.setText("");
        } else {
            this.Hl.setText("");
            this.Hm.setText("");
        }
        this.Hj.setText("");
        this.Hk.setText("");
        this.Hj.setIcon(null);
        this.Hk.setIcon(null);
        this.Hn.setText("0 x 0");
        this.xI.setText("");
        if (((components.v)vK.get(this.GW)).tR().hy() != null) {
            this.Ht.setText(this.a(((components.v)vK.get(this.GW)).tR().hy(), ((components.v)vK.get(this.GW)).tR(), ((components.v)vK.get(this.GW)).tR().ht()));
        } else {
            this.Ht.setText("");
        }
    }

    private String a(at at2, I i2, L l2) {
        String string = "";
        if (at2.b() == 3 && a.SR.isVerEstaduaisAgrupados()) {
            string = String.valueOf(aq.rZ[at2.el()]) + " - " + at2.is() + " - " + i2.hJ()[1];
        } else if (at2.b() == 3) {
            string = String.valueOf(at2.is()) + " - " + i2.hJ()[1];
        } else if (at2.b() == 1) {
            string = String.valueOf(at2.is()) + " - " + i2.hJ()[1];
            if (l2 != null && l2 instanceof z) {
                if (((z)l2).zf() == 1099) {
                    string = "Mata Mata Ascenso - " + i2.hJ()[1];
                } else if (((z)l2).zf() == 1098) {
                    string = "Playoff rebaixamento - " + i2.hJ()[1];
                }
            }
        } else if (at2.b() == 10) {
            string = String.valueOf(at2.getNome()) + " - " + i2.hJ()[1];
        } else if (at2.b() == 7 && at2.el() != 7) {
            string = String.valueOf(at2.getNome()) + " - " + i2.hJ()[1];
        } else if (at2.b() == 9) {
            if (at2.el() < aq.sa.length) {
                string = String.valueOf(aq.sa[at2.el()]) + " - " + i2.hJ()[1];
            } else if (at2.el() == 70) {
                string = "Classificat\u00f3rio Eurocopa - " + i2.hJ()[1];
            }
            if (l2 != null && l2 instanceof f.s && ((f.s)l2).ze() == 7701) {
                string = "Torneio Repescagem";
            }
        } else {
            string = at2 instanceof f.I ? "Supercopa " + ad.bt(((f.I)at2).getPais()) : (at2.b() == 8 ? at2.getNome() : i2.hJ()[1]);
        }
        return string;
    }

    private void a(at at2, L l2) {
        String string = "";
        if (at2 != null) {
            if (at2.b() == 3) {
                string = a.SR.isVerEstaduaisAgrupados() ? "Campeonatos estaduais" : "Campeonato " + aq.rZ[at2.el()];
            } else if (at2.b() == 1) {
                if (at2.iq() != null) {
                    string = "Campeonato " + ad.bs(at2.iq().jc());
                }
            } else if (at2.b() == 10) {
                string = "Regional";
            } else if (at2.b() == 7 && at2.el() != 7) {
                string = "Copas de Sele\u00e7\u00f5es";
            } else if (at2.b() == 7 && at2.el() == 7) {
                string = "Copas do Mundo";
            } else if (at2.b() == 11) {
                string = "Supercopa Nacional";
            } else if (at2.b() == 8) {
                string = "Recopa";
            } else if (at2.b() == 9) {
                string = "Eliminat\u00f3rias";
                if (l2 != null && l2 instanceof f.s && ((f.s)l2).ze() == 7701) {
                    string = "Eliminat\u00f3rias - Repescagem";
                }
            } else {
                string = at2.getNome();
            }
        }
        this.Hg.setText(string);
    }

    public void oR() {
        if (this.GO == null) {
            this.GO = new Timer(d, new ee(this));
            this.GO.setRepeats(false);
            this.GO.start();
        } else {
            this.GO.restart();
        }
    }

    public void qa() {
        boolean bl2 = false;
        ++GT;
        if (dB == 1) {
            if (GT > 48) {
                this.qg();
            }
        } else if (dB == 2 && GT >= 51) {
            bl2 = true;
        }
        if (dV.qj() < 45) {
            this.uh.setText(String.valueOf(Integer.toString(dV.qj())) + "'" + " - " + Integer.toString(dB) + "\u00ba tempo");
            this.Hf.setValue(dV.qj());
        } else {
            this.uh.setText("Acr\u00e9scimos");
        }
        if (bl2) {
            this.uh.setText("Fim de jogo");
            this.qc();
        } else {
            this.aa(false);
        }
    }

    public static void qb() {
        try {
            int n2 = 0;
            while (n2 < He.length) {
                if (He[n2] != null) {
                    He[n2].close();
                    dV.He[n2] = null;
                }
                ++n2;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    private void qc() {
        if (!this.GU) {
            this.GU = true;
            this.dk(1);
            this.qe();
            this.qd();
            if (GY.size() > 0) {
                int n2 = 0;
                while (n2 < GY.size()) {
                    this.g((I)GY.get(n2));
                    ++n2;
                }
            }
            s.dJ();
        }
    }

    private void g(I i2) {
        Serializable serializable;
        Serializable serializable2;
        if (!i2.hc().jZ().booleanValue() && !i2.hd().jZ().booleanValue()) {
            serializable2 = new ArrayList();
            ((ArrayList)serializable2).addAll(i2.hp());
            Collections.sort(serializable2, h.a.abg);
            zD = serializable2;
            serializable = new ArrayList();
            serializable.addAll(i2.hq());
            Collections.sort(serializable, h.a.abg);
            zE = serializable;
        } else {
            if (i2.hc().jZ().booleanValue()) {
                this.a(i2, i2.hc());
            } else {
                serializable2 = new ArrayList();
                ((ArrayList)serializable2).addAll(i2.hp());
                Collections.sort(serializable2, h.a.abg);
                zD = serializable2;
            }
            if (i2.hd().jZ().booleanValue()) {
                this.a(i2, i2.hd());
            } else {
                serializable2 = new ArrayList();
                ((ArrayList)serializable2).addAll(i2.hq());
                Collections.sort(serializable2, h.a.abg);
                zE = serializable2;
            }
        }
        serializable2 = new JDialog(Br);
        serializable = new bg((JDialog)serializable2, i2);
        ((Container)serializable2).add((Component)serializable);
        ((Window)serializable2).setSize(469, 602);
        ((Component)serializable2).setPreferredSize(new Dimension(469, 602));
        ((Dialog)serializable2).setModal(true);
        ((Dialog)serializable2).setResizable(false);
        ((Window)serializable2).setLocationRelativeTo(null);
        ((Dialog)serializable2).setUndecorated(true);
        ((Dialog)serializable2).setVisible(true);
    }

    private void a(I i2, ah ah2) {
        JDialog jDialog = new JDialog(Br);
        C c2 = new C(jDialog, ah2, i2);
        jDialog.add(c2);
        jDialog.setSize(500, 519);
        jDialog.setPreferredSize(new Dimension(500, 519));
        jDialog.setModal(true);
        jDialog.setResizable(false);
        jDialog.setLocationRelativeTo(null);
        jDialog.setUndecorated(true);
        jDialog.setVisible(true);
    }

    private void qd() {
        GY.clear();
        int n2 = 0;
        while (n2 < vK.size()) {
            if (((components.v)vK.get(n2)).tR() != null && ((components.v)vK.get(n2)).tR().hS() && ((components.v)vK.get(n2)).tR().hk()) {
                if (((components.v)vK.get(n2)).tR().hc().jZ().booleanValue() || ((components.v)vK.get(n2)).tR().hd().jZ().booleanValue()) {
                    GY.add(((components.v)vK.get(n2)).tR());
                } else if (a.SR.getVerDecisaoPenNaoHumano() == 1) {
                    GY.add(((components.v)vK.get(n2)).tR());
                }
            }
            ++n2;
        }
    }

    public void qe() {
        int n2 = 0;
        while (n2 < vK.size()) {
            boolean bl2 = false;
            if (((components.v)vK.get(n2)).tR() != null && ((components.v)vK.get(n2)).tR().hu() != ((components.v)vK.get(n2)).tT()) {
                bl2 = true;
            }
            if (bl2) {
                ((components.v)vK.get(n2)).tR().hF();
            }
            ++n2;
        }
    }

    public File dj(int n2) {
        return a.dj(n2);
    }

    private void qf() {
        if (a.SR.isUsaSons()) {
            int n2 = 0;
            while (n2 < this.Hd.length) {
                File file = this.dj(n2);
                if (file != null) {
                    try {
                        this.Hd[n2] = AudioSystem.getAudioInputStream(file);
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                }
                ++n2;
            }
        }
    }

    public void dk(int n2) {
        if (a.SR.isUsaSons()) {
            Object var2_2 = null;
            if (n2 < this.Hd.length && this.Hd[n2] != null) {
                if (He[n2] == null) {
                    try {
                        dV.He[n2] = AudioSystem.getClip();
                        He[n2].open(this.Hd[n2]);
                    }
                    catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
                if (He[n2] != null) {
                    try {
                        He[n2].stop();
                        He[n2].setFramePosition(0);
                        He[n2].start();
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                }
            }
        }
    }

    public void dl(int n2) {
        if (a.SR.isUsaSons()) {
            AudioInputStream audioInputStream = null;
            Clip clip = null;
            try {
                File file = this.dj(n2);
                if (file != null) {
                    audioInputStream = AudioSystem.getAudioInputStream(file);
                }
            }
            catch (UnsupportedAudioFileException unsupportedAudioFileException) {
                unsupportedAudioFileException.printStackTrace();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
            try {
                if (audioInputStream != null) {
                    clip = AudioSystem.getClip();
                    clip.open(audioInputStream);
                    clip.start();
                }
            }
            catch (LineUnavailableException lineUnavailableException) {
                lineUnavailableException.printStackTrace();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }

    public boolean dm(int n2) {
        Object object;
        if (!a.SR.isUsaSons()) {
            return false;
        }
        AudioInputStream audioInputStream = null;
        try {
            object = this.dj(n2);
            if (object != null) {
                audioInputStream = AudioSystem.getAudioInputStream((File)object);
            }
        }
        catch (UnsupportedAudioFileException unsupportedAudioFileException) {
            unsupportedAudioFileException.printStackTrace();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        try {
            if (audioInputStream != null) {
                object = AudioSystem.getClip();
                object.open(audioInputStream);
                object.start();
                object.close();
            }
        }
        catch (LineUnavailableException lineUnavailableException) {
            lineUnavailableException.printStackTrace();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        return true;
    }

    public void qg() {
        int n2;
        GT = 0;
        dB = 2;
        if (a.SR.getVerJanelaSubs() == 1) {
            this.dk(0);
            this.uh.setText("Intervalo");
            n2 = 0;
            while (n2 < vK.size()) {
                if (((components.v)vK.get(n2)).ei()) {
                    this.e(n2, true);
                }
                ++n2;
            }
        }
        n2 = 0;
        while (n2 < vK.size()) {
            if (((components.v)vK.get(n2)).ei()) {
                ((components.v)vK.get(n2)).tR().m(2, 0);
            }
            ++n2;
        }
        this.Hj.setText("");
        this.Hj.setIcon(null);
        this.Hk.setIcon(null);
        this.Hk.setText("");
    }

    public void aa(boolean bl2) {
        int n2;
        if (!bl2) {
            n2 = 0;
            while (n2 < vK.size()) {
                if (((components.v)vK.get(n2)).ei()) {
                    int[] nArray = ((components.v)vK.get(n2)).tR().ib();
                    if (nArray[dB] <= GT) {
                        ((components.v)vK.get(n2)).tR().q(GT, dB);
                    }
                    if (n2 == this.GW) {
                        this.xI.setText(((components.v)vK.get(n2)).tR().ha());
                    }
                }
                ++n2;
            }
        }
        n2 = 0;
        while (n2 < vK.size()) {
            if (((components.v)vK.get(n2)).tR() != null) {
                int n3 = 0;
                while (n3 < ((components.v)vK.get(n2)).tR().hE().size()) {
                    if (!((A)((components.v)vK.get(n2)).tR().hE().get(n3)).isDone() && ((A)((components.v)vK.get(n2)).tR().hE().get(n3)).en() == dB && ((A)((components.v)vK.get(n2)).tR().hE().get(n3)).em() <= GT) {
                        this.a((components.v)vK.get(n2), ((components.v)vK.get(n2)).tR(), (A)((components.v)vK.get(n2)).tR().hE().get(n3), n2);
                    }
                    ++n3;
                }
            }
            ++n2;
        }
        if (dV.GS.GV >= 0) {
            GZ = false;
            GS.e(dV.GS.GV, false);
            GZ = true;
            dV.GS.GV = -1;
        }
        dV.GS.Hs.addNotify();
        if (GZ) {
            GS.oR();
        }
    }

    public void a(components.v v2, I i2, A a2, int n2) {
        if (a2.b() == 8) {
            a2.p(true);
        }
        if (!a2.isDone()) {
            a2.p(true);
            int n3 = 0;
            if (a2.cu() == i2.hc()) {
                n3 = 1;
            } else if (a2.cu() == i2.hd()) {
                n3 = 2;
            }
            if (n3 > 0) {
                v2.a(a2);
                if (a2.b() == 1) {
                    if (a2.el() == 3 && v2.ei()) {
                        this.dk(4);
                        if (!a2.cu().jZ().booleanValue()) {
                            this.b(v2, a2);
                        } else {
                            this.a(v2, a2);
                        }
                        a2.q(true);
                    } else {
                        v2.dJ(n3);
                        if (v2.ei()) {
                            if (a2.cu().jZ().booleanValue()) {
                                this.dk(2);
                            } else {
                                this.dk(3);
                            }
                        }
                    }
                } else if (a2.b() == 3 || a2.b() == 4) {
                    if (v2.ei()) {
                        this.dk(5);
                    }
                    if (a2.cu().jZ().booleanValue()) {
                        GS.e(n2, false);
                    }
                } else if (a2.b() == 5) {
                    if (v2.ei()) {
                        this.dk(6);
                    }
                    if (a2.cu().jZ().booleanValue()) {
                        GS.e(n2, false);
                    }
                }
            }
            dV.GS.Hs.addNotify();
            if (this.Hr.isVisible() && this.GW >= 0 && this.GW == n2) {
                this.Hn.setText(String.valueOf(v2.tT()) + " x " + v2.tU());
                if (n3 == 1) {
                    this.Hj.setText(v2.tV().er());
                    this.Hj.setIcon(v2.tV().es());
                } else {
                    this.Hk.setText(v2.tV().er());
                    this.Hk.setIcon(v2.tV().es());
                }
            }
        }
    }

    private void a(components.v v2, A a2) {
        ArrayList arrayList = a2.cu() == v2.tR().hc() ? v2.tR().hp() : v2.tR().hq();
        JDialog jDialog = new JDialog(Br);
        gh gh2 = new gh(jDialog, a2, arrayList);
        jDialog.add(gh2);
        jDialog.setSize(400, 350);
        jDialog.setPreferredSize(new Dimension(400, 350));
        jDialog.setModal(true);
        jDialog.setResizable(false);
        jDialog.setLocationRelativeTo(null);
        jDialog.setUndecorated(true);
        jDialog.setVisible(true);
        this.b(v2, a2);
    }

    private void b(components.v v2, A a2) {
        JDialog jDialog = new JDialog(Br);
        gb gb2 = new gb(jDialog, v2, a2, a2.eo(), this);
        jDialog.add(gb2);
        jDialog.setSize(402, 202);
        jDialog.setPreferredSize(new Dimension(402, 202));
        jDialog.setModal(true);
        jDialog.setResizable(false);
        jDialog.setLocationRelativeTo(null);
        jDialog.setUndecorated(true);
        jDialog.setVisible(true);
    }

    public String h(I i2) {
        String string = null;
        int n2 = -1;
        n2 = i2.hy().b();
        if (n2 == 3) {
            string = String.valueOf(i2.hy().getNome()) + " " + i2.hy().ip();
        }
        return string;
    }

    public void nc() {
        M m2 = new M(this);
        this.Hs.setModel(m2);
        int[] nArray = new int[]{250, 200, 40, 40, 200, 300};
        int n2 = 0;
        while (n2 < nArray.length) {
            this.Hs.getColumnModel().getColumn(n2).setPreferredWidth(nArray[n2]);
            ++n2;
        }
        this.Hs.setAutoResizeMode(3);
        this.Hs.setRowHeight(25);
        this.Hs.setTableHeader(null);
        this.Hs.setShowGrid(false);
        this.Hs.setDefaultRenderer(components.v.class, new aG());
        this.Hs.setIntercellSpacing(new Dimension(5, 5));
        this.Hs.setAutoCreateRowSorter(false);
        this.Hs.setCellSelectionEnabled(false);
        this.Hs.setRowSelectionAllowed(false);
        this.Hs.setBackground(aq.ot);
        this.Hs.setSelectionBackground(new Color(51, 102, 0));
        this.Hs.setFillsViewportHeight(true);
        this.mH();
    }

    private void qh() {
        if (Hc >= 0) {
            this.GV = Hc;
        }
    }

    private void mH() {
        this.Hs.addMouseListener(new ef(this));
        dX dX2 = new dX(this);
        this.Hn.addMouseListener(dX2);
        this.Ho.addMouseListener(dX2);
        this.Hp.addMouseListener(dX2);
        this.Hl.addMouseListener(dX2);
        this.Hm.addMouseListener(dX2);
        this.xI.addMouseListener(dX2);
        this.Hh.addMouseListener(dX2);
        this.Hi.addMouseListener(dX2);
    }

    private void e(int n2, boolean bl2) {
        JDialog jDialog = new JDialog(Br);
        cD cD2 = new cD(jDialog, (components.v)vK.get(n2), bl2);
        jDialog.add(cD2);
        jDialog.setSize(966, 726);
        jDialog.setPreferredSize(new Dimension(1024, 663));
        jDialog.setModal(true);
        jDialog.setResizable(false);
        jDialog.setLocationRelativeTo(null);
        jDialog.setUndecorated(true);
        jDialog.setVisible(true);
    }

    public ArrayList qi() {
        return vK;
    }

    public static int qj() {
        return GT;
    }

    public static int en() {
        return dB;
    }

    public static ArrayList qk() {
        return zD;
    }

    public static ArrayList ql() {
        return zE;
    }

    public static void a(int n2, ArrayList arrayList) {
        if (n2 == 1) {
            zD = arrayList;
        } else {
            zE = arrayList;
        }
    }

    public static at qm() {
        return Hb;
    }

    public static void v(at at2) {
        Hb = at2;
    }

    public static boolean qn() {
        return GZ;
    }

    public static void ab(boolean bl2) {
        GZ = bl2;
    }

    private void mJ() {
        this.Hq = new JPanel();
        this.Hg = new JLabel();
        this.Hf = new JProgressBar();
        this.uh = new JLabel();
        this.Hr = new JPanel();
        this.xI = new JLabel();
        this.Hn = new JLabel();
        this.Hh = new JLabel();
        this.Hi = new JLabel();
        this.Ho = new JLabel();
        this.Hp = new JLabel();
        this.Hk = new JLabel();
        this.Hm = new JLabel();
        this.Hj = new JLabel();
        this.Hl = new JLabel();
        this.Ht = new JLabel();
        this.zM = new JLabel();
        this.ut = new JScrollPane();
        this.Hs = new JTable();
        this.setBackground(aq.ou);
        this.setPreferredSize(new Dimension(1024, 710));
        this.Hq.setBackground(aq.ou);
        this.zM.setBackground(aq.ou);
        this.zM.setOpaque(true);
        this.Hq.setOpaque(true);
        this.Hq.setPreferredSize(new Dimension(1024, 40));
        this.Hg.setFont(new Font("Tahoma", 1, 14));
        this.Hg.setForeground(new Color(255, 255, 153));
        this.Hg.setText("Informa\u00e7\u00e3o da rodada");
        this.uh.setFont(new Font("Tahoma", 1, 12));
        this.uh.setForeground(new Color(255, 255, 255));
        this.uh.setText("Tempo");
        GroupLayout groupLayout = new GroupLayout(this.Hq);
        this.Hq.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(this.Hg, -2, 566, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE).addComponent(this.Hf, -2, 115, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.uh, -2, 160, -2).addGap(71, 71, 71)));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.Hf, GroupLayout.Alignment.LEADING, -1, -1, Short.MAX_VALUE).addGroup(GroupLayout.Alignment.LEADING, groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.Hg, GroupLayout.Alignment.LEADING).addComponent(this.uh, GroupLayout.Alignment.LEADING)).addGap(0, 3, Short.MAX_VALUE))).addContainerGap()));
        this.Hr.setBackground(new Color(0, 0, 0));
        this.Hr.setPreferredSize(new Dimension(1024, 40));
        this.Hr.setLayout(new b());
        this.xI.setForeground(new Color(255, 255, 255));
        this.xI.setHorizontalAlignment(0);
        this.xI.setText("Posse de bola");
        this.Hr.add((Component)this.xI, new components.a(800, 4, 190, 120));
        this.Hn.setFont(new Font("Tahoma", 1, 24));
        this.Hn.setForeground(new Color(255, 255, 255));
        this.Hn.setHorizontalAlignment(0);
        this.Hn.setText("3 x  1");
        this.Hr.add((Component)this.Hn, new components.a(430, 40, 100, -1));
        this.Hh.setIcon(new ImageIcon(this.getClass().getResource("/aicons/escudo.png")));
        this.Hr.add((Component)this.Hh, new components.a(170, 20, -1, -1));
        this.Hi.setIcon(new ImageIcon(this.getClass().getResource("/aicons/escudo.png")));
        this.Hr.add((Component)this.Hi, new components.a(725, 20, -1, -1));
        this.Ho.setFont(new Font("Tahoma", 1, 12));
        this.Ho.setForeground(new Color(255, 255, 255));
        this.Ho.setText("Tempo");
        this.Ho.setOpaque(true);
        this.Hr.add((Component)this.Ho, new components.a(537, 40, 180, 30));
        this.Hp.setBackground(new Color(153, 153, 0));
        this.Hp.setFont(new Font("Tahoma", 1, 12));
        this.Hp.setForeground(new Color(255, 255, 255));
        this.Hp.setHorizontalAlignment(4);
        this.Hp.setText("Informa\u00e7\u00e3o da rodada");
        this.Hp.setOpaque(true);
        this.Hr.add((Component)this.Hp, new components.a(235, 40, 190, 30));
        this.Hk.setFont(new Font("Tahoma", 0, 12));
        this.Hk.setForeground(new Color(255, 255, 204));
        this.Hk.setHorizontalAlignment(2);
        this.Hr.add((Component)this.Hk, new components.a(530, 90, 280, 30));
        this.Hm.setFont(new Font("Tahoma", 1, 12));
        this.Hm.setForeground(new Color(255, 255, 255));
        this.Hm.setHorizontalAlignment(4);
        this.Hm.setText("Informa\u00e7\u00e3o da rodada");
        this.Hr.add((Component)this.Hm, new components.a(10, 60, 150, -1));
        this.Hj.setFont(new Font("Tahoma", 0, 12));
        this.Hj.setForeground(new Color(255, 255, 204));
        this.Hj.setHorizontalAlignment(4);
        this.Hr.add((Component)this.Hj, new components.a(110, 90, 300, 30));
        this.Hl.setFont(new Font("Tahoma", 1, 12));
        this.Hl.setForeground(new Color(255, 255, 255));
        this.Hl.setHorizontalAlignment(4);
        this.Hl.setText("Informa\u00e7\u00e3o da rodada");
        this.Hr.add((Component)this.Hl, new components.a(10, 40, 150, -1));
        this.Ht.setForeground(new Color(255, 255, 255));
        this.Ht.setHorizontalAlignment(0);
        this.Ht.setText("semifinal");
        this.Hr.add((Component)this.Ht, new components.a(240, 10, 480, -1));
        this.zM.setIcon(new ImageIcon(this.getClass().getResource("/aiconsj/panelh.png")));
        this.zM.setToolTipText("");
        this.Hr.add((Component)this.zM, new components.a(0, 0, 1008, 130));
        this.ut.setBackground(new Color(0, 51, 0));
        this.ut.setBorder(BorderFactory.createCompoundBorder());
        this.ut.setViewportView(this.Hs);
        GroupLayout groupLayout2 = new GroupLayout(this);
        this.setLayout(groupLayout2);
        groupLayout2.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.Hq, -2, -1, -2).addGroup(groupLayout2.createSequentialGroup().addGap(10, 10, 10).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.Hr, -2, 1008, -2).addGroup(groupLayout2.createSequentialGroup().addComponent(this.ut).addGap(3, 3, 3))).addGap(10, 10, 10)));
        groupLayout2.setVerticalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addComponent(this.Hq, -2, -1, -2).addGap(0, 0, 0).addComponent(this.Hr, -2, 130, -2).addGap(20, 20, 20).addComponent(this.ut, -1, 438, Short.MAX_VALUE).addGap(20, 20, 20)));
    }

    static /* synthetic */ void a(dV dV2) {
        dV2.qh();
    }

    static /* synthetic */ void a(dV dV2, int n2) {
        dV2.setVelocidade(n2);
    }

    static /* synthetic */ JTable b(dV dV2) {
        return dV2.Hs;
    }

    static /* synthetic */ ArrayList qo() {
        return vK;
    }

    static /* synthetic */ void b(dV dV2, int n2) {
        dV2.GV = n2;
    }

    static /* synthetic */ int c(dV dV2) {
        return dV2.GW;
    }
}

