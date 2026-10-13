/*
 * Decompiled with CFR 0.152.
 */
package d;

import java.io.File;
import java.io.FilenameFilter;

class c
implements FilenameFilter {
    c() {
    }

    @Override
    public boolean accept(File file, String string) {
        return string.toLowerCase().endsWith(".b16");
    }
}

