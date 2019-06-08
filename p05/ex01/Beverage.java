package p05.ex01;

abstract class Beverage implements Commodity{
    private State state = State.Liquid;
    private Temperature temp;
    
    public void setTemperature(Temperature t){
        this.temp = t;
    }

    public State getState(){
        return this.state;
    }
    public Temperature getTemperature(){
        return this.temp;
    }

    public String toString(){
        return "";
    }
}

class Milk extends Beverage{

    Milk(){
        super();
        this.setTemperature(Temperature.Warm);
    }

    @Override
    public String toString(){
        return "[commodity=Milk" + "[Temperatura()=" + this.getTemperature() + ", State()=" + this.getState() + "]]";
    }
}

class FruitJuice extends Beverage{
    private String fruitName;

    FruitJuice(String fruitName){
        super();
        this.setTemperature(Temperature.Cold);
        this.fruitName = fruitName;
    }

    @Override
    public String toString(){
        return "[commodity=Pork [fruit="+ this.fruitName + " Temperatura()=" + this.getTemperature() + ", State()=" + this.getState() + "]]";
    }
}