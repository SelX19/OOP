package week4.person;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Student extends Person{

    private int student_id;
    private ArrayList<Grades> grades = new ArrayList<Grades>();
    private int credits = 0;

    public Student(String name, String address) {
        super(name,address);
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int study(){
        return this.credits++;
    }

    public int credits() {
        return credits;
    }

    //overriding toString() method for this class, and inheriting and using other methods from parent class, such as getName()
    public String toString() {
        return this.getName() + "\n   " + this.getAddress();
    }

    public void addGrade(Grades grade) {
        for(Grades grade:grades){
            grades.add(grade);
        }
    }

    public static void main(String[] args) {
        Student olli = new Student("Olli", "Ida Albergintie Street 1 00400 Helsinki");
        System.out.println(olli); //printing object - its toString() version, and then printing out credits:
        System.out.println("credits " + olli.credits());
        olli.study();
        System.out.println("credits "+ olli.credits());
    }

}
