package p08.ex02;

class Person {
    private String name;
    private BankAccount bankAccount;
    
    public Person(String n) {
        name = n;
        bankAccount = new BankAccountImpl("PeDeMeia", 0);
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
    private Card empCard;

    public Employee(String n, double s) {
        super(n);
        salary = s;
        this.empCard = null;
    }
    
    public void addCard(Card c) {
        this.empCard = c;
    }
    
    public double getSalary() {
        return salary;
    }

    public String getCard() {
        return this.empCard.getCard();
    }
}