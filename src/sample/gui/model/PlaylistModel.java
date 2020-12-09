package sample.gui.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.be.Playlist;
import sample.be.Song;
import sample.bll.PlaylistManager;

import java.io.IOException;

public class PlaylistModel {

    private ObservableList<Playlist> allPlaylists;

    private final PlaylistManager playlistManager;

    public PlaylistModel() throws IOException {
        playlistManager = new PlaylistManager();
    }

    public ObservableList<Playlist> getAllPlaylists() {
        allPlaylists = FXCollections.observableArrayList();
        allPlaylists.addAll(playlistManager.getAllPlaylists());
        return allPlaylists;
    }

    public void createPlaylist (String name) {
        playlistManager.createPlaylist(name);
    }

    public void deletePlaylist (Playlist playlist) {
        playlistManager.deletePlaylist(playlist);
    }

    public void editPlaylist(Playlist playlist, String name) {
        playlistManager.editPlaylist(playlist, name);
    }

    public Song addToPlaylist (Playlist playlist, Song song) {
        return playlistManager.addToPlaylist(playlist, song);
    }

    public void removeSongFromPlaylist (Playlist selectedItem, Song selectedSong) {
        playlistManager.removeSongFromPlaylist(selectedItem, selectedSong);
    }
}
