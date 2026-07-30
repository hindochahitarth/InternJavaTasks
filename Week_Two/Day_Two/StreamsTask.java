package Week_Two.Day_Two;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;


@FunctionalInterface
interface StringProcessor {
    void process(String message);
}
public class StreamsTask {
        public static void main(String[] args) {

                String[] words = new String[10];
                // String word = words[5].toLowerCase();
                // System.out.print(word);

                //words[5]="HI";
                Optional<String> stringCheckNull = Optional.ofNullable(words[5]);
                
                if (stringCheckNull.isPresent()) {
                        String word = words[5].toLowerCase();
                        System.out.println(word);
                } else {
                        System.out.println("word is null ");
                }
                List<Employee> employees = Arrays.asList(
                                new Employee("Alice", "IT", 60000),
                                new Employee("Bob", "HR", 50000),
                                new Employee("Jack", "IT", 70000),
                                new Employee("Tom", "Finance", 80000),
                                new Employee("Liam", "HR", 55000)
                );

                Map<String, List<Employee>> groupedByDepartment = employees.stream()
                                .collect(Collectors.groupingBy(Employee::getDepartment));

                Optional.ofNullable(groupedByDepartment).ifPresentOrElse(
                                m -> System.out.println("Grouped by department: " + m),
                                () -> System.out.println("Grouped by department: <null>"));

                Map<String, Long> countByDepartment = employees.stream()
                                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

                Optional.ofNullable(countByDepartment).ifPresentOrElse(
                                m -> System.out.println("Department Wise Employees Count: " + m),
                                () -> System.out.println("Department Wise Employees Count: <null>"));
                List<String> names = Arrays.asList("Alice", "Bob", "Harry", "David", "Shepherd", "Vaibhav", "Smit");

                Map<Integer, List<String>> groupedByLength = names.stream()
                                .collect(Collectors.groupingBy(String::length));
                Optional.ofNullable(groupedByLength).ifPresentOrElse(
                                m -> System.out.println("Grouped by length: " + m),
                                () -> System.out.println("Grouped by length: <null>"));

                List<Integer> numbers = Arrays.asList(1, 3, 2, 4, 2, 5, 6, 7, 8, 9);
                Map<Boolean, List<Integer>> groupedByOddEven = numbers.stream()
                                .collect(Collectors.groupingBy(e -> e % 2 == 0));
                Optional.ofNullable(groupedByOddEven).ifPresentOrElse(
                                m -> System.out.println("Grouped by odd and even numbers: " + m),
                                () -> System.out.println("Grouped by odd and even numbers: <null>"));

                Map<Boolean, List<Integer>> sortedGroupedByOddEven = numbers.stream()
                                .collect(Collectors.groupingBy(e -> e % 2 == 0, TreeMap::new, Collectors.toList()));

                Optional.ofNullable(sortedGroupedByOddEven).ifPresentOrElse(
                                m -> System.out.println(sortedGroupedByOddEven),
                                () -> System.out.println("sortedGroupedByOddEven: <null>"));
                List<String> sortedNames = names.stream()
                                .sorted()
                                .collect(Collectors.toList());
                Optional.ofNullable(sortedNames).ifPresentOrElse(
                                m -> System.out.println("Sorted names: " + m),
                                () -> System.out.println("Sorted names: <null>"));
                // memory usage of the groupingBy() operation can grow significantly if:
                // - The classifier function generates a large number of unique keys.
                // - The stream contains a large number of elements that need to be stored in
                //   memory until the entire operation is complete.
                // Demonstrate proper use of the functional interface: process each name
                StringProcessor printer = message -> System.out.println("Message: " + message);


                // Use the functional interface with stream forEach
                names.stream()
                        .map(String::toLowerCase)
                        .forEach(printer::process);

                // Use the functional interface with employees to print department info
                employees.stream()
                        .map(e -> e.getName() + " (" + e.getDepartment() + ")")
                        .forEach(printer::process);
        }
}
