package com.endava.tasks.TaskStream;

import java.io.*;

public class ReaderWriter {
    private static Reader reader;
    private static Writer writer;


    public static void read(File test){
        try {
            reader = new FileReader(test);
            int data = reader.read();
            while (data != -1) {
                System.out.print((char) data);
                data = reader.read();
            }
            reader.close();
            System.out.printf("\n");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void writer(String st, File test) throws IOException {
        writer = new FileWriter(test);
        writer.write(st);
        writer.close();
    }
}
