package p08.ex01A;
import java.util.List;

//Patterns used:
//  -Proxy Pattern (Access/Security control (Don't allow Company to withdraw/balance employee's bank account))
//      (Proxy was implemented in the BankAccount.java file) (Person now has a BankAccountProxy rather than BankAccountImpl)

public class Client {
    
    public static void main(String[] args) {
        Company shark = new Company();
        Company.user = User.COMPANY;
        
        shark.admitPerson("Maria Silva", 1000);
        shark.admitPerson("Manuel Pereira", 900);
        shark.admitPerson("Aurora Machado", 1200);
        shark.admitPerson("Augusto Lima", 1100);
    
        List<Employee> sharkEmps = shark.employees();
    
        System.out.println("#########COMPANY ACCESS#########");

        System.out.println("\nBALANCE:");
        for (Employee e : sharkEmps)
        // "talking to strangers", but this is not a normal case
            if(Double.isNaN(e.getBankAccount().balance()))
                System.out.println("Error! You don't have permission to check this account's balance!");
            else
                System.out.println(e.getBankAccount().balance());
        
        shark.paySalaries(1);

        System.out.println("\nWITHDRAW:");
        for (Employee e : sharkEmps) {
            if(e.getBankAccount().withdraw(500))
                System.out.println(e.getBankAccount().balance());
            else
                System.out.println("Error! You don't have permission to withdraw from this account!");
        }

        System.out.println("\n#########USER ACCESS#########");

        Company.user = User.OWNER;

        System.out.println("\nBALANCE:");
        for (Employee e : sharkEmps)
        // "talking to strangers", but this is not a normal case
            if(Double.isNaN(e.getBankAccount().balance()))
                System.out.println("Error! You don't have permission to check this account's balance!");
            else
                System.out.println(e.getBankAccount().balance());
        
        shark.paySalaries(1);

        System.out.println("\nWITHDRAW:");
        for (Employee e : sharkEmps) {
            if(e.getBankAccount().withdraw(500))
                System.out.println(e.getBankAccount().balance());
            else
                System.out.println("Error! You don't have permission to withdraw from this account!");
        }
    }
}