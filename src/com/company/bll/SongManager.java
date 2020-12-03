package com.company.bll;

import com.company.be.Song;
import com.company.dal.SongDAO;
<<<<<<< Updated upstream
=======

import java.util.List;
>>>>>>> Stashed changes

public class SongManager {

    private final SongDAO songDAO;

    public SongManager(SongDAO songDAO) {
        this.songDAO = songDAO;
<<<<<<< Updated upstream
    }

    public Song addSong(String title, String artist, String genre, int playtime, String location) {
        return songDAO.addSong(title, artist, genre, playtime, location);
    }

    public Song updateSong(Song song, String title,String artist, String genre, int playtime, String location) {
        return songDAO.updateSong(song, title, artist, genre, playtime, location);
    }

    public Song deleteSong(Song songDelete) {
        return songDAO.deleteSong(songDelete);
=======

    }
    public List<Song> getSongs() {
        return songDAO.getSongs();
    }

    public Song addSong(String title, String artist, String genre, int playtime, String location) {
        return songDAO.createSong(title, artist, genre, playtime, location);
    }

    public Song updateSong(Song song, String title, String artist, String genre, int playtime, String location) {
        return songDAO.updateSong(song, title, artist, genre, playtime, location);
    }

    public void deleteSong(Song songDelete) {
        songDAO.deleteSong(songDelete);
>>>>>>> Stashed changes
    }

}
