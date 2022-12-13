package com.gluonapplication.Model.DarazSellerModel.GetRequest;//package com.analytics.desktop.Controller.DarazSellerModel.GetRequest;
//
//import com.lazada.lazop.api.LazopClient;
//import com.lazada.lazop.api.LazopRequest;
//import com.lazada.lazop.api.LazopResponse;
//import com.lazada.lazop.util.ApiException;
//import com.lazada.lazop.util.UrlConstants;
//
//public class LazopTesting extends LazopClient{
//    public LazopTesting(String serverUrl, String appKey, String appSecret) {
//        super(serverUrl, appKey, appSecret);
//
//    }
//
//    public LazopTesting(String serverUrl, String appKey, String appSecret, int connectTimeout, int readTimeout) {
//        super(serverUrl, appKey, appSecret, connectTimeout, readTimeout);
//
//    }
//
//    public static void main(String[] args) {
//        LazopTesting client = new LazopTesting(UrlConstants.API_AUTHORIZATION_URL,"113668","Q1qdNxCEnnoNwbTjQbWzkxDQeqXqXNYL");
//        LazopRequest request = new LazopRequest();
//        request.setApiName("/category/tree/get");
//        request.setHttpMethod("GET");
//        request.addApiParameter("language_code", "en_US");
//        System.out.println(request.getTimestamp());
//        try {
//            Thread.sleep(10);
//            LazopResponse response = client.execute(request);
//            System.out.println(response.getBody());
//        } catch (ApiException | InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//
//}
