package week8_mid_prep;

import java.util.Date;

public class MainApplication {
    public static void main(String[] args) {

        Dish dish1 = new Dish("F123", "bolognese", 17.5, CuisineType.ITALIAN, "pasta");
        Drink drink1 = new Drink("D45", "wine", 10.0, 250.0);

        Restaurant restaurant = new Restaurant("Dolce Gusto");
        restaurant.addMenuItem(dish1);
        restaurant.addMenuItem(drink1);

        // Create reservations
        TableReservation<Dish> dishReservation = new TableReservation<>("R001", new Date(), 5);
        dishReservation.addItemToOrder(dish1, 3);

        TableReservation<Drink> drinkReservation = new TableReservation<>("R002", new Date(), 6);
        drinkReservation.addItemToOrder(drink1, 2);

        //creating customer
        Customer customer = new Customer("C001", "John Doe", "387-61-567-890");
        customer.addReservation(dishReservation);
        customer.addReservation(drinkReservation);

        // Add customer to restaurant
        restaurant.addCustomer(customer);

        //// Display Menu
        System.out.println("Menu:");
        restaurant.displayMenu();

        System.out.println();

        // Display reservation history and total sales
        System.out.println("Customer's Reservations:");
        for (TableReservation<? extends MenuItem> reservation : customer.getReservations()) {
            System.out.println("Reservation ID: " + reservation.getReservationId());
            System.out.println("Table Number: " + reservation.getTableNumber());
            System.out.println("Total Amount: $" + reservation.calculateTotalAmount());
            System.out.println();
        }

        // Display total sales
        System.out.println("Total Sales: $" + restaurant.calculateTotalSales());
    }

}
