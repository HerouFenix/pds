package p08.ex02;
import java.util.ArrayList;

class SocialSecurity{
    private static ArrayList<Person> records = new ArrayList<>();

    public static boolean regist(Person p){
        if(records.contains(p)){
            return false;
        }else{
            records.add(p);
            return true;
        }
    }

    public ArrayList<Person> getRecords(){
        return records;
    }
}