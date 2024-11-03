package week5;

public class Truck extends Vehicle implements Repairable{

    //1st constructor:

    public Truck(String modelName){
        super(modelName);
    }

    //2nd constructor:

    public Truck(String modelName, int mileAge, int health){
        super(modelName, mileAge, health);
    }

    @Override
    public String repair(){
        String msg = "Engine overhauled and tires replaced for ";
        return msg + this.getModelName();
    }

    @Override
    public String service(){
        String msg = "Inspect engine and replace filters for ";
        return msg + this.getModelName() + ", with mileage " + this.getMileage() + " miles crossed, and health " + this.getHealth();
    }

    @Override
    public int expectedLifespan(){
        return 300000;
    }

    public void haul(int loadWeight){
        int typical_load = 5000;
        int health = this.getHealth();
        if(loadWeight > typical_load){
            int extra_strain = loadWeight - typical_load;
            health-= extra_strain;
        }
        if(health < 50){
            int lifespan = this.calculateRemainingLifespan(20000);
        }
    }

}
