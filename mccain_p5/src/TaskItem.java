public class TaskItem {
    private String title;
    private String description;
    private String dueDate;
    private boolean status; //status is complete/incomplete task status...

    //default constructor...
    public TaskItem(String title, String description, String dueDate) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.status = false;
        //TaskApp should not retrieve status from user input when a new task
        //item is created (because new tasks should not be set as complete),
        //so the default status should be set to false (incomplete).
    }

    //constructor with status included as a parameter...
    public TaskItem(String title, String description, String dueDate, boolean status) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
    }

    //add setters, create conditions for title and dueDate, and maybe
    //getters - need to see if getters would be helpful/used...
}