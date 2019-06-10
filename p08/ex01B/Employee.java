package p08.ex01B;

class Employee {
    private double salary;
    private Person person; //Added composition, removed inheritance
    
    public Employee(Person person, double s) {
        this.person = person;
        salary = s;
    }
    
    
    public double getSalary() {
        return salary;
    }

    public Person getPerson() {
        return this.person;
    }
}