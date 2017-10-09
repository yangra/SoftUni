import entitymanager.DBContext;
import entitymanager.EntityManager;
import model.User;

import java.sql.SQLException;
import java.time.LocalDate;

public class ORMDemo {

    public static void main(String[] args) throws SQLException, IllegalAccessException, NoSuchFieldException {
        DBContext em = new EntityManager();
        try {
            User u1 = new User("Ivan", 25, LocalDate.now());
            em.persist(u1);
            u1.setAge(26);
            em.persist(u1);
        } finally {
            em.closeConnection();
        }
    }
}
