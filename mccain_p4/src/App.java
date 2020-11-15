import java.util.Scanner;

public class App {

    public static void displayMainMenu() {
        System.out.print(System.lineSeparator());
        System.out.println("           - Main Menu -           ");
        System.out.println("***********************************");
        System.out.println("* 1. create a new task list       *");
        System.out.println("* 2. load an existing task list   *");
        System.out.println("* 3. quit the program             *");
        System.out.println("***********************************");
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
        System.out.println("       - Create List Menu -       ");
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

    //this function originally returned a boolean, but could not be accessed
    //from within main function because of nested function looping...
    public static boolean determineListMenuOption(String choice) {
        boolean shouldGoToMainMenu = false;
        switch(choice) {
            case "1": //view current task list...
                TaskList.printTasks();
                break;
            case "2": //add task item to task list...
                //create a temporary task item populated from a function...
                TaskItem tempTaskItem = getTaskItemFromUser();

                //store task item in task array list...
                TaskList.addTasks(tempTaskItem);
                break;
            case "3": //edit a task item...
                System.out.println("case 3");
                break;
            case "4": //delete a task item...
                TaskList.deleteTask();
                break;
            case "5": //mark a task item...
                System.out.println("case 5");
                break;
            case "6": //unmark a task item...
                System.out.println("case 6");
                break;
            case "7": //save current task list...
                System.out.println("case 7");
                break;
            case "8": //return to main menu...
                shouldGoToMainMenu = true;
                break;
            default:
                System.out.println("Error occurred when trying to determine your choice...");
        }

        return shouldGoToMainMenu;
    }

    public static String getFileName() {
        String fileName;
        Scanner fileNameInput = new Scanner(System.in);

        System.out.print("Enter the name of the file you want to load: ");
        fileName = fileNameInput.nextLine();

        //exception handling goes here, along with checking if file exists...

        return fileName;
    }

    public static boolean branchFromMainMenu(String mainMenuChoice) {
        String createListChoice;
        boolean shouldGoToMainMenu = false;
        switch(mainMenuChoice) {
            case "1":
                //open create list menu...
                displayCreateListMenu();
                createListChoice = createListMenuInput();
                shouldGoToMainMenu = determineListMenuOption(createListChoice);
                break;
            case "2":
                //load existing task list...
                //String||File tempFileName = getFileName();
                getFileName();

                //main menu SHOULD NOT be called, instead go to
                //createListMenu after loading in the file data...
                shouldGoToMainMenu = true;
                break;
            case "3":
                //quit handled in App's main function before this function is called...
                break;
            default:
                System.out.println("Error occurred when determining choice...");
        }

        return shouldGoToMainMenu;
    }

    public static String getTitle() {
        String tempTitle = ""; //initialize to essentially contain 0 chars...
        Scanner titleInput = new Scanner(System.in);

        //loop ensures that title will contain at least 1 char...
        while (tempTitle.matches("")) {
            System.out.print("Enter a Title: ");
            tempTitle = titleInput.nextLine();

            //exception handling...
            try {
                if (tempTitle.matches("")) {
                    throw new InvalidTitleException();
                }
            } catch (InvalidTitleException e) {
                System.out.println("You need to enter a title...");
            }
        }

        return tempTitle;
    }

    public static String getDescription() {
        String tempDescription; //description can be left blank...
        Scanner descriptionInput = new Scanner(System.in);

        //no need for exception handling since description can be left
        //blank and/or edited with the program...
        System.out.print("Enter a Description: ");
        tempDescription = descriptionInput.nextLine();

        return tempDescription;
    }

    public static String getDueDate() {
        String tempDueDate = "";
        Scanner dueDateInput = new Scanner(System.in);
        boolean flag = true;

        //loop until valid due date is entered...
        while (flag) {
            System.out.print("Enter a Due Date [YYYY-MM-DD] format: ");
            tempDueDate = dueDateInput.nextLine();

            //exception handling...
            //current issue: months can range from 0-19, and days can range from 0-39...
            try {
                if (tempDueDate.matches("[0-9]{4}[-][0-1][0-9][-][0-3][0-9]")) {
                    flag = false;
                }
                else {
                    //flag remains true so while loop continues...
                    throw new InvalidDueDateException();
                }
            } catch (InvalidDueDateException e) {
                //flag remains true so while loop continues...
                System.out.println("You entered an invalid date." +
                        " Make sure to include - between year, month, and day...");
            }
        }

        return tempDueDate;
    }

    public static TaskItem getTaskItemFromUser() {
        //get user input...
        String tempTitle = getTitle();
        String tempDescription = getDescription();
        String tempDueDate = getDueDate();

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
        //store to txt file instead of print...
        TaskList.printTasks();
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
    write TaskList (array list within the class) to txt file for output
    readable input txt file needs to be abl to store text within TaskList
    - (array list). Explained another way on next line...
    previously stored txt files should be able to load as input for TaskList
    - they should then be able to be modified within the program
    modifications for adding, editing, and removing task items should be 3
    - separate cases within the menu
    =========================================================================
    *update menu functionality*
    will need to include a switch case for the menu
    once switch case is added, quitKey needs to be changed to int value that
    -corresponds to the "quit program" option from the new/updated menu
    =========================================================================
    *more updates to menu options*
    task items within a list need to have the option to be marked as completed
    - or incomplete from user input in menu
    need to make sure that the updated menu works with the new features
    =========================================================================
    *FINAL STEPS*
    when finished, create JUnit tests <DO NOT FORGET TO DO FOR FULL CREDIT!!!>
*/