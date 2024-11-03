package week5;

import java.util.Calendar;

public abstract class Vehicle {

    private String modelName;
    private int mileage;
    private int health; //0-100 -> implement

    //I have included one additional attribute lastServicedYear for the purpose of implementing simulateYear() method,


    private int lastServicedYear;

    //method overloading:

    //1st constructor - including default values:

    public Vehicle(String modelName){
        this.modelName = modelName;
        //default values: 0 and 100, used for mileage, and health, respectively
        this.mileage = 0;
        this.health = 100;
        this.lastServicedYear = Calendar.getInstance().get(Calendar.YEAR);
    }

    //2nd constructor - with specified values:

    public Vehicle(String modelName, int mileage, int health){
        this.modelName = modelName;
        this.mileage = mileage;
        this.health = health;
        this.lastServicedYear = Calendar.getInstance().get(Calendar.YEAR);
    }

    //getters:

    public String getModelName() {
        return modelName;
    }

    public int getMileage() {
        return mileage;
    }

    public int getHealth() {
        return health;
    }

    //setters:

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    //abstract methods - need to be implemented by subclasses - specific for each:

    public abstract String service();

    public abstract int expectedLifespan();

    //other methods:

    public boolean needsMaintenance() {
        return health<70;
    }

    public int calculateRemainingLifespan(int mileage){
        int lifeSpan = expectedLifespan();
        if(health<50){
            // reduce expected lifespan proportionally - by percentage of health:
            lifeSpan = (int) (lifeSpan * (health/100.0));
        }
        // also taking into consideration mileage:
        return lifeSpan - mileage;
    }

    public void simulateYear(){
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int passedYears = currentYear - lastServicedYear;

        if(passedYears > 0){
            for(int i =0; i<passedYears; i++){

                //increasing mileage annually:
                mileage += 10000;

                //decrease health if mileage exceeds half of the expected lifespan:
                if(mileage>expectedLifespan()/2){
                    health-=5;
                }

            }
            lastServicedYear = currentYear;
        }
    }

    //method to perform maintenance based on vehicle type:
    public void performMaintenance(Vehicle vehicle){
        if(vehicle instanceof Car){
            Car car = (Car) vehicle;
            System.out.println(car.repair());
            car.drive(500);
        }
        else if(vehicle instanceof Truck){
            Truck truck = (Truck) vehicle;
            System.out.println(truck.repair());
            truck.haul(6000);
        }
        else if(vehicle instanceof Motorcycle){
            Motorcycle motorcycle = (Motorcycle) vehicle;
            motorcycle.race(100);
        }
    }



}
