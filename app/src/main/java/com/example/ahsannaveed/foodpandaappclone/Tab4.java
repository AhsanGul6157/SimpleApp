package com.example.ahsannaveed.foodpandaappclone;

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


public class Tab4 extends Fragment {
    private Retrofit retrofit;
    HandiSpecialitiesAdapter adapter;
    private RecyclerView tab4_recycler;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab4, container, false);
        tab4_recycler = view.findViewById(R.id.tab4_recycler);
        tab4_recycler.setLayoutManager(new LinearLayoutManager(getContext()));
    getDataHandiSpecialaties();

                return view;
    }
public void getDataHandiSpecialaties(){
    retrofit = new Retrofit.Builder()
            .baseUrl(HandiSpecialityApiInterface.BaseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    HandiSpecialityApiInterface handiSpecialityApiInterface =  retrofit.create(HandiSpecialityApiInterface.class);
    Call<List<HandiSpeciality>> call = handiSpecialityApiInterface.getDataHandiSpecialaties();
    call.enqueue(new Callback<List<HandiSpeciality>>() {
        @Override
        public void onResponse(Call<List<HandiSpeciality>> call, Response<List<HandiSpeciality>> response) {
            getDataHandiSpecialaties(response.body());
        }

        @Override
        public void onFailure(Call<List<HandiSpeciality>> call, Throwable t) {
            Toast.makeText(getContext() ,""+t, Toast.LENGTH_SHORT).show();
        }
    });
}
private void getDataHandiSpecialaties(List<HandiSpeciality> handiSpecialitiesDataList){
    adapter= new HandiSpecialitiesAdapter(handiSpecialitiesDataList,getContext());
    tab4_recycler.setAdapter(adapter);

}

}
