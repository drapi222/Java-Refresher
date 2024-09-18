import java.io.*;
import java.util.*;

/**
 * Custom exceptions for specific application errors.
 */
class AddressBookEmptyException extends Exception {
    public AddressBookEmptyException(String message) {
        super(message);
    }
}

class ContactNotFoundException extends Exception {
    public ContactNotFoundException(String message) {
        super(message);
    }
}

class InvalidFileFormatException extends Exception {
    public InvalidFileFormatException(String message) {
        super(message);
    }
}

/**
 * The ContactMakers class is a simple contact system that
 * allows users to add, view, search, edit, and remove contacts
 * from an ArrayList.
 */
public class ContactMakers {
    //Instance variables
    private static String runtimeFile = "runtime.txt"; // Default filename for runtime report
    private static boolean reportRuntime = false; // Flag to enable runtime reporting
    private static ArrayList<Contacts> contacts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static boolean verbose_mode = false;

    //Main method
    //The user GUI for manipulating the address book
    public static void main(String[] args) {
        String filename = null;

        for (int i = 0; i < args.length; i++) {
            if ("-v".equals(args[i])) {
                verbose_mode = true;
            }
            else if ("-a".equals(args[i]) && i + 1 < args.length) {
                filename = args[i + 1];
            }
            else if (args[i].equals("-O")) {
                reportRuntime = true;
                if (i + 1 < args.length && !args[i + 1].startsWith("-")) {
                    runtimeFile = args[i + 1]; // Use the specified filename
                    i++; // Skip the next argument (which is the filename)
                }
            }
        }



        if (filename != null)   {
            try {
                loadContactsFromFile(filename);
            } catch (InvalidFileFormatException | IOException e) {
                System.err.println(e.getMessage());
            }
        }


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

            long startTime, endTime, totalTime;

            // Replacing switch with if-else conditional statements
            if (choice == 1) {
                try {
                    startTime = System.currentTimeMillis();
                    addContact();
                    endTime = System.currentTimeMillis();
                    totalTime = endTime - startTime;
                    reportOperationTime("Adding Contact", totalTime);
                } catch (Exception e) {
                    System.err.println("Error adding contact: " + e.getMessage());
                }
            }
            else if (choice == 2) {
                try {
                    startTime = System.currentTimeMillis();
                    viewContact();
                    endTime = System.currentTimeMillis();
                    totalTime = endTime - startTime;
                    reportOperationTime("View Contact", totalTime);
                } catch (AddressBookEmptyException e) {
                    System.err.println(e.getMessage());
                }
            }
            else if (choice == 3) {
                try {
                    startTime = System.currentTimeMillis();
                    searchContact();
                    endTime = System.currentTimeMillis();
                    totalTime = endTime - startTime;
                    reportOperationTime("Searching Contact", totalTime);
                } catch (ContactNotFoundException e) {
                    System.err.println(e.getMessage());
                }
            }
            else if (choice == 4) {
                try {
                    startTime = System.currentTimeMillis();
                    editContact();
                    endTime = System.currentTimeMillis();
                    totalTime = endTime - startTime;
                    reportOperationTime("Editing Contact", totalTime);
                } catch (ContactNotFoundException e) {
                    System.err.println(e.getMessage());
                }
            }
            else if (choice == 5) {
                try {
                    startTime = System.currentTimeMillis();
                    removeContact();
                    endTime = System.currentTimeMillis();
                    totalTime = endTime - startTime;
                    reportOperationTime("Removing Contact", totalTime);
                } catch (ContactNotFoundException e) {
                    System.err.println(e.getMessage());
                }
            }
            else if (choice == 6) {
                if (filename != null) {
                    try {
                        saveContactsToFile(filename);
                    } catch (IOException e) {
                        System.err.println("Error saving contacts to file: " + e.getMessage());
                    }
                }
                System.out.println("Exiting...");
                break;
            }
            else {
                System.out.println("Invalid option. Please try again.");
            }

        }
    }

    /**
     * Adds a new contact to the contacts list.
     * The user is prompted to enter the contact's name, phone number, alt phone number, email
     * alt email, mailing address, birthyday, and social media
     */
    private static void addContact() {
        System.out.println("Enter Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter alt phone number (optional): ");
        String altPhoneNumber = scanner.nextLine();
        System.out.println("Enter main email: ");
        String email = scanner.nextLine();
        System.out.println("Enter alt email (optional): ");
        String altEmail = scanner.nextLine();
        System.out.println("Enter mailing address (optional): ");
        String mailingAddress = scanner.nextLine();
        System.out.println("Enter birthday (optional): ");
        String birthday = scanner.nextLine();
        System.out.println("Enter social media profile (optional): ");
        String socialMedia = scanner.nextLine();

        contacts.add(new Contacts(name, phoneNumber, altPhoneNumber, email, altEmail, mailingAddress, birthday, socialMedia));
        if (verbose_mode) {
            System.out.println("Contact added: " + name);
        }
    }

    /**
     * Displays all contacts in the contacts list.
     * If the list is empty, a message will be shown.
     */
    private static void viewContact() throws AddressBookEmptyException {
        if (contacts.isEmpty()) {
            throw new AddressBookEmptyException("No contacts in the list.");
        }
        else {
            for (Contacts contact : contacts) {
                System.out.println(contact);
            }
            if (verbose_mode) {
                System.out.println("All contacts listed");
            }
        }
    }

    /**
     * Searches for a contact by name in the contacts list.
     * If the contact is found, it will be shown.
     */
    private static void searchContact() throws ContactNotFoundException {
        System.out.println("Enter the name of the contact you want to find: ");
        String name = scanner.nextLine();

        for (Contacts contact: contacts) {
            if (contact.getName().equals(name)) {
                System.out.println(contact);
                if (verbose_mode) {
                    System.out.println("Contact " + name + " found");
                }
                return;
            }
        }
        throw new ContactNotFoundException("Contact not found: " + name);
    }

    /**
     * Searches for a contact by name and allows the user to edit
     * the contact's phone number and email address.
     */
    //just searchContact() but with an additional edit function
    private static void editContact() throws ContactNotFoundException {
        System.out.println("Enter the name of the contact you want to edit ");
        String name2 = scanner.nextLine();

        for (Contacts contact: contacts) {
            if (contact.getName().equals(name2)) {
                System.out.println("Enter new mame: ");
                contact.setName(scanner.nextLine());
                System.out.println("Enter new phone number: ");
                contact.setPhoneNumber(scanner.nextLine());
                System.out.println("Enter new email: ");
                contact.setEmail(scanner.nextLine());
                System.out.println("Enter mailing address (optional): ");
                contact.setAddress(scanner.nextLine());
                System.out.println("Enter birthday (optional): ");
                contact.setBirthday(scanner.nextLine());
                System.out.println("Enter social media profile (optional): ");
                contact.setMedia(scanner.nextLine());
                if (verbose_mode) {
                    System.out.println("Contact " + name2 + " edited");
                }
                return;

            }
        }
        throw new ContactNotFoundException("Contact not found: " + name2);
    }

    /**
     * Removes a contact by name from the contacts list.
     * If the contact is found, it will be removed and a success message will be displayed.
     */
    private static void removeContact() throws ContactNotFoundException{
        System.out.println("Enter the name of the contact you want to remove ");
        String name2 = scanner.nextLine();

        for (Contacts contact: contacts) {
            if (contact.getName().equals(name2)) {
                contacts.remove(contact);
                if (verbose_mode) {
                    System.out.println("Contact " + name2 + " successfully deleted.");
                }
                return;
            }
        }
        throw new ContactNotFoundException("Contact not found: " + name2);

    }

    private static void saveContactsToFile(String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Contacts contact : contacts) {
                writer.write(contact.toCSV());
                writer.newLine();
            }
        }
        if (verbose_mode) {
            System.out.println("Contacts saved to " + fileName);
        }
    }

    private static void loadContactsFromFile(String fileName) throws InvalidFileFormatException, IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                boolean isCreated = file.createNewFile();
                if (isCreated) {
                    System.out.println("File created: " + file.getName());
                } else {
                    System.out.println("File already exists.");
                }
            }
            catch (IOException e) {
                System.out.println("An error occurred while creating the file.");
                e.printStackTrace();
            }
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length != 8) {
                    throw new InvalidFileFormatException("Invalid file format in " + fileName);
                }
                contacts.add(new Contacts(values[0], values[1], values[2], values[3], values[4], values[5], values[6], values[7]));
            }
        }
        if (verbose_mode) {
            System.out.println("Contacts loaded from " + fileName);
        }
    }

    private static void reportOperationTime(String operation, long timeTaken) {
        if (reportRuntime) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(runtimeFile, true))) {
                writer.write(operation + " took " + timeTaken + " ms\n");
            } catch (IOException e) {
                e.printStackTrace();

            }
        }
    }


}
