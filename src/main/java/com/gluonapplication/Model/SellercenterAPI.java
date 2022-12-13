package com.gluonapplication.Model;

import com.gluonapplication.Model.Enum.Constants;
import com.google.gson.*;

import java.net.URI;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
public class SellercenterAPI {
    private static final String ScApiHost = "https://api.sellercenter.daraz.pk/";
    private static final String HASH_ALGORITHM = "HmacSHA256";
    private static final String CHAR_UTF_8 = "UTF-8";
    //private static final String CHAR_ASCII = "ASCII";

    private final String apiKey = null;

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    Map<String, String> params = new HashMap<String, String>();

    public SellercenterAPI(){

//        //params.put("UserID", userID);
//        params.put("UserID", "syanstore723@gmail.com");
//        params.put("Timestamp", getCurrentTimestamp());
//        params.put("Version", "1.0");
//        params.put("Action", "GetProducts");
//        //params.put("Limit","100");
//        //params.put("Offset","0");
//        params.put("Format","json");
//        //apiKey = "AYQF7dunWQaMNbITI6JJbdtsxhTAOWEqRbrQ-ZfO9_9tq1GQbFZ67gzS";

        final String XML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><Request><Product><SellerSku>4105382173aaee4</SellerSku><Price>12</Price></Product></Request>";
//        final String out = getSellercenterApiResponse(params, Constants.API_KEY.getKey(), ""); // provide XML as an empty string when not needed
//        System.out.println(out); // print out the XML response

    }
    public void execute(){
        final String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                "<Request>\n" +
                " <RequestId>130568938568458</RequestId>\n" +
                "</Request>";
         final String out = getSellercenterApiResponse(params, Constants.API_KEY.getKey(), ""); // provide XML as an empty string when not needed
        System.out.println(out);
    }
    public static void main(String[] args) throws InterruptedException {

       //var b = new ApiModel("GetProducts",Format.JSON,getCurrentTimestamp(),"syanstore723@gmail.com");

       //a.setParams(b.getCommonParameters());
       //a.execute();

//        params.put("UserID", "syanstore723@gmail.com");
//        params.put("Timestamp", getCurrentTimestamp());
//        params.put("Version", "1.0");
//        params.put("Action", "GetBrands");
//        params.put("Limit","100");
//        params.put("Offset","0");
//        params.put("Format","json");
//        final String apiKey = "AYQF7dunWQaMNbITI6JJbdtsxhTAOWEqRbrQ-ZfO9_9tq1GQbFZ67gzS";
//        final String XML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><Request><Product><SellerSku>4105382173aaee4</SellerSku><Price>12</Price></Product></Request>";
//        final String out = getSellercenterApiResponse(params, apiKey, ""); // provide XML as an empty string when not needed
//        System.out.println(out); // print out the XML response
    }
    /**
     * calculates the signature and sends the request
     *
     * @param params Map - request parameters
     * @param apiKey String - user's API Key
     * @param XML String - Request Body
     */
    public String getSellercenterApiResponse(Map<String, String> params, String apiKey, String XML) {
        String queryString = "";
        StringBuilder Output = new StringBuilder();
        HttpURLConnection connection = null;
        URL url = null;
        Map<String, String> sortedParams = new TreeMap<>(params);
        queryString = toQueryString(sortedParams);
        final String signature = hmacDigest(queryString, apiKey);
        System.out.println(signature);
        queryString = queryString.concat("&Signature=".concat(signature));

        final String request = ScApiHost.concat("?".concat(queryString));
        System.out.println(request);
        try {
            url = new URL(request);
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setInstanceFollowRedirects(false);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("charset", CHAR_UTF_8);
            connection.setUseCaches(false);
            System.out.println(connection.getResponseMessage());
            HttpRequest httpRequest = HttpRequest.newBuilder().uri(new URI(request)).header("Content-Type", "application/x-www-form-urlencoded").POST(HttpRequest.BodyPublishers.ofString(XML)).build();

            //System.out.println(response.body());
            GsonBuilder builder = new GsonBuilder();
            builder.setPrettyPrinting();
            Gson gson = builder.create();

            JsonParser parser = new JsonParser();



            //JsonElement rootNode = parser.parse(string);

           // List<Orders> orderss = Collections.singletonList(gson.fromJson(head.get("Body").getAsJsonObject().get("Orders"), Orders.class));
          //  System.out.println(orderss.get(0).getCreatedAt());
            // System.out.println(tree.getAsString());


            //System.out.println(bodyGson.getSuccessResponse());
            //GsonResponse bodys =gson.fromJson(bodyGson.getSuccessResponse().toString(),GsonResponse.class);
           // System.out.println(bodys.getHead());
          //  System.out.println(bodyGson.getBody());
           //System.out.println(bodyGson.getHead());



            //bodyGsonList.forEach(System.out::println);
            // var item = bodyGsonList.get(0);
            //System.out.println(item.getBrandId());
            if (!XML.equals("")) {
                connection. setRequestProperty("Content-Length","" + Integer.toString(XML.getBytes().length));
                DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
                wr.writeBytes(XML);
                wr.flush();
                wr.close();
            }

//            String line = null;
//            BufferedReader reader = new BufferedReader(new
//                    InputStreamReader(connection.getInputStream()));
//            while(reader.readLine() != null) {
//                System.out.println(line);
//                line = reader.readLine();
//                Output.append(reader.lines()).append("\n");
//                System.out.println(line);
//            }
           // System.out.println(gson);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Output.toString();
    }
    /**
     * generates hash key
     *
     * @param msg
     * @param keyString
     * @return string
     */
    private static String hmacDigest(String msg, String keyString) {
        String digest = null;
        try {
            SecretKeySpec key = new SecretKeySpec((keyString).getBytes(StandardCharsets.UTF_8),SellercenterAPI.HASH_ALGORITHM);
            Mac mac = Mac.getInstance(SellercenterAPI.HASH_ALGORITHM);
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

    /**
     * build querystring out of params map
     *
     * @param data map of params
     * @return string
     * @throws UnsupportedEncodingException
     */
    private static String toQueryString(Map<String, String> data) {
        String queryString = "";
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
        queryString = params.toString();
        return queryString;
    }

    /**
     * returns the current timestamp
     * @return current timestamp in ISO 8601 format
     */
    public static String getCurrentTimestamp(){
        final TimeZone tz = TimeZone.getTimeZone("UTC");
        final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mmZ");
        df.setTimeZone(tz);
        return df.format(new Date());
    }
}
