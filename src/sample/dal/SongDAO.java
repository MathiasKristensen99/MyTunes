package sample.dal;

import sample.be.Song;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SongDAO {

    private DatabaseDAO databaseConnector;

    public SongDAO() throws IOException {
        databaseConnector = new DatabaseDAO(); //New Database object, used to creating the connection.
    }

    /**
     * Methods used for getting, adding, getID, updating and deleting songs from the database.
     * Each method uses the database object to creating the connection to the database.
     * Try & Catch blocks are used to "trying" to adding, updating etc. the songs.
     * @return
     */

    /**
     * Method for getting the songs in the database
     * We define the labels we want to retrieve from the database
     * The ResultSet function is used to read the tables, where we define if we want a string or int
     * @return
     */
    public List<Song> getSongs() {
        ArrayList<Song> allSongs = new ArrayList<>();

        try (Connection connection = databaseConnector.getConnection()) {
            String sqlStatement = "SELECT * FROM Song";
            Statement statement = connection.createStatement();
            if (statement.execute(sqlStatement)) {
                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next()) {
                    String title = resultSet.getString("title");
                    String artist = resultSet.getString("artist");
                    String genre = resultSet.getString("genre");
                    String location = resultSet.getString("location");
                    int playtime = resultSet.getInt("playtime");
                    int ID = resultSet.getInt("ID");

                    Song song = new Song(title,artist,genre,location, playtime, ID); // Creating a song object from the retrieved values
                    allSongs.add(song); // Adding the song to an ArrayList
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
        return allSongs;
    }

    /**
     * Method for adding a new song to the database
     * PreparedStatement is used to execute the SQL commands, where we use the INSERT INTO statement
     * @param title
     * @param artist
     * @param genre
     * @param playtime
     * @param location
     * @return
     */
    public Song addSong(String title, String artist, String genre, int playtime, String location) {
        String sql = "INSERT INTO Song(title,artist,genre,playtime,location) VALUES (?,?,?,?,?)";
        try (Connection connection = databaseConnector.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, title); // The five parameters are values we want to insert into the database
            ps.setString(2, artist);
            ps.setString(3, genre);
            ps.setInt(4, playtime);
            ps.setString(5, location);
            ps.addBatch(); // Adding to the preparedstatement
            ps.executeBatch(); // Executing the added parameters, and therefore executing the statement
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        Song song = new Song(title, artist, genre, location, playtime, getNewestSongID()); // Creating a new song object
        return song;
    }

    /**
     * Method used for retrieving the newest song id in the list, in the current state, this method doesn't do much
     * @return
     */
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
        } catch (SQLException ex) {
            System.out.println(ex);
            return newestID;
        }
    }

    /**
     * Updating an existing song in the database, in the current state this is not used.
     * Using the SQL command UPDATE
     * @param song
     * @param title
     * @param artist
     * @param genre
     * @param playtime
     * @param location
     * @return
     */
    public Song updateSong(Song song, String title, String artist, String genre, int playtime, String location) {
        try (Connection connection = databaseConnector.getConnection()) {
            String query = "UPDATE Song set name = ?,artist = ?,genre = ?,time = ?,location = ? WHERE id = ?";
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
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    /**
     * Method used to deleting a song from the database using the DELETE from SQL command, and executing it with a prepared statement
     * It deletes a song by the title.
     * @param songDelete
     * @return
     */
    public Song deleteSong(Song songDelete) {
        try (Connection connection = databaseConnector.getConnection()) {
            String query = "DELETE from Song WHERE title = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, songDelete.getTitle());
            preparedStmt.execute(); // Executing the statement
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return songDelete;
    }

    /**
     * Method used to print the existing songs in the database by using the getSongs method
     * Used for testing
     * @param args
     */

    public static void main(String[] args) throws SQLException, IOException {
        SongDAO songDAO = new SongDAO();

        List<Song> allSongs = songDAO.getSongs();

        System.out.println(allSongs);
    }
}
