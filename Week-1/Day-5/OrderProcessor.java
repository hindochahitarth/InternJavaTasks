
import java.util.*;
import java.util.stream.Collectors;
class OrderProcessor<T extends Sellable> {

    private final List<T> items = new ArrayList<>();



    public void addItem(T item) {

        items.add(item);

    }



    public List<T> getItems() {

        return items;

    }



    public List<T> filterByCategory(String category) {

        return items.stream()

                .filter(item -> item.getCategory().equalsIgnoreCase(category))

                .collect(Collectors.toList());

    }



    public void display() {

        items.forEach(System.out::println);

    }

}
