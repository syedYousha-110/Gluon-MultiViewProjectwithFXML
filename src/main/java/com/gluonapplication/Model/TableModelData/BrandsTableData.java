package com.gluonapplication.Model.TableModelData;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;


import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class BrandsTableData implements CustomTableProperty {


    private  StringProperty brandId;
    private  StringProperty name;
    private  StringProperty globalIdentifier;

    public StringProperty brandIdProperty() {
        return brandId;
    }
    public StringProperty nameProperty() {return name;}

    public StringProperty globalIdentifierProperty() {
        return globalIdentifier;
    }

    public String getBrandId() {
        return brandId.get();
    }

    public String getName() {
        return name.get();
    }

    public String getGlobalIdentifier() {
        return globalIdentifier.get();
    }
    public BrandsTableData(){
        this.brandId = new SimpleStringProperty();
        this.name = new SimpleStringProperty();
        this.globalIdentifier = new SimpleStringProperty();
        getProperties();
    }
    public BrandsTableData(String BrandId, String Name, String GlobalIdentifier){
        this();
        SetBrandID(BrandId);
        SetNameProperty(Name);
        SetGlobalIdentifier(GlobalIdentifier);

    }
    public void SetNameProperty(String name){
        this.name.bindBidirectional(new SimpleStringProperty(name));
    }
    public void SetBrandID(String brandId){
        this.brandId.bindBidirectional(new SimpleStringProperty(brandId));
    }
    public void SetGlobalIdentifier(String globalIdentifier){
        this.globalIdentifier.bindBidirectional(new SimpleStringProperty(globalIdentifier));
    }

    @Override
    public Map<String,Property> getProperties() {

        Map<String,Property> propertyList = new HashMap<>();
        propertyList.put("brandId",brandIdProperty());
        propertyList.put("name",nameProperty());
        propertyList.put("globalIdentifier",globalIdentifierProperty());

        return propertyList;
    }

    @Override
    public Text TableName() {
        Text TableTitle = new Text();
        TableTitle.setText("BrandsTable");
        TableTitle.setFont(javafx.scene.text.Font.font(Font.ITALIC));
        TableTitle.setFont(javafx.scene.text.Font.font(30));
        TableTitle.fillProperty().set(new Color(Math.random(),Math.random(),Math.random(),1).darker());
        return TableTitle;
    }

    @Override
    public TextField searchText(TableView<? extends CustomTableProperty> newTableView, SortedList dataSortedList) {
        TextField textField = new TextField();
       FilteredList<BrandsTableData> dataFilteredList = new FilteredList<>((ObservableList<BrandsTableData>)newTableView.getItems(), setPredicateTo->true);
        textField.textProperty().addListener((observableValue, oldValue, newValue) -> dataFilteredList.setPredicate(data -> {
            BrandsTableData data1 = (BrandsTableData) data.getInstance();
            if (newValue.isEmpty()){
                return true;
            }
                if (String.valueOf(data1.getBrandId()).toLowerCase().contains(newValue.toLowerCase())) {
                    return true;
                }else if (data1.getName().toLowerCase().contains(newValue.toLowerCase())){
                    return true;
                }else return data1.getGlobalIdentifier().toLowerCase().contains(newValue.toLowerCase());
        }));

        dataSortedList = new SortedList<>(dataFilteredList);

        newTableView.setItems(dataSortedList);

        dataSortedList.comparatorProperty().bind(newTableView.comparatorProperty());
        return textField;
    }



    @Override
    public CustomTableProperty getInstance() {
        return this;
    }

}
