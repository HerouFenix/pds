package p07.ex01;

import java.util.Date;

//Patterns used:
//  -Decorator Pattern (Very basic and trivial)

class Client {
    public static void main(String[] args) {
        EmployeeInterface emp1 = new Employee("DS");
        emp1.start(new Date());
        emp1.work();
        emp1.terminate(new Date());

        System.out.println();

        TeamMember tm1 = new TeamMember(new Employee("Vasco"));
        tm1.start(new Date());
        tm1.colaborate();
        tm1.terminate(new Date());

        System.out.println();

        TeamLeader tl1 = new TeamLeader(new Employee("Mota"));
        tl1.start(new Date());
        tl1.plan();
        tl1.terminate(new Date());

        System.out.println();

        Manager mn1 = new Manager(new Employee("Escaleira"));
        mn1.start(new Date());
        mn1.manage();
        mn1.terminate(new Date());

        System.out.println();

        Manager mn2 = new Manager(new TeamLeader(new TeamMember(emp1)));
        mn2.start(new Date());
        mn2.manage();
        mn2.work();
        mn2.terminate(new Date());
    }
}