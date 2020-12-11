package sample.bll;

import sample.be.Song;
import sample.dal.PlaylistSongDAO;
import sample.dal.SongDAO;

import java.io.IOException;
import java.util.List;


public class SongManager {
    private  SongDAO songDAO;
    private  PlaylistSongDAO playlistSongDAO;

    public SongManager() throws IOException {
        songDAO = new SongDAO();
        playlistSongDAO = new PlaylistSongDAO();
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
    public List<Song> getSongs() {
        List<Song> allSongs = songDAO.getSongs();
        return allSongs;
    }
}
