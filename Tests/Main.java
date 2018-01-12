import EDA1.LinHashTable;

public class Main {

    public static void main(String[] args) {

        LinHashTable<Integer> bla = new LinHashTable<>();

        bla.insere(1);
        bla.insere(12);
        bla.insere(23);
        bla.insere(34);
        bla.insere(5);
        bla.insere(0);
        bla.insere(6);
        bla.insere(7);
        bla.insere(11);
        bla.insere(12);

        bla.print();

    }

}
