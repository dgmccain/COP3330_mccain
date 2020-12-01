import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContactListTest {

    //NEW CONTACT LIST IS EMPTY
    @Test
    public void newContactListIsEmpty() {
        ContactList testList = new ContactList();

        assertEquals(0, testList.getEntireContactListSize());
    }

    //ADDING CONTACT ITEM
    @Test
    public void addingContactItemIncreasesSize() {
        ContactItem testItem = new ContactItem("first", "last", "phone", "email");
        ContactList testList = new ContactList();

        testList.addContactItemToList(testItem);

        assertEquals(1, testList.getEntireContactListSize());
    }
    @Test
    public void addingContactItemIsCorrectlyStoredInList() {
        ContactItem testItem = new ContactItem("first", "last", "phone", "email");
        ContactList testList = new ContactList();

        testList.addContactItemToList(testItem);

        assertEquals("first", testList.getContactItemFirstNameFromList(0));
        assertEquals("last", testList.getContactItemLastNameFromList(0));
        assertEquals("phone", testList.getContactItemPhoneNumberFromList(0));
        assertEquals("email", testList.getContactItemEmailAddressFromList(0));
    }

    //REMOVING CONTACT ITEM
    @Test
    public void removingContactItemFailsWithInvalidIndex() {
        ContactList testList = new ContactList();

        assertThrows(IndexOutOfBoundsException.class, () -> testList.deleteContactItemFromList(0));
    }
    @Test
    public void removingContactItemDecreasesSize() {
        ContactItem testItem = new ContactItem("first", "last", "phone", "email");
        ContactList testList = new ContactList();

        testList.addContactItemToList(testItem);
        testList.deleteContactItemFromList(0);

        assertEquals(0, testList.getEntireContactListSize());
    }

    /*
    //GETTING CONTACT ITEM
    gettingContactItemFirstNameFailsWithInvalidIndex()
    gettingContactItemFirstNameSucceedsWithValidIndex()
    gettingContactItemLastNameFailsWithInvalidIndex()
    gettingContactItemLastNameSucceedsWithValidIndex()
    gettingContactItemPhoneNumberFailsWithInvalidIndex()
    gettingContactItemPhoneNumberSucceedsWithValidIndex()
    gettingContactItemEmailAddressFailsWithInvalidIndex()
    gettingContactItemEmailAddressSucceedsWithValidIndex()

    //EDITING CONTACT ITEM
    editingContactItemFailsWithAllBlankValues()
    editingContactItemFailsWithInvalidIndex()
    editingContactItemSucceedsWithBlankFirstName()
    editingContactItemSucceedsWithBlankLastName()
    editingContactItemSucceedsWithBlankPhone()
    editingContactItemSucceedsWithNonBlankValues()

    //SAVING CONTACT LIST
    savingContactListFails()
    savingContactListSucceeds()

    //LOADING CONTACT LIST
    loadingContactListFails()
    loadingContactListSucceeds()
    */

}