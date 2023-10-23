import java.util.Scanner;
import java.util.Vector;

public class Zoo {
    Scanner input = new Scanner(System.in);
    private final Vector<Visitor> visitors;
    private final Vector<Attraction> attractions;
    private final Vector<Animal> animals;
    private final Vector<Discount> discounts;
    private final Vector<SpecialDeals> deals;
    private Double revenue = 0.0;
    private Integer mammals = 0;
    private Integer amphibians = 0;
    private Integer reptiles = 0;

    public Zoo(){
        this.visitors = new Vector<>();
        this.attractions = new Vector<>();
        this.animals = new Vector<>();
        this.discounts = new Vector<>();
        this.deals = new Vector<>();
    }

    public Vector<Attraction> getAttractions() {
        return this.attractions;
    }
    public Vector<Animal> getAnimals() {
        return this.animals;
    }
    public Vector<Visitor> getVisitors() {
        return this.visitors;
    }
    public Vector<Discount> getDiscounts(){ return this.discounts; }
    public Vector<SpecialDeals> getDeals(){ return this.deals; }

    public void viewAttractions(){
        try {
            for (Attraction attraction : this.attractions){
                System.out.println(attraction.getId()+". "+attraction.getName());
            }
            System.out.println("Enter attraction id to view details: ");
            boolean flag = true;
            Integer choice = Integer.parseInt(input.nextLine());
            for (Attraction attraction : this.attractions){
                if (attraction.getId().equals(choice)){
                    System.out.println(attraction.getName());
                    System.out.println(attraction.getPrice());
                    if (attraction.getIsAvailable()) System.out.println("Available");
                    else System.out.println("Not available");
                    flag = false;

                    break;
                }
            }
            if (flag) System.out.println("Invalid choice");
        } catch (NumberFormatException e) {
            System.out.println("Invalid choice");
        }
    }
    public void addAttraction(Attraction attraction){
        this.attractions.add(attraction);
    }
    public void removeAttraction(Integer id) {
        for (Attraction attraction : this.attractions) {
            if (attraction.getId().equals(id)) {
                this.attractions.remove(attraction);
                break;
            }
        }
    }
    public void viewAnimals(){
        try {
            for (Animal animal : this.animals){
                System.out.println(animal.getId()+". "+animal.getSpecies());
            }
            boolean flag = true;
            Integer choice = Integer.parseInt(input.nextLine());
            for (Animal animal : this.animals){
                if (animal.getId().equals(choice)){
                    System.out.println("Species: "+animal.getSpecies());
                    System.out.println("Sound: "+animal.getSound());
                    System.out.println("Description: "+animal.getDescription());
                    flag = false;

                    break;
                }
            }
            if (flag) System.out.println("Invalid choice");
        } catch (NumberFormatException e) {
            System.out.println("Invalid choice");
        }
    }
    public void addAnimal(Object animal) {
        if (animal.getClass()==Mammal.class){
            this.mammals++;
        }
        if (animal.getClass()==Amphibian.class){
            this.amphibians++;
        }
        if (animal.getClass()==Reptile.class){
            this.reptiles++;
        }
        this.animals.add((Animal) animal);
    }
    public void removeAnimal(Integer id) {
        for (Animal animal : this.animals) {
            if (animal.getId().equals(id)) {
                if (animal.getClass()==Mammal.class){
                    if (mammals>2){
                        this.mammals--;
                        this.animals.remove(animal);
                    }
                    else System.out.println("There must be at least 2 mammals in the zoo");
                }
                if (animal.getClass()==Amphibian.class){
                    if (amphibians>2) {
                        this.amphibians--;
                        this.animals.remove(animal);
                    }
                    else System.out.println("There must be at least 2 amphibians in the zoo");
                }
                if (animal.getClass()==Reptile.class){
                    if (reptiles>2) {
                        this.reptiles--;
                        this.animals.remove(animal);
                    }
                    else System.out.println("There must be at least 2 reptiles in the zoo");
                }

                break;
            }
        }
    }
    public void addDiscount(Discount discount){
        this.discounts.add(discount);
    }
    public void updateDiscount(String Code){
        if (Code.equals("MINOR10") || Code.equals("SENIOR20")) {
            System.out.println("Cannot modify default discount");
            return;
        }
        for (Discount discount : this.discounts) {
            if (discount.getCode().equals(Code)) {
                System.out.println("Discount: "+ discount.getCode());
                System.out.println("1. Modify discount");
                System.out.println("2. Exit");
                try {
                    int choice = Integer.parseInt(input.nextLine());
                    switch (choice) {
                        case 1:
                            System.out.print("Enter new percentage:");
                            Integer percentage = Integer.parseInt(input.nextLine());
                            discount.setPercentage(percentage);
                            break;
                        case 2:
                            break;
                        default:
                            System.out.println("Invalid choice");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid choice");
                }
            }
        }
    }
    public void removeDiscount(String Code){
        if (Code.equals("MINOR10") || Code.equals("SENIOR20")) {
            System.out.println("Cannot remove default discount");
            return;
        }
        for (Discount discount : this.discounts) {
            if (discount.getCode().equals(Code)) {
                this.discounts.remove(discount);
                break;
            }
        }
    }
    public void addDeals(SpecialDeals deals){
        this.deals.add(deals);
    }
    public void updateDeals(String Code){
        if (Code.equals("15FOR2") || Code.equals("30FOR3")) {
            System.out.println("Cannot modify default deals");
            return;
        }
        for (SpecialDeals deals : this.deals) {
            if (deals.getCode().equals(Code)) {
                System.out.println("Deals: "+ deals.getCode());
                System.out.println("1. Modify discount");
                System.out.println("2. Modify minimum attraction");
                System.out.println("3. Exit");
                try {
                    int choice = Integer.parseInt(input.nextLine());
                    switch (choice) {
                        case 1:
                            System.out.print("Enter new percentage:");
                            Integer percentage = Integer.parseInt(input.nextLine());
                            deals.setPercentage(percentage);
                            break;
                        case 2:
                            System.out.print("Enter new minimum attraction:");
                            Integer RequiredAttraction = Integer.parseInt(input.nextLine());
                            deals.setRequiredAttraction(RequiredAttraction);
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("Invalid choice");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid choice");
                }
            }
        }
    }
    public void removeDeals(String Code){
        if (Code.equals("15FOR2") || Code.equals("30FOR3")) {
            System.out.println("Cannot remove default deals");
            return;
        }
        for (SpecialDeals deals : this.deals) {
            if (deals.getCode().equals(Code)) {
                this.deals.remove(deals);
                break;
            }
        }
    }
    public Integer applyDeals(Integer tickets){
        for (SpecialDeals deals : this.deals) {
            if (deals.getRequiredAttractions()==tickets) {
                System.out.println("Deals applied!");
                return deals.getPercentage();
            }
        }
        return 0;
    }
    public void addRevenue(Double revenue){
        this.revenue += revenue;
    }

    public Double getRevenue() {
        return revenue;
    }
}