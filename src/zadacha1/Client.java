package zadacha1;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Client {

    public static String GetRawText() throws Exception{
        return new String(Files.readAllBytes(Paths.get("D:\\Projects\\JAVA\\Examinationprogramms\\src\\zadacha1\\book.txt")));
    }
    public static void AddWords(String text, PriorityQueue priorityQueue) throws Exception{
        String word = "";
        char[] raw_text = text.toCharArray();
        for(char ch : raw_text){
            if(ch != ' ') word+=ch;
            if(ch == ' '){
                priorityQueue.add(word);
                word = "";
            }
        }
        if(!word.equalsIgnoreCase(""))
            priorityQueue.add(word);
    }
   public static void main(String[] args) throws Exception {

        String raw_text = GetRawText();
        PriorityQueue priorityQueue = new PriorityQueue();
        AddWords(raw_text,priorityQueue);
        priorityQueue.setSort();
        boolean isExit = false;
        while(!isExit){
            String k = priorityQueue.delete();
            if(priorityQueue.isLong(k))
                System.out.println(k);
            else
                isExit = true;
        }

   }
}
