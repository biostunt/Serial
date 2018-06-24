package zadacha6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Client {
    public static String GetText() throws Exception{
        return new String(Files.readAllBytes(Paths.get("D:\\Projects\\JAVA\\Examinationprogramms\\src\\zadacha6\\book.txt")));
    }
    public static void main(String[] args) throws Exception{
        String raw_data = GetText();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String word = input.readLine();
        RabinKarp searcher = new RabinKarp(word);
        int exp = searcher.search(raw_data);
        System.out.println(raw_data);
        for (int i = 0; i < exp ; i++) {
            System.out.print(" ");
        }
        System.out.print(word);
    }
}
