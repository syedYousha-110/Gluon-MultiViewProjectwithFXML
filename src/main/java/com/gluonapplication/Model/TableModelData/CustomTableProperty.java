package com.gluonapplication.Model.TableModelData;

import javafx.beans.property.Property;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.Map;

public interface CustomTableProperty {

    Map<String, Property> getProperties();

    Text TableName();
    TextField searchText(TableView<? extends CustomTableProperty> newTableView, SortedList dataSortedList);


    CustomTableProperty getInstance();

}
