/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.cv;
import a.cw;
import best.aq;
import components.a;
import components.b;
import est.ConfigEstadualType;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class cu
extends JPanel {
    private int CF = 0;
    private cw CG = null;
    private ConfigEstadualType CH = null;
    private JCheckBox CI;
    private JComboBox CJ;
    private JComboBox CK;
    private JComboBox CL;
    private JComboBox CM;
    private JLabel CN;

    public cu(int n2, cw cw2) {
        this.CF = n2;
        this.CG = cw2;
        this.mJ();
        this.CM.setMaximumRowCount(12);
        int n3 = 0;
        while (n3 < aq.sN.length) {
            this.CM.addItem(aq.sN[n3]);
            ++n3;
        }
        this.CM.addActionListener(new cv(this));
    }

    public void nH() {
        this.CH.setFormula(this.CM.getSelectedIndex());
        if (this.CI.isSelected()) {
            this.CH.setDesempate(0);
        } else {
            this.CH.setDesempate(1);
        }
        if (this.CJ.isVisible()) {
            this.CH.setFinaisIdaVoltaComIndex(0, this.CJ.getSelectedIndex() + 1);
        }
        if (this.CK.isVisible()) {
            this.CH.setFinaisIdaVoltaComIndex(1, this.CK.getSelectedIndex() + 1);
        }
        if (this.CL.isVisible()) {
            this.CH.setFinaisIdaVoltaComIndex(2, this.CL.getSelectedIndex() + 1);
        }
    }

    public void a(ConfigEstadualType configEstadualType) {
        this.CH = configEstadualType;
        this.CM.setSelectedIndex(this.CH.getFormula());
        if (this.CH.getDesempate() == 0) {
            this.CI.setSelected(true);
        } else {
            this.CI.setSelected(false);
        }
        this.a(this.CH.getFormula(), aq.sL[this.CH.getFormula()][2], this.CH);
    }

    private void da(int n2) {
        this.a(n2, aq.sL[n2][2], null);
    }

    private void a(int n2, int n3, ConfigEstadualType configEstadualType) {
        if (7 == n2 || 10 == n2) {
            n3 = 8;
        }
        if (n3 == 2) {
            this.a(this.CJ, "f");
            this.CK.setVisible(false);
            this.CL.setVisible(false);
        } else if (n3 == 4) {
            this.a(this.CJ, "s");
            this.a(this.CK, "f");
            this.CK.setVisible(true);
            this.CL.setVisible(false);
        } else if (n3 == 8) {
            this.a(this.CJ, "q");
            this.a(this.CK, "s");
            this.a(this.CL, "f");
            this.CK.setVisible(true);
            this.CL.setVisible(true);
        }
        if (configEstadualType != null) {
            if (configEstadualType.getFinaisIdaVoltaFormatado()[0]) {
                this.CJ.setSelectedIndex(1);
            }
            if (n3 >= 4 && configEstadualType.getFinaisIdaVoltaFormatado()[1]) {
                this.CK.setSelectedIndex(1);
            }
            if (n3 == 8 && configEstadualType.getFinaisIdaVoltaFormatado()[2]) {
                this.CL.setSelectedIndex(1);
            }
        } else {
            this.CJ.setSelectedIndex(1);
            if (n3 >= 4) {
                this.CK.setSelectedIndex(1);
            }
            if (n3 == 8) {
                this.CL.setSelectedIndex(1);
            }
        }
    }

    private void a(JComboBox jComboBox, String string) {
        jComboBox.removeAllItems();
        if (string.equals("q")) {
            jComboBox.addItem("Quartas: 1 jogo");
            jComboBox.addItem("Quartas: 2 jogos");
        } else if (string.equals("s")) {
            jComboBox.addItem("Semifinal: 1 jogo");
            jComboBox.addItem("Semifinal: 2 jogos");
        } else if (string.equals("f")) {
            jComboBox.addItem("Final: 1 jogo");
            jComboBox.addItem("Final: 2 jogos");
        }
    }

    public void db(int n2) {
        if (n2 == 1) {
            this.setBackground(new Color(36, 104, 43));
        } else if (n2 == 2) {
            this.setBackground(new Color(116, 20, 19));
        } else if (n2 == 3) {
            this.setBackground(new Color(102, 102, 102));
        }
    }

    private void mJ() {
        this.CN = new JLabel();
        this.CL = new JComboBox();
        this.CI = new JCheckBox();
        this.CM = new JComboBox();
        this.CJ = new JComboBox();
        this.CK = new JComboBox();
        this.setBackground(new Color(36, 91, 45));
        this.setLayout(new b());
        this.CN.setForeground(new Color(255, 255, 255));
        this.CN.setHorizontalAlignment(4);
        this.CN.setText("Sistema:");
        this.add((Component)this.CN, new a(10, 14, 81, -1));
        this.add((Component)this.CL, new a(400, 50, 130, -1));
        this.CI.setForeground(new Color(255, 255, 255));
        this.CI.setText("Desempate por penalties");
        this.CI.setOpaque(false);
        this.add((Component)this.CI, new a(355, 10, -1, -1));
        this.add((Component)this.CM, new a(101, 11, 223, -1));
        this.add((Component)this.CJ, new a(100, 50, 130, -1));
        this.add((Component)this.CK, new a(250, 50, 130, -1));
    }

    static /* synthetic */ JComboBox a(cu cu2) {
        return cu2.CM;
    }

    static /* synthetic */ void a(cu cu2, int n2) {
        cu2.da(n2);
    }

    static /* synthetic */ cw b(cu cu2) {
        return cu2.CG;
    }

    static /* synthetic */ int c(cu cu2) {
        return cu2.CF;
    }
}

