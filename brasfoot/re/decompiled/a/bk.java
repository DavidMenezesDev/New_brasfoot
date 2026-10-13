/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.bg;
import java.util.TimerTask;

class bk
extends TimerTask {
    final /* synthetic */ bg zT;

    bk(bg bg2) {
        this.zT = bg2;
    }

    @Override
    public void run() {
        bg.b(this.zT).cancel();
        bg.c(this.zT);
    }
}

