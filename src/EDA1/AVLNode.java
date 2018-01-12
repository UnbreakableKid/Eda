package EDA1;

public class AVLNode <E extends Comparable<? super E>> {

    E element;
    AVLNode<E> left;
    AVLNode<E> right;
    int h;
    boolean valid;

    public AVLNode<E> getLeft() {
        return left;
    }

    AVLNode(E x, int h){
        this(x, null, null, h);
    }

    AVLNode (E x, AVLNode<E> left, AVLNode<E> right, int h){
        element = x;
        this.left = left;
        this.right = right;
        valid = true;
        this.h = h;
    }

    int getMaxHeight(){
        int l = (left == null)? 0:left.getMaxHeight();
        int r = (right == null)? 0:right.getMaxHeight();
        return Math.max(l, r)+1;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}
