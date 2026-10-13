/*
 * Decompiled with CFR 0.152.
 */
package org.eclipse.jdt.internal.jarinjarloader;

import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import org.eclipse.jdt.internal.jarinjarloader.c;

public class d
extends URLStreamHandler {
    private ClassLoader classLoader;

    public d(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    protected URLConnection openConnection(URL uRL) {
        return new c(uRL, this.classLoader);
    }

    @Override
    protected void parseURL(URL uRL, String string, int n2, int n3) {
        String string2 = string.startsWith("rsrc:") ? string.substring(5) : (uRL.getFile().equals("./") ? string : (uRL.getFile().endsWith("/") ? String.valueOf(uRL.getFile()) + string : ("#runtime".equals(string) ? uRL.getFile() : string)));
        this.setURL(uRL, "rsrc", "", -1, null, null, string2, null, null);
    }
}

