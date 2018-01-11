public interface IHash<E> {


    public int ocupados();

    public float factorCarga();

    public void alocarTabela(int dim);

    public void tornarVazia();

    public E procurar(E x);

    public void remove(E x);

    public void insere (E x);

    public void rehash();

    public void print();

    public abstract int procPos(E s);
}

