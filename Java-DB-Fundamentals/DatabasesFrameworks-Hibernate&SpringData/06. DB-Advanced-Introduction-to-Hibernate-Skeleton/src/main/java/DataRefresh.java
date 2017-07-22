import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DataRefresh {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();
        Employee employee = (Employee) em.createQuery("SELECT e FROM Employee AS e WHERE e.id = 4").getSingleResult();

        em.getTransaction().begin();
        employee.setFirstName(employee.getFirstName().toUpperCase());
        em.refresh(employee);
        em.persist(employee);
        em.getTransaction().commit();

        em.close();
        emf.close();


    }
}
