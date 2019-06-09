package p07.ex01;
import java.util.Date;

interface EmployeeInterface{
    void start(Date d);
    void terminate(Date d);
    void work();

    String getName();
}