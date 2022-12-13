package com.gluonapplication.Controller.Views;


import javafx.scene.Parent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class NewMenu {
    private final VBox root;

    public NewMenu(Parent parent){

        AnchorPane pane = (AnchorPane) parent;
        pane.getChildren().forEach(x-> {
            if (x instanceof VBox){
                ((VBox) x).backgroundProperty().setValue(Background.fill(Color.GRAY));
            }
        });
        pane.setBackground(Background.fill(Color.LIGHTGRAY));
        root = new VBox();
        root.getChildren().addAll(parent);
    }
    public VBox getParent(){
        this.root.setMinWidth(300);
        this.root.setMinHeight(1000);
        this.root.setPrefSize(300,1000);
        return this.root;
    }
}
