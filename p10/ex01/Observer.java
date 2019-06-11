package p10.ex01;
import java.util.List;

abstract class Observer{
    protected List<Subject<ProdState>> auctionProds;
    public abstract void update(Product p);
    public abstract void updateBid(Product p);

}

