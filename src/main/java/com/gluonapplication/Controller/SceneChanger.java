package com.gluonapplication.Controller;

import com.gluonapplication.Controller.Enum.View;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.*;

import static javafx.scene.paint.Color.*;


public class SceneChanger{

    private static final Map<View,Parent> cache = new HashMap<>();
    private static Scene scene;
    private static final HBox H_BOXTitle = new HBox();
    private static final HBox H_BOX = new HBox();

    private static final VBox root = new VBox();
    private static final ScrollPane scrollPaneForView = new ScrollPane();
    private static final ScrollPane SideView = new ScrollPane();

    public static List<Pane> colorPane;

    private static final Color color = WHITE;

    public SceneChanger(Scene scene) throws IOException {
        Button ExitButton = new Button("X");
        Button MinimiseButton = new Button("---");
        ExitButton.setMinWidth(50);
        MinimiseButton.setMinWidth(30);

        MinimiseButton.setLayoutX(ExitButton.getBaselineOffset());
        MinimiseButton.prefHeightProperty().bind(H_BOXTitle.heightProperty());
        MinimiseButton.setBackground(Background.fill(WHITE));

        ExitButton.prefHeightProperty().bind(H_BOXTitle.heightProperty());
        ExitButton.setBackground(Background.fill(WHITE));
        MinimiseButton.hoverProperty().addListener((observableValue, aBoolean, t1) -> {
            MinimiseButton.backgroundProperty()
                    .bind(Bindings.when(MinimiseButton.hoverProperty())
                            .then(Background.fill(FLORALWHITE))
                            .otherwise(Background.fill(WHITE)));
        });
        ExitButton.hoverProperty().addListener((hoverProperty, aBoolean, t1) -> {
            ExitButton.backgroundProperty()
                    .bind(Bindings.when(ExitButton.hoverProperty())
                            .then(Background.fill(RED))
                            .otherwise(Background.fill(WHITE)));
        });
        ExitButton.setLayoutX(H_BOXTitle.getBaselineOffset());

        MinimiseButton.setOnAction(event -> {
            Stage stage = (Stage) MinimiseButton.getScene().getWindow();
            stage.setMaximized(!stage.isMaximized());
        });


        ExitButton.onActionProperty().setValue(event -> {
            Platform.exit();
        });

        H_BOXTitle.setBackground(Background.fill(SILVER));
        Label Title = new Label();
        Title.setFont(Font.font(20));
        Title.setText("JAVA-FX Application");
        Title.prefWidthProperty().bind(H_BOXTitle.prefWidthProperty());
        Title.textAlignmentProperty().set(TextAlignment.CENTER);
        H_BOXTitle.getChildren().add(Title);
        H_BOXTitle.getChildren().add(MinimiseButton);
        H_BOXTitle.getChildren().add(ExitButton);

        H_BOX.setBackground(Background.fill(color));
        Parent Menu = FXMLLoader.load(Objects.requireNonNull(SceneChanger.class.getResource("ControllerView/"+View.MENU.getFileName())));
        Pane sidePane = (Pane)Menu;
        sidePane.setMinWidth(300);
        sidePane.setMaxWidth(300);
        SideView.setContent(sidePane);
        SideView.setMinViewportWidth(300);
        SideView.setFitToWidth(true);
        scrollPaneForView.setMinViewportWidth(1000);
        scrollPaneForView.prefWidthProperty().bind(H_BOX.prefWidthProperty().subtract(SideView.widthProperty()));
        scrollPaneForView.prefHeightProperty().bind(H_BOX.prefHeightProperty());
        H_BOX.getChildren().addAll(SideView, scrollPaneForView);
        root.getChildren().add(0,H_BOXTitle);
        root.getChildren().add(1,H_BOX);
        cache.put(View.MENU,sidePane);
        scene.setRoot(root);
        setScene(scene);


    }


    public static void switchTo(View view){
        if (scene==null){
            System.out.println("isScene : false");
            return;
        }
        try {

            if (cache.containsKey(view))
            {
                var root= cache.get(view);
                scrollPaneForView.setContent(root);
                scrollPaneForView.setBackground(Background.fill(color));
                System.out.println("From Cache");
            }else {
                Parent  View_fxml = FXMLLoader.load(Objects.requireNonNull(SceneChanger.class.getResource("ControllerView/"+view.getFileName())));
                AnchorPane viewFxmlPane = (AnchorPane) View_fxml;

                var widthProperty = viewFxmlPane.getPrefWidth();
                var maxProperty = viewFxmlPane.getMaxWidth();
                viewFxmlPane.prefWidthProperty().bind(Bindings.when(scene.widthProperty().subtract(300).greaterThan(widthProperty)).then(H_BOX.widthProperty().subtract(300)).otherwise(widthProperty));
                viewFxmlPane.maxWidthProperty().bind(Bindings.when(scene.widthProperty().subtract(300).greaterThan(maxProperty)).then(H_BOX.widthProperty().subtract(300)).otherwise(maxProperty));
                SceneChanger.colorPane.add(viewFxmlPane);
                viewFxmlPane.backgroundProperty().setValue(Background.fill(color));
                cache.put(view,View_fxml);
                scrollPaneForView.setContent(View_fxml);
                scrollPaneForView.setBackground(Background.fill(color));
                System.out.println("Loaded into Cache");

            }
            ObservableList<Node> nodes = scrollPaneForView.getChildrenUnmodifiable();
            for (final Node node : nodes) {
                if (node instanceof ScrollBar) {
                    ((ScrollBar)node).setBackground(Background.fill(Color.LIGHTGRAY));
                    ((ScrollBar)node).setPrefHeight(18);
                    ((ScrollBar)node).setPrefWidth(18);
                }
            }

            //scene.setRoot(root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void setScene(Scene scene){
        SceneChanger.colorPane = new ArrayList<>();
        SceneChanger.scene = scene;
        root.prefWidthProperty().bind(SceneChanger.scene.widthProperty());
        root.prefHeightProperty().bind(SceneChanger.scene.heightProperty());
        root.maxHeightProperty().bind(SceneChanger.scene.heightProperty());
        root.maxWidthProperty().bind(SceneChanger.scene.widthProperty());
        H_BOXTitle.prefWidthProperty().bind(root.widthProperty());
        H_BOX.prefWidthProperty().bind(root.widthProperty());
        H_BOX.prefHeightProperty().bind(root.heightProperty().subtract(H_BOXTitle.heightProperty()));
        H_BOX.maxHeightProperty().bind(root.prefHeightProperty().subtract(H_BOXTitle.heightProperty()));
    }

}
