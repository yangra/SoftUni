import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class EmployeeQueries {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();

        // STEP 1

        List<String> employeesNames = em.createQuery("SELECT e.firstName FROM Employee AS e WHERE e.salary > 50000").getResultList();

        for (String employeeName : employeesNames) {
            System.out.println(employeeName);
        }

        //STEP 2

        List<Employee> employees = em.createQuery("SELECT e FROM Employee AS e WHERE e.department.name = 'Research and Development'" +
                "ORDER BY e.salary, e.firstName DESC").getResultList();

        for (Employee employee : employees) {
            System.out.printf("%s %s from %s - $%.2f\n",
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getDepartment().getName(),
                    employee.getSalary());
        }

        em.close();
        emf.close();
    }
}
