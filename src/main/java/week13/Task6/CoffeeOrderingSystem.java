package week13.Task6;

import java.util.List;

//main class - client code:
public class CoffeeOrderingSystem {
    public static void main(String[] args) {
        CoffeeDirector director = new CoffeeDirector();

        // Create Espresso Order
        EspressoBuilder espressoBuilder = new EspressoBuilder();
        Coffee espresso = director.constructCoffee(espressoBuilder, "Small", List.of("Sugar"));
        System.out.println(espresso);

        // Create Latte Order
        LatteBuilder latteBuilder = new LatteBuilder();
        Coffee latte = director.constructCoffee(latteBuilder, "Medium", List.of("Milk", "Vanilla"));
        System.out.println(latte);

        // Create Cappuccino Order
        CappuccinoBuilder cappuccinoBuilder = new CappuccinoBuilder();
        Coffee cappuccino = director.constructCoffee(cappuccinoBuilder, "Large", List.of("Cinnamon", "Whipped Cream"));
        System.out.println(cappuccino);
    }
}
