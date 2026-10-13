/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.gb;
import java.util.TimerTask;

class gf
extends TimerTask {
    final /* synthetic */ gb JV;

    gf(gb gb2) {
        this.JV = gb2;
    }

    @Override
    public void run() {
        gb.a(this.JV).cancel();
        gb.c(this.JV);
    }
}

