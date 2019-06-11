package p06.ex01;

//Patterns used:
//  -Adapter Pattern (Adapter used to adapt the 2 legacy Database/Employee classes we were given into a single interface)
//Other stuff useD:
//  -IMMUTABLE LIST!!! (unmodifiable)

class Client{
    public static void main(String[] args) {
       
        CompanyAdapter companyStaff = new CompanyAdapter();

        // Sweets Employees
        Employee emp1 = new Employee("Pedro", 123, 1400.50);
        Employee emp2 = new Employee("Vasco", 124, 2000.50);
        companyStaff.addEmployee(emp1);
        companyStaff.addEmployee(emp2);

        //Petiscos Employees
        Empregado petEmp1 = new Empregado("Diogo", "Silva", 1235, 1313.33);
        Empregado petEmp2 = new Empregado("Pedro", "Oliveira", 1234, 2345.99);
        companyStaff.addEmployee(petEmp1);
        companyStaff.addEmployee(petEmp2);

        //New Company
        System.out.println("Current Staff:");
        companyStaff.printAllEmployees();
            
        System.out.println();

        System.out.print("Vasco: ");
        companyStaff.isInCompany(123);

        System.out.print("Pedro Oliveira: ");
        companyStaff.isInCompany(1234);

        System.out.println("\nRemoving employee Vasco:");
        companyStaff.removeEmployee(123);
        System.out.print("Vasco: ");
        companyStaff.isInCompany(123);
    }
}