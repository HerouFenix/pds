package ex01Vasco;

public class Client implements Observer {
    private String name;

    public Client(String name) {
        this.name = name;
    }

    public boolean bid(Product prod, double bid_value) {
        return prod.registerBid(bid_value, this);
    }

    public void update(String message) {
        System.out.printf("%s: %s\n", this.name, message);
    }

    public String getType() {
        return "Client";
    }

}