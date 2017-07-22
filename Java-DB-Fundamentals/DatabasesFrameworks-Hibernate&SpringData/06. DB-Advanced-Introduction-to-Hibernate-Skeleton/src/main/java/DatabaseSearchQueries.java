import entities.Address;
import entities.Department;
import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DatabaseSearchQueries {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();

        //PART 1
        List<Address> addressList = em.createQuery("SELECT a FROM Address AS a " +
                "ORDER BY a.employees.size DESC, a.town.name").setMaxResults(10).getResultList();

        for (Address address : addressList) {
            System.out.printf("%s, %s - %d employees\n",
                    address.getText(),
                    address.getTown().getName(),
                    address.getEmployees().size());
        }

        //PART 2
        Employee employee = (Employee)em.createQuery("SELECT e FROM Employee AS e WHERE e.id = 147")
                .getSingleResult();

        System.out.printf("%s %s  - %s\n",
                employee.getFirstName(),
                employee.getLastName(),
                employee.getJobTitle());
        Set<Project> employeeProjects = employee.getProjects();
        List<Project> projects = employeeProjects.stream()
                .sorted((a,b)->a.getName().compareTo(b.getName()))
                .collect(Collectors.toList());
        for (Project project : projects) {
            System.out.printf("--- %s\n", project.getName());
        }

        //PART 3
        List<Integer> projectIds = em.createQuery("SELECT p.id FROM Project  AS p " +
                "WHERE YEAR(p.startDate) BETWEEN 2001 AND 2003").getResultList();


        Query employeesQuery = em.createQuery("SELECT e FROM Employee AS e " +
                "INNER JOIN e.projects AS p WHERE p.id IN (:ids) ");

        employeesQuery.setParameter("ids",projectIds);

        List<Employee> employees = employeesQuery.getResultList();

        for (Employee e : employees) {
            System.out.printf("%s %s - Manager: %s\n",
                    e.getFirstName(),
                    e.getLastName(),
                    e.getManager().getFirstName()+ " " + e.getManager().getLastName());
            for (Project project : e.getProjects()) {
                System.out.printf("---Name: %s,  Start date: %s, End date: %s\n",
                        project.getName(),
                        project.getStartDate(),
                        project.getEndDate());
            }
        }

        //PART 4
        List<Department> departments = em.createQuery("SELECT d FROM Department AS d WHERE d.employees.size > 5" +
                "ORDER BY d.employees.size ASC").getResultList();

        for (Department department : departments) {
            System.out.printf("%s Manager: %s\n",
                    department.getName(),
                    department.getManager().getFirstName() + " " + department.getManager().getLastName());
            for (Employee emp :department.getEmployees()){
                System.out.printf("--- %s %s, Hire date: %s, Job title: %s\n",
                        emp.getFirstName(),
                        emp.getLastName(),
                        emp.getHireDate(),
                        emp.getJobTitle());
            }
        }

        em.close();
        emf.close();
    }
}
