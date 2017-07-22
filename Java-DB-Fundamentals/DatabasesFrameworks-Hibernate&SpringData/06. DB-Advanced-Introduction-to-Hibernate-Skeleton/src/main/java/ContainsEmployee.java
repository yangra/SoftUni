import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ContainsEmployee {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] name = reader.readLine().split("\\s");
        String firstName = name[0];
        String lastName = name[1];

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();

        Query selectEmployee = em.createQuery("SELECT e FROM Employee AS e WHERE e.firstName = :firstName AND e.lastName = :lastName");
        selectEmployee.setParameter("firstName", firstName);
        selectEmployee.setParameter("lastName", lastName);

        if (selectEmployee.getResultList().size() > 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        em.close();
        emf.close();
    }
}
