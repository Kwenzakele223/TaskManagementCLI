public class Task
{
    private int id;
    private String title;
    private String description;
    private boolean completed;
    private int userId;

    public Task(int id, String title, String description, int userId)
    {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = false;
        this.userId = userId;
    }

    public int getId(){return id;}
    public String getTitle(){return title;}
    public String getDescription(){return  description;}
    public boolean isCompleted(){return completed;}
    public int getUserId(){return userId;}


    //set false to true
    public void markComplete()
    {
        this.completed = true;
    }

}
