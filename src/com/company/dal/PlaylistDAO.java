package com.company.dal;

import com.company.be.Playlist;
import com.company.be.Song;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlaylistDAO<DatabaseConnectionDAO> {

    PlaylistSongsDAO PlaylistSongInfo = new PlaylistSongsDAO();
    SQLServerDataSource ds;

    public PlaylistDAO() throws IOException {
    }
    this.ds = new SQLServerDataSource();
    DatabaseConnectionDAO connectionInfo = new DatabaseConnectionDAO();
    List<String> infoList = connectionInfo.getDatabaseInfo();
        ds.setDatabaseName(infoList.get(0));
        ds.setUser(infoList.get(1));
        ds.setPassword(infoList.get(2));
        ds.setPortNumber(Integer.parseInt(infoList.get(3)));
        ds.setServerName(infoList.get(4));
}
    public List<Playlist> getAllPlaylists() {
        List<Playlist> allPlaylists = new ArrayList<>();

        try (Connection con = ds.getConnection()) {
            String sqlStatement = "SELECT * FROM Playlist";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sqlStatement);
            while (rs.next()) {
                String name = rs.getString("name");
                int id = rs.getInt("id");
                List<Song> allSongs = PlaylistSongInfo.getPlaylistSongs(id);
                Playlist pl = new Playlist(allSongs.size(), countTotalTime(allSongs), name, id);
                pl.setSongList(allSongs);
                allPlaylists.add(pl);

            }
            return allPlaylists; // Returns the playlists
        } catch (SQLServerException ex) {
            System.out.println(ex);
            return null;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    private int countTotalTime(List<Song> allSongs) {
        int totalTime = 0;
        for (Song allSong : allSongs) {
            totalTime += allSong.getPlaytime();
        }
        return totalTime;
    }
    public Playlist createPlaylist(String name) {
        String sql = "INSERT INTO Playlist(name) VALUES (?)";
        try (Connection con = ds.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.addBatch();
            ps.executeBatch();
        } catch (SQLServerException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        Playlist playlist = new Playlist(0, 0, name, getNewestPlaylist()); //Creates a playlist object and specifies that there are no songs present.
        return playlist;
    }
    private int getNewestPlaylist() {
        int newestID = -1;
        try (Connection con = ds.getConnection()) {
            String query = "SELECT TOP(1) * FROM Playlist ORDER by id desc";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            ResultSet rs = preparedStmt.executeQuery();
            while (rs.next()) {
                newestID = rs.getInt("id");
            }
            return newestID;
        } catch (SQLServerException ex) {
            System.out.println(ex);
            return newestID;
        } catch (SQLException ex) {
            System.out.println(ex);
            return newestID;
        }
    }
    public void updatePlaylist(Playlist selectedItem, String name) {
        try (Connection con = ds.getConnection()) {
            String query = "UPDATE Playlist set name = ? WHERE id = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, name);
            preparedStmt.setInt(2, selectedItem.getID());
            preparedStmt.executeUpdate();
        } catch (SQLServerException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    public void deletePlaylist(Playlist play) {
        try (Connection con = ds.getConnection()) {
            String query = "DELETE from Playlist WHERE id = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, play.getID());
            preparedStmt.execute();
        } catch (SQLServerException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}