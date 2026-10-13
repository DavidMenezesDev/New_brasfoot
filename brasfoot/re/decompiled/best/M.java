/*
 * Decompiled with CFR 0.152.
 */
package best;

import best.ac;
import best.ad;
import best.n;
import c.a;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Random;

public class M {
    private static ArrayList gy = null;
    private static ArrayList gz = null;
    private InputStream gA = this.getClass().getResourceAsStream("/arquivos/default_lang.xml");
    private InputStream gB = this.getClass().getResourceAsStream("/arquivos/ok_bra.txt");
    private static Properties gC = null;

    public M(boolean bl2) {
        if (bl2) {
            this.a(this.it());
        } else {
            this.iu();
        }
    }

    public M() {
    }

    public void a(Properties properties) {
        gC = properties;
    }

    public Properties it() {
        Properties properties = new Properties();
        try {
            properties.loadFromXML(this.gA);
        }
        catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        return properties;
    }

    public void iu() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.gB));
        try {
            String string;
            while ((string = bufferedReader.readLine()) != null) {
                a.SR.aX().add(string);
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public static void iv() {
        String string = "E:/Dropbox/JavaProjetos/names/";
        int n2 = 0;
        while (n2 < ac.jz()) {
            String string2 = String.valueOf(((ad)n.cY().get(n2)).jE()) + ".txt";
            File file = new File(String.valueOf(string) + string2);
            try {
                file.createNewFile();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
            ++n2;
        }
    }

    public static String getString(String string) {
        String string2 = gC.getProperty(string);
        return string2;
    }

    public static void iw() {
        InputStream inputStream = M.class.getClass().getResourceAsStream("/arquivos/default_lang.xml");
        try {
            Properties properties = new Properties();
            properties.loadFromXML(inputStream);
            Enumeration<Object> enumeration = properties.keys();
            while (enumeration.hasMoreElements()) {
                String string = (String)enumeration.nextElement();
                String string2 = properties.getProperty(string);
            }
        }
        catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public void s(int n2, int n3) {
        Object var3_3 = null;
        Object var4_4 = null;
        int n4 = n.G(n2);
        String string = ((ad)n.cY().get(n4)).jE();
        String string2 = "/arquivos/names/" + string + ".txt";
        String string3 = "/arquivos/surnames/" + string + ".txt";
        if (n3 == 1) {
            string2 = string3;
        }
        InputStream inputStream = this.getClass().getResourceAsStream(string2);
        BufferedReader bufferedReader = null;
        if (inputStream != null) {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                unsupportedEncodingException.printStackTrace();
            }
        }
        int n5 = 0;
        try {
            String string4;
            while ((string4 = bufferedReader.readLine()) != null) {
                ++n5;
                if (!string4.isEmpty() & !string4.contains(".") & !string4.contains("/") & !string4.contains("(") & !string4.matches(".*\\d+.*")) {
                    System.out.println(String.valueOf(n5) + ":" + string4);
                }
                System.out.println(string4);
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    /*
     * Unable to fully structure code
     */
    public ArrayList a(String var1_1, int var2_2, int var3_3) {
        block16: {
            block17: {
                if (var2_2 == 221) {
                    var2_2 = 85;
                } else if (var2_2 == 222) {
                    var2_2 = 72;
                } else if (var2_2 == 223) {
                    var2_2 = 85;
                }
                if (M.gy == null || M.gy.size() < 221) {
                    M.gy = new ArrayList<E>(221);
                    var4_4 = 0;
                    while (var4_4 < 222) {
                        M.gy.add(new ArrayList<E>());
                        ++var4_4;
                    }
                }
                if (M.gz == null || M.gz.size() < 221) {
                    M.gz = new ArrayList<E>(221);
                    var4_4 = 0;
                    while (var4_4 < 222) {
                        M.gz.add(new ArrayList<E>());
                        ++var4_4;
                    }
                }
                if (M.gy.get(var2_2) == null) {
                    var4_5 = new ArrayList<E>();
                    M.gy.set(var2_2, var4_5);
                }
                if (M.gz.get(var2_2) == null) {
                    var4_6 = new ArrayList<E>();
                    M.gy.set(var2_2, var4_6);
                }
                var4_7 = (ArrayList)M.gy.get(var2_2);
                if (var3_3 == 1) {
                    var4_7 = (ArrayList)M.gz.get(var2_2);
                }
                if (var4_7 == null || var4_7.size() != 0) break block16;
                var5_8 = this.getClass().getResourceAsStream(var1_1);
                var6_9 = null;
                if (var5_8 == null) break block17;
                try {
                    var6_9 = new BufferedReader(new InputStreamReader(var5_8, "UTF-8"));
                }
                catch (UnsupportedEncodingException var7_10) {
                    var7_10.printStackTrace();
                }
                if (true) ** GOTO lbl52
            }
            return null;
            {
                do {
                    if (!(var7_11.isEmpty() == false & var7_11.contains(".") == false & var7_11.matches(".*\\d+.*") == false)) continue;
                    var4_7.add(var7_11);
lbl52:
                    // 4 sources

                } while ((var7_11 = var6_9.readLine()) != null);
            }
        }
        return var4_7;
    }

    public String au(int n2) {
        String string = null;
        String string2 = null;
        ArrayList arrayList = null;
        int n3 = n.G(n2);
        String string3 = ((ad)n.cY().get(n3)).jE();
        String string4 = "/arquivos/names/" + string3 + ".txt";
        String string5 = "/arquivos/surnames/" + string3 + ".txt";
        arrayList = this.a(string4, n2, 0);
        if (arrayList != null && arrayList.size() > 0) {
            int n4 = new Random().nextInt(arrayList.size());
            int n5 = 0;
            if (arrayList.size() >= 1000 && new Random().nextInt(2) == 0) {
                n4 = new Random().nextInt(500);
            }
            if (n4 == 0) {
                n4 = 1;
            }
            if ((n5 = M.q(string = (String)arrayList.get(n4))) == 1) {
                arrayList = this.a(string5, n2, 1);
                if (arrayList != null && arrayList.size() > 2) {
                    int n6 = new Random().nextInt(arrayList.size());
                    if (n6 == 0) {
                        n6 = 1;
                    }
                    if (!string.equals(string2 = (String)arrayList.get(n6))) {
                        string = String.valueOf(string) + " " + string2;
                    }
                }
            } else if (n5 == 2) {
                boolean bl2 = false;
                if (new Random().nextInt(2) == 0) {
                    bl2 = true;
                }
                if (string.length() <= 12 && bl2 && arrayList != null && arrayList.size() > 2) {
                    int n7 = new Random().nextInt(arrayList.size());
                    if (n7 == 0) {
                        n7 = 1;
                    }
                    if (!string.equals(string2 = (String)arrayList.get(n7)) && string2.length() <= 6) {
                        string = String.valueOf(string) + " " + string2;
                    }
                }
            }
        }
        return string;
    }

    public String k(int n2, boolean bl2) {
        String string = null;
        String string2 = null;
        ArrayList arrayList = null;
        int n3 = n.G(n2);
        String string3 = ((ad)n.cY().get(n3)).jE();
        String string4 = "/arquivos/names/" + string3 + ".txt";
        String string5 = "/arquivos/surnames/" + string3 + ".txt";
        arrayList = this.a(string4, n2, 0);
        if (arrayList != null && arrayList.size() > 0) {
            int n4 = new Random().nextInt(arrayList.size());
            int n5 = 0;
            if (arrayList.size() >= 1000 && new Random().nextInt(2) == 0) {
                n4 = new Random().nextInt(500);
            }
            if (n4 == 0) {
                n4 = 1;
            }
            if ((n5 = M.q(string = (String)arrayList.get(n4))) == 1) {
                if (bl2 && (arrayList = this.a(string5, n2, 1)) != null && arrayList.size() > 2) {
                    int n6 = new Random().nextInt(arrayList.size());
                    if (n6 == 0) {
                        n6 = 1;
                    }
                    if (!string.equals(string2 = (String)arrayList.get(n6))) {
                        string = String.valueOf(string) + " " + string2;
                    }
                }
            } else if (n5 == 2) {
                boolean bl3 = false;
                if (new Random().nextInt(2) == 0) {
                    bl3 = true;
                }
                if (!bl2) {
                    bl3 = false;
                }
                if (string.length() <= 12 && bl3 && arrayList != null && arrayList.size() > 2) {
                    int n7 = new Random().nextInt(arrayList.size());
                    if (n7 == 0) {
                        n7 = 1;
                    }
                    if (!string.equals(string2 = (String)arrayList.get(n7)) && string2.length() <= 6) {
                        string = String.valueOf(string) + " " + string2;
                    }
                }
            }
        }
        return string;
    }

    public static int q(String string) {
        if (string == null || string.isEmpty()) {
            return 0;
        }
        String[] stringArray = string.split("\\s+");
        return stringArray.length;
    }
}

