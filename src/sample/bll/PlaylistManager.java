package sample.bll;

import sample.be.Playlist;
import sample.be.Song;
import sample.dal.PlaylistDAO;

import java.io.IOException;
import java.util.List;

public class PlaylistManager {
    private final PlaylistDAO playlistDAO;

    public PlaylistManager() throws IOException {
        playlistDAO = new PlaylistDAO();
    }

    public Playlist createPlaylist(String name) {

        return playlistDAO.createPlaylist(name);
    }


    public List<Playlist> getAllPlaylists() {
        return playlistDAO.getAllPlaylists();
    }
}
