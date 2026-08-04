package Week_Two.Day_Four;

public  class StudentProfile{
    public static void main(String[] args) {
        CreateStudent.insertStudent("Alice", 22, "alice@gmail.com");
        CreateStudent.insertStudent("Bob", 23, "bob@gmail.com");
        
        System.out.println("\nAll Students:");
        ReadStudent.getAllStudents();

        // UPDATE
        UpdateStudent.updateStudent(1, "alice_new@gmail.com");

        // DELETE
        DeleteStudent.deleteStudent(2);

        // READ again
        System.out.println("\nAfter Update/Delete:");
        ReadStudent.getAllStudents();

    }
}