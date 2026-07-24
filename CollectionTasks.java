import java.util.*;

class Customers implements Comparable<Customers> {

    int id;
    String name;
    String city;

    Customers(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    @Override
    public int compareTo(Customers c) {
        return this.name.compareTo(c.name);
    }

    @Override
    public String toString() {
        return id + " - " + name + " - " + city;
    }
}

class IdComparator implements Comparator<Customers> {

    @Override
    public int compare(Customers c1, Customers c2) {
        return Integer.compare(c1.id, c2.id);
    }
}

class CityComparator implements Comparator<Customers> {

    @Override
    public int compare(Customers c1, Customers c2) {
        return c1.city.compareTo(c2.city);
    }
}

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