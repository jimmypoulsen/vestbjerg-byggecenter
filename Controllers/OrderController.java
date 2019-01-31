package Controllers;

import Models.*;
import java.util.HashMap;
import java.util.HashSet;

import GUI.InsufficientStockException;

public class OrderController {
	private Order currOrder;
	
    public Order newOrder(Customer c) {
        SessionsController sCtrl = new SessionsController();
        int id = OrderContainer.getInstance().getLastOrderId() + 1;
        currOrder = new Order(id, OrderState.PENDING, c, sCtrl.getCurrentLoggedInEmployee());
        return currOrder;
    }
    
    public Order createOrder(PaymentType pt) {
    	if(currOrder != null) {
	        double total = 0;
	        for(OrderLine oL : currOrder.getOrderLines())
	            total += oL.getSubtotal();
	        
	        currOrder.setTotal(total);
	        currOrder.setPaymentType(pt);
	        currOrder.setDelivery(true);
	        currOrder.setState(OrderState.COMPLETED);
	        OrderContainer.getInstance().addOrder(currOrder);
	        return currOrder;
    	} else
    		return null;
    }
    
    public Order createOrderLine(Item i, int quantity) throws InsufficientStockException {
    	if(currOrder != null) {
	        if(i.getStock() >= quantity) {
	        		OrderLine oL = new OrderLine(i, quantity);
	        		i.setStock(i.getStock() - quantity);
	        		return OrderContainer.getInstance().addOrderLine(currOrder, oL);
	        } else {
	        		throw new InsufficientStockException("Insufficient stock. Stock is " + i.getStock() + ".");
	        }
    	} else
    		return null;
    }
    
    public HashMap<Integer, Order> getOrders() {
        return OrderContainer.getInstance().findAllOrders();
    }
    
    public Order getCurrentOrder() {
    	return currOrder;
    }
    
    public HashSet<OrderLine> getCurrentOrderLines() {
    	return currOrder.getOrderLines();
    }
}

