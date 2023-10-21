import java.util.Vector;

public class Visitor implements Person{
    private final String name;
    private final Integer age;
    private final String phoneNumber;
    private final Integer balance;
    private final String email;
    private final String password;
    private boolean visiting = false;
    private Vector<Animal> animals;
    private Vector<Attraction> attractions;
    private String feedback;
    //Constructor
    public Visitor(String name, Integer age, String phoneNumber, Integer balance, String email, String password){
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
        this.email = email;
        this.password = password;
        this.feedback = "";
        this.animals = new Vector<>();
        this.attractions = new Vector<>();
    }

    //Getters
    @Override
    public String getUserName() {
        return this.email;
    }
    public String getPassword() {
        return this.password;
    }
    public Vector<Animal> getAnimals() {
        return this.animals;
    }
    public Vector<Attraction> getAttractions(){
        return this.attractions;
    }

    //Methods
    @Override
    public boolean checkLogin(String name, String password) {
        return name.equals(this.name) && password.equals(this.password);
    }
    public void setVisiting(boolean visiting) {
        this.visiting = visiting;
    }
    public void updateFeedback(String feedback) {
        this.feedback = feedback;
    }
}
