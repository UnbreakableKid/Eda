import  java.util.Iterator;

public class LinkedList<E> implements ILists<E>, Iterable<E> {


    LNode<E> head;
    int size;

    LinkedList(){
        head = new LNode<>();
        size = 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIIterator<E>(head);
    }

    @Override
    public int size() {

        return size;

    }

    @Override
    public boolean isEmpty() {

        return head.next == null;

    }

    @Override
    public void remove(int i) {

        if(i >= size() || i < 0)
            return;

        LNode<E> b = Forward(head, 0, i);

        LNode<E> c = b.next;

        b.next = c.next;

        size--;

    }

    @Override
    public void remove(E x) {

        LNode<E> b = ForwardNode (head.next, head, x);

        if(b != null) {

            LNode<E> c = b.next;

            b.next = c.next;

            size--;

        }
    }


    LNode<E> Forward( LNode<E> current, int i, int target) {

        if (i == target) {

            return current;

        }

        return Forward(current.next, ++i, target);
    }


    LNode<E> ForwardNode (LNode<E> current, LNode<E> previous, E target){

        if(current == null) {

            return null;

        }

        if (current.element == target){

            return  previous;

        }

        return ForwardNode(current.next, previous, target);
    }


    @Override
    public void add(E x) {

        add(size, x);

    }

    @Override
    public void add(int i, E x) {

        LNode<E> b = Forward(head, 0, i);

        LNode<E> n = b.next;

        b.next = new LNode<>(x);

        if(n != null) {
            b.next.next = n;
        }

        size ++;



    }

    @Override
    public E get(int i) {

        if(i >= size() || i < 0)
            return null;

        return Forward(head, 0 - 1, i).element;

    }


    @Override
    public void set(int i, E y) {

        if(i >= size() || i < 0)
            return;

        LNode<E> node = Forward(head, 0 - 1, i);
        node.element = y;

    }

    @Override
    public String toString() {

        String s = "[";
        LNode<E> current = head;

        for(int i = 0; i < size; i++){
            current = current.next;
            s += current.element;
            if (i != size - 1) {
                s += ", ";
            }
        }

        s += "]";

        return s;
    }
}
