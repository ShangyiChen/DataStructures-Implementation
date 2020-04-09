package Common;

public class Node<T> {
    public T val;
    public Node<T> next;
    public Node<T> pre;

    public Node(T x){
        this.val  = x;
    }
}
