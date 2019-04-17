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
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Tab3 extends Fragment {
    RecyclerView tab3_recycler;
    private Retrofit retrofit;
    private SaladApiAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab3, container, false);
        tab3_recycler = view.findViewById(R.id.tab3_recycler);
        tab3_recycler.setLayoutManager(new LinearLayoutManager(getContext()));
       dataSalad();
        return view;
    }

    public void dataSalad(){
        retrofit = new Retrofit.Builder()
                .baseUrl(SecondApiInterface.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        SaladApiInterface saladApiInterface =  retrofit.create(SaladApiInterface.class);
        Call<List<Salad>> call = saladApiInterface.getDataSalad();
        call.enqueue(new Callback<List<Salad>>() {
            @Override
            public void onResponse(Call<List<Salad>> call, Response<List<Salad>> response) {
                getDataSalad(response.body());
            }

            @Override
            public void onFailure(Call<List<Salad>> call, Throwable t) {
                Toast.makeText(getContext(), "Error is"+t, Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void getDataSalad(List<Salad> saladDataList) {
        adapter= new SaladApiAdapter(saladDataList,getContext());
        tab3_recycler.setAdapter(adapter);
    }



}
