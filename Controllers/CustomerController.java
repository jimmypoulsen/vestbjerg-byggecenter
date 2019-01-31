package Controllers;

import Models.*;
import java.util.HashMap;

public class CustomerController {
    public Customer createCustomer(String firstName, String lastName, String cpr, String phone, String address, String city, int zip, String type) {
        int customerNo = CustomerContainer.getInstance().getLastCustomerNo() + 1;
        Customer c = new Customer(firstName, lastName, cpr, phone, address, city, zip, customerNo, type);
        CustomerContainer.getInstance().addCustomer(c);
        return c;
    }
    
    public boolean setCompany(Customer c, Company co) {
        CustomerContainer.getInstance().setCompany(c, co);
        return true;
    }
    
    public Customer getCustomer(int customerNo) {
        return CustomerContainer.getInstance().findCustomer(customerNo);
    }
    
    public HashMap<Integer, Customer> getCustomers() {
        return CustomerContainer.getInstance().findAllCustomers();
    }
}


