/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.dG;
import a.dL;
import a.dM;
import a.gN;
import a.gV;
import a.gW;
import components.a;
import components.b;
import est.ConfigLigaType;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class dK
extends JPanel {
    private static final long serialVersionUID = 1L;
    private static String[] Gv = new String[]{"Sem mata-mata", "Oit./Quar./semi/final", "Quartas/semi/final", "Semi/Final", "Final", "2 grupos de 4 e Final"};
    private static String[] Gw = new String[]{"sem grupos", "2 grupos de 10", "2 grupos de 12", "8 grupos de 5", "2 grupos de 20"};
    private int divisao = 0;
    private dG Gx = null;
    private ConfigLigaType aeQ = null;
    private ConfigLigaType aeR = null;
    private int[] aeS = new int[]{1, 2, 3, 4};
    private int[] aeT = new int[]{1, 2, 3, 4};
    private int aeU = 0;
    private JCheckBox Gz;
    private JCheckBox CI;
    private JCheckBox aeV;
    private JCheckBox aeW;
    private JCheckBox aeX;
    private JComboBox GA;
    private JComboBox GB;
    private JComboBox aeY;
    private JComboBox aeZ;
    private JComboBox afa;
    private JComboBox GD;
    private JTextField GE;
    private JTextField GF;
    private JLabel afb;
    private JLabel GG;
    private JLabel GH;
    private JLabel uF;
    private JLabel afc;
    private JLabel Mp;
    private JLabel afd;
    private JLabel afe;
    private JLabel aff;
    private JLabel afg;
    private JLabel afh;
    private JLabel GJ;

    public dK(int n2, dG dG2) {
        this.divisao = n2;
        this.Gx = dG2;
        this.mJ();
        int[] nArray = new int[]{8, 10, 12, 14, 16, 18, 20, 22, 24, 25, 26, 28, 30, 36, 40, 48, 64};
        int[] nArray2 = new int[]{8, 10, 12, 14, 16, 18, 20, 22, 24, 25, 26, 28, 30, 36, 40, 48, 64, 68};
        if (this.divisao == 4) {
            nArray = nArray2;
        }
        this.GD.setMaximumRowCount(nArray.length);
        int n3 = 0;
        while (n3 < nArray.length) {
            this.GD.addItem(nArray[n3]);
            ++n3;
        }
        n3 = 0;
        while (n3 < this.aeS.length) {
            this.aeY.addItem(this.aeS[n3]);
            ++n3;
        }
        this.GD.addActionListener(new dL(this));
        this.GA.addActionListener(new dM(this));
        this.aeY.addActionListener(new gN(this));
        this.aeZ.addActionListener(new gV(this));
        this.afa.addActionListener(new gW(this));
        if (this.divisao == 1) {
            this.afh.setText("Times que sobem: 0");
            this.aeU = 0;
            this.afa.setEnabled(false);
            this.fw(0);
            this.c(false, false);
            this.aff.setVisible(false);
            this.afa.setVisible(false);
        }
    }

    private void AE() {
        this.AH();
    }

    private void AF() {
        this.Gx.af(this.divisao, this.aeS[this.aeY.getSelectedIndex()]);
        this.aeZ.removeAllItems();
        int n2 = 0;
        while (n2 < this.aeS[this.aeY.getSelectedIndex()]) {
            this.aeZ.addItem(this.aeT[n2]);
            ++n2;
        }
        this.aeZ.setSelectedIndex(this.aeZ.getItemCount() - 1);
    }

    public void fv(int n2) {
        this.afh.setText("Times que sobem: " + n2);
        this.aeU = n2;
    }

    public void aP(boolean bl2) {
        this.afa.removeAllItems();
        if (this.aeU == 1) {
            this.afa.addItem(0);
            this.AG();
        } else if (this.aeU == 2) {
            this.afa.addItem(0);
            this.afa.addItem(1);
            this.AG();
        } else if (this.aeU == 3 || this.aeU == 4) {
            this.afa.addItem(0);
            this.afa.addItem(1);
            this.afa.addItem(2);
            this.AG();
        }
        if (bl2) {
            this.afa.setSelectedItem(this.aeQ.getVagasSobemPeloMataMata());
        } else {
            this.afa.setSelectedItem(0);
            this.AG();
        }
    }

    public void AG() {
        if (this.afa.getSelectedItem() != null) {
            if ((Integer)this.afa.getSelectedItem() == 0) {
                this.c(false, false);
            } else if ((Integer)this.afa.getSelectedItem() == 1) {
                this.c(true, true);
            } else if ((Integer)this.afa.getSelectedItem() == 2) {
                this.c(false, true);
            }
        }
    }

    public void fw(int n2) {
    }

    public void AH() {
        int n2 = 0;
        if (this.aeY.getSelectedIndex() >= 0 && this.aeZ.getSelectedIndex() >= 0) {
            n2 = this.aeS[this.aeY.getSelectedIndex()] - this.aeT[this.aeZ.getSelectedIndex()];
        }
        this.afd.setText("Disputam playoff com liga abaixo: " + n2);
    }

    public void c(boolean bl2, boolean bl3) {
        this.afg.setVisible(bl3);
        this.aeW.setVisible(bl3);
        this.afb.setVisible(bl2);
        this.aeX.setVisible(bl2);
        if (bl2) {
            this.afg.setText("Semifinal");
        } else {
            this.afg.setText("Final");
        }
    }

    public void a(ConfigLigaType configLigaType, ConfigLigaType configLigaType2) {
        int n2;
        this.b(configLigaType);
        this.GE.setText(configLigaType.getNome2());
        if (this.GE.getText().isEmpty()) {
            configLigaType.setNome2("Campeonato");
        }
        this.GF.setText(configLigaType.getNomeDivisao());
        if (this.GF.getText().isEmpty() || this.GF.getText() == "") {
            configLigaType.setNomeDivisao(String.valueOf(configLigaType.getDivisao()) + "\u00aa divis\u00e3o");
        }
        this.dh(configLigaType.getnTimes());
        this.di(configLigaType.getnTimes());
        if (configLigaType.getnTimes() == 8 || configLigaType.getnTimes() == 10 || configLigaType.getnTimes() == 12 || configLigaType.getnTimes() == 14) {
            if (configLigaType.getFormula() == 0) {
                if (configLigaType.getnTimes() == 8) {
                    this.GA.setSelectedItem("4");
                } else if (configLigaType.getnTimes() == 10) {
                    this.GA.setSelectedItem("4");
                } else if (configLigaType.getnTimes() == 12) {
                    this.GA.setSelectedItem("3");
                } else if (configLigaType.getnTimes() == 14) {
                    this.GA.setSelectedItem("3");
                }
            } else {
                this.GA.setSelectedItem(Integer.toString(configLigaType.getFormula()));
            }
            n2 = configLigaType.getNumeroTimesMataMata();
            if (n2 == 8) {
                this.GB.setSelectedItem(Gv[2]);
            } else if (n2 == 4) {
                this.GB.setSelectedItem(Gv[3]);
            } else if (n2 == 2) {
                this.GB.setSelectedItem(Gv[4]);
            } else {
                this.GB.setSelectedIndex(0);
            }
        } else {
            this.O(configLigaType.getnGrupos(), configLigaType.getNumeroTimesMataMata());
        }
        if (configLigaType.getnRebaixados() < 1 && configLigaType.getnRebaixados() > 4) {
            configLigaType.setnRebaixados(2);
        }
        this.aeY.setSelectedItem(configLigaType.getnRebaixados());
        this.aeZ.removeAllItems();
        n2 = 0;
        while (n2 < configLigaType.getnRebaixados()) {
            this.aeZ.addItem(this.aeT[n2]);
            ++n2;
        }
        if (configLigaType.getRebaixadosDireto() == 0) {
            this.aeZ.setSelectedItem(configLigaType.getnRebaixados());
        } else {
            this.aeZ.setSelectedItem(configLigaType.getRebaixadosDireto());
        }
        this.aP(true);
        if (configLigaType.getDuasVoltasMataMataSobe() != null) {
            boolean[] blArray = configLigaType.getDuasVoltasMataMataSobe();
            this.aeW.setSelected(blArray[0]);
            this.aeX.setSelected(blArray[1]);
        }
        if (configLigaType.getDuasVoltasplayoffReb() != null) {
            this.aeV.setSelected(configLigaType.getDuasVoltasplayoffReb()[0]);
        }
        boolean[] blArray = configLigaType.getDuasVoltasMataMata();
        this.Gz.setSelected(blArray[0]);
        if (configLigaType.getDesempate() == 0) {
            this.CI.setSelected(true);
        } else {
            this.CI.setSelected(false);
        }
        this.AH();
    }

    public void db(int n2) {
        if (n2 == 1) {
            this.setBackground(new Color(0, 75, 106));
        } else if (n2 == 2) {
            this.setBackground(new Color(116, 20, 19));
        } else if (n2 == 3) {
            this.setBackground(new Color(102, 102, 102));
        }
    }

    public void O(int n2, int n3) {
        if (n2 == 0) {
            this.GA.setSelectedIndex(0);
        } else if (n2 == 2) {
            this.GA.setSelectedIndex(1);
        } else if (n2 == 8) {
            this.GA.setSelectedIndex(0);
        } else if (n2 == 12) {
            this.GA.setSelectedIndex(0);
        }
        if (n2 == 8) {
            this.GB.setSelectedIndex(0);
        } else if (n2 == 12) {
            this.GB.setSelectedIndex(0);
        } else if (n2 > 0) {
            if (n3 == 4) {
                this.GB.setSelectedItem(Gv[2]);
            } else if (n3 == 2) {
                this.GB.setSelectedItem(Gv[3]);
            } else if (n3 == 1) {
                this.GB.setSelectedItem(Gv[4]);
            } else if (n3 == 1020) {
                this.GB.setSelectedItem(Gv[5]);
            } else {
                this.GB.setSelectedIndex(0);
            }
        } else if (n3 == 8) {
            this.GB.setSelectedItem(Gv[2]);
        } else if (n3 == 4) {
            this.GB.setSelectedItem(Gv[3]);
        } else if (n3 == 2) {
            this.GB.setSelectedItem(Gv[4]);
        } else if (n3 == 1020) {
            this.GB.setSelectedItem(Gv[5]);
        } else {
            this.GB.setSelectedIndex(0);
        }
    }

    public void dh(int n2) {
        this.GD.setSelectedItem(n2);
    }

    public void b(ConfigLigaType configLigaType) {
        this.aeQ = configLigaType;
    }

    public void nH() {
        int n2 = 0;
        int[] nArray = new int[]{8, 10, 12, 14, 16, 18, 20, 22, 24, 25, 26, 28, 30, 36, 40, 48, 64, 68};
        n2 = nArray[this.GD.getSelectedIndex()];
        this.aeQ.setVersaoArquivo(22);
        this.aeQ.setnTimes(n2);
        this.aeQ.setnRebaixados(this.aeS[this.aeY.getSelectedIndex()]);
        this.aeQ.setRebaixadosDireto(this.aeT[this.aeZ.getSelectedIndex()]);
        this.aeQ.setMelhoresTerceiros(false);
        boolean[] blArray = new boolean[2];
        if (this.aeW.isVisible()) {
            blArray[0] = this.aeW.isSelected();
        }
        if (this.aeX.isVisible()) {
            blArray[1] = this.aeX.isSelected();
        }
        this.aeQ.setIdaVoltaMMSobe(blArray[0], blArray[1]);
        if (this.aeV.isVisible()) {
            this.aeQ.setDuasVoltasplayoffReb(this.aeV.isSelected());
        }
        if (this.divisao > 1) {
            this.aeQ.setVagasSobemPeloMataMata((Integer)this.afa.getSelectedItem());
        }
        this.aeQ.setnGrupos(0);
        if (this.aeQ.getnTimes() == 20 || this.aeQ.getnTimes() == 24) {
            if (this.GA.getSelectedIndex() == 1) {
                this.aeQ.setnGrupos(2);
            }
        } else if (this.aeQ.getnTimes() == 40) {
            this.aeQ.setnGrupos(8);
            if (this.GA.getSelectedIndex() == 1) {
                this.aeQ.setnGrupos(2);
            }
        } else if (this.aeQ.getnTimes() == 48) {
            this.aeQ.setnGrupos(12);
        } else if (this.aeQ.getnTimes() == 64) {
            this.aeQ.setnGrupos(8);
        } else if (this.aeQ.getnTimes() == 68) {
            this.aeQ.setnGrupos(8);
        }
        this.aeQ.setFormula(0);
        if (this.aeQ.getnTimes() == 8 || this.aeQ.getnTimes() == 10 || this.aeQ.getnTimes() == 12 || this.aeQ.getnTimes() == 14) {
            if (this.GA.getSelectedItem().equals("4")) {
                this.aeQ.setFormula(4);
            } else if (this.GA.getSelectedItem().equals("3")) {
                this.aeQ.setFormula(3);
            } else if (this.GA.getSelectedItem().equals("2")) {
                this.aeQ.setFormula(2);
            }
        }
        if (this.aeQ.getnTimes() == 30) {
            this.aeQ.setDoisTurnos(false);
        }
        this.aeQ.setNumeroTimesMataMata(0);
        int[] nArray2 = new int[6];
        nArray2[1] = 16;
        nArray2[2] = 8;
        nArray2[3] = 4;
        nArray2[4] = 2;
        nArray2[5] = 1020;
        int[] nArray3 = nArray2;
        int n3 = 0;
        while (n3 < Gv.length) {
            if (this.GB.getSelectedItem().equals(Gv[n3])) {
                this.aeQ.setNumeroTimesMataMata(nArray3[n3]);
            }
            ++n3;
        }
        if (this.aeQ.getnGrupos() > 0) {
            if (this.aeQ.getNumeroTimesMataMata() == 0) {
                this.aeQ.setNumeroTimesMataMata(2);
            }
            if (this.aeQ.getNumeroTimesMataMata() < 1000) {
                this.aeQ.setNumeroTimesMataMata(this.aeQ.getNumeroTimesMataMata() / this.aeQ.getnGrupos());
            }
            if (this.aeQ.getnTimes() == 20 && this.aeQ.getnGrupos() == 2) {
                this.aeQ.setRebaixadoPeloGrupo(true);
                if (this.aeQ.getnRebaixados() == 1 || this.aeQ.getnRebaixados() == 3) {
                    this.aeQ.setnRebaixados(4);
                }
            }
            if (this.aeQ.getnTimes() == 40 && this.aeQ.getnGrupos() == 8) {
                this.aeQ.setRebaixadoPeloGrupo(false);
            }
            if (this.aeQ.getnTimes() == 48 && this.aeQ.getnGrupos() == 12) {
                this.aeQ.setRebaixadoPeloGrupo(false);
                this.aeQ.setNumeroTimesMataMata(2);
                this.aeQ.setMelhoresTerceiros(true);
            } else if (this.aeQ.getnTimes() == 64 && this.aeQ.getnGrupos() == 8) {
                this.aeQ.setRebaixadoPeloGrupo(false);
                this.aeQ.setNumeroTimesMataMata(4);
                this.aeQ.setDoisTurnos(true);
            } else if (this.aeQ.getnTimes() == 68 && this.aeQ.getnGrupos() == 8) {
                this.aeQ.setRebaixadoPeloGrupo(false);
                this.aeQ.setNumeroTimesMataMata(4);
                this.aeQ.setMelhoresTerceiros(false);
            }
        }
        boolean[] blArray2 = new boolean[]{true, true, true, true, true, true, true};
        boolean[] blArray3 = new boolean[7];
        if (this.Gz.isSelected()) {
            this.aeQ.setDuasVoltasMataMata(blArray2);
        } else {
            this.aeQ.setDuasVoltasMataMata(blArray3);
        }
        if (this.aeQ.getnTimes() > 22 && this.aeQ.getnTimes() < 25) {
            this.aeQ.setDuasVoltasMataMata(blArray3);
        }
        if (this.aeQ.getnTimes() == 24 && this.GA.getSelectedIndex() == 1 && this.Gz.isSelected()) {
            this.aeQ.setDuasVoltasMataMata(blArray2);
        }
        if (this.aeQ.getnTimes() == 40 || this.aeQ.getnTimes() == 48 || this.aeQ.getnTimes() == 68) {
            this.aeQ.setDuasVoltasMataMata(blArray2);
        }
        if (!this.Gz.isSelected()) {
            this.aeQ.setDuasVoltasMataMata(blArray3);
        }
        if (!this.CI.isSelected()) {
            this.aeQ.setDesempate(1);
        } else if (this.CI.isSelected()) {
            this.aeQ.setDesempate(0);
        }
        if (!this.GE.getText().toString().equals("")) {
            this.aeQ.setNome2(this.GE.getText().toString());
        }
        this.aeQ.setNomeDivisao(this.GF.getText().toString());
    }

    public void di(int n2) {
        this.GA.setVisible(true);
        this.GG.setVisible(true);
        this.GG.setText("Grupos");
        this.GA.removeAllItems();
        if (n2 == 20) {
            this.GA.addItem(Gw[0]);
            this.GA.addItem(Gw[1]);
        } else if (n2 == 24) {
            this.GA.addItem(Gw[0]);
            this.GA.addItem(Gw[2]);
        } else if (n2 == 40) {
            this.GA.addItem(Gw[3]);
            this.GA.addItem(Gw[4]);
        } else if (n2 == 48) {
            this.GA.addItem("12 grupos de 4");
        } else if (n2 == 64) {
            this.GA.addItem("8 grupos de 8");
        } else if (n2 == 68) {
            this.GA.addItem("Seletiva/8 grupos de 8");
        } else {
            this.GA.addItem(Gw[0]);
            this.GA.setVisible(false);
            this.GG.setVisible(false);
        }
        if (n2 == 8 || n2 == 10 || n2 == 12 || n2 == 14) {
            this.d(n2, true);
        } else {
            this.d(n2, false);
        }
        if (n2 < 20) {
            this.aeY.setSelectedIndex(0);
        } else {
            this.aeY.setSelectedIndex(1);
        }
        if (n2 == 8 || n2 == 10 || n2 == 12 || n2 == 14) {
            this.GA.setVisible(true);
            this.GG.setVisible(true);
            this.GA.removeAllItems();
            this.GG.setText("Turnos");
            if (n2 == 10) {
                this.GA.addItem("2");
                this.GA.addItem("3");
                this.GA.addItem("4");
                this.GA.setSelectedItem("4");
            } else if (n2 == 12 || n2 == 14) {
                this.GA.addItem("2");
                this.GA.addItem("3");
                this.GA.setSelectedItem("3");
            } else if (n2 == 8) {
                this.GA.addItem("4");
            }
            this.d(n2, true);
        }
    }

    private void d(int n2, boolean bl2) {
        this.GB.removeAllItems();
        if (n2 <= 10 || n2 == 12 || n2 == 14) {
            this.GB.addItem(Gv[0]);
            this.GB.addItem(Gv[2]);
            this.GB.addItem(Gv[3]);
            this.GB.addItem(Gv[4]);
        } else if (n2 <= 20 || n2 == 30 || n2 == 25 || n2 == 26 || n2 == 28 || n2 == 36) {
            boolean bl3 = false;
            if (this.GA.getSelectedItem() != null && this.GA.getSelectedItem().equals(Gw[0])) {
                this.GB.addItem(Gv[0]);
                bl3 = true;
            }
            if (bl2) {
                this.GB.addItem(Gv[0]);
            }
            this.GB.addItem(Gv[2]);
            this.GB.addItem(Gv[3]);
            this.GB.addItem(Gv[4]);
            if (n2 == 20) {
                this.GB.addItem(Gv[5]);
            }
        } else if (n2 == 22) {
            this.GB.addItem(Gv[0]);
            this.GB.addItem(Gv[2]);
            this.GB.addItem(Gv[3]);
            this.GB.addItem(Gv[4]);
        } else if (n2 == 24) {
            if (this.GA.getSelectedItem() != null && this.GA.getSelectedItem().equals(Gw[0])) {
                this.GB.addItem(Gv[0]);
            } else {
                this.GB.addItem(Gv[2]);
                this.GB.addItem(Gv[3]);
                this.GB.addItem(Gv[4]);
            }
        } else if (n2 == 40) {
            if (this.GA.getSelectedItem() != null && this.GA.getSelectedItem().equals(Gw[4])) {
                this.GB.addItem(Gv[3]);
                this.GB.addItem(Gv[4]);
            } else {
                this.GB.addItem(Gv[1]);
            }
        } else if (n2 == 48 || n2 == 64 || n2 == 68) {
            this.GB.addItem("32 classificados");
        } else {
            this.GB.addItem(Gv[0]);
        }
    }

    private void mJ() {
        this.GE = new JTextField();
        this.aeY = new JComboBox();
        this.uF = new JLabel();
        this.GF = new JTextField();
        this.GJ = new JLabel();
        this.GD = new JComboBox();
        this.GG = new JLabel();
        this.GA = new JComboBox();
        this.GH = new JLabel();
        this.aeX = new JCheckBox();
        this.CI = new JCheckBox();
        this.afc = new JLabel();
        this.Mp = new JLabel();
        this.afd = new JLabel();
        this.afb = new JLabel();
        this.afa = new JComboBox();
        this.afe = new JLabel();
        this.aeZ = new JComboBox();
        this.afh = new JLabel();
        this.GB = new JComboBox();
        this.Gz = new JCheckBox();
        this.aeW = new JCheckBox();
        this.aff = new JLabel();
        this.aeV = new JCheckBox();
        this.afg = new JLabel();
        this.setBackground(new Color(0, 75, 106));
        this.setMinimumSize(new Dimension(720, 160));
        this.setPreferredSize(new Dimension(720, 160));
        this.setRequestFocusEnabled(false);
        this.setVerifyInputWhenFocusTarget(false);
        this.setLayout(new b());
        this.add((Component)this.GE, new a(100, 10, 220, -1));
        this.add((Component)this.aeY, new a(450, 90, 48, -1));
        this.uF.setFont(new Font("Tahoma", 0, 12));
        this.uF.setForeground(new Color(255, 255, 255));
        this.uF.setHorizontalAlignment(4);
        this.uF.setText("Nome divis\u00e3o:");
        this.add((Component)this.uF, new a(11, 40, 80, -1));
        this.add((Component)this.GF, new a(100, 40, 220, -1));
        this.GJ.setFont(new Font("Tahoma", 0, 12));
        this.GJ.setForeground(new Color(255, 255, 255));
        this.GJ.setHorizontalAlignment(4);
        this.GJ.setText("Total times:");
        this.add((Component)this.GJ, new a(20, 70, 70, -1));
        this.add((Component)this.GD, new a(100, 70, 49, -1));
        this.GG.setFont(new Font("Tahoma", 0, 12));
        this.GG.setForeground(new Color(255, 255, 255));
        this.GG.setHorizontalAlignment(4);
        this.GG.setText("Grupos:");
        this.GG.setToolTipText("");
        this.add((Component)this.GG, new a(158, 70, 50, -1));
        this.GA.setModel(new DefaultComboBoxModel<String>(new String[]{"Sem Grupos", "4 grupos"}));
        this.add((Component)this.GA, new a(210, 70, 110, -1));
        this.GH.setFont(new Font("Tahoma", 0, 12));
        this.GH.setForeground(new Color(255, 255, 255));
        this.GH.setHorizontalAlignment(4);
        this.GH.setText("Mata-mata:");
        this.add((Component)this.GH, new a(20, 100, 70, -1));
        this.aeX.setFont(new Font("Tahoma", 0, 12));
        this.aeX.setForeground(new Color(255, 255, 255));
        this.aeX.setText("Ida e volta");
        this.aeX.setOpaque(false);
        this.add((Component)this.aeX, new a(630, 50, 90, -1));
        this.CI.setFont(new Font("Tahoma", 0, 12));
        this.CI.setForeground(new Color(255, 255, 255));
        this.CI.setText("Desempate por penalties");
        this.CI.setOpaque(false);
        this.add((Component)this.CI, new a(180, 122, -1, -1));
        this.afc.setFont(new Font("Tahoma", 0, 12));
        this.afc.setForeground(new Color(255, 255, 255));
        this.afc.setHorizontalAlignment(4);
        this.afc.setText("Nome:");
        this.add((Component)this.afc, new a(40, 15, 51, -1));
        this.add((Component)this.aeZ, new a(660, 90, 48, -1));
        this.afe.setBackground(new Color(7, 28, 39));
        this.afe.setFont(new Font("Tahoma", 0, 12));
        this.afe.setForeground(new Color(255, 255, 255));
        this.afe.setHorizontalAlignment(2);
        this.afe.setText("Rebaixados direto:");
        this.afe.setOpaque(true);
        this.add((Component)this.afe, new a(550, 90, 170, 20));
        this.Mp.setBackground(new Color(7, 28, 39));
        this.Mp.setFont(new Font("Tahoma", 0, 12));
        this.Mp.setForeground(new Color(255, 255, 255));
        this.Mp.setText("Total Rebaixados:");
        this.Mp.setOpaque(true);
        this.add((Component)this.Mp, new a(340, 90, 210, 20));
        this.afd.setFont(new Font("Tahoma", 0, 12));
        this.afd.setForeground(new Color(255, 255, 255));
        this.afd.setHorizontalAlignment(4);
        this.afd.setText("Disputam playoff com liga abaixo: 5");
        this.add((Component)this.afd, new a(360, 120, 200, -1));
        this.afd.getAccessibleContext().setAccessibleName("Disputam playoff com liga abaixo: 0");
        this.afb.setFont(new Font("Tahoma", 0, 12));
        this.afb.setForeground(new Color(255, 255, 255));
        this.afb.setHorizontalAlignment(4);
        this.afb.setText("Final:");
        this.add((Component)this.afb, new a(620, 38, 40, 10));
        this.add((Component)this.afa, new a(480, 40, 48, -1));
        this.afh.setBackground(new Color(7, 28, 39));
        this.afh.setFont(new Font("Tahoma", 0, 12));
        this.afh.setForeground(new Color(255, 255, 255));
        this.afh.setText("Times que sobem:");
        this.afh.setOpaque(true);
        this.add((Component)this.afh, new a(340, 10, 380, 20));
        this.GB.setModel(new DefaultComboBoxModel<String>(new String[]{"Quartas/Semi/Final", "Sem Mata-Mata", " "}));
        this.add((Component)this.GB, new a(100, 100, 220, -1));
        this.Gz.setFont(new Font("Tahoma", 0, 12));
        this.Gz.setForeground(new Color(255, 255, 255));
        this.Gz.setText("Mata-mata em dois jogos");
        this.Gz.setOpaque(false);
        this.add((Component)this.Gz, new a(10, 122, 170, -1));
        this.aeW.setFont(new Font("Tahoma", 0, 12));
        this.aeW.setForeground(new Color(255, 255, 255));
        this.aeW.setText("Ida e volta");
        this.aeW.setOpaque(false);
        this.add((Component)this.aeW, new a(535, 50, 90, -1));
        this.aff.setFont(new Font("Tahoma", 0, 12));
        this.aff.setForeground(new Color(255, 255, 255));
        this.aff.setHorizontalAlignment(4);
        this.aff.setText("Vagas pelo mata-mata:");
        this.add((Component)this.aff, new a(340, 40, 130, -1));
        this.aeV.setFont(new Font("Tahoma", 0, 12));
        this.aeV.setForeground(new Color(255, 255, 255));
        this.aeV.setText("Ida e volta");
        this.aeV.setOpaque(false);
        this.add((Component)this.aeV, new a(580, 115, 100, -1));
        this.afg.setFont(new Font("Tahoma", 0, 12));
        this.afg.setForeground(new Color(255, 255, 255));
        this.afg.setText("Final");
        this.add((Component)this.afg, new a(540, 36, 70, -1));
    }

    static /* synthetic */ JComboBox a(dK dK2) {
        return dK2.GD;
    }

    static /* synthetic */ dG b(dK dK2) {
        return dK2.Gx;
    }

    static /* synthetic */ int c(dK dK2) {
        return dK2.divisao;
    }

    static /* synthetic */ void a(dK dK2, int n2, boolean bl2) {
        dK2.d(n2, bl2);
    }

    static /* synthetic */ void d(dK dK2) {
        dK2.AF();
    }

    static /* synthetic */ void e(dK dK2) {
        dK2.AE();
    }
}

