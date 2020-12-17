package sample.bll;

import javafx.collections.ObservableList;
import sample.be.Song;
import sample.bll.util.SongFilter;

import sample.dal.SongDAO;

import java.io.IOException;
import java.util.List;


public class SongManager {
    private  SongDAO songDAO;
    private  SongFilter songFilter;

    public SongManager() throws IOException {
        songDAO = new SongDAO();
        songFilter = new SongFilter();
    }

    public Song addSong(String title, String artist, String genre, int playtime, String location, int id) {
        return songDAO.addSong(title, artist, genre, playtime, location);
    }

    public Song updateSong(Song song, String title,String artist, String genre, int playtime, String location) {
        return songDAO.updateSong(song, title, artist, genre, playtime, location);
    }

    public Song deleteSong(Song songDelete) {
        return songDAO.deleteSong(songDelete);
    }

    public List<Song> getSongs() {
        List<Song> allSongs = songDAO.getSongs();
        return allSongs;
    }

    public ObservableList<Song> searchSongs(ObservableList<Song> songs, String text) {
        return songFilter.searchSong(songs, text);
    }
}
