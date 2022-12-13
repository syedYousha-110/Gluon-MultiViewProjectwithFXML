package com.gluonapplication.Controller.DarazSellerModel.GsonBodyModel.ProductModel;



import java.util.List;

public class ProductBody {
    private int TotalProducts;
    private List<Product> Products;

    public int getTotalProducts() {
        return TotalProducts;
    }

    public void setTotalProducts(int totalProducts) {
        TotalProducts = totalProducts;
    }

    public List<Product> getProducts() {
        return Products;
    }

    public void setProducts(List<Product> products) {
        Products = products;
    }
}
