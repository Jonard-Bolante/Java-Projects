import java.util.*;

public class Stacke<E> {

    private ArrayList<E> items;

    public Stacke() {
        items = new ArrayList<E>();
    }

    public boolean isEmpty() {
        return items.size() == 0;
    }

    public void push(E item) {
        if (item == null) {
            throw new NullPointerException();
        } else {
            items.add(item);
        }
    }

    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return items.remove(items.size() - 1);
        }
    }

    public E top() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return items.get(items.size() - 1);
        }
    }
}