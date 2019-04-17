package com.example.ahsannaveed.foodpandaappclone;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Ex_Dis_DealApiInterface {

    String BASEURL = "https://foodpandaappclone.firebaseio.com/";
    @GET("Data/list01/0/Exclusive%20Discounted%20Deals/.json")
        //3...defining method through which we will call the data

   Call<List<ExclusiveDiscountedDeal>> getDataDeal();
}
