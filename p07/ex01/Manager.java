package p07.ex01;

class Manager extends EmployeeDecorator{
    Manager(EmployeeInterface e){
        super(e);
    }
   
    
    public void manage(){
        System.out.println(super.getName()+": Managing work");
    }
}