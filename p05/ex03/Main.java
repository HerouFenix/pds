package p05.ex03;

class Main{
    public static void main(String[] args) {
        Person p = new Person.Builder("Adolfo", "Dias",true).
            suffix("Sr. Dr. Professor").isEmployed(true).city("Espinho City").build();
    }

}