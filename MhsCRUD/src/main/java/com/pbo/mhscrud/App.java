package com.pbo.mhscrud;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("fmhs.fxml"));
        Scene sc = new Scene(parent,900,600);
        stage.setScene(sc);
        stage.setTitle("CRUD MHS");
        stage.show();
    }
    public static void main(String[] args){
        launch();
    }
}


