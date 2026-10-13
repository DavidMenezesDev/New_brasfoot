/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.ay;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class aC
extends MouseAdapter {
    final /* synthetic */ ay yi;

    aC(ay ay2) {
        this.yi = ay2;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        ay.a(this.yi, 2);
    }
}

