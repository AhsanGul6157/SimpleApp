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

public class SoupApiAdapter extends RecyclerView.Adapter<SoupApiAdapter.SoupViewHolder> {
        private List<Soup> SoupList;
        private Context context;

    public SoupApiAdapter(List<Soup> soupList, Context context) {
        SoupList = soupList;
        this.context = context;
    }

    @NonNull
    @Override
    public SoupViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.soup_items_layout,viewGroup,false);
        return new SoupViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SoupViewHolder soupViewHolder, int i) {
        soupViewHolder.titleText.setText(SoupList.get(i).getTitle());
        Soup soupModel = SoupList.get(i);
        Glide.with(context).load(soupModel.getIamge()).into(soupViewHolder.imageView);
        soupViewHolder.priceText.setText(SoupList.get(i).getPrice());



    }

    @Override
    public int getItemCount() {
        return SoupList.size();
    }





    public class SoupViewHolder extends RecyclerView.ViewHolder{
        TextView titleText;
        ImageView imageView;
        TextView priceText;

        public SoupViewHolder(@NonNull View itemView) {
            super(itemView);
            titleText = itemView.findViewById(R.id.title_text);
            imageView = itemView.findViewById(R.id.image);
            priceText = itemView.findViewById(R.id.price_text);
        }
    }
}
