package Models;

public abstract class Person {
    private String firstName;
    private String lastName;
    private String cpr;
    private String phone;
    private String address;
    private String city;
    private int zip;

    public Person(String firstName, String lastName, String cpr, String phone,
                    String address, String city, int zip) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cpr = cpr;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.zip = zip;        
    }
    
    public String getFirstName() {
        return this.firstName;
    }
    
    public String getLastName() {
    	return this.lastName;
    }
    
    public String getFullName() {
    	return this.firstName + " " + this.lastName;
    }
    
    public String getPhone() {
    	return this.phone;
    }
    
}
