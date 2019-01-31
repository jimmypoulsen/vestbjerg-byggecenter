package Models;
import java.util.HashSet;

public class Employee extends Person {
    private int employeeNo;
    private String password;
    private String accessLevel;
    private String title;
    private Branch branch;
    private HashSet<Sale> sales;
    private HashSet<Loan> loans;
    private HashSet<Order> orders;

    public Employee(String firstName, String lastName, String cpr, String phone,
                    String address, int zip, String city, int employeeNo, String password, String accessLevel,
                    String title) {
        super(firstName, lastName, cpr, phone, address, city, zip);
        this.employeeNo = employeeNo;
        this.password = password;
        this.accessLevel = accessLevel;
        this.title = title;
        this.sales = new HashSet<Sale>();
        this.loans = new HashSet<Loan>();
        this.orders = new HashSet<Order>();        
    }

    public void setEmployeeNo(int employeeNo) {
        this.employeeNo = employeeNo;
    }
    
    public int getEmployeeNo() {
        return employeeNo;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }
    
    public String getAccessLevel() {
        return accessLevel;
    }   
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setBranch(Branch b) {
        this.branch = b;
    }
    
    public Branch getBranch() {
        return branch;
    }
    
    // toString method
 }
