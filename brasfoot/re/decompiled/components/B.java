/*
 * Decompiled with CFR 0.152.
 */
package components;

import components.C;
import components.a;
import components.b;
import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class B
extends JPanel {
    private JDialog ub;
    private JButton vm;
    private JComboBox va;
    private JLabel DQ;
    private JLabel DR;
    private JLabel BL;
    private JLabel Mt;

    public B(JDialog jDialog) {
        this.ub = jDialog;
        this.mJ();
        this.mH();
    }

    private void mH() {
        this.vm.addActionListener(new C(this));
    }

    private void mJ() {
        this.BL = new JLabel();
        this.Mt = new JLabel();
        this.DR = new JLabel();
        this.DQ = new JLabel();
        this.va = new JComboBox();
        this.vm = new JButton();
        this.setBackground(new Color(36, 91, 45));
        this.setLayout(new b());
        this.BL.setIcon(new ImageIcon(this.getClass().getResource("/aiconsb/nacionais_sel.png")));
        this.add((Component)this.BL, new a(10, 0, 114, 31));
        this.Mt.setIcon(new ImageIcon(this.getClass().getResource("/aiconsb/selecoes_sel.png")));
        this.add((Component)this.Mt, new a(350, 0, 114, 31));
        this.DR.setIcon(new ImageIcon(this.getClass().getResource("/aiconsb/inter_sel.png")));
        this.add((Component)this.DR, new a(120, 0, 114, 31));
        this.DQ.setIcon(new ImageIcon(this.getClass().getResource("/aiconsb/estaduais_sel.png")));
        this.add((Component)this.DQ, new a(230, 0, 114, 31));
        this.add((Component)this.va, new a(470, 10, 210, 30));
        this.vm.setText("X");
        this.add((Component)this.vm, new a(700, 10, 40, 30));
    }

    static /* synthetic */ JDialog a(B b2) {
        return b2.ub;
    }
}

