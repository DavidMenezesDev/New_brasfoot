/*
 * Decompiled with CFR 0.152.
 */
package best;

import java.io.File;
import java.io.FilenameFilter;

class r
implements FilenameFilter {
    r() {
    }

    @Override
    public boolean accept(File file, String string) {
        return string.toLowerCase().endsWith(".cfg");
    }
}

