package List;

public interface List<T> {
    void add(T item);
    void remove();
    T get(int index);
    int size();
    boolean isEmpty();
}
