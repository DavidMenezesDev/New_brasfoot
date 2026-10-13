/*
 * Decompiled with CFR 0.152.
 */
package b;

import components.y;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class al
extends JLabel
implements ListCellRenderer {
    public Component getListCellRendererComponent(JList jList, Object object, int n2, boolean bl2, boolean bl3) {
        this.setIcon(null);
        if (bl2) {
            this.setBackground(Color.YELLOW);
            this.setForeground(jList.getSelectionForeground());
        } else {
            this.setBackground(jList.getBackground());
            this.setForeground(jList.getForeground());
        }
        if (object != null) {
            y y2 = (y)object;
            String string = y2.tZ();
            this.setText(string);
        }
        return this;
    }
}

