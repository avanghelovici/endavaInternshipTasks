package TaskStream;

import java.io.*;

public class BufferedIOStream {

    private static FileInputStream fileInputStream;
    private static FileOutputStream fileOutputStream;
    private static BufferedInputStream bufferedInputStream;
    private static BufferedOutputStream bufferedOutputStream;

    public static void read(File test) {
        try {
            fileInputStream = new FileInputStream(test);
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            int i;
            while ((i = bufferedInputStream.read()) != -1) {
                System.out.print((char) i);
            }
            System.out.print("\n");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void write(String st, File test) {
        try {
            fileOutputStream = new FileOutputStream(test);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            byte b[] = st.getBytes();
            bufferedOutputStream.write(b);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

