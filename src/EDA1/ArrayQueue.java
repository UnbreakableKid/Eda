package EDA1;

public class ArrayQueue<E> implements Queue<E> {

    private int capacity;
    private int size;
    private E[] array;
    private int ini;
    private int fim;

    public ArrayQueue(int capacity){
        array = (E[]) new Object[capacity];
        ini = 0;
        fim = 0;
        size = 0;
        this.capacity = capacity;
    }

    public ArrayQueue(){
        this(10);
    }

    private int module(int x){
        return (x + 1) % capacity;
    }

    @Override
    public void enqueue(E o) {
        size++;
        //por no fim
        array[fim] = o;
        if(full())
            expand();
        fim = module(fim);
    }

    private void expand(){
        E[] newArray = (E[]) new Object[capacity * 2];
        for (int i = 0; i < capacity; i++){
            newArray[i] = array[i];
        }
        array = newArray;
        capacity *= 2;
    }

    @Override
    public E front() throws Queue.EmptyException {
        if(empty()){
            throw new Queue.EmptyException();
        }
        return array[ini];
    }

    @Override
    public E dequeue() {
        if(empty()){
            return null;
        }
        size--;
        E old = array[ini];
        array[ini] = null;
        ini = module(ini);
        return old;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean empty() {
        return size() == 0;
    }

    public boolean full(){
        return size() == capacity;
    }

    @Override
    public String toString() {
        String s = "[";
        for(int i = 0; i < size; i++){
            s += array[i].toString() + ((i != size - 1) ? ", " : "]");
        }
        return s;
    }
}
