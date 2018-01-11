public class Queue<E>implements IQueue <E> {

    int size, fim, ini, capacity;
    E[] queue;

    public Queue (int capacity){

        queue = (E[]) new Object [capacity];
        size = 0;
        ini = 0;
        fim = 0;
        this.capacity = capacity;

    }

    private int module(int x){
        return (x + 1) % capacity;
    }


    @Override
    public void enqueue(E o) {

        if(!full()) {


            queue[fim] = o;

            fim = module(fim);

            size++;
        }
    }


    @Override
    public E front() throws EmptyException {

        if (empty()){

            throw new EmptyException();
        }

        else {

            return queue[ini];

        }
    }

    @Override
    public E dequeue() throws EmptyException {
        if (empty()){

            throw new EmptyException();

        } else{

            size --;

            E x = queue[ini];

            queue[ini] = null;

            ini = module(ini);


            return x;
        }
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
}
