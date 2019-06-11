package p06.ex01;
import java.util.Vector;
import java.util.List;
import java.util.Collections;

class Database {
    // Data elements
    private Vector<Employee> employees; // Stores the employees
    
    public Database() {
        employees = new Vector<>();
    }

    public boolean addEmployee(Employee employee) {
        //Iterate over all employees to check if that employee already exists
        for (Employee e : this.employees){

            if(e.equals(employee)){
                System.out.println("Error! Employee is already registered!");
                return false;
            }

        }
        this.employees.add(employee);
        return true;
    }

    public void deleteEmployee(long emp_num) {
        //Iterate over all employees and find the one with the specified employee number
        for (Employee employee : this.employees){

            if(employee.getEmpNum() == emp_num){
                this.employees.remove(employee);
                break;
            }

        }
    }

    public List<Employee> getAllEmployees() {
        //return this.employees.toArray(new Employee[this.employees.size()]); NOT SAFE :(
        
        //Note: Unmodifiable list syntax:
        List<Employee> immutablelist = Collections.unmodifiableList(this.employees);
        return immutablelist;
    }
}