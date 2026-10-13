/*
 * Decompiled with CFR 0.152.
 */
package components;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;

public class ar
implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        String string = "<html>";
        string = String.valueOf(string) + this.a(throwable);
        string = string.replaceAll("at ", "<br>        at ");
        string = String.valueOf(string) + "</html>";
        ar.d("erros.log", string);
        throwable.printStackTrace();
    }

    private String a(Throwable throwable) {
        StringWriter stringWriter = new StringWriter();
        throwable.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static void d(String string, String string2) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(string, true));
            bufferedWriter.write(string2);
            bufferedWriter.close();
        }
        catch (IOException iOException) {
            // empty catch block
        }
    }

    private void b(Throwable throwable) {
        String string = System.getProperty("user.dir");
        File file = new File(String.valueOf(string) + "/erros.log");
        try {
            PrintStream printStream = new PrintStream(file);
            throwable.printStackTrace(printStream);
            printStream.close();
        }
        catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }

    public static void ao(String string) {
        String string2 = System.getProperty("user.dir");
        File file = new File(String.valueOf(string2) + "/infoerro.txt");
    }
}

