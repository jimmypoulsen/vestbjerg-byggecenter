package Models;
import java.util.HashSet;

public class Customer extends Person {
    private int customerNo;
    private String type;
    private Company company;
    private HashSet<Loan> loans;
    private HashSet<Order> orders;    

    public Customer(String firstName, String lastName, String cpr, String phone,
                    String address, String city, int zip, int customerNo, String type) {
        super(firstName, lastName, cpr, phone, address, city, zip);
        this.customerNo = customerNo;
        this.type = type;
        this.company = null;
        this.loans = new HashSet<Loan>();
        this.orders = new HashSet<Order>();
    }

    public void setCustomerNo(int customerNo) {
        this.customerNo = customerNo;
    }
    
    public int getCustomerNo() {
        return customerNo;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public String getType() {
        return type;
    }  
    
    public void setCompany(Company c) {
        this.company = c;
    }
    
    public Company getCompany() {
        return company;
    }

    @java.lang.Override
    public java.lang.String toString() {
        String res = "Customer:\n";
        res += "Customer name: " + getFirstName() + "\n";
        res += "Customer no: " + customerNo + "\n";
        res += "Type: " + type + "\n";
        res += "Company: " + company.getName() + "\n";
        return res;
    }
}

