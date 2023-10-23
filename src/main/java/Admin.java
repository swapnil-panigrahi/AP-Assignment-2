import java.util.Scanner;

public class Admin implements Person{
    Scanner input = new Scanner(System.in);
    private final String adminName = "admin";
    private final String adminPassword = "admin123";
    private final Zoo zoo;
    //Constructor
    public Admin(Zoo zoo){
        this.zoo = zoo;
    }

    //Getters
    public String getUserName() {
        return this.adminName;
    }
    public String getPassword() {
        return this.adminPassword;
    }

    //Methods
    public boolean checkLogin(String name, String password) {
        return name.equals(this.adminName) && password.equals(this.adminPassword);
    }
    public void viewAttraction(){
        for (Attraction attraction : this.zoo.getAttractions()) {
            System.out.print("Attraction: "+attraction.getName()+" | ID: ");
            System.out.print(attraction.getId());
            System.out.print(" | Price: "+attraction.getPrice());
            System.out.println(" | Description: "+attraction.getDescription());
        }
    }
    public void addAttraction(String name, Integer id, Integer price, String description) {
        Attraction attraction = new Attraction(name, id, price, description);
        this.zoo.addAttraction(attraction);
    }
    public void removeAttraction(Integer id) {
        this.zoo.removeAttraction(id);
    }
    public void modifyAttraction(Integer id){
        for (Attraction attraction : this.zoo.getAttractions()) {
            if (attraction.getId().equals(id)) {
                System.out.println("Attraction:" + attraction.getName() + " ID:" + attraction.getId());
                System.out.println("1. Modify name");
                System.out.println("2. Modify price");
                System.out.println("3. Modify description");
                System.out.println("4. Exit");
                System.out.print("Enter your option:");
                try {
                    Integer choice = Integer.parseInt(input.nextLine());
                    switch (choice) {
                        case 1:
                            System.out.print("Enter new name:");
                            String name = input.nextLine();
                            attraction.setName(name);
                            break;
                        case 2:
                            System.out.print("Enter new price:");
                            Integer price = Integer.parseInt(input.nextLine());
                            attraction.setPrice(price);
                            break;
                        case 3:
                            System.out.println("Enter new description:");
                            String description = input.nextLine();
                            attraction.setDescription(description);
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("Invalid choice");
                    }
                }
                catch (NumberFormatException e) {
                    System.out.println("Invalid choice");
                    break;
                }
                break;
            }
        }
    }
    public void scheduleEvent(Integer id, Integer price){
        for (Attraction attraction : this.zoo.getAttractions()){
            if (attraction.getId().equals(id)){
                attraction.setPrice(price);
                attraction.setIsAvailable(true);
                break;
            }
        }
    }
    public void addAnimal(String species, String sound, String description, Integer id){
        System.out.println("What type of animal is it?");
        System.out.println("1. Reptile");
        System.out.println("2. Amphibian");
        System.out.println("3. Mammal");
        System.out.println("4. Exit");

        try {
            Integer choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    Reptile reptile = new Reptile(species, sound, description, id);
                    this.zoo.addAnimal(reptile);
                    break;
                case 2:
                    Amphibian amphibian = new Amphibian(species, sound, description, id);
                    this.zoo.addAnimal(amphibian);
                    break;
                case 3:
                    Mammal mammal = new Mammal(species, sound, description, id);
                    this.zoo.addAnimal(mammal);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } catch (NumberFormatException e){
            System.out.println("Invalid choice");
        }
    }
    public void removeAnimal(Integer id){
        this.zoo.removeAnimal(id);
    }
    public void updateAnimal(Integer id){
        for (Animal animal : this.zoo.getAnimals()) {
            if (animal.getId().equals(id)) {
                System.out.println("Animal:" + animal.getSpecies() + " ID:" + animal.getId());
                System.out.println("1. Modify species");
                System.out.println("2. Modify sound");
                System.out.println("3. Modify description");
                System.out.println("4. Exit");
                System.out.print("Enter your option:");
                try {
                    Integer choice = Integer.parseInt(input.nextLine());
                    switch (choice) {
                        case 1:
                            System.out.print("Enter new species:");
                            String species = input.nextLine();
                            animal.setSpecies(species);
                            break;
                        case 2:
                            System.out.print("Enter new sound:");
                            String sound = input.nextLine();
                            animal.setSound(sound);
                            break;
                        case 3:
                            System.out.print("Enter new description:");
                            String description = input.nextLine();
                            animal.setDesc(description);
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("Invalid choice");
                    }
                }
                catch (NumberFormatException e) {
                    System.out.println("Invalid choice");
                    break;
                }
                break;
            }
        }
    }
    public void addDiscount(String Code, Integer Percentage){
        Discount discount = new Discount(Code, Percentage);
        this.zoo.addDiscount(discount);
    }
    public void updateDiscount(String Code){
        this.zoo.updateDiscount(Code);
    }
    public void removeDiscount(String Code){
        this.zoo.removeDiscount(Code);
    }
    public void addDeals(String Code, Integer Percentage, Integer RequiredAttraction){
        SpecialDeals deals = new SpecialDeals(Code, Percentage, RequiredAttraction);
        this.zoo.addDeals(deals);
    }
    public void updateDeals(String Code){
        this.zoo.updateDeals(Code);
    }
    public void removeDeals(String Code){
        this.zoo.removeDeals(Code);
    }
    public void viewVisitorStats(){
        Integer total_visitor = 0;
        for (Visitor visitor : this.zoo.getVisitors()){
            if (visitor.isVisiting()){
                total_visitor++;
            }
        }
        Attraction popular = this.zoo.getAttractions().get(0);
        for (Attraction attraction : this.zoo.getAttractions()){
            if (attraction.getVisits() > popular.getVisits()){
                popular = attraction;
            }
        }
        Attraction ticket = this.zoo.getAttractions().get(0);
        for (Attraction attraction : this.zoo.getAttractions()){
            if (attraction.getTicketCount() > ticket.getTicketCount()){
                ticket = attraction;
            }
        }
        System.out.println("Total visitors: "+total_visitor);
        System.out.println("Total revenue: "+this.zoo.getRevenue());
        System.out.println("Most popular attraction: "+popular.getName());
        System.out.println("Most sold tickets: "+ticket.getName());
    }
    public void viewFeedback(){
        for (Visitor visitor : this.zoo.getVisitors()){
            System.out.println("Visitor: "+visitor.getName());
            System.out.println("Feedback: "+visitor.getFeedback());
        }
    }

    public void viewDiscounts() {
        for (Discount discount : this.zoo.getDiscounts()) {
            System.out.print("Code: "+discount.getCode());
            System.out.println(" | Percentage: "+discount.getPercentage());
        }
    }

    public void viewDeals() {
        for (SpecialDeals deals : this.zoo.getDeals()) {
            System.out.print("Code: "+deals.getCode());
            System.out.print(" | Percentage: "+deals.getPercentage());
            System.out.println(" | Required attractions: "+deals.getRequiredAttractions());
        }
    }

    public void viewAnimals() {
        for (Animal animal : this.zoo.getAnimals()) {
            System.out.print("Species: "+animal.getSpecies());
            System.out.print(" | Sound: "+animal.getSound());
            System.out.print(" | Description: "+animal.getDescription());
            System.out.println(" | ID: "+animal.getId());
        }
    }
}