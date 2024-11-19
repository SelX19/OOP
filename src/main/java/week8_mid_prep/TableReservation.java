package week8_mid_prep;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TableReservation <T extends MenuItem & Billable>{

    private String reservationId;
    private Date reservationDate;
    HashMap<T, Integer> orderedItems;
    private int tableNumber;

    //constructor:
    public TableReservation(String reservationId, Date reservationDate, int tableNumber) {
        this.reservationId = reservationId;
        this.reservationDate = reservationDate;
        this.tableNumber = tableNumber;
        this.orderedItems = new HashMap<>();
    }

    //getters:
    public String getReservationId() {
        return reservationId;
    }
    public Date getReservationDate() {
        return reservationDate;
    }
    public int getTableNumber() {
        return tableNumber;
    }

    public HashMap<T, Integer> getOrderedItems() {
        return orderedItems;
    }

    //setters:
    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }
    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }
    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }
    public void setOrderedItems(HashMap<T, Integer> orderedItems) {
        this.orderedItems = orderedItems;
    }


    public void addItemToOrder(T item, int quantity){
        orderedItems.put(item, quantity);
    }

    public double calculateTotalAmount(){
        double totalAmount = 0.0;
        for(Map.Entry<T, Integer> entry : orderedItems.entrySet()){
            totalAmount+= entry.getKey().applyDiscount(10) * entry.getValue();
        } // key is the billable item(food/drink) from the menu for which we want to get the price and discount and multiply them together and with the quantity (.getValue - value in hashmap), for each item to get the total price of total order
        return totalAmount;
    }

}
