package Models;
import java.util.*;

public class Company {
    private String name;
    private int discount = 5;
    private boolean status = true; // true = active, false = inactive
    private long CVR;
    private Address address;
    private Customer primaryCustomer;
    private HashSet<Customer> customers;

    public Company(String name, long CVR, Address address, Customer primaryCustomer) {
        this.name = name;
        this.CVR = CVR;
        this.address = address;
        this.primaryCustomer = primaryCustomer;
        this.customers = new HashSet<Customer>();
        this.customers.add(this.primaryCustomer);
    }

    public boolean addCustomer(Customer customer) {
        return this.customers.add(customer);
    }

    public String getName() { 
        return name; 
    }

    public void setName(String name) { 
        this.name = name; 
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public long getCVR() {
        return CVR;
    }

    public void setCVR(long CVR) {
        this.CVR = CVR;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Customer getPrimaryCustomer() {
        return primaryCustomer;
    }

    public void setPrimaryCustomer(Customer primaryCustomer) {
        this.primaryCustomer = primaryCustomer;
    }
   
    @java.lang.Override
    public java.lang.String toString() {
        String res = "Company:\n";
        res += "Discount: " + discount + "\n";
        res += "Status: " + status + "\n";
        res += "CVR: " + CVR + "\n";
        res += "Address: " + address + "\n";
        res += "Primary Customer: " + primaryCustomer.getFirstName() + "\n";
               
        if(!customers.isEmpty()) {
            res += "Customers:\n";
            for(Customer c : customers) {
                res += " - " + c.getFirstName() + "\n";
            }
        }
 
        return res;
    }
}