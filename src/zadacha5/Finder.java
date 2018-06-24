package zadacha5;

public class Finder<Key,Value> {
    private class Object<Key,Value>{
        public Key key;
        public Value value;
        public Object(Key key, Value value){
            this.key = key;
            this.value = value;

        }
        public Key getKey(){return key;}
    }
    private Object[] Container = new Object[1];
    private int[] C =new int[1];
    private int top = 0;
    private int cmp = 0;
    public void add(int key, Value value){
        Container[top] = new Object(key,value);
        C[top] = key;
        top++;
        if(top == Container.length) appendSize();
    }
    public void appendSize(){
        Object[] temp = Container;
        Container = new Object[Container.length + Container.length/2 + 1];
        System.arraycopy(temp,0,Container,0,temp.length);
        int[] t = C;
        C = new int[C.length + C.length/2 + 1];
        System.arraycopy(t,0,C,0,t.length);
    }
    public boolean isExist(Value value){
        if(top == 0) return false;
        for (int i = 0; i < top ; i++) {
            if(Container[i].value == value)
                return true;
        }
        return false;
    }
    public int size(){return top;}
    public int get(){
        return C[cmp];
    }
}
