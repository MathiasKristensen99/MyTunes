package sample.bll.util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.be.Song;

public class SongFilter {

    private ObservableList<Song> songSearch = FXCollections.observableArrayList(); //List where we can store the search

    /**
     * Method for searching through the songs in our song table. Using a for loop.
     * We use the .toLowerCase function so the search isn't case sensitive.
     * @param songs
     * @param text
     * @return
     */
    public ObservableList <Song> searchSong (ObservableList<Song> songs, String text) {
        songSearch.clear();
        for (Song song : songs) {
            if (song.getTitle().toLowerCase().startsWith(text.toLowerCase())) {
                songSearch.add(song);
            }
        }
        return songSearch;
    }
}
