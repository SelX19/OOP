package week15_final_prep.MovieDataTransformation;

import java.util.List;

public class MainRun {
    public static void main(String[]args){
        List<Movie> movies = MovieLoader.loadMovies("movies.csv");
        ReportWriter.generateReport("movies-report.csv", movies);
        System.out.println("Report has been successfully generated.");
    }
}
