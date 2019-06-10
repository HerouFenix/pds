package p08.ex01A;

interface BankAccount {
    void deposit(double amount);
    boolean withdraw(double amount);
    double balance();
}
    
class BankAccountImpl implements BankAccount {
    private String bank;
    private double balance;
    
    BankAccountImpl(String bank, double initialDeposit) {
        this.bank = bank;
        balance = initialDeposit;
    }
    
    
    public String getBank() {
        return bank;
    }

    @Override public void deposit(double amount) {
        balance += amount;
    }


    @Override public boolean withdraw(double amount) {
        if (amount > balance )
            return false;
        balance -= amount;
        return true;
    }
    
    
    @Override public double balance() {
        return balance;
    }
}

//The proxy class (extends BankAccount and has a BankAccountImpl object)
class BankAccountProxy implements BankAccount {
    private BankAccountImpl actualBankAccount;

    BankAccountProxy(String bank, double initialDeposit) {
        this.actualBankAccount = new BankAccountImpl(bank, initialDeposit);
    }
    
    
    public String getBank() {
        return this.actualBankAccount.getBank();
    }

    @Override public void deposit(double amount) {
        this.actualBankAccount.deposit(amount);
    }


    //The 2 functions we want to limit access to://

    @Override public boolean withdraw(double amount) {
        if (Company.user == User.OWNER) //Check if the Company's accessing or the owner
            return this.actualBankAccount.withdraw(amount);
        else
            return false;
    }
    
    
    @Override public double balance() {
        if (Company.user == User.OWNER) //Check if the Company's accessing or the owner
            return this.actualBankAccount.balance();
        else{
            return Double.NaN;
        }
    }
}