package week10.task4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[]args){
        List<Song>songs = new ArrayList<>();
        Song song1 = new Song("Señorita", "Shawn Mendes", "english pop");
        Song song2 = new Song("Cradles", "Sub Urban", "english pop");
        Song song3 = new Song("Believer", "Imagine Dragons", "english pop");
        Song song4 = new Song("Adelante", "Otilia", "spanish electro");

        songs.add(song1);
        songs.add(song2);
        songs.add(song3);
        songs.add(song4);

        GenreFilterIterator gfi = new GenreFilterIterator(songs, "english pop");

        while(gfi.hasNext()){
            System.out.println(gfi.next());
        }

    }
}
