package Models;
import java.util.*;

public class Branch {
    private String name;
    private Address address;
    private String phone;
    private ArrayList<Employee> employees;
    private ArrayList<Location> locations;

    public Branch(String name, Address address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.employees = new ArrayList<Employee>();
        this.locations = new ArrayList<Location>();
    }

    public boolean addEmployee(Employee e) {
        boolean res = true;
        if(e != null)
            return employees.add(e);
        else
            res = false;
        return res;
    }

    public boolean addLocation(Location l) {
        boolean res = true;
        if(l != null)
            return locations.add(l);
        else
            res = false;
        return res;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String toString() {
        String res = "Branch:\n";
        res += "Name: " + name + "\n";
        res += "Address: " + address + "\n";
        res += "Phone: " + phone + "\n";
        if(!employees.isEmpty()) {
            res += "Employees:\n";
            for(Employee e : employees) {
                res += " - " + e.getFirstName() + "\n";
            }
        }
        
        if(!locations.isEmpty()) {
            res += "Locations:\n";
            for(Location l : locations) {
                res += " - " + l.getDepartment() + "\n";
            }
        }
        
        return res;
    }
}