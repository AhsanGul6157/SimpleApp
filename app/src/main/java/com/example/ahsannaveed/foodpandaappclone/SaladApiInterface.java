package com.example.ahsannaveed.foodpandaappclone;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SaladApiInterface {
    String BaseURL = "https://foodpandaappclone.firebaseio.com/";
    @GET("Data/list01/0/Salad/.json")
    Call<List<Salad>> getDataSalad();

}
