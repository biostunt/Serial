package zadacha1;

public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int n;
    private boolean isMaxPQ=false;
    public MaxPQ(int size,boolean isMax)
    {
        pq=(Key[]) new Comparable[size+1];
        isMaxPQ=isMax;
    }
    public  MaxPQ(){
        this(1,false);
    }
    public int size(){ return n; }
    public boolean isEmpety(){ return n==0; }
    private void resize(int res){
        assert res>n;
        Key[] temp=(Key[]) new Comparable[res];
        for(int i=1;i<=n;i++)
            temp[i]=pq[i];
        pq=temp;
    }
    public void insert(Key key){
        if(n==pq.length-1) resize(pq.length*2);
        pq[++n]=key;
        swim(n);
    }
    private void swim(int k){
        while(k>1 && less(k/2,k)) {
            exch(k/2,k);
            k=k/2;
        }
    }
    private void sink(int k){
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && less(j, j+1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }
    public Key delMax(){
        Key temp=pq[1];
        exch(1,n--);
        sink(1);
        pq[n+1] =null;
        if((n>0)&&(n==(pq.length-1)/4)) resize(pq.length/2);
        return temp;
    }
    private boolean less(int i,int j)
    {
        if(!isMaxPQ)
            return(pq[i].compareTo(pq[j])<0);
        else
            return (pq[i].compareTo(pq[j])>0);
    }
    private void exch(int i,int j){
        Key temp=pq[i];
        pq[i]=pq[j];
        pq[j]=temp;
    }
}

