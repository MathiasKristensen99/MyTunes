package sample.gui.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import jdk.jfr.Category;
import sample.gui.model.SongModel;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;



public class MainController implements Initializable {

    @FXML private javafx.scene.control.Button closeButton;


    File songFile = new File("data\\songs\\Kom_Kom_-_Rune_Rk__Og_Stanley_Most.mp3");



    // PLAY CONTROLLER PLAY CONTROLLER PLAY CONTROLLER PLAY CONTROLLER PLAY CONTROLLER PLAY CONTROLLER PLAY CONTROLLER PLAY CONTROLLER PLAY CONTROLLER

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

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
    public void songNewClicked(MouseEvent mouseEvent) {
    }


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

    //Makes a new playlist
    public void newPlaylistClicked(MouseEvent mouseEvent) {

    }

    //Edit the choosen playlist
    public void editPlaylistClicked(MouseEvent mouseEvent) {

    }

    //Delete the choosen playlist
    public void deletePlaylistClicked(MouseEvent mouseEvent) {

    }


}