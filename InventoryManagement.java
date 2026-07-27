import java.util.*;
import java.util.stream.Collectors;

interface Sellable {
    String getName();

    double getPrice();

    String getCategory();
}

abstract class Products implements Sellable {
    private final String name;
    private final Double price;
    private final String category;

    protected Products(String name, Double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return " Product Name :- " + name + "\n Product price :- " + price + "\n Product Category :- " + category
                + "\n";
    }

}

class Electronics extends Products {
    private final int warrantyMonths;

    public Electronics(String name, double price, int warrantyMonths) {
        super(name, price, "Electronics ");
        this.warrantyMonths = warrantyMonths;

    }

    public int getWarrantyMonths() {
        return warrantyMonths;
    }

    @Override
    public String toString() {
        return super.toString() + " " + warrantyMonths + " months is warranty period \n";
    }
}

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

class Clothing extends Products {
    private final String size;

    public Clothing(String name, double price, String size) {
        super(name, price, "Clothing");
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    @Override
    public String toString() {
        return super.toString() + " " + "Size - " + size + "\n";
    }
}

public class InventoryManagement {
    public static void main(String[] args) {
        OrderProcessor<Products> shopCart = new OrderProcessor();
        System.out.println("------------------- Inventory Management -------------------");
        System.out.println();

        shopCart.addItem(new Electronics("TV", 820000, 18));
        shopCart.addItem(new Electronics("Washing Machine", 600000, 18));
        shopCart.addItem(new Clothing("T-Shirt", 200, "Large"));
        shopCart.addItem(new Clothing("Shirt", 400, "Medium"));

        shopCart.display();

        List<Products> items = shopCart.filterByCategory("Clothing    ");
        items.forEach(System.out::println);

    }

}
