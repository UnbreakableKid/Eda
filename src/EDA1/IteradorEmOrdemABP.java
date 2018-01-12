package EDA1;

public class IteradorEmOrdemABP <E extends Comparable<? super E>> implements java.util.Iterator<E> {

    // LEFT; NODE; RIGHT
    private ABNode<E> current;
    private ArrayQueue<ABNode<E>> lost;

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

    private void doAll(ABNode<E> node){
        if(node.left != null){
            doAll(node.left);
        }
        lost.enqueue(node);
        if(node.right != null){
            doAll(node.right);
        }
    }

    public IteradorEmOrdemABP(ABNode<E> r, int capacity) {
        lost = new ArrayQueue<>(capacity);
        if(r != null) {
            doAll(r);
        }
    }
}
