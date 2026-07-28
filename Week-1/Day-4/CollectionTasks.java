import java.util.*;

public class CollectionTasks {
    public static void main(String[] args) {

        List<Customers> customerLists = new ArrayList<>();
        
        for (int i = 1; i <= 500; i++) {

            String city;

            if (i % 3 == 0)
                city = "Vadodara";
            else if (i % 3 == 1)
                city = "Ahmedabad";
            else
                city = "Gandhinagar";

            customerLists.add(new Customers(1, "Customer " + i, city));
        }

        Map<String, List<Customers>> group = new HashMap<>();


        // Counting Customer Groups
        for (Customers c : customerLists) {
            group.computeIfAbsent(c.city, k -> new ArrayList<>()).add(c);
        }

        System.out.println("Customer groups ");
        
        for (Map.Entry<String, List<Customers>> entry : group.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue().size());
        }


        System.out.println("First 5 Customers ");
        
        for (int i = 0; i < 5; i++) {
            System.out.println(customerLists.get(i));
        }
        
        customerLists.sort(new IdComparator());

        System.out.println("First 5 Customers ");
        
        for (int i = 0; i < 5; i++) {
            System.out.println(customerLists.get(i));
        }
        
        customerLists.sort(new CityComparator());

        System.out.println("First 5 Customers ");

        for (int i = 0; i < 5; i++) {
            System.out.println(customerLists.get(i));
        }
    }
}