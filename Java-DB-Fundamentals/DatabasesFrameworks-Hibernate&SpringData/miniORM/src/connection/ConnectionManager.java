//############################################
//This class generates a connection to the DB
//but you are responsible to CLOSE it!
//############################################

package connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionManager {

    private static final String URL = "jdbc:mysql://localhost:3306/mini_orm_db?createDatabaseIfNotExist=true";

    private static final String USER = "root";

    private static final String PASSWORD = "root";

    private ConnectionManager() {}

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER,PASSWORD);
    }
}
