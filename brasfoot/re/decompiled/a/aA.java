/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.ay;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class aA
implements ItemListener {
    final /* synthetic */ ay yi;

    aA(ay ay2) {
        this.yi = ay2;
    }

    @Override
    public void itemStateChanged(ItemEvent itemEvent) {
        if (itemEvent.getStateChange() == 1 && !this.yi.wZ) {
            ay.d(this.yi, ay.c(this.yi).getSelectedIndex());
        }
    }
}

