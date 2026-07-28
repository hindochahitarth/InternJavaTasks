
class Rent {
    private String carCompany;
    private static int totalCars = 0; // change variable name

    public Rent(String carCompany) {
        this.carCompany = carCompany;
    }

    public String getCompany() {
        return carCompany;
    }

    public void setCompany(String carCompany) {
        this.carCompany = carCompany;
    }

    public static int getTotalCars() {
        return totalCars;
    }

    public void addCar(Car car) {
        totalCars++;

    }

    public void showDetails() {
        System.out.println("Company name:" + carCompany);
        System.out.println("Total Cars:" + totalCars);
    }

}