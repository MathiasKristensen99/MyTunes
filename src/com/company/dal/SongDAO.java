package com.company.dal;

import com.company.be.Song;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SongDAO {

    private DatabaseDAO databaseConnector;

    public SongDAO() throws IOException {
        databaseConnector = new DatabaseDAO();
    }

    public List<Song> getSongs() {
        List<Song> allSongs = new ArrayList<>();
        try (Connection connection = databaseConnector.getConnection()) {
            String sqlStatement = "SELECT * FROM Song";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sqlStatement);
            while (rs.next()) {
                Song song = new Song(rs.getString("title"), rs.getString("artist"), rs.getString("genre"), rs.getString("location"), rs.getInt("playtime"), rs.getInt("id"));
                allSongs.add(song);
            }
            return allSongs;
        } catch (SQLServerException ex) {
            System.out.println(ex);
            return null;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public Song addSong(String title, String artist, String genre, int playtime, String location) {
        String sql = "INSERT INTO Song(title,artist,genre,playtime,url) VALUES (?,?,?,?,?)";
        try (Connection connection = databaseConnector.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, title);
            ps.setString(2, artist);
            ps.setString(3, genre);
            ps.setInt(4, playtime);
            ps.setString(5, location);
            ps.addBatch();
            ps.executeBatch();
        } catch (SQLServerException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        Song song = new Song(title, artist, genre, location, playtime, getNewestSongID());
        return song;
    }

    private int getNewestSongID() {
        int newestID = -1;
        try (Connection connection = databaseConnector.getConnection()) {
            String query = "SELECT TOP(1) * FROM Song ORDER by id desc";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
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

    public Song updateSong(Song song, String title, String artist, String genre, int playtime, String location) {
        try (Connection connection = databaseConnector.getConnection()) {
            String query = "UPDATE Song set name = ?,artist = ?,genre = ?,time = ?,url = ? WHERE id = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, title);
            preparedStmt.setString(2, artist);
            preparedStmt.setString(3, genre);
            preparedStmt.setInt(4, playtime);
            preparedStmt.setString(5, location);
            preparedStmt.setInt(6, song.getID());
            preparedStmt.executeUpdate();
            Song son = new Song(title, artist, genre, location, playtime, song.getID());
            return son;
        } catch (SQLServerException ex) {
            System.out.println(ex);
            return null;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public Song deleteSong(Song songDelete) {
        try (Connection connection = databaseConnector.getConnection()) {
            String query = "DELETE from Song WHERE id = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, songDelete.getID());
            preparedStmt.execute();
        } catch (SQLServerException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return songDelete;
    }

    public static void main(String[] args) throws SQLException, IOException {
        SongDAO songDAO = new SongDAO();

        List<Song> allSongs = songDAO.getSongs();

        System.out.println(allSongs);
    }
}
