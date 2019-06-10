package p08.ex02;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
 
class Company {
    public static User user;
    private List<Employee> emps = new ArrayList<>();
    private Parking companyParking = new Parking();
    private Insurance companyInsurance = new Insurance();


    public void admitPerson(String name, double salary) {
        Employee e = new Employee(name, salary);
        emps.add(e);

        e.addCard(new Card(name));
        System.out.println(e.getCard());

        if(SocialSecurity.regist(e)){
            System.out.println("Employee registered to the Social Security");
        }else{
            System.out.println("Error! Employee already registered to the Social Security");
        }

        if(this.companyInsurance.regist(e)){
            System.out.println("Employee registered to the Company's Insurance");
        }else{
            System.out.println("Error! Employee already registered to the Company's Insurance");
        }

        if(this.companyParking.allow(e)){
            System.out.println("Employee allowed to park\n");
        }else{
            System.out.println("Error! Employee already has parking permissions\n");
        }
    }
    
    
    public void paySalaries(int month) {
        for (Employee e : emps) {
            BankAccount ba = e.getBankAccount();
            ba.deposit(e.getSalary());
        }
    }


    public List<Employee> employees() {
        return Collections.unmodifiableList(emps);
    }
}