package com.gluonapplication.Model.TableModelData;

import com.gluonapplication.Model.DarazSellerModel.GsonBodyModel.OrderModel.Order;
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
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OrdersTableData implements CustomTableProperty {

    private StringProperty OrderId;
    private StringProperty CustomerFirstName;
    private StringProperty CustomerLastName;
    private StringProperty OrderNumber;
    private StringProperty PaymentMethod;
    private StringProperty ItemsCount;
    private StringProperty DeliveryInfo;
    private StringProperty Price;
    private StringProperty VoucherCode;
    private StringProperty CreatedAt;
    private StringProperty UpdateAt;
    private StringProperty ShippingFee;
    private StringProperty BranchNumber;
    private StringProperty NationalRegistrationNumber;
    private StringProperty PromisedShippingTimes;
    private StringProperty ExtraAttributes;
    private StringProperty Statuses;
    private StringProperty Voucher;
    private StringProperty VoucherPlatform;
    private StringProperty VoucherSeller;
    private StringProperty TaxCode;

    public String getNationalRegistrationNumber() {
        return NationalRegistrationNumber.get();
    }

    public StringProperty nationalRegistrationNumberProperty() {
        return NationalRegistrationNumber;
    }

    public void setNationalRegistrationNumber(String nationalRegistrationNumber) {
        this.NationalRegistrationNumber.set(nationalRegistrationNumber);
    }

    public String getItemsCount() {
        return ItemsCount.get();
    }

    public StringProperty itemsCountProperty() {
        return ItemsCount;
    }

    public void setItemsCount(String itemsCount) {
        this.ItemsCount.set(itemsCount);
    }

    public String getPromisedShippingTimes() {
        return PromisedShippingTimes.get();
    }

    public StringProperty promisedShippingTimesProperty() {
        return PromisedShippingTimes;
    }

    public void setPromisedShippingTimes(String promisedShippingTimes) {
        this.PromisedShippingTimes.set(promisedShippingTimes);
    }

    public String getExtraAttributes() {
        return ExtraAttributes.get();
    }

    public StringProperty extraAttributesProperty() {
        return ExtraAttributes;
    }

    public void setExtraAttributes(String extraAttributes) {
        this.ExtraAttributes.set(extraAttributes);
    }

    public String getStatuses() {
        return Statuses.get();
    }

    public StringProperty statusesProperty() {
        return Statuses;
    }

    public void setStatuses(String statuses) {
        this.Statuses.set(statuses);
    }

    public String getVoucher() {
        return Voucher.get();
    }

    public StringProperty voucherProperty() {
        return Voucher;
    }

    public void setVoucher(String voucher) {
        this.Voucher.set(voucher);
    }

    public String getVoucherPlatform() {
        return VoucherPlatform.get();
    }

    public StringProperty voucherPlatformProperty() {
        return VoucherPlatform;
    }

    public void setVoucherPlatform(String voucherPlatform) {
        this.VoucherPlatform.set(voucherPlatform);
    }

    public String getVoucherSeller() {
        return VoucherSeller.get();
    }

    public StringProperty voucherSellerProperty() {
        return VoucherSeller;
    }

    public void setVoucherSeller(String voucherSeller) {
        this.VoucherSeller.set(voucherSeller);
    }

    public String getShippingFee() {
        return ShippingFee.get();
    }

    public StringProperty shippingFeeProperty() {
        return ShippingFee;
    }

    public void setShippingFee(String shippingFee) {
        this.ShippingFee.set(shippingFee);
    }

    public String getTaxCode() {
        return TaxCode.get();
    }

    public StringProperty taxCodeProperty() {
        return TaxCode;
    }

    public void setTaxCode(String taxCode) {
        this.TaxCode.set(taxCode);
    }

    public String getBranchNumber() {
        return BranchNumber.get();
    }

    public StringProperty branchNumberProperty() {
        return BranchNumber;
    }

    public void setBranchNumber(String branchNumber) {
        this.BranchNumber.set(branchNumber);
    }

    public String getOrderId() {
        return OrderId.get();
    }

    public StringProperty orderIdProperty() {
        return OrderId;
    }

    public void setOrderId(String orderId) {
        this.OrderId.set(orderId);
    }

    public String getCustomerFirstName() {
        return CustomerFirstName.get();
    }

    public StringProperty customerFirstNameProperty() {
        return CustomerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.CustomerFirstName.set(customerFirstName);
    }

    public String getCustomerLastName() {
        return CustomerLastName.get();
    }

    public StringProperty customerLastNameProperty() {
        return CustomerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.CustomerLastName.set(customerLastName);
    }

    public String getOrderNumber() {
        return OrderNumber.get();
    }

    public StringProperty orderNumberProperty() {
        return OrderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.OrderNumber.set(orderNumber);
    }

    public String getPaymentMethod() {
        return PaymentMethod.get();
    }

    public StringProperty paymentMethodProperty() {
        return PaymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.PaymentMethod.set(paymentMethod);
    }

    public String getDeliveryInfo() {
        return DeliveryInfo.get();
    }

    public StringProperty deliveryInfoProperty() {
        return DeliveryInfo;
    }

    public void setDeliveryInfo(String deliveryInfo) {
        this.DeliveryInfo.set(deliveryInfo);
    }

    public String getPrice() {
        return Price.get();
    }

    public StringProperty priceProperty() {
        return Price;
    }

    public void setPrice(String price) {
        this.Price.set(price);
    }

    public String getVoucherCode() {
        return VoucherCode.get();
    }

    public StringProperty voucherCodeProperty() {
        return VoucherCode;
    }

    public void setVoucherCode(String voucherCode) {
        this.VoucherCode.set(voucherCode);
    }

    public String getCreatedAt() {
        return CreatedAt.get();
    }

    public StringProperty createdAtProperty() {
        return CreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        this.CreatedAt.set(createdAt);
    }

    public String getUpdateAt() {
        return UpdateAt.get();
    }

    public StringProperty updateAtProperty() {
        return UpdateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.UpdateAt.set(updateAt);
    }

    public OrdersTableData(Order orders){
        this();
        setOrderId(orders.getOrderId());
        setCustomerFirstName(orders.getCustomerFirstName());
        setCustomerLastName(orders.getCustomerLastName());
        setOrderNumber(orders.getOrderNumber());
        setPaymentMethod(orders.getPaymentMethod());
        setItemsCount(String.valueOf(orders.getItemsCount()));
        setDeliveryInfo(orders.getDeliveryInfo());
        setPrice(orders.getPrice());
        setVoucherCode(orders.getVoucherCode());
        setCreatedAt(orders.getCreatedAt());
        setUpdateAt(orders.getUpdateAt());
        setShippingFee(String.valueOf(orders.getShippingFee()));
        setBranchNumber(orders.getBranchNumber());
        setNationalRegistrationNumber(orders.getNationalRegistrationNumber());
        setPromisedShippingTimes(orders.getPromisedShippingTimes());
        setExtraAttributes(orders.getExtraAttributes());
        setStatuses(Arrays.toString(orders.getStatuses()));
        setVoucher(String.valueOf(orders.getVoucher()));
        setVoucherPlatform(String.valueOf(orders.getVoucherPlatform()));
        setVoucherSeller(String.valueOf(orders.getVoucherSeller()));
        setTaxCode(orders.getTaxCode());
    }
    public OrdersTableData(){
        OrderId = new SimpleStringProperty();
        CustomerFirstName = new SimpleStringProperty();
        CustomerLastName = new SimpleStringProperty();
        OrderNumber = new SimpleStringProperty();
        PaymentMethod = new SimpleStringProperty();
        ItemsCount = new SimpleStringProperty();
        DeliveryInfo = new SimpleStringProperty();
        Price = new SimpleStringProperty();
        VoucherCode = new SimpleStringProperty();
        CreatedAt = new SimpleStringProperty();
        UpdateAt = new SimpleStringProperty();
        ShippingFee = new SimpleStringProperty();
        BranchNumber = new SimpleStringProperty();
        NationalRegistrationNumber = new SimpleStringProperty();
        PromisedShippingTimes = new SimpleStringProperty();
        ExtraAttributes = new SimpleStringProperty();
        Statuses = new SimpleStringProperty();
        Voucher = new SimpleStringProperty();
        VoucherPlatform = new SimpleStringProperty();
        VoucherSeller = new SimpleStringProperty();
        TaxCode = new SimpleStringProperty();
    }

    @Override
    public Map<String, Property> getProperties() {
        Map<String,Property> propertyMap = new HashMap<>();
        propertyMap.put("OrderId",OrderId);
        propertyMap.put("CustomerFirstName",CustomerFirstName);
        propertyMap.put("CustomerLastName",CustomerLastName);
        propertyMap.put("OrderNumber",OrderNumber);
        propertyMap.put("PaymentMethod",PaymentMethod);
        propertyMap.put("ItemsCount",ItemsCount);
        propertyMap.put("DeliveryInfo",DeliveryInfo);
        propertyMap.put("Price",Price);
        propertyMap.put("VoucherCode",VoucherCode);
        propertyMap.put("CreatedAt",CreatedAt);
        propertyMap.put("UpdateAt",UpdateAt);
        propertyMap.put("ShippingFee",ShippingFee);
        propertyMap.put("BranchNumber",BranchNumber);
        propertyMap.put("NationalRegistrationNumber",NationalRegistrationNumber);
        propertyMap.put("PromisedShippingTimes",PromisedShippingTimes);
        propertyMap.put("ExtraAttributes",ExtraAttributes);
        propertyMap.put("Statuses",Statuses);
        propertyMap.put("Voucher",Voucher);
        propertyMap.put("VoucherPlatform",VoucherPlatform);
        propertyMap.put("VoucherSeller",VoucherSeller);
        propertyMap.put("TaxCode",TaxCode);

        return propertyMap;
    }

    @Override
    public Text TableName() {
        Text TableTitle = new Text();
        TableTitle.setText("OrderTable");
        TableTitle.setFont(javafx.scene.text.Font.font(Font.ITALIC));
        TableTitle.setFont(javafx.scene.text.Font.font(30));
        TableTitle.fillProperty().set(new Color(Math.random(),Math.random(),Math.random(),1).darker());
        return TableTitle;
    }

    @Override
    public TextField searchText(TableView<? extends CustomTableProperty> newTableView, SortedList dataSortedList) {
        TextField textField = new TextField();
        FilteredList<OrdersTableData> dataFilteredList = new FilteredList<>((ObservableList<OrdersTableData>) newTableView.getItems(), setPredicate->true);
        textField.textProperty().addListener(((observableValue, s, newValue) -> dataFilteredList.setPredicate(data1->
                {
                    if (newValue.isEmpty()){
                        return true;
                    }
                    if (String.valueOf(data1.getOrderId()).toLowerCase().contains(newValue.toLowerCase())) {
                        return true;
                    }else if (data1.getCustomerFirstName().toLowerCase().contains(newValue.toLowerCase())){
                        return true;
                    }else if(data1.getCustomerLastName().toLowerCase().contains(newValue.toLowerCase())){
                        return true;
                    }else return data1.getCreatedAt().toLowerCase().contains(newValue.toLowerCase()) && !data1.getCreatedAt().isBlank();
                }
        )));
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
