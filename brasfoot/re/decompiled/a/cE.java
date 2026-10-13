/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.cD;
import java.util.TimerTask;

class cE
extends TimerTask {
    final /* synthetic */ cD DI;

    cE(cD cD2) {
        this.DI = cD2;
    }

    @Override
    public void run() {
        cD.ph().cancel();
        cD.a(this.DI);
    }
}

