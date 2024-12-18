package week10.task4;

public class Song {

    private String title;
    private String artist;
    private String genre;

    public Song(String title, String artist, String genre){
        this.title=title;
        this.artist=artist;
        this.genre=genre;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString(){
        return (String.format("Title: %s | Artist: %s | Genre: %s", title, artist, genre));
    }
}
