package Week_Two.Day_Four;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CreateStudent {
    public static void insertStudent(String name,int age , String email){
        String sql="INSERT INTO students (name,age,email) VALUES (?,?,?)";

        try(Connection conn= CreateConnection.getConnection();
            PreparedStatement preparedStatement=conn.prepareStatement(sql)) {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setString(3, email);

            int rows = preparedStatement.executeUpdate();
            System.out.println(rows + " student inserted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
}
