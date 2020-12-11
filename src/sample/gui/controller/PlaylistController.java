package sample.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.be.Playlist;
import sample.gui.model.PlaylistModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOError;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;





public class PlaylistController implements Initializable {

    @FXML
    private Label alertLabel;
    private PlaylistModel playlistModel;
    @FXML
    private TextField nameField;

    @FXML
    private javafx.scene.control.Button cancelButton;
    @FXML
    private javafx.scene.control.Button safeButton;
    private boolean isEditing = false;
    private Playlist editingList;


    MainController refresh;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            playlistModel = new PlaylistModel();
        }catch (IOException ex){
            alertLabel.setText("Alert: No connection to database.");
        }
    }

    /*public PlaylistController() throws IOException {
    }*/

    //cancel action
    @FXML
    private void cancelButtonAction() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }




    //safe action
    @FXML
    private void safeButtonAction(ActionEvent event) {
        String name = nameField.getText().trim();
        if( name.length() > 0 && name.length() < 50) {
            if(!isEditing){
                playlistModel.createPlaylist(name);
                alertLabel.setText("Playlist created.");
            }else{
                playlistModel.editPlaylist(editingList, name);
                alertLabel.setText("Playlist renamed.");
            }
        }else{
            alertLabel.setText("Playlist name is valid.");
        }
        refresh.refreshPlaylist();




        /*Stage stage = (Stage) safeButton.getScene().getWindow();
        stage.close();*/

    }

    void setInfo(Playlist selectedItem){
        isEditing = true;
        editingList = selectedItem;
        nameField.setText(selectedItem.getPlaylistName());
    }


}
