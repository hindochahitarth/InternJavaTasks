import java.util.*;

public class InventoryManagement {
    public static void main(String[] args) throws Validate {
        OrderProcessor<Products> shopCart = new OrderProcessor<Products>();

        System.out.println("------------------- Inventory Management -------------------");
        System.out.println();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name of Product :- ");
        String productName = sc.next();

        if (!productName.matches("^[a-zA-Z]+$")) {
            throw new Validate("Must contains only characters ");
        }

        System.out.print("Enter Price of Product :- ");
        int productPrice = sc.nextInt();

        if (productPrice < 0) {
            throw new Validate("Product Price can't be < 0");
        }

        System.out.print("Enter warranty in months :- ");
        int productWarranty = sc.nextInt();
        if (productWarranty < 0) {
            throw new Validate("Months can't be < 0 ");
        }

        shopCart.addItem(new Electronics(productName, productPrice, productWarranty));
        shopCart.addItem(new Electronics("Washing Machine", 600000, 18));
        shopCart.addItem(new Clothing("T-Shirt", 200, "Large"));
        shopCart.addItem(new Clothing("Shirt", 400, "Medium"));

        shopCart.display();

        System.out.print("Enter category by which you want filter :- ");
        String productCategory = sc.next();
        List<Products> filterCategoryList = shopCart.filterByCategory(productCategory);
        filterCategoryList.forEach(System.out::println);
        

    }
}