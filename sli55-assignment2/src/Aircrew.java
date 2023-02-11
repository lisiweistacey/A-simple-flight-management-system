public class Aircrew extends Person {

    private String position;

    public Aircrew (String name, String email, int age, String position){
        super(name, email, age);
        this.position= position;
    }

    @Override
    public String toString(){
        return "\nname: "+ getName() +"\nemail: "+ getEmail() + "\nage: " + getAge() + "\nposition: " + getPosition();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position){
        if (position != null)
        {
            this.position = position;
        }
        else
        {
            throw new IllegalArgumentException("The position cannot be empty!!!");
        }
    }
}
