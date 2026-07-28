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
