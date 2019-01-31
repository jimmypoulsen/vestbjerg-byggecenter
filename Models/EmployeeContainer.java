package Models;

import java.util.HashMap;

public class EmployeeContainer {
   private static EmployeeContainer instance = null;
   private HashMap<Integer, Employee> employees;
   private Employee currentLoggedInEmployee = null;

   private EmployeeContainer() {
        employees = new HashMap<>();
   }
    
   public static EmployeeContainer getInstance() {
       if(instance == null) {
           instance = new EmployeeContainer();
       } 
       return instance;
   }    

   public Employee addEmployee(Employee e) {
       employees.put(e.getEmployeeNo(), e);
       return e;
   }
   
   public HashMap<Integer, Employee> findAllEmployees() {
	   return new HashMap<Integer, Employee>(employees);
   }

   public boolean performLogin(int employeeNo, String password) {
       // check if the employee exists
       if(employees.containsKey(employeeNo)) {
           // does the passwords match?
           if(employees.get(employeeNo).getPassword().equals(password)) {
               currentLoggedInEmployee = employees.get(employeeNo);
               return true;
           }
       }
       return false;
   }
   
   public boolean performLogout() {
	   this.currentLoggedInEmployee = null;
	   return true;
   }

   public Employee findCurrentLoggedInEmployee() {
       return currentLoggedInEmployee;
   }
   
   public boolean setBranch(Employee e, Branch b) {
        Employee temp = employees.get(e.getEmployeeNo());         
        temp.setBranch(b);
        employees.replace(e.getEmployeeNo(), temp);
        return true;
    }
   
   public int getLastEmployeeNo() {
       int res = 0;
       Employee e;
       if (!employees.isEmpty()) {
           e = employees.get(employees.size());
           res = e.getEmployeeNo();
       }
       return res;
   }
}