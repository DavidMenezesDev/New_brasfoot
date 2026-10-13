/*
 * Decompiled with CFR 0.152.
 */
package b;

import a.eg;
import best.C;
import best.F;
import best.aq;
import c.a;
import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class aH
extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl2, boolean bl3, int n2, int n3) {
        Object object2;
        super.getTableCellRendererComponent(jTable, object, bl2, bl3, n2, n3);
        this.setBorder(noFocusBorder);
        super.setForeground(Color.BLACK);
        if (!bl2) {
            super.setBackground(Color.WHITE);
        }
        this.setHorizontalAlignment(2);
        this.setIcon(null);
        this.setText("");
        F f2 = (F)object;
        if (a.SR.isUsaCoresLista()) {
            object2 = a.SR.getCoresLista();
            if (!bl2) {
                super.setBackground(object2[f2.getPosicao()]);
            }
        }
        if (n3 == 0) {
            this.setHorizontalAlignment(0);
            if (f2.fn() > 0) {
                this.setText(Integer.toString(f2.fn()));
                if (!bl2) {
                    if (f2.fg() != null) {
                        this.setForeground(f2.fg().kC());
                    }
                    if (f2.fg() != null) {
                        this.setBackground(f2.fg().kB());
                    }
                }
            }
        }
        if (n3 == 1) {
            this.setHorizontalAlignment(0);
            this.setText(aq.rI[f2.getPosicao()]);
        }
        if (n3 == 2) {
            this.setHorizontalAlignment(2);
            this.setIcon(f2.fS());
        }
        if (n3 == 3) {
            this.setHorizontalAlignment(2);
            this.setText(f2.getNome());
            if (f2.gl().booleanValue() && !eg.rC()) {
                this.setText("<html><b>" + f2.getNome() + "</b></html>");
            }
            if (f2.fz().booleanValue() && !eg.rC()) {
                this.setText("<html><b>" + f2.getNome() + "</b></html>");
                super.setForeground(new Color(13, 37, 124));
            }
            if (f2.gG() < 0 && !eg.rC()) {
                super.setForeground(new Color(127, 4, 30));
                this.setText("<html><b>&nbsp;" + f2.getNome() + "</b></html>");
            }
            if (eg.rD() != null && f2.c(eg.rD())) {
                super.setForeground(new Color(173, 79, 3));
            }
            if (f2.gm().booleanValue()) {
                this.setIcon(new ImageIcon(this.getClass().getResource("/aicons/estrelared.png")));
            } else if (f2.ff().booleanValue()) {
                this.setIcon(new ImageIcon(this.getClass().getResource("/aicons/estrela.png")));
            }
        }
        if (n3 == 4) {
            this.setHorizontalAlignment(0);
            this.setText(aq.rK[f2.getLado()]);
        }
        if (!a.SR.isHabilidadeIndividual()) {
            if (n3 == 5) {
                this.setText(Integer.toString(f2.fi()));
            } else {
                if (n3 == 6) {
                    return f2.a(eg.rA());
                }
                if (n3 == 7) {
                    if (!eg.rC() && f2.gG() < 30) {
                        super.setForeground(new Color(127, 4, 30));
                        this.setText("<html><b>&nbsp;" + C.a(f2.fj(), 0) + "</b></html>");
                    } else {
                        this.setText("  " + C.a(f2.fj(), 0));
                    }
                } else if (n3 == 8) {
                    this.setText(C.a(f2.fk(), 0));
                    if (f2.ft().booleanValue()) {
                        super.setForeground(new Color(29, 163, 51));
                    }
                } else if (n3 == 9) {
                    this.setText(Integer.toString(f2.gA()));
                } else if (n3 == 10) {
                    object2 = "";
                    String string = "";
                    if (f2.getCr1() < aq.qN.length) {
                        object2 = aq.qN[f2.getCr1()];
                    }
                    if (f2.getCr2() < aq.qN.length) {
                        string = aq.qN[f2.getCr2()];
                    }
                    this.setText(String.valueOf(object2) + "/" + string);
                } else if (n3 == 11) {
                    this.setText(Integer.toString(f2.getIdade()));
                    if (f2.getIdade() > 32) {
                        super.setForeground(new Color(127, 4, 30));
                    } else {
                        super.setForeground(new Color(13, 37, 124));
                    }
                } else if (n3 == 12) {
                    this.setText(Integer.toString(f2.gy()));
                } else if (n3 == 13) {
                    this.setText(Integer.toString(f2.gs()));
                } else if (n3 == 14) {
                    object2 = f2.gn();
                    Double d2 = f2.F();
                    if (d2 < 5.0 && d2 >= 2.0) {
                        super.setForeground(new Color(120, 7, 31));
                    } else if (d2 > 7.0) {
                        super.setForeground(new Color(56, 121, 12));
                    }
                    this.setText((String)object2);
                }
            }
        } else if (n3 == 5) {
            this.setText(Integer.toString(f2.gK()));
        } else if (n3 == 6) {
            this.setText(Integer.toString(f2.gN()));
        } else if (n3 == 7) {
            this.setText(Integer.toString(f2.gO()));
        } else if (n3 == 8) {
            this.setText(Integer.toString(f2.gP()));
        } else if (n3 == 9) {
            this.setText(Integer.toString(f2.gJ()));
        } else if (n3 == 10) {
            this.setText(Integer.toString(f2.gL()));
        } else if (n3 == 11) {
            this.setText(Integer.toString(f2.gM()));
        } else {
            if (n3 == 12) {
                return f2.a(eg.rA());
            }
            if (n3 == 13) {
                if (!eg.rC() && f2.gG() < 30) {
                    super.setForeground(new Color(127, 4, 30));
                    this.setText("<html><b>&nbsp;" + C.a(f2.fj(), 0) + "</b></html>");
                } else {
                    this.setText("  " + C.a(f2.fj(), 0));
                }
            } else if (n3 == 14) {
                this.setText(C.a(f2.fk(), 0));
                if (f2.ft().booleanValue()) {
                    super.setForeground(new Color(29, 163, 51));
                }
            } else if (n3 == 15) {
                this.setText(Integer.toString(f2.gA()));
            } else if (n3 == 16) {
                this.setText(String.valueOf(aq.qN[f2.getCr1()]) + "/" + aq.qN[f2.getCr2()]);
            } else if (n3 == 17) {
                this.setText(Integer.toString(f2.getIdade()));
                if (f2.getIdade() > 32) {
                    super.setForeground(new Color(127, 4, 30));
                } else {
                    super.setForeground(new Color(13, 37, 124));
                }
            } else if (n3 == 18) {
                this.setText(Integer.toString(f2.gy()));
            } else if (n3 == 19) {
                this.setText(Integer.toString(f2.fi()));
                this.setText(Integer.toString(f2.gs()));
            } else if (n3 == 20) {
                object2 = f2.gn();
                Double d3 = f2.F();
                if (d3 < 5.0 && d3 >= 2.0) {
                    super.setForeground(new Color(120, 7, 31));
                } else if (d3 > 7.0) {
                    super.setForeground(new Color(56, 121, 12));
                }
                this.setText((String)object2);
            }
        }
        return this;
    }
}

