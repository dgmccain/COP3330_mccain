import java.util.ArrayList;

public class TaskList {
    //variable(s) must be static to use from main...
    private static ArrayList<TaskItem> taskList = new ArrayList<>();

    //store task items in task list...
    public static void getTasks(TaskItem tempTask) {
        taskList.add(tempTask);
    }

    //print array list elements...
    public static void printTasks() {
        //taskList is only accessible from within class TaskList...
        for (TaskItem taskItem : taskList) {
            //include marked/unmarked status before title...
            System.out.println(taskItem.title +": " + taskItem.description + " [" + taskItem.dueDate + "]");
        }
    }
}
