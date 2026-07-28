import java.util.Comparator;

class IdComparator implements Comparator<Customers> {

    @Override
    public int compare(Customers c1, Customers c2) {
        return Integer.compare(c1.id, c2.id);
    }
}
