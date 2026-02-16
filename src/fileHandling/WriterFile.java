package fileHandling;

import java.io.FileWriter;
import java.io.IOException;

public class WriterFile {
    public static void main(String[] args) throws IOException {
        FileWriter writer = new FileWriter("src/fileHandling/output.txt");
        writer.write("Hey I am writing this is to just check the strings");
        writer.close();
    }
}
