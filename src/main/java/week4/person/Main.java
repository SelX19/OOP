package week4.person;


import java.util.ArrayList;
import java.util.List;

//I have created Main class here, since I have accidentally deleted the original Main class
public class Main {

    public static void printDepartment(List<Person> people) {
        for(Person person : people){
            System.out.println(person);
        }
    }
    public static void main(String[] args) {
        List<Person> people = new ArrayList<Person>();
        people.add( new Teacher("Pekka Mikkola", "Korsontie Street 1 03100 Vantaa", 1200) );
        people.add( new Student("Olli", "Ida Albergintie Street 1 00400 Helsinki") );
        printDepartment(people);
        //P.S.:credits for a student not printed out, since we were printing them so far separately using System.out.println, and not by changing toString method to contain it
    }

    Circle circle = new Circle(2.4, "orange", FillType.FILLED);
    Rectangle rectangle = new Rectangle(15, 30, "yellow", FillType.NOT_FILLED);


}
