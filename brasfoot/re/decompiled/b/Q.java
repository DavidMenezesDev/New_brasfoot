/*
 * Decompiled with CFR 0.152.
 */
package b;

import a.eg;
import b.R;
import best.C;
import best.F;
import best.ah;
import best.aq;
import c.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

public class Q
extends AbstractTableModel {
    private String[] Nt;
    private ArrayList vp;
    private static int SE = 1;
    private eg SN = null;
    public static Comparator KZ = new R();

    public Q(ah ah2, eg eg2) {
        this.SN = eg2;
        this.vp = ah2.kc();
        int n2 = 0;
        while (n2 < this.vp.size()) {
            ((F)this.vp.get(n2)).a((ImageIcon)null);
            ++n2;
        }
        Collections.sort(this.vp, h.a.abe);
        this.Nt = new String[]{"", "P", "", "Nome", "L", "F", "Energia", "Sal\u00e1rio", "Passe", "G", "Car.", "Idade", "GC", "A", "NM"};
        if (a.SR.isHabilidadeIndividual()) {
            this.Nt = new String[]{"", "P", "", "Nome", "L", "Gol", "Des", "Arm", "Fin", "Vel", "Tec", "Pas", "Energia", "Sal\u00e1rio", "Valor", "G", "Car.", "Idade", "GC", "A", "NM"};
        }
        if (this.vp.size() > 0) {
            this.et(0);
        }
    }

    @Override
    public int getColumnCount() {
        return this.Nt.length;
    }

    @Override
    public int getRowCount() {
        return this.vp.size();
    }

    @Override
    public Object getValueAt(int n2, int n3) {
        if (this.vp.size() > 0) {
            return this.vp.get(n2);
        }
        return null;
    }

    public void et(int n2) {
        this.SN.s((F)this.vp.get(n2));
    }

    public Object Y(int n2, int n3) {
        if (n3 != 0) {
            if (n3 == 1) {
                return aq.rI[((F)this.vp.get(n2)).getPosicao()];
            }
            if (n3 != 2) {
                if (n3 == 3) {
                    return ((F)this.vp.get(n2)).getNome();
                }
                if (n3 == 4) {
                    return aq.rK[((F)this.vp.get(n2)).getLado()];
                }
                if (n3 == 5) {
                    return ((F)this.vp.get(n2)).fi();
                }
                if (n3 == 6) {
                    return ((F)this.vp.get(n2)).fp();
                }
                if (n3 == 7) {
                    return C.a(((F)this.vp.get(n2)).fj(), 0);
                }
                if (n3 == 8) {
                    return C.a(((F)this.vp.get(n2)).fk(), 0);
                }
                if (n3 != 9) {
                    if (n3 == 10) {
                        return String.valueOf(aq.qN[((F)this.vp.get(n2)).getCr1()]) + "/" + aq.qN[((F)this.vp.get(n2)).getCr2()];
                    }
                    if (n3 == 11) {
                        return ((F)this.vp.get(n2)).getIdade();
                    }
                    if (n3 == 12) {
                        return 0;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public String getColumnName(int n2) {
        return this.Nt[n2];
    }

    public Class getColumnClass(int n2) {
        if (this.getValueAt(0, n2) != null) {
            return this.getValueAt(0, n2).getClass();
        }
        return String.class;
    }

    public ArrayList uH() {
        return this.vp;
    }

    static /* synthetic */ int vG() {
        return SE;
    }
}

