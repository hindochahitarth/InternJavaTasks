package Week_Two.Day_Five;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/users";
    private static final String USER = "root";
    private static final String PASS = "mysql";

    public static void main(String[] args) {
        Thread dbThread = new Thread(() -> {
            try {
                fetchEmployees();
            } catch (Exception e) {
                System.err.println("Error while fetching employees: " + e.getMessage());
                e.printStackTrace();
            }
        });

        dbThread.start();
    }

    private static void fetchEmployees() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASS);
                Statement statement = connection.createStatement();
                Scanner scanner = new Scanner(System.in)) {

            ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");

            List<Employee> employeeList = new ArrayList<>();
            while (resultSet.next()) {
                Employee employee = new Employee(
                        resultSet.getInt("emp_id"),
                        resultSet.getString("emp_name"),
                        resultSet.getString("emp_department"),
                        resultSet.getDate("emp_bdate").toLocalDate());

                employeeList.add(employee);
            }
            // System.out.println(employeeList);
            LocalDate targetDate = LocalDate.of(2000, 1, 1);

            List<Employee> filterEmployees = employeeList.stream()
                    .filter(emp -> emp.getEmployeeBirthDate().isAfter(targetDate))
                    .collect(Collectors.toList());

            System.out.println("Enter department name by which you want to filter the data : ");
            String department = scanner.next();
            List<Employee> filterEmployeesByDepartment = employeeList.stream()
                    .filter(emp -> emp.getEmployeeDepartment().equalsIgnoreCase(department))
                    .collect(Collectors.toList());

            // System.out.println(filterEmployees);
            System.out.println("After filtering by " + department + " department ");
            System.out.println(filterEmployeesByDepartment);

            List<Employee> sortedEmployees = employeeList.stream()
                    .sorted(Comparator.comparing(Employee::getEmployeeName))
                    .collect(Collectors.toList());
            System.out.println("After Sorting Employees by name wise ");
            System.out.println(sortedEmployees);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
