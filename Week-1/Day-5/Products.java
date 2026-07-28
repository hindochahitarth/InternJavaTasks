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
