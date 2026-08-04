package Week_Two.Day_Four;

public class StudentProfile {
    private static final Object LOCK = new Object();

    public static void main(String[] args) {
        Runnable worker1 = () -> {
            synchronized (LOCK) {
                CreateStudent.insertStudent("Alice", 22, "alice@gmail.com");
                CreateStudent.insertStudent("Bob", 23, "bob@gmail.com");
            }
        };

        Runnable worker2 = () -> {
            synchronized (LOCK) {
                CreateStudent.insertStudent("Charlie", 24, "charlie@gmail.com");
                CreateStudent.insertStudent("Diana", 25, "diana@gmail.com");
            }
        };

        Thread thread1 = new Thread(worker1, "Worker-1");
        Thread thread2 = new Thread(worker2, "Worker-2");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("\nAll Students:");
        ReadStudent.getAllStudents();

        // UPDATE
        synchronized (LOCK) {
            UpdateStudent.updateStudent(1, "alice_new@gmail.com");
        }

        // DELETE
        synchronized (LOCK) {
            DeleteStudent.deleteStudent(2);
        }

        System.out.println("\nAfter Update/Delete:");
        ReadStudent.getAllStudents();
    }
}   