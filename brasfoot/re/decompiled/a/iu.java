/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.aJ;
import a.iv;
import a.iw;
import a.ix;
import a.iy;
import a.iz;
import best.F;
import best.Z;
import best.ah;
import best.am;
import components.a;
import components.ao;
import components.b;
import f.B;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class iu
extends JPanel {
    private JDialog ub;
    private Z vt = null;
    private B vu = null;
    private int w;
    private JLabel Az = new JLabel();
    private ArrayList AE = new ArrayList();
    private ImageIcon AJ;
    private ImageIcon AL = this.AJ = new ImageIcon(this.getClass().getResource("/aicons/camisat40.png"));
    private F MF = null;
    private JButton vm;
    private JComboBox vv;
    private JComboBox MG;
    private JComboBox ue;
    private JLabel Ds;
    private JLabel vf;
    private JLayeredPane MH;

    public iu(JDialog jDialog, B b2, Z z2, int n2) {
        this.ub = jDialog;
        this.vu = b2;
        this.vt = z2;
        this.w = n2;
        this.mJ();
        this.AE.clear();
        int n3 = 0;
        while (n3 <= 25) {
            ao ao2 = new ao();
            this.AE.add(ao2);
            ++n3;
        }
        this.mH();
        if (n2 == 1) {
            this.vf.setText("Time do Ano");
        }
        if (this.vt == null) {
            this.vt = (Z)c.a.SR.N().get(0);
        }
        if (this.vu == null) {
            this.vu = (B)this.vt.eb().get(0);
        }
        this.mW();
    }

    public void mH() {
        this.vm.addActionListener(new iv(this));
    }

    public void mW() {
        int n2 = 0;
        int n3 = 0;
        while (n3 < c.a.SR.N().size()) {
            this.ue.addItem(((Z)c.a.SR.N().get(n3)).jp());
            if (this.vt == c.a.SR.N().get(n3)) {
                n2 = n3;
            }
            ++n3;
        }
        aJ aJ2 = new aJ();
        this.ue.setRenderer(aJ2);
        this.ue.setMaximumRowCount(12);
        this.ue.setSelectedIndex(n2);
        int n4 = 0;
        while (n4 < this.vt.eb().size()) {
            this.vv.addItem(String.valueOf(Integer.toString(n4 + 1)) + "\u00aa divis\u00e3o");
            ++n4;
        }
        if (this.w == 0) {
            n4 = 0;
            while (n4 < this.vu.yi().zb() - 1) {
                this.MG.addItem(String.valueOf(Integer.toString(n4 + 1)) + " \u00aa rodada");
                ++n4;
            }
        } else {
            n4 = 0;
            while (n4 < c.a.SR.H()) {
                this.MG.addItem(Integer.toString(n4 + c.a.SR.op()));
                ++n4;
            }
        }
        if (this.vu != null && this.vu.yi().getDivisao() < this.vv.getItemCount()) {
            this.vv.setSelectedIndex(this.vu.yi().getDivisao() - 1);
        }
        this.vv.addActionListener(new iw(this));
        this.ue.addActionListener(new ix(this));
        this.MG.addActionListener(new iy(this));
        if (this.w == 0) {
            if (this.vu != null && this.vu.yi().zb() - 2 < this.MG.getItemCount()) {
                this.MG.setSelectedIndex(this.vu.yi().zb() - 2);
            }
        } else if (c.a.SR.H() - 1 < this.MG.getItemCount()) {
            this.MG.setSelectedIndex(c.a.SR.H() - 1);
        }
    }

    private void sy() {
        this.MF = null;
        int n2 = 0;
        while (n2 <= 25) {
            ((ao)this.AE.get(n2)).vg();
            ++n2;
        }
        int[] nArray = new int[]{1, 9, 3, 5, 2, 11, 13, 14, 16, 22, 24};
        if (this.w == 0) {
            int n3 = this.MG.getSelectedIndex();
            if (n3 < this.vu.zN().size() && n3 >= 0) {
                int n4 = 0;
                while (n4 < ((am)this.vu.zN().get(n3)).lV().size()) {
                    ((ao)this.AE.get(nArray[n4])).a((F)((am)this.vu.zN().get(n3)).lV().get(n4));
                    if (((am)this.vu.zN().get(n3)).lW().get(n4) != null) {
                        ((ao)this.AE.get(nArray[n4])).h(((ah)((am)this.vu.zN().get(n3)).lW().get(n4)).kS());
                        ((ao)this.AE.get(nArray[n4])).n((ah)((am)this.vu.zN().get(n3)).lW().get(n4));
                    } else {
                        ((ao)this.AE.get(nArray[n4])).h(this.AL);
                    }
                    ++n4;
                }
            }
        } else {
            int n5 = this.MG.getSelectedIndex();
            if (n5 < this.vu.zM().size() && n5 >= 0) {
                this.MF = (F)this.vu.zM().get(n5);
            }
            if (n5 < this.vu.zI().size() && n5 >= 0) {
                int n6 = 0;
                while (n6 < ((am)this.vu.zI().get(n5)).lV().size()) {
                    ((ao)this.AE.get(nArray[n6])).a((F)((am)this.vu.zI().get(n5)).lV().get(n6));
                    if (((am)this.vu.zI().get(n5)).lW().get(n6) != null) {
                        ((ao)this.AE.get(nArray[n6])).h(((ah)((am)this.vu.zI().get(n5)).lW().get(n6)).kS());
                        ((ao)this.AE.get(nArray[n6])).n((ah)((am)this.vu.zI().get(n5)).lW().get(n6));
                    } else {
                        ((ao)this.AE.get(nArray[n6])).h(this.AL);
                    }
                    ++n6;
                }
            }
        }
        this.b(-1, this.MF);
    }

    private void b(int n2, F f2) {
        this.g(((ao)this.AE.get(0)).a(this.AE, n2, this.AL, true, 1, f2));
    }

    public void g(ImageIcon imageIcon) {
        this.Az.setIcon(null);
        this.Az.setIcon(imageIcon);
        this.MH.add((Component)this.Az, new a(-45, 0, -1, -1));
        this.MH.setLayer(this.Az, JLayeredPane.POPUP_LAYER);
    }

    private void mX() {
        if (this.vv.getSelectedIndex() < this.vt.eb().size()) {
            this.vu = (B)this.vt.eb().get(this.vv.getSelectedIndex());
        }
        if (this.w == 0) {
            this.MG.removeAllItems();
            int n2 = 0;
            while (n2 < this.vu.yi().zb() - 1) {
                this.MG.addItem(String.valueOf(Integer.toString(n2 + 1)) + " \u00aa rodada");
                ++n2;
            }
            if (this.vu != null && this.vu.yi().zb() - 2 < this.MG.getItemCount()) {
                this.MG.setSelectedIndex(this.vu.yi().zb() - 2);
            }
        } else if (c.a.SR.H() - 1 < this.MG.getItemCount()) {
            this.MG.setSelectedIndex(c.a.SR.H() - 1);
        }
    }

    private void mU() {
        this.vt = (Z)c.a.SR.N().get(this.ue.getSelectedIndex());
        this.vv.removeAllItems();
        int n2 = 0;
        while (n2 < this.vt.eb().size()) {
            this.vv.addItem(String.valueOf(Integer.toString(n2 + 1)) + "\u00aa divis\u00e3o");
            ++n2;
        }
        this.vv.setSelectedIndex(0);
        this.mX();
    }

    private void mJ() {
        this.MH = new JLayeredPane();
        this.Ds = new JLabel();
        this.vf = new JLabel();
        this.vm = new JButton();
        this.ue = new JComboBox();
        this.vv = new JComboBox();
        this.MG = new JComboBox();
        this.setBackground(new Color(44, 53, 49));
        this.setLayout(new b());
        this.MH.setLayout(new b());
        this.Ds.setIcon(new ImageIcon(this.getClass().getResource("/aiconsj/campo_diminuido.jpg")));
        this.Ds.setAlignmentY(0.0f);
        this.Ds.setRequestFocusEnabled(false);
        this.MH.add((Component)this.Ds, new a(5, 0, 400, 566));
        this.add((Component)this.MH, new a(10, 80, 390, 566));
        this.vf.setFont(new Font("Tahoma", 1, 12));
        this.vf.setForeground(new Color(255, 255, 255));
        this.vf.setText("Time da Rodada");
        this.add((Component)this.vf, new a(10, 15, -1, -1));
        this.vm.setText("X");
        this.add((Component)this.vm, new a(303, 10, 50, -1));
        this.ue.addActionListener(new iz(this));
        this.add((Component)this.ue, new a(10, 50, 120, -1));
        this.add((Component)this.vv, new a(140, 50, 110, -1));
        this.add((Component)this.MG, new a(260, 50, 100, -1));
    }

    private void b(ActionEvent actionEvent) {
    }

    static /* synthetic */ JDialog a(iu iu2) {
        return iu2.ub;
    }

    static /* synthetic */ JComboBox b(iu iu2) {
        return iu2.vv;
    }

    static /* synthetic */ void c(iu iu2) {
        iu2.mX();
    }

    static /* synthetic */ void d(iu iu2) {
        iu2.mU();
    }

    static /* synthetic */ void e(iu iu2) {
        iu2.sy();
    }

    static /* synthetic */ void a(iu iu2, ActionEvent actionEvent) {
        iu2.b(actionEvent);
    }
}

