/**
 * The Contact class creates a contact with a name, phone number, and email address
 * It provides methods to access and update these variables
 */
public class Contact {
    //Instance variables
    public String name;
    public String phoneNumber;
    public String email;

    /**
     * Constructs a new Contact with name, phone number, and email
     *
     * @param name: The contact's name
     * @param phoneNumber: The contact's phone number
     * @param email: The contact's email address
     */
    Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    /**
     * Returns the name of the contact
     * @return The contact's name
     */
    public String getName() {
        return name;
    }

    // Setters for updating the fields
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //um
    public String toString() {
        return "Name: " + name + ", Phone: " + phoneNumber + ", Email: " + email;
    }
}
