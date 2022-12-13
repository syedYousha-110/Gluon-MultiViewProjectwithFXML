package com.gluonapplication.Model.TableModelData;

import javafx.beans.property.Property;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class CategoryTreeAttributes implements CustomTableProperty {



    @Override
    public Map<String, Property> getProperties() {
        return new HashMap<>();
    }

    @Override
    public Text TableName() {
        Text TableTitle = new Text();
        TableTitle.setText("CategoryTreeAttributeTable");
        TableTitle.setFont(javafx.scene.text.Font.font(Font.ITALIC));
        TableTitle.setFont(javafx.scene.text.Font.font(30));
        TableTitle.fillProperty().set(new Color(Math.random(),Math.random(),Math.random(),1).darker());
        return TableTitle;
    }

    @Override
    public TextField searchText(TableView<? extends CustomTableProperty> newTableView, SortedList dataSortedList) {
        return new TextField();
    }

    @Override
    public CustomTableProperty getInstance() {
        return this;
    }
}
