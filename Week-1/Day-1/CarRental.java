import java.time.LocalDateTime;
import java.util.Scanner;

public class CarRental {
    public static void main(String[] args) {


        Rent carRentObj = new Rent("Mahindra");
        Car carObject = new Car(1, "Toyota", "Innova", 700000.0d);
        carRentObj.addCar(carObject);

        CarDetails carDetailsObject = new CarDetails(LocalDateTime.of(2020, 5, 15, 9, 5, 5), 4, "Auto");

        Customer customerObject = new Customer(1, "ABC");

        carRentObj.showDetails();
        carObject.getCarDetails();
        System.out.println(carDetailsObject.showCarDetails());
        customerObject.showDetails();

    }
}