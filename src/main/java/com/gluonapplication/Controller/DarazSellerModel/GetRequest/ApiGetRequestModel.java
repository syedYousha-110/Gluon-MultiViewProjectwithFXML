package com.gluonapplication.Controller.DarazSellerModel.GetRequest;

import com.gluonapplication.Controller.DarazSellerModel.GsonBodyModel.ResponseModel.Head;
import com.gluonapplication.Controller.DarazSellerModel.GsonBodyModel.ICustomData;
import com.gluonapplication.Controller.Enum.Format;
import com.gluonapplication.Controller.TableModelData.CustomTableProperty;
import com.google.gson.*;


import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import java.net.URI;
import java.net.URLEncoder;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;

public abstract class ApiGetRequestModel extends Thread implements ICustomData {


    public String getOffSet() {
        return offSet;
    }

    public void AddParameterOffSet(String offSet) {
        this.offSet = offSet;
    }

    protected String offSet;
    private JsonObject successResponse;
    private Gson gson;

    private Head head;

    public List<CustomTableProperty> getDataForTable() {
        return dataForTable;
    }

    private List<CustomTableProperty> dataForTable;

    public void setDataForTable(List<CustomTableProperty> dataForTable) {
        this.dataForTable = dataForTable;
    }
    public void setHead(Head head) {
        this.head = head;
    }

    public Head getHead() {
        return head;
    }
    public ApiGetRequestModel(String action, Format format, String timeStamp, String userID, String apiKey) {
        setApiKey(apiKey);
        setAction(action);
        setFormat(format);
        setTimeStamp(timeStamp);
        setUserID(userID);
        setCommonParameters(new HashMap<>());
        setDaemon(true);
    }

    public void setCommonParameters(Map<String, String> commonParameters) {
        this.commonParameters = commonParameters;
        this.commonParameters.put("UserID",getUserID());
        this.commonParameters.put("Timestamp",getTimeStamp());
        this.commonParameters.put("Version",version);
        this.commonParameters.put("Action",getAction());
        this.commonParameters.put("Format", getFormat());
    }

    public void addParameter(String Field, String Type){
        getCommonParameters().put(Field,Type);
    }
    public String getScApiHost() {
        return ScApiHost;
    }

    public String getCHAR_UTF_8() {

        return "UTF-8";
    }


    public Map<String, String> getCommonParameters() {
        return commonParameters;
    }

    public String getApiKey() {
        return ApiKey;
    }

    private void setApiKey(String apiKey) {
        this.ApiKey = apiKey;
    }

    public String getAction() {
        return Action;
    }

    public void setAction(String action) {
        Action = action;
    }

    public String getFormat() {
        return format.getFormat();
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getVersion() {
        return version;
    }



    public String GenerateApiRequest(Map<String, String> params, String apiKey, String XML) {

        Map<String, String> sortedParams = new TreeMap<>(params);

        queryString = toQueryString(sortedParams);
        final String signature = HmacDigest(queryString, apiKey);
        queryString = queryString.concat("&Signature=".concat(signature));

        output = ScApiHost.concat("?".concat(queryString));
        setQueryString(output);
        return output;
    }
    public String toQueryString(Map<String, String> data) {
        StringBuilder params = new StringBuilder();
        for (Map.Entry<String, String> pair : data.entrySet()) {
            params.append(URLEncoder.encode((String) pair.getKey(),
                    StandardCharsets.UTF_8)).append("=");
            params.append(URLEncoder.encode((String) pair.getValue(),
                    StandardCharsets.UTF_8)).append("&");
        }
        if (params.length() > 0) {
            params.deleteCharAt(params.length() - 1);
        }
        return params.toString();
    }
    public String HmacDigest(String msg, String keyString) {
        String digest = null;
        try {
            SecretKeySpec key = new SecretKeySpec((keyString).getBytes(StandardCharsets.UTF_8),HASH_ALGORITHM);
            Mac mac = Mac.getInstance(HASH_ALGORITHM);
            mac.init(key);
            final byte[] bytes = mac.doFinal(msg.getBytes(StandardCharsets.US_ASCII));
            StringBuilder hash = new StringBuilder();
            for (byte aByte : bytes) {
                String hex = Integer.toHexString(0xFF & aByte);
                if (hex.length() == 1) {
                    hash.append('0');
                }
                hash.append(hex);
            }
            digest = hash.toString();
        } catch (InvalidKeyException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return digest;
    }

    public JsonObject getSuccessResponse() {
        return successResponse;
    }

    public Gson getGson() {
        return gson;
    }

    public static String getCurrentTimestamp(){
        final TimeZone tz = TimeZone.getTimeZone("UTC");
        final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mmZ");
        df.setTimeZone(tz);
        return df.format(new Date());
    }

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    @Override
    public void run(){
       httpGetRequest(getCommonParameters(), getApiKey(), getXML());
       constructData();
    }
    private void httpGetRequest(Map<String, String> commonParameters, String key, String xml) {
        String request = GenerateApiRequest(commonParameters,key,xml);
        setQueryString(request);
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        setGson(gson);
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest GetRequest = HttpRequest.newBuilder().uri(new URI(request)).GET().build();
            HttpResponse<String> response = client.send(GetRequest, HttpResponse.BodyHandlers.ofString());
            setOutput(response.body());
            JsonElement gsonTree = gson.toJsonTree(response.body());
            JsonObject rootNode = JsonParser.parseString(gsonTree.getAsString()).getAsJsonObject();
            JsonObject details = rootNode.getAsJsonObject();
            JsonElement successResponseNode =  details.get("SuccessResponse").getAsJsonObject();
            JsonObject SuccessResponse = successResponseNode.getAsJsonObject();
            setSuccessResponse(SuccessResponse);
        } catch (Exception e) {
            System.out.println("error"+ e.getMessage());
        }
    }

    private void setGson(Gson gson) {
        this.gson = gson;
    }

    private void setSuccessResponse(JsonObject successResponse) {
        this.successResponse = successResponse;
    }

    public void constructData(){
        System.out.println("Parent class");
    }

    private String output;
    private String queryString = "";
    private final String ScApiHost = "https://api.sellercenter.daraz.pk/";
    private Map<String,String> commonParameters;
    private String Action;
    private Format format;
    private String timeStamp;
    private String UserID;
    private final String version = "1.0";
    private String ApiKey;
    private static final String HASH_ALGORITHM = "HmacSHA256";


    private final String apiKey = null;

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getXML() {
        return XML;
    }

    public void setXML(String XML) {
        this.XML = XML;
    }

    private String XML;


}





