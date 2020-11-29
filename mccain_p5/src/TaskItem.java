public class TaskItem {
    private String title;
    private String description;
    private String dueDate;
    private boolean status; //status is complete/incomplete task status...

    //DEFAULT CONSTRUCTOR (for user input)...
    public TaskItem(String title, String description, String dueDate) {
        if (isTitleValid(title)) {
            this.title = title;
        } else {
            throw new IllegalArgumentException("INVALID - you did not enter a title");
        }

        this.description = description;

        if (isDueDateValid(dueDate)) {
            this.dueDate = dueDate;
        } else {
            throw new IllegalArgumentException("INVALID - you did not enter a correct due date");
        }

        //TaskApp should not retrieve status from user input when a new task
        //item is created (because new tasks should not be set as complete),
        //so the default status should be set to false (incomplete)...
        this.status = false;
    }

    //CONSTRUCTOR (with status included as a parameter)...
    public TaskItem(String title, String description, String dueDate, boolean status) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
    }

    //INPUT VALIDATION
    public boolean isTitleValid(String title) {
        //check if title is empty...
        return !title.matches("");
    }
    public boolean isDueDateValid(String dueDate) {
        //check if due date match yyyy-MM-dd format...
        //if statements ensure that months are 01-12 and days are 01-32...
        //add LocalDate/LocalDateTime and DateTimeFormatter...
        if (dueDate.matches("[0-9]{4}[-][0-1][0-9][-][0-3][0-9]")) {
            //if month == 0...
            if (dueDate.matches("[0-9]{4}[-][0][0][-][0-3][0-9]")) {
                return false;
            }
            //if month >= 13...
            else if (dueDate.matches("[0-9]{4}[-][1][3-9][-][0-3][0-9]")) {
                return false;
            }
            //if days == 0...
            else if (dueDate.matches("[0-9]{4}[-][0-1][0-9][-][0][0]")) {
                return false;
            }
            //if days >= 32...
            else if (dueDate.matches("[0-9]{4}[-][0-1][0-9][-][3][2-9]")) {
                return false;
            }
            //else should return all other valid dates (months 01-12 and days 01-31)...
            else{
                return true;
            }
        } else {
            //input did not match yyyy-MM-dd format...
            return false;
        }
    }

    //SETTERS
    //setTitle() and setDueDate() catch exceptions in the TaskApp class...
    public void setTitle(String title) {
        if (isTitleValid(title)) {
            this.title = title;
        } else {
            throw new IllegalArgumentException("You did not enter a title - Task was not created...");
        }
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setDueDate(String dueDate){
        if(isDueDateValid(dueDate)) {
            this.dueDate = dueDate;
        } else {
            throw new IllegalArgumentException("You must enter a valid due date...");
        }
    }
    public void setStatusAsComplete() {
        this.status = true;
    }
    public void setStatusAsIncomplete() {
        this.status = false;
    }

    //GETTERS
    public String getTitle() {
        return this.title;
    }
    public String getDescription() {
        return this.description;
    }
    public String getDueDate() {
        return this.dueDate;
    }
    public boolean getStatus() {
        return this.status;
    }
}