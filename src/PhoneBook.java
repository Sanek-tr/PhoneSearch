import java.util.*;

public class PhoneBook {
    private Map<String, List<String>> phoneBook = new HashMap<String, List<String>>();

    public void addPhoneNumber(String name, String phoneNum) {
        List<String> personsPhoneNums = phoneBook.get(name);
        if (personsPhoneNums == null) {
            personsPhoneNums = new ArrayList<String>();
            phoneBook.put(name, personsPhoneNums);
        }
        personsPhoneNums.add(phoneNum);
     }

    public List<String> findPhoneNumber(String name){
        return phoneBook.get(name);
    }

    public String findPersonByPhoneNumber(String phoneNum){
        for (Map.Entry<String, List<String>> contact : phoneBook.entrySet()){
            List<String> personsPhoneNums = contact.getValue();
            if (personsPhoneNums.contains(phoneNum)){
                return contact.getKey();
            }
        }
        return null;
    }

    public void deleteRecord(String name){
        phoneBook.remove(name);
    }

    public Set<String> filterKeys(String query){
        Set<String> persons = phoneBook.keySet();
        Set<String> results = new HashSet<String>();
        for (String person : persons){
            if (person.contains(query)){
                results.add(person);
            }
        }
        return results;
    }
}
