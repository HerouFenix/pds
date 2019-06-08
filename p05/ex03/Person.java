package p05.ex03;

public class Person
{
    //Obligatory
    private final String lastName;
    private final String firstName;
    private final boolean isFemale;

    //Optional
    private final String middleName;
    private final String salutation;
    private final String suffix;
    private final String streetAddress;
    private final String city;
    private final String state;
    private final boolean isEmployed;
    private final boolean isHomewOwner;

    //Instead of using an overly complicated builder, we just use this builder instead (See main to check how to instantiate person)
    public static class Builder{
        //Obligatory Fields
        private String lastName;
        private String firstName;
        private boolean isFemale;

        //Optional Fields
        private String middleName = "";
        private String salutation = "";
        private String suffix = "";
        private String streetAddress = "";
        private String city = "";
        private String state = "";
        private boolean isEmployed = false;
        private boolean isHomewOwner = false;

        public Builder(String firstName, String lastName, boolean isFemale) {
            this.lastName = lastName;
            this.firstName = firstName;
            this.isFemale = isFemale;
        }

        public Builder middleName(String val){
            this.middleName = val;
            return this;
        }

        public Builder salutation(String val){
            this.salutation = val;
            return this;
        }

        public Builder suffix(String val){
            this.suffix = val;
            return this;
        }

        public Builder streetAddress(String val){
            this.streetAddress = val;
            return this;
        }

        public Builder city(String val){
            this.city = val;
            return this;
        }

        public Builder state(String val){
            this.state = val;
            return this;
        }

        public Builder isEmployed(boolean val){
            this.isEmployed = val;
            return this;
        }

        public Builder isHomewOwner(boolean val){
            this.isHomewOwner = val;
            return this;
        }

        //Actually calls the Person Builder!
        public Person build() {
            return new Person(this);
        }
    }

    private Person(Builder builder){
        this.lastName = builder.lastName;
        this.firstName = builder.firstName;
        this.middleName = builder.middleName;
        this.salutation = builder.salutation;
        this.suffix = builder.suffix;
        this.streetAddress = builder.streetAddress;
        this.city = builder.city;
        this.state = builder.state;
        this.isFemale = builder.isFemale;
        this.isEmployed = builder.isEmployed;
        this.isHomewOwner = builder.isHomewOwner;
    }
}