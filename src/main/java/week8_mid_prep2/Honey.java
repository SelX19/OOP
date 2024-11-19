package week8_mid_prep2;

public class Honey extends Item {

    private HoneyType honeyType;

    public Honey(String barcode, String name, double price, HoneyType honeyType) {
        super(barcode, name, price);
        this.honeyType = honeyType;}

    public HoneyType getHoneyType(){
        return honeyType;
    }

    public void setHoneyType(HoneyType honeyType){
        this.honeyType = honeyType;
    }

    @Override
    public String getDescription() {
        return (super.getDescription() + String.format(", honey type : %s", honeyType));
    }
}
