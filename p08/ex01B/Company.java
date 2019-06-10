package p08.ex01B;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
 
class Company {
    public static User user;
    private List<Employee> emps = new ArrayList<>();


    //Changed the way this function works
    public void admitEmployee(Person person, double salary) {
        emps.add(new Employee(person, salary));
    }
    
    
    public void paySalaries(int month) {
        for (Employee e : emps) {
            BankAccount ba = e.getPerson().getBankAccount();
            ba.deposit(e.getSalary());
        }
    }


    public List<Employee> employees() {
        return Collections.unmodifiableList(emps);
    }
}