package Models;

public class Address {
    public String address;
    public int zip;
    public String city;

    public Address(String address, int zip, String city) {
        this.address = address;
        this.zip = zip;
        this.city = city;
    }
    
    public String toString() {
        return address + ", " + zip + " " + city;
    }

    // no need for getters and setters when the attributes are public
}