package sample.gui.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class SongController implements Initializable {
    private String path;

    @FXML
    private javafx.scene.control.Button cancelButton;

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





    //safe action
    public void safeClicked(MouseEvent mouseEvent) {
    }

    public void chooseFileMethod(javafx.event.ActionEvent actionEvent) {
    }

    @FXML
    private void cancelButtonAction() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void cancelClicked(MouseEvent mouseEvent) {
    }
}
