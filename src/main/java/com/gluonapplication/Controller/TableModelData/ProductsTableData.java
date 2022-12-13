package com.gluonapplication.Controller.TableModelData;

import javafx.beans.property.Property;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.Map;

public class ProductsTableData implements CustomTableProperty{


    @Override
    public Map<String, Property> getProperties() {
        return null;
    }

    @Override
    public Text TableName() {
        return null;
    }

    @Override
    public TextField searchText(TableView<? extends CustomTableProperty> newTableView, SortedList dataSortedList) {
        return null;
    }

    @Override
    public CustomTableProperty getInstance() {
        return null;
    }
}
