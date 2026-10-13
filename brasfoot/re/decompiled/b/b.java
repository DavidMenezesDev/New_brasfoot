/*
 * Decompiled with CFR 0.152.
 */
package b;

import components.d;
import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;

public class b
extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl2, boolean bl3, int n2, int n3) {
        super.getTableCellRendererComponent(jTable, object, bl2, bl3, n2, n3);
        this.setBorder(noFocusBorder);
        super.setForeground(Color.BLACK);
        this.setHorizontalAlignment(0);
        this.setIcon(null);
        this.setText("");
        d d2 = (d)object;
        if (object != null) {
            if (d2.sZ()) {
                ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/aicons/escudo2.png"));
                if (!d2.sS()) {
                    if (d2.sR()) {
                        if (n3 == 0) {
                            this.setHorizontalAlignment(4);
                            this.setIcon(imageIcon);
                        } else if (n3 == 1) {
                            this.setText("x");
                        } else if (n3 == 2) {
                            this.setHorizontalAlignment(2);
                            this.setIcon(imageIcon);
                        } else if (n3 == 3) {
                            this.setText(d2.sU());
                        } else if (n3 == 4 && d2.sX() != null) {
                            this.setHorizontalAlignment(4);
                            this.setIcon(imageIcon);
                        } else if (n3 == 5 && d2.sX() != null) {
                            this.setText("x");
                        } else if (n3 == 6 && d2.sY() != null) {
                            this.setHorizontalAlignment(2);
                            this.setIcon(imageIcon);
                        }
                    } else {
                        MatteBorder matteBorder = BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(204, 204, 204));
                        this.setBorder(matteBorder);
                        if (n3 == 0) {
                            this.setHorizontalAlignment(4);
                            this.setText(d2.sV());
                        } else if (n3 == 2) {
                            this.setHorizontalAlignment(2);
                            this.setText(d2.sW());
                        } else if (n3 == 4 && d2.sX() != null) {
                            this.setHorizontalAlignment(4);
                            this.setText(d2.sX());
                        } else if (n3 == 6 && d2.sY() != null) {
                            this.setHorizontalAlignment(2);
                            this.setText(d2.sY());
                        }
                    }
                } else if (n3 == 0) {
                    this.setText(d2.sT());
                }
            } else if (!d2.sS()) {
                if (d2.sR()) {
                    String string;
                    String string2;
                    if (n3 == 0) {
                        this.setHorizontalAlignment(4);
                        this.setIcon(d2.sP().hc().a(25, 25, true));
                    } else if (n3 == 2) {
                        this.setHorizontalAlignment(2);
                        this.setIcon(d2.sP().hd().a(25, 25, true));
                    } else if (n3 == 3) {
                        this.setText(d2.sU());
                    }
                    if (d2.sP().e()) {
                        if (n3 == 1) {
                            string2 = "";
                            string2 = Integer.toString(d2.sP().hu());
                            string = "";
                            string = Integer.toString(d2.sP().hw());
                            this.setText(String.valueOf(string2) + "x" + string);
                        }
                    } else if (n3 == 1) {
                        this.setText("x");
                    }
                    if (d2.sQ() != null) {
                        if (n3 == 4) {
                            this.setHorizontalAlignment(4);
                            this.setIcon(d2.sQ().hc().a(25, 25, true));
                        } else if (n3 == 6) {
                            this.setHorizontalAlignment(2);
                            this.setIcon(d2.sQ().hd().a(25, 25, true));
                        }
                        if (d2.sQ().e()) {
                            if (n3 == 5) {
                                string2 = "";
                                string2 = Integer.toString(d2.sQ().hu());
                                string = "";
                                string = Integer.toString(d2.sQ().hw());
                                this.setText(String.valueOf(string2) + "x" + string);
                            }
                        } else if (n3 == 5) {
                            this.setText("x");
                        }
                    }
                } else {
                    String string;
                    String string3;
                    int[] nArray;
                    MatteBorder matteBorder = BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(204, 204, 204));
                    this.setBorder(matteBorder);
                    if (n3 == 0) {
                        this.setHorizontalAlignment(4);
                        this.setText(d2.sP().hc().getNome());
                    } else if (n3 == 1 && d2.sP().e()) {
                        nArray = d2.sP().hQ();
                        if (nArray[0] >= 0 && nArray[1] >= 0) {
                            string3 = "P:" + Integer.toString(nArray[0]);
                            string = Integer.toString(nArray[1]);
                            this.setText(String.valueOf(string3) + " x " + string);
                        }
                    } else if (n3 == 2) {
                        this.setHorizontalAlignment(2);
                        this.setText(d2.sP().hd().getNome());
                    }
                    if (d2.sQ() != null) {
                        if (n3 == 4) {
                            this.setHorizontalAlignment(4);
                            this.setText(d2.sQ().hc().getNome());
                        } else if (n3 == 5 && d2.sQ().e()) {
                            nArray = d2.sQ().hQ();
                            if (nArray[0] >= 0 && nArray[1] >= 0) {
                                string3 = "P:" + Integer.toString(nArray[0]);
                                string = Integer.toString(nArray[1]);
                                this.setText(String.valueOf(string3) + " x " + string);
                            }
                        } else if (n3 == 6) {
                            this.setHorizontalAlignment(2);
                            this.setText(d2.sQ().hd().getNome());
                        }
                    }
                }
            } else if (n3 == 0) {
                this.setText(d2.sT());
            }
        }
        return this;
    }
}

