package p08.ex02;
import java.util.ArrayList;

class Parking{
    private ArrayList<Person> allowed;

    Parking(){
        this.allowed = new ArrayList<>();
    }

    public boolean allow(Person p){
        if(this.allowed.contains(p)){
            return false;
        }else{
            this.allowed.add(p);
            return true;
        }
    }

    public ArrayList<Person> getAllowed(){
        return this.allowed;
    }
}