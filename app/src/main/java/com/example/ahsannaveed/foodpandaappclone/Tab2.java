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

public class Tab2 extends Fragment {
    Retrofit retrofit;
    RecyclerView tab2_recycler;
    SoupApiAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab2, container, false);
        tab2_recycler = view.findViewById(R.id.tab2_recycler);

//        tab2_recycler = view.findViewById(R.id.tab2_recycler);
        tab2_recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        getDataSoup();
        return view;
    }

    public void getDataSoup() {

        retrofit = new Retrofit.Builder()
                .baseUrl(SoupApiInterface.BaseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        SoupApiInterface soupApiInterface = retrofit.create(SoupApiInterface.class);
        Call<List<Soup>> call = soupApiInterface.getDataSoup();
        call.enqueue(new Callback<List<Soup>>() {
            @Override
            public void onResponse(Call<List<Soup>> call, Response<List<Soup>> response) {
                getDataSoup(response.body());
            }

            @Override
            public void onFailure(Call<List<Soup>> call, Throwable t) {
                Toast.makeText(getContext(), "Error is" + t, Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void getDataSoup(List<Soup> SoupList) {

        adapter = new SoupApiAdapter(SoupList, getContext());
        tab2_recycler.setAdapter(adapter);

    }


}
