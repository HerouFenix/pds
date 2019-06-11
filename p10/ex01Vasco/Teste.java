package ex01Vasco;
//All code in this package made by Vasco - github: BlasphemyCoder
public class Teste {
    public static void main(String[] args) {
        Product p1 = new Product("Produto 1", 10.0);
        Product p2 = new Product("Produto 2", 15.0);
        Product p3 = new Product("Produto 3", 20.0);
        Product p4 = new Product("Produto 4", 25.0);
        Product p5 = new Product("Produto 5", 30.0);

        Client cl1 = new Client("Client 1");
        Client cl2 = new Client("Client 2");
        Client cl3 = new Client("Client 3");

        Gestor gestor = new Gestor("Gestor");

        p1.registerObserver(gestor);
        p2.registerObserver(gestor);
        p3.registerObserver(gestor);
        p4.registerObserver(gestor);
        p5.registerObserver(gestor);

        gestor.startLeilao(p1);
        gestor.startLeilao(p2);

        p1.registerObserver(cl1);

        p2.registerObserver(cl2);
        p2.registerObserver(cl3);

        p3.registerObserver(cl3);
        p3.registerObserver(cl1);

        p4.registerObserver(cl2);

        p5.registerObserver(cl3);


        cl1.bid(p2, 20);
        cl1.bid(p2,10);
    }
}