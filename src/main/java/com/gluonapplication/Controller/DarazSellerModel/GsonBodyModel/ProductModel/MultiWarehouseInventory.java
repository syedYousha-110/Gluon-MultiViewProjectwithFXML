package com.gluonapplication.Controller.DarazSellerModel.GsonBodyModel.ProductModel;

public class MultiWarehouseInventory {

    private int occupyQuantity;
    private int quantity;
    private int totalQuantity;
    private int withholdQuantity;
    private int sellableQuantity;
    private String warehouseCode;

    public int getOccupyQuantity() {
        return occupyQuantity;
    }

    public void setOccupyQuantity(int occupyQuantity) {
        this.occupyQuantity = occupyQuantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public int getWithholdQuantity() {
        return withholdQuantity;
    }

    public void setWithholdQuantity(int withholdQuantity) {
        this.withholdQuantity = withholdQuantity;
    }

    public int getSellableQuantity() {
        return sellableQuantity;
    }

    public void setSellableQuantity(int sellableQuantity) {
        this.sellableQuantity = sellableQuantity;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

}
