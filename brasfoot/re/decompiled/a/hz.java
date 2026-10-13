/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.hA;
import a.hB;
import best.aq;
import c.a;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.io.FileNotFoundException;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.KeyStroke;
import javax.swing.Timer;

public class hz
extends JPanel {
    private JDialog ub;
    private String bj;
    private boolean Lz;
    private Timer GO = null;
    private JLabel ug;
    private JProgressBar Hf;

    public hz(JDialog jDialog, String string, boolean bl2) {
        this.ub = jDialog;
        this.bj = string;
        this.Lz = bl2;
        this.mJ();
        if (bl2) {
            this.ug.setText("Carregando...");
            this.setBackground(new Color(0, 51, 51));
            this.ub.setCursor(new Cursor(3));
        }
        this.mY();
        this.mG();
        hB hB2 = new hB(this);
        hB2.start();
    }

    private void mG() {
        this.setBackground(aq.E(a.vM().getCorTema(), 1));
    }

    private void mY() {
        this.a(this);
        this.a(this.Hf);
    }

    private void a(JComponent jComponent) {
        InputMap inputMap = jComponent.getInputMap(1);
        jComponent.getInputMap().put(KeyStroke.getKeyStroke(27, 0), "esc");
        ActionMap actionMap = this.getActionMap();
        jComponent.getActionMap().put("esc", new hA(this));
    }

    public void sh() {
        try {
            a.ae(a.SR.br());
        }
        catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        this.ub.dispose();
    }

    private void mJ() {
        this.ug = new JLabel();
        this.Hf = new JProgressBar();
        this.setBackground(new Color(104, 120, 100));
        this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        this.ug.setFont(new Font("Tahoma", 1, 11));
        this.ug.setForeground(new Color(255, 255, 255));
        this.ug.setHorizontalAlignment(0);
        this.ug.setText("Salvando jogo... isso poder demorar um pouco...");
        this.Hf.setForeground(new Color(0, 102, 0));
        this.Hf.setBorderPainted(false);
        this.Hf.setIndeterminate(true);
        GroupLayout groupLayout = new GroupLayout(this);
        this.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(77, 77, 77).addComponent(this.Hf, -2, 226, -2).addContainerGap(64, Short.MAX_VALUE)).addGroup(groupLayout.createSequentialGroup().addGap(26, 26, 26).addComponent(this.ug, -1, -1, Short.MAX_VALUE).addContainerGap()));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(23, 23, 23).addComponent(this.ug).addGap(18, 18, 18).addComponent(this.Hf, -2, 24, -2).addContainerGap(35, Short.MAX_VALUE)));
    }

    static /* synthetic */ JDialog a(hz hz2) {
        return hz2.ub;
    }
}

