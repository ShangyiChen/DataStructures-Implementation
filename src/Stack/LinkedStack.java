package Stack;
import Common.Node;

import java.util.Stack;

public class LinkedStack<T> {

    private int size;
    private Node<T> head;
    private Node<T> tail;

    public LinkedStack() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }


    public T peek() {
        if(isEmpty()){
            throw new RuntimeException("The stack is empty");
        }
        return (T) this.tail;
    }

    public synchronized T pop() {
        if(!isEmpty()){
            T tmp = (T) new Node<>(tail.val);
            size--;
            if(tail.pre != null){
                T val = tail.val;
                tail = tail.pre;
                tail.next = null;
                return val;
            }else{
                T val = tail.val;
                tail.next = null;
                tail = null;
                return val;
            }
        }
        return null;
    }

    public void push(T val){
        size++;
        Node<T> node = new Node<>(val);
        if(this.head == null){
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        tail.next.pre = tail;
        tail = tail.next;
    }

    public static void main(String[] args) {
        LinkedStack<Double> stack = new LinkedStack<Double>();
        for(double i = 1; i < 3; i++){
            stack.push(i);
            System.out.println("size="+stack.size());
        }
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }


}

