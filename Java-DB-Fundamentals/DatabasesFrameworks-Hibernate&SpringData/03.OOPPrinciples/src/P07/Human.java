package P07;


public abstract class Human {
    private String firstName;
    private String lastName;

    Human(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    String getFirstName() {
        return firstName;
    }

    private void setFirstName(String firstName) {
        if (!firstName.matches("(^[A-Z]).+")){
            throw new IllegalArgumentException("Expected upper case letter!Argument: firstName");
        }else if (firstName.length()<4) {
            throw new IllegalArgumentException("Expected length at least 4 symbols!Argument: firstName");
        }else {
            this.firstName = firstName;
        }
    }

    String getLastName() {
        return lastName;
    }

    protected void setLastName(String lastName) {
        if (!lastName.matches("(^[A-Z]).+")){
            throw new IllegalArgumentException("Expected upper case letter!Argument: lastName");
        }else  if (lastName.length()<3){
            throw new IllegalArgumentException("Expected length at least 3 symbols!Argument: lastName");
        }else{
            this.lastName = lastName;
        }
    }
}
