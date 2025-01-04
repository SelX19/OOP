package week13.Task6;

import java.util.ArrayList;
import java.util.List;

public class Coffee {
    private String type;
    private String size;
    private List<String> toppings;

    private Coffee(Builder builder) {
        this.type = builder.type;
        this.size = builder.size;
        this.toppings = builder.toppings;
    }

    @Override
    public String toString() {
        return "Coffee [Type=" + type + ", Size=" + size + ", Toppings=" + toppings + "]";
    }

    // Static Builder Class
    static class Builder implements CoffeeBuilder {
        private String type;
        private String size;
        private List<String> toppings = new ArrayList<>();

        @Override
        public CoffeeBuilder buildType(String type) {
            this.type = type;
            return this;
        }

        @Override
        public CoffeeBuilder buildSize(String size) {
            this.size = size;
            return this;
        }

        @Override
        public CoffeeBuilder buildToppings(List<String> toppings) {
            this.toppings.addAll(toppings);
            return this;
        }

        @Override
        public Coffee build() {
            return new Coffee(this);
        }
    }

    }
