package p10.ex01;
import java.util.List;
import java.util.ArrayList;


abstract class Subject<T>{
    protected List<Observer> observers = new ArrayList<>();
    protected T state;
    private long timeInAuction = 0;


    public void attach(Observer o){
        observers.add(o);
    }

    public void setState(T s){
        this.state = s;
        if(this.state == ProdState.AUCTION){
            this.timeInAuction = System.nanoTime(); 
        }else{
            this.timeInAuction = System.nanoTime() - this.timeInAuction;
        }
        notifyObservers();
    };

    protected abstract void notifyObservers();
}