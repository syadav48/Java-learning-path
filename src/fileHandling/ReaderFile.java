package fileHandling;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReaderFile {
   public static void main(String[] args) throws IOException {
       FileReader fileReader = new FileReader("src/fileHandling/output.txt");
       int ch;
       while ((ch = fileReader.read()) != -1){
           System.out.println((char) ch);
       }
       fileReader.close();
    }
}
