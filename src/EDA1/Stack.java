package EDA1;

public interface Stack<E>{

    public boolean empty();
    public int size();
    public E peek();
    public E pop();
    public E push(E item);

}
