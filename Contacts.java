/**r b
 * The Contacts class creates a contact with a name, phone number, and email address
 * It provides methods to access and update these variables
 */
public class Contacts {
    //Instance variables
    public String name;
    public String phoneNumber;
    public String email;
    private String altphoneNumber;
    private String altEmail;
    private String address;
    private String birthday;
    private String social;

    /**
     * Constructs a new Contacts with name, phone number, and email
     *
     * @param name: The contact's name
     * @param phoneNumber: The contact's phone number
     * @param email: The contact's email address
     */
    Contacts(String name, String phoneNumber, String altphoneNumber, String email, String altEmail,
             String address, String birthday, String social) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.altphoneNumber = altphoneNumber;
        this.email = email;
        this.altEmail = altEmail;
        this.address = address;
        this.birthday = birthday;
        this.social = social;
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

    public void setName(String name) {
        this.name = name;
    }

    // Setters for updating the fields
    public void setAddress(String address) {
        this.address = address;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setMedia(String social) {
        this.social = social;
    }

    public String toCSV() {
        return String.join(",", name, phoneNumber, altphoneNumber, email, altEmail, address, birthday, social);
    }

    //um
    public String toString() {
        return "Name: " + name + ", Phone: " + phoneNumber + ", Alt Phone: " + altphoneNumber + ", Email: " + email + ", Alt Email: " + altEmail + ", Address: " + address + ", Birthday: " + birthday + ", Social Media: " + social;
    }
}
