public class Attraction {
    private String name;
    private final Integer id;
    private Integer price;
    private Boolean isAvailable = false;
    //Constructor
    public Attraction(String name, Integer id, Integer price){
        this.name = name;
        this.id = id;
        this.price = price;
    }

    //Getters
    public String getName() {
        return name;
    }
    public Integer getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}