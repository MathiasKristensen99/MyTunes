package sample.bll.util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.be.Song;

public class SongFilter {

    private ObservableList<Song> songSearch = FXCollections.observableArrayList();

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
