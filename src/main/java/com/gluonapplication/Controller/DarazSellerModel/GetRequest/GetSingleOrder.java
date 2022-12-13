package com.gluonapplication.Controller.DarazSellerModel.GetRequest;

import com.gluonapplication.Controller.Enum.Format;

public class GetSingleOrder extends ApiGetRequestModel {

    public GetSingleOrder(String userID, String apiKey) {
        super("Order", Format.JSON, getCurrentTimestamp(), userID, apiKey);

    }


}
