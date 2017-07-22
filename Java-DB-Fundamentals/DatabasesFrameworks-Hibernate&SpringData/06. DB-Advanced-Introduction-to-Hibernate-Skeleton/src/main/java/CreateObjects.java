import entities.Address;
import entities.Department;
import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class CreateObjects {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Employee manager = (Employee)entityManager
                .createQuery("SELECT e FROM Employee AS e WHERE e.id = 1")
                .getSingleResult();

        Department training = new Department();
        training.setName("Training");
        training.setManager(manager);

        Town burgas = new Town();
        burgas.setName("Burgas");

        Address addressOne = new Address();
        addressOne.setText("G.M. Dimitrov 12");
        addressOne.setTown(burgas);

        Address addressTwo = new Address();
        addressTwo.setText("Levski 101");
        addressTwo.setTown(burgas);

        Address addressThree = new Address();
        addressThree.setText("Botev 112");
        addressThree.setTown(burgas);

        Address addressFour = new Address();
        addressFour.setText("Gorna reka 41");
        addressFour.setTown(burgas);

        Address addressFive = new Address();
        addressFive.setText("Planinski ruchei 18");
        addressFive.setTown(burgas);

        Employee georgi = new Employee();
        georgi.setFirstName("Georgi");
        georgi.setMiddleName("Georgiev");
        georgi.setLastName("Georgiev");
        georgi.setManager(manager);
        georgi.setAddress(addressOne);
        georgi.setDepartment(training);
        georgi.setJobTitle("Java");
        georgi.setSalary(new BigDecimal(50000));
        Date georgiHireDate = new Date();
        georgi.setHireDate(new Timestamp(georgiHireDate.getTime()));

        Employee milena = new Employee();
        milena.setFirstName("Milena");
        milena.setMiddleName("Stefanova");
        milena.setLastName("Mladenova");
        milena.setManager(manager);
        milena.setAddress(addressTwo);
        milena.setDepartment(training);
        milena.setJobTitle("C#");
        milena.setSalary(new BigDecimal(15000));
        Date milenaHireDate = new Date();
        milena.setHireDate(new Timestamp(milenaHireDate.getTime()));

        Employee doroti = new Employee();
        doroti.setFirstName("Doroti");
        doroti.setMiddleName("Penkova");
        doroti.setLastName("Fanova");
        doroti.setManager(manager);
        doroti.setAddress(addressThree);
        doroti.setDepartment(training);
        doroti.setJobTitle("JavaScript");
        doroti.setSalary(new BigDecimal(5000));
        Date dorotiHireDate = new Date();
        doroti.setHireDate(new Timestamp(dorotiHireDate.getTime()));

        Employee petyr = new Employee();
        petyr.setFirstName("Petyr");
        petyr.setMiddleName("Petrov");
        petyr.setLastName("Petrov");
        petyr.setManager(manager);
        petyr.setAddress(addressOne);
        petyr.setDepartment(training);
        petyr.setJobTitle("JavaScript");
        petyr.setSalary(new BigDecimal(60000));
        Date petyrHireDate = new Date();
        petyr.setHireDate(new Timestamp(petyrHireDate.getTime()));

        Employee ani = new Employee();
        ani.setFirstName("Anna");
        ani.setMiddleName("Petrova");
        ani.setLastName("Gencheva");
        ani.setManager(manager);
        ani.setAddress(addressOne);
        ani.setDepartment(training);
        ani.setJobTitle("Java");
        ani.setSalary(new BigDecimal(50000));
        Date aniHireDate = new Date();
        ani.setHireDate(new Timestamp(aniHireDate.getTime()));

        entityManager.getTransaction().begin();

        entityManager.persist(training);
        entityManager.persist(burgas);
        entityManager.persist(addressOne);
        entityManager.persist(addressTwo);
        entityManager.persist(addressThree);
        entityManager.persist(addressFour);
        entityManager.persist(addressFive);

        entityManager.persist(georgi);
        entityManager.persist(milena);
        entityManager.persist(doroti);
        entityManager.persist(petyr);
        entityManager.persist(ani);

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
