package com.example.ahsannaveed.foodpandaappclone;

import android.content.Context;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class HorizontalRecycler extends RecyclerView.Adapter<HorizontalRecycler.ViewHolder> {

    private List<Model> dataList;
//   private TextView hading_Title_Text;

    private Context context;


    public HorizontalRecycler(List<Model> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        //Creating  view using inflater class
        View view = inflater.inflate(R.layout.item_horizontal, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
//        viewHolder.heading_Title_Text.setText(dataList.get(i).getHeadingTitle());
        viewHolder.titleTextView.setText(dataList.get(i).getTitle());
        viewHolder.subtitleTextView.setText(dataList.get(i).getSubtitle());
        viewHolder.priceTextView.setText(dataList.get(i).getPrice());
        viewHolder.deliveryTextView.setText(dataList.get(i).getDelivery());
        Model dataModel = dataList.get(i);
        Glide.with(context).load(dataModel.getIamge()).into(viewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        //        TextView heading_Title_Text;
        TextView titleTextView;
        TextView subtitleTextView;
        TextView priceTextView;
        TextView deliveryTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            heading_Title_Text = itemView.findViewById(R.id.heading_title);
            imageView = itemView.findViewById(R.id.iamgeview_list0);
            titleTextView = itemView.findViewById(R.id.textview_title);
            subtitleTextView = itemView.findViewById(R.id.textView_subtitle);
            priceTextView = itemView.findViewById(R.id.textView_price);
            deliveryTextView = itemView.findViewById(R.id.textView_delivery);


        }
    }


}
