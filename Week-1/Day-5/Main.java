// record Car(int carId,String brand,String model,double price){

// }Before using record we have to write manually getters and setters and for printing details which was costing a lot of lines of code.But using records we have saved 39 lines of code because it include getter&setter for all variables carId,brand,model and price and for display details also we have to create method but using record we can directly call toString()to print details.

// class Customer {
//     private int custId;
//     private String custName;

// public Customer(int custId,String custName){
// if(custId<=0){
// throw new IllegalArgumentException("Customer ID can't be less than or equal
// to 0.");
// }
// if(custName == null){
// throw new IllegalArgumentException("Customer Name can't be empty.");
// }
// this.custId=custId;
// this.custName=custName;

// }

//     public int getCustId() {
//         return custId;
//     }

//     public void setCustName(String custName) {
//         this.custName = custName;
//     }

//     public String getCustName() {
//         return custName;
//     }

//     public void display() {
//         System.out.println("Customer ID: " + custId);
//         System.out.println("Customer Name:" + custName);
//     }
// }

// class Rent {
//     private String company;
//     private static int total = 0;

//     public Rent(String company) {
//         this.company = company;
//     }

//     public String getCompany() {
//         return company;
//     }

//     public void setCompany(String company) {
//         this.company = company;
//     }

//     public static int getTotalCars() {
//         return total;
//     }

//     public void addCar(Car car) {
//         total++;

//     }

//     public void display() {
//         System.out.println("Company name:" + company);
//         System.out.println("Total Cars:" + total);
//     }

// }

// class Main {
//     public static void main(String[] args) {

//         Rent carrent = new Rent("Mahindra");

//         Car car1 = new Car(1, "Toyota", "Innova", 700000.0d);
//         carrent.addCar(car1);

//         Customer cust1 = new Customer(1, "ABC");

//         carrent.display();
//         car1.toString();
//         cust1.display();

//     }
// }
