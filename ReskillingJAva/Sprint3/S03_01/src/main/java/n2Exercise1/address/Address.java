package n2Exercise1.address;

public abstract class Address {
    protected String street;
    protected String number;
    protected String floor;
    protected String door;
    protected String country;
    protected String city;
    protected String postalCode;
    
    public Address(String street, String number, String floor, String door, String city, String postalCode) {
        this.street = street;
        this.number = number;
        this.floor = floor;
        this.door = door;
        this.postalCode = postalCode;
        this.city = city;
    }
    
    public abstract String returnType();
    
    public String getStreet() {
        return street;
    }
    
    public void setStreet(String street) {
        this.street = street;
    }
    
    public String getNumber() {
        return number;
    }
    
    public void setNumber(String number) {
        this.number = number;
    }
    
    public String getFloor() {
        return floor;
    }
    
    public void setFloor(String floor) {
        this.floor = floor;
    }
    
    public String getDoor() {
        return door;
    }
    
    public void setDoor(String door) {
        this.door = door;
    }
    
    public String getCountry() {
        return country;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getPostalCode() {
        return postalCode;
    }
    
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    
    @Override
    public String toString() {
        return returnType() + ": \n" +
                street + ", " + number + ", " + floor + " " + door + ", " + postalCode + " " + city + ", " + country;
    }
}
