/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.fx;
import c.a;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

public class fw
extends JPanel {
    private JDialog ub;
    private JButton zn;
    private JTextField IA;
    private JLabel ug;
    private JPanel vd;

    public fw(JDialog jDialog) {
        this.ub = jDialog;
        this.mJ();
        this.mH();
    }

    public void mH() {
        this.zn.addActionListener(new fx(this));
    }

    private void nH() {
        String string = this.IA.getText().toString();
        int n2 = -1;
        boolean bl2 = false;
        File file = new File(String.valueOf(System.getProperty("user.dir")) + "/sav/" + string + ".s22");
        if (string.isEmpty() || string.length() > 15 || string.length() == 0) {
            String string2 = "";
            if (string.length() > 15) {
                string2 = ": muito extenso";
            }
            JOptionPane.showMessageDialog(this.ub, "Arquivo inv\u00e1lido" + string2, "Erro", 0);
        } else {
            bl2 = file.exists() ? (n2 = JOptionPane.showConfirmDialog(this.ub, "Um arquivo com esse nome j\u00e1 existe, sobrescrever?", "Arquivo j\u00e1 existe", 0)) == 0 : true;
        }
        if (bl2) {
            this.zn.setCursor(new Cursor(3));
            this.ub.setCursor(new Cursor(3));
            a.SR.d(string);
            this.ub.dispose();
        }
    }

    private boolean C(String string) {
        File file = new File(String.valueOf(System.getProperty("user.dir")) + "/sav/" + string + ".sav");
        return file.exists() && !file.isDirectory();
    }

    private void mJ() {
        this.ug = new JLabel();
        this.vd = new JPanel();
        this.IA = new JTextField();
        this.zn = new JButton();
        this.setBackground(new Color(204, 204, 204));
        this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.ug.setFont(new Font("Tahoma", 1, 12));
        this.ug.setHorizontalAlignment(0);
        this.ug.setText("Escolha um nome de arquivo para salvar o jogo:");
        this.vd.setBackground(new Color(204, 204, 204));
        this.IA.setFont(new Font("Tahoma", 0, 12));
        this.zn.setText("Salvar");
        GroupLayout groupLayout = new GroupLayout(this.vd);
        this.vd.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(54, 54, 54).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.IA, -2, 313, -2).addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup().addComponent(this.zn, -2, 127, -2).addGap(78, 78, 78))).addContainerGap(56, Short.MAX_VALUE)));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(this.IA, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE).addComponent(this.zn, -2, 31, -2).addGap(23, 23, 23)));
        GroupLayout groupLayout2 = new GroupLayout(this);
        this.setLayout(groupLayout2);
        groupLayout2.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addGap(20, 20, 20).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.vd, -1, -1, Short.MAX_VALUE).addComponent(this.ug, -1, -1, Short.MAX_VALUE)).addContainerGap(19, Short.MAX_VALUE)));
        groupLayout2.setVerticalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addGap(18, 18, 18).addComponent(this.ug).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.vd, -2, -1, -2).addContainerGap(22, Short.MAX_VALUE)));
    }

    static /* synthetic */ void a(fw fw2) {
        fw2.nH();
    }
}

