package Models;
import java.util.HashMap;

public class CustomerContainer {
    private static CustomerContainer instance = null;
    private HashMap<Integer, Customer> customers;

    private CustomerContainer() {
        customers = new HashMap<>();
    }

    public static CustomerContainer getInstance() {
        if(instance == null) {
            instance = new CustomerContainer();
        }
        return instance;
    }
    
    public Customer addCustomer(Customer c) {
        return customers.put(c.getCustomerNo(), c);
    }
    
    public boolean setCompany(Customer c, Company co) {
        Customer temp = customers.get(c.getCustomerNo());         
        temp.setCompany(co);
        customers.replace(c.getCustomerNo(), temp);
        return true;
    }
   
    public Customer findCustomer(int customerNo) {
        return customers.get(customerNo);
    }
    
    public HashMap<Integer, Customer> findAllCustomers() {
        return customers;
    }
    
    public int getLastCustomerNo() {
        int res = 0;
        Customer c;
        if (!customers.isEmpty()) {
            c = customers.get(customers.size());
            res = c.getCustomerNo();
        }
        return res;
    }
}