package com.gluonapplication.Model.DarazSellerModel.GsonBodyModel.AttributeModel;

import java.util.List;

public class Attributes {
    private Advanced advanced;
    private String attributeType;
    private String inputType;
    private String isMandatory;
    private String isSaleProp;
    private String label;
    private String name;
    private List<Options> options;
    private int propertyId;

    public Advanced getAdvanced() {
        return advanced;
    }

    public void setAdvanced(Advanced advanced) {
        this.advanced = advanced;
    }

    public String getAttributeType() {
        return attributeType;
    }

    public void setAttributeType(String attributeType) {
        this.attributeType = attributeType;
    }

    public String getInputType() {
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    public String isMandatory() {
        return isMandatory;
    }

    public void setIsMandatory(String isMandatory) {
        this.isMandatory = isMandatory;
    }

    public String isSaleProp() {
        return isSaleProp;
    }

    public void setIsSaleProp(String isSaleProp) {
        this.isSaleProp = isSaleProp;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public List<Options> getOptions() {
        return options;
    }

    public void setOptions(List<Options> options) {
        this.options = options;
    }
}
class Advanced{

    public int getIs_key_prop() {
        return is_key_prop;
    }

    public void setIs_key_prop(int is_key_prop) {
        this.is_key_prop = is_key_prop;
    }

    private int is_key_prop;

    @Override
    public String toString() {
        return "is_Key_prop ? "+getIs_key_prop();
    }
}
class Options{
    private String name;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}