package Week_Two.Day_Five;

import java.time.LocalDate;

public class Employee {
    private int employeeId;
    private String employeeName;

    private String employeeDepartment;
    private LocalDate employeeBirthDate;

    public Employee(int employeeId, String employeeName, String employeeDepartment, LocalDate employeeBirthDate) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;

        this.employeeDepartment = employeeDepartment;
        this.employeeBirthDate = employeeBirthDate;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeDepartment() {
        return employeeDepartment;
    }

    public void setEmployeeAge(String employeeDepartment) {
        this.employeeDepartment = employeeDepartment;
    }

    public LocalDate getEmployeeBirthDate() {
        return employeeBirthDate;
    }

    public void setEmployeeBirthDate(LocalDate employeeBirthDate) {
        this.employeeBirthDate = employeeBirthDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", employeeDepartment=" + employeeDepartment +
                ", employeeBirthDate=" + employeeBirthDate +
                '}';
    }
}
