/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.bg;
import java.util.TimerTask;

class bj
extends TimerTask {
    final /* synthetic */ bg zT;

    bj(bg bg2) {
        this.zT = bg2;
    }

    @Override
    public void run() {
        bg.b(this.zT).cancel();
        this.zT.nL();
    }
}

