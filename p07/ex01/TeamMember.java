package p07.ex01;

class TeamMember extends EmployeeDecorator{
    TeamMember(EmployeeInterface e){
        super(e);
    }
    
    public void colaborate(){
        System.out.println(super.getName()+": Helping with work");
    }
}