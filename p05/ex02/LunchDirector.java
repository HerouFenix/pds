package p05.ex02;

class LunchDirector{
    private LunchBuilder lunchBuilder;

    LunchDirector(LunchBuilder l){
        this.lunchBuilder = l;
    }

    public Lunch getMeal(){
        return this.lunchBuilder.getMeal();
    }

    public void constructMeal(){
        this.lunchBuilder.buildDrink();
        this.lunchBuilder.buildMainCourse();
        this.lunchBuilder.buildSide();

    }
}