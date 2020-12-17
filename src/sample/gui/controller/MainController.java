package sample.gui.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.be.Playlist;
import sample.be.Song;
import sample.gui.model.PlaylistModel;
import sample.gui.model.SongModel;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class MainController implements Initializable  {


    // All the JavaFX functions used in the fxml files
    public Slider volumeSlider;
    public Button btnStop;
    public TextField searchTextField;
    public Button btnSearch;
    public Label lblCurrentSong;
    public Button btnPlay;
    public Button btnForward;
    public Button btnBack;

    @FXML
    private javafx.scene.control.Button closeButton;
    @FXML
    private TableView<Song> tableAllsongs;
    @FXML
    private TableView<Playlist> tableAllPlaylists;
    @FXML
    private TableColumn<Song, String> songTitle;
    @FXML
    private TableColumn<Song, String> songArtist;
    @FXML
    private TableColumn<Song, String> songCategory;
    @FXML
    private TableColumn<Song, Integer> songTime;
    @FXML
    private TableColumn<Song, String> playlistName;

    private MediaPlayer mediaPlayer;
    private int currentSongPlaying = 0;
    private final SongModel songModel;
    private final PlaylistModel playlistModel = new PlaylistModel();

    // Observablelists for the songs and playlists
    private ObservableList<Playlist> allPlaylists = FXCollections.observableArrayList();
    private ObservableList<Song> allSongs = FXCollections.observableArrayList();


    public MainController() throws IOException {
        songModel = new SongModel(); // Creating a songModel object, where most of the methods are
    }


    public void initialize(URL url, ResourceBundle resourceBundle) {

        // Initializing the table, and filling the columns
        allSongs = songModel.getAllSongs();
        songTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        songArtist.setCellValueFactory(new PropertyValueFactory<>("artist"));
        songCategory.setCellValueFactory(new PropertyValueFactory<>("genre"));
        songTime.setCellValueFactory(new PropertyValueFactory<>("playtime"));
        tableAllsongs.setItems(allSongs);

        playlistName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableAllPlaylists.setItems(allPlaylists);

    }

    public void refreshPlaylist(){
        tableAllPlaylists.getItems().clear();
        tableAllPlaylists.setItems(playlistModel.getAllPlaylists());
    }

    // Button for opening the scene where we create a new song
    public void newButtonAction(ActionEvent actionEvent) throws IOException {
        Parent root1;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sample/gui/view/NewSong.fxml"));
        root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.setTitle("Song");
        stage.centerOnScreen();
        stage.show();
    }

    // Closing the application
    @FXML
    private void closeButtonAction() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    // Button for opening a scene to create a new playlist
    public void playlistNewButtonAction(ActionEvent actionEvent)throws IOException {
        Parent root2;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sample/gui/view/Playlist.fxml"));
        root2 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root2));
        stage.setTitle("Playlist");
        stage.centerOnScreen();
        stage.show();
    }

    // Button for playing a song
    public void playSong(ActionEvent actionEvent) {
        if (mediaPlayer == null && tableAllsongs.getSelectionModel().getSelectedIndex() != -1) {
            currentSongPlaying = tableAllsongs.getSelectionModel().getSelectedIndex();
            play();
        }
    }

    // Button for stopping a song if the mediaplayer object is playing a song, and setting the mediaplayer object to null
    public void stopSong(ActionEvent actionEvent) {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            lblCurrentSong.setText("No song is playing"); // Label used to display that no song is currently playing
            mediaPlayer = null;
        }
    }

    /**
     * Creating a new Mediaplayer object, and filling it by assigning a file from the song table
     * Setting the volume to 50
     */
    private void play() {
        mediaPlayer = new MediaPlayer(new Media(new File(tableAllsongs.getItems().get(currentSongPlaying).getLocation()).toURI().toString()));
        tableAllsongs.getSelectionModel().clearAndSelect(currentSongPlaying);
        mediaPlayer.play();
        mediaPlayer.setVolume(50);
        lblCurrentSong.setText(tableAllsongs.getItems().get(currentSongPlaying).getTitle().toString()); // A label so we can see which song is currently being played
    }

    // Refreshing the song table
    public void refreshSongs(ActionEvent actionEvent) {
        tableAllsongs.getItems().clear();
        tableAllsongs.setItems(songModel.getAllSongs());
    }

    // Deleting a song by calling the method from the songModel class
    public void deleteSong(ActionEvent actionEvent) {
        if (tableAllsongs.getSelectionModel().getSelectedIndex() != -1) {
            songModel.deleteSong(tableAllsongs.getSelectionModel().getSelectedItem());
        }
    }

    // If there is a song title in the search field, pressing the button will search for a song containing the given title
    public void searchSong(ActionEvent actionEvent) {
        if (searchTextField.getText() == null || searchTextField.getText().length() <= 0) {
            tableAllsongs.setItems(songModel.getAllSongs());
        }
        else {
            ObservableList<Song> songSearcher = songModel.searchSongs(songModel.getAllSongs(), searchTextField.getText());
            if (songSearcher != null) {
                tableAllsongs.setItems(songSearcher);
            }
        }
    }

    // If pressed while playing a song, the current song will stop and skip forward to the next song
    public void skipForward(ActionEvent actionEvent) {
        if (tableAllsongs.getSelectionModel().getSelectedIndex() != -1) {
            mediaPlayer.stop();
            if (currentSongPlaying + 1 == tableAllsongs.getItems().size()) {
                currentSongPlaying = 0;
            }
            else {
                currentSongPlaying++;
            }
            play();
        }
    }

    // If pressed while playing a song, the current song will stop, and play the previous song in the table
    public void skipBack(ActionEvent actionEvent) {
        if (tableAllsongs.getSelectionModel().getSelectedIndex() != -1) {
            mediaPlayer.stop();
            if (currentSongPlaying - 1 == -1) {
                currentSongPlaying = 0;
            }
            else {
                currentSongPlaying--;
            }
            play();
        }
    }

    /**
     * Buttons which are not used in the current state of the program
     * @param mouseEvent
     */

    public void editPlaylistClicked(MouseEvent mouseEvent) {
    }

    public void deletePlaylistClicked(MouseEvent mouseEvent) {
    }

    public void songPlaylistDeleteClicked(MouseEvent mouseEvent) {
    }

    public void songEditClicked(MouseEvent mouseEvent) {
    }

    public void arrowLeftClicked(MouseEvent mouseEvent) {
    }

    public void arrowUpClicked(MouseEvent mouseEvent) {
    }

    public void arrowDownClicked(MouseEvent mouseEvent) {
    }
}













