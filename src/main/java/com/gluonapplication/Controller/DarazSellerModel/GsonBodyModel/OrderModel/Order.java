package com.gluonapplication.Controller.DarazSellerModel.GsonBodyModel.OrderModel;

public class Order {

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String orderId) {
        OrderId = orderId;
    }

    public String getCustomerFirstName() {
        return CustomerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        CustomerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return CustomerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        CustomerLastName = customerLastName;
    }

    public String getOrderNumber() {
        return OrderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        OrderNumber = orderNumber;
    }

    public String getPaymentMethod() {
        return PaymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        PaymentMethod = paymentMethod;
    }

    public String getRemarks() {
        return Remarks;
    }

    public void setRemarks(String remarks) {
        Remarks = remarks;
    }

    public String getDeliveryInfo() {
        return DeliveryInfo;
    }

    public void setDeliveryInfo(String deliveryInfo) {
        DeliveryInfo = deliveryInfo;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public Boolean getGiftOption() {
        return GiftOption;
    }

    public void setGiftOption(Boolean giftOption) {
        GiftOption = giftOption;
    }

    public String getGiftMessage() {
        return GiftMessage;
    }

    public void setGiftMessage(String giftMessage) {
        GiftMessage = giftMessage;
    }

    public String getVoucherCode() {
        return VoucherCode;
    }

    public void setVoucherCode(String voucherCode) {
        VoucherCode = voucherCode;
    }

    public String getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        CreatedAt = createdAt;
    }

    public String getUpdateAt() {
        return UpdateAt;
    }

    public void setUpdateAt(String updateAt) {
        UpdateAt = updateAt;
    }

    private String OrderId;
        private String CustomerFirstName;
        private String CustomerLastName;
        private String OrderNumber;
        private String PaymentMethod;
        private String Remarks;
        private String DeliveryInfo;
        private String Price;
        private Boolean GiftOption;
        private String GiftMessage;
        private String VoucherCode;
        private String CreatedAt;
        private String UpdateAt;

    public AddressBilling getAddressBilling() {
        return AddressBilling;
    }

    public void setAddressBilling(AddressBilling addressBilling) {
        AddressBilling = addressBilling;
    }

    public AddressShipping getAddressShipping() {
        return AddressShipping;
    }

    public void setAddressShipping(AddressShipping addressShipping) {
        AddressShipping = addressShipping;
    }

    public String getNationalRegistrationNumber() {
        return NationalRegistrationNumber;
    }

    public void setNationalRegistrationNumber(String nationalRegistrationNumber) {
        NationalRegistrationNumber = nationalRegistrationNumber;
    }

    public int getItemsCount() {
        return ItemsCount;
    }

    public void setItemsCount(int itemsCount) {
        ItemsCount = itemsCount;
    }

    public String getPromisedShippingTimes() {
        return PromisedShippingTimes;
    }

    public void setPromisedShippingTimes(String promisedShippingTimes) {
        PromisedShippingTimes = promisedShippingTimes;
    }

    public String getExtraAttributes() {
        return ExtraAttributes;
    }

    public void setExtraAttributes(String extraAttributes) {
        ExtraAttributes = extraAttributes;
    }

    public String[] getStatuses() {
        return Statuses;
    }

    public void setStatuses(String[] statuses) {
        Statuses = statuses;
    }

    public double getVoucher() {
        return Voucher;
    }

    public void setVoucher(double voucher) {
        Voucher = voucher;
    }

    public int getVoucherPlatform() {
        return VoucherPlatform;
    }

    public void setVoucherPlatform(int voucherPlatform) {
        VoucherPlatform = voucherPlatform;
    }

    public int getVoucherSeller() {
        return VoucherSeller;
    }

    public void setVoucherSeller(int voucherSeller) {
        VoucherSeller = voucherSeller;
    }

    public double getShippingFee() {
        return ShippingFee;
    }

    public void setShippingFee(double shippingFee) {
        ShippingFee = shippingFee;
    }

    public String getTaxCode() {
        return TaxCode;
    }

    public void setTaxCode(String taxCode) {
        TaxCode = taxCode;
    }

    public String getBranchNumber() {
        return BranchNumber;
    }

    public void setBranchNumber(String branchNumber) {
        BranchNumber = branchNumber;
    }

        private AddressBilling AddressBilling;
        private AddressShipping AddressShipping;
        private String NationalRegistrationNumber;
        private int ItemsCount;
        private String PromisedShippingTimes;
        private String ExtraAttributes;
        private String[] Statuses;
        private double Voucher;
        private int VoucherPlatform;
        private int VoucherSeller;
        private double ShippingFee;
        private String TaxCode;
        private String BranchNumber;
}
