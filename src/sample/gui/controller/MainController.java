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


    public Slider volumeSlider;
    public Button btnStop;
    public TextField searchTextField;
    public Button btnSearch;
    public Label lblCurrentSong;
    public Button btnPlay;

    private ObservableList<Playlist> allPlaylists = FXCollections.observableArrayList();
    private ObservableList<Song> allSongs = FXCollections.observableArrayList();

    private final SongModel songModel;
    private final PlaylistModel playlistModel = new PlaylistModel();


    @FXML
    private javafx.scene.control.Button closeButton;
    @FXML
    private TableView<Song> tableAllsongs;
    @FXML
    private TableView<Playlist> tableAllPlaylists;
    @FXML
    private ListView listViewSongs;
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
    @FXML
    private TableColumn<Song, Integer> playlistSongs;
    @FXML
    private TableColumn<Song, Integer> playlistTime;

    private MediaPlayer mediaPlayer;
    private int currentSongPlaying = 0;



    public MainController() throws IOException {
        songModel = new SongModel();
    }


    public void initialize(URL url, ResourceBundle resourceBundle) {

        allSongs = songModel.getAllSongs();
        //songTitle.cellValueFactoryProperty().setValue(cellData -> cellData.getValue().getTitleProperty());
        songTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        songArtist.setCellValueFactory(new PropertyValueFactory<>("artist"));
        songCategory.setCellValueFactory(new PropertyValueFactory<>("genre"));
        songTime.setCellValueFactory(new PropertyValueFactory<>("playTime"));
        tableAllsongs.setItems(allSongs);

        //allPlaylists = playlistModel.getAllPlaylists();
        playlistName.setCellValueFactory(new PropertyValueFactory<>("name"));
        playlistTime.setCellValueFactory(new PropertyValueFactory<>("totalTime"));
        playlistSongs.setCellValueFactory(new PropertyValueFactory<>("allSongs"));
        tableAllPlaylists.setItems(allPlaylists);



    }

    public void refreshPlaylist(){
        tableAllPlaylists.getItems().clear();
        tableAllPlaylists.setItems(playlistModel.getAllPlaylists());
    }


    //open new song scene
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

    //SEARCH BOX SEARCH BOX SEARCH BOX SEARCH BOX SEARCH BOX SEARCH BOX SEARCH BOX SEARCH BOX SEARCH BOX SEARCH BOX SEARCH BOX SEARCH BOX SEARCH BOX

    //filter the songs with the text in the search box
    public void magnifyingGlassClicked(MouseEvent mouseEvent) {

    }


    //SONG REGISTER SONG REGISTER SONG REGISTER SONG REGISTER SONG REGISTER SONG REGISTER SONG REGISTER SONG REGISTER SONG REGISTER SONG REGISTER SONG REGISTER

    //Close the application
    @FXML
    private void closeButtonAction() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    //Edit choosen song
    public void songEditClicked(MouseEvent mouseEvent) {

    }

    //Add the choosen song to the choosen playlist
    public void arrowLeftClicked(MouseEvent mouseEvent) {

    }


    //SONGS IN PLAYLIST SONGS IN PLAYLIST SONGS IN PLAYLIST SONGS IN PLAYLIST SONGS IN PLAYLIST SONGS IN PLAYLIST SONGS IN PLAYLIST SONGS IN PLAYLIST

    //Remove song from playlist
    public void songPlaylistDeleteClicked(MouseEvent mouseEvent) {
    }

    //GO up in playlist register
    public void arrowUpClicked(MouseEvent mouseEvent) {

    }


    //Go down in playlist register
    public void arrowDownClicked(MouseEvent mouseEvent) {

    }

    //PLAYLIST MENU PLAYLIST MENU PLAYLIST MENU PLAYLIST MENU PLAYLIST MENU PLAYLIST MENU PLAYLIST MENU PLAYLIST MENU PLAYLIST MENU PLAYLIST MENU PLAYLIST MENU



    //Edit the choosen playlist
    public void editPlaylistClicked(MouseEvent mouseEvent) {

    }

    //Delete the choosen playlist
    public void deletePlaylistClicked(MouseEvent mouseEvent) {

    }

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

    public void playSong(ActionEvent actionEvent) {
        if (mediaPlayer == null && tableAllsongs.getSelectionModel().getSelectedIndex() != -1) {
            currentSongPlaying = tableAllsongs.getSelectionModel().getSelectedIndex();
            play();
        }
    }

    public void stopSong(ActionEvent actionEvent) {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            lblCurrentSong.setText("No song is playing");
            mediaPlayer = null;
        }
    }

    private void play() {
        mediaPlayer = new MediaPlayer(new Media(new File(tableAllsongs.getItems().get(currentSongPlaying).getLocation()).toURI().toString()));
        tableAllsongs.getSelectionModel().clearAndSelect(currentSongPlaying);
        mediaPlayer.play();
        mediaPlayer.setVolume(50);
        lblCurrentSong.setText(tableAllsongs.getItems().get(currentSongPlaying).getTitle().toString());
    }

    public void refreshSongs(ActionEvent actionEvent) {
        tableAllsongs.getItems().clear();
        tableAllsongs.setItems(songModel.getAllSongs());
    }

    public void deleteSong(ActionEvent actionEvent) {
        if (tableAllsongs.getSelectionModel().getSelectedIndex() != -1) {
            songModel.deleteSong(tableAllsongs.getSelectionModel().getSelectedItem());
        }
    }

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
}













