import entities.Address;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class AddingNewAddressAndUpdatingEmployee {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Address address = new Address();
        address.setText("Vitoshka 15");
        em.persist(address);

        Employee employee = null;
        employee = (Employee)em.createQuery("SELECT e FROM Employee AS e WHERE e.lastName = 'Nakov'").getSingleResult();
        employee.setAddress(address);
        em.persist(employee);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
