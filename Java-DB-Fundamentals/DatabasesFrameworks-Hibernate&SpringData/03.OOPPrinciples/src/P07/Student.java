package P07;


/**
 * Created by Yana on 7/5/2017.
 */
public class Student extends Human {
    private String facultyNum;

    Student(String firstName, String lastName, String facultyNum) {
        super(firstName, lastName);
        this.setFacultyNum(facultyNum);
    }

    String getFacultyNum() {
        return facultyNum;
    }

    private void setFacultyNum(String facultyNum) {
        if (facultyNum.matches("\\d{5,10}")){
            this.facultyNum = facultyNum;
        }else {
            throw new IllegalArgumentException("Invalid faculty number!");
        }

    }

    @Override
    public String toString() {
        return String.format("First Name: %s\n" +
                        "Last Name: %s\n" +
                        "Faculty number: %s\n",
                this.getFirstName(),
                this.getLastName(),
                this.getFacultyNum());
    }
}
