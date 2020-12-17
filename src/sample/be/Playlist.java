package sample.be;

import java.util.List;

public class Playlist {

    private List<Song> playlist;
    private String playlistName;
    private int ID;


    public Playlist(int id, String name) {
        this.playlistName = name;
        this.ID = ID;
    }

    /**
     * Get and set methods for the different variables we have declared.
     * @return
     */
    public List<Song> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(List<Song> playlist) {
        this.playlist = playlist;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

}