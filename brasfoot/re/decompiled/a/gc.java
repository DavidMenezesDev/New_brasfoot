/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.gb;
import java.util.TimerTask;

class gc
extends TimerTask {
    final /* synthetic */ gb JV;

    gc(gb gb2) {
        this.JV = gb2;
    }

    @Override
    public void run() {
        gb.a(this.JV).cancel();
        this.JV.py();
    }
}

