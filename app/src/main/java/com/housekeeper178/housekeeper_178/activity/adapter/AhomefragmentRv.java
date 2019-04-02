package com.housekeeper178.housekeeper_178.activity.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.housekeeper178.housekeeper_178.R;


import com.housekeeper178.housekeeper_178.activity.activity.GoodsiinfofromhomeActivity;
import com.housekeeper178.housekeeper_178.activity.activity.LoginActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AhomefragmentRv extends RecyclerView.Adapter<AhomefragmentRv.ViewHolder> {
    private Context context;
    private List<String> imgurl;
    private List<String> name;
    private List<String> price;

    public AhomefragmentRv(List<String> imgurl, List<String> name, List<String> price, Context context) {
        this.imgurl = imgurl;
        this.name = name;
        this.price = price;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.item_hot_grid_view, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        Picasso.get().load("http://47.105.161.233:8080" + imgurl.get(position)).fit().into(holder.imageView);
        holder.tvprice.setText(price.get(position));
        holder.tv1.setText(name.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                     Intent intent = new Intent(context,GoodsiinfofromhomeActivity.class);
                     String doname =name.get(position);
                     intent.putExtra("name",doname);
                     context.startActivity(intent);

            }
        });


    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tv1;
        TextView tvprice;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_hot);
            tv1 = itemView.findViewById(R.id.tv_name);
            tvprice = itemView.findViewById(R.id.tv_price);
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }


}
