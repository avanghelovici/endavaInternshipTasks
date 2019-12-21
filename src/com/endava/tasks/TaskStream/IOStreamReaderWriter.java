package com.endava.tasks.TaskStream;


import java.io.*;

public class IOStreamReaderWriter {

   private static InputStreamReader reader;
   private static FileInputStream fileInputStream;


    public static void read(File test){
        try {
            fileInputStream = new FileInputStream(test);
            reader = new InputStreamReader(fileInputStream);
            {
                int character;
                while ((character = reader.read()) != -1) {
                    System.out.print((char) character);
                }
                System.out.print("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void write(String st, File test) throws IOException {
        try (FileOutputStream fileStream = new FileOutputStream(test);
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileStream)) {
            outputStreamWriter.write(st);
        }
    }
}
