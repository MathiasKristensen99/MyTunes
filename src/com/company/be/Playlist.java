package com.company.be;

import java.util.List;

public class Playlist {
    private List<Song> playlist;
    private String playlistName;
    private int ID;
    private int songCount;
    private int totalPlaytime;
    private final String totalPlaytimeString;

    public Playlist(List<Song> playlist, String playlistName, int id, int songCount, int totalPlaytime, String totalPlaytimeString) {
        this.playlist = playlist;
        this.playlistName = playlistName;
        ID = id;
        this.songCount = songCount;
        this.totalPlaytime = totalPlaytime;
        this.totalPlaytimeString = totalPlaytimeString;
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

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getSongCount() {
        return songCount;
    }

    public void setSongCount(int songCount) {
        this.songCount = songCount;
    }

    public int getTotalPlaytime() {
        return totalPlaytime;
    }

    public void setTotalPlaytime(int totalPlaytime) {
        this.totalPlaytime = totalPlaytime;
    }

    public String getTotalPlaytimeString() {
        return totalPlaytimeString;
    }

    public Song getSong(int currentSongIndex) {
        return playlist.get(currentSongIndex);
    }
    //TODO To string metoder
}