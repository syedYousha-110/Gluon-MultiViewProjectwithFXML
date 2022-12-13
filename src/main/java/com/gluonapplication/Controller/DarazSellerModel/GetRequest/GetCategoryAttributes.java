package com.gluonapplication.Controller.DarazSellerModel.GetRequest;

import com.gluonapplication.Controller.DarazSellerModel.GsonBodyModel.AttributeModel.Attributes;
import com.gluonapplication.Controller.DarazSellerModel.GsonBodyModel.ResponseModel.Head;
import com.gluonapplication.Controller.Enum.Format;
import com.gluonapplication.Controller.TableModelData.AttributesTableData;
import com.google.gson.JsonElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetCategoryAttributes extends ApiGetRequestModel {

    Map<String, String> param = new HashMap<>();
    public GetCategoryAttributes(Format format, String timeStamp, String userID, String apiKey) {
        super("GetCategoryAttributes", format, timeStamp, userID, apiKey);
        param.put("primaryCategory","5695");
        setCommonParameters(param);
        setDataForTable(new ArrayList<>());
    }
    public GetCategoryAttributes(String UserID,String apiKey){
        this(Format.JSON,getCurrentTimestamp(),UserID,apiKey);
        param.put("primaryCategory","5695");
        setCommonParameters(param);
        setDataForTable(new ArrayList<>());
    }


    @Override
    public void run() {
        super.run();
    }
    @Override
    public void constructData() {
        System.out.println("\nGetCategoryAttributes Class");
        Head head;
        if (getSuccessResponse() == null) {return;}
            head = getGson().fromJson(getSuccessResponse().get("Head").getAsJsonObject(), Head.class);
            System.out.println(getSuccessResponse().get("Head"));
            System.out.println(head);
            setHead(head);

            JsonElement arrayOfAttributes = getSuccessResponse().get("Body").getAsJsonArray();
            System.out.println(arrayOfAttributes);
            List<Attributes> attributes = new ArrayList<>();

            arrayOfAttributes.getAsJsonArray().asList().forEach(attribute -> attributes.add(getGson().fromJson(attribute, Attributes.class)));
            for (Attributes attribute : attributes) {
                this.getDataForTable().add(new AttributesTableData(attribute));
            }

    }
    public static void main(String[] args) {

    }

}
