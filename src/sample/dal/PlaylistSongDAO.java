package sample.dal;

import sample.be.Playlist;
import sample.be.Song;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlaylistSongDAO {

    private DatabaseDAO databaseConnector;

    public PlaylistSongDAO() throws IOException {
        databaseConnector = new DatabaseDAO();
    }

    public List<Song> getPlaylistSongs(int id) {
        List<Song> newSongList = new ArrayList();
        try (Connection con = databaseConnector.getConnection()) {
            String query = "SELECT * FROM PlaylistSong INNER JOIN Song ON PlaylistSong.SongID = Song.id WHERE PlaylistSong.PlaylistID = ? ORDER by locationInListID desc"; // Gets all songs from a coresponding playlist.
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, id);
            ResultSet rs = preparedStmt.executeQuery();
            while (rs.next()) {
                Song son = new Song(rs.getString("name"), rs.getString("artist"), rs.getString("genre"), rs.getString("time"), rs.getInt("url"), rs.getInt("id")); // Sets up a song object
                newSongList.add(son); //adds song to a song array
            }
            return newSongList;
        } catch (SQLServerException ex) {
            System.out.println(ex);
            return null;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public Song addToPlaylist(Playlist playlist, Song song) {
        String sql = "INSERT INTO PlaylistSong(PlaylistID,SongID) VALUES (?,?,?)";
        int Id = -1;
        try (Connection con = databaseConnector.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);;
            ps.setInt(1, playlist.getID());
            ps.setInt(2, song.getID());
            ps.setInt(3, Id);
            ps.addBatch();
            ps.executeBatch();
            return song; //Returns song object
        } catch (SQLServerException ex) {
            System.out.println(ex);
            return null;

        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    /*
    Deletes playlist from the Playlist song table in database. (It allows playlist to be deleted from playlist table)

    /*
    Removes a specific song from playlist.
     */
    public void removeSongFromPlaylist(Playlist selectedItem, Song selectedSong) {
        try (Connection con = databaseConnector.getConnection()) {
            String query = "DELETE from PlaylistSong WHERE PlaylistID = ? AND SongID = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, selectedItem.getID());
            preparedStmt.setInt(2, selectedSong.getID());
            preparedStmt.execute();
        } catch (SQLServerException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
