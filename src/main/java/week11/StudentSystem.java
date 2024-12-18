package week11;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StudentSystem {

    private List<Student>students;

    public StudentSystem(String filename){
        try(BufferedReader reader = new BufferedReader(new FileReader("Student Data"))){
            String line;
            while((line=reader.readLine())!=null){
                System.out.println(line);
            }
            students = new ArrayList<>();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public StudentSystem(List<Student>students){
        this.students=students;
    }

    //static method, can be returned without making an instance of a class, but directly applied ont he class - belongs to it
    public static List<Student> readStudents(String filename){
        List<Student> students = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader("Student Dat"))){
            String line;
            while((line=reader.readLine())!=null){
                try{
                    //splitting line into fields:

                    String[] data = line.split(","); //csv -comma separated file

                    //parsing and validating data:

                    int id = Integer.parseInt(data[0].trim());
                    String name = data[1].trim();
                    String university = data[2].trim();
                    String department = data[3].trim();
                    double gpa = Double.parseDouble(data[4].trim());

                    if(gpa<6 || gpa>10){
                        throw new InvalidStudentDataException("Invalid student GPA for the student with ID: " + id);
                    }

                    students.add(new Student(id, name, university, department, gpa));

                }
                catch(NumberFormatException | ArrayIndexOutOfBoundsException e){
                    System.out.println("Skipping invalid row: " + line);
                }
                catch (InvalidStudentDataException e) {
                    System.out.println("Skipping student: " + e.getMessage());
                }
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File not found: " + filename);
        } catch (IOException e) {
            System.out.println("Error reading file: " + filename);
        }
        return students;
    }

    public int noOfStudents(){
        return students.size();
    }

    public Optional<Student> getStudentById(int ID){
        return students.stream().filter(student->student.getID()==ID).findFirst();
    }

    //get student with the highest GPA:
    public Student getHighestGPAStudent(){
        if(students.isEmpty()){
            throw new EmptyStudentListException("List of students is empty");
        }
        else{
            return students.stream()
                    .max(Comparator.comparingDouble(Student::getGPA))
                    .orElseThrow(()->new EmptyStudentListException(("List of students is empty.")));
        }
    }

    //get student with the longest name
    public Student getStudentWithLongestName(){
        if(students.isEmpty()){
            throw new EmptyStudentListException("List of students is empty.");
        }
        else{
            return students.stream()
                    .max(Comparator.comparingInt(student->student.getName().length()))
                    .orElseThrow(()->new EmptyStudentListException("List of students empty."));
        }
    }

    //validate student data
    //passing students list as a parameter, since we have assigned this method to be private
    private void validateStudentData(List<Student>students)throws InvalidStudentDataException{
        boolean isValid = students.stream()
                .allMatch(student->student.getGPA()>=6.0 && student.getGPA()<=10.0);
        if(!isValid){
            throw new InvalidStudentDataException("Read data has invalid rows.");
        }
    }

}
