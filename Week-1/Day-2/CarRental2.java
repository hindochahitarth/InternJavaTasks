
public class CarRental2 {
    public static void main(String[] args) {

        Rent2 carrent = new Rent2("Mahindra");

        carrent.rental();

        LuxuryCar car1 = new LuxuryCar(1, "BMW", "X5", 1500000.0);
        LuxuryCar CarEntity = new LuxuryCar(2, "BMW", "X6", 1600000.0);
        CarEntity car4 = new CarEntity(3, "Honda", "City");

        CarEntity.rental();
        Customer2 cust1 = new Customer2(1, "ABC");

        carrent.addCar(car1);
        carrent.addCar(CarEntity);
        carrent.displayDetails();

        car1.displayDetails();
        CarEntity.displayDetails();
        car4.displayDetails("car 3 details");
        cust1.displayDetails();

    }
}