package com.gluonapplication.Controller;

import com.gluonapplication.Model.DarazSellerModel.GetRequest.GetBrands;
import com.gluonhq.charm.glisten.application.AppManager;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;


import static com.gluonapplication.GluonApplication.*;

public class MenuPresenter {

    public AnchorPane parent;
    @FXML
    private ImageView profile;

    @FXML
    private Label label_commerce;

    public Button getDashBoard() {
        return dashBoard;
    }

    public void setDashBoard(Button dashBoard) {
        this.dashBoard = dashBoard;
    }

    @FXML
    private Button dashBoard;

    public Button getScrapping() {
        return Scrapping;
    }

    public void setScrapping(Button scrapping) {
        Scrapping = scrapping;
    }

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

    private Color color;

    public MenuPresenter(){
        this.color = Color.LIGHTGRAY;
        this.profile = new ImageView();
        this.settings = new Button();
        this.DBMS = new Button();

        this.dashBoard = new Button();
        ImageView dashboardView = new ImageView("E:\\JavaFXApplication\\Gluon-MultiViewProjectwithFXML\\src\\main\\resources\\com\\gluonapplication\\views\\icons\\PikPng.com_cell-phone-icon-png_1188611.png");
        dashboardView.setPreserveRatio(true);
        dashBoard.setGraphic(dashboardView);

        this.GETRequest = new Button();
        ImageView apiView =new ImageView("E:\\JavaFXApplication\\Gluon-MultiViewProjectwithFXML\\src\\main\\resources\\com\\gluonapplication\\Views\\icons\\PikPng.com_scrape-png_4132362.png");
        apiView.setPreserveRatio(true);
        GETRequest.setGraphic(apiView);

        this.Scrapping = new Button();
        ImageView scrappingView = new ImageView("E:\\JavaFXApplication\\Gluon-MultiViewProjectwithFXML\\src\\main\\resources\\com\\gluonapplication\\Views\\icons\\PikPng.com_stock-market-icon-png_3820429.png");
        scrappingView.setPreserveRatio(true);
        Scrapping.setGraphic(scrappingView);

        ImageView(apiView,GETRequest);
        ImageView(dashboardView,dashBoard);
        ImageView(scrappingView,Scrapping);
        initialize();
    }
    private void ImageView(ImageView imageView, Button btn){
        imageView.fitWidthProperty().bind(btn.widthProperty().subtract(10));
        imageView.fitHeightProperty().bind(btn.heightProperty().subtract(2));
        btn.backgroundProperty().set(Background.fill(color));
        buttonTextAndBackgroundPropertyFill(btn);
    }

    public void initialize() {

//        parent.backgroundProperty().set(Background.fill(Color.DIMGREY));
//        Color color = Color.LIGHTGRAY;
//        parent.setPrefHeight(1000);
//        parent.setMinHeight(1000);
//        setButtonsColor(color);
//        settings.setDisable(true);
//        DBMS.setDisable(true);
//        item.setDisable(true);
//        label_commerce.textFillProperty().setValue(Color.WHITE);
//        label_commerce.setBackground(Background.fill(Color.GRAY));
//        label_commerce.setText("www.Daraz.pk");
        GETRequest.setOnAction(event -> {
            System.out.println("Api View");
            AppManager appManager = AppManager.getInstance();
            appManager.switchView(API_VIEW);
            appManager.getDrawer().close();
        });

        Scrapping.setOnAction(event -> {
            System.out.println("Scrapping View");
            AppManager appManager = AppManager.getInstance();
            appManager.switchView(SCRAPPING_VIEW);
            appManager.getDrawer().close();
        });
        dashBoard.setOnAction(event -> {
            {
                System.out.println("Dashboard View");
                AppManager appManager = AppManager.getInstance();
                appManager.switchView(DASHBOARD_VIEW);
                appManager.getDrawer().close();
            }
        });
        profile.hoverProperty().addListener(event-> {
            {

            }
        });

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

