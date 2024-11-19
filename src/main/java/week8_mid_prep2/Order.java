package week8_mid_prep2;

import java.util.Date;
import java.util.HashMap;

public class Order <T extends Item & Sellable>{

    private String orderNo;
    private Date createAt;
    private HashMap<T, Integer> items;

    public Order(String orderNo, Date createAt) {
        this.orderNo = orderNo;
        this.createAt = createAt;
        this.items = new HashMap<>();
    }

    public String getOrderNo() {
        return orderNo;
    }
    public Date getCreateAt() {
        return createAt;
    }
    public HashMap<T, Integer> getItems() {
        return items;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
    public void setItems(HashMap<T, Integer> items) {
        this.items = items;
    }

    //Provide a method addItem(T item, int quantity) to add an item to the order.
    // If item is already in the order just update the quantities
    public void addItem(T item, int quantity){
        items.put(item, items.getOrDefault(item, 0) + quantity);
    }

    public double calculateTotalAmount(){
        double totalAmount = 0;
        for(T item : items.keySet()){
            totalAmount += item.getPrice() * items.get(item); // price * quantity for each item
        }
        return totalAmount;
    }

}
