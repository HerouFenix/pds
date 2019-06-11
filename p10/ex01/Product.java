package p10.ex01;

class Product extends Subject<ProdState>{
    private static int codeCounter = 0;
    private int code;

    private String desc;
    private double basePrice;
    private double currentPrice;

    private long timeInAuction;
    

    Product(String desc, double price){
        this.code = ++codeCounter;
        this.desc = desc;
        this.basePrice = price;
        this.currentPrice = basePrice;

        this.state = ProdState.STOCK;
    }

    public ProdState getState(){
        return this.state;
    }

    public double getPrice(){
        return this.currentPrice;
    }

    public void setPrice(double val){
        this.currentPrice = val;
        notifyObservers();
    }


    protected void notifyObservers(){
        if(this.state == ProdState.AUCTION && this.currentPrice != this.basePrice)
            for (Observer obs : observers){
                obs.updateBid(this);
            }
        else{
            for (Observer obs : observers){
                obs.update(this);
            }
        }
    }

    @Override
    public String toString(){
        return this.desc;
    }
}