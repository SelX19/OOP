package week8_mid_prep2;

import java.sql.Date;
import java.util.Calendar;
import java.util.Map;

public class MainRun {

    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.NOVEMBER, 19);
        java.util.Date utilDate = calendar.getTime();
        Date sqlDate = new Date(utilDate.getTime());
        Date createdAt = sqlDate;

        Milk milk1 = new Milk("AB123", "Zbregovo", 3.5, 2.5);
        Milk milk2 = new Milk("AB123", "Zelene Doline", 4.5, 3.5);
        Honey honey1 = new Honey("IH357", "Livadski med", 15.5, HoneyType.LIVADSKI);
        Honey honey2 = new Honey("LS798", "Bagremov med", 17.5, HoneyType.BAGREMOV);

        Order<Milk> order_milk = new Order<>("123", createdAt);
        Order<Honey> order_honey = new Order<>("123", createdAt);

        Order<Milk> order_milk2 = new Order<>("317", createdAt);
        Order<Honey> order_honey2 = new Order<>("317", createdAt);

        order_milk.addItem(milk1, 200); //adding milk1 item to the list of milk orders, with initial quantity of 200ml
        order_milk.addItem(milk2, 200); //adding milk2 item to the list of milk orders, with initial quantity of 200ml
        order_milk.addItem(milk1, 300); // updating quantity of milk1 item to 500ml

        order_honey.addItem(honey1, 700);
        order_honey.addItem(honey2, 700);
        order_honey.addItem(honey1, 700); // so, updating order quantity of honey1 - livadski med - to 1400g

        order_milk2.addItem(milk2, 300);
        order_honey2.addItem(honey2, 700);
        order_honey2.addItem(honey2, 350);

        Person person1 = new Person("Selma Djozic", 22);
        Person person2 = new Person("Aleks Smith", 45);

        person1.addOrder(order_milk);
        person1.addOrder(order_honey);

        person2.addOrder(order_milk2);
        person2.addOrder(order_honey2);

        //Iterating through each customer’s order history - iterating through orders for specific customer,
        // displaying order details (including item names, prices,
        // and quantities) and calculating the total amount for each order.

        for(Order<? extends Item> order : person1.getOrders()) {
            System.out.println("order number: " + order.getOrderNo() + ", date of order: " + order.getCreateAt());
            for(Map.Entry<? extends Item, Integer> item : order.getItems().entrySet()){
                System.out.println(item.getKey().getDescription() + ", quantity : " + item.getValue());
            }
            System.out.printf("Total amount: %.2f\n\n", order.calculateTotalAmount());
        }

    }
}
