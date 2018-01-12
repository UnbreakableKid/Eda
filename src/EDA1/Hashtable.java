package EDA1;

public abstract class Hashtable<E> {

    private static int DEF_SIZE = 11;
    int size = 0;
    int ocupado = 0;

    Elemento<E>[] table;

    public Hashtable() {

        this(DEF_SIZE);

    }


    public Hashtable(int n) {

        alocarTabela(n);

    }

    public int ocupados() {

        return ocupado;

    }

    public float factorCarga() {

        return (float) ocupado / size;

    }

    int hash(int hashCode) {

        return hashCode % size;

    }

    protected abstract int procPos(E s);

    public void alocarTabela(int dim) {

        table = (Elemento<E>[])new Elemento[dim];
        this.size = dim;

    }

    public void tornarVazia() {

        table = (Elemento<E>[])new Elemento[size];

    }


    public E procurar(E x) {

        int pos = procPos(x);

        if(pos == -1) {

            return null;

        }

        return table[pos].data;
    }


    public void remove(E x) {

        ocupado--;

        int i = procPos(x);

        table[i].valid = false;

    }

    public void insere(E x) {

        ocupado++;

        table[procPos(x)] = new Elemento<>(x);

        if (factorCarga() > 0.5f) {
            rehash();
        }
    }

    public void rehash() {

        int now = size * 2 + 1;
        int oldN = size;

        do {

            now++;

        } while (!isPrime(now));

        Elemento<E>[] old = table;

        alocarTabela(now);

        for (int i = 0; i < oldN; i++) {

            Elemento<E> ele = old[i];

            if (ele != null) {

                insere(ele.data);

            }
        }

        size = now;

    }

    public boolean isPrime(int n) {

        for (int i = 2; i <= n / 2; i++) {

            if (n % i == 0) {

                return false;
            }
        }

        return true;
    }


    public void print() {

        for(int i = 0; i < table.length; i++){
            if(table[i] != null && table[i].valid)
                System.out.println(table[i].data);
        }

    }


    public static class Elemento <E> {

        E data;
        boolean valid;

        public Elemento(E data) {

            this.data = data;

            this.valid = true;

        }

    }
}

