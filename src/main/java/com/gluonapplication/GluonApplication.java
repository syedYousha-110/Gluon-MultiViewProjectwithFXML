package com.gluonapplication;


import com.gluonapplication.Controller.MenuView;
import com.gluonapplication.views.*;
import com.gluonhq.charm.glisten.application.AppManager;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.Swatch;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

import static com.gluonhq.charm.glisten.application.AppManager.HOME_VIEW;

public class GluonApplication extends Application {

    public static final String PRIMARY_VIEW = HOME_VIEW;
    public static final String API_VIEW = "Api View";
    public static final String DASHBOARD_VIEW = "dashboard View";
    public static final String SCRAPPING_VIEW = "Scrapping View";

    private final AppManager appManager = AppManager.initialize(this::postInit);

    @Override
    public void init() {
        appManager.addViewFactory(PRIMARY_VIEW, () -> (View) new PrimaryView().getView());
        appManager.addViewFactory(API_VIEW, () -> (View) new ApiView().getView());
        appManager.addViewFactory(SCRAPPING_VIEW,()-> (View) new ScrappingView().getView());
        appManager.addViewFactory(DASHBOARD_VIEW,()->(View) new DashboardView().getView());
        DrawerManager.buildDrawer(appManager);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        appManager.start(primaryStage);
    }

    private void postInit(Scene scene) {
        Swatch.LIGHT_GREEN.assignTo(scene);

        scene.getStylesheets().add(Objects.requireNonNull(GluonApplication.class.getResource("style.css")).toExternalForm());
        ((Stage) scene.getWindow()).getIcons().add(new Image(Objects.requireNonNull(GluonApplication.class.getResourceAsStream("/icon.png"))));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
