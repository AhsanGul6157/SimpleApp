package com.example.ahsannaveed.foodpandaappclone;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SecondApiInterface {
    String BASEURL = "https://foodpandaappclone.firebaseio.com/";

    @GET("Data/list02/.json")
    Call<List<SecondModel>> getData1();

    //3...defining method through which we will call the data
}
