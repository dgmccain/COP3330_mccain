import java.util.InputMismatchException;
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
    private static final TaskList currentTaskList = new TaskList();
    //initialize a temporary task item for later use throughout the entire TaskApp class...
    private static TaskItem currentTaskItem = new TaskItem("tempTitle", "tempDesc", "2020-01-01");
    private static boolean TasksOpen = true;

    public static void main(String[] args) {
        TaskApp TApp = new TaskApp();
        TApp.runTApp();
    }

    //essentially equivalent in importance to main()
    public void runTApp() {
        String mainMenuChoice;

        //mainMenuOpen is initially true...
        while (TasksOpen) {
            //main menu...
            displayTasksMainMenu();
            mainMenuChoice = retrieveTasksMainMenuInput();
            switch (mainMenuChoice) {
                case "1":
                    loadTaskMenu();
                    break;
                case "2":
                    branchMenu();
                    break;
                case "3":
                    //this is the old code's quitKey, but it should return the user to
                    //the ACTUAL main menu (with options for Tasks, Contacts, and Quit
                    //Program instead of closing the program from here...
                    TasksOpen = false;
                    break;
                default:
                    System.out.println("ERROR - issue occurred with task main menu choice...");
            }
        }

        System.out.println("Returning to Program Main Menu...");
    }

    public void loadTaskMenu() {
        //get filename...
        //validate file, along with exception handling...
        //if file does exist, load file from within TaskList
        //function, passing in filename as a parameter...
    }

    public void branchMenu() {
        boolean branchMenuOpen = true;
        String branchMenuChoice;
        int index;

        while (branchMenuOpen) {
            displayTaskListOperationsMenu();
            branchMenuChoice = retrieveTaskListOperationsMenuInput();

            switch (branchMenuChoice) {
                case "1":
                    //view tasks...
                    if(!isTaskListEmpty()) {
                        currentTaskList.displayItemsInList();
                    }
                    break;
                case "2":
                    //add task...
                    setTaskItemFromUserInput();
                    currentTaskList.addItemToList(currentTaskItem);
                    break;
                case "3":
                    //edit task...
                    if(!isTaskListEmpty()) {
                        currentTaskList.displayItemsInList();
                        //get the task number to edit...
                        index = retrieveTaskNumberFromUserInput("edit");
                        if (isTaskNumberWithinBounds(index)) {
                            //set the current task item to newly entered user input...
                            setTaskItemFromUserInput();
                            //replace task item in current task list with the new item data...
                            currentTaskList.editItemInList(currentTaskItem, index);
                            System.out.println("task #" + index + 1 + " was edited");
                        }
                    }
                    //retrieveTaskNumberFromUserInput(), and setTaskItemFromUserInput()
                    //might need to be duplicated within the TaskList class...
                    break;
                case "4":
                    //remove task...
                    if(!isTaskListEmpty()) {
                        currentTaskList.displayItemsInList();
                        index = retrieveTaskNumberFromUserInput("delete");
                        if (isTaskNumberWithinBounds(index)) {
                            currentTaskList.deleteItemFromList(index);
                        }
                    }
                    //retrieveTaskNumberFromUserInput() might need to be
                    //duplicated within the TaskList class...
                    break;
                case "5":
                    //mark tasks...
                    if(!isUnmarkedListEmpty()) {
                        currentTaskList.displayUnmarkedTasksInList();
                        index = retrieveTaskNumberFromUserInput("mark");
                        if (isTaskNumberWithinBounds(index)) {
                            currentTaskList.markItemInList(index);
                        }
                    }
                    break;
                case "6":
                    //unmark tasks...
                    if(!isMarkedListEmpty()) {
                        currentTaskList.displayMarkedTasksInList();
                        index = retrieveTaskNumberFromUserInput("unmark");
                        if (isTaskNumberWithinBounds(index)) {
                            currentTaskList.unmarkItemInList(index);
                        }
                    }
                    break;
                case "7":
                    //save tasks...
                    break;
                case "8":
                    //return to task main menu...
                    System.out.println("returning to task main menu");
                    branchMenuOpen = false;
                    break;
                default:
                    System.out.println("ERROR - issue occurred with task operation menu choice");
            }

            /**
            //initialize variables for data to be entered by user input...
            String tempTitle = "";
            String tempDescription = "";
            String tempDueDate = "";

            //boolean for while loop - ends when user inputs valid data...
            boolean isInputValid = false;

            while (!isInputValid) {
                try {
                    //retrieve user input data...
                    tempTitle = userInputTitle();
                    tempDescription = userInputDescription();
                    tempDueDate = userInputDueDate();

                    //create a new task item from above user input data...
                    TaskItem mainTaskItem = new TaskItem(tempTitle, tempDescription, tempDueDate);
                    isInputValid = true;

                    //add item to list if user input is valid...
                    mainTaskList.addToList(mainTaskItem);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            //create a new task item from above user input data...
            TaskItem mainTaskItem = new TaskItem(tempTitle, tempDescription, tempDueDate);

            //view task item data...
            displayTaskItem(mainTaskItem);

            //check mark/unmark status...

            //mark as complete...
            mainTaskItem.setStatusAsComplete();
            //view updated data...
            displayTaskItem(mainTaskItem);
            //mark as incomplete...
            mainTaskItem.setStatusAsIncomplete();
            //view updated data...
            displayTaskItem(mainTaskItem);

             //display task item data...
             private void displayTaskItem(TaskItem currentItem) {
             if (currentItem.getStatus()) {
             System.out.print("*** ");
             }
             System.out.print(currentItem.getTitle() + ": ");
             System.out.print(currentItem.getDescription() + " ");
             System.out.println("[" + currentItem.getDueDate() + "]");
             }

            **/
        }
    }

    //USER FUNCTIONS
    //retrieve user input data...
    public String retrieveUserInputTitle() {
        String userTitle;

        System.out.print("Enter a Title: ");
        userTitle = userInput.nextLine();

        return userTitle;
    }
    public String retrieveUserInputDescription() {
        String userDescription;

        System.out.print("Enter a Description: ");
        userDescription = userInput.nextLine();

        return userDescription;
    }
    public String retrieveUserInputDueDate() {
        String userDueDate;

        System.out.print("Enter a Due Date: ");
        userDueDate = userInput.nextLine();

        return userDueDate;
    }
    //retrieve task item from user input...
    public void setTaskItemFromUserInput() {
        String title;
        String description;
        String dueDate;
        boolean flag = true;

        while(flag) {
            title = retrieveUserInputTitle();
            description = retrieveUserInputDescription();
            dueDate = retrieveUserInputDueDate();

            try {
                currentTaskItem = new TaskItem(title, description, dueDate);
                flag = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    //retrieve task number from user input...
    public int retrieveTaskNumberFromUserInput(String msg) {
        int taskNum = 0;
        boolean flag = true;

        while (flag) {
            System.out.print(System.lineSeparator());
            System.out.println("If you would like to cancel, please enter a negative number. Otherwise...");
            System.out.print("Enter the task number you would like to " + msg + ": ");
            try {
                taskNum = userInput.nextInt();
                flag = false;
            } catch (InputMismatchException e) {
                System.out.println(("you did not enter a valid task number..."));
                //implement the following code instead to fulfill requirement:
                //throw new InputMismatchException("you did not enter a valid task number...");
                //then, the exception has to be caught from the function that calls this function...
            }
            userInput.nextLine(); //input buffer
        }

        //subtract 1 because first index is actually at 0, not 1...
        return taskNum - 1;
    }
    public boolean isTaskNumberWithinBounds(int index) {
        if (index >= 0 && index < currentTaskList.getEntireListSize()){
            return true;
        } else {
            System.out.println("INVALID - that task number does not exist");
            return false;
        }
    }

    //CHECKER FUNCTIONS
    public boolean isTaskListEmpty() {
        if(currentTaskList.getEntireListSize() == 0) {
            System.out.println("Currently, there are no tasks in your list...");
            return true;
        }
        else {
            return false;
        }
    }
    public boolean isMarkedListEmpty() {
        if(currentTaskList.getMarkedListSize() == 0) {
            System.out.println("Currently, there are no complete tasks...");
            return true;
        }
        else {
            return false;
        }
    }
    public boolean isUnmarkedListEmpty() {
        if(currentTaskList.getUnmarkedListSize() == 0) {
            System.out.println("Currently, there are no incomplete tasks...");
            return true;
        }
        else {
            return false;
        }
    }

    //MENU FUNCTIONS
    //main menu functions...
    public void displayTasksMainMenu() {
        System.out.print(System.lineSeparator());
        System.out.println("           - Tasks Main Menu -           ");
        System.out.println("*****************************************");
        System.out.println("* 1. load an existing task list         *");
        System.out.println("* 2. view current task list options     *");
        System.out.println("* 3. quit to main menu                  *");
        System.out.println("*****************************************");
    }
    public String retrieveTasksMainMenuInput() {
        String choice = "";
        Scanner choiceInput = new Scanner(System.in);
        boolean flag = true;

        //loop until a valid choice is made...
        while (flag) {
            System.out.print(System.lineSeparator());
            System.out.print("Enter your choice: ");
            choice = choiceInput.nextLine();

            //check if input is 1-3...
            if (choice.matches("[1-3]")) {
                flag = false;
            }
            else {
                System.out.println(("You must choose between the 3 menu options..."));
            }
        }

        return choice;
    }
    //branch menu functions...
    public void displayTaskListOperationsMenu() {
        System.out.print(System.lineSeparator());
        System.out.println("    - Task List Operation Menu -    ");
        System.out.println("************************************");
        System.out.println("* 1. view current task list        *");
        System.out.println("* 2. add a task                    *");
        System.out.println("* 3. edit a task                   *");
        System.out.println("* 4. delete a task                 *");
        System.out.println("* 5. set a task as complete        *");
        System.out.println("* 6. set a task as incomplete      *");
        System.out.println("* 7. save current task list        *");
        System.out.println("* 8. quit to task list main menu   *");
        System.out.println("************************************");
    }
    public String retrieveTaskListOperationsMenuInput() {
        String choice = "";
        boolean flag = true;

        //loop until a valid choice is made...
        while (flag) {
            System.out.print(System.lineSeparator());
            System.out.print("Enter your choice: ");
            choice = userInput.nextLine();

            //check if choice is within bounds (1-8 in menu)...
            if (choice.matches("[1-8]")) { //check if input is 1-8...
                flag = false;
            } else {
                System.out.println(("You must choose between the 8 menu options..."));
            }
        }

        return choice;
    }

    //determine if operation menu (action or actions to take) is needed. Currently
    //using switch case from within branchMenu() to accomplish this...

    /**
     ==========================================================
     the main app class should have the following options:
     option 1: open this taskApp...
     option 2: open ContactsApp...
     option 3: quit/close the program (the entire program)...
     ==========================================================
     at the moment, the second (main) constructor is never used
     - only the default constructor is called...
     ==========================================================
     **/
}