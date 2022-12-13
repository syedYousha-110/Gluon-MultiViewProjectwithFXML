package com.gluonapplication.Model.DarazSellerModel.PostRequest;

import com.gluonapplication.Model.DarazSellerModel.GetRequest.ApiGetRequestModel;
import com.gluonapplication.Model.Enum.Format;

public class ApiPostRequestModel extends ApiGetRequestModel {

    protected String XML;

    @Override
    public String getXML() {
        return XML;
    }

    @Override
    public void setXML(String XML) {
        this.XML = XML;
    }

    public ApiPostRequestModel(String action, Format format, String timeStamp, String userID, String apiKey) {
        super(action, format, timeStamp, userID, apiKey);
    }
    @Override
    public void run(){
        postRequest(XML);
    }
    public void postRequest(String XML){
        GenerateApiRequest(getCommonParameters(),getApiKey(),getXML());

    }
    public void Result(){

    }
}
