package p09.ex03;

class Plane extends Transport{

    @Override
    public void travel(TripType type){
        if(!canHandleTravel(type))
            super.travel(type);
        else    
            System.out.println("You'll be flying " + type +" by plane!");
    }

    @Override
    protected boolean canHandleTravel(TripType type){
        if(type != TripType.INTERCONTINENTAL && type != TripType.INTERNATIONAL){
            return false;
        }
        return true;
    }

}