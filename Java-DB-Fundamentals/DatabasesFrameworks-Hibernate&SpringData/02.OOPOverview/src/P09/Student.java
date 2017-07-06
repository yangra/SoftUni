package P09;


public class Student {
    public static int studentCount = 0;
    private String name;


    public Student(String name){
       this.setName(name);
       studentCount++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
