package week8_mid_prep;

public abstract class MenuItem implements Billable{
    private String code;
    private String name;
    private double price;

    // constructor:
    public MenuItem(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    //getters:
    public String getCode() {
        return code;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }

    //setters:
    public void setCode(String code) {
        this.code = code;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    //implementing Billable methods:
    @Override
    public String getDescription(){
        return String.format("Name: %s, Price: %.2f", name, price);
    }

    @Override
    public double applyDiscount(double discountRate){
        return price - (price * discountRate / 100); // returning discounted price
    }
}
