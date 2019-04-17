package com.example.ahsannaveed.foodpandaappclone;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.List;



public class Tab1RecyclerAdapter extends RecyclerView.Adapter<Tab1RecyclerAdapter.ViewHolder> {

    private List<ExclusiveDiscountedDeal> DataDealList;
    private Context context;

    public Tab1RecyclerAdapter(List<ExclusiveDiscountedDeal> DataDealList, Context context) {
        this.DataDealList = DataDealList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view  = inflater.inflate(R.layout.exclusive_discount_deals_items,viewGroup,false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.titleText.setText(DataDealList.get(i).getTitle());
        viewHolder.subtitleText.setText(DataDealList.get(i).getSubtitle());
        viewHolder.priceText.setText(DataDealList.get(i).getPrice());

    }

    @Override
    public int getItemCount() {
        return DataDealList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleText;
        TextView subtitleText;
        TextView priceText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            titleText = itemView.findViewById(R.id.title);
            subtitleText = itemView.findViewById(R.id.sub_title);
            priceText = itemView.findViewById(R.id.price);
        }
    }
}
