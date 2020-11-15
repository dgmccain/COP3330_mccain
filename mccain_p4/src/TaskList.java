import java.util.ArrayList;
import java.util.Scanner;

public class TaskList {
    //variable(s) must be static to use from main...
    private static ArrayList<TaskItem> taskList = new ArrayList<>();

    //store task items in task list...
    public static void addTasks(TaskItem tempTask) {
        taskList.add(tempTask);
    }

    //edit task items in task list...
    public static void editTasks(int listNum) {
        //make sure user has been prompted to enter the task list # they want to edit...
        //make sure that the data is correctly being overwritten...
        taskList.get(listNum).getTitle();
        taskList.get(listNum).getDescription();
        taskList.get(listNum).getDueDate();
    }

    //remove task item from task list...
    public static void deleteTask() {
        Scanner taskNumInput = new Scanner(System.in);
        boolean flag = true;

        //make user input int...
        while (flag) {
            TaskList.printTasks();
            System.out.print("Enter which task number you want to delete: ");

            //exception handling here...
            if (!taskNumInput.hasNextInt()) {
                taskNumInput.next();
            } else {
                flag = false;
            }
        }

        //assign int variable to the user's valid input...
        int taskNum = taskNumInput.nextInt();

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
            System.out.println(i + ") " + taskList.get(i).title +": " +
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
