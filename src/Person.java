import java.util.ArrayList;

public class Person {
    private String name;
    private ArrayList<String> phoneNums;
    private Address address;

    public Person(String name, ArrayList<String> phoneNums) {
        this.name = name;
        this.phoneNums = phoneNums;
    }

    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getPhoneNums() {
        return phoneNums;
    }

    public Address getAddress() {
        return address;
    }
}
