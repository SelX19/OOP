package week5;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List <Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("Toyota Corolla", 5000, 90));
        vehicles.add(new Truck("Ford F-150", 10000, 80));
        vehicles.add(new Motorcycle("Harley Davidson", 3000, 85));

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.service());
            vehicle.simulateYear();

            //down casting:

            if (vehicle instanceof Car) {
                Car car = (Car) vehicle;
                car.drive(300);
            } else if (vehicle instanceof Truck) {
                Truck truck = (Truck) vehicle;
                truck.haul(6000);
            } else if (vehicle instanceof Motorcycle) {
                Motorcycle motorcycle = (Motorcycle) vehicle;
                motorcycle.race(150);
            }

            vehicle.performMaintenance(vehicle);

            System.out.println("\n");
        }

    }
}
