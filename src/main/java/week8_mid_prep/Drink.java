package week8_mid_prep;

public class Drink extends MenuItem{

    //additional attribute:
    private double volume; //in millilitres

    //constructor:
    public Drink(String code, String name, double price, double volume) {
        super(code, name, price);
        this.volume = volume;
    }

    //getter:
    public double getVolume() {
        return volume;
    }

    //setter:
    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Volume: " + this.getVolume();
    }
}
