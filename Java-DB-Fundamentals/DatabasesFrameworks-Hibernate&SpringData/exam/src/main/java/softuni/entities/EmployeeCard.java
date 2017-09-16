package softuni.entities;

import javax.persistence.*;

/**
 * Created by Yana on 8/13/2017.
 */
@Entity
@Table(name="employee_cards")
public class EmployeeCard {
    private Long id;
    private String number;

    private Employee employee;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(nullable = false, unique = true)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @OneToOne(mappedBy = "employeeCard")
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
