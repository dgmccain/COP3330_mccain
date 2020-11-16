import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class TaskList {
    //NOTE: variable and functions must be declared static to use from main...
    private static final ArrayList<TaskItem> taskList = new ArrayList<>();

    //default constructor...
    public TaskList() {
        //variable is declared above and the constructor will serve no other purpose...
    }

    //ensure that user enters an int value to use as task number...
    public static int getIntFromUser(String msg) {
        Scanner taskNumInput = new Scanner(System.in);
        boolean flag = true;

        //loop until valid input is entered...
        while (flag) {
            //re-print message if invalid input is entered...
            System.out.print("Enter which task number you want to " + msg + ": ");

            //make user input an int value...
            if (!taskNumInput.hasNextInt()) {
                System.out.println("invalid input...");
                taskNumInput.next();
            } else {
                //if input is valid then a false flag will stop the loop...
                flag = false;
            }
        }

        //return the user's valid input...
        return taskNumInput.nextInt();
    }

    //print array list elements...
    public static void printTasks() {
        //taskList is only accessible from within class TaskList...
        for (int i = 0; i < taskList.size(); i++) {
            //include marked/unmarked status after task #i, but before title...
            //use (i+1) so that task #0 becomes task #1...
            System.out.println((i+1) + ") " + taskList.get(i).title +": " +
                    taskList.get(i).description + " [" + taskList.get(i).dueDate + "]");
        }
    }

    //add task item to task list...
    public static void addTasks(TaskItem tempTask) {
        taskList.add(tempTask);
    }

    //edit task item in task list...
    public static void editTasks() {
        int taskNum;

        //display current tasks for user...
        TaskList.printTasks();

        //get input from user...
        taskNum = getIntFromUser("edit");
        //subtract 1 because displayed task #1 corresponds to list element #0...
        taskNum = taskNum - 1;

        //edit task after ensuring the value is within bounds...
        if (taskNum >= 0 && taskNum <= taskList.size()) {
            System.out.println("Enter new info...");
            App.setTaskItemFromUser();
            /*
            taskList.get(taskNum).title = TaskItem.getTitle();
            taskList.get(taskNum).description = TaskItem.getDescription();
            taskList.get(taskNum).dueDate = TaskItem.getDueDate();
            */
        } else {
            System.out.println("The task number you entered does not exist...");
        }
    }

    //remove task item from task list...
    public static void deleteTask() {
        int taskNum;

        //display current tasks for user...
        TaskList.printTasks();

        //get input from user...
        taskNum = getIntFromUser("delete");
        //subtract 1 because displayed task #1 corresponds to list element #0...
        taskNum = taskNum - 1;

        //delete task after ensuring the value is within bounds...
        if (taskNum >= 0 && taskNum <= taskList.size()) {
            taskList.remove(taskNum);
        } else {
            System.out.println("The task number you entered does not exist...");
        }
    }

    //store list to txt file...
    public static void storeTasks() {
        Scanner fileNameInput = new Scanner(System.in);
        String fileName;
        boolean shouldContinue = true;

        System.out.print("Enter a file name to save your list to: ");
        fileName = fileNameInput.nextLine();

        //check if file name already exists...
        if (App.doesFileExist(fileName)) {
            Scanner overwriteInput = new Scanner(System.in);
            String response;

            System.out.println("That file already exists. Would you like to permanently overwrite it?");
            System.out.print("Enter Y or y to continue: ");
            response = overwriteInput.nextLine();

            //confirm that the user wants to overwrite the file...
            if (response.equalsIgnoreCase("y")) {

                //create file object for deletion...
                File oldFile = new File(fileName);
                //delete the file object to clear all of its contents before overwriting...
                if (oldFile.delete()) {
                    System.out.println("The file was successfully overwritten");
                }
                else {
                    System.out.println("There was an issue overwriting the file...");
                }

                //continue to get new file contents...
                shouldContinue = true;
            }
            //do not continue if the user does not want to overwrite the file...
            else {
                System.out.println(fileName + " was not overwritten...");
                shouldContinue = false;
            }
        }

        if (shouldContinue) {
            //create a new txt file from above user input. The
            //txt file should contain data from the list elements...
            try (Formatter output = new Formatter(fileName)) {
                for (TaskItem taskItem : taskList) {
                    output.format("%s;%s;%s;%n", taskItem.getTitle(), taskItem.getDescription(),
                            taskItem.getDueDate());
                }
                //let user know that the file was saved successfully...
                System.out.println("You saved " + fileName + " successfully!");

                //these catches should not typically be triggered...
            } catch (FileNotFoundException ex) {
                System.out.println("The file name you entered does not exist...");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        //do nothing if the user user does not want to overwrite the file...
    }

    //load txt file contents to list...
    public static void loadTasks(String fileName) {
        String lineTitle;
        String lineDescription;
        String lineDueDate;

        //this function is only called if load is successful...
        System.out.println(fileName + " loaded successfully!");

        //exception handling for loading file...
        try {
            Scanner fileScanner = new Scanner(new File(fileName));

            while (fileScanner.hasNextLine()) {
                //delimiter is what separates the object variables on the same line...
                fileScanner.useDelimiter(";");

                //read title...
                lineTitle = fileScanner.next();
                //read description...
                lineDescription = fileScanner.next();
                //read due date...
                lineDueDate = fileScanner.next();

                //buffer the next line input...
                fileScanner.nextLine();

                //store as new task item...
                TaskItem tempItem = new TaskItem(lineTitle, lineDescription, lineDueDate);
                //store task item in list...
                taskList.add(tempItem);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred when trying to load your file...");
        }

        //read from txt file and store as new(?) list...

        //each line from the txt file pertains to a new list index. The task
        //item data is contained within the list index (line). When data is
        //saved, a delimiter char needs to be added between titles, description,
        //and due date so that this load function can be read correctly. Use the
        //delimiter char (likely ;) to separate the file line into task title,
        //description, and due date - all contained as an element within a list...
    }
}
