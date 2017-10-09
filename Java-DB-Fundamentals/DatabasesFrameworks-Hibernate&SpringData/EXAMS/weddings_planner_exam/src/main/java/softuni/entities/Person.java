package softuni.entities;

import org.hibernate.validator.constraints.Length;
import softuni.entities.enums.Gender;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "people")
public class Person {
    private long id;
    @Length(min = 1, max = 60)
    @NotNull
    private String firstName;
    @Length(min = 1, max = 1)
    @NotNull
    private String middleNameInitial;
    @Length(min = 2)
    @NotNull
    private String lastName;
    private Gender gender;
    private Date birthDate;

    private String phone;
    @Pattern(regexp = "[a-zA-Z0-9]+@[a-z]+\\.[a-z]+", message = "Invalid email")
    private String email;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "middle_name_initial", nullable = false)
    public String getMiddleNameInitial() {
        return middleNameInitial;
    }

    public void setMiddleNameInitial(String middleNameInitial) {
        this.middleNameInitial = middleNameInitial;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Column(name = "birth_date")
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Basic
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Transient
    public Integer getAge() {
        Date now = new Date();
        long timeBetween = now.getTime() - birthDate.getTime();
        double yearsBetween = timeBetween / 60 * 60 * 60 * 24 * 364.25;
        return (int) Math.floor(yearsBetween);
    }

    @Transient
    public String getFullName() {
        return this.firstName + " " + this.middleNameInitial + " " + this.lastName;
    }

    public void setFullName(String fullName) {
        String[] names = fullName.split("\\s+");
        this.firstName = names[0];
        this.middleNameInitial = names[1];
        this.lastName = names[2];
    }


}
