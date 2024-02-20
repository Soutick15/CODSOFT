import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nPhone Number: " + phoneNumber + "\nEmail: " + email;
    }
}

class AddressBook {
    private ArrayList<Contact> contacts;

    public AddressBook() {
        contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void removeContact(String name) {
        boolean removed = false;
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                contacts.remove(contact);
                removed = true;
                break;
            }
        }
        if (removed) {
            System.out.println("Contact removed successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    public Contact searchContact(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    }

    public void displayAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            for (Contact contact : contacts) {
                System.out.println(contact);
                System.out.println("-------------------");
            }
        }
    }
}

public class AddressBookApp {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nAddress Book Menu:");
            System.out.println("1. Add a new contact");
            System.out.println("2. Remove a contact");
            System.out.println("3. Search for a contact");
            System.out.println("4. Display all contacts");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    addContact(addressBook, scanner);
                    break;
                case 2:
                    removeContact(addressBook, scanner);
                    break;
                case 3:
                    searchContact(addressBook, scanner);
                    break;
                case 4:
                    addressBook.displayAllContacts();
                    break;
                case 5:
                    System.out.println("Exiting Address Book App. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addContact(AddressBook addressBook, Scanner scanner) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        if (!name.isEmpty() && !phoneNumber.isEmpty() && !email.isEmpty()) {
            Contact newContact = new Contact(name, phoneNumber, email);
            addressBook.addContact(newContact);
            System.out.println("Contact added successfully.");
        } else {
            System.out.println("Please fill in all the required fields.");
        }
    }

    private static void removeContact(AddressBook addressBook, Scanner scanner) {
        System.out.print("Enter the name of the contact to remove: ");
        String contactToRemove = scanner.nextLine();
        addressBook.removeContact(contactToRemove);
    }

    private static void searchContact(AddressBook addressBook, Scanner scanner) {
        System.out.print("Enter the name of the contact to search: ");
        String contactToSearch = scanner.nextLine();
        Contact foundContact = addressBook.searchContact(contactToSearch);
        if (foundContact != null) {
            System.out.println("Contact found:\n" + foundContact);
        } else {
            System.out.println("Contact not found.");
        }
    }
}
