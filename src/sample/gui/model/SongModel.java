package sample.gui.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.be.Song;
import sample.bll.SongManager;

import java.io.IOException;

public class SongModel {

    private ObservableList<Song> allSongs = FXCollections.observableArrayList();

    private SongManager songManager;

    public SongModel() throws IOException {
        songManager = new SongManager();
    }

    public ObservableList<Song> getAllSongs() {
        allSongs = FXCollections.observableArrayList();
        allSongs.addAll(songManager.getSongs());
        return allSongs;
    }

    public void addSong (String title, String artist, String genre, int playtime, String location) {
        songManager.addSong(title, artist, genre, playtime, location);
    }

    public void deleteSong (Song songDelete) {
        songManager.deleteSong(songDelete);
    }

    public void updateSong(Song songDelete, String title, String artist, String genre, int playtime, String location) {
        songManager.updateSong(songDelete, title, artist, genre, playtime, location);
    }

    //public ObservableList<Song> search (ObservableList<Song> items, String query) {
        //return songManager;
    //}
}
