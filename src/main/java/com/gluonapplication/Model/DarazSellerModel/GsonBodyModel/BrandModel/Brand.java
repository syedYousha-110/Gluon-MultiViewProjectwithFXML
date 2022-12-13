package com.gluonapplication.Model.DarazSellerModel.GsonBodyModel.BrandModel;

public class Brand {

    public String getBrandId() {
        return BrandId;
    }

    public void setBrandId(String brandId) {
        this.BrandId=brandId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getGlobalIdentifier() {
        return GlobalIdentifier;
    }

    public void setGlobalIdentifier(String globalIdentifier) {
        GlobalIdentifier = globalIdentifier;
    }

    private String BrandId;
    private String Name;
    private String GlobalIdentifier;

    public String toString() {
        return String.format("%s \n %s \n %s \n",getGlobalIdentifier(),getName(),getBrandId());
    }

}
