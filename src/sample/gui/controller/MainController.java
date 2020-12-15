package sample.gui.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import jdk.jfr.Category;
import sample.be.Playlist;
import sample.be.Song;
import sample.gui.model.PlaylistModel;
import sample.gui.model.SongModel;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;



public class MainController implements Initializable  {




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
    /*@FXML
    private ListView listViewSongs;*/
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


    File songFile = new File("data/songs/Kom_Kom_-_Rune_Rk__Og_Stanley_Most.mp3");

    public MainController() throws IOException {
        songModel = new SongModel();
    }


    // PLAY CONTROLLER PLAY CONTROLLER PLAY CONTROLLER PLAY CONTROLLER PLAY CONTROLLER PLAY CONTROLLER PLAY CONTROLLER PLAY CONTROLLER PLAY CONTROLLER

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        //MediaPlayer mediaPlayer = new MediaPlayer(new Media(new File("src/Resources/Kom_Kom_-_Rune_Rk__Og_Stanley_Most.mp3").toURI().toString()));
        //mediaPlayer.setOnReady(() -> {
            //allSongs.addAll(songModel.getAllSongs());
        //});

        allSongs = songModel.getAllSongs();
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

    @FXML
    private void songNameDisplay(){


    }

    //Play ore Pause the song
    public void playPressed(MouseEvent mouseEvent) {

    }
    //Play the next song from the Playlist.
    public void nextSong(MouseEvent mouseEvent) {

    }

    //Play the last song again.
    public void lastSong(MouseEvent mouseEvent) {

    }
    //open Song edit scene
    public void newButtonAction(ActionEvent actionEvent) throws IOException {
        Parent root1;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sample/gui/view/Song.fxml"));
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



    //Add new song to the register (



    //Delete choosen song
    public void songDeleteClicked(MouseEvent mouseEvent) {

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

}













