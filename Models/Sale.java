package Models;
import java.util.*;

public class Sale {
	private int salesId;
    private PaymentType paymentType;
    private Date date;
    private OrderState state;
    private double total = 0;
    private HashSet<SalesLine> salesLines;
    private Employee employee;

    public Sale(Employee e) {
        this.date = new Date();
        this.state = OrderState.PENDING;
        this.salesLines = new HashSet<SalesLine>();
        this.employee = e;
    }

    public boolean addSalesLine(SalesLine salesLine) {
        return this.salesLines.add(salesLine);
    }
    
    public HashSet<SalesLine> getSalesLines() {
        return new HashSet<SalesLine>(salesLines);
    }
    
    public void setSalesId(int salesId) {
    	this.salesId = salesId;
    }
    
    public int getSalesId() {
    	return salesId;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
    @java.lang.Override
    public java.lang.String toString() {
        String res = "Sale:\n";
        res += "Payment type: " + paymentType + "\n";
        res += "Date: " + date + "\n";
        res += "State: " + state + "\n";
        res += "Total: " + total + "\n";
        if(!salesLines.isEmpty()) {
            for(SalesLine sL : salesLines) {
                res += "Order Line:\n";
                res += "Item name: " + sL.getItem().getName() + "\n";
                res += "Quantity: " + sL.getQuantity() + "\n";
                res += "Subtotal: " + sL.getItem().getPrice() * sL.getQuantity() + "\n";
            }
        }
        res += "Employee: " + employee.getFirstName() + "\n";
        
        return res;
    }
}