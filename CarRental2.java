// Added vehicle abstract class that has abstract method displayDetails that subclass must ovverride
// currently it has only partial implementation after then based on need subclass can override and use
abstract class Vehicle{
    abstract void displayDetails();
}

// Added interface for commmon behviour for rent of cars
// different vehicles can be rented so rental() can be used by implementing the interface Rental
interface Rental {
    void rental();
}

class Car2 extends Vehicle{
    private int carId;
    private String brand;
    private String model;
    private  double price;

    public Car2(int carId,String brand,String model,Double price){
       this.carId=carId;
       this.brand=brand;
       this.model=model;
       this.price=price;
        
    }
    public int getCarId(){
        return carId;
    }
    public void setCarId(int carId){
        this.carId=carId;
    }
    public String getBrand(){
        return brand;
    }
    public void setBrand(String brand){
        this.brand=brand;
    }
    public String getModel(){
        return model;
    }
    public void setModel(String model){
        this.model=model;
    }
    public Double getPrice(){
        return price;
    }
    public void setPrice(Double price){
        this.price=price;
    }
    @Override
    public void displayDetails(){
        System.out.println("Car ID: "+carId+" Brand : "+brand+" Model : "+model+" Price : "+price);
    }
}
class LuxuryCar extends Car2 implements Rental{

    public LuxuryCar(int carId, String brand, String model, Double price) {
        super(carId, brand, model, price);   
    }
    @Override
    public void rental() {
        System.out.println("Car Rented");
    }
}
class Customer2 extends Vehicle{
    private int custId;
    private String custName;

    public Customer2(int custId,String custName){
        if(custId<=0){
            throw new IllegalArgumentException("Customer ID can't be less than or equal to 0.");
        }
        if(custName == null){
            throw new IllegalArgumentException("Customer Name can't be empty.");
        }
        this.custId=custId;
        this.custName=custName;
        
    }
    public int getCustId(){
        return custId;
    }
    public void setCustName(String custName){
        this.custName=custName;
    }
    public String getCustName(){
        return custName;
    }
    @Override
    public void displayDetails(){
        System.out.println("Customer ID: "+custId);
        System.out.println("Customer Name:"+custName);
    }
}
class Rent2 extends Vehicle{
    private String company;
    private static int total=0;

    public Rent2(String company){
        this.company=company;
    }
    public String getCompany(){
        return company;
    }
    public void setCompany(String company){
        this.company=company;
    }
    public static int getTotalCars(){
        return total;
    }
    public void addCar(Car2 car){
        total++;
        
    }
    @Override
    public void displayDetails(){
        System.out.println("Company name:"+company);
        System.out.println("Total Cars:"+total);
    }
}
public class CarRental2{
    public static void main(String[] args) {

        Rent2 carrent = new Rent2("Mahindra");


        LuxuryCar car2=new LuxuryCar(1,"BMW","X5",1500000.0);
        LuxuryCar car3=new LuxuryCar(2,"BMW","X6",1600000.0);
         
        Customer2 cust1=new Customer2(1, "ABC");

        carrent.addCar(car2);
        carrent.addCar(car3);
        carrent.displayDetails();
        
        car2.displayDetails();
        car3.displayDetails();
        cust1.displayDetails();
       
        
    }
}