import java.util.Comparator;

class CityComparator implements Comparator<Customers> {

    @Override
    public int compare(Customers c1, Customers c2) {
        return c1.city.compareTo(c2.city);
    }// which one to put first in order
}
