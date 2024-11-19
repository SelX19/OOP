package week8_mid_prep2;

public class Milk extends Item{

    private double fat;

    public Milk(String barcode, String name, double price, double fat){
        super(barcode, name, price);
        this.fat = fat;
    }

    public double getFat(){
        return fat;
    }

    public void setFat(double fat){
        this.fat = fat;
    }

    @Override
    public String getDescription(){
        return (super.getDescription() + String.format(", fat percentage : %.1f%%", fat));
    }
}
