package Controllers;

import Models.*;

public class CompanyController {
    
    public Company createCompany(String name, long cvr, String address, int zip, String city, Customer primary) {
        Address a = new Address(address, zip, city);
        Company co = CompanyContainer.getInstance().addCompany(new Company(name, cvr, a, primary));
        return co;
    }
}
