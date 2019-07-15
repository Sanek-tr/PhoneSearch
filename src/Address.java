public class Address {
    private String street;
    private String city;

    public Address(String city, String street) {
        this.street = street;
        this.city = city;
    }

    @Override
    public String toString() {
        return street + " " + city;
    }
}
