package sample.gui.controller;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import sample.be.Song;
import sample.gui.model.SongModel;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.StrictMath.toIntExact;

public class SongController implements Initializable {

    public TextField titleField;
    public TextField artistField;
    public TextField timeField;
    public TextField urlField;
    public TextField genreField;
    public Button saveButton;
    public TextField idField;
    @FXML
    private javafx.scene.control.Button cancelButton;
    @FXML
    private AnchorPane root;

    private final SongModel songModel = new SongModel();
    private final MainController mainController = new MainController();
    private String path;
    private MediaPlayer mediaPlayer;
    private boolean isEditing = false;
    private Song songToEdit;



    public SongController() throws IOException {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    //i dont know
    public void moreClicked(MouseEvent mouseEvent) {
    }

    @FXML
    private void chooseFileMethod(ActionEvent actionEvent){

    }

    public void chooseFileMethod(javafx.event.ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select a file");
        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("Sound files (*.wav , *.mp3)", "*.wav", "*.mp3");
        fileChooser.getExtensionFilters().add(extensionFilter);
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            urlField.setText(selectedFile.getAbsolutePath());
            mediaPlayer = new MediaPlayer(new Media(selectedFile.getAbsolutePath()));
        }
    }


    @FXML
    private void cancelButtonAction() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void cancelClicked(MouseEvent mouseEvent) {
    }

    public void saveSong(javafx.event.ActionEvent actionEvent) {
        String title = titleField.getText();
        String artist = artistField.getText();
        String genre = genreField.getText();
        int playtime = Integer.parseInt(timeField.getText());
        String location = urlField.getText();
        int id = Integer.parseInt(idField.getText());

        Song newSong = new Song(title, artist, genre, location, playtime, id);
        newSong.setLocation(location);

        this.songModel.addSong(title, artist, genre, playtime, location, id);
    }
}
