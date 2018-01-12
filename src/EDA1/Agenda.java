package EDA1;

import java.util.Scanner;

public class Agenda {

    private ArvVL <Contact> contacts;
    private boolean running;
    private Scanner s;

    public static void main(String[] args) {
        Agenda a = new Agenda();
        a.start();
    }

    public Agenda() {
        contacts = new ArvVL<Contact>();
        running = true;
        s = new Scanner(System.in);

    }

    public void start(){
        while(running){
            System.out.println("What to do?");
            printMenu();
            int res = chooseANumber();
            handleInput(res);
        }
    }

    private void handleInput(int response) {
        if (response == 0)
            running = false;
        else if (response == 1) {
            addContact();
        }else if (response == 2) {
            listAll();
        }else if (response == 3) {
            edit();
        }else if (response == 4) {
            if(!contacts.isEmpty()) {
                System.out.println("Que número é para procurar?");
                int num = chooseANumber();
                System.out.println(findContact(num));
            }
        }else if (response == 5) {
            System.out.println(export().toString());
        }else if (response == 6) {
            if(!contacts.isEmpty()) {
                System.out.println("Qual(index)?");
                int i = chooseANumber();
                remove(i);
            }
        }
    }

    private int chooseANumber(){
        int num;
        while(true) {
            try {
                num = Integer.valueOf(s.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("NÃO É NÚMERO");
            }
        }
        return num;
    }

    private void addContact(){
        System.out.println("Nome? ");
        String name = s.nextLine();
        System.out.println("Número? ");
        int nu = chooseANumber();
        addContact(name, nu);
    }

    private void edit(){

        if(!contacts.isEmpty()) {

            listAll();
            System.out.println("Qual mudar? (index)");

            int i = chooseANumber();

            System.out.println("Que mudar? \n" +
                    "(1) - Nome? \n" +
                    "(2) - Número?");

            int r = chooseANumber();
            if (r == 1) {
                System.out.println("Novo nome?");
                String res = s.nextLine();
                editContact(i, res);
            }
            if (r == 2) {
                System.out.println("Novo numero?");
                int num = chooseANumber();
                editContact(i, num);
            }
        }
    }

    private void printMenu(){
        System.out.println("" +
                "(1) - Adicionar Contacto\n" +
                "(2) - Listar Contactos\n" +
                "(3) - Editar Contacto\n" +
                "(4) - Procurar Telefone\n" +
                "(5) - Exportar para Queue\n" +
                "(6) - Remover Contacto\n" +
                "(0) - Sair");
    }

    ///// LOGIC


    public void addContact(String name, int number){
        Contact c = new Contact(name, number);
        contacts.insere(c);
    }
    
    public void listAll(){
        contacts.printEmOrdem();
    }

    public Contact findContact(int number){
        for (Contact c: contacts){
            if(c.hasNumber(number))
                return c;
        }
        return null;
    }

    public void editContact(int index, int number) {
        int i = 0;
        Contact original = null;
        for (Contact c: contacts) {
            if(i == index)
                original = c;
            i++;
        }
        if(original != null){
            Contact c = new Contact(original.name, number);
            contacts.remove(original);
            contacts.insere(c);
        }
    }

    public void editContact(int index, String name) {
        int i = 0;
        Contact original = null;
        for (Contact c: contacts) {
            if(i == index)
                original = c;
            i++;
        }
        if(original != null){
            Contact c = new Contact(name, original.number);
            contacts.remove(original);
            contacts.insere(c);
        }
    }

    public void remove(int index){
        int i = 0;
        Contact found = null;
        for (Contact c: contacts) {
            if(i == index)
                found = c;
            i++;
        }
        if(found != null){
            contacts.remove(found);
        }
    }

    public Queue<Contact> export(){
        ArrayQueue<Contact> q = new ArrayQueue<>();
        for (Contact c: contacts) {
            q.enqueue(c);
        }
        return q;
    }
    
    private static class Contact implements Comparable<Contact>{
        
        String name;
        int number;
        
        Contact(String _name, int _number){
            name = _name;
            number = _number;
        }
        
        boolean hasNumber(int _number){
            return number == _number;
        }

        @Override
        public int compareTo(Contact o) {
            int r = name.compareTo(o.name);
            if(r == 0){
                r = Integer.compare(number, o.number);
            }
            return r;
        }

        @Override
        public String toString() {
            return name + ": " + number;
        }
    }
}
