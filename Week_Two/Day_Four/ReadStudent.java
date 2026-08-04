package Week_Two.Day_Four;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReadStudent {
    public static void getAllStudents(){
        String sql = "SELECT * FROM students";


        try (Connection connection = CreateConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {


            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()){
                    System.out.println(resultSet.getInt("id") + " | " +
                            resultSet.getString("name") + " | " +
                            resultSet.getInt("age") + " | " +
                            resultSet.getString("email"));
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
