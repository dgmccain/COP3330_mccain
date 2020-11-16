import java.util.ArrayList;
import java.util.Scanner;

public class TaskList {
    //variable(s) must be static to use from main...
    private static ArrayList<TaskItem> taskList = new ArrayList<>();

    //store task items in task list...
    public static void addTasks(TaskItem tempTask) {
        taskList.add(tempTask);
    }

    public static int getIntFromUser(String msg) {
        Scanner taskNumInput = new Scanner(System.in);
        boolean flag = true;

        //make user input int...
        while (flag) {
            System.out.print("Enter which task number you want to " + msg + ": ");

            //exception handling here...
            if (!taskNumInput.hasNextInt()) {
                System.out.println("invalid input...");
                taskNumInput.next();
            } else {
                flag = false;
            }
        }

        //assign int variable to the user's valid input...
        int taskNum = taskNumInput.nextInt();

        return taskNum;
    }

    //edit task items in task list...
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
            taskList.get(taskNum).title = App.getTitle();
            taskList.get(taskNum).description = App.getDescription();
            taskList.get(taskNum).dueDate = App.getDueDate();
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

    public static void storeTasks() {
        //store list to txt file...
    }

    public static void loadTasks() {
        //read from txt file and store as new(?) list...
    }
}
