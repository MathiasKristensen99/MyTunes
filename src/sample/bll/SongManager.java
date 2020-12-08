package sample.bll;

import sample.be.Song;
import sample.dal.SongDAO;
import java.util.List;


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
    public List<Song> getSongs() {
        return songDAO.getSongs();
    }
}
