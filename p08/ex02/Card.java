package p08.ex02;

class Card{
    private String empName;
    private int empID;


    private static int currentID = 0;

    Card(String name){
        this.empName = name;
        this.empID = currentID;
        currentID++;
    }

    public String getCard(){
        return "Name: " + this.empName + "\nID #: " + this.empID;
    }
}