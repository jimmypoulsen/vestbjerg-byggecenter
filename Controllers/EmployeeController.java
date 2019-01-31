package Controllers;

import Models.*;
import java.util.HashMap;

public class EmployeeController {
    public Employee createEmployee(String firstName, String lastName, String cpr, String phone, String address, int zip, String city, String password, String accessLevel, String title) {
        Address a = new Address(address, zip, city);
        int employeeNo = EmployeeContainer.getInstance().getLastEmployeeNo() + 1;
        Employee e = new Employee(firstName, lastName, cpr, phone, address, zip, city, employeeNo, password, accessLevel, title);
        e = EmployeeContainer.getInstance().addEmployee(e);
        return e;
    }
    
    public HashMap<Integer, Employee> getAllEmployees() {
    	return EmployeeContainer.getInstance().findAllEmployees();
    }
}
