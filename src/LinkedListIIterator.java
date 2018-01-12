import java.util.NoSuchElementException;

public class LinkedListIIterator<E> implements java.util.Iterator<E> {


    LNode<E> current;

    public LinkedListIIterator(LNode<E> start){

        current = start.next;


    }

    @Override
    public boolean hasNext() {

        return current != null && current.element != null;

    }


    @Override
    public E next() {
        if (!hasNext()){

            throw new NoSuchElementException();

        }

        E ele = current.element;

        current = current.next;

        return ele;
    }

}
