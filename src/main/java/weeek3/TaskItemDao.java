package weeek3;

import com.mysql.cj.protocol.Resultset;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskItemDao {
    //creating an instance of connection object
    private Connection connection;

    //constructor - initializing a connection
    public TaskItemDao(DbConnect dbConnection){
        this.connection = dbConnection.getConnection();
    }

    //fetch all task entities from a db:
    public List<ex1_TaskItem> getAllTasks() {
        List<ex1_TaskItem> tasks = new ArrayList<>();
        String query = "SELECT * FROM tasks"; // Ensure table and column names are correct
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("task_id"); // Update with actual column name
                String description = resultSet.getString("task_description");
                TaskStatus status = TaskStatus.valueOf(resultSet.getString("task_status"));
                tasks.add(new ex1_TaskItem(id, description, status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    //fetch a specific task entity by its id:

    //return type is now just from a TaskItem class, not a list, just one task
    //taking id as a parameter

    public ex1_TaskItem getTaskById(int id) {
        ex1_TaskItem task = null;

        // Verify the column name matches your database structure
        String query = "SELECT * FROM tasks WHERE task_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    String description = rs.getString("task_description");

                    // Use uppercase for matching enum values
                    String statusValue = rs.getString("task_status").toUpperCase();
                    TaskStatus status;
                    try {
                        status = TaskStatus.valueOf(statusValue);
                    } catch (IllegalArgumentException e) {
                        // Handle unexpected status values (optional)
                        e.printStackTrace();
                        status = TaskStatus.TO_DO; // Default status or handle as required
                    }

                    task = new ex1_TaskItem(id, description, status);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return task;
    }


    //create a new task:
    public void createTask(ex1_TaskItem task) {
        String query = "INSERT INTO tasks (task_description, task_status) VALUES (?, ?)"; // Use auto-increment ID
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, task.getTaskDescription());
            statement.setString(2, task.getTaskStatus().name());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //update task name with specific id:
    public void updateTask(int id, String newDescription ){
        String query = "UPDATE tasks SET task_description = ? WHERE task_id = ?";
        try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1, newDescription);
            statement.setInt(2, id);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
