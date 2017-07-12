package P05;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChangeTownNamesCasing {
    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String countryName = reader.readLine();
        String updateTownsQuery = "UPDATE towns SET name = UPPER(name) WHERE country = ? ";
        String selectTownsQuery = "SELECT name FROM towns WHERE country = ? ";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {

            PreparedStatement updateTownsStmt = conn.prepareStatement(updateTownsQuery);
            updateTownsStmt.setString(1, countryName);
            int numberOfTowns = updateTownsStmt.executeUpdate();
            updateTownsStmt.close();

            if (numberOfTowns > 0) {
                System.out.printf("%d town names were affected.\n", numberOfTowns);

                PreparedStatement selectTownsStmt = conn.prepareStatement(selectTownsQuery);
                selectTownsStmt.setString(1,countryName);
                ResultSet townsResult = selectTownsStmt.executeQuery();

                List<String> towns = new ArrayList<>();
                while(townsResult.next()){
                    towns.add(townsResult.getString("name"));
                }
                selectTownsStmt.close();

                System.out.println(towns.toString());
            }else{
                System.out.println("No town names were affected.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
