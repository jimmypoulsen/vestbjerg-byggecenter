package Controllers;

import Models.*;
import java.util.ArrayList;

public class BranchController {
    
    public Branch createBranch(String name, String address, int zip, String city, String phone) {
        Address a = new Address(address, zip, city);
        Branch b = BranchContainer.getInstance().addBranch(new Branch(name, a, phone));
        return b;
    }
    
    public void addEmployee(String branchName, Employee e) {
        Branch b = getBranch(branchName);
        BranchContainer.getInstance().addEmployee(b, e);
    }
    
    public void addLocation(String branchName, Location l) {
        Branch b = getBranch(branchName);
        BranchContainer.getInstance().addLocation(b, l);
    }
    
    public Branch getBranch(String name) {
        return BranchContainer.getInstance().findBranch(name);
    }
    
    public ArrayList<Branch> getAllBranches() {
    	return BranchContainer.getInstance().findAllBranches();
    }
    
    public Branch getFirstBranch() {
    	return BranchContainer.getInstance().findFirstBranch();
    }
}
