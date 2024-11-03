package week5;

public class Car extends Vehicle implements Repairable{

    //1st constructor:

    public Car(String modelName){
        super(modelName);
    }

    //2nd constructor:

    public Car(String modelName, int mileage, int health){
        super(modelName, mileage, health);
    }

    @Override
    public String repair(){
        String msg = "Engine tuned and oil changed for ";
        return msg + this.getModelName();
    }

    @Override
    public String service(){
       String msg = "Check engine and change oil for ";
       return msg + this.getModelName() + ", with mileage " + this.getMileage() + " miles crossed, and health " + this.getHealth();
    }

    @Override
    public int expectedLifespan(){
        return 150000;
    }

    public void drive(int miles){
        //updating mileage using setter method, additionally implemented, and inherited from the Vehicle class
        this.setMileage(this.getMileage() + miles);
        //slight decrease in car´s health:
        this.setHealth(this.getHealth()-50);

        int lifespan = this.expectedLifespan();
        if(this.getHealth() < 30){
            lifespan-=10000;
        }
    }
}
