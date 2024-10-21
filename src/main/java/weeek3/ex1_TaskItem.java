package weeek3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ex1_TaskItem {
    private int taskId;
    private String taskDescription;
    private TaskStatus taskStatus;

    //implementing constructor:
    public ex1_TaskItem(int taskId, String taskDescription, TaskStatus taskStatus){
        this.taskId=taskId;
        this.taskDescription=taskDescription;
        this.taskStatus=taskStatus;
    }

    //implementing getters:
    public int getTaskId() {
        return taskId;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    @Override
    public String toString() {
       return "TaskItem{" +
               "taskId=" + taskId +
               ", taskDescription='" + taskDescription + '\'' +
               ", taskStatus=" + taskStatus +
               '}';
    }
}

