package sample.dal;

import sample.be.Playlist;
import sample.be.Song;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlaylistDAO {

    private DatabaseDAO databaseConnector;

    public PlaylistDAO() throws IOException {
        databaseConnector = new DatabaseDAO(); //Database object used to creating the connection
    }

    /**
     * Methods to getting and creating the playlists in the database.
     * In the current state, these doesn't do anything.
     * @return
     */

    //Getting the playlists using the SELECT FROM SQL command. Storing the playlists ind a list. And defining the labels where we collect the data.
    public List<Playlist> getAllPlaylists() {
        List<Playlist> allPlaylists = new ArrayList<>();

        try (Connection connection = databaseConnector.getConnection()) {
            String sqlStatement = "SELECT * FROM Playlist";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sqlStatement);
            while (rs.next()) {
                String name = rs.getString("PlaylistName");
                int id = rs.getInt("id");
                Playlist pl = new Playlist(id, name);
                allPlaylists.add(pl);
            }
            return allPlaylists;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    //Creating a playlist using the INSERT INTO SQL command.
    public Playlist createPlaylist(String name) {
        String sql = "INSERT INTO Playlist(name) VALUES (?)";
        try (Connection connection = databaseConnector.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.addBatch();
            ps.executeBatch();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        Playlist playlist = new Playlist(0, name);
        return playlist;
    }

    //Test to print the existing playlists
    public static void main(String[] args) throws SQLException, IOException {
        PlaylistDAO playlistDAO = new PlaylistDAO();

        List<Playlist> allPlaylist = playlistDAO.getAllPlaylists();

        System.out.println(allPlaylist);
    }
}