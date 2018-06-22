package zadacha2;

import zadacha1.MaxPQ;
import zadacha1.Object;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Client {
    public static String getText() throws Exception{
        return new String(Files.readAllBytes(Paths.get("D:\\Projects\\JAVA\\Examinationprogramms\\src\\zadacha2\\book.txt")));
    }
    public static void sortRawData(String raw_data, MaxPQ<zadacha1.Object> maxPQ){
        char[] data = raw_data.toCharArray();
        String word = "";
        for(char ch : data){
            if(ch != '\n' && ch != ' ') word+=ch;
            if(ch == '\n' || ch == ' '){
                maxPQ.insert(new zadacha1.Object(word));
                word = "";
            }
        }
        if(!word.equalsIgnoreCase(""))
            maxPQ.insert(new Object(word));
    }
    public static void main(String[] args) throws Exception {
        MaxPQ<Object> maxPQ = new MaxPQ<Object>();
        String Data = getText();
        sortRawData(Data, maxPQ);
        Object obj =  maxPQ.delMax();
        System.out.println(obj);
        boolean isExit = false;
        while(!isExit){
            Object that = maxPQ.delMax();
            if(obj.getCount() == that.getCount()) System.out.println(that);
            else isExit = true;
        }
    }
}
