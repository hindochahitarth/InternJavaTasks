
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
