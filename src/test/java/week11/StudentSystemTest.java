package week11;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class StudentSystemTest {

    private static StudentSystem studentSystem;

    @BeforeAll
    public static void setUp() throws Exception{
        studentSystem = new StudentSystem("StudentData.csv");
    }

    @Test
    public void testifStudentisPresent(){
        assertTrue(studentSystem.noOfStudents()>0, "Student list shall not be empty.");
    }

    @Test
    public void testStudentWithId100(){
        assertThrows(StudentNotFoundException.class, ()->{studentSystem.getStudentById(100);}, "Student with id 100 shall not exist");
    }

    @Test
    public void testHighestGPAStudent(){
        assertEquals(9.8, studentSystem.getHighestGPAStudent().getGPA(), "The highest GPA shall be 9.8");
    }

    @Test
    public void testExceptionForEmptyStudentList(){
        StudentSystem emptySystem = new StudentSystem(new ArrayList<>());
        assertThrows(EmptyStudentListException.class, emptySystem::getHighestGPAStudent, "Exception should be thrown for empty student list.");
    }

    @Test
    public void testExceptionMessageForEmptyStudentList(){
        StudentSystem emptySystem = new StudentSystem(new ArrayList<>());
        EmptyStudentListException exception = assertThrows(EmptyStudentListException.class,
                emptySystem::getHighestGPAStudent, "Exception should be thrown for empty student list.");
        assertEquals("List of students is empty.", exception.getMessage(), "Exception message should match.");
    }

    @Test
    void testNamesArray() throws Exception {
        List<Student> students = StudentSystem.readStudents("students.csv");
        List<String> names = students.stream().map(Student::getName).limit(5).toList();
        List<String> expectedNames = Arrays.asList("Camila Wood", "Alexander Thompson", "Liam Taylor", "Evelyn Jenkins", "Michael Jackson");
        assertEquals(expectedNames, names, "The first five student names should match.");
    }


    @Test
    void testSameStudent() {
        Student highestGPAStudent = studentSystem.getHighestGPAStudent();
        Optional<Student> studentById = studentSystem.getStudentById(12);
        assertTrue(studentById.isPresent(), "Student with ID 12 should exist.");
        assertSame(highestGPAStudent, studentById.get(), "The student with the highest GPA should be the same as the student with ID 12.");
    }

    @Test
    void testValidateStudentData() {
        List<Student> invalidStudents = List.of(
                new Student(1, "John Doe", "Uni", "CS", 5.5), // Invalid GPA
                new Student(2, "Jane Doe", "Uni", "Math", 10.5) // Invalid GPA
        );
        InvalidStudentDataException exception = assertThrows(InvalidStudentDataException.class,
                () -> new StudentSystem(invalidStudents), "Exception should be thrown for invalid GPA data.");
        assertEquals("Read data has invalid rows.", exception.getMessage(), "Exception message should match.");
    }

    @Test
    void testStudentToString() {
        Student student = new Student(1, "John Doe", "Uni", "CS", 8.5);
        assertEquals("John Doe", student.toString(), "toString method should return the student's name.");
    }

    @Test
    void testStudentAttributes() {
        Student student = new Student(1, "John Doe", "Uni", "CS", 8.5);
        assertAll("Student Attributes",
                () -> assertEquals(1, student.getID(), "ID should match."),
                () -> assertEquals("John Doe", student.getName(), "Name should match."),
                () -> assertEquals("Uni", student.getUniversity(), "University should match."),
                () -> assertEquals("CS", student.getDepartment(), "Department should match."),
                () -> assertEquals(8.5, student.getGPA(), 0.01, "GPA should match.")
        );
    }

    }
