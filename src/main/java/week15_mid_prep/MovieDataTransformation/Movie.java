package week15_mid_prep.MovieDataTransformation;

import java.util.Date;

public class Movie {

    private Date releaseDate;
    @FieldFormat(text_format=TextFormatter.ORDINARY)
    private String title;
    @FieldFormat(number_format=NumberFormatter.CURRENCY)
    private double boxOffice;
    @FieldFormat(number_format=NumberFormatter.PERCENTAGE)
    private double rating;
    @FieldFormat(text_format=TextFormatter.UPPER_CASE)
    private String genre;
    @FieldFormat(text_format=TextFormatter.UPPER_CASE)
    private String director;
    @FieldFormat(text_format=TextFormatter.LOWER_CASE)
    private String language;

    private Movie(MovieBuilder builder){
        this.releaseDate = builder.releaseDate;
        this.title=builder.title;
        this.boxOffice = builder.boxOffice;
        this.rating = builder.rating;
        this.genre=builder.genre;
        this.director=builder.director;
        this.language=builder.language;
    }

    public static class MovieBuilder{
        private Date releaseDate;
        private String title;
        private double boxOffice;
        private double rating;
        private String genre;
        private String director;
        private String language;

        public MovieBuilder(){

        }

        public MovieBuilder setReleaseDate(Date releaseDate){
            this.releaseDate=releaseDate;
            return this;
        }

        public MovieBuilder setTitle(String title){
            this.title=title;
            return this;
        }

        public MovieBuilder setBoxOffice(double boxOffice){
            this.boxOffice=boxOffice;
            return this;
        }

        public MovieBuilder setRating(double rating){
            this.rating=rating;
            return this;
        }

        public MovieBuilder setGenre(String genre){
            this.genre=genre;
            return this;
        }

        public MovieBuilder setDirector(String director){
            this.director=director;
            return this;
        }

        public MovieBuilder setLanguage(String language){
            this.language=language;
            return this;
        }

        public Movie build(){
            return new Movie(this);
        }

    }

    public Date getReleaseDate(){
        return releaseDate;
    }

    public String getTitle(){
        return title;
    }

    public double getBoxOffice(){
        return boxOffice;
    }

    public double getRating(){
        return rating;
    }

    public String getGenre(){
        return genre;
    }

    public String getDirector(){
        return director;
    }

    public String getLanguage(){
        return language;
    }

}
