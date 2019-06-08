package p05.ex01;

//A beverage factory class
class BeverageFactory{

    //Standard factory method that returns a beverage depending on the temperature specified
    public static Beverage createBeverage(Temperature t){
        switch (t){
            case Cold:
                return new FruitJuice("Orange");
            case Warm:
                return new Milk();
            default:
                System.out.println("Error! Unknown Temperature enum declared!");
                System.exit(1); 
        }
        
        return null;
    }
}