package p09.ex03;

abstract class Transport{
    protected Transport successor = null;

    public void travel(TripType type){
        if(successor != null)
            this.successor.travel(type);
        else    
            System.out.println("No transports available for " + type + " travel! Sorry :(");
    }

    protected boolean canHandleTravel(TripType type){
        return false;
    }

    public Transport setSuccessor(Transport succ){
    this.successor = succ;
        return this;
    }
}