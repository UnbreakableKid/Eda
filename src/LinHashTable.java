public class LinHashTable<E> extends HashTable<E> {


    @Override
    public int procPos(E s) {

        int i = 0;

        int h = hash(s.hashCode());

        System.out.println(h);

        while (true) {

            h = (h + i) % Size;
            i++;

            if (table[h] == null)

                break;

            else if (table[h].data == s && table[h].valid){ //if they the same and valid

                break;
            }

            if (i == Size){

                return -1;
            }
        }
        return h;
    }
}