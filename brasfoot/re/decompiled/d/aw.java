/*
 * Decompiled with CFR 0.152.
 */
package d;

import java.io.File;
import java.io.FilenameFilter;

class aw
implements FilenameFilter {
    aw() {
    }

    @Override
    public boolean accept(File file, String string) {
        return string.toLowerCase().endsWith(".ban");
    }
}

