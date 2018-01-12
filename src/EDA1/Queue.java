package EDA1;

public interface Queue<E> {

    public void enqueue(E o);

    public E front() throws EmptyException;

    public E dequeue() throws EmptyException;

    public int size();

    public boolean empty();

    class EmptyException extends Exception {
        @Override
        public String toString() {
            return "Queue is empty";
        }
    }
}
