# Java-Refresher

Contact Manager Program
=======================

Description:
------------
The Contact Manager program is a simple Java-based application that allows users to manage a list of contacts. Users can add new contacts, view all existing contacts, search for a specific contact, edit contact details, and delete contacts. The program runs in a console environment, providing a text-based menu for user interaction.

Features:
---------
1. **Add Contact**: Users can add a new contact by providing a name, phone number, and email address.
2. **View Contacts**: Users can view all the contacts that have been added to the system.
3. **Search Contact**: Users can search for a contact by name and display the contact's details.
4. **Edit Contact**: Users can update the phone number and email of an existing contact.
5. **Delete Contact**: Users can remove a contact from the system by name.
6. **Exit**: Users can exit the program.

Requirements:
-------------
- Java Development Kit (JDK) installed
- Any IDE or text editor that supports Java (e.g., IntelliJ IDEA, Eclipse, VS Code)

How to Run:
-----------
1. Compile the program:
   - Open your terminal or command prompt.
   - Navigate to the directory where your Java files are stored.
   - Run the following command to compile the program:
     ```
     javac ContactMaker.java
     ```

2. Run the program:
   - After compiling, run the program by executing the following command:
     ```
     java ContactMaker
     ```

3. Follow the on-screen menu to manage your contacts.

Class Descriptions:
-------------------
- **ContactMaker**: This is the main class responsible for presenting the menu to the user and handling user interactions for adding, viewing, searching, editing, and deleting contacts.
- **Contact**: This class represents a contact with three fields: name, phone number, and email. It includes getters and setters to access and modify the contact details.

Notes:
------
- The contact list is stored in an `ArrayList` during runtime and is not persistent. Once the program exits, the contact list will be cleared. Future enhancements could include saving the contact data to a file or database for persistence.

Author:
-------
[Your Name]

Date:
-----
[Current Date]
