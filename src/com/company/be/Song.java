package com.company.be;

import java.io.File;

public class Song {
    private File song;
    private String title;
    private String artist;
    private String category;
    private final int playtime;
    private final int ID;

    public Song(String songPath, String title, String artist, String category, int playtime, int id) {
        song = new File (Song.class.getResource(songPath).getFile());
        this.title = title;
        this.artist = artist;
        this.category = category;
        this.playtime = playtime;
        ID = id;
    }

    public File getSong() {
        return song;
    }

    public void setSong(File song) {
        this.song = song;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPlaytime() {
        return playtime;
    }

    public int getID() {
        return ID;
    }

    public File getFile() {
        return song;
    }

    //TODO To string metoder
}
