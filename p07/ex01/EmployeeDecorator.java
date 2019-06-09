package p07.ex01;
import java.util.Date;

abstract class EmployeeDecorator implements EmployeeInterface{
    private EmployeeInterface employee;

    EmployeeDecorator(EmployeeInterface e){
        this.employee = e;
    }

    public String getName(){
        return this.employee.getName();
    }

    public void start(Date d){
        this.employee.start(d);
    };
    public void terminate(Date d){
        this.employee.terminate(d);
    };
    public void work(){
        this.employee.work();
    };
}