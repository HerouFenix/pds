package p10.ex01;
import java.util.List;
import java.util.ArrayList;

class Manager extends Observer{
    private String name;
    protected List<Subject<ProdState>> soldProds;
    protected List<Subject<ProdState>> stockProds;

    Manager(String name){
        this.name = name;

        this.auctionProds = new ArrayList<>();
        this.soldProds = new ArrayList<>();
        this.stockProds = new ArrayList<>();
    }

    public void attatch(Product p){
        switch(p.getState()){
            case SALES:
                soldProds.add(p);
                break;
            case AUCTION:
                auctionProds.add(p);
                break;

            case STOCK:
                auctionProds.add(p);
                break;
        }

        p.attach(this);
    }

    public void updateBid(Product p){
        System.out.printf("[%s]:A new bid has been placed on: %s\n   Current price: %f\n",this.name,p.toString(),p.getPrice());
    }

    public void update(Product p){
        switch(p.getState()){
            case SALES:
            
                auctionProds.remove(p);
                stockProds.remove(p);

                soldProds.add(p);
                System.out.printf("[%s]:Product: %s\n   Has been sold for:%f\n",this.name,p.toString(),p.getPrice());
                break;
            case AUCTION:
                stockProds.remove(p);
                soldProds.remove(p);

                auctionProds.add(p);
                break;

            case STOCK:
                auctionProds.remove(p);
                soldProds.remove(p);

                stockProds.add(p);
                break;
        }
        
    }
}

