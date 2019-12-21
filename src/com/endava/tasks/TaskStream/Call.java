package TaskStream;

import java.io.*;

import static TaskStream.TestData.*;

public class Call {
    public static void main(String[] args) throws IOException {
        System.out.print("Result of inputStream: ");
        IOStream.read(testInputStream);
        IOStream.write("Text for OutputStream test", testOutputStream);
        System.out.print("Result of outputStream: ");
        IOStream.read(testOutputStream);

        System.out.print("Result of Reader: ");
        ReaderWriter.read(testReader);
        ReaderWriter.writer("Text for Writer test",testWriter);
        System.out.print("Result of Writer: ");
        ReaderWriter.read(testWriter);

        System.out.print("Result of IOStreamReader: ");
        IOStreamReaderWriter.read(iOreaderTest);
        IOStreamReaderWriter.write("Testing 123123",iOwriterTest);
        System.out.print("Result of IOStreamWriter: ");
        IOStreamReaderWriter.read(iOwriterTest);

        System.out.print("Result of BufferedInputStream: ");
        BufferedIOStream.read(bufferedITest);
        BufferedIOStream.write("Test3456789",bufferedOTest);
        System.out.print("Result of BufferedOutputStream: ");
        BufferedIOStream.read(bufferedOTest);

        System.out.print("Result of FileReader: ");
        FileReaderWriter.read(fileReaderTest);
        FileReaderWriter.write("FileWriterTesting",fileWriterTest);
        System.out.print("Result of FileWriter: ");
        FileReaderWriter.read(fileWriterTest);


    }
}