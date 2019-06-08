package p06.ex02;
import java.util.List;

class Contact{
    private int number;
    private String name;

    public Contact(){
        this.number = 0;
        this.name = "";
    }

    public Contact(String name, int number){
        this.name = name;
        this.number = number;
    }

    public void setNumber(int number){
        this.number = number;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getNumber(){
        return this.number;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString(){
        return this.name + " - " + this.number;
    }
}