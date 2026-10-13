/*
 * Decompiled with CFR 0.152.
 */
package d;

import d.f;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

class k
implements ChangeListener {
    final /* synthetic */ f Ut;

    k(f f2) {
        this.Ut = f2;
    }

    @Override
    public void stateChanged(ChangeEvent changeEvent) {
        f.g(this.Ut).setText(Integer.toString(f.h(this.Ut).getValue()));
    }
}

