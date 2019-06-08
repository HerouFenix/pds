package p05.ex02;

interface LunchBuilder{
    public void buildDrink();
    public void buildMainCourse();
    public void buildSide();
    public Lunch getMeal();
}

class CrastoLunchBuilder implements LunchBuilder{
    private Lunch lunch = new Lunch();

    public void buildDrink(){
        this.lunch.setDrink("Vinho Tinto");
    };

    public void buildMainCourse(){
        this.lunch.setMainCourse("Bacalhau à lagareiro");
    };

    public void buildSide(){
        this.lunch.setSide("Broa");
    };

    public Lunch getMeal(){
        return lunch;
    };
}


class SnackLunchBuilder implements LunchBuilder{
    private Lunch lunch = new Lunch();

    public void buildDrink(){
        this.lunch.setDrink("Sumol");
    };

    public void buildMainCourse(){
        this.lunch.setMainCourse("Panado com Pão");
    };

    public void buildSide(){
        this.lunch.setSide("Rissol");
    };

    public Lunch getMeal(){
        return lunch;
    };
}

class CentralCantineLunchBuilder implements LunchBuilder{
    private Lunch lunch = new Lunch();

    public void buildDrink(){
        this.lunch.setDrink("Água");
    };

    public void buildMainCourse(){
        this.lunch.setMainCourse("Grelhaditos");
    };

    public void buildSide(){
        this.lunch.setSide("Queijo da serra");
    };

    public Lunch getMeal(){
        return lunch;
    };
}