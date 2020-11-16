import java.io.File;
import java.util.Scanner;

public class App {

    public static void displayMainMenu() {
        System.out.print(System.lineSeparator());
        System.out.println("                     - Main Menu -                     ");
        System.out.println("*******************************************************");
        System.out.println("* 1. load an existing task list                       *");
        System.out.println("* 2. view loaded task list or create a new task list  *");
        System.out.println("* 3. quit the program                                 *");
        System.out.println("*******************************************************");
    }

    public static String mainMenuInput() {
        String choice = "";
        Scanner choiceInput = new Scanner(System.in);
        boolean flag = true;

        //loop until a valid choice is made...
        while (flag) {
            System.out.print("\nEnter your choice: ");
            choice = choiceInput.nextLine();

            //exception handling...
            try {
                //check if input is 1-3...
                if (choice.matches("[1-3]")) {
                    flag = false;
                }
                else {
                    throw new InvalidChoiceException();
                }
            } catch (InvalidChoiceException e) {
                System.out.println("You must choose between the 3 menu options...");
            }
        }

        return choice;
    }

    public static void displayCreateListMenu() {
        System.out.print(System.lineSeparator());
        System.out.println("        - Task List Menu -        ");
        System.out.println("**********************************");
        System.out.println("* 1. view current task list      *");
        System.out.println("* 2. add a task                  *");
        System.out.println("* 3. edit a task                 *");
        System.out.println("* 4. delete a task               *");
        System.out.println("* 5. set a task as complete      *");
        System.out.println("* 6. set a task as incomplete    *");
        System.out.println("* 7. save current task list      *");
        System.out.println("* 8. quit to main menu           *");
        System.out.println("**********************************");
    }

    public static String createListMenuInput() {
        String choice = "";
        Scanner choiceInput = new Scanner(System.in);
        boolean flag = true;

        //loop until a valid choice is made...
        while (flag) {
            System.out.print("\nEnter your choice: ");
            choice = choiceInput.nextLine();

            //exception handling...
            try {
                //check if input is 1-8...
                if (choice.matches("[1-8]")) {
                    flag = false;
                } else {
                    throw new InvalidChoiceException();
                }
            } catch (InvalidChoiceException e) {
                System.out.println("You must choose between the 8 menu options...");
            }
        }

        return choice;
    }

    public static boolean determineListMenuOption(String choice) {
        boolean shouldGoToMainMenu = false;
        switch (choice) {
            case "1" -> TaskList.printTasks(); //view current task list...
            case "2" -> { //add task item to task list...
                //create a temporary task item populated from a function...
                TaskItem tempTaskItem = setTaskItemFromUser();
                //store task item in task array list...
                TaskList.addTasks(tempTaskItem);
            }
            case "3" -> TaskList.editTasks(); //edit a task item...
            case "4" -> TaskList.deleteTask(); //delete a task item...
            case "5" -> System.out.println("case 5"); //mark a task item...
            case "6" -> System.out.println("case 6"); //unmark a task item...
            case "7" -> TaskList.storeTasks(); //save current task list to txt file...
            case "8" -> shouldGoToMainMenu = true; //return to main menu...
            default -> System.out.println("Error occurred when trying to determine your choice...");
        }

        return shouldGoToMainMenu;
    }

    public static String getFileName() {
        String fileName;
        Scanner fileNameInput = new Scanner(System.in);

        System.out.print("Enter the name of the file you want to load: ");
        fileName = fileNameInput.nextLine();

        return fileName;
    }

    public static boolean doesFileExist(String fileName) {
        File inputFile = new File(fileName);

        return inputFile.exists();
    }

    public static boolean branchFromMainMenu(String mainMenuChoice) {
        String createListChoice;
        boolean shouldGoToMainMenu = false;

        //NOTE: Unconventional switch case was used to
        //streamline handling file loading sequence...
        switch(mainMenuChoice) {
            case "1":
                //load existing task list...
                String tempFileName = getFileName();
                //check if the file entered exists...
                boolean doesExist = doesFileExist(tempFileName);

                if (doesExist) {
                    //load file contents into list...
                    TaskList.loadTasks(tempFileName);
                    //if file load was successful then main menu should still be called...
                    shouldGoToMainMenu = true;
                }
                else {
                    //return to main menu...
                    System.out.println("The file name you entered does not exist...");
                    shouldGoToMainMenu = true;
                    break;
                }
                break;
                //case 1 should only break if there is an error reading the file name. The code
                //should then bring up the main menu again. Otherwise, new menu functions from
                //case 2 should be invoked using the data that was loaded from the txt file...
            case "2":
                //open create list menu...
                displayCreateListMenu();
                createListChoice = createListMenuInput();
                shouldGoToMainMenu = determineListMenuOption(createListChoice);
                break;
            case "3":
                //quitting the program is handled in the App's main function
                //before this function is ever called...
                break;
            default:
                System.out.println("Error occurred when determining choice...");
        }

        return shouldGoToMainMenu;
    }

    public static TaskItem setTaskItemFromUser() {
        //get user input...
        String tempTitle = TaskItem.setTitle();
        String tempDescription = TaskItem.setDescription();
        String tempDueDate = TaskItem.setDueDate();

        //create task item from the above variables, then return the object...
        return new TaskItem(tempTitle, tempDescription, tempDueDate);
    }

    //the following classes are used for exception handling...
    static class InvalidTitleException extends IllegalArgumentException {
        public InvalidTitleException() {
            super();
        }
    }
    static class InvalidDueDateException extends IllegalArgumentException {
        public InvalidDueDateException() {
            super();
        }
    }
    static class InvalidChoiceException extends IllegalArgumentException {
        public InvalidChoiceException() {
            super();
        }
    }

    //main method...
    public static void main(String[] args) {
        boolean quitKey = false;
        String menuChoice = null;
        boolean mainMenuOpen = true;

        while (!quitKey) {
            //start with main menu...
            while(mainMenuOpen) {
                displayMainMenu();
                menuChoice = mainMenuInput();
                mainMenuOpen = false; //close after user choice is made...
            }

            //determine what choice was made in the main menu...
            if (menuChoice.matches("3")) {
                quitKey = true;
            }
            else {
                mainMenuOpen = branchFromMainMenu(menuChoice);
            }

        }

        System.out.println("Program closing...");
    }
}

/*
    TO DO:
    *CURRENT ISSUE(S)*
    TaskList uses static for functions and even array list variable
    =========================================================================
    *console input exception handling*
    modify exception handling of inputting a title and due date
    - the dueDate months need to range from 01 to 12, instead of 00 to 19
    - the dueDate days need to range between 01 and 31 according to month
    =========================================================================
    *file IO*
    readable input txt file needs to be able to store text within TaskList
    - (array list). Explained another way on next line...
    previously stored txt files should be able to load as input for TaskList
    =========================================================================
    *more updates to menu options*
    task items within a list need to have the option to be marked as completed
    - or incomplete from user input in menu
    need to make sure that the updated menu works with the new features
    =========================================================================
    *FINAL STEPS*
    when finished, create JUnit tests <DO NOT FORGET TO DO FOR FULL CREDIT!!!>
*/