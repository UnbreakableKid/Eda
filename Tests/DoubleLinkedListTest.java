import EDA1.DoubleLinkedList;

public class DoubleLinkedListTest
{
    public static void main(String[] args) {
        DoubleLinkedList<String> d = new DoubleLinkedList<>();

        d.add("1");
        d.add("2");
        d.add("3");
        d.add("4");
        d.add("5");
        d.add("6");
        d.add("7");
        d.add("8");
        d.add("9");
        d.add("10");
        d.add(2, "4");

        System.out.println(d.toString());

        d.remove(9);
        d.remove(8);
        d.remove(7);
        d.remove(6);
        d.remove(5);
        d.remove(4);
        d.remove(3);
        d.remove(2);
        d.remove(1);
        d.remove(0);
        d.add(2, "4");
        d.add(0, "5");

        System.out.println(d.toString());

        d.remove("12");
        d.remove(12);
        d.remove("5");
        d.remove("10");

        System.out.println(d.toString());

        System.out.println(d.get(4));

        System.out.println(d.get(d.size()));

        d.set(4, "555");

        System.out.println(d.toString());

        System.out.println();

        for(String s : d)
            System.out.println(s);

    }
}
