class Customers implements Comparable<Customers> {

    int id;
    String name;
    String city;

    Customers(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    @Override
    public int compareTo(Customers c) {
        return this.name.compareTo(c.name);
    }

    @Override
    public String toString() {
        return id + " - " + name + " - " + city;
    }
}
