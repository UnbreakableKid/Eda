package EDA1;

public class IteradorEmOrdemAVL<E extends Comparable<? super E>> implements java.util.Iterator<E> {

    // LEFT; NODE; RIGHT
    private AVLNode<E> current;
    private ArrayQueue<AVLNode<E>> lost;

    @Override
    public boolean hasNext() {
        return !lost.empty();
    }

    @Override
    public E next() {
        if (!hasNext()) {
            throw new java.util.NoSuchElementException();
        }
        current = lost.dequeue();
        return current.element;
    }

    private void doAll(AVLNode<E> node){
        if(node.left != null){
            doAll(node.left);
        }

        if(node.valid) lost.enqueue(node);

        if(node.right != null){
            doAll(node.right);
        }
    }

    public IteradorEmOrdemAVL(AVLNode<E> r, int capacity) {
        lost = new ArrayQueue<>(capacity);
        if(r != null) {
            doAll(r);
        }
    }
}
