/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.gb;
import java.util.TimerTask;

class ge
extends TimerTask {
    final /* synthetic */ gb JV;

    ge(gb gb2) {
        this.JV = gb2;
    }

    @Override
    public void run() {
        gb.a(this.JV).cancel();
        gb.b(this.JV);
    }
}

