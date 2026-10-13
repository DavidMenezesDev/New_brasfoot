/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.dO;
import a.dP;
import a.dQ;
import a.dR;
import a.dS;
import a.dT;
import a.dU;
import best.n;
import c.a;
import est.InfoArquivoSalvoType;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public class dN
extends JPanel {
    private JDialog ub;
    private ArrayList GL = new ArrayList();
    private String[][] GM = new String[1][1];
    private String GN = null;
    private Timer GO = null;
    private JButton vb;
    private JButton vc;
    private JButton GP;
    private JLabel ug;
    private JScrollPane ut;
    private JTable GQ;
    private JLabel yA;
    private JLabel Fr;

    public dN(JDialog jDialog) {
        this.ub = jDialog;
        this.mJ();
        this.mK();
        this.nc();
        this.mH();
    }

    public void mH() {
        this.vb.addActionListener(new dO(this));
        this.vc.addActionListener(new dP(this));
        this.GP.addActionListener(new dQ(this));
    }

    private void pW() {
        if (this.GN != null) {
            this.yA.setText("carregando...");
            this.Fr.setText("aguarde...");
            if (this.GO == null) {
                this.GO = new Timer(10, new dR(this));
                this.GO.setRepeats(false);
                this.GO.start();
            } else {
                this.GO.restart();
            }
        }
    }

    private void pX() {
        int n2 = -1;
        n2 = JOptionPane.showConfirmDialog(this.ub, "Deseja excluir o arquivo?", "Confirma\u00e7\u00e3o", 0);
        if (n2 == 0 && this.GN != null) {
            String string = String.valueOf(n.cK) + "/sav/" + this.GN + ".s22";
            Path path = Paths.get(string, new String[0]);
            try {
                Files.deleteIfExists(path);
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
            this.mK();
            this.nc();
        }
    }

    private void mK() {
        this.GM = null;
        this.GL.clear();
        File file = new File(String.valueOf(System.getProperty("user.dir")) + "/sav");
        File[] fileArray = file.listFiles(new dS(this));
        int n2 = 0;
        while (n2 < fileArray.length) {
            if (fileArray[n2].isFile()) {
                String string = fileArray[n2].getName();
                string = string.substring(0, string.lastIndexOf("."));
                this.GL.add(string);
            }
            ++n2;
        }
        this.GM = new String[this.GL.size()][1];
        n2 = 0;
        while (n2 < this.GM.length) {
            this.GM[n2][0] = (String)this.GL.get(n2);
            ++n2;
        }
    }

    private void nc() {
        Object[] objectArray = new String[]{"Arquivo"};
        this.GQ.setSelectionMode(0);
        this.GQ.setRowSelectionAllowed(true);
        this.GQ.setSelectionBackground(Color.YELLOW);
        this.GQ.setFillsViewportHeight(true);
        this.GQ.setModel(new DefaultTableModel(this.GM, objectArray));
        this.GQ.getSelectionModel().addListSelectionListener(new dT(this));
        if (this.GQ.getRowCount() > 0) {
            this.GQ.setRowSelectionInterval(0, 0);
        }
    }

    private void pY() {
        InfoArquivoSalvoType infoArquivoSalvoType = null;
        infoArquivoSalvoType = a.af(this.GN);
        this.yA.setText("");
        this.Fr.setText("");
        if (infoArquivoSalvoType != null) {
            this.yA.setText(String.valueOf(Integer.toString(infoArquivoSalvoType.getA())) + " - " + infoArquivoSalvoType.getN() + " (" + infoArquivoSalvoType.getTc() + ")");
            this.Fr.setText("Pr\u00f3x.: " + infoArquivoSalvoType.getI());
        }
    }

    private void mJ() {
        this.ug = new JLabel();
        this.ut = new JScrollPane();
        this.GQ = new dU(this);
        this.vb = new JButton();
        this.vc = new JButton();
        this.GP = new JButton();
        this.yA = new JLabel();
        this.Fr = new JLabel();
        this.setBackground(new Color(104, 120, 100));
        this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        this.ug.setFont(new Font("Tahoma", 1, 12));
        this.ug.setForeground(new Color(255, 255, 255));
        this.ug.setText("Carregar Jogo Salvo");
        this.ut.setViewportView(this.GQ);
        this.vb.setIcon(new ImageIcon(this.getClass().getResource("/aicons/loadt.png")));
        this.vb.setText("Carregar");
        this.vc.setIcon(new ImageIcon(this.getClass().getResource("/aicons/home.png")));
        this.vc.setText("Cancelar");
        this.GP.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icondel.png")));
        this.GP.setText("Deletar");
        this.yA.setForeground(new Color(255, 255, 255));
        this.yA.setText("T\u00e9cnico:");
        this.Fr.setForeground(new Color(255, 255, 255));
        this.Fr.setText("T\u00e9cnico:");
        GroupLayout groupLayout = new GroupLayout(this);
        this.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(22, 22, 22).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.ut, -2, 0, Short.MAX_VALUE).addComponent(this.ug).addComponent(this.yA, -1, -1, Short.MAX_VALUE).addComponent(this.Fr, -1, -1, Short.MAX_VALUE).addGroup(groupLayout.createSequentialGroup().addComponent(this.vb, -2, 115, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.vc, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.GP, -2, 107, -2))).addContainerGap(20, Short.MAX_VALUE)));
        groupLayout.linkSize(0, this.vb, this.vc, this.GP);
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(this.ug).addGap(18, 18, 18).addComponent(this.ut, -2, 186, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.yA).addGap(18, 18, 18).addComponent(this.Fr).addGap(18, 18, 18).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.vb).addComponent(this.vc).addComponent(this.GP)).addContainerGap(22, Short.MAX_VALUE)));
        groupLayout.linkSize(1, this.vb, this.vc, this.GP);
    }

    static /* synthetic */ JDialog a(dN dN2) {
        return dN2.ub;
    }

    static /* synthetic */ void b(dN dN2) {
        dN2.pW();
    }

    static /* synthetic */ void c(dN dN2) {
        dN2.pX();
    }

    static /* synthetic */ String d(dN dN2) {
        return dN2.GN;
    }

    static /* synthetic */ JTable e(dN dN2) {
        return dN2.GQ;
    }

    static /* synthetic */ ArrayList f(dN dN2) {
        return dN2.GL;
    }

    static /* synthetic */ void a(dN dN2, String string) {
        dN2.GN = string;
    }

    static /* synthetic */ void g(dN dN2) {
        dN2.pY();
    }
}

