import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static Scanner input = new Scanner(System.in);
    public static void MainMenu(){
        System.out.println("Welcome to the Zoo Management System");
        System.out.println("1. Enter as Admin");
        System.out.println("2. Enter as Visitor");
        System.out.println("3. Exit");
    }
    public static void AdminMenu(){
        System.out.println("Welcome Admin");
        System.out.println("1. Manage Attraction");
        System.out.println("2. Manage Discounts");
        System.out.println("3. Manage Deals");
        System.out.println("4. Manage Animals");
        System.out.println("5. Schedule Events");
        System.out.println("6. View Visitor Stats");
        System.out.println("7. View Feedback");
        System.out.println("8. Exit");
    }
    public static void AttractionMenu(){
        System.out.println("1. View Attraction");
        System.out.println("2. Add Attraction");
        System.out.println("3. Remove Attraction");
        System.out.println("4. Modify Attraction");
        System.out.println("5. Exit");
    }
    public static void DiscountMenu(){
        System.out.println("1. View Discounts");
        System.out.println("2. Add Discount");
        System.out.println("3. Remove Discount");
        System.out.println("4. Modify Discount");
        System.out.println("5. Exit");
    }
    public static void DealsMenu(){
        System.out.println("1. View Deals");
        System.out.println("2. Add Deals");
        System.out.println("3. Remove Deals");
        System.out.println("4. Modify Deals");
        System.out.println("5. Exit");
    }
    public static void AnimalMenu(){
        System.out.println("1. View Animals");
        System.out.println("2. Add Animal");
        System.out.println("3. Remove Animal");
        System.out.println("4. Modify Animal");
        System.out.println("5. Exit");
    }
    public static void BasicMenu(){
        System.out.println("Welcome Visitor");
        System.out.println("1. Explore the Zoo");
        System.out.println("2. Buy Membership");
        System.out.println("3. Buy Tickets");
        System.out.println("4. View Discounts");
        System.out.println("5. View Deals");
        System.out.println("6. Visit Animals");
        System.out.println("7. Visit Attractions");
        System.out.println("8. Leave Feedback");
        System.out.println("9. Exit");
    }
    public static void PremiumMenu(){
        System.out.println("Welcome Visitor");
        System.out.println("1. Explore the Zoo");
        System.out.println("2. Visit Animals");
        System.out.println("3. Visit Attractions");
        System.out.println("4. Leave Feedback");
        System.out.println("5. Exit");
    }
    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        zoo.addDiscount(new Discount("MINOR10", 10));
        zoo.addDiscount(new Discount("SENIOR20", 20));
        zoo.addDeals(new SpecialDeals("15FOR2", 15, 2));
        zoo.addDeals(new SpecialDeals("30FOR3", 30, 3));
        zoo.addAnimal(new Reptile("Snake", "Hiss", "Snakes are elongated, legless reptiles known for their diverse species, sizes, and habitats. They are cold-blooded and characterized by their scaly bodies, forked tongues, and a remarkable ability to swallow prey whole.", 1));
        zoo.addAnimal(new Reptile("Crocodiles", "Grunt", "Crocodiles are formidable reptiles known for their large, armored bodies and powerful jaws. They are semi-aquatic, often found in freshwater habitats, and are apex predators with exceptional hunting skills.", 2));
        zoo.addAnimal(new Mammal("Elephant", "Snort", "Elephants are Earth's largest land mammals, known for their massive size, distinct trunk, and powerful tusks. These intelligent and social creatures inhabit various habitats, from savannas to forests.", 3));
        zoo.addAnimal(new Mammal("Monkey", "Chatter", "Monkeys are agile and intelligent primates found in diverse habitats around the world. They are characterized by their long tails, dexterous hands, and complex social behaviors.", 4));
        zoo.addAnimal(new Amphibian("Frog", "Croak", "Frogs are small, amphibious creatures known for their distinctive croaking calls and leaping abilities. They are found in various ecosystems, from rainforests to wetlands.", 5));
        zoo.addAnimal(new Amphibian("Salamander", "Squeak", "Salamanders are amphibians recognized for their slender bodies, moist skin, and a remarkable ability to regenerate lost body parts.", 6));

        Admin admin = new Admin(zoo);
        Visitor visitor = null;
        Integer AttractionID = 0;
        Integer AnimalID = 7;

        while (true) {
            MainMenu();
            try {
                Integer choice = Integer.parseInt(input.nextLine());
                if (choice==1){
                    System.out.println("Enter Admin Username: ");
                    String username = input.nextLine();
                    System.out.println("Enter Admin Password: ");
                    String password = input.nextLine();
                    if (admin.checkLogin(username, password)){
                        while (true) {
                            AdminMenu();
                            try {
                                Integer adminChoice = Integer.parseInt(input.nextLine());
                                switch (adminChoice) {
                                    case 1:
                                        while (true) {
                                            AttractionMenu();
                                            Integer attractionChoice = Integer.parseInt(input.nextLine());
                                            switch (attractionChoice) {
                                                case 1:
                                                    admin.viewAttraction();
                                                    break;
                                                case 2:
                                                    System.out.println("Enter Attraction Name: ");
                                                    String name = input.nextLine();
                                                    System.out.println("Enter Attraction Price: ");
                                                    Integer price = Integer.parseInt(input.nextLine());
                                                    System.out.println("Enter Attraction Description: ");
                                                    String description = input.nextLine();
                                                    admin.addAttraction(name, AttractionID, price, description);
                                                    AttractionID++;
                                                    break;
                                                case 3:
                                                    System.out.println("Enter Attraction ID: ");
                                                    Integer id = Integer.parseInt(input.nextLine());
                                                    admin.removeAttraction(id);
                                                    break;
                                                case 4:
                                                    System.out.println("Enter Attraction ID: ");
                                                    Integer id1 = Integer.parseInt(input.nextLine());
                                                    admin.modifyAttraction(id1);
                                                    break;
                                                case 5:
                                                    break;
                                                default:
                                                    System.out.println("Invalid choice");
                                            }
                                            if (attractionChoice==5){
                                                break;
                                            }
                                        }
                                        break;
                                    case 2:
                                        while (true) {
                                            DiscountMenu();
                                            Integer discountChoice = Integer.parseInt(input.nextLine());
                                            switch (discountChoice) {
                                                case 1:
                                                    admin.viewDiscounts();
                                                case 2:
                                                    System.out.println("Enter Discount Code: ");
                                                    String code = input.nextLine();
                                                    System.out.println("Enter Discount Percentage: ");
                                                    Integer percentage = Integer.parseInt(input.nextLine());
                                                    admin.addDiscount(code, percentage);
                                                    break;
                                                case 3:
                                                    System.out.println("Enter Discount Code: ");
                                                    String code1 = input.nextLine();
                                                    admin.removeDiscount(code1);
                                                    break;
                                                case 4:
                                                    System.out.println("Enter Discount Code: ");
                                                    String code2 = input.nextLine();
                                                    admin.updateDiscount(code2);
                                                    break;
                                                case 5:
                                                    break;
                                                default:
                                                    System.out.println("Invalid choice");
                                            }
                                            if (discountChoice==5){
                                                break;
                                            }
                                        }
                                        break;
                                    case 3:
                                        while (true) {
                                            DealsMenu();
                                            Integer dealsChoice = Integer.parseInt(input.nextLine());
                                            switch (dealsChoice) {
                                                case 1:
                                                    admin.viewDeals();
                                                    break;
                                                case 2:
                                                    System.out.println("Enter Deals Code: ");
                                                    String code3 = input.nextLine();
                                                    System.out.println("Enter Deals Percentage: ");
                                                    Integer percentage1 = Integer.parseInt(input.nextLine());
                                                    System.out.println("Enter Deals Minimum Attraction: ");
                                                    Integer minimumAttraction = Integer.parseInt(input.nextLine());
                                                    admin.addDeals(code3, percentage1, minimumAttraction);
                                                    break;
                                                case 3:
                                                    System.out.println("Enter Deals Code: ");
                                                    String code4 = input.nextLine();
                                                    admin.removeDeals(code4);
                                                    break;
                                                case 4:
                                                    System.out.println("Enter Deals Code: ");
                                                    String code5 = input.nextLine();
                                                    admin.updateDeals(code5);
                                                    break;
                                                case 5:
                                                    break;
                                                default:
                                                    System.out.println("Invalid choice");
                                            }
                                            if (dealsChoice==5){
                                                break;
                                            }
                                        }
                                        break;
                                    case 4:
                                        while (true) {
                                            AnimalMenu();
                                            Integer animalChoice = Integer.parseInt(input.nextLine());
                                            switch (animalChoice) {
                                                case 1:
                                                    admin.viewAnimals();
                                                    break;
                                                case 2:
                                                    System.out.println("Enter Animal Species: ");
                                                    String species = input.nextLine();
                                                    System.out.println("Enter Animal Sound: ");
                                                    String sound = input.nextLine();
                                                    System.out.println("Enter Animal Description: ");
                                                    String description1 = input.nextLine();
                                                    admin.addAnimal(species, sound, description1, AnimalID);
                                                    AnimalID++;
                                                    break;
                                                case 3:
                                                    System.out.println("Enter Animal ID: ");
                                                    Integer id2 = Integer.parseInt(input.nextLine());
                                                    admin.removeAnimal(id2);
                                                    break;
                                                case 4:
                                                    System.out.println("Enter Animal ID: ");
                                                    Integer id3 = Integer.parseInt(input.nextLine());
                                                    admin.updateAnimal(id3);
                                                    break;
                                                case 5:
                                                    break;
                                                default:
                                                    System.out.println("Invalid choice");
                                            }
                                            if (animalChoice==5){
                                                break;
                                            }
                                        }
                                        break;
                                    case 5:
                                        admin.viewAttraction();
                                        System.out.println("Enter Event ID: ");
                                        Integer id4 = Integer.parseInt(input.nextLine());
                                        System.out.println("Enter Event Price: ");
                                        Integer price1 = Integer.parseInt(input.nextLine());
                                        admin.scheduleEvent(id4, price1);
                                        break;
                                    case 6:
                                        admin.viewVisitorStats();
                                        break;
                                    case 7:
                                        admin.viewFeedback();
                                        break;
                                    case 8:
                                        break;
                                    default:
                                        System.out.println("Invalid choice");
                                }
                                if (adminChoice==8){
                                    break;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid choice");
                            }
                        }
                    }
                    else {
                        System.out.println("Incorrect password");
                    }
                }
                else if (choice==2){
                    System.out.println("1. Register");
                    System.out.println("2. Login");
                    Integer visitorChoice = Integer.parseInt(input.nextLine());
                    if (visitorChoice == 1){
                        System.out.println("Enter Visitor Email: ");
                        String email = input.nextLine();
                        while (!validateMail(email)) {
                            System.out.println("Invalid email");
                            email = input.nextLine();
                        }
                        System.out.println("Enter Visitor Password: ");
                        String password = input.nextLine();
                        System.out.println("Enter Visitor Name: ");
                        String name = input.nextLine();
                        System.out.println("Enter Visitor Age: ");
                        Integer age = Integer.parseInt(input.nextLine());
                        System.out.println("Enter Phone number: ");
                        String phone = input.nextLine();
                        while (!validateNumber(phone)) {
                            System.out.println("Invalid phone number");
                            phone = input.nextLine();
                        }
                        System.out.println("Enter Balance: ");
                        Double balance = Double.parseDouble(input.nextLine());
                        while (balance < 20) {
                            System.out.println("Balance must be at least 20");
                            balance = Double.parseDouble(input.nextLine());
                        }
                        zoo.getVisitors().add(new Visitor(name, age, phone, balance-20, email, password, zoo));
                        System.out.println("₹20.0 have been deducted from your balance, you are now a basic member.");
                        continue;
                    }
                    else if (visitorChoice == 2){
                        System.out.println("Enter Visitor Email: ");
                        String email = input.nextLine();
                        System.out.println("Enter Visitor Password: ");
                        String password = input.nextLine();
                        for (Visitor visitor1 : zoo.getVisitors()){
                            if (visitor1.checkLogin(email, password)){
                                visitor = visitor1;
                                break;
                            }
                        }
                        if (visitor == null){
                            System.out.println("Incorrect email or password");
                            continue;
                        }
                    }
                    while (true) {
                        if (Objects.equals(visitor.getUsertype(), "Basic")){
                            BasicMenu();
                            try {
                                Integer visitorChoice1 = Integer.parseInt(input.nextLine());
                                switch (visitorChoice1) {
                                    case 1:
                                        visitor.exploreZoo();
                                        break;
                                    case 2:
                                        visitor.buyMembership();
                                        break;
                                    case 3:
                                        visitor.buyTickets();
                                        break;
                                    case 4:
                                        visitor.viewDiscount();
                                        break;
                                    case 5:
                                        visitor.viewDeals();
                                        break;
                                    case 6:
                                        visitor.visitAnimals();
                                        break;
                                    case 7:
                                        visitor.visitAttractions();
                                        break;
                                    case 8:
                                        visitor.leaveFeedback();
                                        break;
                                    case 9:
                                        break;
                                    default:
                                        System.out.println("Invalid choice");
                                }
                                if (visitorChoice1 == 9) {
                                    break;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid choice");
                            }
                        } else {
                            PremiumMenu();
                            try {
                                Integer visitorChoice2 = Integer.parseInt(input.nextLine());
                                switch (visitorChoice2) {
                                    case 1:
                                        visitor.exploreZoo();
                                        break;
                                    case 2:
                                        visitor.visitAnimals();
                                        break;
                                    case 3:
                                        visitor.visitAttractions();
                                        break;
                                    case 4:
                                        visitor.leaveFeedback();
                                        break;
                                    case 5:
                                        break;
                                    default:
                                        System.out.println("Invalid choice");
                                }
                                if (visitorChoice2 == 5) {
                                    break;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid choice");
                            }
                        }
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice");
            }
        }
    }
    public static boolean validateMail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public static boolean validateNumber(String phoneNumber) {
        String phoneRegex = "^[0-9]{10}$";

        Pattern pattern = Pattern.compile(phoneRegex);
        Matcher matcher = pattern.matcher(phoneNumber);

        return matcher.matches();
    }
}