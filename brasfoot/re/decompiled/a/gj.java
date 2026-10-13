/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.gh;
import java.util.TimerTask;

class gj
extends TimerTask {
    final /* synthetic */ gh JW;

    gj(gh gh2) {
        this.JW = gh2;
    }

    @Override
    public void run() {
        gh.rL().cancel();
        gh.b(this.JW);
    }
}

