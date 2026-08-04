package Week_Two.Day_Four;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateStudent {
    public static void updateStudent(int id, String newEmail) {
        String sql = "UPDATE students SET email = ? WHERE id = ?";

        try (Connection conn = (Connection) CreateConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, newEmail);
            stmt.setInt(2, id);

            int rows = stmt.executeUpdate();
            System.out.println(rows + " student updated successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}