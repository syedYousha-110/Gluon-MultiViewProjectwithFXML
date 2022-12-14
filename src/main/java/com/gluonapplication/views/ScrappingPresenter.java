package com.gluonapplication.views;

import com.gluonhq.charm.glisten.animation.BounceInRightTransition;
import com.gluonhq.charm.glisten.application.AppManager;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.FloatingActionButton;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ScrappingPresenter {
    @FXML
    private View scrapping;

    public void initialize(){
        scrapping.setShowTransitionFactory(BounceInRightTransition::new);
        FloatingActionButton fb = new FloatingActionButton(MaterialDesignIcon.BACKSPACE.text, e->{
            AppManager.getInstance().switchToPreviousView();
        });
        fb.showOn(scrapping);
        scrapping.showingProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue){
                AppBar appBar = AppManager.getInstance().getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.MENU.button(x->AppManager.getInstance().getDrawer().open()));
                appBar.setTitle(new Label("Web Scrapping"));
                appBar.setProgress(10.00);
                appBar.setProgressBarVisible(true);
            }
        });
    }
}
