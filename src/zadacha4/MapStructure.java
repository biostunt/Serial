package zadacha4;

import java.net.ContentHandler;

public class MapStructure <Value>{
    private class Object<Value>{
        private int key;
        private Value value;
        public Object(int key, Value value){
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }
        public Value getValue() {
            return value;
        }
        public String toString(){
            return "Key: " + this.key + " Value: " + this.value;
        }
    }
    private Object[] Container = new Object[1];
    private int top = 0;
    public MapStructure(){}
    public void put(int key,  Value value){
        Container[top++] = new Object<Value>(key,value);
        if(top == Container.length) appendSize();
    }
    private void appendSize(){
        Object[] temp = Container;
        Container = new Object[Container.length + Container.length/2 + 1];
        System.arraycopy(temp,0,Container,0,temp.length);
    }
    public int rank(int key){
        int Less = 0;
        boolean isContains = false;
        for (int i = 0; i < top ; i++){
            if(Container[i].getKey() < key)
                Less++;
            if(Container[i].getKey() == key)
                isContains = true;
        }
        if(isContains)
            System.out.println("There is no element with the same key");
        return Less;
    }

}
