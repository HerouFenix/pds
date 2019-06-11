package ex01Vasco;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private static int counter = 0;
    private int id;
    private String description;
    private double starting_price;
    private double highest_bid;
    private List<Observer> observers;
    private ProductStates state;
    private int auction_time;

    public Product(String descript, double price) {
        counter += 1;
        this.id = counter;
        this.description = descript;
        this.starting_price = price;
        this.highest_bid = price;
        this.observers = new ArrayList<Observer>();
        this.state = ProductStates.STOCK;
    }

    public boolean registerBid(double val, Observer obs) {
        if (this.state == ProductStates.AUCTION) {
            if (val > this.highest_bid) {
                this.highest_bid = val;
                this.observers.add(obs);
                this.notifyObservers("A bid with the value " + val + " was done!");
                return true;
            }
            for (Observer observer : this.observers) {
                if (observer.getType().equals("Gestor"))
                    observer.update("A bid with the value " + val + " was done!");
            }
            return false;
        }

        else
            return false;
    }

    public void registerObserver(Observer obs) {
        if (!(this.observers.contains(obs)))
            this.observers.add(obs);
    }

    public void notifyObservers(String message) {
        for (Observer obs : this.observers) {
            obs.update(message);
        }
    }

    public void notify(Observer obs, String message) {
        obs.update(message);
    }

    public void startAuction(int time) {
        this.state = ProductStates.AUCTION;
        this.auction_time = time;
    }

}