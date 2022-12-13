package com.gluonapplication.views;

import com.gluonapplication.Model.Enum.View;
import com.gluonapplication.Model.SceneChanger;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;


import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    public AnchorPane parent;
    @FXML
    private ImageView profile;

    @FXML
    private Label label_commerce;
    @FXML
    private Button dashBoard;

    @FXML
    private Button Scrapping;

    public Button getGETRequest() {
        return GETRequest;
    }

    public void setGETRequest(Button GETRequest) {
        this.GETRequest = GETRequest;
    }

    @FXML
    private Button GETRequest;

    @FXML
    private Button DBMS;

    @FXML
    private Button item;

    @FXML
    private Button settings;


    public MenuController(){
        Color color = Color.LIGHTGRAY;
        setGETRequest(new Button("GETRequest"));
        var btn = getGETRequest();
        ImageView imageView =new ImageView("E:\\JavaFXApplication\\Gluon-MultiViewProjectwithFXML\\src\\main\\resources\\com\\gluonapplication\\Views\\icons\\PikPng.com_scrape-png_4132362.png");
        imageView.setPreserveRatio(true);
        btn.setGraphic(imageView);
        btn.graphicProperty().addListener((observable, oldValue, newValue) -> {
//            newValue.setLayoutX(Double.parseDouble(BorderLayout.CENTER));
//            newValue.setLayoutY(Double.parseDouble(BorderLayout.CENTER));
        });
        imageView.fitWidthProperty().bind(btn.widthProperty().subtract(10));
        imageView.fitHeightProperty().bind(btn.heightProperty().subtract(2));
        btn.backgroundProperty().set(Background.fill(color));
        buttonTextAndBackgroundPropertyFill(GETRequest);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        parent.backgroundProperty().set(Background.fill(Color.DIMGREY));
        Color color = Color.LIGHTGRAY;
        parent.setPrefHeight(1000);
        parent.setMinHeight(1000);
        setButtonsColor(color);
        settings.setDisable(true);
        DBMS.setDisable(true);
        item.setDisable(true);
        label_commerce.textFillProperty().setValue(Color.WHITE);
        label_commerce.setBackground(Background.fill(Color.GRAY));
        label_commerce.setText("www.Daraz.pk");

        GETRequest.hoverProperty().addListener(event -> SceneChanger.switchTo(View.API));
        Scrapping.hoverProperty().addListener(event -> SceneChanger.switchTo(View.SCRAPPING));
        dashBoard.hoverProperty().addListener(event -> SceneChanger.switchTo(View.NEW_DASHBOARD));
        profile.hoverProperty().addListener(event-> SceneChanger.switchTo(View.DASHBOARD));

        buttonTextAndBackgroundPropertyFill(GETRequest);
        buttonTextAndBackgroundPropertyFill(Scrapping);
        buttonTextAndBackgroundPropertyFill(dashBoard);
        buttonTextAndBackgroundPropertyFill(settings);
        buttonTextAndBackgroundPropertyFill(DBMS);


    }

    private void setButtonsColor(Color color){
        GETRequest.setBackground(Background.fill(color));
        settings.setBackground(Background.fill(color));
        Scrapping.setBackground(Background.fill(color));
        DBMS.setBackground(Background.fill(color));
        item.setBackground(Background.fill(color));
        dashBoard.setBackground(Background.fill(color));
    }
    private void buttonTextAndBackgroundPropertyFill(Button button){
        button.textFillProperty().bind(Bindings.when(button.hoverProperty()).then(Color.BLACK).otherwise(Color.WHITE));
        button.backgroundProperty().bind(Bindings.when(button.hoverProperty()).then(Background.fill(Color.WHITE)).otherwise(Background.fill(Color.LIGHTGRAY)));
    }

}

