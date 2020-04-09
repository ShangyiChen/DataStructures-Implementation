package Stack;
import java.util.Arrays;

public class ArrayStack<T> {
    private final static int DEFAULT_INITIAL_CAPACITY = 16;
    private final static int DEFAULT_MAX_CAPACITY = Integer.MAX_VALUE / 2;

    private int size = 0;

    private int capacity;

    private int top = -1;

    private T[] elements;

    public ArrayStack(int capacity){
        if(capacity <= 0){
            throw new IllegalArgumentException("参数不合法");
        }else if(capacity >= DEFAULT_MAX_CAPACITY){
            this.elements = (T[]) new Object[DEFAULT_MAX_CAPACITY];
            this.capacity = DEFAULT_MAX_CAPACITY;
        }else{
            this.elements = (T[]) new Object[capacity];
        }
    }

    public ArrayStack() {
        this.elements = (T[]) new Object[DEFAULT_INITIAL_CAPACITY];
        this.capacity = DEFAULT_INITIAL_CAPACITY;
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public T peek(){
        if(isEmpty()){
            throw new RuntimeException("the stack is empty");
        }
        return this.elements[top];
    }

    public T pop(){
        if(isEmpty()){
            throw new RuntimeException("the stack is empty");
        }
        T tmp = this.elements[top];
        top--;
        size--;
        return tmp;
    }

    public void push(T x){
        int newCap = size + 1;
        if(newCap > capacity){
            huge(newCap);
        }
        size++;
        top++;
        this.elements[top] = x;

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

    public static void main(String[] args) {
        ArrayStack<Double> stack = new ArrayStack<>();
        for(double i = 1; i < 32; i++){
            stack.push(i);
            System.out.println("size="+stack.size()+",capacity="+stack.capacity);
        }
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
