package sample.gui.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

import java.awt.event.ActionEvent;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class SongController implements Initializable {
    private String path;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    //i dont know
    public void moreClicked(MouseEvent mouseEvent) {
    }

    @FXML
    private void chooseFileMethod(ActionEvent actionEvent){
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);
        path = file.toURI().toString();
    }


    //Cancel action
    public void cancelClicked(MouseEvent mouseEvent) {
        
    }

    //safe action
    public void safeClicked(MouseEvent mouseEvent) {
    }

    public void chooseFileMethod(javafx.event.ActionEvent actionEvent) {
    }
}
