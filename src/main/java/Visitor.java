import java.util.Objects;
import java.util.Scanner;
import java.util.Vector;

public class Visitor implements Person {
    Scanner input = new Scanner(System.in);
    private final String name;
    private final Integer age;
    private final String phoneNumber;
    private String usertype;
    private double balance;
    private final String email;
    private final String password;
    private boolean visiting = false;
    private final Zoo zoo;
    private final Vector<Attraction> attractions;
    private String feedback;

    //Constructor
    public Visitor(String name, Integer age, String phoneNumber, Double balance, String email, String password, Zoo zoo) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.usertype = "Basic";
        this.balance = balance;
        this.email = email;
        this.password = password;
        this.zoo = zoo;
        this.feedback = "";
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

    public Vector<Attraction> getAttractions() {
        return this.attractions;
    }

    public String getFeedback() {
        return this.feedback;
    }

    public boolean isVisiting() {
        if (!this.attractions.isEmpty()){
            this.visiting = true;
        }
        return this.visiting;
    }

    public String getName() {
        return this.name;
    }

    //Methods
    @Override
    public boolean checkLogin(String email, String password) {
        return email.equals(this.email) && password.equals(this.password);
    }

    public void exploreZoo() {
        try {
            System.out.println("Welcome to the zoo!");
            System.out.println("1. View attractions");
            System.out.println("2. View animals");
            System.out.println("3. Exit");
            System.out.print("Enter your option:");
            Integer choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    this.zoo.viewAttractions();
                    break;
                case 2:
                    this.zoo.viewAnimals();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
    }

    public void buyMembership() {
        try {
            System.out.println("1. Buy Premium Membership");
            System.out.println("2. Exit");
            System.out.print("Enter your option:");
            Integer choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    this.usertype = "Premium";
                    this.balance -= 50;
                    System.out.println("Membership bought successfully, ₹50 deducted from your balance");
                    this.zoo.addRevenue(50.0);
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
    }

    public void buyTickets() {
        try {
            for (Attraction attraction : this.zoo.getAttractions()) {
                if (attraction.getIsAvailable()) {
                    System.out.print("Attraction: " + attraction.getName() + " | Price: ₹");
                    System.out.print(attraction.getPrice());
                    System.out.println(" | ID: " + attraction.getId());
                }
            }
            System.out.println("1. Buy tickets");
            System.out.println("2. Exit");
            System.out.print("Enter your option:");
            Integer choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Enter attraction ID:");
                    Integer id = Integer.parseInt(input.nextLine());
                    System.out.print("Enter number of tickets:");
                    Integer tickets = Integer.parseInt(input.nextLine());
                    for (Attraction attraction : this.zoo.getAttractions()) {
                        if (attraction.getId().equals(id)) {
                            if (!attraction.getIsAvailable()) {
                                System.out.println("Attraction not available! Please try again later");
                                break;
                            }
                            Integer DealDisc = this.zoo.applyDeals(tickets);
                            double price = (attraction.getPrice()*(1-(DealDisc/(double) 100)));
                            for (Discount discount : this.zoo.getDiscounts()){
                                System.out.println(discount.getCode()+" "+discount.getPercentage()+"% off");
                            }
                            try {
                                System.out.print("Enter discount code:");
                                String code = input.nextLine();
                                for (Discount discount : this.zoo.getDiscounts()) {
                                    if (discount.getCode().equals(code)) {
                                        if (Objects.equals(discount.getCode(), "MINOR10")) {
                                            if (this.age >= 18) {
                                                System.out.println("You can't apply this code");
                                                break;
                                            }
                                        }
                                        if (Objects.equals(discount.getCode(), "SENIOR10")) {
                                            if (this.age <= 60) {
                                                System.out.println("You can't apply this code");
                                                break;
                                            }
                                        }
                                        price = price * (100 - discount.getPercentage()) / 100;
                                        break;
                                    }
                                }
                            } catch (Exception e) {
                                System.out.println("Invalid input");
                            }
                            if (price*tickets > this.balance) {
                                System.out.println("Insufficient balance");
                                break;
                            }
                            this.balance -= price * tickets;
                            this.zoo.addRevenue(price*tickets);
                            for (int i = 0; i < tickets; i++) {
                                attraction.tickets();
                                this.attractions.add(attraction);
                            }
                            System.out.println("Tickets bought successfully. Price = ₹" + price * tickets + " has been deducted from your balance.");
                            break;
                        }
                    }
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
    }
    public void viewDiscount(){
        for (Discount discount : this.zoo.getDiscounts()){
            System.out.println(discount.getCode()+" "+discount.getPercentage()+"% off");
        }
    }
    public void viewDeals(){
        for (SpecialDeals deals : this.zoo.getDeals()){
            System.out.println(deals.getCode()+" "+deals.getPercentage()+"% off for "+deals.getRequiredAttractions()+" tickets");
        }
    }
    public void visitAnimals(){
        try {
            for (Animal animal : this.zoo.getAnimals()) {
                System.out.print("Animal:" + animal.getSpecies() + " ID:");
                System.out.println(animal.getId());
            }
            Integer choice = Integer.parseInt(input.nextLine());
            for (Animal animal : this.zoo.getAnimals()) {
                if (animal.getId().equals(choice)) {
                    System.out.println("1. Feed");
                    System.out.println("2. Read");
                    System.out.println("3. Exit");

                    Integer option = Integer.parseInt(input.nextLine());
                    switch (option) {
                        case 1:
                            animal.feed();
                            break;
                        case 2:
                            animal.read();
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("Invalid choice");
                    }
                }
            }
        }
        catch (Exception e) {
            System.out.println("Invalid input");
        }
    }
    public void visitAttractions(){
        boolean visited = false;
        if (Objects.equals(this.usertype,"Basic")) {
            try {
                for (Attraction attraction : this.attractions) {
                    System.out.print("Attraction: " + attraction.getName() + " | ID: ");
                    System.out.println(attraction.getId());
                }
                System.out.println("Enter attraction ID:");
                Integer choice = Integer.parseInt(input.nextLine());
                for (Attraction attraction : this.attractions) {
                    if (attraction.getId().equals(choice)) {
                        attraction.visits();
                        System.out.println("Thanks for visiting!");
                        this.attractions.remove(attraction);
                        visited = true;
                        break;
                    }
                }
                if (!visited) {
                    System.out.println("You haven't bought tickets for this attraction");
                }

            }
            catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
        else {
            try {
                for (Attraction attraction : this.zoo.getAttractions()) {
                    if (attraction.getIsAvailable()) {
                        System.out.print("Attraction: " + attraction.getName() + " | ID: ");
                        System.out.println(attraction.getId());
                    }
                }
                System.out.print("Enter attraction ID: ");
                Integer choice = Integer.parseInt(input.nextLine());
                for (Attraction attraction : this.attractions) {
                    if (attraction.getId().equals(choice) && attraction.getIsAvailable()) {
                        attraction.visits();
                        System.out.println("Thanks for visiting!");
                        this.attractions.remove(attraction);
                        break;
                    } else {
                        System.out.println("Invalid choice");
                    }
                }
            }
            catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
    }
    public void leaveFeedback(){
        try {
            System.out.print("Enter your feedback:");
            String feedback = input.nextLine();
            this.feedback = feedback;
            System.out.println("Feedback submitted successfully");
        }
        catch (Exception e) {
            System.out.println("Invalid input");
        }
    }
    public String getUsertype() {
        return usertype;
    }
}