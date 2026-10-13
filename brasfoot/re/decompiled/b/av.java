/*
 * Decompiled with CFR 0.152.
 */
package b;

import c.a;
import components.aC;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class av
extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl2, boolean bl3, int n2, int n3) {
        super.getTableCellRendererComponent(jTable, object, bl2, bl3, n2, n3);
        this.setBorder(noFocusBorder);
        super.setForeground(Color.BLACK);
        this.setHorizontalAlignment(2);
        this.setIcon(null);
        this.setText("");
        aC aC2 = (aC)object;
        if (aC2 != null) {
            if (n3 == 0) {
                this.setIcon(aC2.vC());
                this.setText(aC2.vB());
            } else if (n3 == 1) {
                this.setIcon(aC2.cu().kU());
                this.setText(aC2.cu().getNome());
            } else if (n3 == 2) {
                this.setText(Integer.toString(aC2.H() + a.SR.iU()));
            }
        }
        return this;
    }
}

