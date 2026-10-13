/*
 * Decompiled with CFR 0.152.
 */
package org.eclipse.jdt.internal.jarinjarloader;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.jar.Attributes;
import java.util.jar.Manifest;
import org.eclipse.jdt.internal.jarinjarloader.b;
import org.eclipse.jdt.internal.jarinjarloader.e;

public class JarRsrcLoader {
    public static void main(String[] stringArray) {
        Object object;
        b b2 = JarRsrcLoader.Ad();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL.setURLStreamHandlerFactory(new e(classLoader));
        URL[] uRLArray = new URL[b2.aaB.length];
        int n2 = 0;
        while (n2 < b2.aaB.length) {
            object = b2.aaB[n2];
            uRLArray[n2] = ((String)object).endsWith("/") ? new URL("rsrc:" + (String)object) : new URL("jar:rsrc:" + (String)object + "!/");
            ++n2;
        }
        URLClassLoader uRLClassLoader = new URLClassLoader(uRLArray, JarRsrcLoader.Ac());
        Thread.currentThread().setContextClassLoader(uRLClassLoader);
        object = Class.forName(b2.aaA, true, uRLClassLoader);
        Method method = ((Class)object).getMethod("main", stringArray.getClass());
        method.invoke(null, new Object[]{stringArray});
    }

    private static ClassLoader Ac() {
        try {
            Method method = ClassLoader.class.getMethod("getPlatformClassLoader", null);
            return (ClassLoader)method.invoke(null, null);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            return null;
        }
    }

    private static b Ad() {
        Enumeration<URL> enumeration = Thread.currentThread().getContextClassLoader().getResources("META-INF/MANIFEST.MF");
        while (enumeration.hasMoreElements()) {
            try {
                URL uRL = enumeration.nextElement();
                InputStream inputStream = uRL.openStream();
                if (inputStream == null) continue;
                b b2 = new b(null);
                Manifest manifest = new Manifest(inputStream);
                Attributes attributes = manifest.getMainAttributes();
                b2.aaA = attributes.getValue("Rsrc-Main-Class");
                String string = attributes.getValue("Rsrc-Class-Path");
                if (string == null) {
                    string = "";
                }
                b2.aaB = JarRsrcLoader.al(string);
                if (b2.aaA == null || b2.aaA.trim().isEmpty()) continue;
                return b2;
            }
            catch (Exception exception) {}
        }
        System.err.println("Missing attributes for JarRsrcLoader in Manifest (Rsrc-Main-Class, Rsrc-Class-Path)");
        return null;
    }

    private static String[] al(String string) {
        if (string == null) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<String>();
        int n2 = 0;
        while (n2 < string.length()) {
            int n3 = string.indexOf(32, n2);
            if (n3 == -1) {
                n3 = string.length();
            }
            if (n3 > n2) {
                arrayList.add(string.substring(n2, n3));
            }
            n2 = n3 + 1;
        }
        return arrayList.toArray(new String[arrayList.size()]);
    }
}

