package com.gluonapplication.Model.DarazSellerModel.GetRequest;

import com.gluonapplication.Model.DarazSellerModel.GsonBodyModel.TreeCategoryModel.Children;
import com.gluonapplication.Model.DarazSellerModel.GsonBodyModel.ResponseModel.Head;
import com.gluonapplication.Model.Enum.Constants;
import com.gluonapplication.Model.Enum.Format;
import com.google.gson.JsonElement;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetCategoryTree extends ApiGetRequestModel {
    Map<String, String> param = new HashMap<>();
    List<Long> categoryId = new ArrayList<>();
    private int i = 0;
    public GetCategoryTree(Format format, String timeStamp, String userID, String apiKey) {
         super("GetCategoryTree", format, timeStamp, userID,apiKey);
    }
    public GetCategoryTree(String userID,String apiKey){
        super("GetTransactionDetails",Format.JSON,getCurrentTimestamp(),userID,apiKey);
        System.out.println(getCommonParameters());
        System.out.println(getSuccessResponse());
        setDataForTable(new ArrayList<>());
    }


    @Override
    public void run(){
        super.run();

    }

    @Override
    public void constructData() {
        System.out.println("\nGetCategoryTree Class");
        Head head;
        if (getSuccessResponse() == null) {return;}
        head = getGson().fromJson(getSuccessResponse().get("Head").getAsJsonObject(), Head.class);
        setHead(head);

        System.out.println(head);

        JsonElement arrayOfAttributes = getSuccessResponse().get("Body").getAsJsonArray();
        System.out.println(arrayOfAttributes);
        List<Children> attributes = new ArrayList<>();
        arrayOfAttributes.getAsJsonArray().asList().forEach(attribute->attributes.add(getGson().fromJson(attribute, Children.class)));
        int k = 1;

        for (Children children:attributes){
            System.out.println(children.getName());
                children(children,k++);
            System.out.println();
        }

        System.out.println(categoryId.size());
        System.out.println(i);
    }
    private void children(Children children , int j){
        this.i +=j;
            categoryId.add(children.getCategoryId());
            for (Children children1 : children.getChildren()){
                if (!children1.isLeaf()){
                    System.out.println(children1.getName());
                }
                children(children1,i);
            }


    }

    public static void main(String[] args) throws InterruptedException {
        var b = new GetCategoryTree("syanstore723@gmail.com", Constants.API_KEY.getKey());
        b.start();
        b.join();
    }
}
