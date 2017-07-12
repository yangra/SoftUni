package P06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class RemoveVillain {
    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int id = Integer.parseInt(reader.readLine());

        String selectVillainQuery = "SELECT * FROM villains WHERE villain_id = ? ";

        String deleteFromMapTableQuery = "DELETE FROM minions_villains WHERE villain_id = ? ";
        String deleteFromVillainsQuery = "DELETE FROM villains WHERE villain_id = ? ";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {

            PreparedStatement selectVillainStmt = conn.prepareStatement(selectVillainQuery);
            selectVillainStmt.setInt(1, id);
            ResultSet villain = selectVillainStmt.executeQuery();

            if(!villain.next()){
                System.out.println("No such villain was found");
            }else{
                PreparedStatement deleteFromMapTableStmt = conn.prepareStatement(deleteFromMapTableQuery);
                deleteFromMapTableStmt.setInt(1, id);
                int minionsReleased = deleteFromMapTableStmt.executeUpdate();
                deleteFromMapTableStmt.close();

                PreparedStatement deleteFromVillainsStmt = conn.prepareStatement(deleteFromVillainsQuery);
                deleteFromVillainsStmt.setInt(1,id);
                deleteFromVillainsStmt.executeUpdate();
                System.out.printf("%s was deleted\n", villain.getString("name"));
                deleteFromVillainsStmt.close();
                System.out.printf("%d minions released\n", minionsReleased);
            }

            selectVillainStmt.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
