package zadacha4;

import java.util.Random;

public class Client {
    public static int getRandomInt(int i){
        Random rand = new Random();
        int boot = rand.nextInt(i);
        while(boot == 0) boot = rand.nextInt(i);
        return boot;
    }
    public static String getRandomString(int i){
        char[] alpha = "qwertyuiopasdfghjklzxcvbnm".toCharArray();
        String word = "";
        for (int j = 0; j < i ; j++) {
            word+= alpha[getRandomInt(alpha.length)];
        }
        return word;
    }

    public static void main(String[] args){
        MapStructure<String> map = new MapStructure<String>();
        int MAX = 100;
        for (int i = 0; i < MAX ; i++) {
            map.put(getRandomInt(100),getRandomString(getRandomInt(11)));
        }
        System.out.println("" + map.rank(10));
    }
}
