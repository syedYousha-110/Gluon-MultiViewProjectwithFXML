package com.gluonapplication.Model.DarazSellerModel.GsonBodyModel.ResponseModel;

public class GsonResponse {

    private Object SuccessResponse;
    private com.gluonapplication.Model.DarazSellerModel.GsonBodyModel.ResponseModel.Head Head;
    private Object Body;

    public Object getSuccessResponse() {
        return this.SuccessResponse;
    }
    public Object getHead(){
        return this.Head;
    }
    public Object getBody(){
        return this.Body;
    }
    public void setBody(Object body) {
        this.Body = body;
    }
    public void setSuccessResponse(Object successResponse) {
        SuccessResponse = successResponse;
    }
    public void SetHead(Head Head){
        this.Head = Head;
    }
}
