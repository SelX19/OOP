package week13.Task6;

import java.util.List;

// Builder Interface
interface CoffeeBuilder {
    CoffeeBuilder buildType(String type);
    CoffeeBuilder buildSize(String size);
    CoffeeBuilder buildToppings(List<String> toppings);
    Coffee build();
}
