package p08.ex01B;

//Only this class now has access to a bank account
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
    
