public abstract class HashTable<E> implements IHash<E> {

    int Size = 11;
    int ocupado = 0;

    Elemento<E>[] table;

    public HashTable() {

        table = new Elemento[Size];

    }


    public HashTable(int n) {

        table = new Elemento[n];

        this.Size = n;

    }

    public int ocupados() {

        return ocupado;

    }

    public float factorCarga() {

        return ocupado / Size;
    }

    int hash(int hashCode) {

        return hashCode % Size;
    }

    public abstract int procPos(E s);


    public void alocarTabela(int dim) {

        Elemento[] table2;
        table2 = new Elemento[dim];

        this.Size = dim;

    }

    public void tornarVazia() {

        table = new Elemento[Size];

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

        table[procPos(x)].data = x;

        if (factorCarga() > 0.5) {
            rehash();
        }
    }

    public void rehash() {

        int now = Size * 2 + 1;
        int oldN = Size;

        do {

            now++;

        }

        while (!isPrime(now));
        {

            Elemento<E>[] old = table;

            alocarTabela(now);

            for (int i = 0; i < oldN; i++) {

                Elemento<E> ele = old[i];

                if (ele != null) {

                    insere(ele.data);
                }
            }
        }
    }

    public boolean isPrime(int n) {

        for (int i = 2; i <= n / 2; i++) {

            if (n % i == 0) {

                return false;
            }
        }

        return true;
    }


    @Override
    public void print() {

        for(int i = 0; i < table.length; i++){
            if(table[i] != null && table[i].valid)
                System.out.println(table[i].data);
        }

    }
}

