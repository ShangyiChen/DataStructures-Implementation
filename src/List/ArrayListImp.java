package List;

import java.util.Arrays;

public class ArrayListImp<T> implements List {
    private final int DEFAULT_INITIAL_CAPACITY = 16;
    private final int DEFAULT_MAX_CAPACITY = Integer.MAX_VALUE >>> 1;
    private T[] elements;
    private int size;
    private int capacity;

    public ArrayListImp(){
        this.elements = (T[]) new Object[DEFAULT_INITIAL_CAPACITY];
        this.size = 0;
        this.capacity = DEFAULT_INITIAL_CAPACITY;
    }
    public ArrayListImp(int initialCapacity) {
        if(initialCapacity <= 0){
            initialCapacity = DEFAULT_INITIAL_CAPACITY;
        }
        this.elements = (T[]) new Object[initialCapacity];
        this.size = 0;
        this.capacity = initialCapacity;
    }

    @Override
    public void add(Object item) {
        int newCap = size + 1;
        if(newCap > capacity){
            huge(newCap);
        }

        this.elements[size] = (T) item;
        size++;


    }
    private void huge(int minCap){
        if(minCap > DEFAULT_MAX_CAPACITY){
            throw new RuntimeException("stackOverFlow Exception");
        }
        T[] tmpData;
        int oldCap = this.capacity;
        int newCap = oldCap + (oldCap >>> 1);
        if(newCap < minCap) {
            newCap = minCap;
        }
        if(newCap > DEFAULT_MAX_CAPACITY){
            throw new RuntimeException("stackOverFlow Exception");
        }else if(newCap == DEFAULT_MAX_CAPACITY){
            tmpData = (T[]) new Object[DEFAULT_MAX_CAPACITY];
        }else{
            tmpData = (T[]) new Object[newCap];
        }
        copyElements(tmpData);
        this.capacity = newCap;
    }
    private void copyElements(T[] tmpData){
        Arrays.fill(tmpData, null);
        for(int i = 0; i < this.size; i++){
            tmpData[i] = this.elements[i];
        }
        this.elements = tmpData;
    }

    @Override
    public void remove() {
        this.elements[size - 1] = null;
        this.size--;
    }

    @Override
    public Object get(int index) {
        if(isEmpty()){
            throw new RuntimeException("empty list");
        }
        if(index < 0 || index >= this.size){
            throw new RuntimeException("indexOutOfBoundary");
        }
        return this.elements[index];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    public void print(){
        System.out.print("size = " + this.size + " : ");
        for(int i = 0; i < this.size; i++){
            System.out.print(this.elements[i] + ",");
        }
        System.out.println(" ");
    }

    public static void main(String[] args) {
        ArrayListImp<Integer> list = new ArrayListImp<Integer>();
        for(int i = 1; i < 5; i++){
            list.add(i);
            System.out.println("size="+list.size());
        }
        list.print();
        list.remove();
        list.print();
        for(int i = 0; i < list.size(); i++){
            System.out.println("list.get(" + i + ") = " + list.get(i));
        }

    }

}
