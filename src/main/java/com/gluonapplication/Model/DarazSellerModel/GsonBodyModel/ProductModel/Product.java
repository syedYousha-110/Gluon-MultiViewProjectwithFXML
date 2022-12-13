package com.gluonapplication.Model.DarazSellerModel.GsonBodyModel.ProductModel;

import java.util.List;

public class Product {
    private int PrimaryCategory;
    private long ItemId;
    private ProductAttribute Attributes;
    private List<Skus> Skus;

    public int getPrimaryCategory() {
        return PrimaryCategory;
    }

    public void setPrimaryCategory(int primaryCategory) {
        PrimaryCategory = primaryCategory;
    }

    public long getItemId() {
        return ItemId;
    }

    public void setItemId(long itemId) {
        ItemId = itemId;
    }

    public ProductAttribute getAttributes() {
        return Attributes;
    }

    public void setAttributes(ProductAttribute attributes) {
        Attributes = attributes;
    }

    public List<Skus> getSkus() {
        return Skus;
    }

    public void setSkus(List<Skus> skus) {
        Skus = skus;
    }
}
