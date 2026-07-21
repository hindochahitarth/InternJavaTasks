class Car{
    private int carId;
    private String brand;
    private String model;
    private  double price;

    public Car(int carId,String brand,String model,Double price){
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
    public String getCarDetails(){
        return "Car ID: "+carId+" Brand : "+brand+" Model : "+model+" Price : "+price;
    }
}
class Customer {
    private int custId;
    private String custName;

    public Customer(int custId,String custName){
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
    public void display(){
        System.out.println("Customer ID: "+custId);
        System.out.println("Customer Name:"+custName);
    }
}
class Rent {
    private String company;
    private static int total=0;

    public Rent(String company){
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
    public void addCar(Car car){
        total++;
        
    }
    public void display(){
        System.out.println("Company name:"+company);
        System.out.println("Total Cars:"+total);
    }

}

public class CarRental{
    public static void main(String[] args) {

        Rent carrent = new Rent("Mahindra");

        Car car1=new Car(1, "Toyota", "Innova", 700000.0d);        
        carrent.addCar(car1);
        
        Customer cust1=new Customer(1, "ABC");

        carrent.display();
        car1.getCarDetails();
        cust1.display();
       
        
    }
}