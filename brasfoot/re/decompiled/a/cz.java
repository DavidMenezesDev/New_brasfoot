/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.cA;
import a.cB;
import a.cC;
import best.C;
import best.F;
import best.ah;
import best.aq;
import best.l;
import c.a;
import java.awt.Color;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

public class cz
extends JPanel {
    private JDialog ub;
    private F CY;
    private ah ul = null;
    private boolean CZ = false;
    private JButton uC;
    private JButton uD;
    private JTextField uE;
    private JLabel ug;
    private JPanel vd;
    private JLabel uF;
    private JLabel uG;
    private JLabel uH;
    private JLabel uI;

    public cz(JDialog jDialog, F f2, ah ah2, boolean bl2) {
        this.ub = jDialog;
        this.CY = f2;
        this.ul = ah2;
        this.CZ = bl2;
        this.mJ();
        this.mK();
        this.mH();
        this.mG();
    }

    private void mG() {
        this.setBackground(aq.E(a.vM().getCorTema(), 1));
    }

    private void mK() {
        this.uF.setText(this.CY.getNome());
        this.uG.setText("Valor do passe: " + C.c(this.CY.fk()));
    }

    public static boolean B(String string) {
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

    private void oK() {
        String string = String.valueOf(this.uE.getText().toString()) + "000";
        if (!string.equals("") && string.matches("\\d+") && cz.B(string) && Integer.parseInt(string) >= 0) {
            this.uH.setText(C.c(Integer.parseInt(string)));
        } else {
            this.uH.setText("valor inv\u00e1lido");
        }
    }

    public void mH() {
        this.uC.addActionListener(new cA(this));
        this.uD.addActionListener(new cB(this));
        this.uE.getDocument().addDocumentListener(new cC(this));
    }

    private void oL() {
        String string = String.valueOf(this.uE.getText().toString()) + "000";
        int n2 = -1;
        if (!string.equals("") && string.matches("\\d+") && cz.B(string) && Integer.parseInt(string) > 0) {
            int n3 = Integer.parseInt(string);
            if (this.ul.kb() >= (long)n3) {
                if (this.CY.fg().jZ().booleanValue()) {
                    int n4 = Integer.parseInt(string);
                    String string2 = this.ul.getNome();
                    String string3 = this.CY.fg().ka().dS();
                    n2 = JOptionPane.showConfirmDialog(this.ub, String.valueOf(string3) + " proposta pelo seu jogador\n" + "Deseja aceitar?", "Proposta de compra", 0);
                    if (n2 == 0) {
                        if (!this.CZ) {
                            this.CY.a(this.ul, n4, false, false, false);
                        } else {
                            this.CY.c(this.ul, n4);
                        }
                        l.l(true);
                        this.ub.dispose();
                    }
                } else if (this.CY.ft().booleanValue() && n3 >= this.CY.fl() && !this.CZ) {
                    this.oM();
                } else {
                    Object object;
                    int n5 = 0;
                    int n6 = Integer.parseInt(string);
                    n5 = l.a(this.CY, this.ul, n6);
                    String[] stringArray = new String[]{"Oferta recusada", "Compra realizada", "Jogador do seu time", "Limite de 30 jogadores alcan\u00e7ado", "N\u00e3o deseja se transferir para o seu time", "Sem dinheiro para comprar este jogador"};
                    if (n5 <= 5) {
                        JOptionPane.showMessageDialog(this.ub, stringArray[n5], "Compra", 2);
                    } else if (n5 == 6) {
                        object = C.c(l.cM());
                        n2 = JOptionPane.showConfirmDialog(this.ub, "Para jogar no seu time\no jogador quer um sal\u00e1rio de:\n" + (String)object + "\n" + "Deseja aceitar?", "Deseja aumento de sal\u00e1rio", 0);
                        if (n2 == 0) {
                            this.CY.ae(l.cM());
                            n5 = 1;
                        }
                    } else if (n5 == 7) {
                        n6 = l.cN();
                        object = this.CY.fg().getNome();
                        String string4 = "";
                        String string5 = "";
                        int n7 = 0;
                        if (l.cM() > 0) {
                            n7 = l.cM();
                            string4 = C.c(l.cM());
                            string5 = "E o jogador quer um sal\u00e1rio de " + string4 + "\n";
                        }
                        if ((n2 = JOptionPane.showConfirmDialog(this.ub, String.valueOf(object) + " enviou uma contra-proposta\n" + "O clube aceita um valor de " + C.c(n6) + "\n" + string5 + "Deseja aceitar?", "Contra-proposta", 0)) == 0) {
                            if (n7 > 0) {
                                this.CY.ae(n7);
                            }
                            n5 = 1;
                        }
                    }
                    if (n5 == 1) {
                        if (!this.CZ) {
                            object = this.CY.fg();
                            this.CY.a(this.ul, n6, false, false, false);
                            l.a((ah)object, this.CY);
                        } else {
                            this.CY.c(this.ul, n6);
                        }
                        l.l(true);
                        this.ub.dispose();
                    }
                }
            } else {
                this.uH.setText("Valor maior que dinheiro em caixa");
            }
        } else {
            this.uH.setText("valor inv\u00e1lido");
        }
    }

    private void oM() {
        int n2 = 0;
        n2 = l.b(this.CY, this.ul);
        String[] stringArray = new String[]{"N\u00e3o est\u00e1 \u00e0 venda", "Compra realizada", "Jogador do seu time", "Limite de 32 jogadores alcan\u00e7ado", "N\u00e3o deseja se transferir para o seu time", "Sem dinheiro para comprar este jogador"};
        JOptionPane.showMessageDialog(this.ub, stringArray[n2], "Compra", 2);
        if (n2 == 1) {
            this.ub.dispose();
        }
    }

    private void mJ() {
        this.vd = new JPanel();
        this.ug = new JLabel();
        this.uF = new JLabel();
        this.uH = new JLabel();
        this.uE = new JTextField();
        this.uI = new JLabel();
        this.uG = new JLabel();
        this.uC = new JButton();
        this.uD = new JButton();
        this.setBackground(new Color(44, 53, 49));
        this.vd.setBackground(new Color(104, 120, 100));
        this.ug.setFont(new Font("Tahoma", 1, 12));
        this.ug.setForeground(new Color(255, 255, 102));
        this.ug.setHorizontalAlignment(0);
        this.ug.setText("Proposta pelo jogador");
        this.uF.setFont(new Font("Tahoma", 0, 12));
        this.uF.setForeground(new Color(255, 255, 255));
        this.uF.setHorizontalAlignment(0);
        this.uF.setText("Nome do Jogador");
        this.uH.setForeground(new Color(255, 255, 255));
        this.uH.setHorizontalAlignment(2);
        this.uH.setText("Pre\u00e7o inicial:");
        this.uI.setForeground(new Color(255, 255, 255));
        this.uI.setHorizontalAlignment(2);
        this.uI.setText("Sua proposta (em milhares de $):");
        this.uG.setForeground(new Color(255, 255, 255));
        this.uG.setText("Valor do passe:");
        this.uC.setText("Cancelar");
        this.uD.setText("Enviar");
        GroupLayout groupLayout = new GroupLayout(this.vd);
        this.vd.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup().addGap(14, 14, 14).addComponent(this.uF, -1, -1, Short.MAX_VALUE)).addGroup(groupLayout.createSequentialGroup().addGap(67, 67, 67).addComponent(this.uC, -2, 91, -2).addGap(26, 26, 26).addComponent(this.uD, -2, 86, -2).addGap(0, 0, Short.MAX_VALUE)).addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addComponent(this.ug, -2, 317, -2).addGap(0, 0, Short.MAX_VALUE)).addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.uE, -2, 200, -2).addComponent(this.uI, -2, 264, -2).addComponent(this.uH, -2, 237, -2).addComponent(this.uG, -2, 256, -2)))))).addContainerGap()));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(this.ug).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.uF).addGap(18, 18, 18).addComponent(this.uG).addGap(18, 18, 18).addComponent(this.uI).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.uE, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.uH).addGap(34, 34, 34).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.uC).addComponent(this.uD)).addContainerGap(46, Short.MAX_VALUE)));
        GroupLayout groupLayout2 = new GroupLayout(this);
        this.setLayout(groupLayout2);
        groupLayout2.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addGap(18, 18, 18).addComponent(this.vd, -2, -1, -2).addContainerGap(18, Short.MAX_VALUE)));
        groupLayout2.setVerticalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout2.createSequentialGroup().addGap(19, 19, 19).addComponent(this.vd, -2, -1, -2).addContainerGap(21, Short.MAX_VALUE)));
    }

    static /* synthetic */ JDialog a(cz cz2) {
        return cz2.ub;
    }

    static /* synthetic */ void b(cz cz2) {
        cz2.oL();
    }

    static /* synthetic */ void c(cz cz2) {
        cz2.oK();
    }
}

