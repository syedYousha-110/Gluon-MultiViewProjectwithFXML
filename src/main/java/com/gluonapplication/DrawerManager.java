package com.gluonapplication;

import com.airhacks.afterburner.views.FXMLView;
import com.gluonapplication.Controller.MenuPresenter;
import com.gluonhq.attach.lifecycle.LifecycleService;
import com.gluonhq.attach.util.Platform;
import com.gluonhq.attach.util.Services;
import com.gluonhq.charm.glisten.application.AppManager;
import com.gluonhq.charm.glisten.application.ViewStackPolicy;
import com.gluonhq.charm.glisten.control.Avatar;
import com.gluonhq.charm.glisten.control.NavigationDrawer;
import com.gluonhq.charm.glisten.control.NavigationDrawer.Item;
import com.gluonhq.charm.glisten.control.NavigationDrawer.ViewItem;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.scene.image.Image;

import java.util.Objects;
import java.util.Optional;

import static com.gluonapplication.GluonApplication.*;

public class DrawerManager {

    public static void buildDrawer(AppManager app) {
        NavigationDrawer drawer = app.getDrawer();

        NavigationDrawer.Header header = new NavigationDrawer.Header("Final Year Project",
                "Multi View Project",
                new Avatar(21, new Image(Objects.requireNonNull(DrawerManager.class.getResourceAsStream("/icon.png")))));
        drawer.setHeader(header);

        MenuPresenter menuPresenter = new MenuPresenter();
        final Item primaryItem = new ViewItem("Primary", MaterialDesignIcon.HOME.graphic(), PRIMARY_VIEW, ViewStackPolicy.SKIP);
        final Item tertiaryItem = new ViewItem("Api", menuPresenter.getGETRequest(),API_VIEW);
        final Item secondaryItem = new ViewItem("Scrapping",menuPresenter.getScrapping() , SCRAPPING_VIEW);
        final Item fourthItem = new ViewItem("dashBoard",menuPresenter.getDashBoard() ,DASHBOARD_VIEW);

        drawer.getItems().addAll(primaryItem, secondaryItem,tertiaryItem,fourthItem);
        if (Platform.isAndroid()){
            System.out.println("andriod");
        }
        if (Platform.isDesktop()) {
            System.out.println("desktop");
            final Item quitItem = new Item("Quit", MaterialDesignIcon.EXIT_TO_APP.graphic());
            quitItem.selectedProperty().addListener((obs, ov, nv) -> {
                if (nv) {
                    Services.get(LifecycleService.class).ifPresent(LifecycleService::shutdown);
                }
            });
            drawer.getItems().add(quitItem);
        }
    }
}