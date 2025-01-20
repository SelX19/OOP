import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import week15_mid_prep.LibraryManagementSystem.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    private List<Book> books;

    @BeforeEach
    public void setUp(){
        books = LibraryLoader.loadBooks("/Users/selmadjozic/IdeaProjects/OOP_labss/src/test/resources/testBooks.csv"); //test csv file, with missing mandatory fields, throwing exceptions, etc.
    }

    @Test
    public void testMissingFields_ThrowInvalidBookException(){
        assertThrows(InvalidBookException.class, ()->{LibraryLoader.loadBooks("/Users/selmadjozic/IdeaProjects/OOP_labss/src/test/resources/testMissingFields.csv");},
                "InvalidBookException is expected to be thrown, due to missing mandatory fields. ");
    }

    @Test
    public void testInvalidData_ThrowInvalidBookException(){
        assertThrows(InvalidBookException.class, ()->{LibraryLoader.loadBooks("/Users/selmadjozic/IdeaProjects/OOP_labss/src/test/resources/testInvalidData.csv");},
                "InvalidBookException is expected to be thrown, due to invalid data entry (e.g. negative price).");
    }

    @Test
    public void testLoadBooks_VerifyDataIntegrity(){
        try {
            Book firstBook = books.getFirst();
            Date publDate = new SimpleDateFormat("yyyy-MM-dd").parse("2018-05-08");
            assertAll(
                    //validating that the list of books is not empty (for further tests to take place and be able to pass)
                    () -> assertNotNull(books, "Books list shall not be null."),
                    //validating list's size (number of books)
                    () -> assertEquals(3, books.size(), "Number of books in a list shall be 3."),
                    //verifying data integrity (of the first book from the list)
                    () -> assertEquals("ISBN-001", firstBook.getIsbn(), "Isbn of the first book shall be 'ISBN-001'."),
                    () -> assertEquals("Effective Java", firstBook.getTitle(), "Title of the first book shall be 'Effective Java'."),
                    () -> assertEquals("Joshua Bloch", firstBook.getAuthor(), "Author of the first book shall be 'Joshua Bloch'."),
                    () -> assertEquals(publDate, firstBook.getPublicationDate(), "Publication date of the first book shall be '2018-05-08'."),
                    () -> assertEquals(BookCategory.SCIENCE, firstBook.getCategory(), "Category of the first book shall be 'SCIENCE'."),
                    () -> assertEquals(50.00, firstBook.getPrice(), "Price of the first book shall be 50.00."),
                    () -> assertEquals(AvailabilityStatus.AVAILABLE, firstBook.getAvailability(), "Category of the first book shall be 'AVAILABLE'.")


            );
        }
        catch(ParseException e){
            throw new RuntimeException(e);
        }
    }

    //testing if new file/report could be created using the class and its method for file writing
    @Test
    public void testGenerateReport_FileCreation(){
        String outputFileName = "test_library_report.csv";

        LibraryReportGenerator.generateReport(outputFileName, books);

        //asserting that the report file exists(has been created)
        File reportFile = new File(outputFileName); //testBooks.csv
        assertTrue(reportFile.exists(), "Report file shall exist.");

        try{
            //asserting the size of the newly created report
            List<String> lines = Files.readAllLines(Paths.get(outputFileName)); //** including header line of the report as well

            assertEquals(4, lines.size(), "Report's size shall be 4, including the header line");

            String headerLine = lines.get(0);

            assertEquals("isbn, title, author, publicationDate, category, price, availability", headerLine, "Header mismatch.");

        }
        catch(IOException e){
            throw new RuntimeException(e);
        }

        reportFile.delete();
    }

    @Test
    public void testFileNotFound_ThrowRuntimeException(){
        //attempting to load a non-existent file, and asserting that the Runtime exception, with FileNotFound cause, is thrown in that case
        RuntimeException exception = assertThrows(RuntimeException.class, ()->{LibraryLoader.loadBooks("non_existent_file.csv");}, "Expected Runtime exception.");
        Throwable exCause = exception.getCause();
        String expectedMessage = "non_existent_file.csv (No such file or directory)";
        assertEquals(FileNotFoundException.class + ": "+ expectedMessage, "class "+ exCause, "The cause of RuntimeException shall be FileNotFoundException - trying to load a non-existent file.");

    }
}
