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

        LNode<E> c = Forward(head, 0, i);

        LNode<E> p = c.previous;

        LNode<E> n = c.next;

        p = n.next;

        size--;

    }

    @Override
    public void remove(E x) {

        LNode<E> y = ForwardNode (head, x);

        LNode<E> p = y.previous;

        LNode<E> n = p.next;

        p.next = n;

        size--;
    }


    LNode<E> Forward( LNode<E> current, int i, int target) {

        if (i == target) {
            return current;

        }

        return Forward(current.next, i++, target);
    }


    LNode<E> ForwardNode ( LNode<E> current, E target){

        if (current.element == target){

            return  current;

        }

        return ForwardNode(current.next, target);
    }


    @Override
    public void add(E x) {

        LNode<E> y = Forward(head, 0, size);

        LNode<E> temp = new  LNode<>(x);

        temp.previous = y;
        y.next = temp;

        size ++;

    }

    @Override
    public void add(int i, E x) {

        LNode<E> n = Forward(head, 0, i);

        LNode<E> a = new LNode<>(x);

        LNode<E> p = n.previous;

        a.next = n;

        a.previous = p;

        n.previous = a;

        p.next = a;

        size++;

    }

    @Override
    public E get(int i) {

        return Forward(head, 0, i).element;
    }


    @Override
    public void set(int i, E y) {

        LNode<E> node = Forward(head, 0, i);
        node.element = y;

    }

    @Override
    public String toString() {

        String s = "";
        LNode<E> current = head.next;

        while (current != null){

            s+= current.element + " , ";
            current = current.next;

        }
     return s;
    }
}
