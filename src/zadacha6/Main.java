package zadacha6;

import java.util.Random;

public class Main {

    public static void trySearch(String text,String find){
        BMSearch search = new BMSearch(text);
        System.out.print("Starting searching\n");
        System.out.print(""+ search.seacrh(find));
    }

    public static String TextGenerator(int size, char[] alpha){
        String text = "";
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            text += alpha[rand.nextInt(alpha.length-1)];
        }
        System.out.println("Random ends...");
        return text;
    }

    public static void main(String[] args) {
        char[] alphabet = "QWERTYUIOPOASDFGHJKLZXCVBNM".toCharArray();
        int MAX = 10000 ;
        String text = TextGenerator(MAX, alphabet);
        String find = "HELLO";
        trySearch(text,find);

    }

}
