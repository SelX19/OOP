import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import week15_mid_prep.BookDataTransformation.Book;
import week15_mid_prep.BookDataTransformation.FinalPrep;
import week15_mid_prep.BookDataTransformation.WrongFormatException;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {
    private static List<Book> books;

    @BeforeEach
    public void SetUp(){ //load/read list of books before running each test, using FinalPrep's static loadBooks method
        books = FinalPrep.loadBooks("/Users/selmadjozic/IdeaProjects/OOP_labss/src/test/resources/mybooks.csv");
    }

    @Test
    public void ifValuesEmpty_ThrowAnCustomException(){
        assertThrows(WrongFormatException.class, ()->{FinalPrep.loadBooks("/Users/selmadjozic/IdeaProjects/OOP_labss/src/test/resources/books_with_empty_values.csv");},
                "Some mandatory fields are missing, exception shall be thrown.");
    }

    @Test
    public void ifFileLoaded_assertMultipleConditions(){
        assertAll(
                "Validate loaded books",
                ()->assertEquals("B07FWVXXU", books.get(1).getCustomerId()),
                ()->assertEquals(158, books.size())
        );
    }

    @Test
    public void ifFileDoesNotExist_assertCauseIsFileNotFoundException(){
        String nonExistentFile = "path/to/non/existant/file.csv";

        try { //code that shall cause an exception
            FinalPrep.loadBooks(nonExistentFile);
        } catch (RuntimeException ex) {
            // Verify the cause of the exception is a FileNotFoundException
            assertTrue(ex.getCause() instanceof FileNotFoundException,
                    "Cause of RuntimeException should be FileNotFoundException");
        }
    }


}
