public class Passenger extends Person {

    private String pnr;
    private String seat;
    private int luggageCapacity;

    public Passenger(String name, String email, int age, String pnr, String seat, int luggageCapacity) {
        super(name, email, age);
        this.pnr = pnr;
        this.seat = seat;
        this.luggageCapacity = luggageCapacity;
    }

    @Override
    public String toString(){
        return getName() +", "+ getEmail() + ", " + getAge() + ", " + pnr + ", "+ seat + ", " + luggageCapacity;
    }

    public String getPNR() {
        return pnr;
    }

    public void setPNR(String pnr){
        if (pnr.length() != 6)
        {
            this.pnr = pnr;
        }
        else
        {
            throw new IllegalArgumentException("PNR format cannot be empty!!!");
        }
    }

    public String getSeat () {
        return seat;
    }

    public void setSeat(String seat){
        if (seat != null)
        {
            this.seat = seat;
        }
        else
        {
            throw new IllegalArgumentException("Seats cannot be empty!!!");
        }
    }

    public int getLuggageCapacity() {
        return luggageCapacity;
    }

    public void setLuggageCapacity(int luggageCapacity){
        if (luggageCapacity< 0)
        {
            throw new IllegalArgumentException("The number of luggageCapacity must be greater than or equal to 0!!!");
        }
        else
        {
            this.luggageCapacity = luggageCapacity;
        }
    }
}
