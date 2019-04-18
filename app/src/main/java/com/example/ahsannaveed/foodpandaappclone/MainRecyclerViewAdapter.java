package com.example.ahsannaveed.foodpandaappclone;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewAdapter.MainViewHolder> {
    private List<MainModel> dataListMain;
//   private TextView hading_Title_Text;

    private Context context;

    public MainRecyclerViewAdapter(List<MainModel> dataListMain, Context context) {
        this.dataListMain = dataListMain;
        this.context = context;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.main_recycler_view_layout, viewGroup, false);

        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder mainViewHolder, int i) {
        mainViewHolder.titleTextViewMain.setText(dataListMain.get(i).getTitle());
        mainViewHolder.subtitleTextViewMain.setText(dataListMain.get(i).getSubtitle());
        mainViewHolder.priceTextViewMain.setText(dataListMain.get(i).getPrice());
        mainViewHolder.deliveryTextViewMain.setText(dataListMain.get(i).getDelivery());
        MainModel mainModel = dataListMain.get(i);
        Glide.with(context).load(mainModel.getIamge()).into(mainViewHolder.imageViewMain);
    }

    @Override
    public int getItemCount() {
        return dataListMain.size();
    }

    //1-creating view holder for the adapter class
    public class MainViewHolder extends RecyclerView.ViewHolder {

        ImageView imageViewMain;
        //        TextView heading_Title_Text;
        TextView titleTextViewMain;
        TextView subtitleTextViewMain;
        TextView priceTextViewMain;
        TextView deliveryTextViewMain;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewMain = itemView.findViewById(R.id.iamgeview_main_list);
            titleTextViewMain = itemView.findViewById(R.id.textview_title_main);
            subtitleTextViewMain = itemView.findViewById(R.id.textView_subtitle_main);
            priceTextViewMain = itemView.findViewById(R.id.textView_price_main);
            deliveryTextViewMain = itemView.findViewById(R.id.textView_delivery_main);
        }
    }
}
