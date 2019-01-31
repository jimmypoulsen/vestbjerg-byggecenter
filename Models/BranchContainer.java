package Models;

import java.util.ArrayList;
import java.util.Iterator;

public class BranchContainer {
   private static BranchContainer instance = null;
   private ArrayList<Branch> branches;
   
   private BranchContainer() {
       branches = new ArrayList<>();
   }
   
   public static BranchContainer getInstance() {
       if(instance == null) {
           instance = new BranchContainer();
       } 
       return instance;
   }
   
   public Branch addBranch(Branch b) {
       branches.add(b);
       return b;
   }
   
   public void addEmployee(Branch b, Employee e) {
       b.addEmployee(e);
   }
   
   public void addLocation(Branch b, Location l) {
       b.addLocation(l);
   }
   
   public Branch findBranch(String name) {
       Branch current = null;
       Branch res = null;
       int index = 0;
       boolean found = false;
       int size = branches.size();
       while (index < size && !found) {
           current = branches.get(index);
           if(current.getName().equals(name)) {
               found = true;
           } else {
               index++;
           }
       }
       if (found) {
           res = branches.get(index);
       }
       return res;
   }
   
   public ArrayList<Branch> findAllBranches() {
	   return new ArrayList<Branch>(branches);
   }
   
   public Branch findFirstBranch() {
	   Iterator<Branch> bIterator = branches.iterator();
	   return bIterator.next();
   }
}
