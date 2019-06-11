package p10.ex02;

abstract class Employee {
    protected String name;
    public abstract String getName();
}

class Programmer extends Employee {
    public Programmer(String name) {
        this.name = name;
    }
    
    @Override
    public String getName() {
        return name;
    }
}

class NullProgrammer extends Employee {
    public NullProgrammer(String name) {
        this.name = name;
    }
    
    @Override
    public String getName() {
        return "There aren't any " + this.name + " programmers!";
    }
}