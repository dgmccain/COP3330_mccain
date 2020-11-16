import java.util.Scanner;

public class TaskItem {
    //variables need to be protected to use within TaskList.printTasks...
    protected String title;
    protected String description;
    protected String dueDate;

    public TaskItem(String title, String description, String dueDate) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
    }

    public static String setTitle() {
        String tempTitle = ""; //initialize to essentially contain 0 chars...
        Scanner titleInput = new Scanner(System.in);

        //loop ensures that title will contain at least 1 char...
        while (tempTitle.matches("")) {
            System.out.print("Enter a Title: ");
            tempTitle = titleInput.nextLine();

            //exception handling...
            try {
                if (tempTitle.matches("")) {
                    throw new App.InvalidTitleException();
                }
            } catch (App.InvalidTitleException e) {
                System.out.println("You need to enter a title...");
            }
        }

        return tempTitle;
    }

    public String getTitle() {
        return this.title;
    }

    public static String setDescription() {
        String tempDescription; //description can be left blank...
        Scanner descriptionInput = new Scanner(System.in);

        //no need for exception handling since description can be left
        //blank and/or edited with the program...
        System.out.print("Enter a Description: ");
        tempDescription = descriptionInput.nextLine();

        return tempDescription;
    }

    public String getDescription() {
        return this.description;
    }

    public static String setDueDate() {
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
                    throw new App.InvalidDueDateException();
                }
            } catch (App.InvalidDueDateException e) {
                //flag remains true so while loop continues...
                System.out.println("You entered an invalid date. Try again...");
            }
        }

        return tempDueDate;
    }

    public String getDueDate() {
        return this.dueDate;
    }
}
