
class CarEntity extends Vehicle {
    private int carId;
    private String carBrand;
    private String carModel;
    private double carPrice;

    public CarEntity(int carId, String carBrand, String carModel) {
        this(carId, carBrand, carModel, 0.0);
    }

    public CarEntity(int carId, String carBrand, String carModel, Double carPrice) {
        this.carId = carId;
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.carPrice = carPrice;

    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getcarBrand() {
        return carBrand;
    }

    public void setcarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getcarModel() {
        return carModel;
    }

    public void setcarModel(String carModel) {
        this.carModel = carModel;
    }

    public Double getcarPrice() {
        return carPrice;
    }

    public void setcarPrice(Double carPrice) {
        this.carPrice = carPrice;
    }

    @Override
    public void displayDetails() {
        System.out.println("Car ID: " + carId + " carBrand : " + carBrand + " carModel : " + carModel + " carPrice : " + carPrice);
    }

    public void displayDetails(String message) {
        System.out.println(message);
        System.out.println("Car ID: " + carId + " carBrand : " + carBrand + " carModel : " + carModel + " carPrice : " + carPrice);
    }
}
