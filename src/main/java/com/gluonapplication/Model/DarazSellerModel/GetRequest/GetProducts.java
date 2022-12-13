package com.gluonapplication.Model.DarazSellerModel.GetRequest;

import com.gluonapplication.Model.DarazSellerModel.GsonBodyModel.ProductModel.Product;
import com.gluonapplication.Model.DarazSellerModel.GsonBodyModel.ProductModel.ProductBody;
import com.gluonapplication.Model.DarazSellerModel.GsonBodyModel.ResponseModel.Head;
import com.gluonapplication.Model.Enum.Constants;
import com.gluonapplication.Model.Enum.Format;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.*;


public class GetProducts extends ApiGetRequestModel {

    private List<Product> products;
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    private GetProducts(Format format, String timeStamp, String userID, String apiKey) {
        super("GetProducts",format, timeStamp, userID, apiKey);

    }

    public GetProducts(String userID, String apiKey) {
       this(Format.JSON,getCurrentTimestamp(),userID,apiKey);
    }
    @Override
    public void constructData() {
        System.out.println("\nGetProducts");
        if (getSuccessResponse() == null) {return;}
        System.out.println(getSuccessResponse());
        Head head =  getGson().fromJson(Objects.requireNonNullElseGet(getSuccessResponse().get("Head").getAsJsonObject(), JsonObject::new), Head.class);
        setHead(head);
        JsonElement products = getSuccessResponse().get("Body");
        System.out.println(products.toString());
        ProductBody productBody = getGson().fromJson(products.getAsJsonObject(), ProductBody.class);
        setProducts(new ArrayList<>(productBody.getProducts()));
    }

    public static void main(String[] args) throws InterruptedException {
        GetProducts d = new GetProducts("syanstore723@gmail.com", Constants.API_KEY.getKey());
       // d.addParameter("Limit", String.valueOf(24));
        //d.addParameter("Search", "220578104-1622698644073-0");
        d.start();
        d.join();
        d.getProducts().forEach(x-> System.out.println(x.getPrimaryCategory()));
        System.out.println(d.getQueryString());

    }

}
