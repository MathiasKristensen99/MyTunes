package sample.bll;

import sample.be.Playlist;
import sample.be.Song;
import sample.dal.PlaylistDAO;
import sample.dal.PlaylistSongDAO;

import java.io.IOException;
import java.util.List;

public class PlaylistManager {
    private final PlaylistDAO playlistDAO;
    private final PlaylistSongDAO playlistSongDAO;

    public PlaylistManager() throws IOException {
        playlistDAO = new PlaylistDAO();
        playlistSongDAO = new PlaylistSongDAO();
    }

    public Playlist createPlaylist(String name) {
        return playlistDAO.createPlaylist(name);
    }

    public Song addToPlaylist(Playlist playlist, Song song) {
        return playlistSongDAO.addToPlaylist(playlist, song);
    }

    public List<Playlist> getAllPlaylists() {
        return playlistDAO.getAllPlaylists();
    }

    public void deletePlaylist(Playlist play) {
        playlistSongDAO.deleteFromPlaylistSongsEverything(play);
        playlistDAO.deletePlaylist(play);
    }

    public void editPlaylist(Playlist get, String text) {
        playlistDAO.updatePlaylist(get, text);
    }

    public void removeSongFromPlaylist(Playlist selectedItem, Song selectedSong) {
        playlistSongDAO.removeSongFromPlaylist(selectedItem, selectedSong);
    }
}
