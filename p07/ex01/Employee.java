package p07.ex01;
import java.util.Date;

class Employee implements EmployeeInterface{
    private String name;

    Employee(String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }

    public void start(Date d){
        System.out.println("Employee " + this.name + " started working at: " +d.toString());
    };
    public void terminate(Date d){
        System.out.println("Employee " + this.name + " stopped working at: " +d.toString());
    };
    public void work(){
        System.out.println(this.name + ": Working");
    };
}