package sample.be;

import java.util.List;

public class Playlist {
    private int totalTime;
    private List<Song> playlist;
    private String playlistName;
    private int ID;
    private int songCount;
    private final String totalTimeString;

    public Playlist(int songCount, int totalTime, String name, int ID) {
        this.songCount = songCount;
        this.totalTime = totalTime;
        totalTimeString = getTotalTimeString();
        this.playlistName = playlistName;
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

    public int getSongCount() {
        return songCount;
    }

    public void setSongCount(int songCount) {
        this.songCount = songCount;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public Song getSong(int currentSongIndex) {
        return playlist.get(currentSongIndex);
    }

    public String toString() {
        return " Name=" + playlistName + "Total song count =" + songCount + ", Total play Time=" + totalTime;
    }

    public String getTotalTimeString() {
        String minutesString;
        String secondString;
        int hours = totalTime / 3600;
        int minutes = (totalTime % 3600) / 60;
        if (minutes < 10) {
            minutesString = "0" + minutes;
        } else {
            minutesString = "" + minutes;
        }
        int seconds = totalTime % 60;
        if (10 > seconds) {
            secondString = "0" + seconds;
        } else {
            secondString = "" + seconds;
        }
        return hours + ":" + minutesString + ":" + secondString;
    }
}