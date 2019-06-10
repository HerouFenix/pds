package p08.ex02;
import java.util.ArrayList;

class Insurance{
    private ArrayList<Person> records;

    Insurance(){
        this.records = new ArrayList<>();
    }

    public boolean regist(Person p){
        if(this.records.contains(p)){
            return false;
        }else{
            this.records.add(p);
            return true;
        }
    }

    public ArrayList<Person> getRecords(){
        return this.records;
    }
}