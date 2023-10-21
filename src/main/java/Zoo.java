import java.util.Vector;

public class Zoo {
    private final Vector<Visitor> visitors;
    private final Vector<Attraction> attractions;
    private final Vector<Animal> animals;
    private final Vector<Discount> discounts;
    private final Vector<SpecialDeals> deals;
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

    public void addAttraction(Attraction attraction){
        this.attractions.add(attraction);
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

    public void removeAttraction(Integer id) {
        for (Attraction attraction : this.attractions) {
            if (attraction.getId().equals(id)) {
                this.attractions.remove(attraction);
                break;
            }
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
    public void removeDiscount(String Code){
        if (Code.equals("CHILDREN") || Code.equals("SENIOR")) {
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
    public void removeDeals(String Code){
        for (SpecialDeals deals : this.deals) {
            if (deals.getCode().equals(Code)) {
                this.deals.remove(deals);
                break;
            }
        }
    }

}