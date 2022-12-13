package com.gluonapplication.Controller.DarazSellerModel.GsonBodyModel.ProductModel;

import com.gluonapplication.Controller.DarazSellerModel.GsonBodyModel.BrandModel.Brand;

public class ProductAttribute {
    private String description;
    private String short_description;
    private String description_en;
    private String brand;
    private String warranty_type;
    private String source;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public String getDescription_en() {
        return description_en;
    }

    public void setDescription_en(String description_en) {
        this.description_en = description_en;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand =brand;
    }
    public String getWarranty_type() {
        return warranty_type;
    }

    public void setWarranty_type(String warranty_type) {
        this.warranty_type = warranty_type;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
