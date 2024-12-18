package week10.task2;

import java.lang.reflect.Field;
import java.util.List;

public class GradeAnalyzer {

    private List<Integer> grades; //shall be student grades

    //defining list of student grades in the constructor, passing them in:

    public GradeAnalyzer(Student student){//passing in student object as parameter - to have the same list of grades
        this.grades = student.getGrades();
    }

    public double calculateAverage(){
        double sum = 0.0;
        double avg;
        for(int grade:grades){
            sum+=grade;
        }
        avg = sum/grades.size();
        return avg;
    }

    public void printSummary(){
        System.out.printf("Grade Summary:\nGrades: %s\nAverage Grade: %.2f\n", grades, calculateAverage());
    }
}
