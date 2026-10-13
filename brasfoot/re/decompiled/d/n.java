/*
 * Decompiled with CFR 0.152.
 */
package d;

import b.aK;
import best.aq;
import d.A;
import d.B;
import d.C;
import d.D;
import d.E;
import d.F;
import d.G;
import d.H;
import d.I;
import d.J;
import d.K;
import d.L;
import d.M;
import d.N;
import d.O;
import d.P;
import d.Q;
import d.R;
import d.S;
import d.T;
import d.U;
import d.V;
import d.W;
import d.aD;
import d.ac;
import d.ai;
import d.ao;
import d.ap;
import d.ay;
import d.f;
import d.o;
import d.p;
import d.q;
import d.r;
import d.s;
import d.t;
import d.u;
import d.v;
import d.w;
import d.x;
import d.y;
import d.z;
import e.g;
import h.a;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import sun.java2d.SunGraphicsEnvironment;

public class n
extends JFrame {
    private e.t Uu = null;
    private g Uv = null;
    private boolean Uc = true;
    public JDialog Uw;
    private boolean Ux = true;
    private boolean Uy = true;
    private boolean Uz = false;
    private ai UA;
    Comparator UB = new o(this);
    private JButton afR;
    private JButton UC;
    private JButton UD;
    private JButton UE;
    private JButton UF;
    private JButton Kc;
    private JButton UG;
    private JButton UH;
    private JButton UI;
    private JButton UJ;
    private JButton UK;
    private JButton BZ;
    private JButton UL;
    private JButton UM;
    private JButton UN;
    private JButton UO;
    private JComboBox Nq;
    private JPanel vd;
    private JPanel we;
    private JPanel wf;
    private JScrollPane ut;
    private JScrollPane wi;
    private JTextField Ej;
    private JTextField Ek;
    private JLabel afS;
    private JLabel UR;
    private JLabel US;
    private JLabel UT;
    private JLabel UU;
    private JLabel Fq;
    private JLabel UV;
    private JLabel UW;
    private JLabel MM;
    private JLabel UX;
    private JLabel UY;
    private JLabel UZ;
    private JLabel Va;
    private JLabel Vb;
    private JLabel Gk;
    private JLabel MQ;
    private JLabel Vc;
    private JLabel Vd;
    private JLabel Ve;
    private JLabel MR;
    private JLabel MS;
    private JLabel Vf;
    private JTable UQ;
    public JTable Vg;

    public n() {
        this.Uu = (e.t)best.n.cZ().get(0);
        ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/aicons/ball.png"));
        this.setIconImage(imageIcon.getImage());
        this.setTitle("Editor Brasfoot");
        this.pack();
        GraphicsConfiguration graphicsConfiguration = this.getGraphicsConfiguration();
        Rectangle rectangle = SunGraphicsEnvironment.getUsableBounds(graphicsConfiguration.getDevice());
        this.setMaximizedBounds(new Rectangle(0, 0, rectangle.width, rectangle.height));
        this.setExtendedState((this.getExtendedState() & 6) == 6 ? 0 : 6);
        Color color = Color.decode("#007700");
        this.getContentPane().setBackground(color);
        this.mJ();
        this.Ay();
        this.Ej.setText("");
        this.Ek.setText("");
        this.afS.setText("");
        this.mW();
        this.wx();
        this.wF();
    }

    private void mW() {
        this.Nq.removeAllItems();
        int n2 = 0;
        while (n2 < aq.rH.length) {
            this.Nq.addItem(aq.rH[n2]);
            ++n2;
        }
        this.Nq.setSelectedIndex(0);
    }

    public static String k(int n2, boolean bl2) {
        String string = null;
        string = new best.M().k(n2, bl2);
        if (string != null && string.length() != 0) {
            string.isEmpty();
        }
        return string;
    }

    public void Bb() {
        boolean bl2 = false;
        if (this.Uc) {
            if (best.n.da().wI().getJogadores().size() >= 30) {
                bl2 = true;
            }
        } else if (best.n.da().wI().getJuniores().size() >= 15) {
            bl2 = true;
        }
        if (!bl2) {
            String string;
            boolean bl3 = true;
            if (new Random().nextInt(5) == 0) {
                bl3 = false;
            }
            if ((string = n.k(this.Uu.getPais(), bl3)) != null && !string.isEmpty() && string.length() > 1) {
                int[] nArray = best.F.at(this.Nq.getSelectedIndex());
                g g2 = new g();
                g2.setNome(string);
                g2.setEstrela(false);
                g2.setTopMundial(false);
                g2.setPais(this.Uu.getPais());
                g2.setPosicao(this.Nq.getSelectedIndex());
                if (this.Uc) {
                    g2.setIdade(new Random().nextInt(20) + 18);
                } else {
                    g2.setIdade(new Random().nextInt(4) + 16);
                }
                g2.setStatus(0);
                g2.setCr1(nArray[0]);
                g2.setCr2(nArray[1]);
                g2.setLado(new Random().nextInt(2));
                g2.setHash(new Random().nextInt(4) + 7);
                if (this.Uc) {
                    best.n.da().wI().getJogadores().add(g2);
                    ((ap)best.n.da().wJ().getModel()).i(3, true);
                    best.n.da().wG();
                } else {
                    best.n.da().wI().getJuniores().add(g2);
                    ((ap)best.n.da().wJ().getModel()).i(3, true);
                    best.n.da().wG();
                }
                this.an(string);
                this.afS.setText("Criado: " + string);
                best.n.da().wo();
            }
        }
    }

    private void b(e.t t2) {
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        while (n4 < t2.getJogadores().size()) {
            if (((g)t2.getJogadores().get(n4)).getPosicao() == 0) {
                ++n2;
            } else {
                ++n3;
            }
            ++n4;
        }
        if (n2 >= 1 && n3 >= 11) {
            t2.setValid(true);
        } else {
            t2.setValid(false);
        }
        t2.setVid(185);
    }

    public void wo() {
        this.b(this.Uu);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(String.valueOf(best.n.cK) + "/teams/" + this.Uu.getFileRef() + ".ban");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(this.Uu);
            objectOutputStream.close();
            fileOutputStream.close();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        this.Vg.addNotify();
        this.UQ.addNotify();
    }

    public void c(e.t t2) {
        ObjectOutputStream objectOutputStream;
        FileOutputStream fileOutputStream;
        this.b(this.Uu);
        this.b(t2);
        try {
            fileOutputStream = new FileOutputStream(String.valueOf(best.n.cK) + "/teams/" + this.Uu.getFileRef() + ".ban");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(this.Uu);
            objectOutputStream.close();
            fileOutputStream.close();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        try {
            fileOutputStream = new FileOutputStream(String.valueOf(best.n.cK) + "/teams/" + t2.getFileRef() + ".ban");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(t2);
            objectOutputStream.close();
            fileOutputStream.close();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public void wp() {
        boolean bl2 = true;
        if (this.Uc && this.Uu.getJogadores().size() >= 30) {
            bl2 = false;
        } else if (!this.Uc && this.Uu.getJuniores().size() >= 15) {
            bl2 = false;
        }
        if (bl2) {
            this.aK(true);
            f f2 = new f();
            this.Uw = new JDialog();
            this.Uw.add(f2);
            this.Uw.setSize(514, 350);
            this.Uw.setModal(true);
            this.Uw.setResizable(false);
            this.Uw.setLocationRelativeTo(null);
            this.Uw.setUndecorated(true);
            this.Uw.setVisible(true);
        }
    }

    public void wq() {
        if (this.Uc) {
            if (this.Uu.getJogadores().size() > 0) {
                this.UZ.setText(String.valueOf(Integer.toString(this.Uu.getJogadores().size())) + "/" + 30);
                this.UY.setText(Integer.toString(this.Uu.getNumeroTitulares()));
            } else {
                this.Uv = null;
                this.UZ.setText("0/30");
                this.UY.setText("0");
            }
        } else if (this.Uu.getJuniores().size() > 0) {
            this.UZ.setText(String.valueOf(Integer.toString(this.Uu.getJuniores().size())) + "/" + 15);
            this.UY.setText(Integer.toString(this.Uu.getNumeroTitularesJuniores()));
        } else {
            this.Uv = null;
            this.UZ.setText("0/15");
            this.UY.setText("0");
        }
    }

    private void wr() {
        int n2 = 0;
        while (n2 < best.n.cZ().size()) {
            ((e.t)best.n.cZ().get(n2)).setMark(((e.t)best.n.cZ().get(n2)).hasDuplicado());
            ++n2;
        }
        this.wv();
        this.Vg.addNotify();
    }

    private void ws() {
        if (!this.Ek.getText().isEmpty()) {
            String string = best.D.f(this.Ek.getText());
            ((ay)this.Vg.getModel()).ak(string);
        }
    }

    private void wt() {
        if (!this.Ej.getText().isEmpty()) {
            String string = best.D.f(this.Ej.getText());
            ((ay)this.Vg.getModel()).ai(string);
        }
    }

    private void wu() {
        int n2 = 0;
        while (n2 < best.n.cZ().size()) {
            ((e.t)best.n.cZ().get(n2)).setMark(((e.t)best.n.cZ().get(n2)).semEscudo());
            ++n2;
        }
        this.wv();
        this.Vg.addNotify();
    }

    private void wv() {
        int n2 = 0;
        while (n2 < best.n.cZ().size()) {
            if (((e.t)best.n.cZ().get(n2)).isMark()) {
                this.Vg.changeSelection(n2, 0, true, true);
                this.Vg.setRowSelectionInterval(n2, n2);
                break;
            }
            ++n2;
        }
    }

    private void ww() {
        int n2 = 0;
        while (n2 < best.n.cZ().size()) {
            ((e.t)best.n.cZ().get(n2)).setMark(((e.t)best.n.cZ().get(n2)).semCamisa());
            ++n2;
        }
        this.wv();
        this.Vg.addNotify();
    }

    private void sp() {
        best.n.dc().setVisible(true);
        this.dispose();
    }

    private void wx() {
        this.Kc.addActionListener(new z(this));
        this.afR.addActionListener(new K(this));
        this.UO.addActionListener(new R(this));
        this.UN.addActionListener(new S(this));
        this.UK.addActionListener(new T(this));
        this.UJ.addActionListener(new U(this));
        this.UM.addActionListener(new V(this));
        this.UL.addActionListener(new W(this));
        this.UE.addActionListener(new p(this));
        this.Kc.addActionListener(new q(this));
        this.BZ.addActionListener(new r(this));
        this.UQ.getTableHeader().addMouseListener(new s(this));
        this.UI.addActionListener(new t(this));
        this.UF.addActionListener(new u(this));
        this.UD.addActionListener(new v(this));
        this.UC.addActionListener(new w(this));
        this.UG.addActionListener(new x(this));
        this.UH.addActionListener(new y(this));
        this.UQ.getSelectionModel().addListSelectionListener(new A(this));
        this.UQ.addMouseListener(new B(this));
        this.Vg.addMouseListener(new C(this));
        this.Gk.addMouseListener(new D(this));
        this.MR.addMouseListener(new E(this));
        this.MS.addMouseListener(new F(this));
        this.UV.addMouseListener(new G(this));
        this.UW.addMouseListener(new H(this));
        this.Vb.addMouseListener(new I(this));
        this.MM.addMouseListener(new J(this));
        this.MQ.addMouseListener(new L(this));
        JPopupMenu jPopupMenu = new JPopupMenu();
        JMenuItem jMenuItem = new JMenuItem("Adicionar Jogador");
        jMenuItem.addActionListener(new M(this));
        jPopupMenu.add(jMenuItem);
        jPopupMenu.addSeparator();
        JMenuItem jMenuItem2 = new JMenuItem("Editar Jogador");
        jMenuItem2.addActionListener(new N(this));
        jPopupMenu.add(jMenuItem2);
        jPopupMenu.addSeparator();
        JMenuItem jMenuItem3 = new JMenuItem("Deletar Jogador");
        jMenuItem3.addActionListener(new O(this));
        jPopupMenu.add(jMenuItem3);
        jPopupMenu.addSeparator();
        JMenuItem jMenuItem4 = new JMenuItem("Transferir Jogador");
        jMenuItem4.addActionListener(new P(this));
        jPopupMenu.add(jMenuItem4);
        this.UQ.setComponentPopupMenu(jPopupMenu);
    }

    public void wy() {
        this.aL(true);
        ac ac2 = new ac();
        this.Uw = new JDialog();
        this.Uw.add(ac2);
        this.Uw.setSize(518, 398);
        this.Uw.setModal(true);
        this.Uw.setResizable(false);
        this.Uw.setLocationRelativeTo(null);
        this.Uw.setUndecorated(true);
        this.Uw.setVisible(true);
    }

    public void wz() {
        int n2 = -1;
        n2 = JOptionPane.showConfirmDialog(null, "Apagar o time? Isso pode ocasionar erros no jogo!", "Confirmar", 0);
        String string = String.valueOf(best.n.cK) + "/teams/" + this.Uu.getFileRef() + ".ban";
        if (n2 == 0) {
            Path path = Paths.get(string, new String[0]);
            try {
                Files.deleteIfExists(path);
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
            best.n.cZ().remove(this.Uu);
            this.ah(null);
        }
    }

    public void wA() {
        if (this.Uu != null) {
            this.aL(false);
            ac ac2 = new ac();
            this.Uw = new JDialog();
            this.Uw.add(ac2);
            this.Uw.setSize(518, 398);
            this.Uw.setModal(true);
            this.Uw.setResizable(false);
            this.Uw.setLocationRelativeTo(null);
            this.Uw.setUndecorated(true);
            this.Uw.setVisible(true);
        }
    }

    public void wB() {
        if (this.UQ.getSelectedRow() >= 0) {
            int n2 = this.UQ.convertRowIndexToModel(this.UQ.getSelectedRow());
            ((ap)this.UQ.getModel()).eI(n2);
            this.UQ.addNotify();
            this.wq();
            this.wo();
        }
    }

    public void wC() {
        if (this.Uv != null) {
            this.aK(false);
            f f2 = new f();
            this.Uw = new JDialog();
            this.Uw.add(f2);
            this.Uw.setSize(500, 350);
            this.Uw.setModal(true);
            this.Uw.setResizable(false);
            this.Uw.setLocationRelativeTo(null);
            this.Uw.setUndecorated(true);
            this.Uw.setVisible(true);
        }
    }

    public void wD() {
        if (this.Uv != null) {
            this.aK(false);
            this.UA = new ai();
            this.Uw = new JDialog();
            this.Uw.add(this.UA);
            this.Uw.setSize(368, 504);
            this.Uw.setModal(true);
            this.Uw.setResizable(false);
            this.Uw.setLocationRelativeTo(null);
            this.Uw.setUndecorated(true);
            this.Uw.setVisible(true);
        }
    }

    public void b(BufferedImage bufferedImage) {
        long l2 = 0L;
        long l3 = 0L;
        l2 = System.currentTimeMillis();
        int[] nArray = new int[10];
        int[][] nArray2 = new int[bufferedImage.getWidth()][bufferedImage.getHeight()];
        int n2 = 0;
        while (n2 < bufferedImage.getWidth()) {
            int n3 = 0;
            while (n3 < bufferedImage.getHeight()) {
                int n4 = bufferedImage.getRGB(n2, n3);
                float[] fArray = new float[3];
                int n5 = n4 >> 16 & 0xFF;
                int n6 = n4 >> 8 & 0xFF;
                int n7 = n4 & 0xFF;
                double d2 = 0.2126 * (double)n5 + 0.7152 * (double)n6 + 0.0722 * (double)n7;
                Color.RGBtoHSB(n5, n6, n7, fArray);
                if (d2 < 128.0) {
                    nArray[0] = nArray[0] + 1;
                } else {
                    nArray[1] = nArray[1] + 1;
                }
                if ((double)fArray[1] < 0.1 && (double)fArray[2] > 0.9) {
                    nArray[8] = nArray[8] + 1;
                } else if ((double)fArray[2] < 0.1) {
                    nArray[9] = nArray[9] + 1;
                } else {
                    float f2 = fArray[0] * 360.0f;
                    if (f2 >= 0.0f && f2 < 30.0f) {
                        nArray[2] = nArray[2] + 1;
                    } else if (f2 >= 30.0f && f2 < 90.0f) {
                        nArray[3] = nArray[3] + 1;
                    } else if (f2 >= 90.0f && f2 < 150.0f) {
                        nArray[4] = nArray[4] + 1;
                    } else if (f2 >= 150.0f && f2 < 210.0f) {
                        nArray[5] = nArray[5] + 1;
                    } else if (f2 >= 210.0f && f2 < 270.0f) {
                        nArray[6] = nArray[6] + 1;
                    } else if (f2 >= 270.0f && f2 < 330.0f) {
                        nArray[7] = nArray[7] + 1;
                    } else {
                        nArray[2] = nArray[2] + 1;
                    }
                }
                ++n3;
            }
            ++n2;
        }
        l3 = System.currentTimeMillis() - l2;
    }

    public void wE() {
        Serializable serializable;
        Serializable serializable2;
        Serializable serializable3;
        Serializable serializable4;
        Object object;
        Color color = this.Uu.getCorT();
        Color color2 = this.Uu.getCorF();
        this.Gk.setForeground(color);
        this.Gk.setText(this.Uu.getNome());
        this.MR.setForeground(color);
        this.MR.setText(aq.pZ[this.Uu.getReputacao()]);
        ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/aflags/" + Integer.toString(this.Uu.getPais()) + ".png"));
        this.Vc.setIcon(imageIcon);
        this.MQ.setForeground(color);
        String string = best.ac.valueOf("P" + this.Uu.getPais()).getNome();
        this.MQ.setText(string);
        if (this.Uu.getPais() == 29) {
            this.MM.setVisible(true);
            this.UX.setVisible(true);
            this.MM.setForeground(color);
            object = aq.rY[this.Uu.getEstado()];
            this.MM.setText((String)object);
            serializable4 = new ImageIcon(this.getClass().getResource("/aesticons/" + Integer.toString(this.Uu.getEstado()) + ".png"));
            this.UX.setIcon((Icon)((Object)serializable4));
        } else {
            this.MM.setVisible(false);
            this.UX.setVisible(false);
        }
        this.UV.setForeground(color);
        this.UV.setText(this.Uu.getEstadio());
        this.UW.setForeground(color);
        this.UW.setText(String.valueOf(Integer.toString(this.Uu.getCapacidade())) + " lugares");
        this.Vb.setForeground(color);
        this.Vb.setText(Integer.toString(this.Uu.getNivel()));
        this.MS.setForeground(color);
        this.MS.setText(this.Uu.getTecnico());
        this.we.setBackground(color2);
        this.UZ.setForeground(color);
        this.wq();
        this.UY.setForeground(color);
        this.afS.setForeground(color);
        this.afS.setText("");
        object = null;
        serializable4 = new File(String.valueOf(best.n.cK) + "/teams/escudos/" + this.Uu.getFileRef() + ".png");
        if (((File)serializable4).exists() && !((File)serializable4).isDirectory()) {
            try {
                object = ImageIO.read(new File(String.valueOf(best.n.cK) + "/teams/escudos/" + this.Uu.getFileRef() + ".png"));
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
            serializable3 = new ImageIcon((Image)object);
            this.Fq.setIcon((Icon)((Object)serializable3));
        } else {
            this.Fq.setIcon(new ImageIcon(this.getClass().getResource("/aicons/escudo.png")));
        }
        serializable3 = new File(String.valueOf(best.n.cK) + "/teams/camisas/" + this.Uu.getFileRef() + ".png");
        if (((File)serializable3).exists() && !((File)serializable4).isDirectory()) {
            try {
                object = ImageIO.read(new File(String.valueOf(best.n.cK) + "/teams/camisas/" + this.Uu.getFileRef() + ".png"));
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
            this.b((BufferedImage)object);
            serializable2 = new ImageIcon((Image)object);
            this.UR.setIcon((Icon)((Object)serializable2));
        } else {
            this.UR.setIcon(new ImageIcon(this.getClass().getResource("/aicons/camisaVazia.png")));
        }
        serializable2 = new File(String.valueOf(best.n.cK) + "/teams/camisas2/" + this.Uu.getFileRef() + ".png");
        if (((File)serializable2).exists() && !((File)serializable4).isDirectory()) {
            try {
                object = ImageIO.read(new File(String.valueOf(best.n.cK) + "/teams/camisas2/" + this.Uu.getFileRef() + ".png"));
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
            serializable = new ImageIcon((Image)object);
            this.US.setIcon((Icon)((Object)serializable));
            this.b((BufferedImage)object);
        } else {
            this.US.setIcon(new ImageIcon(this.getClass().getResource("/aicons/camisaVazia.png")));
        }
        serializable = new File(String.valueOf(best.n.cK) + "/teams/camisas3/" + this.Uu.getFileRef() + ".png");
        if (((File)serializable).exists() && !((File)serializable4).isDirectory()) {
            try {
                object = ImageIO.read(new File(String.valueOf(best.n.cK) + "/teams/camisas3/" + this.Uu.getFileRef() + ".png"));
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
            ImageIcon imageIcon2 = new ImageIcon((Image)object);
            this.UT.setIcon(imageIcon2);
        } else {
            this.UT.setIcon(new ImageIcon(this.getClass().getResource("/aicons/camisaVazia.png")));
        }
    }

    private void wF() {
        this.Vg.getColumnModel().getColumn(0).setPreferredWidth(150);
        this.Vg.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.Vg.getColumnModel().getColumn(2).setPreferredWidth(102);
        this.Vg.setAutoResizeMode(3);
        this.Vg.setShowGrid(false);
        this.Vg.setDefaultRenderer(e.t.class, new aK());
        this.Vg.setAutoCreateRowSorter(false);
        this.Vg.getTableHeader().setCursor(new Cursor(12));
        this.Vg.setCellSelectionEnabled(false);
        this.Vg.setSelectionMode(2);
        this.Vg.getSelectionModel().addListSelectionListener(new Q(this));
        this.Vg.setRowSelectionAllowed(true);
        this.Vg.setRowHeight(20);
        this.Vg.setIntercellSpacing(new Dimension(0, 0));
        this.Vg.getTableHeader().setReorderingAllowed(false);
        TableRowSorter<TableModel> tableRowSorter = new TableRowSorter<TableModel>(this.Vg.getModel());
        this.Vg.setRowSorter(tableRowSorter);
        tableRowSorter.setComparator(0, a.aaG);
        tableRowSorter.setComparator(1, a.aaE);
        tableRowSorter.setComparator(2, a.aaF);
    }

    public void ah(String string) {
        this.Uc = true;
        this.wO().addNotify();
        this.wO().setRowSelectionInterval(0, 0);
        int n2 = this.Vg.convertRowIndexToModel(this.Vg.getSelectedRow());
        ((ay)this.Vg.getModel()).et(n2);
        ((ay)this.Vg.getModel()).fireTableDataChanged();
        if (string != null) {
            ay cfr_ignored_0 = (ay)this.Vg.getModel();
            ay.eL(0);
            ((ay)this.Vg.getModel()).ai(string);
        }
    }

    public void an(String string) {
        int n2 = 0;
        while (n2 < this.Uu.getJogadores().size()) {
            if (string.length() <= ((g)this.Uu.getJogadores().get(n2)).getNome().length() && string.equalsIgnoreCase(best.D.f(((g)this.Uu.getJogadores().get(n2)).getNome()).substring(0, string.length()))) {
                best.n.da().wJ().changeSelection(n2, 0, true, true);
                best.n.da().wJ().setRowSelectionInterval(n2, n2);
                break;
            }
            ++n2;
        }
    }

    public void wG() {
        this.wJ().addNotify();
        this.wJ().setRowSelectionInterval(0, 0);
        int n2 = this.Vg.convertRowIndexToModel(this.Vg.getSelectedRow());
        ((ay)this.Vg.getModel()).et(n2);
        this.wq();
    }

    public void wH() {
        this.UQ.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.UQ.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.UQ.getColumnModel().getColumn(2).setPreferredWidth(120);
        this.UQ.getColumnModel().getColumn(3).setPreferredWidth(70);
        this.UQ.getColumnModel().getColumn(4).setPreferredWidth(57);
        this.UQ.getColumnModel().getColumn(5).setPreferredWidth(40);
        this.UQ.getColumnModel().getColumn(6).setPreferredWidth(60);
        this.UQ.getColumnModel().getColumn(7).setPreferredWidth(60);
        this.UQ.setAutoResizeMode(3);
        this.UQ.setAutoCreateRowSorter(false);
        this.UQ.setShowGrid(false);
        this.UQ.setDefaultRenderer(String.class, new ao());
        this.UQ.setDefaultRenderer(Integer.class, new ao());
        this.UQ.setDefaultRenderer(Icon.class, new ao());
        this.UQ.setDefaultRenderer(ImageIcon.class, new ao());
        this.UQ.setDefaultRenderer(Boolean.class, new ao());
        this.UQ.setSelectionBackground(Color.YELLOW);
        this.UQ.setCellSelectionEnabled(false);
        this.UQ.setSelectionMode(0);
        this.UQ.setRowSelectionAllowed(true);
        this.UQ.setRowHeight(20);
        this.UQ.setIntercellSpacing(new Dimension(0, 0));
        this.UQ.getTableHeader().setReorderingAllowed(false);
    }

    public e.t wI() {
        return this.Uu;
    }

    public void d(e.t t2) {
        this.Uu = t2;
    }

    public JTable wJ() {
        return this.UQ;
    }

    public void b(JTable jTable) {
        this.UQ = jTable;
    }

    public boolean wK() {
        return this.Uc;
    }

    public void aJ(boolean bl2) {
        this.Uc = bl2;
    }

    public g wL() {
        return this.Uv;
    }

    public void a(g g2) {
        this.Uv = g2;
    }

    public boolean wM() {
        return this.Ux;
    }

    public void aK(boolean bl2) {
        this.Ux = bl2;
    }

    public boolean wN() {
        return this.Uy;
    }

    public void aL(boolean bl2) {
        this.Uy = bl2;
    }

    public JTable wO() {
        return this.Vg;
    }

    public JButton wP() {
        return this.UN;
    }

    public JButton wQ() {
        return this.UO;
    }

    public boolean wR() {
        return this.Uz;
    }

    public void aM(boolean bl2) {
        this.Uz = bl2;
    }

    public ai wS() {
        return this.UA;
    }

    private void Ay() {
        ay ay2 = new ay();
        this.Vg = new aD(this, ay2);
        this.ut.setViewportView(this.Vg);
    }

    private void mJ() {
        this.vd = new JPanel();
        this.wf = new JPanel();
        this.Ve = new JLabel();
        this.Ej = new JTextField();
        this.UJ = new JButton();
        this.Vd = new JLabel();
        this.Ek = new JTextField();
        this.UK = new JButton();
        this.Va = new JLabel();
        this.UM = new JButton();
        this.UE = new JButton();
        this.UL = new JButton();
        this.ut = new JScrollPane();
        this.Vg = new JTable();
        this.UC = new JButton();
        this.UF = new JButton();
        this.UD = new JButton();
        this.Kc = new JButton();
        this.BZ = new JButton();
        this.we = new JPanel();
        this.wi = new JScrollPane();
        this.UQ = new JTable();
        this.Fq = new JLabel();
        this.UG = new JButton();
        this.UI = new JButton();
        this.UH = new JButton();
        this.UO = new JButton();
        this.UN = new JButton();
        this.UZ = new JLabel();
        this.UY = new JLabel();
        this.UT = new JLabel();
        this.UR = new JLabel();
        this.US = new JLabel();
        this.Gk = new JLabel();
        this.Vc = new JLabel();
        this.MQ = new JLabel();
        this.UX = new JLabel();
        this.MM = new JLabel();
        this.MR = new JLabel();
        this.Vf = new JLabel();
        this.UV = new JLabel();
        this.UU = new JLabel();
        this.MS = new JLabel();
        this.Vb = new JLabel();
        this.UW = new JLabel();
        this.afR = new JButton();
        this.Nq = new JComboBox();
        this.afS = new JLabel();
        this.setDefaultCloseOperation(3);
        this.setBackground(new Color(0, 153, 51));
        this.vd.setBackground(new Color(0, 153, 0));
        this.wf.setBackground(new Color(0, 102, 51));
        this.Ve.setForeground(new Color(255, 255, 255));
        this.Ve.setHorizontalAlignment(4);
        this.Ve.setText("Procurar time:");
        this.Ej.setText("jTextField1");
        this.UJ.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon_search.png")));
        this.UJ.setCursor(new Cursor(12));
        this.Vd.setForeground(new Color(255, 255, 255));
        this.Vd.setHorizontalAlignment(4);
        this.Vd.setText("Procurar jogador:");
        this.Ek.setText("jTextField1");
        this.UK.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon_search.png")));
        this.UK.setToolTipText("");
        this.UK.setCursor(new Cursor(12));
        this.Va.setForeground(new Color(255, 255, 255));
        this.Va.setHorizontalAlignment(2);
        this.Va.setText("Mostrar times:");
        this.UM.setText("sem escudo");
        this.UM.setCursor(new Cursor(12));
        this.UE.setText("jogadores duplicados");
        this.UE.setCursor(new Cursor(12));
        this.UL.setText("sem camisas");
        this.UL.setCursor(new Cursor(12));
        GroupLayout groupLayout = new GroupLayout(this.wf);
        this.wf.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.Vd, -2, 132, -2).addComponent(this.Ve, -2, 114, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, Short.MAX_VALUE).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.Ej, GroupLayout.Alignment.TRAILING, -2, 182, -2).addComponent(this.Ek, GroupLayout.Alignment.TRAILING, -2, 182, -2)).addGap(18, 18, 18).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.UJ, GroupLayout.Alignment.TRAILING, -2, 59, -2).addComponent(this.UK, GroupLayout.Alignment.TRAILING, -2, 59, -2))).addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addComponent(this.UM, -2, 125, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.UL, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, Short.MAX_VALUE).addComponent(this.UE)).addGroup(groupLayout.createSequentialGroup().addComponent(this.Va, -2, 132, -2).addGap(0, 0, Short.MAX_VALUE))))).addContainerGap()));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.UK).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.Ve).addComponent(this.Ej, -2, -1, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.UJ).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.Vd).addComponent(this.Ek, -2, -1, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.Va).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, Short.MAX_VALUE).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.UM).addComponent(this.UE).addComponent(this.UL)).addContainerGap()));
        this.Vg.setModel(new DefaultTableModel(new Object[][]{new Object[4], new Object[4], new Object[4], new Object[4]}, new String[]{"Title 1", "Title 2", "Title 3", "Title 4"}));
        this.ut.setViewportView(this.Vg);
        this.UC.setIcon(new ImageIcon(this.getClass().getResource("/aicons/iconadd.png")));
        this.UC.setText("adicionar");
        this.UC.setCursor(new Cursor(12));
        this.UF.setIcon(new ImageIcon(this.getClass().getResource("/aicons/iconed.png")));
        this.UF.setText("editar");
        this.UF.setCursor(new Cursor(12));
        this.UD.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icondel.png")));
        this.UD.setText("deletar");
        this.UD.setCursor(new Cursor(12));
        this.Kc.setIcon(new ImageIcon(this.getClass().getResource("/aicons/home.png")));
        this.Kc.setText("in\u00edcio");
        this.Kc.setCursor(new Cursor(12));
        this.BZ.setIcon(new ImageIcon(this.getClass().getResource("/aicons/exit.png")));
        this.BZ.setText("sair jogo");
        this.BZ.setCursor(new Cursor(12));
        GroupLayout groupLayout2 = new GroupLayout(this.vd);
        this.vd.setLayout(groupLayout2);
        groupLayout2.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addGap(108, 108, 108).addComponent(this.Kc, -2, 101, -2).addGap(46, 46, 46).addComponent(this.BZ).addContainerGap(-1, Short.MAX_VALUE)).addGroup(groupLayout2.createSequentialGroup().addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addContainerGap().addComponent(this.wf, -1, -1, Short.MAX_VALUE)).addGroup(groupLayout2.createSequentialGroup().addContainerGap().addComponent(this.ut)).addGroup(groupLayout2.createSequentialGroup().addGap(31, 31, 31).addComponent(this.UC, -1, -1, Short.MAX_VALUE).addGap(18, 18, 18).addComponent(this.UF, -1, -1, Short.MAX_VALUE).addGap(18, 18, 18).addComponent(this.UD, -1, -1, Short.MAX_VALUE).addGap(20, 20, 20))).addContainerGap()));
        groupLayout2.setVerticalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, groupLayout2.createSequentialGroup().addContainerGap().addComponent(this.ut).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.UC).addComponent(this.UF).addComponent(this.UD)).addGap(18, 18, 18).addComponent(this.wf, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.BZ).addComponent(this.Kc)).addGap(26, 26, 26)));
        this.we.setBackground(new Color(0, 102, 102));
        this.we.setToolTipText("");
        this.UQ.setModel(new DefaultTableModel(new Object[][]{new Object[4], new Object[4], new Object[4], new Object[4]}, new String[]{"Title 1", "Title 2", "Title 3", "Title 4"}));
        this.wi.setViewportView(this.UQ);
        this.Fq.setIcon(new ImageIcon(this.getClass().getResource("/aicons/escudo.png")));
        this.Fq.setCursor(new Cursor(12));
        this.Fq.setName("labescudo");
        this.UG.setIcon(new ImageIcon(this.getClass().getResource("/aicons/ja.png")));
        this.UG.setCursor(new Cursor(12));
        this.UI.setIcon(new ImageIcon(this.getClass().getResource("/aicons/je.png")));
        this.UI.setCursor(new Cursor(12));
        this.UH.setIcon(new ImageIcon(this.getClass().getResource("/aicons/jd.png")));
        this.UH.setCursor(new Cursor(12));
        this.UO.setText("Principal");
        this.UO.setCursor(new Cursor(12));
        this.UN.setText("Juniores");
        this.UN.setCursor(new Cursor(12));
        this.UZ.setForeground(new Color(255, 255, 255));
        this.UZ.setHorizontalAlignment(4);
        this.UZ.setIcon(new ImageIcon(this.getClass().getResource("/aicons/player_shirt_tot.png")));
        this.UZ.setText("25/30");
        this.UY.setForeground(new Color(255, 255, 255));
        this.UY.setHorizontalAlignment(4);
        this.UY.setIcon(new ImageIcon(this.getClass().getResource("/aicons/player_shirt_greensmall.png")));
        this.UY.setText("25");
        this.UT.setIcon(new ImageIcon(this.getClass().getResource("/aicons/camisaVazia.png")));
        this.UR.setIcon(new ImageIcon(this.getClass().getResource("/aicons/camisaVazia.png")));
        this.US.setIcon(new ImageIcon(this.getClass().getResource("/aicons/camisaVazia.png")));
        this.Gk.setFont(new Font("Tahoma", 0, 14));
        this.Gk.setForeground(new Color(255, 255, 255));
        this.Gk.setText("Nome do Time");
        this.Vc.setIcon(new ImageIcon(this.getClass().getResource("/aicons/paisVazio.png")));
        this.MQ.setForeground(new Color(255, 255, 255));
        this.MQ.setText("pais");
        this.UX.setIcon(new ImageIcon(this.getClass().getResource("/aicons/paisVazio.png")));
        this.MM.setForeground(new Color(255, 255, 255));
        this.MM.setText("estado");
        this.MR.setForeground(new Color(255, 255, 255));
        this.MR.setText("reputa\u00e7\u00e3o");
        this.Vf.setIcon(new ImageIcon(this.getClass().getResource("/aicons/estadio_icon16.png")));
        this.UV.setForeground(new Color(255, 255, 255));
        this.UV.setText("jLabel1");
        this.UU.setIcon(new ImageIcon(this.getClass().getResource("/aicons/iconcoach16.png")));
        this.MS.setForeground(new Color(255, 255, 255));
        this.MS.setText("jLabel1");
        this.Vb.setFont(new Font("Tahoma", 0, 18));
        this.Vb.setForeground(new Color(255, 255, 255));
        this.Vb.setText("20");
        this.UW.setForeground(new Color(255, 255, 255));
        this.UW.setText("jLabel1");
        this.afR.setFont(new Font("Tahoma", 0, 12));
        this.afR.setIcon(new ImageIcon(this.getClass().getResource("/aicons/ja.png")));
        this.afR.setText("Criar aleat\u00f3rio");
        this.afR.setCursor(new Cursor(12));
        this.Nq.setModel(new DefaultComboBoxModel<String>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
        this.afS.setForeground(new Color(255, 255, 255));
        this.afS.setHorizontalAlignment(0);
        this.afS.setText("Adicionado:");
        GroupLayout groupLayout3 = new GroupLayout(this.we);
        this.we.setLayout(groupLayout3);
        groupLayout3.setHorizontalGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout3.createSequentialGroup().addContainerGap().addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.wi).addGroup(groupLayout3.createSequentialGroup().addGap(10, 10, 10).addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout3.createSequentialGroup().addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout3.createSequentialGroup().addGap(8, 8, 8).addComponent(this.UU).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.MS, -2, 105, -2)).addGroup(groupLayout3.createSequentialGroup().addComponent(this.Vf).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.UV, -2, 172, -2).addComponent(this.UW, -2, 172, -2)))).addGap(50, 50, 50).addComponent(this.UR).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout3.createSequentialGroup().addComponent(this.US).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.UT)).addGroup(groupLayout3.createSequentialGroup().addComponent(this.UO).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.UN)))).addGroup(groupLayout3.createSequentialGroup().addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout3.createSequentialGroup().addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.Gk).addGroup(groupLayout3.createSequentialGroup().addComponent(this.Vc).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.MQ, -2, 147, -2).addGap(18, 18, 18).addComponent(this.UX).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.MM, -2, 87, -2))).addGap(18, 92, Short.MAX_VALUE)).addGroup(groupLayout3.createSequentialGroup().addComponent(this.MR, -2, 147, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, Short.MAX_VALUE).addComponent(this.Vb).addGap(28, 28, 28))).addComponent(this.Fq, -2, 75, -2)))).addGroup(GroupLayout.Alignment.TRAILING, groupLayout3.createSequentialGroup().addComponent(this.UZ).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.UY, -2, 41, -2).addGap(31, 31, 31).addComponent(this.UG, -2, 38, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.UI, -2, 38, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.UH, -2, 38, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, Short.MAX_VALUE).addComponent(this.afR, -2, 137, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.Nq, -2, -1, -2)).addGroup(groupLayout3.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(this.afS, -2, 238, -2))).addContainerGap()));
        groupLayout3.setVerticalGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, groupLayout3.createSequentialGroup().addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.Fq, -2, 82, -2).addGroup(groupLayout3.createSequentialGroup().addContainerGap().addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.UX).addComponent(this.MM).addGroup(groupLayout3.createSequentialGroup().addComponent(this.Gk).addGap(1, 1, 1).addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.MR).addComponent(this.Vb)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.Vc).addComponent(this.MQ)))))).addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout3.createSequentialGroup().addGap(12, 12, 12).addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.UT).addComponent(this.UR).addComponent(this.US))).addGroup(groupLayout3.createSequentialGroup().addGap(10, 10, 10).addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout3.createSequentialGroup().addComponent(this.Vf).addGap(29, 29, 29)).addGroup(groupLayout3.createSequentialGroup().addComponent(this.UV).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE).addComponent(this.UW).addGap(18, 18, 18))).addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.UU).addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.MS).addComponent(this.UO).addComponent(this.UN))))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE).addComponent(this.wi, -2, 451, -2).addGap(4, 4, 4).addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.UG, -1, -1, Short.MAX_VALUE).addGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.UZ, -2, 33, -2).addComponent(this.UY)).addComponent(this.UI, -1, -1, Short.MAX_VALUE).addComponent(this.UH, -1, -1, Short.MAX_VALUE).addComponent(this.afR, -1, -1, Short.MAX_VALUE).addComponent(this.Nq)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.afS).addGap(8, 8, 8)));
        GroupLayout groupLayout4 = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(groupLayout4);
        groupLayout4.setHorizontalGroup(groupLayout4.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout4.createSequentialGroup().addContainerGap().addComponent(this.vd, -2, -1, -2).addGap(18, 18, 18).addComponent(this.we, -2, -1, -2).addContainerGap(275, Short.MAX_VALUE)));
        groupLayout4.setVerticalGroup(groupLayout4.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout4.createSequentialGroup().addContainerGap().addGroup(groupLayout4.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.vd, -1, -1, Short.MAX_VALUE).addComponent(this.we, -1, -1, Short.MAX_VALUE)).addContainerGap(23, Short.MAX_VALUE)));
        this.pack();
    }

    static /* synthetic */ void a(n n2) {
        n2.sp();
    }

    static /* synthetic */ JButton b(n n2) {
        return n2.UO;
    }

    static /* synthetic */ JButton c(n n2) {
        return n2.UN;
    }

    static /* synthetic */ JLabel d(n n2) {
        return n2.afS;
    }

    static /* synthetic */ boolean e(n n2) {
        return n2.Uc;
    }

    static /* synthetic */ void a(n n2, boolean bl2) {
        n2.Uc = bl2;
    }

    static /* synthetic */ e.t f(n n2) {
        return n2.Uu;
    }

    static /* synthetic */ JTable g(n n2) {
        return n2.UQ;
    }

    static /* synthetic */ void a(n n2, g g2) {
        n2.Uv = g2;
    }

    static /* synthetic */ void h(n n2) {
        n2.wt();
    }

    static /* synthetic */ void i(n n2) {
        n2.ws();
    }

    static /* synthetic */ void j(n n2) {
        n2.wu();
    }

    static /* synthetic */ void k(n n2) {
        n2.ww();
    }

    static /* synthetic */ void l(n n2) {
        n2.wr();
    }

    static /* synthetic */ JLabel m(n n2) {
        return n2.UY;
    }
}

