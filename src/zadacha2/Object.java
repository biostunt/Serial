package zadacha2;

public class Object implements Comparable<Object> {
    private String word;
    private int Count = 0;
    public Object(String s){
        this.word = s;
        findChars();
    }
    private void findChars(){
        String chars = "А, Е, Ё, И, О, У, Ы, Э, Ю, Я";
                //{"А", "Е", "Ё", "И", "О", "У", "Ы", "Э", "Ю", "Я"};
        String[] word = this.word.split("");
        for (int i = 0; i < word.length ; i++) {
            if(chars.contains(word[i]) || chars.contains(word[i].toUpperCase()) ) this.Count++;
        }
    }
    public int getCount() {
        return Count;
    }
    public int compareTo(Object that){
        if(this.Count > that.getCount()) return 1;
        if(this.Count == that.getCount()) return 0;
        else return -1;
    }
    public String toString(){
        return this.word;
    }
}
