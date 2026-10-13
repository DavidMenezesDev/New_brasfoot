/*
 * Decompiled with CFR 0.152.
 */
package org.eclipse.jdt.internal.jarinjarloader;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;

public class c
extends URLConnection {
    private ClassLoader classLoader;

    public c(URL uRL, ClassLoader classLoader) {
        super(uRL);
        this.classLoader = classLoader;
    }

    @Override
    public void connect() {
    }

    @Override
    public InputStream getInputStream() {
        String string = URLDecoder.decode(this.url.getFile(), "UTF-8");
        InputStream inputStream = this.classLoader.getResourceAsStream(string);
        if (inputStream == null) {
            throw new MalformedURLException("Could not open InputStream for URL '" + this.url + "'");
        }
        return inputStream;
    }
}

