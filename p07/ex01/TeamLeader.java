package p07.ex01;

class TeamLeader extends EmployeeDecorator{
    TeamLeader(EmployeeInterface e){
        super(e);
    }
   
    public void plan(){
        System.out.println(super.getName()+": Planning work");
    }
}