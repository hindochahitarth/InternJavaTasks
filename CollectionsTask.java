import java.util.*;
import java.util.stream.Collectors;

public class CollectionsTask {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<String> custList = new ArrayList<>();
        Set<String> custSet = new TreeSet<>();
        Set<String> custSetHash = new HashSet<>();
        Map<Integer, String> custMap = new HashMap<>();

        for (int i = 1; i <= 500; i++) {

            custList.add("Customer " + i);
            custSet.add("Customer " + i);
            custMap.put(0 + i, "Customer");
            custSetHash.add("Customer " + i);
        }

        System.out.println("Enter the Customer name you want to search : ");
        String findCustomer = sc.nextLine();

        // Searching using stream and find customer names
        List<String> matches = custList.stream()
                .filter(name -> name.toLowerCase().contains(findCustomer.toLowerCase()))
                .collect(Collectors.toList());

        System.out.println("Here are the matching names that we have found ");

        // More faster way using HashMap because it provides O(1) time complexity which
        // is better than all other and faster because they use hash function
        // It maps to exact location by hashing so it does not lookup at all elements
        // directly look at exact
        // memory location

        for (String m : matches) {
            System.out.println(m + " ");
        }

        // Using iterator to remove specific element
        Iterator itr = custSet.iterator();
        while (itr.hasNext()) {
            String e = (String) itr.next();
            if (e.endsWith("99")) {
                itr.remove();
            }
        }
        // Filtering customers using stream api
        Collection<String> filteredList = custList.stream()
                .filter(name -> name.endsWith("9"))
                .collect(Collectors.toList());

        // Customers whose name ends with 99 will be printed
        System.out.println(filteredList);

        // Searching in set using for each loop
        Set<String> newSet = custSet.stream()
                .filter(name -> name.contentEquals(findCustomer))
                .collect(Collectors.toSet());

        if (newSet.size() == 1) {
            System.out.println(findCustomer + " found ");
        } else {
            System.out.println("No Customer with name " + findCustomer + " found");
        }
        sc.close();

        // Using removeIf() to removee specific element from ArrayList
        custList.removeIf(name -> name.equals("Customer 497"));
        System.out.println(custList.size());

        // Removing specific customer from HashMap
        custMap.remove(456);

        System.out.println(custMap.size());

        // ArrayList is used for frequent retrievals and has O(N) complexity and it
        // allows duplicates
        // ArrayList allows multiple nulls and maintains insertion orders

        // HashMap stores data as key-value pair , allow multiple null value and only 1
        // null key
        // keys are unique
        // HashMap provides much faster searching then ArrayList , constant time for
        // lookup or insertions

        // HashSet doest not allow duplicates and insertion order not maintained and it
        // uses HashTable
        // HashSet ensures each customer data are unique and prevents duplicates

        // TreeSet does not allow duplicates , sorts elements in ascending order by
        // default,allows single null
        // TreeSet has O(log(n)) time complexity because of TreeMap implementation

    }
}
