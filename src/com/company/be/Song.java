package com.company.be;

import java.io.File;

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


    //TODO Tostring metoder
}
