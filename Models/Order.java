package Models;
import java.util.*;

public class Order {
    private int orderId;
    private PaymentType paymentType;
    private Date date;
    private OrderState state;
    private Date paymentDue;
    private boolean delivery = false;
    private double total = 0;
    private HashSet<OrderLine> orderLines;
    private Customer customer;
    private Employee employee;

    public Order(int orderId, OrderState state, Customer customer, Employee employee) {
        this.orderId = orderId;
        this.date = new Date();
        this.state = state;
        this.paymentDue = new Date();
        this.orderLines = new HashSet<OrderLine>();
        this.customer = customer;
        this.employee = employee;
    }

    public boolean addOrderLine(OrderLine oL) {
    	total += oL.getSubtotal();
        return this.orderLines.add(oL);
    }
    
    public HashSet<OrderLine> getOrderLines() {
        return new HashSet<OrderLine>(orderLines);
    }
    
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    
    public int getOrderId() {
        return orderId;
    }
    
    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public Date getPaymentDue() {
        return paymentDue;
    }

    public void setPaymentDue(Date paymentDue) {
        this.paymentDue = paymentDue;
    }

    public boolean isDelivery() {
        return delivery;
    }

    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @java.lang.Override
    public java.lang.String toString() {
        String res = "Order:\n";
        res += "Payment type: " + paymentType + "\n";
        res += "Date: " + date + "\n";
        res += "State: " + state + "\n";
        res += "Payment due: " + paymentDue + "\n";
        if (delivery)
            res += "Levering: Ja\n";
        else
            res += "Levering: Nej\n";
        res += "Total: " + total + "\n";
        if(!orderLines.isEmpty()) {
            for(OrderLine oL : orderLines) {
                res += "Order Line:\n";
                res += "Item name: " + oL.getItem().getName() + "\n";
                res += "Quantity: " + oL.getQuantity() + "\n";
                res += "Subtotal: " + oL.getItem().getPrice() * oL.getQuantity() + "\n";
            }
        }
        res += "Employee: " + employee.getFirstName() + "\n";
        
        return res;
    }
}