package Week_Two.Day_Four;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteStudent {
    public static void deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id = ?";

        try (Connection conn = CreateConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            int rows = stmt.executeUpdate();
            System.out.println(rows + " student deleted successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}