import java.util.Scanner;
import java.util.ArrayList;

/**
 * The ContactMaker class is a simple contact system that
 * allows users to add, view, search, edit, and remove contacts
 * from an ArrayList.
 */
public class ContactMaker {
    //Instance variables
    private static ArrayList<Contact> contacts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    //Main method
    //The user GUI for manipulating the address book
    public static void main(String[] args) {
        while (true) {
            System.out.println("\nContact Manager Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Edit Contact");
            System.out.println("5. Delete Contact");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                addContact();
            }
            else if (choice == 2) {
                viewContact();
            }
            else if (choice == 3) {
                searchContact();
            }
            else if (choice == 4) {
                editContact();
            }
            else if (choice == 5) {
                removeContact();
            }
            else if (choice == 6) {
                System.out.println("Exiting...");
                break;
            }
            else {
                System.out.println("I did not know what you requested. Try again");
            }

        }
    }

    /**
     * Adds a new contact to the contacts list.
     * The user is prompted to enter the contact's name, phone number, and email.
     */
    private static void addContact() {
        System.out.println("Enter Name" );
        String name = scanner.nextLine();
        System.out.print("Enter phone number ");
        String number = scanner.nextLine();
        System.out.print("Enter email address ");
        String email = scanner.nextLine();

        contacts.add(new Contact(name, number, email));
        System.out.println("Contact added");
    }

    /**
     * Displays all contacts in the contacts list.
     * If the list is empty, a message will be shown.
     */
    private static void viewContact() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts in list");
        }
        else {
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    /**
     * Searches for a contact by name in the contacts list.
     * If the contact is found, it will be shown.
     */
    private static void searchContact() {
        System.out.println("Enter the name of the contact you want to find: ");
        String name = scanner.nextLine();

        for (Contact contact: contacts) {
            if (contact.getName().equals(name)) {
                System.out.println(contact);
                return;
            }
        }
        System.out.println("Contact not found");
    }

    /**
     * Searches for a contact by name and allows the user to edit
     * the contact's phone number and email address.
     */
    //just searchContact() but with an additional edit function
    private static void editContact() {
        System.out.println("Enter the name of the contact you want to edit ");
        String name2 = scanner.nextLine();

        for (Contact contact: contacts) {
            if (contact.getName().equals(name2)) {
                System.out.println("Enter new phone number: ");
                contact.setPhoneNumber(scanner.nextLine());
                System.out.println("Enter new email: ");
                contact.setEmail(scanner.nextLine());
                System.out.println("Contact " + name2 + " successfully edited");
                return;
            }
        }
        System.out.println("Contact not found");
    }

    /**
     * Removes a contact by name from the contacts list.
     * If the contact is found, it will be removed and a success message will be displayed.
     */
    private static void removeContact() {
        System.out.println("Enter the name of the contact you want to remove ");
        String name2 = scanner.nextLine();

        for (Contact contact: contacts) {
            if (contact.getName().equals(name2)) {
                contacts.remove(contact);
                System.out.println("Contact " + name2 + " successfully deleted");
                return;
            }
        }
        System.out.println("Contact not found");
    }




}
