import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Counter {
    int count = 0;

    public synchronized void increment() {
        count++;
    }
}

public class SynchronizedDemo {

    public static void main(String[] args) throws InterruptedException {

        String url = "jdbc:mysql://localhost:3306/your_database"; // change database

        String user = "root";
        String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to MySQL database: " + conn.getCatalog());
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Counter counter = new Counter();

        ExecutorService executor = Executors.newFixedThreadPool(20); // pool with 2 threads

        Runnable task = () -> {
            for (int i = 0; i < 100000; i++) {
                counter.increment();
            }
        };

        executor.submit(task);
        executor.submit(task);

        // shutdown executor and wait
        executor.shutdown();

        System.out.println(executor.getClass());

        // 5. Wait for all submitted tasks to finish execution (replaces join)
        if (executor.awaitTermination(1, TimeUnit.MINUTES)) {
            System.out.println("Final Count = " + counter.count);
        } else {
            System.out.println("Tasks did not finish within the timeout period.");
        }

    }
}