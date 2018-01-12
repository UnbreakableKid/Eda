package EDA1;

public class ABNode<E extends Comparable<? super E>>{

    E element;
    ABNode<E> left;
    ABNode<E> right;

    ABNode(E x){
        this.element = x;
        this.left = null;
        this.right = null;
    }

    ABNode ( E x, ABNode<E> left, ABNode<E> right){
        this.element = x;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}


