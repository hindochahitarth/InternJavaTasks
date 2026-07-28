class LuxuryCar extends CarEntity implements Rental {

    public LuxuryCar(int carId, String brand, String model, Double price) {
        super(carId, brand, model, price);
    }

    @Override
    public void rental() {
        System.out.println("Car Rented");
    }
}