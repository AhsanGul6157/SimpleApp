package com.example.ahsannaveed.foodpandaappclone;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {


    String BASEURL = "https://foodpandaappclone.firebaseio.com/";

    @GET("Data/list01/.json")
        //3...defining method through which we will call the data

    Call<List<Model>> getData();


}
