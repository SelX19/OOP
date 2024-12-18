package week10.task2;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String ID;
    private List<Integer> grades;

    public Student(String name, String ID, List<Integer> grades){
        this.name = name;
        this.ID = ID;
        this.grades = grades;
    }

    public List<Integer> getGrades(){
        return grades;
    }

    public void printInfo(){
        System.out.printf("Student's name:%s \nStudent's ID:%s \nStudent's grades:%s\n", name, ID, grades.toString());
    }
}
