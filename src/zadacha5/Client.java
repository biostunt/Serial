package zadacha5;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Client {
    public static String getRaw() throws Exception{
        return new String(Files.readAllBytes(Paths.get("D:\\Projects\\JAVA\\Examinationprogramms\\src\\zadacha5\\book.txt")));
    }
    public static void sortRawData(String raw_data, Finder finder,RBT rbt){
        char[] data = raw_data.toCharArray();
        String word = "";
        for(char ch : data){
            if(ch != '\n' && ch != ' ' && ch != ',' && ch != '.'){
                String c ="" + ch;
                word += c.toLowerCase();
            };
            if(ch == '\n' || ch == ' '){
                if(!finder.isExist(word)){
                    finder.add(word.length(),word);
                    rbt.put(word.length(),word);
                }
                word = "";
            }
        }
        if(!word.equalsIgnoreCase(""))
            if(finder.isExist(word)){
                finder.add(word.length(),word);
                rbt.put(word.length(),word);
            }
    }
    public static int GetHash(String s){
        return (s.length() * 9719) % 45;
    }
    public static void main(String[] args) throws Exception {
        RBT<Integer,String> rbt = new RBT<>();
        Finder<Integer,String> finder = new Finder<>();
        sortRawData(getRaw(),finder,rbt);
        for (int i = 0; i < finder.size() ; i++) {
            System.out.println(rbt.get(finder.get()));
        }
    }
}
