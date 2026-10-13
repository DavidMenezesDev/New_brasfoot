/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.db;
import a.dc;
import a.dd;
import a.de;
import a.gq;
import best.K;
import best.M;
import best.S;
import best.ae;
import best.p;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

public class da
extends JPanel {
    private JFrame Br;
    private JButton ud;
    private JButton vb;
    private JLabel ug;
    private JLabel Bj;
    private JLabel vw;
    private JLabel zb;
    private JLabel zc;
    private JLabel zd;
    private JLabel ze;
    private JLabel Ef;
    private JLabel Eg;
    private JLabel Eh;
    private JLabel Ei;
    private JLabel uh;
    private JLabel a_;
    private JLabel ur;
    private JLabel us;
    private JLabel vx;
    private JLabel vy;
    private JLabel vz;
    private JLabel vA;
    private JPanel vd;
    private JPanel we;
    private JSeparator BE;
    private JTextField Ej;
    private JTextField Ek;

    public da(JFrame jFrame) {
        this.mJ();
        this.mH();
    }

    private void pr() {
        try {
            Desktop.getDesktop().browse(new URI("http://www.brasfoot.com"));
        }
        catch (IOException | URISyntaxException exception) {
            // empty catch block
        }
    }

    private void pb() {
        gq gq2 = new gq();
        gq2.pack();
        gq2.setSize(529, 321);
        gq2.setLocationRelativeTo(null);
        gq2.setVisible(true);
        S.db().setVisible(false);
    }

    private boolean ps() {
        if (this.Ej.getText().isEmpty()) {
            return false;
        }
        if (this.Ek.getText().isEmpty()) {
            return false;
        }
        if (this.Ej.getText().toString().length() < 3) {
            return false;
        }
        ae.t(null);
        ae.u("");
        p.n(false);
        if (!this.Ej.getText().isEmpty() && this.Ej.getText().toString().length() > 1 && this.Ej.getText().toString().length() < 100) {
            ae.t(this.Ej.getText().toString());
        }
        String string = this.Ek.getText();
        string.trim();
        string = string.replaceAll("\\s+", "");
        String string2 = "";
        int n2 = 0;
        while (n2 < string.length()) {
            if (n2 < 8) {
                string2 = String.valueOf(string2) + string.charAt(n2);
            }
            ++n2;
        }
        if (!string2.isEmpty() && string2.length() > 1 && string2.length() >= 7 && this.B(string2)) {
            ae.u(string2);
        }
        K.in();
        if (p.dt()) {
            de.pu();
            de.pv();
            this.pb();
        }
        return false;
    }

    public boolean B(String string) {
        try {
            Integer.parseInt(string);
        }
        catch (NumberFormatException numberFormatException) {
            return false;
        }
        catch (NullPointerException nullPointerException) {
            return false;
        }
        return true;
    }

    public void mH() {
        this.Ef.addMouseListener(new db(this));
        this.ud.addActionListener(new dc(this));
        this.vb.addActionListener(new dd(this));
    }

    private void mJ() {
        this.vd = new JPanel();
        this.ug = new JLabel();
        this.BE = new JSeparator();
        this.uh = new JLabel();
        this.ur = new JLabel();
        this.us = new JLabel();
        this.vx = new JLabel();
        this.vy = new JLabel();
        this.vz = new JLabel();
        this.vA = new JLabel();
        this.Bj = new JLabel();
        this.vw = new JLabel();
        this.zb = new JLabel();
        this.zc = new JLabel();
        this.zd = new JLabel();
        this.ze = new JLabel();
        this.Ef = new JLabel();
        this.Eg = new JLabel();
        this.we = new JPanel();
        this.a_ = new JLabel();
        this.Ei = new JLabel();
        this.Ej = new JTextField();
        this.Ek = new JTextField();
        this.vb = new JButton();
        this.Eh = new JLabel();
        this.ud = new JButton();
        this.setBackground(new Color(84, 127, 59));
        this.vd.setBackground(new Color(42, 64, 29));
        this.ug.setFont(new Font("Tahoma", 1, 18));
        this.ug.setForeground(new Color(255, 255, 102));
        this.ug.setHorizontalAlignment(0);
        this.ug.setText(M.getString("fix_title"));
        this.uh.setFont(new Font("Tahoma", 0, 12));
        this.uh.setForeground(new Color(255, 255, 255));
        this.uh.setText(M.getString("fix_l1"));
        this.ur.setFont(new Font("Tahoma", 0, 12));
        this.ur.setForeground(new Color(255, 255, 255));
        this.ur.setText("<html>" + M.getString("fix_l2") + "</html>");
        this.us.setFont(new Font("Tahoma", 0, 12));
        this.us.setForeground(new Color(255, 255, 255));
        this.us.setText("Registrando seu Brasfoot voc\u00ea ganhar\u00e1 as op\u00e7\u00f5es extras:");
        this.vx.setFont(new Font("Tahoma", 0, 12));
        this.vx.setForeground(new Color(255, 255, 255));
        this.vx.setText(" - Acesso \u00e0 \u00e1rea de s\u00f3cios do site (com novas ligas, camisas, escudos, f\u00f3rum de debates e muito mais!) ");
        this.vy.setFont(new Font("Tahoma", 0, 12));
        this.vy.setForeground(new Color(255, 255, 255));
        this.vy.setText("- Poder\u00e1 jogar com mais de um t\u00e9cnico humano");
        this.vz.setFont(new Font("Tahoma", 0, 12));
        this.vz.setForeground(new Color(255, 255, 255));
        this.vz.setText("- Poder\u00e1 escolher um time de qualquer divis\u00e3o para iniciar o jogo");
        this.vA.setFont(new Font("Tahoma", 0, 12));
        this.vA.setForeground(new Color(255, 255, 255));
        this.vA.setText("- Jogar regionais e estaduais; inclusive escolher o sistema de disputa dos estaduais");
        this.Bj.setFont(new Font("Tahoma", 0, 12));
        this.Bj.setForeground(new Color(255, 255, 255));
        this.Bj.setText("- Jogar campeonatos de sele\u00e7\u00f5es: Copa do Mundo, Eurocopa, Copa Am\u00e9rica etc");
        this.vw.setFont(new Font("Tahoma", 0, 12));
        this.vw.setForeground(new Color(255, 255, 255));
        this.vw.setText("- Jogar a Copa Sul-Americana (ou Liga UEFA)");
        this.zb.setFont(new Font("Tahoma", 0, 12));
        this.zb.setForeground(new Color(255, 255, 255));
        this.zb.setText("- Escolher o sistema de disputa do campeonato nacional");
        this.zc.setFont(new Font("Tahoma", 0, 12));
        this.zc.setForeground(new Color(255, 255, 255));
        this.zc.setText("- Fazer proposta de compra para qualquer jogador, mesmo se ele n\u00e3o estiver a venda");
        this.zd.setFont(new Font("Tahoma", 0, 12));
        this.zd.setForeground(new Color(255, 255, 255));
        this.zd.setText("- Velocidades de jogo Hiper-r\u00e1pido para jogos humanos e Ultrasonico para jogos n\u00e3o humanos");
        this.ze.setFont(new Font("Tahoma", 0, 12));
        this.ze.setForeground(new Color(255, 255, 255));
        this.ze.setText("Para fazer o registro acesse o site do jogo:");
        this.Ef.setFont(new Font("Tahoma", 1, 12));
        this.Ef.setForeground(new Color(255, 255, 102));
        this.Ef.setText("www.brasfoot.com");
        this.Eg.setFont(new Font("Tahoma", 0, 12));
        this.Eg.setForeground(new Color(255, 255, 255));
        this.Eg.setText("<html>O registro pode ser feito por dep\u00f3sito banc\u00e1rio, boleto banc\u00e1rio ou cart\u00e3o de cr\u00e9dito em transfer\u00eancias seguras. Ap\u00f3s o registro voc\u00ea receber\u00e1 por email o nome e c\u00f3digo para ser digitado abaixo. </html>");
        this.we.setBackground(new Color(0, 0, 0));
        this.we.setBorder(BorderFactory.createLineBorder(new Color(42, 50, 15)));
        this.we.setOpaque(false);
        this.a_.setForeground(new Color(255, 255, 255));
        this.a_.setText(M.getString("fix_nom"));
        this.Ei.setForeground(new Color(255, 255, 255));
        this.Ei.setText(M.getString("fix_nom2"));
        this.vb.setFont(new Font("Tahoma", 0, 12));
        this.vb.setText(M.getString("fix_nom3"));
        GroupLayout groupLayout = new GroupLayout(this.we);
        this.we.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(111, 111, 111).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.Ei).addComponent(this.a_)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.Ej).addComponent(this.Ek, -1, 341, Short.MAX_VALUE)).addGap(28, 28, 28).addComponent(this.vb, -2, 133, -2).addContainerGap(139, Short.MAX_VALUE)));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(19, 19, 19).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.a_).addComponent(this.Ej, -2, -1, -2)).addGap(18, 18, 18).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.Ek, -2, -1, -2).addComponent(this.Ei))).addGroup(groupLayout.createSequentialGroup().addGap(29, 29, 29).addComponent(this.vb, -2, 35, -2))).addContainerGap(31, Short.MAX_VALUE)));
        this.Eh.setFont(new Font("Tahoma", 1, 12));
        this.Eh.setForeground(new Color(255, 255, 153));
        this.Eh.setText("Ap\u00f3s o registro ser\u00e1 enviado o seu c\u00f3digo pessoal, voc\u00ea deve digit\u00e1-lo abaixo:");
        this.ud.setText("X");
        GroupLayout groupLayout2 = new GroupLayout(this.vd);
        this.vd.setLayout(groupLayout2);
        groupLayout2.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addGap(28, 28, 28).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addComponent(this.Eh, -1, -1, Short.MAX_VALUE).addContainerGap(-1, Short.MAX_VALUE)).addGroup(groupLayout2.createSequentialGroup().addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.ur, -2, 693, -2).addComponent(this.us, -2, 619, -2).addComponent(this.vx, -2, 619, -2).addComponent(this.vy, -2, 619, -2).addComponent(this.vz, -2, 619, -2).addComponent(this.vA, -2, 619, -2).addComponent(this.Bj, -2, 619, -2).addComponent(this.vw, -2, 619, -2).addComponent(this.zb, -2, 619, -2).addComponent(this.zc, -2, 619, -2).addComponent(this.zd, -2, 619, -2).addComponent(this.uh, -2, 619, -2).addComponent(this.we, -2, -1, -2).addGroup(groupLayout2.createSequentialGroup().addComponent(this.ze, -2, 253, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.Ef, -2, 250, -2)).addComponent(this.Eg, -2, 709, -2)).addContainerGap(44, Short.MAX_VALUE)))).addGroup(GroupLayout.Alignment.TRAILING, groupLayout2.createSequentialGroup().addContainerGap(-1, Short.MAX_VALUE).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, groupLayout2.createSequentialGroup().addComponent(this.ug, -2, 616, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.ud, -2, 47, -2).addGap(68, 68, 68)).addGroup(GroupLayout.Alignment.TRAILING, groupLayout2.createSequentialGroup().addComponent(this.BE, -2, 209, -2).addGap(332, 332, 332)))));
        groupLayout2.setVerticalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addGap(20, 20, 20).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.ug, -2, 29, -2).addComponent(this.ud)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.BE, -2, 10, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.uh).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.ur, -2, 85, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.us).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.vx).addGap(4, 4, 4).addComponent(this.vy).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.vz).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.vA).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.Bj).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.vw).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.zb).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.zc).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.zd).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.ze).addComponent(this.Ef)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.Eg, -2, 59, -2).addGap(13, 13, 13).addComponent(this.Eh).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.we, -2, -1, -2).addContainerGap(18, Short.MAX_VALUE)));
        GroupLayout groupLayout3 = new GroupLayout(this);
        this.setLayout(groupLayout3);
        groupLayout3.setHorizontalGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout3.createSequentialGroup().addGap(28, 28, 28).addComponent(this.vd, -2, -1, -2).addContainerGap(20, Short.MAX_VALUE)));
        groupLayout3.setVerticalGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout3.createSequentialGroup().addGap(27, 27, 27).addComponent(this.vd, -2, -1, -2).addContainerGap(24, Short.MAX_VALUE)));
    }

    static /* synthetic */ void a(da da2) {
        da2.pr();
    }

    static /* synthetic */ void b(da da2) {
        da2.pb();
    }

    static /* synthetic */ boolean c(da da2) {
        return da2.ps();
    }
}

