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
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class HandiSpecialitiesAdapter extends RecyclerView.Adapter<HandiSpecialitiesAdapter.HandiSpecialitiesViewHolder> {
    private List<HandiSpeciality> HandiSpecialitiesDataList;
    private Context context;

    public HandiSpecialitiesAdapter(List<HandiSpeciality> handiSpecialitiesDataList, Context context) {
        HandiSpecialitiesDataList = handiSpecialitiesDataList;
        this.context = context;
    }

    @NonNull
    @Override
    public HandiSpecialitiesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.handispecialities_list_items, viewGroup, false);

        return new HandiSpecialitiesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HandiSpecialitiesViewHolder handiSpecialitiesViewHolder, int i) {
        handiSpecialitiesViewHolder.titleText.setText(HandiSpecialitiesDataList.get(i).getTitle());
        HandiSpeciality handiSpecialitiesModel = HandiSpecialitiesDataList.get(i);
        Glide.with(context).load(handiSpecialitiesModel.getIamge()).apply(new RequestOptions().circleCrop()).into(handiSpecialitiesViewHolder.imageView);
        handiSpecialitiesViewHolder.priceText.setText(HandiSpecialitiesDataList.get(i).getPrice());


    }

    @Override
    public int getItemCount() {
        return HandiSpecialitiesDataList.size();
    }

    public class HandiSpecialitiesViewHolder extends RecyclerView.ViewHolder {
        TextView titleText;
        ImageView imageView;
        TextView priceText;

        public HandiSpecialitiesViewHolder(@NonNull View itemView) {
            super(itemView);
            titleText = itemView.findViewById(R.id.handi_title_text);
            imageView = itemView.findViewById(R.id.handi_image);
            priceText = itemView.findViewById(R.id.handi_price_text);

        }
    }
}
