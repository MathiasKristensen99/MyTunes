package com.company.bll;

import com.company.be.Song;
import com.company.dal.SongDAO;

public class SongManager {

    private final SongDAO songDAO;

    public SongManager(SongDAO songDAO) {
        this.songDAO = songDAO;
    }

    public Song addSong(String title, String artist, String genre, int playtime, String location) {
        return songDAO.addSong(title, artist, genre, playtime, location);
    }

    public Song updateSong(Song song, String title,String artist, String genre, int playtime, String location) {
        return songDAO.updateSong(song, title, artist, genre, playtime, location);
    }

    public Song deleteSong(Song songDelete) {
        return songDAO.deleteSong(songDelete);
    }

}
