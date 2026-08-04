package Week_Two.Day_Four;

import java.sql.Connection;
import java.sql.DriverManager;

public class CreateConnection {
    private static final String URL="jdbc:mysql://localhost:3306/student";
    private static final String USER="root";
    private static final String PASSWORD="mysql";

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }
    
}
