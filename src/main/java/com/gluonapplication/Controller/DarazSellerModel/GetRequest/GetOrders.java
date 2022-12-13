package com.gluonapplication.Controller.DarazSellerModel.GetRequest;


import com.gluonapplication.Controller.DarazSellerModel.GsonBodyModel.OrderModel.Order;
import com.gluonapplication.Controller.DarazSellerModel.GsonBodyModel.ResponseModel.Head;
import com.gluonapplication.Controller.Enum.Format;
import com.gluonapplication.Controller.TableModelData.OrdersTableData;
import com.google.gson.JsonElement;

import java.util.ArrayList;
import java.util.List;


public class GetOrders extends ApiGetRequestModel {
    private GetOrders(Format format, String timeStamp, String userID, String apiKey) {
        super("GetOrders", format, timeStamp, userID, apiKey);
    }
    public GetOrders(String userID, String apiKey){
        this(Format.JSON,getCurrentTimestamp(),userID,apiKey);
    }
    @Override
    public void run() {
        super.run();
    }
    @Override
    public void constructData(){
        System.out.println("\nGetOrderClass");
        setDataForTable(new ArrayList<>());
        List<Order> ordersList = new ArrayList<>();
        if (getSuccessResponse() == null) {return;}
        Head head =  getGson().fromJson(getSuccessResponse().get("Head").getAsJsonObject(), Head.class);
        setHead(head);
        System.out.println(head);
        JsonElement arrayOfBrands = getSuccessResponse().get("Body").getAsJsonObject().get("Orders");
        arrayOfBrands.getAsJsonArray().asList().forEach(order->ordersList.add(getGson().fromJson(order,Order.class)));
        for (Order orders:ordersList){
            getDataForTable().add(new OrdersTableData(orders));
        }
    }

}
