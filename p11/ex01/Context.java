package p11.ex01;

import java.util.Comparator;

class Context{
    private Strategy sortStrategy;

    public Context(Strategy strat){
        this.sortStrategy = strat;
    }

    public void setStrategy(Strategy strat){
        this.sortStrategy = strat;
    }

    public void sort(Phone[] phones, Comparator<Phone> comparator){
        this.sortStrategy.sort(phones,comparator);
    }
}