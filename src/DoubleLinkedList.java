import  java.util.Iterator;

public class DoubleLinkedList<E> implements ILists<E>, Iterable<E> {


    private LNode<E> head, end;
    private int size;

    DoubleLinkedList(){

        head = new LNode<>();
        end = new LNode<>();
        head.next = end;
        end.previous = head;
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

        return head.next == end;

    }

    @Override
    public void remove(int i) {

        LNode<E> c;

        if(i >= size() || i < 0)
            return;

        if (i < size/2) {

            c = Forward(head, 0 - 1, i);

        }else{

            c = Backward(end, size + 1 - 1, i);

        }

        if(c != null) {

            LNode<E> p = c.previous;

            LNode<E> n = c.next;

            p.next = n;

            n.previous = p;

            size--;

        }

    }

    @Override
    public void remove(E x) {

        LNode<E> y = ForwardNode (head, x);

        if (y != null) {

            LNode<E> p = y.previous;

            LNode<E> n = y.next;

            p.next = n;

            n.previous = p;

            size--;

        }
    }

    LNode<E> Forward(LNode<E> current, int at, int target) {

        if (current == end){
            return null;
        }

        if (at == target) {
            return current;
        }

        return Forward(current.next, ++at, target);
    }

    LNode<E> Backward(LNode<E> current, int at, int target) {

        if (current == head){
            return null;
        }

        if (at == target) {
            return current;
        }

        return Backward(current.previous, --at, target);
    }


    LNode<E> ForwardNode ( LNode<E> current, E target){

        if (current.element == target){

            return  current;

        }

        if (current == end) {

            return null;

        }

        return ForwardNode(current.next, target);
    }


    @Override
    public void add(E x) {

        add(size, x);

    }

    @Override
    public void add(int i, E x) {

        if(i > size())
            return;

        LNode<E> n;

        if (i < size/2){

            n = Forward(head, 0, i);

        } else {

            n = Backward(end, size, i);

        }

        if(n != null) {

            LNode<E> a = new LNode<>(x);

            LNode<E> p = n.previous;

            a.next = n;

            a.previous = p;

            n.previous = a;

            p.next = a;

            size++;

        }
    }

    @Override
    public E get(int i) {

        if(i >= size() || i < 0)
            return null;

        if (i < size/2) {

            return Forward(head, 0 - 1, i).element;

        }else{

           return Backward(end, size + 1, i).element;

        }
    }


    @Override
    public void set(int i, E y) {

        LNode<E> node;

        if(i >= size() || i < 0)
            return;

        if (i < size/2) {

            node = Forward(head, 0, i);

        }else{

            node = Backward(end, size, i);

        }

        if(node != null) {

            node.element = y;

        }

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
