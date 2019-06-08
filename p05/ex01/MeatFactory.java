package p05.ex01;

//A beverage factory class
class MeatFactory{

    //Standard factory method that returns a beverage depending on the temperature specified
    public static Meat createMeat(Temperature t){
        switch (t){
            case Cold:
                return new Tuna();

            case Warm:
                return new Pork();

            default:
                System.out.println("Error! Unknown Temperature enum declared!");
                System.exit(1);     
        }

        return null;
    }
}