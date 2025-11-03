import java.util.*;

interface PhoneBook {
    void add(String lastName, String phoneNumber);
    List<String> get(String lastName);
}
class SimplePhoneBook implements PhoneBook {
    private Map<String, List<String>> contacts;

    public SimplePhoneBook() {
        this.contacts = new HashMap<>();
    }
    @Override
    public void add(String lastName, String phoneNumber) {
        contacts.putIfAbsent(lastName, new ArrayList<>());
        contacts.get(lastName).add(phoneNumber);
    }
    @Override
    public List<String> get(String lastName) {
        return contacts.getOrDefault(lastName, new ArrayList<>());
    }
    public void printAllContacts() {
        for (Map.Entry<String, List<String>> entry : contacts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new SimplePhoneBook();

        phoneBook.add("Иванов", "+7-911-456-7890");
        phoneBook.add("Петров", "+7-911-654-3210");
        phoneBook.add("Иванов", "+7-911-222-3333");

        System.out.println("\nВесь справочник: ");
        if (phoneBook instanceof SimplePhoneBook) {
            ((SimplePhoneBook) phoneBook).printAllContacts();
        }
    }
}
