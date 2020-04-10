package List;
import Common.Node;
public class LinkedListImp<T> implements List{

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedListImp(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }


    public void add(Object item) {
        Node<T> node = new Node<T>((T) item);
        if(this.size() == 0){
            this.head = node;
            this.tail = node;
            this.head.next = tail;
            this.tail.pre = head;
            this.head.pre = null;
            this.tail.next = null;
            this.size++;
            return;
        }

        tail.next = node;
        tail.next.pre = tail;
        tail = tail.next;
        tail.next = null;
        this.size++;
    }

    public void addFirst(T item){
        Node<T> node = new Node<>(item);
        node.next = this.head;
        node.pre = null;
        this.head.pre = node;
        this.head = node;
        this.size++;
    }

    @Override
    public void remove() {
        if(isEmpty()){
            throw new RuntimeException("empty list");
        }
        if(this.size == 1){
            this.tail = null;
            this.head = null;
            this.size--;
            return;
        }
        Node<T> node = this.tail.pre;
        this.tail.pre = null;
        tail = node;
        tail.next = null;
        this.size--;
    }
    public void removeFirst(){
        if(isEmpty()){
            throw new RuntimeException("empty list");
        }
        if(this.size == 1){
            this.tail = null;
            this.head = null;
            this.size--;
            return;
        }
        Node<T> node = this.head.next;
        this.head.next = null;
        this.head = node;
        this.head.pre = null;
        this.size--;
    }

    @Override
    public T get(int index) {
        if(isEmpty()){
            throw new RuntimeException("empty list");
        }
        if(index <= 0 || index >= this.size){
            throw new RuntimeException("indexOutOfBoundary");
        }
        if(index <= this.size/2){
            int i = 0;
            Node<T> p = head;
            while(i < index){
                i++;
                p = p.next;
            }
            return p.val;
        }else{
            int i = this.size - 1;
            Node<T> p = tail;
            while(i > index){
                i--;
                p = p.pre;
            }
            return p.val;
        }
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
        Node<T> p = head;
        System.out.print("size="+this.size()+":");
        while(p != null){
            System.out.print(p.val + ",");
            p = p.next;
        }
        System.out.println(" ");
    }

    public static void main(String[] args) {
        LinkedListImp<Integer> list = new LinkedListImp<Integer>();
        for(int i = 1; i < 5; i++){
            list.add(i);
            System.out.println("size="+list.size());
        }
        list.print();
        list.remove();
        list.print();
        list.removeFirst();
        list.print();
        list.addFirst(9);
        list.print();

    }
}
