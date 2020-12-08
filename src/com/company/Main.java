package com.company;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/MyTunes/src/com.company/gui/view/MyTunes.fxml"));
        Scene scene = new Scene(root);
        Parent songRoot = FXMLLoader.load(getClass().getResource("/MyTunes/src/com.company/gui/view/Song.fxml"));
        Scene song = new Scene(songRoot);
        Parent playlistRoot = FXMLLoader.load(getClass().getResource("/MyTunes/src/com.company/gui/view/Playlist.fxml"));
        Scene playlist = new Scene(playlistRoot);
        stage.setScene(scene);
        stage.show();

    }
    public static void main(String[] args) {



    }


}
