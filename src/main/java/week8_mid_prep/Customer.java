package week8_mid_prep;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String customerId;
    private String name;
    private String phoneNumber;
    List<TableReservation<? extends MenuItem>> reservations;

    // constructor:
    public Customer(String customerId, String name, String phoneNumber) {
        this.customerId = customerId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.reservations = new ArrayList<>();
    }

    public void addReservation(TableReservation<? extends MenuItem> reservation){
        reservations.add(reservation);
    }

    //getters:
    public String getCustomerId() {
        return customerId;
    }
    public String getName() {
        return name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public List<TableReservation<? extends MenuItem>> getReservations() {
        return reservations;
    }

    //setters:
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setReservations(List<TableReservation<? extends MenuItem>> reservations) {
        this.reservations = reservations;
    }

}
