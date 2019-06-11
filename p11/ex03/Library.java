package p11.ex03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.reflect.Method;

public class Library {
    private List<Book> books;

    Library(){
        this.books = new ArrayList<>();
    }

    public void addBook(Book b){
        this.books.add(b);
    }

    public void manage() {
        Scanner sc = new Scanner(System.in);
        boolean err = false;
        do {
            System.out.println("*** Library ***");
            for (Book b : books)
                System.out.println(b);
            
            System.out.println(">> <livro>, <operação: (1)regista; (2)requisita; (3)devolve; (4)reserva; (5)cancela \n");
            
            System.out.print(">> ");

            String line = sc.nextLine();

            int bookCode = Integer.parseInt(line.split(",")[0]) - 1;
            int op = Integer.parseInt(line.split(",")[1]);
            
            String operation = "";
            switch (op) {
                case 1:
                    operation = "registBook";
                    break;
                case 2:
                    operation = "requestBook";
                    break;

                case 3:
                    operation = "returnBook";
                    break;

                case 4:
                    operation = "reserveBook";
                    break;

                case 5:
                    operation = "cancelBook";
                    break;
                default:
                    err = true;
                    break;
            }

            if(!err){
                try {
                    //JAVA REFLECTION
                    Method method = Book.class.getMethod(operation,new Class<?>[0]);
                    method.invoke(books.get(bookCode));
                } catch (Exception e) {
                    System.out.println("Operação não disponível!\n");
                }
            }
    
        } while (!err);

        sc.close();
    }
}