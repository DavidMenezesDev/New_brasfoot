/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.dN;
import java.io.File;
import java.io.FilenameFilter;

class dS
implements FilenameFilter {
    final /* synthetic */ dN GR;

    dS(dN dN2) {
        this.GR = dN2;
    }

    @Override
    public boolean accept(File file, String string) {
        return string.toLowerCase().endsWith(".s22");
    }
}

