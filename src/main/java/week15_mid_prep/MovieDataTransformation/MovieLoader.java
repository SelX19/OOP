package week15_mid_prep.MovieDataTransformation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MovieLoader {

    List<Movie> movies = new ArrayList<>();

    public MovieLoader(String fileName){
        this.movies=loadMovies(fileName);
    }

    public static List<Movie> loadMovies(String fileName){
        //P.S.: list of movies returned!!
        List<Movie> movies = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            List<String> lines = reader.lines().collect(Collectors.toList());

            //P.S.:skipping the header line
            for(int i=1; i<lines.size(); i++){

                //splitting each line to its parts/fields
                String[] parts = lines.get(i).split(";");

                //checking if some fields are equal empty
                if(parts[1]=="" || parts[2]==""  || parts[3]==""){
                    throw new InvalidMovieDataException("Invalid data", new ClassCastException());
                }

                //add new object(new line) with all its appropriate parts/fields to the movies list
                movies.add(
                        new Movie.MovieBuilder()
                                .setReleaseDate(new SimpleDateFormat("yyyy-MM-dd").parse(parts[0]))
                                .setTitle(parts[1])
                                .setBoxOffice(Double.parseDouble(parts[2]))
                                .setRating(Double.parseDouble(parts[3]))
                                .setGenre(parts[4])
                                .setDirector(parts[5])
                                .setLanguage(parts[6])
                                .build()
                );
            }
            return movies;
        }
        catch(FileNotFoundException | ParseException e){
            throw new RuntimeException(e);
        }
    }
}
