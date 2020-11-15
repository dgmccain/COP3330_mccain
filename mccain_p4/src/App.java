import java.util.Scanner;

public class App {

    public static void displayMainMenu() {
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

    public static boolean getQuit() {
        Scanner quitInput = new Scanner(System.in);
        String response;
        boolean flag = true;
        boolean result = false; //initialization for result can be true or false...

        //loop until user determines whether or not to quit the program...
        while (flag) {
            System.out.print("Would you like to continue? Enter Y/N: ");
            response = quitInput.next();

            //exception handling...
            try {
                if (response.matches("Y") || response.matches("y")) {
                    flag = false;
                    result = false;
                } else if (response.matches("N") || response.matches("n")) {
                    flag = false;
                    result = true;
                } else {
                    throw new InvalidQuitKeyException();
                }
            } catch (InvalidQuitKeyException e) {
                flag = true;
                System.out.println("You must enter Y/N...");
            }
        }
        return result;
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

    static class InvalidQuitKeyException extends IllegalArgumentException {
        public InvalidQuitKeyException() {
            super();
        }
    }

    static class InvalidChoiceException extends IllegalArgumentException {
        public InvalidChoiceException() {
            super();
        }
    }

    public static void main(String[] args) {
        boolean quitKey = false; //initialize loop at start...
        String menuChoice;
        boolean mainMenuOpen = true;

        while (!quitKey) {
            //start with main menu...
            while(mainMenuOpen) {
                displayMainMenu();
                menuChoice = mainMenuInput();
                mainMenuOpen = false; //close after user choice is made...
            }

            //pass the menuChoice to a function which contains a switch(menuChoice) case
            //to determine which sub-menu the program should branch off to next...

            //create a temporary variable populated from a function...
            TaskItem tempTaskItem = getTaskItemFromUser();

            //store task item in task array list...
            TaskList.getTasks(tempTaskItem);

            quitKey = getQuit();
        }
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