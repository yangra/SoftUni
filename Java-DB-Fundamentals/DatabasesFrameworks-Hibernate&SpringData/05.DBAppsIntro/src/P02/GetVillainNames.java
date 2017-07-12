package P02;

import java.sql.*;

public class GetVillainNames {
    private static final String URL ="jdbc:mysql://localhost:3306/minions_db";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) throws SQLException {
        try(Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
            Statement stmnt = conn.createStatement()){
            String query = "SELECT v.name, COUNT(mv.minion_id) as 'minion_count' FROM minions_villains as mv " +
                    "JOIN villains as v ON mv.villain_id = v.villain_id " +
                    "GROUP BY name " +
                    "HAVING minion_count > 3 " +
                    "ORDER BY minion_count DESC ;";
            ResultSet result = stmnt.executeQuery(query);
            while(result.next()){
                System.out.printf("%s %d\n", result.getString("name"),result.getInt("minion_count"));
            }

        }
    }
}
