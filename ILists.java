public interface ILists<E> {

    public java.util.Iterator<E> iterator();

    public int size();

    public boolean isEmpty();

    public void remove(int i);

    public void remove(E x);

    public void add(E x); // adiciona x no fim da lista

    public void add(int i, E x);

    public E get(int i);

    public void set(int i, E y);

    public String toString();

}
