/*
 * Decompiled with CFR 0.152.
 */
package d;

import d.n;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

class aD
extends JTable {
    final /* synthetic */ n Vh;

    aD(n n2, TableModel tableModel) {
        this.Vh = n2;
        super(tableModel);
    }

    @Override
    public Component prepareRenderer(TableCellRenderer tableCellRenderer, int n2, int n3) {
        Component component = super.prepareRenderer(tableCellRenderer, n2, n3);
        if (!this.isCellSelected(n2, n3)) {
            if (n2 % 2 == 0 && !this.isCellSelected(n2, n3)) {
                Color color = Color.decode("#f6f7e5");
                component.setBackground(color);
            } else {
                component.setBackground(this.getBackground());
            }
        }
        return component;
    }
}

