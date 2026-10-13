/*
 * Decompiled with CFR 0.152.
 */
package b;

import best.at;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class ai
extends JLabel
implements ListCellRenderer {
    public Component getListCellRendererComponent(JList jList, Object object, int n2, boolean bl2, boolean bl3) {
        if (object != null && object instanceof at) {
            at at2 = (at)object;
            String string = at2.getNome();
            this.setText(string);
            if (bl2) {
                this.setBackground(jList.getSelectionBackground());
                this.setForeground(jList.getSelectionForeground());
            } else {
                this.setBackground(jList.getBackground());
                this.setForeground(jList.getForeground());
            }
        } else {
            this.setText((String)object);
        }
        return this;
    }
}

