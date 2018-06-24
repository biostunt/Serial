package zadacha3;

public class Correction {
    private int top;
    private boolean[] Answer;
    public Correction(int size){
        Answer = new boolean[size];
    }
    public void addModification(boolean cor){
        Answer[this.top++] = cor;
    }
    public boolean isCorrect(){
        for(boolean b : Answer)
            if(!b)
                return false;
        return true;
    }
}
