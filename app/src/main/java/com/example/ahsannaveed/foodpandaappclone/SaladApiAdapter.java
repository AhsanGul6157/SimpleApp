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

public class SaladApiAdapter  extends RecyclerView.Adapter<SaladApiAdapter.SaladViewHolder> {
    private List<Salad> SaladDataList;
    private Context context;

    public SaladApiAdapter(List<Salad> saladDataList, Context context) {
        SaladDataList = saladDataList;
        this.context = context;
    }



    @NonNull
    @Override
    public SaladViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.salad_items_list,viewGroup,false);

        return new SaladViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SaladViewHolder saladViewHolder, int i) {
        saladViewHolder.saladTitleText.setText(SaladDataList.get(i).getTitle());
        Glide.with(context).load(SaladDataList.get(i).getIamge()).into(saladViewHolder.saladImage);
        saladViewHolder.saladPrice.setText(SaladDataList.get(i).getPrice());

    }

    @Override
    public int getItemCount() {
        return SaladDataList.size();
    }

    public class SaladViewHolder extends RecyclerView.ViewHolder{
        TextView saladTitleText;
        ImageView saladImage;
        TextView saladPrice;

        public SaladViewHolder(@NonNull View itemView) {
            super(itemView);
            saladTitleText = itemView.findViewById(R.id.salad_title_text);
            saladImage = itemView.findViewById(R.id.salad_image);
            saladPrice = itemView.findViewById(R.id.salad_price_text);
        }
    }
}
