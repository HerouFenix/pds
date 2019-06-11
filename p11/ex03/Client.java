package p11.ex03;

//Patterns used:
//  -State
//Other stuff used:
//  -JAVA REFLECTIONS! (Invocation of method at runtime)

public class Client{
    public static void main(String[] args) {

        Library lib = new Library();

        lib.addBook(new Book("Java Anti-Stress", 2018, "Omodionah"));
        lib.addBook(new Book("A Guerra dos Padrões", 2019, "Jorge Omel"));
        lib.addBook(new Book("A Procura da Luz", 2017, "Khumatkli"));

        lib.manage();
    }

}

