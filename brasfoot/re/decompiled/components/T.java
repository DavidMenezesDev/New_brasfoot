/*
 * Decompiled with CFR 0.152.
 */
package components;

import components.O;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

class T
implements ChangeListener {
    final /* synthetic */ O QR;

    T(O o2) {
        this.QR = o2;
    }

    @Override
    public void stateChanged(ChangeEvent changeEvent) {
        this.QR.um();
    }
}

