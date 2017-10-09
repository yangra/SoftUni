package entitymanager;

import java.sql.SQLException;

public interface DBContext {

    <E> boolean persist(E entity) throws IllegalAccessException, SQLException, NoSuchFieldException;

    public void closeConnection() throws SQLException;
}
