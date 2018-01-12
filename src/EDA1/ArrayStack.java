package EDA1;

public class ArrayStack<E> implements Stack<E> {

    private E[] array;
    private int maxSize;
    private int last = -1;

    public ArrayStack(){
        this(10);
    }

    public ArrayStack(int n){
        maxSize = n;
        array = (E[])new Object[n];
    }

    @Override
    public boolean empty() {
        return last == -1;
    }

    @Override
    public int size() {
        return last;
    }

    @Override
    public E peek() {
        return array[last];
    }

    @Override
    public E pop() {
        if(empty()){
            return null;
        }
        return array[last--];
    }

    private void ensureCapacity(){
        E[] newArray = (E[]) new Object[maxSize * 2];
        for (int i = 0; i < maxSize; i++){
            newArray[i] = array[i];
        }
        array = newArray;
        maxSize *= 2;
    }

    @Override
    public E push(E item) {
        if(last + 1 >= maxSize){
            ensureCapacity();
        }
        array[++last] = item;
        return item;
    }
}
