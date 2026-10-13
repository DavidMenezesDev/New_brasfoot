/*
 * Decompiled with CFR 0.152.
 */
package org.eclipse.jdt.internal.jarinjarloader;

import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import org.eclipse.jdt.internal.jarinjarloader.d;

public class e
implements URLStreamHandlerFactory {
    private ClassLoader classLoader;
    private URLStreamHandlerFactory aaC;

    public e(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public URLStreamHandler createURLStreamHandler(String string) {
        if ("rsrc".equals(string)) {
            return new d(this.classLoader);
        }
        if (this.aaC != null) {
            return this.aaC.createURLStreamHandler(string);
        }
        return null;
    }

    public void setURLStreamHandlerFactory(URLStreamHandlerFactory uRLStreamHandlerFactory) {
        this.aaC = uRLStreamHandlerFactory;
    }
}

