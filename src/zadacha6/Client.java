package zadacha6;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Client {

    public static String GetText() throws Exception{
        return new String(Files.readAllBytes(Paths.get("D:\\Projects\\JAVA\\Examinationprogramms\\src\\zadacha5\\book.txt")));
    }
    public static void main(String[] args) {
        
    }
}
