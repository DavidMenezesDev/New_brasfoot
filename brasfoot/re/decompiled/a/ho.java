/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.hk;
import c.a;
import java.util.TimerTask;

class ho
extends TimerTask {
    final /* synthetic */ hk Lt;

    ho(hk hk2) {
        this.Lt = hk2;
    }

    @Override
    public void run() {
        hk.ph().cancel();
        a.SR.ax();
    }
}

