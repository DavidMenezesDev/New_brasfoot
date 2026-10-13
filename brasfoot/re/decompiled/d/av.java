/*
 * Decompiled with CFR 0.152.
 */
package d;

import best.n;
import d.aw;
import e.t;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class av {
    public static void iD() {
        File file = new File(String.valueOf(n.cK) + "/teams");
        File[] fileArray = file.listFiles(new aw());
        int n2 = 0;
        while (n2 < fileArray.length) {
            if (fileArray[n2].isFile()) {
                String string = fileArray[n2].getName();
                string = string.substring(0, string.lastIndexOf("."));
                av.e(fileArray[n2].getPath(), string);
            }
            ++n2;
        }
    }

    public static void e(String string, String string2) {
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
        if (t2.getVid() == 185) {
            t2.setFileRef(string2);
            n.cZ().add(t2);
        }
    }
}

