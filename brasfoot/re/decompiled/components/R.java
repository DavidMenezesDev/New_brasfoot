/*
 * Decompiled with CFR 0.152.
 */
package components;

import components.O;
import components.aa;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

class R
implements ChangeListener {
    final /* synthetic */ O QR;

    R(O o2) {
        this.QR = o2;
    }

    @Override
    public void stateChanged(ChangeEvent changeEvent) {
        aa aa2 = (aa)changeEvent.getSource();
        this.QR.um();
    }
}

