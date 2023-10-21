public class Discount {
    private String Code;
    private Integer Percentage;

    public Discount(String Code, Integer Percentage) {
        this.Code = Code;
        this.Percentage = Percentage;
    }

    public String getCode() {
        return Code;
    }
    public Integer getPercentage() {
        return Percentage;
    }
}