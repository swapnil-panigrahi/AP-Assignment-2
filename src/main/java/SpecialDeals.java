public class SpecialDeals extends Discount {
    private final int requiredAttractions;

    public SpecialDeals(String code, int percentage, int requiredAttractions) {
        super(code, percentage);
        this.requiredAttractions = requiredAttractions;
    }

    public int getRequiredAttractions() {
        return requiredAttractions;
    }
}