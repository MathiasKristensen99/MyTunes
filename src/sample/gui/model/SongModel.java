package sample.gui.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.be.Song;
import sample.bll.SongManager;

import java.io.IOException;

public class SongModel {


    private ObservableList<Song> allSongs = FXCollections.observableArrayList();

    private final SongManager songManager;


    public SongModel() throws IOException {
        songManager = new SongManager(); // Creating a songManager object
    }

    /**
     * A JavaFX observableArrayList to show the existing songs in the database
     */
    public ObservableList<Song> getAllSongs() {
        allSongs = FXCollections.observableArrayList();
        allSongs.addAll(songManager.getSongs());
        return allSongs;
    }

    /**
     * Method used for adding a song to the database
     */
    public void addSong (String title, String artist, String genre, int playtime, String location, int id) {
        songManager.addSong(title, artist, genre, playtime, location, id);
    }

    /**
     * Method used to delete a song
     * @param songDelete
     */
    public void deleteSong (Song songDelete) {
        songManager.deleteSong(songDelete);
    }

    /**
     *Updating a song, this is currently not used
     */
    public void updateSong(Song songDelete, String title, String artist, String genre, int playtime, String location) {
        songManager.updateSong(songDelete, title, artist, genre, playtime, location);
    }

    /**
     * Method used to search through the songs
     */
    public ObservableList<Song> searchSongs (ObservableList<Song> songs, String text) {
        return songManager.searchSongs(songs, text);
    }

}
