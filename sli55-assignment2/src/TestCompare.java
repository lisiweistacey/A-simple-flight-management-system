import java.util.Comparator;

public class TestCompare extends Passenger implements Comparator<Passenger> {

    public TestCompare(String name, String email, int age, String pnr, String seat, int luggageCapacity) {
        super(name, email, age, pnr, seat, luggageCapacity);
    }

    @Override
    public int compare(Passenger p1, Passenger p2){
        if(p1 != null && p2 != null){
            int i;
            // Sort by name.
            i = p1.getName().compareTo(p2.getName()); // ascending order
            // If the names are the same, sort by age.
            if(i == 0){
                i = p1.getAge() - p2.getAge();
            }
            return i;
        }
        else{
            throw new NullPointerException("Null pointer!!!");
        }
    }
}
