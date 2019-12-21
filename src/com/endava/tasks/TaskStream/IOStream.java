package com.endava.tasks.TaskStream;

import java.io.*;

public class IOStream {
    private static InputStream inputstream;

    private static OutputStream outputStream;

    public static void read(File test) throws IOException {
        inputstream = new FileInputStream(test);
        int data = inputstream.read();
        char content;
        while (data != -1) {
            content = (char) data;
            System.out.print(content);
            data = inputstream.read();
        }
        inputstream.close();
        System.out.printf("\n");
    }

    public static void write(String st, File test) throws IOException {
        outputStream = new FileOutputStream(test);
        outputStream.write(st.getBytes());
        outputStream.close();
    }
}
