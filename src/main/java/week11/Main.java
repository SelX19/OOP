package week11;

import java.io.IOException;
import java.util.Optional;

public class Main{
    public static void main(String[]args){
        try{
            //loading data from the csv file
            StudentSystem system = new StudentSystem("StudentsData.csv");

            //Number of students
            System.out.println("Number of students: " + system.noOfStudents());

            //Get students by id
            int targetId = 1;
            Optional<Student>student = system.getStudentById(targetId);
            student.ifPresentOrElse(
                    s->System.out.println("Found student: "+s),
                    ()->System.out.println("Student with ID " + targetId + "cannot be found.")
            );

            // Get highest GPA student
            System.out.println("Student with highest GPA: " + system.getHighestGPAStudent());

            // Get longest name student
            System.out.println("Student with longest name: " + system.getStudentWithLongestName());

        }
        catch(EmptyStudentListException e){
            System.out.println(e.getMessage());
        }
    }
}
