package sample.be;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Song {

    private StringProperty title;
    private StringProperty artist;
    private StringProperty genre;
    private String location;
    private final int playtime;
    private final int ID;

    public Song(String title, String artist, String genre, String location, int playtime, int id) {

        this.title = new SimpleStringProperty();
        this.artist = new SimpleStringProperty();
        this.genre = new SimpleStringProperty();
        this.location = location;
        this.playtime = playtime;
        ID = id;

        setTitle(title);
        setArtist(artist);
        setGenre(genre);
        setLocation(location);
  }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public StringProperty getTitleProperty() {
        return title;
    }

    public StringProperty getArtistProperty() {
        return artist;
    }

    public StringProperty getGenreProperty() {
        return genre;
    }

    public StringProperty getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public String getArtist() {
        return artist.get();
    }

    public void setArtist(String artist) {
        this.artist.set(artist);
    }

    public String getGenre() {
        return genre.get();
    }

    public void setGenre(String genre) {
        this.genre.set(genre);
    }

    public int getPlaytime() {
        return playtime;
    }

    public int getID() {
        return ID;
    }

    public String toString() {
        return this.getTitle() + " " + this.getArtist();
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
