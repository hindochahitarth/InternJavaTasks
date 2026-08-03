package Week_Two.Day_Four;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentProfile {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String QUERY="";


    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
                System.out.println("Connected to MySQL database: " + conn.getCatalog());

                createStudent(conn, 1, "John", 20);
                readStudent(conn, 1);
                updateStudent(conn, 1, "John Jos", 21);
                readStudent(conn, 1);
                deleteStudent(conn, 1);
                readStudent(conn, 1);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createStudent(Connection conn, int id, String name, int age) throws SQLException {
        String sql = "INSERT INTO student (id, name, age) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, age);
            int rows = ps.executeUpdate();
            System.out.println("Inserted student: " + name + " (rows affected: " + rows + ")");
        }
    }

    private static void readStudent(Connection conn, int id) throws SQLException {
        String sql = "SELECT id, name, age FROM student WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Student found: id=" + rs.getInt("id") + ", name=" + rs.getString("name") + ", age=" + rs.getInt("age"));
                } else {
                    System.out.println("Student with id " + id + " not found.");
                }
            }
        }
    }

    private static void updateStudent(Connection conn, int id, String name, int age) throws SQLException {
        String sql = "UPDATE student SET name = ?, age = ? WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setInt(3, id);
            int rows = ps.executeUpdate();
            System.out.println("Updated student id " + id + " (rows affected: " + rows + ")");
        }
    }

    private static void deleteStudent(Connection conn, int id) throws SQLException {
        String sql = "DELETE FROM student WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            System.out.println("Deleted student id " + id + " (rows affected: " + rows + ")");
        }
    }
}
