public class SpecialDeals extends Discount {
    private int requiredAttractions;

    public SpecialDeals(String code, int percentage, int requiredAttractions) {
        super(code, percentage);
        this.requiredAttractions = requiredAttractions;
    }

    public int getRequiredAttractions() {
        return requiredAttractions;
    }

    public void setRequiredAttraction(Integer requiredAttraction) {
        this.requiredAttractions = requiredAttraction;
    }
}