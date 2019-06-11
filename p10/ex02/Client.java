package p10.ex02;

//Patterns used:
//  -Null Object
//  -Factory (code given by teacher)


public class Client {
    public static void main(String[] args) {
        Employee emp = EmployeeFactory. getCustomer ("Mac");
        Employee emp2 = EmployeeFactory. getCustomer ("Janela");
        Employee emp3 = EmployeeFactory. getCustomer ("Linux");
        Employee emp4 = EmployeeFactory. getCustomer ("Mack");

        System.out.println(emp.getName());
        System.out.println(emp2.getName());
        System.out.println(emp3.getName());
        System.out.println(emp4.getName());
    }
}