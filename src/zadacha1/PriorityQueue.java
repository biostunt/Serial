package zadacha1;

public class PriorityQueue {
    private String[] Container = new String[2];
    private int top = 0;
    private int first = 0;
    private int maxlong;
    public PriorityQueue(){

    }
    public boolean isEmpty() {return this.top == 0;}
    public int size() {return this.top - 1;}
    public void add(String obj){
        this.Container[this.top] = obj;
        swim(this.top);
        this.top++;
        if(this.top == this.Container.length) appendSize();

    }
    private void appendSize(){
        String[] temp = this.Container;
        this.Container = new String[this.Container.length + this.Container.length/2 + 1];
        System.arraycopy(temp,0,this.Container,0,temp.length);
    }
    private void swim(int k){
        while(k > 1 && less(k/2,k)){
            swap(k/2,k);
            k = k/2;
        }
    }
    private boolean less(int a, int b){
        if(this.Container[a].length() < this.Container[b].length())
            return true;
        else
            return false;
    }
    private void swap(int a, int b){
        String temp = this.Container[a];
        this.Container[a] = this.Container[b];
        this.Container[b] = temp;
    }
    public void setSort(){
        doSort(0,this.top-1);
        this.maxlong = this.Container[0].length();
    }
    private void doSort(int start, int end) {
        if (start >= end)
            return;
        int i = start, j = end;
        int cur = i - (i - j) / 2;
        while (i < j) {
            while (i < cur && (this.Container[i].length() >= this.Container[cur].length())) {
                i++;
            }
            while (j > cur && (this.Container[cur].length() >= this.Container[j].length())) {
                j--;
            }
            if (i < j) {
                swap(i,j);
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        doSort(start, cur);
        doSort(cur+1, end);
    }
    public String delete(){
        String temp = this.Container[this.first++];
        return temp;
    }
    public boolean isLong(String obj){
        if(obj.length() == this.maxlong) return true;
        else return false;
    }
}
