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
}
