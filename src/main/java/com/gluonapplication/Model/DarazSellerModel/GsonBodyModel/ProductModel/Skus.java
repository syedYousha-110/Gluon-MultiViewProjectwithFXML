package com.gluonapplication.Model.DarazSellerModel.GsonBodyModel.ProductModel;


import com.google.gson.GsonBuilder;
import com.google.gson.JsonPrimitive;
import javafx.scene.image.Image;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Skus {

    private volatile Product product;
    private String Status;
    private Number quantity;
    private String _compatible_variation_;
    private List<String> Images;
    private String SellerSku;
    private String ShopSku;
    private String package_content;
    private URL url;
    private List<JsonPrimitive> multiWarehouseInventories;
    private String package_width;
    private String package_height;
    private List<JsonPrimitive> fblWarehouseInventories;
    private double special_price;
    private double price;
    private List<String> channelInventories;
    private String package_length;
    private String package_weight;

    private String color_family;
    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public Number getQuantity() {
        return quantity;
    }

    public void setQuantity(Number quantity) {
        this.quantity = quantity;
    }

    public String get_compatible_variation_() {
        return _compatible_variation_;
    }

    public String getColor_family() {
        return color_family;
    }

    public void setColor_family(String color_family) {
        this.color_family = color_family;
    }

    public void set_compatible_variation_(String _compatible_variation_) {
        this._compatible_variation_ = _compatible_variation_;
    }

    public List<Image> getImages() {
        List<Image> images = new ArrayList<>();
        //this.Images.stream().map(Image::new).forEach(images::add);
        this.Images.forEach(x-> {
            try {

                URL url1 = new URL(x);
                InputStream inputStream = new BufferedInputStream(url1.openStream());
                Image image = new Image(inputStream);
                images.add(image);
            } catch (IOException e) {
                System.out.println("Wrong Url");
            }
        });
        return images;
    }

    public void setImages(List<String> images) {
        Images = images;
    }

    public String getSellerSku() {
        return SellerSku;
    }

    public void setSellerSku(String sellerSku) {
        SellerSku = sellerSku;
    }

    public String getShopSku() {
        return ShopSku;
    }

    public void setShopSku(String shopSku) {
        ShopSku = shopSku;
    }

    public String getPackage_content() {
        return package_content;
    }

    public void setPackage_content(String package_content) {
        this.package_content = package_content;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public List<MultiWarehouseInventory> getMultiWarehouseInventories() {
        List<MultiWarehouseInventory> ArrayList = new ArrayList<>();
        this.multiWarehouseInventories.forEach(x -> {
            MultiWarehouseInventory item = new GsonBuilder().create().fromJson(x.getAsString(), MultiWarehouseInventory.class);
            ArrayList.add(item);
        });
        return ArrayList;
    }

    public void setMultiWarehouseInventories(List<JsonPrimitive> multiWarehouseInventories) {
        this.multiWarehouseInventories = multiWarehouseInventories;
    }

    public String getPackage_width() {
        return package_width;
    }

    public void setPackage_width(String package_width) {
        this.package_width = package_width;
    }

    public String getPackage_height() {
        return package_height;
    }

    public void setPackage_height(String package_height) {
        this.package_height = package_height;
    }

    public List<FblWarehouseInventory> getFblWarehouseInventories() {
        List<FblWarehouseInventory> ArrayList = new ArrayList<>();
        this.fblWarehouseInventories.forEach(x -> {
            FblWarehouseInventory item = new GsonBuilder().create().fromJson(x.getAsString(), FblWarehouseInventory.class);
            ArrayList.add(item);
        });
        return ArrayList;
    }

    public void setFblWarehouseInventories(List<JsonPrimitive> fblWarehouseInventories) {
        this.fblWarehouseInventories = fblWarehouseInventories;
    }

    public double getSpecial_price() {
        return special_price;
    }

    public void setSpecial_price(double special_price) {
        this.special_price = special_price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<String> getChannelInventories() {
        return channelInventories;
    }

    public void setChannelInventories(List<String> channelInventories) {
        this.channelInventories = channelInventories;
    }

    public String getPackage_length() {
        return package_length;
    }

    public void setPackage_length(String package_length) {
        this.package_length = package_length;
    }

    public String getSpecial_from_date() {
        return special_from_date;
    }

    public void setSpecial_from_date(String special_from_date) {
        this.special_from_date = special_from_date;
    }

    public String getSpecial_from_time() {
        return special_from_time;
    }

    public void setSpecial_from_time(String special_from_time) {
        this.special_from_time = special_from_time;
    }

    public String getSpecial_time_format() {
        return special_time_format;
    }

    public void setSpecial_time_format(String special_time_format) {
        this.special_time_format = special_time_format;
    }

    public String getPackage_weight() {
        return package_weight;
    }

    public void setPackage_weight(String package_weight) {
        this.package_weight = package_weight;
    }

    public Number getSkuId() {
        return SkuId;
    }

    public void setSkuId(Number skuId) {
        SkuId = skuId;
    }

    public String getSubStatus() {
        return SubStatus;
    }

    public void setSubStatus(String subStatus) {
        SubStatus = subStatus;
    }

    public String getSpecial_to_date() {
        return special_to_date;
    }

    public void setSpecial_to_date(String special_to_date) {
        this.special_to_date = special_to_date;
    }

    public String getSpecial_to_time() {
        return special_to_time;
    }

    public void setSpecial_to_time(String special_to_time) {
        this.special_to_time = special_to_time;
    }

    private String special_from_date;
    private String special_from_time;
    private String special_time_format;
    private Number SkuId;
    private String SubStatus;
    private String special_to_date;
    private String special_to_time;


}
