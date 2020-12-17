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

    public void setSongList(List<Song> songList) {
        this.playlist = songList;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    

    public Song getSong(int currentSongIndex) {
        return playlist.get(currentSongIndex);
    }


}