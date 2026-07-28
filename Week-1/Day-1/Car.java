class Car {
    private int carId;
    private String carBrand;
    private String carModel;
    private double carPrice;

    public Car(int carId, String carBrand, String carModel, Double carPrice) {
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

    public String getcarcarModel() {
        return carModel;
    }

    public void setcarcarModel(String carModel) {
        this.carModel = carModel;
    }

    public Double getcarPrice() {
        return carPrice;
    }

    public void setcarPrice(Double carPrice) {
        this.carPrice = carPrice;
    }

    public String getCarDetails() {
        return "Car ID: " + carId + " carBrand : " + carBrand + " carcarModel : " + carModel + " carPrice : " + carPrice;
    }
}
