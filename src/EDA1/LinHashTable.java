package EDA1;

public class LinHashTable<E> extends Hashtable<E> {

    @Override
    protected int procPos(E s) {

        int i = 0;

        int h = hash(s.hashCode());

        int ori = h;

        //System.out.println(h);

        while (true) {

            h = (ori + i) % size;
            i++;

            if (table[h] == null)

                break;

            else if (table[h].data.equals(s) && (table[h].valid)){ //if they the same and valid

                break;

            }

            if (i == size){

                return -1;

            }
        }
        return h;
    }
}