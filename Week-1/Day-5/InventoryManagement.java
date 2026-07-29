import java.util.*;

public class InventoryManagement {
    public static void main(String[] args) {
        OrderProcessor<Products> shopCart = new OrderProcessor<>();

        System.out.println("------------------- Inventory Management -------------------");
        System.out.println();
        try (Scanner sc = new Scanner(System.in)) {
            String productName;
            while (true) {
                try {
                    productName = readProductName(sc);
                    break;
                } catch (CustomCheckedException e) {
                    System.out.println(e.getMessage());
                } catch (CustomUncheckedException e) {
                    System.out.println(e.getMessage());
                }
            }

            double productPrice;
            while (true) {
                try {
                    productPrice = readProductPrice(sc);
                    break;
                } catch (CustomUncheckedException e) {
                    System.out.println(e.getMessage());
                }
            }

            int productWarranty;
            while (true) {
                try {
                    productWarranty = readProductWarranty(sc);
                    break;
                } catch (CustomUncheckedException e) {
                    System.out.println(e.getMessage());
                }
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
        } catch (InputMismatchException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    private static String readProductName(Scanner sc) throws CustomCheckedException {
        System.out.print("Enter name of Product :- ");
        String productName = sc.nextLine().trim();
        if (productName.isEmpty()) {
            throw new CustomCheckedException("Invalid input. Product name cannot be empty. Please try again.");
        }
        validateProductNameCharacters(productName);
        return productName;
    }

    private static void validateProductNameCharacters(String productName) {
        if (!productName.matches("^[a-zA-Z ]+$")) {
            throw new CustomUncheckedException(
                    "Invalid input. Must contain only letters and spaces. Please try again.");
        }
    }

    private static double readProductPrice(Scanner sc) throws CustomUncheckedException {
        System.out.print("Enter Price of Product :- ");
        String priceInput = sc.nextLine().trim();
        try {
            double productPrice = Double.parseDouble(priceInput);
            if (productPrice < 0) {
                throw new CustomUncheckedException("Invalid input. Price can't be negative. Please try again.");
            }
            return productPrice;
        } catch (NumberFormatException e) {
            throw new CustomUncheckedException("Invalid Product Price. Please enter a valid number.");
        }
    }

    private static int readProductWarranty(Scanner sc) throws CustomUncheckedException {
        System.out.print("Enter warranty in months :- ");
        String warrantyInput = sc.nextLine().trim();
        try {
            int productWarranty = Integer.parseInt(warrantyInput);
            if (productWarranty < 0) {
                throw new CustomUncheckedException("Invalid input. Months can't be < 0. Please try again.");
            }
            return productWarranty;
        } catch (NumberFormatException e) {
            throw new CustomUncheckedException("Invalid warranty input. Please enter a valid integer.");
        }
    }

    private static class CustomUncheckedException extends RuntimeException {
        CustomUncheckedException(String message) {
            super(message);
        }
    }

    private static class CustomCheckedException extends Exception {
        CustomCheckedException(String message) {
            super(message);
        }
    }
}
