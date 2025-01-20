package week15_final_prep.MovieDataTransformation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    private static List<Movie> movies;

    @BeforeEach
    public void SetUp(){
        movies=MovieLoader.loadMovies("/Users/selmadjozic/IdeaProjects/OOP_labss/src/test/resources/moviestest.csv");
    }

    @Test
    public void ifValuesEmpty_ThrowCustomException(){
        assertThrows(InvalidMovieDataException.class, ()->{MovieLoader.loadMovies("/Users/selmadjozic/IdeaProjects/OOP_labss/src/test/resources/movies_test_empty_fields");});
    }

    @Test
    public void ifFileLoaded_assertMultipleConditions(){
        assertAll(
                ()->assertEquals("Barbie", movies.get(0).getTitle()),
                ()->assertEquals(2, movies.size())
        );
    }

    @Test
    public void ifFileDoesNotExist_assertCauseIsFileNotFoundException(){
        try{
            MovieLoader.loadMovies("non_existent_file.csv");
        }
        catch(RuntimeException e){
            assertTrue(e.getCause() instanceof FileNotFoundException);
        }
    }

}