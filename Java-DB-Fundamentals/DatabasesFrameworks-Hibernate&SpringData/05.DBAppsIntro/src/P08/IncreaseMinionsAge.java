package P08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Arrays;

public class IncreaseMinionsAge {
    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

        String selectQuery = "SELECT * FROM minions";

        String selectNameQuery = "SELECT name FROM minions WHERE minion_id = ? ";
        String updateQuery = "UPDATE minions SET age = age+1, name = ? WHERE minion_id = ? ";


        try (Connection conn  = DriverManager.getConnection(URL,USER,PASSWORD);
             Statement selectStmt = conn.createStatement()){

            PreparedStatement selectNameStmt = conn.prepareStatement(selectNameQuery);
            PreparedStatement updateStmt = conn.prepareStatement(updateQuery);

            for (int id: input){
                selectNameStmt.setInt(1,id);
                ResultSet result = selectNameStmt.executeQuery();
                if(result.next()){
                    String name = result.getString("name");
                    String capitalizedName = Capitalize(name);

                    updateStmt.setString(1,capitalizedName);
                    updateStmt.setInt(2,id);
                    updateStmt.executeUpdate();
                }else{
                    System.out.printf("No minion with id %d\n", id);
                }
            }
            selectNameStmt.close();
            updateStmt.close();


            ResultSet minions = selectStmt.executeQuery(selectQuery);

            while(minions.next()){
                System.out.printf("%s %d\n", minions.getString("name"), minions.getInt("age"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static String Capitalize(String name) {
        String result = "";
        String[] words = name.split("\\s+");
        for (String word : words){
            word = word.substring(0,1).toUpperCase() + word.substring(1).toLowerCase();
            result += word + " ";
        }
        return result.trim();
    }
}
