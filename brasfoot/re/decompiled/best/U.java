/*
 * Decompiled with CFR 0.152.
 */
package best;

import best.V;
import best.ah;
import c.a;
import e.t;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class U {
    private static transient int hj = 0;

    public static void w(boolean bl2) {
        File file = new File(String.valueOf(System.getProperty("user.dir")) + "/teams");
        File[] fileArray = file.listFiles(new V());
        if (fileArray != null) {
            int n2 = 0;
            while (n2 < fileArray.length) {
                if (fileArray[n2].isFile()) {
                    String string = fileArray[n2].getName();
                    string = string.substring(0, string.lastIndexOf("."));
                    try {
                        U.a(fileArray[n2].getPath(), string, bl2);
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                }
                ++n2;
            }
        }
    }

    public static void a(String string, String string2, boolean bl2) {
        t t2 = new t();
        try {
            FileInputStream fileInputStream = new FileInputStream(string);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            t2 = (t)objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return;
        }
        catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
            return;
        }
        try {
            if (bl2) {
                new ah(t2);
            } else if (t2.getVid() == 185) {
                boolean bl3 = false;
                if (bl3) {
                    if (t2.getPais() == 29 && hj < 24) {
                        t2.setPais(218);
                        ++hj;
                    } else if (t2.getPais() == 29 && hj < 48) {
                        t2.setPais(220);
                        ++hj;
                    }
                }
                t2.setFileRef(string2);
                if (t2.isValid()) {
                    if (t2.getPais() >= 0 && t2.getPais() < a.SR.bD.length) {
                        int n2 = t2.getPais();
                        a.SR.bD[n2] = a.SR.bD[n2] + 1;
                        if (t2.getPais() == 29) {
                            int n3 = t2.getEstado();
                            a.SR.bE[n3] = a.SR.bE[n3] + 1;
                        }
                    }
                    a.SR.bC.add(t2);
                }
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }
}

