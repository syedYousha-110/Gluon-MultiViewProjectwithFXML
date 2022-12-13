package com.gluonapplication.Model.DarazSellerModel.GetRequest;

import com.gluonapplication.Model.Enum.Format;

public class GetSingleOrder extends ApiGetRequestModel {

    public GetSingleOrder(String userID, String apiKey) {
        super("Order", Format.JSON, getCurrentTimestamp(), userID, apiKey);

    }


}
