/*
 * Decompiled with CFR 0.152.
 */
package best;

import java.io.File;
import java.io.FilenameFilter;

class Q
implements FilenameFilter {
    Q() {
    }

    @Override
    public boolean accept(File file, String string) {
        return string.toLowerCase().endsWith(".xml");
    }
}

