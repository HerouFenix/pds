package p05.ex01;

abstract class Meat implements Commodity{
    private State state = State.Solid;
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

class Tuna extends Meat{

    Tuna(){
        super();
        setTemperature(Temperature.Cold);
    }

    @Override
    public String toString(){
        return "[commodity=Tuna" + "[Temperatura()=" + this.getTemperature() + ", State()=" + this.getState() + "]]";
    }
}

class Pork extends Meat{
    private Temperature temp;

    Pork(){
        super();
        setTemperature(Temperature.Warm);
    }

    @Override
    public String toString(){
        return "[commodity=Pork" + "[Temperatura()=" + this.getTemperature() + ", State()=" + this.getState() + "]]";
    }
}