package sample.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class PlaylistController {
    @FXML
    private javafx.scene.control.Button cancelButton;
    //cancel action


    //safe action
    public void safeClicked(MouseEvent mouseEvent) {
    }

    //cancel action
    @FXML
    private void cancelButtonAction() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}
