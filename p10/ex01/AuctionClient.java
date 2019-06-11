package p10.ex01;
import java.util.ArrayList;

class AuctionClient extends Observer{
    private String name;

    AuctionClient(String name){
        this.name = name;
        this.auctionProds = new ArrayList<>();
    }

    public void bid(Product p,double val){
        if(!this.auctionProds.contains(p)){
            if(p.getState() == ProdState.AUCTION){
                p.attach(this);
            }else{
                System.out.println("Error! Item is not for auction!");
                return;
            }
        }

        if(val < p.getPrice()){
            System.out.println("Error! You can't place a bid smaller than the current one!");
            return;
        }

        p.setPrice(val);
        
    }

    public void updateBid(Product p){
        System.out.printf("[%s]: A new bid has been placed on: %s\n   Current price:%f\n",this.name,p.toString(),p.getPrice());
    }

    public void update(Product p){
        this.auctionProds.remove(p);
    }
}