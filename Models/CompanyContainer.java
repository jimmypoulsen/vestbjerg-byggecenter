package Models;

import java.util.HashSet;

public class CompanyContainer {
   private static CompanyContainer instance = null;
   private HashSet<Company> companies;
   
   private CompanyContainer() {
       companies = new HashSet<>();
   }
   
   public static CompanyContainer getInstance() {
       if(instance == null) {
           instance = new CompanyContainer();
       } 
       return instance;
   }
   
   //Hashset
   public Company addCompany(Company co) {
       companies.add(co);
       return co;
   }
}

