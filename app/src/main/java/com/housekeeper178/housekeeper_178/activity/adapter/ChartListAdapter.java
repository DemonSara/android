package com.housekeeper178.housekeeper_178.activity.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.base.model.Base;
import com.housekeeper178.housekeeper_178.R;
import com.housekeeper178.housekeeper_178.activity.activity.EnSureDeletActivity;
import com.housekeeper178.housekeeper_178.activity.activity.GoodsiinfofromhomeActivity;


import java.util.List;

import butterknife.BindView;

public class ChartListAdapter extends RecyclerView.Adapter<ChartListAdapter.ViewHolder> {
    Context context;
    private List<String> goodsname;
    private List<String> price;
    private List<Integer> did;
   private List<String> amount;


    public ChartListAdapter(Context context, List<String> goodsname, List<String> price, List<Integer> did,List<String> amount) {
        this.context = context;
        this.goodsname = goodsname;
        this.price = price;
        this.did = did;
      this.amount = amount;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.item_check_bill, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.amountt.setText(amount.get(position));
        holder.goodname.setText(goodsname.get(position));
        holder.total.setText(price.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EnSureDeletActivity.class);
                int i = did.get(position);
                intent.putExtra("id", i);
                context.startActivity(intent);

            }
        });
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView goodname;
        TextView total;
        TextView amountt;

        public ViewHolder(View itemView) {
            super(itemView);
            amountt = itemView.findViewById(R.id.tv_good_amount);
            goodname = itemView.findViewById(R.id.tv_shopname_myorderfragment);
            total = itemView.findViewById(R.id.tv_price_myorderfragment);
        }
    }

    @Override
    public int getItemCount() {
        return goodsname.size();
    }
}
