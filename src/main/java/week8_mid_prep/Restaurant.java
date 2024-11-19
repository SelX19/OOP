package week8_mid_prep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Restaurant {
    private String restaurantName;
    private List<Customer> customers; //list of customers who have made reservations
    private HashMap<String, MenuItem> menuItems; // map of all manu items available at the restaurant

    public Restaurant(String restaurantName){
        this.restaurantName = restaurantName;
        this.customers = new ArrayList<>();
        this.menuItems = new HashMap<>();
    }
    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    public void addMenuItem(MenuItem item){
        menuItems.put(item.getName(), item);
    }

    public Customer getCustomer(String customerId){
        for(Customer customer :customers){
            if(customer.getCustomerId().equals(customerId)){
                return customer;
            }
        }
        return null;
    }

    public void displayMenu() {
        for (MenuItem item : menuItems.values()) {
            System.out.println(item.getDescription());
        }
    }

    public double calculateTotalSales(){
        double totalSales = 0;
        for (Customer customer : customers) {
            for (TableReservation<? extends MenuItem> reservation : customer.getReservations()) {
                totalSales += reservation.calculateTotalAmount();
            }
        }
        return totalSales;
    }

    public String getRestaurantName() {
        return restaurantName;
    }
    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

}
