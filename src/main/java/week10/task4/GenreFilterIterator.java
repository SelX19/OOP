package week10.task4;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class GenreFilterIterator implements Iterator<Song>{

    private List<Song> songs;
    private String TargetGenre;
    private int currentIndex;

    public GenreFilterIterator(List<Song>songs, String genre){
        this.songs = songs;
        this.TargetGenre = genre;
        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext(){
       while(currentIndex<songs.size() && !songs.get(currentIndex).getGenre().equals(TargetGenre)){
           currentIndex++; //looping through the playlist (a list of songs), and checking for each song if its genre is equal to Target genre, if not, increment the index
       }
       return currentIndex<songs.size(); //if we have reached the last song of the list and its genre is not he target one, we increment the index and hence index would be out of range, exceeding the playlist's range, and returning false(nor more songs of that genre in the playlist), otherwise, true would be returned (there are more songs of that genre in the playlist)
    }

    @Override
    public Song next(){
        if (!hasNext()) {
            throw new NoSuchElementException("No more songs with the target genre.");
        }
        return songs.get(currentIndex++);
    }
}
