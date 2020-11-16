import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;


class TaskItemTest {

    /*
    //TaskItem Tests...
    @Test
    public void TestUnsuccessfulTitleCreation() {
        Scanner titleInput = new Scanner("");
        String testInput = titleInput.next();

        TaskItem.setTitle();
        //user should be prompted to enter title again because it cannot be left blank...
    }

    @Test
    public void TestSuccessfulTaskItemTitleCreation() {
        Scanner titleInput = new Scanner("title");
        String testInput = titleInput.next();

        TaskItem.setTitle();
        assertEquals("title", TaskItem.getTitle());
    }

    @Test
    public void TestSuccessfulTaskItemDescriptionCreation() {
        Scanner descriptionInput = new Scanner("description");
        String testInput = descriptionInput.next();

        TaskItem.setDescription();
        assertEquals("description", TaskItem.getDescription());
    }

    @Test
    public void TestUnsuccessfulTaskItemDueDateCreation1() {
        //tests for if string is entered instead of correct yyyy-MM-dd format...
        Scanner dueDateInput = new Scanner("due date");
        String testInput = dueDateInput.next();

        TaskItem.setDueDate();
        //should ask user to re-enter data...
    }

    @Test
    public void TestUnsuccessfulTaskItemDueDateCreation2() {
        //tests for using / instead of - for yyyy-MM-dd format...
        Scanner dueDateInput = new Scanner("2020/10/05");
        String testInput = dueDateInput.next();

        TaskItem.setDueDate();
        assertEquals("title", TaskItem.getDueDate());
    }

    //add tests for get functions...

    @Test
    public void TestSuccessfulTaskItemCreation() {
        TaskItem itemTest = new TaskItem("title", "description", "2020-01-01");
        assertEquals("title", itemTest.title);
        assertEquals("description", itemTest.description);
        assertEquals("2020-01-01", itemTest.dueDate);
    }
    */

    //======================================================================================
    //add tests for if the list itself fails (ex. trying to remove an index beyond bounds...
    //also, add tests for functions contained within the TaskList class...
    //======================================================================================

    //===================================================================
    //The following should be tests for functions within the App class...
    //===================================================================

    @Test
    public void TestUnsuccessfulMainMenuChoice() {
        //enter a char or out-of-bounds int...
    }

    @Test
    public void TestMainMenuChoice1() {
        //test for if int 1 is entered...
    }

    @Test
    public void TestForIfFileDoesNotLoad() {
        //enter the file name of a txt file that does not exist...
        //expect print to console confirming the file does not exist...
    }

    @Test
    public void TestForIfFileLoads() {
        //enter the file name of a txt file that already exists...
        //expect print to console confirming the file exists/loaded...
    }

    @Test
    public void TestMainMenuChoice2() {
        //test for if int 2 is entered...
    }

    @Test
    public void TestMainMenuChoice3() {
        //test for if int 3 is entered...
        //program should close...
    }

}