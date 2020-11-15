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

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDueDate() {
        return this.dueDate;
    }
}
