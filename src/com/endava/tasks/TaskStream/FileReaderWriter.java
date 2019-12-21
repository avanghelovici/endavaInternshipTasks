package com.endava.tasks.TaskStream;

import java.io.*;

public class FileReaderWriter {
    private static FileReader fileReader;

    public static void read(File test) {
        try {
            fileReader = new FileReader(test);
            {
                int charRead = -1;
                while ((charRead = fileReader.read()) != -1) {
                    System.out.print((char) charRead);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void write(String st, File test) {
        try (
                FileWriter writer = new FileWriter(test);
        ) {
            writer.write(st);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}