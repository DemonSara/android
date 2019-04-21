package com.housekeeper178.housekeeper_178.activity.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.housekeeper178.housekeeper_178.R;

import java.util.List;

public class AllOrderAdapter extends RecyclerView.Adapter<AllOrderAdapter.ViewHolder> {
    Context context;
    private List<String> goodsname;
    private List<String> price;
    private List<String> amount;

    public AllOrderAdapter(Context context, List<String> goodsname, List<String> price, List<String> amount) {
        this.context = context;
        this.goodsname = goodsname;
        this.price = price;
        this.amount = amount;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.item_all_order, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView goodname;
        TextView total;
        TextView a;

        public ViewHolder(View itemView) {
            super(itemView);
            goodname = itemView.findViewById(R.id.tv_shopname_itemorder);
            total = itemView.findViewById(R.id.tv_price_itemallorder);
            a = itemView.findViewById(R.id.orderitemamount);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.goodname.setText(goodsname.get(position));
        holder.total.setText(price.get(position));
        holder.a.setText(amount.get(position));
    }

    @Override
    public int getItemCount() {
        return goodsname.size();
    }
}
