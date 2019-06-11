package p10.ex01;

//Patterns used:
//  -Observer
//Nota:
//  -I'm not too too sure whether or not the patter was correctly implemented. For a different version, check ex01VascoVersion (made by Vasco - github: BlasphemyCoder)


public class Client {
    public static void main(String[] args) {
        Product p1 = new Product("Produto 1", 10.0);
        Product p2 = new Product("Produto 2", 15.0);
        Product p3 = new Product("Produto 3", 20.0);
        Product p4 = new Product("Produto 4", 25.0);
        Product p5 = new Product("Produto 5", 30.0);


        AuctionClient cl1 = new AuctionClient("Client 1");
        AuctionClient cl2 = new AuctionClient("Client 2");
        AuctionClient cl3 = new AuctionClient("Client 3");

        Manager mg = new Manager("Manager 1");
        mg.attatch(p1);
        mg.attatch(p2);
        mg.attatch(p3);
        mg.attatch(p4);
        mg.attatch(p5);

        p2.setState(ProdState.AUCTION);
        p1.setState(ProdState.AUCTION);

        cl1.bid(p2, 20.3);
        System.out.println("");
        cl1.bid(p1, 25);
        System.out.println("");


        p3.setState(ProdState.AUCTION);

        cl2.bid(p2,22);
        System.out.println("");

        cl1.bid(p2,30);
        System.out.println("");

        cl3.bid(p3,420);
        System.out.println("");

        p2.setState(ProdState.SALES);
        cl2.bid(p2,22);

    }
}