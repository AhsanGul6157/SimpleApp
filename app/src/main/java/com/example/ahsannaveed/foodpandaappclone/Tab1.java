package com.example.ahsannaveed.foodpandaappclone;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Tab1 extends Fragment {
    private Retrofit retrofit;
    private Tab1RecyclerAdapter adapter;
//    TextView title;
    RecyclerView tab_recycler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab1, container, false);

        tab_recycler = view.findViewById(R.id.tab_recycler);
        tab_recycler.setLayoutManager(new LinearLayoutManager(getContext()));

       getEx_dis_DealApiInterface();

        return view;

    }



    //main listApi Interface method, called int the on create method
    public void getEx_dis_DealApiInterface(){

        retrofit = new Retrofit.Builder()
                .baseUrl(Ex_Dis_DealApiInterface.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
       Ex_Dis_DealApiInterface ex_dis_dealApiInterface =  retrofit.create(Ex_Dis_DealApiInterface.class);
        Call<List<ExclusiveDiscountedDeal>> call = ex_dis_dealApiInterface.getDataDeal();
        call.enqueue(new Callback<List<ExclusiveDiscountedDeal>>() {
            @Override
            public void onResponse(Call<List<ExclusiveDiscountedDeal>> call, Response<List<ExclusiveDiscountedDeal>> response) {
                getDataDeal(response.body());
            }

            @Override
            public void onFailure(Call<List<ExclusiveDiscountedDeal>> call, Throwable t) {
                Toast.makeText(getContext(), "Error is"+t, Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void getDataDeal(List<ExclusiveDiscountedDeal> DataDealList) {

        adapter= new Tab1RecyclerAdapter(DataDealList,getContext());
        tab_recycler.setAdapter(adapter);

    }


}
