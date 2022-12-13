package com.gluonapplication.Model.DarazSellerModel.GsonBodyModel.ResponseModel;


public class Head {

    public String getRequestId() {
        return RequestId;
    }

    public void setRequestId(String requestId) {
        RequestId = (requestId);
    }
    public Head(){

    }

    public String getRequestAction() {
        return RequestAction;
    }

    public void setRequestAction(String requestAction) {
        RequestAction = requestAction;
    }

    public String getResponseType() {
        return ResponseType;
    }

    public void setResponseType(String responseType) {
        ResponseType = responseType;
    }

    public String getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(String timestamp) {
        Timestamp = timestamp;
    }

    public int getTotalCount() {
        return TotalCount;
    }

    private String RequestId;
    private String RequestAction;
    private String ResponseType;
    private String Timestamp;
    private Integer TotalCount;

    private String ErrorType;

    public void setTotalCount(Integer totalCount) {
        TotalCount = totalCount;
    }

    public String getErrorType() {
        return ErrorType;
    }

    public void setErrorType(String errorType) {
        ErrorType = errorType;
    }

    public String getErrorCode() {
        return ErrorCode;
    }

    public void setErrorCode(String errorCode) {
        ErrorCode = errorCode;
    }

    public String getErrorMessage() {
        return ErrorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        ErrorMessage = errorMessage;
    }

    private String ErrorCode;
    private String ErrorMessage;

    @Override
    public String toString() {
        if (TotalCount != null) {
            return String.format("\nRequest ID : %s \nRequest Action: %s \nResponse Type : %s \nTimeStamp : %s \nTotalCount : %d", getRequestId(), getRequestAction(), getResponseType(), getTimestamp(), getTotalCount());
        } else
            return String.format("\nRequest ID : %s \nRequest Action: %s \nResponse Type : %s \nTimeStamp : %s", getRequestId(), getRequestAction(), getResponseType(), getTimestamp());
    }

    }


