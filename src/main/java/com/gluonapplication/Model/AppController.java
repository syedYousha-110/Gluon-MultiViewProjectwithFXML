package com.gluonapplication.Model;

import javafx.application.Application;


import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;

import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;


public class AppController extends Application {

    public Stage stage;

    public SceneChanger sceneChanger;
    @Override
    public void start(Stage stage) {
        setStage(stage);
        Scene scene = new Scene(new Group());
        try {
            sceneChanger = new SceneChanger(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setScene(scene);
        stage.show();
    }
    private void setStage(Stage primaryStage){
        stage = primaryStage;
        primaryStage.centerOnScreen();
        Rectangle2D primaryScreen = Screen.getPrimary().getVisualBounds();

        stage.setTitle("Final Year Project");
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(true);
        stage.setMinHeight(900);
        stage.setMinWidth(1000);
        stage.setHeight(Screen.getPrimary().getVisualBounds().getHeight()-100);
        stage.setWidth(Screen.getPrimary().getVisualBounds().getWidth()-100);
        stage.setX((primaryScreen.getWidth()-stage.getWidth())-50);
        stage.setY((primaryScreen.getHeight()-stage.getHeight())-50);
    }


    public static void main(String[] args) {
        launch(args);
    }

}