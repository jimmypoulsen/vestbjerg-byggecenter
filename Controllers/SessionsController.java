package Controllers;

import Models.*;

public class SessionsController {
    public boolean loginEmployee(int employeeNo, String password) {
    	if(EmployeeContainer.getInstance().performLogin(employeeNo, password))
            return true;
        return false;
    }
    
    public boolean logoutEmployee() {
    	if(EmployeeContainer.getInstance().performLogout())
    		return true;
    	return false;
    }

    public Employee getCurrentLoggedInEmployee() {
        return EmployeeContainer.getInstance().findCurrentLoggedInEmployee();
    }
}
