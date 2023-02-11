public abstract class Person {

    private String name;
    private String email;
    private int age;

    public Person() {
    }

    public Person(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name){
        if(name != null)
        {
            this.name = name;
        }
        else
        {
            throw new IllegalArgumentException("The passenger's name cannot be empty!!!");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email){
        if (email != null)
        {
            this.email = email;
        }
        else
        {
            throw new IllegalArgumentException("The message cannot be empty!!!");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age){
        if(age < 0 || age > 120)
        {
            throw new IllegalArgumentException("Age should be in the range!!!");
        }
        else
        {
            this.age = age;
        }
    }
}