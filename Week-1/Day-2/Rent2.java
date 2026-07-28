class Rent2 extends Vehicle implements Rental {
    private String company;
    private static int total = 0;

    public Rent2(String company) {
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public static int getTotalCars() {
        return total;
    }

    public void addCar(CarEntity car) {
        total++;

    }

    @Override
    public void displayDetails() {
        System.out.println("Company name:" + company);
        System.out.println("Total Cars:" + total);
    }

    @Override
    public void rental() {
        System.out.println("Rent2 Class ");
    }
}