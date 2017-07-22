import entities.Department;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import java.util.List;


public class ConcurrentDatabaseChangesWithEntityManager {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
//        EntityManager em1 = emf.createEntityManager();
//        EntityManager em2 = emf.createEntityManager();
//
//        em1.getTransaction().begin();
//
//        List<Department> departments = em1.createQuery("SELECT d FROM Department AS d " +
//                "WHERE CHAR_LENGTH(d.name) > 20").getResultList();
//        for (Department department : departments) {
//            department.setName(department.getName().toUpperCase());
//            //em1.lock(department, LockModeType.PESSIMISTIC_WRITE);
//            em1.persist(department);
//        }
//
//        em2.getTransaction().begin();
//        List<Department> dpts = em1.createQuery("SELECT d FROM Department AS d " +
//                "WHERE CHAR_LENGTH(d.name) > 20").getResultList();
//        for (Department dpt : dpts) {
//            dpt.setName(dpt.getName().toUpperCase());
//            //em2.lock(dpt,LockModeType.PESSIMISTIC_WRITE);
//            em2.persist(dpt);
//        }
//
//        em1.getTransaction().commit();
//        em2.getTransaction().commit();
//
//        em1.close();
//        em2.close();
//        emf.close();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em1 = emf.createEntityManager();
        EntityManager em2 = emf.createEntityManager();

        em1.getTransaction().begin();
        Employee employeeEm1 = em1.find(Employee.class, 1);
        employeeEm1.setFirstName("Nasko");

        em2.getTransaction().begin();
        Employee employeeEm2 = em2.find(Employee.class, 1);
        employeeEm2.setFirstName("Ico");

//        em1.lock(employeeEm1, LockModeType.PESSIMISTIC_WRITE);
//        em2.lock(employeeEm2, LockModeType.PESSIMISTIC_WRITE);

        em1.getTransaction().commit();
        em2.getTransaction().commit();

        em1.close();
        em2.close();
        emf.close();
    }
}
