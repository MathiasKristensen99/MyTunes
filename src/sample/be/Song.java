package sample.be;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


import java.io.File;
import java.util.concurrent.TimeUnit;

public class Song {

    private String title;
    private String artist;
    private String genre;
    private String location;
    private final int playtime;
    private final int ID;

    public Song(String title, String artist, String genre, String location, int playtime, int id) {

        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.location = location;
        this.playtime = playtime;
        ID = id;
  }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPlaytime() {
        return playtime;
    }

    public int getID() {
        return ID;
    }

    public String toString() {
        return title;
    }

    public String getPlaytimeString() {
        String minutesString;
        String secondString;
        int minutes = playtime / 60;
        if (minutes < 10) {
            minutesString = "0" + minutes;
        } else {
            minutesString = "" + minutes;
        }
        int seconds = playtime % 60;
        if (10 > seconds) {
            secondString = "0" + seconds;
        } else {
            secondString = "" + seconds;
        }
        return minutesString + ":" + secondString;
    }

}
