import java.util.Iterator;

public class ListCircularIterator<T> implements Iterator<T> {
    private LinkedListCircular.SentinelNode s;
    private int size;

    public ListCircularIterator(LinkedListCircular<T> linkedListCircular) {
        this.s = (LinkedListCircular.SentinelNode) linkedListCircular.getfirstNode();
        this.size = linkedListCircular.size();
    }

    @Override
    public boolean hasNext() {
        return s.getindex() < size+1;
    }

    @Override
    public T next() {
        T t=(T)s;
        s=s.getnext();
        return t;
    }


}
