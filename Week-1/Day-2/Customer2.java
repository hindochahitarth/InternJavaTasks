class Customer2 extends Vehicle {
    private int custId;
    private String custName;

    public Customer2(int custId, String custName) {
        if (custId <= 0) {
            throw new IllegalArgumentException("Customer ID can't be less than or equal to 0.");
        }
        if (custName == null) {
            throw new IllegalArgumentException("Customer Name can't be empty.");
        }
        this.custId = custId;
        this.custName = custName;

    }

    public int getCustId() {
        return custId;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustName() {
        return custName;
    }

    @Override
    public void displayDetails() {
        System.out.println("Customer ID: " + custId);
        System.out.println("Customer Name:" + custName);
    }
}
