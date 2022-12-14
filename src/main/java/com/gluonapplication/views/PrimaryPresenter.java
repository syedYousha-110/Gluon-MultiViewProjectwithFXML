package com.gluonapplication.views;

import com.gluonhq.charm.glisten.application.AppManager;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.Objects;

public class PrimaryPresenter {

    @FXML
    private View primary;

    @FXML
    private Label label;

    public void initialize() {
        primary.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppBar appBar = AppManager.getInstance().getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> 
                        AppManager.getInstance().getDrawer().open()));
                appBar.setTitleText("Primary");
                TextField field = new TextField();
                var design = MaterialDesignIcon.SEARCH.button();
                appBar.getActionItems().add(design);
                design.setOnAction(event -> {
                    appBar.getActionItems().add(field);
                    appBar.getActionItems().remove(design);
                });
                    field.setOnKeyPressed(event -> {
                        if (event.getCode().equals(KeyCode.BACK_SPACE) && field.getText().isEmpty()){
                        appBar.getActionItems().add(design);
                        appBar.getActionItems().remove(field);}
                    });


            }
        });
    }

    @FXML
    void buttonClick() {
        label.setText("Hello JavaFX Universe!");
    }

}
