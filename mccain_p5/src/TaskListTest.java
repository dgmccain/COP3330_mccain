import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {
    //NEW LIST IS EMPTY
    @Test
    public void newListIsEmpty() {
        TaskList testList = new TaskList();

        assertEquals(0, testList.getEntireListSize());
    }

    //ADDING ITEM
    @Test
    public void addingItemIncreasesSize() {
        TaskItem testItem = new TaskItem("title", "desc", "2020-01-01");
        TaskList testList = new TaskList();

        testList.addItemToList(testItem);

        assertEquals(1, testList.getEntireListSize());
    }

    @Test
    public void addingItemIsCorrectlyStoredInList() {
        TaskItem testItem = new TaskItem("title", "desc", "2020-01-01");
        TaskList testList = new TaskList();

        testList.addItemToList(testItem);

        assertEquals("title", testList.getItemTitleFromList(0));
        assertEquals("desc", testList.getItemDescriptionFromList(0));
        assertEquals("2020-01-01", testList.getItemDueDateFromList(0));
        assertFalse(testList.getItemStatusFromList(0));
    }

    //GETTING ITEM DATA
    @Test
    public void gettingItemTitleSucceedsWithValidIndex() {
        TaskItem testItem = new TaskItem("title", "desc", "2020-01-01");
        TaskList testList = new TaskList();

        testList.addItemToList(testItem);

        assertEquals("title", testList.getItemTitleFromList(0));
    }

    @Test
    public void gettingItemTitleFailsWithInvalidIndex() {
        TaskList testList = new TaskList();

        assertThrows(IndexOutOfBoundsException.class, () -> testList.getItemTitleFromList(0));
    }

    @Test
    public void gettingItemDescriptionSucceedsWithValidIndex() {
        TaskItem testItem = new TaskItem("title", "desc", "2020-01-01");
        TaskList testList = new TaskList();

        testList.addItemToList(testItem);

        assertEquals("desc", testList.getItemDescriptionFromList(0));
    }

    @Test
    public void gettingItemDescriptionFailsWithInvalidIndex() {
        TaskList testList = new TaskList();

        assertThrows(IndexOutOfBoundsException.class, () -> testList.getItemDescriptionFromList(0));
    }

    @Test
    public void gettingItemDueDateSucceedsWithValidIndex() {
        TaskItem testItem = new TaskItem("title", "desc", "2020-01-01");
        TaskList testList = new TaskList();

        testList.addItemToList(testItem);

        assertEquals("2020-01-01", testList.getItemDueDateFromList(0));
    }

    @Test
    public void gettingItemDueDateFailsWithInvalidIndex() {
        TaskList testList = new TaskList();

        assertThrows(IndexOutOfBoundsException.class, () -> testList.getItemDueDateFromList(0));
    }

    //REMOVING ITEM
    @Test
    public void removingItemsDecreasesSize() {
        TaskItem testItem = new TaskItem("title", "desc", "2020-01-01");
        TaskList testList = new TaskList();

        testList.addItemToList(testItem);
        testList.deleteItemFromList(0);

        assertEquals(0, testList.getEntireListSize());
    }

    @Test
    public void removingItemsFailsWithInvalidIndex() {
        TaskList testList = new TaskList();

        assertThrows(IndexOutOfBoundsException.class, () -> testList.deleteItemFromList(0));
    }

    //EDITING ITEM
    //title...
    @Test
    public void editingItemTitleSucceedsWithExpectedValue() {
        TaskItem testOriginalItem = new TaskItem("original title", "desc", "2020-01-01");
        TaskList testList = new TaskList();

        //add an item to list and check to see if it was stored correctly...
        testList.addItemToList(testOriginalItem);
        assertEquals("original title", testList.getItemTitleFromList(0));

        //edit the item and verify the updated contents...
        TaskItem testUpdatedItem = new TaskItem("updated title", "desc", "2020-01-01");
        testList.editItemInList(testUpdatedItem, 0);

        assertEquals("updated title", testList.getItemTitleFromList(0));
    }

    @Test
    public void editingItemTitleFailsWithInvalidIndex() {
        //applies to title, description, and due date because the function takes
        //an entire task item as a parameter along with an index (item location)...
        TaskItem testItem = new TaskItem("title", "desc", "2020-01-01");
        TaskList testList = new TaskList();

        //testItem was never added to the list, so there is no item to edit...
        assertThrows(IndexOutOfBoundsException.class, () ->
                testList.editItemInList(testItem, 0));
    }

    @Test
    public void editingItemTitleFailsIfEmptyString() {
        TaskItem testOriginalItem = new TaskItem("original title", "desc", "2020-01-01");
        TaskList testList = new TaskList();

        testList.addItemToList(testOriginalItem);
        assertEquals("original title", testList.getItemTitleFromList(0));

        try {
            TaskItem testUpdatedItem = new TaskItem("", "desc", "2020-01-01");
            //the following edit function will not actually be called because the TaskItem
            //constructor should first throw an exception (because the title is empty). If
            //the TaskItem was ACTUALLY valid, then it would be passed to the edit function...
            testList.editItemInList(testUpdatedItem, 0);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    //description...
    @Test
    public void editingItemDescriptionSucceedsWithExpectedValue() {
        TaskItem testOriginalItem = new TaskItem("title", "original desc", "2020-01-01");
        TaskList testList = new TaskList();

        testList.addItemToList(testOriginalItem);
        assertEquals("original desc", testList.getItemDescriptionFromList(0));

        TaskItem testUpdatedItem = new TaskItem("title", "updated desc", "2020-01-01");
        testList.editItemInList(testUpdatedItem, 0);

        assertEquals("updated desc", testList.getItemDescriptionFromList(0));
    }

    @Test
    public void editingItemDescriptionFailsWithInvalidIndex() {
        TaskItem testItem = new TaskItem("title", "desc", "2020-01-01");
        TaskList testList = new TaskList();

        assertThrows(IndexOutOfBoundsException.class, () ->
                testList.editItemInList(testItem, 0));
    }

    //due date...
    @Test
    public void editingItemDueDateSucceedsWithExpectedValue() {
        TaskItem testOriginalItem = new TaskItem("title", "desc", "2020-01-01");
        TaskList testList = new TaskList();

        testList.addItemToList(testOriginalItem);
        assertEquals("2020-01-01", testList.getItemDueDateFromList(0));

        TaskItem testUpdatedItem = new TaskItem("title", "updated desc", "2020-02-02");
        testList.editItemInList(testUpdatedItem, 0);

        assertEquals("2020-02-02", testList.getItemDueDateFromList(0));
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex() {
        TaskItem testItem = new TaskItem("title", "desc", "2020-01-01");
        TaskList testList = new TaskList();

        assertThrows(IndexOutOfBoundsException.class, () ->
                testList.editItemInList(testItem, 0));
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidDateFormat() {
        TaskItem testOriginalItem = new TaskItem("title", "desc", "2020-01-01");
        TaskList testList = new TaskList();

        testList.addItemToList(testOriginalItem);
        assertEquals("2020-01-01", testList.getItemDueDateFromList(0));

        try {
            TaskItem testUpdatedItem = new TaskItem("title", "updated desc", "date");
            testList.editItemInList(testUpdatedItem, 0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidMonth() {
        TaskItem testOriginalItem = new TaskItem("title", "desc", "2020-01-01");
        TaskList testList = new TaskList();

        testList.addItemToList(testOriginalItem);
        assertEquals("2020-01-01", testList.getItemDueDateFromList(0));

        try {
            TaskItem testUpdatedItem = new TaskItem("title", "updated desc", "2020-13-01");
            testList.editItemInList(testUpdatedItem, 0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidDay() {
        TaskItem testOriginalItem = new TaskItem("title", "desc", "2020-01-01");
        TaskList testList = new TaskList();

        testList.addItemToList(testOriginalItem);
        assertEquals("2020-01-01", testList.getItemDueDateFromList(0));

        try {
            TaskItem testUpdatedItem = new TaskItem("title", "updated desc", "2020-01-32");
            testList.editItemInList(testUpdatedItem, 0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    //MARKING ITEM
    @Test
    public void markingTaskItemChangesStatus() {
        TaskItem testOriginalItem = new TaskItem("title", "desc", "2020-01-01");
        TaskList testList = new TaskList();

        testList.addItemToList(testOriginalItem);
        assertFalse(testList.getItemStatusFromList(0));

        testList.markItemInList(0);
        assertTrue(testList.getItemStatusFromList(0));
    }

    @Test
    public void markingTaskItemFailsWithInvalidIndex() {
        TaskItem testOriginalItem = new TaskItem("title", "desc", "2020-01-01");
        TaskList testList = new TaskList();

        testList.addItemToList(testOriginalItem);
        assertFalse(testList.getItemStatusFromList(0));

        try {
            //original task item is stored in index 0, so there will be no index 1...
            testList.markItemInList(1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    //UNMARKING ITEM
    @Test
    public void unmarkingTaskItemChangesStatus() {
        TaskItem testOriginalItem = new TaskItem("title", "desc", "2020-01-01", true);
        TaskList testList = new TaskList();

        testList.addItemToList(testOriginalItem);
        assertTrue(testList.getItemStatusFromList(0));

        testList.unmarkItemInList(0);
        assertFalse(testList.getItemStatusFromList(0));
    }

    @Test
    public void unmarkingTaskItemFailsWithInvalidIndex() {
        TaskItem testOriginalItem = new TaskItem("title", "desc", "2020-01-01", true);
        TaskList testList = new TaskList();

        testList.addItemToList(testOriginalItem);
        assertTrue(testList.getItemStatusFromList(0));

        try {
            //original task item is stored in index 0, so there will be no index 1...
            testList.unmarkItemInList(1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    //SAVING ITEM LIST
    @Test
    public void savingTaskListFails() {
        TaskList testList = new TaskList();

        //create file - WILL OVERWRITE FILE WITH IDENTICAL NAME (only if a file with
        //an identical name exists and is stored in the same path)...
        testList.saveTaskListToFile("saveTaskList_ExampleFile2.txt");
        //check if the newly saved file exists...
        assertFalse(TaskApp.doesFileExist("saveTaskList_ExampleFile2.txt"));
    }

    @Test
    public void savingTaskListSucceeds() {
        TaskItem testOriginalItem = new TaskItem("title", "desc", "2020-01-01");
        TaskList testList = new TaskList();

        testList.addItemToList(testOriginalItem);

        //create file - WILL OVERWRITE FILE WITH IDENTICAL NAME (only if a file with
        //an identical name exists and is stored in the same path)...
        testList.saveTaskListToFile("saveTaskList_ExampleFile1.txt");
        //check if the newly saved file exists...
        assertTrue(TaskApp.doesFileExist("saveTaskList_ExampleFile1.txt"));
    }

    //LOADING ITEM LIST
    @Test
    public void loadingTaskListFails() {
        TaskList testList = new TaskList();

        //try to load a task that does not exist. The exception is caught in the
        //<TaskList.loadTasks()> function, sending an error message to the console...
        testList.loadTasks("aFileThatDoesNotExist");

        //check if the file exists...
        assertFalse(TaskApp.doesFileExist("aFileThatDoesNotExist"));
    }

    @AfterAll
    public static void loadingTaskListSucceeds() {
        //can ONLY TEST AFTER <savingTaskListSucceeds()> test has passed. File
        //names in both test cases can be changed; the load file just needs to
        //be identical in name to the save file...
        TaskList testList = new TaskList();

        testList.loadTasks("saveTaskList_ExampleFile1.txt");

        assertEquals("title", testList.getItemTitleFromList(0));
        assertEquals("desc", testList.getItemDescriptionFromList(0));
        assertEquals("2020-01-01", testList.getItemDueDateFromList(0));
        assertFalse(testList.getItemStatusFromList(0));
    }
}