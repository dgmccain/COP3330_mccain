import java.util.Scanner;

/**
 *** TODO & NOTES ***
 ==============================================================================
 1. find out how TaskApp and ContactsApp are supposed to be implemented
    - I think having a MainApp class that creates a new TaskApp and ContactsApp
    - within a <static void main> function, and each have their own <run>
    - classes (where <run> operates like <main>) is the best approach...
 2. side-note: file handling will most likely be handled here, or in TaskList
 3. finish p4 here
 4. after p4 is completed, include the necessary classes for contacts
 ==============================================================================
 **/

public class TaskApp {
    private static final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        TaskApp TApp = new TaskApp();
        TApp.runTApp();
    }

    public void runTApp() {
        String tempTitle;
        String tempDescription;
        String tempDueDate;

        //retrieve user input data...
        tempTitle = userInputTitle();
        tempDescription = userInputDescription();
        tempDueDate = userInputDueDate();

        //create a new task item from user input data...
        TaskItem mainTaskItem = new TaskItem(tempTitle, tempDescription, tempDueDate);

        //view task item data...
        displayTaskItem(mainTaskItem);

        /**
         check mark/unmark status...
         **/
        //mark as complete...
        mainTaskItem.setStatusAsComplete();
        //view updated data...
        displayTaskItem(mainTaskItem);
        //mark as incomplete...
        mainTaskItem.setStatusAsIncomplete();
        //view updated data...
        displayTaskItem(mainTaskItem);
    }

    //retrieve user input data...
    private String userInputTitle() {
        String userTitle;

        System.out.print("Enter a Title: ");
        userTitle = userInput.nextLine();

        return userTitle;
    }
    private String userInputDescription() {
        String userDescription;

        System.out.print("Enter a Description: ");
        userDescription = userInput.nextLine();

        return userDescription;
    }
    private String userInputDueDate() {
        String userDueDate;

        System.out.print("Enter a Due Date: ");
        userDueDate = userInput.nextLine();

        return userDueDate;
    }

    //display task item data...
    private void displayTaskItem(TaskItem currentItem) {
        if (currentItem.getStatus()) {
            System.out.print("*** ");
        }
        System.out.print(currentItem.getTitle() + ": ");
        System.out.print(currentItem.getDescription() + " ");
        System.out.println("[" + currentItem.getDueDate() + "]");
    }
}