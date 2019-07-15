import java.util.*;

public class AddressBook {
    private Map<String, List<Address>> addressBook = new HashMap<String, List<Address>>();

    public void addAddress(String name, String city, String street) {
        List<Address> personsAddresses = addressBook.get(name);
        if (personsAddresses == null) {
            personsAddresses = new ArrayList<Address>();
            addressBook.put(name, personsAddresses);
        }
        personsAddresses.add(new Address(city, street));
    }

    public List<Address> findAddress(String name){
        return addressBook.get(name);
    }

    public void deleteRecord(String name){
        addressBook.remove(name);
    }

    public Set<String> filterKeys(String query){
        Set<String> results = new HashSet<String>();
        for (Map.Entry<String, List<Address>> entry : addressBook.entrySet()){
            String person = entry.getKey();

            if (person.contains(query) || addressContainsQuery(entry.getValue(), query)){
                results.add(person);
            }
        }
        return results;
    }

    private boolean addressContainsQuery(List<Address> addresses, String query){
        for (Address address : addresses){
            if (address.toString().contains(query)){
                return true;
            }
        }
        return false;
    }
}
