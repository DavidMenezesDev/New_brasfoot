/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.cR;
import c.a;
import java.util.TimerTask;

class cS
extends TimerTask {
    final /* synthetic */ cR DV;

    cS(cR cR2) {
        this.DV = cR2;
    }

    @Override
    public void run() {
        cR.ph().cancel();
        a.SR.V();
    }
}

