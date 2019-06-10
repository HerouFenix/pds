package p09.ex03;

class Train extends Transport{

    @Override
    public void travel(TripType type){
        if(!canHandleTravel(type))
            super.travel(type);
        else    
            System.out.println("You'll be traveling " + type + " by train!");
    }

    @Override
    protected boolean canHandleTravel(TripType type){
        if(type != TripType.NATIONAL){
            return false;
        }
        return true;
    }

}