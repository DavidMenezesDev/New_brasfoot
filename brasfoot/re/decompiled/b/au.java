/*
 * Decompiled with CFR 0.152.
 */
package b;

import components.aj;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class au
extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl2, boolean bl3, int n2, int n3) {
        super.getTableCellRendererComponent(jTable, object, bl2, bl3, n2, n3);
        this.setBorder(noFocusBorder);
        super.setForeground(Color.BLACK);
        this.setHorizontalAlignment(0);
        this.setIcon(null);
        this.setText("");
        aj aj2 = (aj)object;
        if (aj2 != null && aj2.dX(n3) != null) {
            this.setText("<html>\n<body><p style=\\\"vertical-align: bottom; padding:5; font-size:10\\\"><center><img src=\"file:" + aj2.dY(n3) + "\" >" + "<center>" + aj2.dX(n3) + " [" + Integer.toString(aj2.dZ(n3)) + "]" + "</center>" + "<br><center>" + "\n</p>\n</body></html>\n");
        }
        return this;
    }
}

