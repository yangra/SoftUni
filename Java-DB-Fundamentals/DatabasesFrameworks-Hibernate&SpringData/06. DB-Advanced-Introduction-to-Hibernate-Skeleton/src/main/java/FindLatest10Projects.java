import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


public class FindLatest10Projects {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();

        List<Project> last10Projects = em.createQuery("SELECT p FROM Project AS p " +
                "ORDER BY p.startDate DESC").setMaxResults(10).getResultList();
        for (Project project : last10Projects) {
            System.out.printf("Name: %s, Description: %s, Start date: %s, End date: %s\n",
                    project.getName(),
                    project.getDescription(),
                    project.getStartDate(),
                    project.getEndDate());
        }

        em.close();
        emf.close();

    }
}
