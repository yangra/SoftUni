package P07;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrintAllMinionNames {
    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String query = "SELECT name FROM minions";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement stmt = conn.createStatement()) {
            ResultSet minionNames = stmt.executeQuery(query);
            List<String> names = new ArrayList<>();
            while (minionNames.next()){
                names.add(minionNames.getString("name"));
            }
            for (int i = 0, j = names.size()-1; i < names.size()/2 ; i++, j--) {
                System.out.println(names.get(i));
                System.out.println(names.get(j));
            }
            if (names.size()%2!=0){
                System.out.println(names.get(names.size()/2));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
