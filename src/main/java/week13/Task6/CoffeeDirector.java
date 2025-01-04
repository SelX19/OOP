package week13.Task6;

import java.util.List;

public class CoffeeDirector {
    public Coffee constructCoffee(Coffee.Builder builder, String size, List<String> toppings) {
        return builder
                .buildSize(size)
                .buildToppings(toppings)
                .build();
    }
}
