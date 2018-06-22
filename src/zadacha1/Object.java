package zadacha1;

public class Object implements Comparable<Object> {
    private String word;
    private int Count;
    public Object(String s){
        this.word = s;
        this.Count = s.length();
    }

    public String getWord() {
        return word;
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
        return getWord();
    }
}
