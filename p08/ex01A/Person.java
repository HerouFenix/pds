package p08.ex01A;

class Person {
    private String name;
    private BankAccount bankAccount;
    
    public Person(String n) {
        name = n;
        bankAccount = new BankAccountProxy("PeDeMeia", 0);
    }
    
    
    public String getName() {
        return name;
    }


    public BankAccount getBankAccount() {
        return bankAccount;
    }
}
    
class Employee extends Person {
    private double salary;
    
    public Employee(String n, double s) {
        super(n);
        salary = s;
    }
    
    
    public double getSalary() {
        return salary;
    }
}