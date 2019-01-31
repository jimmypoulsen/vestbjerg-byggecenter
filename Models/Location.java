package Models;

import java.util.HashSet;

public class Location {
    private String department;
    private int shelfNo;
    private Branch branch;
    private HashSet<Item> items;
    
    public Location(String department, int shelfNo, Branch branch) {
        this.department = department;
        this.shelfNo = shelfNo;
        this.branch = branch;
        this.items = new HashSet<Item>();
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public void setShelfNo(int shelfNo) {
        this.shelfNo = shelfNo;
    }
    
    public int getShelfNo() {
        return shelfNo;
    }
    
    public void setBranch(Branch b) {
        this.branch = b;
    }
    
    public Branch getBranch() {
        return branch;
    }
}
