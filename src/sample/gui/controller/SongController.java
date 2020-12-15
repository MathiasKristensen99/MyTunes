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
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.xml.sax.ContentHandler;
import org.xml.sax.helpers.DefaultHandler;
import sample.be.Song;
import sample.gui.model.SongModel;

import java.awt.event.ActionEvent;
import java.io.*;
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

    public void chooseFileMethod(javafx.event.ActionEvent actionEvent) throws FileNotFoundException {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose file");
        File file = fileChooser.showOpenDialog(stage);
        if (file.toString() != null) {
            String location = file.toString().replaceAll("\\\\", "/");
            try {
                InputStream inputStream = new FileInputStream(new File(location));
                ContentHandler contentHandler = new DefaultHandler();
                Metadata metaData = new Metadata();
                Parser parser = new Mp3Parser();
                ParseContext parserContext = new ParseContext();
                parser.parse(inputStream, contentHandler, metaData, parserContext);
                inputStream.close();
                String[] metadataName = metaData.names();

                titleField.setText(metaData.get("title"));
                artistField.setText(metaData.get("artist"));
                genreField.setText(metaData.get("genre"));
                timeField.setText(String.valueOf((int) Math.round(Double.parseDouble(metaData.get("playtime")))));
            } catch (Exception e) {
                e.printStackTrace();
            }
            urlField.setText(location);
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
