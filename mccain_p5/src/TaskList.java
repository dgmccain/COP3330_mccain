import java.util.ArrayList;

public class TaskList {
    private final ArrayList<TaskItem> taskList = new ArrayList<>();

    public TaskList() {
        //default constructor...
    }

    //add item to list...
    public void addItemToList(TaskItem taskItem) {
        taskList.add(taskItem);
    }

    //edit items in list...
    public void editItemInList(TaskItem updatedTaskItem, int location) {
        try {
            this.taskList.get(location).setTitle(updatedTaskItem.getTitle());
            this.taskList.get(location).setDescription(updatedTaskItem.getDescription());
            this.taskList.get(location).setDueDate(updatedTaskItem.getDueDate());
            this.taskList.get(location).setStatusAsIncomplete();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    //delete item from list...
    public void deleteItemFromList(int index) {
        taskList.remove(index);
        System.out.println("task #" + (index + 1) + " was deleted");
    }

    //display entire list contents...
    public void displayItemsInList() {
        String mark = "***";

        for (int i = 0; i < this.taskList.size(); i++) {
            //use (i+1) so that task #0 becomes task #1...
            System.out.print((i + 1 + ")"));
            //only output "***" if the task item status is true...
            if (this.taskList.get(i).getStatus()) {
                System.out.print(" " + mark);
            }
            //output remaining task item object variables...
            System.out.println(" " + this.taskList.get(i).getTitle() + ": " +
                    this.taskList.get(i).getDescription() + " [" + this.taskList.get(i).getDueDate() + "]");
        }
    }

    //display marked/unmarked task items in task list...
    public void displayMarkedTasksInList() {
        String mark = "***";

        for (int i = 0; i < this.taskList.size(); i++) {
            //only output "***" if the task item status is true...
            if (this.taskList.get(i).getStatus()) {
                //use (i+1) so that task #0 becomes task #1...
                System.out.print((i + 1 + ")"));
                System.out.print(" " + mark);

                //only output completed task items...
                System.out.println(" " + this.taskList.get(i).getTitle() + ": " +
                        this.taskList.get(i).getDescription() + " [" + this.taskList.get(i).getDueDate() + "]");
            }
        }
    }
    public void displayUnmarkedTasksInList() {
        for (int i = 0; i < this.taskList.size(); i++) {
            //only output task item if the status is false...
            if (!this.taskList.get(i).getStatus()) {
                //use (i+1) so that task #0 becomes task #1...
                System.out.print((i + 1 + ")"));

                //only output incomplete task items...
                System.out.println(" " + this.taskList.get(i).getTitle() + ": " +
                        this.taskList.get(i).getDescription() + " [" + this.taskList.get(i).getDueDate() + "]");
            }
        }
    }

    //set task item in task list to marked/unmarked...
    public void markItemInList(int index) {
        int taskNum = index + 1;
        //if status is unmarked...
        if (!this.taskList.get(index).getStatus()) {
            this.taskList.get(index).setStatusAsComplete();
            System.out.println("task #" + taskNum + " was marked...");
        } else {
            System.out.println("task #" + taskNum + " was already marked...");
        }
    }
    public void unmarkItemInList(int index) {
        int taskNum = index + 1;
        //if status is marked...
        if (this.taskList.get(index).getStatus()) {
            this.taskList.get(index).setStatusAsIncomplete();
            System.out.println("task #" + taskNum + " was unmarked...");
        } else {
            System.out.println("task #" + taskNum + " was already unmarked...");
        }
    }

    //function to basically allow .size() function within TaskApp class...
    public int getEntireListSize() {
        return taskList.size();
    }
    public int getMarkedListSize() {
        int count = 0;
        for (int i = 0; i < taskList.size(); i++) {
            //if status is marked, then add to count...
            if(taskList.get(i).getStatus()) {
                count++;
            }
        }
        return count;
    }
    public int getUnmarkedListSize() {
        int count = 0;
        for (int i = 0; i < taskList.size(); i++) {
            //if status is unmarked, then add to count...
            if(!taskList.get(i).getStatus()) {
                count++;
            }
        }
        return count;
    }
}