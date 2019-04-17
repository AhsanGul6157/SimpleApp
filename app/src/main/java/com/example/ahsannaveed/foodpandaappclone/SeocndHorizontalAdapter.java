package com.example.ahsannaveed.foodpandaappclone;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class SeocndHorizontalAdapter extends RecyclerView.Adapter<SeocndHorizontalAdapter.SecondViewHolder> {
    private List<SecondModel> dataList1;
//   private TextView hading_Title_Text;

    private Context context;

    public SeocndHorizontalAdapter(List<SecondModel> dataList1, Context context) {
        this.dataList1 = dataList1;
        this.context = context;
    }

    @NonNull
    @Override
    public SecondViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
       View view = inflater.inflate(R.layout.second_item_horizontal,viewGroup,false);
        return new SecondViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SecondViewHolder secondViewHolder, int i) {
        secondViewHolder.titleTextView1.setText(dataList1.get(i).getTitle());
        secondViewHolder.subtitleTextView1.setText(dataList1.get(i).getSubtitle());
        secondViewHolder.priceTextView1.setText(dataList1.get(i).getPrice());
        secondViewHolder.deliveryTextView1.setText(dataList1.get(i).getDelivery());
        SecondModel secondModelModel = dataList1.get(i);
        Glide.with(context).load(secondModelModel.getIamge()).into(secondViewHolder.imageView1);
    }

    @Override
    public int getItemCount() {
        return dataList1.size();
    }

    public class SecondViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView1;
        //        TextView heading_Title_Text;
        TextView titleTextView1;
        TextView  subtitleTextView1;
        TextView  priceTextView1;
        TextView  deliveryTextView1;

        public SecondViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView1 = itemView.findViewById(R.id.iamgeview_list1);
            titleTextView1 = itemView.findViewById(R.id.textview_title_1);
            subtitleTextView1 = itemView.findViewById(R.id.textView_subtitle_1);
            priceTextView1 = itemView.findViewById(R.id.textView_price_1);
            deliveryTextView1 = itemView.findViewById(R.id.textView_delivery_1);
        }
    }
}



