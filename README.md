Overview
The Contact Manager is a simple Java console application for managing contacts. It allows users to add, view, search, edit, and delete contacts, and supports saving/loading contacts to/from a file. The app also includes optional runtime performance reporting.

Features:

- Add Contact: Add new contacts with name, phone, email, and optional details like social media.
- View Contacts: Display all contacts in the list.
- Search Contact: Search for a contact by name.
- Edit Contact: Update contact details (phone, email, etc.).
- Remove Contact: Delete a contact by name.
- Save/Load Contacts: Save and load contacts from a CSV file.
- Runtime Reporting: Track the time taken for operations.

Run the application with optional flags:

- -v : Enable verbose mode for additional details.
- -a <filename> : Load contacts from a specified file.
- -O <filename> : Enable runtime reporting and specify the report file.

Example:
java ContactMakers -v -a AddressBookSample10.txt -O runtime.txt

Custom Exceptions:

- AddressBookEmptyException: Thrown when trying to view/edit an empty address book.
- ContactNotFoundException: Thrown when the specified contact is not found.
- InvalidFileFormatException: Thrown when the contact file has an invalid format.


Author: Kevin,
Date: September 2, 2024