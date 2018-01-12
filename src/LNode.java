public class LNode<E> {

    LNode<E> previous;
    LNode<E> next;
    E element;

    LNode() {this(null, null, null);}

    LNode(E e, LNode<E> prev, LNode<E> next){

        this.next = next;
        previous = prev;
        element = e;
    }

    LNode (E e) {this (e, null, null); }
}
