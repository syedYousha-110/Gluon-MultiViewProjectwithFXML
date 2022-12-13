package com.gluonapplication.Model.TableModelData;


import com.gluonapplication.Model.DarazSellerModel.GsonBodyModel.AttributeModel.Attributes;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;


public class AttributesTableData implements CustomTableProperty {

    private StringProperty Advance;
    private StringProperty AttributeType;
    private StringProperty InputType;
    private StringProperty IsMandatory;
    private StringProperty IsSaleProp;
    private StringProperty Label;
    private StringProperty Name;
    private StringProperty PropertyId;

    public String getAdvance() {
        return Advance.get();
    }

    public StringProperty advanceProperty() {
        return Advance;
    }

    public void setAdvance(String advance) {
        this.Advance.set(advance);
    }

    public String getAttributeType() {
        return AttributeType.get();
    }

    public StringProperty attributeTypeProperty() {
        return AttributeType;
    }

    public void setAttributeType(String attributeType) {
        this.AttributeType.set(attributeType);
    }

    public String getInputType() {
        return InputType.get();
    }

    public StringProperty inputTypeProperty() {
        return InputType;
    }

    public void setInputType(String inputType) {
        this.InputType.set(inputType);
    }

    public String getIsMandatory() {
        return IsMandatory.get();
    }

    public StringProperty isMandatoryProperty() {
        return IsMandatory;
    }

    public void setIsMandatory(String isMandatory) {
        this.IsMandatory.set(isMandatory);
    }

    public String getIsSaleProp() {
        return IsSaleProp.get();
    }

    public StringProperty isSalePropProperty() {
        return IsSaleProp;
    }

    public void setIsSaleProp(String isSaleProp) {
        this.IsSaleProp.set(isSaleProp);
    }

    public String getLabel() {
        return Label.get();
    }

    public StringProperty labelProperty() {
        return Label;
    }

    public void setLabel(String label) {
        this.Label.set(label);
    }

    public String getName() {
        return Name.get();
    }

    public StringProperty nameProperty() {
        return Name;
    }

    public void setName(String name) {
        this.Name.set(name);
    }


    public String getPropertyId() {
        return PropertyId.get();
    }

    public StringProperty propertyIdProperty() {
        return PropertyId;
    }

    public void setPropertyId(String propertyId) {
        this.PropertyId.set(propertyId);
    }
    public AttributesTableData(){
        Advance = new SimpleStringProperty();
        AttributeType = new SimpleStringProperty();
        InputType = new SimpleStringProperty();
        IsMandatory = new SimpleStringProperty();
        IsSaleProp = new SimpleStringProperty();
        Label = new SimpleStringProperty();
        Name = new SimpleStringProperty();
        PropertyId = new SimpleStringProperty();
    }
    public AttributesTableData(Attributes attributes){
        this();
        setAdvance(String.valueOf(attributes.getAdvanced()));
        setAttributeType(attributes.getAttributeType());
        setInputType(attributes.getInputType());
        setIsMandatory(attributes.isMandatory());
        setIsSaleProp(attributes.isSaleProp());
        setLabel(attributes.getLabel());
        setName(attributes.getName());
        setPropertyId(String.valueOf(attributes.getPropertyId()));
    }

    @Override
    public Map<String, Property> getProperties() {

        Map<String,Property> propertyMap = new HashMap<>();
        propertyMap.put("Advance",Advance);
        propertyMap.put("AttributeType",AttributeType);
        propertyMap.put("InputType",InputType);
        propertyMap.put("IsMandatory",IsMandatory);
        propertyMap.put("IsSaleProp",IsSaleProp);
        propertyMap.put("Label",Label);
        propertyMap.put("Name",Name);
        propertyMap.put("PropertyId",PropertyId);

        return propertyMap;
    }

    @Override
    public Text TableName() {
        Text TableTitle = new Text();
        TableTitle.setText("ProductAttributeTable");
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
