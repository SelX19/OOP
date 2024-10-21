package weeek3;

import java.util.Arrays;
import java.util.List;

public class DataStructures2 {

    private TaskItemDao taskItemDao;

    //constructor
    public DataStructures2(TaskItemDao taskItemDao) {

        this.taskItemDao = taskItemDao;
    }


    // Fetch all tasks from the database:
    public List<ex1_TaskItem> getAllTasks() {
        return taskItemDao.getAllTasks();
    }

    //Fetch a task by its id:
    public ex1_TaskItem getTaskById(int id) {
        return taskItemDao.getTaskById(id);
    }

    // Create a new task
    public void createTask(ex1_TaskItem task) {
        taskItemDao.createTask(task);
    }

    // Update task description by ID
    public void updateTaskDescription(int id, String newDescription) {
        taskItemDao.updateTask(id, newDescription);
    }

    public static void main(String[] args){
        //initializing db connection:
        DbConnect dbConnect = new DbConnect();
        TaskItemDao taskItemDao = new TaskItemDao(dbConnect);
        DataStructures2 ds = new DataStructures2(taskItemDao);

        // Fetch all tasks from the database
        System.out.println("All Tasks:");
        ds.getAllTasks().forEach(System.out::println);

        // Fetch a task by ID
        System.out.println("\nTask with ID 1:");
        ex1_TaskItem task = ds.getTaskById(1);
        System.out.println(task);

        // Create a new task
        System.out.println("\nCreating a new task...");
        ex1_TaskItem newTask = new ex1_TaskItem(4, "Submit final project", TaskStatus.TO_DO);
        ds.createTask(newTask);

        // Update a task description by ID
        System.out.println("\nUpdating task description for task ID 1...");
        ds.updateTaskDescription(1, "Push updated code to GitHub");
    }

}
