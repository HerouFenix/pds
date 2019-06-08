package p05.ex01;

//A beverage factory class
class ContainerFactory{

    //Standard factory method that returns a beverage depending on the temperature specified
    public static Container createContainerFor(Commodity c){
        switch (c.getState()){
            case Liquid:
                switch (c.getTemperature()){
                    case Cold:
                        return new PlasticBottle();

                    default:
                        return new TermicBottle();

                }
            
            case Solid:
                switch (c.getTemperature()){
                    case Cold:
                        return new PlasticBag();
                    
                    default:
                        return new Tupperware();
                }
            
            default:
                System.out.println("Error! Unknown State enum declared!");
                System.exit(1);     
        }
        
        return null;
    }
}