package com.gluonapplication.Model.DarazSellerModel.GetRequest;

import com.gluonapplication.Model.DarazSellerModel.GsonBodyModel.BrandModel.Brand;
import com.gluonapplication.Model.DarazSellerModel.GsonBodyModel.ResponseModel.Head;
import com.gluonapplication.Model.DarazSellerModel.GsonBodyModel.ICustomData;
import com.gluonapplication.Model.Enum.Format;
import com.gluonapplication.Model.TableModelData.BrandsTableData;
import com.google.gson.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetBrands extends ApiGetRequestModel implements ICustomData {

    private final Map<String,String> param = new HashMap<>();
    private String limit;

    public GetBrands(String userID, String apiKey) {
        super("GetBrands", Format.JSON, getCurrentTimestamp(), userID, apiKey);
        AddParameterLimit("100");
        param.put("Offset","0");
        setCommonParameters(param);
        setDataForTable(new ArrayList<>());

    }

    @Override
    public void run() {
        super.run();

    }
    @Override
    public void constructData(){
        System.out.println("\nGetBrands Class");
        Head head;
        if (getSuccessResponse()==null){
            return;
        }
        head = getGson().fromJson(getSuccessResponse().get("Head").getAsJsonObject(), Head.class);
        System.out.println(head);
        setHead(head);
        JsonElement arrayOfBrands = getSuccessResponse().get("Body").getAsJsonObject().get("Brands");
        List<Brand> brandList = new ArrayList<>();
        arrayOfBrands.getAsJsonArray().asList().forEach(brands-> brandList.add(getGson().fromJson(brands, Brand.class)));
        for (Brand brand: brandList){
            this.getDataForTable().add(new BrandsTableData(brand.getBrandId(), brand.getName(), brand.getGlobalIdentifier()));
        }
    }


    public String getLimit() {
        return limit;
    }
    public void AddParameterLimit(String limit) {
        if (limit.isEmpty() || limit.isBlank()){
            this.limit = "100";
        }else{
        double value = Double.parseDouble(limit);
        if (value>1000)
        this.limit = String.valueOf(1000);
        else this.limit = limit;}
        param.put("Limit",getLimit());
    }

}
