package _04WorkForce.models.employees;

public class StandardEmployee extends BaseEmployee {


    public static final int WORK_HOURS_PER_WEEK = 40;

    public StandardEmployee(String name) {
        super(name, WORK_HOURS_PER_WEEK);
    }
}
