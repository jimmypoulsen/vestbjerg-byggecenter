package Models;

import java.util.HashMap;

public class OrderContainer {
   private static OrderContainer instance = null;
   private HashMap<Integer, Order> orders;

   private OrderContainer() {
       orders = new HashMap<>();
   }
   
   public static OrderContainer getInstance() {
       if(instance == null) {
           instance = new OrderContainer();
       } 
       return instance;
   }
   
   public Order addOrder(Order o) {
       return orders.put(o.getOrderId(), o);
   }
   
   public Order addOrderLine(Order o, OrderLine oL) {
       o.addOrderLine(oL);
       return o;
   }

   public Order setOrderTotal(Order o, double total) {
       o.setTotal(total);
       return o;
   }

   public HashMap<Integer, Order> findAllOrders() {
        return orders;
   }
   
   public int getLastOrderId() {
       int res = 0;
       Order o;
       if (!orders.isEmpty()) {
           o = orders.get(orders.size());
           res = o.getOrderId();
       }
       return res;
   }
}
