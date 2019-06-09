package p05.ex03;

//Patterns used:
//  -Builder Pattern (Simplification of person instatiation using a static builder inside the Person class)


class Client{
    public static void main(String[] args) {
        Person p = new Person.Builder("Adolfo", "Dias",true).
            suffix("Sr. Dr. Professor").isEmployed(true).city("Espinho City").build();
    }

}