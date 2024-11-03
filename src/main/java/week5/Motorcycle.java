package week5;

public class Motorcycle extends Vehicle{

    //1st constructor:

    public Motorcycle (String modelName){
        super(modelName);
    }

    //2nd constructor:

    public Motorcycle (String modelName, int mileAge, int health){
        super(modelName, mileAge, health);
    }

    @Override
    public String service(){
        String msg = "Lubricate chain and tune engine for ";
        return msg + this.getModelName() + ", with mileage " + this.getMileage() + " miles crossed, and health " + this.getHealth();
    }

    @Override
    public int expectedLifespan(){
        return 50000;
    }

    public void race(int raceMiles){
        this.setMileage(this.getMileage()+raceMiles);
        this.setHealth(this.getHealth()-raceMiles/500);
        if(this.getHealth() < 40){
            this.setMileage(this.getMileage()-5000);
        }
    }

}
