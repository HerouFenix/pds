package p05.ex02;

class Lunch{
    private String drink;
    private String mainCourse;
    private String side;

    public void setDrink(String d){
        this.drink = d;
    };

    public void setMainCourse(String m){
        this.mainCourse = m;
    };

    public void setSide(String s){
        this.side = s;
    };

    @Override
    public String toString(){
        String meal = "[ drink: " + this.drink + 
                        ", main course: " + this.mainCourse + 
                        ", side: " + this.side + 
                        " ]";
        return meal;
    };
}