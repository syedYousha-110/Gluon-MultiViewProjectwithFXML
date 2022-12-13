package com.gluonapplication.Model.TableModelData;

import javafx.beans.property.*;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.StringConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;


public class TableUtility {


    private TableView<CustomTableProperty> tableView ;

    private Map<ObservableList<CustomTableProperty>,TableView<CustomTableProperty>> ListableViewMap = new HashMap<>();
    private   ObservableList<CustomTableProperty> dataObservableList = FXCollections.observableArrayList();
    private CustomTableProperty customTableProperty;

    public TableUtility(CustomTableProperty customTableProperty, ObservableList<CustomTableProperty> observableList, TableView<CustomTableProperty> newTableView){
        this.customTableProperty = customTableProperty;
        setObservableList(observableList);
        setTableView(newTableView);
        ListableViewMap.put(observableList,this.tableView);
    }

    private List<TableColumn<CustomTableProperty, StringProperty>> InitializeColumns(){
        if (customTableProperty.getInstance() == null){
            return new ArrayList<>();
        }
        List<TableColumn<CustomTableProperty,StringProperty>> columns = new ArrayList<>();

        for (int i = 0; i< customTableProperty.getInstance().getProperties().size(); i++){
            columns.add(new TableColumn<>(Arrays.asList(customTableProperty.getClass().getDeclaredFields()).get(i).getName()));
            columns.get(i).setCellFactory(y->new TextFieldTableCell<>(getStringConverter()));

        }
        columns.forEach(x->x.setCellValueFactory(y->y.getValue().getInstance().getProperties().get(x.getText())));

        return columns;
    }


    public void setObservableList(ObservableList<CustomTableProperty> observableList){
        if (observableList ==null){
            this.dataObservableList = FXCollections.observableArrayList();
        }
        this.dataObservableList = observableList;
    }
    public ObservableList<CustomTableProperty> getDataObservableList(){
        return dataObservableList;
    }

    public TableView<CustomTableProperty> getTableView() {
        return tableView;

    }

    public void setTableView(TableView<CustomTableProperty> tableView) {
        tableView = new TableView<>();
        tableView.getColumns().addAll(InitializeColumns());
        tableView.setItems(dataObservableList);
        tableView.setEditable(true);
        this.tableView = tableView;

//        ItemTableUtility.tableView = tableView;
//        ItemTableUtility.tableView.getColumns().addAll(InitializeColumns());
//
//        TableView.TableViewSelectionModel<CustomProperty> tsm = ItemTableUtility.tableView.getSelectionModel();
//        ObservableList<Integer> list = tsm.getSelectedIndices();

    }

    private static StringConverter getNumberConverter(){
        return new StringConverter<>() {
            @Override
            public String toString(Object o) {
                return Integer.toString((Integer) o);
            }

            @Override
            public Integer fromString(String s) {
                return Integer.parseInt(s);
            }
        };
    }
    private StringConverter<Object> getConverter(){
        return new StringConverter<Object>() {
            @Override
            public String toString(Object o) {
                return o.toString();
            }

            @Override
            public Object fromString(String s) {
                return s;
            }
        };
    }
    private static StringConverter getStringConverter() {

        return new StringConverter<>() {
            @Override
            public String toString(Object o) {
                return o!=null?o.toString():"";
            }

            @Override
            public Object fromString(String s) {

                return s;
            }
        };

    }

}
