package weeek3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataStructures {

        private List<ex1_TaskItem> tasks;

        //constructor
        public DataStructures() {
            tasks = Arrays.asList(
                    new ex1_TaskItem(1, "Push lab code to the github", TaskStatus.TO_DO),
                    new ex1_TaskItem(2, "Prepare for the quiz", TaskStatus.IN_PROGRESS),
                    new ex1_TaskItem(3, "Go over tasks from lab2", TaskStatus.COMPLETED));

        }

        //Task 1: method to get all tasks
        public List<ex1_TaskItem> getAllTasks() {
            return tasks;
        }

        //Task 2: method to get tasks by status
        public List<ex1_TaskItem> getByStatus(TaskStatus status) {
            return tasks.stream()
                    .filter(task->task.getTaskStatus()==status)
                    .collect(Collectors.toList());
        }

        // Task 3 : Method to find tasks whose id is greater than or equal to 2
       public List<ex1_TaskItem> getByIdGreaterOrEqualToTwo() {
            return tasks.stream()
                    .filter(task->task.getTaskId()>=2)
                    .collect(Collectors.toList());
       }

       // Task4 : Method to print the description of each task
    public void printDescriptionOfEachTask() {
            tasks.forEach(task-> System.out.println(task.getTaskDescription()));
    }

    public static void main(String[] args) {
        DataStructures ds = new DataStructures(); //creating a new object to apply custom methods on

        System.out.println("All Tasks:");
        ds.getAllTasks().forEach(System.out::println);

        System.out.println("\nTasks with status IN_PROGRESS:");
        ds.getByStatus(TaskStatus.IN_PROGRESS).forEach(System.out::println);

        System.out.println("\nTasks with id greater than or equal to 2:");
        ds.getByIdGreaterOrEqualToTwo().forEach(System.out::println);

        System.out.println("\nTask Descriptions:");
        ds.printDescriptionOfEachTask();
    }

    }
