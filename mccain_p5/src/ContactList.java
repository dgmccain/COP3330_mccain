import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

public class ContactList {
    private final List<ContactItem> contactList = new ArrayList<>();

    public ContactList() {
        //default constructor...
    }

    //add item to list...
    public void addContactItemToList(ContactItem contactItem) {
        contactList.add(contactItem);
    }

    //this.size() function...
    public int getEntireContactListSize() {
        return this.contactList.size();
    }

    //LOAD
    //load list from file...
    public void loadContactListFromFile(String fileName) {
        String lineFirstName;
        String lineLastName;
        String linePhoneNumber;
        String lineEmailAddress;

        //start by deleting the current contactList before loading from file contents...
        for (int i = contactList.size(); i > 0; i--) {
            //remove the last element in the array list...
            contactList.remove((i-1));
        }

        //exception handling for loading file...
        try {
            Scanner fileScanner = new Scanner(new File(fileName));

            while (fileScanner.hasNextLine()) {
                //delimiter is what separates the object variables on the same line...
                fileScanner.useDelimiter(";");

                //read first name...
                lineFirstName = fileScanner.next();
                //read last name...
                lineLastName = fileScanner.next();
                //read phone number...
                linePhoneNumber = fileScanner.next();
                //read email address...
                lineEmailAddress = fileScanner.next();

                //buffer the next line input...
                fileScanner.nextLine();

                //store as new contact item...
                ContactItem tempItem = new ContactItem(lineFirstName, lineLastName, linePhoneNumber, lineEmailAddress);
                //store contact item in list...
                contactList.add(tempItem);
            }

            //this function is only called if load is successful...
            System.out.println(fileName + " loaded successfully!");

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred when trying to load your file...");
        }
    }
}
