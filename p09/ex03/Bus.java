package p09.ex03;

class Bus extends Transport{

    @Override
    public void travel(TripType type){
        if(!canHandleTravel(type))
            super.travel(type);
        else    
            System.out.println("You'll be taking the " + type + " bus!");
    }

    @Override
    protected boolean canHandleTravel(TripType type){
        if(type != TripType.REGIONAL){
            return false;
        }
        return true;
    }

}