public class Attraction {
    private String name;
    private final Integer id;
    private Integer price;
    private Boolean isAvailable = false;
    private String description;
    private Integer ticketCount = 0;
    private Integer visits = 0;
    //Constructor
    public Attraction(String name, Integer id, Integer price, String description){
        this.name = name;
        this.id = id;
        this.price = price;
        this.description = description;
    }

    //Getters
    public String getName() {
        return name;
    }
    public Integer getId() {
        return id;
    }
    public Integer getPrice() {
        return price;
    }
    public Boolean getIsAvailable() {
        return isAvailable;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    public Integer getTicketCount(){
        return this.ticketCount;
    }
    public Integer getVisits(){
        return this.visits;
    }
    public void tickets(){
        this.ticketCount++;
    }
    public void visits(){
        this.visits++;
    }
}