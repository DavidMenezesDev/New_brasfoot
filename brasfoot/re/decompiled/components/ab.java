/*
 * Decompiled with CFR 0.152.
 */
package components;

import components.RangeSliderUI;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ab
implements ChangeListener {
    final /* synthetic */ RangeSliderUI Rd;

    public ab(RangeSliderUI rangeSliderUI) {
        this.Rd = rangeSliderUI;
    }

    @Override
    public void stateChanged(ChangeEvent changeEvent) {
        if (!RangeSliderUI.a(this.Rd) && !RangeSliderUI.b(this.Rd)) {
            this.Rd.calculateThumbLocation();
            RangeSliderUI.c(this.Rd).repaint();
        }
    }
}

