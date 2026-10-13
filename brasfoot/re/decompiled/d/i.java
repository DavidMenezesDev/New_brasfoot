/*
 * Decompiled with CFR 0.152.
 */
package d;

import best.n;
import d.f;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class i
implements ItemListener {
    final /* synthetic */ f Ut;

    i(f f2) {
        this.Ut = f2;
    }

    @Override
    public void itemStateChanged(ItemEvent itemEvent) {
        n.da().aM(f.c(this.Ut).isSelected());
    }
}

