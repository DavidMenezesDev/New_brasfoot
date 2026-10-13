/*
 * Decompiled with CFR 0.152.
 */
package d;

import java.io.File;
import java.io.FilenameFilter;

class d
implements FilenameFilter {
    d() {
    }

    @Override
    public boolean accept(File file, String string) {
        return string.toLowerCase().endsWith(".xml");
    }
}

