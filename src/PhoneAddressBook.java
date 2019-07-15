import java.util.*;

public class PhoneAddressBook {
//    String syote = "1\npekka\n09-12345\n4\npekka\nmannerheimintie\nhelsinki\n5\nseppo\nx\n";
//    private Scanner scanner = new Scanner(syote);
    private Scanner scanner = new Scanner(System.in);
    private PhoneBook phoneBook = new PhoneBook();
    private AddressBook addressBook = new AddressBook();

    public void start(){
        printMenu();
        while (true){
            System.out.println("");
            System.out.print("command: ");
            String command = scanner.nextLine();
            if (command.equals("1")){
                addPhoneNumber();
            } else if (command.equals("2")){
                findPhoneNumber();
            } else if (command.equals("3")){
                findPersonByPhoneNumber();
            } else if (command.equals("4")){
                addAddress();
            } else if (command.equals("5")){
                findPersonalInfo();
            } else if (command.equals("6")){
                deletePersonalInfo();
            } else if (command.equals("7")){
                filterPersonalInfo();
            } else if (command.equals("x")){
                break;
            }
        }
        scanner.close();
    }

    public void printMenu(){
        System.out.println("phone search");
        System.out.println("available operations:");
        System.out.println(" 1 add a number");
        System.out.println(" 2 search for a number");
        System.out.println(" 3 search for a person by phone number");
        System.out.println(" 4 add an address");
        System.out.println(" 5 search for personal information");
        System.out.println(" 6 delete personal information");
        System.out.println(" 7 filtered listing");
        System.out.println(" x quit");
    }

    public void addPhoneNumber(){
        System.out.print("whose number: ");
        String name = scanner.nextLine();
        System.out.print("number: ");
        String number = scanner.nextLine();
        phoneBook.addPhoneNumber(name, number);
    }

    public void findPhoneNumber(){
        System.out.print("whose number: ");
        String name = scanner.nextLine();
        List<String> phoneNumbers = phoneBook.findPhoneNumber(name);
        if (phoneNumbers == null){
            System.out.println(" not found");
        } else {
            for (String phoneNumber : phoneNumbers){
                System.out.println(" " + phoneNumber);
            }
        }
    }

    public void findPersonByPhoneNumber(){
        System.out.print("number: ");
        String number = scanner.nextLine();
        String name = phoneBook.findPersonByPhoneNumber(number);
        if (name == null){
            System.out.println(" not found");
        } else {
            System.out.println(" " + name);
        }
    }

    public void addAddress(){
        System.out.print("whose address: ");
        String name = scanner.nextLine();
        System.out.print("street: ");
        String street = scanner.nextLine();
        System.out.print("city: ");
        String city = scanner.nextLine();
        addressBook.addAddress(name, city, street);
    }

    public void findPersonalInfo(){
        System.out.print("whose information: ");
        String name = scanner.nextLine();
        printPersonalInfo(name);
    }

    public void deletePersonalInfo(){
        System.out.print("whose information: ");
        String name = scanner.nextLine();
        phoneBook.deleteRecord(name);
        addressBook.deleteRecord(name);
    }

    private void printPersonalInfo(String name){
        List<Address> addresses = addressBook.findAddress(name);
        List<String> phoneNumbers = phoneBook.findPhoneNumber(name);
        if (addresses == null && phoneNumbers == null){
            System.out.println(" not found");
            return;
        }
        if (addresses == null){
            System.out.println("  address unknown");
        } else {
            for (Address address : addresses){
                System.out.print("  address: ");
                System.out.println(address);
            }
        }
        if (phoneNumbers == null){
            System.out.println("  phone number not found");
        } else {
            for (String phoneNumber : phoneNumbers){
                System.out.println("  " + phoneNumber);
            }
        }
    }

    public void filterPersonalInfo(){
        System.out.print("keyword (if empty, all listed): ");
        String keyword = scanner.nextLine();
        Set<String> phoneBookNames = phoneBook.filterKeys(keyword);
        Set<String> addressBookNames = addressBook.filterKeys(keyword);
        phoneBookNames.addAll(addressBookNames);
        if (phoneBookNames.isEmpty()){
            System.out.println(" keyword not found");
        }
        List<String> list = new ArrayList<String>(phoneBookNames);
        Collections.sort(list);
        for (String name : list){
            System.out.println();
            System.out.println(" " + name);
            printPersonalInfo(name);
        }
    }

}
