import entities.Address;
import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class RemoveTowns {
    public static void main(String[] args) throws IOException {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
//        EntityManager em = emf.createEntityManager();
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String townName = reader.readLine();
//
//        Query addressQuery = em.createQuery("SELECT a FROM Address AS a WHERE a.town.name = :townName");
//        addressQuery.setParameter("townName", townName);
//        List<Address> addresses = addressQuery.getResultList();
//        if (addresses.size() > 0) {
//            em.getTransaction().begin();
//            Town town = addresses.get(0).getTown();
//            for (Address address : addresses) {
//                for (Employee employee : address.getEmployees()) {
//                    employee.setAddress(null);
//                }
//                em.flush();
//                em.remove(address);
//            }
//            em.remove(town);
//            em.getTransaction().commit();
//
//            if (addresses.size()==1){
//                System.out.printf("1 address in %s was deleted\n", townName);
//            }else{
//                System.out.printf("%d addresses in %s were deleted", addresses.size(),townName);
//            }
//
//        } else {
//            System.out.println("There are no addresses from this town in the database!");
//            Query townQuery = em.createQuery("SELECT t FROM Town AS t WHERE t.name = :townName");
//            townQuery.setParameter("townName", townName);
//            List<Town> town = townQuery.getResultList();
//            if(town.size()>0) {
//                em.getTransaction().begin();
//                em.remove(town);
//                em.getTransaction().commit();
//            }else {
//                System.out.println("There is no such town in the database!");
//            }
//        }
//
//        em.close();
//        emf.close();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String townName = bufferedReader.readLine();

        int countRemoveAddress = 0;
        em.getTransaction().begin();
        try {
            Town town = (Town) em.createQuery(String.format("select t from Town t where t.name = '%s'", townName)).getSingleResult();
            List<Address> addresses = em.createQuery(String.format("select a from Address a where a.town.name = '%s'", townName)).getResultList();

            for (Address address : addresses) {
                em.remove(address);
                countRemoveAddress++;
            }
            em.remove(town);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        System.out.println(String.format("%d address in %s was deleted", countRemoveAddress, townName));
        em.close();
        emf.close();
    }
}
