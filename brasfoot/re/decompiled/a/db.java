/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.da;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class db
extends MouseAdapter {
    final /* synthetic */ da El;

    db(da da2) {
        this.El = da2;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        da.a(this.El);
    }
}

