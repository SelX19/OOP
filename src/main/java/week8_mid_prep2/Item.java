package week8_mid_prep2;

public abstract class Item implements Sellable{

    //class set to be abstract so that it is not instantiable
    private String barcode;
    private String name;
    private double price;

    //however, it may have a constructor which could be called from subclasses
    public Item(String barcode, String name, double price) {
        this.barcode = barcode;
        this.name = name;
        this.price = price;
    }

    //getters
    public String getBarcode(){
        return barcode;
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }

    //setters
    public void setBarcode(String barcode){
        this.barcode=barcode;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setPrice(double price){
        this.price=price;
    }

    //implementing Sellable methods - default implementation

    @Override
    public double calculateDiscount(double discountRate){
        return price*discountRate;
    }

    @Override
    public String getDescription(){
        return String.format("barcode : %s, name : %s, price : %.2f", barcode, name, price);
    }
}
